package awesomespider.lumina.Items;

import awesomespider.lumina.Lumina;
import awesomespider.lumina.Utils.PlayerUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;
import java.util.UUID;

/**
 * Created by Wyatt on 4/21/2015.
 */
public class ItemLuminaOrb extends Item{
    public ItemLuminaOrb(int maxStackSize, String name, String textureName){
        this.setMaxStackSize(maxStackSize);
        this.setUnlocalizedName(name);
        this.setTextureName(textureName);
    }

    @Override
    public boolean onItemUseFirst(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
        ForgeDirection direction = ForgeDirection.getOrientation(side);

        boolean playerIsValid = false;

        NBTTagCompound nbt;

        if (item.stackTagCompound != null){
            nbt = item.stackTagCompound;
        } else {
            //TODO Create exception util, and throw an exception with an error code here
        }

        if (item.stackTagCompound.getString("Owner").equals(player.getUniqueID().toString())){
            playerIsValid = true;
        } else {
            playerIsValid = false;
        }

        if (playerIsValid) {
            if (direction == ForgeDirection.UP) {
                world.setBlock(x, y + 1, z, Lumina.luminaOrb);

                if (player.inventory.getStackInSlot(player.inventory.currentItem).isItemEqual(item)){
                    player.inventory.consumeInventoryItem(player.inventory.getStackInSlot(player.inventory.currentItem).getItem());
                }
            } else if (!playerIsValid) {
                player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[Lumina] That is not your Lumina Orb. You will be punished."));

                player.setHealth(player.getHealth() - 2F);
            }
        }
        return true;
    }

    @Override
    public void onCreated(ItemStack item, World world, EntityPlayer player){
        boolean alreadyOwned = false;

        if (player.inventory.hasItem(this)){
            alreadyOwned = true;
        } else {
            alreadyOwned = false;
        }//TODO Look for Lumina Orb blocks in the world that this player owns as well

        if (!alreadyOwned){
            item.stackTagCompound = new NBTTagCompound();

            NBTTagCompound nbt = item.stackTagCompound;

            nbt.setString("Owner", player.getUniqueID().toString());
        } else {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.RED + "[Lumina] You already own a Lumina Orb. You will be punished."));

            player.setHealth(player.getHealth() - 2F);
        }
    }

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List par3List, boolean par4Boolean){
        par3List.add(EnumChatFormatting.AQUA + "A glowing orb made from pure light");
        par3List.add(EnumChatFormatting.AQUA + "and knowledge. It knows all but is");
        par3List.add(EnumChatFormatting.AQUA + "very unstable, as magic tends to be.");
        par3List.add(EnumChatFormatting.GREEN + "Owner: " + PlayerUtil.getPlayerFromUUID(item.stackTagCompound.getString("Owner"), player.worldObj));
    }
}
