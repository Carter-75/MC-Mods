/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.Ck
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.Ck;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.pk_0;
import org.valkyrienskies.core.impl.shadow.po_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.Ck
 */
public final class ck_0
implements Iterable<Integer> {
    private final int a;
    private final int[] b;
    private final int[] c;
    private final int d;
    private final int e;

    private ck_0(int ... nArray) {
        this.a = nArray.length;
        int[] nArray2 = nArray;
        this.c = ch_0.a(nArray, nArray2.length);
        this.b = new int[this.a];
        this.e = this.a - 1;
        int n2 = nArray[this.e];
        for (int i2 = 0; i2 < this.e; ++i2) {
            int n3 = 1;
            for (int i3 = i2 + 1; i3 < this.a; ++i3) {
                n3 *= nArray[i3];
            }
            this.b[i2] = n3;
            n2 *= nArray[i2];
        }
        this.b[this.e] = 0;
        if (n2 <= 0) {
            throw new pk_0(n2);
        }
        this.d = n2;
    }

    private a a() {
        return new a(this);
    }

    private int b() {
        return this.a;
    }

    private int[] a(int n2) {
        if (n2 < 0 || n2 >= this.d) {
            throw new po_0(n2, (Number)0, this.d);
        }
        int[] nArray = new int[this.a];
        int n3 = 0;
        for (int i2 = 0; i2 < this.e; ++i2) {
            int n4 = 0;
            int n5 = this.b[i2];
            while (n3 <= n2) {
                n3 += n5;
                ++n4;
            }
            n3 -= n5;
            nArray[i2] = --n4;
        }
        nArray[this.e] = n2 - n3;
        return nArray;
    }

    private int a(int ... nArray) {
        if (nArray.length != this.a) {
            throw new oS(nArray.length, this.a);
        }
        int n2 = 0;
        for (int i2 = 0; i2 < this.a; ++i2) {
            int n3 = nArray[i2];
            if (n3 < 0 || n3 >= this.c[i2]) {
                throw new po_0(n3, (Number)0, this.c[i2] - 1);
            }
            n2 += this.b[i2] * nArray[i2];
        }
        return n2 + nArray[this.e];
    }

    private int c() {
        return this.d;
    }

    private int[] d() {
        int[] nArray = this.c;
        return ch_0.a(this.c, nArray.length);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < this.a; ++i2) {
            StringBuilder stringBuilder2 = stringBuilder.append("[");
            int[] nArray = new int[]{i2};
            ck_0 ck_02 = this;
            if (nArray.length != ck_02.a) {
                throw new oS(nArray.length, ck_02.a);
            }
            int n2 = 0;
            for (int i3 = 0; i3 < ck_02.a; ++i3) {
                int n3 = nArray[i3];
                if (n3 < 0 || n3 >= ck_02.c[i3]) {
                    throw new po_0(n3, (Number)0, ck_02.c[i3] - 1);
                }
                n2 += ck_02.b[i3] * nArray[i3];
            }
            stringBuilder2.append(n2 + nArray[ck_02.e]).append("]");
        }
        return stringBuilder.toString();
    }

    @Override
    public final /* synthetic */ Iterator iterator() {
        ck_0 ck_02 = this;
        return new a(ck_02);
    }

    static /* synthetic */ int a(ck_0 ck_02) {
        return ck_02.a;
    }

    static /* synthetic */ int b(ck_0 ck_02) {
        return ck_02.d;
    }

    static /* synthetic */ int c(ck_0 ck_02) {
        return ck_02.e;
    }

    static /* synthetic */ int[] d(ck_0 ck_02) {
        return ck_02.c;
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public final class a
    implements Iterator<Integer> {
        private final int[] a;
        private int b;
        private final int c;
        private /* synthetic */ ck_0 d;

        a(ck_0 ck_02) {
            this.d = ck_02;
            this.a = new int[Ck.a((ck_0)this.d)];
            this.b = -1;
            this.c = Ck.b((ck_0)this.d) - 1;
            this.a[Ck.c((ck_0)ck_02)] = -1;
        }

        @Override
        public final boolean hasNext() {
            return this.b < this.c;
        }

        private Integer a() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i2 = Ck.c((ck_0)this.d); i2 >= 0; --i2) {
                if (this.a[i2] != Ck.d((ck_0)this.d)[i2] - 1) {
                    int n2 = i2;
                    this.a[n2] = this.a[n2] + 1;
                    break;
                }
                this.a[i2] = 0;
            }
            return ++this.b;
        }

        private int b() {
            return this.b;
        }

        private int[] c() {
            int[] nArray = this.a;
            return ch_0.a(this.a, nArray.length);
        }

        private int a(int n2) {
            return this.a[n2];
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object next() {
            a a2 = this;
            if (!a2.hasNext()) {
                throw new NoSuchElementException();
            }
            for (int i2 = Ck.c((ck_0)a2.d); i2 >= 0; --i2) {
                if (a2.a[i2] != Ck.d((ck_0)a2.d)[i2] - 1) {
                    int n2 = i2;
                    a2.a[n2] = a2.a[n2] + 1;
                    break;
                }
                a2.a[i2] = 0;
            }
            return ++a2.b;
        }
    }
}

