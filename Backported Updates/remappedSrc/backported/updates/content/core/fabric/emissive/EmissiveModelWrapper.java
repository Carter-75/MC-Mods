/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel
 *  net.fabricmc.fabric.api.renderer.v1.render.RenderContext
 *  net.minecraft.class_1087
 *  net.minecraft.class_1799
 *  net.minecraft.class_1920
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_5819
 *  net.minecraft.class_777
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.core.fabric.emissive;

import backported.updates.content.client.util.EmissiveQuad;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.class_1087;
import net.minecraft.class_1799;
import net.minecraft.class_1920;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_5819;
import net.minecraft.class_777;
import org.jetbrains.annotations.Nullable;

public class EmissiveModelWrapper
extends ForwardingBakedModel {
    private final class_1087 emissiveModel;

    public EmissiveModelWrapper(class_1087 baseModel, class_1087 emissiveModel) {
        this.wrapped = baseModel;
        this.emissiveModel = emissiveModel;
    }

    public boolean isVanillaAdapter() {
        return false;
    }

    public void emitBlockQuads(class_1920 blockView, class_2680 state, class_2338 pos, Supplier<class_5819> randomSupplier, RenderContext context) {
        super.emitBlockQuads(blockView, state, pos, randomSupplier, context);
        context.pushTransform(quad -> {
            quad.lightmap(0, 0xF000F0);
            quad.lightmap(1, 0xF000F0);
            quad.lightmap(2, 0xF000F0);
            quad.lightmap(3, 0xF000F0);
            return true;
        });
        if (this.emissiveModel instanceof ForwardingBakedModel) {
            this.emissiveModel.emitBlockQuads(blockView, state, pos, randomSupplier, context);
        } else {
            class_2350.method_42013().forEach(d -> context.fallbackConsumer().accept(this.emissiveModel));
            context.fallbackConsumer().accept(this.emissiveModel);
        }
        context.popTransform();
    }

    public void emitItemQuads(class_1799 stack, Supplier<class_5819> randomSupplier, RenderContext context) {
        super.emitItemQuads(stack, randomSupplier, context);
        context.pushTransform(quad -> {
            quad.lightmap(0, 0xF000F0);
            quad.lightmap(1, 0xF000F0);
            quad.lightmap(2, 0xF000F0);
            quad.lightmap(3, 0xF000F0);
            return true;
        });
        if (this.emissiveModel instanceof ForwardingBakedModel) {
            this.emissiveModel.emitItemQuads(stack, randomSupplier, context);
        } else {
            context.fallbackConsumer().accept(this.emissiveModel);
        }
        context.popTransform();
    }

    public List<class_777> method_4707(@Nullable class_2680 state, @Nullable class_2350 face, class_5819 random) {
        ArrayList<class_777> quads = new ArrayList<class_777>(this.wrapped.method_4707(state, face, random));
        List emissiveQuads = this.emissiveModel.method_4707(state, face, random);
        for (class_777 quad : emissiveQuads) {
            quads.add(new EmissiveQuad(quad));
        }
        return quads;
    }
}

