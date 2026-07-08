/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1767
 *  net.minecraft.class_1937
 *  net.minecraft.class_1959
 *  net.minecraft.class_2338
 *  net.minecraft.class_5819
 *  net.minecraft.class_6005
 *  net.minecraft.class_6005$class_6006
 *  net.minecraft.class_6880
 */
package backported.updates.content.common.level.entities.animal;

import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBiomeTags;
import net.minecraft.class_1767;
import net.minecraft.class_1937;
import net.minecraft.class_1959;
import net.minecraft.class_2338;
import net.minecraft.class_5819;
import net.minecraft.class_6005;
import net.minecraft.class_6880;

public class SheepColorSpawnRules {
    private static final SheepColorSpawnConfiguration TEMPERATE_SPAWN_CONFIGURATION = new SheepColorSpawnConfiguration(SheepColorSpawnRules.weighted((class_6005<SheepColorProvider>)SheepColorSpawnRules.builder().method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7963), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7944), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7967), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7957), 3).method_34975((Object)SheepColorSpawnRules.commonColors(class_1767.field_7952), 82).method_34974()));
    private static final SheepColorSpawnConfiguration WARM_SPAWN_CONFIGURATION = new SheepColorSpawnConfiguration(SheepColorSpawnRules.weighted((class_6005<SheepColorProvider>)SheepColorSpawnRules.builder().method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7944), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7967), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7952), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7963), 3).method_34975((Object)SheepColorSpawnRules.commonColors(class_1767.field_7957), 82).method_34974()));
    private static final SheepColorSpawnConfiguration COLD_SPAWN_CONFIGURATION = new SheepColorSpawnConfiguration(SheepColorSpawnRules.weighted((class_6005<SheepColorProvider>)SheepColorSpawnRules.builder().method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7967), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7944), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7952), 5).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7957), 3).method_34975((Object)SheepColorSpawnRules.commonColors(class_1767.field_7963), 82).method_34974()));

    private static SheepColorProvider commonColors(class_1767 color) {
        return SheepColorSpawnRules.weighted((class_6005<SheepColorProvider>)SheepColorSpawnRules.builder().method_34975((Object)SheepColorSpawnRules.single(color), 499).method_34975((Object)SheepColorSpawnRules.single(class_1767.field_7954), 1).method_34974());
    }

    public static class_1767 getRandomSheepColor(class_1767 original, class_1937 level, class_2338 pos, class_5819 random) {
        if (!VanillaBackport.COMMON_CONFIG.hasFarmAnimalVariants.get().booleanValue()) {
            return original;
        }
        SheepColorSpawnConfiguration config = SheepColorSpawnRules.getSheepColorConfiguration((class_6880<class_1959>)level.method_23753(pos));
        return config.colors().get(random);
    }

    private static SheepColorSpawnConfiguration getSheepColorConfiguration(class_6880<class_1959> biome) {
        if (biome.method_40220(ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS)) {
            return WARM_SPAWN_CONFIGURATION;
        }
        return biome.method_40220(ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS) ? COLD_SPAWN_CONFIGURATION : TEMPERATE_SPAWN_CONFIGURATION;
    }

    private static SheepColorProvider weighted(class_6005<SheepColorProvider> colors) {
        if (colors.method_34993()) {
            throw new IllegalArgumentException("List must be non-empty");
        }
        return random -> ((SheepColorProvider)colors.method_34973(random).orElseThrow(IllegalStateException::new)).get(random);
    }

    private static SheepColorProvider single(class_1767 color) {
        return random -> color;
    }

    private static class_6005.class_6006<SheepColorProvider> builder() {
        return class_6005.method_34971();
    }

    static interface SheepColorProvider {
        public class_1767 get(class_5819 var1);
    }

    record SheepColorSpawnConfiguration(SheepColorProvider colors) {
    }
}

