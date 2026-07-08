/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.db_0;
import org.valkyrienskies.core.impl.shadow.dd_0;
import org.valkyrienskies.core.impl.shadow.df_0;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Di
 */
public interface di_0 {
    public void a(VsiConvexPolygonc var1, VsiConvexPolygonc var2, Iterator<? extends Vector3dc> var3, dd_0 var4, db_0 var5, db_0 var6, Vector3dc var7);

    public static /* synthetic */ void a(di_0 di_02, VsiConvexPolygonc vsiConvexPolygonc, VsiConvexPolygonc vsiConvexPolygonc2, Iterator iterator2, dd_0 dd_02, db_0 db_02, db_0 db_03, Vector3dc vector3dc, int n2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkIfColliding");
        }
        if ((n2 & 0x40) != 0) {
            vector3dc = null;
        }
        di_02.a(vsiConvexPolygonc, vsiConvexPolygonc2, iterator2, dd_02, db_02, db_03, vector3dc);
    }

    public Vector3dc a(VsiConvexPolygonc var1, Vector3dc var2, VsiConvexPolygonc var3, Iterator<? extends Vector3dc> var4, db_0 var5, db_0 var6, double var7, Vector3dc var9);

    public static /* synthetic */ Vector3dc a(di_0 di_02, VsiConvexPolygonc vsiConvexPolygonc, Vector3dc vector3dc, VsiConvexPolygonc vsiConvexPolygonc2, Iterator iterator2, db_0 db_02, db_0 db_03, double d2, Vector3dc vector3dc2, int n2, Object object) {
        return di_02.a(vsiConvexPolygonc, vector3dc, vsiConvexPolygonc2, iterator2, db_02, db_03, d2, null);
    }

    public Vector3dc a(VsiConvexPolygonc var1, Vector3dc var2, VsiConvexPolygonc var3, Iterator<? extends Vector3dc> var4, db_0 var5, db_0 var6);

    public df_0 a(VsiConvexPolygonc var1, VsiConvexPolygonc var2, Vector3dc var3, Iterator<? extends Vector3dc> var4);
}

