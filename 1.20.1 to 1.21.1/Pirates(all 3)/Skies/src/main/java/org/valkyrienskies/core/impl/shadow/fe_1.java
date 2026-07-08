/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fc_1;
import org.valkyrienskies.core.impl.shadow.fu_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fE
 */
public interface fe_1<K, V>
extends fc_1<K>,
fu_2<K, V> {
    @Override
    public boolean hasPrevious();

    @Override
    public K previous();
}

