package awesomespider.lumina.TileEntities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Awesome_Spider on 5/12/2015.
 */
public class TileEntityPowerConverter extends TileEntity {
    int powerPerTick = 1;

    public Map<ForgeDirection, TileEntity> neighboringBlocks = new HashMap<ForgeDirection, TileEntity>();

    /**
     * Timer used for checking neighboring blocks.
     */
    public int blockCheckTimer = 10;

    @Override
    public void updateEntity(){
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
     * Converts lumina power to rf.
     * @param luminaPowerDirection - The direction that the lumina power storage is to convert power from.
     * @param rfStorageDirection - The direction that the rf power storage is to convert power to.
     */
    public void convertLuminaToRf(ForgeDirection luminaPowerDirection, ForgeDirection rfStorageDirection){
        //TODO I know you have a lot of things to finish in this thing allready, but finish the power converter :)
    }
}
