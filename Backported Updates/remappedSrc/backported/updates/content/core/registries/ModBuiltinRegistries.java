/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.content.core.registries;

import backported.updates.content.common.api.wolf.WolfSoundVariant;
import backported.updates.content.common.level.entities.animal.CatDataVariant;
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.common.level.entities.animal.CowVariant;
import backported.updates.content.common.level.entities.animal.FrogDataVariant;
import backported.updates.content.common.level.entities.animal.PigVariant;
import backported.updates.content.common.level.entities.animal.WolfDataVariant;
import backported.updates.content.core.registries.ModRegistries;
import backported.updates.foundation.core.BuiltInCoreRegistry;

public class ModBuiltinRegistries {
    public static final BuiltInCoreRegistry<WolfSoundVariant> WOLF_SOUND_VARIANTS = new BuiltInCoreRegistry<WolfSoundVariant>(ModRegistries.WOLF_SOUND_VARIANT.get(), "minecraft");
    public static final BuiltInCoreRegistry<CowVariant> COW_VARIANTS = new BuiltInCoreRegistry<CowVariant>(ModRegistries.COW_VARIANT.get(), "minecraft");
    public static final BuiltInCoreRegistry<ChickenVariant> CHICKEN_VARIANTS = new BuiltInCoreRegistry<ChickenVariant>(ModRegistries.CHICKEN_VARIANT.get(), "minecraft");
    public static final BuiltInCoreRegistry<PigVariant> PIG_VARIANTS = new BuiltInCoreRegistry<PigVariant>(ModRegistries.PIG_VARIANT.get(), "minecraft");
    public static final BuiltInCoreRegistry<FrogDataVariant> FROG_VARIANTS = new BuiltInCoreRegistry<FrogDataVariant>(ModRegistries.FROG_VARIANT.get(), "minecraft");
    public static final BuiltInCoreRegistry<WolfDataVariant> WOLF_VARIANTS = new BuiltInCoreRegistry<WolfDataVariant>(ModRegistries.WOLF_VARIANT.get(), "minecraft");
    public static final BuiltInCoreRegistry<CatDataVariant> CAT_VARIANTS = new BuiltInCoreRegistry<CatDataVariant>(ModRegistries.CAT_VARIANT.get(), "minecraft");
}

