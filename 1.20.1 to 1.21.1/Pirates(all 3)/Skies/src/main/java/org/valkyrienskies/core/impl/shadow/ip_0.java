/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ip
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ip;", "", "<init>", "(Ljava/lang/String;I)V", "EMPTY", "DENSE", "SPARSE", "DELETE"})
public final class ip_0
extends Enum<ip_0> {
    public static final /* enum */ ip_0 EMPTY = new ip_0();
    public static final /* enum */ ip_0 DENSE = new ip_0();
    public static final /* enum */ ip_0 SPARSE = new ip_0();
    public static final /* enum */ ip_0 DELETE = new ip_0();
    private static final /* synthetic */ ip_0[] $VALUES;

    public static ip_0[] values() {
        return (ip_0[])$VALUES.clone();
    }

    public static ip_0 valueOf(String value) {
        String string;
        return Enum.valueOf(ip_0.class, string);
    }

    private static final /* synthetic */ ip_0[] a() {
        ip_0[] ip_0Array = new ip_0[4];
        ip_0[] ip_0Array2 = ip_0Array;
        ip_0Array[0] = EMPTY;
        ip_0Array2[1] = DENSE;
        ip_0Array2[2] = SPARSE;
        ip_0Array2[3] = DELETE;
        return ip_0Array2;
    }

    static {
        ip_0[] ip_0Array = new ip_0[4];
        ip_0[] ip_0Array2 = ip_0Array;
        ip_0Array[0] = EMPTY;
        ip_0Array2[1] = DENSE;
        ip_0Array2[2] = SPARSE;
        ip_0Array2[3] = DELETE;
        $VALUES = ip_0Array2;
    }
}

