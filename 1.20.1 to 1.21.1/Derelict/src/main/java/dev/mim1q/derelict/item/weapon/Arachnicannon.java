/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  net.minecraft.class_124
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1271
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1838
 *  net.minecraft.class_1839
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_2680
 *  net.minecraft.class_3222
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_5250
 *  net.minecraft.class_5328
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.item.weapon;

import dev.mim1q.derelict.block.cobweb.SpiderEggBlock;
import dev.mim1q.derelict.entity.projectile.SpiderEggProjectile;
import dev.mim1q.derelict.init.ModEntities;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import net.minecraft.class_124;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1838;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2680;
import net.minecraft.class_3222;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_5250;
import net.minecraft.class_5328;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\f*\u00020\u0006H\u0002\u00a2\u0006\u0004\b!\u0010\u001dJ\u001b\u0010#\u001a\u00020\u000e*\u00020\u00062\u0006\u0010\"\u001a\u00020\fH\u0002\u00a2\u0006\u0004\b#\u0010$J7\u0010)\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010\u0018\u001a\u00020(H\u0016\u00a2\u0006\u0004\b)\u0010*\u00a8\u0006+"}, d2={"Ldev/mim1q/derelict/item/weapon/Arachnicannon;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1792$class_1793;", "settings", "<init>", "(Lnet/minecraft/class_1792$class_1793;)V", "Lnet/minecraft/class_1799;", "stack", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_1309;", "user", "", "remainingUseTicks", "", "onStoppedUsing", "(Lnet/minecraft/class_1799;Lnet/minecraft/class_1937;Lnet/minecraft/class_1309;I)V", "Lnet/minecraft/class_1657;", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_1271;", "use", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1271;", "Lnet/minecraft/class_1838;", "context", "Lnet/minecraft/class_1269;", "useOnBlock", "(Lnet/minecraft/class_1838;)Lnet/minecraft/class_1269;", "getMaxUseTime", "(Lnet/minecraft/class_1799;)I", "Lnet/minecraft/class_1839;", "getUseAction", "(Lnet/minecraft/class_1799;)Lnet/minecraft/class_1839;", "getLoadedEggs", "eggs", "setLoadedEggs", "(Lnet/minecraft/class_1799;I)V", "", "Lnet/minecraft/class_2561;", "tooltip", "Lnet/minecraft/class_1836;", "appendTooltip", "(Lnet/minecraft/class_1799;Lnet/minecraft/class_1937;Ljava/util/List;Lnet/minecraft/class_1836;)V", "derelict"})
public final class Arachnicannon
extends class_1792 {
    public Arachnicannon(@NotNull class_1792.class_1793 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    public void method_7840(@NotNull class_1799 stack, @NotNull class_1937 world, @NotNull class_1309 user, int remainingUseTicks) {
        block3: {
            Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            Intrinsics.checkNotNullParameter((Object)user, (String)"user");
            super.method_7840(stack, world, user, remainingUseTicks);
            int time = 72000 - remainingUseTicks;
            if (world.field_9236 || time <= 10) break block3;
            int count = this.getLoadedEggs(stack);
            int amount = RangesKt.coerceAtMost((int)count, (int)5);
            if (amount == 0) {
                return;
            }
            this.setLoadedEggs(stack, count - amount);
            stack.method_7956(1, user, arg_0 -> Arachnicannon.onStoppedUsing$lambda$0(user, arg_0));
            world.method_8396(null, user.method_24515(), class_3417.field_14910, class_3419.field_15248, 1.0f, 0.8f);
            int n = 0;
            while (n < amount) {
                int it = n++;
                boolean bl = false;
                SpiderEggProjectile projectile = new SpiderEggProjectile(ModEntities.INSTANCE.getSPIDER_EGG_PROJECTILE(), world);
                projectile.method_33574(user.method_19538().method_1031(0.0, 1.5, 0.0));
                projectile.method_7432((class_1297)user);
                projectile.method_24919((class_1297)user, user.method_36455(), user.method_36454(), 0.0f, 2.3f + user.method_6051().method_43057() * 2.0f, 5.0f);
                world.method_8649((class_1297)projectile);
            }
            class_3222 class_32222 = user instanceof class_3222 ? (class_3222)user : null;
            if (class_32222 != null && (class_32222 = class_32222.method_7357()) != null) {
                class_32222.method_7906((class_1792)this, 200);
            }
        }
    }

    @NotNull
    public class_1271<class_1799> method_7836(@NotNull class_1937 world, @NotNull class_1657 user, @NotNull class_1268 hand) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)user, (String)"user");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        class_1799 it = user.method_5998(hand);
        boolean bl = false;
        Intrinsics.checkNotNull((Object)it);
        class_1271 class_12712 = this.getLoadedEggs(it) == 0 ? class_1271.method_22431((Object)it) : class_5328.method_29282((class_1937)world, (class_1657)user, (class_1268)hand);
        Intrinsics.checkNotNullExpressionValue((Object)class_12712, (String)"let(...)");
        return class_12712;
    }

    @NotNull
    public class_1269 method_7884(@NotNull class_1838 context) {
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        class_2680 state = context.method_8045().method_8320(context.method_8037());
        if (state.method_26204() instanceof SpiderEggBlock) {
            class_1799 class_17992 = context.method_8041();
            Intrinsics.checkNotNullExpressionValue((Object)class_17992, (String)"getStack(...)");
            if (this.getLoadedEggs(class_17992) < 20) {
                context.method_8045().method_22352(context.method_8037(), false);
                class_1799 class_17993 = context.method_8041();
                Intrinsics.checkNotNullExpressionValue((Object)class_17993, (String)"getStack(...)");
                class_1799 class_17994 = context.method_8041();
                Intrinsics.checkNotNullExpressionValue((Object)class_17994, (String)"getStack(...)");
                this.setLoadedEggs(class_17993, this.getLoadedEggs(class_17994) + 1);
                context.method_8045().method_8396(null, context.method_8037(), class_3417.field_15197, class_3419.field_15245, 1.0f, 1.0f);
                return class_1269.field_5812;
            }
        }
        class_1269 class_12692 = super.method_7884(context);
        Intrinsics.checkNotNullExpressionValue((Object)class_12692, (String)"useOnBlock(...)");
        return class_12692;
    }

    public int method_7881(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        return 72000;
    }

    @NotNull
    public class_1839 method_7853(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        return class_1839.field_8953;
    }

    private final int getLoadedEggs(class_1799 $this$getLoadedEggs) {
        class_2487 class_24872 = $this$getLoadedEggs.method_7969();
        return class_24872 != null ? class_24872.method_10550("eggs") : 0;
    }

    private final void setLoadedEggs(class_1799 $this$setLoadedEggs, int eggs) {
        $this$setLoadedEggs.method_7948().method_10569("eggs", eggs);
    }

    public void method_7851(@NotNull class_1799 stack, @Nullable class_1937 world, @NotNull List<class_2561> tooltip, @NotNull class_1836 context) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        Intrinsics.checkNotNullParameter(tooltip, (String)"tooltip");
        Intrinsics.checkNotNullParameter((Object)context, (String)"context");
        super.method_7851(stack, world, tooltip, context);
        int loaded = this.getLoadedEggs(stack);
        if (loaded == 0) {
            class_5250 class_52502 = class_2561.method_43471((String)"item.derelict.arachnicannon.tooltip.no_eggs").method_27692(class_124.field_1080);
            Intrinsics.checkNotNullExpressionValue((Object)class_52502, (String)"formatted(...)");
            tooltip.add((class_2561)class_52502);
        }
        Object[] objectArray = new Object[]{loaded, 20};
        class_5250 class_52503 = class_2561.method_43469((String)"item.derelict.arachnicannon.tooltip.eggs", (Object[])objectArray).method_27692(class_124.field_1080);
        Intrinsics.checkNotNullExpressionValue((Object)class_52503, (String)"formatted(...)");
        tooltip.add((class_2561)class_52503);
    }

    private static final void onStoppedUsing$lambda$0(class_1309 $user, class_1309 it) {
        Intrinsics.checkNotNullParameter((Object)$user, (String)"$user");
        $user.method_20236($user.method_6058());
    }
}

