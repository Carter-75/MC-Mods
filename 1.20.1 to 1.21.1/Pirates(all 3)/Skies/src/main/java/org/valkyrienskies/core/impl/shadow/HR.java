/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;

@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2={"Lorg/valkyrienskies/core/impl/shadow/HR;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "START", "PERSIST", "END"})
public final class HR
extends Enum<HR> {
    public static final /* enum */ HR UNKNOWN = new HR();
    public static final /* enum */ HR START = new HR();
    public static final /* enum */ HR PERSIST = new HR();
    public static final /* enum */ HR END = new HR();
    private static final /* synthetic */ HR[] $VALUES;

    public static HR[] values() {
        return (HR[])$VALUES.clone();
    }

    public static HR valueOf(String value) {
        String string;
        return Enum.valueOf(HR.class, string);
    }

    private static final /* synthetic */ HR[] a() {
        HR[] hRArray = new HR[4];
        HR[] hRArray2 = hRArray;
        hRArray[0] = UNKNOWN;
        hRArray2[1] = START;
        hRArray2[2] = PERSIST;
        hRArray2[3] = END;
        return hRArray2;
    }

    static {
        HR[] hRArray = new HR[4];
        HR[] hRArray2 = hRArray;
        hRArray[0] = UNKNOWN;
        hRArray2[1] = START;
        hRArray2[2] = PERSIST;
        hRArray2[3] = END;
        $VALUES = hRArray2;
    }
}

