/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 */
package backported.updates.content.common.api.variant.spawn;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.check.BiomeCheck;
import backported.updates.content.common.api.variant.spawn.check.MoonBrightnessCheck;
import backported.updates.content.common.api.variant.spawn.check.StructureCheck;
import backported.updates.content.common.api.variant.spawn.check.raw.RawBiomeCheck;
import backported.updates.content.common.api.variant.spawn.check.raw.RawStructureCheck;
import backported.updates.content.core.registries.ModRegistries;
import backported.updates.foundation.core.CoreRegistry;
import com.mojang.serialization.MapCodec;
import java.util.function.Supplier;

public class SpawnConditions {
    public static final CoreRegistry<MapCodec<? extends SpawnCondition>> CONDITIONS = CoreRegistry.create(ModRegistries.SPAWN_CONDITION_TYPE.get(), "minecraft");
    public static final Supplier<MapCodec<? extends SpawnCondition>> STRUCTURE = CONDITIONS.register("structure", () -> StructureCheck.CODEC);
    public static final Supplier<MapCodec<? extends SpawnCondition>> MOON_BRIGHTNESS = CONDITIONS.register("moon_brightness", () -> MoonBrightnessCheck.CODEC);
    public static final Supplier<MapCodec<? extends SpawnCondition>> BIOME = CONDITIONS.register("biome", () -> BiomeCheck.CODEC);
    public static final Supplier<MapCodec<? extends SpawnCondition>> RAW_BIOME = CONDITIONS.register("raw_biome", () -> RawBiomeCheck.CODEC);
    public static final Supplier<MapCodec<? extends SpawnCondition>> RAW_STRUCTURE = CONDITIONS.register("raw_structure", () -> RawStructureCheck.CODEC);
}

