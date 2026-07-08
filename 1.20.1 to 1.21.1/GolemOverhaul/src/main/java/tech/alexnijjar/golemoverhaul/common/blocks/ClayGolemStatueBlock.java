/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1836
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_1944
 *  net.minecraft.class_1959
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2383
 *  net.minecraft.class_247
 *  net.minecraft.class_2561
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3726
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.Nullable
 */
package tech.alexnijjar.golemoverhaul.common.blocks;

import java.util.List;
import java.util.stream.Stream;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1836;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_1944;
import net.minecraft.class_1959;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2383;
import net.minecraft.class_247;
import net.minecraft.class_2561;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import org.jetbrains.annotations.Nullable;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantComponents;
import tech.alexnijjar.golemoverhaul.common.entities.golems.TerracottaGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class ClayGolemStatueBlock
extends class_2383 {
    public static final class_2746 WATERLOGGED = class_2741.field_12508;
    public static final class_265 SHAPE_NORTH = Stream.of(class_2248.method_9541((double)9.6, (double)0.0, (double)3.0, (double)12.6, (double)3.0, (double)6.0), class_2248.method_9541((double)3.5, (double)0.0, (double)3.0, (double)6.5, (double)3.0, (double)6.0), class_2248.method_9541((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), class_2248.method_9541((double)2.5, (double)0.0, (double)6.0, (double)4.5, (double)6.0, (double)10.0), class_2248.method_9541((double)11.5, (double)0.0, (double)6.0, (double)13.5, (double)6.0, (double)10.0), class_2248.method_9541((double)6.5, (double)2.0, (double)2.2, (double)9.5, (double)7.0, (double)4.2)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();
    public static final class_265 SHAPE_EAST = Stream.of(class_2248.method_9541((double)10.0, (double)0.0, (double)9.6, (double)13.0, (double)3.0, (double)12.6), class_2248.method_9541((double)10.0, (double)0.0, (double)3.5, (double)13.0, (double)3.0, (double)6.5), class_2248.method_9541((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), class_2248.method_9541((double)6.0, (double)0.0, (double)2.5, (double)10.0, (double)6.0, (double)4.5), class_2248.method_9541((double)6.0, (double)0.0, (double)11.5, (double)10.0, (double)6.0, (double)13.5), class_2248.method_9541((double)11.8, (double)2.0, (double)6.5, (double)13.8, (double)7.0, (double)9.5)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();
    public static final class_265 SHAPE_SOUTH = Stream.of(class_2248.method_9541((double)3.4, (double)0.0, (double)10.0, (double)6.4, (double)3.0, (double)13.0), class_2248.method_9541((double)9.5, (double)0.0, (double)10.0, (double)12.5, (double)3.0, (double)13.0), class_2248.method_9541((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), class_2248.method_9541((double)11.5, (double)0.0, (double)6.0, (double)13.5, (double)6.0, (double)10.0), class_2248.method_9541((double)2.5, (double)0.0, (double)6.0, (double)4.5, (double)6.0, (double)10.0), class_2248.method_9541((double)6.5, (double)2.0, (double)11.8, (double)9.5, (double)7.0, (double)13.8)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();
    public static final class_265 SHAPE_WEST = Stream.of(class_2248.method_9541((double)3.0, (double)0.0, (double)3.4, (double)6.0, (double)3.0, (double)6.4), class_2248.method_9541((double)3.0, (double)0.0, (double)9.5, (double)6.0, (double)3.0, (double)12.5), class_2248.method_9541((double)4.0, (double)0.0, (double)4.0, (double)12.0, (double)9.0, (double)12.0), class_2248.method_9541((double)6.0, (double)0.0, (double)11.5, (double)10.0, (double)6.0, (double)13.5), class_2248.method_9541((double)6.0, (double)0.0, (double)2.5, (double)10.0, (double)6.0, (double)4.5), class_2248.method_9541((double)2.2, (double)2.0, (double)6.5, (double)4.2, (double)7.0, (double)9.5)).reduce((v1, v2) -> class_259.method_1072((class_265)v1, (class_265)v2, (class_247)class_247.field_1366)).get();

    public ClayGolemStatueBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)this.field_10647.method_11664()).method_11657((class_2769)field_11177, (Comparable)class_2350.field_11043)).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{field_11177, WATERLOGGED});
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return switch ((class_2350)state.method_11654((class_2769)field_11177)) {
            case class_2350.field_11034 -> SHAPE_EAST;
            case class_2350.field_11035 -> SHAPE_SOUTH;
            case class_2350.field_11039 -> SHAPE_WEST;
            default -> SHAPE_NORTH;
        };
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
        return (class_2680)((class_2680)this.method_9564().method_11657((class_2769)field_11177, (Comparable)context.method_8042().method_10153())).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(fluidState.method_15772().equals(class_3612.field_15910)));
    }

    public void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if (level.method_8314(class_1944.field_9282, pos) > 11 - state.method_26193((class_1922)level, pos)) {
            this.spawnGolem((class_1937)level, pos, state);
            return;
        }
        if (((class_1959)level.method_23753(pos).comp_349()).method_8712() > 1.0f) {
            this.spawnGolem((class_1937)level, pos, state);
        }
    }

    private void spawnGolem(class_1937 level, class_2338 pos, class_2680 state) {
        TerracottaGolem golem = (TerracottaGolem)((class_1299)ModEntityTypes.TERRACOTTA_GOLEM.get()).method_5883(level);
        if (golem == null) {
            return;
        }
        golem.method_5808((double)pos.method_10263() + 0.5, pos.method_10264(), (double)pos.method_10260() + 0.5, ((class_2350)state.method_11654((class_2769)field_11177)).method_10144(), 0.0f);
        level.method_8649((class_1297)golem);
        level.method_22352(pos, false);
    }

    public void method_9568(class_1799 stack, @Nullable class_1922 level, List<class_2561> tooltip, class_1836 flag) {
        tooltip.add(ConstantComponents.CLAY_GOLEM_STATUE_TOOLTIP);
    }
}

