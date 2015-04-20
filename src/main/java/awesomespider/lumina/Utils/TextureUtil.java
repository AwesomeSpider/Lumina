package awesomespider.lumina.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Wyatt on 4/16/2015.
 */
public class TextureUtil {
    public static void bindTexture(String modid, String path){
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(modid, path));
    }
}
