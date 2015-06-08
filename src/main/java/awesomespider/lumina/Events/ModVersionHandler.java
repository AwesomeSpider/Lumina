package awesomespider.lumina.Events;

import awesomespider.lumina.Api.Utils.ConfigUtil;
import awesomespider.lumina.Api.VersionChecker;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

import java.io.IOException;

/**
 * Created by Awesome_Spider on 6/1/2015.
 */
public class ModVersionHandler {
    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event){
        if (VersionChecker.sendNewUpdate){
            try {
                VersionChecker.sendNewVersionToPlayer(event.player);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
