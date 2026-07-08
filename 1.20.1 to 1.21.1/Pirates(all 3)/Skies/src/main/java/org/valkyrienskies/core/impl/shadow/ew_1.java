/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eW
 */
public interface ew_1<E>
extends Collection<E> {
    public int a(Object var1);

    @Override
    public boolean add(E var1);

    public boolean a(E var1, int var2);

    @Override
    public boolean remove(Object var1);

    public boolean b(Object var1, int var2);

    public Set<E> a();

    @Override
    public int size();

    @Override
    public boolean containsAll(Collection<?> var1);

    @Override
    public boolean removeAll(Collection<?> var1);

    @Override
    public boolean retainAll(Collection<?> var1);

    @Override
    public Iterator<E> iterator();
}

