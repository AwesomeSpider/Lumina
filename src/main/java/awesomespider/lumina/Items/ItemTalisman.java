package awesomespider.lumina.Items;

import net.minecraft.item.Item;

/**
 * Created by Awesome_Spider on 6/11/2015.
 */
public class ItemTalisman extends Item {
    public ItemTalisman(int maxStackSize, String name, String textureName){
        this.setMaxStackSize(maxStackSize);
        this.setUnlocalizedName(name);
        this.setTextureName(textureName);
    }
}
