/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.event.player.UseEntityCallback
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1317
 *  net.minecraft.class_1317$class_1318
 *  net.minecraft.class_1317$class_4306
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_9168
 */
package backported.updates.foundation.common.integration.fabric;

import backported.updates.foundation.common.integration.MobIntegration;
import backported.updates.foundation.common.integration.MobInteraction;
import backported_updates.mixin.foundation.access.SpawnPlacementsAccessor;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1317;
import net.minecraft.class_2902;
import net.minecraft.class_5132;
import net.minecraft.class_9168;

public class MobIntegrationImpl {
    public static void registerIntegrations(Consumer<MobIntegration.Event> listener) {
        listener.accept(new MobIntegration.Event(){

            @Override
            public void registerMobInteraction(MobInteraction interaction) {
                UseEntityCallback.EVENT.register((player, level, hand, entity, hit) -> interaction.onInteract(player, entity, hand));
            }

            @Override
            public void registerAttributes(Supplier<? extends class_1299<? extends class_1309>> type, Supplier<class_5132.class_5133> builder) {
                FabricDefaultAttributeRegistry.register(type.get(), (class_5132.class_5133)builder.get());
            }

            @Override
            public <T extends class_1308> void registerPlacement(Supplier<class_1299<T>> entity, class_9168 spawnPlacement, class_2902.class_2903 heightmap, class_1317.class_4306<T> spawnPredicate) {
                if (SpawnPlacementsAccessor.getDATA_BY_TYPE().get(entity.get()) != null) {
                    SpawnPlacementsAccessor.getDATA_BY_TYPE().put(entity.get(), new class_1317.class_1318(heightmap, spawnPlacement, spawnPredicate));
                } else {
                    class_1317.method_20637(entity.get(), (class_9168)spawnPlacement, (class_2902.class_2903)heightmap, spawnPredicate);
                }
            }
        });
    }
}

