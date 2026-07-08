/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.GameRules
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.entity.Leashable
 *  net.minecraft.entity.Leashable$LeashData
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.LeashDataExtension;
import backported.updates.content.common.api.leash.LeashExtension;
import net.minecraft.entity.Entity;
import net.minecraft.world.GameRules;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.entity.Leashable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Leashable.class})
public interface LeashableMixin
extends LeashExtension {
    @Shadow
    private static <E extends Entity> void resolveLeashData(E entity, Leashable.LeashData leashData) {
    }

    @Inject(method={"tickLeash"}, at={@At(value="HEAD")}, cancellable=true)
    private static <E extends Entity> void onTickLeash(E entity, CallbackInfo ci) {
        Leashable.LeashData data = ((Leashable)entity).getLeashData();
        if (data != null && data.unresolvedLeashData != null) {
            LeashableMixin.resolveLeashData(entity, data);
        }
        if (data != null && data.leashHolder != null) {
            if (!entity.isAlive() || !data.leashHolder.isAlive()) {
                ((Leashable)entity).detachLeash(true, entity.getWorld().getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS));
            }
            Entity holder = ((Leashable)entity).getLeashHolder();
            LeashExtension leashed = (LeashExtension)entity;
            if (holder != null && holder.getWorld() == entity.getWorld()) {
                double distance = leashed.vb$leashDistanceTo(holder);
                leashed.vb$whenLeashedTo(holder);
                if (distance > leashed.vb$leashSnapDistance()) {
                    entity.getWorld().playSound(null, holder.getBlockPos(), SoundEvents.ENTITY_LEASH_KNOT_BREAK, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    ((Leashable)entity).detachLeash();
                } else if (distance > leashed.vb$leashElasticDistance() - (double)holder.getWidth() - (double)entity.getWidth() && leashed.vb$checkElasticInteractions(holder, data)) {
                    leashed.vb$onElasticLeashPull();
                } else {
                    ((Leashable)entity).onShortLeashTick(holder);
                }
                LeashDataExtension leashData = (LeashDataExtension)(Object)data;
                entity.setYaw((float)((double)entity.getYaw() - leashData.angularMomentum()));
                leashData.setAngularMomentum(leashData.angularMomentum() * (double)LeashExtension.vb$angularFriction(entity));
            }
        }
        ci.cancel();
    }
}

