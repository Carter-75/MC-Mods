/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.item.Item
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.listener.ClientPlayPacketListener
 *  net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.network.EntityTrackerEntry
 */
package backported.updates.content.common.level.boat;

import backported.updates.content.common.level.boat.PaleOakBoatBehavior;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.common.registries.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.block.BlockState;
import net.minecraft.server.network.EntityTrackerEntry;

public class PaleOakBoat
extends BoatEntity
implements PaleOakBoatBehavior {
    public PaleOakBoat(EntityType<? extends PaleOakBoat> entityType, World level) {
        super(entityType, level);
    }

    public PaleOakBoat(World level, double x, double y, double z) {
        this(ModEntities.PALE_OAK_BOAT.get(), level);
        this.setPosition(x, y, z);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    public Item asItem() {
        return ModItems.PALE_OAK_BOAT.get();
    }

    protected void fall(double y, boolean onGround, BlockState state, BlockPos pos) {
        this.fall(this, y, onGround);
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entity) {
        return new EntitySpawnS2CPacket((Entity)this, entity);
    }
}

