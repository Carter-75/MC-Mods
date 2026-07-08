/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UInt
 *  kotlin.ULong
 *  kotlin.UShort
 *  kotlin.jvm.internal.Intrinsics
 */
package com.fasterxml.jackson.module.kotlin;

import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 5, 1}, k=2, xi=48, d1={"\u00000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u0016\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2={"", "Lkotlin/UByte;", "asUByte", "(S)Lkotlin/UByte;", "", "Lkotlin/UInt;", "asUInt", "(J)Lkotlin/UInt;", "Ljava/math/BigInteger;", "Lkotlin/ULong;", "asULong", "(Ljava/math/BigInteger;)Lkotlin/ULong;", "", "Lkotlin/UShort;", "asUShort", "(I)Lkotlin/UShort;", "uLongMaxValue", "Ljava/math/BigInteger;", "jackson-module-kotlin"})
public final class UnsignedNumbersKt {
    @NotNull
    private static final BigInteger uLongMaxValue = new BigInteger(Long.toUnsignedString(-1L));

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public static final UByte asUByte(short $this$asUByte) {
        if ($this$asUByte < 0) return null;
        int n2 = -1;
        boolean bl = false;
        short s = (short)n2;
        int n3 = 255;
        boolean bl2 = false;
        if ($this$asUByte > (short)(s & n3)) return null;
        n2 = $this$asUByte;
        bl = false;
        UByte uByte = UByte.box-impl((byte)UByte.constructor-impl((byte)((byte)n2)));
        return uByte;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public static final UShort asUShort(int $this$asUShort) {
        if ($this$asUShort < 0) return null;
        int n2 = -1;
        boolean bl = false;
        if ($this$asUShort > (n2 & 0xFFFF)) return null;
        n2 = $this$asUShort;
        bl = false;
        UShort uShort = UShort.box-impl((short)UShort.constructor-impl((short)((short)n2)));
        return uShort;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    public static final UInt asUInt(long $this$asUInt) {
        if ($this$asUInt < 0L) return null;
        int n2 = -1;
        boolean bl = false;
        if ($this$asUInt > ((long)n2 & 0xFFFFFFFFL)) return null;
        long l2 = $this$asUInt;
        boolean bl2 = false;
        UInt uInt = UInt.box-impl((int)UInt.constructor-impl((int)((int)l2)));
        return uInt;
    }

    @Nullable
    public static final ULong asULong(@NotNull BigInteger $this$asULong) {
        ULong uLong;
        Intrinsics.checkNotNullParameter((Object)$this$asULong, (String)"<this>");
        if ($this$asULong.compareTo(BigInteger.ZERO) >= 0 && $this$asULong.compareTo(uLongMaxValue) <= 0) {
            long l2 = $this$asULong.longValue();
            boolean bl = false;
            uLong = ULong.box-impl((long)ULong.constructor-impl((long)l2));
        } else {
            uLong = null;
        }
        return uLong;
    }
}

