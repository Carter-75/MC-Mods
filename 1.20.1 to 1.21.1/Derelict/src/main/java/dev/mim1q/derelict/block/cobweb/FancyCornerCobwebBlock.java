/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_2248
 *  net.minecraft.class_2350
 *  net.minecraft.class_2415
 *  net.minecraft.class_2470
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2754
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_3532
 *  net.minecraft.class_3542
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.block.cobweb;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_2248;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_2470;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2754;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3532;
import net.minecraft.class_3542;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2={"Ldev/mim1q/derelict/block/cobweb/FancyCornerCobwebBlock;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_4970$class_2251;)V", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_1750;", "ctx", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "", "offset", "", "getRotation", "(Lnet/minecraft/class_1750;F)I", "state", "Lnet/minecraft/class_2415;", "mirror", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_2415;)Lnet/minecraft/class_2680;", "Lnet/minecraft/class_2470;", "rotation", "rotate", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_2470;)Lnet/minecraft/class_2680;", "Companion", "Type", "derelict"})
public final class FancyCornerCobwebBlock
extends class_2248 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final class_2758 ROTATION;
    @NotNull
    private static final class_2754<Type> TYPE;

    public FancyCornerCobwebBlock(@NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        super.method_9515(builder);
        class_2769[] class_2769Array = new class_2769[]{ROTATION, TYPE};
        builder.method_11667(class_2769Array);
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        if (ctx.method_8038().method_10166().method_10179()) {
            Object object = ((class_2680)this.method_9564().method_11657((class_2769)ROTATION, (Comparable)Integer.valueOf(this.getRotation(ctx, 45.0f)))).method_11657((class_2769)TYPE, (Comparable)((Object)Type.HORIZONTAL));
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
            return (class_2680)object;
        }
        Object object = ((class_2680)this.method_9564().method_11657((class_2769)ROTATION, (Comparable)Integer.valueOf(FancyCornerCobwebBlock.getRotation$default(this, ctx, 0.0f, 2, null)))).method_11657((class_2769)TYPE, (Comparable)((Object)(ctx.method_8038() == class_2350.field_11036 ? Type.BOTTOM : Type.TOP)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
        return (class_2680)object;
    }

    private final int getRotation(class_1750 ctx, float offset) {
        class_1657 class_16572 = ctx.method_8036();
        float yaw = class_3532.method_15341((float)(class_16572 != null ? class_16572.field_6241 + offset : 0.0f), (float)360.0f);
        return (int)(yaw / 45.0f) % 8;
    }

    static /* synthetic */ int getRotation$default(FancyCornerCobwebBlock fancyCornerCobwebBlock, class_1750 class_17502, float f, int n, Object object) {
        if ((n & 2) != 0) {
            f = 22.5f;
        }
        return fancyCornerCobwebBlock.getRotation(class_17502, f);
    }

    @NotNull
    public class_2680 method_9569(@NotNull class_2680 state, @NotNull class_2415 mirror) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)mirror, (String)"mirror");
        Object object = state.method_11657((class_2769)ROTATION, (Comparable)Integer.valueOf((((Number)((Object)state.method_11654((class_2769)ROTATION))).intValue() + mirror.ordinal() * 4) % 8));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
        return (class_2680)object;
    }

    @NotNull
    public class_2680 method_9598(@NotNull class_2680 state, @NotNull class_2470 rotation) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)rotation, (String)"rotation");
        Object object = state.method_11657((class_2769)ROTATION, (Comparable)Integer.valueOf((((Number)((Object)state.method_11654((class_2769)ROTATION))).intValue() + rotation.ordinal() * 2) % 8));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
        return (class_2680)object;
    }

    static {
        class_2758 class_27582 = class_2758.method_11867((String)"rotation", (int)0, (int)7);
        Intrinsics.checkNotNullExpressionValue((Object)class_27582, (String)"of(...)");
        ROTATION = class_27582;
        class_2754 class_27542 = class_2754.method_11850((String)"type", Type.class);
        Intrinsics.checkNotNullExpressionValue((Object)class_27542, (String)"of(...)");
        TYPE = class_27542;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Ldev/mim1q/derelict/block/cobweb/FancyCornerCobwebBlock$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2758;", "ROTATION", "Lnet/minecraft/class_2758;", "getROTATION", "()Lnet/minecraft/class_2758;", "Lnet/minecraft/class_2754;", "Ldev/mim1q/derelict/block/cobweb/FancyCornerCobwebBlock$Type;", "TYPE", "Lnet/minecraft/class_2754;", "getTYPE", "()Lnet/minecraft/class_2754;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2758 getROTATION() {
            return ROTATION;
        }

        @NotNull
        public final class_2754<Type> getTYPE() {
            return TYPE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/block/cobweb/FancyCornerCobwebBlock$Type;", "Lnet/minecraft/class_3542;", "", "", "id", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "asString", "()Ljava/lang/String;", "Ljava/lang/String;", "TOP", "BOTTOM", "HORIZONTAL", "derelict"})
    public static final class Type
    extends Enum<Type>
    implements class_3542 {
        @NotNull
        private final String id;
        public static final /* enum */ Type TOP = new Type("top");
        public static final /* enum */ Type BOTTOM = new Type("bottom");
        public static final /* enum */ Type HORIZONTAL = new Type("horizontal");
        private static final /* synthetic */ Type[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private Type(String id) {
            this.id = id;
        }

        @NotNull
        public String method_15434() {
            return this.id;
        }

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }

        public static Type valueOf(String value) {
            return Enum.valueOf(Type.class, value);
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            $VALUES = typeArray = new Type[]{Type.TOP, Type.BOTTOM, Type.HORIZONTAL};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

