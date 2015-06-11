package awesomespider.lumina.Api;

import awesomespider.lumina.Api.Utils.ConfigUtil;
import awesomespider.lumina.Lumina;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by Awesome_Spider on 6/1/2015.
 */
public class VersionChecker {
    public static boolean sendNewUpdate = ConfigUtil.sendNewVersion;

    static final String url = "https://raw.githubusercontent.com/AwesomeSpider/Lumina/master/src/main/resources/version.txt";

    static String version;
    static String type;
    static String mainFeature;
    static String link;

    static void checkVersion() throws IOException {
        InputStream in = new URL(url).openStream();

        List<String> lines = IOUtils.readLines(in);

        version = lines.get(0);
        type = lines.get(1);
        mainFeature = lines.get(2);
        link = lines.get(3);
    }

    public static String getVersion(){
        return version;
    }

    public static String getType(){
        return type;
    }

    public static void sendNewVersionToPlayer(EntityPlayer player) throws IOException {
        checkVersion();

        String result;

        if (!Lumina.VERSION.equals(version)){
            result = EnumChatFormatting.AQUA + "Your current Lumina installation is out of date. " +
                    "A new version " + EnumChatFormatting.AQUA + "was found: [" + EnumChatFormatting.BLUE + type + " " + version + EnumChatFormatting.AQUA + "] " +
                    mainFeature + ". You can download this " + EnumChatFormatting.AQUA + "at " + link + ".";

            player.addChatComponentMessage(new ChatComponentText(result));
        }
    }
}
