package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import awesomespider.lumina.TileEntities.TileEntitySteamTurbine;
import awesomespider.lumina.Api.Utils.UnitUtil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Awesome_Spider on 5/2/2015.
 */
public class BlockSteamTurbine extends BlockContainer {

    public boolean active = false;

    public BlockSteamTurbine(Material material) {
        super(material);

        this.setBlockName("steamTurbine");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntitySteamTurbine();
    }

    @Override
    public void randomDisplayTick(World world, int posX, int posY, int posZ, Random random){
        TileEntitySteamTurbine te = (TileEntitySteamTurbine) world.getTileEntity(posX, posY, posZ);

        boolean active = te.active;

        if (active){
            if (random.nextInt(5) == 1){
                world.spawnParticle("dripWater", posX + 0.1D, posY + 0.8D, posZ + 0.5D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX + 0.1D, posY + 0.75D, posZ + 0.5D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX + 0.1D, posY + 0.7D, posZ + 0.5D, 0D, 0D, 0D);
            }

            if (random.nextInt(5) == 2){
                world.spawnParticle("dripWater", posX - 0.1D, posY + 0.8D, posZ + 0.5D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX - 0.1D, posY + 0.75D, posZ + 0.5D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX - 0.1D, posY + 0.7D, posZ + 0.5D, 0D, 0D, 0D);
            }

            if (random.nextInt(5) == 3){
                world.spawnParticle("dripWater", posX + 0.5D, posY + 0.8D, posZ + 0.1D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX + 0.5D, posY + 0.75D, posZ + 0.1D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX + 0.5D, posY + 0.7D, posZ + 0.1D, 0D, 0D, 0D);
            }

            if (random.nextInt(5) == 4){
                world.spawnParticle("dripWater", posX + 0.5D, posY + 0.8D, posZ - 0.1D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX + 0.5D, posY + 0.75D, posZ - 0.1D, 0D, 0D, 0D);
                world.spawnParticle("dripWater", posX + 0.5D, posY + 0.7D, posZ - 0.1D, 0D, 0D, 0D);
            }
        }
    }

    @Override
    public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player, int side, float sideX, float sideY, float sideZ){
        TileEntitySteamTurbine te = (TileEntitySteamTurbine) world.getTileEntity(posX, posY, posZ);

        player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Steam Turbine operation parameters:"));
        if (te.active) {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Status: Active"));
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Power Production: 1 " + UnitUtil.powerUnitPerSecond));
        } else {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Status: " + EnumChatFormatting.RED + "Inactive"));
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Power Production: " + EnumChatFormatting.RED + "0 " + UnitUtil.powerUnitPerSecond));
        }

        if (!te.fullOfPower){
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Stored Power: " + te.powerStored));
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Power full: " + te.fullOfPower));
        } else {
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Stored Power: " + EnumChatFormatting.RED + te.powerStored));
            player.addChatMessage(new ChatComponentText(EnumChatFormatting.GREEN + "Power full: " + EnumChatFormatting.RED + te.fullOfPower));
        }

        return true;
    }

    public IIcon bottomIcon;
    public IIcon topIcon;
    public IIcon sideIconInactive;
    public IIcon sideIconActive;

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        bottomIcon = reg.registerIcon(Lumina.MODID + ":machine_steam_io_port");
        topIcon = reg.registerIcon(Lumina.MODID + ":machine_power_io_port");
        sideIconInactive = reg.registerIcon(Lumina.MODID + ":steam_turbine_inactive");
        sideIconActive = reg.registerIcon(Lumina.MODID + ":steam_turbine_active");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0){
            return bottomIcon;
        } else if (side == 1){
            return topIcon;
        } else if (side == 2){
            if (active){
                return sideIconActive;
            } else {
                return sideIconInactive;
            }
        } else if (side == 3){
            if (active){
                return sideIconActive;
            } else {
                return sideIconInactive;
            }
        } else if (side == 4){
            if (active){
                return sideIconActive;
            } else {
                return sideIconInactive;
            }
        } else if (side == 5){
            if (active){
                return sideIconActive;
            } else {
                return sideIconInactive;
            }
        }

        return null;
    }
}
