/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1263
 *  net.minecraft.class_1268
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2371
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2745
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.block.CopperChestBlock;
import backported.updates.copper.block.entity.CopperChestBlockEntity;
import backported.updates.copper.registry.ModBlocks;
import backported.updates.copper.util.WeatheringHelper;
import com.mojang.serialization.MapCodec;
import java.util.Optional;
import net.minecraft.class_1263;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class WeatheringCopperChestBlock
extends CopperChestBlock
implements class_5955 {
    public WeatheringCopperChestBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(weatheringState, properties);
    }

    public MapCodec<? extends WeatheringCopperChestBlock> method_53969() {
        return null;
    }

    public static Optional<class_2248> getNextBlock(class_2248 block) {
        if (block == ModBlocks.COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_CHEST.get());
        }
        return class_5955.method_34737((class_2248)block);
    }

    public static Optional<class_2248> getPreviousBlock(class_2248 block) {
        if (block == ModBlocks.OXIDIZED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WEATHERED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.EXPOSED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.COPPER_CHEST.get());
        }
        return Optional.empty();
    }

    @Override
    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        if (stack.method_31573(class_3489.field_42612)) {
            CopperChestBlockEntity chestEntity;
            class_2586 class_25862 = level.method_8321(pos);
            if (class_25862 instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)class_25862).isChestOpen()) {
                return class_9062.field_47731;
            }
            Optional<class_2248> previousBlock = WeatheringCopperChestBlock.getPreviousBlock(state.method_26204());
            if (previousBlock.isPresent()) {
                class_2745 chestType = (class_2745)state.method_11654((class_2769)field_10770);
                class_2248 newBlock = previousBlock.get();
                if (chestType != class_2745.field_12569) {
                    class_2350 connectedDir = class_2281.method_9758((class_2680)state);
                    class_2338 connectedPos = pos.method_10093(connectedDir);
                    class_2680 connectedState = level.method_8320(connectedPos);
                    if (connectedState.method_26204() == state.method_26204()) {
                        level.method_8396(player, pos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3005, pos, 0);
                        level.method_8396(player, connectedPos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3005, connectedPos, 0);
                    } else {
                        level.method_8396(player, pos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3005, pos, 0);
                    }
                } else {
                    level.method_8396(player, pos, class_3417.field_29541, class_3419.field_15245, 1.0f, 1.0f);
                    level.method_8444(player, 3005, pos, 0);
                }
                if (!level.field_9236) {
                    class_2371<class_1799> currentItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, pos);
                    class_2371<class_1799> connectedItems = class_2371.method_10211();
                    class_2680 newState = newBlock.method_34725(state);
                    if (chestType != class_2745.field_12569) {
                        class_2350 connectedDir = class_2281.method_9758((class_2680)state);
                        class_2338 connectedPos = pos.method_10093(connectedDir);
                        class_2680 connectedState = level.method_8320(connectedPos);
                        if (connectedState.method_26204() == state.method_26204()) {
                            class_2680 connectedNewState = newBlock.method_34725(connectedState);
                            connectedItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, connectedPos);
                            level.method_8652(pos, newState, 2);
                            level.method_8652(connectedPos, connectedNewState, 2);
                            level.method_8408(pos, newBlock);
                            level.method_8408(connectedPos, newBlock);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                            WeatheringCopperChestBlock.restoreInventory(level, connectedPos, connectedItems);
                            stack.method_7970(2, (class_1309)player, class_1309.method_56079((class_1268)hand));
                        } else {
                            level.method_8501(pos, newState);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                            stack.method_7970(1, (class_1309)player, class_1309.method_56079((class_1268)hand));
                        }
                    } else {
                        level.method_8501(pos, newState);
                        WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                        stack.method_7970(1, (class_1309)player, class_1309.method_56079((class_1268)hand));
                    }
                }
                return class_9062.field_47728;
            }
            return class_9062.field_47731;
        }
        if (stack.method_31574(class_1802.field_20414)) {
            CopperChestBlockEntity chestEntity;
            class_2586 chestType = level.method_8321(pos);
            if (chestType instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)chestType).isChestOpen()) {
                return class_9062.field_47731;
            }
            class_2248 waxedBlock = null;
            if (this == ModBlocks.COPPER_CHEST.get()) {
                waxedBlock = (class_2248)ModBlocks.WAXED_COPPER_CHEST.get();
            } else if (this == ModBlocks.EXPOSED_COPPER_CHEST.get()) {
                waxedBlock = (class_2248)ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get();
            } else if (this == ModBlocks.WEATHERED_COPPER_CHEST.get()) {
                waxedBlock = (class_2248)ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get();
            } else if (this == ModBlocks.OXIDIZED_COPPER_CHEST.get()) {
                waxedBlock = (class_2248)ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get();
            }
            if (waxedBlock != null) {
                chestType = (class_2745)state.method_11654((class_2769)field_10770);
                if (chestType != class_2745.field_12569) {
                    class_2350 connectedDir = class_2281.method_9758((class_2680)state);
                    class_2338 connectedPos = pos.method_10093(connectedDir);
                    class_2680 connectedState = level.method_8320(connectedPos);
                    if (connectedState.method_26204() == state.method_26204()) {
                        level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3003, pos, 0);
                        level.method_8396(player, connectedPos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3003, connectedPos, 0);
                    } else {
                        level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3003, pos, 0);
                    }
                } else {
                    level.method_8396(player, pos, class_3417.field_29543, class_3419.field_15245, 1.0f, 1.0f);
                    level.method_8444(player, 3003, pos, 0);
                }
                if (!level.field_9236) {
                    class_2371<class_1799> currentItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, pos);
                    class_2371<class_1799> connectedItems = class_2371.method_10211();
                    class_2680 waxedState = waxedBlock.method_34725(state);
                    if (chestType != class_2745.field_12569) {
                        class_2350 connectedDir = class_2281.method_9758((class_2680)state);
                        class_2338 connectedPos = pos.method_10093(connectedDir);
                        class_2680 connectedState = level.method_8320(connectedPos);
                        if (connectedState.method_26204() == state.method_26204()) {
                            class_2680 connectedWaxedState = waxedBlock.method_34725(connectedState);
                            connectedItems = WeatheringCopperChestBlock.copyInventoryAndClear(level, connectedPos);
                            level.method_8652(pos, waxedState, 2);
                            level.method_8652(connectedPos, connectedWaxedState, 2);
                            level.method_8408(pos, waxedBlock);
                            level.method_8408(connectedPos, waxedBlock);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                            WeatheringCopperChestBlock.restoreInventory(level, connectedPos, connectedItems);
                        } else {
                            level.method_8501(pos, waxedState);
                            WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                        }
                    } else {
                        level.method_8501(pos, waxedState);
                        WeatheringCopperChestBlock.restoreInventory(level, pos, currentItems);
                    }
                    stack.method_57008(1, (class_1309)player);
                }
                return class_9062.field_47728;
            }
            return class_9062.field_47731;
        }
        return super.method_55765(stack, state, level, pos, player, hand, hitResult);
    }

    protected void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        class_2350 connectedDir;
        class_2338 otherPos;
        class_2680 otherState;
        CopperChestBlockEntity chestEntity;
        class_2745 chestType = (class_2745)state.method_11654((class_2769)field_10770);
        if (chestType.equals((Object)class_2745.field_12571)) {
            return;
        }
        class_2586 class_25862 = level.method_8321(pos);
        if (class_25862 instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)class_25862).isChestOpen()) {
            return;
        }
        Optional<class_2248> nextBlock = WeatheringCopperChestBlock.getNextBlock(state.method_26204());
        if (!nextBlock.isPresent() || random.method_43057() >= 0.05688889f) {
            return;
        }
        class_2248 newBlock = nextBlock.get();
        if (chestType != class_2745.field_12569 && (otherState = level.method_8320(otherPos = pos.method_10093(connectedDir = class_2281.method_9758((class_2680)state)))).method_26204() == state.method_26204()) {
            CopperChestBlockEntity otherChest;
            class_2586 class_25863 = level.method_8321(otherPos);
            if (class_25863 instanceof CopperChestBlockEntity && (otherChest = (CopperChestBlockEntity)class_25863).isChestOpen()) {
                return;
            }
            class_2371<class_1799> thisItems = WeatheringCopperChestBlock.copyInventoryAndClear((class_1937)level, pos);
            class_2371<class_1799> otherItems = WeatheringCopperChestBlock.copyInventoryAndClear((class_1937)level, otherPos);
            class_2680 newState = newBlock.method_34725(state);
            class_2680 newOtherState = newBlock.method_34725(otherState);
            level.method_8652(pos, newState, 2);
            level.method_8652(otherPos, newOtherState, 2);
            level.method_8408(pos, newBlock);
            level.method_8408(otherPos, newBlock);
            WeatheringCopperChestBlock.restoreInventory((class_1937)level, pos, thisItems);
            WeatheringCopperChestBlock.restoreInventory((class_1937)level, otherPos, otherItems);
            return;
        }
        class_2371<class_1799> currentItems = WeatheringCopperChestBlock.copyInventoryAndClear((class_1937)level, pos);
        class_2680 newState = newBlock.method_34725(state);
        level.method_8652(pos, newState, 2);
        WeatheringCopperChestBlock.restoreInventory((class_1937)level, pos, currentItems);
        level.method_8408(pos, newBlock);
    }

    protected boolean method_9542(class_2680 state) {
        return WeatheringHelper.canWeather(state, WeatheringCopperChestBlock::getNextBlock);
    }

    public class_5955.class_5811 getAge() {
        return this.getState();
    }

    protected static class_2371<class_1799> copyInventoryAndClear(class_1937 level, class_2338 pos) {
        class_2586 blockEntity = level.method_8321(pos);
        if (blockEntity instanceof class_1263) {
            class_1263 container = (class_1263)blockEntity;
            class_2371 items = class_2371.method_10213((int)container.method_5439(), (Object)class_1799.field_8037);
            for (int i = 0; i < container.method_5439(); ++i) {
                items.set(i, (Object)container.method_5438(i).method_7972());
            }
            container.method_5448();
            if (blockEntity instanceof CopperChestBlockEntity) {
                CopperChestBlockEntity chestEntity = (CopperChestBlockEntity)blockEntity;
                chestEntity.method_5431();
            }
            return items;
        }
        return class_2371.method_10211();
    }

    protected static void restoreInventory(class_1937 level, class_2338 pos, class_2371<class_1799> items) {
        if (items.isEmpty()) {
            return;
        }
        class_2586 blockEntity = level.method_8321(pos);
        if (blockEntity instanceof class_1263) {
            class_1263 container = (class_1263)blockEntity;
            for (int i = 0; i < Math.min(container.method_5439(), items.size()); ++i) {
                container.method_5447(i, (class_1799)items.get(i));
            }
            if (blockEntity instanceof CopperChestBlockEntity) {
                CopperChestBlockEntity chestEntity = (CopperChestBlockEntity)blockEntity;
                chestEntity.method_5431();
            }
        }
    }
}

