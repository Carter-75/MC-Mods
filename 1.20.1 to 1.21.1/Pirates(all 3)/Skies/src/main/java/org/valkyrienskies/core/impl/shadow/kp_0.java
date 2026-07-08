/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.kq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.kp
 */
public abstract class kp_0<E>
extends kq_0<E> {
    private static final long a = 1229469966212206107L;

    protected kp_0(Set<E> set) {
        super(set);
    }

    private void a(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.c());
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a((Collection)objectInputStream.readObject());
    }
}

