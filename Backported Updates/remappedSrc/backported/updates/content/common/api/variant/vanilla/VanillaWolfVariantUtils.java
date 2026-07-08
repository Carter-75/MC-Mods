/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1493
 *  net.minecraft.class_2338
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  net.minecraft.class_6880
 *  net.minecraft.class_9346
 */
package backported.updates.content.common.api.variant.vanilla;

import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.api.variant.vanilla.VanillaWolfVariantRegistry;
import java.util.Optional;
import net.minecraft.class_1493;
import net.minecraft.class_2338;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import net.minecraft.class_6880;
import net.minecraft.class_9346;

public final class VanillaWolfVariantUtils {
    private VanillaWolfVariantUtils() {
    }

    public static Optional<class_6880<class_9346>> selectVariantForSpawn(class_5425 level, class_2338 pos) {
        SpawnContext context = SpawnContext.create(level, pos);
        return VanillaWolfVariantRegistry.selectVariantForSpawn(context, level.method_8409());
    }

    public static Optional<class_6880<class_9346>> selectVariantForSpawn(SpawnContext context, class_5819 random) {
        return VanillaWolfVariantRegistry.selectVariantForSpawn(context, random);
    }

    public static void applyVariantToWolf(class_1493 wolf, class_6880<class_9346> variant) {
        wolf.method_58063(variant);
    }

    public static boolean selectAndApplyVariant(class_1493 wolf, class_5425 level, class_2338 pos) {
        Optional<class_6880<class_9346>> variant = VanillaWolfVariantUtils.selectVariantForSpawn(level, pos);
        variant.ifPresent(v -> VanillaWolfVariantUtils.applyVariantToWolf(wolf, (class_6880<class_9346>)v));
        return variant.isPresent();
    }

    public static class_6880<class_9346> selectOffspringVariant(class_1493 parent1, class_1493 parent2, class_5819 random) {
        return random.method_43056() ? parent1.method_58062() : parent2.method_58062();
    }
}

