/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dg
 */
public interface dg_0 {
    public boolean b();

    public Vector3dc c();

    public double d();

    default public Vector3d a(Vector3d vector3d) {
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
        Vector3d vector3d2 = this.c().mul(this.d(), vector3d);
        Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
        return vector3d2;
    }
}

