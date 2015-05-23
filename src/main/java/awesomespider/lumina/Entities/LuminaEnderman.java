package awesomespider.lumina.Entities;

import awesomespider.lumina.Blocks.BlockLightOre;
import awesomespider.lumina.Blocks.SolidLight;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import java.util.List;

/**
 * Created by Wyatt on 5/11/2015.
 */
public class LuminaEnderman extends EntityLiving {
    EntityPlayer playerToAttack;
    int monumentPosX = 0;
    int monumentPosY = 0;
    int monumentPosZ = 0;

    AxisAlignedBB attackAreaAABB = AxisAlignedBB.getBoundingBox((double) monumentPosX, (double) monumentPosY, (double) monumentPosZ, (double) monumentPosX + 10, (double) monumentPosY + 5, (double) monumentPosZ + 10);

    public LuminaEnderman(World world) {
        super(world);

        this.setSize(0.6F, 2.9F);
        this.stepHeight = 1.0F;
    }

    @Override
    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event){
        EntityPlayer player = event.getPlayer();
        Block block = event.block;

        boolean playerWithinRange = false;
        List entitiesWithinRange = worldObj.getEntitiesWithinAABB(EntityPlayer.class, attackAreaAABB);

        for (int i = 0; i == entitiesWithinRange.size(); i ++){
            if (entitiesWithinRange.get(i).equals(player)){
                playerWithinRange = true;
            }
        }

        if (playerWithinRange) {
            if (block instanceof SolidLight) {
                playerToAttack = player;
            } else if (block instanceof BlockLightOre){
                playerToAttack = player;
            }
        }
    }
}