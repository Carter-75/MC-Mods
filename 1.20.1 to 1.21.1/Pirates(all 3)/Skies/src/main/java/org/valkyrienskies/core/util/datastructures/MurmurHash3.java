/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.util.datastructures;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\n\u00a8\u0006\u0012"}, d2={"Lorg/valkyrienskies/core/util/datastructures/MurmurHash3;", "", "", "hash", "fmix32", "(I)I", "k", "mix32", "(II)I", "C1_32", "I", "C2_32", "M_32", "N_32", "R1_32", "R2_32", "<init>", "()V", "util"})
public final class MurmurHash3 {
    @NotNull
    public static final MurmurHash3 INSTANCE = new MurmurHash3();
    private static final int C1_32 = -862048943;
    private static final int C2_32 = 461845907;
    private static final int R1_32 = 15;
    private static final int R2_32 = 13;
    private static final int M_32 = 5;
    private static final int N_32 = -430675100;

    private MurmurHash3() {
    }

    public final int mix32(int k2, int hash) {
        int k3 = k2;
        int hash2 = hash;
        k3 *= -862048943;
        k3 = Integer.rotateLeft(k3, 15);
        return Integer.rotateLeft(hash2 ^= (k3 *= 461845907), 13) * 5 + -430675100;
    }

    public final int fmix32(int hash) {
        int hash2 = hash;
        hash2 ^= hash2 >>> 16;
        hash2 *= -2048144789;
        hash2 ^= hash2 >>> 13;
        hash2 *= -1028477387;
        hash2 ^= hash2 >>> 16;
        return hash2;
    }
}

