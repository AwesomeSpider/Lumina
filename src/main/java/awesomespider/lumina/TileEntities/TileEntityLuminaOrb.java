package awesomespider.lumina.TileEntities;

import awesomespider.lumina.Api.Essentia.Essentia;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Awesome_Spider on 4/17/2015.
 */
public class TileEntityLuminaOrb extends TileEntity {
    public float rotation = 0;

    //New Component System
    public TileEntity[] componentsNorth = {};
    public TileEntity[] componentsEast = {};
    public TileEntity[] componentsSouth = {};
    public TileEntity[] componentsWest = {};

    public TileEntity[] componentsClumpNorthEast = {};
    public TileEntity[] componentsClumpSouthEast = {};
    public TileEntity[] componentsClumpSouthWest = {};
    public TileEntity[] componentsClumpNorthWest = {};

    int timer = 20;

    @Override
    public void updateEntity(){
        if (worldObj.isRemote) rotation += 0.5;

        if (timer != 0){
            timer --;
        } else {
            checkForComponents();

            timer = 20;
        }
    }

    /**
     * Will check for components periodically for the orb to transfer Essentia to or to operate machines. This will be called every second.
     */
    public void checkForComponents(){
        int posX = this.xCoord;
        int posY = this.yCoord;
        int posZ = this.zCoord;

        //First Pass: North
        componentsNorth[0] = worldObj.getTileEntity(posX, posY, posZ - 1);
        componentsNorth[1] = worldObj.getTileEntity(posX, posY, posZ - 3);
        componentsNorth[2] = worldObj.getTileEntity(posX, posY, posZ - 5);

        //Second Pass: East
        componentsEast[0] = worldObj.getTileEntity(posX + 1, posY, posZ);
        componentsEast[1] = worldObj.getTileEntity(posX + 3, posY, posZ);
        componentsEast[2] = worldObj.getTileEntity(posX + 5, posY, posZ);

        //Third Pass: South
        componentsSouth[0] = worldObj.getTileEntity(posX, posY, posZ - 1);
        componentsSouth[1] = worldObj.getTileEntity(posX, posY, posZ - 3);
        componentsSouth[2] = worldObj.getTileEntity(posX, posY, posZ - 5);

        //Forth Pass: West
        componentsWest[0] = worldObj.getTileEntity(posX - 1, posY, posZ);
        componentsWest[1] = worldObj.getTileEntity(posX - 3, posY, posZ);
        componentsWest[2] = worldObj.getTileEntity(posX - 5, posY, posZ);

        //Fifth Pass: Clump North East
        componentsClumpNorthEast[0] = worldObj.getTileEntity(posX + 2, posY, posZ - 4);
        componentsClumpNorthEast[1] = worldObj.getTileEntity(posX + 4, posY, posZ - 4);
        componentsClumpNorthEast[2] = worldObj.getTileEntity(posX + 4, posY, posZ - 2);
        componentsClumpNorthEast[3] = worldObj.getTileEntity(posX + 2, posY, posZ - 2);

        //Sixth Pass: Clump South East
        componentsClumpSouthEast[0] = worldObj.getTileEntity(posX + 2, posY, posZ + 4);
        componentsClumpSouthEast[1] = worldObj.getTileEntity(posX + 4, posY, posZ + 4);
        componentsClumpSouthEast[2] = worldObj.getTileEntity(posX + 4, posY, posZ + 2);
        componentsClumpSouthEast[3] = worldObj.getTileEntity(posX + 2, posY, posZ + 2);

        //Seventh Pass: Clump South West
        componentsClumpSouthWest[0] = worldObj.getTileEntity(posX - 2, posY, posZ + 4);
        componentsClumpSouthWest[1] = worldObj.getTileEntity(posX - 4, posY, posZ + 4);
        componentsClumpSouthWest[2] = worldObj.getTileEntity(posX - 4, posY, posZ + 2);
        componentsClumpSouthWest[3] = worldObj.getTileEntity(posX - 2, posY, posZ + 2);

        //eighth Pass: Clump North West
        componentsClumpNorthWest[0] = worldObj.getTileEntity(posX + 2, posY, posZ + 4);
        componentsClumpNorthWest[1] = worldObj.getTileEntity(posX + 4, posY, posZ + 4);
        componentsClumpNorthWest[2] = worldObj.getTileEntity(posX + 4, posY, posZ + 2);
        componentsClumpNorthWest[3] = worldObj.getTileEntity(posX + 2, posY, posZ + 2);
    }

    /**
     * Checks Essentia and returns a list of the amounts. To be called when needed.
     */
    public List checkEssentia(){
        List result = new ArrayList();

        TileEntityEssentiaStorage te1 = null;
        TileEntityEssentiaStorage te2 = null;
        TileEntityEssentiaStorage te3 = null;
        TileEntityEssentiaStorage te4 = null;

        TileEntityEssentiaStorage te5 = null;
        TileEntityEssentiaStorage te6 = null;
        TileEntityEssentiaStorage te7 = null;
        TileEntityEssentiaStorage te8 = null;

        TileEntityEssentiaStorage te9 = null;
        TileEntityEssentiaStorage te10 = null;
        TileEntityEssentiaStorage te11 = null;
        TileEntityEssentiaStorage te12 = null;

        TileEntityEssentiaStorage te13 = null;
        TileEntityEssentiaStorage te14 = null;
        TileEntityEssentiaStorage te15 = null;
        TileEntityEssentiaStorage te16 = null;

        if (componentsClumpNorthEast[0] instanceof TileEntityEssentiaStorage) te1 = (TileEntityEssentiaStorage) componentsClumpNorthEast[0];
        if (componentsClumpNorthEast[1] instanceof TileEntityEssentiaStorage) te2 = (TileEntityEssentiaStorage) componentsClumpNorthEast[1];
        if (componentsClumpNorthEast[2] instanceof TileEntityEssentiaStorage) te3 = (TileEntityEssentiaStorage) componentsClumpNorthEast[2];
        if (componentsClumpNorthEast[3] instanceof TileEntityEssentiaStorage) te4 = (TileEntityEssentiaStorage) componentsClumpNorthEast[3];

        if (componentsClumpSouthEast[0] instanceof TileEntityEssentiaStorage) te5 = (TileEntityEssentiaStorage) componentsClumpSouthEast[0];
        if (componentsClumpSouthEast[1] instanceof TileEntityEssentiaStorage) te6 = (TileEntityEssentiaStorage) componentsClumpSouthEast[1];
        if (componentsClumpSouthEast[2] instanceof TileEntityEssentiaStorage) te7 = (TileEntityEssentiaStorage) componentsClumpSouthEast[2];
        if (componentsClumpSouthEast[3] instanceof TileEntityEssentiaStorage) te8 = (TileEntityEssentiaStorage) componentsClumpSouthEast[3];

        if (componentsClumpSouthWest[0] instanceof TileEntityEssentiaStorage) te9  = (TileEntityEssentiaStorage) componentsClumpSouthWest[0];
        if (componentsClumpSouthWest[1] instanceof TileEntityEssentiaStorage) te10 = (TileEntityEssentiaStorage) componentsClumpSouthWest[1];
        if (componentsClumpSouthWest[2] instanceof TileEntityEssentiaStorage) te11 = (TileEntityEssentiaStorage) componentsClumpSouthWest[2];
        if (componentsClumpSouthWest[3] instanceof TileEntityEssentiaStorage) te12 = (TileEntityEssentiaStorage) componentsClumpSouthWest[3];

        if (componentsClumpNorthWest[0] instanceof TileEntityEssentiaStorage) te13 = (TileEntityEssentiaStorage) componentsClumpNorthWest[0];
        if (componentsClumpNorthWest[1] instanceof TileEntityEssentiaStorage) te14 = (TileEntityEssentiaStorage) componentsClumpNorthWest[1];
        if (componentsClumpNorthWest[2] instanceof TileEntityEssentiaStorage) te15 = (TileEntityEssentiaStorage) componentsClumpNorthWest[2];
        if (componentsClumpNorthWest[3] instanceof TileEntityEssentiaStorage) te16 = (TileEntityEssentiaStorage) componentsClumpNorthWest[3];

        if (te1 != null) result.add(new Essentia(te1.essentiaType, te1.essentiaMb));
        if (te2 != null) result.add(new Essentia(te2.essentiaType, te2.essentiaMb));
        if (te3 != null) result.add(new Essentia(te3.essentiaType, te3.essentiaMb));
        if (te4 != null) result.add(new Essentia(te4.essentiaType, te4.essentiaMb));
        if (te5 != null) result.add(new Essentia(te5.essentiaType, te5.essentiaMb));
        if (te6 != null) result.add(new Essentia(te6.essentiaType, te6.essentiaMb));
        if (te7 != null) result.add(new Essentia(te7.essentiaType, te7.essentiaMb));
        if (te8 != null) result.add(new Essentia(te8.essentiaType, te8.essentiaMb));
        if (te9 != null) result.add(new Essentia(te9.essentiaType, te9.essentiaMb));
        if (te10 != null) result.add(new Essentia(te10.essentiaType, te10.essentiaMb));
        if (te11 != null) result.add(new Essentia(te11.essentiaType, te11.essentiaMb));
        if (te12 != null) result.add(new Essentia(te12.essentiaType, te12.essentiaMb));
        if (te13 != null) result.add(new Essentia(te13.essentiaType, te13.essentiaMb));
        if (te14 != null) result.add(new Essentia(te14.essentiaType, te14.essentiaMb));
        if (te15 != null) result.add(new Essentia(te15.essentiaType, te15.essentiaMb));
        if (te16 != null) result.add(new Essentia(te16.essentiaType, te16.essentiaMb));

        return result;
    }
}
