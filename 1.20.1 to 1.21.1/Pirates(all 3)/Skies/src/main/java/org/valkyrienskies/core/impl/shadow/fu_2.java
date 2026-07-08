/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fu
 */
public interface fu_2<K, V>
extends Iterator<K> {
    @Override
    public boolean hasNext();

    @Override
    public K next();

    public K a();

    public V b();

    @Override
    public void remove();

    public V a(V var1);
}

