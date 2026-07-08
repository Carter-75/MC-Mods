/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1299$class_1300
 *  net.minecraft.class_1311
 *  net.minecraft.class_7924
 */
package backported.updates.copper.registry;

import backported.updates.copper.Constants;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_7924;

public class ModEntities {
    public static Supplier<class_1299<CopperGolemEntity>> COPPER_GOLEM;

    public static void register() {
        Constants.LOG.info("Registering entities for {}", (Object)"Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_GOLEM = helper.registerAuto(class_7924.field_41266, "copper_golem", () -> class_1299.class_1300.method_5903(CopperGolemEntity::new, (class_1311)class_1311.field_17715).method_17687(0.49f, 0.98f).method_55687(0.8125f).method_27299(10).method_5905("copper_golem"));
    }
}

