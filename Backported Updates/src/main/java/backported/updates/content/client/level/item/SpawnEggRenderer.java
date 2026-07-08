/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.client.color.item.ItemColors
 *  net.minecraft.client.util.math.MatrixStack
 *  net.minecraft.client.util.math.MatrixStack$Entry
 *  net.minecraft.client.render.VertexConsumer
 *  net.minecraft.client.render.VertexConsumerProvider
 *  net.minecraft.client.render.RenderLayers
 *  net.minecraft.util.math.ColorHelper$Argb
 *  net.minecraft.client.render.item.ItemModels
 *  net.minecraft.client.render.model.BakedQuad
 *  net.minecraft.registry.Registries
 *  net.minecraft.client.render.model.json.ModelTransformationMode
 *  net.minecraft.client.render.item.ItemRenderer
 */
package backported.updates.content.client.level.item;

import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.client.v2.render.DynamicItemRenderer;
import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.registry.Registries;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.render.item.ItemRenderer;

public class SpawnEggRenderer
implements DynamicItemRenderer.Renderer {
    public static final Set<ItemConvertible> SPAWN_EGGS = Set.of(Items.ALLAY_SPAWN_EGG, Items.ARMADILLO_SPAWN_EGG, Items.AXOLOTL_SPAWN_EGG, Items.BAT_SPAWN_EGG, Items.BEE_SPAWN_EGG, Items.BLAZE_SPAWN_EGG, Items.BOGGED_SPAWN_EGG, Items.BREEZE_SPAWN_EGG, Items.CAMEL_SPAWN_EGG, Items.CAT_SPAWN_EGG, Items.CAVE_SPIDER_SPAWN_EGG, Items.CHICKEN_SPAWN_EGG, Items.COD_SPAWN_EGG, Items.COW_SPAWN_EGG, (ItemConvertible)ModItems.CREAKING_SPAWN_EGG.get(), Items.CREEPER_SPAWN_EGG, Items.DOLPHIN_SPAWN_EGG, Items.DONKEY_SPAWN_EGG, Items.DROWNED_SPAWN_EGG, Items.ELDER_GUARDIAN_SPAWN_EGG, Items.ENDERMAN_SPAWN_EGG, Items.ENDERMITE_SPAWN_EGG, Items.EVOKER_SPAWN_EGG, Items.FOX_SPAWN_EGG, Items.FROG_SPAWN_EGG, Items.GHAST_SPAWN_EGG, Items.GLOW_SQUID_SPAWN_EGG, Items.GOAT_SPAWN_EGG, Items.GUARDIAN_SPAWN_EGG, (ItemConvertible)ModItems.HAPPY_GHAST_SPAWN_EGG.get(), Items.HOGLIN_SPAWN_EGG, Items.HORSE_SPAWN_EGG, Items.HUSK_SPAWN_EGG, Items.IRON_GOLEM_SPAWN_EGG, Items.LLAMA_SPAWN_EGG, Items.MAGMA_CUBE_SPAWN_EGG, Items.MOOSHROOM_SPAWN_EGG, Items.MULE_SPAWN_EGG, Items.OCELOT_SPAWN_EGG, Items.PANDA_SPAWN_EGG, Items.PARROT_SPAWN_EGG, Items.PHANTOM_SPAWN_EGG, Items.PIG_SPAWN_EGG, Items.PIGLIN_SPAWN_EGG, Items.PIGLIN_BRUTE_SPAWN_EGG, Items.PILLAGER_SPAWN_EGG, Items.POLAR_BEAR_SPAWN_EGG, Items.PUFFERFISH_SPAWN_EGG, Items.RABBIT_SPAWN_EGG, Items.RAVAGER_SPAWN_EGG, Items.SALMON_SPAWN_EGG, Items.SHEEP_SPAWN_EGG, Items.SHULKER_SPAWN_EGG, Items.SILVERFISH_SPAWN_EGG, Items.SKELETON_SPAWN_EGG, Items.SKELETON_HORSE_SPAWN_EGG, Items.SLIME_SPAWN_EGG, Items.SNIFFER_SPAWN_EGG, Items.SNOW_GOLEM_SPAWN_EGG, Items.SPIDER_SPAWN_EGG, Items.SQUID_SPAWN_EGG, Items.STRAY_SPAWN_EGG, Items.STRIDER_SPAWN_EGG, Items.TADPOLE_SPAWN_EGG, Items.TRADER_LLAMA_SPAWN_EGG, Items.TROPICAL_FISH_SPAWN_EGG, Items.TURTLE_SPAWN_EGG, Items.VEX_SPAWN_EGG, Items.VILLAGER_SPAWN_EGG, Items.VINDICATOR_SPAWN_EGG, Items.WANDERING_TRADER_SPAWN_EGG, Items.WARDEN_SPAWN_EGG, Items.WITCH_SPAWN_EGG, Items.WITHER_SKELETON_SPAWN_EGG, Items.WOLF_SPAWN_EGG, Items.ZOGLIN_SPAWN_EGG, Items.ZOMBIE_SPAWN_EGG, Items.ZOMBIE_HORSE_SPAWN_EGG, Items.ZOMBIE_VILLAGER_SPAWN_EGG, Items.ZOMBIFIED_PIGLIN_SPAWN_EGG);
    private static final Map<ItemConvertible, ModelIdentifier> EGG_MODELS = SpawnEggRenderer.buildModels();

    private static Map<ItemConvertible, ModelIdentifier> buildModels() {
        HashMap<ItemConvertible, ModelIdentifier> models = new HashMap<ItemConvertible, ModelIdentifier>();
        for (ItemConvertible item : SPAWN_EGGS) {
            models.put(item, SpawnEggRenderer.create(item.asItem()));
        }
        return models;
    }

    private static ModelIdentifier create(Item item) {
        return new ModelIdentifier(VanillaBackport.resource(Registries.ITEM.getId(item).getPath()), "inventory");
    }

    @Override
    public boolean shouldUse() {
        return VanillaBackport.CLIENT_CONFIG.useLegacySpawnEggs.get() == false;
    }

    @Override
    public void renderFirstPerson(ItemStack stack, ModelTransformationMode context, boolean leftHand, MatrixStack pose, VertexConsumerProvider buffer, int light, int overlay, BakedModel model, ItemModels shaper, ItemColors colors) {
        model = shaper.getModelManager().getModel(EGG_MODELS.get(stack.getItem()));
        model.getTransformation().getTransformation(context).apply(leftHand, pose);
        pose.translate(-0.5f, -0.5f, -0.5f);
        RenderLayer renderType = RenderLayers.getItemLayer((ItemStack)stack, (boolean)true);
        VertexConsumer vertices = ItemRenderer.getDirectItemGlintConsumer(buffer, (RenderLayer)renderType, (boolean)true, (boolean)stack.hasGlint());
        this.renderModelLists(model, stack, light, overlay, pose, vertices, colors);
    }

    @Override
    public ResultHolder<BakedModel> renderThirdPerson(ItemStack stack, ItemModels shaper) {
        return ResultHolder.submit(shaper.getModelManager().getModel(EGG_MODELS.get(stack.getItem())));
    }

    @Override
    public Set<ModelIdentifier> registerModels() {
        ImmutableSet models = ImmutableSet.of();
        models = ImmutableSet.builder().addAll((Iterable)models).addAll(EGG_MODELS.values()).build();
        return models;
    }

    @Override
    public void renderQuadList(MatrixStack pose, VertexConsumer buffer, List<BakedQuad> quads, ItemStack stack, int light, int overlay, ItemColors colors) {
        MatrixStack.Entry last = pose.peek();
        for (BakedQuad quad : quads) {
            int tint = -1;
            float alpha = (float)ColorHelper.Argb.getAlpha((int)tint) / 255.0f;
            float red = (float)ColorHelper.Argb.getRed((int)tint) / 255.0f;
            float green = (float)ColorHelper.Argb.getGreen((int)tint) / 255.0f;
            float blue = (float)ColorHelper.Argb.getBlue((int)tint) / 255.0f;
            buffer.quad(last, quad, red, green, blue, alpha, light, overlay);
        }
    }
}

