/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 */
package org.valkyrienskies.mod.common.jackson;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ#\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2={"Lorg/valkyrienskies/mod/common/jackson/BlockPosKeyDeserializer;", "Lcom/fasterxml/jackson/databind/KeyDeserializer;", "", "key", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "", "deserializeKey", "(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Ljava/lang/Object;", "<init>", "()V", "valkyrienskies-120"})
public final class BlockPosKeyDeserializer
extends KeyDeserializer {
    @Override
    @Nullable
    public Object deserializeKey(@Nullable String key, @NotNull DeserializationContext ctxt) {
        class_2338 class_23382;
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        if (key == null) {
            return null;
        }
        try {
            long packed = Long.parseLong(key);
            class_23382 = class_2338.method_10092((long)packed);
        }
        catch (NumberFormatException e2) {
            throw JsonMappingException.from(ctxt, "Invalid BlockPos key '" + key + "'", (Throwable)e2);
        }
        return class_23382;
    }
}

