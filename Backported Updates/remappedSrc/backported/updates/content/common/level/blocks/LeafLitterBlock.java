/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_156
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_2248
 *  net.minecraft.class_2261
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2415
 *  net.minecraft.class_2470
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2753
 *  net.minecraft.class_2758
 *  net.minecraft.class_2769
 *  net.minecraft.class_3726
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 */
package backported.updates.content.common.level.blocks;

import com.mojang.serialization.MapCodec;
import java.util.function.BiFunction;
import net.minecraft.class_156;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_2248;
import net.minecraft.class_2261;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2415;
import net.minecraft.class_2470;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2753;
import net.minecraft.class_2758;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_4538;
import net.minecraft.class_4970;

public class LeafLitterBlock
extends class_2261 {
    public static final MapCodec<LeafLitterBlock> CODEC = LeafLitterBlock.method_54094(LeafLitterBlock::new);
    public static final int MIN_SEGMENT = 1;
    public static final int MAX_SEGMENT = 4;
    public static final class_2753 FACING = class_2741.field_12481;
    public static final class_2758 AMOUNT = class_2741.field_42835;
    private static final BiFunction<class_2350, Integer, class_265> SHAPE_BY_PROPERTIES = class_156.method_34865((direction, value) -> {
        class_265 shape = class_259.method_1073();
        class_265[] shapes = new class_265[]{class_2248.method_9541((double)8.0, (double)0.0, (double)8.0, (double)16.0, (double)3.0, (double)16.0), class_2248.method_9541((double)8.0, (double)0.0, (double)0.0, (double)16.0, (double)3.0, (double)8.0), class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)3.0, (double)8.0), class_2248.method_9541((double)0.0, (double)0.0, (double)8.0, (double)8.0, (double)3.0, (double)16.0)};
        for (int index = 0; index < value; ++index) {
            int i = Math.floorMod(index - direction.method_10161(), 4);
            shape = class_259.method_1084((class_265)shape, (class_265)shapes[i]);
        }
        return shape.method_52620();
    });

    public MapCodec<LeafLitterBlock> method_53969() {
        return CODEC;
    }

    public LeafLitterBlock(class_4970.class_2251 properties) {
        super(properties);
        this.method_9590((class_2680)((class_2680)((class_2680)this.method_9595().method_11664()).method_11657((class_2769)FACING, (Comparable)class_2350.field_11043)).method_11657((class_2769)AMOUNT, (Comparable)Integer.valueOf(1)));
    }

    public class_2680 method_9598(class_2680 state, class_2470 rotation) {
        return (class_2680)state.method_11657((class_2769)FACING, (Comparable)rotation.method_10503((class_2350)state.method_11654((class_2769)FACING)));
    }

    public class_2680 method_9569(class_2680 state, class_2415 mirror) {
        return state.method_26186(mirror.method_10345((class_2350)state.method_11654((class_2769)FACING)));
    }

    public boolean method_9616(class_2680 state, class_1750 useContext) {
        return !useContext.method_8046() && useContext.method_8041().method_31574(this.method_8389()) && (Integer)state.method_11654((class_2769)AMOUNT) < 4 || super.method_9616(state, useContext);
    }

    public boolean method_9558(class_2680 state, class_4538 level, class_2338 pos) {
        class_2338 below = pos.method_10074();
        return level.method_8320(below).method_26206((class_1922)level, below, class_2350.field_11036);
    }

    public class_265 method_9530(class_2680 state, class_1922 level, class_2338 pos, class_3726 context) {
        return SHAPE_BY_PROPERTIES.apply((class_2350)state.method_11654((class_2769)FACING), (Integer)state.method_11654((class_2769)AMOUNT));
    }

    public class_2680 method_9605(class_1750 context) {
        class_2680 state = context.method_8045().method_8320(context.method_8037());
        return state.method_27852((class_2248)this) ? (class_2680)state.method_11657((class_2769)AMOUNT, (Comparable)Integer.valueOf(Math.min(4, (Integer)state.method_11654((class_2769)AMOUNT) + 1))) : (class_2680)this.method_9564().method_11657((class_2769)FACING, (Comparable)context.method_8042().method_10153());
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{FACING, AMOUNT});
    }
}

