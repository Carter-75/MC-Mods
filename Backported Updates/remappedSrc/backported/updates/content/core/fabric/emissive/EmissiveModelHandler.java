/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin
 *  net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier
 *  net.minecraft.class_1087
 *  net.minecraft.class_1091
 *  net.minecraft.class_2960
 */
package backported.updates.content.core.fabric.emissive;

import backported.updates.content.core.fabric.emissive.EmissiveModelWrapper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_2960;

@Environment(value=EnvType.CLIENT)
public class EmissiveModelHandler
implements ClientModInitializer {
    private static final String[] EMISSIVE_BLOCKS = new String[]{"open_eyeblossom", "potted_open_eyeblossom", "firefly_bush"};
    private static final String EMISSIVE_SUFFIX = "_emissive";

    public void onInitializeClient() {
        ModelLoadingPlugin.register(pluginContext -> {
            pluginContext.addModels(EmissiveModelHandler.getEmissiveModelLocations());
            pluginContext.modifyModelAfterBake().register(ModelModifier.WRAP_PHASE, (model, context) -> {
                class_1091 modelLocation = context.topLevelId();
                if (modelLocation == null) {
                    return model;
                }
                class_2960 id = modelLocation.comp_2875();
                if (!modelLocation.comp_2876().isEmpty()) {
                    return model;
                }
                String path = id.method_12832();
                String namespace = id.method_12836();
                for (String blockName : EMISSIVE_BLOCKS) {
                    boolean matches = false;
                    if (namespace.equals("minecraft")) {
                        if (path.equals(blockName) || path.equals("block/" + blockName)) {
                            matches = true;
                        }
                        if (id.toString().contains("minecraft:" + blockName)) {
                            matches = true;
                        }
                    }
                    if (!matches) continue;
                    class_2960 emissiveModelId = class_2960.method_60656((String)("block/" + blockName + EMISSIVE_SUFFIX));
                    class_1087 emissiveModel = context.baker().method_45873(emissiveModelId, context.settings());
                    if (emissiveModel == null) continue;
                    return new EmissiveModelWrapper(model, emissiveModel);
                }
                return model;
            });
        });
    }

    private static class_2960[] getEmissiveModelLocations() {
        class_2960[] locations = new class_2960[EMISSIVE_BLOCKS.length];
        for (int i = 0; i < EMISSIVE_BLOCKS.length; ++i) {
            locations[i] = class_2960.method_60656((String)("block/" + EMISSIVE_BLOCKS[i] + EMISSIVE_SUFFIX));
        }
        return locations;
    }
}

