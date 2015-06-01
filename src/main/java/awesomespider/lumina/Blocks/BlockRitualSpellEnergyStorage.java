package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

/**
 * Created by Awesome_Spider on 5/25/2015.
 */
public class BlockRitualSpellEnergyStorage extends Block {
    /*
    An array of Icons that can be used. The index is the metadata.

    0 - normal
    1 - edge north
    2 - edge east
    3 - edge south
    4 - edge west

    5 - corner north east
    6 - corner south east
    7 - corner south west
    8 - corner north west

    9 - center
    10 - side
     */
    public IIcon[] icons;

    public BlockRitualSpellEnergyStorage(Material material) {
        super(material);
        this.setBlockName("ritualStone");
        this.setBlockTextureName(Lumina.MODID + ":ritualStone_spellEnergyStorage");
        this.setBlockUnbreakable();
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        icons = new IIcon[10];

        for (int i = 0; i < this.icons.length; ++i)
        {
            this.icons[i] = reg.registerIcon(this.getTextureName() + "_" + i);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        if (side == 0) {
            return icons[meta];
        } else if (side == 1) {
            return icons[meta];
        } else if (side == 2) {
            if (meta > 0){
                return icons[10];
            } else {
                return icons[0];
            }
        } else if (side == 3) {
            if (meta > 0){
                return icons[10];
            } else {
                return icons[0];
            }
        } else if (side == 4) {
            if (meta > 0){
                return icons[10];
            } else {
                return icons[0];
            }
        } else if (side == 5) {
            if (meta > 0){
                return icons[10];
            } else {
                return icons[0];
            }
        }

        return null;
    }
}
