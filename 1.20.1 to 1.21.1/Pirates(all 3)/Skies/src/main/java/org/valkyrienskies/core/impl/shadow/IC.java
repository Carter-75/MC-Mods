/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0007\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/IC;", "", "", "solverType", "I", "getSolverType", "()I", "p0", "<init>", "(Ljava/lang/String;II)V", "GAUSS_SEIDEL", "JACOBI"})
public final class IC
extends Enum<IC> {
    private final int solverType;
    public static final /* enum */ IC GAUSS_SEIDEL = new IC(0);
    public static final /* enum */ IC JACOBI = new IC(1);
    private static final /* synthetic */ IC[] $VALUES;

    private IC(int n3) {
        this.solverType = n3;
    }

    @JvmName(name="getSolverType")
    public final int getSolverType() {
        return this.solverType;
    }

    public static IC[] values() {
        return (IC[])$VALUES.clone();
    }

    public static IC valueOf(String value) {
        String string;
        return Enum.valueOf(IC.class, string);
    }

    private static final /* synthetic */ IC[] a() {
        IC[] iCArray = new IC[2];
        IC[] iCArray2 = iCArray;
        iCArray[0] = GAUSS_SEIDEL;
        iCArray2[1] = JACOBI;
        return iCArray2;
    }

    static {
        IC[] iCArray = new IC[2];
        IC[] iCArray2 = iCArray;
        iCArray[0] = GAUSS_SEIDEL;
        iCArray2[1] = JACOBI;
        $VALUES = iCArray2;
    }
}

