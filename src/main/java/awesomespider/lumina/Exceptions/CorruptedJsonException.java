package awesomespider.lumina.Exceptions;

/**
 * Created by Awesome_Spider on 5/18/2015.
 */
public class CorruptedJsonException extends Exception {
    public CorruptedJsonException(String dir){
        super( "The json file " + dir + " is corrupted." +
                "Go to Lumina's minecraftforum page and look for the instructions provided for the following error code. " +
                "Error code : CJEx04 Good luck :)");
    }
}
