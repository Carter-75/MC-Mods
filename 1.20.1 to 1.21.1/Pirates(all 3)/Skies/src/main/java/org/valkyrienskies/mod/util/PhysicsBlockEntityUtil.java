/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 */
package org.valkyrienskies.mod.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.api.BlockEntityPhysicsListener;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ)\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2={"Lorg/valkyrienskies/mod/util/PhysicsBlockEntityUtil;", "", "Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;", "listener", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_1937;", "level", "", "reason", "", "onLoad", "(Lorg/valkyrienskies/mod/api/BlockEntityPhysicsListener;Lnet/minecraft/class_2338;Lnet/minecraft/class_1937;Ljava/lang/String;)V", "onRemove", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_1937;Ljava/lang/String;)V", "<init>", "()V", "valkyrienskies-120"})
public final class PhysicsBlockEntityUtil {
    @NotNull
    public static final PhysicsBlockEntityUtil INSTANCE = new PhysicsBlockEntityUtil();

    private PhysicsBlockEntityUtil() {
    }

    @JvmStatic
    public static final void onLoad(@NotNull BlockEntityPhysicsListener listener, @NotNull class_2338 pos, @NotNull class_1937 level, @NotNull String reason) {
        Intrinsics.checkNotNullParameter((Object)listener, (String)"listener");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        ValkyrienSkiesMod.INSTANCE.addBlockEntityPhysTicker(VSGameUtilsKt.getDimensionId(level), pos, listener);
    }

    public static /* synthetic */ void onLoad$default(BlockEntityPhysicsListener blockEntityPhysicsListener, class_2338 class_23382, class_1937 class_19372, String string, int n2, Object object) {
        if ((n2 & 8) != 0) {
            string = "";
        }
        PhysicsBlockEntityUtil.onLoad(blockEntityPhysicsListener, class_23382, class_19372, string);
    }

    @JvmStatic
    public static final void onRemove(@NotNull class_2338 pos, @NotNull class_1937 level, @NotNull String reason) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)reason, (String)"reason");
        ValkyrienSkiesMod.INSTANCE.removeBlockEntityPhysTicker(pos, VSGameUtilsKt.getDimensionId(level));
    }

    public static /* synthetic */ void onRemove$default(class_2338 class_23382, class_1937 class_19372, String string, int n2, Object object) {
        if ((n2 & 4) != 0) {
            string = "";
        }
        PhysicsBlockEntityUtil.onRemove(class_23382, class_19372, string);
    }
}

