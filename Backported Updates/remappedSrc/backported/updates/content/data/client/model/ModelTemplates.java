/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_4942
 *  net.minecraft.class_4945
 */
package backported.updates.content.data.client.model;

import backported.updates.content.data.client.model.TextureSlots;
import java.util.Optional;
import net.minecraft.class_2960;
import net.minecraft.class_4942;
import net.minecraft.class_4945;

public class ModelTemplates {
    public static final class_4942 MOSSY_CARPET_SIDE = ModelTemplates.create("mossy_carpet_side", class_4945.field_23018);
    public static final class_4942 DRIED_GHAST = ModelTemplates.create("dried_ghast", class_4945.field_23012, class_4945.field_23015, class_4945.field_23014, class_4945.field_23019, class_4945.field_23020, class_4945.field_23021, class_4945.field_23022, TextureSlots.TENTACLES);
    public static final class_4942 LEAF_LITTER_1 = ModelTemplates.create("template_leaf_litter_1", "_1", class_4945.field_23011);
    public static final class_4942 LEAF_LITTER_2 = ModelTemplates.create("template_leaf_litter_2", "_2", class_4945.field_23011);
    public static final class_4942 LEAF_LITTER_3 = ModelTemplates.create("template_leaf_litter_3", "_3", class_4945.field_23011);
    public static final class_4942 LEAF_LITTER_4 = ModelTemplates.create("template_leaf_litter_4", "_4", class_4945.field_23011);

    private static class_4942 create(String name, class_4945 ... slots) {
        return new class_4942(Optional.of(class_2960.method_60656((String)("block/" + name))), Optional.empty(), slots);
    }

    private static class_4942 create(String name, String suffix, class_4945 ... slots) {
        return new class_4942(Optional.of(class_2960.method_60656((String)("block/" + name))), Optional.of(suffix), slots);
    }
}

