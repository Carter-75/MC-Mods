/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_2096$class_2099
 */
package backported.updates.content.common.api.variant.spawn.check;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_2096;

public record MoonBrightnessCheck(class_2096.class_2099 range) implements SpawnCondition
{
    public static final MapCodec<MoonBrightnessCheck> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_2096.class_2099.field_45762.fieldOf("range").forGetter(MoonBrightnessCheck::range)).apply((Applicative)instance, MoonBrightnessCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        return this.range.method_9047((double)context.level().method_8410().method_30272());
    }

    @Override
    public MapCodec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}

