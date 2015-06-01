package awesomespider.lumina.Api.Essentia;

import awesomespider.lumina.Exceptions.DuplicateEssentiaEntryException;
import awesomespider.lumina.Exceptions.InvalidEssentiaEntryException;
import awesomespider.lumina.Exceptions.InvalidModidException;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Awesome_Spider on 5/17/2015.
 */
public class EssentiaHelper {
    /**
     * The hashmap that holds all the items/blocks that can be decompiled.
     * The String is the modid that entered the item/block.
     * The ArrayList is a list of the mod's entries.
     */
    static Map<String, ArrayList<EssentiaEntry>> essentiaEntries = new HashMap<String, ArrayList<EssentiaEntry>>();

    /**
     * A list of all the modids of mods that have entered items/blocks.
     */
    static List<String> modids = new ArrayList<String>();

    /**
     * Adds an item to the list of items/blocks that can be decompiled into essentia.
     * @param item - The item to be added.
     * @param essentia - The type of essentia and how much to be made.
     */
    public static void addEssentiaItem(Item item, Essentia essentia, String modid) throws DuplicateEssentiaEntryException {
        if (!modids.contains(modid)) modids.add(modid);

        ArrayList<EssentiaEntry> entries;

        if (essentiaEntries.containsKey(modid)) {
            entries = essentiaEntries.get(modid);
        } else {
            entries = new ArrayList<EssentiaEntry>();
        }

        EssentiaEntry entry = new EssentiaEntry(new ItemStack(item), essentia);

        if (!entries.contains(entry)){
            entries.add(entry);
        } else {
            throw new DuplicateEssentiaEntryException(modid);
        }

        essentiaEntries.put(modid, entries);
    }

    /**
     * Adds a block to the list of items/blocks that can be decompiled into essentia.
     * @param block - The block to be added.
     * @param essentia - The type of essentia and how much to be made.
     */
    public static void addEssentiaItem(Block block, Essentia essentia, String modid) throws DuplicateEssentiaEntryException {
        if (!modids.contains(modid)) modids.add(modid);

        ArrayList<EssentiaEntry> entries;

        if (essentiaEntries.containsKey(modid)) {
            entries = essentiaEntries.get(modid);
        } else {
            entries = new ArrayList<EssentiaEntry>();
        }

        EssentiaEntry entry = new EssentiaEntry(new ItemStack(block), essentia);

        if (!entries.contains(entry)){
            entries.add(entry);
        } else {
            throw new DuplicateEssentiaEntryException(modid);
        }

        essentiaEntries.put(modid, entries);
    }

    /**
     * Adds a itemstack to the list of items/blocks that can be decompiled into essentia.
     * @param itemstack - The item or block to be added.
     * @param essentia - The type of essentia and how much to be made.
     */
    public static void addEssentiaItem(ItemStack itemstack, Essentia essentia, String modid) throws DuplicateEssentiaEntryException {
        if (!modids.contains(modid)) modids.add(modid);

        ArrayList<EssentiaEntry> entries;

        if (essentiaEntries.containsKey(modid)) {
            entries = essentiaEntries.get(modid);
        } else {
            entries = new ArrayList<EssentiaEntry>();
        }

        EssentiaEntry entry = new EssentiaEntry(itemstack , essentia);

        if (!entries.contains(entry)){
            entries.add(entry);
        } else {
            throw new DuplicateEssentiaEntryException(modid);
        }

        essentiaEntries.put(modid, entries);
    }

    /**
     * Removes an entry from the list of items/blocks that can be decompiled into essentia.
     * @param entry - The entry to remove.
     * @param modid - The mod's modid to remove the entry from.
     * @throws InvalidEssentiaEntryException
     * @throws InvalidModidException
     */
    public static void deleteEssentiaItem(EssentiaEntry entry, String modid) throws InvalidEssentiaEntryException, InvalidModidException {
        if (essentiaEntries.containsKey(modid)){
            ArrayList<EssentiaEntry> entries = essentiaEntries.get(modid);
            if (entries.contains(entry)){
                entries.remove(entry);
            } else {
               throw new InvalidEssentiaEntryException(modid);
            }
        } else {
            throw new InvalidModidException(modid);
        }
    }

    /*public static void saveToDisk() throws IOException {
        File file = new File(Lumina.dataFolder, "/Essentia.json");

        JsonUtil.createJsonFile(file);

        JsonWriter json = new JsonWriter(new FileWriter(file));

        json.beginObject();

        int modidListSize = modids.size();

        for (int i = 0; i == modidListSize; i ++){
            ArrayList<EssentiaEntry> entries = essentiaEntries.get(modids.get(i));

            json.name(modids.get(i));
            json.beginObject();

            for (int i2 = 0; i2 == entries.size(); i ++){
                EssentiaEntry entry = entries.get(i2);
                Essentia result = entry.essentia;
                ItemStack ingredient = entry.stack;

                json.name(ingredient.getUnlocalizedName() + ".Type").value(result.type.toString());
                json.name(ingredient.getUnlocalizedName() + ".Amount").value(result.mb);
            }

            json.endObject();
        }
        json.endObject();
        json.close();
    }*/

    /*public static void readFromDisk() throws IOException, CorruptedJsonException {
        File file = new File(Lumina.dataFolder, "/Essentia.json");

        JsonReader json = new JsonReader(new FileReader(file));

        json.beginObject();

        while(json.hasNext()){
            String currentModid = json.nextName();

            List<EssentiaEntry> modEntries = new ArrayList<EssentiaEntry>();

            modids.add(currentModid);
            json.beginObject();

            while(json.hasNext()){
                EssentiaEntry entry;
                ItemStack ingredient;
                Essentia essentia;

                String unlocalizedName;
                String type;
                int amount;

                String nameType = json.nextName();
                if (nameType.endsWith(".Type")){
                    type = json.nextString();
                } else {
                    throw new CorruptedJsonException(file.getAbsolutePath());
                }

                String nameAmount = json.nextName();
                if (nameType.endsWith(".Amount")){
                    amount = json.nextInt();
                } else {
                    throw new CorruptedJsonException(file.getAbsolutePath());
                }

                String nameTypeCut = nameType.substring(0, nameType.length() - 5);
                String nameAmountCut = nameAmount.substring(0, nameAmount.length() - 7);

                if (nameTypeCut.equals(nameAmountCut)){
                    unlocalizedName = nameTypeCut;
                } else {
                    throw new CorruptedJsonException(file.getAbsolutePath());
                }

                if (unlocalizedName.startsWith("item.")){
                    ingredient = new ItemStack(GameRegistry.findItem(currentModid, unlocalizedName));
                } else if (unlocalizedName.startsWith("tile.")){
                    ingredient = new ItemStack(GameRegistry.findBlock(currentModid, unlocalizedName));
                } else {
                    throw new CorruptedJsonException(file.getAbsolutePath());
                }

                essentia = new Essentia(Essentia.Elements.valueOf(type), amount);

                entry = new EssentiaEntry(ingredient, essentia);

                modEntries.add(entry);
            }

            json.endObject();

           essentiaEntries.put(currentModid, (ArrayList<EssentiaEntry>) modEntries);
        }

        json.endObject();
        json.close();
    }*/

    /**
     * Adds the default Essentia Entries to the map.
     */
    public static void addDefaults(){
        //TODO Re-balance this system.

        //Items
        try {
            addEssentiaItem(Items.apple,         new Essentia(Essentia.Elements.PLANT, 5),  "minecraft");
            addEssentiaItem(Items.baked_potato,  new Essentia(Essentia.Elements.PLANT, 5, Essentia.Elements.FIRE, 2), "minecraft");
            addEssentiaItem(Items.beef,          new Essentia(Essentia.Elements.LIFE, 5, Essentia.Elements.FIRE, 5), "minecraft");
            addEssentiaItem(Items.blaze_powder,  new Essentia(Essentia.Elements.FIRE, 15), "minecraft");
            addEssentiaItem(Items.blaze_rod,     new Essentia(Essentia.Elements.FIRE, 25), "minecraft");
            addEssentiaItem(Items.boat,          new Essentia(Essentia.Elements.WATER, 2, Essentia.Elements.PLANT, 2), "minecraft");
            addEssentiaItem(Items.bone,          new Essentia(Essentia.Elements.LIFE, 2, Essentia.Elements.SPECTRAL, 10), "minecraft");
            addEssentiaItem(Items.book,          new Essentia(Essentia.Elements.KNOWLEDGE, 5), "minecraft");
            addEssentiaItem(Items.bowl,          new Essentia(Essentia.Elements.PLANT, 2), "minecraft");
            addEssentiaItem(Items.bread,         new Essentia(Essentia.Elements.PLANT, 5, Essentia.Elements.LIFE, 5), "minecraft");
            addEssentiaItem(Items.brewing_stand, new Essentia(Essentia.Elements.KNOWLEDGE, 10), "minecraft");
            addEssentiaItem(Items.brick,         new Essentia(Essentia.Elements.EARTH, 7), "minecraft");
            addEssentiaItem(Items.bucket,        new Essentia(Essentia.Elements.WATER, 5, Essentia.Elements.ORE, 5), "minecraft");
            addEssentiaItem(Items.carrot,        new Essentia(Essentia.Elements.PLANT, 5), "minecraft");
            addEssentiaItem(Items.carrot_on_a_stick, new Essentia(Essentia.Elements.PLANT, 5), "minecraft");
            addEssentiaItem(Items.cauldron,             new Essentia(Essentia.Elements.ORE, 6), "minecraft");
            addEssentiaItem(Items.chicken,      new Essentia(Essentia.Elements.LIFE, 2), "minecraft");
            addEssentiaItem(Items.clay_ball,    new Essentia(Essentia.Elements.EARTH, 5), "minecraft");
            addEssentiaItem(Items.coal,         new Essentia(Essentia.Elements.EARTH, 2, Essentia.Elements.ORE, 2), "minecraft");
            addEssentiaItem(Items.diamond,      new Essentia(Essentia.Elements.ORE, 25), "minecraft");
            addEssentiaItem(Items.egg,          new Essentia(Essentia.Elements.LIFE, 5), "minecraft");
            addEssentiaItem(Items.emerald,      new Essentia(Essentia.Elements.ORE, 30), "minecraft");
            addEssentiaItem(Items.enchanted_book, new Essentia(Essentia.Elements.KNOWLEDGE, 20), "minecraft");
            addEssentiaItem(Items.ender_eye,    new Essentia(Essentia.Elements.ENDER, 10), "minecraft");
            addEssentiaItem(Items.ender_pearl,  new Essentia(Essentia.Elements.ENDER, 5), "minecraft");
            addEssentiaItem(Items.experience_bottle, new Essentia(Essentia.Elements.XP, 10), "minecraft"); //10 XP essentia gives 1 xp lvl???
            addEssentiaItem(Items.feather,      new Essentia(Essentia.Elements.AIR, 1), "minecraft");
            addEssentiaItem(Items.fire_charge,  new Essentia(Essentia.Elements.FIRE, 5), "minecraft");
            addEssentiaItem(Items.fish,         new Essentia(Essentia.Elements.WATER, 5, Essentia.Elements.LIFE, 2), "minecraft");
            addEssentiaItem(Items.flint,        new Essentia(Essentia.Elements.EARTH, 1, Essentia.Elements.ORE, 2), "minecraft");
            addEssentiaItem(Items.ghast_tear,   new Essentia(Essentia.Elements.SPECTRAL, 10), "minecraft");
            addEssentiaItem(Items.gold_ingot,   new Essentia(Essentia.Elements.ORE, 15), "minecraft");
            addEssentiaItem(Items.gold_nugget,  new Essentia(Essentia.Elements.ORE, 2), "minecraft");
            addEssentiaItem(Items.gunpowder,    new Essentia(Essentia.Elements.SPECTRAL, 2, Essentia.Elements.FIRE, 5), "minecraft");
            addEssentiaItem(Items.iron_ingot,   new Essentia(Essentia.Elements.ORE, 10), "minecraft");
            addEssentiaItem(Items.lava_bucket,  new Essentia(Essentia.Elements.FIRE, 15), "minecraft");
            addEssentiaItem(Items.magma_cream,  new Essentia(Essentia.Elements.PLANT, 12), "minecraft");
            addEssentiaItem(Items.melon,        new Essentia(Essentia.Elements.PLANT, 3, Essentia.Elements.WATER, 2), "minecraft");
            addEssentiaItem(Items.milk_bucket,  new Essentia(Essentia.Elements.WATER, 5), "minecraft");
            addEssentiaItem(Items.nether_star,  new Essentia(Essentia.Elements.SPECTRAL, 50), "minecraft");
            addEssentiaItem(Items.nether_wart,  new Essentia(Essentia.Elements.FIRE, 2), "minecraft");
            addEssentiaItem(Items.netherbrick,  new Essentia(Essentia.Elements.FIRE, 5), "minecraft");
            addEssentiaItem(Items.paper,        new Essentia(Essentia.Elements.PLANT, 2), "minecraft");
            addEssentiaItem(Items.potato,       new Essentia(Essentia.Elements.PLANT, 5), "minecraft");
            addEssentiaItem(Items.quartz,       new Essentia(Essentia.Elements.ORE, 7), "minecraft");
            addEssentiaItem(Items.redstone,     new Essentia(Essentia.Elements.ORE, 5), "minecraft");
            addEssentiaItem(Items.reeds,        new Essentia(Essentia.Elements.PLANT, 5), "minecraft");
            addEssentiaItem(Items.rotten_flesh, new Essentia(Essentia.Elements.SPECTRAL, 4), "minecraft");
            addEssentiaItem(Items.slime_ball,   new Essentia(Essentia.Elements.SPECTRAL, 3), "minecraft");
            addEssentiaItem(Items.snowball,     new Essentia(Essentia.Elements.WATER, 7), "minecraft");
            addEssentiaItem(Items.speckled_melon, new Essentia(Essentia.Elements.PLANT, 3, Essentia.Elements.LIFE, 3), "minecraft");
            addEssentiaItem(Items.water_bucket, new Essentia(Essentia.Elements.WATER, 15), "minecraft");
            addEssentiaItem(Items.wheat,        new Essentia(Essentia.Elements.PLANT, 2), "minecraft");
            addEssentiaItem(Items.written_book, new Essentia(Essentia.Elements.KNOWLEDGE, 10), "minecraft");
        } catch(DuplicateEssentiaEntryException e){
            e.printStackTrace();
        }

        //Blocks
        try {
            addEssentiaItem(Blocks.brick_block, new Essentia(Essentia.Elements.EARTH, 28), "minecraft");
            addEssentiaItem(Blocks.coal_block, new Essentia(Essentia.Elements.EARTH, 18, Essentia.Elements.ORE, 18), "minecraft");
            addEssentiaItem(Blocks.diamond_block, new Essentia(Essentia.Elements.ORE, 225), "minecraft");
            addEssentiaItem(Blocks.emerald_block, new Essentia(Essentia.Elements.ORE, 270), "minecraft");
            addEssentiaItem(Blocks.gold_block, new Essentia(Essentia.Elements.ORE, 135), "minecraft");
            addEssentiaItem(Blocks.hay_block, new Essentia(Essentia.Elements.PLANT, 18), "minecraft");
            addEssentiaItem(Blocks.iron_block, new Essentia(Essentia.Elements.ORE, 90), "minecraft");
            addEssentiaItem(Blocks.melon_block, new Essentia(Essentia.Elements.PLANT, 27, Essentia.Elements.WATER, 18), "minecraft");
            addEssentiaItem(Blocks.quartz_block, new Essentia(Essentia.Elements.ORE, 63), "minecraft");
            addEssentiaItem(Blocks.redstone_block, new Essentia(Essentia.Elements.ORE, 45), "minecraft");
            addEssentiaItem(Blocks.cactus, new Essentia(Essentia.Elements.PLANT, 5), "minecraft");
            addEssentiaItem(Blocks.clay, new Essentia(Essentia.Elements.EARTH, 20), "minecraft");
            addEssentiaItem(Blocks.cobblestone, new Essentia(Essentia.Elements.ORE, 2), "minecraft");
            addEssentiaItem(Blocks.enchanting_table, new Essentia(Essentia.Elements.KNOWLEDGE, 50), "minecraft");
            addEssentiaItem(Blocks.dirt, new Essentia(Essentia.Elements.EARTH, 1), "minecraft");
            addEssentiaItem(Blocks.dragon_egg, new Essentia(Essentia.Elements.ENDER, 50, Essentia.Elements.LIFE, 50), "minecraft");
            addEssentiaItem(Blocks.end_stone, new Essentia(Essentia.Elements.ENDER, 10), "minecraft");
            addEssentiaItem(Blocks.grass, new Essentia(Essentia.Elements.EARTH, 2, Essentia.Elements.PLANT, 2), "minecraft");
            addEssentiaItem(Blocks.ice, new Essentia(Essentia.Elements.WATER, 10), "minecraft");
            addEssentiaItem(Blocks.mycelium, new Essentia(Essentia.Elements.EARTH, 5, Essentia.Elements.SPECTRAL, 1), "minecraft");
            addEssentiaItem(Blocks.netherrack, new Essentia(Essentia.Elements.FIRE, 5), "minecraft");
            addEssentiaItem(Blocks.nether_brick, new Essentia(Essentia.Elements.FIRE, 20), "minecraft");
            addEssentiaItem(Blocks.packed_ice, new Essentia(Essentia.Elements.WATER, 20), "minecraft");
            addEssentiaItem(Blocks.pumpkin, new Essentia(Essentia.Elements.PLANT, 5), "minecraft");
            addEssentiaItem(Blocks.soul_sand, new Essentia(Essentia.Elements.SPECTRAL, 10), "minecraft");
            addEssentiaItem(Blocks.stone, new Essentia(Essentia.Elements.ORE, 4), "minecraft");
        } catch (DuplicateEssentiaEntryException e){
            e.printStackTrace();
        }
    }
}
