package awesomespider.lumina.TileEntities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Awesome_Spider on 5/2/2015.
 */
public class TileEntityPowerStorage extends TileEntity {
    int powerStored;
    int powerMax;

    boolean fullOfPower = false;
    boolean powerLocked = true;

    public Map<ForgeDirection, TileEntity> neighboringBlocks = new HashMap<ForgeDirection, TileEntity>();

    /**
     * Timer used for power io.
     */
    public int powerTransferTimer = 10;

    /**
     * Timer used for checking neighboring blocks.
     */
    public int blockCheckTimer = 10;

    @Override
    public void updateEntity(){
        fullOfPower = powerStored == powerMax;

        if (powerTransferTimer == 0) {//Execute when timer runs out
            powerTransferTimer = 10;
        } else {
            powerTransferTimer --;
        }

        if (blockCheckTimer == 0) {//Execute when timer runs out
            updateNeighboringBlocks();
            blockCheckTimer = 10;
        } else {
            blockCheckTimer --;
        }
    }

    /**
     * Updates the map of neighboring blocks. Called every second.
     */
    public void updateNeighboringBlocks(){
        neighboringBlocks.put(ForgeDirection.UP, worldObj.getTileEntity(xCoord, yCoord + 1, zCoord));
        neighboringBlocks.put(ForgeDirection.DOWN, worldObj.getTileEntity(xCoord, yCoord - 1, zCoord));
        neighboringBlocks.put(ForgeDirection.NORTH, worldObj.getTileEntity(xCoord, yCoord, zCoord - 1));
        neighboringBlocks.put(ForgeDirection.SOUTH, worldObj.getTileEntity(xCoord, yCoord, zCoord + 1));
        neighboringBlocks.put(ForgeDirection.EAST, worldObj.getTileEntity(xCoord + 1, yCoord, zCoord));
        neighboringBlocks.put(ForgeDirection.WEST, worldObj.getTileEntity(xCoord - 1, yCoord, zCoord));
    }

    /**
     * Adds power to the stored power.
     * @return If the tile entity's power is locked.
     */
    public boolean addPower(){
        if (!powerLocked) {
            powerStored++;
        }

        return powerLocked;
    }

    /**
     * Subtracts power from the stored power.
     * @return If the tile entity's power is locked.
     */
    public boolean depletePower(){
        if (!powerLocked) {
            powerStored--;
        }

        return powerLocked;
    }

    /**
     *
     * @param direction - The ForgeDirection that the tile entity to transfer power to is located relative to the current block.
     * @return If the tile entity's power is locked.
     */
    public boolean transferPowerOut(ForgeDirection direction){
        if (!powerLocked){
            TileEntityPowerStorage te = (TileEntityPowerStorage) neighboringBlocks.get(direction);

            depletePower();
            te.addPower();
        }

        return powerLocked;
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);

        nbt.setInteger("powerMax", powerMax);
        nbt.setInteger("powerStored", powerStored);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);

        powerMax = nbt.getInteger("powerMax");
        powerStored = nbt.getInteger("powerStored");
    }
}
