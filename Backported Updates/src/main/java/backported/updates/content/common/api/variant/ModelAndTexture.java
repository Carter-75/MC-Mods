/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.util.Identifier
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.content.common.api.variant;

import backported.updates.content.common.api.variant.ClientAsset;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public record ModelAndTexture<T>(T model, ClientAsset asset) {
    public ModelAndTexture(T model, Identifier path) {
        this(model, new ClientAsset(path));
    }

    public static <T> MapCodec<ModelAndTexture<T>> codec(Codec<T> codec, T entry) {
        return RecordCodecBuilder.mapCodec(instance -> instance.group(codec.optionalFieldOf("model", entry).forGetter(ModelAndTexture::model), ClientAsset.DEFAULT_FIELD_CODEC.forGetter(ModelAndTexture::asset)).apply(instance, ModelAndTexture::new));
    }

    public static <T> PacketCodec<RegistryByteBuf, ModelAndTexture<T>> streamCodec(PacketCodec<RegistryByteBuf, T> modelCodec) {
        return PacketCodec.tuple(modelCodec, ModelAndTexture::model, ClientAsset.STREAM_CODEC, ModelAndTexture::asset, ModelAndTexture::new);
    }
}

