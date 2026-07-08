/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.DyeColor
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.util.collection.DataPool
 *  net.minecraft.util.collection.DataPool$Builder
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBiomeTags;
import net.minecraft.util.DyeColor;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.collection.DataPool;
import net.minecraft.registry.entry.RegistryEntry;

public class SheepColorSpawnRules {
    private static final SheepColorSpawnConfiguration TEMPERATE_SPAWN_CONFIGURATION = new SheepColorSpawnConfiguration(SheepColorSpawnRules.weighted((DataPool<SheepColorProvider>)SheepColorSpawnRules.builder().add(SheepColorSpawnRules.single(DyeColor.BLACK), 5).add(SheepColorSpawnRules.single(DyeColor.GRAY), 5).add(SheepColorSpawnRules.single(DyeColor.LIGHT_GRAY), 5).add(SheepColorSpawnRules.single(DyeColor.BROWN), 3).add(SheepColorSpawnRules.commonColors(DyeColor.WHITE), 82).build()));
    private static final SheepColorSpawnConfiguration WARM_SPAWN_CONFIGURATION = new SheepColorSpawnConfiguration(SheepColorSpawnRules.weighted((DataPool<SheepColorProvider>)SheepColorSpawnRules.builder().add(SheepColorSpawnRules.single(DyeColor.GRAY), 5).add(SheepColorSpawnRules.single(DyeColor.LIGHT_GRAY), 5).add(SheepColorSpawnRules.single(DyeColor.WHITE), 5).add(SheepColorSpawnRules.single(DyeColor.BLACK), 3).add(SheepColorSpawnRules.commonColors(DyeColor.BROWN), 82).build()));
    private static final SheepColorSpawnConfiguration COLD_SPAWN_CONFIGURATION = new SheepColorSpawnConfiguration(SheepColorSpawnRules.weighted((DataPool<SheepColorProvider>)SheepColorSpawnRules.builder().add(SheepColorSpawnRules.single(DyeColor.LIGHT_GRAY), 5).add(SheepColorSpawnRules.single(DyeColor.GRAY), 5).add(SheepColorSpawnRules.single(DyeColor.WHITE), 5).add(SheepColorSpawnRules.single(DyeColor.BROWN), 3).add(SheepColorSpawnRules.commonColors(DyeColor.BLACK), 82).build()));

    private static SheepColorProvider commonColors(DyeColor color) {
        return SheepColorSpawnRules.weighted((DataPool<SheepColorProvider>)SheepColorSpawnRules.builder().add(SheepColorSpawnRules.single(color), 499).add(SheepColorSpawnRules.single(DyeColor.PINK), 1).build());
    }

    public static DyeColor getRandomSheepColor(DyeColor original, World level, BlockPos pos, Random random) {
        if (!VanillaBackport.COMMON_CONFIG.hasFarmAnimalVariants.get().booleanValue()) {
            return original;
        }
        SheepColorSpawnConfiguration config = SheepColorSpawnRules.getSheepColorConfiguration((RegistryEntry<Biome>)level.getBiome(pos));
        return config.colors().get(random);
    }

    private static SheepColorSpawnConfiguration getSheepColorConfiguration(RegistryEntry<Biome> biome) {
        if (biome.isIn(ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS)) {
            return WARM_SPAWN_CONFIGURATION;
        }
        return biome.isIn(ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS) ? COLD_SPAWN_CONFIGURATION : TEMPERATE_SPAWN_CONFIGURATION;
    }

    private static SheepColorProvider weighted(DataPool<SheepColorProvider> colors) {
        if (colors.isEmpty()) {
            throw new IllegalArgumentException("List must be non-empty");
        }
        return random -> ((SheepColorProvider)colors.getDataOrEmpty(random).orElseThrow(IllegalStateException::new)).get(random);
    }

    private static SheepColorProvider single(DyeColor color) {
        return random -> color;
    }

    private static DataPool.Builder<SheepColorProvider> builder() {
        return DataPool.builder();
    }

    static interface SheepColorProvider {
        public DyeColor get(Random var1);
    }

    record SheepColorSpawnConfiguration(SheepColorProvider colors) {
    }
}

