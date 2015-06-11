package awesomespider.lumina.Guis;

import awesomespider.lumina.Api.Utils.LangUtil;
import awesomespider.lumina.Api.Utils.TextureUtil;
import awesomespider.lumina.Lumina;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

/**
 * Created by Awesome_Spider on 6/11/2015.
 */
public class GuiTalisman extends GuiScreen {
    int guiWidth = 176;
    int guiHeight = 133;

    int guiLeft;
    int guiTop;

    String[] unlocalizedSpellNames = {
            "ritual.summoning.name"
    };

    String[] localizedSpellNames;

    @Override
    public void initGui(){
        super.initGui();

        guiLeft = (this.width - this.guiWidth) / 2;
        guiTop = (this.height - this.guiHeight) / 2;

        localizedSpellNames = new String[]{
                LangUtil.tranlate(unlocalizedSpellNames[0])
        };

        buttonList.add(new GuiButton(1, guiLeft + 70 + fontRendererObj.getStringWidth(localizedSpellNames[0]), guiTop, "Etch Glyphs"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float par3){
        TextureUtil.bindTexture(Lumina.MODID, "textures/guis/guiTalisman_Background1");
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, 64, 64);

        TextureUtil.bindTexture(Lumina.MODID, "textures/guis/guiTalisman_Background2");
        this.drawTexturedModalRect(guiLeft + 64, guiTop, 0, 0, guiWidth, guiHeight);

        //Finish the talisman gui
    }
}
