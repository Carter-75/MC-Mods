/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.core.helper.fabric.DataSerializerRegistryImpl;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_2943.class})
public class EntityDataSerializersMixin {
    @Inject(method={"getSerializer"}, at={@At(value="TAIL")}, cancellable=true)
    private static void getSerializer(int id, CallbackInfoReturnable<class_2941<?>> cir) {
        class_2941 serializer = (class_2941)cir.getReturnValue();
        if (serializer == null) {
            cir.setReturnValue(DataSerializerRegistryImpl.getSerializer(id));
        }
    }

    @Inject(method={"getSerializedId"}, at={@At(value="TAIL")}, cancellable=true)
    private static void getSerializedId(class_2941<?> serializer, CallbackInfoReturnable<Integer> cir) {
        int id = (Integer)cir.getReturnValue();
        if (id < 0) {
            cir.setReturnValue((Object)DataSerializerRegistryImpl.getSerializedId(serializer, id));
        }
    }
}

