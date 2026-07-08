/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.iz_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.jo
 */
public final class jo_0<K, V>
extends iz_0<K, V>
implements Serializable,
Cloneable {
    private static final long j = -1788199231038721040L;

    public jo_0() {
        super(16, 0.75f, 12);
    }

    private jo_0(int n2) {
        super(n2);
    }

    private jo_0(int n2, float f2) {
        super(n2, f2);
    }

    private jo_0(Map<? extends K, ? extends V> map2) {
        super(map2);
    }

    private jo_0<K, V> a() {
        return (jo_0)super.i();
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a(objectInputStream);
    }

    @Override
    public final /* synthetic */ Object clone() {
        jo_0 jo_02 = this;
        return (jo_0)super.i();
    }
}

