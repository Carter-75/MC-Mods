/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_4944
 *  net.minecraft.class_4945
 */
package backported.updates.content.data.client.model;

import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.data.client.model.TextureSlots;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_4944;
import net.minecraft.class_4945;

public class TextureMappings {
    public static class_4944 side(class_2248 block) {
        return class_4944.method_25883((class_4945)class_4945.field_23018, (class_2960)class_4944.method_25860((class_2248)block));
    }

    public static class_4944 driedGhast(String string) {
        return new class_4944().method_25868(class_4945.field_23012, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_north"))).method_25868(class_4945.field_23014, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_bottom"))).method_25868(class_4945.field_23015, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_top"))).method_25868(class_4945.field_23019, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_north"))).method_25868(class_4945.field_23020, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_south"))).method_25868(class_4945.field_23021, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_west"))).method_25868(class_4945.field_23022, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_east"))).method_25868(TextureSlots.TENTACLES, class_4944.method_25866((class_2248)ModBlocks.DRIED_GHAST.get(), (String)(string + "_tentacles")));
    }
}

