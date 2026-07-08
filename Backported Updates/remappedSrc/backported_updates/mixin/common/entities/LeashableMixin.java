/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_9817
 *  net.minecraft.class_9817$class_9818
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Invoker
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.minecraft.class_1297;
import net.minecraft.class_9817;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_9817.class})
public interface LeashableMixin {
    @Invoker
    public static void callRestoreLeashFromSave(class_1297 entity, class_9817.class_9818 leashData) {
    }

    @Invoker
    public static void callDropLeash(class_1297 entity, boolean broadcast, boolean drop) {
    }

    @Inject(method={"tickLeash"}, at={@At(value="HEAD")}, cancellable=true)
    private static <E extends class_1297> void vb$tickLeash(E entity, CallbackInfo ci) {
        if (entity instanceof HappyGhast) {
            ci.cancel();
            class_9817.class_9818 data = ((class_9817)entity).method_60955();
            if (data != null && data.field_52218 != null) {
                LeashableMixin.callRestoreLeashFromSave(entity, data);
            }
            if (data != null && data.field_52217 != null) {
                class_1297 holder;
                if (!entity.method_5805() || !data.field_52217.method_5805()) {
                    LeashableMixin.callDropLeash(entity, true, true);
                }
                if ((holder = ((class_9817)entity).method_60952()) != null && holder.method_37908() == entity.method_37908()) {
                    float distanceFromHolder = entity.method_5739(holder);
                    if (!((class_9817)entity).method_60956(holder, distanceFromHolder)) {
                        return;
                    }
                    if ((double)distanceFromHolder > 16.0) {
                        ((class_9817)entity).method_60970();
                    } else if ((double)distanceFromHolder > 12.0) {
                        ((class_9817)entity).method_61162(holder, distanceFromHolder);
                        entity.method_45318();
                    } else {
                        ((class_9817)entity).method_60963(holder);
                    }
                }
            }
        }
    }
}

