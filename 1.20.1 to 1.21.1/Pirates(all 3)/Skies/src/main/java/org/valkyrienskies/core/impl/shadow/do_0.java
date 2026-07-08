/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.CollisionPoint;
import org.valkyrienskies.core.impl.shadow.FV;
import org.valkyrienskies.core.impl.shadow.dt_1;
import org.valkyrienskies.core.impl.shadow.dy_1;
import org.valkyrienskies.core.internal.VsiCore;
import org.valkyrienskies.core.internal.collision.VsiSolidShapeUtils;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Do
 */
@dy_1
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00160\u0019\u00a2\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u001b\u0010\u0011\u001a\u00020\u00168CX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Do;", "Lorg/valkyrienskies/core/internal/collision/VsiSolidShapeUtils;", "", "Lorg/joml/primitives/AABBic;", "p0", "p1", "cutBoxes", "(Ljava/util/List;Lorg/joml/primitives/AABBic;)Ljava/util/List;", "", "Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "generateCollisionPointsForBoxes", "(Ljava/util/List;)Ljava/util/List;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "generateShapeFromBoxes", "(Ljava/util/List;)Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "mergeBoxes", "", "c", "I", "a", "d", "b", "Lorg/valkyrienskies/core/internal/VsiCore;", "Lorg/valkyrienskies/core/impl/shadow/dT;", "()Lorg/valkyrienskies/core/internal/VsiCore;", "Lorg/valkyrienskies/core/impl/shadow/dT;", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/dT;)V"})
public final class do_0
implements VsiSolidShapeUtils {
    private static /* synthetic */ KProperty<Object>[] a;
    private final dt_1 b;
    private final int c;
    private final int d;

    @Inject
    public do_0(dt_1<VsiCore> dt_12) {
        Intrinsics.checkNotNullParameter(dt_12, (String)"");
        this.b = dt_12;
        this.c = 10;
        this.d = 20;
    }

    @JvmName(name="a")
    private final VsiCore a() {
        return (VsiCore)FV.a(this.b, a[0]);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public final List<AABBic> mergeBoxes(List<AABBic> boxes) {
        Intrinsics.checkNotNullParameter(boxes, (String)"");
        if (boxes.size() < 2) {
            return boxes;
        }
        var2_2 = false;
        block0: while (!var2_2) {
            var4_4 = boxes.size();
            for (var3_3 = 0; var3_3 < var4_4; ++var3_3) {
                var6_6 = boxes.size();
                for (var5_5 = var3_3 + 1; var5_5 < var6_6; ++var5_5) {
                    block7: {
                        block8: {
                            block6: {
                                var8_8 = boxes.get(var5_5);
                                var7_7 = boxes.get(var3_3);
                                if (var7_7.minY() != var8_8.minY() || var7_7.maxY() != var8_8.maxY() || var7_7.minZ() != var8_8.minZ() || var7_7.maxZ() != var8_8.maxZ()) break block6;
                                var9_9 = var7_7.minX();
                                var10_10 = var7_7.maxX() + 1;
                                var11_11 = var8_8.minX();
                                var12_12 = var8_8.maxX() + 1;
                                if (var9_9 > var12_12 || var10_10 < var11_11) break block6;
                                v0 /* !! */  = new AABBi(Math.min(var7_7.minX(), var8_8.minX()), var7_7.minY(), var7_7.minZ(), Math.max(var7_7.maxX(), var8_8.maxX()), var7_7.maxY(), var7_7.maxZ());
                                break block7;
                            }
                            if (var7_7.minX() != var8_8.minX() || var7_7.maxX() != var8_8.maxX() || var7_7.minZ() != var8_8.minZ() || var7_7.maxZ() != var8_8.maxZ()) break block8;
                            var9_9 = var7_7.minY();
                            var10_10 = var7_7.maxY() + 1;
                            var11_11 = var8_8.minY();
                            var12_12 = var8_8.maxY() + 1;
                            if (var9_9 > var12_12 || var10_10 < var11_11) break block8;
                            v0 /* !! */  = new AABBi(var7_7.minX(), Math.min(var7_7.minY(), var8_8.minY()), var7_7.minZ(), var7_7.maxX(), Math.max(var7_7.maxY(), var8_8.maxY()), var7_7.maxZ());
                            break block7;
                        }
                        if (var7_7.minX() != var8_8.minX() || var7_7.maxX() != var8_8.maxX() || var7_7.minY() != var8_8.minY() || var7_7.maxY() != var8_8.maxY()) ** GOTO lbl-1000
                        var9_9 = var7_7.minZ();
                        var10_10 = var7_7.maxZ() + 1;
                        var11_11 = var8_8.minZ();
                        var12_12 = var8_8.maxZ() + 1;
                        if (var9_9 <= var12_12 && var10_10 >= var11_11) {
                            v0 /* !! */  = new AABBi(var7_7.minX(), var7_7.minY(), Math.min(var7_7.minZ(), var8_8.minZ()), var7_7.maxX(), var7_7.maxY(), Math.max(var7_7.maxZ(), var8_8.maxZ()));
                        } else lbl-1000:
                        // 2 sources

                        {
                            v0 /* !! */  = var7_7 = null;
                        }
                    }
                    if (v0 /* !! */  == null) continue;
                    boxes.remove(var5_5);
                    boxes.remove(var3_3);
                    boxes.add(var7_7);
                    continue block0;
                }
            }
            var2_2 = true;
        }
        return var1_1;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final List<AABBic> cutBoxes(List<AABBic> boxes, AABBic cut) {
        void var1_1;
        Intrinsics.checkNotNullParameter(boxes, (String)"");
        Intrinsics.checkNotNullParameter((Object)cut, (String)"");
        AABBi aABBi = new AABBi();
        AABBi aABBi2 = new AABBi();
        if (boxes.isEmpty()) {
            return boxes;
        }
        boolean bl = false;
        block0: while (!bl) {
            int n2 = boxes.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                AABBic aABBic = boxes.get(i2);
                AABBic aABBic2 = cut;
                Object object = aABBic;
                AABBic aABBic3 = aABBi2;
                AABBic aABBic4 = aABBi;
                ((AABBi)aABBic4).setMin(object.minX(), object.minY(), object.minZ());
                ((AABBi)aABBic4).setMax(object.maxX(), object.maxY(), object.maxZ());
                ((AABBi)aABBic3).setMin(aABBic2.minX(), aABBic2.minY(), aABBic2.minZ());
                ((AABBi)aABBic3).setMax(aABBic2.maxX(), aABBic2.maxY(), aABBic2.maxZ());
                if (!((AABBi)aABBic4).intersectsAABB(aABBic3)) continue;
                boxes.remove(i2);
                object = boxes;
                aABBic3 = cut;
                aABBic4 = aABBic;
                if (aABBic4.minX() < aABBic3.minX()) {
                    object.add(new AABBi(aABBic4.minX(), aABBic4.minY(), aABBic4.minZ(), aABBic3.minX() - 1, aABBic4.maxY(), aABBic4.maxZ()));
                }
                if (aABBic4.maxX() > aABBic3.maxX()) {
                    object.add(new AABBi(aABBic3.maxX() + 1, aABBic4.minY(), aABBic4.minZ(), aABBic4.maxX(), aABBic4.maxY(), aABBic4.maxZ()));
                }
                if (aABBic4.minY() < aABBic3.minY()) {
                    object.add(new AABBi(aABBic3.minX(), aABBic4.minY(), aABBic4.minZ(), aABBic3.maxX(), aABBic3.minY() - 1, aABBic4.maxZ()));
                }
                if (aABBic4.maxY() > aABBic3.maxY()) {
                    object.add(new AABBi(aABBic3.minX(), aABBic3.maxY() + 1, aABBic4.minZ(), aABBic3.maxX(), aABBic4.maxY(), aABBic4.maxZ()));
                }
                if (aABBic4.minZ() < aABBic3.minZ()) {
                    object.add(new AABBi(aABBic3.minX(), aABBic3.minY(), aABBic4.minZ(), aABBic3.maxX(), aABBic3.maxY(), aABBic3.minZ() - 1));
                }
                if (aABBic4.maxZ() <= aABBic3.maxZ()) continue block0;
                object.add(new AABBi(aABBic3.minX(), aABBic3.minY(), aABBic3.maxZ() + 1, aABBic3.maxX(), aABBic3.maxY(), aABBic4.maxZ()));
                continue block0;
            }
            bl = true;
        }
        return var1_1;
    }

    @Override
    public final List<CollisionPoint> generateCollisionPointsForBoxes(List<? extends AABBic> boxes) {
        Intrinsics.checkNotNullParameter(boxes, (String)"");
        ArrayList<CollisionPoint> arrayList = new ArrayList<CollisionPoint>();
        for (AABBic aABBic : boxes) {
            float f2;
            float f3;
            float f4;
            int n2 = aABBic.maxX() + 1 - aABBic.minX();
            int n3 = aABBic.maxY() + 1 - aABBic.minY();
            int n4 = aABBic.maxZ() + 1 - aABBic.minZ();
            if (n2 << 1 <= n3 && n2 << 1 <= n4) {
                f4 = (float)n2 / 2.0f;
                float f5 = (float)(aABBic.maxX() + 1 + aABBic.minX()) / 2.0f;
                float f6 = (float)aABBic.minY() + f4;
                f3 = (float)aABBic.minZ() + f4;
                f2 = (float)(aABBic.maxY() + 1) - f4;
                float f7 = (float)(aABBic.maxZ() + 1) - f4;
                arrayList.add(new CollisionPoint(f5 / 16.0f, f6 / 16.0f, f3 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f5 / 16.0f, f6 / 16.0f, f7 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f5 / 16.0f, f2 / 16.0f, f3 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f5 / 16.0f, f2 / 16.0f, f7 / 16.0f, f4 / 16.0f));
                continue;
            }
            if (n3 << 1 <= n2 && n3 << 1 <= n4) {
                f4 = (float)n3 / 2.0f;
                float f8 = (float)(aABBic.maxY() + 1 + aABBic.minY()) / 2.0f;
                float f9 = (float)aABBic.minX() + f4;
                f3 = (float)aABBic.minZ() + f4;
                f2 = (float)(aABBic.maxX() + 1) - f4;
                float f10 = (float)(aABBic.maxZ() + 1) - f4;
                arrayList.add(new CollisionPoint(f9 / 16.0f, f8 / 16.0f, f3 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f9 / 16.0f, f8 / 16.0f, f10 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f2 / 16.0f, f8 / 16.0f, f3 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f2 / 16.0f, f8 / 16.0f, f10 / 16.0f, f4 / 16.0f));
                continue;
            }
            if (n4 << 1 <= n2 && n4 << 1 <= n3) {
                f4 = (float)n4 / 2.0f;
                float f11 = (float)(aABBic.maxZ() + 1 + aABBic.minZ()) / 2.0f;
                float f12 = (float)aABBic.minX() + f4;
                f3 = (float)aABBic.minY() + f4;
                f2 = (float)(aABBic.maxX() + 1) - f4;
                float f13 = (float)(aABBic.maxY() + 1) - f4;
                arrayList.add(new CollisionPoint(f12 / 16.0f, f3 / 16.0f, f11 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f12 / 16.0f, f13 / 16.0f, f11 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f2 / 16.0f, f3 / 16.0f, f11 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f2 / 16.0f, f13 / 16.0f, f11 / 16.0f, f4 / 16.0f));
                continue;
            }
            if (n2 >= 2 * n3 && n2 >= 2 * n4) {
                f4 = (float)Math.min(n3, n4) / 2.0f;
                float f14 = (float)(aABBic.maxY() + 1 + aABBic.minY()) / 2.0f;
                float f15 = (float)(aABBic.maxZ() + 1 + aABBic.minZ()) / 2.0f;
                arrayList.add(new CollisionPoint(((float)aABBic.minX() + f4) / 16.0f, f14 / 16.0f, f15 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint((float)(aABBic.maxX() + 1 + aABBic.minX()) / 2.0f / 16.0f, f14 / 16.0f, f15 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)(aABBic.maxX() + 1) - f4) / 16.0f, f14 / 16.0f, f15 / 16.0f, f4 / 16.0f));
                continue;
            }
            if (n3 >= 2 * n2 && n3 >= 2 * n4) {
                f4 = (float)Math.min(n2, n4) / 2.0f;
                float f16 = (float)(aABBic.maxX() + 1 + aABBic.minX()) / 2.0f;
                float f17 = (float)(aABBic.maxZ() + 1 + aABBic.minZ()) / 2.0f;
                arrayList.add(new CollisionPoint(f16 / 16.0f, ((float)aABBic.minY() + f4) / 16.0f, f17 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f16 / 16.0f, (float)(aABBic.maxY() + 1 + aABBic.minY()) / 2.0f / 16.0f, f17 / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f16 / 16.0f, ((float)(aABBic.maxY() + 1) - f4) / 16.0f, f17 / 16.0f, f4 / 16.0f));
                continue;
            }
            if (n4 >= 2 * n2 && n4 >= 2 * n3) {
                f4 = (float)Math.min(n2, n3) / 2.0f;
                float f18 = (float)(aABBic.maxX() + 1 + aABBic.minX()) / 2.0f;
                float f19 = (float)(aABBic.maxY() + 1 + aABBic.minY()) / 2.0f;
                arrayList.add(new CollisionPoint(f18 / 16.0f, f19 / 16.0f, ((float)aABBic.minZ() + f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f18 / 16.0f, f19 / 16.0f, (float)(aABBic.maxZ() + 1 + aABBic.minZ()) / 2.0f / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(f18 / 16.0f, f19 / 16.0f, ((float)(aABBic.maxZ() + 1) - f4) / 16.0f, f4 / 16.0f));
                continue;
            }
            if (boxes.size() == 1) {
                f4 = (float)Math.min(n2, Math.min(n3, n4)) / 4.0f;
                arrayList.add(new CollisionPoint(((float)aABBic.minX() + f4) / 16.0f, ((float)aABBic.minY() + f4) / 16.0f, ((float)aABBic.minZ() + f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)aABBic.minX() + f4) / 16.0f, ((float)aABBic.minY() + f4) / 16.0f, ((float)aABBic.maxZ() + 1.0f - f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)aABBic.minX() + f4) / 16.0f, ((float)aABBic.maxY() + 1.0f - f4) / 16.0f, ((float)aABBic.minZ() + f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)aABBic.minX() + f4) / 16.0f, ((float)aABBic.maxY() + 1.0f - f4) / 16.0f, ((float)aABBic.maxZ() + 1.0f - f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)aABBic.maxX() + 1.0f - f4) / 16.0f, ((float)aABBic.minY() + f4) / 16.0f, ((float)aABBic.minZ() + f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)aABBic.maxX() + 1.0f - f4) / 16.0f, ((float)aABBic.minY() + f4) / 16.0f, ((float)aABBic.maxZ() + 1.0f - f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)aABBic.maxX() + 1.0f - f4) / 16.0f, ((float)aABBic.maxY() + 1.0f - f4) / 16.0f, ((float)aABBic.minZ() + f4) / 16.0f, f4 / 16.0f));
                arrayList.add(new CollisionPoint(((float)aABBic.maxX() + 1.0f - f4) / 16.0f, ((float)aABBic.maxY() + 1.0f - f4) / 16.0f, ((float)aABBic.maxZ() + 1.0f - f4) / 16.0f, f4 / 16.0f));
                continue;
            }
            f4 = (float)Math.min(n2, Math.min(n3, n4)) / 2.0f;
            float f20 = (float)(aABBic.maxX() + 1 + aABBic.minX()) / 2.0f;
            float f21 = (float)(aABBic.maxY() + 1 + aABBic.minY()) / 2.0f;
            f3 = (float)(aABBic.maxZ() + 1 + aABBic.minZ()) / 2.0f;
            arrayList.add(new CollisionPoint(f20 / 16.0f, f21 / 16.0f, f3 / 16.0f, f4 / 16.0f));
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final BoxesBlockShape generateShapeFromBoxes(List<AABBic> posBoxes) {
        void var1_1;
        Intrinsics.checkNotNullParameter(posBoxes, (String)"");
        List<AABBic> list = new AABBi(0, 0, 0, 15, 15, 15);
        if (posBoxes.isEmpty()) {
            return this.a().newSolidStateBoxesShapeBuilder().addNegativeBox((AABBic)((Object)list)).build();
        }
        this.mergeBoxes(posBoxes);
        if (posBoxes.size() > this.c) {
            return null;
        }
        Object[] objectArray = new AABBic[1];
        Object object = objectArray;
        objectArray[0] = list;
        list = CollectionsKt.mutableListOf((Object[])object);
        for (AABBic aABBic : posBoxes) {
            list = this.cutBoxes(list, aABBic);
        }
        this.mergeBoxes(list);
        if (list.size() > this.c) {
            return null;
        }
        object = this.generateCollisionPointsForBoxes(posBoxes);
        if (object.size() > this.d) {
            return null;
        }
        return this.a().newSolidStateBoxesShapeBuilder().addCollisionPoints((Iterable)object).addNegativeBoxes((Iterable<? extends AABBic>)list).addPositiveBoxes((Iterable)var1_1).build();
    }

    private static final AABBi a(AABBic aABBic, AABBic aABBic2) {
        int n2;
        int n3;
        int n4;
        int n5;
        if (aABBic.minY() == aABBic2.minY() && aABBic.maxY() == aABBic2.maxY() && aABBic.minZ() == aABBic2.minZ() && aABBic.maxZ() == aABBic2.maxZ()) {
            n5 = aABBic.minX();
            n4 = aABBic.maxX() + 1;
            n3 = aABBic2.minX();
            n2 = aABBic2.maxX() + 1;
            if (n5 <= n2 && n4 >= n3) {
                return new AABBi(Math.min(aABBic.minX(), aABBic2.minX()), aABBic.minY(), aABBic.minZ(), Math.max(aABBic.maxX(), aABBic2.maxX()), aABBic.maxY(), aABBic.maxZ());
            }
        }
        if (aABBic.minX() == aABBic2.minX() && aABBic.maxX() == aABBic2.maxX() && aABBic.minZ() == aABBic2.minZ() && aABBic.maxZ() == aABBic2.maxZ()) {
            n5 = aABBic.minY();
            n4 = aABBic.maxY() + 1;
            n3 = aABBic2.minY();
            n2 = aABBic2.maxY() + 1;
            if (n5 <= n2 && n4 >= n3) {
                return new AABBi(aABBic.minX(), Math.min(aABBic.minY(), aABBic2.minY()), aABBic.minZ(), aABBic.maxX(), Math.max(aABBic.maxY(), aABBic2.maxY()), aABBic.maxZ());
            }
        }
        if (aABBic.minX() == aABBic2.minX() && aABBic.maxX() == aABBic2.maxX() && aABBic.minY() == aABBic2.minY() && aABBic.maxY() == aABBic2.maxY()) {
            n5 = aABBic.minZ();
            n4 = aABBic.maxZ() + 1;
            n3 = aABBic2.minZ();
            n2 = aABBic2.maxZ() + 1;
            if (n5 <= n2 && n4 >= n3) {
                return new AABBi(aABBic.minX(), aABBic.minY(), Math.min(aABBic.minZ(), aABBic2.minZ()), aABBic.maxX(), aABBic.maxY(), Math.max(aABBic.maxZ(), aABBic2.maxZ()));
            }
        }
        return null;
    }

    private static final boolean a(AABBi aABBi, AABBi aABBi2, AABBic aABBic, AABBic aABBic2) {
        aABBi.setMin(aABBic.minX(), aABBic.minY(), aABBic.minZ());
        aABBi.setMax(aABBic.maxX(), aABBic.maxY(), aABBic.maxZ());
        aABBi2.setMin(aABBic2.minX(), aABBic2.minY(), aABBic2.minZ());
        aABBi2.setMax(aABBic2.maxX(), aABBic2.maxY(), aABBic2.maxZ());
        return aABBi.intersectsAABB(aABBi2);
    }

    private static final void a(AABBic aABBic, AABBic aABBic2, List<AABBic> list) {
        if (aABBic.minX() < aABBic2.minX()) {
            list.add(new AABBi(aABBic.minX(), aABBic.minY(), aABBic.minZ(), aABBic2.minX() - 1, aABBic.maxY(), aABBic.maxZ()));
        }
        if (aABBic.maxX() > aABBic2.maxX()) {
            list.add(new AABBi(aABBic2.maxX() + 1, aABBic.minY(), aABBic.minZ(), aABBic.maxX(), aABBic.maxY(), aABBic.maxZ()));
        }
        if (aABBic.minY() < aABBic2.minY()) {
            list.add(new AABBi(aABBic2.minX(), aABBic.minY(), aABBic.minZ(), aABBic2.maxX(), aABBic2.minY() - 1, aABBic.maxZ()));
        }
        if (aABBic.maxY() > aABBic2.maxY()) {
            list.add(new AABBi(aABBic2.minX(), aABBic2.maxY() + 1, aABBic.minZ(), aABBic2.maxX(), aABBic.maxY(), aABBic.maxZ()));
        }
        if (aABBic.minZ() < aABBic2.minZ()) {
            list.add(new AABBi(aABBic2.minX(), aABBic2.minY(), aABBic.minZ(), aABBic2.maxX(), aABBic2.maxY(), aABBic2.minZ() - 1));
        }
        if (aABBic.maxZ() > aABBic2.maxZ()) {
            list.add(new AABBi(aABBic2.minX(), aABBic2.minY(), aABBic2.maxZ() + 1, aABBic2.maxX(), aABBic2.maxY(), aABBic.maxZ()));
        }
    }

    static {
        KProperty[] kPropertyArray = new KProperty[1];
        KProperty[] kPropertyArray2 = kPropertyArray;
        kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(do_0.class, "vsCore", "getVsCore()Lorg/valkyrienskies/core/internal/VsiCore;", 0)));
        a = kPropertyArray2;
    }
}

