/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Triple
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.random.Random
 *  kotlin.text.StringsKt
 *  net.minecraft.class_3218
 *  org.dynmap.DynmapCommonAPI
 *  org.dynmap.DynmapCommonAPIListener
 *  org.dynmap.markers.GenericMarker
 *  org.dynmap.markers.Marker
 *  org.dynmap.markers.MarkerIcon
 *  org.dynmap.markers.MarkerSet
 *  org.dynmap.markers.PolyLineMarker
 */
package org.valkyrienskies.mod.compat.dynmap;

import java.util.Set;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import net.minecraft.class_3218;
import org.dynmap.DynmapCommonAPI;
import org.dynmap.DynmapCommonAPIListener;
import org.dynmap.markers.GenericMarker;
import org.dynmap.markers.Marker;
import org.dynmap.markers.MarkerIcon;
import org.dynmap.markers.MarkerSet;
import org.dynmap.markers.PolyLineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3dc;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.QueryableShipData;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.internal.ships.VsiQueryableShipData;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b5\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0013J-\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002\u00a2\u0006\u0004\b\u001f\u0010\u001eJ\u0011\u0010 \u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b \u0010!J)\u0010&\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0$2\u0006\u0010#\u001a\u00020\"H\u0002\u00a2\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b+\u0010,J\u0011\u0010.\u001a\u0004\u0018\u00010-H&\u00a2\u0006\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0006\u00a8\u00066"}, d2={"Lorg/valkyrienskies/mod/compat/dynmap/DynmapHandler;", "Lorg/dynmap/DynmapCommonAPIListener;", "Lorg/dynmap/DynmapCommonAPI;", "dynmapCommonAPI", "", "apiEnabled", "(Lorg/dynmap/DynmapCommonAPI;)V", "register", "()V", "Lnet/minecraft/class_3218;", "level", "updateMarkers", "(Lnet/minecraft/class_3218;)V", "Lorg/dynmap/markers/MarkerSet;", "markerSet", "Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "Lorg/valkyrienskies/core/api/ships/ServerShip;", "data", "clearUnusedIconMarkers", "(Lorg/dynmap/markers/MarkerSet;Lorg/valkyrienskies/core/api/ships/QueryableShipData;)V", "clearUnusedPolylineMarkers", "Lorg/dynmap/markers/GenericMarker;", "marker", "", "enabled", "clearUnusedMarker", "(Lorg/dynmap/markers/GenericMarker;Lorg/valkyrienskies/core/api/ships/QueryableShipData;Z)V", "", "world", "renderShipIconMarker", "(Lorg/valkyrienskies/core/api/ships/ServerShip;Lorg/dynmap/markers/MarkerSet;Ljava/lang/String;)V", "renderShipPolylineMarker", "getOrCreateMarkerSet", "()Lorg/dynmap/markers/MarkerSet;", "Lorg/joml/primitives/AABBdc;", "aabb", "Lkotlin/Triple;", "", "getArraysFromAABB", "(Lorg/joml/primitives/AABBdc;)Lkotlin/Triple;", "ship", "createShipLabel", "(Lorg/valkyrienskies/core/api/ships/ServerShip;)Ljava/lang/String;", "getWorldName", "(Lnet/minecraft/class_3218;)Ljava/lang/String;", "Lorg/dynmap/markers/MarkerIcon;", "getOrCreateIcon", "()Lorg/dynmap/markers/MarkerIcon;", "api", "Lorg/dynmap/DynmapCommonAPI;", "getApi", "()Lorg/dynmap/DynmapCommonAPI;", "setApi", "<init>", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nDynmapHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DynmapHandler.kt\norg/valkyrienskies/mod/compat/dynmap/DynmapHandler\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,166:1\n1863#2,2:167\n1863#2,2:169\n1863#2,2:171\n1863#2,2:173\n*S KotlinDebug\n*F\n+ 1 DynmapHandler.kt\norg/valkyrienskies/mod/compat/dynmap/DynmapHandler\n*L\n39#1:167,2\n43#1:169,2\n47#1:171,2\n51#1:173,2\n*E\n"})
public abstract class DynmapHandler
extends DynmapCommonAPIListener {
    @Nullable
    private DynmapCommonAPI api;

    @Nullable
    public final DynmapCommonAPI getApi() {
        return this.api;
    }

    public final void setApi(@Nullable DynmapCommonAPI dynmapCommonAPI) {
        this.api = dynmapCommonAPI;
    }

    public void apiEnabled(@NotNull DynmapCommonAPI dynmapCommonAPI) {
        Intrinsics.checkNotNullParameter((Object)dynmapCommonAPI, (String)"dynmapCommonAPI");
        this.api = dynmapCommonAPI;
    }

    public void register() {
        DynmapCommonAPIListener.register((DynmapCommonAPIListener)this);
    }

    public final void updateMarkers(@NotNull class_3218 level) {
        ServerShip ship;
        boolean $i$f$forEach;
        Iterable $this$forEach$iv;
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        String worldName = this.getWorldName(level);
        VsiQueryableShipData<ServerShip> allShips = VSGameUtilsKt.getShipObjectWorld(level).getAllShips();
        MarkerSet markerSet = this.getOrCreateMarkerSet();
        if (markerSet == null) {
            return;
        }
        MarkerSet markerSet2 = markerSet;
        this.clearUnusedIconMarkers(markerSet2, (QueryableShipData<? extends ServerShip>)allShips);
        if (VSGameConfig.SERVER.getDynmap().getShowIconMarkers()) {
            $this$forEach$iv = allShips;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ship = (ServerShip)element$iv;
                boolean bl = false;
                this.renderShipIconMarker(ship, markerSet2, worldName);
            }
        }
        this.clearUnusedPolylineMarkers(markerSet2, (QueryableShipData<? extends ServerShip>)allShips);
        if (VSGameConfig.SERVER.getDynmap().getShowPolylineMarkers()) {
            $this$forEach$iv = allShips;
            $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                ship = (ServerShip)element$iv;
                boolean bl = false;
                this.renderShipPolylineMarker(ship, markerSet2, worldName);
            }
        }
    }

    private final void clearUnusedIconMarkers(MarkerSet markerSet, QueryableShipData<? extends ServerShip> data) {
        block1: {
            Set set = markerSet.getMarkers();
            if (set == null) break block1;
            Iterable $this$forEach$iv = set;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                Marker marker = (Marker)element$iv;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)marker);
                this.clearUnusedMarker((GenericMarker)marker, data, VSGameConfig.SERVER.getDynmap().getShowIconMarkers());
            }
        }
    }

    private final void clearUnusedPolylineMarkers(MarkerSet markerSet, QueryableShipData<? extends ServerShip> data) {
        block1: {
            Set set = markerSet.getPolyLineMarkers();
            if (set == null) break block1;
            Iterable $this$forEach$iv = set;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                PolyLineMarker marker = (PolyLineMarker)element$iv;
                boolean bl = false;
                Intrinsics.checkNotNull((Object)marker);
                this.clearUnusedMarker((GenericMarker)marker, data, VSGameConfig.SERVER.getDynmap().getShowPolylineMarkers());
            }
        }
    }

    private final void clearUnusedMarker(GenericMarker marker, QueryableShipData<? extends ServerShip> data, boolean enabled) {
        String string = marker.getMarkerID();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getMarkerID(...)");
        long id = Long.parseLong(StringsKt.replace$default((String)string, (String)"ship", (String)"", (boolean)false, (int)4, null));
        if (data.getById(id) == null || !enabled) {
            marker.deleteMarker();
        }
    }

    private final void renderShipIconMarker(ServerShip data, MarkerSet markerSet, String world) {
        Vector3dc pos = data.getTransform().getPositionInWorld();
        String label = this.createShipLabel(data);
        MarkerIcon icon = this.getOrCreateIcon();
        Marker marker = markerSet.findMarker("ship" + data.getId());
        if (marker == null) {
            DynmapHandler $this$renderShipIconMarker_u24lambda_u244 = this;
            boolean bl = false;
            markerSet.createMarker("ship" + data.getId(), label, true, world, pos.x(), pos.y(), pos.z(), icon, true);
            return;
        }
        Marker marker2 = marker;
        marker2.setDescription(label);
        marker2.setLocation(world, pos.x(), pos.y(), pos.z());
        marker2.setMarkerIcon(icon);
    }

    private final void renderShipPolylineMarker(ServerShip data, MarkerSet markerSet, String world) {
        Triple<double[], double[], double[]> arrays = this.getArraysFromAABB(data.getWorldAABB());
        String label = this.createShipLabel(data);
        PolyLineMarker polyLineMarker = markerSet.findPolyLineMarker("ship" + data.getId());
        if (polyLineMarker == null) {
            PolyLineMarker self;
            DynmapHandler $this$renderShipPolylineMarker_u24lambda_u245 = this;
            boolean bl = false;
            PolyLineMarker polyLineMarker2 = self = markerSet.createPolyLineMarker("ship" + data.getId(), label, true, world, (double[])arrays.getFirst(), (double[])arrays.getSecond(), (double[])arrays.getThird(), true);
            if (polyLineMarker2 != null) {
                polyLineMarker2.setLineStyle(5, self.getLineOpacity(), Random.Default.nextInt(0, 0xFFFFFF));
            }
            if ((polyLineMarker = self) == null) {
                return;
            }
        }
        PolyLineMarker marker = polyLineMarker;
        marker.setDescription(label);
        marker.setCornerLocations((double[])arrays.getFirst(), (double[])arrays.getSecond(), (double[])arrays.getThird());
    }

    private final MarkerSet getOrCreateMarkerSet() {
        Object object = this.api;
        if (object == null || (object = object.getMarkerAPI()) == null || (object = object.getMarkerSet("valkyrienskies")) == null) {
            DynmapHandler $this$getOrCreateMarkerSet_u24lambda_u246 = this;
            boolean bl = false;
            DynmapCommonAPI dynmapCommonAPI = $this$getOrCreateMarkerSet_u24lambda_u246.api;
            object = dynmapCommonAPI != null && (dynmapCommonAPI = dynmapCommonAPI.getMarkerAPI()) != null ? dynmapCommonAPI.createMarkerSet("valkyrienskies", "VS Ship Markers", null, true) : null;
        }
        return object;
    }

    private final Triple<double[], double[], double[]> getArraysFromAABB(AABBdc aabb) {
        double[] dArray = new double[]{aabb.minX(), aabb.minX(), aabb.minX(), aabb.minX(), aabb.minX(), aabb.minX(), aabb.maxX(), aabb.maxX(), aabb.minX(), aabb.maxX(), aabb.maxX(), aabb.maxX(), aabb.maxX(), aabb.maxX(), aabb.minX(), aabb.minX(), aabb.maxX()};
        double[] x = dArray;
        double[] dArray2 = new double[]{aabb.minY(), aabb.maxY(), aabb.maxY(), aabb.minY(), aabb.minY(), aabb.maxY(), aabb.maxY(), aabb.minY(), aabb.minY(), aabb.minY(), aabb.minY(), aabb.maxY(), aabb.maxY(), aabb.maxY(), aabb.maxY(), aabb.minY(), aabb.minY()};
        double[] y = dArray2;
        double[] dArray3 = new double[]{aabb.minZ(), aabb.minZ(), aabb.maxZ(), aabb.maxZ(), aabb.minZ(), aabb.minZ(), aabb.minZ(), aabb.minZ(), aabb.minZ(), aabb.minZ(), aabb.maxZ(), aabb.maxZ(), aabb.minZ(), aabb.maxZ(), aabb.maxZ(), aabb.maxZ(), aabb.maxZ()};
        double[] z = dArray3;
        return new Triple((Object)x, (Object)y, (Object)z);
    }

    private final String createShipLabel(ServerShip ship) {
        String label = "<h1>" + ship.getSlug() + "</h1>";
        if (VSGameConfig.SERVER.getDynmap().getShowShipId()) {
            label = label + "<p><strong>Ship ID: </strong>" + ship.getId() + "</p>";
        }
        if (VSGameConfig.SERVER.getDynmap().getShowShipMass()) {
            label = label + "<p><strong>Ship Mass: </strong>" + ship.getInertiaData().getMass() + " kg</p>";
        }
        return label;
    }

    @NotNull
    public abstract String getWorldName(@NotNull class_3218 var1);

    @Nullable
    public abstract MarkerIcon getOrCreateIcon();
}

