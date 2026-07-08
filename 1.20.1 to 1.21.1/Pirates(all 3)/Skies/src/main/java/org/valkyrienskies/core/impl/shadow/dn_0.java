/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Db
 *  org.valkyrienskies.core.impl.shadow.Dc
 *  org.valkyrienskies.core.impl.shadow.De
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.impl.shadow.Db;
import org.valkyrienskies.core.impl.shadow.Dc;
import org.valkyrienskies.core.impl.shadow.De;
import org.valkyrienskies.core.impl.shadow.db_0;
import org.valkyrienskies.core.impl.shadow.dc_0;
import org.valkyrienskies.core.impl.shadow.dd_0;
import org.valkyrienskies.core.impl.shadow.de_0;
import org.valkyrienskies.core.impl.shadow.df_0;
import org.valkyrienskies.core.impl.shadow.di_0;
import org.valkyrienskies.core.impl.shadow.dj_0;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;
import org.valkyrienskies.core.util.VectorConversionsKt;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dn
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007JO\u0010\u0006\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0012J5\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0006\u0010\u0013J?\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0014JW\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0016JE\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0017J=\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r\u00a2\u0006\u0004\b\u0006\u0010\u0018J5\u0010\u0006\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a2\u0006\u0004\b\u0006\u0010\u001a"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Dn;", "Lorg/valkyrienskies/core/impl/shadow/Di;", "Lorg/joml/Vector3dc;", "p0", "p1", "", "a", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)D", "Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "", "p2", "Lorg/valkyrienskies/core/impl/shadow/Dd;", "p3", "Lorg/valkyrienskies/core/impl/shadow/Db;", "p4", "p5", "p6", "", "(Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Ljava/util/Iterator;Lorg/valkyrienskies/core/impl/shadow/Dd;Lorg/valkyrienskies/core/impl/shadow/Db;Lorg/valkyrienskies/core/impl/shadow/Db;Lorg/joml/Vector3dc;)V", "(Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/impl/shadow/Db;Lorg/valkyrienskies/core/impl/shadow/Db;)D", "(Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/impl/shadow/Db;Lorg/valkyrienskies/core/impl/shadow/Db;)D", "p7", "(Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Ljava/util/Iterator;Lorg/valkyrienskies/core/impl/shadow/Db;Lorg/valkyrienskies/core/impl/shadow/Db;DLorg/joml/Vector3dc;)Lorg/joml/Vector3dc;", "(Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Ljava/util/Iterator;Lorg/valkyrienskies/core/impl/shadow/Db;Lorg/valkyrienskies/core/impl/shadow/Db;)Lorg/joml/Vector3dc;", "(Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;Lorg/valkyrienskies/core/impl/shadow/Db;Lorg/valkyrienskies/core/impl/shadow/Db;)D", "Lorg/valkyrienskies/core/impl/shadow/Df;", "(Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;Lorg/joml/Vector3dc;Ljava/util/Iterator;)Lorg/valkyrienskies/core/impl/shadow/Df;", "<init>", "()V"})
public final class dn_0
implements di_0 {
    public static final dn_0 INSTANCE = new dn_0();

    private dn_0() {
    }

    @Override
    public final void a(VsiConvexPolygonc vsiConvexPolygonc, VsiConvexPolygonc vsiConvexPolygonc2, Iterator<? extends Vector3dc> iterator2, dd_0 dd_02, db_0 db_02, db_0 db_03, Vector3dc vector3dc) {
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc2, (String)"");
        Intrinsics.checkNotNullParameter(iterator2, (String)"");
        Intrinsics.checkNotNullParameter((Object)dd_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_03, (String)"");
        double d2 = Double.MAX_VALUE;
        boolean bl = true;
        Object object = dd_02;
        dd_02.b = bl;
        while (iterator2.hasNext()) {
            double d3;
            double d4;
            double d5;
            Vector3dc vector3dc2 = iterator2.next();
            db_0 db_04 = db_03;
            db_0 db_05 = db_02;
            Vector3dc vector3dc3 = vector3dc2;
            VsiConvexPolygonc vsiConvexPolygonc3 = vsiConvexPolygonc2;
            object = vsiConvexPolygonc;
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc3, (String)"");
            Intrinsics.checkNotNullParameter((Object)vector3dc3, (String)"");
            Intrinsics.checkNotNullParameter((Object)db_05, (String)"");
            Intrinsics.checkNotNullParameter((Object)db_04, (String)"");
            object = (Dc)dj_0.a((VsiConvexPolygonc)object, vector3dc3, db_05);
            vsiConvexPolygonc3 = (Dc)dj_0.a(vsiConvexPolygonc3, vector3dc3, db_04);
            double d6 = dc_0.a.a((dc_0)object, (dc_0)((Object)vsiConvexPolygonc3));
            if (Math.abs(d5) < 1.0E-6) {
                bl = false;
                object = dd_02;
                dd_02.b = bl;
                return;
            }
            if (vector3dc != null) {
                double d7;
                d4 = vector3dc.dot(vector3dc2);
                if (Math.abs(d4) < 1.0E-6) continue;
                double d8 = d6 / d4;
                double d9 = Math.abs(d8);
                if (!(d7 < d2)) continue;
                d2 = d9;
                object = dd_02;
                ((dd_0)object).c.set(vector3dc);
                double d10 = d8;
                object = dd_02;
                dd_02.d = d10;
                continue;
            }
            d4 = Math.abs(d6);
            if (!(d3 < d2)) continue;
            d2 = d4;
            object = dd_02;
            ((dd_0)object).c.set(vector3dc2);
            double d11 = d6;
            object = dd_02;
            dd_02.d = d11;
        }
        if (d2 == Double.MAX_VALUE) {
            bl = false;
            object = dd_02;
            dd_02.b = bl;
        }
    }

    @Override
    public final Vector3dc a(VsiConvexPolygonc vsiConvexPolygonc, Vector3dc vector3dc, VsiConvexPolygonc vsiConvexPolygonc2, Iterator<? extends Vector3dc> iterator2, db_0 db_02, db_0 db_03, double d2, Vector3dc vector3dc2) {
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc2, (String)"");
        Intrinsics.checkNotNullParameter(iterator2, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_03, (String)"");
        Vector3dc vector3dc3 = null;
        while (iterator2.hasNext()) {
            Vector3dc vector3dc4 = iterator2.next();
            double d3 = dn_0.a(vsiConvexPolygonc, vector3dc, vsiConvexPolygonc2, vector3dc4, db_02, db_03);
            if (d3 == 0.0) {
                return vector3dc;
            }
            Vector3dc vector3dc5 = null;
            if (vector3dc2 != null) {
                double d4 = vector3dc4.dot(vector3dc2);
                if (Math.abs(d4) < 1.0E-6) continue;
                Vector3d vector3d = new Vector3d(d3 * vector3dc2.x() / d4, d3 * vector3dc2.y() / d4, d3 * vector3dc2.z() / d4);
                vector3dc5 = vector3dc.add(vector3d, new Vector3d());
            } else {
                double d5;
                if (Math.abs(vector3dc4.y()) >= Math.sin(Math.toRadians(d2))) {
                    double d6;
                    Vector3d vector3d = new Vector3d(0.0, d3 / vector3dc4.y(), 0.0);
                    vector3dc5 = vector3dc.add(vector3d, new Vector3d());
                    Intrinsics.checkNotNullExpressionValue((Object)vector3dc5, (String)"");
                    d5 = VectorConversionsKt.horizontalLength(vector3dc5);
                    if (d6 > 1.0E-6) {
                        double d7;
                        double d8 = Math.abs(vector3dc5.y()) / d5;
                        if (d7 >= Math.tan(Math.toRadians(d2))) {
                            vector3dc5 = null;
                        }
                    }
                }
                if (vector3dc5 == null) {
                    Vector3d vector3d = new Vector3d(vector3dc4.x(), 0.0, vector3dc4.z()).normalize();
                    if (!vector3d.isFinite()) continue;
                    d5 = vector3dc4.dot(vector3d);
                    Vector3d vector3d2 = new Vector3d(d3 * vector3d.x() / d5, 0.0, d3 * vector3d.z() / d5);
                    vector3dc5 = vector3dc.add(vector3d2, new Vector3d());
                }
            }
            if (vector3dc3 == null) {
                vector3dc3 = vector3dc5;
                continue;
            }
            Vector3dc vector3dc6 = vector3dc5;
            Intrinsics.checkNotNull(vector3dc6);
            Vector3d vector3d = new Vector3d(vector3dc6).sub(vector3dc);
            Vector3d vector3d3 = new Vector3d(vector3dc3).sub(vector3dc);
            if (!(vector3d.lengthSquared() < vector3d3.lengthSquared())) continue;
            vector3dc3 = vector3dc5;
        }
        Vector3dc vector3dc7 = vector3dc3;
        Intrinsics.checkNotNull(vector3dc7);
        return vector3dc7;
    }

    @Override
    public final Vector3dc a(VsiConvexPolygonc vsiConvexPolygonc, Vector3dc vector3dc, VsiConvexPolygonc vsiConvexPolygonc2, Iterator<? extends Vector3dc> iterator2, db_0 db_02, db_0 db_03) {
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc2, (String)"");
        Intrinsics.checkNotNullParameter(iterator2, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_03, (String)"");
        Vector3dc vector3dc2 = null;
        while (iterator2.hasNext()) {
            Vector3dc vector3dc3 = iterator2.next();
            double d2 = dn_0.a(vsiConvexPolygonc, vector3dc, vsiConvexPolygonc2, vector3dc3, db_02, db_03);
            if (d2 == 0.0) {
                return vector3dc;
            }
            Vector3d vector3d = new Vector3d(vector3dc3.x(), 0.0, vector3dc3.z()).normalize();
            if (!vector3d.isFinite()) continue;
            double d3 = vector3dc3.dot(vector3d);
            vector3dc3 = new Vector3d(d2 * vector3d.x() / d3, 0.0, d2 * vector3d.z() / d3);
            Vector3d vector3d2 = vector3dc.add(vector3dc3, new Vector3d());
            Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
            vector3dc3 = vector3d2;
            if (vector3dc2 == null) {
                vector3dc2 = vector3dc3;
                continue;
            }
            Vector3d vector3d3 = new Vector3d(vector3dc3).sub(vector3dc);
            Vector3d vector3d4 = new Vector3d(vector3dc2).sub(vector3dc);
            if (!(vector3d3.lengthSquared() < vector3d4.lengthSquared())) continue;
            vector3dc2 = vector3dc3;
        }
        Vector3dc vector3dc4 = vector3dc2;
        Intrinsics.checkNotNull(vector3dc4);
        return vector3dc4;
    }

    private static double a(Vector3dc vector3dc, Vector3dc vector3dc2) {
        return new Vector3d(vector3dc.x(), 0.0, vector3dc.z()).angleCos(new Vector3d(vector3dc2.x(), 0.0, vector3dc2.z()));
    }

    @Override
    public final df_0 a(VsiConvexPolygonc vsiConvexPolygonc, VsiConvexPolygonc vsiConvexPolygonc2, Vector3dc vector3dc, Iterator<? extends Vector3dc> iterator2) {
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter(iterator2, (String)"");
        db_0 db_02 = Db.a.a();
        db_0 db_03 = Db.a.a();
        de_0 de_02 = De.a.a();
        double d2 = 0.0;
        boolean bl = true;
        de_0 de_03 = de_02;
        ((De)de_02).b = bl;
        while (iterator2.hasNext()) {
            Vector3dc vector3dc2 = iterator2.next();
            double d3 = dn_0.a(vsiConvexPolygonc, vsiConvexPolygonc2, vector3dc, vector3dc2, db_02, db_03);
            if (d3 == 0.0) continue;
            bl = false;
            de_03 = de_02;
            ((De)de_02).b = bl;
            if (!(d3 > d2)) continue;
            d2 = d3;
            de_03 = de_02;
            ((De)de_03).c.set(vector3dc2);
            double d4 = d2;
            de_03 = de_02;
            ((De)de_02).d = d4;
            if (!(d3 == Double.POSITIVE_INFINITY)) continue;
        }
        return de_02;
    }

    private static double a(VsiConvexPolygonc vsiConvexPolygonc, VsiConvexPolygonc vsiConvexPolygonc2, Vector3dc vector3dc, db_0 db_02, db_0 db_03) {
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_03, (String)"");
        vsiConvexPolygonc = (Dc)dj_0.a(vsiConvexPolygonc, vector3dc, db_02);
        vsiConvexPolygonc2 = (Dc)dj_0.a(vsiConvexPolygonc2, vector3dc, db_03);
        return dc_0.a.a((dc_0)((Object)vsiConvexPolygonc), (dc_0)((Object)vsiConvexPolygonc2));
    }

    private static double a(VsiConvexPolygonc vsiConvexPolygonc, Vector3dc vector3dc, VsiConvexPolygonc vsiConvexPolygonc2, Vector3dc vector3dc2, db_0 db_02, db_0 db_03) {
        vsiConvexPolygonc = (Dc)dj_0.a(vsiConvexPolygonc, vector3dc2, db_02);
        vsiConvexPolygonc2 = (Dc)dj_0.a(vsiConvexPolygonc2, vector3dc2, db_03);
        double d2 = vector3dc2.dot(vector3dc);
        return dc_0.a.a((dc_0)((Object)vsiConvexPolygonc), (dc_0)((Object)vsiConvexPolygonc2), d2);
    }

    private static double a(VsiConvexPolygonc vsiConvexPolygonc, VsiConvexPolygonc vsiConvexPolygonc2, Vector3dc vector3dc, Vector3dc vector3dc2, db_0 db_02, db_0 db_03) {
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vsiConvexPolygonc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"");
        Intrinsics.checkNotNullParameter((Object)vector3dc2, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_02, (String)"");
        Intrinsics.checkNotNullParameter((Object)db_03, (String)"");
        vsiConvexPolygonc = (Dc)dj_0.a(vsiConvexPolygonc, vector3dc2, db_02);
        vsiConvexPolygonc2 = (Dc)dj_0.a(vsiConvexPolygonc2, vector3dc2, db_03);
        double d2 = vector3dc.dot(vector3dc2);
        return dc_0.a.b((dc_0)((Object)vsiConvexPolygonc), (dc_0)((Object)vsiConvexPolygonc2), d2);
    }
}

