/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2753
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3532
 *  net.minecraft.class_3726
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block;

import dev.mim1q.derelict.util.ShapeUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2753;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3532;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import org.jetbrains.annotations.NotNull;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 -2\u00020\u0001:\u0004./0-B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H$\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH$\u00a2\u0006\u0004\b\f\u0010\rJ#\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ?\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016\u00a2\u0006\u0004\b(\u0010)J'\u0010+\u001a\u00020*2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b+\u0010,\u0082\u0001\u0003123\u00a8\u00064"}, d2={"Ldev/mim1q/derelict/block/RotatableCoverBlock;", "Lnet/minecraft/class_2248;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_2758;", "getRotationProperty", "()Lnet/minecraft/class_2758;", "Lnet/minecraft/class_1750;", "ctx", "", "getRotation", "(Lnet/minecraft/class_1750;)I", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_1922;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_3726;", "context", "Lnet/minecraft/class_265;", "getOutlineShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Lnet/minecraft/class_1937;", "Lnet/minecraft/class_1657;", "player", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_3965;", "hit", "Lnet/minecraft/class_1269;", "onUse", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;Lnet/minecraft/class_3965;)Lnet/minecraft/class_1269;", "", "isTransparent", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;)Z", "Companion", "Normal", "Crossed", "SquarePatch", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Crossed;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "derelict"})
public abstract class RotatableCoverBlock
extends class_2248 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_265 SHAPE;
    @NotNull
    private static final class_265 SHAPE_BOTTOM;
    @NotNull
    private static final class_265 SHAPE_TOP;
    @NotNull
    private static final class_2753 FACING;
    @NotNull
    private static final class_2758 ROTATION_8;
    @NotNull
    private static final class_2758 ROTATION_3;
    @NotNull
    private static final class_2758 ROTATION_4;

    private RotatableCoverBlock(FabricBlockSettings settings) {
        super((class_4970.class_2251)settings.nonOpaque());
    }

    @NotNull
    protected abstract class_2758 getRotationProperty();

    protected abstract int getRotation(@NotNull class_1750 var1);

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        super.method_9515(builder);
        class_2769[] class_2769Array = new class_2769[]{ROTATION_8, FACING};
        builder.method_11667(class_2769Array);
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        int rotation = ctx.method_8038().method_10166().method_10178() ? this.getRotation(ctx) : 0;
        Object object = ((class_2680)this.method_9564().method_11657((class_2769)FACING, (Comparable)ctx.method_8038())).method_11657((class_2769)this.getRotationProperty(), (Comparable)Integer.valueOf(rotation));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
        return (class_2680)object;
    }

    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos, @NotNull class_3726 context) {
        class_2350 facing;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_2350 class_23502 = facing = (class_2350)state.method_11654((class_2769)FACING);
        return switch (class_23502 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[class_23502.ordinal()]) {
            case 1 -> SHAPE_BOTTOM;
            case 2 -> SHAPE_TOP;
            default -> {
                Intrinsics.checkNotNull((Object)facing);
                yield ShapeUtil.INSTANCE.rotate(SHAPE, facing);
            }
        };
    }

    @NotNull
    public class_1269 method_9534(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_1657 player, @NotNull class_1268 hand, @NotNull class_3965 hit) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)player, (String)"player");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        Intrinsics.checkNotNullParameter((Object)hit, (String)"hit");
        Integer rotation = (Integer)state.method_11654((class_2769)this.getRotationProperty());
        int difference = player.method_5715() ? -1 : 1;
        int newRotation = class_3532.method_15387((int)(rotation + difference), (int)this.getRotationProperty().method_11898().size());
        world.method_8501(pos, (class_2680)state.method_11657((class_2769)this.getRotationProperty(), (Comparable)Integer.valueOf(newRotation)));
        return class_1269.field_5812;
    }

    public boolean method_9579(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        return true;
    }

    public /* synthetic */ RotatableCoverBlock(FabricBlockSettings settings, DefaultConstructorMarker $constructor_marker) {
        this(settings);
    }

    static {
        class_265 class_2652 = class_2248.method_9541((double)1.0, (double)1.0, (double)14.0, (double)15.0, (double)15.0, (double)16.0);
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"createCuboidShape(...)");
        SHAPE = class_2652;
        class_265 class_2653 = class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)2.0, (double)15.0);
        Intrinsics.checkNotNullExpressionValue((Object)class_2653, (String)"createCuboidShape(...)");
        SHAPE_BOTTOM = class_2653;
        class_265 class_2654 = class_2248.method_9541((double)1.0, (double)14.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);
        Intrinsics.checkNotNullExpressionValue((Object)class_2654, (String)"createCuboidShape(...)");
        SHAPE_TOP = class_2654;
        class_2753 class_27532 = class_2741.field_12525;
        Intrinsics.checkNotNullExpressionValue((Object)class_27532, (String)"FACING");
        FACING = class_27532;
        class_2758 class_27582 = class_2758.method_11867((String)"rotation", (int)0, (int)7);
        Intrinsics.checkNotNullExpressionValue((Object)class_27582, (String)"of(...)");
        ROTATION_8 = class_27582;
        class_2758 class_27583 = class_2758.method_11867((String)"rotation", (int)0, (int)2);
        Intrinsics.checkNotNullExpressionValue((Object)class_27583, (String)"of(...)");
        ROTATION_3 = class_27583;
        class_2758 class_27584 = class_2758.method_11867((String)"rotation", (int)0, (int)3);
        Intrinsics.checkNotNullExpressionValue((Object)class_27584, (String)"of(...)");
        ROTATION_4 = class_27584;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\u00a8\u0006\u001b"}, d2={"Ldev/mim1q/derelict/block/RotatableCoverBlock$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_265;", "SHAPE", "Lnet/minecraft/class_265;", "getSHAPE", "()Lnet/minecraft/class_265;", "SHAPE_BOTTOM", "getSHAPE_BOTTOM", "SHAPE_TOP", "getSHAPE_TOP", "Lnet/minecraft/class_2753;", "FACING", "Lnet/minecraft/class_2753;", "getFACING", "()Lnet/minecraft/class_2753;", "Lnet/minecraft/class_2758;", "ROTATION_8", "Lnet/minecraft/class_2758;", "getROTATION_8", "()Lnet/minecraft/class_2758;", "ROTATION_3", "getROTATION_3", "ROTATION_4", "getROTATION_4", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_265 getSHAPE() {
            return SHAPE;
        }

        @NotNull
        public final class_265 getSHAPE_BOTTOM() {
            return SHAPE_BOTTOM;
        }

        @NotNull
        public final class_265 getSHAPE_TOP() {
            return SHAPE_TOP;
        }

        @NotNull
        public final class_2753 getFACING() {
            return FACING;
        }

        @NotNull
        public final class_2758 getROTATION_8() {
            return ROTATION_8;
        }

        @NotNull
        public final class_2758 getROTATION_3() {
            return ROTATION_3;
        }

        @NotNull
        public final class_2758 getROTATION_4() {
            return ROTATION_4;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2={"Ldev/mim1q/derelict/block/RotatableCoverBlock$Crossed;", "Ldev/mim1q/derelict/block/RotatableCoverBlock;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_2758;", "getRotationProperty", "()Lnet/minecraft/class_2758;", "Lnet/minecraft/class_1750;", "ctx", "", "getRotation", "(Lnet/minecraft/class_1750;)I", "derelict"})
    public static final class Crossed
    extends RotatableCoverBlock {
        public Crossed(@NotNull FabricBlockSettings settings) {
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            super(settings, null);
        }

        @Override
        protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
            Intrinsics.checkNotNullParameter(builder, (String)"builder");
            class_2769[] class_2769Array = new class_2769[]{Companion.getROTATION_3(), Companion.getFACING()};
            builder.method_11667(class_2769Array);
        }

        @Override
        @NotNull
        protected class_2758 getRotationProperty() {
            return Companion.getROTATION_3();
        }

        @Override
        protected int getRotation(@NotNull class_1750 ctx) {
            Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
            return ctx.method_8042().method_10166() == class_2350.class_2351.field_11048 ? 2 : 0;
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2={"Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "Ldev/mim1q/derelict/block/RotatableCoverBlock;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_2758;", "getRotationProperty", "()Lnet/minecraft/class_2758;", "Lnet/minecraft/class_1750;", "ctx", "", "getRotation", "(Lnet/minecraft/class_1750;)I", "OxidizableNormal", "derelict"})
    public static class Normal
    extends RotatableCoverBlock {
        public Normal(@NotNull FabricBlockSettings settings) {
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            super(settings, null);
        }

        @Override
        @NotNull
        protected class_2758 getRotationProperty() {
            return Companion.getROTATION_8();
        }

        @Override
        protected int getRotation(@NotNull class_1750 ctx) {
            Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
            boolean up = ctx.method_8038() == class_2350.field_11036;
            class_1657 class_16572 = ctx.method_8036();
            float yaw = class_3532.method_15341((float)(class_16572 != null ? class_16572.field_6241 + (up ? 11.25f : -11.25f) : 0.0f), (float)360.0f);
            int rotation = (int)(yaw / 22.5f) % 8;
            return ctx.method_8038() == class_2350.field_11036 ? rotation : 7 - rotation;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0019\u00a8\u0006\u001a"}, d2={"Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal$OxidizableNormal;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$Normal;", "Lnet/minecraft/class_5955;", "Lnet/minecraft/class_5955$class_5811;", "level", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/minecraft/class_5955$class_5811;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "getDegradationLevel", "()Lnet/minecraft/class_5955$class_5811;", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_3218;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_5819;", "random", "", "randomTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "", "hasRandomTicks", "(Lnet/minecraft/class_2680;)Z", "Lnet/minecraft/class_5955$class_5811;", "derelict"})
        public static final class OxidizableNormal
        extends Normal
        implements class_5955 {
            @NotNull
            private final class_5955.class_5811 level;

            public OxidizableNormal(@NotNull class_5955.class_5811 level, @NotNull FabricBlockSettings settings) {
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
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0014\u00a2\u0006\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2={"Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "Ldev/mim1q/derelict/block/RotatableCoverBlock;", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_2758;", "getRotationProperty", "()Lnet/minecraft/class_2758;", "Lnet/minecraft/class_1750;", "ctx", "", "getRotation", "(Lnet/minecraft/class_1750;)I", "OxidizableSquarePatch", "derelict"})
    public static class SquarePatch
    extends RotatableCoverBlock {
        public SquarePatch(@NotNull FabricBlockSettings settings) {
            Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
            super(settings, null);
        }

        @Override
        protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
            Intrinsics.checkNotNullParameter(builder, (String)"builder");
            class_2769[] class_2769Array = new class_2769[]{Companion.getROTATION_4(), Companion.getFACING()};
            builder.method_11667(class_2769Array);
        }

        @Override
        @NotNull
        protected class_2758 getRotationProperty() {
            return Companion.getROTATION_4();
        }

        @Override
        protected int getRotation(@NotNull class_1750 ctx) {
            Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
            boolean up = ctx.method_8038() == class_2350.field_11036;
            class_1657 class_16572 = ctx.method_8036();
            float yaw = class_3532.method_15341((float)(class_16572 != null ? class_16572.field_6241 + (up ? 11.25f : -11.25f) : 0.0f), (float)360.0f);
            int rotation = (int)(yaw / 22.5f) % 4;
            return ctx.method_8038() == class_2350.field_11036 ? rotation : 3 - rotation;
        }

        @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0019\u00a8\u0006\u001a"}, d2={"Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch$OxidizableSquarePatch;", "Ldev/mim1q/derelict/block/RotatableCoverBlock$SquarePatch;", "Lnet/minecraft/class_5955;", "Lnet/minecraft/class_5955$class_5811;", "level", "Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;", "settings", "<init>", "(Lnet/minecraft/class_5955$class_5811;Lnet/fabricmc/fabric/api/object/builder/v1/block/FabricBlockSettings;)V", "getDegradationLevel", "()Lnet/minecraft/class_5955$class_5811;", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_3218;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_5819;", "random", "", "randomTick", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_3218;Lnet/minecraft/class_2338;Lnet/minecraft/class_5819;)V", "", "hasRandomTicks", "(Lnet/minecraft/class_2680;)Z", "Lnet/minecraft/class_5955$class_5811;", "derelict"})
        public static final class OxidizableSquarePatch
        extends SquarePatch
        implements class_5955 {
            @NotNull
            private final class_5955.class_5811 level;

            public OxidizableSquarePatch(@NotNull class_5955.class_5811 level, @NotNull FabricBlockSettings settings) {
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
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[class_2350.values().length];
            try {
                nArray[class_2350.field_11036.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11033.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

