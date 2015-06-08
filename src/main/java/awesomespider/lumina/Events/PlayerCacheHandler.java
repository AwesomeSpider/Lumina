package awesomespider.lumina.Events;

import awesomespider.lumina.Api.Utils.PlayerUtil;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;

/**
 * Created by Awesome_Spider on 4/21/2015.
 */
public class PlayerCacheHandler {
    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer p = event.player;

        try {
            PlayerUtil.addPlayerToCache(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
