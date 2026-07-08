/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.IC;
import org.valkyrienskies.core.impl.shadow.Iw;
import org.valkyrienskies.core.impl.shadow.Iz;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010 \u001a\u00020\u0011\u0012\b\b\u0002\u0010!\u001a\u00020\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\u0011\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u001c\u0012\b\b\u0002\u0010)\u001a\u00020\u0011\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0011\u0012\b\b\u0002\u0010-\u001a\u00020\u0017\u00a2\u0006\u0004\b.\u0010/R\"\u0010\t\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0007\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0005\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0005\u001a\u00020\u00118\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0005\u0010\u0015R\"\u0010\u000b\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\t\u0010\bR\"\u0010\u000f\u001a\u00020\u00118\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\f\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00178\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\t\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00118\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\r\u0010\u0014\"\u0004\b\r\u0010\u0015R\"\u0010\n\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\"\u0010\u000e\u001a\u00020\u001c8\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u0003\u0010\u001e\"\u0004\b\t\u0010\u001fR\"\u0010\u0016\u001a\u00020\u00028\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0012\u001a\u00020\u00118\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0013\u001a\u0004\b\t\u0010\u0014\"\u0004\b\t\u0010\u0015R\"\u0010\u0010\u001a\u00020\u00118\u0017@\u0017X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0007\u0010\u0014\"\u0004\b\u0007\u0010\u0015"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Iv;", "Lorg/valkyrienskies/core/impl/shadow/Iw;", "", "i", "D", "e", "()D", "c", "(D)V", "a", "j", "f", "d", "b", "k", "g", "n", "", "m", "I", "()I", "(I)V", "l", "Lorg/valkyrienskies/core/impl/shadow/Iz;", "Lorg/valkyrienskies/core/impl/shadow/Iz;", "()Lorg/valkyrienskies/core/impl/shadow/Iz;", "(Lorg/valkyrienskies/core/impl/shadow/Iz;)V", "h", "Lorg/valkyrienskies/core/impl/shadow/IC;", "Lorg/valkyrienskies/core/impl/shadow/IC;", "()Lorg/valkyrienskies/core/impl/shadow/IC;", "(Lorg/valkyrienskies/core/impl/shadow/IC;)V", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "<init>", "(IIIDDDDDLorg/valkyrienskies/core/impl/shadow/IC;IDDILorg/valkyrienskies/core/impl/shadow/Iz;)V"})
public class Iv
implements Iw {
    public int a;
    public int b;
    public int c;
    private double h;
    private double i;
    private double j;
    private double k;
    private double l;
    public IC d;
    private int m;
    private double n;
    public double e;
    public int f;
    public Iz g;

    private Iv(int n2, int n3, int n4, double d2, double d3, double d4, double d5, double d6, IC iC, int n5, double d7, double d8, int n6, Iz iz) {
        Intrinsics.checkNotNullParameter((Object)((Object)iC), (String)"");
        Intrinsics.checkNotNullParameter((Object)((Object)iz), (String)"");
        this.a = n2;
        this.b = n3;
        this.c = n4;
        this.h = d2;
        this.i = d3;
        this.j = d4;
        this.k = d5;
        this.l = d6;
        this.d = iC;
        this.m = n5;
        this.n = d7;
        this.e = d8;
        this.f = n6;
        this.g = iz;
    }

    public /* synthetic */ Iv(int n2, int n3, int n4, double d2, double d3, double d4, double d5, double d6, IC iC, int n5, double d7, double d8, int n6, Iz iz, int n7, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n7 & 1) != 0) {
            n2 = 1;
        }
        if ((n7 & 2) != 0) {
            n3 = 4;
        }
        if ((n7 & 4) != 0) {
            n4 = 1;
        }
        if ((n7 & 8) != 0) {
            d2 = 1.0;
        }
        if ((n7 & 0x10) != 0) {
            d3 = 0.0;
        }
        if ((n7 & 0x20) != 0) {
            d4 = 0.0;
        }
        if ((n7 & 0x40) != 0) {
            d5 = 0.0;
        }
        if ((n7 & 0x80) != 0) {
            d6 = 0.05;
        }
        if ((n7 & 0x100) != 0) {
            iC = IC.JACOBI;
        }
        if ((n7 & 0x200) != 0) {
            n5 = 4;
        }
        if ((n7 & 0x400) != 0) {
            d7 = 1.0;
        }
        if ((n7 & 0x800) != 0) {
            d8 = 10000.0;
        }
        if ((n7 & 0x1000) != 0) {
            n6 = 64;
        }
        if ((n7 & 0x2000) != 0) {
            iz = Iz.KRUNCH_CLASSIC;
        }
        this(n2, n3, n4, d2, d3, d4, d5, d6, iC, n5, d7, d8, n6, iz);
    }

    @Override
    @JvmName(name="a")
    public final int a() {
        return this.a;
    }

    @JvmName(name="a")
    public final void a(int n2) {
        this.a = n2;
    }

    @Override
    @JvmName(name="b")
    public final int b() {
        return this.b;
    }

    @JvmName(name="b")
    public final void b(int n2) {
        this.b = n2;
    }

    @Override
    @JvmName(name="c")
    public final int c() {
        return this.c;
    }

    @JvmName(name="c")
    public final void c(int n2) {
        this.c = n2;
    }

    @Override
    @JvmName(name="d")
    public final double d() {
        return this.h;
    }

    @JvmName(name="b")
    private void b(double d2) {
        this.h = d2;
    }

    @Override
    @JvmName(name="e")
    public final double e() {
        return this.i;
    }

    @JvmName(name="c")
    private void c(double d2) {
        this.i = d2;
    }

    @Override
    @JvmName(name="f")
    public final double f() {
        return this.j;
    }

    @JvmName(name="d")
    private void d(double d2) {
        this.j = d2;
    }

    @Override
    @JvmName(name="g")
    public final double g() {
        return this.k;
    }

    @JvmName(name="e")
    private void e(double d2) {
        this.k = d2;
    }

    @Override
    @JvmName(name="h")
    public final double h() {
        return this.l;
    }

    @JvmName(name="f")
    private void f(double d2) {
        this.l = d2;
    }

    @Override
    @JvmName(name="i")
    public final IC i() {
        return this.d;
    }

    @JvmName(name="a")
    public final void a(IC iC) {
        Intrinsics.checkNotNullParameter((Object)((Object)iC), (String)"");
        this.d = iC;
    }

    @Override
    @JvmName(name="j")
    public final int j() {
        return this.m;
    }

    @JvmName(name="e")
    private void e(int n2) {
        this.m = n2;
    }

    @Override
    @JvmName(name="k")
    public final double k() {
        return this.n;
    }

    @JvmName(name="g")
    private void g(double d2) {
        this.n = d2;
    }

    @Override
    @JvmName(name="l")
    public final double l() {
        return this.e;
    }

    @JvmName(name="a")
    public final void a(double d2) {
        this.e = d2;
    }

    @Override
    @JvmName(name="m")
    public final int m() {
        return this.f;
    }

    @JvmName(name="d")
    public final void d(int n2) {
        this.f = n2;
    }

    @Override
    @JvmName(name="n")
    public final Iz n() {
        return this.g;
    }

    @JvmName(name="a")
    public final void a(Iz iz) {
        Intrinsics.checkNotNullParameter((Object)((Object)iz), (String)"");
        this.g = iz;
    }

    public Iv() {
        this(0, 0, 0, 0.0, 0.0, 0.0, 0.0, 0.0, null, 0, 0.0, 0.0, 0, null, 16383, null);
    }
}

