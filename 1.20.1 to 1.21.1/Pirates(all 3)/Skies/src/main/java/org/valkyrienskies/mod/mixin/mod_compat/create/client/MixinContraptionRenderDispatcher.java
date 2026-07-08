/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.render.ContraptionEntityRenderer
 *  dev.engine_room.flywheel.lib.transform.PoseTransformStack
 *  dev.engine_room.flywheel.lib.transform.Translate
 *  net.minecraft.class_2382
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.contraptions.render.ContraptionEntityRenderer;
import dev.engine_room.flywheel.lib.transform.PoseTransformStack;
import dev.engine_room.flywheel.lib.transform.Translate;
import net.minecraft.class_2382;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.common.VSClientGameUtils;

@Mixin(value={ContraptionEntityRenderer.class})
public abstract class MixinContraptionRenderDispatcher {
    @Redirect(method={"renderActors"}, at=@At(value="INVOKE", target="Ldev/engine_room/flywheel/lib/transform/PoseTransformStack;translate(Lnet/minecraft/core/Vec3i;)Ldev/engine_room/flywheel/lib/transform/Translate;"))
    private static Translate redirectTranslate(PoseTransformStack instance, class_2382 vec3i) {
        VSClientGameUtils.transformRenderIfInShipyard(instance.unwrap(), vec3i.method_10263(), vec3i.method_10264(), vec3i.method_10260());
        return instance;
    }
}

