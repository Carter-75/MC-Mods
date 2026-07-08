/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.entity.vehicle.BoatEntity$Type
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.model.CompositeEntityModel
 *  net.minecraft.client.render.entity.BoatEntityRenderer
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
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={BoatEntityRenderer.class})
public class BoatRendererMixin {
    @Inject(method={"getTexture"}, at={@At(value="HEAD")}, cancellable=true)
    private void platform$getCustomModelTexture(BoatEntity boat, CallbackInfoReturnable<Identifier> cir) {
        BoatRendererMixin boatRendererMixin = this;
        if (boatRendererMixin instanceof CustomBoatModel) {
            CustomBoatModel model = (CustomBoatModel)(boatRendererMixin);
            cir.setReturnValue((model.getModelWithLocation(boat).getFirst()));
        }
    }

    @WrapOperation(method={"render"}, at={@At(value="INVOKE", target="Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;")})
    private Object platform$getCustomModel(Map<BoatEntity.Type, Pair<Identifier, CompositeEntityModel<BoatEntity>>> instance, Object o, Operation<Pair<Identifier, CompositeEntityModel<BoatEntity>>> original, BoatEntity boat) {
        BoatRendererMixin boatRendererMixin = this;
        if (boatRendererMixin instanceof CustomBoatModel) {
            CustomBoatModel model = (CustomBoatModel)(boatRendererMixin);
            return model.getModelWithLocation(boat);
        }
        return original.call(new Object[]{instance, o});
    }
}

