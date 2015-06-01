package awesomespider.lumina.Api.Utils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awesome_Spider on 4/21/2015.
 */
public class JsonUtil {
    /**
     * Creates the specified Json file.
     * Must have the file extension be ".json" or it will not work.
     * If it exists it will not be created.
     * @param jsonFile - The jsonFile to create.
     * @throws IOException - If the directory that the Json file is in does not exist, this exception will be thrown.
     */
    public static void createJsonFile(File jsonFile) throws IOException {
        if (jsonFile.getAbsolutePath().endsWith(".json")) {//TODO If not throw an exception with an error code
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();

                JsonWriter json = new JsonWriter(new FileWriter(jsonFile));

                json.beginObject();

                json.endObject();

                json.close();
            }
        }
    }

    /**
     * Sets the specified name to the specified value. If the name does not exist, it will be created.
     * @param jsonFile - The json file where the name is to modify.
     * @param name - The name to change the value of.
     * @param value - The value to set.
     * @throws IOException
     */
    public static void setJsonValue(File jsonFile, String name, boolean value) throws IOException {
        JsonWriter json = new JsonWriter(new FileWriter(jsonFile));

        json.setIndent("    ");

        json.beginObject();

        json.name(name).value(value);

        json.endObject();

        json.close();
    }

    /**
     * Sets the specified name to the specified value. If the name does not exist, it will be created.
     * @param jsonFile - The json file where the name is to modify.
     * @param name - The name to change the value of.
     * @param value - The value to set.
     * @throws IOException
     */
    public static void setJsonValue(File jsonFile, String name, double value) throws IOException {
        JsonWriter json = new JsonWriter(new FileWriter(jsonFile));

        json.setIndent("    ");

        json.beginObject();

        json.name(name).value(value);

        json.endObject();

        json.close();
    }

    /**
     * Sets the specified name to the specified value. If the name does not exist, it will be created.
     * @param jsonFile - The json file where the name is to modify.
     * @param name - The name to change the value of.
     * @param value - The value to set.
     * @throws IOException
     */
    public static void setJsonValue(File jsonFile, String name, long value) throws IOException {
        JsonWriter json = new JsonWriter(new FileWriter(jsonFile));

        json.setIndent("    ");

        json.beginObject();

        json.name(name).value(value);

        json.endObject();

        json.close();
    }

    /**
     * Sets the specified name to the specified value. If the name does not exist, it will be created.
     * @param jsonFile - The json file where the name is to modify.
     * @param name - The name to change the value of.
     * @param value - The value to set.
     * @throws IOException
     */
    public static void setJsonValue(File jsonFile, String name, String value) throws IOException {
        JsonWriter json = new JsonWriter(new FileWriter(jsonFile));

        json.setIndent("    ");

        json.beginObject();

        json.name(name).value(value);

        json.endObject();

        json.close();
    }

    /**
     * Sets the specified name to the specified value. If the name does not exist, it will be created.
     * @param jsonFile - The json file where the name is to modify.
     * @param name - The name to change the value of.
     * @param value - The value to set.
     * @throws IOException
     */
    public static void setJsonValue(File jsonFile, String name, int value) throws IOException {
        JsonWriter json = new JsonWriter(new FileWriter(jsonFile));

        json.setIndent("    ");

        json.beginObject();

        json.name(name).value(value);

        json.endObject();

        json.close();
    }

    /**
     * Sets the specified name to the specified value. If the name does not exist, it will be created.
     * @param jsonFile - The json file where the name is to modify.
     * @param name - The name to change the value of.
     * @param value - The value to set.
     * @throws IOException
     */
    public static void setJsonValue(File jsonFile, String name, List<String> value) throws IOException {
        JsonWriter json = new JsonWriter(new FileWriter(jsonFile));

        json.setIndent("    ");

        json.beginObject();

        json.name(name);
        json.beginArray();
        for (String s : value){
            json.value(s);
        }
        json.endArray();

        json.endObject();

        json.close();
    }

    /**
     * Gets the value of the specified name.
     * @param jsonFile - The json file where the value is located.
     * @param name - The name of the value to get.
     * @return The value.
     * @throws IOException
     */
    public static String getJsonStringValue(File jsonFile, String name) throws IOException {
        JsonReader json = new JsonReader(new FileReader(jsonFile));

        String result = null;

        json.beginObject();

        while (json.hasNext()){
            if (json.nextName().equals(name)){
               result = json.nextString();
            }
        }

        json.endObject();

        json.close();

        return result;
    }

    /**
     * Gets the value of the specified name.
     * @param jsonFile - The json file where the value is located.
     * @param name - The name of the value to get.
     * @return The value.
     * @throws IOException
     */
    public static boolean getJsonBooleanValue(File jsonFile, String name) throws IOException {
        JsonReader json = new JsonReader(new FileReader(jsonFile));

        boolean result = false;

        json.beginObject();

        while (json.hasNext()){
            if (json.nextName().equals(name)){
                result = json.nextBoolean();
            }
        }

        json.endObject();

        json.close();

        return result;
    }

    /**
     * Gets the value of the specified name.
     * @param jsonFile - The json file where the value is located.
     * @param name - The name of the value to get.
     * @return The value.
     * @throws IOException
     */
    public static double getJsonDoubleValue(File jsonFile, String name) throws IOException {
        JsonReader json = new JsonReader(new FileReader(jsonFile));

        double result = 0;

        json.beginObject();

        while (json.hasNext()){
            if (json.nextName().equals(name)){
                result = json.nextDouble();
            }
        }

        json.endObject();

        json.close();

        return result;
    }

    /**
     * Gets the value of the specified name.
     * @param jsonFile - The json file where the value is located.
     * @param name - The name of the value to get.
     * @return The value.
     * @throws IOException
     */
    public static int getJsonIntValue(File jsonFile, String name) throws IOException {
        JsonReader json = new JsonReader(new FileReader(jsonFile));

        int result = 0;

        json.beginObject();

        while (json.hasNext()){
            if (json.nextName().equals(name)){
                result = json.nextInt();
            }
        }

        json.endObject();

        json.close();

        return result;
    }

    /**
     * Gets the value of the specified name.
     * @param jsonFile - The json file where the value is located.
     * @param name - The name of the value to get.
     * @return The value.
     * @throws IOException
     */
    public static long getJsonLongValue(File jsonFile, String name) throws IOException {
        JsonReader json = new JsonReader(new FileReader(jsonFile));

        long result = 0;

        json.beginObject();

        while (json.hasNext()){
            if (json.nextName().equals(name)){
                result = json.nextLong();
            }
        }

        json.endObject();

        json.close();

        return result;
    }

    /**
     * Gets the value of the specified name.
     * @param jsonFile - The json file where the value is located.
     * @param name - The name of the value to get.
     * @return The value.
     * @throws IOException
     */
    public static ArrayList<String> getJsonStringListValue(File jsonFile, String name) throws IOException {
        JsonReader json = new JsonReader(new FileReader(jsonFile));

        ArrayList<String> result = new ArrayList<String>();

        json.beginObject();

        if (json.nextName().equals(name)) {
            json.beginArray();
            while (json.hasNext()) {
                result.add(json.nextString());
            }
            json.endArray();
        }

        json.endObject();

        json.close();

        return result;
    }
}
