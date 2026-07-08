/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class GC<A, B>
extends StdDeserializer<A> {
    private final Function1<B, A> a;
    private final Class<B> b;

    public GC(Function1<? super B, ? extends A> function1, Class<A> clazz, Class<B> clazz2) {
        Intrinsics.checkNotNullParameter(function1, (String)"");
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        Intrinsics.checkNotNullParameter(clazz2, (String)"");
        super(clazz);
        this.a = function1;
        this.b = clazz2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final A deserialize(JsonParser p, DeserializationContext ctxt) {
        void var1_1;
        void var2_2;
        Intrinsics.checkNotNullParameter((Object)p, (String)"");
        Intrinsics.checkNotNullParameter((Object)var2_2, (String)"");
        return (A)this.a.invoke(p.getCodec().readValue((JsonParser)var1_1, this.b));
    }
}

