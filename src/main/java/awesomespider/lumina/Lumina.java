package awesomespider.lumina;

import awesomespider.lumina.Api.EssentiaHelper;
import awesomespider.lumina.Blocks.*;
import awesomespider.lumina.Events.PlayerCacheEventHandler;
import awesomespider.lumina.Exceptions.CorruptedJsonException;
import awesomespider.lumina.Generation.WorldGeneration;
import awesomespider.lumina.Guis.GuiHandler;
import awesomespider.lumina.Items.*;
import awesomespider.lumina.Utils.*;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModClassLoader;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Mod(modid = Lumina.MODID, version = Lumina.VERSION, name = Lumina.NAME)
public class Lumina {
    public static final String MODID = "lumina";
    public static final String NAME = "Lumina";
    public static final String VERSION = "0.0.1";
    public static final String LOGPREFIX = "[Lumina]";

    @SidedProxy(clientSide = "awesomespider.lumina.ClientProxy", serverSide = "awesomespider.lumina.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static Lumina instance;

    public static Logger log;

    public static File dataFolder;
    public static File configFile;

    //Blocks
    public static BlockContainer luminaOrb;
    public static BlockContainer steamTurbine;

    public static Block solidLight;
    public static Block crackedStoneLightOreThingy;

    public static Block illuminatingAlloyBlock;

    public static Block powerConverter;

    //Items
    public static Item itemLuminaOrb;

    public static Item steamTurbineRotor;

    public static Item lightDust;
    public static Item lightGlowstoneBlend;
    public static Item lightGlowstoneIronBlend;
    public static Item illuminatingAlloyIngot;
    public static Item lightCrystal;

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
        luminaOrb = new LuminaOrb(Material.rock);
        steamTurbine = new BlockSteamTurbine(Material.iron);

        solidLight = new SolidLight(Material.rock);
        crackedStoneLightOreThingy = new BlockLightOre(Material.rock);

        powerConverter = new BlockPowerConverter(Material.iron);

        //Initialize Items
        itemLuminaOrb = new ItemLuminaOrb(1, "itemLuminaOrb", MODID + ":itemLuminaOrb");
        lightDust = new ItemLightDust(64, "lightDust", MODID + ":lightDust");
        lightGlowstoneBlend = new ItemLightGlowstoneBlend(64, "lightGlowstoneBlend", MODID + ":lightGlowstoneBlend");
        lightGlowstoneIronBlend = new ItemLightGlowstoneIronBlend(64, "lightGlowstoneIronBlend", MODID + ":lightGlowstoneIronBlend");
        illuminatingAlloyIngot = new ItemIlluminatingAlloyIngot(64, "illuminatingAlloyIngot", MODID + "illuminatingAlloyIngot");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        log.info(LOGPREFIX + " " + LangUtil.tranlate("log.init.text"));
        proxy.registerRenderers();

        GameRegistry.registerBlock(luminaOrb, "luminaOrb");
        GameRegistry.registerBlock(steamTurbine, "steamTurbine");

        GameRegistry.registerBlock(solidLight, "solidifyedLight");
        GameRegistry.registerBlock(crackedStoneLightOreThingy, "lightOre");

        if (ModCompatibilityUtil.isThermalExpansionLoaded()) {
            GameRegistry.registerBlock(powerConverter, "powerConverter");
        }

        GameRegistry.registerItem(itemLuminaOrb, itemLuminaOrb.getUnlocalizedName(), MODID);
        GameRegistry.registerItem(lightDust, lightDust.getUnlocalizedName(), MODID);

        GameRegistry.registerWorldGenerator(new WorldGeneration(), 0);

        MinecraftForge.EVENT_BUS.register(new PlayerCacheEventHandler());
        MinecraftForge.EVENT_BUS.register(new TimeUtil());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
        log.info(LOGPREFIX + " " + LangUtil.tranlate("log.postinit.text"));
        try {
            PlayerUtil.createPlayerCache();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            EssentiaHelper.readFromDisk();
            EssentiaHelper.addDefaults();
            EssentiaHelper.saveToDisk();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CorruptedJsonException e) {
            e.printStackTrace();
        }
    }
}
