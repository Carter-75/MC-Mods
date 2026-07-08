/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2464
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.v2.internal.block;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2464;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017\u00a2\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0017\u00a2\u0006\u0004\b\u0010\u0010\u000fJ'\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017\u00a2\u0006\u0004\b\u0012\u0010\u0013J'\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0017\u00a2\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2={"Lg_mungus/vlib/v2/internal/block/GhostPlatformBlock;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_2464;", "getRenderShape", "(Lnet/minecraft/class_2680;)Lnet/minecraft/class_2464;", "Lnet/minecraft/class_1922;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_3726;", "context", "Lnet/minecraft/class_265;", "getCollisionShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "getShape", "level", "getInteractionShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;)Lnet/minecraft/class_265;", "reader", "getBlockSupportShape", "", "useShapeForLightOcclusion", "(Lnet/minecraft/class_2680;)Z", "isCollisionShapeFullBlock", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;)Z", "<init>", "()V", "vlib"})
public final class GhostPlatformBlock
extends class_2248 {
    public GhostPlatformBlock() {
        super(class_4970.class_2251.method_9637().method_9632(Float.MAX_VALUE).method_36558(Float.MAX_VALUE).method_45477().method_22488());
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_2464 method_9604(@NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return class_2464.field_11455;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_265 method_9549(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos, @NotNull class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_265 class_2652 = class_259.method_1073();
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"empty(...)");
        return class_2652;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos, @NotNull class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_265 class_2652 = class_259.method_1073();
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"empty(...)");
        return class_2652;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_265 method_9584(@NotNull class_2680 state, @NotNull class_1922 level, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        class_265 class_2652 = class_259.method_1073();
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"empty(...)");
        return class_2652;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_265 method_25959(@NotNull class_2680 state, @NotNull class_1922 reader, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)reader, (String)"reader");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        class_265 class_2652 = class_259.method_1077();
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"block(...)");
        return class_2652;
    }

    @Deprecated(message="Deprecated in Java")
    public boolean method_9526(@NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return true;
    }

    @Deprecated(message="Deprecated in Java")
    public boolean method_37403(@NotNull class_2680 state, @NotNull class_1922 level, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return true;
    }
}

