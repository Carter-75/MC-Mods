/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.DI;

public abstract class DH<N extends DH<N>>
implements Comparable<N> {
    private static final Comparator<Comparable<Object>> a = new Comparator<Comparable<Object>>(){

        private static int a(Comparable<Object> comparable, Comparable<Object> comparable2) {
            return comparable.compareTo(comparable2);
        }

        @Override
        public final /* synthetic */ int compare(Object object, Object object2) {
            object2 = (Comparable)object2;
            object = (Comparable)object;
            return object.compareTo(object2);
        }
    };
    public N i;
    public N j;
    public N k;
    public boolean l;

    public boolean b() {
        return false;
    }

    public void c() {
    }

    public final boolean d() {
        return this.j == null;
    }

    public final N e() {
        DH<N> dH = this;
        while (dH.i != null) {
            dH = dH.i;
        }
        return (N)dH;
    }

    public final N f() {
        if (this.d()) {
            return null;
        }
        DH<N> dH = this;
        while (!((DH)dH.j).d()) {
            dH = dH.j;
        }
        return (N)dH;
    }

    public final N g() {
        if (this.d()) {
            return null;
        }
        DH<N> dH = this;
        while (!((DH)dH.k).d()) {
            dH = dH.k;
        }
        return (N)dH;
    }

    public final N h() {
        if (!((DH)this.j).d()) {
            N n2 = this.j;
            while (!((DH)((DH)n2).k).d()) {
                n2 = ((DH)n2).k;
            }
            return n2;
        }
        if (this.i == null) {
            return null;
        }
        DH<N> dH = this;
        while (dH.i != null && ((DH)dH.i).j == dH) {
            dH = dH.i;
        }
        return dH.i;
    }

    public final N i() {
        if (!((DH)this.k).d()) {
            N n2 = this.k;
            while (!((DH)((DH)n2).j).d()) {
                n2 = ((DH)n2).j;
            }
            return n2;
        }
        if (this.i == null) {
            return null;
        }
        DH<N> dH = this;
        while (dH.i != null && ((DH)dH.i).k == dH) {
            dH = dH.i;
        }
        return dH.i;
    }

    private boolean a() {
        if (this.d() || ((DH)this.k).d()) {
            throw new IllegalArgumentException("The node or its right child is a leaf");
        }
        N n2 = this.k;
        this.k = ((DH)n2).j;
        DH dH = this;
        if (!((DH)this.k).d()) {
            ((DH)this.k).i = dH;
        }
        ((DH)n2).i = this.i;
        this.i = n2;
        ((DH)n2).j = dH;
        if (((DH)n2).i != null) {
            if (((DH)((DH)n2).i).j == this) {
                ((DH)((DH)n2).i).j = n2;
            } else {
                ((DH)((DH)n2).i).k = n2;
            }
        }
        this.b();
        return ((DH)n2).b();
    }

    private boolean m() {
        if (this.d() || ((DH)this.j).d()) {
            throw new IllegalArgumentException("The node or its left child is a leaf");
        }
        N n2 = this.j;
        this.j = ((DH)n2).k;
        DH dH = this;
        if (!((DH)this.j).d()) {
            ((DH)this.j).i = dH;
        }
        ((DH)n2).i = this.i;
        this.i = n2;
        ((DH)n2).k = dH;
        if (((DH)n2).i != null) {
            if (((DH)((DH)n2).i).j == this) {
                ((DH)((DH)n2).i).j = n2;
            } else {
                ((DH)((DH)n2).i).k = n2;
            }
        }
        this.b();
        return ((DH)n2).b();
    }

    private void a(boolean bl) {
        if (!this.l) {
            throw new IllegalArgumentException("The node must be red");
        }
        boolean bl2 = bl;
        if (bl) {
            this.b();
        }
        DH<N> dH = this;
        while (dH.i != null && ((DH)dH.i).l) {
            N n2 = dH.i;
            N n3 = ((DH)n2).i;
            if (((DH)((DH)n3).j).l && ((DH)((DH)n3).k).l) {
                ((DH)((DH)n3).j).l = false;
                ((DH)((DH)n3).k).l = false;
                ((DH)n3).l = true;
                if (bl2 && (bl2 = ((DH)n2).b())) {
                    bl2 = ((DH)n3).b();
                }
                dH = n3;
                continue;
            }
            if (((DH)n2).j == dH) {
                if (((DH)n3).k == n2) {
                    ((DH)n2).m();
                    dH = n2;
                    n2 = dH.i;
                }
            } else if (((DH)n3).j == n2) {
                ((DH)n2).a();
                dH = n2;
                n2 = dH.i;
            }
            if (((DH)n2).j == dH) {
                var3_4 = ((DH)n3).m();
                if (bl) {
                    bl2 = var3_4;
                }
            } else {
                var3_4 = ((DH)n3).a();
                if (bl) {
                    bl2 = var3_4;
                }
            }
            ((DH)n2).l = false;
            ((DH)n3).l = true;
            dH = n2;
            break;
        }
        if (dH.i == null) {
            dH.l = false;
        }
        if (bl2) {
            dH = dH.i;
            while (dH != null && dH.b()) {
                dH = dH.i;
            }
        }
    }

    private void n() {
        this.a(true);
    }

    private N b(boolean bl) {
        this.a(bl);
        return this.e();
    }

    public final N j() {
        this.a(true);
        return this.e();
    }

    private static Comparator<N> o() {
        Comparator<Comparable<Object>> comparator = a;
        return comparator;
    }

    private N a(N n2, boolean bl, Comparator<? super N> comparator) {
        block6: {
            DH dH;
            block7: {
                if (this.i != null) {
                    throw new IllegalArgumentException("This is not the root of a tree");
                }
                dH = this;
                if (this.d()) {
                    ((DH)n2).l = false;
                    ((DH)n2).j = dH;
                    ((DH)n2).k = dH;
                    ((DH)n2).i = null;
                    ((DH)n2).b();
                    return n2;
                }
                if (comparator == null) {
                    comparator = a;
                }
                DH<N> dH2 = dH;
                while (true) {
                    int n3;
                    if ((n3 = comparator.compare((N)n2, (N)dH2)) < 0) {
                        if (!((DH)dH2.j).d()) {
                            dH2 = dH2.j;
                            continue;
                        }
                        ((DH)n2).j = dH2.j;
                        ((DH)n2).k = dH2.j;
                        dH2.j = n2;
                        ((DH)n2).i = dH2;
                        break block6;
                    }
                    if (n3 <= 0 && !bl) break block7;
                    if (((DH)dH2.k).d()) break;
                    dH2 = dH2.k;
                }
                ((DH)n2).j = dH2.k;
                ((DH)n2).k = dH2.k;
                dH2.k = n2;
                ((DH)n2).i = dH2;
                break block6;
            }
            ((DH)n2).i = null;
            return (N)dH;
        }
        ((DH)n2).l = true;
        return ((DH)n2).j();
    }

    private N p() {
        N n2 = this.i();
        boolean bl = ((DH)n2).l;
        N n3 = ((DH)n2).j;
        N n4 = ((DH)n2).k;
        N n5 = ((DH)n2).i;
        ((DH)n2).l = this.l;
        ((DH)n2).j = this.j;
        ((DH)n2).k = this.k;
        ((DH)n2).i = this.i;
        if (this.i != null) {
            if (((DH)this.i).j == this) {
                ((DH)this.i).j = n2;
            } else {
                ((DH)this.i).k = n2;
            }
        }
        DH dH = this;
        this.l = bl;
        this.j = n3;
        this.k = n4;
        if (n5 == this) {
            this.i = n2;
            ((DH)this.i).k = dH;
        } else {
            this.i = n5;
            ((DH)this.i).j = dH;
        }
        ((DH)((DH)n2).k).i = n2;
        if (!((DH)((DH)n2).j).d()) {
            ((DH)((DH)n2).j).i = n2;
        }
        if (!((DH)this.k).d()) {
            ((DH)this.k).i = dH;
        }
        return n2;
    }

    private void q() {
        N n2;
        boolean bl;
        boolean bl2;
        boolean bl3;
        DH<N> dH;
        block20: {
            dH = this;
            bl3 = true;
            bl2 = false;
            bl = false;
            while (true) {
                n2 = dH.i;
                if (dH.l) {
                    ((DH)n2).l = true;
                    dH.l = false;
                    if (((DH)n2).j == dH) {
                        bl3 = ((DH)n2).m();
                        dH = ((DH)n2).j;
                    } else {
                        bl3 = ((DH)n2).a();
                        dH = ((DH)n2).k;
                    }
                    bl2 = true;
                    bl = true;
                    continue;
                }
                if (((DH)dH.j).l || ((DH)dH.k).l) break;
                dH.l = true;
                if (((DH)n2).l) {
                    ((DH)n2).l = false;
                } else {
                    N n3;
                    if (bl3 && !bl2) {
                        bl3 = ((DH)n2).b();
                    }
                    if ((n3 = ((DH)n2).i) != null) {
                        dH = ((DH)n3).j == n2 ? ((DH)n3).k : ((DH)n3).j;
                        bl2 = bl;
                        bl = false;
                        continue;
                    }
                }
                break block20;
                break;
            }
            if (dH == ((DH)n2).j) {
                if (!((DH)dH.j).l) {
                    dH.a();
                    dH = dH.i;
                }
            } else if (!((DH)dH.k).l) {
                dH.m();
                dH = dH.i;
            }
            dH.l = ((DH)n2).l;
            ((DH)n2).l = false;
            if (dH == ((DH)n2).j) {
                ((DH)dH.j).l = false;
                bl3 = ((DH)n2).m();
            } else {
                ((DH)dH.k).l = false;
                bl3 = ((DH)n2).a();
            }
            bl2 = bl;
            bl = false;
        }
        n2 = dH.i;
        if (bl3 && n2 != null) {
            if (!bl2) {
                bl3 = ((DH)n2).b();
            }
            if (bl3 && ((DH)n2).i != null) {
                n2 = ((DH)n2).i;
                if (!bl) {
                    bl3 = ((DH)n2).b();
                }
                if (bl3) {
                    n2 = ((DH)n2).i;
                    while (n2 != null && ((DH)n2).b()) {
                        n2 = ((DH)n2).i;
                    }
                }
            }
        }
    }

    public final void k() {
        if (this.d()) {
            throw new IllegalArgumentException("Attempted to remove a leaf node");
        }
        DH dH = ((DH)this.j).d() || ((DH)this.k).d() ? null : (DH)this.p();
        Object object = !((DH)this.j).d() ? this.j : (!((DH)this.k).d() ? this.k : null);
        if (object != null) {
            ((DH)object).i = this.i;
            if (this.i != null) {
                if (((DH)this.i).j == this) {
                    ((DH)this.i).j = object;
                } else {
                    ((DH)this.i).k = object;
                }
            }
            ((DH)object).l = false;
            if (((DH)object).i != null) {
                object = ((DH)object).i;
                while (object != null && ((DH)object).b()) {
                    object = ((DH)object).i;
                }
            }
        } else if (this.i != null) {
            object = this.j;
            N n2 = this.i;
            if (((DH)n2).j == this) {
                ((DH)n2).j = object;
                object = ((DH)n2).k;
            } else {
                ((DH)n2).k = object;
                object = ((DH)n2).j;
            }
            if (!this.l) {
                ((DH)object).q();
            } else {
                while (n2 != null && ((DH)n2).b()) {
                    n2 = ((DH)n2).i;
                }
            }
        }
        if (dH != null) {
            dH.b();
            object = dH.i;
            while (object != null && ((DH)object).b()) {
                object = ((DH)object).i;
            }
        }
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = true;
    }

    public final N l() {
        N n2;
        if (this.d()) {
            throw new IllegalArgumentException("Attempted to remove a leaf node");
        }
        if (this.i != null) {
            n2 = this.i;
        } else if (!((DH)this.j).d()) {
            n2 = this.j;
        } else if (!((DH)this.k).d()) {
            n2 = this.k;
        } else {
            return this.j;
        }
        this.k();
        return ((DH)n2).e();
    }

    private static <N extends DH<N>> N a(Iterator<? extends N> iterator2, int n2, int n3, N n4) {
        if (n2 == 0) {
            return n4;
        }
        N n5 = DH.a(iterator2, (n2 - 1) / 2, n3 - 1, n4);
        DH dH = (DH)iterator2.next();
        iterator2 = DH.a(iterator2, n2 / 2, n3 - 1, n4);
        dH.l = n3 % 4 == 1;
        dH.j = n5;
        dH.k = iterator2;
        if (!((DH)n5).d()) {
            ((DH)n5).i = dH;
        }
        if (!((DH)((Object)iterator2)).d()) {
            ((DH)((Object)iterator2)).i = dH;
        }
        dH.b();
        return (N)dH;
    }

    public static <N extends DH<N>> N a(Collection<? extends N> collection, N n2) {
        int n3 = collection.size();
        if (n3 == 0) {
            return n2;
        }
        int n4 = 0;
        for (int i2 = n3; i2 > 0; i2 /= 2) {
            ++n4;
        }
        N n5 = DH.a(collection.iterator(), n3, n4, n2);
        ((DH)DH.a(collection.iterator(), n3, n4, n2)).i = null;
        ((DH)n5).l = false;
        return n5;
    }

    private N a(N n2, N n3, int n4, int n5) {
        DH dH;
        DH<N> dH2 = this;
        if (n4 <= n5) {
            dH = null;
            int n6 = n5;
            while (n6 > n4) {
                if (!((DH)n2).l) {
                    --n6;
                }
                dH = (DH)n2;
                n2 = ((DH)n2).j;
            }
            if (((DH)n2).l) {
                dH = (DH)n2;
                n2 = ((DH)n2).j;
            }
        } else {
            dH = null;
            int n7 = n4;
            while (n7 > n5) {
                if (!dH2.l) {
                    --n7;
                }
                dH = dH2;
                dH2 = dH2.k;
            }
            if (dH2.l) {
                dH = dH2;
                dH2 = dH2.k;
            }
        }
        ((DH)n3).l = true;
        ((DH)n3).i = dH;
        if (dH != null) {
            if (n4 < n5) {
                dH.j = n3;
            } else {
                dH.k = n3;
            }
        }
        ((DH)n3).j = dH2;
        if (!dH2.d()) {
            dH2.i = n3;
        }
        ((DH)n3).k = n2;
        if (!((DH)n2).d()) {
            ((DH)n2).i = n3;
        }
        return ((DH)n3).j();
    }

    private int r() {
        int n2 = 0;
        DH<N> dH = this;
        while (dH != null) {
            if (!dH.l) {
                ++n2;
            }
            dH = dH.k;
        }
        return n2 - 1;
    }

    public final N a(N n2, N n3) {
        if (this.i != null || ((DH)n2).i != null) {
            throw new IllegalArgumentException("The node is not the root of a tree");
        }
        return this.a(n2, n3, this.r(), ((DH)n2).r());
    }

    public final N a(N n2) {
        if (this.i != null || ((DH)n2).i != null) {
            throw new IllegalArgumentException("The node is not the root of a tree");
        }
        if (this.d()) {
            return n2;
        }
        if (((DH)n2).d()) {
            DH dH = this;
            return (N)dH;
        }
        N n3 = ((DH)n2).f();
        n2 = ((DH)n3).l();
        return this.a(n2, n3);
    }

    public final N[] a(N n2) {
        Object object;
        int n3;
        N n4;
        int n5;
        N n6;
        int n7;
        boolean bl;
        N n8;
        if (this.i != null) {
            throw new IllegalArgumentException("This is not the root of a tree");
        }
        if (this.d() || ((DH)n2).d()) {
            throw new IllegalArgumentException("The root or the split node is a leaf");
        }
        if (((DH)n2).e() != this) {
            throw new IllegalArgumentException("The split node does not belong to this tree");
        }
        if (!((DH)((DH)n2).j).d()) {
            n8 = n2;
            bl = false;
            n7 = ((DH)((DH)n2).k).r();
            n6 = ((DH)n2).j;
            n5 = n7;
            ((DH)n6).i = null;
            if (((DH)n6).l) {
                ((DH)n6).l = false;
                ++n5;
            }
            n4 = ((DH)((DH)n2).g()).k;
            n3 = 0;
        } else {
            object = n2;
            while (((DH)object).i != null && ((DH)((DH)object).i).j == object) {
                object = ((DH)object).i;
            }
            n8 = ((DH)object).i;
            bl = true;
            n7 = ((DH)object).r();
            n4 = object;
            n3 = n7;
            ((DH)n4).i = null;
            if (((DH)n4).l) {
                ((DH)n4).l = false;
                ++n3;
            }
            n6 = ((DH)n2).j;
            n5 = 0;
        }
        while (n8 != null) {
            N n9;
            object = ((DH)n8).i;
            boolean bl2 = object != null && ((DH)object).k == n8;
            int n10 = n7 + (((DH)n8).l ? 0 : 1);
            N n11 = n9 = bl ? ((DH)n8).j : ((DH)n8).k;
            if (bl && n5 >= n7 && !((DH)n8).l) {
                if (n5 > n7) {
                    ((DH)n6).l = true;
                }
                ((DH)n8).i = null;
                ((DH)n8).k = n6;
                if (!((DH)n6).d()) {
                    ((DH)n6).i = n8;
                }
                n6 = n8;
                ((DH)n6).b();
                n5 = n7 + 1;
            } else if (!bl && n3 >= n7 && !((DH)n8).l) {
                if (n3 > n7) {
                    ((DH)n4).l = true;
                }
                ((DH)n8).i = null;
                ((DH)n8).j = n4;
                if (!((DH)n4).d()) {
                    ((DH)n4).i = n8;
                }
                n4 = n8;
                ((DH)n4).b();
                n3 = n7 + 1;
            } else {
                boolean bl3;
                ((DH)n9).i = null;
                if (((DH)n9).l) {
                    ((DH)n9).l = false;
                    ++n7;
                }
                boolean bl4 = bl3 = !((DH)n9).d() && ((DH)((DH)n9).j).l && ((DH)((DH)n9).k).l;
                if (bl) {
                    n6 = ((DH)n9).a(n6, n8, n7, n5);
                    n5 = n5 >= n7 || bl3 && !((DH)((DH)n6).j).l ? n7 + 1 : n7;
                } else {
                    n4 = ((DH)n4).a(n9, n8, n3, n7);
                    n3 = n3 >= n7 || bl3 && !((DH)((DH)n4).j).l ? n7 + 1 : n7;
                }
            }
            n8 = object;
            bl = bl2;
            n7 = n10;
        }
        DH[] dHArray = (DH[])Array.newInstance(this.getClass(), 2);
        object = dHArray;
        dHArray[0] = n6;
        object[1] = n4;
        return object;
    }

    private int c(N n2) {
        if (this.d() || ((DH)n2).d()) {
            throw new IllegalArgumentException("One of the nodes is a leaf node");
        }
        int n3 = 0;
        DH<N> dH = this;
        int n4 = 0;
        block0: while (dH.i != null && ((DH)n2).i != null) {
            do {
                dH = dH.i;
                ++n3;
                if (dH != n2) continue;
                return n3 - n4;
            } while (dH.i != null && n3 < 2 * n4);
            while (n4 < 2 * n3) {
                n2 = ((DH)n2).i;
                ++n4;
                if (n2 == dH) {
                    return n3 - n4;
                }
                if (((DH)n2).i != null) continue;
                continue block0;
            }
        }
        while (dH.i != null) {
            dH = dH.i;
            ++n3;
        }
        while (((DH)n2).i != null) {
            n2 = ((DH)n2).i;
            ++n4;
        }
        if (dH != n2) {
            throw new IllegalArgumentException("The nodes do not belong to the same tree");
        }
        return n3 - n4;
    }

    private N d(N n2) {
        int n3 = this.c(n2);
        DH<N> dH = this;
        if (n3 >= 0) {
            for (var4_4 = 0; var4_4 < n3; ++var4_4) {
                dH = dH.i;
            }
        } else {
            for (var4_4 = 0; var4_4 < -n3; ++var4_4) {
                n2 = ((DH)n2).i;
            }
        }
        while (dH != n2) {
            dH = dH.i;
            n2 = ((DH)n2).i;
        }
        return n2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final int b(N n2) {
        void var3_7;
        N n3;
        block13: {
            int n4;
            if (this == n2) {
                return 0;
            }
            int n5 = this.c(n2);
            DH dH = this;
            n3 = n2;
            if (n5 > 0) {
                void var3_4;
                n4 = 0;
                while (n4 + 1 < n5) {
                    N n6 = var3_4.i;
                    ++n4;
                }
                if (var3_4.i != n2) {
                    N n7 = var3_4.i;
                    break block13;
                } else {
                    if (((DH)n2).j == var3_4) {
                        return -1;
                    }
                    return 1;
                }
            }
            if (n5 < 0) {
                n4 = 0;
                while (n4 + 1 < -n5) {
                    n3 = ((DH)n3).i;
                    ++n4;
                }
                if (((DH)n3).i != this) {
                    n3 = ((DH)n3).i;
                } else {
                    if (this.j == n3) {
                        return 1;
                    }
                    return -1;
                }
            }
        }
        while (var3_7.i != ((DH)n3).i) {
            N n8 = var3_7.i;
            n3 = ((DH)n3).i;
        }
        if (((DH)var3_7.i).j == var3_7) {
            return -1;
        }
        return 1;
    }

    private void s() {
        if (this.j != null || this.k != null || this.i != null || this.l) {
            throw new RuntimeException("A leaf node's \"left\", \"right\", \"parent\", or isRed field is incorrect");
        }
    }

    private void a(int n2, Set<DI<N>> set) {
        while (true) {
            DH<N> dH = dH2;
            if (dH2.j == null || dH2.k == null) {
                dH2.s();
                if (n2 != 1) {
                    throw new RuntimeException("Not all root-to-leaf paths have the same number of black nodes");
                }
                return;
            }
            if (!set.add(new DI<DH>(dH))) {
                throw new RuntimeException("The tree contains a repeated non-leaf node");
            }
            if (dH2.l) {
                if (!((DH)dH2.j).d() && ((DH)dH2.j).l || !((DH)dH2.k).d() && ((DH)dH2.k).l) {
                    throw new RuntimeException("A red node has a red child");
                }
            } else {
                if (n2 == 0) {
                    throw new RuntimeException("Not all root-to-leaf paths have the same number of black nodes");
                }
                --n2;
            }
            if (!((DH)dH2.j).d() && ((DH)dH2.j).i != dH2) {
                throw new RuntimeException("left.parent != this");
            }
            if (!((DH)dH2.k).d() && ((DH)dH2.k).i != dH2) {
                throw new RuntimeException("right.parent != this");
            }
            dH = dH2.j;
            N n3 = dH2.k;
            dH.a(n2, set);
            DH<N> dH2 = n3;
        }
    }

    private void t() {
        while (true) {
            dH.c();
            if (dH.j == null) break;
            N n2 = dH.j;
            N n3 = dH.k;
            ((DH)n2).t();
            DH<N> dH = n3;
        }
    }

    private void u() {
        if (this.d()) {
            this.s();
            return;
        }
        if (this.i == null && this.l) {
            throw new RuntimeException("The root is red");
        }
        HashSet<DI<DH>> hashSet = new HashSet<DI<DH>>();
        int n2 = 0;
        DH<N> dH = this;
        while (dH != null) {
            if (!hashSet.add(new DI<DH>(dH))) {
                throw new RuntimeException("The tree contains a repeated non-leaf node");
            }
            if (!dH.l) {
                ++n2;
            }
            dH = dH.j;
        }
        this.a(n2, (Set<DI<N>>)new HashSet<DI<N>>());
    }

    private void v() {
        DH dH = this;
        if (dH.d()) {
            dH.s();
        } else {
            if (dH.i == null && dH.l) {
                throw new RuntimeException("The root is red");
            }
            HashSet<DI<DH>> hashSet = new HashSet<DI<DH>>();
            int n2 = 0;
            DH<N> dH2 = dH;
            while (dH2 != null) {
                if (!hashSet.add(new DI<DH>(dH2))) {
                    throw new RuntimeException("The tree contains a repeated non-leaf node");
                }
                if (!dH2.l) {
                    ++n2;
                }
                dH2 = dH2.j;
            }
            dH.a(n2, (Set<DI<N>>)new HashSet<DI<N>>());
        }
        this.t();
    }

    private void a(Comparator<? super N> comparator, N object, N n2) {
        while (!dH3.d()) {
            DH dH = dH3;
            if (object != null && comparator.compare(dH, object) < 0) {
                throw new RuntimeException("The nodes are not ordered correctly");
            }
            if (n2 != null && comparator.compare(dH, n2) > 0) {
                throw new RuntimeException("The nodes are not ordered correctly");
            }
            DH dH2 = dH3.j;
            N n3 = dH3.k;
            dH2.a(comparator, object, (DH)dH);
            object = dH;
            DH<N> dH3 = n3;
        }
    }

    private void a(Comparator<? super N> comparator) {
        if (comparator == null) {
            comparator = a;
        }
        this.a(comparator, null, null);
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.b((DH)object);
    }
}

