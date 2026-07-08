/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2960
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4dc
 *  org.joml.Quaterniondc
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.joml.primitives.AABBd
 *  org.joml.primitives.AABBdc
 *  org.valkyrienskies.core.api.ships.LoadedShip
 *  org.valkyrienskies.core.api.ships.properties.ShipTransform
 *  org.valkyrienskies.core.impl.shadow.Dk
 *  org.valkyrienskies.core.internal.collision.VsiConvexPolygonc
 *  org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider
 *  org.valkyrienskies.core.util.AABBdUtilKt
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider
 *  org.valkyrienskies.mod.common.util.VectorConversionsMCKt
 *  org.valkyrienskies.mod.util.BugFixUtil
 */
package g_mungus.vlib.util;

import g_mungus.vlib.data.DimensionSettings;
import g_mungus.vlib.dimension.DimensionSettingsManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2960;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4dc;
import org.joml.Quaterniondc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.impl.shadow.Dk;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;
import org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider;
import org.valkyrienskies.core.util.AABBdUtilKt;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.util.BugFixUtil;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a7\u0010\n\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000b\u001a=\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2={"Lnet/minecraft/class_1297;", "entity", "Lnet/minecraft/class_243;", "movement", "Lnet/minecraft/class_238;", "entityBoundingBox", "Lnet/minecraft/class_1937;", "world", "Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "collider", "adjustEntityMovementForShipCollisions", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;Lnet/minecraft/class_238;Lnet/minecraft/class_1937;Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;)Lnet/minecraft/class_243;", "", "Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "getShipPolygonsCollidingWithEntity", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;Lnet/minecraft/class_238;Lnet/minecraft/class_1937;Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;)Ljava/util/List;", "Lorg/joml/primitives/AABBdc;", "aabb", "Lorg/joml/Quaterniondc;", "shipToWorldRotation", "shrinkAABBXZ", "(Lorg/joml/primitives/AABBdc;Lorg/joml/Quaterniondc;)Lorg/joml/primitives/AABBdc;", "vlib"})
@SourceDebugExtension(value={"SMAP\nEntityCollisionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityCollisionUtils.kt\ng_mungus/vlib/util/EntityCollisionUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,161:1\n1#2:162\n1863#3,2:163\n*S KotlinDebug\n*F\n+ 1 EntityCollisionUtils.kt\ng_mungus/vlib/util/EntityCollisionUtilsKt\n*L\n131#1:163,2\n*E\n"})
public final class EntityCollisionUtilsKt {
    @NotNull
    public static final class_243 adjustEntityMovementForShipCollisions(@Nullable class_1297 entity, @NotNull class_243 movement, @NotNull class_238 entityBoundingBox, @NotNull class_1937 world, @NotNull VsiEntityPolygonCollider collider) {
        Long collidingWith;
        Intrinsics.checkNotNullParameter((Object)movement, (String)"movement");
        Intrinsics.checkNotNullParameter((Object)entityBoundingBox, (String)"entityBoundingBox");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)collider, (String)"collider");
        double inflation = entity instanceof class_1657 ? 0.5 : 0.1;
        class_1297 class_12972 = entity;
        double stepHeight = class_12972 != null ? (double)class_12972.method_49476() : 0.0;
        class_243 class_2432 = new class_243(movement.method_10216(), movement.method_10214() + Math.max(stepHeight - inflation, 0.0), movement.method_10215());
        class_238 class_2383 = entityBoundingBox.method_1014(inflation);
        Intrinsics.checkNotNullExpressionValue((Object)class_2383, (String)"inflate(...)");
        List<VsiConvexPolygonc> collidingShipPolygons = EntityCollisionUtilsKt.getShipPolygonsCollidingWithEntity(entity, class_2432, class_2383, world, collider);
        if (collidingShipPolygons.isEmpty()) {
            return movement;
        }
        if (entity != null && (collidingWith = ((IEntityDraggingInformationProvider)entity).getDraggingInformation().getLastShipStoodOn()) != null && entity instanceof class_1657) {
            Quaterniondc shipToWorldRotation;
            LoadedShip loadedShip = (LoadedShip)VSGameUtilsKt.getShipObjectWorld((class_1937)world).getLoadedShips().getById(collidingWith.longValue());
            Quaterniondc quaterniondc = loadedShip != null && (loadedShip = loadedShip.getTransform()) != null ? loadedShip.getShipToWorldRotation() : (shipToWorldRotation = null);
            if (shipToWorldRotation != null) {
                Pair pair = collider.adjustEntityMovementForPolygonCollisions((Vector3dc)VectorConversionsMCKt.toJOML((class_243)movement), EntityCollisionUtilsKt.shrinkAABBXZ((AABBdc)VectorConversionsMCKt.toJOML((class_238)entityBoundingBox), shipToWorldRotation), stepHeight, collidingShipPolygons);
                Vector3dc newMovement = (Vector3dc)pair.component1();
                Long shipCollidingWith = (Long)pair.component2();
                if (shipCollidingWith != null) {
                    ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(shipCollidingWith);
                }
                return VectorConversionsMCKt.toMinecraft((Vector3dc)newMovement);
            }
        }
        Pair pair = collider.adjustEntityMovementForPolygonCollisions((Vector3dc)VectorConversionsMCKt.toJOML((class_243)movement), (AABBdc)VectorConversionsMCKt.toJOML((class_238)entityBoundingBox), stepHeight, collidingShipPolygons);
        Vector3dc newMovement = (Vector3dc)pair.component1();
        Long shipCollidingWith = (Long)pair.component2();
        if (entity != null && shipCollidingWith != null) {
            ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(shipCollidingWith);
        }
        return VectorConversionsMCKt.toMinecraft((Vector3dc)newMovement);
    }

    @NotNull
    public static final List<VsiConvexPolygonc> getShipPolygonsCollidingWithEntity(@Nullable class_1297 entity, @NotNull class_243 movement, @NotNull class_238 entityBoundingBox, @NotNull class_1937 world, @NotNull VsiEntityPolygonCollider collider) {
        Intrinsics.checkNotNullParameter((Object)movement, (String)"movement");
        Intrinsics.checkNotNullParameter((Object)entityBoundingBox, (String)"entityBoundingBox");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)collider, (String)"collider");
        class_238 entityBoxWithMovement = entityBoundingBox.method_18804(movement);
        List collidingPolygons = new ArrayList();
        AABBd entityBoundingBoxExtended = AABBdUtilKt.extend((AABBd)VectorConversionsMCKt.toJOML((class_238)entityBoundingBox), (Vector3dc)((Vector3dc)VectorConversionsMCKt.toJOML((class_243)movement)));
        class_2960 class_29602 = world.method_27983().method_29177();
        Intrinsics.checkNotNullExpressionValue((Object)class_29602, (String)"location(...)");
        DimensionSettings dimSettings = DimensionSettingsManager.INSTANCE.getSettingsForLevel(class_29602);
        boolean shouldApplyFunkyFix = dimSettings.getShipScale() == 0.0625 && dimSettings.getGravity() == 0.0;
        for (LoadedShip shipObject : VSGameUtilsKt.getShipObjectWorld((class_1937)world).getLoadedShips().getIntersecting((AABBdc)entityBoundingBoxExtended)) {
            Vector3d vector3d;
            ShipTransform shipTransform = shipObject.getTransform();
            Intrinsics.checkNotNull((Object)entityBoxWithMovement);
            VsiConvexPolygonc entityPolyInShipCoordinates = VsiEntityPolygonCollider.createPolygonFromAABB$default((VsiEntityPolygonCollider)collider, (AABBdc)((AABBdc)VectorConversionsMCKt.toJOML((class_238)entityBoxWithMovement)), (Matrix4dc)shipTransform.getWorldToShip(), null, (int)4, null);
            AABBd entityBoundingBoxInShipCoordinates = null;
            entityBoundingBoxInShipCoordinates = entityPolyInShipCoordinates.getEnclosingAABB(new AABBd());
            if (shouldApplyFunkyFix) {
                AABBd worldAABB = VectorConversionsMCKt.toJOML((class_238)entityBoxWithMovement);
                Vector3d originalHalfExtents = new Vector3d((worldAABB.maxX - worldAABB.minX) / 2.0, (worldAABB.maxY - worldAABB.minY) / 2.0, (worldAABB.maxZ - worldAABB.minZ) / 2.0);
                originalHalfExtents.mul(2.0);
                Vector3d $this$getShipPolygonsCollidingWithEntity_u24lambda_u240 = vector3d = new Vector3d();
                boolean bl = false;
                ((AABBdc)entityBoundingBoxInShipCoordinates).center($this$getShipPolygonsCollidingWithEntity_u24lambda_u240);
                Vector3d center = vector3d;
                entityBoundingBoxInShipCoordinates = new AABBd(center.x - originalHalfExtents.x, center.y - originalHalfExtents.y, center.z - originalHalfExtents.z, center.x + originalHalfExtents.x, center.y + originalHalfExtents.y, center.z + originalHalfExtents.z);
            }
            if (entity instanceof class_1657) {
                entityBoundingBoxInShipCoordinates = EntityCollisionUtilsKt.shrinkAABBXZ((AABBdc)entityBoundingBoxInShipCoordinates, shipTransform.getShipToWorldRotation());
            }
            if (BugFixUtil.INSTANCE.isCollisionBoxTooBig(VectorConversionsMCKt.toMinecraft((AABBdc)((AABBdc)entityBoundingBoxInShipCoordinates)))) continue;
            Iterable shipBlockCollisionStream = world.method_20812(entity, VectorConversionsMCKt.toMinecraft((AABBdc)((AABBdc)entityBoundingBoxInShipCoordinates)));
            Intrinsics.checkNotNull((Object)shipBlockCollisionStream);
            Iterable $this$forEach$iv = shipBlockCollisionStream;
            boolean $i$f$forEach = false;
            vector3d = $this$forEach$iv.iterator();
            while (vector3d.hasNext()) {
                Object element$iv = vector3d.next();
                class_265 voxelShape = (class_265)element$iv;
                boolean bl = false;
                voxelShape.method_1089((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> EntityCollisionUtilsKt.getShipPolygonsCollidingWithEntity$lambda$2$lambda$1(shipTransform, shipObject, collidingPolygons, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
            }
        }
        return collidingPolygons;
    }

    private static final AABBdc shrinkAABBXZ(AABBdc aabb, Quaterniondc shipToWorldRotation) {
        Vector3d vector3d;
        Vector3d $this$shrinkAABBXZ_u24lambda_u243 = vector3d = new Vector3d();
        boolean bl = false;
        aabb.center($this$shrinkAABBXZ_u24lambda_u243);
        Vector3d center = vector3d;
        Vector3d $this$shrinkAABBXZ_u24lambda_u244 = $this$shrinkAABBXZ_u24lambda_u243 = new Vector3d();
        boolean bl2 = false;
        aabb.extent($this$shrinkAABBXZ_u24lambda_u244);
        Vector3d halfExtents = $this$shrinkAABBXZ_u24lambda_u243;
        double yaw = shipToWorldRotation.getEulerAnglesXYZ((Vector3d)new Vector3d()).y;
        double scale = 1.0 / (Math.abs(Math.cos(yaw)) + Math.abs(Math.sin(yaw)));
        halfExtents.x *= scale;
        halfExtents.z *= scale;
        Vector3d newMin = new Vector3d(center.x - halfExtents.x, aabb.minY(), center.z - halfExtents.z);
        Vector3d newMax = new Vector3d(center.x + halfExtents.x, aabb.maxY(), center.z + halfExtents.z);
        return (AABBdc)new AABBd((Vector3dc)newMin, (Vector3dc)newMax);
    }

    private static final void getShipPolygonsCollidingWithEntity$lambda$2$lambda$1(ShipTransform $shipTransform, LoadedShip $shipObject, List $collidingPolygons, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        Intrinsics.checkNotNullParameter((Object)$shipTransform, (String)"$shipTransform");
        Intrinsics.checkNotNullParameter((Object)$shipObject, (String)"$shipObject");
        Intrinsics.checkNotNullParameter((Object)$collidingPolygons, (String)"$collidingPolygons");
        VsiConvexPolygonc shipPolygon = Dk.INSTANCE.createPolygonFromAABB((AABBdc)new AABBd(minX, minY, minZ, maxX, maxY, maxZ), $shipTransform.getShipToWorld(), Long.valueOf($shipObject.getId()));
        $collidingPolygons.add(shipPolygon);
    }
}

