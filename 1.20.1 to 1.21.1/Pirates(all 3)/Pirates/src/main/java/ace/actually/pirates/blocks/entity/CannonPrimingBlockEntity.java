/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2315
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2453
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_268
 *  net.minecraft.class_2680
 *  net.minecraft.class_270
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  org.valkyrienskies.core.api.ships.ServerShip
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package ace.actually.pirates.blocks.entity;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.CannonPrimingBlock;
import ace.actually.pirates.util.ConfigUtils;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2315;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2453;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_268;
import net.minecraft.class_2680;
import net.minecraft.class_270;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class CannonPrimingBlockEntity
extends class_2586 {
    public int cooldown = 0;
    private int lastCooldown = 40;
    public final double randomRotation = Math.random() * 2.5;
    private static int cooldownConfig = -5;

    public CannonPrimingBlockEntity(class_2338 pos, class_2680 state) {
        super((class_2591)Pirates.CANNON_PRIMING_BLOCK_ENTITY.get(), pos, state);
    }

    /*
     * Unable to fully structure code
     */
    public void tick(class_1937 world, class_2338 pos, class_2680 state, CannonPrimingBlockEntity be) {
        if (!(world instanceof class_3218)) ** GOTO lbl-1000
        sw = (class_3218)world;
        if (this.cooldown == 0) {
            if (CannonPrimingBlockEntity.checkShouldFire(sw, pos, state) && !((Boolean)state.method_11654((class_2769)CannonPrimingBlock.DISARMED)).booleanValue()) {
                this.fire(sw, pos, state);
            } else {
                this.cooldown = 3;
            }
        } else if (this.cooldown == 4) {
            if (!world.method_49803(pos)) {
                --this.cooldown;
            }
        } else {
            --this.cooldown;
        }
        if (((Boolean)state.method_11654((class_2769)class_2453.field_11413)).booleanValue() && this.lastCooldown - this.cooldown == 10) {
            world.method_8501(pos, (class_2680)state.method_11657((class_2769)class_2453.field_11413, (Comparable)Boolean.valueOf(false)));
        }
    }

    public void fire(class_1937 world, class_2338 pos, class_2680 state, int cooldown) {
        if (this.cooldown > 3) {
            return;
        }
        world.method_8501(pos, (class_2680)state.method_11657((class_2769)class_2453.field_11413, (Comparable)Boolean.valueOf(true)));
        this.lastCooldown = this.cooldown = cooldown;
        class_2338 ahead = pos.method_10081(((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10163());
        if (world.method_8320(ahead).method_27852((class_2248)Pirates.DISPENSER_CANNON_BLOCK.get())) {
            world.method_39279(ahead, world.method_8320(ahead).method_26204(), 4);
        }
    }

    public void fire(class_3218 world, class_2338 pos, class_2680 state) {
        if (cooldownConfig == -5) {
            cooldownConfig = Integer.parseInt(ConfigUtils.config.getOrDefault("cannon-firing-pause", "40"));
        }
        if (world.method_8450().method_8355(Pirates.PIRATES_IS_LIVE_WORLD)) {
            this.fire((class_1937)world, pos, state, cooldownConfig + (int)(Math.random() * 20.0));
        }
    }

    private static boolean checkShouldFire(class_3218 world, class_2338 pos, class_2680 state) {
        class_2382 raycastStart = ((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10163();
        if (!(world.method_8320(pos.method_10081(raycastStart)).method_26204() instanceof class_2315) || world.method_8320(pos.method_10081(raycastStart)).method_11654((class_2769)class_2741.field_12525) != state.method_11654((class_2769)class_2741.field_12525)) {
            return false;
        }
        class_3959 context = new class_3959(VSGameUtilsKt.toWorldCoordinates((class_1937)world, (class_243)class_243.method_24953((class_2382)pos.method_10081(raycastStart.method_35862(2)))), VSGameUtilsKt.toWorldCoordinates((class_1937)world, (class_243)class_243.method_24953((class_2382)pos.method_10081(raycastStart.method_35862(32)))), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, null);
        class_3965 result = world.method_17742(context);
        ServerShip thisShip = VSGameUtilsKt.getShipManagingPos((class_3218)world, (class_2338)result.method_17777());
        if (thisShip != null) {
            class_268 team = world.method_14170().method_1164(thisShip.getSlug());
            if (team != null) {
                ServerShip otherShip = VSGameUtilsKt.getShipManagingPos((class_3218)world, (class_2338)result.method_17777());
                class_268 otherTeam = world.method_14170().method_1164(otherShip.getSlug());
                if (otherTeam != null) {
                    return !team.method_1206((class_270)otherTeam);
                }
            }
            return true;
        }
        return false;
    }
}

