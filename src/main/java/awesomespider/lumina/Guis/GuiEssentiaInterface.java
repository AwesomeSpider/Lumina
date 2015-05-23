package awesomespider.lumina.Guis;

import awesomespider.lumina.Api.Essentia;
import awesomespider.lumina.Lumina;
import awesomespider.lumina.TileEntities.TileEntityEssentiaInterface;
import awesomespider.lumina.Utils.TextureUtil;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerBeacon;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Wyatt on 5/7/2015.
 */
public class GuiEssentiaInterface extends GuiScreen {
    int guiWidth = 176;
    int guiHeight = 133;

    int guiLeft;
    int guiTop;

    TileEntity te;

    public GuiEssentiaInterface(TileEntity te){
        this.te = te;//TODO Finish this gui
    }

    @Override
    public void initGui(){
        super.initGui();

        guiLeft = (this.width - this.guiWidth) / 2;
        guiTop = (this.height - this.guiHeight) / 2;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float par3){
        TileEntityEssentiaInterface te2;

        if (te instanceof TileEntityEssentiaInterface) {
            te2 = (TileEntityEssentiaInterface) te;
        } else {
            te2 = null;
        }

        TextureUtil.bindTexture(Lumina.MODID, "textures/guis/guiEssentiaInterface");
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, guiWidth, guiHeight);

        if (!te2.orbLocated) {
            drawString(fontRendererObj, "Searching...", guiLeft + (guiWidth / 2), guiTop + 5, 0x0255255);
        }

        List essentia = te2.luminaOrb.checkEssentia();
        int essentiaListSize = essentia.size();

        int amountWater = 0;
        int amountFire = 0;
        int amountEarth = 0;
        int amountAir = 0;

        for (int i = 0; i == essentiaListSize; i ++){
            Essentia e = (Essentia) essentia.get(i);

            Essentia.Elements element = e.type;

            switch (element){
                case FIRE:
                    amountFire = amountFire + e.mb;
                    break;
                case WATER:
                    amountWater = amountWater + e.mb;
                    break;
                case EARTH:
                    amountEarth = amountEarth + e.mb;
                    break;
                case AIR:
                    amountAir = amountAir + e.mb;
            }
        }

        //TODO Finish this gui. :)
    }
}
