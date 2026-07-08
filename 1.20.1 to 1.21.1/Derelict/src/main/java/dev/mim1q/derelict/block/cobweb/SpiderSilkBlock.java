/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.cobweb;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0017"}, d2={"Ldev/mim1q/derelict/block/cobweb/SpiderSilkBlock;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_4970$class_2251;)V", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_1297;", "entity", "", "onEntityCollision", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1297;)V", "stateFrom", "Lnet/minecraft/class_2350;", "direction", "", "isSideInvisible", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_2680;Lnet/minecraft/class_2350;)Z", "derelict"})
public final class SpiderSilkBlock
extends class_2248 {
    public SpiderSilkBlock(@NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    public void method_9548(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        entity.method_5844(state, new class_243(0.75, 0.5, 0.75));
    }

    public boolean method_9522(@NotNull class_2680 state, @NotNull class_2680 stateFrom, @NotNull class_2350 direction) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)stateFrom, (String)"stateFrom");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        return Intrinsics.areEqual((Object)stateFrom.method_26204(), (Object)((Object)this));
    }
}

