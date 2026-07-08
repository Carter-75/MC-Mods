/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  net.minecraft.class_3218
 *  net.minecraft.class_3492
 *  net.minecraft.class_3499
 *  net.minecraft.class_5425
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3d
 *  org.joml.Vector3dc
 *  org.joml.Vector3i
 *  org.joml.Vector3ic
 *  org.valkyrienskies.core.api.ships.ServerShip
 *  org.valkyrienskies.core.api.ships.Ship
 *  org.valkyrienskies.core.impl.game.ShipTeleportDataImpl
 *  org.valkyrienskies.core.internal.ShipTeleportData
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.util.VectorConversionsMCKt
 */
package g_mungus.vlib.v2.api.extension;

import g_mungus.vlib.VLib;
import g_mungus.vlib.data.DimensionSettings;
import g_mungus.vlib.dimension.DimensionSettingsManager;
import g_mungus.vlib.v2.api.experimental.HasSpecialSaveBehavior;
import g_mungus.vlib.v2.api.extension.ShipExtKt;
import g_mungus.vlib.v2.internal.assembly.BoundedVoxelSet;
import g_mungus.vlib.v2.internal.injected.CanFillFromVoxelSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import net.minecraft.class_3218;
import net.minecraft.class_3492;
import net.minecraft.class_3499;
import net.minecraft.class_5425;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.Vector3i;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.impl.game.ShipTeleportDataImpl;
import org.valkyrienskies.core.internal.ShipTeleportData;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a-\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\t\u001a!\u0010\r\u001a\u00020\f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Lnet/minecraft/class_3499;", "Lnet/minecraft/class_3218;", "level", "Lnet/minecraft/class_2338;", "blockPos", "", "static", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "placeAsShip", "(Lnet/minecraft/class_3499;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Z)Lorg/valkyrienskies/core/api/ships/ServerShip;", "Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;", "voxelSet", "", "fillFromVoxelSet", "(Lnet/minecraft/class_3499;Lnet/minecraft/class_3218;Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;)V", "vlib"})
public final class StructureTemplateExtKt {
    @Nullable
    public static final ServerShip placeAsShip(@NotNull class_3499 $this$placeAsShip, @NotNull class_3218 level, @NotNull class_2338 blockPos, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)$this$placeAsShip, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        class_2338 pos = blockPos;
        class_2338 originalPos = blockPos;
        if (level.method_31606(pos)) {
            pos = new class_2338(pos.method_10263(), 0, pos.method_10260());
        }
        DimensionSettings dimensionSettings = DimensionSettingsManager.INSTANCE.getSettingsForLevel(VSGameUtilsKt.getDimensionId((class_1937)((class_1937)level)));
        ServerShip ship = VSGameUtilsKt.getShipObjectWorld((class_3218)level).createNewShipAtBlock((Vector3ic)VectorConversionsMCKt.toJOML((class_2382)((class_2382)pos)), false, dimensionSettings.getShipScale(), VSGameUtilsKt.getDimensionId((class_1937)((class_1937)level)));
        ship.setStatic(true);
        class_2338 centreOfShip = VectorConversionsMCKt.toBlockPos((Vector3ic)((Vector3ic)ship.getChunkClaim().getCenterBlockCoordinates(VSGameUtilsKt.getYRange((class_1937)((class_1937)level)), new Vector3i()))).method_33096(pos.method_10264());
        class_3492 structurePlaceSettings = new class_3492();
        structurePlaceSettings.method_15119(centreOfShip);
        $this$placeAsShip.method_15172((class_5425)level, centreOfShip, centreOfShip, structurePlaceSettings, level.field_9229, 2);
        if (ship.getInertiaData().getMass() < 0.001) {
            VSGameUtilsKt.getShipObjectWorld((class_3218)level).deleteShip(ship);
            VLib.INSTANCE.getLOGGER().warn("Deleting ship with id: " + ship.getId() + " because it has mass < 0.001");
            return null;
        }
        if (!Intrinsics.areEqual((Object)pos, (Object)originalPos)) {
            VSGameUtilsKt.getShipObjectWorld((class_3218)level).teleportShip(ship, (ShipTeleportData)new ShipTeleportDataImpl((Vector3dc)new Vector3d((double)originalPos.method_10263(), (double)originalPos.method_10264(), (double)originalPos.method_10260()), null, null, null, null, null, null, 126, null));
        }
        Vector3d vector3d = ship.getTransform().getPositionInWorld().add(ship.getInertiaData().getCenterOfMassInShip(), new Vector3d()).sub((double)centreOfShip.method_10263(), (double)centreOfShip.method_10264(), (double)centreOfShip.method_10260());
        Intrinsics.checkNotNullExpressionValue((Object)vector3d, (String)"sub(...)");
        Vector3d newPos = vector3d;
        VSGameUtilsKt.getShipObjectWorld((class_3218)level).teleportShip(ship, (ShipTeleportData)new ShipTeleportDataImpl((Vector3dc)newPos, null, null, null, null, null, null, 126, null));
        ShipExtKt.forEachBlock((Ship)ship, (Function1<? super class_2338, Unit>)((Function1)arg_0 -> StructureTemplateExtKt.placeAsShip$lambda$1(level, arg_0)));
        ship.setStatic(bl);
        return ship;
    }

    public static /* synthetic */ ServerShip placeAsShip$default(class_3499 class_34992, class_3218 class_32182, class_2338 class_23382, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = false;
        }
        return StructureTemplateExtKt.placeAsShip(class_34992, class_32182, class_23382, bl);
    }

    public static final void fillFromVoxelSet(@NotNull class_3499 $this$fillFromVoxelSet, @NotNull class_3218 level, @NotNull BoundedVoxelSet voxelSet) {
        Intrinsics.checkNotNullParameter((Object)$this$fillFromVoxelSet, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)voxelSet, (String)"voxelSet");
        ((CanFillFromVoxelSet)$this$fillFromVoxelSet).vlib$fillFromVoxelSet((class_1937)level, voxelSet);
    }

    private static final Unit placeAsShip$lambda$1(class_3218 $level, class_2338 blockPos) {
        block1: {
            Intrinsics.checkNotNullParameter((Object)$level, (String)"$level");
            Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
            class_2586 class_25862 = $level.method_8321(blockPos);
            if (class_25862 == null) break block1;
            class_2586 it = class_25862;
            boolean bl = false;
            if (it instanceof HasSpecialSaveBehavior) {
                ((HasSpecialSaveBehavior)it).executeAfterLoadingShip();
            }
        }
        return Unit.INSTANCE;
    }
}

