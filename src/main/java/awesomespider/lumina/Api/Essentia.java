package awesomespider.lumina.Api;

/**
 * Created by Wyatt on 5/10/2015.
 */
public class Essentia {
    public enum Elements{
        //Primary Elements
        //Main Elements
        FIRE,
        WATER,
        EARTH,
        AIR,

        KNOWLEDGE,
        ENDER, //?
        XP, //?

        //Secondary Elements
        PLANT, //Water + Earth
        LIFE, //Water + Fire?
        SPECTRAL, //Life + Fire? TODO Find better component for these
        ORE, //Earth + Fire?
        UNDEFINED
    }

    public Elements type;
    public int mb;

    public Elements type2;
    public int mb2;

    public Essentia(Elements essentiaType, int amountMb){
        type = essentiaType;
        mb = amountMb;
    }

    public Essentia(Elements essentiaType, int amountMb, Elements secondaryEssentiaType, int secondaryAmountMb){
        type = essentiaType;
        mb = amountMb;

        type2 = secondaryEssentiaType;
        mb2 = secondaryAmountMb;
    }
}
