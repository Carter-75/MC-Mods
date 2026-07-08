/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10
 *  net.minecraft.class_1268
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3726
 *  net.minecraft.class_3737
 *  net.minecraft.class_3749
 *  net.minecraft.class_3965
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_9062
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.block;

import backported.updates.copper.registry.ModBlocks;
import java.util.Optional;
import net.minecraft.class_10;
import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3726;
import net.minecraft.class_3737;
import net.minecraft.class_3749;
import net.minecraft.class_3965;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5955;
import net.minecraft.class_9062;
import org.jetbrains.annotations.Nullable;

public class CopperLanternBlock
extends class_3749
implements class_3737 {
    public static final class_2746 HANGING = class_2741.field_16561;
    public static final class_2746 WATERLOGGED = class_2741.field_12508;
    protected static final class_265 AABB = class_259.method_1084((class_265)class_2248.method_9541((double)5.0, (double)0.0, (double)5.0, (double)11.0, (double)7.0, (double)11.0), (class_265)class_2248.method_9541((double)6.0, (double)7.0, (double)6.0, (double)10.0, (double)9.0, (double)10.0));
    protected static final class_265 HANGING_AABB = class_259.method_1084((class_265)class_2248.method_9541((double)5.0, (double)1.0, (double)5.0, (double)11.0, (double)8.0, (double)11.0), (class_265)class_2248.method_9541((double)6.0, (double)8.0, (double)6.0, (double)10.0, (double)10.0, (double)10.0));
    private final class_5955.class_5811 weatheringState;

    public CopperLanternBlock(class_5955.class_5811 weatheringState, class_4970.class_2251 properties) {
        super(properties);
        this.weatheringState = weatheringState;
        this.method_9590((class_2680)((class_2680)((class_2680)this.field_10647.method_11664()).method_11657((class_2769)HANGING, (Comparable)Boolean.valueOf(false))).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    public class_5955.class_5811 getWeatheringState() {
        return this.weatheringState;
    }

    public static Optional<class_2248> getUnwaxedBlock(class_2248 block) {
        if (block == ModBlocks.WAXED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.EXPOSED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.WEATHERED_COPPER_LANTERN.get());
        }
        if (block == ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get()) {
            return Optional.of((class_2248)ModBlocks.OXIDIZED_COPPER_LANTERN.get());
        }
        return Optional.empty();
    }

    protected class_9062 method_55765(class_1799 stack, class_2680 state, class_1937 level, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        Optional<class_2248> unwaxedBlock;
        if (stack.method_31573(class_3489.field_42612) && (unwaxedBlock = CopperLanternBlock.getUnwaxedBlock(state.method_26204())).isPresent()) {
            level.method_8396(player, pos, class_3417.field_29542, class_3419.field_15245, 1.0f, 1.0f);
            level.method_8444(player, 3004, pos, 0);
            if (!level.field_9236) {
                class_2680 newState = unwaxedBlock.get().method_34725(state);
                level.method_8501(pos, newState);
                stack.method_7970(1, (class_1309)player, hand == class_1268.field_5808 ? class_1304.field_6173 : class_1304.field_6171);
            }
            return class_9062.method_55644((boolean)level.field_9236);
        }
        return class_9062.field_47731;
    }

    @Nullable
    public class_2680 method_9605(class_1750 context) {
        class_3610 fluidstate = context.method_8045().method_8316(context.method_8037());
        for (class_2350 direction : context.method_7718()) {
            class_2680 blockstate;
            if (direction.method_10166() != class_2350.class_2351.field_11052 || !(blockstate = (class_2680)this.method_9564().method_11657((class_2769)HANGING, (Comparable)Boolean.valueOf(direction == class_2350.field_11036))).method_26184((class_4538)context.method_8045(), context.method_8037())) continue;
            return (class_2680)blockstate.method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(fluidstate.method_15772() == class_3612.field_15910));
        }
        return null;
    }

    protected class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return (Boolean)state.method_11654((class_2769)HANGING) != false ? HANGING_AABB : AABB;
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{HANGING, WATERLOGGED});
    }

    protected boolean method_9558(class_2680 state, class_4538 level, class_2338 pos) {
        class_2350 direction = CopperLanternBlock.getConnectedDirection(state).method_10153();
        return class_2248.method_20044((class_4538)level, (class_2338)pos.method_10093(direction), (class_2350)direction.method_10153());
    }

    protected static class_2350 getConnectedDirection(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)HANGING) != false ? class_2350.field_11033 : class_2350.field_11036;
    }

    protected class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            level.method_39281(pos, (class_3611)class_3612.field_15910, class_3612.field_15910.method_15789((class_4538)level));
        }
        return CopperLanternBlock.getConnectedDirection(state).method_10153() == direction && !state.method_26184((class_4538)level, pos) ? class_2246.field_10124.method_9564() : super.method_9559(state, direction, neighborState, level, pos, neighborPos);
    }

    protected class_3610 method_9545(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
    }

    protected boolean method_9516(class_2680 state, class_10 type) {
        return false;
    }
}

