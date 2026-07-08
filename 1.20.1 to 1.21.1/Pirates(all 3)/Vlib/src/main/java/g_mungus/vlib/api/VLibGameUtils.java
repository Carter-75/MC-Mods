/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.text.StringsKt
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3485
 *  net.minecraft.class_3499
 *  org.jetbrains.annotations.NotNull
 *  org.joml.primitives.AABBic
 *  org.valkyrienskies.core.api.ships.ServerShip
 *  org.valkyrienskies.core.api.ships.Ship
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package g_mungus.vlib.api;

import g_mungus.vlib.VLib;
import g_mungus.vlib.v2.api.VLibAPI;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3485;
import net.minecraft.class_3499;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u00a2\u0006\u0004\b\b\u0010\tJ3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0007\u00a2\u0006\u0004\b\b\u0010\rJ7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0018JC\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001aH\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002\u00a2\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u00020%2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0002\u00a2\u0006\u0004\b&\u0010'\u00a8\u0006*"}, d2={"Lg_mungus/vlib/api/VLibGameUtils;", "", "Lnet/minecraft/class_3218;", "level", "Lnet/minecraft/class_2338;", "blockPos", "Ljava/util/concurrent/CompletionStage;", "Lorg/valkyrienskies/core/api/ships/Ship;", "assembleByConnectivity", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;)Ljava/util/concurrent/CompletionStage;", "", "Lnet/minecraft/class_2248;", "blackList", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Ljava/util/List;)Ljava/util/concurrent/CompletionStage;", "", "structurePath", "", "withEntities", "deleteAfter", "", "saveShipToTemplate", "(Ljava/lang/String;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;ZZ)V", "", "shipId", "(Ljava/lang/String;Lnet/minecraft/class_3218;JZZ)V", "ship", "Lnet/minecraft/class_3485;", "structureTemplateManager", "Lkotlin/Pair;", "Lnet/minecraft/class_3499;", "Lnet/minecraft/class_2960;", "getStructureTemplate", "(Ljava/lang/String;Lnet/minecraft/class_3218;Lorg/valkyrienskies/core/api/ships/Ship;ZLnet/minecraft/class_3485;)Lkotlin/Pair;", "Lorg/joml/primitives/AABBic;", "aabb", "getMin", "(Lorg/joml/primitives/AABBic;)Lnet/minecraft/class_2338;", "Lnet/minecraft/class_2382;", "getSize", "(Lorg/joml/primitives/AABBic;)Lnet/minecraft/class_2382;", "<init>", "()V", "vlib"})
public final class VLibGameUtils {
    @NotNull
    public static final VLibGameUtils INSTANCE = new VLibGameUtils();

    private VLibGameUtils() {
    }

    @Deprecated(message="Moved to VLibAPI class")
    @NotNull
    public final CompletionStage<Ship> assembleByConnectivity(@NotNull class_3218 level, @NotNull class_2338 blockPos) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        return this.assembleByConnectivity(level, blockPos, CollectionsKt.emptyList());
    }

    @Deprecated(message="Moved to VLibAPI class")
    @NotNull
    public final CompletionStage<Ship> assembleByConnectivity(@NotNull class_3218 level, @NotNull class_2338 blockPos, @NotNull List<? extends class_2248> blackList) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter(blackList, (String)"blackList");
        if (VSGameUtilsKt.isBlockInShipyard((class_1937)((class_1937)level), (class_2338)blockPos)) {
            CompletableFuture completableFuture = CompletableFuture.failedFuture(new IllegalArgumentException("Ship is already assembled"));
            Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"failedFuture(...)");
            return completableFuture;
        }
        ServerShip serverShip = VLibAPI.assembleByConnectivity(level, blockPos, blackList);
        if (serverShip != null) {
            ServerShip it = serverShip;
            boolean bl = false;
            CompletableFuture<ServerShip> completableFuture = CompletableFuture.completedFuture(it);
            Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"completedFuture(...)");
            return completableFuture;
        }
        CompletableFuture completableFuture = CompletableFuture.failedFuture(new Exception("Assembly failed"));
        Intrinsics.checkNotNullExpressionValue(completableFuture, (String)"failedFuture(...)");
        return completableFuture;
    }

    @Deprecated(message="Moved to VLibAPI class")
    public final void saveShipToTemplate(@NotNull String structurePath, @NotNull class_3218 level, @NotNull class_2338 blockPos, boolean withEntities, boolean deleteAfter) {
        Long shipID;
        Intrinsics.checkNotNullParameter((Object)structurePath, (String)"structurePath");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        ServerShip serverShip = VSGameUtilsKt.getShipManagingPos((class_3218)level, (class_2338)blockPos);
        Long l = shipID = serverShip != null ? Long.valueOf(serverShip.getId()) : null;
        if (shipID != null) {
            this.saveShipToTemplate(structurePath, level, shipID, withEntities, deleteAfter);
        } else {
            VLib.INSTANCE.getLOGGER().error("Could not find ship for blockPos: " + blockPos + " in world: " + VSGameUtilsKt.getDimensionId((class_1937)((class_1937)level)));
        }
    }

    @Deprecated(message="Moved to VLibAPI class")
    public final void saveShipToTemplate(@NotNull String structurePath, @NotNull class_3218 level, long shipId, boolean withEntities, boolean deleteAfter) {
        Intrinsics.checkNotNullParameter((Object)structurePath, (String)"structurePath");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Ship ship = VSGameUtilsKt.getAllShips((class_1937)((class_1937)level)).getById(shipId);
        if (ship == null) {
            VLibGameUtils it = this;
            boolean bl = false;
            VLib.INSTANCE.getLOGGER().error("Could not find ship id: " + shipId + " in world: " + VSGameUtilsKt.getDimensionId((class_1937)((class_1937)level)));
            return;
        }
        Ship ship2 = ship;
        class_3485 structureTemplateManager = level.method_14183();
        Intrinsics.checkNotNull((Object)structureTemplateManager);
        structureTemplateManager.method_15093((class_2960)this.getStructureTemplate(structurePath, level, ship2, withEntities, structureTemplateManager).getSecond());
        if (deleteAfter) {
            VSGameUtilsKt.getShipObjectWorld((class_3218)level).deleteShip((ServerShip)ship2);
        }
    }

    @Deprecated(message="Moved to VLibAPI class")
    @NotNull
    public final Pair<class_3499, class_2960> getStructureTemplate(@NotNull String structurePath, @NotNull class_3218 level, @NotNull Ship ship, boolean withEntities, @NotNull class_3485 structureTemplateManager) {
        class_2960 class_29602;
        String shipName;
        Intrinsics.checkNotNullParameter((Object)structurePath, (String)"structurePath");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)structureTemplateManager, (String)"structureTemplateManager");
        Object object = ship.getSlug();
        if (object == null) {
            object = shipName = "ship_" + Random.Default.nextInt();
        }
        if (StringsKt.contains$default((CharSequence)structurePath, (char)':', (boolean)false, (int)2, null)) {
            class_29602 = new class_2960(structurePath + shipName);
        } else {
            if (StringsKt.contains$default((CharSequence)structurePath, (char)'/', (boolean)false, (int)2, null)) {
                throw new IllegalArgumentException("Invalid structure path: the required format is either:\nnamespace\n- or -\nnamespace:folder/");
            }
            class_29602 = new class_2960(structurePath, shipName);
        }
        class_2960 resourceLocation = class_29602;
        class_3499 structureTemplate = structureTemplateManager.method_15091(resourceLocation);
        structureTemplate.method_15174((class_1937)level, this.getMin(ship.getShipAABB()), this.getSize(ship.getShipAABB()), withEntities, class_2246.field_10124);
        return new Pair((Object)structureTemplate, (Object)resourceLocation);
    }

    private final class_2338 getMin(AABBic aabb) {
        if (aabb != null) {
            return new class_2338(aabb.minX() - 1, aabb.minY() - 1, aabb.minZ() - 1);
        }
        throw new Exception("Why doesn't the ship have a shipyard AABB?");
    }

    private final class_2382 getSize(AABBic aabb) {
        if (aabb != null) {
            return new class_2382(aabb.maxX() - aabb.minX() + 2, aabb.maxY() - aabb.minY() + 2, aabb.maxZ() - aabb.minZ() + 2);
        }
        throw new Exception("Why doesn't the ship have a shipyard AABB?");
    }
}

