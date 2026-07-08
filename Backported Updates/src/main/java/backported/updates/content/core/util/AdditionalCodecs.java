/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Either
 *  com.mojang.serialization.Codec
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.network.PacketByteBuf
 *  net.minecraft.util.dynamic.Codecs
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.content.core.util;

import backported.updates.content.core.util.ColorUtils;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import net.minecraft.util.math.Vec3d;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.network.codec.PacketCodec;

public class AdditionalCodecs {
    public static final Codec<Integer> RGB_COLOR_CODEC = AdditionalCodecs.withAlternative(Codec.INT, Codecs.VECTOR_3F, vector -> ColorUtils.colorFromFloat(1.0f, vector.x(), vector.y(), vector.z()));
    public static final PacketCodec<ByteBuf, Vec3d> VEC3_STREAM_CODEC = new PacketCodec<ByteBuf, Vec3d>(){

        public Vec3d decode(ByteBuf byteBuf) {
            return new PacketByteBuf(byteBuf).readVec3d();
        }

        public void encode(ByteBuf byteBuf, Vec3d vec3) {
            new PacketByteBuf(byteBuf).writeVec3d(vec3);
        }
    };

    private static <T, U> Codec<T> withAlternative(Codec<T> primary, Codec<U> alternative, Function<U, T> converter) {
        return Codec.either(primary, alternative).xmap(either -> either.map(t -> t, converter), Either::left);
    }
}

