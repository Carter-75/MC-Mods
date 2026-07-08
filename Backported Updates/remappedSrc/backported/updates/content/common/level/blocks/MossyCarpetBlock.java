/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.collect.Maps
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1309
 *  net.minecraft.class_156
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2256
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2353
 *  net.minecraft.class_2415
 *  net.minecraft.class_2470
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2754
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3726
 *  net.minecraft.class_4538
 *  net.minecraft.class_4778
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5778
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.common.registries.ModBlocks;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.minecraft.class_1309;
import net.minecraft.class_156;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2256;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_2470;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2754;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3726;
import net.minecraft.class_4538;
import net.minecraft.class_4778;
import net.minecraft.class_4970;
import net.minecraft.class_5778;
import net.minecraft.class_5819;
import org.jetbrains.annotations.Nullable;

public class MossyCarpetBlock
extends class_2248
implements class_2256 {
    public static final MapCodec<MossyCarpetBlock> CODEC = MossyCarpetBlock.method_54094(MossyCarpetBlock::new);
    public static final class_2746 BASE = class_2741.field_16562;
    private static final class_2754<class_4778> NORTH = class_2741.field_22175;
    private static final class_2754<class_4778> EAST = class_2741.field_22174;
    private static final class_2754<class_4778> SOUTH = class_2741.field_22176;
    private static final class_2754<class_4778> WEST = class_2741.field_22177;
    private static final Map<class_2350, class_2754<class_4778>> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf((Map)((Map)class_156.method_654((Object)Maps.newEnumMap(class_2350.class), enumMap -> {
        enumMap.put(class_2350.field_11043, NORTH);
        enumMap.put(class_2350.field_11034, EAST);
        enumMap.put(class_2350.field_11035, SOUTH);
        enumMap.put(class_2350.field_11039, WEST);
    })));
    private static final class_265 DOWN_AABB = class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)1.0, (double)16.0);
    private static final class_265 WEST_AABB = class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)1.0, (double)16.0, (double)16.0);
    private static final class_265 EAST_AABB = class_2248.method_9541((double)15.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
    private static final class_265 NORTH_AABB = class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)1.0);
    private static final class_265 SOUTH_AABB = class_2248.method_9541((double)0.0, (double)0.0, (double)15.0, (double)16.0, (double)16.0, (double)16.0);
    private static final class_265 WEST_SHORT_AABB = class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)1.0, (double)10.0, (double)16.0);
    private static final class_265 EAST_SHORT_AABB = class_2248.method_9541((double)15.0, (double)0.0, (double)0.0, (double)16.0, (double)10.0, (double)16.0);
    private static final class_265 NORTH_SHORT_AABB = class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)10.0, (double)1.0);
    private static final class_265 SOUTH_SHORT_AABB = class_2248.method_9541((double)0.0, (double)0.0, (double)15.0, (double)16.0, (double)10.0, (double)16.0);
    private final Map<class_2680, class_265> shapesCache;

    public MapCodec<MossyCarpetBlock> method_53969() {
        return CODEC;
    }

    public MossyCarpetBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)((class_2680)((class_2680)((class_2680)this.method_9595().method_11664()).method_11657((class_2769)BASE, (Comparable)Boolean.valueOf(true))).method_11657(NORTH, (Comparable)class_4778.field_22178)).method_11657(EAST, (Comparable)class_4778.field_22178)).method_11657(SOUTH, (Comparable)class_4778.field_22178)).method_11657(WEST, (Comparable)class_4778.field_22178));
        this.shapesCache = ImmutableMap.copyOf(this.method_9595().method_11662().stream().collect(Collectors.toMap(Function.identity(), MossyCarpetBlock::calculateShape)));
    }

    public class_265 method_9571(class_2680 state, class_1922 level, class_2338 pos) {
        return class_259.method_1073();
    }

    private static class_265 calculateShape(class_2680 state) {
        class_265 shape = class_259.method_1073();
        if (((Boolean)state.method_11654((class_2769)BASE)).booleanValue()) {
            shape = DOWN_AABB;
        }
        shape = switch ((class_4778)state.method_11654(NORTH)) {
            default -> throw new MatchException(null, null);
            case class_4778.field_22178 -> shape;
            case class_4778.field_22179 -> class_259.method_1084((class_265)shape, (class_265)NORTH_SHORT_AABB);
            case class_4778.field_22180 -> class_259.method_1084((class_265)shape, (class_265)NORTH_AABB);
        };
        shape = switch ((class_4778)state.method_11654(SOUTH)) {
            default -> throw new MatchException(null, null);
            case class_4778.field_22178 -> shape;
            case class_4778.field_22179 -> class_259.method_1084((class_265)shape, (class_265)SOUTH_SHORT_AABB);
            case class_4778.field_22180 -> class_259.method_1084((class_265)shape, (class_265)SOUTH_AABB);
        };
        shape = switch ((class_4778)state.method_11654(EAST)) {
            default -> throw new MatchException(null, null);
            case class_4778.field_22178 -> shape;
            case class_4778.field_22179 -> class_259.method_1084((class_265)shape, (class_265)EAST_SHORT_AABB);
            case class_4778.field_22180 -> class_259.method_1084((class_265)shape, (class_265)EAST_AABB);
        };
        shape = switch ((class_4778)state.method_11654(WEST)) {
            default -> throw new MatchException(null, null);
            case class_4778.field_22178 -> shape;
            case class_4778.field_22179 -> class_259.method_1084((class_265)shape, (class_265)WEST_SHORT_AABB);
            case class_4778.field_22180 -> class_259.method_1084((class_265)shape, (class_265)WEST_AABB);
        };
        return shape.method_1110() ? class_259.method_1077() : shape;
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return this.shapesCache.get(state);
    }

    public class_265 method_9549(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return (Boolean)state.method_11654((class_2769)BASE) != false ? DOWN_AABB : class_259.method_1073();
    }

    public boolean method_9579(class_2680 state, class_1922 level, class_2338 pos) {
        return true;
    }

    public boolean method_9558(class_2680 state, class_4538 level, class_2338 pos) {
        class_2680 floorState = level.method_8320(pos.method_10074());
        return ((Boolean)state.method_11654((class_2769)BASE)).booleanValue() ? !floorState.method_26215() : floorState.method_27852((class_2248)this) && (Boolean)floorState.method_11654((class_2769)BASE) != false;
    }

    private static boolean hasFaces(class_2680 state) {
        if (((Boolean)state.method_11654((class_2769)BASE)).booleanValue()) {
            return true;
        }
        return PROPERTY_BY_DIRECTION.values().stream().anyMatch(property -> state.method_11654((class_2769)property) != class_4778.field_22178);
    }

    private static boolean canSupportAtFace(class_1922 level, class_2338 pos, class_2350 direction) {
        class_2338 adjacent = pos.method_10093(direction);
        class_2680 adjacentState = level.method_8320(adjacent);
        return direction != class_2350.field_11036 && class_5778.method_33358((class_1922)level, (class_2350)direction, (class_2338)adjacent, (class_2680)adjacentState);
    }

    private static class_2680 getUpdatedState(class_2680 state, class_1922 level, class_2338 pos, boolean flag) {
        class_2680 aboveState = null;
        class_2680 belowState = null;
        flag |= ((Boolean)state.method_11654((class_2769)BASE)).booleanValue();
        for (class_2350 direction : class_2350.class_2353.field_11062) {
            class_4778 wallSide;
            class_2754<class_4778> property = MossyCarpetBlock.getPropertyForFace(direction);
            class_4778 class_47782 = MossyCarpetBlock.canSupportAtFace(level, pos, direction) ? (flag ? class_4778.field_22179 : (class_4778)state.method_11654(property)) : (wallSide = class_4778.field_22178);
            if (wallSide == class_4778.field_22179) {
                if (aboveState == null) {
                    aboveState = level.method_8320(pos.method_10084());
                }
                if (aboveState.method_27852(ModBlocks.PALE_MOSS_CARPET.get()) && aboveState.method_11654(property) != class_4778.field_22178 && !((Boolean)aboveState.method_11654((class_2769)BASE)).booleanValue()) {
                    wallSide = class_4778.field_22180;
                }
                if (!((Boolean)state.method_11654((class_2769)BASE)).booleanValue()) {
                    if (belowState == null) {
                        belowState = level.method_8320(pos.method_10074());
                    }
                    if (belowState.method_27852(ModBlocks.PALE_MOSS_CARPET.get()) && belowState.method_11654(property) == class_4778.field_22178) {
                        wallSide = class_4778.field_22178;
                    }
                }
            }
            state = (class_2680)state.method_11657(property, (Comparable)wallSide);
        }
        return state;
    }

    public static void placeAt(class_1936 level, class_2338 pos, class_5819 random, int flag) {
        class_2680 base = ModBlocks.PALE_MOSS_CARPET.get().method_9564();
        class_2680 updatedState = MossyCarpetBlock.getUpdatedState(base, (class_1922)level, pos, true);
        level.method_8652(pos, updatedState, flag);
        class_2680 topperState = MossyCarpetBlock.createTopperWithSideChance((class_1922)level, pos, () -> ((class_5819)random).method_43056());
        if (!topperState.method_26215()) {
            level.method_8652(pos.method_10084(), topperState, flag);
            class_2680 reUpdatedState = MossyCarpetBlock.getUpdatedState(updatedState, (class_1922)level, pos, true);
            level.method_8652(pos, reUpdatedState, flag);
        }
    }

    public void method_9567(class_1937 level, class_2338 pos, class_2680 state, @Nullable class_1309 placer, class_1799 stack) {
        if (!level.field_9236) {
            class_5819 random = level.method_8409();
            class_2680 topperState = MossyCarpetBlock.createTopperWithSideChance((class_1922)level, pos, () -> ((class_5819)random).method_43056());
            if (!topperState.method_26215()) {
                level.method_8652(pos.method_10084(), topperState, 3);
            }
        }
    }

    private static class_2680 createTopperWithSideChance(class_1922 level, class_2338 pos, BooleanSupplier flag) {
        class_2338 above = pos.method_10084();
        class_2680 aboveState = level.method_8320(above);
        boolean isCarpet = aboveState.method_27852(ModBlocks.PALE_MOSS_CARPET.get());
        if (!(isCarpet && ((Boolean)aboveState.method_11654((class_2769)BASE)).booleanValue() || !isCarpet && !aboveState.method_45474())) {
            class_2680 baselessCarpet = (class_2680)ModBlocks.PALE_MOSS_CARPET.get().method_9564().method_11657((class_2769)BASE, (Comparable)Boolean.valueOf(false));
            class_2680 updatedState = MossyCarpetBlock.getUpdatedState(baselessCarpet, level, pos.method_10084(), true);
            for (class_2350 direction : class_2350.class_2353.field_11062) {
                class_2754<class_4778> property = MossyCarpetBlock.getPropertyForFace(direction);
                if (updatedState.method_11654(property) == class_4778.field_22178 || flag.getAsBoolean()) continue;
                updatedState = (class_2680)updatedState.method_11657(property, (Comparable)class_4778.field_22178);
            }
            return MossyCarpetBlock.hasFaces(updatedState) && updatedState != aboveState ? updatedState : class_2246.field_10124.method_9564();
        }
        return class_2246.field_10124.method_9564();
    }

    @Nullable
    public class_2680 method_9605(class_1750 context) {
        return MossyCarpetBlock.getUpdatedState(this.method_9564(), (class_1922)context.method_8045(), context.method_8037(), true);
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        if (!state.method_26184((class_4538)level, pos)) {
            return class_2246.field_10124.method_9564();
        }
        class_2680 updatedState = MossyCarpetBlock.getUpdatedState(state, (class_1922)level, pos, false);
        return !MossyCarpetBlock.hasFaces(updatedState) ? class_2246.field_10124.method_9564() : updatedState;
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{BASE, NORTH, EAST, SOUTH, WEST});
    }

    public class_2680 method_9598(class_2680 state, class_2470 rotation) {
        return switch (rotation) {
            case class_2470.field_11464 -> (class_2680)((class_2680)((class_2680)((class_2680)state.method_11657(NORTH, (Comparable)((class_4778)state.method_11654(SOUTH)))).method_11657(EAST, (Comparable)((class_4778)state.method_11654(WEST)))).method_11657(SOUTH, (Comparable)((class_4778)state.method_11654(NORTH)))).method_11657(WEST, (Comparable)((class_4778)state.method_11654(EAST)));
            case class_2470.field_11465 -> (class_2680)((class_2680)((class_2680)((class_2680)state.method_11657(NORTH, (Comparable)((class_4778)state.method_11654(EAST)))).method_11657(EAST, (Comparable)((class_4778)state.method_11654(SOUTH)))).method_11657(SOUTH, (Comparable)((class_4778)state.method_11654(WEST)))).method_11657(WEST, (Comparable)((class_4778)state.method_11654(NORTH)));
            case class_2470.field_11463 -> (class_2680)((class_2680)((class_2680)((class_2680)state.method_11657(NORTH, (Comparable)((class_4778)state.method_11654(WEST)))).method_11657(EAST, (Comparable)((class_4778)state.method_11654(NORTH)))).method_11657(SOUTH, (Comparable)((class_4778)state.method_11654(EAST)))).method_11657(WEST, (Comparable)((class_4778)state.method_11654(SOUTH)));
            default -> state;
        };
    }

    public class_2680 method_9569(class_2680 state, class_2415 mirror) {
        return switch (mirror) {
            case class_2415.field_11300 -> (class_2680)((class_2680)state.method_11657(NORTH, (Comparable)((class_4778)state.method_11654(SOUTH)))).method_11657(SOUTH, (Comparable)((class_4778)state.method_11654(NORTH)));
            case class_2415.field_11301 -> (class_2680)((class_2680)state.method_11657(EAST, (Comparable)((class_4778)state.method_11654(WEST)))).method_11657(WEST, (Comparable)((class_4778)state.method_11654(EAST)));
            default -> super.method_9569(state, mirror);
        };
    }

    @Nullable
    public static class_2754<class_4778> getPropertyForFace(class_2350 direction) {
        return PROPERTY_BY_DIRECTION.get(direction);
    }

    public boolean method_9651(class_4538 level, class_2338 pos, class_2680 state) {
        return (Boolean)state.method_11654((class_2769)BASE) != false && !MossyCarpetBlock.createTopperWithSideChance((class_1922)level, pos, () -> true).method_26215();
    }

    public boolean method_9650(class_1937 level, class_5819 random, class_2338 pos, class_2680 state) {
        return true;
    }

    public void method_9652(class_3218 level, class_5819 random, class_2338 pos, class_2680 state) {
        class_2680 topperState = MossyCarpetBlock.createTopperWithSideChance((class_1922)level, pos, () -> true);
        if (!topperState.method_26215()) {
            level.method_8652(pos.method_10084(), topperState, 3);
        }
    }
}

