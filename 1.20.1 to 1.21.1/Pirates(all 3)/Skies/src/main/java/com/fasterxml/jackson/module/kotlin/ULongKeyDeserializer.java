/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ULong
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.module.kotlin.UnsignedNumbersKt;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@Metadata(mv={1, 5, 1}, k=1, xi=48, d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ,\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\f"}, d2={"Lcom/fasterxml/jackson/module/kotlin/ULongKeyDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer;", "", "key", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "ctxt", "Lkotlin/ULong;", "deserializeKey-woJcscw", "(Ljava/lang/String;Lcom/fasterxml/jackson/databind/DeserializationContext;)Lkotlin/ULong;", "deserializeKey", "<init>", "()V", "jackson-module-kotlin"})
public final class ULongKeyDeserializer
extends StdKeyDeserializer {
    @NotNull
    public static final ULongKeyDeserializer INSTANCE = new ULongKeyDeserializer();

    private ULongKeyDeserializer() {
        super(6, ULong.class);
    }

    @Nullable
    public ULong deserializeKey-woJcscw(@Nullable String key, @NotNull DeserializationContext ctxt) {
        ULong uLong;
        Intrinsics.checkNotNullParameter((Object)ctxt, (String)"ctxt");
        String string = key;
        if (string == null) {
            uLong = null;
        } else {
            String string2 = string;
            boolean bl = false;
            boolean bl2 = false;
            String it = string2;
            boolean bl3 = false;
            String string3 = it;
            boolean bl4 = false;
            ULong uLong2 = UnsignedNumbersKt.asULong(new BigInteger(string3));
            if (uLong2 == null) {
                throw new InputCoercionException(null, "Numeric value (" + key + ") out of range of ULong (0 - 18446744073709551615).", JsonToken.VALUE_NUMBER_INT, ULong.class);
            }
            uLong = ULong.box-impl((long)uLong2.unbox-impl());
        }
        return uLong;
    }
}

