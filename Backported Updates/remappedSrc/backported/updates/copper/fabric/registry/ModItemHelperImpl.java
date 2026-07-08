/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1826
 *  net.minecraft.class_2248
 */
package backported.updates.copper.fabric.registry;

import backported.updates.copper.fabric.item.Copper3DBlockItem;
import backported.updates.copper.registry.ModEntities;
import backported.updates.copper.registry.ModItemHelper;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1826;
import net.minecraft.class_2248;

public class ModItemHelperImpl
implements ModItemHelper {
    private static final int PRIMARY_COPPER = 12088115;
    private static final int SECONDARY_OXIDIZED = 4772300;

    @Override
    public class_1792 createSpawnEgg() {
        return new class_1826(ModEntities.COPPER_GOLEM.get(), 12088115, 4772300, new class_1792.class_1793());
    }

    @Override
    public class_1747 create3DBlockItem(class_2248 block, class_1792.class_1793 properties) {
        return new Copper3DBlockItem(block, properties);
    }
}

