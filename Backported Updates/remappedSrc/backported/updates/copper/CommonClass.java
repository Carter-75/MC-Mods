/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_5132$class_5133
 */
package backported.updates.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.ModSounds;
import backported.updates.copper.compat.ModCompat;
import backported.updates.copper.compat.modules.FastChestCompat;
import backported.updates.copper.compat.modules.IronChestsCompat;
import backported.updates.copper.compat.modules.SophisticatedStorageCompat;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.item.armor.CopperArmorMaterial;
import backported.updates.copper.platform.Services;
import backported.updates.copper.registry.ModBlockEntities;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.registry.ModEntities;
import backported.updates.copper.registry.ModItems;
import backported.updates.copper.registry.ModParticles;
import net.minecraft.class_5132;

public class CommonClass {
    public static void init() {
        Constants.LOG.info("Initializing {} on {}", (Object)"Copper-Age-Backport", (Object)Services.PLATFORM.getPlatformName());
        ModSounds.register();
        CopperArmorMaterial.init();
        ModMemoryTypes.register();
        ModParticles.register();
        ModBlocks.register();
        ModBlockEntities.register();
        ModEntities.register();
        ModItems.register();
        CommonClass.registerCompatModules();
        ModCompat.init();
        Constants.LOG.info("{} initialized successfully!", (Object)"Copper-Age-Backport");
    }

    public static void registerEntityAttributes() {
        Constants.LOG.info("Registering entity attributes for {}", (Object)"Copper-Age-Backport");
    }

    public static class_5132.class_5133 getCopperGolemAttributes() {
        return CopperGolemEntity.createAttributes();
    }

    private static void registerCompatModules() {
        ModCompat.register("fastchest", FastChestCompat::new);
        ModCompat.register("sophisticatedstorage", SophisticatedStorageCompat::new);
        ModCompat.register("ironchest", IronChestsCompat::new);
    }
}

