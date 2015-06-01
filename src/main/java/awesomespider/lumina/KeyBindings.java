package awesomespider.lumina;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by Awesome_Spider on 5/28/2015.
 */
public class KeyBindings {
    public static KeyBinding start; //Opens a gui then starts the player in Lumina

    public static void init(){
        start = new KeyBinding("key.start", Keyboard.KEY_L, "key.categories.lumina");

        ClientRegistry.registerKeyBinding(start);
    }
}
