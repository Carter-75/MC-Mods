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
import org.valkyrienskies.core.impl.shadow.wM;
import org.valkyrienskies.core.impl.shadow.wN;
import org.valkyrienskies.core.impl.shadow.wO;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class wJ<PAIR> {
    private cb_0 a;
    private cb_0 b;
    private final wK<PAIR> c;

    public wJ(wK<PAIR> wK2) {
        this(wK2, 0, Integer.MAX_VALUE);
    }

    private wJ(wK<PAIR> wK2, int n2, int n3) {
        this.c = wK2;
        this.a = new Cb(0, (cb_0.a)new a(0));
        this.b = new Cb(Integer.MAX_VALUE, (cb_0.a)new b(0));
    }

    public final int h() {
        cb_0 cb_02 = this.a;
        return ((Cb)cb_02).a;
    }

    public int a() {
        cb_0 cb_02 = this.a;
        return ((Cb)cb_02).b;
    }

    private int b() {
        cb_0 cb_02 = this.b;
        return ((Cb)cb_02).a;
    }

    public final int i() {
        cb_0 cb_02 = this.b;
        return ((Cb)cb_02).b;
    }

    public final wK<PAIR> j() {
        return this.c;
    }

    public PAIR a(wO ... wOArray) {
        this.b(wOArray);
        this.a.d();
        this.b.d();
        return this.c();
    }

    private PAIR d() {
        this.a.d();
        this.b.d();
        return this.c();
    }

    protected abstract PAIR c();

    public final void k() {
        this.a.c();
    }

    protected final void l() {
        this.b.c();
    }

    public void b(wO ... wOArray) {
        for (wO wO2 : wOArray) {
            if (wO2 instanceof wM) {
                wO2 = (wM)wO2;
                this.a.a(((wM)wO2).a);
                continue;
            }
            if (!(wO2 instanceof wN)) continue;
            wO2 = (wN)wO2;
            this.b.a(((wN)wO2).a);
        }
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

