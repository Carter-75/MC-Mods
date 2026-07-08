/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.fW
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.valkyrienskies.core.impl.shadow.fW;
import org.valkyrienskies.core.impl.shadow.fn_1;
import org.valkyrienskies.core.impl.shadow.fw_1;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.fw_1<E>, not org.valkyrienskies.core.impl.shadow.fW - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.gh
 */
public final class gh_2
extends fW
implements Serializable,
fn_1 {
    private static final long a = -7740146511091606676L;

    public gh_2() {
        super(new TreeMap());
    }

    private gh_2(Comparator<? super E> comparator) {
        super(new TreeMap(comparator));
    }

    private gh_2(Collection<? extends E> collection) {
        this();
        this.addAll(collection);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean add(E object) {
        void var1_1;
        if (this.b() == null && !(object instanceof Comparable)) {
            if (object == null) {
                throw new NullPointerException();
            }
            throw new IllegalArgumentException("Objects of type " + object.getClass() + " cannot be added to a naturally ordered TreeBag as it does not implement Comparable");
        }
        return super.add((Object)var1_1);
    }

    @Override
    public final E c() {
        gh_2 gh_22 = this;
        return ((SortedMap)super.e()).firstKey();
    }

    @Override
    public final E d() {
        gh_2 gh_22 = this;
        return ((SortedMap)super.e()).lastKey();
    }

    @Override
    public final Comparator<? super E> b() {
        gh_2 gh_22 = this;
        return ((SortedMap)super.e()).comparator();
    }

    private SortedMap<E, fw_1.b> f() {
        return (SortedMap)super.e();
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.b());
        super.a(objectOutputStream);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator)objectInputStream.readObject();
        super.a(new TreeMap(comparator), objectInputStream);
    }
}

