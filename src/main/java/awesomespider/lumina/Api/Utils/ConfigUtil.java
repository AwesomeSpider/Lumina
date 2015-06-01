package awesomespider.lumina.Api.Utils;

import awesomespider.lumina.Lumina;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.IOException;

/**
 * Created by Awesome_Spider on 4/17/2015.
 */
public class ConfigUtil {
    public static Configuration config;

    public static final String CATEGORY_ESSENTIA = "essentia";

    public static boolean exceptEssentiaFromAllOtherMods;
    public static boolean essentiaWhitelist;
    public static String[] essentiaWhitelistedMods;
    public static boolean essentiaBlacklist;
    public static String[] essentiaBlacklistedMods;

    public static final String CATEGORY_MISC = "miscellaneous";

    public static boolean sendNewVersion;

    /**
     * Initalizes the config. It also loads it for you. Invoke in the preinit method.
     * @throws IOException
     */
    public static void initialize() throws IOException {
        if (Lumina.configFile.exists()){
            config = new Configuration(Lumina.configFile);
            config.load();
        } else {
            Lumina.log.info(Lumina.LOGPREFIX + " Config Directory/File Doesn't Exist. Creating...");
            Lumina.dataFolder.mkdirs();
            Lumina.configFile.createNewFile();

            config = new Configuration(Lumina.configFile);
            config.load();

            Lumina.log.info(Lumina.LOGPREFIX + " Setting The Config's Default Values.");
            setDefaultValues();
            config.save();
        }

        exceptEssentiaFromAllOtherMods = getValue(CATEGORY_ESSENTIA, "exceptEssentiaEntriesFromAllOtherMods", true);
        essentiaWhitelist = getValue(CATEGORY_ESSENTIA, "essentiaWhitelist", false);
        essentiaWhitelistedMods = getValue(CATEGORY_ESSENTIA, "essentiaWhitelistedMods", new String[]{
                "lumina",
                "minecraft"
        });
        essentiaWhitelist = getValue(CATEGORY_ESSENTIA, "essentiaBlacklist", false);
        essentiaWhitelistedMods = getValue(CATEGORY_ESSENTIA, "essentiaBlacklistedMods", new String[]{});

        sendNewVersion = getValue(CATEGORY_MISC, "sendNewUpdate", true);
    }

    /**
     * Sets the default values for the whole config.
     */
    public static void setDefaultValues(){
        //Essentia
        config.get("essentia", "exceptEssentiaEntriesFromAllOtherMods", true, "If you are making a modpack and don't want items from other mods making essentia, " +
                "turn this to false, otherwise leave it the way it is. " +
                "If you turn this off you can white list or black list mods from this feature, " +
                "see essentiaWhitelist (and essentiaWhitelistedMods) or essentiaBlacklist (and essentiaBlacklistedMods)," +
                "or, if you do not want any mods using this feature, you can turn it to false and leave the previously said values to their defaults.");
        config.get("essentia", "essentiaWhitelist", false, "If you are making a modpack and have the above value set to false, " +
                "you can set this to true and use the list below to whitelist certain mods to be able to " +
                "use their items to make essentia. You can blacklist mods also, but don't have whitelisting and blacklisting on at the same time. " +
                "It will cause BAD times. :)");
        config.get("essentia", "essentiaWhitelistedMods", new String[]{
                "lumina",
                "minecraft"
        }, "Some modids to whitelist, essentiaWhitelist must be on.");
        config.get("essentia", "essentiaBlacklist", false, "If you are making a modpack and have the above value set to false, " +
                "you can set this to true and use the list below to blacklist certain mods to not be able to " +
                "use their items to make essentia. You can whitelist mods also, but don't have whitelisting and blacklisting on at the same time. " +
                "It will cause BAD times. :)");
        config.get("essentia", "essentiaBlacklistedMods", new String[]{

        }, "Some modids to blacklist, essentiaBlacklist must be on.");

        config.get(CATEGORY_MISC, "sendNewUpdate", true, "If you would like to turn the version checker off, turn this to false. " +
                "The version checker checks for a new version of the mod, then if there is a new version it notifies each player that logs in.");
    }

    /**
     * Gets the specifyed boolean value.
     * @param key  The key to get the value of.
     * @param defaultValue - The key's default value.
     */
    public static boolean getValue(String category, String key, boolean defaultValue){
        Property property = config.get(category, key, defaultValue);

        if (property.isBooleanValue()){
            return property.getBoolean();
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " Warning! The config value for key " + key + " is not a boolean. Returning false. Things my not work properly.");
            return false;
        }
    }

    /**
     * Gets the specifyed int value.
     * @param key  The key to get the value of.
     * @param defaultValue - The key's default value.
     */
    public static int getValue(String category, String key, int defaultValue){
        Property property = config.get(category, key, defaultValue);

        if (property.isIntValue()){
            return property.getInt();
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " Warning! The config value for key " + key + " is not an int. Returning 0. Things my not work properly.");
            return 0;
        }
    }

    /**
     * Gets the specifyed double value.
     * @param key  The key to get the value of.
     * @param defaultValue - The key's default value.
     */
    public static double getValue(String category, String key, double defaultValue){
        Property property = config.get(category, key, defaultValue);

        if (property.isDoubleValue()){
            return property.getDouble();
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " Warning! The config value for key " + key + " is not an double. Returning 0. Things my not work properly.");
            return 0;
        }
    }

    /**
     * Gets the specifyed String value.
     * @param key  The key to get the value of.
     * @param defaultValue - The key's default value.
     */
    public static String getValue(String category, String key, String defaultValue){
        Property property = config.get(category, key, defaultValue);

        if (property.getType() == Property.Type.STRING){
            return property.getString();
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " Warning! The config value for key " + key + " is not an String. Returning null. Things my not work properly.");
            return null;
        }
    }

    /**
     * Gets the specifyed String array value.
     * @param key  The key to get the value of.
     * @param defaultValue - The key's default value.
     */
    public static String[] getValue(String category, String key, String[] defaultValue){
        Property property = config.get(category, key, defaultValue);

        if (property.getType() == Property.Type.STRING){
            return property.getStringList();
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " Warning! The config value for key " + key + " is not an String. Returning null. Things my not work properly.");
            return null;
        }
    }

    /**
     * Sets the specifyed boolean value.
     * @return The ConfigUtil for ease of use.
     */
    public ConfigUtil setValue(String key, boolean defaultValue, boolean newValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

        if (property.isBooleanValue()){
            property.set(newValue);
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " The specifyed key (" + key + ") did not contain a boolean value. Therefor, it could not be set to one.");
        }

        return this;
    }

    /**
     * Sets the specifyed int value.
     * @return The ConfigUtil for ease of use.
     */
    public ConfigUtil setValue(String key, int defaultValue, int newValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

        if (property.isIntValue()){
            property.set(newValue);
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " The specifyed key (" + key + ") did not contain a int value. Therefor, it could not be set to one.");
        }

        return this;
    }

    /**
     * Sets the specifyed double value.
     * @return The ConfigUtil for ease of use.
     */
    public ConfigUtil setValue(String key, double defaultValue, double newValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

        if (property.isDoubleValue()){
            property.set(newValue);
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " The specifyed key (" + key + ") did not contain a double value. Therefor, it could not be set to one.");
        }

        return this;
    }

    /**
     * Sets the specifyed String value.
     * @return The ConfigUtil for ease of use.
     */
    public ConfigUtil setValue(String key, String defaultValue, String newValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

        if (property.getType() == Property.Type.STRING){
            property.set(newValue);
        } else {
            Lumina.log.warn(Lumina.LOGPREFIX + " The specifyed key (" + key + ") did not contain a String value. Therefor, it could not be set to one.");
        }

        return this;
    }
}
