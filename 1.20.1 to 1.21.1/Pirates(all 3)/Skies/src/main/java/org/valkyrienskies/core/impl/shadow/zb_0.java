/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.zb
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.zb;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.zb
 */
@Deprecated
public enum zb_0 {
    EQ("="),
    LEQ("<="),
    GEQ(">=");

    private final String stringValue;

    private zb_0(String string2) {
        this.stringValue = string2;
    }

    public final String toString() {
        return this.stringValue;
    }

    public final zb_0 a() {
        switch (1.a[this.ordinal()]) {
            case 1: {
                return GEQ;
            }
            case 2: {
                return LEQ;
            }
        }
        return EQ;
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[zb.values().length];
            try {
                1.a[zb.LEQ.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[zb.GEQ.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}

