/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.fn_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fp
 */
public final class fp_0<T> {
    public final fn_0<T> a;
    public T b;

    public fp_0(fn_0<T> fn_02, T t) {
        Intrinsics.checkNotNullParameter(fn_02, (String)"");
        this.a = fn_02;
        this.b = t;
    }

    private T a() {
        return this.b;
    }

    public final ByteBuf a(T t, ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        this.a.a(this.b, t, byteBuf);
        this.b = t;
        return byteBuf;
    }
}

