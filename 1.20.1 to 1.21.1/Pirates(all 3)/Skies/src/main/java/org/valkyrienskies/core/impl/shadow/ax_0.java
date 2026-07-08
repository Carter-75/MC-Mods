/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.AA;
import org.valkyrienskies.core.impl.shadow.aq_0;
import org.valkyrienskies.core.impl.shadow.ci_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ax
 */
public final class ax_0
extends aq_0 {
    private static final long a = 1L;

    public ax_0() {
        this(-1);
    }

    private ax_0(int n2) {
        super(-1);
    }

    private ax_0(ax_0 ax_02) {
        ax_0.a(ax_02, this);
    }

    public final synchronized void a(double d2) {
        super.a(d2);
    }

    public final synchronized double a(AA aA) {
        return super.a(aA);
    }

    public final synchronized void i() {
        super.i();
    }

    public final synchronized double b(int n2) {
        return super.b(n2);
    }

    public final synchronized long d() {
        return super.d();
    }

    public final synchronized double e() {
        return super.e();
    }

    public final synchronized double h() {
        return super.h();
    }

    public final synchronized double[] k() {
        return super.k();
    }

    public final synchronized int j() {
        return super.j();
    }

    public final synchronized void a(int n2) {
        super.a(n2);
    }

    public final synchronized String toString() {
        return super.toString();
    }

    private synchronized ax_0 m() {
        ax_0 ax_02 = new ax_0();
        ax_0.a(this, ax_02);
        return ax_02;
    }

    private static void a(ax_0 ax_02, ax_0 ax_03) {
        ci_0.a(ax_02);
        ci_0.a(ax_03);
        ax_0 ax_04 = ax_02;
        synchronized (ax_04) {
            ax_0 ax_05 = ax_03;
            synchronized (ax_05) {
                aq_0.a(ax_02, ax_03);
            }
            return;
        }
    }

    public final /* synthetic */ aq_0 l() {
        return this.m();
    }
}

