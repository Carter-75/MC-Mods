/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2337
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3218
 *  net.minecraft.class_3610
 *  net.minecraft.class_3611
 *  net.minecraft.class_3612
 *  net.minecraft.class_3737
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_5945
 *  net.minecraft.class_6019
 */
package backported.updates.copper.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2337;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_2902;
import net.minecraft.class_3218;
import net.minecraft.class_3610;
import net.minecraft.class_3611;
import net.minecraft.class_3612;
import net.minecraft.class_3737;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_5945;
import net.minecraft.class_6019;

public class CopperLightningRodBlock
extends class_2337
implements class_3737 {
    public static final MapCodec<CopperLightningRodBlock> CODEC = CopperLightningRodBlock.method_54094(CopperLightningRodBlock::new);
    public static final class_2746 WATERLOGGED = class_2741.field_12508;
    public static final class_2746 POWERED = class_2741.field_12484;
    private static final int ACTIVATION_TICKS = 8;
    public static final int RANGE = 128;
    private static final int SPARK_CYCLE = 200;

    public MapCodec<? extends CopperLightningRodBlock> method_53969() {
        return CODEC;
    }

    public CopperLightningRodBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)((class_2680)this.field_10647.method_11664()).method_11657((class_2769)field_10927, (Comparable)class_2350.field_11036)).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(false))).method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(false)));
    }

    public class_2680 method_9605(class_1750 context) {
        class_3610 fluidstate = context.method_8045().method_8316(context.method_8037());
        boolean flag = fluidstate.method_15772() == class_3612.field_15910;
        return (class_2680)((class_2680)this.method_9564().method_11657((class_2769)field_10927, (Comparable)context.method_8038())).method_11657((class_2769)WATERLOGGED, (Comparable)Boolean.valueOf(flag));
    }

    protected class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        if (((Boolean)state.method_11654((class_2769)WATERLOGGED)).booleanValue()) {
            level.method_39281(pos, (class_3611)class_3612.field_15910, class_3612.field_15910.method_15789((class_4538)level));
        }
        return super.method_9559(state, direction, neighborState, level, pos, neighborPos);
    }

    protected class_3610 method_9545(class_2680 state) {
        return (Boolean)state.method_11654((class_2769)WATERLOGGED) != false ? class_3612.field_15910.method_15729(false) : super.method_9545(state);
    }

    protected int method_9524(class_2680 state, class_1922 level, class_2338 pos, class_2350 direction) {
        return (Boolean)state.method_11654((class_2769)POWERED) != false ? 15 : 0;
    }

    protected int method_9603(class_2680 state, class_1922 level, class_2338 pos, class_2350 direction) {
        return (Boolean)state.method_11654((class_2769)POWERED) != false && state.method_11654((class_2769)field_10927) == direction ? 15 : 0;
    }

    public void onLightningStrike(class_2680 state, class_1937 level, class_2338 pos) {
        level.method_8652(pos, (class_2680)state.method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(true)), 3);
        this.updateNeighbours(state, level, pos);
        level.method_39279(pos, (class_2248)this, 8);
        level.method_20290(3002, pos, ((class_2350)state.method_11654((class_2769)field_10927)).method_10166().ordinal());
    }

    private void updateNeighbours(class_2680 state, class_1937 level, class_2338 pos) {
        level.method_8452(pos.method_10093(((class_2350)state.method_11654((class_2769)field_10927)).method_10153()), (class_2248)this);
    }

    protected void method_9588(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        level.method_8652(pos, (class_2680)state.method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(false)), 3);
        this.updateNeighbours(state, (class_1937)level, pos);
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        if (level.method_8546() && (long)level.field_9229.method_43048(200) <= level.method_8510() % 200L && pos.method_10264() == level.method_8624(class_2902.class_2903.field_13202, pos.method_10263(), pos.method_10260()) - 1) {
            class_5945.method_34683((class_2350.class_2351)((class_2350)state.method_11654((class_2769)field_10927)).method_10166(), (class_1937)level, (class_2338)pos, (double)0.125, (class_2394)class_2398.field_29644, (class_6019)class_6019.method_35017((int)1, (int)2));
        }
    }

    protected void method_9536(class_2680 state, class_1937 level, class_2338 pos, class_2680 newState, boolean movedByPiston) {
        if (!state.method_27852(newState.method_26204())) {
            if (((Boolean)state.method_11654((class_2769)POWERED)).booleanValue()) {
                this.updateNeighbours(state, level, pos);
            }
            super.method_9536(state, level, pos, newState, movedByPiston);
        }
    }

    protected void method_9615(class_2680 state, class_1937 level, class_2338 pos, class_2680 oldState, boolean movedByPiston) {
        if (!state.method_27852(oldState.method_26204()) && ((Boolean)state.method_11654((class_2769)POWERED)).booleanValue() && !level.method_8397().method_8674(pos, (Object)this)) {
            level.method_8652(pos, (class_2680)state.method_11657((class_2769)POWERED, (Comparable)Boolean.valueOf(false)), 18);
        }
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{field_10927, POWERED, WATERLOGGED});
    }

    protected boolean method_9506(class_2680 state) {
        return true;
    }
}

