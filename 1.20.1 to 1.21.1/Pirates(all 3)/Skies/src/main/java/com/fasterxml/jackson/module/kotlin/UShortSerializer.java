/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UShort
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ-\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\t\u0010\n\u00f8\u0001\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u000e"}, d2={"Lcom/fasterxml/jackson/module/kotlin/UShortSerializer;", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "Lkotlin/UShort;", "value", "Lcom/fasterxml/jackson/core/JsonGenerator;", "gen", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "provider", "", "serialize-_TFR7lA", "(SLcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V", "serialize", "<init>", "()V", "jackson-module-kotlin"})
public final class UShortSerializer
extends StdSerializer<UShort> {
    @NotNull
    public static final UShortSerializer INSTANCE = new UShortSerializer();

    private UShortSerializer() {
        super(UShort.class);
    }

    public void serialize-_TFR7lA(short value, @NotNull JsonGenerator gen, @NotNull SerializerProvider provider) {
        Intrinsics.checkNotNullParameter((Object)gen, (String)"gen");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"provider");
        boolean bl = false;
        gen.writeNumber(value & 0xFFFF);
    }
}

