package awesomespider.lumina.Api.Utils;

import cpw.mods.fml.common.Loader;

/**
 * Created by Awesome_Spider on 5/12/2015.
 */
public class ModCompatibilityUtil {
    public static boolean isThermalExpansionLoaded(){
        return Loader.isModLoaded("ThermalExpansion");
    }
}
