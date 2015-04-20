package awesomespider.lumina.Blocks;

import net.minecraft.tileentity.TileEntity;

/**
 * Created by Wyatt on 4/17/2015.
 */
public class TileEntityLuminaOrb extends TileEntity {
    public float rotation = 0;

    @Override
    public void updateEntity(){
        if (worldObj.isRemote) rotation += 0.5;
    }
}
