/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EntityType$Builder
 *  net.minecraft.entity.SpawnGroup
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryKeys;

public class ModEntities {
    public static Supplier<EntityType<CopperGolemEntity>> COPPER_GOLEM;

    public static void register() {
        Constants.LOG.info("Registering entities for {}", "Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_GOLEM = helper.registerAuto(RegistryKeys.ENTITY_TYPE, "copper_golem", () -> EntityType.Builder.create(CopperGolemEntity::new, (SpawnGroup)SpawnGroup.MISC).dimensions(0.49f, 0.98f).eyeHeight(0.8125f).maxTrackingRange(10).build("copper_golem"));
    }
}

