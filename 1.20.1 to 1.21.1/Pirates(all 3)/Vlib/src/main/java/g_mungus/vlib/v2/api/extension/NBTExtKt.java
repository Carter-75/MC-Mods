/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2487
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package g_mungus.vlib.v2.api.extension;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2487;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2={"Lnet/minecraft/class_2487;", "", "prefix", "Lnet/minecraft/class_2382;", "vec", "", "putVec3i", "(Lnet/minecraft/class_2487;Ljava/lang/String;Lnet/minecraft/class_2382;)V", "Lnet/minecraft/class_2338;", "getVec3i", "(Lnet/minecraft/class_2487;Ljava/lang/String;)Lnet/minecraft/class_2338;", "vlib"})
public final class NBTExtKt {
    public static final void putVec3i(@NotNull class_2487 $this$putVec3i, @NotNull String prefix, @NotNull class_2382 vec) {
        Intrinsics.checkNotNullParameter((Object)$this$putVec3i, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        Intrinsics.checkNotNullParameter((Object)vec, (String)"vec");
        class_2382 $this$putVec3i_u24lambda_u240 = vec;
        boolean bl = false;
        $this$putVec3i.method_10569(prefix + "x", $this$putVec3i_u24lambda_u240.method_10263());
        $this$putVec3i.method_10569(prefix + "y", $this$putVec3i_u24lambda_u240.method_10264());
        $this$putVec3i.method_10569(prefix + "z", $this$putVec3i_u24lambda_u240.method_10260());
    }

    @Nullable
    public static final class_2338 getVec3i(@NotNull class_2487 $this$getVec3i, @NotNull String prefix) {
        Intrinsics.checkNotNullParameter((Object)$this$getVec3i, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)prefix, (String)"prefix");
        return !$this$getVec3i.method_10545(prefix + "x") || !$this$getVec3i.method_10545(prefix + "y") || !$this$getVec3i.method_10545(prefix + "z") ? null : new class_2338($this$getVec3i.method_10550(prefix + "x"), $this$getVec3i.method_10550(prefix + "y"), $this$getVec3i.method_10550(prefix + "z"));
    }
}

