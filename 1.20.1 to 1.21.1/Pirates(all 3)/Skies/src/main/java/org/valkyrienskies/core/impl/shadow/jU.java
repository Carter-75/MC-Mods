/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import org.valkyrienskies.core.impl.shadow.jR;

public final class jU<E>
extends jR<E>
implements Serializable {
    private static final long a = 20150610L;

    public jU() {
        super(new HashMap());
    }

    private jU(Collection<? extends E> collection) {
        this();
        this.addAll(collection);
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        super.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a(new HashMap());
        super.a(objectInputStream);
    }
}

