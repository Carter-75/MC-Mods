/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kO;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class uI<T extends kO<T>> {
    public final T a;
    public final T[] b;
    private final T[][] c;

    private uI(T t, T[] TArray) {
        this((kO)t, (kO[])TArray, null);
    }

    public uI(T t, T[] TArray, T[][] TArray2) {
        this.a = t;
        this.b = (kO[])TArray.clone();
        this.c = uI.a(t.c(), TArray2);
    }

    protected static T[][] a(kM<T> kOArray, T[][] TArray) {
        if (TArray == null) {
            return null;
        }
        kOArray = (kO[][])ch_0.a(kOArray, TArray.length, -1);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            kOArray[i2] = (kO[])TArray[i2].clone();
        }
        return kOArray;
    }

    public final T a() {
        return this.a;
    }

    public final int b() {
        return this.b.length;
    }

    public final T[] c() {
        return (kO[])this.b.clone();
    }

    public final int d() {
        if (this.c == null) {
            return 0;
        }
        return this.c.length;
    }

    public final int a(int n2) {
        if (n2 == 0) {
            return this.b.length;
        }
        return this.c[n2 - 1].length;
    }

    public final T[] b(int n2) {
        if (n2 == 0) {
            return (kO[])this.b.clone();
        }
        return (kO[])this.c[n2 - 1].clone();
    }
}

