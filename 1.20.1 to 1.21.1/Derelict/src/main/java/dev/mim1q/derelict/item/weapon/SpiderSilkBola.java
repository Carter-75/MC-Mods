/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1839
 *  net.minecraft.class_1937
 *  net.minecraft.class_3222
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_5328
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.item.weapon;

import dev.mim1q.derelict.entity.projectile.SpiderSilkBolaProjectile;
import dev.mim1q.derelict.init.ModEntities;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_3222;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_5328;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/item/weapon/SpiderSilkBola;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1792$class_1793;", "settings", "<init>", "(Lnet/minecraft/class_1792$class_1793;)V", "Lnet/minecraft/class_1799;", "stack", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_1309;", "user", "", "remainingUseTicks", "", "onStoppedUsing", "(Lnet/minecraft/class_1799;Lnet/minecraft/class_1937;Lnet/minecraft/class_1309;I)V", "Lnet/minecraft/class_1657;", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_1271;", "use", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1271;", "getMaxUseTime", "(Lnet/minecraft/class_1799;)I", "Lnet/minecraft/class_1839;", "getUseAction", "(Lnet/minecraft/class_1799;)Lnet/minecraft/class_1839;", "derelict"})
public final class SpiderSilkBola
extends class_1792 {
    public SpiderSilkBola(@NotNull class_1792.class_1793 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    public void method_7840(@NotNull class_1799 stack, @NotNull class_1937 world, @NotNull class_1309 user, int remainingUseTicks) {
        block2: {
            Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            Intrinsics.checkNotNullParameter((Object)user, (String)"user");
            super.method_7840(stack, world, user, remainingUseTicks);
            int ticks = this.method_7881(stack) - remainingUseTicks;
            if (ticks < 10) {
                return;
            }
            if (world.field_9236) break block2;
            SpiderSilkBolaProjectile projectile = new SpiderSilkBolaProjectile(ModEntities.INSTANCE.getSPIDER_SILK_BOLA(), world);
            projectile.method_33574(user.method_19538().method_1031(0.0, 1.5, 0.0));
            projectile.method_7432((class_1297)user);
            projectile.method_24919((class_1297)user, user.method_36455(), user.method_36454(), 0.0f, 1.5f, 0.1f);
            world.method_8649((class_1297)projectile);
            world.method_8396(null, user.method_24515(), class_3417.field_14600, class_3419.field_15248, 1.0f, 0.6f + world.field_9229.method_43057() * 0.2f);
            user.method_5998(user.method_6058()).method_7934(1);
            class_3222 class_32222 = user instanceof class_3222 ? (class_3222)user : null;
            if (class_32222 != null && (class_32222 = class_32222.method_7357()) != null) {
                class_32222.method_7906((class_1792)this, 20);
            }
        }
    }

    @NotNull
    public class_1271<class_1799> method_7836(@NotNull class_1937 world, @NotNull class_1657 user, @NotNull class_1268 hand) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)user, (String)"user");
        Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
        class_1271 class_12712 = class_5328.method_29282((class_1937)world, (class_1657)user, (class_1268)hand);
        Intrinsics.checkNotNullExpressionValue((Object)class_12712, (String)"consumeHeldItem(...)");
        return class_12712;
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
}

