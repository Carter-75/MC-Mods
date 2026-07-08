/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_2960
 *  net.minecraft.class_3037
 *  net.minecraft.class_5699
 */
package backported.updates.garden.feature.pale_moss_feature;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_2960;
import net.minecraft.class_3037;
import net.minecraft.class_5699;

public record PaleMossPatchConfig(int number, class_2960 blockId) implements class_3037
{
    public static final Codec<PaleMossPatchConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)class_5699.field_33442.fieldOf("number").forGetter(PaleMossPatchConfig::number), (App)class_2960.field_25139.fieldOf("blockID").forGetter(PaleMossPatchConfig::blockId)).apply((Applicative)instance, PaleMossPatchConfig::new));
}

