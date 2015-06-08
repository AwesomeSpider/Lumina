package awesomespider.lumina.Api;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Awesome_Spider on 6/6/2015.
 */
public class Ritual {
    ItemStack stack1, stack2, stack3, stack4;
    int requiredPower;
    ItemStack result;
    int tier;

    public Ritual(ItemStack[] stacksRequired, int powerRequired, ItemStack result, int tierRequired) {
        stack1 = stacksRequired[0];
        stack2 = stacksRequired[1];
        stack3 = stacksRequired[2];
        stack4 = stacksRequired[3];

        requiredPower = powerRequired;
        this.result = result;
        tier = tierRequired;
    }

    public void performAnimation(World world, int masterRitualStoneX, int masterRitualStoneY, int masterRitualStoneZ){
        int posX = masterRitualStoneX;
        int posY = masterRitualStoneY;
        int posZ = masterRitualStoneZ;

        //TODO Work on animation
    }
}
