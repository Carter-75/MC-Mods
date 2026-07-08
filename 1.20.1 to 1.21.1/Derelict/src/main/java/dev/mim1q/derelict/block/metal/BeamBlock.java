/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_3542
 *  net.minecraft.class_3726
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.metal;

import dev.mim1q.derelict.util.ShapeUtil;
import dev.mim1q.derelict.util.StringWrapper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3542;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/block/metal/BeamBlock;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_4970$class_2251;)V", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "state", "Lnet/minecraft/class_1922;", "world", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_3726;", "context", "Lnet/minecraft/class_265;", "getOutlineShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Lnet/minecraft/class_1750;", "ctx", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "Companion", "BeamRotation", "derelict"})
public class BeamBlock
extends class_2248 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_265 SHAPE_VERTICAL;
    @NotNull
    private static final class_265 SHAPE_HORIZONTAL;
    @NotNull
    private static final class_2754<BeamRotation> BEAM_AXIS;

    public BeamBlock(@NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        class_2769[] class_2769Array = new class_2769[]{BEAM_AXIS};
        builder.method_11667(class_2769Array);
    }

    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos, @NotNull class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return ((BeamRotation)((Object)state.method_11654((class_2769)BEAM_AXIS))).getShape();
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_2350.class_2351 class_23512 = ctx.method_8038().method_10166();
        return switch (class_23512 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[class_23512.ordinal()]) {
            case 1 -> {
                Object v1 = this.method_9564().method_11657((class_2769)BEAM_AXIS, (Comparable)((Object)BeamRotation.X));
                Intrinsics.checkNotNullExpressionValue((Object)v1, (String)"with(...)");
                yield (class_2680)v1;
            }
            case 2 -> {
                Object v3 = this.method_9564().method_11657((class_2769)BEAM_AXIS, (Comparable)((Object)BeamRotation.Z));
                Intrinsics.checkNotNullExpressionValue((Object)v3, (String)"with(...)");
                yield (class_2680)v3;
            }
            default -> {
                class_2350.class_2351 v4 = ctx.method_8042().method_10166();
                class_2680 var2_2 = (v4 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[v4.ordinal()]) == 1 ? (class_2680)this.method_9564().method_11657((class_2769)BEAM_AXIS, (Comparable)((Object)BeamRotation.Y_X)) : (class_2680)this.method_9564().method_11657((class_2769)BEAM_AXIS, (Comparable)((Object)BeamRotation.Y_Z));
                Intrinsics.checkNotNull((Object)var2_2);
                yield var2_2;
            }
        };
    }

    static {
        class_265[] class_265Array = new class_265[]{class_2248.method_9541((double)5.0, (double)0.0, (double)0.0, (double)11.0, (double)16.0, (double)16.0), class_2248.method_9541((double)0.0, (double)0.0, (double)14.0, (double)16.0, (double)16.0, (double)16.0)};
        class_265 class_2652 = class_259.method_17786((class_265)class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)2.0), (class_265[])class_265Array);
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"union(...)");
        SHAPE_VERTICAL = class_2652;
        class_265Array = new class_265[]{class_2248.method_9541((double)5.0, (double)2.0, (double)0.0, (double)11.0, (double)14.0, (double)16.0), class_2248.method_9541((double)0.0, (double)14.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0)};
        class_265 class_2653 = class_259.method_17786((class_265)class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)2.0, (double)16.0), (class_265[])class_265Array);
        Intrinsics.checkNotNullExpressionValue((Object)class_2653, (String)"union(...)");
        SHAPE_HORIZONTAL = class_2653;
        class_2754 class_27542 = class_2754.method_11850((String)"axis", BeamRotation.class);
        Intrinsics.checkNotNullExpressionValue((Object)class_27542, (String)"of(...)");
        BEAM_AXIS = class_27542;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001a\n \t*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2={"Ldev/mim1q/derelict/block/metal/BeamBlock$BeamRotation;", "Lnet/minecraft/class_3542;", "", "", "name", "Lnet/minecraft/class_265;", "shape", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lnet/minecraft/class_265;)V", "kotlin.jvm.PlatformType", "asString", "()Ljava/lang/String;", "Lnet/minecraft/class_265;", "getShape", "()Lnet/minecraft/class_265;", "X", "Y_X", "Y_Z", "Z", "derelict"})
    public static final class BeamRotation
    extends Enum<BeamRotation>
    implements class_3542 {
        private final /* synthetic */ String $$delegate_0;
        @NotNull
        private final class_265 shape;
        public static final /* enum */ BeamRotation X = new BeamRotation("x", ShapeUtil.INSTANCE.rotate(Companion.getSHAPE_HORIZONTAL(), class_2350.field_11034));
        public static final /* enum */ BeamRotation Y_X = new BeamRotation("y_x", ShapeUtil.INSTANCE.rotate(Companion.getSHAPE_VERTICAL(), class_2350.field_11034));
        public static final /* enum */ BeamRotation Y_Z = new BeamRotation("y_z", Companion.getSHAPE_VERTICAL());
        public static final /* enum */ BeamRotation Z = new BeamRotation("z", Companion.getSHAPE_HORIZONTAL());
        private static final /* synthetic */ BeamRotation[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private BeamRotation(String name, class_265 shape) {
            this.$$delegate_0 = StringWrapper.constructor-impl(name);
            this.shape = shape;
        }

        public String method_15434() {
            return StringWrapper.asString-impl(this.$$delegate_0);
        }

        @NotNull
        public final class_265 getShape() {
            return this.shape;
        }

        public static BeamRotation[] values() {
            return (BeamRotation[])$VALUES.clone();
        }

        public static BeamRotation valueOf(String value) {
            return Enum.valueOf(BeamRotation.class, value);
        }

        @NotNull
        public static EnumEntries<BeamRotation> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = beamRotationArray = new BeamRotation[]{BeamRotation.X, BeamRotation.Y_X, BeamRotation.Y_Z, BeamRotation.Z};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2={"Ldev/mim1q/derelict/block/metal/BeamBlock$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_265;", "SHAPE_VERTICAL", "Lnet/minecraft/class_265;", "getSHAPE_VERTICAL", "()Lnet/minecraft/class_265;", "SHAPE_HORIZONTAL", "getSHAPE_HORIZONTAL", "Lnet/minecraft/class_2754;", "Ldev/mim1q/derelict/block/metal/BeamBlock$BeamRotation;", "BEAM_AXIS", "Lnet/minecraft/class_2754;", "getBEAM_AXIS", "()Lnet/minecraft/class_2754;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_265 getSHAPE_VERTICAL() {
            return SHAPE_VERTICAL;
        }

        @NotNull
        public final class_265 getSHAPE_HORIZONTAL() {
            return SHAPE_HORIZONTAL;
        }

        @NotNull
        public final class_2754<BeamRotation> getBEAM_AXIS() {
            return BEAM_AXIS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[class_2350.class_2351.values().length];
            try {
                nArray[class_2350.class_2351.field_11048.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.class_2351.field_11051.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

