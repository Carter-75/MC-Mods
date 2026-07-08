/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.SolidBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001#B)\b\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007H\u00c6\u0003\u00a2\u0006\u0004\b\b\u0010\tJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0007H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015H\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018H\u00d6\u0001\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00078\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u001f\u001a\u0004\b \u0010\t"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState;", "", "component1", "()D", "component2", "component3", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "component4", "()Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "elasticity", "friction", "hardness", "shape", "copy", "(DDDLorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "D", "getElasticity", "getFriction", "getHardness", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "getShape", "<init>", "(DDDLorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;)V", "BuilderImpl"})
public final class SolidStateImpl
implements SolidState {
    private final double elasticity;
    private final double friction;
    private final double hardness;
    private final SolidBlockShape shape;

    /*
     * WARNING - void declaration
     */
    private SolidStateImpl(double elasticity, double friction, double hardness, SolidBlockShape shape) {
        void var3_2;
        void var1_1;
        this.elasticity = var1_1;
        this.friction = var3_2;
        this.hardness = hardness;
        this.shape = shape;
    }

    @Override
    @JvmName(name="getElasticity")
    public final double getElasticity() {
        return this.elasticity;
    }

    @Override
    @JvmName(name="getFriction")
    public final double getFriction() {
        return this.friction;
    }

    @Override
    @JvmName(name="getHardness")
    public final double getHardness() {
        return this.hardness;
    }

    @Override
    @JvmName(name="getShape")
    public final SolidBlockShape getShape() {
        return this.shape;
    }

    public final double component1() {
        return this.elasticity;
    }

    public final double component2() {
        return this.friction;
    }

    public final double component3() {
        return this.hardness;
    }

    public final SolidBlockShape component4() {
        return this.shape;
    }

    /*
     * WARNING - void declaration
     */
    public final SolidStateImpl copy(double elasticity, double friction, double hardness, SolidBlockShape shape) {
        void var3_2;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)shape, (String)"");
        return new SolidStateImpl((double)var1_1, (double)var3_2, hardness, shape);
    }

    public static /* synthetic */ SolidStateImpl copy$default(SolidStateImpl solidStateImpl, double d2, double d3, double d4, SolidBlockShape solidBlockShape, int n2, Object object) {
        if ((n2 & 1) != 0) {
            d2 = solidStateImpl.elasticity;
        }
        if ((n2 & 2) != 0) {
            d3 = solidStateImpl.friction;
        }
        if ((n2 & 4) != 0) {
            d4 = solidStateImpl.hardness;
        }
        if ((n2 & 8) != 0) {
            solidBlockShape = solidStateImpl.shape;
        }
        return solidStateImpl.copy(d2, d3, d4, solidBlockShape);
    }

    public final String toString() {
        return "SolidStateImpl(elasticity=" + this.elasticity + ", friction=" + this.friction + ", hardness=" + this.hardness + ", shape=" + this.shape + ")";
    }

    public final int hashCode() {
        int n2 = Double.hashCode(this.elasticity);
        n2 = n2 * 31 + Double.hashCode(this.friction);
        n2 = n2 * 31 + Double.hashCode(this.hardness);
        n2 = n2 * 31 + this.shape.hashCode();
        return n2;
    }

    public final boolean equals(Object other) {
        SolidStateImpl solidStateImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof SolidStateImpl)) {
            return false;
        }
        solidStateImpl = solidStateImpl;
        if (Double.compare(this.elasticity, solidStateImpl.elasticity) != 0) {
            return false;
        }
        if (Double.compare(this.friction, solidStateImpl.friction) != 0) {
            return false;
        }
        if (Double.compare(this.hardness, solidStateImpl.hardness) != 0) {
            return false;
        }
        return Intrinsics.areEqual((Object)this.shape, (Object)solidStateImpl.shape);
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ SolidStateImpl(double elasticity, double friction, double hardness, SolidBlockShape shape, DefaultConstructorMarker $constructor_marker) {
        this((double)var1_2, (double)var3_3, hardness, shape);
        void var3_3;
        void var1_2;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\u0007\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u00a2\u0006\u0002\b\u0005H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl$BuilderImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "Lkotlin/Function1;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "", "Lkotlin/ExtensionFunctionType;", "shapeBuilder", "boxesShape", "(Lkotlin/jvm/functions/Function1;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl$BuilderImpl;", "Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl;", "build", "()Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl;", "", "elasticity", "(D)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl$BuilderImpl;", "friction", "hardness", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "shape", "(Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/SolidStateImpl$BuilderImpl;", "Ljava/lang/Double;", "Ljavax/inject/Provider;", "newBoxesBlockShapeBuilder", "Ljavax/inject/Provider;", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidBlockShape;", "<init>", "(Ljavax/inject/Provider;)V"})
    public static final class BuilderImpl
    implements SolidState.Builder {
        private final Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilder;
        private Double elasticity;
        private Double friction;
        private Double hardness;
        private SolidBlockShape shape;

        /*
         * WARNING - void declaration
         */
        @Inject
        public BuilderImpl(Provider<BoxesBlockShape.Builder> newBoxesBlockShapeBuilder) {
            void var1_1;
            Intrinsics.checkNotNullParameter(newBoxesBlockShapeBuilder, (String)"");
            this.newBoxesBlockShapeBuilder = var1_1;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl elasticity(double elasticity) {
            void var1_1;
            BuilderImpl builderImpl = this;
            this.elasticity = (double)var1_1;
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl friction(double friction) {
            void var1_1;
            BuilderImpl builderImpl = this;
            this.friction = (double)var1_1;
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl hardness(double hardness) {
            void var1_1;
            BuilderImpl builderImpl = this;
            this.hardness = (double)var1_1;
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl shape(SolidBlockShape shape) {
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
        public final BuilderImpl boxesShape(Function1<? super BoxesBlockShape.Builder, Unit> shapeBuilder) {
            void var1_1;
            Intrinsics.checkNotNullParameter(shapeBuilder, (String)"");
            BuilderImpl builderImpl = this;
            BoxesBlockShape.Builder builder = this.newBoxesBlockShapeBuilder.get();
            var1_1.invoke((Object)builder);
            this.shape = builder.build();
            return builderImpl;
        }

        @Override
        public final SolidStateImpl build() {
            Double d2 = this.elasticity;
            if (d2 == null) {
                String string = "elasticity must be set";
                throw new IllegalArgumentException(string.toString());
            }
            double d3 = ((Number)d2).doubleValue();
            Double d4 = this.friction;
            if (d4 == null) {
                String string = "friction must be set";
                throw new IllegalArgumentException(string.toString());
            }
            double d5 = ((Number)d4).doubleValue();
            Double d6 = this.hardness;
            if (d6 == null) {
                String string = "hardness must be set";
                throw new IllegalArgumentException(string.toString());
            }
            double d7 = ((Number)d6).doubleValue();
            SolidBlockShape solidBlockShape = this.shape;
            if (solidBlockShape == null) {
                String string = "shape must be set";
                throw new IllegalArgumentException(string.toString());
            }
            SolidBlockShape solidBlockShape2 = solidBlockShape;
            return new SolidStateImpl(d3, d5, d7, solidBlockShape2, null);
        }
    }
}

