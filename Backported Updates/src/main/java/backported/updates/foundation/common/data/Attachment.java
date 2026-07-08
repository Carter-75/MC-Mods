/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Codec
 *  net.minecraft.util.Identifier
 */
package backported.updates.foundation.common.data;

import com.mojang.serialization.Codec;
import java.util.function.Supplier;
import net.minecraft.util.Identifier;

public interface Attachment<A> {
    public Identifier valueId();

    public Codec<A> codec();

    public Supplier<A> defaultSyncedValue();

    public static <A> Attachment<A> create(final Identifier id, final Codec<A> codec, final Supplier<A> value) {
        return new Attachment<A>(){

            @Override
            public Identifier valueId() {
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

