package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Awesome_Spider on 5/11/2015.
 */
public class BlockLightOre extends Block {
    //TODO Maybe rename it back to CrackedStoneLightOreThingy, I don't know. :)

    private Item drop;
    private int meta;
    private int least_quantity;
    private int most_quantity;

    public BlockLightOre(Material material, Item drop, int meta, int leastDrops, int mostDrops){
        this(material);

        this.drop = drop;
        this.meta = meta;
        this.least_quantity = leastDrops;
        this.most_quantity = mostDrops;
    }

    public BlockLightOre(Material material) {
        super(material);

        this.setBlockName("lightOre");
        this.setBlockTextureName(Lumina.MODID + ":lightOre");
        this.setLightLevel(1F);
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return this.drop;
    }

    @Override
    public int damageDropped(int metadata) {
        return this.meta;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random) {
        if (this.least_quantity >= this.most_quantity)
            return this.least_quantity;
        return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
    }
}
