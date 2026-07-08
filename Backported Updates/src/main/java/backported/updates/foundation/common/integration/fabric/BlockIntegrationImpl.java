/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.player.UseBlockCallback
 *  net.fabricmc.fabric.api.registry.CompostingChanceRegistry
 *  net.fabricmc.fabric.api.registry.FuelRegistry
 *  net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry
 *  net.minecraft.item.ItemUsageContext
 *  net.minecraft.item.ItemConvertible
 *  net.minecraft.block.Block
 */
package backported.updates.foundation.common.integration.fabric;

import backported.updates.foundation.common.integration.BlockIntegration;
import backported.updates.foundation.common.integration.BlockInteraction;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.fabricmc.fabric.api.registry.FlattenableBlockRegistry;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.block.Block;

public class BlockIntegrationImpl {
    public static void registerIntegrations(Consumer<BlockIntegration.Event> listener) {
        listener.accept(new BlockIntegration.Event(){

            @Override
            public void registerBlockInteraction(BlockInteraction interaction) {
                UseBlockCallback.EVENT.register((player, level, hand, hit) -> interaction.onUse(new ItemUsageContext(player, hand, hit)));
            }

            @Override
            public void registerFuelItem(ItemConvertible item, int burnTime) {
                FuelRegistry.INSTANCE.add(item, burnTime);
            }

            @Override
            public void registerCompostableItem(ItemConvertible item, float chance) {
                CompostingChanceRegistry.INSTANCE.add(item, Float.valueOf(chance));
            }

            @Override
            public void registerOxidableBlock(Block less, Block more) {
                OxidizableBlocksRegistry.registerOxidizableBlockPair((Block)less, (Block)more);
            }

            @Override
            public void registerWaxableBlock(Block unwaxed, Block waxed) {
                OxidizableBlocksRegistry.registerWaxableBlockPair((Block)unwaxed, (Block)waxed);
            }

            @Override
            public void registerStrippableBlock(Block target, Block result) {
                StrippableBlockRegistry.register(target, result);
            }

            @Override
            public void registerFlattenableBlock(Block target, net.minecraft.block.BlockState result) {
                FlattenableBlockRegistry.register(target, result);
            }
        });
    }
}

