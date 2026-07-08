/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uI;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class uJ<T extends kO<T>>
extends uI<T> {
    private final T[] c;
    private final T[][] d;

    public uJ(T t, T[] TArray, T[] TArray2) {
        this((kO)t, (kO[])TArray, (kO[])TArray2, null, null);
    }

    public uJ(T t, T[] TArray, T[] TArray2, T[][] TArray3, T[][] TArray4) {
        super(t, TArray, TArray3);
        this.c = (kO[])TArray2.clone();
        this.d = uJ.a(t.c(), TArray4);
    }

    public final T[] e() {
        return (kO[])this.c.clone();
    }

    public final T[] c(int n2) {
        if (n2 == 0) {
            return (kO[])this.c.clone();
        }
        return (kO[])this.d[n2 - 1].clone();
    }
}

