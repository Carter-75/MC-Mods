/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_8176
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/init/NoZFightingOffsetter;", "Lnet/minecraft/class_4970$class_8176;", "<init>", "()V", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1922;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_243;", "evaluate", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;)Lnet/minecraft/class_243;", "derelict"})
public final class NoZFightingOffsetter
implements class_4970.class_8176 {
    @NotNull
    public static final NoZFightingOffsetter INSTANCE = new NoZFightingOffsetter();

    private NoZFightingOffsetter() {
    }

    @NotNull
    public class_243 evaluate(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        int x = pos.method_10263() % 3;
        int y = pos.method_10264() % 3;
        int z = pos.method_10260() % 3;
        return new class_243((double)z * 0.001 + (double)y * 0.0015, (double)x * 0.001 + (double)z * 0.0015, (double)y * 0.001 + (double)x * 0.0015);
    }
}

