package awesomespider.lumina.Api.Utils;

/**
 * Created by Awesome_Spider on 4/22/2015.
 */
public class NumberUtil {
    /**
     * Gets the fluid level for display. The number returned is 0-14.
     * @param max - The max possible storage.
     * @param actual - The actual amount of fluid stored.
     * @return - The fluid level for display.
     */
    public static int getFluidLevelForDisplay(int max, int actual){
        int percentage = actual / max * 100;
        int displayLevelMax = 14;
        int displayLevel = 0;

        switch (percentage){
            case 7: displayLevel = 1;
                break;
            case 14: displayLevel = 2;
                break;
            case 21: displayLevel = 3;
                break;
            case 28: displayLevel = 4;
                break;
            case 35: displayLevel = 5;
                break;
            case 42: displayLevel = 6;
                break;
            case 49: displayLevel = 7;
                break;
            case 56: displayLevel = 8;
                break;
            case 63: displayLevel = 9;
                break;
            case 70: displayLevel = 10;
                break;
            case 77: displayLevel = 11;
                break;
            case 84: displayLevel = 12;
                break;
            case 91: displayLevel = 13;
                break;
            case 98: displayLevel = 14;
                break;
            case 100: displayLevel = 14;
                break;
        }

        return displayLevel;
    }
}
