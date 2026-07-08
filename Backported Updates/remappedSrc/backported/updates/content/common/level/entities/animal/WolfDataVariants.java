/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.common.api.variant.ClientAsset;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import backported.updates.content.common.api.variant.spawn.check.raw.RawBiomeCheck;
import backported.updates.content.common.level.entities.animal.WolfDataVariant;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;
import net.minecraft.class_1959;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;

public class WolfDataVariants {
    public static final BuiltInCoreRegistry<WolfDataVariant> REGISTRY = ModBuiltinRegistries.WOLF_VARIANTS;

    private static class_5321<WolfDataVariant> register(String key, String assetId, class_6862<class_1959> tag) {
        return WolfDataVariants.register(key, assetId, SpawnPrioritySelectors.single(new RawBiomeCheck(tag), 1));
    }

    private static class_5321<WolfDataVariant> register(String key, String assetId, SpawnPrioritySelectors selectors) {
        class_2960 wild = class_2960.method_60656((String)("entity/wolf/" + assetId));
        class_2960 tame = class_2960.method_60656((String)("entity/wolf/" + assetId + "_tame"));
        class_2960 angry = class_2960.method_60656((String)("entity/wolf/" + assetId + "_angry"));
        return REGISTRY.resource(key, new WolfDataVariant(new WolfDataVariant.AssetInfo(new ClientAsset(wild), new ClientAsset(tame), new ClientAsset(angry)), selectors));
    }
}

