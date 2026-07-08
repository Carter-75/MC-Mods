/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.core.data.tags;

import backported.updates.foundation.common.data.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.RegistryKeys;

public class ModBlockTags {
    public static final TagRegistry<Block> TAGS = TagRegistry.create(RegistryKeys.BLOCK, "backported_updates");
    public static final TagKey<Block> PALE_OAK_LOGS = TAGS.register("pale_oak_logs");
    public static final TagKey<Block> CREAKING_HEART_HOLDERS = TAGS.register("creaking_heart_holders");
    public static final TagKey<Block> HAPPY_GHAST_AVOIDS = TAGS.register("happy_ghast_avoids");
    public static final TagKey<Block> TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS = TAGS.register("triggers_ambient_desert_sand_block_sounds");
    public static final TagKey<Block> TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS = TAGS.register("triggers_ambient_desert_dry_vegetation_block_sounds");
    public static final TagKey<Block> TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS = TAGS.register("triggers_ambient_dried_ghast_block_sounds");
    public static final TagKey<Block> ALLOWS_LEAF_LITTER = TAGS.register("allows_leaf_litter");
    public static final TagKey<Block> SPAWN_FALLING_LEAVES = TAGS.register("spawn_falling_leaves");
    public static final TagKey<Block> SPAWN_FALLING_NEEDLES = TAGS.register("spawn_falling_needles");
    public static final TagKey<Block> CAMELS_SPAWNABLE_ON = TAGS.register("camel_spawnable_on");
    public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = TAGS.register("incorrect_for_copper_tool");
    public static final TagKey<Block> COPPER_GOLEM_STATUES = TAGS.register("copper_golem_statues");
    public static final TagKey<Block> COPPER_CHESTS = TAGS.register("copper_chests");
    public static final TagKey<Block> COPPER = TAGS.register("copper");
}

