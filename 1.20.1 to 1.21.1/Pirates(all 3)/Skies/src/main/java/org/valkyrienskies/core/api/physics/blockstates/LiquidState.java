/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.api.physics.blockstates;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.LiquidBlockShape;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0010R\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0011\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "", "", "getDensity", "()D", "density", "getDragCoefficient", "dragCoefficient", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "getShape", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "shape", "Lorg/joml/Vector3dc;", "getVelocity", "()Lorg/joml/Vector3dc;", "velocity", "Builder", "api"})
public interface LiquidState {
    public double getDensity();

    public double getDragCoefficient();

    @NotNull
    public Vector3dc getVelocity();

    @NotNull
    public LiquidBlockShape getShape();

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH&\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH&\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a2\u0006\u0004\b\u0011\u0010\u0012\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0013\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "", "Lorg/joml/primitives/AABBic;", "boundingBox", "boxShape", "(Lorg/joml/primitives/AABBic;)Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "build", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "", "density", "(D)Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "dragCoefficient", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "shape", "(Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;)Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lorg/joml/Vector3dc;", "velocity", "(Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "api"})
    public static interface Builder {
        @NotNull
        public Builder boxShape(@NotNull AABBic var1);

        @NotNull
        public Builder shape(@NotNull LiquidBlockShape var1);

        @NotNull
        public Builder density(double var1);

        @NotNull
        public Builder dragCoefficient(double var1);

        @NotNull
        public Builder velocity(@NotNull Vector3dc var1);

        @NotNull
        public LiquidState build();
    }
}

