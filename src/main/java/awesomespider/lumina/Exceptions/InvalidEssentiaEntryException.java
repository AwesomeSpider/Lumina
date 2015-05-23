package awesomespider.lumina.Exceptions;

/**
 * Created by Wyatt on 5/17/2015.
 */
public class InvalidEssentiaEntryException extends Exception {
    public InvalidEssentiaEntryException(String modid){
        super("An external mod (" + modid + ") attempted to remove a non-existant essentia entry." +
                "Go to Lumina's minecraftforum page and look for the instructions provided for the following error code. " +
                "Error code : IEEEx02 Good luck :)");
    }
}
