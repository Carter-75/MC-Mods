/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal.physics;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3ic;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.IShipActiveChunksSet;
import org.valkyrienskies.core.internal.physics.VSCollisionShapeData;
import org.valkyrienskies.core.internal.physics.VSCollisionShapes;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0004\b\r\u0010\u000eJD\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fH\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aH\u00d6\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dH\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b!\u0010\u000eR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010\u0004R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b$\u0010\u0004R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b*\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010\b\u00a8\u0006/"}, d2={"Lorg/valkyrienskies/core/internal/physics/VSVoxelCollisionShapeData;", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapeData;", "Lorg/joml/Vector3ic;", "component1", "()Lorg/joml/Vector3ic;", "component2", "Lorg/joml/primitives/AABBic;", "component3", "()Lorg/joml/primitives/AABBic;", "", "component4", "()Z", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "component5", "()Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "minDefined", "maxDefined", "totalVoxelRegion", "shipVoxelsFullyLoaded", "chunksToLoad", "copy", "(Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/primitives/AABBic;ZLorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;)Lorg/valkyrienskies/core/internal/physics/VSVoxelCollisionShapeData;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;", "getChunksToLoad", "Lorg/joml/Vector3ic;", "getMaxDefined", "getMinDefined", "Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "getShapeType", "()Lorg/valkyrienskies/core/internal/physics/VSCollisionShapes;", "shapeType", "Z", "getShipVoxelsFullyLoaded", "Lorg/joml/primitives/AABBic;", "getTotalVoxelRegion", "<init>", "(Lorg/joml/Vector3ic;Lorg/joml/Vector3ic;Lorg/joml/primitives/AABBic;ZLorg/valkyrienskies/core/api/ships/properties/IShipActiveChunksSet;)V", "internal"})
public final class VSVoxelCollisionShapeData
implements VSCollisionShapeData {
    @NotNull
    private final Vector3ic minDefined;
    @NotNull
    private final Vector3ic maxDefined;
    @NotNull
    private final AABBic totalVoxelRegion;
    private final boolean shipVoxelsFullyLoaded;
    @Nullable
    private final IShipActiveChunksSet chunksToLoad;

    public VSVoxelCollisionShapeData(@NotNull Vector3ic minDefined, @NotNull Vector3ic maxDefined, @NotNull AABBic totalVoxelRegion, boolean shipVoxelsFullyLoaded, @Nullable IShipActiveChunksSet chunksToLoad) {
        Intrinsics.checkNotNullParameter((Object)minDefined, (String)"minDefined");
        Intrinsics.checkNotNullParameter((Object)maxDefined, (String)"maxDefined");
        Intrinsics.checkNotNullParameter((Object)totalVoxelRegion, (String)"totalVoxelRegion");
        this.minDefined = minDefined;
        this.maxDefined = maxDefined;
        this.totalVoxelRegion = totalVoxelRegion;
        this.shipVoxelsFullyLoaded = shipVoxelsFullyLoaded;
        this.chunksToLoad = chunksToLoad;
    }

    @NotNull
    public final Vector3ic getMinDefined() {
        return this.minDefined;
    }

    @NotNull
    public final Vector3ic getMaxDefined() {
        return this.maxDefined;
    }

    @NotNull
    public final AABBic getTotalVoxelRegion() {
        return this.totalVoxelRegion;
    }

    public final boolean getShipVoxelsFullyLoaded() {
        return this.shipVoxelsFullyLoaded;
    }

    @Nullable
    public final IShipActiveChunksSet getChunksToLoad() {
        return this.chunksToLoad;
    }

    @Override
    @NotNull
    public VSCollisionShapes getShapeType() {
        return VSCollisionShapes.VOXEL;
    }

    @NotNull
    public final Vector3ic component1() {
        return this.minDefined;
    }

    @NotNull
    public final Vector3ic component2() {
        return this.maxDefined;
    }

    @NotNull
    public final AABBic component3() {
        return this.totalVoxelRegion;
    }

    public final boolean component4() {
        return this.shipVoxelsFullyLoaded;
    }

    @Nullable
    public final IShipActiveChunksSet component5() {
        return this.chunksToLoad;
    }

    @NotNull
    public final VSVoxelCollisionShapeData copy(@NotNull Vector3ic minDefined, @NotNull Vector3ic maxDefined, @NotNull AABBic totalVoxelRegion, boolean shipVoxelsFullyLoaded, @Nullable IShipActiveChunksSet chunksToLoad) {
        Intrinsics.checkNotNullParameter((Object)minDefined, (String)"minDefined");
        Intrinsics.checkNotNullParameter((Object)maxDefined, (String)"maxDefined");
        Intrinsics.checkNotNullParameter((Object)totalVoxelRegion, (String)"totalVoxelRegion");
        return new VSVoxelCollisionShapeData(minDefined, maxDefined, totalVoxelRegion, shipVoxelsFullyLoaded, chunksToLoad);
    }

    public static /* synthetic */ VSVoxelCollisionShapeData copy$default(VSVoxelCollisionShapeData vSVoxelCollisionShapeData, Vector3ic vector3ic, Vector3ic vector3ic2, AABBic aABBic, boolean bl, IShipActiveChunksSet iShipActiveChunksSet, int n2, Object object) {
        if ((n2 & 1) != 0) {
            vector3ic = vSVoxelCollisionShapeData.minDefined;
        }
        if ((n2 & 2) != 0) {
            vector3ic2 = vSVoxelCollisionShapeData.maxDefined;
        }
        if ((n2 & 4) != 0) {
            aABBic = vSVoxelCollisionShapeData.totalVoxelRegion;
        }
        if ((n2 & 8) != 0) {
            bl = vSVoxelCollisionShapeData.shipVoxelsFullyLoaded;
        }
        if ((n2 & 0x10) != 0) {
            iShipActiveChunksSet = vSVoxelCollisionShapeData.chunksToLoad;
        }
        return vSVoxelCollisionShapeData.copy(vector3ic, vector3ic2, aABBic, bl, iShipActiveChunksSet);
    }

    @NotNull
    public String toString() {
        return "VSVoxelCollisionShapeData(minDefined=" + this.minDefined + ", maxDefined=" + this.maxDefined + ", totalVoxelRegion=" + this.totalVoxelRegion + ", shipVoxelsFullyLoaded=" + this.shipVoxelsFullyLoaded + ", chunksToLoad=" + this.chunksToLoad + ")";
    }

    public int hashCode() {
        int result2 = this.minDefined.hashCode();
        result2 = result2 * 31 + this.maxDefined.hashCode();
        result2 = result2 * 31 + this.totalVoxelRegion.hashCode();
        result2 = result2 * 31 + Boolean.hashCode(this.shipVoxelsFullyLoaded);
        result2 = result2 * 31 + (this.chunksToLoad == null ? 0 : this.chunksToLoad.hashCode());
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VSVoxelCollisionShapeData)) {
            return false;
        }
        VSVoxelCollisionShapeData vSVoxelCollisionShapeData = (VSVoxelCollisionShapeData)other;
        if (!Intrinsics.areEqual((Object)this.minDefined, (Object)vSVoxelCollisionShapeData.minDefined)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.maxDefined, (Object)vSVoxelCollisionShapeData.maxDefined)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.totalVoxelRegion, (Object)vSVoxelCollisionShapeData.totalVoxelRegion)) {
            return false;
        }
        if (this.shipVoxelsFullyLoaded != vSVoxelCollisionShapeData.shipVoxelsFullyLoaded) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.chunksToLoad, (Object)vSVoxelCollisionShapeData.chunksToLoad);
    }
}

