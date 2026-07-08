/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Hd
 */
@Metadata(mv={1, 6, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fR\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2={"Lorg/valkyrienskies/physics_api/RayCastResult;", "", "", "getDistance", "()D", "distance", "", "Lorg/valkyrienskies/physics_api/PhysicsBodyId;", "getHitBodyId", "()I", "hitBodyId", "Lorg/joml/Vector3dc;", "getHitNormal", "()Lorg/joml/Vector3dc;", "hitNormal", "Companion", "physics_api"})
public interface hd_0 {
    public static final a a = org.valkyrienskies.core.impl.shadow.Hd$a.a;

    @JvmName(name="a")
    public int a();

    @JvmName(name="b")
    public double b();

    @JvmName(name="c")
    public Vector3dc c();

    public static final class a {
        static final /* synthetic */ a a;

        private a() {
        }

        private static Vector3d a(hd_0 object, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3d, (String)"");
            object = vector3d.set(vector3dc).fma(object.b(), vector3dc2);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
            return object;
        }

        private static /* synthetic */ Vector3d a(a object, hd_0 object2, Vector3dc vector3dc, Vector3dc vector3dc2, Vector3d vector3d, int n2) {
            if ((n2 & 4) != 0) {
                vector3d = new Vector3d();
            }
            hd_0 hd_02 = object2;
            Vector3dc vector3dc3 = vector3dc;
            Vector3dc vector3dc4 = vector3dc2;
            vector3dc2 = vector3d;
            vector3dc = vector3dc4;
            object2 = vector3dc3;
            object = hd_02;
            Intrinsics.checkNotNullParameter((Object)hd_02, (String)"");
            Intrinsics.checkNotNullParameter((Object)object2, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
            object = ((Vector3d)vector3dc2).set((Vector3dc)object2).fma(object.b(), vector3dc);
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
            return object;
        }

        static {
            a = new a();
        }
    }
}

