/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  org.dynmap.DynmapCommonAPI
 *  org.dynmap.fabric_1_20.DynmapMod
 *  org.dynmap.fabric_1_20.DynmapPlugin
 *  org.dynmap.fabric_1_20.FabricWorld
 *  org.dynmap.markers.MarkerIcon
 */
package org.valkyrienskies.mod.fabric.compat.dynmap;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import org.dynmap.DynmapCommonAPI;
import org.dynmap.fabric_1_20.DynmapMod;
import org.dynmap.fabric_1_20.DynmapPlugin;
import org.dynmap.fabric_1_20.FabricWorld;
import org.dynmap.markers.MarkerIcon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.compat.dynmap.DynmapHandler;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2={"Lorg/valkyrienskies/mod/fabric/compat/dynmap/FabricDynmapHandler;", "Lorg/valkyrienskies/mod/compat/dynmap/DynmapHandler;", "", "register", "()V", "Lnet/minecraft/class_3218;", "level", "", "getWorldName", "(Lnet/minecraft/class_3218;)Ljava/lang/String;", "Lorg/dynmap/markers/MarkerIcon;", "getOrCreateIcon", "()Lorg/dynmap/markers/MarkerIcon;", "<init>", "valkyrienskies-120"})
public final class FabricDynmapHandler
extends DynmapHandler {
    @Override
    public void register() {
        super.register();
        ServerTickEvents.END_WORLD_TICK.register(this::updateMarkers);
    }

    @Override
    @NotNull
    public String getWorldName(@NotNull class_3218 level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        String string = FabricWorld.getWorldName((DynmapPlugin)DynmapMod.plugin, (class_1937)((class_1937)level));
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getWorldName(...)");
        return string;
    }

    @Override
    @Nullable
    public MarkerIcon getOrCreateIcon() {
        Object object = this.getApi();
        if (object == null || (object = object.getMarkerAPI()) == null || (object = object.getMarkerIcon("ship")) == null) {
            FabricDynmapHandler $this$getOrCreateIcon_u24lambda_u241 = this;
            boolean bl = false;
            DynmapPlugin dynmapPlugin = DynmapMod.plugin;
            if (dynmapPlugin != null && (dynmapPlugin = dynmapPlugin.getFabricServer()) != null) {
                DynmapPlugin it = dynmapPlugin;
                boolean bl2 = false;
                DynmapCommonAPI dynmapCommonAPI = $this$getOrCreateIcon_u24lambda_u241.getApi();
                object = dynmapCommonAPI != null && (dynmapCommonAPI = dynmapCommonAPI.getMarkerAPI()) != null ? dynmapCommonAPI.createMarkerIcon("ship", "ship", it.openResource("valkyrienskies", "assets/valkyrienskies/icon.png")) : null;
            } else {
                object = null;
            }
        }
        return object;
    }
}

