/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.tL;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class tK<T extends tL>
implements Serializable {
    private static final long a = -3442297081515880464L;
    public final List<T> b = new ArrayList<T>();

    public final void a(T t) {
        this.b.add(t);
    }

    public final List<T> b() {
        return this.b;
    }
}

