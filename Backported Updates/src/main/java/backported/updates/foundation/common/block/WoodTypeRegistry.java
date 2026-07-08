/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.Identifier
 *  net.minecraft.block.WoodType
 *  net.minecraft.block.BlockSetType
 */
package backported.updates.foundation.common.block;

import backported.updates.foundation.common.block.fabric.WoodTypeRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import net.minecraft.block.WoodType;
import net.minecraft.block.BlockSetType;

public class WoodTypeRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static WoodType create(Identifier location, BlockSetType blockSetType) {
        return WoodTypeRegistryImpl.create(location, blockSetType);
    }

    @ExpectPlatform
    @Environment(value=EnvType.CLIENT)
    @ExpectPlatform.Transformed
    public static void registerWoodType(WoodType type) {
        WoodTypeRegistryImpl.registerWoodType(type);
    }
}

