/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_2248
 */
package backported.updates.copper.registry;

import backported.updates.copper.platform.Services;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_2248;

public interface ModItemHelper {
    public class_1792 createSpawnEgg();

    public class_1747 create3DBlockItem(class_2248 var1, class_1792.class_1793 var2);

    public static class_1792 createSpawnEggItem() {
        return Services.ITEM_HELPER.createSpawnEgg();
    }

    public static class_1747 create3DBlockItemForPlatform(class_2248 block, class_1792.class_1793 properties) {
        return Services.ITEM_HELPER.create3DBlockItem(block, properties);
    }
}

