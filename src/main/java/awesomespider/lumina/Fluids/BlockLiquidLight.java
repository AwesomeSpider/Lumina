package awesomespider.lumina.Fluids;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by Wyatt on 5/11/2015.
 */
public class BlockLiquidLight extends BlockFluidBase{
    public BlockLiquidLight(Fluid fluid, Material material) {
        super(fluid, material);
    }

    @Override
    public int getQuantaValue(IBlockAccess world, int x, int y, int z) {
        return 0;
    }

    @Override
    public boolean canCollideCheck(int meta, boolean fullHit) {
        return false;
    }

    @Override
    public int getMaxRenderHeightMeta() {
        return 0;
    }

    @Override
    public FluidStack drain(World world, int x, int y, int z, boolean doDrain) {
        return null;
    }

    @Override
    public boolean canDrain(World world, int x, int y, int z) {
        return false;
    }
}
