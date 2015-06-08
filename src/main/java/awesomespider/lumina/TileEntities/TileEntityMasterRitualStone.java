package awesomespider.lumina.TileEntities;

import awesomespider.lumina.Api.Ritual;
import awesomespider.lumina.Api.RitualRegistry;
import awesomespider.lumina.Blocks.BlockRitualItemHolder;
import awesomespider.lumina.Blocks.BlockRitualSpellEnergyStorage;
import awesomespider.lumina.Blocks.BlockRitualStone;
import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.BlockGlowstone;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awesome_Spider on 5/24/2015.
 */
public class TileEntityMasterRitualStone extends TileEntity {
    private boolean formed = false;
    private int tier = 0;

    @Override
    public void updateEntity() {
        checkMultiblock();
        updateTextures();
    }

    public void checkMultiblock(){
        //Edges Tier 1
        Block b1 = worldObj.getBlock(xCoord - 1, yCoord, zCoord);
        Block b2 = worldObj.getBlock(xCoord + 1, yCoord, zCoord);
        Block b3 = worldObj.getBlock(xCoord, yCoord, zCoord - 1);
        Block b4 = worldObj.getBlock(xCoord, yCoord, zCoord + 1);

        //Corners Tier 1
        Block b5 = worldObj.getBlock(xCoord - 1, yCoord, zCoord - 1);
        Block b6 = worldObj.getBlock(xCoord + 1, yCoord, zCoord - 1);
        Block b7 = worldObj.getBlock(xCoord + 1, yCoord, zCoord + 1);
        Block b8 = worldObj.getBlock(xCoord - 1, yCoord, zCoord + 1);

        //Edges Tier 2
        Block b9 = worldObj.getBlock(xCoord - 2, yCoord, zCoord);
        Block b10 = worldObj.getBlock(xCoord + 2, yCoord, zCoord);
        Block b11 = worldObj.getBlock(xCoord, yCoord, zCoord - 2);
        Block b12 = worldObj.getBlock(xCoord, yCoord, zCoord + 2);

        //Corners Tier 2
        Block b13 = worldObj.getBlock(xCoord - 1, yCoord, zCoord - 2);
        Block b14 = worldObj.getBlock(xCoord + 1, yCoord, zCoord - 2);
        Block b15 = worldObj.getBlock(xCoord + 1, yCoord, zCoord + 2);
        Block b16 = worldObj.getBlock(xCoord - 1, yCoord, zCoord + 2);
        Block b17 = worldObj.getBlock(xCoord - 2, yCoord, zCoord - 1);
        Block b18 = worldObj.getBlock(xCoord + 2, yCoord, zCoord - 1);
        Block b19 = worldObj.getBlock(xCoord + 2, yCoord, zCoord + 1);
        Block b20 = worldObj.getBlock(xCoord - 2, yCoord, zCoord + 1);

        //Pillars Tier 2
        Block b21 = worldObj.getBlock(xCoord + 2, yCoord, zCoord - 2);
        Block b22 = worldObj.getBlock(xCoord + 2, yCoord + 1, zCoord - 2);
        Block b23 = worldObj.getBlock(xCoord + 2, yCoord + 2, zCoord - 2);
        Block b24 = worldObj.getBlock(xCoord + 2, yCoord + 3, zCoord - 2);

        Block b25 = worldObj.getBlock(xCoord + 2, yCoord, zCoord + 2);
        Block b26 = worldObj.getBlock(xCoord + 2, yCoord + 1, zCoord + 2);
        Block b27 = worldObj.getBlock(xCoord + 2, yCoord + 2, zCoord + 2);
        Block b28 = worldObj.getBlock(xCoord + 2, yCoord + 3, zCoord + 2);

        Block b29 = worldObj.getBlock(xCoord - 2, yCoord, zCoord + 2);
        Block b30 = worldObj.getBlock(xCoord - 2, yCoord + 1, zCoord + 2);
        Block b31 = worldObj.getBlock(xCoord - 2, yCoord + 2, zCoord + 2);
        Block b32 = worldObj.getBlock(xCoord - 2, yCoord + 3, zCoord + 2);

        Block b33 = worldObj.getBlock(xCoord - 2, yCoord, zCoord - 2);
        Block b34 = worldObj.getBlock(xCoord - 2, yCoord + 1, zCoord - 2);
        Block b35 = worldObj.getBlock(xCoord - 2, yCoord + 2, zCoord - 2);
        Block b36 = worldObj.getBlock(xCoord - 2, yCoord + 3, zCoord - 2);

        //Check edges and corners
        if (b1 instanceof BlockRitualStone && b2 instanceof BlockRitualStone && b3 instanceof BlockRitualStone && b4 instanceof BlockRitualStone &&
                b5 instanceof BlockRitualItemHolder && b6 instanceof BlockRitualItemHolder && b7 instanceof BlockRitualItemHolder && b8 instanceof BlockRitualItemHolder &&
                    b9 instanceof BlockRitualSpellEnergyStorage && b10 instanceof BlockRitualSpellEnergyStorage && b11 instanceof BlockRitualSpellEnergyStorage && b12 instanceof BlockRitualSpellEnergyStorage &&
                        b13 instanceof BlockRitualStone && b14 instanceof BlockRitualStone && b15 instanceof BlockRitualStone && b16 instanceof BlockRitualStone &&
                            b17 instanceof BlockRitualStone && b18 instanceof BlockRitualStone && b19 instanceof BlockRitualStone && b20 instanceof BlockRitualStone){
            //Check pillars
            if (b21 instanceof BlockGlass && b22 instanceof BlockGlass && b23 instanceof BlockGlass && b24 instanceof BlockGlowstone &&
                    b25 instanceof BlockGlass && b26 instanceof BlockGlass && b27 instanceof BlockGlass && b28 instanceof BlockGlowstone &&
                        b29 instanceof BlockGlass && b30 instanceof BlockGlass && b31 instanceof BlockGlass && b32 instanceof BlockGlowstone &&
                            b33 instanceof BlockGlass && b34 instanceof BlockGlass && b35 instanceof BlockGlass && b36 instanceof BlockGlowstone){
                tier = 2;
                formed = true;
            }
        } else if (b1 instanceof BlockRitualSpellEnergyStorage && b2 instanceof BlockRitualSpellEnergyStorage && b3 instanceof BlockRitualSpellEnergyStorage && b4 instanceof BlockRitualSpellEnergyStorage &&
                    b5 instanceof BlockRitualItemHolder && b6 instanceof BlockRitualItemHolder && b7 instanceof BlockRitualItemHolder && b8 instanceof BlockRitualItemHolder){
            tier = 1;
            formed = true;
        } else {
            tier = 0;
            formed = false;
        }
    }

    public void updateTextures(){
        if (formed) {
            if (tier == 1) {
                worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, xCoord + 1, yCoord, zCoord + 1));
                worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, xCoord - 1, yCoord, zCoord - 1));

                //Edges
                worldObj.setBlock(xCoord, yCoord, zCoord - 1, Lumina.ritualSpellPowerStorage);
                worldObj.setBlock(xCoord + 1, yCoord, zCoord, Lumina.ritualSpellPowerStorage);
                worldObj.setBlock(xCoord, yCoord, zCoord + 1, Lumina.ritualSpellPowerStorage);
                worldObj.setBlock(xCoord - 1, yCoord, zCoord, Lumina.ritualSpellPowerStorage);

                //Corners
                worldObj.setBlock(xCoord + 1, yCoord, zCoord - 1, Lumina.ritualItemHolder);
                worldObj.setBlock(xCoord + 1, yCoord, zCoord + 1, Lumina.ritualItemHolder);
                worldObj.setBlock(xCoord - 1, yCoord, zCoord + 1, Lumina.ritualItemHolder);
                worldObj.setBlock(xCoord - 1, yCoord, zCoord - 1, Lumina.ritualItemHolder);

                //Edges
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord - 1, 1, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord, 2, 2);
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord + 1, 3, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord, 4, 2);

                //Corners
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord - 1, 5, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord + 1, 6, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord + 1, 7, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord - 1, 8, 2);

                //Master Ritual Stone
                worldObj.getBlock(xCoord, yCoord, zCoord).setBlockTextureName(Lumina.MODID + ":masterRitualStone_1");
            } else if (tier == 2) {
                worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, xCoord + 1, yCoord, zCoord + 1));
                worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, xCoord - 1, yCoord, zCoord - 1));
                worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, xCoord - 1, yCoord, zCoord + 1));
                worldObj.addWeatherEffect(new EntityLightningBolt(worldObj, xCoord + 1, yCoord, zCoord - 1));

                //Edges
                worldObj.setBlock(xCoord, yCoord, zCoord - 2, Lumina.ritualSpellPowerStorage);
                worldObj.setBlock(xCoord + 2, yCoord, zCoord, Lumina.ritualSpellPowerStorage);
                worldObj.setBlock(xCoord, yCoord, zCoord + 2, Lumina.ritualSpellPowerStorage);
                worldObj.setBlock(xCoord - 2, yCoord, zCoord, Lumina.ritualSpellPowerStorage);

                //Corners
                worldObj.setBlock(xCoord + 1, yCoord, zCoord - 1, Lumina.ritualItemHolder);
                worldObj.setBlock(xCoord + 1, yCoord, zCoord + 1, Lumina.ritualItemHolder);
                worldObj.setBlock(xCoord - 1, yCoord, zCoord + 1, Lumina.ritualItemHolder);
                worldObj.setBlock(xCoord - 1, yCoord, zCoord - 1, Lumina.ritualItemHolder);

                //Inner Edges
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord - 1, 9, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord, 9, 2);
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord + 1, 9, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord, 9, 2);

                //Inner Corners
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord - 1, 9, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord + 1, 9, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord + 1, 9, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord - 1, 9, 2);

                //Outer Edges
                worldObj.setBlockMetadataWithNotify(xCoord - 2, yCoord, zCoord, 1, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 2, yCoord, zCoord, 2, 2);
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord - 2, 3, 2);
                worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord + 2, 4, 2);

                //Outer Corners
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord - 2, 8, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord - 2, 5, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 1, yCoord, zCoord + 2, 6, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 1, yCoord, zCoord + 2, 7, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 2, yCoord, zCoord - 1, 8, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 2, yCoord, zCoord - 1, 5, 2);
                worldObj.setBlockMetadataWithNotify(xCoord + 2, yCoord, zCoord + 1, 6, 2);
                worldObj.setBlockMetadataWithNotify(xCoord - 2, yCoord, zCoord + 1, 7, 2);


                //Master Ritual Stone
                worldObj.getBlock(xCoord, yCoord, zCoord).setBlockTextureName(Lumina.MODID + ":masterRitualStone_1");
            }
        }
    }

    public Ritual getRitual(ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4){
        return RitualRegistry.instance().getRitual(stack1, stack2, stack3, stack4);
    }
}
