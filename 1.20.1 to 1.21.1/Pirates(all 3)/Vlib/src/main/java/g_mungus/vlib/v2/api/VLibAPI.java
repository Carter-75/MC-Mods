/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3499
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Vector3dc
 *  org.joml.Vector3ic
 *  org.valkyrienskies.core.api.ships.ServerShip
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 *  org.valkyrienskies.mod.common.util.VectorConversionsMCKt
 */
package g_mungus.vlib.v2.api;

import g_mungus.vlib.VLib;
import g_mungus.vlib.v2.api.extension.ServerLevelExtKt;
import g_mungus.vlib.v2.api.extension.ShipExtKt;
import g_mungus.vlib.v2.api.extension.StructureTemplateExtKt;
import g_mungus.vlib.v2.api.model.NamedStructureTemplate;
import g_mungus.vlib.v2.internal.assembly.BoundedVoxelSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3499;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.joml.Vector3ic;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0004\b\t\u0010\nJ1\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J1\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\r2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ-\u0010$\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\"H\u0002\u00a2\u0006\u0004\b$\u0010%\u00a8\u0006("}, d2={"Lg_mungus/vlib/v2/api/VLibAPI;", "", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "ship", "Lnet/minecraft/class_2960;", "resourceLocation", "Lnet/minecraft/class_3218;", "level", "Lg_mungus/vlib/v2/api/model/NamedStructureTemplate;", "saveShipToTemplate", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_2960;Lnet/minecraft/class_3218;)Lg_mungus/vlib/v2/api/model/NamedStructureTemplate;", "Lnet/minecraft/class_3499;", "template", "Lnet/minecraft/class_2338;", "pos", "", "static", "placeTemplateAsShip", "(Lnet/minecraft/class_3499;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Z)Lorg/valkyrienskies/core/api/ships/ServerShip;", "", "discardShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_3218;)V", "Lorg/joml/Vector3dc;", "newPos", "teleportShip", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lnet/minecraft/class_3218;Lorg/joml/Vector3dc;)V", "start", "", "Lnet/minecraft/class_2248;", "blackList", "assembleByConnectivity", "(Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Ljava/util/List;)Lorg/valkyrienskies/core/api/ships/ServerShip;", "Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;", "voxelSet", "Lkotlin/Function0;", "whenComplete", "cleanupOriginalBlocks", "(Lnet/minecraft/class_3218;Lg_mungus/vlib/v2/internal/assembly/BoundedVoxelSet;Lkotlin/jvm/functions/Function0;)V", "<init>", "()V", "vlib"})
@SourceDebugExtension(value={"SMAP\nVLibAPI.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VLibAPI.kt\ng_mungus/vlib/v2/api/VLibAPI\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n1863#2,2:72\n1863#2,2:74\n*S KotlinDebug\n*F\n+ 1 VLibAPI.kt\ng_mungus/vlib/v2/api/VLibAPI\n*L\n55#1:72,2\n64#1:74,2\n*E\n"})
public final class VLibAPI {
    @NotNull
    public static final VLibAPI INSTANCE = new VLibAPI();

    private VLibAPI() {
    }

    @JvmStatic
    @NotNull
    public static final NamedStructureTemplate saveShipToTemplate(@NotNull ServerShip ship, @NotNull class_2960 resourceLocation, @NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)resourceLocation, (String)"resourceLocation");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        return ShipExtKt.saveToTemplate(ship, resourceLocation, level);
    }

    @JvmStatic
    @Nullable
    public static final ServerShip placeTemplateAsShip(@NotNull class_3499 template, @NotNull class_3218 level, @NotNull class_2338 pos, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)template, (String)"template");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return StructureTemplateExtKt.placeAsShip(template, level, pos, bl);
    }

    @JvmStatic
    public static final void discardShip(@NotNull ServerShip ship, @NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        ShipExtKt.discard(ship, level);
    }

    @JvmStatic
    public static final void teleportShip(@NotNull ServerShip ship, @NotNull class_3218 level, @NotNull Vector3dc newPos) {
        Intrinsics.checkNotNullParameter((Object)ship, (String)"ship");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)newPos, (String)"newPos");
        ShipExtKt.teleport(ship, level, newPos);
    }

    @JvmStatic
    @Nullable
    public static final ServerShip assembleByConnectivity(@NotNull class_3218 level, @NotNull class_2338 start, @NotNull List<? extends class_2248> blackList) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)start, (String)"start");
        Intrinsics.checkNotNullParameter(blackList, (String)"blackList");
        if (VSGameUtilsKt.isBlockInShipyard((class_1937)((class_1937)level), (class_2338)start)) {
            return null;
        }
        BoundedVoxelSet boundedVoxelSet = BoundedVoxelSet.Companion.tryFillByConnectivity((class_1937)level, start, blackList);
        if (boundedVoxelSet == null) {
            return null;
        }
        BoundedVoxelSet voxelSet = boundedVoxelSet;
        class_3499 it = new class_3499();
        boolean bl = false;
        StructureTemplateExtKt.fillFromVoxelSet(it, level, voxelSet);
        ServerShip serverShip = StructureTemplateExtKt.placeAsShip(it, level, VectorConversionsMCKt.toBlockPos((Vector3ic)voxelSet.getMin()), true);
        if (serverShip == null) {
            return null;
        }
        ServerShip ship = serverShip;
        INSTANCE.cleanupOriginalBlocks(level, voxelSet, (Function0<Unit>)((Function0)() -> VLibAPI.assembleByConnectivity$lambda$1(ship)));
        return ship;
    }

    public static /* synthetic */ ServerShip assembleByConnectivity$default(class_3218 class_32182, class_2338 class_23382, List list, int n, Object object) {
        if ((n & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        return VLibAPI.assembleByConnectivity(class_32182, class_23382, list);
    }

    private final void cleanupOriginalBlocks(class_3218 level, BoundedVoxelSet voxelSet, Function0<Unit> whenComplete) {
        Iterable $this$forEach$iv = voxelSet.getVoxels();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            class_2338 pos = (class_2338)element$iv;
            boolean bl = false;
            class_2586 be = level.method_8321(pos);
            if (be != null) {
                level.method_8544(pos);
            }
            level.method_8652(pos, VLib.INSTANCE.getGHOST_BLOCK().method_9564(), 0);
        }
        ServerLevelExtKt.scheduleCallback(level, 4, (Function0<Unit>)((Function0)() -> VLibAPI.cleanupOriginalBlocks$lambda$4(voxelSet, whenComplete, level)));
    }

    private static final Unit assembleByConnectivity$lambda$1(ServerShip $ship) {
        Intrinsics.checkNotNullParameter((Object)$ship, (String)"$ship");
        $ship.setStatic(false);
        return Unit.INSTANCE;
    }

    private static final Unit cleanupOriginalBlocks$lambda$4(BoundedVoxelSet $voxelSet, Function0 $whenComplete, class_3218 $level) {
        Intrinsics.checkNotNullParameter((Object)$voxelSet, (String)"$voxelSet");
        Intrinsics.checkNotNullParameter((Object)$whenComplete, (String)"$whenComplete");
        Intrinsics.checkNotNullParameter((Object)$level, (String)"$level");
        Iterable $this$forEach$iv = $voxelSet.getVoxels();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            class_2338 pos = (class_2338)element$iv;
            boolean bl = false;
            $level.method_8652(pos, class_2246.field_10124.method_9564(), 2);
        }
        $whenComplete.invoke();
        return Unit.INSTANCE;
    }
}

