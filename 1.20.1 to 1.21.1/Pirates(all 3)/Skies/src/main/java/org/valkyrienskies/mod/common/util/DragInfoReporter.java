/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_3218
 */
package org.valkyrienskies.mod.common.util;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_3218;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.valkyrienskies.core.api.ships.DragController;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2={"Lorg/valkyrienskies/mod/common/util/DragInfoReporter;", "", "Lnet/minecraft/class_3218;", "level", "", "tick", "(Lnet/minecraft/class_3218;)V", "Ljava/util/HashMap;", "", "Lorg/joml/Vector3dc;", "shipDragValues", "Ljava/util/HashMap;", "getShipDragValues", "()Ljava/util/HashMap;", "shipLiftValues", "getShipLiftValues", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nDragInfoReporter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DragInfoReporter.kt\norg/valkyrienskies/mod/common/util/DragInfoReporter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,19:1\n1863#2,2:20\n*S KotlinDebug\n*F\n+ 1 DragInfoReporter.kt\norg/valkyrienskies/mod/common/util/DragInfoReporter\n*L\n13#1:20,2\n*E\n"})
public final class DragInfoReporter {
    @NotNull
    public static final DragInfoReporter INSTANCE = new DragInfoReporter();
    @NotNull
    private static final HashMap<Long, Vector3dc> shipDragValues = new HashMap();
    @NotNull
    private static final HashMap<Long, Vector3dc> shipLiftValues = new HashMap();

    private DragInfoReporter() {
    }

    @NotNull
    public final HashMap<Long, Vector3dc> getShipDragValues() {
        return shipDragValues;
    }

    @NotNull
    public final HashMap<Long, Vector3dc> getShipLiftValues() {
        return shipLiftValues;
    }

    public final void tick(@NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Iterable $this$forEach$iv = VSGameUtilsKt.getShipObjectWorld(level).getLoadedShips();
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            LoadedServerShip ship = (LoadedServerShip)element$iv;
            boolean bl = false;
            Map map2 = shipDragValues;
            Long l2 = ship.getId();
            DragController dragController = ship.getDragController();
            Intrinsics.checkNotNull((Object)dragController);
            map2.put(l2, dragController.getDragForce());
            Map map3 = shipLiftValues;
            Long l3 = ship.getId();
            DragController dragController2 = ship.getDragController();
            Intrinsics.checkNotNull((Object)dragController2);
            map3.put(l3, dragController2.getLiftForce());
        }
    }
}

