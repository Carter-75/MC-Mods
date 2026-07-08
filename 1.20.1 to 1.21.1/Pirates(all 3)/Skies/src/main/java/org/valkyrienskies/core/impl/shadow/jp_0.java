/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.iZ
 *  org.valkyrienskies.core.impl.shadow.jc
 *  org.valkyrienskies.core.impl.shadow.jc$c
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.fa_2;
import org.valkyrienskies.core.impl.shadow.iZ;
import org.valkyrienskies.core.impl.shadow.iz_0;
import org.valkyrienskies.core.impl.shadow.jc;
import org.valkyrienskies.core.impl.shadow.jc_0;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.jc_0<K, V>, not org.valkyrienskies.core.impl.shadow.jc - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.jp
 */
public final class jp_0
extends jc
implements Serializable,
Cloneable,
fa_2 {
    private static final long k = -612114643488955218L;
    private static int l = 100;
    private transient int m;
    private boolean n;

    public jp_0() {
        this(100, 0.75f, false);
    }

    private jp_0(int n2) {
        this(n2, 0.75f);
    }

    private jp_0(int n2, int n3) {
        this(n2, n3, 0.75f);
    }

    private jp_0(int n2, boolean bl) {
        this(n2, 0.75f, bl);
    }

    private jp_0(int n2, float f2) {
        this(n2, 0.75f, false);
    }

    private jp_0(int n2, int n3, float f2) {
        this(n2, n3, 0.75f, false);
    }

    private jp_0(int n2, float f2, boolean bl) {
        int n3 = n2;
        this(n3, n3, f2, bl);
    }

    private jp_0(int n2, int n3, float f2, boolean bl) {
        super(n3, f2);
        if (n2 <= 0) {
            throw new IllegalArgumentException("LRUMap max size must be greater than 0");
        }
        if (n3 > n2) {
            throw new IllegalArgumentException("LRUMap initial size must not be greather than max size");
        }
        this.m = n2;
        this.n = bl;
    }

    private jp_0(Map<? extends K, ? extends V> map2) {
        this(map2, false);
    }

    private jp_0(Map<? extends K, ? extends V> map2, boolean bl) {
        this(map2.size(), 0.75f, false);
        this.putAll(map2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final V get(Object key) {
        void var1_1;
        boolean bl = true;
        jc_0.c_0 c_02 = var1_1;
        jp_0 jp_02 = this;
        if ((c_02 = jp_02.f(c_02)) == null) {
            return null;
        }
        jp_02.a(c_02);
        return c_02.getValue();
    }

    private V a(Object object, boolean bl) {
        if ((object = this.f(object)) == null) {
            return null;
        }
        this.a((jc_0.c_0)object);
        return ((iz_0.c)object).getValue();
    }

    private void a(jc_0.c_0<K, V> c_02) {
        if (((jc.c)c_02).f != this.j) {
            ++((iZ)this).f;
            if (((jc.c)c_02).e == null) {
                throw new IllegalStateException("Entry.before is null. Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
            }
            ((jc.c)((jc.c)c_02).e).f = ((jc.c)c_02).f;
            ((jc.c)((jc.c)c_02).f).e = ((jc.c)c_02).e;
            ((jc.c)c_02).f = this.j;
            ((jc.c)c_02).e = ((jc.c)this.j).e;
            ((jc.c)((jc.c)this.j).e).f = c_02;
            ((jc.c)this.j).e = c_02;
            return;
        }
        if (c_02 == this.j) {
            throw new IllegalStateException("Can't move header to MRU (please report this to dev@commons.apache.org)");
        }
    }

    protected final void a(iz_0.c<K, V> c2, V v) {
        this.a((jc_0.c_0)((jc.c)c2));
        c2.setValue(v);
    }

    protected final void a(int n2, int n3, K k2, V object) {
        Object object2 = this;
        if (((iZ)object2).c >= ((jp_0)object2).m) {
            object2 = ((jc.c)this.j).f;
            boolean bl = false;
            if (this.n) {
                if (object2 != this.j && object2 != null) {
                    bl = true;
                }
                if (object2 == null) {
                    throw new IllegalStateException("Entry.after=null, header.after" + ((jc.c)this.j).f + " header.before" + ((jc.c)this.j).e + " key=" + k2 + " value=" + object + " size=" + ((iZ)this).c + " maxSize=" + this.m + " Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
                }
            } else {
                bl = true;
            }
            if (bl) {
                if (object2 == null) {
                    throw new IllegalStateException("reuse=null, header.after=" + ((jc.c)this.j).f + " header.before" + ((jc.c)this.j).e + " key=" + k2 + " value=" + object + " size=" + ((iZ)this).c + " maxSize=" + this.m + " Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
                }
                Object v = object;
                object = k2;
                int n4 = n3;
                n3 = n2;
                Object object3 = object2;
                object2 = this;
                try {
                    int n5 = ((iZ)object2).d.length;
                    int n6 = ((iz_0.c)object3).b;
                    Object object4 = ((iZ)object2).d;
                    object4 = ((iZ)object2).d[n6 &= n5 - 1];
                    Object object5 = null;
                    while (object4 != object3 && object4 != null) {
                        object5 = object4;
                        object4 = object4.a;
                    }
                    if (object4 == null) {
                        throw new IllegalStateException("Entry.next=null, data[removeIndex]=" + ((iZ)object2).d[n6] + " previous=" + object5 + " key=" + object + " value=" + v + " size=" + ((iZ)object2).c + " maxSize=" + ((jp_0)object2).m + " Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
                    }
                    ++((iZ)object2).f;
                    object2.b((iz_0.c)object3, n6, (iz_0.c)object5);
                    object2.a((jc_0.c_0)object3, n3, n4, object, v);
                    ((jp_0)object2).a((iz_0.c)object3, n3);
                }
                catch (NullPointerException nullPointerException) {
                    throw new IllegalStateException("NPE, entry=" + object3 + " entryIsHeader=" + (object3 == ((jc)object2).j) + " key=" + object + " value=" + v + " size=" + ((iZ)object2).c + " maxSize=" + ((jp_0)object2).m + " Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
                }
            } else {
                super.a(n2, n3, k2, object);
            }
            return;
        }
        super.a(n2, n3, k2, object);
    }

    private void b(jc_0.c_0<K, V> c_02, int n2, int n3, K k2, V v) {
        try {
            int n4 = ((iZ)this).d.length;
            int n5 = c_02.b;
            Object object = ((iZ)this).d;
            object = ((iZ)this).d[n5 &= n4 - 1];
            Object object2 = null;
            while (object != c_02 && object != null) {
                object2 = object;
                object = object.a;
            }
            if (object == null) {
                throw new IllegalStateException("Entry.next=null, data[removeIndex]=" + ((iZ)this).d[n5] + " previous=" + object2 + " key=" + k2 + " value=" + v + " size=" + ((iZ)this).c + " maxSize=" + this.m + " Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
            }
            ++((iZ)this).f;
            this.b(c_02, n5, (iz_0.c)object2);
            this.a(c_02, n2, n3, k2, v);
            this.a(c_02, n2);
            return;
        }
        catch (NullPointerException nullPointerException) {
            throw new IllegalStateException("NPE, entry=" + c_02 + " entryIsHeader=" + (c_02 == this.j) + " key=" + k2 + " value=" + v + " size=" + ((iZ)this).c + " maxSize=" + this.m + " Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to dev@commons.apache.org as a bug.");
        }
    }

    private static boolean j() {
        return true;
    }

    @Override
    public final boolean a() {
        return ((iZ)this).c >= this.m;
    }

    @Override
    public final int b() {
        return this.m;
    }

    private boolean k() {
        return this.n;
    }

    private jp_0<K, V> l() {
        return (jp_0)((Object)super.i());
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a(objectInputStream);
    }

    protected final void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.m);
        super.a(objectOutputStream);
    }

    protected final void a(ObjectInputStream objectInputStream) {
        this.m = objectInputStream.readInt();
        super.a(objectInputStream);
    }

    public final /* synthetic */ Object clone() {
        jp_0 jp_02 = this;
        return (jp_0)((Object)super.i());
    }
}

