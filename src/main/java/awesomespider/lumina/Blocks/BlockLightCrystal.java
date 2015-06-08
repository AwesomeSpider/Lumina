package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by Awesome_Spider on 6/2/2015.
 */
public class BlockLightCrystal extends Block {
    public IIcon[] icons;

    public BlockLightCrystal(Material material) {
        super(material);

        this.setBlockName("blockLightCrystal");
        this.setBlockTextureName(Lumina.MODID + ":LightCrystal");
        this.setLightLevel(2F);
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        icons = new IIcon[]{
                reg.registerIcon(this.getTextureName() + "_0"),
                reg.registerIcon(this.getTextureName() + "_1"),
                reg.registerIcon(this.getTextureName() + "_2"),
                reg.registerIcon(this.getTextureName() + "_3"),
                reg.registerIcon(this.getTextureName() + "_4"),
                reg.registerIcon(this.getTextureName() + "_5"),
                reg.registerIcon(this.getTextureName() + "_6"),
                reg.registerIcon(this.getTextureName() + "_7")
        };
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[meta];
    }
}
