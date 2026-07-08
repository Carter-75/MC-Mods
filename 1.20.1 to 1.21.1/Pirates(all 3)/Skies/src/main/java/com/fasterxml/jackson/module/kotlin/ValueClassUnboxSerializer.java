/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ValueClassUnboxSerializer;", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "", "value", "Lcom/fasterxml/jackson/core/JsonGenerator;", "gen", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "provider", "", "serialize", "(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V", "<init>", "()V", "jackson-module-kotlin"})
public final class ValueClassUnboxSerializer
extends StdSerializer<Object> {
    @NotNull
    public static final ValueClassUnboxSerializer INSTANCE = new ValueClassUnboxSerializer();

    private ValueClassUnboxSerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(@NotNull Object value, @NotNull JsonGenerator gen, @NotNull SerializerProvider provider) {
        Intrinsics.checkNotNullParameter((Object)value, (String)"value");
        Intrinsics.checkNotNullParameter((Object)gen, (String)"gen");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        Object unboxed = value.getClass().getMethod("unbox-impl", new Class[0]).invoke(value, new Object[0]);
        if (unboxed == null) {
            provider.findNullValueSerializer(null).serialize(null, gen, provider);
            return;
        }
        provider.findValueSerializer(unboxed.getClass()).serialize(unboxed, gen, provider);
    }
}

