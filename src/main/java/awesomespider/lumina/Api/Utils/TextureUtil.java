package awesomespider.lumina.Api.Utils;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Awesome_Spider on 4/16/2015.
 */
public class TextureUtil {
    public static void bindTexture(String modid, String path){
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(modid, path));
    }
}
