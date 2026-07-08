/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.core.helper.fabric.DataSerializerRegistryImpl;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={TrackedDataHandlerRegistry.class})
public class EntityDataSerializersMixin {
    @Inject(method={"get"}, at={@At(value="TAIL")}, cancellable=true)
    private static void getSerializer(int id, CallbackInfoReturnable<TrackedDataHandler<?>> cir) {
        TrackedDataHandler serializer = (TrackedDataHandler)cir.getReturnValue();
        if (serializer == null) {
            cir.setReturnValue(DataSerializerRegistryImpl.getSerializer(id));
        }
    }

    @Inject(method={"getId"}, at={@At(value="TAIL")}, cancellable=true)
    private static void getSerializedId(TrackedDataHandler<?> serializer, CallbackInfoReturnable<Integer> cir) {
        int id = (Integer)cir.getReturnValue();
        if (id < 0) {
            cir.setReturnValue(DataSerializerRegistryImpl.getSerializedId(serializer, id));
        }
    }
}

