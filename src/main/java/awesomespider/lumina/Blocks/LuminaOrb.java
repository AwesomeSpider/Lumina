package awesomespider.lumina.Blocks;

import awesomespider.lumina.TileEntities.TileEntityLuminaOrb;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Wyatt on 4/17/2015.
 */
public class LuminaOrb extends BlockContainer{

    public LuminaOrb(Material material) {
        super(material);

        this.setBlockName("luminaOrb");
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.setLightLevel(2.5F);
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public int getRenderType(){
        return -1;
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityLuminaOrb();
    }
}
