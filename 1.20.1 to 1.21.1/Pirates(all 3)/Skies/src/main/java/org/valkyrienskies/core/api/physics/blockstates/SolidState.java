/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 */
package org.valkyrienskies.core.api.physics.blockstates;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.SolidBlockShape;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u000eR\u0014\u0010\u0005\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\r\u001a\u00020\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000f\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "", "", "getElasticity", "()D", "elasticity", "getFriction", "friction", "getHardness", "hardness", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "getShape", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "shape", "Builder", "api"})
public interface SolidState {
    public double getElasticity();

    public double getFriction();

    public double getHardness();

    @NotNull
    public SolidBlockShape getShape();

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J(\u0010\u0007\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH&\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH&\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH&\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H&\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0014\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "", "Lkotlin/Function1;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "", "Lkotlin/ExtensionFunctionType;", "shapeBuilder", "boxesShape", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "build", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "", "elasticity", "(D)Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "friction", "hardness", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "shape", "(Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;)Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "api"})
    public static interface Builder {
        @NotNull
        public Builder elasticity(double var1);

        @NotNull
        public Builder friction(double var1);

        @NotNull
        public Builder hardness(double var1);

        @NotNull
        public Builder shape(@NotNull SolidBlockShape var1);

        @NotNull
        public Builder boxesShape(@NotNull Function1<? super BoxesBlockShape.Builder, Unit> var1);

        @NotNull
        public SolidState build();
    }
}

