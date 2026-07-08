/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_2960
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.content.common.api.variant;

import backported.updates.content.common.api.variant.ClientAsset;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_2960;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public record ModelAndTexture<T>(T model, ClientAsset asset) {
    public ModelAndTexture(T model, class_2960 path) {
        this(model, new ClientAsset(path));
    }

    public static <T> MapCodec<ModelAndTexture<T>> codec(Codec<T> codec, T entry) {
        return RecordCodecBuilder.mapCodec(instance -> instance.group((App)codec.optionalFieldOf("model", entry).forGetter(ModelAndTexture::model), (App)ClientAsset.DEFAULT_FIELD_CODEC.forGetter(ModelAndTexture::asset)).apply((Applicative)instance, ModelAndTexture::new));
    }

    public static <T> class_9139<class_9129, ModelAndTexture<T>> streamCodec(class_9139<class_9129, T> modelCodec) {
        return class_9139.method_56435(modelCodec, ModelAndTexture::model, ClientAsset.STREAM_CODEC, ModelAndTexture::asset, ModelAndTexture::new);
    }
}

