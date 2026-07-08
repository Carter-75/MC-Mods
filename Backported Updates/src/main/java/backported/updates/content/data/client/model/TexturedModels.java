/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.Model
 *  net.minecraft.data.client.TextureMap
 *  net.minecraft.data.client.TexturedModel
 *  net.minecraft.data.client.TexturedModel$Factory
 */
package backported.updates.content.data.client.model;

import backported.updates.content.data.client.model.ModelTemplates;
import backported.updates.content.data.client.model.TextureMappings;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TexturedModel;

public class TexturedModels {
    public static final TexturedModel.Factory MOSSY_CARPET_SIDE = TexturedModel.makeFactory(TextureMappings::side, (Model)ModelTemplates.MOSSY_CARPET_SIDE);
    public static final TexturedModel.Factory LEAF_LITTER_1 = TexturedModel.makeFactory(TextureMap::texture, (Model)ModelTemplates.LEAF_LITTER_1);
    public static final TexturedModel.Factory LEAF_LITTER_2 = TexturedModel.makeFactory(TextureMap::texture, (Model)ModelTemplates.LEAF_LITTER_2);
    public static final TexturedModel.Factory LEAF_LITTER_3 = TexturedModel.makeFactory(TextureMap::texture, (Model)ModelTemplates.LEAF_LITTER_3);
    public static final TexturedModel.Factory LEAF_LITTER_4 = TexturedModel.makeFactory(TextureMap::texture, (Model)ModelTemplates.LEAF_LITTER_4);
}

