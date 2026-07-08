/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ic
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ic;", "", "<init>", "(Ljava/lang/String;I)V", "SOLID_BOXES", "BELT"})
public final class ic_0
extends Enum<ic_0> {
    public static final /* enum */ ic_0 SOLID_BOXES = new ic_0();
    public static final /* enum */ ic_0 BELT = new ic_0();
    private static final /* synthetic */ ic_0[] $VALUES;

    public static ic_0[] values() {
        return (ic_0[])$VALUES.clone();
    }

    public static ic_0 valueOf(String value) {
        String string;
        return Enum.valueOf(ic_0.class, string);
    }

    private static final /* synthetic */ ic_0[] a() {
        ic_0[] ic_0Array = new ic_0[2];
        ic_0[] ic_0Array2 = ic_0Array;
        ic_0Array[0] = SOLID_BOXES;
        ic_0Array2[1] = BELT;
        return ic_0Array2;
    }

    static {
        ic_0[] ic_0Array = new ic_0[2];
        ic_0[] ic_0Array2 = ic_0Array;
        ic_0Array[0] = SOLID_BOXES;
        ic_0Array2[1] = BELT;
        $VALUES = ic_0Array2;
    }
}

