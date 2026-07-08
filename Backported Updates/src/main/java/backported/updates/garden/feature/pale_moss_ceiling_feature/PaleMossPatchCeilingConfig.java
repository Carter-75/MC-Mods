/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.Identifier
 *  net.minecraft.world.gen.feature.FeatureConfig
 *  net.minecraft.util.dynamic.Codecs
 */
package backported.updates.garden.feature.pale_moss_ceiling_feature;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.dynamic.Codecs;

public record PaleMossPatchCeilingConfig(int number, Identifier blockId) implements FeatureConfig
{
    public static final Codec<PaleMossPatchCeilingConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codecs.POSITIVE_INT.fieldOf("number").forGetter(PaleMossPatchCeilingConfig::number), Identifier.CODEC.fieldOf("blockID").forGetter(PaleMossPatchCeilingConfig::blockId)).apply(instance, PaleMossPatchCeilingConfig::new));
}

