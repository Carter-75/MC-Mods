/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.db_0;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dj
 */
public final class dj_0 {
    public static final db_0 a(VsiConvexPolygonc object, Vector3dc vector3dc, db_0 db_02) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_02, (String)"");
        double d2 = Double.POSITIVE_INFINITY;
        double d3 = Double.NEGATIVE_INFINITY;
        for (Vector3dc vector3dc2 : object.getPoints()) {
            double d4 = vector3dc2.dot(vector3dc);
            d2 = Math.min(d2, d4);
            d3 = Math.max(d3, d4);
        }
        double d5 = d2;
        object = db_02;
        db_02.b = d5;
        d5 = d3;
        object = db_02;
        db_02.c = d5;
        return db_02;
    }
}

