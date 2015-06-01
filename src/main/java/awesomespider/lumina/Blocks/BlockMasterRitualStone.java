package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import awesomespider.lumina.TileEntities.TileEntityMasterRitualStone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * Created by Awesome_Spider on 5/24/2015.
 */
public class BlockMasterRitualStone extends BlockContainer{
    public BlockMasterRitualStone(Material material) {
        super(material);
        this.setBlockName("masterRitualStone");
        this.setBlockTextureName(Lumina.MODID + ":masterRitualStone");
        this.setBlockUnbreakable();
    }

    @Override
    public TileEntity createNewTileEntity(World world, int par2) {
        return new TileEntityMasterRitualStone();
    }

    @Override
    public boolean onBlockActivated(World world, int posX, int posY, int posZ, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
        return false; //TODO Activate the spell in this.
    }

    @Override
    public void onBlockClicked(World world, int posX, int posY, int posZ, EntityPlayer player){

    }
}
