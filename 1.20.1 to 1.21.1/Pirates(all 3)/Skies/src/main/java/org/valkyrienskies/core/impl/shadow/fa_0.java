/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.buffer.ByteBuf
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import io.netty.buffer.ByteBuf;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.event.RegisteredListener;
import org.valkyrienskies.core.impl.shadow.EX;
import org.valkyrienskies.core.impl.shadow.EY;
import org.valkyrienskies.core.impl.shadow.EZ;
import org.valkyrienskies.core.impl.shadow.fe_0;
import org.valkyrienskies.core.internal.world.VsiPlayer;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fa
 */
public final class fa_0 {
    public final EY a;
    final int b;
    final String c;

    public fa_0(EY eY, int n2, String string) {
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        this.a = eY;
        this.b = n2;
        this.c = string;
    }

    private EY c() {
        return this.a;
    }

    public final int a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final EZ a(ByteBuf byteBuf) {
        return new EZ(this, byteBuf);
    }

    public final void b(ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        this.a.a(this.a(byteBuf));
    }

    public final void a(ByteBuf byteBuf, VsiPlayer vsiPlayer) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayer, (String)"");
        this.a.a(this.a(byteBuf), vsiPlayer);
    }

    public final void a(ByteBuf object, VsiPlayer ... object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        VsiPlayer[] vsiPlayerArray = Arrays.copyOf(object2, ((VsiPlayer[])object2).length);
        object2 = this.a((ByteBuf)object);
        object = this.a;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiPlayerArray, (String)"");
        for (VsiPlayer vsiPlayer : vsiPlayerArray) {
            ((EY)object).a((EZ)object2, vsiPlayer);
        }
    }

    public final void c(ByteBuf byteBuf) {
        Intrinsics.checkNotNullParameter((Object)byteBuf, (String)"");
        this.a.b(this.a(byteBuf));
    }

    public final RegisteredListener a(fe_0 fe_02) {
        Intrinsics.checkNotNullParameter((Object)fe_02, (String)"");
        return this.a.a(this, fe_02);
    }

    public final RegisteredListener a(EX eX) {
        Intrinsics.checkNotNullParameter((Object)eX, (String)"");
        return this.a.a(this, eX);
    }

    private EY d() {
        return this.a;
    }

    private int e() {
        return this.b;
    }

    private String f() {
        return this.c;
    }

    private static fa_0 a(EY eY, int n2, String string) {
        Intrinsics.checkNotNullParameter((Object)eY, (String)"");
        Intrinsics.checkNotNullParameter((Object)string, (String)"");
        return new fa_0(eY, n2, string);
    }

    private static /* synthetic */ fa_0 a(fa_0 object, EY eY, int n2, String string, int n3) {
        if ((n3 & 1) != 0) {
            eY = ((fa_0)object).a;
        }
        if ((n3 & 2) != 0) {
            n2 = ((fa_0)object).b;
        }
        if ((n3 & 4) != 0) {
            string = ((fa_0)object).c;
        }
        String string2 = string;
        int n4 = n2;
        object = eY;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"");
        return new fa_0((EY)object, n4, string2);
    }

    public final String toString() {
        return "PacketType(channel=" + this.a + ", id=" + this.b + ", name=" + this.c + ")";
    }

    public final int hashCode() {
        int n2 = this.a.hashCode();
        n2 = n2 * 31 + Integer.hashCode(this.b);
        n2 = n2 * 31 + this.c.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        fa_0 fa_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof fa_0)) {
            return false;
        }
        fa_02 = fa_02;
        if (!Intrinsics.areEqual((Object)this.a, (Object)fa_02.a)) {
            return false;
        }
        if (this.b != fa_02.b) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.c, (Object)fa_02.c);
    }
}

