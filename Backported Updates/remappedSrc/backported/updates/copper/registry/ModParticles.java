/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2400
 *  net.minecraft.class_7924
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.class_2400;
import net.minecraft.class_7924;

public class ModParticles {
    public static Supplier<class_2400> COPPER_FIRE_FLAME;

    public static void register() {
        Constants.LOG.info("Registering particles for {}", (Object)"Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_FIRE_FLAME = helper.registerAuto(class_7924.field_41210, "copper_fire_flame", () -> new class_2400(false){});
    }
}

