/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.entity.ai.goal.IronGolemLookGoal
 *  net.minecraft.entity.passive.IronGolemEntity
 *  net.minecraft.entity.passive.VillagerEntity
 *  net.minecraft.item.Items
 *  net.minecraft.util.math.Box
 *  net.minecraft.entity.ai.TargetPredicate
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.IronGolemLookGoal;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import net.minecraft.entity.ai.TargetPredicate;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={IronGolemLookGoal.class})
public abstract class OfferFlowerGoalMixin
extends Goal {
    @Shadow
    @Final
    private IronGolemEntity golem;
    @Shadow
    private VillagerEntity targetVillager;
    @Shadow
    private int lookCountdown;
    @Unique
    private static final TargetPredicate copperagebackport$OFFER_TARGET_CONTEXT = TargetPredicate.createNonAttackable().setBaseMaxDistance(6.0);
    @Unique
    private CopperGolemEntity copperagebackport$copperGolemTarget = null;

    @Inject(method={"canStart"}, at={@At(value="RETURN")}, cancellable=true)
    private void copperagebackport$canUseWithCopperGolem(CallbackInfoReturnable<Boolean> cir) {
        if (((Boolean)cir.getReturnValue()).booleanValue()) {
            this.copperagebackport$copperGolemTarget = null;
            return;
        }
        Box searchBox = this.golem.getBoundingBox().expand(6.0, 2.0, 6.0);
        List<CopperGolemEntity> copperGolems = this.golem.getWorld().getEntitiesByClass(CopperGolemEntity.class, searchBox, entity -> copperagebackport$OFFER_TARGET_CONTEXT.test((LivingEntity)this.golem, (LivingEntity)entity));
        if (!copperGolems.isEmpty()) {
            CopperGolemEntity nearest = null;
            double nearestDist = Double.MAX_VALUE;
            for (CopperGolemEntity cg : copperGolems) {
                double dist = this.golem.squaredDistanceTo((Entity)cg);
                if (!(dist < nearestDist)) continue;
                nearestDist = dist;
                nearest = cg;
            }
            if (nearest != null) {
                this.copperagebackport$copperGolemTarget = nearest;
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method={"start"}, at={@At(value="TAIL")})
    private void copperagebackport$startWithCopperGolem(CallbackInfo ci) {
        if (this.copperagebackport$copperGolemTarget != null) {
            this.lookCountdown = 100;
        }
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")}, cancellable=true)
    private void copperagebackport$tickWithCopperGolem(CallbackInfo ci) {
        if (this.copperagebackport$copperGolemTarget != null) {
            this.golem.getLookControl().lookAt((Entity)this.copperagebackport$copperGolemTarget, 30.0f, 30.0f);
            --this.lookCountdown;
            ci.cancel();
        }
    }

    @Inject(method={"stop"}, at={@At(value="HEAD")})
    private void copperagebackport$giveFlowerToCopperGolem(CallbackInfo ci) {
        if (this.copperagebackport$copperGolemTarget != null && this.lookCountdown <= 0) {
            CopperGolemEntity copperGolem = this.copperagebackport$copperGolemTarget;
            Box searchBox = this.golem.getBoundingBox().expand(6.0, 2.0, 6.0);
            boolean inRange = searchBox.intersects(copperGolem.getBoundingBox());
            boolean slotEmpty = copperGolem.getEquippedStack(CopperGolemEntity.EQUIPMENT_SLOT_ANTENNA).isEmpty();
            if (inRange && slotEmpty) {
                copperGolem.equipStack(CopperGolemEntity.EQUIPMENT_SLOT_ANTENNA, Items.POPPY.getDefaultStack());
            }
            this.copperagebackport$copperGolemTarget = null;
        }
    }
}

