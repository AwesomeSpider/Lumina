package awesomespider.lumina.Events;

import awesomespider.lumina.Lumina;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Wyatt on 4/23/2015.
 */
public class PlayerCacheEventHandler {
    @SubscribeEvent
    public void onPlayerCacheEvent(LuminaPlayerCacheEvent event){
        if (event.actionPerformed == LuminaPlayerCacheEvent.Action.WRITE){
            Lumina.log.info(Lumina.LOGPREFIX + " New player (" + event.player.getDisplayName() + ") joined. The player has been added to PlayerCache.json");
        } else if (event.actionPerformed == LuminaPlayerCacheEvent.Action.READ){
            Lumina.log.info(Lumina.LOGPREFIX + " A player's UUID has been fetched from PlayerCache.json for " + event.modid + ".");
        }
    }
}
