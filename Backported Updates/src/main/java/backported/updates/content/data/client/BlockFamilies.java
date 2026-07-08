/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.block.Block
 *  net.minecraft.data.family.BlockFamily
 *  net.minecraft.data.family.BlockFamily$Builder
 *  net.minecraft.registry.Registries
 */
package backported.updates.content.data.client;

import backported.updates.content.common.registries.ModBlocks;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

public class BlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();
    public static final BlockFamily PALE_OAK_PLANKS = BlockFamilies.familyBuilder(ModBlocks.PALE_OAK_PLANKS.get()).button(ModBlocks.PALE_OAK_BUTTON.get()).fence(ModBlocks.PALE_OAK_FENCE.get()).fenceGate(ModBlocks.PALE_OAK_FENCE_GATE.get()).pressurePlate(ModBlocks.PALE_OAK_PRESSURE_PLATE.get()).sign((Block)((Supplier)ModBlocks.PALE_OAK_SIGN.getFirst()).get(), (Block)((Supplier)ModBlocks.PALE_OAK_SIGN.getSecond()).get()).slab(ModBlocks.PALE_OAK_SLAB.get()).stairs(ModBlocks.PALE_OAK_STAIRS.get()).door(ModBlocks.PALE_OAK_DOOR.get()).trapdoor(ModBlocks.PALE_OAK_TRAPDOOR.get()).group("wooden").unlockCriterionName("has_planks").build();
    public static final BlockFamily RESIN_BRICKS = BlockFamilies.familyBuilder(ModBlocks.RESIN_BRICKS.get()).wall(ModBlocks.RESIN_BRICK_WALL.get()).stairs(ModBlocks.RESIN_BRICK_STAIRS.get()).slab(ModBlocks.RESIN_BRICK_SLAB.get()).chiseled(ModBlocks.CHISELED_RESIN_BRICKS.get()).build();

    private static BlockFamily.Builder familyBuilder(Block block) {
        BlockFamily.Builder builder = new BlockFamily.Builder(block);
        BlockFamily family = MAP.put(block, builder.build());
        if (family != null) {
            throw new IllegalStateException("Duplicate family definition for " + String.valueOf(Registries.BLOCK.getId(block)));
        }
        return builder;
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
}

