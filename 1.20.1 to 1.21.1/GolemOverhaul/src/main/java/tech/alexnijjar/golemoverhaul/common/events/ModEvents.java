/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.event.EventResult
 *  dev.architectury.event.events.common.BlockEvent
 *  dev.architectury.event.events.common.InteractionEvent
 *  net.minecraft.class_1309
 *  net.minecraft.class_1542
 *  net.minecraft.class_1799
 *  net.minecraft.class_1820
 *  net.minecraft.class_1922
 *  net.minecraft.class_2246
 *  net.minecraft.class_238
 *  net.minecraft.class_3218
 */
package tech.alexnijjar.golemoverhaul.common.events;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.event.events.common.InteractionEvent;
import java.util.List;
import java.util.Random;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_1820;
import net.minecraft.class_1922;
import net.minecraft.class_2246;
import net.minecraft.class_238;
import net.minecraft.class_3218;
import tech.alexnijjar.golemoverhaul.common.entities.IShearable;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HayGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.KelpGolem;

public class ModEvents {
    public static void init() {
        ModEvents.registerShearInteractions();
        ModEvents.registerKelpGolemPlacementDetection();
        ModEvents.registerHayGolemTramplePrevention();
    }

    private static void registerShearInteractions() {
        InteractionEvent.INTERACT_ENTITY.register((player, entity, hand) -> {
            if (!(entity instanceof IShearable)) {
                return EventResult.pass();
            }
            IShearable target = (IShearable)entity;
            if (entity.method_37908().field_9236) {
                return EventResult.pass();
            }
            class_1799 stack = player.method_5998(hand);
            if (!(stack.method_7909() instanceof class_1820)) {
                return EventResult.pass();
            }
            if (!target.isShearable()) {
                return EventResult.interruptFalse();
            }
            List<class_1799> drops = target.onSheared();
            drops.forEach(dropStack -> {
                class_1542 droppedItem = entity.method_5699(dropStack, 1.0f);
                if (droppedItem != null) {
                    Random rand = new Random();
                    droppedItem.method_18799(droppedItem.method_18798().method_1031((double)((rand.nextFloat() - rand.nextFloat()) * 0.1f), (double)(rand.nextFloat() * 0.05f), (double)((rand.nextFloat() - rand.nextFloat()) * 0.1f)));
                }
            });
            stack.method_7956(1, (class_1309)player, p -> p.method_20236(hand));
            return EventResult.interruptTrue();
        });
    }

    private static void registerKelpGolemPlacementDetection() {
        BlockEvent.PLACE.register((level, blockPos, blockState, entity) -> {
            if (!(level instanceof class_3218)) {
                return EventResult.pass();
            }
            class_3218 serverLevel = (class_3218)level;
            if (blockState.method_27852(class_2246.field_10342) || blockState.method_27852(class_2246.field_10174)) {
                serverLevel.method_8503().execute(() -> KelpGolem.trySpawnGolem(level, blockPos));
            }
            return EventResult.pass();
        });
    }

    private static void registerHayGolemTramplePrevention() {
        InteractionEvent.FARMLAND_TRAMPLE.register((level, blockPos, blockState, v, entity) -> {
            if (level.method_8608()) {
                return EventResult.pass();
            }
            class_238 bounds = blockState.method_26220((class_1922)level, blockPos).method_1107().method_996(blockPos).method_1014(10.0);
            if (!level.method_18467(HayGolem.class, bounds).isEmpty()) {
                return EventResult.interruptFalse();
            }
            return EventResult.pass();
        });
    }
}

