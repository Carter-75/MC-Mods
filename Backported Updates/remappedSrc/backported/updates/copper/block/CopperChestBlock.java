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
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2371
 *  net.minecraft.class_2464
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2745
 *  net.minecraft.class_2769
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3726
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_9062
 */
package backported.updates.copper.block;

import backported.updates.copper.ModSounds;
import backported.updates.copper.block.entity.CopperChestBlockEntity;
import backported.updates.copper.platform.Services;
import backported.updates.copper.registry.ModBlockEntities;
import backported.updates.copper.registry.ModBlocks;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.class_1263;
import net.minecraft.class_1268;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2371;
import net.minecraft.class_2464;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import net.minecraft.class_5955;
import net.minecraft.class_9062;

public class CopperChestBlock
extends class_2281 {
    private static final Map<class_2248, Supplier<class_2248>> COPPER_TO_COPPER_CHEST_MAPPING = Map.of(class_2246.field_27119, () -> (class_2248)ModBlocks.COPPER_CHEST.get(), class_2246.field_27118, () -> (class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get(), class_2246.field_27117, () -> (class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get(), class_2246.field_27116, () -> (class_2248)ModBlocks.OXIDIZED_COPPER_CHEST.get(), class_2246.field_27133, () -> (class_2248)ModBlocks.COPPER_CHEST.get(), class_2246.field_27135, () -> (class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get(), class_2246.field_27134, () -> (class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get(), class_2246.field_33407, () -> (class_2248)ModBlocks.OXIDIZED_COPPER_CHEST.get());
    protected final class_5955.class_5811 weatherState;
    private final class_3414 openSound;
    private final class_3414 closeSound;

    public CopperChestBlock(class_5955.class_5811 weatherState, class_4970.class_2251 properties) {
        super(properties, () -> ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get());
        this.weatherState = weatherState;
        this.openSound = ModSounds.COPPER_CHEST_OPEN.get();
        this.closeSound = ModSounds.COPPER_CHEST_CLOSE.get();
    }

    public MapCodec<? extends class_2281> method_53969() {
        return null;
    }

    public class_5955.class_5811 getState() {
        return this.weatherState;
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)14.0, (double)15.0);
    }

    public class_265 method_9549(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)14.0, (double)15.0);
    }

    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new CopperChestBlockEntity(pos, state);
    }

    public class_2464 method_9604(class_2680 state) {
        if (Services.PLATFORM.isFastChestSimplifiedEnabled()) {
            return class_2464.field_11458;
        }
        return super.method_9604(state);
    }

    public <T extends class_2586> class_5558<T> method_31645(class_1937 level, class_2680 state, class_2591<T> type) {
        if (Services.PLATFORM.isFastChestSimplifiedEnabled()) {
            return null;
        }
        return super.method_31645(level, state, type);
    }

    public static class_2680 getFromCopperBlock(class_2248 block, class_2350 direction, class_1937 level, class_2338 pos) {
        class_2248 chestBlock = COPPER_TO_COPPER_CHEST_MAPPING.getOrDefault(block, () -> (class_2248)ModBlocks.COPPER_CHEST.get()).get();
        return (class_2680)chestBlock.method_9564().method_11657((class_2769)field_10768, (Comparable)direction);
    }

    public static Optional<class_2248> getUnwaxedBlock(class_2248 block) {
        if (block == ModBlocks.WAXED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.COPPER_CHEST.get());
        }
        if (block == ModBlocks.WAXED_EXPOSED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WAXED_WEATHERED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_CHEST.get());
        }
        if (block == ModBlocks.WAXED_OXIDIZED_COPPER_CHEST.get()) {
            return Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_CHEST.get());
        }
        return Optional.empty();
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hitResult) {
        if (stack.method_31573(class_3489.field_42612)) {
            CopperChestBlockEntity chestEntity;
            class_2586 class_25862 = level.method_8321(pos);
            if (class_25862 instanceof CopperChestBlockEntity && (chestEntity = (CopperChestBlockEntity)class_25862).isChestOpen()) {
                return class_9062.field_47731;
            }
            Optional<class_2248> unwaxedBlock = CopperChestBlock.getUnwaxedBlock(state.method_26204());
            if (unwaxedBlock.isPresent()) {
                class_2745 chestType = (class_2745)state.method_11654((class_2769)field_10770);
                class_2248 newBlock = unwaxedBlock.get();
                if (chestType != class_2745.field_12569) {
                    class_2350 connectedDir = class_2281.method_9758((class_2680)state);
                    class_2338 connectedPos = pos.method_10093(connectedDir);
                    class_2680 connectedState = level.method_8320(connectedPos);
                    if (connectedState.method_26204() == state.method_26204()) {
                        level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3004, pos, 0);
                        level.method_8396(player, connectedPos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3004, connectedPos, 0);
                    } else {
                        level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
                        level.method_8444(player, 3004, pos, 0);
                    }
                } else {
                    level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
                    level.method_8444(player, 3004, pos, 0);
                }
                if (!level.field_9236) {
                    class_2371<class_1799> currentItems = CopperChestBlock.copyInventoryAndClear(level, pos);
                    class_2371<class_1799> connectedItems = class_2371.method_10211();
                    class_2680 newState = newBlock.method_34725(state);
                    if (chestType != class_2745.field_12569) {
                        class_2350 connectedDir = class_2281.method_9758((class_2680)state);
                        class_2338 connectedPos = pos.method_10093(connectedDir);
                        class_2680 connectedState = level.method_8320(connectedPos);
                        if (connectedState.method_26204() == state.method_26204()) {
                            class_2680 connectedNewState = newBlock.method_34725(connectedState);
                            connectedItems = CopperChestBlock.copyInventoryAndClear(level, connectedPos);
                            level.method_8652(pos, newState, 2);
                            level.method_8652(connectedPos, connectedNewState, 2);
                            level.method_8408(pos, newBlock);
                            level.method_8408(connectedPos, newBlock);
                            CopperChestBlock.restoreInventory(level, pos, currentItems);
                            CopperChestBlock.restoreInventory(level, connectedPos, connectedItems);
                        } else {
                            level.method_8501(pos, newState);
                            CopperChestBlock.restoreInventory(level, pos, currentItems);
                        }
                    } else {
                        level.method_8501(pos, newState);
                        CopperChestBlock.restoreInventory(level, pos, currentItems);
                    }
                    stack.method_7970(1, (class_1309)player, class_1309.method_56079((class_1268)hand));
                }
                return class_9062.field_47728;
            }
            return class_9062.field_47728;
        }
        return super.method_55765(stack, state, level, pos, player, hand, hitResult);
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

