/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.foundation.collision.Matrix3d
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.mod.compat;

import com.simibubi.create.foundation.collision.Matrix3d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.mixin.mod_compat.create.accessors.Matrix3dAccessor;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"Lcom/simibubi/create/foundation/collision/Matrix3d;", "Lorg/joml/Matrix3d;", "toJOML", "(Lcom/simibubi/create/foundation/collision/Matrix3d;)Lorg/joml/Matrix3d;", "valkyrienskies-120"})
public final class CreateConversionsKt {
    @NotNull
    public static final org.joml.Matrix3d toJOML(@NotNull Matrix3d $this$toJOML) {
        Intrinsics.checkNotNullParameter((Object)$this$toJOML, (String)"<this>");
        Matrix3dAccessor accessor = (Matrix3dAccessor)$this$toJOML;
        return new org.joml.Matrix3d(accessor.getM00(), accessor.getM01(), accessor.getM02(), accessor.getM10(), accessor.getM11(), accessor.getM12(), accessor.getM20(), accessor.getM21(), accessor.getM22());
    }
}

