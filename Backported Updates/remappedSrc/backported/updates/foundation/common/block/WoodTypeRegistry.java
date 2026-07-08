/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2960
 *  net.minecraft.class_4719
 *  net.minecraft.class_8177
 */
package backported.updates.foundation.common.block;

import backported.updates.foundation.common.block.fabric.WoodTypeRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2960;
import net.minecraft.class_4719;
import net.minecraft.class_8177;

public class WoodTypeRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static class_4719 create(class_2960 location, class_8177 blockSetType) {
        return WoodTypeRegistryImpl.create(location, blockSetType);
    }

    @ExpectPlatform
    @Environment(value=EnvType.CLIENT)
    @ExpectPlatform.Transformed
    public static void registerWoodType(class_4719 type) {
        WoodTypeRegistryImpl.registerWoodType(type);
    }
}

