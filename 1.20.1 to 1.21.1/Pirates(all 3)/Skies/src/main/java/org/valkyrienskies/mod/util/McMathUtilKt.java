/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_238
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_238;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import org.joml.Vector3dc;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0002\u0010\u0003\"\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Lnet/minecraft/class_238;", "", "scale", "(Lnet/minecraft/class_238;D)Lnet/minecraft/class_238;", "Lorg/joml/Vector3dc;", "DEFAULT_WORLD_GRAVITY", "Lorg/joml/Vector3dc;", "getDEFAULT_WORLD_GRAVITY", "()Lorg/joml/Vector3dc;", "valkyrienskies-120"})
public final class McMathUtilKt {
    @NotNull
    private static final Vector3dc DEFAULT_WORLD_GRAVITY = new Vector3d(0.0, -10.0, 0.0);

    @NotNull
    public static final class_238 scale(@NotNull class_238 $this$scale, double scale) {
        Intrinsics.checkNotNullParameter((Object)$this$scale, (String)"<this>");
        double sizeX = $this$scale.method_17939() * scale / (double)2;
        double sizeY = $this$scale.method_17940() * scale / (double)2;
        double sizeZ = $this$scale.method_17941() * scale / (double)2;
        return new class_238($this$scale.method_1005().field_1352 - sizeX, $this$scale.method_1005().field_1351 - sizeY, $this$scale.method_1005().field_1350 - sizeZ, $this$scale.method_1005().field_1352 + sizeX, $this$scale.method_1005().field_1351 + sizeY, $this$scale.method_1005().field_1350 + sizeZ);
    }

    @NotNull
    public static final Vector3dc getDEFAULT_WORLD_GRAVITY() {
        return DEFAULT_WORLD_GRAVITY;
    }
}

