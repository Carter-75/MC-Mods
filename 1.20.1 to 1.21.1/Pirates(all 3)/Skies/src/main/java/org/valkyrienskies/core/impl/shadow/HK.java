/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HK;", "", "<init>", "(Ljava/lang/String;I)V", "FIXED", "DISTANCE", "SPHERICAL", "REVOLUTE", "PRISMATIC", "GEAR", "RACK_AND_PINION", "D6"})
public final class HK
extends Enum<HK> {
    public static final /* enum */ HK FIXED = new HK();
    public static final /* enum */ HK DISTANCE = new HK();
    public static final /* enum */ HK SPHERICAL = new HK();
    public static final /* enum */ HK REVOLUTE = new HK();
    public static final /* enum */ HK PRISMATIC = new HK();
    public static final /* enum */ HK GEAR = new HK();
    public static final /* enum */ HK RACK_AND_PINION = new HK();
    public static final /* enum */ HK D6 = new HK();
    private static final /* synthetic */ HK[] $VALUES;

    public static HK[] values() {
        return (HK[])$VALUES.clone();
    }

    public static HK valueOf(String value) {
        String string;
        return Enum.valueOf(HK.class, string);
    }

    private static final /* synthetic */ HK[] a() {
        HK[] hKArray = new HK[8];
        HK[] hKArray2 = hKArray;
        hKArray[0] = FIXED;
        hKArray2[1] = DISTANCE;
        hKArray2[2] = SPHERICAL;
        hKArray2[3] = REVOLUTE;
        hKArray2[4] = PRISMATIC;
        hKArray2[5] = GEAR;
        hKArray2[6] = RACK_AND_PINION;
        hKArray2[7] = D6;
        return hKArray2;
    }

    static {
        HK[] hKArray = new HK[8];
        HK[] hKArray2 = hKArray;
        hKArray[0] = FIXED;
        hKArray2[1] = DISTANCE;
        hKArray2[2] = SPHERICAL;
        hKArray2[3] = REVOLUTE;
        hKArray2[4] = PRISMATIC;
        hKArray2[5] = GEAR;
        hKArray2[6] = RACK_AND_PINION;
        hKArray2[7] = D6;
        $VALUES = hKArray2;
    }
}

