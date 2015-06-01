package awesomespider.lumina.Fluids;

import net.minecraftforge.fluids.Fluid;

/**
 * Created by Awesome_Spider on 5/11/2015.
 */
public class LiquidLight extends Fluid {
    public LiquidLight(String fluidName) {
        super(fluidName);

        this.setLuminosity(3);
        this.setViscosity(1000);
        this.setDensity(750);
        this.setTemperature(275);
    }
}
