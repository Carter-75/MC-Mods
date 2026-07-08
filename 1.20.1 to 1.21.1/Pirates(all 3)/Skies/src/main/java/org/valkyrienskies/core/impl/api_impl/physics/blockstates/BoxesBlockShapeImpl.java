/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.apache.logging.log4j.Logger;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.CollisionPoint;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.InternalUtilsKt;
import org.valkyrienskies.core.impl.shadow.FX;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001cB;\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u000f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0015R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u000f8\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lorg/joml/primitives/AABBic;", "boundingBox", "Lorg/joml/primitives/AABBic;", "getBoundingBox", "()Lorg/joml/primitives/AABBic;", "", "Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "collisionPoints", "Ljava/util/Collection;", "getCollisionPoints", "()Ljava/util/Collection;", "I", "negativeBoxes", "getNegativeBoxes", "positiveBoxes", "getPositiveBoxes", "<init>", "(Lorg/joml/primitives/AABBic;Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;)V", "BuilderImpl"})
public final class BoxesBlockShapeImpl
implements BoxesBlockShape {
    private final AABBic boundingBox;
    private final Collection<AABBic> positiveBoxes;
    private final Collection<AABBic> negativeBoxes;
    private final Collection<CollisionPoint> collisionPoints;
    private final int hashCode;

    /*
     * WARNING - void declaration
     */
    private BoxesBlockShapeImpl(AABBic boundingBox, Collection<? extends AABBic> positiveBoxes, Collection<? extends AABBic> negativeBoxes, Collection<CollisionPoint> collisionPoints) {
        int n2;
        BoxesBlockShapeImpl boxesBlockShapeImpl;
        void var2_3;
        BoxesBlockShapeImpl boxesBlockShapeImpl2;
        this.boundingBox = boxesBlockShapeImpl2;
        this.positiveBoxes = var2_3;
        this.negativeBoxes = boxesBlockShapeImpl;
        this.collisionPoints = collisionPoints;
        boxesBlockShapeImpl = boxesBlockShapeImpl2 = this;
        int n3 = boxesBlockShapeImpl2.getBoundingBox().hashCode();
        n3 = n3 * 31 + ((Object)boxesBlockShapeImpl2.getPositiveBoxes()).hashCode();
        n3 = n3 * 31 + ((Object)boxesBlockShapeImpl2.getNegativeBoxes()).hashCode();
        boxesBlockShapeImpl.hashCode = n2 = (n3 = n3 * 31 + ((Object)boxesBlockShapeImpl2.getCollisionPoints()).hashCode());
    }

    @Override
    @JvmName(name="getBoundingBox")
    public final AABBic getBoundingBox() {
        return this.boundingBox;
    }

    @Override
    @JvmName(name="getPositiveBoxes")
    public final Collection<AABBic> getPositiveBoxes() {
        return this.positiveBoxes;
    }

    @Override
    @JvmName(name="getNegativeBoxes")
    public final Collection<AABBic> getNegativeBoxes() {
        return this.negativeBoxes;
    }

    @Override
    @JvmName(name="getCollisionPoints")
    public final Collection<CollisionPoint> getCollisionPoints() {
        return this.collisionPoints;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean equals(Object other) {
        void var1_1;
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxesBlockShapeImpl)) {
            return false;
        }
        if (!Intrinsics.areEqual((Object)this.getBoundingBox(), (Object)((BoxesBlockShapeImpl)other).getBoundingBox())) {
            return false;
        }
        if (!Intrinsics.areEqual(this.getPositiveBoxes(), ((BoxesBlockShapeImpl)other).getPositiveBoxes())) {
            return false;
        }
        if (!Intrinsics.areEqual(this.getNegativeBoxes(), ((BoxesBlockShapeImpl)other).getNegativeBoxes())) {
            return false;
        }
        return Intrinsics.areEqual(this.getCollisionPoints(), ((BoxesBlockShapeImpl)var1_1).getCollisionPoints());
    }

    public final int hashCode() {
        return this.hashCode;
    }

    /*
     * WARNING - void declaration
     */
    public /* synthetic */ BoxesBlockShapeImpl(AABBic boundingBox, Collection positiveBoxes, Collection negativeBoxes, Collection collisionPoints, DefaultConstructorMarker $constructor_marker) {
        this((AABBic)var1_1, (Collection<? extends AABBic>)var2_2, (Collection<? extends AABBic>)var3_3, collisionPoints);
        void var3_3;
        void var2_2;
        void var1_1;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\t\b\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0007\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl$BuilderImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "", "x", "y", "z", "radius", "addCollisionPoint", "(FFFF)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl$BuilderImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;", "point", "(Lorg/valkyrienskies/core/api/physics/blockstates/CollisionPoint;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl$BuilderImpl;", "Lorg/joml/primitives/AABBic;", "box", "addNegativeBox", "(Lorg/joml/primitives/AABBic;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl$BuilderImpl;", "addPositiveBox", "Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl;", "build", "()Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl;", "", "toString", "()Ljava/lang/String;", "", "collisionPoints", "Ljava/util/List;", "negativeBoxes", "positiveBoxes", "<init>", "()V", "Companion"})
    public static final class BuilderImpl
    implements BoxesBlockShape.Builder {
        public static final Companion Companion = new Companion(null);
        private final List<AABBic> positiveBoxes = new ArrayList();
        private final List<AABBic> negativeBoxes = new ArrayList();
        private final List<CollisionPoint> collisionPoints = new ArrayList();
        private static final Logger logger$delegate = FX.a("BoxesBlockShape.Builder");

        @Inject
        public BuilderImpl() {
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl addPositiveBox(AABBic box) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)box, (String)"");
            BuilderImpl builderImpl = this;
            InternalUtilsKt.require4bits("box", box);
            this.positiveBoxes.add((AABBic)var1_1);
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl addNegativeBox(AABBic box) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)box, (String)"");
            BuilderImpl builderImpl = this;
            InternalUtilsKt.require4bits("box", box);
            this.negativeBoxes.add((AABBic)var1_1);
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl addCollisionPoint(CollisionPoint point) {
            void var1_1;
            Intrinsics.checkNotNullParameter((Object)point, (String)"");
            BuilderImpl builderImpl = this;
            this.collisionPoints.add((CollisionPoint)var1_1);
            return builderImpl;
        }

        /*
         * WARNING - void declaration
         */
        @Override
        public final BuilderImpl addCollisionPoint(float x, float y, float z, float radius) {
            void var3_3;
            void var2_2;
            void var1_1;
            BuilderImpl builderImpl = this;
            this.collisionPoints.add(new CollisionPoint((float)var1_1, (float)var2_2, (float)var3_3, radius));
            return builderImpl;
        }

        @Override
        public final BoxesBlockShapeImpl build() {
            Object object;
            Object object2;
            if (this.positiveBoxes.isEmpty() != this.collisionPoints.isEmpty()) {
                throw new IllegalArgumentException("there are positive boxes but no collision points, or vice versa for " + this);
            }
            for (AABBic object32 : this.positiveBoxes) {
                Object v0;
                block4: {
                    object2 = this.negativeBoxes;
                    Iterator iterator2 = object2.iterator();
                    while (iterator2.hasNext()) {
                        Object t = iterator2.next();
                        object2 = (AABBic)t;
                        if (!object32.intersectsAABB((AABBic)object2)) continue;
                        v0 = t;
                        break block4;
                    }
                    v0 = null;
                }
                if ((object2 = (AABBic)v0) == null) continue;
            }
            Iterable iterable = this.positiveBoxes;
            object2 = new AABBi(0, 0, 0, 0, 0, 0);
            for (Object t : iterable) {
                Object object3 = object2;
                object2 = (AABBic)t;
                object = object3;
                AABBi aABBi = ((AABBi)object3).union((AABBic)object2);
                Intrinsics.checkNotNullExpressionValue((Object)aABBi, (String)"");
                object2 = aABBi;
            }
            object = object2;
            return new BoxesBlockShapeImpl((AABBic)object, this.positiveBoxes, this.negativeBoxes, CollectionsKt.toList((Iterable)this.collisionPoints), null);
        }

        public final String toString() {
            return "BoxesBlockShape.Builder(positiveBoxes=" + this.positiveBoxes + ", negativeBoxes=" + this.negativeBoxes + ", collisionPoints=" + this.collisionPoints + ")";
        }

        @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028GX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxesBlockShapeImpl$BuilderImpl$Companion;", "", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>", "()V"})
        public static final class Companion {
            static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

            private Companion() {
            }

            @JvmName(name="getLogger")
            public final Logger getLogger() {
                KProperty<Object> kProperty = $$delegatedProperties[0];
                Logger logger = logger$delegate;
                Intrinsics.checkNotNullParameter(kProperty, (String)"");
                return logger;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            static {
                KProperty[] kPropertyArray = new KProperty[1];
                KProperty[] kPropertyArray2 = kPropertyArray;
                kPropertyArray[0] = Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(Companion.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)));
                $$delegatedProperties = kPropertyArray2;
            }
        }
    }
}

