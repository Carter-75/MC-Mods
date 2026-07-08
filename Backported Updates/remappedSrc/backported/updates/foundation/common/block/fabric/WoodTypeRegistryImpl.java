/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder
 *  net.minecraft.class_2960
 *  net.minecraft.class_4719
 *  net.minecraft.class_8177
 */
package backported.updates.foundation.common.block.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.class_2960;
import net.minecraft.class_4719;
import net.minecraft.class_8177;

public class WoodTypeRegistryImpl {
    public static class_4719 create(class_2960 location, class_8177 blockSetType) {
        return WoodTypeBuilder.copyOf((class_4719)class_4719.field_21676).register(location, blockSetType);
    }

    @Environment(value=EnvType.CLIENT)
    public static void registerWoodType(class_4719 type) {
    }
}

