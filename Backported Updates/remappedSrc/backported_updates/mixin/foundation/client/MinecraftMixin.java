/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1661
 *  net.minecraft.class_1799
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_310
 *  net.minecraft.class_3966
 *  net.minecraft.class_636
 *  net.minecraft.class_746
 *  org.jetbrains.annotations.Nullable
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.foundation.client;

import backported.updates.foundation.common.events.EntityEvents;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1661;
import net.minecraft.class_1799;
import net.minecraft.class_239;
import net.minecraft.class_310;
import net.minecraft.class_3966;
import net.minecraft.class_636;
import net.minecraft.class_746;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_310.class})
public class MinecraftMixin {
    @Shadow
    @Nullable
    public class_239 field_1765;
    @Shadow
    @Nullable
    public class_746 field_1724;
    @Shadow
    @Nullable
    public class_636 field_1761;

    @Inject(method={"pickBlock"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$pickUpEntity(CallbackInfo ci) {
        if (this.field_1765 != null && this.field_1765.method_17783() == class_239.class_240.field_1331) {
            boolean isCreative = this.field_1724.method_31549().field_7477;
            class_1799[] pickResult = new class_1799[]{class_1799.field_8037};
            if (!isCreative) {
                return;
            }
            class_1297 entity = ((class_3966)this.field_1765).method_17782();
            EntityEvents.ON_PICK.invoker().onPickUp(entity, stack -> {
                pickResult[0] = stack;
            });
            if (!pickResult[0].method_7960()) {
                class_1661 inventory = this.field_1724.method_31548();
                inventory.method_7374(pickResult[0]);
                this.field_1761.method_2909(this.field_1724.method_5998(class_1268.field_5808), 36 + inventory.field_7545);
                ci.cancel();
            }
        }
    }
}

