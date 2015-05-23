package awesomespider.lumina.Items;

import net.minecraft.item.Item;

/**
 * Created by Wyatt on 5/12/2015.
 */
public class ItemIlluminatingAlloyIngot extends Item {
    public ItemIlluminatingAlloyIngot(int maxStackSize, String name, String textureName){
        this.setMaxStackSize(maxStackSize);
        this.setUnlocalizedName(name);
        this.setTextureName(textureName);
    }
}