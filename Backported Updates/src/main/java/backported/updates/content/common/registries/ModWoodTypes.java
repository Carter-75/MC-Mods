/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.block.WoodType
 *  net.minecraft.block.BlockSetType
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.registries.ModBlockSetTypes;
import backported.updates.foundation.common.block.WoodTypeRegistry;
import net.minecraft.util.Identifier;
import net.minecraft.block.WoodType;
import net.minecraft.block.BlockSetType;

public class ModWoodTypes {
    public static final WoodType PALE_OAK = ModWoodTypes.register("pale_oak", ModBlockSetTypes.PALE_OAK);

    private static WoodType register(String name, BlockSetType set) {
        return WoodTypeRegistry.create(Identifier.ofVanilla((String)name), set);
    }
}

