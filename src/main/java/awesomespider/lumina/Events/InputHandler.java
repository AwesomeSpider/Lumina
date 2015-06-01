package awesomespider.lumina.Events;

import awesomespider.lumina.Api.Utils.PlayerUtil;
import awesomespider.lumina.KeyBindings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;

/**
 * Created by Awesome_Spider on 5/28/2015.
 */
public class InputHandler {
    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if(KeyBindings.start.isPressed()){
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;

            try {
                PlayerUtil.startPlayer(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
