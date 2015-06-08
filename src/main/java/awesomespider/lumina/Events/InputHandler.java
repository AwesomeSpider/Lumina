package awesomespider.lumina.Events;

import awesomespider.lumina.Api.Utils.PlayerUtil;
import awesomespider.lumina.KeyBindings;
import awesomespider.lumina.Lumina;
import awesomespider.lumina.Packets.LumiconSpawnPacket;
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

            Lumina.network.sendToServer(new LumiconSpawnPacket(player.posX, player.posY, player.posZ));
        }
    }
}
