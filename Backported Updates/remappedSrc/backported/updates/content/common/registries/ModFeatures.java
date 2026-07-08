/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_3031
 *  net.minecraft.class_3111
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.features.CactusFlowerFeature;
import backported.updates.content.common.level.features.FallenTreeConfiguration;
import backported.updates.content.common.level.features.FallenTreeFeature;
import backported.updates.content.common.level.features.LeafLitterFeature;
import backported.updates.foundation.core.CoreRegistry;
import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import net.minecraft.class_3031;
import net.minecraft.class_3111;
import net.minecraft.class_7924;

public class ModFeatures {
    public static final CoreRegistry<class_3031<?>> FEATURES = CoreRegistry.create(class_7924.field_41267, "minecraft");
    public static final Supplier<class_3031<FallenTreeConfiguration>> FALLEN_TREE = FEATURES.register("fallen_tree", () -> new FallenTreeFeature(FallenTreeConfiguration.CODEC));
    public static final Supplier<class_3031<class_3111>> LEAF_LITTER = FEATURES.register("leaf_litter", () -> new LeafLitterFeature((Codec<class_3111>)class_3111.field_24893));
    public static final Supplier<class_3031<class_3111>> CACTUS_FLOWER = FEATURES.register("cactus_flower", () -> new CactusFlowerFeature((Codec<class_3111>)class_3111.field_24893));
}

