/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2350
 *  net.minecraft.class_247
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2350;
import net.minecraft.class_247;
import net.minecraft.class_259;
import net.minecraft.class_265;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\u0019\u0010\b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\n\u00a8\u0006\u000b"}, d2={"Ldev/mim1q/derelict/util/ShapeUtil;", "", "<init>", "()V", "Lnet/minecraft/class_265;", "Lnet/minecraft/class_2350;", "from", "to", "rotate", "(Lnet/minecraft/class_265;Lnet/minecraft/class_2350;Lnet/minecraft/class_2350;)Lnet/minecraft/class_265;", "(Lnet/minecraft/class_265;Lnet/minecraft/class_2350;)Lnet/minecraft/class_265;", "derelict"})
public final class ShapeUtil {
    @NotNull
    public static final ShapeUtil INSTANCE = new ShapeUtil();

    private ShapeUtil() {
    }

    @NotNull
    public final class_265 rotate(@NotNull class_265 $this$rotate, @NotNull class_2350 from, @NotNull class_2350 to) {
        Intrinsics.checkNotNullParameter((Object)$this$rotate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)from, (String)"from");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        class_265[] class_265Array = new class_265[]{$this$rotate, class_259.method_1073()};
        class_265[] buffer = class_265Array;
        int times = (to.method_10161() - from.method_10161() + 4) % 4;
        for (int i = 0; i < times; ++i) {
            buffer[0].method_1089((arg_0, arg_1, arg_2, arg_3, arg_4, arg_5) -> ShapeUtil.rotate$lambda$0(buffer, arg_0, arg_1, arg_2, arg_3, arg_4, arg_5));
            buffer[0] = buffer[1];
            buffer[1] = class_259.method_1073();
        }
        class_265 class_2652 = buffer[0];
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"get(...)");
        return class_2652;
    }

    @NotNull
    public final class_265 rotate(@NotNull class_265 $this$rotate, @NotNull class_2350 to) {
        Intrinsics.checkNotNullParameter((Object)$this$rotate, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)to, (String)"to");
        return this.rotate($this$rotate, class_2350.field_11043, to);
    }

    private static final void rotate$lambda$0(class_265[] $buffer, double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        Intrinsics.checkNotNullParameter((Object)$buffer, (String)"$buffer");
        $buffer[1] = class_259.method_1082((class_265)$buffer[1], (class_265)class_259.method_1081((double)(1.0 - maxZ), (double)minY, (double)minX, (double)(1.0 - minZ), (double)maxY, (double)maxX), (class_247)class_247.field_1366);
    }
}

