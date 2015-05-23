package awesomespider.lumina;

import awesomespider.lumina.Guis.GuiHandler;
import awesomespider.lumina.TileEntities.Renderers.LuminaOrbItemRenderer;
import awesomespider.lumina.TileEntities.Renderers.LuminaOrbRenderer;
import awesomespider.lumina.TileEntities.TileEntityLuminaOrb;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * Created by Wyatt on 4/18/2015.
 */
public class ClientProxy extends CommonProxy {
    public void registerRenderers(){
        LuminaOrbRenderer renderer = new LuminaOrbRenderer();

        GameRegistry.registerTileEntity(TileEntityLuminaOrb.class, "tileLuminaOrb");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLuminaOrb.class, renderer);

        MinecraftForgeClient.registerItemRenderer(Lumina.itemLuminaOrb, new LuminaOrbItemRenderer(renderer));
    }
}
