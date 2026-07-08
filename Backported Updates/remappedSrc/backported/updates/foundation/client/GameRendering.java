/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1091
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1920
 *  net.minecraft.class_1921
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2396
 *  net.minecraft.class_2484$class_2485
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2960
 *  net.minecraft.class_322
 *  net.minecraft.class_326
 *  net.minecraft.class_3611
 *  net.minecraft.class_4002
 *  net.minecraft.class_5598
 *  net.minecraft.class_5601
 *  net.minecraft.class_5607
 *  net.minecraft.class_5614
 *  net.minecraft.class_5617
 *  net.minecraft.class_630
 *  net.minecraft.class_707
 *  net.minecraft.class_7923
 *  net.minecraft.class_811
 *  org.jetbrains.annotations.NotNull
 */
package backported.updates.foundation.client;

import backported.updates.foundation.client.fabric.GameRenderingImpl;
import backported.updates.foundation.client.v2.render.HandHeldItemRenderer;
import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1091;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1920;
import net.minecraft.class_1921;
import net.minecraft.class_1935;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2396;
import net.minecraft.class_2484;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2960;
import net.minecraft.class_322;
import net.minecraft.class_326;
import net.minecraft.class_3611;
import net.minecraft.class_4002;
import net.minecraft.class_5598;
import net.minecraft.class_5601;
import net.minecraft.class_5607;
import net.minecraft.class_5614;
import net.minecraft.class_5617;
import net.minecraft.class_630;
import net.minecraft.class_707;
import net.minecraft.class_7923;
import net.minecraft.class_811;
import org.jetbrains.annotations.NotNull;

@Environment(value=EnvType.CLIENT)
public class GameRendering {
    public static final Map<class_2960, class_2960> MODEL_OVERRIDES = new ConcurrentHashMap<class_2960, class_2960>();

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerBlockColors(Consumer<BlockColorEvent> listener) {
        GameRenderingImpl.registerBlockColors(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerItemColors(Consumer<ItemColorEvent> listener) {
        GameRenderingImpl.registerItemColors(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerBlockRenderers(Consumer<BlockRendererEvent> listener) {
        GameRenderingImpl.registerBlockRenderers(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerEntityRenderers(Consumer<EntityRendererEvent> listener) {
        GameRenderingImpl.registerEntityRenderers(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerBlockEntityRenderers(Consumer<BlockEntityRendererEvent> listener) {
        GameRenderingImpl.registerBlockEntityRenderers(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerModelLayers(Consumer<ModelLayerEvent> listener) {
        GameRenderingImpl.registerModelLayers(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerSpecialModels(Consumer<SpecialModelEvent> listener) {
        GameRenderingImpl.registerSpecialModels(listener);
    }

    public static void registerHandHeldModels(Consumer<HandHeldModelEvent> listener) {
        HandHeldModelEvent event = (item, original, handHeld, perspectives) -> ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).register((class_1935)item, new HandHeldItemRenderer(original, handHeld));
        listener.accept(event);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerModelOverrides(Consumer<ModelOverrideEvent> listener) {
        GameRenderingImpl.registerModelOverrides(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerSkullRenderers(Consumer<SkullRendererEvent> listener) {
        GameRenderingImpl.registerSkullRenderers(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerParticleFactories(Consumer<ParticleFactoryEvent> listener) {
        GameRenderingImpl.registerParticleFactories(listener);
    }

    public static interface HandHeldModelEvent {
        default public void register(class_1792 item, class_2960 handHeld) {
            this.register(item, class_7923.field_41178.method_10221((Object)item), handHeld);
        }

        default public void register(class_1792 item, class_1091 handHeld) {
            this.register(item, class_1091.method_61078((class_2960)class_7923.field_41178.method_10221((Object)item)), handHeld);
        }

        public void register(class_1792 var1, class_1091 var2, class_1091 var3, Set<class_811> var4);

        default public void register(class_1792 item, class_2960 original, class_2960 handheld, Set<class_811> perspectives) {
            this.register(item, class_1091.method_61078((class_2960)original), class_1091.method_61078((class_2960)handheld), perspectives);
        }

        default public void register(class_1792 item, class_1091 original, class_1091 handheld) {
            this.register(item, original, handheld, Set.of(class_811.field_4317, class_811.field_4318, class_811.field_4319));
        }

        default public void register(class_1792 item, class_2960 original, class_2960 handheld) {
            this.register(item, class_1091.method_61078((class_2960)original), class_1091.method_61078((class_2960)handheld));
        }

        public record Models(class_1091 original, class_1091 handheld, Set<class_811> perspectives) {
        }
    }

    public static interface ParticleFactoryEvent {
        public <T extends class_2394, P extends class_2396<T>> void register(Supplier<P> var1, class_707<T> var2);

        public <T extends class_2394, P extends class_2396<T>> void register(Supplier<P> var1, Factory<T> var2);

        @FunctionalInterface
        public static interface Factory<T extends class_2394> {
            @NotNull
            public class_707<T> create(class_4002 var1);
        }
    }

    public static interface SkullRendererEvent {
        public void registerSkullModel(class_2484.class_2485 var1, Function<class_630, class_5598> var2, class_5601 var3);

        public void registerSkullTexture(class_2484.class_2485 var1, class_2960 var2);
    }

    public static interface ModelOverrideEvent {
        default public void register(class_2960 original, class_2960 override, boolean condition) {
            if (condition) {
                MODEL_OVERRIDES.put(original, override);
            } else {
                MODEL_OVERRIDES.remove(original);
            }
        }

        default public void register(class_2960 original, class_2960 override) {
            this.register(original, override, true);
        }
    }

    public static interface SpecialModelEvent {
        public void register(class_2960 var1);

        public void register(class_2960 ... var1);

        @Deprecated
        default public void register(class_1091 model) {
            this.register(model.comp_2875());
        }

        @Deprecated
        default public void register(class_1091 ... models) {
            for (class_1091 model : models) {
                this.register(model.comp_2875());
            }
        }
    }

    public static interface ModelLayerEvent {
        public void register(class_5601 var1, Supplier<class_5607> var2);
    }

    public static interface BlockEntityRendererEvent {
        public <E extends class_2586> void register(class_2591<? extends E> var1, class_5614<E> var2);
    }

    public static interface EntityRendererEvent {
        public <E extends class_1297> void register(class_1299<? extends E> var1, class_5617<E> var2);
    }

    public static interface BlockRendererEvent {
        public void register(class_1921 var1, class_2248 ... var2);

        public void register(class_1921 var1, class_3611 ... var2);
    }

    public static interface ItemColorEvent {
        public void register(class_326 var1, class_1935 ... var2);

        public int getColor(class_1799 var1, int var2);
    }

    public static interface BlockColorEvent {
        public void register(class_322 var1, class_2248 ... var2);

        public int getColor(class_2680 var1, class_1920 var2, class_2338 var3, int var4);
    }
}

