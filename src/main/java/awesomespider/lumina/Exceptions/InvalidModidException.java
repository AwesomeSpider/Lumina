package awesomespider.lumina.Exceptions;

/**
 * Created by Wyatt on 5/17/2015.
 */
public class InvalidModidException extends Exception {
    public InvalidModidException(String modid){
        super("An external mod (" + modid + ") has attempted to delete an EssentiaEntry with a modid that does not have any submitted entries. " +
                "Go to Lumina's minecraftforum page and look for the instructions provided for the following error code. " +
                "Error code : IMEx03 Good luck :)");
    }
}
