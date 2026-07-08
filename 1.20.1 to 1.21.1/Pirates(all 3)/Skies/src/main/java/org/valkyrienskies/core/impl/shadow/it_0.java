/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iM
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.iM;
import org.valkyrienskies.core.impl.shadow.im_1;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.im_1<E>, not org.valkyrienskies.core.impl.shadow.iM - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.iT
 */
public final class it_0
extends iM
implements Serializable {
    private static final long d = 6897789178562232073L;
    private static final int e = 20;
    private transient im_1.d<E> f;
    private transient int g;
    private int h = 20;

    public it_0() {
        this(20);
    }

    private it_0(Collection<? extends E> collection) {
        super(collection);
    }

    private it_0(int n2) {
        this.a();
    }

    private int c() {
        return this.h;
    }

    private void a(int n2) {
        this.h = n2;
        it_0 it_02 = this;
        while (it_02.g > it_02.h) {
            it_02.e();
        }
    }

    private void d() {
        while (this.g > this.h) {
            this.e();
        }
    }

    private im_1.d<E> e() {
        if (this.g == 0) {
            return null;
        }
        im_1.d d2 = this.f;
        this.f = d2.b;
        d2.b = null;
        --this.g;
        return d2;
    }

    private boolean f() {
        return this.g >= this.h;
    }

    private void b(im_1.d<E> d2) {
        Object object = this;
        if (((it_0)object).g >= ((it_0)object).h) {
            return;
        }
        object = this.f;
        d2.a = null;
        d2.b = object;
        d2.a((Object)null);
        this.f = d2;
        ++this.g;
    }

    protected final im_1.d<E> a(E e2) {
        im_1.d d2 = this.e();
        if (d2 == null) {
            return super.a(e2);
        }
        d2.a(e2);
        return d2;
    }

    protected final void a(im_1.d<E> d2) {
        super.a(d2);
        this.b(d2);
    }

    protected final void b() {
        int n2 = Math.min(this.b, this.h - this.g);
        im_1.d d2 = this.a.b;
        for (int i2 = 0; i2 < n2; ++i2) {
            im_1.d d3 = d2;
            d2 = d2.b;
            this.b(d3);
        }
        super.b();
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a(objectInputStream);
    }
}

