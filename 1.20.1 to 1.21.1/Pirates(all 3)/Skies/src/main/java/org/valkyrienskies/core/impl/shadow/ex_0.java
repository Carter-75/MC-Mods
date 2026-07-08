/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.ObjectCollection
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.objects.ObjectCollection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.joml.Matrix3d;
import org.joml.Matrix3dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.world.PhysLevel;
import org.valkyrienskies.core.impl.shadow.ev_0;
import org.valkyrienskies.core.impl.shadow.ew_0;
import org.valkyrienskies.core.impl.shadow.hc_0;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ex
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011JA\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000f"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ex;", "", "Lorg/valkyrienskies/core/api/world/PhysLevel;", "p0", "Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;", "p1", "Lorg/valkyrienskies/core/impl/shadow/Hc;", "p2", "Lorg/valkyrienskies/core/impl/shadow/Ew;", "p3", "Lorg/joml/Matrix3dc;", "p4", "Lkotlin/Pair;", "Lorg/joml/Vector3dc;", "a", "(Lorg/valkyrienskies/core/api/world/PhysLevel;Lorg/valkyrienskies/core/api/ships/properties/ShipTransform;Lorg/valkyrienskies/core/impl/shadow/Hc;Lorg/valkyrienskies/core/impl/shadow/Ew;Lorg/joml/Matrix3dc;)Lkotlin/Pair;", "<init>", "()V"})
public final class ex_0 {
    public static final ex_0 INSTANCE = new ex_0();

    private ex_0() {
    }

    public static Pair<Vector3dc, Vector3dc> a(PhysLevel object, ShipTransform shipTransform, hc_0 object2, ew_0 object3, Matrix3dc matrix3dc) {
        Vector3d vector3d;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter((Object)shipTransform, (String)"");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"");
        Intrinsics.checkNotNullParameter((Object)object3, (String)"");
        Intrinsics.checkNotNullParameter((Object)matrix3dc, (String)"");
        Vector3d vector3d2 = new Vector3d();
        Vector3d vector3d3 = new Vector3d();
        Object object4 = object2;
        Vector3dc vector3dc = ((hc_0)object4).d;
        object4 = object2;
        object2 = ((hc_0)object4).e;
        for (ev_0 ev_02 : (ObjectCollection)ew_0.a((ew_0)object3).values()) {
            double d2;
            double d3;
            double d4;
            double d5;
            double d6;
            double d7;
            Vector3dc vector3dc2;
            Vector3dc vector3dc3;
            Vector3dc vector3dc4;
            Vector3dc vector3dc5;
            Object object5;
            Object object6;
            BlockPos2ObjectOpenHashMap<Wing> blockPos2ObjectOpenHashMap = ev_02;
            object4 = ev_02;
            blockPos2ObjectOpenHashMap = ev_02.a;
            if (blockPos2ObjectOpenHashMap.getContainsNullKey()) {
                Vector3dc vector3dc6;
                Wing wing = (Wing)blockPos2ObjectOpenHashMap.getValues()[blockPos2ObjectOpenHashMap.getN()];
                int n2 = blockPos2ObjectOpenHashMap.getKeys()[blockPos2ObjectOpenHashMap.getN() * 3 + 2];
                int n3 = blockPos2ObjectOpenHashMap.getKeys()[blockPos2ObjectOpenHashMap.getN() * 3 + 1];
                int n4 = blockPos2ObjectOpenHashMap.getKeys()[blockPos2ObjectOpenHashMap.getN() * 3];
                object4 = ev_02;
                int n5 = n4;
                int n6 = n3;
                object4 = ev_02;
                boolean bl = ((ev_0)object4).e;
                object6 = wing;
                n3 = n2;
                n4 = n6;
                int n7 = n5;
                object5 = ((ev_0)object4).c;
                Vector3d vector3d4 = object5.transformDirection(new Vector3d(((Wing)object6).getWingNormal()));
                Intrinsics.checkNotNullExpressionValue((Object)vector3d4, (String)"");
                vector3dc5 = vector3d4;
                Vector3d vector3d5 = object5.transformPosition(new Vector3d((double)n7 + 0.5, (double)n4 + 0.5, (double)n3 + 0.5));
                Intrinsics.checkNotNullExpressionValue((Object)vector3d5, (String)"");
                vector3dc4 = vector3d5;
                Vector3d vector3d6 = shipTransform.getShipToWorld().transformPosition(vector3dc4, new Vector3d()).sub(shipTransform.getPositionInWorld());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d6, (String)"");
                vector3dc3 = vector3d6;
                Vector3d vector3d7 = new Vector3d((Vector3dc)object2).cross(vector3dc3).add(vector3dc);
                Intrinsics.checkNotNullExpressionValue((Object)vector3d7, (String)"");
                object4 = vector3d7;
                Vector3d vector3d8 = shipTransform.getShipToWorld().transformDirection(vector3dc5, new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d8, (String)"");
                object5 = vector3d8;
                Vector3d vector3d9 = object4.sub(new Vector3d((Vector3dc)object5).mul(object5.dot((Vector3dc)object4)), new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d9, (String)"");
                vector3dc5 = vector3d9;
                if (vector3dc6.lengthSquared() > 1.0E-12) {
                    Vector3d vector3d10 = new Vector3d(vector3dc5).normalize();
                    Intrinsics.checkNotNullExpressionValue((Object)vector3d10, (String)"");
                    vector3dc2 = vector3d10;
                    d7 = vector3dc2.angle((Vector3dc)object4) * -Math.signum(object5.dot((Vector3dc)object4)) + ((Wing)object6).getWingCamberAttackAngleBias();
                    vector3dc2 = object4.mul(-1.0, new Vector3d());
                    if (!(((Vector3d)vector3dc2).lengthSquared() < 1.0E-12)) {
                        Vector3dc vector3dc7;
                        ((Vector3d)vector3dc2).normalize();
                        Intrinsics.checkNotNull((Object)vector3dc2);
                        vector3dc4 = shipTransform.getShipToWorld().transformPosition(vector3dc4, new Vector3d());
                        d6 = object.getAerodynamicUtils().getAirDensityForY(((Vector3d)vector3dc4).y(), object.getDimension());
                        d5 = Math.sin(d7 * 2.0);
                        d4 = RangesKt.coerceIn((double)(((Wing)object6).getWingLiftPower() * d5 * d6 * vector3dc5.lengthSquared()), (double)-1.0E7, (double)1.0E7);
                        Vector3d vector3d11 = object5.mul(d4, new Vector3d());
                        Intrinsics.checkNotNullExpressionValue((Object)vector3d11, (String)"");
                        vector3dc4 = vector3d11;
                        d3 = (1.0 - Math.cos(d7 * 2.0)) / 2.0;
                        d2 = ((Wing)object6).getWingDragPower() * d3 * d6 * object4.lengthSquared();
                        if (bl) {
                            Vector3d vector3d12 = ((Vector3d)vector3dc2).mul(d2, new Vector3d());
                            Intrinsics.checkNotNullExpressionValue((Object)vector3d12, (String)"");
                            vector3dc7 = vector3d12;
                        } else {
                            vector3dc7 = new Vector3d();
                        }
                        Vector3dc vector3dc8 = vector3dc7;
                        Vector3d vector3d13 = vector3dc4.add(vector3dc8, new Vector3d());
                        Intrinsics.checkNotNullExpressionValue((Object)vector3d13, (String)"");
                        vector3dc8 = vector3d13;
                        if (!(vector3dc8.lengthSquared() > 1.0E16)) {
                            object6 = vector3dc3.cross(vector3dc8, new Vector3d());
                            vector3d2.add(vector3dc8);
                            vector3d3.add((Vector3dc)object6);
                        }
                    }
                }
            }
            for (int i2 = blockPos2ObjectOpenHashMap.getN(); i2 >= 0; --i2) {
                Vector3dc vector3dc9;
                Vector3dc vector3dc10;
                if (blockPos2ObjectOpenHashMap.getKeys()[i2 * 3] == 0 && blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 1] == 0 && blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 2] == 0) continue;
                Wing wing = (Wing)blockPos2ObjectOpenHashMap.getValues()[i2];
                int n8 = blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 2];
                int n9 = blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 1];
                int n10 = blockPos2ObjectOpenHashMap.getKeys()[i2 * 3];
                object4 = ev_02;
                int n11 = n10;
                int n12 = n9;
                object4 = ev_02;
                boolean bl = ((ev_0)object4).e;
                object6 = wing;
                n9 = n8;
                n10 = n12;
                int n13 = n11;
                object5 = ((ev_0)object4).c;
                Vector3d vector3d14 = object5.transformDirection(new Vector3d(((Wing)object6).getWingNormal()));
                Intrinsics.checkNotNullExpressionValue((Object)vector3d14, (String)"");
                vector3dc5 = vector3d14;
                Vector3d vector3d15 = object5.transformPosition(new Vector3d((double)n13 + 0.5, (double)n10 + 0.5, (double)n9 + 0.5));
                Intrinsics.checkNotNullExpressionValue((Object)vector3d15, (String)"");
                vector3dc4 = vector3d15;
                Vector3d vector3d16 = shipTransform.getShipToWorld().transformPosition(vector3dc4, new Vector3d()).sub(shipTransform.getPositionInWorld());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d16, (String)"");
                vector3dc3 = vector3d16;
                Vector3d vector3d17 = new Vector3d((Vector3dc)object2).cross(vector3dc3).add(vector3dc);
                Intrinsics.checkNotNullExpressionValue((Object)vector3d17, (String)"");
                object4 = vector3d17;
                Vector3d vector3d18 = shipTransform.getShipToWorld().transformDirection(vector3dc5, new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d18, (String)"");
                object5 = vector3d18;
                Vector3d vector3d19 = object4.sub(new Vector3d((Vector3dc)object5).mul(object5.dot((Vector3dc)object4)), new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d19, (String)"");
                vector3dc5 = vector3d19;
                if (!(vector3dc10.lengthSquared() > 1.0E-12)) continue;
                Vector3d vector3d20 = new Vector3d(vector3dc5).normalize();
                Intrinsics.checkNotNullExpressionValue((Object)vector3d20, (String)"");
                vector3dc2 = vector3d20;
                d7 = vector3dc2.angle((Vector3dc)object4) * -Math.signum(object5.dot((Vector3dc)object4)) + ((Wing)object6).getWingCamberAttackAngleBias();
                vector3dc2 = object4.mul(-1.0, new Vector3d());
                if (((Vector3d)vector3dc2).lengthSquared() < 1.0E-12) continue;
                ((Vector3d)vector3dc2).normalize();
                Intrinsics.checkNotNull((Object)vector3dc2);
                vector3dc4 = shipTransform.getShipToWorld().transformPosition(vector3dc4, new Vector3d());
                d6 = object.getAerodynamicUtils().getAirDensityForY(((Vector3d)vector3dc4).y(), object.getDimension());
                d5 = Math.sin(d7 * 2.0);
                d4 = RangesKt.coerceIn((double)(((Wing)object6).getWingLiftPower() * d5 * d6 * vector3dc5.lengthSquared()), (double)-1.0E7, (double)1.0E7);
                Vector3d vector3d21 = object5.mul(d4, new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d21, (String)"");
                vector3dc4 = vector3d21;
                d3 = (1.0 - Math.cos(d7 * 2.0)) / 2.0;
                d2 = ((Wing)object6).getWingDragPower() * d3 * d6 * object4.lengthSquared();
                if (bl) {
                    Vector3d vector3d22 = ((Vector3d)vector3dc2).mul(d2, new Vector3d());
                    Intrinsics.checkNotNullExpressionValue((Object)vector3d22, (String)"");
                    vector3dc9 = vector3d22;
                } else {
                    vector3dc9 = new Vector3d();
                }
                Vector3dc vector3dc11 = vector3dc9;
                Vector3d vector3d23 = vector3dc4.add(vector3dc11, new Vector3d());
                Intrinsics.checkNotNullExpressionValue((Object)vector3d23, (String)"");
                vector3dc11 = vector3d23;
                if (vector3dc11.lengthSquared() > 1.0E16) continue;
                object6 = vector3dc3.cross(vector3dc11, new Vector3d());
                vector3d2.add(vector3dc11);
                vector3d3.add((Vector3dc)object6);
            }
        }
        object3 = matrix3dc.invert(new Matrix3d());
        object = ((Matrix3d)object3).transform(shipTransform.getWorldToShip().transformDirection(vector3d3, new Vector3d()));
        if (vector3d.length() > Math.PI * 4) {
            vector3d3.mul(Math.PI * 4 / ((Vector3d)object).length());
        }
        return new Pair((Object)vector3d2, (Object)vector3d3);
    }
}

