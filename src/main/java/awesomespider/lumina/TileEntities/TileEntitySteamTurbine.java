package awesomespider.lumina.TileEntities;

import awesomespider.lumina.Blocks.BlockSteamTurbine;
import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Timer;

/**
 * Created by Wyatt on 5/2/2015.
 */
public class TileEntitySteamTurbine extends TileEntity {
    public int powerStored;
    public final int powerMax = 250;

    public boolean fullOfPower = false;

    public int steamMb;
    public final int steamMbMax = 500;

    public boolean active = false;

    public boolean fullOfSteam = false;

    /**
     * Timer used for power transfer and production per second.
     */
    public int timer = 20;

    @Override
    public void updateEntity(){
        fullOfSteam = steamMb == steamMbMax;
        fullOfPower = powerStored == powerMax;

        active = steamMb >= 0;

        if (active){
            if (!fullOfPower) {
                BlockSteamTurbine block = (BlockSteamTurbine) worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);

                block.active = true;

                if (timer == 0) {//Execute when timer runs out
                    steamMb--;
                    powerStored++;
                }
            }
        }

        if (!active){
            BlockSteamTurbine block = (BlockSteamTurbine) worldObj.getBlock(this.xCoord, this.yCoord, this.zCoord);

            block.active = false;
        }

        TileEntity te = worldObj.getTileEntity(this.xCoord, this.yCoord + 1, this.zCoord);

        if (te != null)
            if (te instanceof TileEntityPowerStorage){
                TileEntityPowerStorage te2 = (TileEntityPowerStorage) te;

                if (!te2.fullOfPower){
                    if (timer == 0) {//Execute when timer runs out
                        if (!te2.fullOfPower) {
                            this.powerStored--;
                            te2.addPower();
                        }
                    }
                }
            }

        if (timer != 0) {//Execute when timer hasn't run out
            timer --;
        } else {
            timer = 20; //Reset timer
        }
    }

    public void addSteam(){
        steamMb ++;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);

        nbt.setInteger("steamMilibuckets", steamMb);
        nbt.setInteger("powerStored", powerStored);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);

        steamMb = nbt.getInteger("steamMilibuckets");
        powerStored = nbt.getInteger("powerStored");
    }
}
