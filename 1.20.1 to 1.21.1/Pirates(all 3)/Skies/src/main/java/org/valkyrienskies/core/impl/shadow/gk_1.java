/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.Serializable;
import org.valkyrienskies.core.impl.shadow.ff_1;
import org.valkyrienskies.core.impl.shadow.hf_2;
import org.valkyrienskies.core.impl.shadow.hz_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gK
 */
public abstract class gk_1<T>
implements Serializable,
hz_2<T> {
    private static final long b = -3094696765038308799L;
    protected final ff_1<? super T>[] a;

    public gk_1(ff_1<? super T> ... ff_1Array) {
        this.a = ff_1Array;
    }

    @Override
    public final ff_1<? super T>[] a() {
        return hf_2.a(this.a);
    }
}

