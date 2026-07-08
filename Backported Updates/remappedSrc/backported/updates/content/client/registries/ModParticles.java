/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2394
 *  net.minecraft.class_2396
 *  net.minecraft.class_2400
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2675
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_9381
 */
package backported.updates.content.client.registries;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.foundation.core.helper.ParticleRegistry;
import java.util.function.Supplier;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2400;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2675;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_9381;

public class ModParticles {
    public static final ParticleRegistry PARTICLES = ParticleRegistry.create("minecraft");
    public static final Supplier<class_2400> PALE_OAK_LEAVES = PARTICLES.register("pale_oak_leaves", false);
    public static final Supplier<class_2396<TrailParticleOption>> TRAIL = PARTICLES.register("trail", false, particle -> TrailParticleOption.CODEC, particle -> TrailParticleOption.STREAM_CODEC);
    public static final Supplier<class_2400> FIREFLY = PARTICLES.register("firefly", false);
    public static final Supplier<class_2396<class_9381>> TINTED_LEAVES = PARTICLES.register("tinted_leaves", false, class_9381::method_58254, class_9381::method_58261);
    public static final Supplier<class_2396<class_9381>> TINTED_NEEDLES = PARTICLES.register("tinted_needles", false, class_9381::method_58254, class_9381::method_58261);

    public static <T extends class_2394> int sendParticles(class_3218 level, T particle, double x, double y, double z, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
        return ModParticles.sendParticles(level, particle, false, false, x, y, z, particleCount, xOffset, yOffset, zOffset, speed);
    }

    public static <T extends class_2394> int sendParticles(class_3218 level, T particle, boolean longDistance, boolean overrideLimiter, double x, double y, double z, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
        class_2675 packet = new class_2675(particle, overrideLimiter, x, y, z, (float)xOffset, (float)yOffset, (float)zOffset, (float)speed, particleCount);
        int sent = 0;
        for (int i = 0; i < level.method_18456().size(); ++i) {
            class_3222 player = (class_3222)level.method_18456().get(i);
            if (!ModParticles.sendParticles(level, player, longDistance, x, y, z, packet)) continue;
            ++sent;
        }
        return sent;
    }

    public static <T extends class_2394> boolean sendParticles(class_3218 level, class_3222 player, T particle, boolean longDistance, boolean overrideLimiter, double x, double y, double z, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
        class_2675 packet = new class_2675(particle, overrideLimiter, x, y, z, (float)xOffset, (float)yOffset, (float)zOffset, (float)speed, particleCount);
        return ModParticles.sendParticles(level, player, longDistance, x, y, z, packet);
    }

    private static boolean sendParticles(class_3218 level, class_3222 player, boolean longDistance, double x, double y, double z, class_2596<?> packet) {
        if (player.method_37908() != level) {
            return false;
        }
        class_2338 pos = player.method_24515();
        if (pos.method_19769((class_2374)new class_243(x, y, z), longDistance ? 512.0 : 32.0)) {
            player.field_13987.method_14364(packet);
            return true;
        }
        return false;
    }
}

