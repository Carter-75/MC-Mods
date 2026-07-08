/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_1297
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_3726
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.metal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1297;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u001d\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2={"Ldev/mim1q/derelict/block/metal/BarbedWireBlock;", "Lnet/minecraft/class_2248;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "state", "Lnet/minecraft/class_1922;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_3726;", "context", "Lnet/minecraft/class_265;", "getOutlineShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Lnet/minecraft/class_1750;", "ctx", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "Lnet/minecraft/class_1937;", "Lnet/minecraft/class_1297;", "entity", "onEntityCollision", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1297;)V", "Companion", "derelict"})
public class BarbedWireBlock
extends class_2248 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_265 SHAPE;
    @NotNull
    private static final class_265 SHAPE_ROTATED;
    @NotNull
    private static final class_2754<class_2350.class_2351> AXIS;

    public BarbedWireBlock(@NotNull FabricBlockSettings settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super((class_4970.class_2251)settings);
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        class_2769[] class_2769Array = new class_2769[]{AXIS};
        builder.method_11667(class_2769Array);
    }

    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos, @NotNull class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return state.method_11654((class_2769)AXIS) == class_2350.class_2351.field_11048 ? SHAPE : SHAPE_ROTATED;
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Object object = this.method_9564().method_11657((class_2769)AXIS, (Comparable)ctx.method_8042().method_10170().method_10166());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
        return (class_2680)object;
    }

    public void method_9548(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        entity.method_5844(state, new class_243(0.5, 0.5, 0.5));
        entity.method_5643(world.method_48963().method_48826(), 1.5f);
    }

    static {
        class_265 class_2652 = class_2248.method_9541((double)0.0, (double)0.0, (double)4.0, (double)16.0, (double)8.0, (double)12.0);
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"createCuboidShape(...)");
        SHAPE = class_2652;
        class_265 class_2653 = class_2248.method_9541((double)4.0, (double)0.0, (double)0.0, (double)12.0, (double)8.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)class_2653, (String)"createCuboidShape(...)");
        SHAPE_ROTATED = class_2653;
        class_2754 class_27542 = class_2741.field_12529;
        Intrinsics.checkNotNullExpressionValue((Object)class_27542, (String)"HORIZONTAL_AXIS");
        AXIS = class_27542;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Ldev/mim1q/derelict/block/metal/BarbedWireBlock$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_265;", "SHAPE", "Lnet/minecraft/class_265;", "getSHAPE", "()Lnet/minecraft/class_265;", "SHAPE_ROTATED", "getSHAPE_ROTATED", "Lnet/minecraft/class_2754;", "Lnet/minecraft/class_2350$class_2351;", "AXIS", "Lnet/minecraft/class_2754;", "getAXIS", "()Lnet/minecraft/class_2754;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_265 getSHAPE() {
            return SHAPE;
        }

        @NotNull
        public final class_265 getSHAPE_ROTATED() {
            return SHAPE_ROTATED;
        }

        @NotNull
        public final class_2754<class_2350.class_2351> getAXIS() {
            return AXIS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

