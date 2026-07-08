/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.predicate.NumberRange$DoubleRange
 */
package backported.updates.content.common.api.variant.spawn.check;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.predicate.NumberRange;

public record MoonBrightnessCheck(NumberRange.DoubleRange range) implements SpawnCondition
{
    public static final MapCodec<MoonBrightnessCheck> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(NumberRange.DoubleRange.CODEC.fieldOf("range").forGetter(MoonBrightnessCheck::range)).apply(instance, MoonBrightnessCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        return this.range.test((double)context.level().toServerWorld().getMoonSize());
    }

    @Override
    public MapCodec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}

