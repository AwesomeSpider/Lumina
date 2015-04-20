package awesomespider.lumina;

import awesomespider.lumina.Blocks.LuminaOrbRenderer;
import awesomespider.lumina.Blocks.TileEntityLuminaOrb;
import cpw.mods.fml.client.registry.ClientRegistry;

/**
 * Created by Wyatt on 4/18/2015.
 */
public class ClientProxy extends CommonProxy {
    public static void registerRenderers(){
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLuminaOrb.class, new LuminaOrbRenderer());
    }
}
