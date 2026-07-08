/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.internal.physics.blockstates;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2={"Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "liquidState", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "getLiquidState", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "solidState", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "getSolidState", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "<init>", "(Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;)V", "internal"})
public final class VsiBlockState {
    @Nullable
    private final SolidState solidState;
    @Nullable
    private final LiquidState liquidState;

    public VsiBlockState(@Nullable SolidState solidState, @Nullable LiquidState liquidState) {
        this.solidState = solidState;
        this.liquidState = liquidState;
    }

    @Nullable
    public final SolidState getSolidState() {
        return this.solidState;
    }

    @Nullable
    public final LiquidState getLiquidState() {
        return this.liquidState;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VsiBlockState)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.solidState, (Object)((VsiBlockState)other).solidState)) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.liquidState, (Object)((VsiBlockState)other).liquidState);
    }

    public int hashCode() {
        SolidState solidState = this.solidState;
        int result2 = solidState != null ? solidState.hashCode() : 0;
        LiquidState liquidState = this.liquidState;
        result2 = 31 * result2 + (liquidState != null ? liquidState.hashCode() : 0);
        return result2;
    }

    @NotNull
    public String toString() {
        return "VsBlockState(solidState=" + this.solidState + ", liquidState=" + this.liquidState + ")";
    }
}

