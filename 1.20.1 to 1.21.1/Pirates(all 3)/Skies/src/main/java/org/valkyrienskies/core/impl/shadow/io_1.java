/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.in_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.iO
 */
public abstract class io_1<E>
extends in_1<E> {
    private static final long a = 2684959196747496299L;

    protected io_1(List<E> list) {
        super(list);
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

