package awesomespider.lumina.Utils;

import awesomespider.lumina.Lumina;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.IOException;

/**
 * Created by Wyatt on 4/17/2015.
 */
public class ConfigUtil {
    public static Configuration config;

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
            Lumina.dataFolder.mkdir();
            Lumina.configFile.createNewFile();

            config = new Configuration(Lumina.configFile);
            config.load();

            Lumina.log.info(Lumina.LOGPREFIX + " Setting The Config's Default Values.");
            setDefaultValues();
        }
    }

    /**
     * Sets the default values for the whole config.
     */
    public static void setDefaultValues(){
        config.get(Configuration.CATEGORY_GENERAL, "testValue", true, "This is just a test. :)");
    }

    /**
     * Gets the specifyed boolean value.
     * @param key  The key to get the value of.
     * @param defaultValue - The key's default value.
     */
    public static boolean getValue(String key, boolean defaultValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

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
    public static int getValue(String key, int defaultValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

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
    public static double getValue(String key, double defaultValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

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
    public static String getValue(String key, String defaultValue){
        Property property = config.get(Configuration.CATEGORY_GENERAL, key, defaultValue);

        if (property.getType() == Property.Type.STRING){
            return property.getString();
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
