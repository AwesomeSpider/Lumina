package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import awesomespider.lumina.TileEntities.TileEntityPowerConverter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Awesome_Spider on 5/12/2015.
 */
public class BlockPowerConverter extends BlockContainer {
    public BlockPowerConverter(Material material) {
        super(material);

        this.setBlockName("powerConverter");
        this.setBlockTextureName(Lumina.MODID + ":powerConverter");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityPowerConverter();
    }
}
