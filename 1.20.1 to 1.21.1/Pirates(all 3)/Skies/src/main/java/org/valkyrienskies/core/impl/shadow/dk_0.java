/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.comparisons.ComparisonsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.valkyrienskies.core.impl.shadow.Db
 *  org.valkyrienskies.core.impl.shadow.Dq
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.impl.shadow.Db;
import org.valkyrienskies.core.impl.shadow.Dq;
import org.valkyrienskies.core.impl.shadow.dh_0;
import org.valkyrienskies.core.impl.shadow.di_0;
import org.valkyrienskies.core.impl.shadow.dn_0;
import org.valkyrienskies.core.impl.shadow.dq_0;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;
import org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider;
import org.valkyrienskies.core.util.AABBdUtilKt;
import org.valkyrienskies.core.util.VectorConversionsKt;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Dk
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=JI\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJI\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J-\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017JU\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJS\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJI\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0018\u00010\fj\u0004\u0018\u0001`\r0\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\"\u0010#J1\u0010'\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010$2\u000e\u0010&\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\rH\u0016\u00a2\u0006\u0004\b'\u0010(J#\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0002\u00a2\u0006\u0004\b+\u0010,J'\u0010/\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b3\u00104R\u001a\u00106\u001a\b\u0012\u0004\u0012\u00020\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010;\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00109\u00a8\u0006>"}, d2={"Lorg/valkyrienskies/core/impl/collision/EntityPolygonColliderImpl;", "Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "Lorg/joml/Vector3dc;", "movement", "Lorg/joml/primitives/AABBdc;", "entityBoundingBox", "", "entityStepHeight", "", "Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "collidingPolygons", "Lkotlin/Pair;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "adjustEntityMovementForPolygonCollisions", "(Lorg/joml/Vector3dc;Lorg/joml/primitives/AABBdc;DLjava/util/List;)Lkotlin/Pair;", "entityVelocity", "adjustMovementComponentWise", "(Lorg/joml/primitives/AABBdc;Lorg/joml/Vector3dc;DLjava/util/List;)Lkotlin/Pair;", "entityAABB", "maxSlopeClimbAngle", "", "canStep4", "(Lorg/joml/primitives/AABBdc;Ljava/util/List;D)Z", "entityVel", "forcedResponseNormalFromCaller", "collide", "(Lorg/joml/primitives/AABBdc;Ljava/util/List;Lorg/joml/Vector3dc;DLorg/joml/Vector3dc;)Lkotlin/Pair;", "stepHeight", "collideWithStep", "(Lorg/joml/primitives/AABBdc;Ljava/util/List;Lorg/joml/Vector3dc;DD)Lkotlin/Pair;", "collideWithoutStep", "(Lorg/joml/primitives/AABBdc;Ljava/util/List;Lorg/joml/Vector3dc;D)Lkotlin/Pair;", "aabb", "createFeetAABB", "(Lorg/joml/primitives/AABBdc;)Lorg/joml/primitives/AABBdc;", "Lorg/joml/Matrix4dc;", "transform", "shipFrom", "createPolygonFromAABB", "(Lorg/joml/primitives/AABBdc;Lorg/joml/Matrix4dc;Ljava/lang/Long;)Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "", "shipNormals", "generateAllNormals", "(Ljava/lang/Iterable;)Ljava/util/List;", "topPosRelative", "botPosRelative", "getFeetSlice", "(Lorg/joml/primitives/AABBdc;DD)Lorg/joml/primitives/AABBdc;", "newVel", "originalVel", "roundNewVelToOriginal", "(Lorg/joml/Vector3dc;Lorg/joml/Vector3dc;)Lorg/joml/Vector3dc;", "", "UNIT_NORMALS", "[Lorg/joml/Vector3dc;", "X_NORMAL", "Lorg/joml/Vector3dc;", "Y_NORMAL", "Z_NORMAL", "<init>", "()V", "impl"})
public final class dk_0
implements VsiEntityPolygonCollider {
    public static final dk_0 INSTANCE = new dk_0();
    private static final Vector3dc b = new Vector3d(1.0, 0.0, 0.0);
    private static final Vector3dc c = new Vector3d(0.0, 1.0, 0.0);
    private static final Vector3dc d = new Vector3d(0.0, 0.0, 1.0);
    private static final Vector3dc[] e;

    private dk_0() {
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiConvexPolygonc createPolygonFromAABB(AABBdc aabb, Matrix4dc transform2, Long shipFrom) {
        void var3_3;
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"");
        return Dq.a_.a((AABBdc)var1_1, (Matrix4dc)var2_2, (Long)var3_3);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    @Override
    public final Pair<Vector3dc, Long> adjustEntityMovementForPolygonCollisions(Vector3dc movement, AABBdc entityBoundingBox, double entityStepHeight, List<? extends VsiConvexPolygonc> collidingPolygons) {
        Object object;
        void var2_2;
        Pair<Vector3dc, Long> pair;
        void var3_3;
        Intrinsics.checkNotNullParameter((Object)movement, (String)"");
        Intrinsics.checkNotNullParameter((Object)entityBoundingBox, (String)"");
        Intrinsics.checkNotNullParameter(collidingPolygons, (String)"");
        List<? extends VsiConvexPolygonc> list = collidingPolygons;
        void var9_11 = var3_3;
        void var3_4 = pair;
        pair = this;
        boolean bl = VectorConversionsKt.horizontalLengthSq((Vector3dc)var3_4) > 1.0E-8 && var9_11 > 0.0;
        if (bl) {
            Pair pair2 = ((dk_0)pair).a((AABBdc)var2_2, (List<? extends VsiConvexPolygonc>)list, new Vector3d(0.0, -0.2, 0.0), 45.0, null);
            AABBd aABBd = var2_2.translate((Vector3dc)pair2.getFirst(), new AABBd());
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"");
            boolean bl2 = pair.a((AABBdc)aABBd, list, 45.0);
            if (bl2) {
                Pair pair3;
                void var23_13 = var9_11;
                double d2 = 45.0;
                void var8_15 = var3_4;
                List<? extends VsiConvexPolygonc> list2 = list;
                AABBd aABBd2 = var2_2;
                Pair<Vector3dc, Long> pair4 = pair;
                if (!(var23_13 >= 0.0)) {
                    String string = "StepHeight was " + (double)var23_13 + ", which is less than 0.0!";
                    throw new IllegalArgumentException(string.toString());
                }
                Vector3dc vector3dc = (Vector3dc)pair4.a((AABBdc)aABBd2, list2, (Vector3dc)new Vector3d(0.0, (double)var23_13, 0.0), 45.0, c).getFirst();
                double d3 = vector3dc.y();
                if (!(0.0 <= d3 ? d3 <= var23_13 : false)) {
                    pair3 = null;
                } else {
                    AABBd aABBd3 = aABBd2.translate(vector3dc, new AABBd());
                    Intrinsics.checkNotNullExpressionValue((Object)aABBd3, (String)"");
                    Vector3dc vector3dc2 = (Vector3dc)((dk_0)pair4).a(aABBd3, (List<? extends VsiConvexPolygonc>)list2, new Vector3d(var8_15.x(), 0.0, var8_15.z()), 45.0, null).getFirst();
                    double d4 = vector3dc.y() - var8_15.y();
                    AABBd aABBd4 = aABBd3.translate(vector3dc2, new AABBd());
                    Intrinsics.checkNotNullExpressionValue((Object)aABBd4, (String)"");
                    Pair<Vector3dc, Long> pair5 = super.a((AABBdc)aABBd4, list2, (Vector3dc)new Vector3d(0.0, -d4, 0.0), 45.0, c);
                    Vector3dc vector3dc3 = (Vector3dc)pair5.getFirst();
                    Long l2 = (Long)pair5.getSecond();
                    vector3dc = new Vector3d(vector3dc).add(vector3dc2).add(vector3dc3);
                    aABBd2 = aABBd2.translate(vector3dc, new AABBd());
                    Intrinsics.checkNotNullExpressionValue((Object)aABBd2, (String)"");
                    boolean bl3 = super.a((AABBdc)aABBd2, list2, 45.0);
                    if (!bl3) {
                        Pair pair6 = ((dk_0)pair4).a(aABBd2, (List<? extends VsiConvexPolygonc>)list2, new Vector3d(0.0, -d4 - vector3dc3.y(), 0.0), 45.0, null);
                        Vector3d vector3d = new Vector3d(vector3dc).add((Vector3dc)pair6.getFirst());
                        double d5 = vector3d.y();
                        if (!(0.0 <= d5 ? d5 <= var23_13 : false)) {
                            pair3 = null;
                        } else {
                            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
                            pair3 = new Pair((Object)dk_0.a(vector3d, (Vector3dc)var8_15), pair6.getSecond());
                        }
                    } else {
                        double d6 = ((Vector3d)vector3dc).y();
                        if (!(0.0 <= d6 ? d6 <= var23_13 : false)) {
                            pair3 = null;
                        } else {
                            Intrinsics.checkNotNullExpressionValue((Object)vector3dc, (String)"");
                            pair3 = new Pair((Object)dk_0.a(vector3dc, (Vector3dc)var8_15), (Object)l2);
                        }
                    }
                }
                if (pair3 != null) {
                    pair4 = pair3;
                    if (VectorConversionsKt.differenceHorLengthSq((Vector3dc)pair3.getFirst(), (Vector3dc)var3_4) < 1.0E-8) {
                        object = pair4;
                        return object;
                    }
                    pair = pair.a((AABBdc)var2_2, list, (Vector3dc)var3_4, 45.0);
                    if (!(VectorConversionsKt.differenceHorLengthSq((Vector3dc)pair4.getFirst(), (Vector3dc)var3_4) <= VectorConversionsKt.differenceHorLengthSq((Vector3dc)pair.getFirst(), (Vector3dc)var3_4))) return pair;
                    object = pair4;
                    return object;
                }
            }
        }
        object = pair.a((AABBdc)var2_2, list, (Vector3dc)var3_4, 45.0);
        return object;
    }

    private final Pair<Vector3dc, Long> a(AABBdc pair, Vector3dc vector3dc, double d2, List<? extends VsiConvexPolygonc> list) {
        boolean bl = VectorConversionsKt.horizontalLengthSq(vector3dc) > 1.0E-8 && d2 > 0.0;
        if (bl) {
            Pair pair2 = this.a((AABBdc)pair, (List<? extends VsiConvexPolygonc>)list, new Vector3d(0.0, -0.2, 0.0), 45.0, null);
            AABBd aABBd = pair.translate((Vector3dc)pair2.getFirst(), new AABBd());
            Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"");
            boolean bl2 = this.a(aABBd, list, 45.0);
            if (bl2) {
                Pair<Vector3dc, Long> pair3 = this.a((AABBdc)pair, list, vector3dc, 45.0, d2);
                if (pair3 == null) {
                    return this.a((AABBdc)pair, list, vector3dc, 45.0);
                }
                Pair<Vector3dc, Long> pair4 = pair3;
                if (VectorConversionsKt.differenceHorLengthSq((Vector3dc)pair3.getFirst(), vector3dc) < 1.0E-8) {
                    return pair4;
                }
                pair = this.a((AABBdc)pair, list, vector3dc, 45.0);
                if (VectorConversionsKt.differenceHorLengthSq((Vector3dc)pair4.getFirst(), vector3dc) <= VectorConversionsKt.differenceHorLengthSq((Vector3dc)pair.getFirst(), vector3dc)) {
                    return pair4;
                }
                return pair;
            }
        }
        return this.a((AABBdc)pair, list, vector3dc, 45.0);
    }

    private final Pair<Vector3dc, Long> a(AABBdc aABBdc, List<? extends VsiConvexPolygonc> list, Vector3dc vector3dc, double d2, double d3) {
        if (!(d3 >= 0.0)) {
            String string = "StepHeight was " + d3 + ", which is less than 0.0!";
            throw new IllegalArgumentException(string.toString());
        }
        Vector3dc vector3dc2 = (Vector3dc)this.a(aABBdc, list, (Vector3dc)new Vector3d(0.0, d3, 0.0), 45.0, c).getFirst();
        double d4 = vector3dc2.y();
        if (!(0.0 <= d4 ? d4 <= d3 : false)) {
            return null;
        }
        AABBd aABBd = aABBdc.translate(vector3dc2, new AABBd());
        Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"");
        Vector3dc vector3dc3 = (Vector3dc)this.a(aABBd, (List<? extends VsiConvexPolygonc>)list, new Vector3d(vector3dc.x(), 0.0, vector3dc.z()), 45.0, null).getFirst();
        double d5 = vector3dc2.y() - vector3dc.y();
        Object object = aABBd.translate(vector3dc3, new AABBd());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"");
        object = this.a((AABBdc)object, list, (Vector3dc)new Vector3d(0.0, -d5, 0.0), 45.0, c);
        Vector3dc vector3dc4 = (Vector3dc)object.getFirst();
        object = (Long)object.getSecond();
        vector3dc2 = new Vector3d(vector3dc2).add(vector3dc3).add(vector3dc4);
        aABBdc = aABBdc.translate(vector3dc2, new AABBd());
        Intrinsics.checkNotNullExpressionValue((Object)aABBdc, (String)"");
        boolean bl = this.a(aABBdc, list, 45.0);
        if (!bl) {
            Pair pair = this.a(aABBdc, (List<? extends VsiConvexPolygonc>)list, new Vector3d(0.0, -d5 - vector3dc4.y(), 0.0), 45.0, null);
            Vector3d vector3d = new Vector3d(vector3dc2).add((Vector3dc)pair.getFirst());
            double d6 = vector3d.y();
            if (!(0.0 <= d6 ? d6 <= d3 : false)) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
            return new Pair((Object)dk_0.a(vector3d, vector3dc), pair.getSecond());
        }
        double d7 = ((Vector3d)vector3dc2).y();
        if (!(0.0 <= d7 ? d7 <= d3 : false)) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue((Object)vector3dc2, (String)"");
        return new Pair((Object)dk_0.a(vector3dc2, vector3dc), object);
    }

    private final Pair<Vector3dc, Long> a(AABBdc aABBdc, List<? extends VsiConvexPolygonc> list, Vector3dc vector3dc, double d2) {
        return this.a(aABBdc, (List<? extends VsiConvexPolygonc>)list, vector3dc, 45.0, null);
    }

    private final Pair<Vector3dc, Long> a(AABBdc aABBdc, List<? extends VsiConvexPolygonc> list, Vector3dc vector3dc, double d2, Vector3dc vector3dc2) {
        Object object = dk_0.a(aABBdc);
        VsiConvexPolygonc vsiConvexPolygonc = dq_0.a_.a$default(Dq.a_, aABBdc, null, null, 6);
        Object object2 = list;
        list = CollectionsKt.sortedWith((Iterable)object2, (Comparator)new Comparator((AABBdc)object){
            private /* synthetic */ AABBdc a;
            {
                this.a = aABBdc;
            }

            public final int compare(T a2, T b2) {
                Comparable comparable;
                Object object = (VsiConvexPolygonc)a2;
                object = object.computeCenterPos(new Vector3d());
                Comparable comparable2 = Double.valueOf(AABBdUtilKt.signedDistanceTo(this.a, (Vector3dc)object));
                object = (VsiConvexPolygonc)((Object)comparable);
                comparable = comparable2;
                object = object.computeCenterPos(new Vector3d());
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)Double.valueOf(AABBdUtilKt.signedDistanceTo(this.a, (Vector3dc)object)));
            }
        });
        object2 = new Vector3d(vector3dc);
        object = null;
        Object object3 = list;
        object3 = object3.iterator();
        while (object3.hasNext()) {
            boolean bl;
            double d3;
            Object object4 = object3.next();
            object4 = (VsiConvexPolygonc)object4;
            if (!AABBdUtilKt.intersectsAABB(AABBdUtilKt.extend(new AABBd(vsiConvexPolygonc.getAabb()), (Vector3dc)object2), object4.getAabb())) continue;
            List<Vector3dc> list2 = dk_0.a(object4.getNormals());
            Object object5 = dn_0.INSTANCE.a(vsiConvexPolygonc, (VsiConvexPolygonc)object4, (Vector3dc)object2, list2.iterator());
            double d4 = d3 = object5.b() ? 0.0 : object5.d();
            if (!(d4 < 1.0)) continue;
            Vector3d vector3d = ((Vector3dc)object2).mul(d3, new Vector3d());
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
            object5 = vector3d;
            Vector3d vector3d2 = ((Vector3dc)object2).mul(1.0 - d3, new Vector3d());
            Intrinsics.checkNotNullExpressionValue((Object)vector3d2, (String)"");
            object2 = vector3d2;
            object = object4.getShipFrom();
            Object object6 = aABBdc.translate((Vector3dc)object5, new AABBd());
            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"");
            dq_0 dq_02 = dq_0.a_.a$default(Dq.a_, (AABBdc)object6, null, null, 6);
            if (vector3dc2 == null && (bl = INSTANCE.a((AABBdc)object6, list, d2))) {
                object6 = dn_0.INSTANCE.a(dq_02, (Vector3dc)object2, (VsiConvexPolygonc)object4, list2.iterator(), Db.a.a(), Db.a.a(), d2, c);
                boolean bl2 = object2.y() < 0.0 && object6.y() > object2.y() && object6.y() < 0.34 || object2.y() > 0.0 && object6.y() < object2.y() && object6.y() > 0.34;
                if (bl2) {
                    Vector3d vector3d3 = object5.add((Vector3dc)object6, new Vector3d());
                    Intrinsics.checkNotNullExpressionValue((Object)vector3d3, (String)"");
                    object2 = vector3d3;
                    continue;
                }
            }
            object6 = dn_0.INSTANCE.a(dq_02, (Vector3dc)object2, (VsiConvexPolygonc)object4, list2.iterator(), Db.a.a(), Db.a.a(), d2, vector3dc2);
            object6 = object5.add((Vector3dc)object6, new Vector3d());
            Intrinsics.checkNotNullExpressionValue((Object)object6, (String)"");
            object2 = object6;
        }
        return new Pair((Object)dk_0.a((Vector3dc)object2, vector3dc), object);
    }

    private static Vector3dc a(Vector3dc vector3dc, Vector3dc vector3dc2) {
        Vector3d vector3d;
        vector3dc = new Vector3d(vector3dc);
        if (Math.abs(vector3d.x() - vector3dc2.x()) < 1.0E-8) {
            ((Vector3d)vector3dc).x = vector3dc2.x();
        }
        if (Math.abs(((Vector3d)vector3dc).y() - vector3dc2.y()) < 1.0E-8) {
            ((Vector3d)vector3dc).y = vector3dc2.y();
        }
        if (Math.abs(((Vector3d)vector3dc).z() - vector3dc2.z()) < 1.0E-8) {
            ((Vector3d)vector3dc).z = vector3dc2.z();
        }
        return vector3dc;
    }

    private static AABBdc a(AABBdc aABBdc, double d2, double d3) {
        double d4 = aABBdc.maxY() - aABBdc.minY();
        double d5 = aABBdc.minY();
        double d6 = d5 + d4 * 0.0;
        double d7 = d5 + d3 * d4;
        return new AABBd(aABBdc.minX(), d7, aABBdc.minZ(), aABBdc.maxX(), d6, aABBdc.maxZ());
    }

    private final boolean a(AABBdc object6, List<? extends VsiConvexPolygonc> list, double d2) {
        Object object2;
        double d3 = (object6.maxY() - object6.minY()) * 0.001;
        Object object3 = dk_0.a((AABBdc)object6, 0.0, 0.001);
        dq_0 dq_02 = dq_0.a_.a$default(Dq.a_, (AABBdc)object3, null, null, 6);
        Object object4 = list;
        list = CollectionsKt.sortedWith((Iterable)object4, (Comparator)new Comparator((AABBdc)object3){
            private /* synthetic */ AABBdc a;
            {
                this.a = aABBdc;
            }

            public final int compare(T a2, T b2) {
                Comparable comparable;
                Object object = (VsiConvexPolygonc)a2;
                object = object.computeCenterPos(new Vector3d());
                Comparable comparable2 = Double.valueOf(AABBdUtilKt.signedDistanceTo(this.a, (Vector3dc)object));
                object = (VsiConvexPolygonc)((Object)comparable);
                comparable = comparable2;
                object = object.computeCenterPos(new Vector3d());
                return ComparisonsKt.compareValues((Comparable)comparable, (Comparable)Double.valueOf(AABBdUtilKt.signedDistanceTo(this.a, (Vector3dc)object)));
            }
        });
        object4 = new Vector3d();
        Object object5 = list;
        object3 = object5.iterator();
        while (object3.hasNext()) {
            object2 = object3.next();
            object5 = (VsiConvexPolygonc)object2;
            if (!AABBdUtilKt.intersectsAABB(dq_02.getAabb(), object5.getAabb())) continue;
            List<Vector3dc> list2 = dk_0.a(object5.getNormals());
            object4 = dn_0.INSTANCE.a(dq_02, (Vector3dc)object4, (VsiConvexPolygonc)object5, list2.iterator(), Db.a.a(), Db.a.a());
        }
        double d4 = d3 * Math.tan(Math.toRadians(90.0 - d2));
        object3 = dk_0.a((AABBdc)object6, 0.0, -0.001);
        AABBd aABBd = new AABBd(object3.minX() + d4, object3.minY(), object3.minZ() + d4, object3.maxX() - d4, object3.maxY(), object3.maxZ() - d4).translate((Vector3dc)object4);
        Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"");
        object3 = aABBd;
        object2 = dq_0.a_.a$default(Dq.a_, (AABBdc)object3, null, null, 6);
        Iterable iterable = list;
        for (Object object6 : iterable) {
            Vector3dc vector3dc;
            object6 = (VsiConvexPolygonc)object6;
            if (!AABBdUtilKt.intersectsAABB(((dh_0)object2).getAabb(), object6.getAabb())) continue;
            list = dk_0.a(object6.getNormals());
            object6 = di_0.a(dn_0.INSTANCE, (VsiConvexPolygonc)object2, new Vector3d(), (VsiConvexPolygonc)object6, list.iterator(), Db.a.a(), Db.a.a(), d2, null, 128, null);
            if (!(vector3dc.lengthSquared() > 1.0E-8)) continue;
            return true;
        }
        return false;
    }

    private static AABBdc a(AABBdc aABBdc) {
        return new AABBd(aABBdc.minX(), aABBdc.minY(), aABBdc.minZ(), aABBdc.maxX(), aABBdc.minY() + 0.1 * (aABBdc.maxY() - aABBdc.minY()), aABBdc.maxZ());
    }

    /*
     * WARNING - void declaration
     */
    private static List<Vector3dc> a(Iterable<? extends Vector3dc> iterable) {
        void vector3dc;
        ArrayList<Vector3dc> arrayList = new ArrayList<Vector3dc>();
        Vector3dc[] vector3dcArray = e;
        boolean bl = false;
        int n2 = vector3dcArray.length;
        while (vector3dc < n2) {
            Vector3dc vector3dc2 = vector3dcArray[vector3dc];
            arrayList.add(vector3dc2);
            ++vector3dc;
        }
        for (Vector3dc vector3dc3 : iterable) {
            arrayList.add(vector3dc3);
            for (Vector3dc vector3dc4 : e) {
                Vector3dc vector3dc5;
                Vector3d vector3d = vector3dc3.cross(vector3dc4, new Vector3d()).normalize();
                Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"");
                vector3dc4 = vector3d;
                if (!(vector3dc5.lengthSquared() > 1.0E-6)) continue;
                arrayList.add(vector3dc4);
            }
        }
        return arrayList;
    }

    static {
        Vector3dc[] vector3dcArray = new Vector3dc[3];
        Vector3dc[] vector3dcArray2 = vector3dcArray;
        vector3dcArray[0] = b;
        vector3dcArray2[1] = c;
        vector3dcArray2[2] = d;
        e = vector3dcArray2;
    }
}

