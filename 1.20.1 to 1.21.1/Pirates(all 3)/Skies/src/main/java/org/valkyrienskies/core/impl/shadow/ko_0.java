/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.kr_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ko
 */
public abstract class ko_0<E>
extends kr_0<E>
implements NavigableSet<E> {
    private static final long a = 20150528L;

    protected ko_0() {
    }

    protected ko_0(NavigableSet<E> navigableSet) {
        super(navigableSet);
    }

    protected final NavigableSet<E> a() {
        return (NavigableSet)super.b();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E lower(E e2) {
        void var1_1;
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).lower(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E floor(E e2) {
        void var1_1;
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).floor(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E ceiling(E e2) {
        void var1_1;
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).ceiling(var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public E higher(E e2) {
        void var1_1;
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).higher(var1_1);
    }

    @Override
    public E pollFirst() {
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).pollFirst();
    }

    @Override
    public E pollLast() {
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).pollLast();
    }

    @Override
    public NavigableSet<E> descendingSet() {
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).descendingSet();
    }

    @Override
    public Iterator<E> descendingIterator() {
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).descendingIterator();
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        void var3_3;
        void var2_2;
        void var1_1;
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).subSet(var1_1, (boolean)var2_2, var3_3, toInclusive);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public NavigableSet<E> headSet(E toElement, boolean inclusive) {
        void var2_2;
        void var1_1;
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).headSet(var1_1, (boolean)var2_2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
        void var2_2;
        void var1_1;
        ko_0 ko_02 = this;
        return ((NavigableSet)super.b()).tailSet(var1_1, (boolean)var2_2);
    }

    @Override
    protected final /* synthetic */ Set c() {
        ko_0 ko_02 = this;
        return (NavigableSet)super.b();
    }

    @Override
    public final /* synthetic */ Collection f() {
        ko_0 ko_02 = this;
        return (NavigableSet)super.b();
    }
}

