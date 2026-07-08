/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.enums.EnumEntries
 *  kotlin.enums.EnumEntriesKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.class_124
 *  net.minecraft.class_1297
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3726
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5250
 *  net.minecraft.class_5431
 *  net.minecraft.class_5778
 *  net.minecraft.class_7118
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.block.cobweb;

import dev.mim1q.derelict.tag.ModBlockTags;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import net.minecraft.class_1297;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5250;
import net.minecraft.class_5431;
import net.minecraft.class_5778;
import net.minecraft.class_7118;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 =2\u00020\u0001:\u0001=B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J7\u0010*\u001a\u00020)2\u0006\u0010\"\u001a\u00020!2\b\u0010\u000b\u001a\u0004\u0018\u00010#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010(\u001a\u00020'H\u0016\u00a2\u0006\u0004\b*\u0010+J/\u0010.\u001a\u00020-2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020#2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020,H\u0016\u00a2\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016\u00a2\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H\u0016\u00a2\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u000203H\u0016\u00a2\u0006\u0004\b6\u00105J/\u0010:\u001a\u00020)2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u0002072\u0006\u0010\r\u001a\u00020\f2\u0006\u00109\u001a\u000208H\u0016\u00a2\u0006\u0004\b:\u0010;R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010<\u00a8\u0006>"}, d2={"Ldev/mim1q/derelict/block/cobweb/FancyCobwebBlock;", "Lnet/minecraft/class_5778;", "Lnet/minecraft/class_4970$class_2251;", "settings", "", "hasTooltip", "<init>", "(Lnet/minecraft/class_4970$class_2251;Z)V", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_4538;", "world", "Lnet/minecraft/class_2338;", "pos", "canPlaceAt", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_4538;Lnet/minecraft/class_2338;)Z", "origin", "Lnet/minecraft/class_2350;", "direction", "canConnect", "(Lnet/minecraft/class_4538;Lnet/minecraft/class_2338;Lnet/minecraft/class_2350;)Z", "Lnet/minecraft/class_1750;", "ctx", "getPlacementState", "(Lnet/minecraft/class_1750;)Lnet/minecraft/class_2680;", "neighborState", "Lnet/minecraft/class_1936;", "neighborPos", "getStateForNeighborUpdate", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_2350;Lnet/minecraft/class_2680;Lnet/minecraft/class_1936;Lnet/minecraft/class_2338;Lnet/minecraft/class_2338;)Lnet/minecraft/class_2680;", "context", "canReplace", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1750;)Z", "Lnet/minecraft/class_1799;", "stack", "Lnet/minecraft/class_1922;", "", "Lnet/minecraft/class_2561;", "tooltip", "Lnet/minecraft/class_1836;", "options", "", "appendTooltip", "(Lnet/minecraft/class_1799;Lnet/minecraft/class_1922;Ljava/util/List;Lnet/minecraft/class_1836;)V", "Lnet/minecraft/class_3726;", "Lnet/minecraft/class_265;", "getOutlineShape", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1922;Lnet/minecraft/class_2338;Lnet/minecraft/class_3726;)Lnet/minecraft/class_265;", "Lnet/minecraft/class_7118;", "getGrower", "()Lnet/minecraft/class_7118;", "", "getMaxHorizontalModelOffset", "()F", "getVerticalModelOffsetMultiplier", "Lnet/minecraft/class_1937;", "Lnet/minecraft/class_1297;", "entity", "onEntityCollision", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_1297;)V", "Z", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nFancyCobwebBlock.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FancyCobwebBlock.kt\ndev/mim1q/derelict/block/cobweb/FancyCobwebBlock\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,97:1\n12511#2,2:98\n*S KotlinDebug\n*F\n+ 1 FancyCobwebBlock.kt\ndev/mim1q/derelict/block/cobweb/FancyCobwebBlock\n*L\n27#1:98,2\n*E\n"})
public class FancyCobwebBlock
extends class_5778 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final boolean hasTooltip;
    @NotNull
    private static final String DISABLED_TOOLTIP_KEY = "block.derelict.fancy_cobweb.disabled_tooltip";

    public FancyCobwebBlock(@NotNull class_4970.class_2251 settings, boolean hasTooltip) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
        this.hasTooltip = hasTooltip;
    }

    public /* synthetic */ FancyCobwebBlock(class_4970.class_2251 class_22512, boolean bl, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = false;
        }
        this(class_22512, bl);
    }

    public boolean method_9558(@NotNull class_2680 state, @NotNull class_4538 world, @NotNull class_2338 pos) {
        boolean bl;
        block1: {
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullExpressionValue((Object)class_5778.field_28421, (String)"DIRECTIONS");
            Object[] $this$any$iv = class_5778.field_28421;
            boolean $i$f$any = false;
            for (Object element$iv : $this$any$iv) {
                class_2350 it = (class_2350)element$iv;
                boolean bl2 = false;
                Intrinsics.checkNotNull((Object)it);
                if (!this.canConnect(world, pos, it)) continue;
                bl = true;
                break block1;
            }
            bl = false;
        }
        return bl;
    }

    private final boolean canConnect(class_4538 world, class_2338 origin, class_2350 direction) {
        class_2338 pos = origin.method_10081(direction.method_10163());
        class_2680 state = world.method_8320(pos);
        return state.method_30368((class_1922)world, pos, direction.method_10153(), class_5431.field_25823) || state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS());
    }

    @NotNull
    public class_2680 method_9605(@NotNull class_1750 ctx) {
        Intrinsics.checkNotNullParameter((Object)ctx, (String)"ctx");
        class_2338 pos = ctx.method_8037();
        class_1937 world = ctx.method_8045();
        class_2680 state = this.method_9564();
        for (class_2350 direction : EntriesMappings.entries$0) {
            class_2769 class_27692 = (class_2769)class_5778.method_33374((class_2350)direction);
            Intrinsics.checkNotNull((Object)world);
            class_4538 class_45382 = (class_4538)world;
            Intrinsics.checkNotNull((Object)pos);
            state = (class_2680)state.method_11657(class_27692, (Comparable)Boolean.valueOf(this.canConnect(class_45382, pos, direction)));
        }
        Iterator iterator = state;
        Intrinsics.checkNotNull((Object)iterator);
        return iterator;
    }

    @NotNull
    public class_2680 method_9559(@NotNull class_2680 state, @NotNull class_2350 direction, @NotNull class_2680 neighborState, @NotNull class_1936 world, @NotNull class_2338 pos, @NotNull class_2338 neighborPos) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        Intrinsics.checkNotNullParameter((Object)neighborState, (String)"neighborState");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)neighborPos, (String)"neighborPos");
        Object object = state.method_11657((class_2769)class_5778.method_33374((class_2350)direction), (Comparable)Boolean.valueOf(this.canConnect((class_4538)world, pos, direction)));
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"with(...)");
        return (class_2680)object;
    }

    public boolean method_9616(@NotNull class_2680 state, @NotNull class_1750 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        return false;
    }

    public void method_9568(@NotNull class_1799 stack, @Nullable class_1922 world, @NotNull List<class_2561> tooltip, @NotNull class_1836 options) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter(tooltip, (String)"tooltip");
        Intrinsics.checkNotNullParameter((Object)options, (String)"options");
        super.method_9568(stack, world, tooltip, options);
        class_5250 text = class_2561.method_43471((String)DISABLED_TOOLTIP_KEY);
        String string = text.getString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getString(...)");
        if (!StringsKt.isBlank((CharSequence)string) && this.hasTooltip) {
            class_5250 class_52502 = text.method_27692(class_124.field_1079);
            Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"formatted(...)");
            tooltip.add((class_2561)class_52502);
        }
    }

    @NotNull
    public class_265 method_9530(@NotNull class_2680 state, @NotNull class_1922 world, @NotNull class_2338 pos, @NotNull class_3726 context) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_265 class_2652 = class_259.method_1077();
        Intrinsics.checkNotNullExpressionValue((Object)class_2652, (String)"fullCube(...)");
        return class_2652;
    }

    @NotNull
    public class_7118 method_41432() {
        return new class_7118((class_5778)this);
    }

    public float method_32913() {
        return 0.0625f;
    }

    public float method_37247() {
        return 0.0625f;
    }

    public void method_9548(@NotNull class_2680 state, @NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_1297 entity) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)entity, (String)"entity");
        entity.method_5844(state, new class_243(0.75, 0.5, 0.75));
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Ldev/mim1q/derelict/block/cobweb/FancyCobwebBlock$Companion;", "", "<init>", "()V", "", "DISABLED_TOOLTIP_KEY", "Ljava/lang/String;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class EntriesMappings {
        public static final /* synthetic */ EnumEntries<class_2350> entries$0;

        static {
            entries$0 = EnumEntriesKt.enumEntries((Enum[])((Enum[])class_2350.values()));
        }
    }
}

