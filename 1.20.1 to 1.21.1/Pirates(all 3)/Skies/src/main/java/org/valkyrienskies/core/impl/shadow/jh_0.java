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
 * Renamed from org.valkyrienskies.core.impl.shadow.jh
 */
public final class jh_0<K, V>
extends iz_0<K, V>
implements Serializable,
Cloneable {
    private static final long j = -7074655917369299456L;

    public jh_0() {
        super(16, 0.75f, 12);
    }

    private jh_0(int n2) {
        super(n2);
    }

    private jh_0(int n2, float f2) {
        super(n2, f2);
    }

    private jh_0(Map<? extends K, ? extends V> map2) {
        super(map2);
    }

    @Override
    protected final Object a(Object object) {
        if (object != null) {
            object = object.toString().toCharArray();
            for (int i2 = (v1067092).length - 1; i2 >= 0; --i2) {
                object[i2] = Character.toLowerCase(Character.toUpperCase((char)object[i2]));
            }
            return new String((char[])object);
        }
        return iz_0.a;
    }

    private jh_0<K, V> a() {
        return (jh_0)super.i();
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
        jh_0 jh_02 = this;
        return (jh_0)super.i();
    }
}

