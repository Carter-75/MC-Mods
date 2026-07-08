/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel
 *  net.fabricmc.fabric.api.renderer.v1.render.RenderContext
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.client.render.model.BakedQuad
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.core.fabric.emissive;

import backported.updates.content.client.util.EmissiveQuad;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockRenderView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.random.Random;
import net.minecraft.client.render.model.BakedQuad;
import org.jetbrains.annotations.Nullable;

public class EmissiveModelWrapper
extends ForwardingBakedModel {
    private final BakedModel emissiveModel;

    public EmissiveModelWrapper(BakedModel baseModel, BakedModel emissiveModel) {
        this.wrapped = baseModel;
        this.emissiveModel = emissiveModel;
    }

    public boolean isVanillaAdapter() {
        return false;
    }

    public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<Random> randomSupplier, RenderContext context) {
        super.emitBlockQuads(blockView, state, pos, randomSupplier, context);
        context.pushTransform(quad -> {
            quad.lightmap(0, 0xF000F0);
            quad.lightmap(1, 0xF000F0);
            quad.lightmap(2, 0xF000F0);
            quad.lightmap(3, 0xF000F0);
            return true;
        });
        if (this.emissiveModel instanceof FabricBakedModel) {
            ((FabricBakedModel) this.emissiveModel).emitBlockQuads(blockView, state, pos, randomSupplier, context);
        }
        context.popTransform();
    }

    public void emitItemQuads(ItemStack stack, Supplier<Random> randomSupplier, RenderContext context) {
        super.emitItemQuads(stack, randomSupplier, context);
        context.pushTransform(quad -> {
            quad.lightmap(0, 0xF000F0);
            quad.lightmap(1, 0xF000F0);
            quad.lightmap(2, 0xF000F0);
            quad.lightmap(3, 0xF000F0);
            return true;
        });
        if (this.emissiveModel instanceof FabricBakedModel) {
            ((FabricBakedModel) this.emissiveModel).emitItemQuads(stack, randomSupplier, context);
        }
        context.popTransform();
    }

    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        ArrayList<BakedQuad> quads = new ArrayList<BakedQuad>(this.wrapped.getQuads(state, face, random));
        List<BakedQuad> emissiveQuads = this.emissiveModel.getQuads(state, face, random);
        for (BakedQuad quad : emissiveQuads) {
            quads.add(new EmissiveQuad(quad));
        }
        return quads;
    }
}

