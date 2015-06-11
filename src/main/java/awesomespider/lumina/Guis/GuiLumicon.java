package awesomespider.lumina.Guis;

import awesomespider.lumina.Api.Utils.TextureUtil;
import awesomespider.lumina.Lumina;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

/**
 * Created by Awesome_Spider on 6/8/2015.
 */
public class GuiLumicon extends GuiScreen{
    int guiWidth = 146;
    int guiHeight = 180;

    int guiLeft;
    int guiTop;

    @Override
    public void initGui(){
        super.initGui();

        guiLeft = (this.width - this.guiWidth) / 2;
        guiTop = (this.height - this.guiHeight) / 2;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float par3){
        TextureUtil.bindTexture(Lumina.MODID, "textures/guis/guiLumicon");
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, guiWidth, guiHeight);
    }
}
