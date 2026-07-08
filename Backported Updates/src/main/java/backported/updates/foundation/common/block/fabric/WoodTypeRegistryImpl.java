/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder
 *  net.minecraft.util.Identifier
 *  net.minecraft.block.WoodType
 *  net.minecraft.block.BlockSetType
 */
package backported.updates.foundation.common.block.fabric;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.block.WoodType;
import net.minecraft.block.BlockSetType;

public class WoodTypeRegistryImpl {
    public static WoodType create(Identifier location, BlockSetType blockSetType) {
        return WoodTypeBuilder.copyOf((WoodType)WoodType.OAK).register(location, blockSetType);
    }

    @Environment(value=EnvType.CLIENT)
    public static void registerWoodType(WoodType type) {
    }
}

