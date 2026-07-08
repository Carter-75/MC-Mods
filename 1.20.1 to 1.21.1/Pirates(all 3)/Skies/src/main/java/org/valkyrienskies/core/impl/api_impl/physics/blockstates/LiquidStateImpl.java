/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.LiquidBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.BoxBlockShapeImpl;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.InternalUtilsKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u0001&B)\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00058\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\f\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\t8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b#\u0010\u000b"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "component1", "()Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "", "component2", "()D", "component3", "Lorg/joml/Vector3dc;", "component4", "()Lorg/joml/Vector3dc;", "shape", "density", "dragCoefficient", "velocity", "copy", "(Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;DDLorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getDensity", "getDragCoefficient", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "getShape", "Lorg/joml/Vector3dc;", "getVelocity", "<init>", "(Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;DDLorg/joml/Vector3dc;)V", "BuilderImpl"})
public final class LiquidStateImpl
implements LiquidState {
    private final LiquidBlockShape shape;
    private final double density;
    private final double dragCoefficient;
    private final Vector3dc velocity;

    /*
     * WARNING - void declaration
     */
    private LiquidStateImpl(LiquidBlockShape shape, double density, double dragCoefficient, Vector3dc velocity) {
        void var2_2;
        void var1_1;
        this.shape = var1_1;
        this.density = var2_2;
        this.dragCoefficient = dragCoefficient;
        this.velocity = velocity;
    }

    @Override
    @JvmName(name="getShape")
    public final LiquidBlockShape getShape() {
        return this.shape;
    }

    @Override
    @JvmName(name="getDensity")
    public final double getDensity() {
        return this.density;
    }

    @Override
    @JvmName(name="getDragCoefficient")
    public final double getDragCoefficient() {
        return this.dragCoefficient;
    }

    @Override
    @JvmName(name="getVelocity")
    public final Vector3dc getVelocity() {
        return this.velocity;
    }

    public final String toString() {
        return "LiquidState(shape=" + this.getShape() + ", density=" + this.getDensity() + ", dragCoefficient=" + this.getDragCoefficient() + ", velocity=" + this.getVelocity() + ")";
    }

    public final LiquidBlockShape component1() {
        return this.shape;
    }

    public final double component2() {
        return this.density;
    }

    public final double component3() {
        return this.dragCoefficient;
    }

    public final Vector3dc component4() {
        return this.velocity;
    }

    /*
     * WARNING - void declaration
     */
    public final LiquidStateImpl copy(LiquidBlockShape shape, double density, double dragCoefficient, Vector3dc velocity) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shape, (String)"");
        Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
        return new LiquidStateImpl((LiquidBlockShape)var1_1, (double)var2_2, dragCoefficient, velocity);
    }

    public static /* synthetic */ LiquidStateImpl copy$default(LiquidStateImpl liquidStateImpl, LiquidBlockShape liquidBlockShape, double d2, double d3, Vector3dc vector3dc, int n2, Object object) {
        if ((n2 & 1) != 0) {
            liquidBlockShape = liquidStateImpl.shape;
        }
        if ((n2 & 2) != 0) {
            d2 = liquidStateImpl.density;
        }
        if ((n2 & 4) != 0) {
            d3 = liquidStateImpl.dragCoefficient;
        }
        if ((n2 & 8) != 0) {
            vector3dc = liquidStateImpl.velocity;
        }
        return liquidStateImpl.copy(liquidBlockShape, d2, d3, vector3dc);
    }

    public final int hashCode() {
        int n2 = this.shape.hashCode();
        n2 = n2 * 31 + Double.hashCode(this.density);
        n2 = n2 * 31 + Double.hashCode(this.dragCoefficient);
        n2 = n2 * 31 + this.velocity.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        LiquidStateImpl liquidStateImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof LiquidStateImpl)) {
            return false;
        }
        liquidStateImpl = liquidStateImpl;
        if (!Intrinsics.areEqual((Object)this.shape, (Object)liquidStateImpl.shape)) {
            return false;
        }
        if (Double.compare(this.density, liquidStateImpl.density) != 0) {
            return false;
        }
        if (Double.compare(this.dragCoefficient, liquidStateImpl.dragCoefficient) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.velocity, (Object)liquidStateImpl.velocity);
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ LiquidStateImpl(LiquidBlockShape shape, double density, double dragCoefficient, Vector3dc velocity, DefaultConstructorMarker $constructor_marker) {
        this((LiquidBlockShape)var1_1, (double)var2_2, dragCoefficient, velocity);
        void var2_2;
        void var1_1;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0016\u0010\u0011\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl$BuilderImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "Lorg/joml/primitives/AABBic;", "boundingBox", "boxShape", "(Lorg/joml/primitives/AABBic;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl$BuilderImpl;", "Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl;", "build", "()Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl;", "", "density", "(D)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl$BuilderImpl;", "dragCoefficient", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "shape", "(Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl$BuilderImpl;", "Lorg/joml/Vector3dc;", "velocity", "(Lorg/joml/Vector3dc;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/LiquidStateImpl$BuilderImpl;", "Ljava/lang/Double;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidBlockShape;", "Lorg/joml/Vector3d;", "Lorg/joml/Vector3d;", "<init>", "()V"})
    public static final class BuilderImpl
    implements LiquidState.Builder {
        private LiquidBlockShape shape;
        private Double density;
        private Double dragCoefficient;
        private Vector3d velocity = new Vector3d();

        @Inject
        public BuilderImpl() {
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl boxShape(AABBic boundingBox) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)boundingBox, (String)"");
            BuilderImpl builderImpl = this;
            InternalUtilsKt.require4bits("boundingBox", boundingBox);
            this.shape = new BoxBlockShapeImpl(new AABBi((AABBic)var1_1));
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl shape(LiquidBlockShape shape) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)shape, (String)"");
            BuilderImpl builderImpl = this;
            this.shape = var1_1;
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl density(double density) {
            void var1_1;
            BuilderImpl builderImpl = this;
            this.density = (double)var1_1;
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl dragCoefficient(double dragCoefficient) {
            void var1_1;
            BuilderImpl builderImpl = this;
            this.dragCoefficient = (double)var1_1;
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl velocity(Vector3dc velocity) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)velocity, (String)"");
            BuilderImpl builderImpl = this;
            this.velocity.set((Vector3dc)var1_1);
            return builderImpl;
        }

        @Override
        public final LiquidStateImpl build() {
            Object object = this.shape;
            Double d2 = this.density;
            Double d3 = this.dragCoefficient;
            if (object == null) {
                object = "shape must be set";
                throw new IllegalArgumentException(object.toString());
            }
            if (d2 == null) {
                object = "density must be set";
                throw new IllegalArgumentException(object.toString());
            }
            if (d3 == null) {
                object = "dragCoefficient must be set";
                throw new IllegalArgumentException(object.toString());
            }
            return new LiquidStateImpl((LiquidBlockShape)object, d2, d3, this.velocity, null);
        }
    }
}

