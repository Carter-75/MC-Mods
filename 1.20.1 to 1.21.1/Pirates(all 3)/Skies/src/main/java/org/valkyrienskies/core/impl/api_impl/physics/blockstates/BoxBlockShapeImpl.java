/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.physics.blockstates;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.physics.blockstates.BoxBlockShape;
import org.valkyrienskies.core.impl.api_impl.physics.blockstates.InternalUtilsKt;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rH\u00d6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00028\u0017X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxBlockShapeImpl;", "Lorg/valkyrienskies/core/api/physics/blockstates/BoxBlockShape;", "Lorg/joml/primitives/AABBic;", "component1", "()Lorg/joml/primitives/AABBic;", "boundingBox", "copy", "(Lorg/joml/primitives/AABBic;)Lorg/valkyrienskies/core/impl/api_impl/physics/blockstates/BoxBlockShapeImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lorg/joml/primitives/AABBic;", "getBoundingBox", "<init>", "(Lorg/joml/primitives/AABBic;)V"})
public final class BoxBlockShapeImpl
implements BoxBlockShape {
    private final AABBic boundingBox;

    /*
     * WARNING - void declaration
     */
    public BoxBlockShapeImpl(AABBic boundingBox) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)boundingBox, (String)"");
        this.boundingBox = var1_1;
        InternalUtilsKt.require4bits("boundingBox", this.getBoundingBox());
    }

    @Override
    @JvmName(name="getBoundingBox")
    public final AABBic getBoundingBox() {
        return this.boundingBox;
    }

    public final AABBic component1() {
        return this.boundingBox;
    }

    /*
     * WARNING - void declaration
     */
    public final BoxBlockShapeImpl copy(AABBic boundingBox) {
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)boundingBox, (String)"");
        return new BoxBlockShapeImpl((AABBic)var1_1);
    }

    public static /* synthetic */ BoxBlockShapeImpl copy$default(BoxBlockShapeImpl boxBlockShapeImpl, AABBic aABBic, int n2, Object object) {
        if ((n2 & 1) != 0) {
            aABBic = boxBlockShapeImpl.boundingBox;
        }
        return boxBlockShapeImpl.copy(aABBic);
    }

    public final String toString() {
        return "BoxBlockShapeImpl(boundingBox=" + this.boundingBox + ")";
    }

    public final int hashCode() {
        return this.boundingBox.hashCode();
    }

    public final boolean equals(Object other) {
        BoxBlockShapeImpl boxBlockShapeImpl;
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxBlockShapeImpl)) {
            return false;
        }
        boxBlockShapeImpl = boxBlockShapeImpl;
        return Intrinsics.areEqual((Object)this.boundingBox, (Object)boxBlockShapeImpl.boundingBox);
    }
}

