/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2465
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.metal.oxidizable;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2465;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0019\u00a8\u0006\u001a"}, d2={"Ldev/mim1q/derelict/block/metal/oxidizable/OxidizablePillarBlock;", "Lnet/minecraft/class_2465;", "Lnet/minecraft/class_5955;", "Lnet/minecraft/class_5955$class_5811;", "level", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_5955$class_5811;Lnet/minecraft/class_4970$class_2251;)V", "getDegradationLevel", "()Lnet/minecraft/class_5955$class_5811;", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_3218;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_5819;", "random", "", "randomTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "", "hasRandomTicks", "(Lnet/minecraft/class_2680;)Z", "Lnet/minecraft/class_5955$class_5811;", "derelict"})
public final class OxidizablePillarBlock
extends class_2465
implements class_5955 {
    @NotNull
    private final class_5955.class_5811 level;

    public OxidizablePillarBlock(@NotNull class_5955.class_5811 level, @NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
        this.level = level;
    }

    @NotNull
    public class_5955.class_5811 getDegradationLevel() {
        return this.level;
    }

    public void method_9514(@NotNull class_2680 state, @NotNull class_3218 world, @NotNull class_2338 pos, @NotNull class_5819 random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        this.method_33621(state, world, pos, random);
    }

    public boolean method_9542(@NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return class_5955.method_34737((class_2248)state.method_26204()).isPresent();
    }
}

