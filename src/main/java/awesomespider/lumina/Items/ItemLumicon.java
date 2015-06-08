package awesomespider.lumina.Items;

import net.minecraft.item.Item;

/**
 * Created by Awesome_Spider on 6/1/2015.
 */
public class ItemLumicon extends Item {
    public ItemLumicon(int maxStackSize, String name, String textureName){
        this.setMaxStackSize(maxStackSize);
        this.setUnlocalizedName(name);
        this.setTextureName(textureName);
    }
}
