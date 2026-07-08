/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.block.SkullBlock$SkullType
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.block.entity.SkullBlockEntityModel
 *  net.minecraft.client.render.entity.model.EntityModelLoader
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 *  net.minecraft.client.model.ModelPart
 *  net.minecraft.client.render.block.entity.SkullBlockEntityRenderer
 *  net.minecraft.component.type.ProfileComponent
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package backported_updates.mixin.foundation.fabric.client;

import backported.updates.foundation.client.fabric.GameRenderingImpl;
import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.util.Pair;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.block.SkullBlock;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.component.type.ProfileComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={SkullBlockEntityRenderer.class})
public class SkullBlockRendererMixin {
    @Inject(method={"getModels"}, at={@At(value="INVOKE", target="Lcom/google/common/collect/ImmutableMap$Builder;put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;", ordinal=5, remap=false)}, locals=LocalCapture.CAPTURE_FAILHARD)
    private static void addSkullModels(EntityModelLoader models, CallbackInfoReturnable<Map<SkullBlock.SkullType, SkullBlockEntityModel>> cir, ImmutableMap.Builder<SkullBlock.SkullType, SkullBlockEntityModel> builder) {
        for (Map.Entry<SkullBlock.SkullType, Pair<Function<ModelPart, SkullBlockEntityModel>, EntityModelLayer>> entry : GameRenderingImpl.MODEL_BY_SKULL.entrySet()) {
            builder.put(entry.getKey(), ((SkullBlockEntityModel)((Function)entry.getValue().getFirst()).apply(models.getModelPart((EntityModelLayer)entry.getValue().getSecond()))));
        }
    }

    @Inject(method={"getRenderLayer"}, at={@At(value="HEAD")}, cancellable=true)
    private static void getRenderType(SkullBlock.SkullType type, ProfileComponent profile, CallbackInfoReturnable<RenderLayer> cir) {
        for (Map.Entry<SkullBlock.SkullType, Identifier> entry : GameRenderingImpl.TEXTURE_BY_SKULL.entrySet()) {
            if (entry.getKey() != type) continue;
            cir.setReturnValue(RenderLayer.getEntityCutoutNoCullZOffset(entry.getValue()));
        }
    }
}

