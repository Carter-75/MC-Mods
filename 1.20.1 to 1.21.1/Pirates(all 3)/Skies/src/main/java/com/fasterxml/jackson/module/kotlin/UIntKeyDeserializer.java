/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UInt
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.module.kotlin.UnsignedNumbersKt;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\f"}, d2={"Lcom/fasterxml/jackson/module/kotlin/UIntKeyDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer;", "", "key", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "Lkotlin/UInt;", "deserializeKey-uT2Fmlo", "(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lkotlin/UInt;", "deserializeKey", "<init>", "()V", "jackson-module-kotlin"})
public final class UIntKeyDeserializer
extends StdKeyDeserializer {
    @NotNull
    public static final UIntKeyDeserializer INSTANCE = new UIntKeyDeserializer();

    private UIntKeyDeserializer() {
        super(6, UInt.class);
    }

    @Nullable
    public UInt deserializeKey-uT2Fmlo(@Nullable String key, @NotNull DeserializationContext ctxt) {
        UInt uInt;
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        Object object = super.deserializeKey(key, ctxt);
        if (object == null) {
            uInt = null;
        } else {
            Object object2 = object;
            boolean bl = false;
            boolean bl2 = false;
            Object it = object2;
            boolean bl3 = false;
            UInt uInt2 = UnsignedNumbersKt.asUInt((Long)it);
            if (uInt2 == null) {
                throw new InputCoercionException(null, "Numeric value (" + key + ") out of range of UInt (0 - 4294967295).", JsonToken.VALUE_NUMBER_INT, UInt.class);
            }
            uInt = UInt.box-impl((int)uInt2.unbox-impl());
        }
        return uInt;
    }
}

