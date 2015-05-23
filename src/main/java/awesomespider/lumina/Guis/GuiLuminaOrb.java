package awesomespider.lumina.Guis;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

/**
 * Created by Wyatt on 4/24/2015.
 */
public class GuiLuminaOrb extends GuiScreen {
    enum State {
        NONE,
        MAIN_MENU,
        TECH,
        MAGIC
    }

    State currentState;

    @Override
    public void initGui(){
        GuiButton techButton = new GuiButton(1, 1, 1, "Technology");
        GuiButton magicButton = new GuiButton(2, 100, 1, "Magic");

        buttonList.add(1, techButton);
        buttonList.add(2, magicButton);

        currentState = State.MAIN_MENU;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float par3){
        if (currentState == State.MAIN_MENU){
            clearRemnants();
            GuiButton button = (GuiButton) buttonList.get(1);
            button.visible = true;
            button = (GuiButton) buttonList.get(2);
            button.visible = true;
        }
    }

    public void clearRemnants(){
        GuiButton button = (GuiButton) buttonList.get(1);
        button.visible = false;
        button = (GuiButton) buttonList.get(2);
        button.visible = false;
    }

    @Override
    public void actionPerformed(GuiButton button){
        if (button.displayString.equals("Technology")){
            currentState = State.TECH;
        } else if (button.displayString.equals("Magic")) {
            currentState = State.MAGIC;
        }
    }
}
