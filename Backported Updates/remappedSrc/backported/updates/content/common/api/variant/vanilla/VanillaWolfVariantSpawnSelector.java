/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_5321
 *  net.minecraft.class_5381
 *  net.minecraft.class_6880
 *  net.minecraft.class_7924
 *  net.minecraft.class_9346
 */
package backported.updates.content.common.api.variant.vanilla;

import backported.updates.content.common.api.variant.spawn.PriorityProvider;
import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import backported.updates.content.common.api.variant.spawn.SpawnPrioritySelectors;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.List;
import net.minecraft.class_5321;
import net.minecraft.class_5381;
import net.minecraft.class_6880;
import net.minecraft.class_7924;
import net.minecraft.class_9346;

public record VanillaWolfVariantSpawnSelector(class_6880<class_9346> vanillaVariant, SpawnPrioritySelectors spawnConditions) implements PriorityProvider<SpawnContext, SpawnCondition>
{
    public static final Codec<VanillaWolfVariantSpawnSelector> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)class_5381.method_29749((class_5321)class_7924.field_49772, (Codec)class_9346.field_49724).fieldOf("vanilla_variant").forGetter(VanillaWolfVariantSpawnSelector::vanillaVariant), (App)SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(VanillaWolfVariantSpawnSelector::spawnConditions)).apply((Applicative)instance, VanillaWolfVariantSpawnSelector::new));

    public static VanillaWolfVariantSpawnSelector fallback(class_6880<class_9346> variant, int priority) {
        return new VanillaWolfVariantSpawnSelector(variant, SpawnPrioritySelectors.fallback(priority));
    }

    public static VanillaWolfVariantSpawnSelector withCondition(class_6880<class_9346> variant, SpawnCondition condition, int priority) {
        return new VanillaWolfVariantSpawnSelector(variant, SpawnPrioritySelectors.single(condition, priority));
    }

    @Override
    public List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }
}

