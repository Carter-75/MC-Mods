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
import org.valkyrienskies.core.impl.shadow.jf;
import org.valkyrienskies.core.impl.shadow.jf_0;

/*
 * Signature claims super is org.valkyrienskies.core.impl.shadow.jf_0<K, V>, not org.valkyrienskies.core.impl.shadow.jf - discarding signature.
 */
public final class jA
extends jf
implements Serializable {
    private static final long j = 1555089888138299607L;

    public jA() {
        super(jf_0.h.HARD, jf_0.h.SOFT, 16, 0.75f, false);
    }

    private jA(jf_0.h h2, jf_0.h h3) {
        super(h2, h3, 16, 0.75f, false);
    }

    private jA(jf_0.h h2, jf_0.h h3, boolean bl) {
        super(h2, h3, 16, 0.75f, bl);
    }

    private jA(jf_0.h h2, jf_0.h h3, int n2, float f2) {
        super(h2, h3, n2, f2, false);
    }

    private jA(jf_0.h h2, jf_0.h h3, int n2, float f2, boolean bl) {
        super(h2, h3, n2, f2, bl);
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

