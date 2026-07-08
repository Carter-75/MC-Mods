/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.Leashable
 *  net.minecraft.entity.Leashable$LeashData
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.minecraft.entity.Entity;
import net.minecraft.entity.Leashable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={Leashable.class})
public interface LeashableMixin {
    @Invoker
    public static void callResolveLeashData(Entity entity, Leashable.LeashData leashData) {
    }

    @Invoker
    public static void callDetachLeash(Entity entity, boolean broadcast, boolean drop) {
    }

    @Inject(method={"tickLeash"}, at={@At(value="HEAD")}, cancellable=true)
    private static <E extends Entity> void vb$tickLeash(E entity, CallbackInfo ci) {
        if (entity instanceof HappyGhast) {
            ci.cancel();
            Leashable.LeashData data = ((Leashable)entity).getLeashData();
            if (data != null && data.unresolvedLeashData != null) {
                LeashableMixin.callResolveLeashData(entity, data);
            }
            if (data != null && data.leashHolder != null) {
                Entity holder;
                if (!entity.isAlive() || !data.leashHolder.isAlive()) {
                    LeashableMixin.callDetachLeash(entity, true, true);
                }
                if ((holder = ((Leashable)entity).getLeashHolder()) != null && holder.getWorld() == entity.getWorld()) {
                    float distanceFromHolder = entity.distanceTo(holder);
                    if (!((Leashable)entity).beforeLeashTick(holder, distanceFromHolder)) {
                        return;
                    }
                    if ((double)distanceFromHolder > 16.0) {
                        ((Leashable)entity).detachLeash();
                    } else if ((double)distanceFromHolder > 12.0) {
                        ((Leashable)entity).applyLeashElasticity(holder, distanceFromHolder);
                        entity.limitFallDistance();
                    } else {
                        ((Leashable)entity).onShortLeashTick(holder);
                    }
                }
            }
        }
    }
}

