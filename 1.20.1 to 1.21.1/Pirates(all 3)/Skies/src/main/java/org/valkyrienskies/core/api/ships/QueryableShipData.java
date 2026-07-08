/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.jvm.internal.markers.KMappedMarker
 */
package org.valkyrienskies.core.api.ships;

import java.util.Collection;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.Ship;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0006\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0016\u00a2\u0006\u0004\b\u0006\u0010\u000bJ\u001d\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0015\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H&\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u0004\u0018\u00018\u00002\n\u0010\n\u001a\u00060\bj\u0002`\tH&\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H'\u00a2\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H&\u00a2\u0006\u0004\b\u001c\u0010\u001eJ-\u0010\u001f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0017\u00a2\u0006\u0004\b\u001f\u0010\u0016J\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0017\u00a2\u0006\u0004\b \u0010\u001dJ\u000f\u0010!\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b!\u0010\"R*\u0010(\u001a\u0012\u0012\b\u0012\u00060\bj\u0002`\t\u0012\u0004\u0012\u00028\u00000#8&X\u00a7\u0004\u00a2\u0006\f\u0012\u0004\b&\u0010'\u001a\u0004\b$\u0010%\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006)\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/ships/QueryableShipData;", "Lorg/valkyrienskies/core/api/ships/Ship;", "ShipType", "", "element", "", "contains", "(Lorg/valkyrienskies/core/api/ships/Ship;)Z", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "shipId", "(J)Z", "elements", "containsAll", "(Ljava/util/Collection;)Z", "", "chunkX", "chunkZ", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "dimensionId", "getByChunkPos", "(IILjava/lang/String;)Lorg/valkyrienskies/core/api/ships/Ship;", "getById", "(J)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/primitives/AABBdc;", "aabb", "", "getIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/lang/Iterable;", "(Lorg/joml/primitives/AABBdc;Ljava/lang/String;)Ljava/lang/Iterable;", "getShipDataFromChunkPos", "getShipDataIntersecting", "isEmpty", "()Z", "", "getIdToShipData", "()Ljava/util/Map;", "getIdToShipData$annotations", "()V", "idToShipData", "api"})
@SourceDebugExtension(value={"SMAP\nQueryableShipData.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QueryableShipData.kt\norg/valkyrienskies/core/api/ships/QueryableShipData\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,66:1\n1734#2,3:67\n*S KotlinDebug\n*F\n+ 1 QueryableShipData.kt\norg/valkyrienskies/core/api/ships/QueryableShipData\n*L\n48#1:67,3\n*E\n"})
public interface QueryableShipData<ShipType extends Ship>
extends Collection<ShipType>,
KMappedMarker {
    @Nullable
    public ShipType getById(long var1);

    @Nullable
    public ShipType getByChunkPos(int var1, int var2, @NotNull String var3);

    @NotNull
    public Iterable<ShipType> getIntersecting(@NotNull AABBdc var1, @NotNull String var2);

    @Deprecated(message="This gets all ships in the AABB, irrespective of dimension. This is pretty much never what you want.", replaceWith=@ReplaceWith(expression="getIntersecting(aabb, dimensionId)", imports={}))
    @NotNull
    public Iterable<ShipType> getIntersecting(@NotNull AABBdc var1);

    default public boolean contains(long shipId) {
        return this.getById(shipId) != null;
    }

    @Override
    default public boolean contains(@NotNull ShipType element) {
        Intrinsics.checkNotNullParameter(element, (String)"element");
        return this.contains(element.getId());
    }

    @Override
    default public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        boolean bl;
        block3: {
            Intrinsics.checkNotNullParameter(elements, (String)"elements");
            Iterable $this$all$iv = elements;
            boolean $i$f$all = false;
            if (((Collection)$this$all$iv).isEmpty()) {
                bl = true;
            } else {
                for (Object element$iv : $this$all$iv) {
                    Ship p0 = (Ship)element$iv;
                    boolean bl2 = false;
                    if (this.contains(p0)) continue;
                    bl = false;
                    break block3;
                }
                bl = true;
            }
        }
        return bl;
    }

    @Override
    default public boolean isEmpty() {
        return this.size() == 0;
    }

    @Deprecated(message="This gets all ships in the AABB, irrespective of dimension. This is pretty much never what you want.", replaceWith=@ReplaceWith(expression="getIntersecting(aabb, dimensionId)", imports={}))
    @NotNull
    default public Iterable<ShipType> getShipDataIntersecting(@NotNull AABBdc aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"aabb");
        return this.getIntersecting(aabb);
    }

    @Deprecated(message="renamed", replaceWith=@ReplaceWith(expression="getByChunkPos(chunkX, chunkZ, dimensionId)", imports={}))
    @Nullable
    default public ShipType getShipDataFromChunkPos(int chunkX, int chunkZ, @NotNull String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"dimensionId");
        return this.getByChunkPos(chunkX, chunkZ, dimensionId);
    }

    @NotNull
    public Map<Long, ShipType> getIdToShipData();

    @Deprecated(message="Use the specific functions instead, such as #getById or #iterator")
    public static /* synthetic */ void getIdToShipData$annotations() {
    }
}

