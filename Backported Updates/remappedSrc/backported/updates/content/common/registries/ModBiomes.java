/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_5321
 *  net.minecraft.class_6796
 *  net.minecraft.class_7871
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.worldgen.biomes.TheGardenAwakensBiomes;
import backported.updates.foundation.common.worldgen.WorldGenRegistry;
import net.minecraft.class_1959;
import net.minecraft.class_5321;
import net.minecraft.class_6796;
import net.minecraft.class_7871;
import net.minecraft.class_7891;
import net.minecraft.class_7924;

public class ModBiomes {
    public static final WorldGenRegistry<class_1959> BIOMES = WorldGenRegistry.of(class_7924.field_41236, "minecraft");
    public static final class_5321<class_1959> PALE_GARDEN = BIOMES.create("pale_garden");

    public static void bootstrap(class_7891<class_1959> context) {
        class_7871 features = context.method_46799(class_7924.field_41245);
        class_7871 carvers = context.method_46799(class_7924.field_41238);
        context.method_46838(PALE_GARDEN, (Object)TheGardenAwakensBiomes.paleGarden((class_7871<class_6796>)features, carvers));
    }
}

