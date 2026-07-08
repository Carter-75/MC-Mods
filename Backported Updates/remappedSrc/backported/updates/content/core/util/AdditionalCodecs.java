/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Either
 *  com.mojang.serialization.Codec
 *  io.netty.buffer.ByteBuf
 *  net.minecraft.class_243
 *  net.minecraft.class_2540
 *  net.minecraft.class_5699
 *  net.minecraft.class_9139
 */
package backported.updates.content.core.util;

import backported.updates.content.core.util.ColorUtils;
import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.function.Function;
import net.minecraft.class_243;
import net.minecraft.class_2540;
import net.minecraft.class_5699;
import net.minecraft.class_9139;

public class AdditionalCodecs {
    public static final Codec<Integer> RGB_COLOR_CODEC = AdditionalCodecs.withAlternative(Codec.INT, class_5699.field_40723, vector -> ColorUtils.colorFromFloat(1.0f, vector.x(), vector.y(), vector.z()));
    public static final class_9139<ByteBuf, class_243> VEC3_STREAM_CODEC = new class_9139<ByteBuf, class_243>(){

        public class_243 decode(ByteBuf byteBuf) {
            return new class_2540(byteBuf).method_52996();
        }

        public void encode(ByteBuf byteBuf, class_243 vec3) {
            new class_2540(byteBuf).method_52955(vec3);
        }
    };

    private static <T, U> Codec<T> withAlternative(Codec<T> primary, Codec<U> alternative, Function<U, T> converter) {
        return Codec.either(primary, alternative).xmap(either -> either.map(t -> t, converter), Either::left);
    }
}

