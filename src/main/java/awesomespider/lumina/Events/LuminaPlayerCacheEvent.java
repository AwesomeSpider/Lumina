package awesomespider.lumina.Events;


import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Wyatt on 4/23/2015.
 */
public class LuminaPlayerCacheEvent extends Event{
    public enum Action{
        NONE,
        CREATE,
        WRITE,
        READ,
        EDIT
    }

    Action actionPerformed;
    EntityPlayer player;
    String modid;

    public LuminaPlayerCacheEvent(Action action){
        actionPerformed = action;
    }

    public LuminaPlayerCacheEvent(Action action, EntityPlayer playerEffected){
        actionPerformed = action;
        player = playerEffected;
    }

    public LuminaPlayerCacheEvent(Action action, String MODID){
        actionPerformed = action;
        modid = MODID;
    }
}
