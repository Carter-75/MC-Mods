/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap$Builder
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1921
 *  net.minecraft.class_2484$class_2485
 *  net.minecraft.class_2960
 *  net.minecraft.class_5598
 *  net.minecraft.class_5599
 *  net.minecraft.class_5601
 *  net.minecraft.class_630
 *  net.minecraft.class_836
 *  net.minecraft.class_9296
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
import net.minecraft.class_1921;
import net.minecraft.class_2484;
import net.minecraft.class_2960;
import net.minecraft.class_5598;
import net.minecraft.class_5599;
import net.minecraft.class_5601;
import net.minecraft.class_630;
import net.minecraft.class_836;
import net.minecraft.class_9296;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={class_836.class})
public class SkullBlockRendererMixin {
    @Inject(method={"createSkullRenderers"}, at={@At(value="INVOKE", target="Lcom/google/common/collect/ImmutableMap$Builder;put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;", ordinal=5)}, locals=LocalCapture.CAPTURE_FAILHARD)
    private static void addSkullModels(class_5599 models, CallbackInfoReturnable<Map<class_2484.class_2485, class_5598>> cir, ImmutableMap.Builder<class_2484.class_2485, class_5598> builder) {
        for (Map.Entry<class_2484.class_2485, Pair<Function<class_630, class_5598>, class_5601>> entry : GameRenderingImpl.MODEL_BY_SKULL.entrySet()) {
            builder.put((Object)entry.getKey(), (Object)((class_5598)((Function)entry.getValue().getFirst()).apply(models.method_32072((class_5601)entry.getValue().getSecond()))));
        }
    }

    @Inject(method={"getRenderType"}, at={@At(value="HEAD")}, cancellable=true)
    private static void getRenderType(class_2484.class_2485 type, class_9296 profile, CallbackInfoReturnable<class_1921> cir) {
        for (Map.Entry<class_2484.class_2485, class_2960> entry : GameRenderingImpl.TEXTURE_BY_SKULL.entrySet()) {
            if (entry.getKey() != type) continue;
            cir.setReturnValue((Object)class_1921.method_28116((class_2960)entry.getValue()));
        }
    }
}

