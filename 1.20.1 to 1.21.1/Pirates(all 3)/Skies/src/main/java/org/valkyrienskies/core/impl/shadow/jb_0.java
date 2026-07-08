/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fn_2;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.jk_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jb
 */
public abstract class jb_0<K, V>
implements fn_2<K, V> {
    @Override
    public fu_2<K, V> c() {
        return new jk_0(this.entrySet());
    }
}

