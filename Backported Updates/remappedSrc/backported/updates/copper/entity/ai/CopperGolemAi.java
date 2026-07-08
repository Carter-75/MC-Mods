/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.ImmutableSet
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1314
 *  net.minecraft.class_1937
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3708
 *  net.minecraft.class_4095
 *  net.minecraft.class_4095$class_5303
 *  net.minecraft.class_4101
 *  net.minecraft.class_4110
 *  net.minecraft.class_4112
 *  net.minecraft.class_4118
 *  net.minecraft.class_4140
 *  net.minecraft.class_4141
 *  net.minecraft.class_4148
 *  net.minecraft.class_4149
 *  net.minecraft.class_4168
 *  net.minecraft.class_4818
 *  net.minecraft.class_5712
 *  net.minecraft.class_5753
 *  net.minecraft.class_6019
 *  net.minecraft.class_6028
 *  net.minecraft.class_6880
 *  net.minecraft.class_7895
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.entity.ai;

import backported.updates.copper.Constants;
import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.ModSounds;
import backported.updates.copper.ModTags;
import backported.updates.copper.compat.ModCompat;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemState;
import backported.updates.copper.entity.ai.behavior.InteractWithDoor;
import backported.updates.copper.entity.ai.behavior.PressRandomCopperButton;
import backported.updates.copper.entity.ai.behavior.TransportItemsBetweenContainers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1314;
import net.minecraft.class_1937;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3708;
import net.minecraft.class_4095;
import net.minecraft.class_4101;
import net.minecraft.class_4110;
import net.minecraft.class_4112;
import net.minecraft.class_4118;
import net.minecraft.class_4140;
import net.minecraft.class_4141;
import net.minecraft.class_4148;
import net.minecraft.class_4149;
import net.minecraft.class_4168;
import net.minecraft.class_4818;
import net.minecraft.class_5712;
import net.minecraft.class_5753;
import net.minecraft.class_6019;
import net.minecraft.class_6028;
import net.minecraft.class_6880;
import net.minecraft.class_7895;
import org.jetbrains.annotations.Nullable;

public class CopperGolemAi {
    private static final ImmutableList<class_4149<? extends class_4148<? super CopperGolemEntity>>> SENSOR_TYPES = ImmutableList.of((Object)class_4149.field_18466, (Object)class_4149.field_18469);
    private static final ImmutableList<class_4140<?>> MEMORY_TYPES = ImmutableList.of((Object)class_4140.field_18449, (Object)class_4140.field_18445, (Object)class_4140.field_18446, (Object)class_4140.field_18442, (Object)class_4140.field_18451, (Object)class_4140.field_18452, (Object)class_4140.field_39408, (Object)class_4140.field_19293, (Object)class_4140.field_18441, (Object)class_4140.field_26389, ModMemoryTypes.GAZE_COOLDOWN_TICKS.get(), ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), (Object[])new class_4140[]{ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), ModMemoryTypes.UNREACHABLE_TRANSPORT_BLOCK_POSITIONS.get(), ModMemoryTypes.IS_PRESSING_BUTTON.get(), ModMemoryTypes.LAST_CONTAINER_EMPTY.get()});

    public static class_4095.class_5303<CopperGolemEntity> brainProvider() {
        return class_4095.method_28311(MEMORY_TYPES, SENSOR_TYPES);
    }

    public static class_4095<CopperGolemEntity> makeBrain(class_4095<CopperGolemEntity> brain) {
        CopperGolemAi.initCoreActivity(brain);
        CopperGolemAi.initIdleActivity(brain);
        brain.method_18890((Set)ImmutableSet.of((Object)class_4168.field_18594));
        brain.method_18897(class_4168.field_18595);
        brain.method_24536();
        return brain;
    }

    private static void initCoreActivity(class_4095<CopperGolemEntity> brain) {
        brain.method_18882(class_4168.field_18594, 0, ImmutableList.of((Object)new class_6028(1.5f), (Object)new class_4110(45, 90), (Object)new class_4112(), InteractWithDoor.create(), (Object)new class_5753(ModMemoryTypes.GAZE_COOLDOWN_TICKS.get()), (Object)new class_5753(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get())));
    }

    private static void initIdleActivity(class_4095<CopperGolemEntity> brain) {
        ImmutableList.Builder behaviorsBuilder = ImmutableList.builder();
        behaviorsBuilder.add((Object)Pair.of((Object)0, (Object)((Object)new TransportItemsBetweenContainers(1.0f, state -> state.method_26164(ModTags.Blocks.COPPER_CHESTS), state -> CopperGolemAi.isValidDestinationContainer(state), 32, 8, CopperGolemAi.getTargetReachedInteractions(), CopperGolemAi.onTravelling(), CopperGolemAi.shouldQueueForTarget()))));
        if (CommonConfig.golemPressesButtons()) {
            behaviorsBuilder.add((Object)Pair.of((Object)1, (Object)((Object)new PressRandomCopperButton(1.0f, 16, 4, 150))));
        }
        behaviorsBuilder.add((Object)Pair.of((Object)2, (Object)class_7895.method_47069((class_1299)class_1299.field_6097, (float)6.0f, (class_6019)class_6019.method_35017((int)40, (int)80))));
        behaviorsBuilder.add((Object)Pair.of((Object)3, (Object)new class_4118((Map)ImmutableMap.of((Object)class_4140.field_18445, (Object)class_4141.field_18457, ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), (Object)class_4141.field_18456), (List)ImmutableList.of((Object)Pair.of((Object)class_4818.method_47015((float)1.0f, (int)2, (int)2), (Object)1), (Object)Pair.of((Object)new class_4101(30, 60), (Object)1)))));
        brain.method_18881(class_4168.field_18595, behaviorsBuilder.build());
    }

    private static Map<TransportItemsBetweenContainers.ContainerInteractionState, TransportItemsBetweenContainers.OnTargetReachedInteraction> getTargetReachedInteractions() {
        return Map.of(TransportItemsBetweenContainers.ContainerInteractionState.PICKUP_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.GETTING_ITEM, ModSounds.COPPER_GOLEM_ITEM_GET.get()), TransportItemsBetweenContainers.ContainerInteractionState.PICKUP_NO_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.GETTING_NO_ITEM, ModSounds.COPPER_GOLEM_ITEM_NO_GET.get()), TransportItemsBetweenContainers.ContainerInteractionState.PLACE_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.DROPPING_ITEM, ModSounds.COPPER_GOLEM_ITEM_DROP.get()), TransportItemsBetweenContainers.ContainerInteractionState.PLACE_NO_ITEM, CopperGolemAi.onReachedTargetInteraction(CopperGolemState.DROPPING_NO_ITEM, ModSounds.COPPER_GOLEM_ITEM_NO_DROP.get()));
    }

    private static TransportItemsBetweenContainers.OnTargetReachedInteraction onReachedTargetInteraction(CopperGolemState state, @Nullable class_3414 sound) {
        return (mob, target, tick) -> {
            if (mob instanceof CopperGolemEntity) {
                CopperGolemEntity copperGolem = (CopperGolemEntity)mob;
                if (tick == 1) {
                    CopperGolemAi.playChestSound(copperGolem, target.pos(), true);
                    copperGolem.setOpenedChestPos(target.pos());
                    copperGolem.setState(state);
                }
                if (tick == 9 && sound != null) {
                    copperGolem.method_5783(sound, 1.0f, 1.0f);
                }
                if (tick == 60) {
                    CopperGolemAi.playChestSound(copperGolem, target.pos(), false);
                    copperGolem.clearOpenedChestPos();
                }
            }
        };
    }

    private static void playChestSound(CopperGolemEntity golem, class_2338 pos, boolean open) {
        class_2680 blockState;
        class_1937 level = golem.method_37908();
        if (ModCompat.handleChestOpen(level, pos, blockState = level.method_8320(pos), open)) {
            level.method_33596((class_1297)golem, (class_6880)(open ? class_5712.field_28176 : class_5712.field_28177), pos);
            return;
        }
        class_3414 soundEvent = blockState.method_26164(ModTags.Blocks.COPPER_CHESTS) ? (open ? ModSounds.COPPER_CHEST_OPEN.get() : ModSounds.COPPER_CHEST_CLOSE.get()) : (blockState.method_26204() instanceof class_3708 ? (open ? class_3417.field_17604 : class_3417.field_17603) : (open ? class_3417.field_14982 : class_3417.field_14823));
        level.method_8396(null, pos, soundEvent, class_3419.field_15245, 0.5f, level.field_9229.method_43057() * 0.1f + 0.9f);
        try {
            class_2586 blockEntity = level.method_8321(pos);
            if (blockEntity != null) {
                if (blockState.method_26204() instanceof class_3708) {
                    if (blockState.method_28498((class_2769)class_3708.field_18006)) {
                        level.method_8652(pos, (class_2680)blockState.method_11657((class_2769)class_3708.field_18006, (Comparable)Boolean.valueOf(open)), 3);
                    }
                } else if (blockState.method_26204() instanceof class_2281) {
                    level.method_8427(pos, blockState.method_26204(), 1, open ? 1 : 0);
                } else {
                    level.method_8427(pos, blockState.method_26204(), 1, open ? 1 : 0);
                }
            }
        }
        catch (Exception e) {
            Constants.LOG.debug("Failed to animate container at {}: {}", (Object)pos, (Object)e.getMessage());
        }
        level.method_33596((class_1297)golem, (class_6880)(open ? class_5712.field_28176 : class_5712.field_28177), pos);
    }

    private static Consumer<class_1314> onTravelling() {
        return mob -> {
            if (mob instanceof CopperGolemEntity) {
                CopperGolemEntity copperGolem = (CopperGolemEntity)mob;
                copperGolem.clearOpenedChestPos();
                copperGolem.setState(CopperGolemState.IDLE);
            }
        };
    }

    private static Predicate<TransportItemsBetweenContainers.TransportItemTarget> shouldQueueForTarget() {
        return target -> false;
    }

    private static boolean isValidDestinationContainer(class_2680 state) {
        if (state.method_26164(ModTags.Blocks.COPPER_CHESTS)) {
            return false;
        }
        if (state.method_26204() instanceof class_2281) {
            return true;
        }
        if (state.method_26204() instanceof class_3708) {
            return true;
        }
        return ModCompat.isValidModContainer(state);
    }

    public static void updateActivity(CopperGolemEntity golem) {
        golem.method_18868().method_24531((List)ImmutableList.of((Object)class_4168.field_18595));
    }
}

