package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Awesome_Spider on 5/11/2015.
 */
public class SolidLight extends Block {

    public SolidLight(Material material) {
        super(material);

        this.setBlockName("solidifyedLight");
        this.setBlockTextureName(Lumina.MODID + ":solidifyedLight");
        this.setLightLevel(1.5F);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }
}
