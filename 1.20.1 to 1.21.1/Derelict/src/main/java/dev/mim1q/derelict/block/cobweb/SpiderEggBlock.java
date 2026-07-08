/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.block.cobweb;

import dev.mim1q.derelict.block.cobweb.SpiderEggBlock;
import dev.mim1q.derelict.init.ModBlockEntities;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001$BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u001d\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c\"\b\b\u0000\u0010\u0017*\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001e\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010#R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001f\u00a8\u0006%"}, d2={"Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock;", "Lnet/minecraft/class_2237;", "Lnet/minecraft/class_4970$class_2251;", "settings", "", "big", "Lnet/minecraft/class_1299;", "Lnet/minecraft/class_1309;", "entityType", "Lkotlin/Function1;", "Lnet/minecraft/class_5819;", "", "count", "ticks", "<init>", "(Lnet/minecraft/class_4970$class_2251;ZLnet/minecraft/class_1299;Lkotlin/jvm/functions/Function1;Z)V", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_2586;", "createBlockEntity", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)Lnet/minecraft/class_2586;", "T", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_2591;", "type", "Lnet/minecraft/class_5558;", "getTicker", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2680;Lnet/minecraft/class_2591;)Lnet/minecraft/class_5558;", "Z", "getBig", "()Z", "Lnet/minecraft/class_1299;", "Lkotlin/jvm/functions/Function1;", "SpiderEggBlockEntity", "derelict"})
public final class SpiderEggBlock
extends class_2237 {
    private final boolean big;
    @Nullable
    private final class_1299<? extends class_1309> entityType;
    @NotNull
    private final Function1<class_5819, Integer> count;
    private final boolean ticks;

    public SpiderEggBlock(@NotNull class_4970.class_2251 settings, boolean big, @Nullable class_1299<? extends class_1309> entityType, @NotNull Function1<? super class_5819, Integer> count, boolean ticks) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        Intrinsics.checkNotNullParameter(count, (String)"count");
        super(settings);
        this.big = big;
        this.entityType = entityType;
        this.count = count;
        this.ticks = ticks;
    }

    public /* synthetic */ SpiderEggBlock(class_4970.class_2251 class_22512, boolean bl, class_1299 class_12992, Function1 function1, boolean bl2, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            class_12992 = null;
        }
        if ((n & 8) != 0) {
            function1 = SpiderEggBlock::_init_$lambda$0;
        }
        if ((n & 0x10) != 0) {
            bl2 = class_12992 != null;
        }
        this(class_22512, bl, (class_1299<? extends class_1309>)class_12992, (Function1<? super class_5819, Integer>)function1, bl2);
    }

    public final boolean getBig() {
        return this.big;
    }

    @NotNull
    public class_2586 method_10123(@NotNull class_2338 pos, @NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        return new SpiderEggBlockEntity(pos, state);
    }

    @Nullable
    public <T extends class_2586> class_5558<T> method_31645(@NotNull class_1937 world, @NotNull class_2680 state, @NotNull class_2591<T> type) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter(type, (String)"type");
        return !this.ticks ? null : class_2237.method_31618(type, ModBlockEntities.INSTANCE.getSPIDER_EGG_BLOCK_ENTITY(), (class_5558)getTicker.1.INSTANCE);
    }

    private static final int _init_$lambda$0(class_5819 it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return 1;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/block/cobweb/SpiderEggBlock$SpiderEggBlockEntity;", "Lnet/minecraft/class_2586;", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "state", "<init>", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "Lnet/minecraft/class_1937;", "world", "", "tick", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "derelict"})
    public static final class SpiderEggBlockEntity
    extends class_2586 {
        public SpiderEggBlockEntity(@NotNull class_2338 pos, @NotNull class_2680 state) {
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            super(ModBlockEntities.INSTANCE.getSPIDER_EGG_BLOCK_ENTITY(), pos, state);
        }

        public final void tick(@NotNull class_1937 world, @NotNull class_2338 pos, @NotNull class_2680 state) {
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
            Intrinsics.checkNotNullParameter((Object)state, (String)"state");
            if (world.method_8510() % 10L == (long)pos.hashCode() % 10L && world.method_18459((double)pos.method_10263() + 0.5, (double)pos.method_10264(), (double)pos.method_10260() + 0.5, 5.0, true) != null) {
                class_2248 class_22482 = state.method_26204();
                SpiderEggBlock spiderEggBlock = class_22482 instanceof SpiderEggBlock ? (SpiderEggBlock)class_22482 : null;
                if (spiderEggBlock != null) {
                    SpiderEggBlock block = spiderEggBlock;
                    boolean bl = false;
                    class_5819 random = world.field_9229;
                    if (block.entityType != null) {
                        Function1 function1 = block.count;
                        Intrinsics.checkNotNull((Object)random);
                        int n = ((Number)function1.invoke((Object)random)).intValue();
                        int n2 = 0;
                        while (n2 < n) {
                            int it = n2++;
                            boolean bl2 = false;
                            if ((class_1309)block.entityType.method_5883(world) != null) {
                                class_1309 class_13092;
                                Intrinsics.checkNotNull((Object)class_13092);
                                class_1309 entity = class_13092;
                                entity.method_23327((double)pos.method_10263() + 0.5, (double)pos.method_10264() + 0.5, (double)pos.method_10260() + 0.5);
                                world.method_8649((class_1297)entity);
                                continue;
                            }
                            break;
                        }
                    }
                }
                world.method_22352(pos, false);
            }
        }
    }
}

