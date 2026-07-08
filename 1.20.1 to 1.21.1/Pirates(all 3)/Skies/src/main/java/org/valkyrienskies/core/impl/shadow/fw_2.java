/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import org.valkyrienskies.core.impl.shadow.fn_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fw
 */
@Deprecated
public interface fw_2<K, V>
extends fn_2<K, Object> {
    public boolean a(K var1, V var2);

    @Override
    public int size();

    @Override
    public Object get(Object var1);

    @Override
    public boolean containsValue(Object var1);

    @Override
    public Object put(K var1, Object var2);

    @Override
    public Object remove(Object var1);

    @Override
    public Collection<Object> values();
}

