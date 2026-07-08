/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.valkyrienskies.core.impl.shadow.BM;
import org.valkyrienskies.core.impl.shadow.BR;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oY;
import org.valkyrienskies.core.impl.shadow.po_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class BQ
implements Iterable<int[]> {
    private final int a;
    private final int b;
    private final int c;

    public BQ(int n2, int n3) {
        this(n2, n3, org.valkyrienskies.core.impl.shadow.BQ$a.LEXICOGRAPHIC$6aecea3e);
    }

    private BQ(int n2, int n3, int n4) {
        BR.e(n2, n3);
        this.a = n2;
        this.b = n3;
        this.c = n4;
    }

    private int a() {
        return this.a;
    }

    private int b() {
        return this.b;
    }

    @Override
    public final Iterator<int[]> iterator() {
        if (this.b == 0 || this.b == this.a) {
            return new d(ch_0.a(this.b));
        }
        switch (1.a[this.c - 1]) {
            case 1: {
                return new c(this.a, this.b);
            }
        }
        throw new oY();
    }

    private Comparator<int[]> c() {
        return new b(this.a, this.b);
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[org.valkyrienskies.core.impl.shadow.BQ$a.values$40fb79f8().length];
            try {
                1.a[org.valkyrienskies.core.impl.shadow.BQ$a.LEXICOGRAPHIC$6aecea3e - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class b
    implements Serializable,
    Comparator<int[]> {
        private static final long a = 20130906L;
        private final int b;
        private final int c;

        b(int n2, int n3) {
            this.b = n2;
            this.c = n3;
        }

        private int a(int[] nArray, int[] nArray2) {
            if (nArray.length != this.c) {
                throw new oS(nArray.length, this.c);
            }
            if (nArray2.length != this.c) {
                throw new oS(nArray2.length, this.c);
            }
            int[] nArray3 = nArray;
            nArray = ch_0.a(nArray, nArray3.length);
            Arrays.sort(nArray);
            nArray3 = nArray2;
            nArray2 = ch_0.a(nArray2, nArray3.length);
            Arrays.sort(nArray2);
            long l2 = this.a(nArray);
            long l3 = this.a(nArray2);
            if (l2 < l3) {
                return -1;
            }
            if (l2 > l3) {
                return 1;
            }
            return 0;
        }

        private long a(int[] nArray) {
            long l2 = 0L;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int n2 = nArray[i2];
                if (n2 < 0 || n2 >= this.b) {
                    throw new po_0(n2, (Number)0, this.b - 1);
                }
                l2 += (long)(nArray[i2] * BM.e(this.b, i2));
            }
            return l2;
        }

        @Override
        public final /* synthetic */ int compare(Object object, Object object2) {
            int[] nArray = (int[])object2;
            object2 = (int[])object;
            object = this;
            if (((Object)object2).length != ((b)object).c) {
                throw new oS(((Object)object2).length, ((b)object).c);
            }
            if (nArray.length != ((b)object).c) {
                throw new oS(nArray.length, ((b)object).c);
            }
            Object object3 = object2;
            int[] nArray2 = ch_0.a((int[])object3, ((Object)object3).length);
            object2 = nArray2;
            Arrays.sort(nArray2);
            object3 = nArray;
            nArray = ch_0.a(nArray, ((Object)object3).length);
            Arrays.sort(nArray);
            long l2 = super.a((int[])object2);
            long l3 = super.a(nArray);
            if (l2 < l3) {
                return -1;
            }
            if (l2 > l3) {
                return 1;
            }
            return 0;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class d
    implements Iterator<int[]> {
        private final int[] a;
        private boolean b = true;

        d(int[] nArray) {
            this.a = nArray;
        }

        @Override
        public final boolean hasNext() {
            return this.b;
        }

        private int[] a() {
            if (this.b) {
                this.b = false;
                return this.a;
            }
            throw new NoSuchElementException();
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object next() {
            d d2 = this;
            if (d2.b) {
                d2.b = false;
                return d2.a;
            }
            throw new NoSuchElementException();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class c
    implements Iterator<int[]> {
        private final int a;
        private final int[] b;
        private boolean c = true;
        private int d;

        c(int n2, int n3) {
            this.a = n3;
            this.b = new int[n3 + 3];
            if (n3 == 0 || n3 >= n2) {
                this.c = false;
                return;
            }
            int n4 = 1;
            while (n4 <= n3) {
                int n5 = n4++;
                this.b[n5] = n5 - 1;
            }
            this.b[n3 + 1] = n2;
            this.b[n3 + 2] = 0;
            this.d = n3;
        }

        @Override
        public final boolean hasNext() {
            return this.c;
        }

        private int[] a() {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            int[] nArray = new int[this.a];
            System.arraycopy(this.b, 1, nArray, 0, this.a);
            int n2 = 0;
            if (this.d > 0) {
                this.b[this.d] = n2 = this.d;
                --this.d;
                return nArray;
            }
            if (this.b[1] + 1 < this.b[2]) {
                this.b[1] = this.b[1] + 1;
                return nArray;
            }
            this.d = 2;
            boolean bl = false;
            while (!bl) {
                this.b[this.d - 1] = this.d - 2;
                n2 = this.b[this.d] + 1;
                if (n2 == this.b[this.d + 1]) {
                    ++this.d;
                    continue;
                }
                bl = true;
            }
            if (this.d > this.a) {
                this.c = false;
                return nArray;
            }
            this.b[this.d] = n2;
            --this.d;
            return nArray;
        }

        @Override
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public final /* synthetic */ Object next() {
            c c2 = this;
            if (!c2.c) {
                throw new NoSuchElementException();
            }
            int[] nArray = new int[c2.a];
            System.arraycopy(c2.b, 1, nArray, 0, c2.a);
            int n2 = 0;
            if (c2.d > 0) {
                n2 = c2.d;
            } else {
                if (c2.b[1] + 1 < c2.b[2]) {
                    c2.b[1] = c2.b[1] + 1;
                    return nArray;
                }
                c2.d = 2;
                boolean bl = false;
                while (!bl) {
                    c2.b[c2.d - 1] = c2.d - 2;
                    n2 = c2.b[c2.d] + 1;
                    if (n2 == c2.b[c2.d + 1]) {
                        ++c2.d;
                        continue;
                    }
                    bl = true;
                }
                if (c2.d > c2.a) {
                    c2.c = false;
                    return nArray;
                }
            }
            c2.b[c2.d] = n2;
            --c2.d;
            return nArray;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a
    extends Enum<a> {
        public static final int LEXICOGRAPHIC$6aecea3e = 1;
        private static final /* synthetic */ int[] $VALUES$47939f79;

        public static int[] values$40fb79f8() {
            return (int[])$VALUES$47939f79.clone();
        }

        private a() {
        }

        static {
            $VALUES$47939f79 = new int[]{LEXICOGRAPHIC$6aecea3e};
        }
    }
}

