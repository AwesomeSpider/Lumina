package awesomespider.lumina.TileEntities.Renderers;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

/**
 * Created by Awesome_Spider on 4/25/2015.
 */
public class LuminaOrbItemRenderer implements IItemRenderer {
    LuminaOrbRenderer tesr;


    public  LuminaOrbItemRenderer(LuminaOrbRenderer renderer){
        tesr = renderer;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        tesr.renderTileEntityAt(null, 0, 0, 0, 0);
    }
}
