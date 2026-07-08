/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.fn_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fo
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR$\u0010\t\u001a\u0004\u0018\u00018\u00008\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\u0005\u0010\f"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fo;", "T", "", "Lio/netty/buffer/ByteBuf;", "p0", "a", "(Lio/netty/buffer/ByteBuf;)Ljava/lang/Object;", "Lorg/valkyrienskies/core/impl/shadow/Fn;", "Lorg/valkyrienskies/core/impl/shadow/Fn;", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "p1", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/Fn;Ljava/lang/Object;)V"})
public final class fo_0<T> {
    public final fn_0<T> a;
    public T b;

    public fo_0(fn_0<T> fn_02, T t) {
        Intrinsics.checkNotNullParameter(fn_02, (String)"");
        this.a = fn_02;
        this.b = t;
    }

    public /* synthetic */ fo_0(fn_0 fn_02, Object object, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            object = null;
        }
        this(fn_02, object);
    }

    @JvmName(name="a")
    private T a() {
        return this.b;
    }

    @JvmName(name="a")
    private void a(T t) {
        this.b = t;
    }

    public final T a(ByteBuf object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        T t = this.b;
        Intrinsics.checkNotNull(t);
        object = this.a.a(t, (ByteBuf)object);
        T t2 = object;
        this.b = t2;
        return (T)object;
    }
}

