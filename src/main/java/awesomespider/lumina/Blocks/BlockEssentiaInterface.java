package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Awesome_Spider on 5/8/2015.
 */
public class BlockEssentiaInterface extends Block {
    public BlockEssentiaInterface(Material material) {
        super(material);
    }

    @Override
    public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player, int side,
                                 float hitX, float hitY, float hitZ){
        player.openGui(Lumina.instance, 1, world, posX, posY, posZ);
        return true;
    }
}
