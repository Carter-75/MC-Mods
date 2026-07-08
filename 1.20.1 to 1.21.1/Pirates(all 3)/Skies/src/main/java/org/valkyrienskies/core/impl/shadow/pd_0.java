/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.oV;
import org.valkyrienskies.core.impl.shadow.px_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.pd
 */
public class pd_0
extends oV {
    private static final long b = -8415396756375798143L;
    private final Integer[] c;
    private final Integer[] d;

    private pd_0(Integer[] integerArray, Integer[] integerArray2) {
        this(px_0.DIMENSIONS_MISMATCH, integerArray, integerArray2);
    }

    public pd_0(px_0 px_02, Integer[] integerArray, Integer[] integerArray2) {
        super(px_02, integerArray, integerArray2);
        this.c = (Integer[])integerArray.clone();
        this.d = (Integer[])integerArray2.clone();
    }

    private Integer[] b() {
        return (Integer[])this.c.clone();
    }

    private Integer[] c() {
        return (Integer[])this.d.clone();
    }

    public final int a(int n2) {
        return this.c[n2];
    }

    public final int b(int n2) {
        return this.d[n2];
    }
}

