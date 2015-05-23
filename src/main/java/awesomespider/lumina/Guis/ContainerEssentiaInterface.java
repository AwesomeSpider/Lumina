package awesomespider.lumina.Guis;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * Created by Wyatt on 5/8/2015.
 */
public class ContainerEssentiaInterface extends Container {
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
