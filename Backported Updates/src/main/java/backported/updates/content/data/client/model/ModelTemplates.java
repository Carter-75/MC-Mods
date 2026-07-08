/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.Model
 *  net.minecraft.data.client.TextureKey
 */
package backported.updates.content.data.client.model;

import backported.updates.content.data.client.model.TextureSlots;
import java.util.Optional;
import net.minecraft.util.Identifier;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;

public class ModelTemplates {
    public static final Model MOSSY_CARPET_SIDE = ModelTemplates.create("mossy_carpet_side", TextureKey.SIDE);
    public static final Model DRIED_GHAST = ModelTemplates.create("dried_ghast", TextureKey.PARTICLE, TextureKey.TOP, TextureKey.BOTTOM, TextureKey.NORTH, TextureKey.SOUTH, TextureKey.EAST, TextureKey.WEST, TextureSlots.TENTACLES);
    public static final Model LEAF_LITTER_1 = ModelTemplates.create("template_leaf_litter_1", "_1", TextureKey.TEXTURE);
    public static final Model LEAF_LITTER_2 = ModelTemplates.create("template_leaf_litter_2", "_2", TextureKey.TEXTURE);
    public static final Model LEAF_LITTER_3 = ModelTemplates.create("template_leaf_litter_3", "_3", TextureKey.TEXTURE);
    public static final Model LEAF_LITTER_4 = ModelTemplates.create("template_leaf_litter_4", "_4", TextureKey.TEXTURE);

    private static Model create(String name, TextureKey ... slots) {
        return new Model(Optional.of(Identifier.ofVanilla((String)("block/" + name))), Optional.empty(), slots);
    }

    private static Model create(String name, String suffix, TextureKey ... slots) {
        return new Model(Optional.of(Identifier.ofVanilla((String)("block/" + name))), Optional.of(suffix), slots);
    }
}

