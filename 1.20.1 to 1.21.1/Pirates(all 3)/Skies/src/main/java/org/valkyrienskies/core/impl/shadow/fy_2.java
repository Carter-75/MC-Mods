/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fy
 */
public interface fy_2<E>
extends Collection<E> {
    public int a(Object var1);

    public int a(E var1, int var2);

    @Override
    public boolean add(E var1);

    public int b(E var1, int var2);

    @Override
    public boolean remove(Object var1);

    public int c(Object var1, int var2);

    public Set<E> a();

    public Set<a_0<E>> b();

    @Override
    public Iterator<E> iterator();

    @Override
    public int size();

    @Override
    public boolean containsAll(Collection<?> var1);

    @Override
    public boolean removeAll(Collection<?> var1);

    @Override
    public boolean retainAll(Collection<?> var1);

    @Override
    public boolean equals(Object var1);

    @Override
    public int hashCode();
}

