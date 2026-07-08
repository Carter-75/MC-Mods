/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_1959
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package backported.updates.content.common.api.variant.spawn.check.raw;

import backported.updates.content.common.api.variant.spawn.SpawnCondition;
import backported.updates.content.common.api.variant.spawn.SpawnContext;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_1959;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public record RawBiomeCheck(class_6862<class_1959> requiredBiomes) implements SpawnCondition
{
    public static final MapCodec<RawBiomeCheck> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group((App)class_6862.method_40090((class_5321)class_7924.field_41236).fieldOf("biomes").forGetter(RawBiomeCheck::requiredBiomes)).apply((Applicative)instance, RawBiomeCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        return context.biome().method_40220(this.requiredBiomes);
    }

    @Override
    public MapCodec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}

