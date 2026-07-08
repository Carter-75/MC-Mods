/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2318
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2498
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2769
 *  net.minecraft.class_3726
 *  net.minecraft.class_4970$class_2251
 */
package org.valkyrienskies.mod.common.block;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2318;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2498;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.mod.common.block.WingBlock;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J#\u0010\b\u001a\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0014\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0017\u00a2\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010 \u001a\n \u001f*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\"\u001a\n \u001f*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010!R\u001c\u0010#\u001a\n \u001f*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u001c\u0010$\u001a\n \u001f*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010!R\u001c\u0010%\u001a\n \u001f*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010!R\u001c\u0010&\u001a\n \u001f*\u0004\u0018\u00010\u00150\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010!\u00a8\u0006)"}, d2={"Lorg/valkyrienskies/mod/common/block/TestWingBlock;", "Lnet/minecraft/class_2318;", "Lorg/valkyrienskies/mod/common/block/WingBlock;", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "builder", "", "createBlockStateDefinition", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_1750;", "ctx", "getStateForPlacement", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1922;", "blockGetter", "Lnet/minecraft/class_2338;", "blockPos", "Lnet/minecraft/class_3726;", "collisionContext", "Lnet/minecraft/class_265;", "getShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Lnet/minecraft/class_1937;", "level", "pos", "blockState", "Lorg/valkyrienskies/core/api/ships/Wing;", "getWing", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)Lorg/valkyrienskies/core/api/ships/Wing;", "kotlin.jvm.PlatformType", "EAST_AABB", "Lnet/minecraft/class_265;", "WEST_AABB", "SOUTH_AABB", "NORTH_AABB", "UP_AABB", "DOWN_AABB", "<init>", "()V", "valkyrienskies-120"})
public final class TestWingBlock
extends class_2318
implements WingBlock {
    @NotNull
    public static final TestWingBlock INSTANCE = new TestWingBlock();
    private static final class_265 EAST_AABB = class_2318.method_9541((double)4.0, (double)0.0, (double)0.0, (double)12.0, (double)16.0, (double)16.0);
    private static final class_265 WEST_AABB = class_2318.method_9541((double)4.0, (double)0.0, (double)0.0, (double)12.0, (double)16.0, (double)16.0);
    private static final class_265 SOUTH_AABB = class_2318.method_9541((double)0.0, (double)0.0, (double)4.0, (double)16.0, (double)16.0, (double)12.0);
    private static final class_265 NORTH_AABB = class_2318.method_9541((double)0.0, (double)0.0, (double)4.0, (double)16.0, (double)16.0, (double)12.0);
    private static final class_265 UP_AABB = class_2318.method_9541((double)0.0, (double)4.0, (double)0.0, (double)16.0, (double)12.0, (double)16.0);
    private static final class_265 DOWN_AABB = class_2318.method_9541((double)0.0, (double)4.0, (double)0.0, (double)16.0, (double)12.0, (double)16.0);

    private TestWingBlock() {
        super(class_4970.class_2251.method_9637().method_9629(10.0f, 1200.0f).method_9626(class_2498.field_11533));
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        class_2769[] class_2769Array = new class_2769[]{class_2318.field_10927};
        builder.method_11667(class_2769Array);
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        Object object = this.method_9564().method_11657((class_2769)class_2318.field_10927, (Comparable)ctx.method_7715().method_10153());
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"setValue(...)");
        return (class_2680)object;
    }

    @Deprecated(message="Deprecated in Java")
    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @NotNull class_1922 blockGetter, @NotNull class_2338 blockPos, @NotNull class_3726 collisionContext) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)blockGetter, (String)"blockGetter");
        Intrinsics.checkNotNullParameter((Object)blockPos, (String)"blockPos");
        Intrinsics.checkNotNullParameter((Object)collisionContext, (String)"collisionContext");
        class_2350 class_23502 = (class_2350)state.method_11654((class_2769)class_2318.field_10927);
        switch (class_23502 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[class_23502.ordinal()]) {
            case 1: {
                class_265 class_2652 = DOWN_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"DOWN_AABB");
                return class_2652;
            }
            case 2: {
                class_265 class_2653 = NORTH_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2653, (String)"NORTH_AABB");
                return class_2653;
            }
            case 3: {
                class_265 class_2654 = SOUTH_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2654, (String)"SOUTH_AABB");
                return class_2654;
            }
            case 4: {
                class_265 class_2655 = WEST_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2655, (String)"WEST_AABB");
                return class_2655;
            }
            case 5: {
                class_265 class_2656 = EAST_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2656, (String)"EAST_AABB");
                return class_2656;
            }
            case 6: {
                class_265 class_2657 = UP_AABB;
                Intrinsics.checkNotNullExpressionValue((Object)class_2657, (String)"UP_AABB");
                return class_2657;
            }
        }
        class_265 class_2658 = UP_AABB;
        Intrinsics.checkNotNullExpressionValue((Object)class_2658, (String)"UP_AABB");
        return class_2658;
    }

    @Override
    @NotNull
    public Wing getWing(@Nullable class_1937 level, @Nullable class_2338 pos, @NotNull class_2680 blockState) {
        Intrinsics.checkNotNullParameter((Object)blockState, (String)"blockState");
        double wingPower = 150.0;
        double wingDrag = 30.0;
        Double wingBreakingForce = null;
        double wingCamberAttackAngleBias = Math.toRadians(10.0);
        class_2382 class_23822 = ((class_2350)blockState.method_11654((class_2769)class_2318.field_10927)).method_10163();
        Intrinsics.checkNotNullExpressionValue((Object)class_23822, (String)"getNormal(...)");
        return new Wing(VectorConversionsMCKt.toJOMLD(class_23822), wingPower, wingDrag, wingBreakingForce, wingCamberAttackAngleBias);
    }

    static {
        INSTANCE.method_9590((class_2680)((class_2680)TestWingBlock.INSTANCE.field_10647.method_11664()).method_11657((class_2769)class_2318.field_10927, (Comparable)class_2350.field_11036));
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[class_2350.values().length];
            try {
                nArray[class_2350.field_11033.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11043.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11035.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11039.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11034.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11036.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

