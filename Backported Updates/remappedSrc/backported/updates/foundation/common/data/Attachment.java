/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.class_2960
 */
package backported.updates.foundation.common.data;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import net.minecraft.class_2960;

public interface Attachment<A> {
    public class_2960 valueId();

    public Codec<A> codec();

    public Supplier<A> defaultSyncedValue();

    public static <A> Attachment<A> create(final class_2960 id, final Codec<A> codec, final Supplier<A> value) {
        return new Attachment<A>(){

            @Override
            public class_2960 valueId() {
                return id;
            }

            @Override
            public Codec<A> codec() {
                return codec;
            }

            @Override
            public Supplier<A> defaultSyncedValue() {
                return value;
            }
        };
    }
}

