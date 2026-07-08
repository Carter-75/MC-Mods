/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.valkyrienskies.core.impl.shadow.GS;
import org.valkyrienskies.core.impl.shadow.GX;
import org.valkyrienskies.core.impl.shadow.GY;
import org.valkyrienskies.core.impl.shadow.ha_0;
import org.valkyrienskies.core.impl.shadow.hb_0;
import org.valkyrienskies.core.impl.shadow.hc_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ht
 */
public final class ht_0<T extends GS>
implements GY<T> {
    private final int b;
    private final ha_0 c;
    private hc_0 d;
    private GX e;
    private boolean f;
    private double g;
    private double h;
    private double i;
    private double j;
    private Vector3dc k;
    private double l;
    private boolean m;
    private int n;
    private T o;
    private hb_0 p;
    boolean a;

    public ht_0(int n2, ha_0 ha_02, hc_0 hc_02, GX gX, boolean bl, double d2, double d3, double d4, double d5, Vector3dc vector3dc, double d6, boolean bl2, int n3, T t, hb_0 hb_02) {
        Intrinsics.checkNotNullParameter((Object)ha_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)gX, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.b = n2;
        this.c = ha_02;
        this.d = hc_02;
        this.e = gX;
        this.f = true;
        this.g = 1.0;
        this.h = 1.0;
        this.i = 1.0;
        this.j = 1.0;
        this.k = vector3dc;
        this.l = 1.0;
        this.m = true;
        this.n = 0;
        this.o = t;
        this.p = null;
    }

    @Override
    public final int a() {
        return this.b;
    }

    @Override
    public final ha_0 b() {
        return this.c;
    }

    @Override
    public final hc_0 d() {
        return this.d;
    }

    @Override
    public final void a(hc_0 hc_02) {
        Intrinsics.checkNotNullParameter((Object)hc_02, (String)"");
        this.d = hc_02;
    }

    @Override
    public final GX e() {
        return this.e;
    }

    @Override
    public final void a(GX gX) {
        Intrinsics.checkNotNullParameter((Object)gX, (String)"");
        this.e = gX;
    }

    @Override
    public final boolean f() {
        return this.f;
    }

    @Override
    public final void a(boolean bl) {
        this.f = bl;
    }

    @Override
    public final double g() {
        return this.g;
    }

    @Override
    public final void a(double d2) {
        this.g = d2;
    }

    @Override
    public final double h() {
        return this.h;
    }

    @Override
    public final void b(double d2) {
        this.h = d2;
    }

    @Override
    public final double i() {
        return this.i;
    }

    @Override
    public final void c(double d2) {
        this.i = d2;
    }

    @Override
    public final double j() {
        return this.j;
    }

    @Override
    public final void d(double d2) {
        this.j = d2;
    }

    @Override
    public final Vector3dc k() {
        return this.k;
    }

    @Override
    public final void a(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        this.k = vector3dc;
    }

    @Override
    public final double l() {
        return this.l;
    }

    @Override
    public final void e(double d2) {
        this.l = d2;
    }

    @Override
    public final boolean m() {
        return this.m;
    }

    @Override
    public final void b(boolean bl) {
        this.m = bl;
    }

    @Override
    public final int n() {
        return this.n;
    }

    @Override
    public final void a(int n2) {
        this.n = n2;
    }

    @Override
    public final T c() {
        return this.o;
    }

    @Override
    public final void a(T t) {
        this.o = t;
    }

    @Override
    public final hb_0 o() {
        return this.p;
    }

    @Override
    public final void a(hb_0 hb_02) {
        this.p = hb_02;
    }

    private boolean t() {
        return this.a;
    }

    public final void c(boolean bl) {
        this.a = true;
    }

    @Override
    public final void b(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
    }

    @Override
    public final void c(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
    }

    @Override
    public final void d(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
    }

    @Override
    public final void e(Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
    }

    @Override
    public final void a(Vector3dc vector3dc, Vector3dc vector3dc2) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
    }

    @Override
    public final boolean p() {
        return this.a;
    }

    @Override
    public final boolean a(AABBd aABBd) {
        Intrinsics.checkNotNullParameter((Object)aABBd, (String)"");
        aABBd.setMin(0.0, 0.0, 0.0);
        aABBd.setMax(0.0, 0.0, 0.0);
        return true;
    }

    @Override
    public final void q() {
    }

    @Override
    public final boolean r() {
        return true;
    }

    @Override
    public final double s() {
        return 0.0;
    }
}

