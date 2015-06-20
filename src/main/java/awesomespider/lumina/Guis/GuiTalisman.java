package awesomespider.lumina.Guis;

import awesomespider.lumina.Api.Utils.LangUtil;
import awesomespider.lumina.Api.Utils.TextureUtil;
import awesomespider.lumina.Lumina;
import awesomespider.lumina.TileEntities.TileEntityMasterRitualStone;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.tileentity.TileEntity;

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

    TileEntity te;

    public GuiTalisman(TileEntity te){
        this.te = te;
    }

    @Override
    public void initGui(){
        super.initGui();

        guiLeft = (this.width - this.guiWidth) / 2;
        guiTop = (this.height - this.guiHeight) / 2;

        localizedSpellNames = new String[]{
                LangUtil.tranlate(unlocalizedSpellNames[0])
        };

        buttonList.add(new GuiButton(0, guiLeft + 70 + fontRendererObj.getStringWidth(localizedSpellNames[0]), guiTop + 5, "Draw Glyphs"));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float par3){
        TextureUtil.bindTexture(Lumina.MODID, "textures/guis/guiTalisman_Background1");
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, 64, 64);

        TextureUtil.bindTexture(Lumina.MODID, "textures/guis/guiTalisman_Background2");
        this.drawTexturedModalRect(guiLeft + 64, guiTop, 0, 0, guiWidth, guiHeight);

        this.drawString(this.fontRendererObj, localizedSpellNames[0], guiTop + 10, guiLeft + 70, 255255255);

        GuiButton button1 = (GuiButton) buttonList.get(0);
        button1.visible = true;
    }

    @Override
    public void actionPerformed(GuiButton button) {
        if (button.id == 0){
            TileEntityMasterRitualStone te2 = (TileEntityMasterRitualStone) te;
        }
    }
}
