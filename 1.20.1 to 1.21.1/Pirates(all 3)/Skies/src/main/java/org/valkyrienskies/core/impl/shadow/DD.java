/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.DE;
import org.valkyrienskies.core.impl.shadow.DH;
import org.valkyrienskies.core.impl.shadow.dy_0;

public final class DD
extends DH<DD> {
    public static final DD a = new DD(null, null);
    public final DE b;
    public int c;
    public boolean d;
    public boolean e;
    public final dy_0 f;
    public Object g;
    public boolean h;

    public DD(DE dE, dy_0 dy_02) {
        this.b = dE;
        this.f = dy_02;
    }

    public final boolean a() {
        boolean bl;
        boolean bl2 = ((DD)this.j).d || ((DD)this.k).d || this.b.c == this && this.b.d != null;
        boolean bl3 = bl = ((DD)this.j).e || ((DD)this.k).e || this.b.c == this && this.b.e != null;
        if (bl2 == this.d && bl == this.e) {
            return false;
        }
        this.d = bl2;
        this.e = bl;
        return true;
    }

    @Override
    public final boolean b() {
        int n2 = ((DD)this.j).c + ((DD)this.k).c + 1;
        boolean bl = this.a();
        Object object = null;
        boolean bl2 = false;
        if (this.f != null) {
            if (((DD)this.j).h) {
                object = ((DD)this.j).g;
                bl2 = true;
            }
            if (this.b.g && this.b.c == this) {
                if (bl2) {
                    object = this.f.a(object, this.b.f);
                } else {
                    object = this.b.f;
                    bl2 = true;
                }
            }
            if (((DD)this.k).h) {
                if (bl2) {
                    object = this.f.a(object, ((DD)this.k).g);
                } else {
                    object = ((DD)this.k).g;
                    bl2 = true;
                }
            }
        }
        if (n2 == this.c && !bl && this.h == bl2 && (object != null ? object.equals(this.g) : this.g == null)) {
            return false;
        }
        this.c = n2;
        this.g = object;
        this.h = bl2;
        return true;
    }
}

