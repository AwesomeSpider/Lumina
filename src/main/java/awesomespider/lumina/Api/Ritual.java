package awesomespider.lumina.Api;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Awesome_Spider on 6/6/2015.
 */
public class Ritual {
    public String name;
    public ItemStack stack1, stack2, stack3, stack4;
    public int requiredPower;
    public ItemStack result;
    public int tier;

    public int mainGlyph;
    public int[] glyphColor;

    public Ritual(String ritualName, ItemStack[] stacksRequired, int powerRequired, ItemStack result, int tierRequired, int mainGlyphMeta, int[] glyphColorRGB) {
        name = ritualName;
        stack1 = stacksRequired[0];
        stack2 = stacksRequired[1];
        stack3 = stacksRequired[2];
        stack4 = stacksRequired[3];

        requiredPower = powerRequired;
        this.result = result;
        tier = tierRequired;
        mainGlyph = mainGlyphMeta;
        glyphColor = glyphColorRGB;
    }

    public void performAnimation(World world, int masterRitualStoneX, int masterRitualStoneY, int masterRitualStoneZ){
        int posX = masterRitualStoneX;
        int posY = masterRitualStoneY;
        int posZ = masterRitualStoneZ;

        //TODO Work on animation
    }
}
