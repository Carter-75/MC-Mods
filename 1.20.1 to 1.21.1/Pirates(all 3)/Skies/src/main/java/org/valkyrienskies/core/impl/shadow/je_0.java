/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.fd_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.jd_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.je
 */
public abstract class je_0<K, V>
extends jd_0<K, V>
implements fd_1<K, V> {
    protected je_0() {
    }

    public je_0(fd_1<K, V> fd_12) {
        super(fd_12);
    }

    protected final fd_1<K, V> a() {
        return (fd_1)super.i();
    }

    @Override
    public K firstKey() {
        je_0 je_02 = this;
        return ((fd_1)super.i()).firstKey();
    }

    @Override
    public K lastKey() {
        je_0 je_02 = this;
        return ((fd_1)super.i()).lastKey();
    }

    @Override
    public final K c(K k2) {
        je_0 je_02 = this;
        return ((fd_1)super.i()).c(k2);
    }

    @Override
    public final K d(K k2) {
        je_0 je_02 = this;
        return ((fd_1)super.i()).d(k2);
    }

    @Override
    public fe_1<K, V> e() {
        je_0 je_02 = this;
        return ((fd_1)super.i()).e();
    }

    @Override
    public /* synthetic */ fu_2 c() {
        return this.e();
    }
}

