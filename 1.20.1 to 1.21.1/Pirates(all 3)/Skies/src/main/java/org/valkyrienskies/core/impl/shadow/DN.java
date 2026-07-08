/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Vector3d;
import org.joml.primitives.AABBi;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.BoxesBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.CollisionPoint;
import org.valkyrienskies.core.api.physics.blockstates.LiquidState;
import org.valkyrienskies.core.api.physics.blockstates.SolidBlockShape;
import org.valkyrienskies.core.api.physics.blockstates.SolidState;
import org.valkyrienskies.core.impl.shadow.CP;
import org.valkyrienskies.core.impl.shadow.DM;
import org.valkyrienskies.core.internal.physics.blockstates.VsiBlockState;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockType;
import org.valkyrienskies.core.internal.world.chunks.VsiBlockTypes;

@Singleton
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB;\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001c\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u0002000-\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002020-\u00a2\u0006\u0004\b4\u00105J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\"\u0010\u0015\u001a\u00020\u00028\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\f\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00048\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\f\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u001c8\u0007\u00a2\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\f\u0010\u001eR\"\u0010 \u001a\u00020\u00028\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\u001b\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00048\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b\u001b\u0010\u001aR\"\u0010%\u001a\u00020\u00028\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b$\u0010\u0013\"\u0004\b\u0015\u0010\u0014R\"\u0010(\u001a\u00020\u00048\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b&\u0010\u0017\u001a\u0004\b'\u0010\u0019\"\u0004\b\u0015\u0010\u001aR\"\u0010&\u001a\u00020\u00028\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b)\u0010\u0013\"\u0004\b\u000e\u0010\u0014R\"\u0010\"\u001a\u00020\u00048\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b%\u0010\u0017\u001a\u0004\b*\u0010\u0019\"\u0004\b\u000e\u0010\u001aR\"\u0010\n\u001a\u00020\u00028\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b+\u0010\u0013\"\u0004\b\u0010\u0010\u0014R\"\u0010\r\u001a\u00020\u00048\u0017@\u0017X\u0096.\u00a2\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b,\u0010\u0019\"\u0004\b\u0010\u0010\u001a"}, d2={"Lorg/valkyrienskies/core/impl/shadow/DN;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockTypes;", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "p0", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "getState", "(Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;)Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "getType", "(Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;)Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "", "m", "D", "a", "n", "b", "o", "c", "Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "getAir", "()Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;", "(Lorg/valkyrienskies/core/internal/world/chunks/VsiBlockType;)V", "d", "h", "Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "getAirState", "()Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;", "(Lorg/valkyrienskies/core/internal/physics/blockstates/VsiBlockState;)V", "e", "Lorg/valkyrienskies/core/impl/shadow/CP;", "Lorg/valkyrienskies/core/impl/shadow/CP;", "()Lorg/valkyrienskies/core/impl/shadow/CP;", "f", "g", "getEmpty", "l", "getEmptyState", "getLava", "i", "k", "getLavaState", "j", "getSolid", "getSolidState", "getWater", "getWaterState", "Ljavax/inject/Provider;", "Lorg/valkyrienskies/core/api/physics/blockstates/LiquidState$Builder;", "p1", "Lorg/valkyrienskies/core/api/physics/blockstates/SolidState$Builder;", "p2", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxesBlockShape$Builder;", "p3", "<init>", "(Lorg/valkyrienskies/core/impl/shadow/CP;Ljavax/inject/Provider;Ljavax/inject/Provider;Ljavax/inject/Provider;)V"})
public final class DN
implements VsiBlockTypes {
    public static final a a = new a(null);
    public final CP b;
    private VsiBlockType c;
    private VsiBlockType d;
    private VsiBlockType e;
    private VsiBlockType f;
    private VsiBlockType g;
    private VsiBlockState h;
    private VsiBlockState i;
    private VsiBlockState j;
    private VsiBlockState k;
    private VsiBlockState l;
    private final double m;
    private final double n;
    private final double o;
    private static int p = 0;
    private static int q = 1;
    private static int r = 2;

    @Inject
    public DN(CP object, Provider<LiquidState.Builder> object2, Provider<SolidState.Builder> object3, Provider<BoxesBlockShape.Builder> object4) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        Intrinsics.checkNotNullParameter(object2, (String)"");
        Intrinsics.checkNotNullParameter(object3, (String)"");
        Intrinsics.checkNotNullParameter(object4, (String)"");
        this.b = object;
        this.m = 0.3;
        this.n = 0.5;
        this.o = 1.0;
        object = new AABBi(0, 0, 0, 15, 15, 15);
        Object[] objectArray = new CollisionPoint[8];
        Object object5 = objectArray;
        objectArray[0] = new CollisionPoint(0.25f, 0.25f, 0.25f, 0.25f);
        object5[1] = new CollisionPoint(0.25f, 0.25f, 0.75f, 0.25f);
        object5[2] = new CollisionPoint(0.25f, 0.75f, 0.25f, 0.25f);
        object5[3] = new CollisionPoint(0.25f, 0.75f, 0.75f, 0.25f);
        object5[4] = new CollisionPoint(0.75f, 0.25f, 0.25f, 0.25f);
        object5[5] = new CollisionPoint(0.75f, 0.25f, 0.75f, 0.25f);
        object5[6] = new CollisionPoint(0.75f, 0.75f, 0.25f, 0.25f);
        object5[7] = new CollisionPoint(0.75f, 0.75f, 0.75f, 0.25f);
        object5 = CollectionsKt.listOf((Object[])object5);
        object5 = object4.get().addCollisionPoints((Iterable)object5).addPositiveBox((AABBic)object).build();
        object4 = object4.get().addCollisionPoints(CollectionsKt.emptyList()).addNegativeBox((AABBic)object).build();
        object5 = object3.get().shape((SolidBlockShape)object5).elasticity(this.m).friction(this.n).hardness(this.o).build();
        LiquidState liquidState = object2.get().boxShape((AABBic)object).density(100.0).dragCoefficient(0.3).velocity(new Vector3d()).build();
        object = object2.get().boxShape((AABBic)object).density(1000.0).dragCoefficient(1.0).velocity(new Vector3d()).build();
        object2 = object3.get().shape((SolidBlockShape)object4).elasticity(this.m).friction(this.n).hardness(this.o).build();
        object4 = new DM(0);
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).c = object4;
        object4 = new VsiBlockState(null, null);
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).h = object4;
        object4 = new VsiBlockState((SolidState)object5, null);
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).i = object4;
        object4 = new DM(this.b.b(this.getSolidState()));
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).d = object4;
        object4 = new VsiBlockState(null, liquidState);
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).j = object4;
        object4 = new DM(this.b.b(this.getWaterState()));
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).e = object4;
        object4 = new VsiBlockState(null, (LiquidState)object);
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).k = object4;
        object4 = new DM(this.b.b(this.getLavaState()));
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).f = object4;
        object4 = new VsiBlockState((SolidState)object2, null);
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).l = object4;
        object4 = new DM(this.b.b(this.getEmptyState()));
        object3 = this;
        Intrinsics.checkNotNullParameter((Object)object4, (String)"");
        ((DN)object3).g = object4;
    }

    @JvmName(name="a")
    public final CP a() {
        return this.b;
    }

    @Override
    @JvmName(name="getAir")
    public final VsiBlockType getAir() {
        VsiBlockType vsiBlockType = this.c;
        if (vsiBlockType != null) {
            return vsiBlockType;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="a")
    private void a(VsiBlockType vsiBlockType) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockType, (String)"");
        this.c = vsiBlockType;
    }

    @Override
    @JvmName(name="getSolid")
    public final VsiBlockType getSolid() {
        VsiBlockType vsiBlockType = this.d;
        if (vsiBlockType != null) {
            return vsiBlockType;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="b")
    private void b(VsiBlockType vsiBlockType) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockType, (String)"");
        this.d = vsiBlockType;
    }

    @Override
    @JvmName(name="getWater")
    public final VsiBlockType getWater() {
        VsiBlockType vsiBlockType = this.e;
        if (vsiBlockType != null) {
            return vsiBlockType;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="c")
    private void c(VsiBlockType vsiBlockType) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockType, (String)"");
        this.e = vsiBlockType;
    }

    @Override
    @JvmName(name="getLava")
    public final VsiBlockType getLava() {
        VsiBlockType vsiBlockType = this.f;
        if (vsiBlockType != null) {
            return vsiBlockType;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="d")
    private void d(VsiBlockType vsiBlockType) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockType, (String)"");
        this.f = vsiBlockType;
    }

    @Override
    @JvmName(name="getEmpty")
    public final VsiBlockType getEmpty() {
        VsiBlockType vsiBlockType = this.g;
        if (vsiBlockType != null) {
            return vsiBlockType;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="e")
    private void e(VsiBlockType vsiBlockType) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockType, (String)"");
        this.g = vsiBlockType;
    }

    @Override
    @JvmName(name="getAirState")
    public final VsiBlockState getAirState() {
        VsiBlockState vsiBlockState = this.h;
        if (vsiBlockState != null) {
            return vsiBlockState;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="a")
    private void a(VsiBlockState vsiBlockState) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        this.h = vsiBlockState;
    }

    @Override
    @JvmName(name="getSolidState")
    public final VsiBlockState getSolidState() {
        VsiBlockState vsiBlockState = this.i;
        if (vsiBlockState != null) {
            return vsiBlockState;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="b")
    private void b(VsiBlockState vsiBlockState) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        this.i = vsiBlockState;
    }

    @Override
    @JvmName(name="getWaterState")
    public final VsiBlockState getWaterState() {
        VsiBlockState vsiBlockState = this.j;
        if (vsiBlockState != null) {
            return vsiBlockState;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="c")
    private void c(VsiBlockState vsiBlockState) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        this.j = vsiBlockState;
    }

    @Override
    @JvmName(name="getLavaState")
    public final VsiBlockState getLavaState() {
        VsiBlockState vsiBlockState = this.k;
        if (vsiBlockState != null) {
            return vsiBlockState;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="d")
    private void d(VsiBlockState vsiBlockState) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        this.k = vsiBlockState;
    }

    @Override
    @JvmName(name="getEmptyState")
    public final VsiBlockState getEmptyState() {
        VsiBlockState vsiBlockState = this.l;
        if (vsiBlockState != null) {
            return vsiBlockState;
        }
        Intrinsics.throwUninitializedPropertyAccessException((String)"");
        return null;
    }

    @JvmName(name="e")
    private void e(VsiBlockState vsiBlockState) {
        Intrinsics.checkNotNullParameter((Object)vsiBlockState, (String)"");
        this.l = vsiBlockState;
    }

    @Override
    public final VsiBlockType getType(VsiBlockState state) {
        CP cP;
        Intrinsics.checkNotNullParameter((Object)state, (String)"");
        void var2_3 = cP;
        cP = this.b;
        Intrinsics.checkNotNullParameter((Object)var2_3, (String)"");
        int n2 = cP.c.getInt((Object)var2_3);
        if (n2 < 0) {
            return null;
        }
        return new DM(n2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final VsiBlockState getState(VsiBlockType type) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)type, (String)"");
        Object object = (DM)var1_1;
        int n2 = ((DM)object).a;
        object = this.b;
        return (VsiBlockState)((CP)object).d.get(n2);
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/DN$a;", "", "", "p", "I", "a", "q", "b", "r", "c", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

