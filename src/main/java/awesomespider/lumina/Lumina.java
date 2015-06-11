package awesomespider.lumina;

import awesomespider.lumina.Api.Essentia.EssentiaHelper;
import awesomespider.lumina.Api.RitualRegistry;
import awesomespider.lumina.Api.VersionChecker;
import awesomespider.lumina.Blocks.*;
import awesomespider.lumina.CreativeTabs.LuminaTab;
import awesomespider.lumina.Events.InputHandler;
import awesomespider.lumina.Events.ModVersionHandler;
import awesomespider.lumina.Events.PlayerCacheEventHandler;
import awesomespider.lumina.Generation.WorldGeneration;
import awesomespider.lumina.Guis.GuiHandler;
import awesomespider.lumina.Items.*;
import awesomespider.lumina.Api.Utils.*;
import awesomespider.lumina.Packets.LumiconSpawnPacket;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

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

    public static SimpleNetworkWrapper network;

    public static CreativeTabs luminaTab;

    //Blocks
    public static BlockContainer luminaOrb;
    public static BlockContainer steamTurbine;

    public static Block solidLight;
    public static Block crackedStoneLightOreThingy;

    public static Block illuminatingAlloyBlock;

    public static Block powerConverter;

    public static Block ritualStone;
    public static Block ritualSpellPowerStorage;
    public static Block ritualItemHolder;

    public static Block blockLightCrystal;

    //Items
    public static Item lumicon;

    public static Item impureLightIngot;

    public static Item itemLuminaOrb;

    public static Item steamTurbineRotor;

    public static Item lightDust;
    public static Item lightGlowstoneBlend;
    public static Item lightGlowstoneIronBlend;
    public static Item illuminatingAlloyIngot;
    public static Item lightCrystal;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
       log = event.getModLog();
       log.info(LOGPREFIX + " " + LangUtil.tranlate("log.preinit.text"));
        dataFolder = new File(event.getModConfigurationDirectory(), "/Lumina");
        configFile = event.getSuggestedConfigurationFile();

        try {
            ConfigUtil.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        KeyBindings.init();

        network = NetworkRegistry.INSTANCE.newSimpleChannel("Lumina|Channel");

        luminaTab = new LuminaTab("Lumina");

        //Initialize Blocks
        luminaOrb = new LuminaOrb(Material.rock);
        steamTurbine = new BlockSteamTurbine(Material.iron);

        solidLight = new SolidLight(Material.rock);
        crackedStoneLightOreThingy = new BlockLightOre(Material.rock);

        powerConverter = new BlockPowerConverter(Material.iron);

        blockLightCrystal = new BlockLightCrystal(Material.rock);

        //Initialize Items
        lumicon = new ItemLumicon(1, "lumicon", MODID + ":lumicon");

        impureLightIngot = new ItemImpureLightIngot(64, "impureLightIngot", MODID + ":impureLightIngot");

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

        //Block
        GameRegistry.registerBlock(luminaOrb, "luminaOrb");
        GameRegistry.registerBlock(steamTurbine, "steamTurbine");

        GameRegistry.registerBlock(solidLight, "solidifyedLight");
        GameRegistry.registerBlock(crackedStoneLightOreThingy, "lightOre");

        if (ModCompatibilityUtil.isThermalExpansionLoaded) {
            GameRegistry.registerBlock(powerConverter, "powerConverter");
        }

        GameRegistry.registerBlock(blockLightCrystal, "blockLightCrystal");

        //Items
        GameRegistry.registerItem(lumicon, lumicon.getUnlocalizedName(), MODID);

        GameRegistry.registerItem(impureLightIngot, impureLightIngot.getUnlocalizedName(), MODID);

        GameRegistry.registerItem(itemLuminaOrb, itemLuminaOrb.getUnlocalizedName(), MODID);
        GameRegistry.registerItem(lightDust, lightDust.getUnlocalizedName(), MODID);

        //Recipes
        GameRegistry.addSmelting(crackedStoneLightOreThingy, new ItemStack(impureLightIngot), 0.5F);

        GameRegistry.registerWorldGenerator(new WorldGeneration(), 0);

        MinecraftForge.EVENT_BUS.register(new PlayerCacheEventHandler());
        MinecraftForge.EVENT_BUS.register(new TimeUtil());
        FMLCommonHandler.instance().bus().register(new InputHandler());
        FMLCommonHandler.instance().bus().register(new ModVersionHandler());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        network.registerMessage(LumiconSpawnPacket.Handler.class, LumiconSpawnPacket.class, 0, Side.SERVER);
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event){
        log.info(LOGPREFIX + " " + LangUtil.tranlate("log.postinit.text"));

        try {
            PlayerUtil.createPlayerCache();
        } catch (IOException e) {
            e.printStackTrace();
        }

        EssentiaHelper.addDefaults();

        try {
            PlayerUtil.loadPlayersStarted();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
