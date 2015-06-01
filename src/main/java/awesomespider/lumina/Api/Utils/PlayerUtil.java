package awesomespider.lumina.Api.Utils;

import awesomespider.lumina.Events.LuminaPlayerCacheEvent;
import awesomespider.lumina.Lumina;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Awesome_Spider on 4/21/2015.
 */
public class PlayerUtil {
    static File playerDataDir = new File(Lumina.dataFolder, "/Player Data");
    static File cacheDir = new File(Lumina.dataFolder, "/Player Data/PlayerCache.json");
    static File playersDir = new File(Lumina.dataFolder, "/Player Data/PlayersStarted.json");
    static List<UUID> playersStartedList = new ArrayList<UUID>();

    public static void createPlayerCache() throws IOException{
        playerDataDir.mkdirs();
        JsonUtil.createJsonFile(cacheDir);
        MinecraftForge.EVENT_BUS.post(new LuminaPlayerCacheEvent(LuminaPlayerCacheEvent.Action.CREATE));
    }

    public static void addPlayerToCache(EntityPlayer player) throws IOException {
        JsonUtil.setJsonValue(cacheDir, player.getUniqueID().toString(), player.getDisplayName());
        MinecraftForge.EVENT_BUS.post(new LuminaPlayerCacheEvent(LuminaPlayerCacheEvent.Action.WRITE, player));
    }

    public static String getPlayerNameFromUUID(String uuid, String MODID) throws IOException {
        MinecraftForge.EVENT_BUS.post(new LuminaPlayerCacheEvent(LuminaPlayerCacheEvent.Action.READ, MODID));
        return JsonUtil.getJsonStringValue(cacheDir, uuid);
    }

    public static EntityPlayer getPlayerFromUUID(String uuid, World world){
        return world.func_152378_a(UUID.fromString(uuid));
    }

    public static void startPlayer(EntityPlayer player) throws IOException {
        if (!isPlayerAlreadyStarted(player)){
            playersStartedList.add(player.getUniqueID());

            savePlayersStarted();

            playPlayerStartAnimation(player);
        }
    }

    public static boolean isPlayerAlreadyStarted(EntityPlayer player){
        return playersStartedList.contains(player.getUniqueID());
    }

    public static void playPlayerStartAnimation(EntityPlayer player){
        //TODO Work on the animation of the player starting the journey
        player.addChatMessage(new ChatComponentText(EnumChatFormatting.AQUA + "The air hums with energy."));

        player.playSound("portal.portal", 10, 10);

        player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX + 4, player.posY, player.posZ));
        player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ + 4));
        player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX - 4, player.posY, player.posZ));
        player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ - 4));

        //Taken from GuiIngame debug screen code (thanks to Ernio for helping me)
        int i4 = MathHelper.floor_double((double) (Minecraft.getMinecraft().thePlayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        String direction = Direction.directions[i4];

        ForgeDirection lookDirection = ForgeDirection.valueOf(direction);

        switch(lookDirection){
            case NORTH:
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ - 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ - 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ - 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ - 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ - 4));

                player.worldObj.createExplosion((Entity)null, player.posX, player.posY, player.posZ - 4, 6, false);
                player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, player.posX, player.posY, player.posZ - 4, new ItemStack(Lumina.lumicon)));
                break;
            case EAST:
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX + 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX + 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX + 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX + 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX + 4, player.posY, player.posZ));

                player.worldObj.createExplosion((Entity)null, player.posX + 4, player.posY, player.posZ, 6, false);
                player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, player.posX + 4, player.posY, player.posZ, new ItemStack(Lumina.lumicon)));
                break;
            case SOUTH:
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ + 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ + 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ + 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ + 4));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX, player.posY, player.posZ + 4));

                player.worldObj.createExplosion((Entity)null, player.posX, player.posY, player.posZ + 4, 6, false);
                player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, player.posX, player.posY, player.posZ + 4, new ItemStack(Lumina.lumicon)));
                break;
            case WEST:
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX - 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX - 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX - 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX - 4, player.posY, player.posZ));
                player.worldObj.addWeatherEffect(new EntityLightningBolt(player.worldObj, player.posX - 4, player.posY, player.posZ));

                player.worldObj.createExplosion((Entity)null, player.posX - 4, player.posY, player.posZ, 6, false);
                player.worldObj.spawnEntityInWorld(new EntityItem(player.worldObj, player.posX - 4, player.posY, player.posZ, new ItemStack(Lumina.lumicon)));
                break;
        }
    }

    public static void savePlayersStarted() throws IOException {
        JsonUtil.createJsonFile(playersDir);
        List<String> uuids = new ArrayList<String>();

        for (UUID uuid : playersStartedList){
            uuids.add(uuid.toString());
        }

        JsonUtil.setJsonValue(playersDir, "playersStarted", uuids);
    }

    public static void loadPlayersStarted() throws IOException {
        ArrayList<String> uuids = JsonUtil.getJsonStringListValue(playersDir, "playersStarted");

        for (String uuid : uuids){
            playersStartedList.add(UUID.fromString(uuid));
        }
    }
}
