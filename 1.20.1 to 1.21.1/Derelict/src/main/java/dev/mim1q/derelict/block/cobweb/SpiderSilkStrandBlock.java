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
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
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
package dev.mim1q.derelict.block.cobweb;

import dev.mim1q.derelict.util.StringWrapper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3542;
import net.minecraft.class_3726;
import net.minecraft.class_4970;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00070\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\"\u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001fH\u0016\u00a2\u0006\u0004\b\"\u0010#\u00a8\u0006&"}, d2={"Ldev/mim1q/derelict/block/cobweb/SpiderSilkStrandBlock;", "Lnet/minecraft/class_2248;", "Lnet/minecraft/class_4970$class_2251;", "settings", "<init>", "(Lnet/minecraft/class_4970$class_2251;)V", "Lnet/minecraft/class_2689$class_2690;", "Lnet/minecraft/class_2680;", "builder", "", "appendProperties", "(Lnet/minecraft/class_2689$class_2690;)V", "Lnet/minecraft/class_1750;", "ctx", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "Lnet/minecraft/class_1922;", "world", "Lnet/minecraft/class_2338;", "pos", "kotlin.jvm.PlatformType", "getStateForPos", "(Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;)Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_2350;", "direction", "neighborState", "Lnet/minecraft/class_1936;", "neighborPos", "getStateForNeighborUpdate", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_2350;Lnet/minecraft/class_2680;Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;)Lnet/minecraft/class_2680;", "Lnet/minecraft/class_3726;", "context", "Lnet/minecraft/class_265;", "getOutlineShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Companion", "Type", "derelict"})
public final class SpiderSilkStrandBlock
extends class_2248 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final class_265 SHAPE = class_2248.method_9541((double)6.0, (double)0.0, (double)6.0, (double)10.0, (double)16.0, (double)10.0);
    private static final class_2754<Type> TYPE = class_2754.method_11850((String)"type", Type.class);

    public SpiderSilkStrandBlock(@NotNull class_4970.class_2251 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
        this.method_9590((class_2680)this.method_9564().method_11657((class_2769)TYPE, (Comparable)((Object)Type.MIDDLE)));
    }

    protected void method_9515(@NotNull class_2689.class_2690<class_2248, class_2680> builder) {
        Intrinsics.checkNotNullParameter(builder, (String)"builder");
        class_2769[] class_2769Array = new class_2769[]{TYPE};
        builder.method_11667(class_2769Array);
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_1937 class_19372 = ctx.method_8045();
        Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"getWorld(...)");
        class_1922 class_19222 = (class_1922)class_19372;
        class_2338 class_23382 = ctx.method_8037();
        Intrinsics.checkNotNullExpressionValue((Object)class_23382, (String)"getBlockPos(...)");
        class_2680 class_26802 = this.getStateForPos(class_19222, class_23382);
        Intrinsics.checkNotNullExpressionValue((Object)class_26802, (String)"getStateForPos(...)");
        return class_26802;
    }

    private final class_2680 getStateForPos(class_1922 world, class_2338 pos) {
        return class_2248.method_9501((class_265)world.method_8320(pos.method_10084()).method_26218(world, pos.method_10084()), (class_2350)class_2350.field_11033) ? (class_2680)this.method_9564().method_11657((class_2769)TYPE, (Comparable)((Object)Type.TOP)) : (class_2248.method_9501((class_265)world.method_8320(pos.method_10074()).method_26218(world, pos.method_10074()), (class_2350)class_2350.field_11036) ? (class_2680)this.method_9564().method_11657((class_2769)TYPE, (Comparable)((Object)Type.BOTTOM)) : this.method_9564());
    }

    @NotNull
    public class_2680 method_9559(@NotNull class_2680 state, @NotNull class_2350 direction, @NotNull class_2680 neighborState, @NotNull class_1936 world, @NotNull class_2338 pos, @NotNull class_2338 neighborPos) {
        class_2680 class_26802;
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)neighborState, (String)"neighborState");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        if (direction.method_10166().method_10178()) {
            class_2680 class_26803 = this.getStateForPos((class_1922)world, pos);
            class_26802 = class_26803;
            Intrinsics.checkNotNullExpressionValue((Object)class_26803, (String)"getStateForPos(...)");
        } else {
            class_26802 = state;
        }
        return class_26802;
    }

    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos, @NotNull class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_265 class_2652 = SHAPE;
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"SHAPE");
        return class_2652;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R8\u0010\n\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\t0\t \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2={"Ldev/mim1q/derelict/block/cobweb/SpiderSilkStrandBlock$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_265;", "kotlin.jvm.PlatformType", "SHAPE", "Lnet/minecraft/class_265;", "Lnet/minecraft/class_2754;", "Ldev/mim1q/derelict/block/cobweb/SpiderSilkStrandBlock$Type;", "TYPE", "Lnet/minecraft/class_2754;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001\u00a2\u0006\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/block/cobweb/SpiderSilkStrandBlock$Type;", "Lnet/minecraft/class_3542;", "", "", "name", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "kotlin.jvm.PlatformType", "asString", "()Ljava/lang/String;", "TOP", "MIDDLE", "BOTTOM", "derelict"})
    public static final class Type
    extends Enum<Type>
    implements class_3542 {
        private final /* synthetic */ String $$delegate_0;
        public static final /* enum */ Type TOP = new Type("top");
        public static final /* enum */ Type MIDDLE = new Type("middle");
        public static final /* enum */ Type BOTTOM = new Type("bottom");
        private static final /* synthetic */ Type[] $VALUES;
        private static final /* synthetic */ EnumEntries $ENTRIES;

        private Type(String name) {
            this.$$delegate_0 = StringWrapper.constructor-impl(name);
        }

        public String method_15434() {
            return StringWrapper.asString-impl(this.$$delegate_0);
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
            $VALUES = typeArray = new Type[]{Type.TOP, Type.MIDDLE, Type.BOTTOM};
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[])$VALUES);
        }
    }
}

