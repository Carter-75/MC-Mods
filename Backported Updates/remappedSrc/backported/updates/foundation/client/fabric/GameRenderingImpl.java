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
 *  net.minecraft.class_1091
 *  net.minecraft.class_1747
 *  net.minecraft.class_1799
 *  net.minecraft.class_1920
 *  net.minecraft.class_1921
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2396
 *  net.minecraft.class_2484$class_2485
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_322
 *  net.minecraft.class_326
 *  net.minecraft.class_3611
 *  net.minecraft.class_5598
 *  net.minecraft.class_5601
 *  net.minecraft.class_5616
 *  net.minecraft.class_630
 *  net.minecraft.class_707
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
import net.minecraft.class_1091;
import net.minecraft.class_1747;
import net.minecraft.class_1799;
import net.minecraft.class_1920;
import net.minecraft.class_1921;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2484;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_322;
import net.minecraft.class_326;
import net.minecraft.class_3611;
import net.minecraft.class_5598;
import net.minecraft.class_5601;
import net.minecraft.class_5616;
import net.minecraft.class_630;
import net.minecraft.class_707;

public class GameRenderingImpl {
    public static final Map<class_2484.class_2485, class_2960> TEXTURE_BY_SKULL = new ConcurrentHashMap<class_2484.class_2485, class_2960>();
    public static final Map<class_2484.class_2485, Pair<Function<class_630, class_5598>, class_5601>> MODEL_BY_SKULL = new ConcurrentHashMap<class_2484.class_2485, Pair<Function<class_630, class_5598>, class_5601>>();

    public static void registerBlockColors(Consumer<GameRendering.BlockColorEvent> listener) {
        listener.accept(new GameRendering.BlockColorEvent(){

            @Override
            public void register(class_322 color, class_2248 ... blocks) {
                ColorProviderRegistry.BLOCK.register((Object)color, (Object[])blocks);
            }

            @Override
            public int getColor(class_2680 state, class_1920 level, class_2338 pos, int tint) {
                class_322 colors = (class_322)ColorProviderRegistry.BLOCK.get((Object)state.method_26204());
                return colors != null ? colors.getColor(state, level, pos, tint) : -1;
            }
        });
    }

    public static void registerItemColors(Consumer<GameRendering.ItemColorEvent> listener) {
        listener.accept(new GameRendering.ItemColorEvent(){

            @Override
            public void register(class_326 color, class_1935 ... items) {
                ColorProviderRegistry.ITEM.register((Object)color, (Object[])items);
            }

            @Override
            public int getColor(class_1799 stack, int tint) {
                class_2680 state = ((class_1747)stack.method_7909()).method_7711().method_9564();
                return class_310.method_1551().method_1505().method_1697(state, null, null, tint);
            }
        });
    }

    public static void registerBlockRenderers(Consumer<GameRendering.BlockRendererEvent> listener) {
        listener.accept(new GameRendering.BlockRendererEvent(){

            @Override
            public void register(class_1921 type, class_2248 ... blocks) {
                BlockRenderLayerMap.INSTANCE.putBlocks(type, blocks);
            }

            @Override
            public void register(class_1921 type, class_3611 ... fluids) {
                BlockRenderLayerMap.INSTANCE.putFluids(type, fluids);
            }
        });
    }

    public static void registerBlockEntityRenderers(Consumer<GameRendering.BlockEntityRendererEvent> listener) {
        listener.accept(class_5616::method_32144);
    }

    public static void registerEntityRenderers(Consumer<GameRendering.EntityRendererEvent> listener) {
        listener.accept(EntityRendererRegistry::register);
    }

    public static void registerModelLayers(Consumer<GameRendering.ModelLayerEvent> listener) {
        listener.accept((layer, definition) -> EntityModelLayerRegistry.registerModelLayer((class_5601)layer, ((Supplier)definition)::get));
    }

    public static void registerSpecialModels(Consumer<GameRendering.SpecialModelEvent> listener) {
        GameRendering.SpecialModelEvent event = new GameRendering.SpecialModelEvent(){

            @Override
            public void register(class_2960 model) {
                ModelLoadingPlugin.register(context -> context.addModels(new class_2960[]{model}));
            }

            @Override
            public void register(class_2960 ... models) {
                for (class_2960 model : models) {
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
                public void register(class_2960 original, class_2960 override, boolean condition) {
                    GameRendering.ModelOverrideEvent.super.register(original, override, condition);
                    plugin.addModels(new class_2960[]{GameRenderingImpl.wrapModel(override)});
                }
            });
            plugin.modifyModelAfterBake().register((model, context) -> {
                class_2960 original;
                class_2960 override;
                class_1091 toLevel = context.topLevelId();
                if (toLevel != null && "inventory".equals(toLevel.method_4740()) && (override = GameRendering.MODEL_OVERRIDES.get(original = toLevel.comp_2875())) != null) {
                    try {
                        class_2960 overrideModel = GameRenderingImpl.wrapModel(override);
                        return context.baker().method_45873(overrideModel, context.settings());
                    }
                    catch (Exception e) {
                        Platform.LOGGER.error("Failed to load override model: {}", (Object)override);
                    }
                }
                return model;
            });
        });
    }

    private static class_2960 wrapModel(class_2960 model) {
        return class_2960.method_60655((String)model.method_12836(), (String)("item/" + model.method_12832()));
    }

    public static void registerSkullRenderers(Consumer<GameRendering.SkullRendererEvent> listener) {
        GameRendering.SkullRendererEvent event = new GameRendering.SkullRendererEvent(){

            @Override
            public void registerSkullModel(class_2484.class_2485 type, Function<class_630, class_5598> model, class_5601 layer) {
                MODEL_BY_SKULL.put(type, (Pair<Function<class_630, class_5598>, class_5601>)new Pair(model, (Object)layer));
            }

            @Override
            public void registerSkullTexture(class_2484.class_2485 type, class_2960 texture) {
                TEXTURE_BY_SKULL.put(type, texture);
            }
        };
        listener.accept(event);
    }

    public static void registerParticleFactories(Consumer<GameRendering.ParticleFactoryEvent> listener) {
        GameRendering.ParticleFactoryEvent event = new GameRendering.ParticleFactoryEvent(){

            @Override
            public <T extends class_2394, P extends class_2396<T>> void register(Supplier<P> type, class_707<T> provider) {
                ParticleFactoryRegistry.getInstance().register((class_2396)type.get(), provider);
            }

            @Override
            public <T extends class_2394, P extends class_2396<T>> void register(Supplier<P> type, GameRendering.ParticleFactoryEvent.Factory<T> factory) {
                ParticleFactoryRegistry.getInstance().register((class_2396)type.get(), factory::create);
            }
        };
        listener.accept(event);
    }
}

