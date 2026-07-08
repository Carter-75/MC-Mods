/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1799
 *  net.minecraft.class_1923
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2464
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2746
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  org.jetbrains.annotations.Nullable
 *  org.valkyrienskies.core.api.ships.LoadedServerShip
 *  org.valkyrienskies.mod.common.ValkyrienSkiesMod
 *  org.valkyrienskies.mod.common.util.DimensionIdProvider
 */
package ace.actually.pirates.blocks;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.entity.MotionInvokingBlockEntity;
import ace.actually.pirates.util.EurekaCompat;
import ace.actually.pirates.util.SailsCompat;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1799;
import net.minecraft.class_1923;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2464;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2746;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.mod.common.ValkyrienSkiesMod;
import org.valkyrienskies.mod.common.util.DimensionIdProvider;

public class MotionInvokingBlock
extends class_2237 {
    public static final class_2746 ARMED = class_2746.method_11825((String)"armed");
    public static final class_2758 COMPAT = class_2758.method_11867((String)"compat", (int)0, (int)2);

    public MotionInvokingBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{ARMED});
        builder.method_11667(new class_2769[]{COMPAT});
    }

    @Nullable
    public class_2680 method_9605(class_1750 ctx) {
        int compatVal = 0;
        if (Pirates.loadedCompats.sails && SailsCompat.checkHelm(ctx.method_8045(), ctx.method_8037())) {
            compatVal = 1;
        }
        if (Pirates.loadedCompats.eureka && EurekaCompat.checkHelm(ctx.method_8045(), ctx.method_8037())) {
            compatVal = 2;
        }
        return (class_2680)((class_2680)super.method_9605(ctx).method_11657((class_2769)ARMED, (Comparable)Boolean.valueOf(true))).method_11657((class_2769)COMPAT, (Comparable)Integer.valueOf(compatVal));
    }

    public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        return super.method_9534(state, world, pos, player, hand, hit);
    }

    public void method_9612(class_2680 state, class_1937 world, class_2338 pos, class_2248 sourceBlock, class_2338 sourcePos, boolean notify) {
        state.method_11657((class_2769)COMPAT, (Comparable)Integer.valueOf(0));
        if (Pirates.loadedCompats.sails && SailsCompat.checkHelm(world, pos)) {
            state.method_11657((class_2769)COMPAT, (Comparable)Integer.valueOf(1));
        }
        if (Pirates.loadedCompats.eureka && EurekaCompat.checkHelm(world, pos)) {
            state.method_11657((class_2769)COMPAT, (Comparable)Integer.valueOf(2));
        }
        world.method_8652(pos, state, 10);
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new MotionInvokingBlockEntity(pos, state);
    }

    @Nullable
    public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
        return MotionInvokingBlock.method_31618(type, (class_2591)((class_2591)Pirates.MOTION_INVOKING_BLOCK_ENTITY.get()), MotionInvokingBlockEntity::tick);
    }

    public void method_9565(class_2680 state, class_3218 world, class_2338 pos, class_1799 tool, boolean dropExperience) {
        super.method_9565(state, world, pos, tool, dropExperience);
        int i = 15 + world.field_9229.method_43048(15) + world.field_9229.method_43048(15);
        this.method_9583(world, pos, i);
    }

    public void method_9536(class_2680 state, class_1937 world, class_2338 pos, class_2680 newState, boolean moved) {
        super.method_9536(state, world, pos, newState, moved);
    }

    public class_2464 method_9604(class_2680 state) {
        return class_2464.field_11458;
    }

    public static void disarm(class_1937 world, class_2338 pos) {
        if (world.method_8608()) {
            return;
        }
        world.method_8501(pos, (class_2680)((MotionInvokingBlock)((Object)Pirates.MOTION_INVOKING_BLOCK.get())).method_9564().method_11657((class_2769)ARMED, (Comparable)Boolean.valueOf(false)));
        world.method_8396(null, pos, class_3417.field_19344, class_3419.field_15245, 1.0f, 0.95f);
        MotionInvokingBlock.stopMotion(world, pos);
    }

    private static void stopMotion(class_1937 world, class_2338 pos) {
        if (!world.field_9236) {
            DimensionIdProvider provider = (DimensionIdProvider)world;
            class_1923 chunkPos = world.method_22350(pos).method_12004();
            LoadedServerShip ship = (LoadedServerShip)ValkyrienSkiesMod.getVsCore().getHooks().getCurrentShipServerWorld().getLoadedShips().getByChunkPos(chunkPos.field_9181, chunkPos.field_9180, provider.getDimensionId());
            if (ship != null) {
                MotionInvokingBlockEntity be = (MotionInvokingBlockEntity)world.method_8321(pos);
                if (((Integer)world.method_8320(pos).method_11654((class_2769)COMPAT)).equals(1)) {
                    SailsCompat.stopMotion(ship);
                } else if (((Integer)world.method_8320(pos).method_11654((class_2769)COMPAT)).equals(2)) {
                    EurekaCompat.stopMotion(ship);
                }
            }
        }
    }
}

