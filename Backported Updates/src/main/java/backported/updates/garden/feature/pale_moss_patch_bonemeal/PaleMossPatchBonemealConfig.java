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
package backported.updates.garden.feature.pale_moss_patch_bonemeal;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.util.dynamic.Codecs;

public record PaleMossPatchBonemealConfig(int number, Identifier blockId) implements FeatureConfig
{
    public static final Codec<PaleMossPatchBonemealConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codecs.POSITIVE_INT.fieldOf("number").forGetter(PaleMossPatchBonemealConfig::number), Identifier.CODEC.fieldOf("blockID").forGetter(PaleMossPatchBonemealConfig::blockId)).apply(instance, PaleMossPatchBonemealConfig::new));
}

