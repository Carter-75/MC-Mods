/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.BlockRenderView
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.particle.ParticleType
 *  net.minecraft.block.SkullBlock$SkullType
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.entity.BlockEntityType
 *  net.minecraft.block.BlockState
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.color.block.BlockColorProvider
 *  net.minecraft.client.color.item.ItemColorProvider
 *  net.minecraft.fluid.Fluid
 *  net.minecraft.client.particle.SpriteProvider
 *  net.minecraft.client.render.block.entity.SkullBlockEntityModel
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 *  net.minecraft.client.model.TexturedModelData
 *  net.minecraft.client.render.block.entity.BlockEntityRendererFactory
 *  net.minecraft.client.render.entity.EntityRendererFactory
 *  net.minecraft.client.model.ModelPart
 *  net.minecraft.client.particle.ParticleFactory
 *  net.minecraft.registry.Registries
 *  net.minecraft.client.render.model.json.ModelTransformationMode
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
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.BlockRenderView;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.block.SkullBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.fluid.Fluid;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.render.block.entity.SkullBlockEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.registry.Registries;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import org.jetbrains.annotations.NotNull;

@Environment(value=EnvType.CLIENT)
public class GameRendering {
    public static final Map<Identifier, Identifier> MODEL_OVERRIDES = new ConcurrentHashMap<Identifier, Identifier>();

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
        HandHeldModelEvent event = (item, original, handHeld, perspectives) -> ((ItemRendererRegistry)ItemRendererRegistry.INSTANCE.get()).register((ItemConvertible)item, new HandHeldItemRenderer(original, handHeld));
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
        default public void register(Item item, Identifier handHeld) {
            this.register(item, Registries.ITEM.getId(item), handHeld);
        }

        default public void register(Item item, ModelIdentifier handHeld) {
            this.register(item, ModelIdentifier.ofInventoryVariant(Registries.ITEM.getId(item)), handHeld);
        }

        public void register(Item var1, ModelIdentifier var2, ModelIdentifier var3, Set<ModelTransformationMode> var4);

        default public void register(Item item, Identifier original, Identifier handheld, Set<ModelTransformationMode> perspectives) {
            this.register(item, ModelIdentifier.ofInventoryVariant(original), ModelIdentifier.ofInventoryVariant(handheld), perspectives);
        }

        default public void register(Item item, ModelIdentifier original, ModelIdentifier handheld) {
            this.register(item, original, handheld, Set.of(ModelTransformationMode.GUI, ModelTransformationMode.GROUND, ModelTransformationMode.FIXED));
        }

        default public void register(Item item, Identifier original, Identifier handheld) {
            this.register(item, ModelIdentifier.ofInventoryVariant(original), ModelIdentifier.ofInventoryVariant(handheld));
        }

        public record Models(ModelIdentifier original, ModelIdentifier handheld, Set<ModelTransformationMode> perspectives) {
        }
    }

    public static interface ParticleFactoryEvent {
        public <T extends ParticleEffect, P extends ParticleType<T>> void register(Supplier<P> var1, ParticleFactory<T> var2);

        public <T extends ParticleEffect, P extends ParticleType<T>> void register(Supplier<P> var1, Factory<T> var2);

        @FunctionalInterface
        public static interface Factory<T extends ParticleEffect> {
            @NotNull
            public ParticleFactory<T> create(SpriteProvider var1);
        }
    }

    public static interface SkullRendererEvent {
        public void registerSkullModel(SkullBlock.SkullType var1, Function<ModelPart, SkullBlockEntityModel> var2, EntityModelLayer var3);

        public void registerSkullTexture(SkullBlock.SkullType var1, Identifier var2);
    }

    public static interface ModelOverrideEvent {
        default public void register(Identifier original, Identifier override, boolean condition) {
            if (condition) {
                MODEL_OVERRIDES.put(original, override);
            } else {
                MODEL_OVERRIDES.remove(original);
            }
        }

        default public void register(Identifier original, Identifier override) {
            this.register(original, override, true);
        }
    }

    public static interface SpecialModelEvent {
        public void register(Identifier var1);

        public void register(Identifier ... var1);

        @Deprecated
        default public void register(ModelIdentifier model) {
            this.register(model.id());
        }

        @Deprecated
        default public void register(ModelIdentifier ... models) {
            for (ModelIdentifier model : models) {
                this.register(model.id());
            }
        }
    }

    public static interface ModelLayerEvent {
        public void register(EntityModelLayer var1, Supplier<TexturedModelData> var2);
    }

    public static interface BlockEntityRendererEvent {
        public <E extends BlockEntity> void register(BlockEntityType<? extends E> var1, BlockEntityRendererFactory<E> var2);
    }

    public static interface EntityRendererEvent {
        public <E extends Entity> void register(EntityType<? extends E> var1, EntityRendererFactory<E> var2);
    }

    public static interface BlockRendererEvent {
        public void register(RenderLayer var1, Block ... var2);

        public void register(RenderLayer var1, Fluid ... var2);
    }

    public static interface ItemColorEvent {
        public void register(ItemColorProvider var1, ItemConvertible ... var2);

        public int getColor(ItemStack var1, int var2);
    }

    public static interface BlockColorEvent {
        public void register(BlockColorProvider var1, Block ... var2);

        public int getColor(BlockState var1, BlockRenderView var2, BlockPos var3, int var4);
    }
}

