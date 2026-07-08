/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ga
 */
public final class ga_0 {
    public static final void a(Vector3dc object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        if (!object.isFinite()) {
            object = (Vector3dc)object + " is not finite!";
            throw new IllegalArgumentException(object.toString());
        }
    }

    private static void a(Vector3dc object, Function0<String> function0) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter(function0, (String)"");
        if (!object.isFinite()) {
            object = function0.invoke();
            throw new IllegalArgumentException(object.toString());
        }
    }

    private static void a(Quaterniondc object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        if (!object.isFinite()) {
            object = (Quaterniondc)object + " is not finite!";
            throw new IllegalArgumentException(object.toString());
        }
    }

    private static void a(Quaterniondc object, Function0<String> function0) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter(function0, (String)"");
        if (!object.isFinite()) {
            object = function0.invoke();
            throw new IllegalArgumentException(object.toString());
        }
    }

    private static void b(Quaterniondc object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        if (!(Math.abs(object.lengthSquared() - 1.0) < 1.0E-12)) {
            object = (Quaterniondc)object + " is not normalized!";
            throw new IllegalArgumentException(object.toString());
        }
    }

    private static void b(Quaterniondc object, Function0<String> function0) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter(function0, (String)"");
        if (!(Math.abs(object.lengthSquared() - 1.0) < 1.0E-12)) {
            object = function0.invoke();
            throw new IllegalArgumentException(object.toString());
        }
    }
}

