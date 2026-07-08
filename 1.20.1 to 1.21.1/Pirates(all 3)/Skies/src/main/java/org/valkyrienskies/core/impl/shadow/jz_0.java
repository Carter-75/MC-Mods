/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.jf
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import org.valkyrienskies.core.impl.shadow.jf;
import org.valkyrienskies.core.impl.shadow.jf_0;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.jf_0<K, V>, not org.valkyrienskies.core.impl.shadow.jf - discarding signature.
 * Renamed from org.valkyrienskies.core.impl.shadow.jz
 */
public final class jz_0
extends jf
implements Serializable {
    private static final long j = -1266190134568365852L;

    public jz_0() {
        super(jf_0.h.HARD, jf_0.h.SOFT, 16, 0.75f, false);
    }

    private jz_0(jf_0.h h2, jf_0.h h3) {
        super(h2, h3, 16, 0.75f, false);
    }

    private jz_0(jf_0.h h2, jf_0.h h3, boolean bl) {
        super(h2, h3, 16, 0.75f, bl);
    }

    private jz_0(jf_0.h h2, jf_0.h h3, int n2, float f2) {
        super(h2, h3, n2, f2, false);
    }

    private jz_0(jf_0.h h2, jf_0.h h3, int n2, float f2, boolean bl) {
        super(h2, h3, n2, f2, bl);
    }

    protected final int b(Object object) {
        return System.identityHashCode(object);
    }

    protected final int c(Object object, Object object2) {
        return System.identityHashCode(object) ^ System.identityHashCode(object2);
    }

    protected final boolean a(Object object, Object object2) {
        Object object3 = object2 = this.a(jf_0.h.HARD) ? object2 : ((Reference)object2).get();
        return object == object2;
    }

    protected final boolean b(Object object, Object object2) {
        return object == object2;
    }

    private void b(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        this.a(objectOutputStream);
    }

    private void b(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.a(objectInputStream);
    }
}

