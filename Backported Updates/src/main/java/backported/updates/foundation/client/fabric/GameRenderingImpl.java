/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
 *  net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin
 *  net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.item.BlockItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleType
 *  net.minecraft.block.SkullBlock$SkullType
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.color.block.BlockColorProvider
 *  net.minecraft.client.color.item.ItemColorProvider
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.client.render.block.entity.SkullBlockEntityModel
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 *  net.minecraft.client.render.block.entity.BlockEntityRendererFactories
 *  net.minecraft.client.model.ModelPart
 *  net.minecraft.client.particle.ParticleFactory
 */
package backported.updates.foundation.client.fabric;

import backported.updates.foundation.Platform;
import backported.updates.foundation.client.GameRendering;
import com.mojang.datafixers.util.Pair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockRenderView;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.model.TexturedModelData;

public class GameRenderingImpl {
    public static final Map<SkullBlock.SkullType, Identifier> TEXTURE_BY_SKULL = new ConcurrentHashMap<SkullBlock.SkullType, Identifier>();
    public static final Map<SkullBlock.SkullType, Pair<Function<ModelPart, SkullBlockEntityModel>, EntityModelLayer>> MODEL_BY_SKULL = new ConcurrentHashMap<SkullBlock.SkullType, Pair<Function<ModelPart, SkullBlockEntityModel>, EntityModelLayer>>();

    public static void registerBlockColors(Consumer<GameRendering.BlockColorEvent> listener) {
        listener.accept(new GameRendering.BlockColorEvent(){

            @Override
            public void register(BlockColorProvider color, Block ... blocks) {
                ColorProviderRegistry.BLOCK.register(color, blocks);
            }

            @Override
            public int getColor(BlockState state, BlockRenderView level, BlockPos pos, int tint) {
                BlockColorProvider colors = (BlockColorProvider)ColorProviderRegistry.BLOCK.get(state.getBlock());
                return colors != null ? colors.getColor(state, level, pos, tint) : -1;
            }
        });
    }

    public static void registerItemColors(Consumer<GameRendering.ItemColorEvent> listener) {
        listener.accept(new GameRendering.ItemColorEvent(){

            @Override
            public void register(ItemColorProvider color, ItemConvertible ... items) {
                ColorProviderRegistry.ITEM.register(color, items);
            }

            @Override
            public int getColor(ItemStack stack, int tint) {
                BlockState state = ((BlockItem)stack.getItem()).getBlock().getDefaultState();
                return MinecraftClient.getInstance().getBlockColors().getColor(state, null, null, tint);
            }
        });
    }

    public static void registerBlockRenderers(Consumer<GameRendering.BlockRendererEvent> listener) {
        listener.accept(new GameRendering.BlockRendererEvent(){

            @Override
            public void register(RenderLayer type, Block ... blocks) {
                BlockRenderLayerMap.INSTANCE.putBlocks(type, blocks);
            }

            @Override
            public void register(RenderLayer type, Fluid ... fluids) {
                BlockRenderLayerMap.INSTANCE.putFluids(type, fluids);
            }
        });
    }

    public static void registerBlockEntityRenderers(Consumer<GameRendering.BlockEntityRendererEvent> listener) {
        listener.accept(BlockEntityRendererFactories::register);
    }

    public static void registerEntityRenderers(Consumer<GameRendering.EntityRendererEvent> listener) {
        listener.accept(EntityRendererRegistry::register);
    }

    public static void registerModelLayers(Consumer<GameRendering.ModelLayerEvent> listener) {
        listener.accept((layer, definition) -> EntityModelLayerRegistry.registerModelLayer((EntityModelLayer)layer, ((Supplier<TexturedModelData>)definition)::get));
    }

    public static void registerSpecialModels(Consumer<GameRendering.SpecialModelEvent> listener) {
        GameRendering.SpecialModelEvent event = new GameRendering.SpecialModelEvent(){

            @Override
            public void register(Identifier model) {
                ModelLoadingPlugin.register(context -> context.addModels(new Identifier[]{model}));
            }

            @Override
            public void register(Identifier ... models) {
                for (Identifier model : models) {
                    this.register(model);
                }
            }
        };
        listener.accept(event);
    }

    public static void registerModelOverrides(Consumer<GameRendering.ModelOverrideEvent> listener) {
        ModelLoadingPlugin.register(plugin -> {
            listener.accept(new GameRendering.ModelOverrideEvent(){

                @Override
                public void register(Identifier original, Identifier override, boolean condition) {
                    GameRendering.ModelOverrideEvent.super.register(original, override, condition);
                    plugin.addModels(new Identifier[]{GameRenderingImpl.wrapModel(override)});
                }
            });
            plugin.modifyModelAfterBake().register((model, context) -> {
                Identifier original;
                Identifier override;
                ModelIdentifier toLevel = context.topLevelId();
                if (toLevel != null && "inventory".equals(toLevel.getVariant()) && (override = GameRendering.MODEL_OVERRIDES.get(original = toLevel.id())) != null) {
                    try {
                        Identifier overrideModel = GameRenderingImpl.wrapModel(override);
                        return context.baker().bake(overrideModel, context.settings());
                    }
                    catch (Exception e) {
                        Platform.LOGGER.error("Failed to load override model: {}", override);
                    }
                }
                return model;
            });
        });
    }

    private static Identifier wrapModel(Identifier model) {
        return Identifier.of((String)model.getNamespace(), (String)("item/" + model.getPath()));
    }

    public static void registerSkullRenderers(Consumer<GameRendering.SkullRendererEvent> listener) {
        GameRendering.SkullRendererEvent event = new GameRendering.SkullRendererEvent(){

            @Override
            public void registerSkullModel(SkullBlock.SkullType type, Function<ModelPart, SkullBlockEntityModel> model, EntityModelLayer layer) {
                MODEL_BY_SKULL.put(type, (Pair<Function<ModelPart, SkullBlockEntityModel>, EntityModelLayer>)new Pair(model, layer));
            }

            @Override
            public void registerSkullTexture(SkullBlock.SkullType type, Identifier texture) {
                TEXTURE_BY_SKULL.put(type, texture);
            }
        };
        listener.accept(event);
    }

    public static void registerParticleFactories(Consumer<GameRendering.ParticleFactoryEvent> listener) {
        GameRendering.ParticleFactoryEvent event = new GameRendering.ParticleFactoryEvent(){

            @Override
            public <T extends ParticleEffect, P extends ParticleType<T>> void register(Supplier<P> type, ParticleFactory<T> provider) {
                ParticleFactoryRegistry.getInstance().register((ParticleType)type.get(), provider);
            }

            @Override
            public <T extends ParticleEffect, P extends ParticleType<T>> void register(Supplier<P> type, GameRendering.ParticleFactoryEvent.Factory<T> factory) {
                ParticleFactoryRegistry.getInstance().register((ParticleType)type.get(), factory::create);
            }
        };
        listener.accept(event);
    }
}

