package awesomespider.lumina.TileEntities;

import awesomespider.lumina.Blocks.BlockRitualStone;
import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockGlass;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

/**
 * Created by Awesome_Spider on 5/24/2015.
 */
public class TileEntityMasterRitualStone extends TileEntity {
    private boolean complete = false;
    private int tier = 0;

    @Override
    public void updateEntity() {
        if (!complete) {
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

                complete = true;
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

                complete = true;
            }
        }

        updateTier();
    }

    public int updateTier() {
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

        if (b1 instanceof BlockRitualStone && b2 instanceof BlockRitualStone && b3 instanceof BlockRitualStone && b4 instanceof BlockRitualStone &&
                b5 instanceof BlockRitualStone && b6 instanceof BlockRitualStone && b7 instanceof BlockRitualStone && b8 instanceof BlockRitualStone &&
                    b9 instanceof BlockRitualStone && b10 instanceof BlockRitualStone && b11 instanceof BlockRitualStone && b12 instanceof BlockRitualStone &&
                        b13 instanceof BlockRitualStone && b14 instanceof BlockRitualStone && b15 instanceof BlockRitualStone && b16 instanceof BlockRitualStone &&
                            b17 instanceof BlockRitualStone && b18 instanceof BlockRitualStone && b19 instanceof BlockRitualStone && b20 instanceof BlockRitualStone){

            tier = 2;
        } else if (b1 instanceof BlockRitualStone && b2 instanceof BlockRitualStone && b3 instanceof BlockRitualStone && b4 instanceof BlockRitualStone &&
                b5 instanceof BlockRitualStone && b6 instanceof BlockRitualStone && b7 instanceof BlockRitualStone && b8 instanceof BlockRitualStone){
            tier = 1;
        } else {
            tier = 0;
            complete = false;
        }

        return tier;
    }
}
