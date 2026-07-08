/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.item.AxeItem
 *  net.minecraft.item.ShovelItem
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.block.DispenserBlock
 *  net.minecraft.block.dispenser.DispenserBehavior
 *  net.minecraft.block.FireBlock
 *  net.minecraft.block.BlockState
 */
package backported.updates.foundation.common.integration;

import backported.updates.foundation.common.integration.BlockInteraction;
import backported.updates.foundation.common.integration.fabric.BlockIntegrationImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Map;
import java.util.function.Consumer;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.block.FireBlock;
import net.minecraft.block.BlockState;

public class BlockIntegration {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerIntegrations(Consumer<Event> listener) {
        BlockIntegrationImpl.registerIntegrations(listener);
    }

    public static interface Event {
        public void registerBlockInteraction(BlockInteraction var1);

        public void registerFuelItem(ItemConvertible var1, int var2);

        public void registerCompostableItem(ItemConvertible var1, float var2);

        public void registerWaxableBlock(Block var1, Block var2);

        public void registerOxidableBlock(Block var1, Block var2);

        default public void registerDispenserBehavior(ItemConvertible item, DispenserBehavior behavior) {
            DispenserBlock.registerBehavior((ItemConvertible)item, (DispenserBehavior)behavior);
        }

        public void registerStrippableBlock(Block target, Block result);

        public void registerFlattenableBlock(Block target, BlockState result);

        default public void registerFlattenableBlock(Block target, Block result) {
            this.registerFlattenableBlock(target, result.getDefaultState());
        }

        default public void registerFlammableBlock(Block target, int encouragement, int flammability) {
            ((FireBlock)Blocks.FIRE).registerFlammableBlock(target, encouragement, flammability);
        }
    }
}

