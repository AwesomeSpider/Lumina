package awesomespider.lumina.Exceptions;

/**
 * Created by Wyatt on 5/17/2015.
 */
public class DuplicateEssentiaEntryException extends Exception{
    public DuplicateEssentiaEntryException(String modid){
        super("An external mod (" + modid + ") has attempted to enter a duplicate essentia entry. " +
                "Go to Lumina's minecraftforum page and look for the instructions provided for the following error code. " +
                "Error code : DEEEx01 Good luck :)");
    }
}
