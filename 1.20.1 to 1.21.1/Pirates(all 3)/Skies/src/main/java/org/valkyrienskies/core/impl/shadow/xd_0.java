/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.xd
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.xd;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.xd
 */
public enum xd_0 {
    EQ("="),
    LEQ("<="),
    GEQ(">=");

    private final String stringValue;

    private xd_0(String string2) {
        this.stringValue = string2;
    }

    public final String toString() {
        return this.stringValue;
    }

    public final xd_0 a() {
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
            a = new int[xd.values().length];
            try {
                1.a[xd.LEQ.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[xd.GEQ.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }
}

