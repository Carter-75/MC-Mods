/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  net.minecraft.class_2487
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_2487;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/minecraft/class_2487;", "", "prefix", "Lorg/joml/Vector3dc;", "vector3d", "", "putVector3d", "(Lnet/minecraft/class_2487;Ljava/lang/String;Lorg/joml/Vector3dc;)V", "Lorg/joml/Vector3d;", "getVector3d", "(Lnet/minecraft/class_2487;Ljava/lang/String;)Lorg/joml/Vector3d;", "valkyrienskies-120"})
public final class NbtUtilKt {
    public static final void putVector3d(@NotNull class_2487 $this$putVector3d, @NotNull String prefix, @NotNull Vector3dc vector3d) {
        Intrinsics.checkNotNullParameter((Object)$this$putVector3d, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        Intrinsics.checkNotNullParameter((Object)vector3d, (String)"vector3d");
        Vector3dc $this$putVector3d_u24lambda_u240 = vector3d;
        boolean bl = false;
        $this$putVector3d.method_10549(prefix + "x", $this$putVector3d_u24lambda_u240.x());
        $this$putVector3d.method_10549(prefix + "y", $this$putVector3d_u24lambda_u240.y());
        $this$putVector3d.method_10549(prefix + "z", $this$putVector3d_u24lambda_u240.z());
    }

    @Nullable
    public static final Vector3d getVector3d(@NotNull class_2487 $this$getVector3d, @NotNull String prefix) {
        Intrinsics.checkNotNullParameter((Object)$this$getVector3d, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        return !StringsKt.contains$default((CharSequence)prefix, (CharSequence)(prefix + "x"), (boolean)false, (int)2, null) || !StringsKt.contains$default((CharSequence)prefix, (CharSequence)(prefix + "y"), (boolean)false, (int)2, null) || !StringsKt.contains$default((CharSequence)prefix, (CharSequence)(prefix + "z"), (boolean)false, (int)2, null) ? null : new Vector3d($this$getVector3d.method_10574(prefix + "x"), $this$getVector3d.method_10574(prefix + "y"), $this$getVector3d.method_10574(prefix + "z"));
    }
}

