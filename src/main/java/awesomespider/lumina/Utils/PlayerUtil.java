package awesomespider.lumina.Utils;

import awesomespider.lumina.Events.LuminaPlayerCacheEvent;
import awesomespider.lumina.Lumina;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Wyatt on 4/21/2015.
 */
public class PlayerUtil {
    static File cacheDir = new File(Lumina.dataFolder, "/Player Data/PlayerCache.json");

    public static void createPlayerCache() throws IOException{
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
}
