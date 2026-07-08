/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1922
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2256
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2350
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2746
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  net.minecraft.class_3726
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5778
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.registries.ModBlockStateProperties;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.core.data.tags.ModBlockTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_1922;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2256;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2746;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import net.minecraft.class_3726;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5778;
import net.minecraft.class_5819;

public class HangingMossBlock
extends class_2248
implements class_2256 {
    public static final MapCodec<HangingMossBlock> CODEC = HangingMossBlock.method_54094(HangingMossBlock::new);
    private static final class_265 TIP_SHAPE = class_2248.method_9541((double)1.0, (double)2.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);
    private static final class_265 BASE_SHAPE = class_2248.method_9541((double)1.0, (double)0.0, (double)1.0, (double)15.0, (double)16.0, (double)15.0);
    public static final class_2746 TIP = ModBlockStateProperties.TIP;

    public MapCodec<HangingMossBlock> method_53969() {
        return CODEC;
    }

    public HangingMossBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)this.method_9595().method_11664()).method_11657((class_2769)TIP, (Comparable)Boolean.valueOf(true)));
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return (Boolean)state.method_11654((class_2769)TIP) != false ? TIP_SHAPE : BASE_SHAPE;
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        class_2680 aboveState;
        if (random.method_43048(500) == 0 && ((aboveState = level.method_8320(pos.method_10084())).method_26164(ModBlockTags.PALE_OAK_LOGS) || aboveState.method_27852(ModBlocks.PALE_OAK_LEAVES.get()))) {
            level.method_8486((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260(), ModSoundEvents.PALE_HANGING_MOSS_IDLE.get(), class_3419.field_15245, 1.0f, 1.0f, false);
        }
    }

    public boolean method_9579(class_2680 state, class_1922 level, class_2338 pos) {
        return true;
    }

    public boolean method_9558(class_2680 state, class_4538 level, class_2338 pos) {
        return this.canStayAtPosition((class_1922)level, pos);
    }

    private boolean canStayAtPosition(class_1922 level, class_2338 pos) {
        class_2680 aboveState;
        class_2338 above = pos.method_10084();
        return class_5778.method_33358((class_1922)level, (class_2350)class_2350.field_11036, (class_2338)above, (class_2680)(aboveState = level.method_8320(above))) || aboveState.method_27852(ModBlocks.PALE_HANGING_MOSS.get());
    }

    public class_2680 method_9559(class_2680 state, class_2350 direction, class_2680 neighborState, class_1936 level, class_2338 pos, class_2338 neighborPos) {
        if (!this.canStayAtPosition((class_1922)level, pos)) {
            level.method_39279(pos, (class_2248)this, 1);
        }
        return (class_2680)state.method_11657((class_2769)TIP, (Comparable)Boolean.valueOf(!level.method_8320(pos.method_10074()).method_27852((class_2248)this)));
    }

    public void method_9588(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        if (!this.canStayAtPosition((class_1922)level, pos)) {
            level.method_22352(pos, true);
        }
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{TIP});
    }

    public boolean method_9651(class_4538 level, class_2338 pos, class_2680 state) {
        return this.canGrowInto(level.method_8320(this.getTip((class_1922)level, pos).method_10074()));
    }

    private boolean canGrowInto(class_2680 state) {
        return state.method_26215();
    }

    public class_2338 getTip(class_1922 level, class_2338 pos) {
        class_2680 state;
        class_2338.class_2339 position = pos.method_25503();
        do {
            position.method_10098(class_2350.field_11033);
        } while ((state = level.method_8320((class_2338)position)).method_27852((class_2248)this));
        return position.method_10093(class_2350.field_11036).method_10062();
    }

    public boolean method_9650(class_1937 level, class_5819 random, class_2338 pos, class_2680 state) {
        return true;
    }

    public void method_9652(class_3218 level, class_5819 random, class_2338 pos, class_2680 state) {
        class_2338 tipPos = this.getTip((class_1922)level, pos).method_10074();
        if (this.canGrowInto(level.method_8320(tipPos))) {
            level.method_8501(tipPos, (class_2680)state.method_11657((class_2769)TIP, (Comparable)Boolean.valueOf(true)));
        }
    }
}

