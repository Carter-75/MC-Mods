/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.screenshake.ScreenShakeUtils
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1839
 *  net.minecraft.class_1937
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2400
 *  net.minecraft.class_243
 *  net.minecraft.class_3218
 *  net.minecraft.class_5328
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.item.weapon;

import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.gimm1q.screenshake.ScreenShakeUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1839;
import net.minecraft.class_1937;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2400;
import net.minecraft.class_243;
import net.minecraft.class_3218;
import net.minecraft.class_5328;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J3\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001c"}, d2={"Ldev/mim1q/derelict/item/weapon/Wildfire;", "Lnet/minecraft/class_1792;", "Lnet/minecraft/class_1792$class_1793;", "settings", "<init>", "(Lnet/minecraft/class_1792$class_1793;)V", "Lnet/minecraft/class_1937;", "world", "Lnet/minecraft/class_1309;", "user", "Lnet/minecraft/class_1799;", "stack", "", "remainingUseTicks", "", "usageTick", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1309;Lnet/minecraft/class_1799;I)V", "Lnet/minecraft/class_1839;", "getUseAction", "(Lnet/minecraft/class_1799;)Lnet/minecraft/class_1839;", "getMaxUseTime", "(Lnet/minecraft/class_1799;)I", "Lnet/minecraft/class_1657;", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_1271;", "use", "(Lnet/minecraft/class_1937;Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1271;", "derelict"})
public final class Wildfire
extends class_1792 {
    public Wildfire(@NotNull class_1792.class_1793 settings) {
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        super(settings);
    }

    public void method_7852(@NotNull class_1937 world, @NotNull class_1309 user, @NotNull class_1799 stack, int remainingUseTicks) {
        boolean shootFlame;
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)user, (String)"user");
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        if (!(user instanceof class_1657)) {
            return;
        }
        boolean bl = shootFlame = user.method_6048() >= 20;
        if (shootFlame) {
            user.method_45319(((class_1657)user).method_5720().method_18805(-1.0, 0.0, -1.0).method_1021(0.03));
            int n = 16;
            for (int i = 0; i < n; ++i) {
                int it = i;
                boolean bl2 = false;
                class_243 dir = user.method_5828(1.0f).method_1021(1.1).method_49272(((class_1657)user).method_6051(), 0.1f);
                class_243 sideDir = new class_243(0.0, 0.0, 1.0).method_1024(MathExtensionsKt.radians(-user.field_6283 - (float)90));
                class_2400 particle = switch (((class_1657)user).method_6051().method_39332(0, 5)) {
                    case 1 -> class_2398.field_11240;
                    case 2 -> class_2398.field_11251;
                    default -> class_2398.field_27783;
                };
                class_243 rngVec = class_243.field_1353.method_49272(((class_1657)user).method_6051(), 0.2f);
                world.method_8406((class_2394)particle, ((class_1657)user).method_23317() + sideDir.field_1352 * 0.4 + dir.field_1352 * 0.3 + rngVec.field_1352, ((class_1657)user).method_23318() + 1.25 + rngVec.field_1351, ((class_1657)user).method_23321() + sideDir.field_1350 * 0.4 + dir.field_1350 * 0.3 + rngVec.field_1350, dir.field_1352, dir.field_1351, dir.field_1350);
            }
        }
        if (!(world instanceof class_3218)) {
            return;
        }
        float shakeStrength = Math.min(1.0f, (float)((class_1657)user).method_6048() * 0.05f);
        ScreenShakeUtils.shakeAround((class_3218)((class_3218)world), (class_243)((class_1657)user).method_19538(), (float)shakeStrength, (int)40, (double)5.0, (double)32.0, (String)"derelict_wildfire");
    }

    @NotNull
    public class_1839 method_7853(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        return class_1839.field_8952;
    }

    public int method_7881(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        return 72000;
    }

    @NotNull
    public class_1271<class_1799> method_7836(@Nullable class_1937 world, @Nullable class_1657 user, @Nullable class_1268 hand) {
        class_1271 class_12712 = class_5328.method_29282((class_1937)world, (class_1657)user, (class_1268)hand);
        Intrinsics.checkNotNullExpressionValue((Object)class_12712, (String)"consumeHeldItem(...)");
        return class_12712;
    }
}

