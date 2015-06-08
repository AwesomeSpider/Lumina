package awesomespider.lumina.CreativeTabs;

import awesomespider.lumina.Lumina;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Awesome_Spider on 6/3/2015.
 */
public class LuminaTab extends CreativeTabs {
    public LuminaTab(String lable) {
        super(lable);
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }

    public void addItem(Item item){
        item.setCreativeTab(Lumina.luminaTab);
    }

    public void addBlock(Block block){
        block.setCreativeTab(Lumina.luminaTab);
    }
}
