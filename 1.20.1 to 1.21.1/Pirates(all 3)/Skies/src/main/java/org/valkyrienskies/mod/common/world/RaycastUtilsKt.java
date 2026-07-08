/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmOverloads
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Ref$DoubleRef
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3532
 *  net.minecraft.class_3610
 *  net.minecraft.class_3959
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 */
package org.valkyrienskies.mod.common.world;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3610;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2d;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.joml.primitives.LineSegmentf;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.util.AABBdUtilKt;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.util.McMathUtilKt;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\b\b\u0002\u0010\b\u001a\u00020\u0003H\u0007\u00a2\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\u0010\u001a\u00020\t*\u00020\u00002\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a]\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00012\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00028\u00000\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0016H\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0018\u001aI\u0010$\u001a\u0004\u0018\u00010#*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u001f2\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b$\u0010%\u001a\u0019\u0010'\u001a\u00020\t*\u00020&2\u0006\u0010\f\u001a\u00020\u0001\u00a2\u0006\u0004\b'\u0010(\"\u001c\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u0006-"}, d2={"Lnet/minecraft/class_1937;", "Lnet/minecraft/class_3959;", "ctx", "", "shouldTransformHitPos", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "skipShip", "skipWorld", "Lnet/minecraft/class_3965;", "clipIncludeShips", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_3959;ZLjava/lang/Long;Z)Lnet/minecraft/class_3965;", "context", "Lnet/minecraft/class_243;", "realStart", "realEnd", "clip", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_3959;Lnet/minecraft/class_243;Lnet/minecraft/class_243;)Lnet/minecraft/class_3965;", "T", "raycastContext", "Ljava/util/function/BiFunction;", "Lnet/minecraft/class_2338;", "Ljava/util/function/Function;", "blockRaycaster", "(Lnet/minecraft/class_243;Lnet/minecraft/class_243;Lnet/minecraft/class_3959;Ljava/util/function/BiFunction;Ljava/util/function/Function;)Ljava/lang/Object;", "Lnet/minecraft/class_1297;", "shooter", "origStartVecM", "origEndVecM", "Lnet/minecraft/class_238;", "origBoundingBoxM", "Ljava/util/function/Predicate;", "filter", "", "maxDistance2", "Lnet/minecraft/class_3966;", "raytraceEntities", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1297;Lnet/minecraft/class_243;Lnet/minecraft/class_243;Lnet/minecraft/class_238;Ljava/util/function/Predicate;D)Lnet/minecraft/class_3966;", "Lnet/minecraft/class_1922;", "vanillaClip", "(Lnet/minecraft/class_1922;Lnet/minecraft/class_3959;)Lnet/minecraft/class_3965;", "Lorg/apache/logging/log4j/Logger;", "kotlin.jvm.PlatformType", "logger", "Lorg/apache/logging/log4j/Logger;", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nRaycastUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RaycastUtils.kt\norg/valkyrienskies/mod/common/world/RaycastUtilsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,314:1\n1863#2,2:315\n1863#2,2:317\n*S KotlinDebug\n*F\n+ 1 RaycastUtils.kt\norg/valkyrienskies/mod/common/world/RaycastUtilsKt\n*L\n267#1:315,2\n226#1:317,2\n*E\n"})
public final class RaycastUtilsKt {
    private static final Logger logger = LogManager.getLogger("RaycastUtilsKt");

    @JvmOverloads
    @NotNull
    public static final class_3965 clipIncludeShips(@NotNull class_1937 $this$clipIncludeShips, @NotNull class_3959 ctx, boolean shouldTransformHitPos, @Nullable Long skipShip, boolean skipWorld) {
        class_3965 vanillaHit;
        Intrinsics.checkNotNullParameter((Object)$this$clipIncludeShips, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        if (skipWorld) {
            class_243 line = ctx.method_17747().method_1020(ctx.method_17750());
            v0 = class_3965.method_17778((class_243)ctx.method_17747(), (class_2350)class_2350.method_10142((double)line.field_1352, (double)line.field_1351, (double)line.field_1350), (class_2338)class_2338.method_49638((class_2374)((class_2374)ctx.method_17747())));
        } else {
            v0 = vanillaHit = RaycastUtilsKt.vanillaClip((class_1922)$this$clipIncludeShips, ctx);
        }
        if (VSGameUtilsKt.getShipObjectWorld($this$clipIncludeShips) == null) {
            logger.error("shipObjectWorld was empty for level raytrace, this should not be possible! Returning vanilla result.");
            Intrinsics.checkNotNull((Object)vanillaHit);
            return vanillaHit;
        }
        class_3965 closestHit = vanillaHit;
        class_243 closestHitPos = vanillaHit.field_1329;
        double closestHitDist = closestHitPos.method_1025(ctx.method_17750());
        class_243 class_2432 = ctx.method_17750();
        Intrinsics.checkNotNullExpressionValue((Object)class_2432, (String)"getFrom(...)");
        Vector3dc vector3dc = VectorConversionsMCKt.toJOML(class_2432);
        class_243 class_2433 = ctx.method_17747();
        Intrinsics.checkNotNullExpressionValue((Object)class_2433, (String)"getTo(...)");
        AABBd aABBd = new AABBd(vector3dc, VectorConversionsMCKt.toJOML(class_2433)).correctBounds();
        Intrinsics.checkNotNullExpressionValue((Object)aABBd, (String)"correctBounds(...)");
        AABBdc clipAABB = aABBd;
        LineSegmentf clipSegment = new LineSegmentf(ctx.method_17750().method_46409(), ctx.method_17747().method_46409());
        for (Ship ship : VSGameUtilsKt.getShipsIntersecting($this$clipIncludeShips, clipAABB)) {
            Object object;
            Object worldToShip;
            Object object2;
            Vector2d chopParam = new Vector2d();
            AABBd expandedAABB = AABBdUtilKt.expand(new AABBd(ship.getWorldAABB()), 1.0);
            int intersectType = expandedAABB.intersectsLineSegment(clipSegment, chopParam);
            if (intersectType == -1) continue;
            Long l2 = skipShip;
            if (l2 != null && ship.getId() == l2.longValue()) continue;
            Vector3d choppedFrom = null;
            Vector3d choppedTo = null;
            switch (intersectType) {
                case 2: {
                    class_243 class_2434 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_2434, (String)"getFrom(...)");
                    Vector3d vector3d = VectorConversionsMCKt.toJOML(class_2434);
                    class_243 class_2435 = ctx.method_17747();
                    Intrinsics.checkNotNullExpressionValue((Object)class_2435, (String)"getTo(...)");
                    Vector3d vector3d2 = VectorConversionsMCKt.toJOML(class_2435);
                    class_243 class_2436 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_2436, (String)"getFrom(...)");
                    choppedFrom = vector3d.add(vector3d2.sub(VectorConversionsMCKt.toJOML(class_2436)).mul(chopParam.x));
                    class_243 class_2437 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_2437, (String)"getFrom(...)");
                    Vector3d vector3d3 = VectorConversionsMCKt.toJOML(class_2437);
                    class_243 class_2438 = ctx.method_17747();
                    Intrinsics.checkNotNullExpressionValue((Object)class_2438, (String)"getTo(...)");
                    Vector3d vector3d4 = VectorConversionsMCKt.toJOML(class_2438);
                    class_243 class_2439 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_2439, (String)"getFrom(...)");
                    choppedTo = vector3d3.add(vector3d4.sub(VectorConversionsMCKt.toJOML(class_2439)).mul(chopParam.y));
                    break;
                }
                case 1: {
                    class_243 class_24310 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24310, (String)"getFrom(...)");
                    if (expandedAABB.containsPoint(VectorConversionsMCKt.toJOML(class_24310))) {
                        class_243 class_24311 = ctx.method_17750();
                        Intrinsics.checkNotNullExpressionValue((Object)class_24311, (String)"getFrom(...)");
                        choppedFrom = VectorConversionsMCKt.toJOML(class_24311);
                        class_243 class_24312 = ctx.method_17750();
                        Intrinsics.checkNotNullExpressionValue((Object)class_24312, (String)"getFrom(...)");
                        Vector3d vector3d = VectorConversionsMCKt.toJOML(class_24312);
                        class_243 class_24313 = ctx.method_17747();
                        Intrinsics.checkNotNullExpressionValue((Object)class_24313, (String)"getTo(...)");
                        Vector3d vector3d5 = VectorConversionsMCKt.toJOML(class_24313);
                        class_243 class_24314 = ctx.method_17750();
                        Intrinsics.checkNotNullExpressionValue((Object)class_24314, (String)"getFrom(...)");
                        choppedTo = vector3d.add(vector3d5.sub(VectorConversionsMCKt.toJOML(class_24314)).mul(chopParam.y));
                        break;
                    }
                    class_243 class_24315 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24315, (String)"getFrom(...)");
                    Vector3d vector3d = VectorConversionsMCKt.toJOML(class_24315);
                    class_243 class_24316 = ctx.method_17747();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24316, (String)"getTo(...)");
                    Vector3d vector3d6 = VectorConversionsMCKt.toJOML(class_24316);
                    class_243 class_24317 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24317, (String)"getFrom(...)");
                    choppedFrom = vector3d.add(vector3d6.sub(VectorConversionsMCKt.toJOML(class_24317)).mul(chopParam.x));
                    class_243 class_24318 = ctx.method_17747();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24318, (String)"getTo(...)");
                    choppedTo = VectorConversionsMCKt.toJOML(class_24318);
                    break;
                }
                default: {
                    class_243 class_24319 = ctx.method_17750();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24319, (String)"getFrom(...)");
                    choppedFrom = VectorConversionsMCKt.toJOML(class_24319);
                    class_243 class_24320 = ctx.method_17747();
                    Intrinsics.checkNotNullExpressionValue((Object)class_24320, (String)"getTo(...)");
                    choppedTo = VectorConversionsMCKt.toJOML(class_24320);
                }
            }
            if ((object2 = ship instanceof ClientShip ? (ClientShip)ship : null) == null || (object2 = object2.getRenderTransform()) == null || (object2 = object2.getWorldToShip()) == null) {
                object2 = worldToShip = ship.getWorldToShip();
            }
            if ((object = ship instanceof ClientShip ? (ClientShip)ship : null) == null || (object = object.getRenderTransform()) == null || (object = object.getShipToWorld()) == null) {
                object = ship.getShipToWorld();
            }
            Object shipToWorld = object;
            class_243 class_24321 = ctx.method_17750();
            Intrinsics.checkNotNullExpressionValue((Object)class_24321, (String)"getFrom(...)");
            Vector3d vector3d = worldToShip.transformPosition(VectorConversionsMCKt.toJOML(class_24321));
            Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"transformPosition(...)");
            class_243 shipStart = VectorConversionsMCKt.toMinecraft(vector3d);
            class_243 class_24322 = ctx.method_17747();
            Intrinsics.checkNotNullExpressionValue((Object)class_24322, (String)"getTo(...)");
            Vector3d vector3d7 = worldToShip.transformPosition(VectorConversionsMCKt.toJOML(class_24322));
            Intrinsics.checkNotNullExpressionValue((Object)vector3d7, (String)"transformPosition(...)");
            class_243 shipEnd = VectorConversionsMCKt.toMinecraft(vector3d7);
            class_3965 shipHit = RaycastUtilsKt.clip($this$clipIncludeShips, ctx, shipStart, shipEnd);
            class_243 class_24323 = shipHit.field_1329;
            Intrinsics.checkNotNullExpressionValue((Object)class_24323, (String)"location");
            Vector3d vector3d8 = shipToWorld.transformPosition(VectorConversionsMCKt.toJOML(class_24323));
            Intrinsics.checkNotNullExpressionValue((Object)vector3d8, (String)"transformPosition(...)");
            class_243 shipHitPos = VectorConversionsMCKt.toMinecraft(vector3d8);
            double shipHitDist = shipHitPos.method_1025(ctx.method_17750());
            if (!(shipHitDist < closestHitDist) || shipHit.method_17783() == class_239.class_240.field_1333) continue;
            closestHit = shipHit;
            closestHitPos = shipHitPos;
            closestHitDist = shipHitDist;
        }
        if (shouldTransformHitPos) {
            closestHit.field_1329 = closestHitPos;
        }
        class_3965 class_39652 = closestHit;
        Intrinsics.checkNotNull((Object)class_39652);
        return class_39652;
    }

    public static /* synthetic */ class_3965 clipIncludeShips$default(class_1937 class_19372, class_3959 class_39592, boolean bl, Long l2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = true;
        }
        if ((n2 & 4) != 0) {
            l2 = null;
        }
        if ((n2 & 8) != 0) {
            bl2 = false;
        }
        return RaycastUtilsKt.clipIncludeShips(class_19372, class_39592, bl, l2, bl2);
    }

    private static final class_3965 clip(class_1937 $this$clip, class_3959 context, class_243 realStart, class_243 realEnd) {
        class_3965 class_39652 = RaycastUtilsKt.clip(realStart, realEnd, context, (arg_0, arg_1) -> RaycastUtilsKt.clip$lambda$0($this$clip, realStart, realEnd, arg_0, arg_1), arg_0 -> RaycastUtilsKt.clip$lambda$1(realStart, realEnd, arg_0));
        Intrinsics.checkNotNull((Object)class_39652, (String)"null cannot be cast to non-null type net.minecraft.world.phys.BlockHitResult");
        return class_39652;
    }

    private static final <T> T clip(class_243 realStart, class_243 realEnd, class_3959 raycastContext, BiFunction<class_3959, class_2338, T> context, Function<class_3959, T> blockRaycaster) {
        T t;
        class_243 vec3d = realStart;
        class_243 vec3d2 = realEnd;
        if (Intrinsics.areEqual((Object)vec3d, (Object)vec3d2)) {
            t = blockRaycaster.apply(raycastContext);
        } else {
            int l2;
            int k2;
            double d2 = class_3532.method_16436((double)-1.0E-7, (double)vec3d2.field_1352, (double)vec3d.field_1352);
            double e2 = class_3532.method_16436((double)-1.0E-7, (double)vec3d2.field_1351, (double)vec3d.field_1351);
            double f2 = class_3532.method_16436((double)-1.0E-7, (double)vec3d2.field_1350, (double)vec3d.field_1350);
            double g2 = class_3532.method_16436((double)-1.0E-7, (double)vec3d.field_1352, (double)vec3d2.field_1352);
            double h2 = class_3532.method_16436((double)-1.0E-7, (double)vec3d.field_1351, (double)vec3d2.field_1351);
            double i2 = class_3532.method_16436((double)-1.0E-7, (double)vec3d.field_1350, (double)vec3d2.field_1350);
            int j2 = class_3532.method_15357((double)g2);
            class_2338.class_2339 mutable = new class_2338.class_2339(j2, k2 = class_3532.method_15357((double)h2), l2 = class_3532.method_15357((double)i2));
            T object = context.apply(raycastContext, (class_2338)mutable);
            if (object != null) {
                t = object;
            } else {
                double m2 = d2 - g2;
                double n2 = e2 - h2;
                double o = f2 - i2;
                int p = class_3532.method_17822((double)m2);
                int q = class_3532.method_17822((double)n2);
                int r = class_3532.method_17822((double)o);
                double s = p == 0 ? Double.MAX_VALUE : (double)p / m2;
                double t2 = q == 0 ? Double.MAX_VALUE : (double)q / n2;
                double u = r == 0 ? Double.MAX_VALUE : (double)r / o;
                double v = s * (p > 0 ? 1.0 - class_3532.method_15385((double)g2) : class_3532.method_15385((double)g2));
                double w = t2 * (q > 0 ? 1.0 - class_3532.method_15385((double)h2) : class_3532.method_15385((double)h2));
                double x = u * (r > 0 ? 1.0 - class_3532.method_15385((double)i2) : class_3532.method_15385((double)i2));
                Object object2 = null;
                do {
                    if (v > 1.0 && w > 1.0 && x > 1.0) {
                        return blockRaycaster.apply(raycastContext);
                    }
                    if (v < w) {
                        if (v < x) {
                            j2 += p;
                            v += s;
                            continue;
                        }
                        l2 += r;
                        x += u;
                        continue;
                    }
                    if (w < x) {
                        k2 += q;
                        w += t2;
                        continue;
                    }
                    l2 += r;
                    x += u;
                } while ((object2 = context.apply(raycastContext, (class_2338)mutable.method_10103(j2, k2, l2))) == null);
                t = object2;
            }
        }
        return t;
    }

    @Nullable
    public static final class_3966 raytraceEntities(@NotNull class_1937 $this$raytraceEntities, @NotNull class_1297 shooter, @NotNull class_243 origStartVecM, @NotNull class_243 origEndVecM, @NotNull class_238 origBoundingBoxM, @NotNull Predicate<class_1297> filter2, double maxDistance2) {
        Intrinsics.checkNotNullParameter((Object)$this$raytraceEntities, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)shooter, (String)"shooter");
        Intrinsics.checkNotNullParameter((Object)origStartVecM, (String)"origStartVecM");
        Intrinsics.checkNotNullParameter((Object)origEndVecM, (String)"origEndVecM");
        Intrinsics.checkNotNullParameter((Object)origBoundingBoxM, (String)"origBoundingBoxM");
        Intrinsics.checkNotNullParameter(filter2, (String)"filter");
        Ref.DoubleRef distance2 = new Ref.DoubleRef();
        distance2.element = maxDistance2;
        Ref.ObjectRef resultEntity = new Ref.ObjectRef();
        Ref.ObjectRef location = new Ref.ObjectRef();
        List entities = $this$raytraceEntities.method_8333(shooter, origBoundingBoxM, filter2);
        Intrinsics.checkNotNull((Object)entities);
        RaycastUtilsKt.raytraceEntities$checkEntities(distance2, (Ref.ObjectRef<class_1297>)resultEntity, (Ref.ObjectRef<class_243>)location, shooter, entities, origStartVecM, origEndVecM, 1.0);
        Vector3d origStartVec = VectorConversionsMCKt.toJOML(origStartVecM);
        Vector3d origEndVec = VectorConversionsMCKt.toJOML(origEndVecM);
        Vector3d start = new Vector3d();
        Vector3d end = new Vector3d();
        Iterable<Ship> $this$forEach$iv = VSGameUtilsKt.getShipsIntersecting($this$raytraceEntities, VectorConversionsMCKt.toJOML(origBoundingBoxM));
        boolean $i$f$forEach = false;
        Iterator<Ship> iterator2 = $this$forEach$iv.iterator();
        while (iterator2.hasNext()) {
            Ship element$iv;
            Ship it = element$iv = iterator2.next();
            boolean bl = false;
            it.getWorldToShip().transformPosition(origStartVec, start);
            it.getWorldToShip().transformPosition(origEndVec, end);
            double scale = 1.0 / it.getTransform().getShipToWorldScaling().x();
            RaycastUtilsKt.raytraceEntities$checkEntities(distance2, (Ref.ObjectRef<class_1297>)resultEntity, (Ref.ObjectRef<class_243>)location, shooter, entities, VectorConversionsMCKt.toMinecraft(start), VectorConversionsMCKt.toMinecraft(end), scale);
        }
        return resultEntity.element == null ? null : new class_3966((class_1297)resultEntity.element, (class_243)location.element);
    }

    @NotNull
    public static final class_3965 vanillaClip(@NotNull class_1922 $this$vanillaClip, @NotNull class_3959 context) {
        Intrinsics.checkNotNullParameter((Object)$this$vanillaClip, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        Object object = class_1922.method_17744((class_243)context.method_17750(), (class_243)context.method_17747(), (Object)context, (arg_0, arg_1) -> RaycastUtilsKt.vanillaClip$lambda$4($this$vanillaClip, arg_0, arg_1), RaycastUtilsKt::vanillaClip$lambda$5);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"traverseBlocks(...)");
        return (class_3965)object;
    }

    @JvmOverloads
    @NotNull
    public static final class_3965 clipIncludeShips(@NotNull class_1937 $this$clipIncludeShips, @NotNull class_3959 ctx, boolean shouldTransformHitPos, @Nullable Long skipShip) {
        Intrinsics.checkNotNullParameter((Object)$this$clipIncludeShips, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        return RaycastUtilsKt.clipIncludeShips$default($this$clipIncludeShips, ctx, shouldTransformHitPos, skipShip, false, 8, null);
    }

    @JvmOverloads
    @NotNull
    public static final class_3965 clipIncludeShips(@NotNull class_1937 $this$clipIncludeShips, @NotNull class_3959 ctx, boolean shouldTransformHitPos) {
        Intrinsics.checkNotNullParameter((Object)$this$clipIncludeShips, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        return RaycastUtilsKt.clipIncludeShips$default($this$clipIncludeShips, ctx, shouldTransformHitPos, null, false, 12, null);
    }

    @JvmOverloads
    @NotNull
    public static final class_3965 clipIncludeShips(@NotNull class_1937 $this$clipIncludeShips, @NotNull class_3959 ctx) {
        Intrinsics.checkNotNullParameter((Object)$this$clipIncludeShips, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        return RaycastUtilsKt.clipIncludeShips$default($this$clipIncludeShips, ctx, false, null, false, 14, null);
    }

    private static final class_3965 clip$lambda$0(class_1937 $this_clip, class_243 $realStart, class_243 $realEnd, class_3959 raycastContext, class_2338 blockPos) {
        Intrinsics.checkNotNullParameter((Object)$this_clip, (String)"$this_clip");
        Intrinsics.checkNotNullParameter((Object)$realStart, (String)"$realStart");
        Intrinsics.checkNotNullParameter((Object)$realEnd, (String)"$realEnd");
        Intrinsics.checkNotNullParameter((Object)raycastContext, (String)"raycastContext");
        class_2338 class_23382 = blockPos;
        Intrinsics.checkNotNull((Object)class_23382);
        class_2680 class_26802 = $this_clip.method_8320(class_23382);
        Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getBlockState(...)");
        class_2680 blockState = class_26802;
        class_3610 class_36102 = $this_clip.method_8316(blockPos);
        Intrinsics.checkNotNullExpressionValue((Object)class_36102, (String)"getFluidState(...)");
        class_3610 fluidState = class_36102;
        class_243 vec3d = $realStart;
        class_243 vec3d2 = $realEnd;
        class_265 voxelShape = raycastContext.method_17748(blockState, (class_1922)$this_clip, blockPos);
        class_3965 blockHitResult = $this_clip.method_17745(vec3d, vec3d2, blockPos, voxelShape, blockState);
        class_265 voxelShape2 = raycastContext.method_17749(fluidState, (class_1922)$this_clip, blockPos);
        class_3965 blockHitResult2 = voxelShape2.method_1092(vec3d, vec3d2, blockPos);
        class_3965 class_39652 = blockHitResult;
        double d2 = class_39652 == null ? Double.MAX_VALUE : $realStart.method_1025(class_39652.field_1329);
        class_3965 class_39653 = blockHitResult2;
        double e2 = class_39653 == null ? Double.MAX_VALUE : $realEnd.method_1025(class_39653.field_1329);
        return d2 <= e2 ? blockHitResult : blockHitResult2;
    }

    private static final class_3965 clip$lambda$1(class_243 $realStart, class_243 $realEnd, class_3959 raycastContext) {
        Intrinsics.checkNotNullParameter((Object)$realStart, (String)"$realStart");
        Intrinsics.checkNotNullParameter((Object)$realEnd, (String)"$realEnd");
        Intrinsics.checkNotNullParameter((Object)raycastContext, (String)"raycastContext");
        class_243 vec3d = $realStart.method_1020($realEnd);
        return class_3965.method_17778((class_243)$realEnd, (class_2350)class_2350.method_10142((double)vec3d.field_1352, (double)vec3d.field_1351, (double)vec3d.field_1350), (class_2338)class_2338.method_49638((class_2374)((class_2374)$realEnd)));
    }

    private static final void raytraceEntities$checkEntities(Ref.DoubleRef distance2, Ref.ObjectRef<class_1297> resultEntity, Ref.ObjectRef<class_243> location, class_1297 $shooter, List<? extends class_1297> entities, class_243 startVec, class_243 endVec, double scale) {
        Iterable $this$forEach$iv = entities;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            class_1297 entity = (class_1297)element$iv;
            boolean bl = false;
            class_238 class_2384 = entity.method_5829().method_1014((double)entity.method_5871());
            Intrinsics.checkNotNullExpressionValue((Object)class_2384, (String)"inflate(...)");
            class_238 aabb = McMathUtilKt.scale(class_2384, scale);
            Optional clipO = aabb.method_992(startVec, endVec);
            if (aabb.method_1006(startVec)) {
                if (distance2.element < 0.0) continue;
                resultEntity.element = entity;
                location.element = clipO.orElse(startVec);
                distance2.element = 0.0;
                continue;
            }
            if (!clipO.isPresent()) continue;
            Object t = clipO.get();
            Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
            class_243 clip = (class_243)t;
            double d2 = startVec.method_1025(clip) / (scale * scale);
            if (d2 >= distance2.element && !(distance2.element == 0.0)) continue;
            if (entity.method_5668() == $shooter.method_5668()) {
                if (!(distance2.element == 0.0)) continue;
                resultEntity.element = entity;
                location.element = clip;
                continue;
            }
            resultEntity.element = entity;
            location.element = clip;
            distance2.element = d2;
        }
    }

    private static final class_3965 vanillaClip$lambda$4(class_1922 $this_vanillaClip, class_3959 clipContext, class_2338 blockPos) {
        Intrinsics.checkNotNullParameter((Object)$this_vanillaClip, (String)"$this_vanillaClip");
        Intrinsics.checkNotNullParameter((Object)clipContext, (String)"clipContext");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        class_2680 blockState = $this_vanillaClip.method_8320(blockPos);
        class_3610 fluidState = $this_vanillaClip.method_8316(blockPos);
        class_243 vec3 = clipContext.method_17750();
        class_243 vec32 = clipContext.method_17747();
        class_265 voxelShape = clipContext.method_17748(blockState, $this_vanillaClip, blockPos);
        class_3965 blockHitResult = $this_vanillaClip.method_17745(vec3, vec32, blockPos, voxelShape, blockState);
        class_265 voxelShape2 = clipContext.method_17749(fluidState, $this_vanillaClip, blockPos);
        class_3965 blockHitResult2 = voxelShape2.method_1092(vec3, vec32, blockPos);
        double d2 = blockHitResult == null ? Double.MAX_VALUE : clipContext.method_17750().method_1025(blockHitResult.field_1329);
        double e2 = blockHitResult2 == null ? Double.MAX_VALUE : clipContext.method_17750().method_1025(blockHitResult2.field_1329);
        return d2 <= e2 ? blockHitResult : blockHitResult2;
    }

    private static final class_3965 vanillaClip$lambda$5(class_3959 ctx) {
        class_243 vec3 = ctx.method_17750().method_1020(ctx.method_17747());
        return class_3965.method_17778((class_243)ctx.method_17747(), (class_2350)class_2350.method_10142((double)vec3.field_1352, (double)vec3.field_1351, (double)vec3.field_1350), (class_2338)class_2338.method_49638((class_2374)((class_2374)ctx.method_17747())));
    }
}

