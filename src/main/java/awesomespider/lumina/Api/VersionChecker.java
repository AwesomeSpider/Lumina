package awesomespider.lumina.Api;

import awesomespider.lumina.Api.Utils.ConfigUtil;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Awesome_Spider on 6/1/2015.
 */
public class VersionChecker {
    public static boolean sendNewUpdate(){
        return ConfigUtil.sendNewVersion;
    }

    static final String[] urls = {
            
    };

    static String version;
    static String mainFeature;
    static String link;

    private void checkVersion() throws IOException {
        InputStream in = new URL("").openStream();

        version = IOUtils.readLines(in).get(0);
        mainFeature = IOUtils.readLines(in).get(1);
        link = IOUtils.readLines(in).get(2);
    }
}
