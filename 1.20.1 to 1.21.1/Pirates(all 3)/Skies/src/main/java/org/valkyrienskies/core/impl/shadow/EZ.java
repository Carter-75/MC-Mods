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
import org.valkyrienskies.core.impl.shadow.fa_0;
import org.valkyrienskies.core.internal.world.VsiPlayer;

public final class EZ {
    final fa_0 a;
    public final ByteBuf b;

    public EZ(fa_0 fa_02, ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        this.a = fa_02;
        this.b = byteBuf;
    }

    public final fa_0 a() {
        return this.a;
    }

    public final ByteBuf b() {
        return this.b;
    }

    private void c() {
        this.a.b(this.b);
    }

    private void a(VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        this.a.a(this.b, vsiPlayer);
    }

    private fa_0 d() {
        return this.a;
    }

    private ByteBuf e() {
        return this.b;
    }

    private static EZ a(fa_0 fa_02, ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        return new EZ(fa_02, byteBuf);
    }

    private static /* synthetic */ EZ a(EZ object, fa_0 fa_02, ByteBuf byteBuf, int n2) {
        if ((n2 & 1) != 0) {
            fa_02 = ((EZ)object).a;
        }
        if ((n2 & 2) != 0) {
            byteBuf = ((EZ)object).b;
        }
        fa_0 fa_03 = fa_02;
        fa_02 = byteBuf;
        object = fa_03;
        Intrinsics.checkNotNullParameter((Object)fa_03, (String)"");
        Intrinsics.checkNotNullParameter((Object)fa_02, (String)"");
        return new EZ((fa_0)object, (ByteBuf)fa_02);
    }

    public final String toString() {
        return "Packet(type=" + this.a + ", data=" + this.b + ")";
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + this.b.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        EZ eZ;
        if (this == other) {
            return true;
        }
        if (!(other instanceof EZ)) {
            return false;
        }
        eZ = eZ;
        if (!Intrinsics.areEqual((Object)this.a, (Object)eZ.a)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.b, (Object)eZ.b);
    }
}

