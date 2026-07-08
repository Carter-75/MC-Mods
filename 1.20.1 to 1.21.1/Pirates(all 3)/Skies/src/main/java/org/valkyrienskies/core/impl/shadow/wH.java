/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.co_0;
import org.valkyrienskies.core.impl.shadow.oX;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.pp_0;
import org.valkyrienskies.core.impl.shadow.wI;
import org.valkyrienskies.core.impl.shadow.wJ;
import org.valkyrienskies.core.impl.shadow.wL;
import org.valkyrienskies.core.impl.shadow.wM;
import org.valkyrienskies.core.impl.shadow.wO;
import org.valkyrienskies.core.impl.shadow.zH;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class wH<PAIR>
extends wI<PAIR> {
    private final wI<PAIR> a;
    private int b;
    private int c;
    private zH d;
    private wO[] e;
    private int f = -1;
    private int g = -1;

    public wH(wI<PAIR> wI2, int n2, zH zH2) {
        super(wI2.j());
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.a = wI2;
        this.c = n2;
        this.d = zH2;
    }

    @Override
    public final int a() {
        return this.b;
    }

    public abstract PAIR[] b();

    @Override
    public final PAIR a(wO ... wOArray) {
        this.e = wOArray;
        return super.a(wOArray);
    }

    @Override
    protected final PAIR c() {
        for (int i2 = 0; i2 < this.e.length; ++i2) {
            if (this.e[i2] instanceof wM) {
                this.e[i2] = null;
                this.f = i2;
            }
            if (!(this.e[i2] instanceof wL)) continue;
            this.e[i2] = null;
            this.g = i2;
        }
        if (this.f == -1) {
            throw new oX();
        }
        if (this.g == -1) {
            throw new oX();
        }
        RuntimeException runtimeException = null;
        this.b = 0;
        this.d();
        int n2 = this.h();
        double[] dArray = this.f();
        double[] dArray2 = this.g();
        double[] dArray3 = this.e();
        for (int i3 = 0; i3 < this.c; ++i3) {
            Object object;
            try {
                this.e[this.f] = new wM(n2 - this.b);
                object = null;
                if (i3 == 0) {
                    object = dArray3;
                } else {
                    int n3 = 0;
                    while (object == null) {
                        if (n3++ >= this.h()) {
                            throw new pp_0(this.h());
                        }
                        object = this.d.a();
                        for (int i4 = 0; object != null && i4 < ((Object)object).length; ++i4) {
                            if (!(dArray != null && object[i4] < dArray[i4]) && (dArray2 == null || !(object[i4] > dArray2[i4]))) continue;
                            object = null;
                        }
                    }
                }
                this.e[this.g] = new wL((double[])object);
                Object PAIR = ((wJ)this.a).a(this.e);
                this.a(PAIR);
            }
            catch (RuntimeException runtimeException2) {
                object = runtimeException2;
                runtimeException = runtimeException2;
            }
            this.b += this.a.a();
        }
        co_0[] co_0Array = this.b();
        if (co_0Array.length == 0) {
            throw runtimeException;
        }
        return (PAIR)co_0Array[0];
    }

    protected abstract void a(PAIR var1);

    protected abstract void d();
}

