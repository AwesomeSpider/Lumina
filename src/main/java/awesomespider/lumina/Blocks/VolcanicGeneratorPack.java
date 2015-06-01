package awesomespider.lumina.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Awesome_Spider on 5/6/2015.
 */
public class VolcanicGeneratorPack extends BlockContainer {
    public VolcanicGeneratorPack(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return null;//TODO Create a tile entity class for VolcanicGeneratorPack
    }

    @Override
    public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player, int side,
                                    float hitX, float hitY, float hitZ){
        TileEntity te = world.getTileEntity(posX, posY, posZ);

        return true;
    }
}
