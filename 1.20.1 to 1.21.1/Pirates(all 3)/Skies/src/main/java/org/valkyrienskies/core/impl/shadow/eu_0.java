/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.jvm.internal.Intrinsics;
import org.joml.Quaterniondc;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.bodies.properties.BodyTransformImpl;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Eu
 */
public final class eu_0 {
    public static final ShipTransform a(Vector3dc vector3dc, Vector3dc vector3dc2, Quaterniondc quaterniondc, Vector3dc vector3dc3) {
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)quaterniondc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
        return new BodyTransformImpl(vector3dc, quaterniondc, vector3dc3, vector3dc2);
    }
}

