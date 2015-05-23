package awesomespider.lumina.TileEntities;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

/**
 * Created by Wyatt on 5/7/2015.
 */
public class TileEntityEssentiaInterface extends TileEntity{
    /* Timer used in checking blocks for lumina orb*/
    int timer = 20;

    public boolean orbLocated = false;
    public TileEntityLuminaOrb luminaOrb;

    @Override
    public void updateEntity(){
        if (timer == 0){
            if (!orbLocated) {
                checkForOrb();
            }
            timer = 10;
        } else {
            timer --;
        }
    }

    /**
     * Check for the lumina orb. To be called once per second if the orb isn't located yet.
     */
    public void checkForOrb(){
        TileEntity te;

        //Search east and west of this tile entity
        te = worldObj.getTileEntity(xCoord + 2, yCoord, zCoord);
        if (te == null) te = worldObj.getTileEntity(xCoord + 4, yCoord, zCoord);
        if (te == null) te = worldObj.getTileEntity(xCoord - 2, yCoord, zCoord);
        if (te == null) te = worldObj.getTileEntity(xCoord - 4, yCoord, zCoord);

        //Search north and south of this tile entity
        if (te == null) te = worldObj.getTileEntity(xCoord, yCoord, zCoord + 2);
        if (te == null) te = worldObj.getTileEntity(xCoord, yCoord, zCoord + 4);
        if (te == null) te = worldObj.getTileEntity(xCoord, yCoord, zCoord - 2);
        if (te == null) te = worldObj.getTileEntity(xCoord, yCoord, zCoord - 4);

        if (te != null){
            if (te instanceof TileEntityLuminaOrb) {
                orbLocated = true;
                luminaOrb = (TileEntityLuminaOrb) te;
            }
        }
    }
}
