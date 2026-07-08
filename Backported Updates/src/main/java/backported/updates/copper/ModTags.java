/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper;

import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> COPPER = Blocks.tag("copper");
        public static final TagKey<Block> COPPER_CHESTS = Blocks.tag("copper_chests");
        public static final TagKey<Block> WOODEN_SHELVES = Blocks.tag("wooden_shelves");

        private static TagKey<Block> tag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of((String)"copperagebackport", (String)name));
        }
    }
}

