/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1928
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_9817
 *  net.minecraft.class_9817$class_9818
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.LeashDataExtension;
import backported.updates.content.common.api.leash.LeashExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1928;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_9817;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_9817.class})
public interface LeashableMixin
extends LeashExtension {
    @Shadow
    private static <E extends class_1297> void method_60958(E entity, class_9817.class_9818 leashData) {
    }

    @Inject(method={"tickLeash"}, at={@At(value="HEAD")}, cancellable=true)
    private static <E extends class_1297> void onTickLeash(E entity, CallbackInfo ci) {
        class_9817.class_9818 data = ((class_9817)entity).method_60955();
        if (data != null && data.field_52218 != null) {
            LeashableMixin.method_60958(entity, data);
        }
        if (data != null && data.field_52217 != null) {
            if (!entity.method_5805() || !data.field_52217.method_5805()) {
                ((class_9817)entity).method_5932(true, entity.method_37908().method_8450().method_8355(class_1928.field_19393));
            }
            class_1297 holder = ((class_9817)entity).method_60952();
            LeashExtension leashed = (LeashExtension)entity;
            if (holder != null && holder.method_37908() == entity.method_37908()) {
                double distance = leashed.vb$leashDistanceTo(holder);
                leashed.vb$whenLeashedTo(holder);
                if (distance > leashed.vb$leashSnapDistance()) {
                    entity.method_37908().method_8396(null, holder.method_24515(), class_3417.field_15184, class_3419.field_15254, 1.0f, 1.0f);
                    ((class_9817)entity).method_60970();
                } else if (distance > leashed.vb$leashElasticDistance() - (double)holder.method_17681() - (double)entity.method_17681() && leashed.vb$checkElasticInteractions(holder, data)) {
                    leashed.vb$onElasticLeashPull();
                } else {
                    ((class_9817)entity).method_60963(holder);
                }
                LeashDataExtension leashData = (LeashDataExtension)data;
                entity.method_36456((float)((double)entity.method_36454() - leashData.angularMomentum()));
                leashData.setAngularMomentum(leashData.angularMomentum() * (double)LeashExtension.vb$angularFriction(entity));
            }
        }
        ci.cancel();
    }
}

