/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1352
 *  net.minecraft.class_1372
 *  net.minecraft.class_1439
 *  net.minecraft.class_1646
 *  net.minecraft.class_1802
 *  net.minecraft.class_238
 *  net.minecraft.class_4051
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.copper;

import backported.updates.copper.entity.CopperGolemEntity;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1372;
import net.minecraft.class_1439;
import net.minecraft.class_1646;
import net.minecraft.class_1802;
import net.minecraft.class_238;
import net.minecraft.class_4051;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1372.class})
public abstract class OfferFlowerGoalMixin
extends class_1352 {
    @Shadow
    @Final
    private class_1439 field_6542;
    @Shadow
    private class_1646 field_6544;
    @Shadow
    private int field_6543;
    @Unique
    private static final class_4051 copperagebackport$OFFER_TARGET_CONTEXT = class_4051.method_36626().method_18418(6.0);
    @Unique
    private CopperGolemEntity copperagebackport$copperGolemTarget = null;

    @Inject(method={"canUse"}, at={@At(value="RETURN")}, cancellable=true)
    private void copperagebackport$canUseWithCopperGolem(CallbackInfoReturnable<Boolean> cir) {
        if (((Boolean)cir.getReturnValue()).booleanValue()) {
            this.copperagebackport$copperGolemTarget = null;
            return;
        }
        class_238 searchBox = this.field_6542.method_5829().method_1009(6.0, 2.0, 6.0);
        List copperGolems = this.field_6542.method_37908().method_8390(CopperGolemEntity.class, searchBox, entity -> copperagebackport$OFFER_TARGET_CONTEXT.method_18419((class_1309)this.field_6542, (class_1309)entity));
        if (!copperGolems.isEmpty()) {
            CopperGolemEntity nearest = null;
            double nearestDist = Double.MAX_VALUE;
            for (CopperGolemEntity cg : copperGolems) {
                double dist = this.field_6542.method_5858((class_1297)cg);
                if (!(dist < nearestDist)) continue;
                nearestDist = dist;
                nearest = cg;
            }
            if (nearest != null) {
                this.copperagebackport$copperGolemTarget = nearest;
                cir.setReturnValue((Object)true);
            }
        }
    }

    @Inject(method={"start"}, at={@At(value="TAIL")})
    private void copperagebackport$startWithCopperGolem(CallbackInfo ci) {
        if (this.copperagebackport$copperGolemTarget != null) {
            this.field_6543 = 100;
        }
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")}, cancellable=true)
    private void copperagebackport$tickWithCopperGolem(CallbackInfo ci) {
        if (this.copperagebackport$copperGolemTarget != null) {
            this.field_6542.method_5988().method_6226((class_1297)this.copperagebackport$copperGolemTarget, 30.0f, 30.0f);
            --this.field_6543;
            ci.cancel();
        }
    }

    @Inject(method={"stop"}, at={@At(value="HEAD")})
    private void copperagebackport$giveFlowerToCopperGolem(CallbackInfo ci) {
        if (this.copperagebackport$copperGolemTarget != null && this.field_6543 <= 0) {
            CopperGolemEntity copperGolem = this.copperagebackport$copperGolemTarget;
            class_238 searchBox = this.field_6542.method_5829().method_1009(6.0, 2.0, 6.0);
            boolean inRange = searchBox.method_994(copperGolem.method_5829());
            boolean slotEmpty = copperGolem.method_6118(CopperGolemEntity.EQUIPMENT_SLOT_ANTENNA).method_7960();
            if (inRange && slotEmpty) {
                copperGolem.method_5673(CopperGolemEntity.EQUIPMENT_SLOT_ANTENNA, class_1802.field_8880.method_7854());
            }
            this.copperagebackport$copperGolemTarget = null;
        }
    }
}

