/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Dq
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.impl.shadow.Dq;
import org.valkyrienskies.core.impl.shadow.dh_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dq
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B?\b\u0002\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u0011\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000e\u00a8\u0006\u0016"}, d2={"Lorg/valkyrienskies/core/impl/collision/TransformedCuboidPolygon;", "Lorg/valkyrienskies/core/impl/collision/ConvexPolygon;", "Lorg/joml/primitives/AABBdc;", "aabb", "Lorg/joml/Matrix4dc;", "transform", "setFromAABB", "(Lorg/joml/primitives/AABBdc;Lorg/joml/Matrix4dc;)Lorg/valkyrienskies/core/impl/collision/TransformedCuboidPolygon;", "Lorg/joml/primitives/AABBd;", "_aabb", "Lorg/joml/primitives/AABBd;", "", "Lorg/joml/Vector3d;", "_normals", "Ljava/util/List;", "_points", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "_shipFrom", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lorg/joml/primitives/AABBd;)V", "Companion", "impl"})
public final class dq_0
extends dh_0 {
    public static final a_ a_ = new a_(null);
    private final List<Vector3d> b;
    private final List<Vector3d> c;
    private final AABBd d;
    private static final int e = 8;
    private static final int f = 3;

    private dq_0(List<? extends Vector3d> list, List<? extends Vector3d> list2, Long l2, AABBd aABBd) {
        super(list, list2, l2, aABBd);
        this.b = list;
        this.c = list2;
        this.d = aABBd;
    }

    /* synthetic */ dq_0(List list, List list2, Long l2, AABBd aABBd, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 4) != 0) {
            l2 = null;
        }
        this(list, list2, l2, aABBd);
    }

    public final dq_0 a(AABBdc iterator2, Matrix4dc matrix4dc) {
        Intrinsics.checkNotNullParameter((Object)iterator2, (String)"");
        this.b.get(0).set(iterator2.minX(), iterator2.minY(), iterator2.minZ());
        this.b.get(1).set(iterator2.minX(), iterator2.minY(), iterator2.maxZ());
        this.b.get(2).set(iterator2.minX(), iterator2.maxY(), iterator2.minZ());
        this.b.get(3).set(iterator2.minX(), iterator2.maxY(), iterator2.maxZ());
        this.b.get(4).set(iterator2.maxX(), iterator2.minY(), iterator2.minZ());
        this.b.get(5).set(iterator2.maxX(), iterator2.minY(), iterator2.maxZ());
        this.b.get(6).set(iterator2.maxX(), iterator2.maxY(), iterator2.minZ());
        this.b.get(7).set(iterator2.maxX(), iterator2.maxY(), iterator2.maxZ());
        this.c.get(0).set(1.0, 0.0, 0.0);
        this.c.get(1).set(0.0, 1.0, 0.0);
        this.c.get(2).set(0.0, 0.0, 1.0);
        if (matrix4dc != null) {
            double d2 = this.b.get(0).x();
            double d3 = this.b.get(0).y();
            double d4 = this.b.get(0).z();
            double d5 = this.b.get(0).x();
            double d6 = this.b.get(0).y();
            double d7 = this.b.get(0).z();
            for (Vector3d vector3d : this.b) {
                matrix4dc.transformPosition(vector3d);
                d2 = Math.min(d2, vector3d.x());
                d3 = Math.min(d3, vector3d.y());
                d4 = Math.min(d4, vector3d.z());
                d5 = Math.max(d5, vector3d.x());
                d6 = Math.max(d6, vector3d.y());
                d7 = Math.max(d7, vector3d.z());
            }
            this.d.setMin(d2, d3, d4);
            this.d.setMax(d5, d6, d7);
            for (Vector3d vector3d : this.c) {
                matrix4dc.transformDirection(vector3d).normalize();
            }
        } else {
            this.d.set((AABBdc)((Object)iterator2));
        }
        return this;
    }

    private static /* synthetic */ dq_0 a$default(dq_0 dq_02, AABBdc aABBdc, Matrix4dc matrix4dc, int n2) {
        if ((n2 & 2) != 0) {
            matrix4dc = null;
        }
        return dq_02.a(aABBdc, matrix4dc);
    }

    public /* synthetic */ dq_0(List list, List list2, Long l2, AABBd aABBd, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, l2, aABBd);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J3\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2={"Lorg/valkyrienskies/core/impl/collision/TransformedCuboidPolygon$Companion;", "", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipFrom", "Lorg/valkyrienskies/core/impl/collision/TransformedCuboidPolygon;", "createEmptyRectangularPrismPolygon", "(Ljava/lang/Long;)Lorg/valkyrienskies/core/impl/collision/TransformedCuboidPolygon;", "Lorg/joml/primitives/AABBdc;", "aabb", "Lorg/joml/Matrix4dc;", "transform", "createFromAABB", "(Lorg/joml/primitives/AABBdc;Lorg/joml/Matrix4dc;Ljava/lang/Long;)Lorg/valkyrienskies/core/impl/collision/TransformedCuboidPolygon;", "", "NUMBER_OF_NORMALS", "I", "NUMBER_OF_POINTS", "<init>", "()V", "impl"})
    public static final class a_ {
        private a_() {
        }

        private static dq_0 a(Long l2) {
            ArrayList<Vector3d> arrayList;
            List<Vector3d> list = new ArrayList<Vector3d>(8);
            for (int i2 = 0; i2 < 8; ++i2) {
                arrayList = list;
                arrayList.add(new Vector3d());
            }
            list = list;
            List list2 = new ArrayList(3);
            for (int i3 = 0; i3 < 3; ++i3) {
                arrayList = list2;
                arrayList.add(new Vector3d());
            }
            list2 = list2;
            return new Dq(list, list2, l2, new AABBd(), null);
        }

        private static /* synthetic */ dq_0 a$default(a_ a_2, Long l2, int n2) {
            if ((n2 & 1) != 0) {
                l2 = null;
            }
            return org.valkyrienskies.core.impl.shadow.Dq$a_.a(l2);
        }

        public final dq_0 a(AABBdc aABBdc, Matrix4dc matrix4dc, Long l2) {
            Intrinsics.checkNotNullParameter((Object)aABBdc, (String)"");
            return org.valkyrienskies.core.impl.shadow.Dq$a_.a(l2).a(aABBdc, matrix4dc);
        }

        public static /* synthetic */ dq_0 a$default(a_ a_2, AABBdc aABBdc, Matrix4dc matrix4dc, Long l2, int n2) {
            return a_2.a(aABBdc, null, null);
        }

        public /* synthetic */ a_(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

