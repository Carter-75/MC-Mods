/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2338
 *  net.minecraft.class_2533
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_8177
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.metal.oxidizable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2338;
import net.minecraft.class_2533;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_8177;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001b\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/block/metal/oxidizable/OxidizableTrapdoorBlock;", "Lnet/minecraft/class_2533;", "Lnet/minecraft/class_5955;", "Lnet/minecraft/class_5955$class_5811;", "level", "Lnet/minecraft/class_4970$class_2251;", "settings", "Lnet/minecraft/class_8177;", "type", "<init>", "(Lnet/minecraft/class_5955$class_5811;Lnet/minecraft/class_4970$class_2251;Lnet/minecraft/class_8177;)V", "getDegradationLevel", "()Lnet/minecraft/class_5955$class_5811;", "Lnet/minecraft/class_2680;", "state", "", "hasRandomTicks", "(Lnet/minecraft/class_2680;)Z", "Lnet/minecraft/class_3218;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_5819;", "random", "", "randomTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "Lnet/minecraft/class_5955$class_5811;", "derelict"})
public final class OxidizableTrapdoorBlock
extends class_2533
implements class_5955 {
    @NotNull
    private final class_5955.class_5811 level;

    public OxidizableTrapdoorBlock(@NotNull class_5955.class_5811 level, @NotNull class_4970.class_2251 settings, @NotNull class_8177 type) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        Intrinsics.checkNotNullParameter((Object)type, (String)"type");
        super(settings, type);
        this.level = level;
    }

    @NotNull
    public class_5955.class_5811 getDegradationLevel() {
        return this.level;
    }

    public boolean method_9542(@NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return true;
    }

    public void method_9514(@NotNull class_2680 state, @NotNull class_3218 world, @NotNull class_2338 pos, @NotNull class_5819 random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        this.method_33621(state, world, pos, random);
    }
}

