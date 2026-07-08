/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Position
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleType
 *  net.minecraft.particle.SimpleParticleType
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.packet.s2c.play.ParticleS2CPacket
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.server.network.ServerPlayerEntity
 *  net.minecraft.particle.EntityEffectParticleEffect
 */
package backported.updates.content.client.registries;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.foundation.core.helper.ParticleRegistry;
import java.util.function.Supplier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.ParticleS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.particle.EntityEffectParticleEffect;

public class ModParticles {
    public static final ParticleRegistry PARTICLES = ParticleRegistry.create("backported_updates");
    public static final Supplier<SimpleParticleType> PALE_OAK_LEAVES = PARTICLES.register("pale_oak_leaves", false);
    public static final Supplier<ParticleType<TrailParticleOption>> TRAIL = PARTICLES.register("trail", false, particle -> TrailParticleOption.CODEC, particle -> TrailParticleOption.STREAM_CODEC);
    public static final Supplier<SimpleParticleType> FIREFLY = PARTICLES.register("firefly", false);
    public static final Supplier<ParticleType<EntityEffectParticleEffect>> TINTED_LEAVES = PARTICLES.register("tinted_leaves", false, EntityEffectParticleEffect::createCodec, EntityEffectParticleEffect::createPacketCodec);
    public static final Supplier<ParticleType<EntityEffectParticleEffect>> TINTED_NEEDLES = PARTICLES.register("tinted_needles", false, EntityEffectParticleEffect::createCodec, EntityEffectParticleEffect::createPacketCodec);

    public static <T extends ParticleEffect> int sendParticles(ServerWorld level, T particle, double x, double y, double z, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
        return ModParticles.sendParticles(level, particle, false, false, x, y, z, particleCount, xOffset, yOffset, zOffset, speed);
    }

    public static <T extends ParticleEffect> int sendParticles(ServerWorld level, T particle, boolean longDistance, boolean overrideLimiter, double x, double y, double z, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
        ParticleS2CPacket packet = new ParticleS2CPacket(particle, overrideLimiter, x, y, z, (float)xOffset, (float)yOffset, (float)zOffset, (float)speed, particleCount);
        int sent = 0;
        for (int i = 0; i < level.getPlayers().size(); ++i) {
            ServerPlayerEntity player = (ServerPlayerEntity)level.getPlayers().get(i);
            if (!ModParticles.sendParticles(level, player, longDistance, x, y, z, packet)) continue;
            ++sent;
        }
        return sent;
    }

    public static <T extends ParticleEffect> boolean sendParticles(ServerWorld level, ServerPlayerEntity player, T particle, boolean longDistance, boolean overrideLimiter, double x, double y, double z, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
        ParticleS2CPacket packet = new ParticleS2CPacket(particle, overrideLimiter, x, y, z, (float)xOffset, (float)yOffset, (float)zOffset, (float)speed, particleCount);
        return ModParticles.sendParticles(level, player, longDistance, x, y, z, packet);
    }

    private static boolean sendParticles(ServerWorld level, ServerPlayerEntity player, boolean longDistance, double x, double y, double z, Packet<?> packet) {
        if (player.getWorld() != level) {
            return false;
        }
        BlockPos pos = player.getBlockPos();
        if (pos.isWithinDistance((Position)new Vec3d(x, y, z), longDistance ? 512.0 : 32.0)) {
            player.networkHandler.sendPacket(packet);
            return true;
        }
        return false;
    }
}

