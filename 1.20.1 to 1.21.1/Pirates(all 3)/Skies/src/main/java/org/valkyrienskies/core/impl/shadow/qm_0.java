/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.qp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qm
 */
public abstract class qm_0<T>
extends qp_0 {
    final List<T> a;

    public qm_0(List<T> list) {
        this(list, true);
    }

    public qm_0(T[] TArray) {
        this(Arrays.asList(TArray));
    }

    private qm_0(List<T> list, boolean bl) {
        this.a(list);
        this.a = Collections.unmodifiableList(new ArrayList<T>(list));
    }

    protected abstract void a(List<T> var1);

    protected final List<T> a() {
        return this.a;
    }

    public final int b() {
        qm_0 qm_02 = this;
        return qm_02.a.size();
    }

    public abstract qm_0<T> c();

    public String toString() {
        Object[] objectArray = new Object[2];
        objectArray[0] = this.d();
        qm_0 qm_02 = this;
        objectArray[1] = qm_02.a;
        return String.format("(f=%s %s)", objectArray);
    }
}

