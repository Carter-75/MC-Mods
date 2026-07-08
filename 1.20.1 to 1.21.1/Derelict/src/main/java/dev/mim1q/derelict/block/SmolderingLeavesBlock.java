/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2397
 *  net.minecraft.class_2398
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2397;
import net.minecraft.class_2398;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Ldev/mim1q/derelict/block/SmolderingLeavesBlock;", "Lnet/minecraft/class_2397;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_5819;", "random", "", "randomDisplayTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "derelict"})
public final class SmolderingLeavesBlock
extends class_2397 {
    public SmolderingLeavesBlock(@NotNull FabricBlockSettings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super((class_4970.class_2251)settings.ticksRandomly().luminance(4).emissiveLighting(SmolderingLeavesBlock::_init_$lambda$0));
    }

    public void method_9496(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_5819 random) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)random, (String)"random");
        super.method_9496(state, world, pos, random);
        if (random.method_43057() < 0.1f) {
            world.method_8406((class_2394)class_2398.field_11240, (double)pos.method_10263() + random.method_43058(), (double)pos.method_10264() + random.method_43058(), (double)pos.method_10260() + random.method_43058(), 0.0, 0.01, 0.0);
        }
    }

    private static final boolean _init_$lambda$0(class_2680 class_26802, class_1922 class_19222, class_2338 class_23382) {
        return true;
    }
}

