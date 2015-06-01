package awesomespider.lumina.Api.Essentia;

import awesomespider.lumina.Api.Essentia.Essentia;
import net.minecraft.item.ItemStack;

/**
 * Created by Wyatt on 5/17/2015.
 */
public class EssentiaEntry {
    public ItemStack stack;
    public Essentia essentia;

    public EssentiaEntry(ItemStack ingredient, Essentia result){
        stack = ingredient;
        essentia = result;
    }
}
