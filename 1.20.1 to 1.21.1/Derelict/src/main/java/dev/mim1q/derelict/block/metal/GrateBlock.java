/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_4262
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.metal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_4262;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2={"Ldev/mim1q/derelict/block/metal/GrateBlock;", "Lnet/minecraft/class_4262;", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_4970$class_2251;)V", "Lnet/minecraft/class_2680;", "state", "stateFrom", "Lnet/minecraft/class_2350;", "direction", "", "isSideInvisible", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_2680;Lnet/minecraft/class_2350;)Z", "derelict"})
public class GrateBlock
extends class_4262 {
    public GrateBlock(@NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    public boolean method_9522(@NotNull class_2680 state, @NotNull class_2680 stateFrom, @NotNull class_2350 direction) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)stateFrom, (String)"stateFrom");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        return stateFrom.method_26204() instanceof GrateBlock || super.method_9522(state, stateFrom, direction);
    }
}

