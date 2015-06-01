package awesomespider.lumina.Entities;

import net.minecraft.client.audio.SoundList;
import net.minecraft.client.audio.SoundRegistry;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.UUID;

/**
 * Created by Awesome_Spider on 5/15/2015.
 */
public class EntityLuminaCat extends EntityTameable {
    public UUID ownerUUID;

    public EntityLuminaCat(World world, UUID owner) {
        super(world);

        this.setSize(0.6F, 0.8F);
        this.getNavigator().setAvoidsWater(true);
        this.getNavigator().setEnterDoors(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAIFollowOwner(this, 1.0D, 10.0F, 5.0F));
        this.tasks.addTask(4, new EntityAILuminaCatSit(this, 1.33D));
        this.tasks.addTask(5, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(6, new EntityAIOcelotAttack(this));
        this.tasks.addTask(7, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        //this.targetTasks.addTask(1, new EntityAIAttackOnCollide(this, EntityCreeper.class));
//TODO Finish Lumina Cat
        ownerUUID = owner;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable par1) {
        return par1;
    }
}
