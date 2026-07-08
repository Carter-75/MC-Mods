/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public final class FY {
    private static String a = "org.agrona.hints.disable.onSpinWait";
    private static final MethodHandle b;

    private FY() {
    }

    public static void a() {
        if (b != null) {
            try {
                b.invokeExact();
                return;
            }
            catch (Throwable throwable) {}
        }
    }

    static {
        MethodHandle methodHandle = null;
        if (!Boolean.getBoolean("org.agrona.hints.disable.onSpinWait")) {
            try {
                MethodHandles.Lookup lookup = MethodHandles.lookup();
                methodHandle = lookup.findStatic(Thread.class, "onSpinWait", MethodType.methodType(Void.TYPE));
            }
            catch (Exception exception) {}
        }
        b = methodHandle;
    }
}

