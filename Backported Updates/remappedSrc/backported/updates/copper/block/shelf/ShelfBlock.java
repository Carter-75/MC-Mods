/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_10
 *  net.minecraft.class_1264
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2415
 *  net.minecraft.class_2464
 *  net.minecraft.class_2470
 *  net.minecraft.class_2586
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3726
 *  net.minecraft.class_3737
 *  net.minecraft.class_3965
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5712
 *  net.minecraft.class_5712$class_7397
 *  net.minecraft.class_6880
 *  net.minecraft.class_9062
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block.shelf;

import backported.updates.copper.ModSounds;
import backported.updates.copper.ModTags;
import backported.updates.copper.block.shelf.SelectableSlotContainer;
import backported.updates.copper.block.shelf.ShelfBlockEntity;
import backported.updates.copper.block.shelf.SideChainPart;
import backported.updates.copper.block.shelf.SideChainPartBlock;
import com.mojang.serialization.MapCodec;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import net.minecraft.class_10;
import net.minecraft.class_1264;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_2464;
import net.minecraft.class_2470;
import net.minecraft.class_2586;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_3965;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5712;
import net.minecraft.class_6880;
import net.minecraft.class_9062;
import org.jetbrains.annotations.Nullable;

public class ShelfBlock
extends class_2237
implements SelectableSlotContainer,
SideChainPartBlock,
class_3737 {
    public static final MapCodec<ShelfBlock> CODEC = ShelfBlock.method_54094(ShelfBlock::new);
    public static final class_2746 POWERED = class_2741.field_12484;
    public static final class_2754<class_2350> FACING = class_2741.field_12481;
    public static final class_2754<SideChainPart> SIDE_CHAIN_PART = class_2754.method_11850((String)"side_chain_part", SideChainPart.class);
    public static final class_2746 WATERLOGGED = class_2741.field_12508;
    private static final Map<class_2350, class_265> SHAPES = ShelfBlock.createShapes();

    private static Map<class_2350, class_265> createShapes() {
        EnumMap<class_2350, class_265> map = new EnumMap<class_2350, class_265>(class_2350.class);
        class_265 baseShape = class_259.method_17786((class_265)class_2248.method_9541((double)0.0, (double)12.0, (double)11.0, (double)16.0, (double)16.0, (double)13.0), (class_265[])new class_265[]{class_2248.method_9541((double)0.0, (double)0.0, (double)13.0, (double)16.0, (double)16.0, (double)16.0), class_2248.method_9541((double)0.0, (double)0.0, (double)11.0, (double)16.0, (double)4.0, (double)13.0)});
        map.put(class_2350.field_11043, baseShape);
        map.put(class_2350.field_11035, ShelfBlock.rotateShape(baseShape, class_2350.field_11035));
        map.put(class_2350.field_11039, ShelfBlock.rotateShape(baseShape, class_2350.field_11039));
        map.put(class_2350.field_11034, ShelfBlock.rotateShape(baseShape, class_2350.field_11034));
        return map;
    }

    private static class_265 rotateShape(class_265 shape, class_2350 direction) {
        return switch (direction) {
            case class_2350.field_11035 -> class_259.method_17786((class_265)class_2248.method_9541((double)0.0, (double)12.0, (double)3.0, (double)16.0, (double)16.0, (double)5.0), (class_265[])new class_265[]{class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)3.0), class_2248.method_9541((double)0.0, (double)0.0, (double)3.0, (double)16.0, (double)4.0, (double)5.0)});
            case class_2350.field_11039 -> class_259.method_17786((class_265)class_2248.method_9541((double)11.0, (double)12.0, (double)0.0, (double)13.0, (double)16.0, (double)16.0), (class_265[])new class_265[]{class_2248.method_9541((double)13.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0), class_2248.method_9541((double)11.0, (double)0.0, (double)0.0, (double)13.0, (double)4.0, (double)16.0)});
            case class_2350.field_11034 -> class_259.method_17786((class_265)class_2248.method_9541((double)3.0, (double)12.0, (double)0.0, (double)5.0, (double)16.0, (double)16.0), (class_265[])new class_265[]{class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)3.0, (double)16.0, (double)16.0), class_2248.method_9541((double)3.0, (double)0.0, (double)0.0, (double)5.0, (double)4.0, (double)16.0)});
            default -> shape;
        };
    }

    public ShelfBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)((class_2680)((class_2680)this.field_10647.method_11664()).method_11657(FACING, (Comparable)class_2350.field_11043)).method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(false))).method_11657(SIDE_CHAIN_PART, (Comparable)((Object)SideChainPart.UNCONNECTED))).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected MapCodec<? extends class_2237> method_53969() {
        return CODEC;
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{FACING, POWERED, SIDE_CHAIN_PART, WATERLOGGED});
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return SHAPES.get(state.method_11654(FACING));
    }

    public boolean method_9526(class_2680 state) {
        return true;
    }

    public class_2464 method_9604(class_2680 state) {
        return class_2464.field_11458;
    }

    protected boolean method_9516(class_2680 state, class_10 type) {
        return false;
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new ShelfBlockEntity(pos, state);
    }

    public class_2680 method_9605(class_1750 context) {
        class_3610 fluidstate = context.method_8045().method_8316(context.method_8037());
        return (class_2680)((class_2680)((class_2680)this.method_9564().method_11657(FACING, (Comparable)context.method_8042().method_10153())).method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(context.method_8045().method_49803(context.method_8037())))).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(fluidstate.method_15772() == class_3612.field_15910));
    }

    public class_2680 method_9598(class_2680 state, class_2470 rotation) {
        return (class_2680)state.method_11657(FACING, (Comparable)rotation.method_10503((class_2350)state.method_11654(FACING)));
    }

    public class_2680 method_9569(class_2680 state, class_2415 mirror) {
        return state.method_26186(mirror.method_10345((class_2350)state.method_11654(FACING)));
    }

    public void method_9612(class_2680 state, class_1937 level, class_2338 pos, class_2248 block, class_2338 fromPos, boolean isMoving) {
        if (!level.method_8608()) {
            boolean hasSignal = level.method_49803(pos);
            if ((Boolean)state.method_11654((class_2769)POWERED) != hasSignal) {
                class_2680 newState = (class_2680)state.method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(hasSignal));
                if (!hasSignal) {
                    newState = (class_2680)newState.method_11657(SIDE_CHAIN_PART, (Comparable)((Object)SideChainPart.UNCONNECTED));
                }
                level.method_8652(pos, newState, 3);
                this.playSound((class_1936)level, pos, hasSignal ? ModSounds.SHELF_ACTIVATE.get() : ModSounds.SHELF_DEACTIVATE.get());
                level.method_43276((class_6880)(hasSignal ? class_5712.field_28174 : class_5712.field_28175), pos, class_5712.class_7397.method_43287((class_2680)newState));
            }
        }
    }

    public void method_9615(class_2680 state, class_1937 level, class_2338 pos, class_2680 oldState, boolean isMoving) {
        if (((Boolean)state.method_11654((class_2769)POWERED)).booleanValue()) {
            this.updateSelfAndNeighborsOnPoweringUp((class_1936)level, pos, state, oldState);
        } else {
            this.updateNeighborsAfterPoweringDown((class_1936)level, pos, state);
        }
    }

    public void method_9536(class_2680 state, class_1937 level, class_2338 pos, class_2680 newState, boolean isMoving) {
        if (!state.method_27852(newState.method_26204())) {
            class_2586 blockentity = level.method_8321(pos);
            if (blockentity instanceof ShelfBlockEntity) {
                ShelfBlockEntity shelfEntity = (ShelfBlockEntity)blockentity;
                for (int i = 0; i < shelfEntity.method_5439(); ++i) {
                    class_1799 itemStack = shelfEntity.method_5438(i);
                    if (itemStack.method_7960()) continue;
                    class_1264.method_5449((class_1937)level, (double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), (class_1799)itemStack);
                }
                level.method_8455(pos, (class_2248)this);
            }
            this.updateNeighborsAfterPoweringDown((class_1936)level, pos, state);
        }
        super.method_9536(state, level, pos, newState, isMoving);
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        class_2586 class_25862 = level.method_8321(pos);
        if (class_25862 instanceof ShelfBlockEntity) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)class_25862;
            if (hand == class_1268.field_5808) {
                OptionalInt slotOpt = this.getHitSlot(hit, (class_2350)state.method_11654(FACING));
                if (slotOpt.isEmpty()) {
                    return class_9062.field_47731;
                }
                if (level.method_8608()) {
                    return class_9062.field_47728;
                }
                class_1661 inventory = player.method_31548();
                class_1799 heldItem = stack;
                if (!((Boolean)state.method_11654((class_2769)POWERED)).booleanValue()) {
                    boolean swapped = ShelfBlock.swapSingleItem(heldItem, player, shelfEntity, slotOpt.getAsInt(), inventory);
                    if (swapped) {
                        this.playSound((class_1936)level, pos, heldItem.method_7960() ? ModSounds.SHELF_TAKE_ITEM.get() : ModSounds.SHELF_SINGLE_SWAP.get());
                    } else {
                        if (heldItem.method_7960()) {
                            return class_9062.field_47731;
                        }
                        this.playSound((class_1936)level, pos, ModSounds.SHELF_PLACE_ITEM.get());
                    }
                    return class_9062.field_47729;
                }
                boolean swapped = this.swapHotbar(level, pos, inventory);
                if (!swapped) {
                    return class_9062.field_47729;
                }
                this.playSound((class_1936)level, pos, ModSounds.SHELF_MULTI_SWAP.get());
                return class_9062.field_47729;
            }
        }
        return class_9062.field_47731;
    }

    protected class_1269 method_55766(class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_3965 hit) {
        class_2586 class_25862 = level.method_8321(pos);
        if (class_25862 instanceof ShelfBlockEntity) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)class_25862;
            OptionalInt slotOpt = this.getHitSlot(hit, (class_2350)state.method_11654(FACING));
            if (slotOpt.isEmpty()) {
                return class_1269.field_5811;
            }
            if (level.method_8608()) {
                return class_1269.field_5812;
            }
            class_1661 inventory = player.method_31548();
            if (!((Boolean)state.method_11654((class_2769)POWERED)).booleanValue()) {
                int slot = slotOpt.getAsInt();
                class_1799 shelfItem = shelfEntity.method_5438(slot);
                if (!shelfItem.method_7960()) {
                    class_1799 takenItem = shelfItem.method_7972();
                    shelfEntity.method_5447(slot, class_1799.field_8037);
                    if (!player.method_31548().method_7394(takenItem)) {
                        player.method_7328(takenItem, false);
                    }
                    shelfEntity.method_5431();
                    this.playSound((class_1936)level, pos, ModSounds.SHELF_TAKE_ITEM.get());
                    return class_1269.field_21466;
                }
                return class_1269.field_5811;
            }
            boolean swapped = this.swapHotbar(level, pos, inventory);
            if (!swapped) {
                return class_1269.field_21466;
            }
            this.playSound((class_1936)level, pos, ModSounds.SHELF_MULTI_SWAP.get());
            return class_1269.field_21466;
        }
        return class_1269.field_5811;
    }

    private static boolean swapSingleItem(class_1799 heldStack, class_1657 player, ShelfBlockEntity shelf, int slot, class_1661 inventory) {
        class_1799 shelfItem = shelf.swapItemNoUpdate(slot, heldStack);
        class_1799 newHeldItem = player.method_31549().field_7477 && shelfItem.method_7960() ? heldStack.method_7972() : shelfItem;
        inventory.method_5447(inventory.field_7545, newHeldItem);
        inventory.method_5431();
        shelf.method_5431();
        return !shelfItem.method_7960();
    }

    private boolean swapHotbar(class_1937 level, class_2338 pos, class_1661 inventory) {
        List connectedBlocks = this.getAllBlocksConnectedTo((class_1936)level, pos);
        if (connectedBlocks.isEmpty()) {
            return false;
        }
        boolean anySwapped = false;
        for (int i = 0; i < connectedBlocks.size(); ++i) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)level.method_8321((class_2338)connectedBlocks.get(i));
            if (shelfEntity == null) continue;
            for (int j = 0; j < shelfEntity.method_5439(); ++j) {
                int hotbarSlot = 9 - (connectedBlocks.size() - i) * shelfEntity.method_5439() + j;
                if (hotbarSlot < 0 || hotbarSlot >= 9) continue;
                class_1799 hotbarItem = inventory.method_5441(hotbarSlot);
                class_1799 shelfItem = shelfEntity.swapItemNoUpdate(j, hotbarItem);
                if (hotbarItem.method_7960() && shelfItem.method_7960()) continue;
                inventory.method_5447(hotbarSlot, shelfItem);
                anySwapped = true;
            }
            inventory.method_5431();
            shelfEntity.method_5431();
        }
        return anySwapped;
    }

    private void playSound(class_1936 level, class_2338 pos, class_3414 sound) {
        level.method_8396(null, pos, sound, class_3419.field_15245, 1.0f, 1.0f);
    }

    public class_3610 method_9545(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 currentPos, class_2338 neighborPos) {
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            level.method_39281(currentPos, (class_3611)class_3612.field_15910, class_3612.field_15910.method_15789((class_4538)level));
        }
        return super.method_9559(state, direction, neighborState, level, currentPos, neighborPos);
    }

    public boolean method_9498(class_2680 state) {
        return true;
    }

    public int method_9572(class_2680 state, class_1937 level, class_2338 pos) {
        if (level.method_8608()) {
            return 0;
        }
        class_2586 class_25862 = level.method_8321(pos);
        if (class_25862 instanceof ShelfBlockEntity) {
            ShelfBlockEntity shelfEntity = (ShelfBlockEntity)class_25862;
            int slot0 = shelfEntity.method_5438(0).method_7960() ? 0 : 1;
            int slot1 = shelfEntity.method_5438(1).method_7960() ? 0 : 1;
            int slot2 = shelfEntity.method_5438(2).method_7960() ? 0 : 1;
            return slot0 | slot1 << 1 | slot2 << 2;
        }
        return 0;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public int getColumns() {
        return 3;
    }

    @Override
    public SideChainPart getSideChainPart(class_2680 state) {
        return (SideChainPart)((Object)state.method_11654(SIDE_CHAIN_PART));
    }

    @Override
    public class_2680 setSideChainPart(class_2680 state, SideChainPart part) {
        return (class_2680)state.method_11657(SIDE_CHAIN_PART, (Comparable)((Object)part));
    }

    @Override
    public class_2350 getFacing(class_2680 state) {
        return (class_2350)state.method_11654(FACING);
    }

    @Override
    public boolean isConnectable(class_2680 state) {
        return state.method_26164(ModTags.Blocks.WOODEN_SHELVES) && state.method_28498((class_2769)POWERED) && (Boolean)state.method_11654((class_2769)POWERED) != false;
    }

    @Override
    public int getMaxChainLength() {
        return 3;
    }
}

