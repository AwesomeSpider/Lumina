package awesomespider.lumina;

import awesomespider.lumina.Blocks.LuminaOrb;
import awesomespider.lumina.Utils.ConfigUtil;
import awesomespider.lumina.Utils.LangUtil;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

@Mod(modid = Lumina.MODID, version = Lumina.VERSION)
public class Lumina {
    public static final String MODID = "lumina";
    public static final String VERSION = "0.0.1";
    public static final String LOGPREFIX = "[Lumina]";

    @SidedProxy(clientSide = "awesomespider.lumina.ClientProxy", serverSide = "awesomespider.lumina.CommonProxy")
    public static CommonProxy proxy;

    public static Logger log;

    public static File dataFolder;
    public static File configFile;

    public static BlockContainer luminaOrb;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
       log =  event.getModLog();
       log.info(LOGPREFIX + " " + LangUtil.tranlate("log.preinit.text"));
        dataFolder = event.getModConfigurationDirectory();
        configFile = event.getSuggestedConfigurationFile();

        try {
            ConfigUtil.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Initialize Blocks
        luminaOrb = new LuminaOrb(Material.air);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        log.info(LOGPREFIX + " " + LangUtil.tranlate("log.init.text"));
        ClientProxy.registerRenderers();

        GameRegistry.registerBlock(luminaOrb, "luminaOrb");
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        log.info(LOGPREFIX + " " + LangUtil.tranlate("log.postinit.text"));
    }
}
