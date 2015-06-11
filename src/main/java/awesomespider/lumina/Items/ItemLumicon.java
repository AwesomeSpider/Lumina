package awesomespider.lumina.Items;

import awesomespider.lumina.Api.Utils.PlayerUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Awesome_Spider on 6/1/2015.
 */
public class ItemLumicon extends Item {
    public ItemLumicon(int maxStackSize, String name, String textureName){
        this.setMaxStackSize(maxStackSize);
        this.setUnlocalizedName(name);
        this.setTextureName(textureName);
    }

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List par3List, boolean par4) {
        String owner;

        if (item.stackTagCompound != null) {
            owner = item.stackTagCompound.getString("owner");
        } else {
            owner = null;
        }

        if (player.getUniqueID().toString().equals(owner)) {
            par3List.add(EnumChatFormatting.AQUA + "Bound to your soul.");
        } else {
            if (owner != null)
                par3List.add(EnumChatFormatting.AQUA + "Bound to " + PlayerUtil.getPlayerFromUUID(owner, player.worldObj).getDisplayName() + "'s soul.");
        }

        if (owner == null) {
            par3List.add(EnumChatFormatting.RED + "Owner: Not Bound");
            par3List.add(EnumChatFormatting.RED + "Right click to bind.");
        } else {
            par3List.add(EnumChatFormatting.GREEN + "Owner: " + PlayerUtil.getPlayerFromUUID(owner, player.worldObj).getDisplayName());
        }
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
        if (stack.stackTagCompound == null){
            stack.stackTagCompound = new NBTTagCompound();
        }

        String owner = stack.stackTagCompound.getString("owner");

        if (owner == null){
            stack.stackTagCompound.setString("owner", player.getUniqueID().toString());
        }

        return true;
    }
}
