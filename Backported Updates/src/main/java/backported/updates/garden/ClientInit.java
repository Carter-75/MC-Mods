/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.minecraft.client.render.RenderLayer
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.client.render.entity.model.EntityModelLayer
 *  org.apache.commons.lang3.SystemUtils
 */
package backported.updates.garden;

import backported.updates.garden.Init;
import backported.updates.garden.entity.CreakingEntityRenderer;
import backported.updates.garden.entity.CreakingModel;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import org.apache.commons.lang3.SystemUtils;

@Environment(value=EnvType.CLIENT)
public class ClientInit
implements ClientModInitializer {
    public static final EntityModelLayer MODEL_CREAKING_LAYER = new EntityModelLayer(Identifier.of((String)"iwie", (String)"creaking"), "main");

    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_SHORT_GRASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_MOSS_CARPET, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_OAK_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_HANGING_MOSS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_HANGING_MOSS_PLANT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.POTTED_PALE_OAK_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.CLOSED_EYE_BLOSSOM_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.OPEN_EYE_BLOSSOM_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.POTTED_CLOSED_EYE_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.POTTED_OPEN_EYE_BLOSSOM, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_OAK_DOOR, RenderLayer.getCutout());
        MinecraftClient client = MinecraftClient.getInstance();
        CompletableFuture.runAsync(() -> {
            while (client.getBlockColors() == null || client.getWindow() == null) {
                try {
                    Thread.sleep(100L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (SystemUtils.IS_OS_WINDOWS) {
                File config = new File("promotion.iwie");
                boolean mayPromote = true;
                try {
                    if (config.createNewFile()) {
                        Files.writeString(config.toPath(), (CharSequence)"true", new OpenOption[0]);
                    } else {
                        mayPromote = Boolean.parseBoolean(Files.readString(config.toPath()));
                    }
                }
                catch (Exception e) {
                    mayPromote = false;
                }
                if (mayPromote) {
                    client.getWindow().setTitle("https://modrinth.com/mod/i-want-it-earlier");
                }
            }
        });
        EntityRendererRegistry.register(Init.CREAKING, CreakingEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((EntityModelLayer)MODEL_CREAKING_LAYER, CreakingModel::getTexturedModelData);
    }
}

