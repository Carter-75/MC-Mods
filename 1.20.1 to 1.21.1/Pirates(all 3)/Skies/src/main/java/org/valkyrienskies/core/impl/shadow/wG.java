/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Cb
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.Cb;
import org.valkyrienskies.core.impl.shadow.cb_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.pq_0;
import org.valkyrienskies.core.impl.shadow.wK;
import org.valkyrienskies.core.impl.shadow.wP;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class wG<PAIR>
implements wP<PAIR> {
    private static final a a = new a(0);
    private static final b b = new b(0);
    private final int c;
    private final int d;
    private final wK<PAIR> e;

    public wG(int n2, int n3, wK<PAIR> wK2) {
        this.c = n2;
        this.d = n3;
        this.e = wK2;
    }

    @Override
    public final cb_0 d() {
        return new Cb(this.c, (cb_0.a)a);
    }

    @Override
    public final cb_0 e() {
        return new Cb(this.d, (cb_0.a)b);
    }

    @Override
    public final wK<PAIR> f() {
        return this.e;
    }

    static final class 1 {
    }

    static final class b
    implements cb_0.a {
        private b() {
        }

        public final void a(int n2) {
            throw new pq_0(n2);
        }

        /* synthetic */ b(byte by) {
            this();
        }
    }

    static final class a
    implements cb_0.a {
        private a() {
        }

        public final void a(int n2) {
            throw new pp_0(n2);
        }

        /* synthetic */ a(byte by) {
            this();
        }
    }
}

