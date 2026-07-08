/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class GD<A, B>
extends StdSerializer<A> {
    private final Function1<A, B> a;

    public GD(Function1<? super A, ? extends B> function1, Class<A> clazz) {
        Intrinsics.checkNotNullParameter(function1, (String)"");
        Intrinsics.checkNotNullParameter(clazz, (String)"");
        super(clazz);
        this.a = function1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void serialize(A value, JsonGenerator gen, SerializerProvider provider) {
        void var2_2;
        void var1_1;
        void var3_3;
        Intrinsics.checkNotNullParameter((Object)gen, (String)"");
        Intrinsics.checkNotNullParameter((Object)provider, (String)"");
        var3_3.defaultSerializeValue(this.a.invoke((Object)var1_1), (JsonGenerator)var2_2);
    }
}

