/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Fx
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Fx;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE", "UPDATE", "DELETE"})
public final class fx_0
extends Enum<fx_0> {
    public static final /* enum */ fx_0 CREATE = new fx_0();
    public static final /* enum */ fx_0 UPDATE = new fx_0();
    public static final /* enum */ fx_0 DELETE = new fx_0();
    private static final /* synthetic */ fx_0[] $VALUES;

    public static fx_0[] values() {
        return (fx_0[])$VALUES.clone();
    }

    public static fx_0 valueOf(String value) {
        String string;
        return Enum.valueOf(fx_0.class, string);
    }

    private static final /* synthetic */ fx_0[] a() {
        fx_0[] fx_0Array = new fx_0[3];
        fx_0[] fx_0Array2 = fx_0Array;
        fx_0Array[0] = CREATE;
        fx_0Array2[1] = UPDATE;
        fx_0Array2[2] = DELETE;
        return fx_0Array2;
    }

    static {
        fx_0[] fx_0Array = new fx_0[3];
        fx_0[] fx_0Array2 = fx_0Array;
        fx_0Array[0] = CREATE;
        fx_0Array2[1] = UPDATE;
        fx_0Array2[2] = DELETE;
        $VALUES = fx_0Array2;
    }
}

