/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.passive.WolfEntity
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.ServerWorldAccess
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.passive.WolfVariant
 */
package backported.updates.content.common.api.variant.vanilla;

import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.api.variant.vanilla.VanillaWolfVariantRegistry;
import java.util.Optional;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.passive.WolfVariant;

public final class VanillaWolfVariantUtils {
    private VanillaWolfVariantUtils() {
    }

    public static Optional<RegistryEntry<WolfVariant>> selectVariantForSpawn(ServerWorldAccess level, BlockPos pos) {
        SpawnContext context = SpawnContext.create(level, pos);
        return VanillaWolfVariantRegistry.selectVariantForSpawn(context, level.getRandom());
    }

    public static Optional<RegistryEntry<WolfVariant>> selectVariantForSpawn(SpawnContext context, Random random) {
        return VanillaWolfVariantRegistry.selectVariantForSpawn(context, random);
    }

    public static void applyVariantToWolf(WolfEntity wolf, RegistryEntry<WolfVariant> variant) {
        wolf.setVariant(variant);
    }

    public static boolean selectAndApplyVariant(WolfEntity wolf, ServerWorldAccess level, BlockPos pos) {
        Optional<RegistryEntry<WolfVariant>> variant = VanillaWolfVariantUtils.selectVariantForSpawn(level, pos);
        variant.ifPresent(v -> VanillaWolfVariantUtils.applyVariantToWolf(wolf, (RegistryEntry<WolfVariant>)v));
        return variant.isPresent();
    }

    public static RegistryEntry<WolfVariant> selectOffspringVariant(WolfEntity parent1, WolfEntity parent2, Random random) {
        return random.nextBoolean() ? parent1.getVariant() : parent2.getVariant();
    }
}

