package awesomespider.lumina.TileEntities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Wyatt on 4/23/2015.
 */
public class TileEntityFluidStorageBase extends TileEntity {

    int maxMilibuckets;
    String liquidName;
    int milibuckets;

    boolean full = false;
    int fullAmt = 0;

    @Override
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);

        nbt.setInteger("maxMilibuckets", maxMilibuckets);
        nbt.setString("liquidName", liquidName);
        nbt.setInteger("milibuckets", milibuckets);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);

        maxMilibuckets = nbt.getInteger("maxMilibuckets");
        liquidName = nbt.getString("liquidName");
        milibuckets = nbt.getInteger("milibuckets");
    }

    @Override
    public void updateEntity(){
        if (milibuckets == 0){
            liquidName = null;
        }
    }

    /**
     * Attempt to add fluid to this tile entity.
     * @param liquid - The name of the liquid that needs to be added.
     * @param milibuckets - The amount of fluid to be added.
     * @return - Whether the tile entity got full while filling.
     */
    public boolean attemptAddFluid(String liquid, int milibuckets){
        int amt = milibuckets + this.milibuckets;

        if (this.milibuckets == 0){
            this.milibuckets = amt;
        }

        if (amt <= maxMilibuckets) {
            if (liquid.equals(liquidName)) {
                this.milibuckets = amt;
                return true;
            } else {
                return false;
            }
        } else {
            int remainder = 0;

             for (int i = 0; i == milibuckets; i ++){
                 if (this.milibuckets != this.maxMilibuckets)
                     this.milibuckets = this.milibuckets ++;
                 if (this.milibuckets == this.maxMilibuckets) {
                     remainder++;
                     full = true;
                 }
             }

            fullAmt = remainder;

            return false;
        }
    }

    /**
     * Turns the amount it is overfilled back to 0.
     * @return - The amount that should be added back to the block attempting to add a fluid.
     */
    public int takeBackFullAmount(){
        int result = fullAmt;
        fullAmt = 0;
        return result;
    }

    /**
     * Turns the amount it is overfilled back to 0.
     */
    public void nullifyFullAmount(){
        fullAmt = 0;
    }

    /**
     * Get the amount of fluid in milibuckets.
     * @return - The amount of fluid.
     */
    public int getMilibuckets(){
        return milibuckets;
    }

    /**
     * Gets the name of fluid being held.
     * @return - The name of fluid being held.
     */
    public String getFluidName(){
        return liquidName;
    }

    /**
     * Converts the given fluidName to a Fluid instance.
     * @param fluidName - The name of the fluid to be converted.
     * @return - The fluid.
     */
    public Fluid convertNameToFluid(String fluidName){
        return FluidRegistry.getFluid(fluidName);
    }

    /**
     * Depletes the amount of fluid specified.
     * @return - If it worked or not.
     */
    public boolean attemptDeplete(int amount){
        milibuckets = milibuckets - amount;
        return true;
    }
}
