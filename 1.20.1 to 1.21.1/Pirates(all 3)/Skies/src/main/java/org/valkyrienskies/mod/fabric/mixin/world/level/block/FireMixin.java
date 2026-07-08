/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2358
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_4538
 *  net.minecraft.class_5819
 *  net.minecraft.class_6908
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.fabric.mixin.world.level.block;

import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2358;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_4538;
import net.minecraft.class_5819;
import net.minecraft.class_6908;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_2358.class})
public abstract class FireMixin {
    @Unique
    private boolean isModifyingFireTick = false;
    @Shadow
    @Final
    public static class_2758 field_11092;

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    public void fireTickMixin(class_2680 state, class_3218 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
        if (this.isModifyingFireTick) {
            return;
        }
        this.isModifyingFireTick = true;
        double origX = pos.method_10263();
        double origY = pos.method_10264();
        double origZ = pos.method_10260();
        VSGameUtilsKt.transformToNearbyShipsAndWorld((class_1937)level, origX, origY, origZ, 3.0, (x, y, z) -> {
            class_2338 newPos = class_2338.method_49637((double)x, (double)y, (double)z);
            if (level.method_22351(newPos)) {
                level.method_8650(pos, false);
            }
            int i2 = (Integer)state.method_11654((class_2769)field_11092);
            boolean bl2 = level.method_23753(newPos).method_40220(class_6908.field_41752);
            int k2 = bl2 ? -50 : 0;
            this.method_10196((class_1937)level, newPos.method_10078(), 300 + k2, random, i2);
            this.method_10196((class_1937)level, newPos.method_10067(), 300 + k2, random, i2);
            this.method_10196((class_1937)level, newPos.method_10074(), 250 + k2, random, i2);
            this.method_10196((class_1937)level, newPos.method_10084(), 250 + k2, random, i2);
            this.method_10196((class_1937)level, newPos.method_10095(), 300 + k2, random, i2);
            this.method_10196((class_1937)level, newPos.method_10072(), 300 + k2, random, i2);
            class_2338.class_2339 mutableBlockPos = new class_2338.class_2339();
            for (int l2 = -1; l2 <= 1; ++l2) {
                for (int m2 = -1; m2 <= 1; ++m2) {
                    for (int n2 = -1; n2 <= 4; ++n2) {
                        if (l2 == 0 && n2 == 0 && m2 == 0) continue;
                        int o = 100;
                        if (n2 > 1) {
                            o += (n2 - 1) * 100;
                        }
                        mutableBlockPos.method_25504((class_2382)newPos, l2, n2, m2);
                        int p = this.method_10194((class_4538)level, (class_2338)mutableBlockPos);
                        if (p <= 0) continue;
                        int q = (p + 40 + level.method_8407().method_5461() * 7) / (i2 + 30);
                        if (bl2) {
                            q /= 2;
                        }
                        if (q <= 0 || random.method_43048(o) > q || level.method_8419() && this.method_10192((class_1937)level, (class_2338)mutableBlockPos)) continue;
                        int r = Math.min(15, i2 + random.method_43048(5) / 4);
                        level.method_8652((class_2338)mutableBlockPos, this.method_24855((class_1936)level, (class_2338)mutableBlockPos, r), 3);
                    }
                }
            }
        });
        this.isModifyingFireTick = false;
    }

    @Inject(method={"onPlace"}, at={@At(value="HEAD")})
    public void onPlaceMixin(class_2680 state, class_1937 level, class_2338 pos, class_2680 oldState, boolean isMoving, CallbackInfo ci) {
        double origX = pos.method_10263();
        double origY = pos.method_10264();
        double origZ = pos.method_10260();
        VSGameUtilsKt.transformToNearbyShipsAndWorld(level, origX, origY, origZ, 1.0, (x, y, z) -> {
            class_2338 newPos = class_2338.method_49637((double)x, (double)y, (double)z);
            if (level.method_22351(newPos)) {
                level.method_8650(pos, false);
            }
        });
    }

    @Shadow
    private void method_10196(class_1937 level, class_2338 pos, int chance, class_5819 random, int age) {
    }

    @Shadow
    protected boolean method_10192(class_1937 level, class_2338 pos) {
        return this.method_10192(level, pos);
    }

    @Shadow
    private int method_10194(class_4538 level, class_2338 pos) {
        return this.method_10194(level, pos);
    }

    @Shadow
    private class_2680 method_24855(class_1936 level, class_2338 pos, int age) {
        return this.method_24855(level, pos, age);
    }
}

