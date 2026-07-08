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
package backported.updates.garden.feature.pale_moss_ceiling_feature;

import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_2960;
import net.minecraft.class_3037;
import net.minecraft.class_5699;

public record PaleMossPatchCeilingConfig(int number, class_2960 blockId) implements class_3037
{
    public static final Codec<PaleMossPatchCeilingConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)class_5699.field_33442.fieldOf("number").forGetter(PaleMossPatchCeilingConfig::number), (App)class_2960.field_25139.fieldOf("blockID").forGetter(PaleMossPatchCeilingConfig::blockId)).apply((Applicative)instance, PaleMossPatchCeilingConfig::new));
}

