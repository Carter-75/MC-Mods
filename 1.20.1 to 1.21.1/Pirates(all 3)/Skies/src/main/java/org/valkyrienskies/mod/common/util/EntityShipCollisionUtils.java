/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_3218
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 */
package org.valkyrienskies.mod.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_3218;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.internal.collision.VsiConvexPolygonc;
import org.valkyrienskies.core.internal.collision.VsiEntityPolygonCollider;
import org.valkyrienskies.core.util.AABBdUtilKt;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.util.BugFixUtil;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J'\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2={"Lorg/valkyrienskies/mod/common/util/EntityShipCollisionUtils;", "", "Lnet/minecraft/class_1297;", "entity", "", "isCollidingWithUnloadedShips", "(Lnet/minecraft/class_1297;)Z", "Lorg/valkyrienskies/core/api/ships/Ship;", "ship", "Lorg/joml/primitives/AABBdc;", "aABB", "Lnet/minecraft/class_1937;", "level", "areAllChunksLoaded", "(Lorg/valkyrienskies/core/api/ships/Ship;Lorg/joml/primitives/AABBdc;Lnet/minecraft/class_1937;)Z", "Lnet/minecraft/class_243;", "movement", "Lnet/minecraft/class_238;", "entityBoundingBox", "world", "adjustEntityMovementForShipCollisions", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;Lnet/minecraft/class_238;Lnet/minecraft/class_1937;)Lnet/minecraft/class_243;", "", "Lorg/valkyrienskies/core/internal/collision/VsiConvexPolygonc;", "getShipPolygonsCollidingWithEntity", "(Lnet/minecraft/class_1297;Lnet/minecraft/class_243;Lnet/minecraft/class_238;Lnet/minecraft/class_1937;)Ljava/util/List;", "Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "collider", "Lorg/valkyrienskies/core/internal/collision/VsiEntityPolygonCollider;", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nEntityShipCollisionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EntityShipCollisionUtils.kt\norg/valkyrienskies/mod/common/util/EntityShipCollisionUtils\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,146:1\n1734#2,3:147\n1863#2,2:150\n*S KotlinDebug\n*F\n+ 1 EntityShipCollisionUtils.kt\norg/valkyrienskies/mod/common/util/EntityShipCollisionUtils\n*L\n39#1:147,3\n132#1:150,2\n*E\n"})
public final class EntityShipCollisionUtils {
    @NotNull
    public static final EntityShipCollisionUtils INSTANCE = new EntityShipCollisionUtils();
    @NotNull
    private static final VsiEntityPolygonCollider collider = VSGameUtilsKt.getVsCore().getEntityPolygonCollider();

    private EntityShipCollisionUtils() {
    }

    @JvmStatic
    public static final boolean isCollidingWithUnloadedShips(@NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        class_1937 level = entity.method_37908();
        if (level instanceof class_3218 || level.field_9236 && level instanceof class_638) {
            boolean bl;
            block5: {
                if (level.field_9236 && level instanceof class_638 && !VSGameUtilsKt.getShipObjectWorld((class_638)level).isSyncedWithServer()) {
                    return true;
                }
                class_238 class_2384 = entity.method_5829();
                Intrinsics.checkNotNullExpressionValue((Object)class_2384, (String)"getBoundingBox(...)");
                AABBd aabb = VectorConversionsMCKt.toJOML(class_2384);
                Iterable<Ship> $this$all$iv = VSGameUtilsKt.getShipsIntersecting(level, aabb);
                boolean $i$f$all = false;
                if ($this$all$iv instanceof Collection && ((Collection)$this$all$iv).isEmpty()) {
                    bl = true;
                } else {
                    Iterator<Ship> iterator2 = $this$all$iv.iterator();
                    while (iterator2.hasNext()) {
                        Ship element$iv;
                        Ship ship = element$iv = iterator2.next();
                        boolean bl2 = false;
                        AABBd aabbInShip = new AABBd(aabb).transform(ship.getWorldToShip());
                        Intrinsics.checkNotNull((Object)aabbInShip);
                        if (INSTANCE.areAllChunksLoaded(ship, aabbInShip, level)) continue;
                        bl = false;
                        break block5;
                    }
                    bl = true;
                }
            }
            return !bl;
        }
        return false;
    }

    private final boolean areAllChunksLoaded(Ship ship, AABBdc aABB, class_1937 level) {
        int minX = class_3532.method_15357((double)(aABB.minX() - 1.0E-7)) - 1 >> 4;
        int maxX = class_3532.method_15357((double)(aABB.maxX() + 1.0E-7)) + 1 >> 4;
        int minZ = class_3532.method_15357((double)(aABB.minZ() - 1.0E-7)) - 1 >> 4;
        int maxZ = class_3532.method_15357((double)(aABB.maxZ() + 1.0E-7)) + 1 >> 4;
        int chunkX = minX;
        if (chunkX <= maxX) {
            while (true) {
                int chunkZ;
                if ((chunkZ = minZ) <= maxZ) {
                    while (true) {
                        if (ship.getActiveChunksSet().contains(chunkX, chunkZ) && level.method_22338(chunkX, chunkZ) == null) {
                            return false;
                        }
                        if (chunkZ == maxZ) break;
                        ++chunkZ;
                    }
                }
                if (chunkX == maxX) break;
                ++chunkX;
            }
        }
        return true;
    }

    @NotNull
    public final class_243 adjustEntityMovementForShipCollisions(@Nullable class_1297 entity, @NotNull class_243 movement, @NotNull class_238 entityBoundingBox, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter((Object)movement, (String)"movement");
        Intrinsics.checkNotNullParameter((Object)entityBoundingBox, (String)"entityBoundingBox");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        double inflation = entity instanceof class_1657 ? 0.5 : 0.1;
        class_1297 class_12972 = entity;
        double stepHeight = class_12972 != null ? (double)class_12972.method_49476() : 0.0;
        class_243 class_2432 = new class_243(movement.method_10216(), movement.method_10214() + stepHeight / (double)2, movement.method_10215());
        class_238 class_2384 = entityBoundingBox.method_1009(inflation, inflation + stepHeight / (double)2, inflation);
        Intrinsics.checkNotNullExpressionValue((Object)class_2384, (String)"inflate(...)");
        List<VsiConvexPolygonc> collidingShipPolygons = this.getShipPolygonsCollidingWithEntity(entity, class_2432, class_2384, world);
        if (collidingShipPolygons.isEmpty()) {
            return movement;
        }
        Pair<Vector3dc, Long> pair = collider.adjustEntityMovementForPolygonCollisions(VectorConversionsMCKt.toJOML(movement), VectorConversionsMCKt.toJOML(entityBoundingBox), stepHeight, collidingShipPolygons);
        Vector3dc newMovement = (Vector3dc)pair.component1();
        Long shipCollidingWith = (Long)pair.component2();
        if (entity != null) {
            class_1937 class_19372 = entity.method_37908();
            class_2338 class_23382 = entity.method_23312();
            Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getOnPos(...)");
            LoadedShip standingOnShip = VSGameUtilsKt.getLoadedShipManagingPos(class_19372, (class_2382)class_23382);
            if (shipCollidingWith != null && standingOnShip != null && standingOnShip.getId() == shipCollidingWith.longValue()) {
                ((IEntityDraggingInformationProvider)entity).getDraggingInformation().setLastShipStoodOn(shipCollidingWith);
                for (class_1297 entityRiding : entity.method_5736()) {
                    Intrinsics.checkNotNull((Object)entityRiding, (String)"null cannot be cast to non-null type org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider");
                    ((IEntityDraggingInformationProvider)entityRiding).getDraggingInformation().setLastShipStoodOn(shipCollidingWith);
                }
            }
        }
        return VectorConversionsMCKt.toMinecraft(newMovement);
    }

    @NotNull
    public final List<VsiConvexPolygonc> getShipPolygonsCollidingWithEntity(@Nullable class_1297 entity, @NotNull class_243 movement, @NotNull class_238 entityBoundingBox, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter((Object)movement, (String)"movement");
        Intrinsics.checkNotNullParameter((Object)entityBoundingBox, (String)"entityBoundingBox");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        class_238 entityBoxWithMovement = entityBoundingBox.method_18804(movement);
        List collidingPolygons = new ArrayList();
        AABBd entityBoundingBoxExtended = AABBdUtilKt.extend(VectorConversionsMCKt.toJOML(entityBoundingBox), VectorConversionsMCKt.toJOML(movement));
        for (LoadedShip shipObject : VSGameUtilsKt.getShipObjectWorld(world).getLoadedShips().getIntersecting(entityBoundingBoxExtended, VSGameUtilsKt.getDimensionId(world))) {
            ShipTransform shipTransform = shipObject.getTransform();
            Intrinsics.checkNotNull((Object)entityBoxWithMovement);
            VsiConvexPolygonc entityPolyInShipCoordinates = VsiEntityPolygonCollider.createPolygonFromAABB$default(collider, VectorConversionsMCKt.toJOML(entityBoxWithMovement), shipTransform.getWorldToShip(), null, 4, null);
            AABBdc entityBoundingBoxInShipCoordinates = entityPolyInShipCoordinates.getEnclosingAABB(new AABBd());
            if (BugFixUtil.INSTANCE.isCollisionBoxTooBig(VectorConversionsMCKt.toMinecraft(entityBoundingBoxInShipCoordinates))) continue;
            Iterable shipBlockCollisionStream = world.method_20812(entity, VectorConversionsMCKt.toMinecraft(entityBoundingBoxInShipCoordinates));
            Intrinsics.checkNotNull((Object)shipBlockCollisionStream);
            Iterable $this$forEach$iv = shipBlockCollisionStream;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                class_265 voxelShape = (class_265)element$iv;
                boolean bl = false;
                voxelShape.method_1089((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> EntityShipCollisionUtils.getShipPolygonsCollidingWithEntity$lambda$2$lambda$1(shipTransform, shipObject, collidingPolygons, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
            }
        }
        return collidingPolygons;
    }

    private static final void getShipPolygonsCollidingWithEntity$lambda$2$lambda$1(ShipTransform $shipTransform, LoadedShip $shipObject, List $collidingPolygons, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        Intrinsics.checkNotNullParameter((Object)$shipTransform, (String)"$shipTransform");
        Intrinsics.checkNotNullParameter((Object)$shipObject, (String)"$shipObject");
        Intrinsics.checkNotNullParameter((Object)$collidingPolygons, (String)"$collidingPolygons");
        VsiConvexPolygonc shipPolygon = VSGameUtilsKt.getVsCore().getEntityPolygonCollider().createPolygonFromAABB(new AABBd(minX, minY, minZ, maxX, maxY, maxZ), $shipTransform.getShipToWorld(), $shipObject.getId());
        $collidingPolygons.add(shipPolygon);
    }
}

