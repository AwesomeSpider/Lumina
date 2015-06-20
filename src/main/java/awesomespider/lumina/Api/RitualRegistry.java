package awesomespider.lumina.Api;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Awesome_Spider on 6/7/2015.
 */
public class RitualRegistry {
    private static RitualRegistry instance = new RitualRegistry();
    private static ArrayList<Ritual> ritualList = new ArrayList<Ritual>();

    public static RitualRegistry instance(){
        return instance;
    }

    public void register(Ritual ritual){
        ritualList.add(ritual);
    }

    public ArrayList<Ritual> getRituals(){
        return ritualList;
    }

    public Ritual getRitual(ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4){
        Ritual result = null;

        for (Ritual ritual : ritualList){
            if (stack1.equals(ritual.stack1) && stack2.equals(ritual.stack2) && stack3.equals(ritual.stack3) && stack4.equals(ritual.stack4)){
                result = ritual;
            } else {
                result = null;
            }
        }

        return result;
    }

    public Ritual getRitual(String name){
        Ritual result = null;

        for (Ritual ritual : ritualList){
            if (ritual.name.equals(name)){
                result = ritual;
            } else {
                result = null;
            }
        }

        return result;
    }
}
