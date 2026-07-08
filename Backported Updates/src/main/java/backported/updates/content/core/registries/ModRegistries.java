/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.registry.Registry
 *  net.minecraft.registry.RegistryKey
 */
package backported.updates.content.core.registries;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.wolf.WolfSoundVariant;
import backported.updates.content.common.level.entities.animal.CatDataVariant;
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.common.level.entities.animal.CowVariant;
import backported.updates.content.common.level.entities.animal.FrogDataVariant;
import backported.updates.content.common.level.entities.animal.PigVariant;
import backported.updates.content.common.level.entities.animal.WolfDataVariant;
import backported.updates.foundation.core.RegistryBuilder;
import com.mojang.serialization.MapCodec;
import java.util.function.Supplier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;

public class ModRegistries {
    public static final RegistryBuilder BUILDER = RegistryBuilder.create("backported_updates");
    public static final RegistryBuilder INTERNAL = RegistryBuilder.create("backported_updates");
    public static final RegistryKey<Registry<WolfSoundVariant>> WOLF_SOUND_VARIANT_KEY = BUILDER.resource("wolf_sound_variant");
    public static final Supplier<Registry<WolfSoundVariant>> WOLF_SOUND_VARIANT = BUILDER.registry(WOLF_SOUND_VARIANT_KEY);
    public static final RegistryKey<Registry<CowVariant>> COW_VARIANT_KEY = BUILDER.resource("cow_variant");
    public static final Supplier<Registry<CowVariant>> COW_VARIANT = BUILDER.registry(COW_VARIANT_KEY);
    public static final RegistryKey<Registry<ChickenVariant>> CHICKEN_VARIANT_KEY = BUILDER.resource("chicken_variant");
    public static final Supplier<Registry<ChickenVariant>> CHICKEN_VARIANT = BUILDER.registry(CHICKEN_VARIANT_KEY);
    public static final RegistryKey<Registry<PigVariant>> PIG_VARIANT_KEY = BUILDER.resource("pig_variant");
    public static final Supplier<Registry<PigVariant>> PIG_VARIANT = BUILDER.registry(PIG_VARIANT_KEY);
    public static final RegistryKey<Registry<FrogDataVariant>> FROG_VARIANT_KEY = INTERNAL.resource("frog_variant");
    public static final Supplier<Registry<FrogDataVariant>> FROG_VARIANT = INTERNAL.registry(FROG_VARIANT_KEY);
    public static final RegistryKey<Registry<WolfDataVariant>> WOLF_VARIANT_KEY = INTERNAL.resource("wolf_variant");
    public static final Supplier<Registry<WolfDataVariant>> WOLF_VARIANT = INTERNAL.registry(WOLF_VARIANT_KEY);
    public static final RegistryKey<Registry<CatDataVariant>> CAT_VARIANT_KEY = INTERNAL.resource("cat_variant");
    public static final Supplier<Registry<CatDataVariant>> CAT_VARIANT = INTERNAL.registry(CAT_VARIANT_KEY);
    public static final RegistryKey<Registry<MapCodec<? extends SpawnCondition>>> SPAWN_CONDITION_TYPE_KEY = BUILDER.resource("spawn_condition_type");
    public static final Supplier<Registry<MapCodec<? extends SpawnCondition>>> SPAWN_CONDITION_TYPE = BUILDER.registry(SPAWN_CONDITION_TYPE_KEY);
}

