/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1690
 *  net.minecraft.class_1690$class_1692
 *  net.minecraft.class_2960
 *  net.minecraft.class_4595
 *  net.minecraft.class_881
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.foundation.fabric.client.renderer;

import backported.updates.foundation.client.api.model.CustomBoatModel;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.datafixers.util.Pair;
import java.util.Map;
import net.minecraft.class_1690;
import net.minecraft.class_2960;
import net.minecraft.class_4595;
import net.minecraft.class_881;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_881.class})
public class BoatRendererMixin {
    @Inject(method={"getTextureLocation(Lnet/minecraft/world/entity/vehicle/Boat;)Lnet/minecraft/resources/ResourceLocation;"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$getCustomModelTexture(class_1690 boat, CallbackInfoReturnable<class_2960> cir) {
        BoatRendererMixin boatRendererMixin = this;
        if (boatRendererMixin instanceof CustomBoatModel) {
            CustomBoatModel model = (CustomBoatModel)((Object)boatRendererMixin);
            cir.setReturnValue((Object)((class_2960)model.getModelWithLocation(boat).getFirst()));
        }
    }

    @WrapOperation(method={"render(Lnet/minecraft/world/entity/vehicle/Boat;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V"}, at={@At(value="INVOKE", target="Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;")})
    private Object platform$getCustomModel(Map<class_1690.class_1692, Pair<class_2960, class_4595<class_1690>>> instance, Object o, Operation<Pair<class_2960, class_4595<class_1690>>> original, class_1690 boat) {
        BoatRendererMixin boatRendererMixin = this;
        if (boatRendererMixin instanceof CustomBoatModel) {
            CustomBoatModel model = (CustomBoatModel)((Object)boatRendererMixin);
            return model.getModelWithLocation(boat);
        }
        return original.call(new Object[]{instance, o});
    }
}

