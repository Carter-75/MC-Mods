/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.player.UseBlockCallback
 *  net.fabricmc.fabric.api.registry.CompostingChanceRegistry
 *  net.fabricmc.fabric.api.registry.FuelRegistry
 *  net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry
 *  net.minecraft.class_1838
 *  net.minecraft.class_1935
 *  net.minecraft.class_2248
 */
package backported.updates.foundation.common.integration.fabric;

import backported.updates.foundation.common.integration.BlockIntegration;
import backported.updates.foundation.common.integration.BlockInteraction;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.class_1838;
import net.minecraft.class_1935;
import net.minecraft.class_2248;

public class BlockIntegrationImpl {
    public static void registerIntegrations(Consumer<BlockIntegration.Event> listener) {
        listener.accept(new BlockIntegration.Event(){

            @Override
            public void registerBlockInteraction(BlockInteraction interaction) {
                UseBlockCallback.EVENT.register((player, level, hand, hit) -> interaction.onUse(new class_1838(player, hand, hit)));
            }

            @Override
            public void registerFuelItem(class_1935 item, int burnTime) {
                FuelRegistry.INSTANCE.add(item, (Object)burnTime);
            }

            @Override
            public void registerCompostableItem(class_1935 item, float chance) {
                CompostingChanceRegistry.INSTANCE.add(item, (Object)Float.valueOf(chance));
            }

            @Override
            public void registerOxidableBlock(class_2248 less, class_2248 more) {
                OxidizableBlocksRegistry.registerOxidizableBlockPair((class_2248)less, (class_2248)more);
            }

            @Override
            public void registerWaxableBlock(class_2248 unwaxed, class_2248 waxed) {
                OxidizableBlocksRegistry.registerWaxableBlockPair((class_2248)unwaxed, (class_2248)waxed);
            }
        });
    }
}

