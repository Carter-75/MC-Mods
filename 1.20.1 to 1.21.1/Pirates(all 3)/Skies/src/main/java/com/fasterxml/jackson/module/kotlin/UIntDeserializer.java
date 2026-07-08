/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.module.kotlin.UnsignedNumbersKt;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0007\u0010\b\u00f8\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\f"}, d2={"Lcom/fasterxml/jackson/module/kotlin/UIntDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdDeserializer;", "Lkotlin/UInt;", "Lcom/fasterxml/jackson/core/JsonParser;", "p", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "deserialize-xfHcF5w", "(Lcom/fasterxml/jackson/core/JsonParser;Lcom/fasterxml/jackson/databind/DeserializationContext;)I", "deserialize", "<init>", "()V", "jackson-module-kotlin"})
public final class UIntDeserializer
extends StdDeserializer<UInt> {
    @NotNull
    public static final UIntDeserializer INSTANCE = new UIntDeserializer();

    private UIntDeserializer() {
        super(UInt.class);
    }

    public int deserialize-xfHcF5w(@NotNull JsonParser p, @NotNull DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter((Object)p, (String)"p");
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        UInt uInt = UnsignedNumbersKt.asUInt(p.getLongValue());
        if (uInt == null) {
            throw new InputCoercionException(p, "Numeric value (" + p.getText() + ") out of range of UInt (0 - 4294967295).", JsonToken.VALUE_NUMBER_INT, UInt.class);
        }
        return uInt.unbox-impl();
    }
}

