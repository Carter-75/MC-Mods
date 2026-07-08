/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1778
 *  net.minecraft.class_1786
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2415
 *  net.minecraft.class_243
 *  net.minecraft.class_247
 *  net.minecraft.class_2470
 *  net.minecraft.class_2561
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2753
 *  net.minecraft.class_2769
 *  net.minecraft.class_3417
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3726
 *  net.minecraft.class_3965
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5540
 *  org.jetbrains.annotations.Nullable
 */
package tech.alexnijjar.golemoverhaul.common.blocks;

import java.util.List;
import java.util.stream.Stream;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1778;
import net.minecraft.class_1786;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_243;
import net.minecraft.class_247;
import net.minecraft.class_2470;
import net.minecraft.class_2561;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2753;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5540;
import org.jetbrains.annotations.Nullable;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantComponents;
import tech.alexnijjar.golemoverhaul.common.entities.golems.CandleGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class CandleGolemBlock
extends class_5540 {
    public static final class_2746 WATERLOGGED = class_2741.field_12508;
    public static final class_2753 FACING = class_2741.field_12481;
    public static final class_243 OFFSET = new class_243(0.5, 0.5625, 0.5);
    public static final class_265 SHAPE_NORTH = Stream.of(class_2248.method_9541((double)5.0, (double)5.0, (double)5.0, (double)11.0, (double)8.0, (double)11.0), class_2248.method_9541((double)5.5, (double)0.0, (double)5.5, (double)10.5, (double)5.0, (double)10.5), class_2248.method_9541((double)10.5, (double)0.0, (double)6.5, (double)11.5, (double)3.0, (double)9.5), class_2248.method_9541((double)4.5, (double)0.0, (double)6.5, (double)5.5, (double)3.0, (double)9.5)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();
    public static final class_265 SHAPE_EAST = Stream.of(class_2248.method_9541((double)5.0, (double)5.0, (double)5.0, (double)11.0, (double)8.0, (double)11.0), class_2248.method_9541((double)5.5, (double)0.0, (double)5.5, (double)10.5, (double)5.0, (double)10.5), class_2248.method_9541((double)6.5, (double)0.0, (double)10.5, (double)9.5, (double)3.0, (double)11.5), class_2248.method_9541((double)6.5, (double)0.0, (double)4.5, (double)9.5, (double)3.0, (double)5.5)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();
    public static final class_265 SHAPE_SOUTH = Stream.of(class_2248.method_9541((double)5.0, (double)5.0, (double)5.0, (double)11.0, (double)8.0, (double)11.0), class_2248.method_9541((double)5.5, (double)0.0, (double)5.5, (double)10.5, (double)5.0, (double)10.5), class_2248.method_9541((double)4.5, (double)0.0, (double)6.5, (double)5.5, (double)3.0, (double)9.5), class_2248.method_9541((double)10.5, (double)0.0, (double)6.5, (double)11.5, (double)3.0, (double)9.5)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();
    public static final class_265 SHAPE_WEST = Stream.of(class_2248.method_9541((double)5.0, (double)5.0, (double)5.0, (double)11.0, (double)8.0, (double)11.0), class_2248.method_9541((double)5.5, (double)0.0, (double)5.5, (double)10.5, (double)5.0, (double)10.5), class_2248.method_9541((double)6.5, (double)0.0, (double)4.5, (double)9.5, (double)3.0, (double)5.5), class_2248.method_9541((double)6.5, (double)0.0, (double)10.5, (double)9.5, (double)3.0, (double)11.5)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();

    public CandleGolemBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)((class_2680)this.field_10647.method_11664()).method_11657((class_2769)field_27083, (Comparable)Boolean.valueOf(false))).method_11657((class_2769)FACING, (Comparable)class_2350.field_11043)).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{FACING, field_27083, WATERLOGGED});
    }

    public void method_9612(class_2680 state, class_1937 level, class_2338 pos, class_2248 block, class_2338 fromPos, boolean isMoving) {
        if (level.method_8608()) {
            return;
        }
        if (level.method_49803(pos)) {
            this.spawnGolem(level, pos, state);
            level.method_22352(pos, false);
        }
    }

    protected Iterable<class_243> method_31613(class_2680 state) {
        return List.of(OFFSET);
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return switch ((class_2350)state.method_11654((class_2769)FACING)) {
            case class_2350.field_11034 -> SHAPE_EAST;
            case class_2350.field_11035 -> SHAPE_SOUTH;
            case class_2350.field_11039 -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
    }

    public class_1269 method_9534(class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        boolean isFlintAndSteel;
        if (level.method_8608()) {
            return class_1269.field_5812;
        }
        class_1799 stack = player.method_5998(hand);
        if (!(((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue() || ((Boolean)state.method_11654((class_2769)field_27083)).booleanValue() || stack.method_7960() || !(isFlintAndSteel = stack.method_7909() instanceof class_1786) && !(stack.method_7909() instanceof class_1778))) {
            if (!level.method_8608()) {
                level.method_8501(pos, (class_2680)state.method_11657((class_2769)field_27083, (Comparable)Boolean.valueOf(true)));
                level.method_8396(null, pos, isFlintAndSteel ? class_3417.field_15145 : class_3417.field_15013, player.method_5634(), 1.0f, level.field_9229.method_43057() * 0.4f + 0.8f);
                if (isFlintAndSteel) {
                    stack.method_7956(1, (class_1309)player, p -> p.method_20236(hand));
                }
            }
            return class_1269.method_29236((boolean)level.method_8608());
        }
        this.spawnGolem(level, pos, state);
        level.method_22352(pos, false);
        return class_1269.method_29236((boolean)level.method_8608());
    }

    private void spawnGolem(class_1937 level, class_2338 pos, class_2680 state) {
        CandleGolem golem = (CandleGolem)((class_1299)ModEntityTypes.CANDLE_GOLEM.get()).method_5883(level);
        if (golem == null) {
            return;
        }
        golem.setLit((Boolean)level.method_8320(pos).method_11654((class_2769)field_27083));
        golem.method_5808((double)pos.method_10263() + 0.5, pos.method_10264(), (double)pos.method_10260() + 0.5, ((class_2350)state.method_11654((class_2769)FACING)).method_10144(), 0.0f);
        level.method_8649((class_1297)golem);
    }

    public class_2680 method_9598(class_2680 state, class_2470 rotation) {
        return (class_2680)state.method_11657((class_2769)FACING, (Comparable)rotation.method_10503((class_2350)state.method_11654((class_2769)FACING)));
    }

    public class_2680 method_9569(class_2680 state, class_2415 mirror) {
        return state.method_26186(mirror.method_10345((class_2350)state.method_11654((class_2769)FACING)));
    }

    public class_3610 method_9545(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            level.method_39281(pos, (class_3611)class_3612.field_15910, class_3612.field_15910.method_15789((class_4538)level));
        }
        return super.method_9559(state, direction, neighborState, level, pos, neighborPos);
    }

    public class_2680 method_9605(class_1750 context) {
        class_3610 fluidState = context.method_8045().method_8316(context.method_8037());
        return (class_2680)((class_2680)this.method_9564().method_11657((class_2769)FACING, (Comparable)context.method_8042().method_10153())).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(fluidState.method_15772().equals(class_3612.field_15910)));
    }

    public void method_9568(class_1799 stack, @Nullable class_1922 level, List<class_2561> tooltip, class_1836 flag) {
        tooltip.add(ConstantComponents.CANDLE_GOLEM_TOOLTIP);
    }
}

