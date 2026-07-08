/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.particle.SimpleParticleType
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.RegistryKeys;

public class ModParticles {
    public static Supplier<SimpleParticleType> COPPER_FIRE_FLAME;

    public static void register() {
        Constants.LOG.info("Registering particles for {}", "Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_FIRE_FLAME = helper.registerAuto(RegistryKeys.PARTICLE_TYPE, "copper_fire_flame", () -> new SimpleParticleType(false){});
    }
}

