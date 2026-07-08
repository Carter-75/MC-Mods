/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin
 *  net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier
 *  net.minecraft.client.render.model.BakedModel
 *  net.minecraft.client.util.ModelIdentifier
 *  net.minecraft.util.Identifier
 */
package backported.updates.content.core.fabric.emissive;

import backported.updates.content.core.fabric.emissive.EmissiveModelWrapper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelModifier;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;

@Environment(value=EnvType.CLIENT)
public class EmissiveModelHandler
implements ClientModInitializer {
    private static final String[] EMISSIVE_BLOCKS = new String[]{"open_eyeblossom", "potted_open_eyeblossom", "firefly_bush"};
    private static final String EMISSIVE_SUFFIX = "_emissive";

    public void onInitializeClient() {
        ModelLoadingPlugin.register(pluginContext -> {
            pluginContext.addModels(EmissiveModelHandler.getEmissiveModelLocations());
            pluginContext.modifyModelAfterBake().register(ModelModifier.WRAP_PHASE, (model, context) -> {
                ModelIdentifier modelLocation = context.topLevelId();
                if (modelLocation == null) {
                    return model;
                }
                Identifier id = modelLocation.id();
                if (!modelLocation.variant().isEmpty()) {
                    return model;
                }
                String path = id.getPath();
                String namespace = id.getNamespace();
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
                    Identifier emissiveModelId = Identifier.ofVanilla((String)("block/" + blockName + EMISSIVE_SUFFIX));
                    BakedModel emissiveModel = context.baker().bake(emissiveModelId, context.settings());
                    if (emissiveModel == null) continue;
                    return new EmissiveModelWrapper(model, emissiveModel);
                }
                return model;
            });
        });
    }

    private static Identifier[] getEmissiveModelLocations() {
        Identifier[] locations = new Identifier[EMISSIVE_BLOCKS.length];
        for (int i = 0; i < EMISSIVE_BLOCKS.length; ++i) {
            locations[i] = Identifier.ofVanilla((String)("block/" + EMISSIVE_BLOCKS[i] + EMISSIVE_SUFFIX));
        }
        return locations;
    }
}

