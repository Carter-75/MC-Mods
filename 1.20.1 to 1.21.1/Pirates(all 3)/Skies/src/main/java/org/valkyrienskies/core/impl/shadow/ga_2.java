/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import org.valkyrienskies.core.impl.shadow.fw_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ga
 */
public final class ga_2<E>
extends fw_1<E>
implements Serializable {
    private static final long a = -6561115435802554013L;

    public ga_2() {
        super(new HashMap());
    }

    public ga_2(Collection<? extends E> collection) {
        this();
        this.addAll(collection);
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        super.a(objectOutputStream);
    }

    private void a(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        super.a(new HashMap(), objectInputStream);
    }
}

