/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HV;", "", "<init>", "(Ljava/lang/String;I)V", "FLAT", "POS_X_45", "POS_Z_45", "NEG_X_45", "NEG_Z_45"})
public final class HV
extends Enum<HV> {
    public static final /* enum */ HV FLAT = new HV();
    public static final /* enum */ HV POS_X_45 = new HV();
    public static final /* enum */ HV POS_Z_45 = new HV();
    public static final /* enum */ HV NEG_X_45 = new HV();
    public static final /* enum */ HV NEG_Z_45 = new HV();
    private static final /* synthetic */ HV[] $VALUES;

    public static HV[] values() {
        return (HV[])$VALUES.clone();
    }

    public static HV valueOf(String value) {
        String string;
        return Enum.valueOf(HV.class, string);
    }

    private static final /* synthetic */ HV[] a() {
        HV[] hVArray = new HV[5];
        HV[] hVArray2 = hVArray;
        hVArray[0] = FLAT;
        hVArray2[1] = POS_X_45;
        hVArray2[2] = POS_Z_45;
        hVArray2[3] = NEG_X_45;
        hVArray2[4] = NEG_Z_45;
        return hVArray2;
    }

    static {
        HV[] hVArray = new HV[5];
        HV[] hVArray2 = hVArray;
        hVArray[0] = FLAT;
        hVArray2[1] = POS_X_45;
        hVArray2[2] = POS_Z_45;
        hVArray2[3] = NEG_X_45;
        hVArray2[4] = NEG_Z_45;
        $VALUES = hVArray2;
    }
}

