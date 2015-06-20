package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by Awesome_Spider on 6/11/2015.
 */
public class BlockGlyph extends Block {

    /*
    1 - 13 glyph 1 - 13
    14 glyph of summoning
    15 glyph of purification
    16 glyph of infusion
    17 glyph of growth
     */
    IIcon[] glyphs;

    public BlockGlyph(Material material) {
        super(material);

        this.setBlockName("ritualGlyph");
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int posX, int posY, int posZ, int metadata, int fortune){
        return new ArrayList<ItemStack>();
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        glyphs = new IIcon[17];

        glyphs[0] = reg.registerIcon(Lumina.MODID + ":Glyph1");
        glyphs[1] = reg.registerIcon(Lumina.MODID + ":Glyph2");
        glyphs[2] = reg.registerIcon(Lumina.MODID + ":Glyph3");
        glyphs[3] = reg.registerIcon(Lumina.MODID + ":Glyph4");
        glyphs[4] = reg.registerIcon(Lumina.MODID + ":Glyph5");
        glyphs[5] = reg.registerIcon(Lumina.MODID + ":Glyph5");
        glyphs[6] = reg.registerIcon(Lumina.MODID + ":Glyph6");
        glyphs[7] = reg.registerIcon(Lumina.MODID + ":Glyph7");
        glyphs[8] = reg.registerIcon(Lumina.MODID + ":Glyph8");
        glyphs[9] = reg.registerIcon(Lumina.MODID + ":Glyph9");
        glyphs[10] = reg.registerIcon(Lumina.MODID + ":Glyph10");
        glyphs[11] = reg.registerIcon(Lumina.MODID + ":Glyph11");
        glyphs[12] = reg.registerIcon(Lumina.MODID + ":Glyph12");
        glyphs[13] = reg.registerIcon(Lumina.MODID + ":Glyph13");
        glyphs[14] = reg.registerIcon(Lumina.MODID + ":GlyphOfSummoning");
        glyphs[15] = reg.registerIcon(Lumina.MODID + ":GlyphOfPurification");
        glyphs[16] = reg.registerIcon(Lumina.MODID + ":GlyphOfInfusion");
        glyphs[17] = reg.registerIcon(Lumina.MODID + ":GlyphOfGrowth");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0) {
            return glyphs[meta];
        } else {
            return null;
        }
    }
}
