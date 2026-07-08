/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.qN;
import org.valkyrienskies.core.impl.shadow.rK;
import org.valkyrienskies.core.impl.shadow.rM;
import org.valkyrienskies.core.impl.shadow.rV;
import org.valkyrienskies.core.impl.shadow.rY;
import org.valkyrienskies.core.impl.shadow.sa_0;
import org.valkyrienskies.core.impl.shadow.sb_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
final class rW<S extends qN> {
    private final rY<S> c;
    boolean a;
    boolean b;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    rW(rK rK2) {
        this.c = rK2;
        this.a = false;
        this.b = false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final void a(rM<S> rM2, sb_0<S> sb_02) {
        rM rM3;
        block33: {
            block32: {
                block29: {
                    block31: {
                        block30: {
                            rM3 = rM2;
                            if (rM3.a == null) {
                                rM3 = rM2;
                                if ((Boolean)rM3.e == false) return;
                                this.a = true;
                                this.b = true;
                                return;
                            }
                            rM3 = rM2;
                            Object object = rM3.a.c();
                            object = sb_02.a((rV)object);
                            switch (1.a[((sb_0.a)object).c() - 1]) {
                                case 1: {
                                    rM3 = rM2;
                                    if (rM3.a.a(sb_02.c()).c() == sa_0.PLUS$7c70dd6b) {
                                        rM3 = rM2;
                                        if (!this.c.c(rM3.c)) {
                                            this.a = true;
                                        }
                                    } else {
                                        rM3 = rM2;
                                        if (!this.c.c(rM3.c)) {
                                            this.b = true;
                                        }
                                    }
                                    if (this.a) {
                                        if (this.b) return;
                                    }
                                    rM3 = rM2;
                                    this.a(rM3.b, sb_02);
                                    return;
                                }
                                case 2: {
                                    rM3 = rM2;
                                    if (rM3.a.a(sb_02.c()).c() == sa_0.PLUS$7c70dd6b) {
                                        rM3 = rM2;
                                        if (!this.c.c(rM3.b)) {
                                            this.a = true;
                                        }
                                    } else {
                                        rM3 = rM2;
                                        if (!this.c.c(rM3.b)) {
                                            this.b = true;
                                        }
                                    }
                                    if (this.a) {
                                        if (this.b) return;
                                    }
                                    rM3 = rM2;
                                    this.a(rM3.c, sb_02);
                                    return;
                                }
                                case 3: {
                                    rM<S> rM4 = rM2;
                                    rM3 = rM4;
                                    rM3 = object;
                                    this.a(rM4.b, ((sb_0.a)((Object)rM3)).a);
                                    if (this.a) {
                                        if (this.b) return;
                                    }
                                    rM<S> rM5 = rM2;
                                    rM3 = rM5;
                                    rM3 = object;
                                    this.a(rM5.c, ((sb_0.a)((Object)rM3)).b);
                                    return;
                                }
                            }
                            rM3 = rM2;
                            if (!rM3.a.c().a(sb_02.c())) break block29;
                            rM3 = rM2;
                            rM3 = rM3.b;
                            if (rM3.a != null) break block30;
                            rM3 = rM2;
                            rM3 = rM3.b;
                            if (!((Boolean)rM3.e).booleanValue()) break block31;
                        }
                        this.a = true;
                    }
                    rM3 = rM2;
                    rM3 = rM3.c;
                    if (rM3.a == null) {
                        rM3 = rM2;
                        rM3 = rM3.c;
                        if ((Boolean)rM3.e == false) return;
                    }
                    this.b = true;
                    return;
                }
                rM3 = rM2;
                rM3 = rM3.b;
                if (rM3.a != null) break block32;
                rM3 = rM2;
                rM3 = rM3.b;
                if (!((Boolean)rM3.e).booleanValue()) break block33;
            }
            this.b = true;
        }
        rM3 = rM2;
        rM3 = rM3.c;
        if (rM3.a == null) {
            rM3 = rM2;
            rM3 = rM3.c;
            if ((Boolean)rM3.e == false) return;
        }
        this.a = true;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[sa_0.values$65ac40a5().length];
            try {
                1.a[sa_0.PLUS$7c70dd6b - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[sa_0.MINUS$7c70dd6b - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[sa_0.BOTH$7c70dd6b - 1] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}

