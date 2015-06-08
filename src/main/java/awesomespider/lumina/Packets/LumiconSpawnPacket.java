package awesomespider.lumina.Packets;

import awesomespider.lumina.Api.Utils.PlayerUtil;
import awesomespider.lumina.Lumina;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.io.IOException;

/**
 * Created by Awesome_Spider on 6/2/2015.
 *
 * A packet sent from client to server to spawn the lumicon on 'L' key-press. Thanks TheRealMcrafter, FailEnder, and diesieben07 on the
 * minecrftforge.net forums for helping me get the lumicon spawning working.
 */
public class LumiconSpawnPacket implements IMessage {
    double posX;
    double posY;
    double posZ;

    public LumiconSpawnPacket(){}

    public LumiconSpawnPacket(double posX, double posY, double posZ){
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.posX = buf.readDouble();
        this.posY = buf.readDouble();
        this.posZ = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(posX);
        buf.writeDouble(posY);
        buf.writeDouble(posZ);
    }

    public static class Handler implements IMessageHandler<LumiconSpawnPacket, IMessage> {
        @Override
        public IMessage onMessage(LumiconSpawnPacket message, MessageContext ctx) {
            EntityPlayer player = ctx.getServerHandler().playerEntity;
            Lumina.log.info(Lumina.LOGPREFIX + " LuminaSpawnPacket recieved, player " + player.getDisplayName() + " has attempted to summon a lumicon. Spawning...");
            try {
                PlayerUtil.startPlayer(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
