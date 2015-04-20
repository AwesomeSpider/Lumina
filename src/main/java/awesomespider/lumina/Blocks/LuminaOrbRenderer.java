package awesomespider.lumina.Blocks;

import awesomespider.lumina.Lumina;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * Created by Wyatt on 4/17/2015.
 */
public class LuminaOrbRenderer extends TileEntitySpecialRenderer {
    ResourceLocation texture;
    ResourceLocation objModelLocation;
    IModelCustom model;

    public LuminaOrbRenderer(){
        texture = new ResourceLocation(Lumina.MODID, "models/LuminaOrbTexture.png");
        objModelLocation = new ResourceLocation(Lumina.MODID, "models/LuminaOrb.obj");
        model = AdvancedModelLoader.loadModel(objModelLocation);
    }

    @Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
        TileEntityLuminaOrb orb = (TileEntityLuminaOrb) te;
        float scale = 1F;
        float rotation = orb.rotation + (timeSinceLastTick / 2F);

        bindTexture(texture);

        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(rotation, 0F, 1F, 0.5F);
        model.renderAll();
        GL11.glPopMatrix();
    }
}
