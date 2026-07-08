/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1750
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2415
 *  net.minecraft.class_2453
 *  net.minecraft.class_2464
 *  net.minecraft.class_2470
 *  net.minecraft.class_2586
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5558
 *  org.jetbrains.annotations.Nullable
 */
package ace.actually.pirates.blocks;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.DispenserCannonBlock;
import ace.actually.pirates.blocks.entity.CannonPrimingBlockEntity;
import net.minecraft.class_1750;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_2453;
import net.minecraft.class_2464;
import net.minecraft.class_2470;
import net.minecraft.class_2586;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4970;
import net.minecraft.class_5558;
import org.jetbrains.annotations.Nullable;

public class CannonPrimingBlock
extends class_2237 {
    public static final class_2746 DISARMED = class_2741.field_12553;

    public CannonPrimingBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    public class_2464 method_9604(class_2680 state) {
        return class_2464.field_11458;
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{class_2453.field_11413}).method_11667(new class_2769[]{class_2741.field_12525}).method_11667(new class_2769[]{DISARMED});
    }

    @Nullable
    public class_2680 method_9605(class_1750 ctx) {
        class_2350 facing;
        class_1937 world;
        class_2338 pos = ctx.method_8037();
        if (world.method_8320(pos.method_10081((facing = (world = ctx.method_8045()).method_8320(pos.method_10095()).method_27852(class_2246.field_10200) ? class_2350.field_11043 : (world.method_8320(pos.method_10078()).method_27852(class_2246.field_10200) ? class_2350.field_11034 : (world.method_8320(pos.method_10072()).method_27852(class_2246.field_10200) ? class_2350.field_11035 : (world.method_8320(pos.method_10067()).method_27852(class_2246.field_10200) ? class_2350.field_11039 : (world.method_8320(pos.method_10084()).method_27852(class_2246.field_10200) ? class_2350.field_11036 : (world.method_8320(pos.method_10074()).method_27852(class_2246.field_10200) ? class_2350.field_11033 : ctx.method_7715())))))).method_10163())).method_27852(class_2246.field_10200) && world.method_8320(pos.method_10081(facing.method_10163())).method_11654((class_2769)class_2741.field_12525) == facing) {
            world.method_8652(pos.method_10081(facing.method_10163()), (class_2680)((DispenserCannonBlock)((Object)Pirates.DISPENSER_CANNON_BLOCK.get())).method_9564().method_11657((class_2769)class_2741.field_12525, (Comparable)facing), 3);
        }
        return (class_2680)((class_2680)((class_2680)this.method_9564().method_11657((class_2769)class_2453.field_11413, (Comparable)Boolean.valueOf(false))).method_11657((class_2769)class_2741.field_12525, (Comparable)facing)).method_11657((class_2769)DISARMED, (Comparable)Boolean.valueOf(true));
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new CannonPrimingBlockEntity(pos, state);
    }

    @Nullable
    public <T extends class_2586> class_5558<T> method_31645(class_1937 world, class_2680 state, class_2591<T> type) {
        return CannonPrimingBlock.method_31618(type, (class_2591)((class_2591)Pirates.CANNON_PRIMING_BLOCK_ENTITY.get()), (world1, pos, state1, be) -> be.tick(world1, pos, state1, (CannonPrimingBlockEntity)be));
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 world, class_2338 pos, class_2338 neighborPos) {
        if (world.method_8320(pos.method_10081(((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10163())).method_27852(class_2246.field_10200) && world.method_8320(pos.method_10081(((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10163())).method_11654((class_2769)class_2741.field_12525) == state.method_11654((class_2769)class_2741.field_12525)) {
            world.method_8652(pos.method_10081(((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10163()), (class_2680)((DispenserCannonBlock)((Object)Pirates.DISPENSER_CANNON_BLOCK.get())).method_9564().method_11657((class_2769)class_2741.field_12525, (Comparable)((class_2350)state.method_11654((class_2769)class_2741.field_12525))), 3);
        }
        if (world.method_49803(pos) && !world.method_8608()) {
            ((CannonPrimingBlockEntity)world.method_8321(pos)).fire((class_1937)world, pos, state, 19);
        }
        return super.method_9559(state, direction, neighborState, world, pos, neighborPos);
    }

    public class_2680 method_9598(class_2680 state, class_2470 rotation) {
        return (class_2680)state.method_11657((class_2769)class_2741.field_12525, (Comparable)rotation.method_10503((class_2350)state.method_11654((class_2769)class_2741.field_12525)));
    }

    public class_2680 method_9569(class_2680 state, class_2415 mirror) {
        return state.method_26186(mirror.method_10345((class_2350)state.method_11654((class_2769)class_2741.field_12525)));
    }

    public static void disarm(class_1937 world, class_2338 pos) {
        if (world.method_8608()) {
            return;
        }
        class_2680 blockState = world.method_8320(pos);
        if (!((Boolean)blockState.method_11654((class_2769)DISARMED)).booleanValue()) {
            world.method_8501(pos, (class_2680)blockState.method_11657((class_2769)DISARMED, (Comparable)Boolean.valueOf(true)));
            world.method_8396(null, pos, class_3417.field_19199, class_3419.field_15245, 0.5f, 1.5f);
        }
    }
}

