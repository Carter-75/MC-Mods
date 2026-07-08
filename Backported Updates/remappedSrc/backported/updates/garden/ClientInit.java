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
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_5601
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
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_5601;
import org.apache.commons.lang3.SystemUtils;

@Environment(value=EnvType.CLIENT)
public class ClientInit
implements ClientModInitializer {
    public static final class_5601 MODEL_CREAKING_LAYER = new class_5601(class_2960.method_60655((String)"iwie", (String)"creaking"), "main");

    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_SHORT_GRASS, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_MOSS_CARPET, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_OAK_SAPLING, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_OAK_LEAVES, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_HANGING_MOSS, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_HANGING_MOSS_PLANT, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.POTTED_PALE_OAK_SAPLING, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.CLOSED_EYE_BLOSSOM_BLOCK, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.OPEN_EYE_BLOSSOM_BLOCK, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.POTTED_CLOSED_EYE_BLOSSOM, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.POTTED_OPEN_EYE_BLOSSOM, class_1921.method_23581());
        BlockRenderLayerMap.INSTANCE.putBlock(Init.PALE_OAK_DOOR, class_1921.method_23581());
        class_310 client = class_310.method_1551();
        CompletableFuture.runAsync(() -> {
            while (client.method_1505() == null || client.method_22683() == null) {
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
                    client.method_22683().method_24286("https://modrinth.com/mod/i-want-it-earlier");
                }
            }
        });
        EntityRendererRegistry.register(Init.CREAKING, CreakingEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)MODEL_CREAKING_LAYER, CreakingModel::getTexturedModelData);
    }
}

