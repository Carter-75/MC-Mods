/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1309
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5551
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.block.flickering;

import dev.mim1q.derelict.block.flickering.FlickeringBlock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1309;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_4970;
import net.minecraft.class_5551;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u00020\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0014\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2={"Ldev/mim1q/derelict/block/flickering/FlickeringEndRodBlock;", "Lnet/minecraft/class_5551;", "Ldev/mim1q/derelict/block/flickering/FlickeringBlock;", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_4970$class_2251;)V", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "state", "Lnet/minecraft/class_3218;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_5819;", "random", "scheduledTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "Lnet/minecraft/class_1937;", "Lnet/minecraft/class_1309;", "placer", "Lnet/minecraft/class_1799;", "itemStack", "onPlaced", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;Lnet/minecraft/class_1309;Lnet/minecraft/class_1799;)V", "derelict"})
public final class FlickeringEndRodBlock
extends class_5551
implements FlickeringBlock {
    public FlickeringEndRodBlock(@NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings.method_9640().method_9631(FlickeringBlock.Companion::getLuminance));
        this.method_9590((class_2680)this.method_9564().method_11657((class_2769)FlickeringBlock.Companion.getLIGHT_STATE(), (Comparable)((Object)FlickeringBlock.Companion.LightState.FLICKERING)));
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        super.method_9515(builder);
        class_2769[] class_2769Array = new class_2769[]{FlickeringBlock.Companion.getLIGHT_STATE()};
        builder.method_11667(class_2769Array);
    }

    public void method_9588(@NotNull class_2680 state, @NotNull class_3218 world, @NotNull class_2338 pos, @NotNull class_5819 random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        this.scheduleFlicker((class_1937)world, state, pos, random, (class_2248)this);
    }

    public void method_9567(@NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_2680 state, @Nullable class_1309 placer, @NotNull class_1799 itemStack) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)itemStack, (String)"itemStack");
        class_5819 class_58192 = world.field_9229;
        Intrinsics.checkNotNullExpressionValue((Object)class_58192, (String)"random");
        this.scheduleFlicker(world, state, pos, class_58192, (class_2248)this);
    }

    @Override
    public void scheduleFlicker(@NotNull class_1937 world, @NotNull class_2680 state, @NotNull class_2338 pos, @NotNull class_5819 random, @NotNull class_2248 block) {
        FlickeringBlock.DefaultImpls.scheduleFlicker(this, world, state, pos, random, block);
    }

    @Override
    @NotNull
    public Pair<FlickeringBlock.Companion.LightState, Integer> nextFancyFlicker(@NotNull class_5819 random, @NotNull FlickeringBlock.Companion.LightState currentState) {
        return FlickeringBlock.DefaultImpls.nextFancyFlicker(this, random, currentState);
    }

    @Override
    @NotNull
    public Pair<FlickeringBlock.Companion.LightState, Integer> nextFabulousFlicker(@NotNull class_5819 random) {
        return FlickeringBlock.DefaultImpls.nextFabulousFlicker(this, random);
    }
}

