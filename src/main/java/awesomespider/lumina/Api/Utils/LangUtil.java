package awesomespider.lumina.Api.Utils;

import net.minecraft.util.StatCollector;

/**
 * Created by Awesome_Spider on 4/16/2015.
 */
public class LangUtil {
    /**
     * Translates the given string from unlocalized form. For example: item.exampleItem.name could translate to Example Item.
     * @param unlocalizedString - The string to translate, must be in the lang file
     * @return - The localized string.
     */
    public static String tranlate(String unlocalizedString){
        return StatCollector.translateToLocal(unlocalizedString);
    }
}
