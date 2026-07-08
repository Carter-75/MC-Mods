/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1657
 *  net.minecraft.class_1750
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2237
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2586
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_2689$class_2690
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3726
 *  net.minecraft.class_3965
 *  net.minecraft.class_4970$class_2251
 *  org.jetbrains.annotations.Nullable
 */
package ace.actually.pirates.blocks;

import ace.actually.pirates.blocks.entity.ShipIdBlockEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1657;
import net.minecraft.class_1750;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2237;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2586;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_2689;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3726;
import net.minecraft.class_3965;
import net.minecraft.class_4970;
import org.jetbrains.annotations.Nullable;

public class ShipIdBlock
extends class_2237 {
    public ShipIdBlock(class_4970.class_2251 settings) {
        super(settings);
    }

    public class_265 method_9530(class_2680 state, class_1922 world, class_2338 pos, class_3726 context) {
        switch ((class_2350)state.method_11654((class_2769)class_2741.field_12525)) {
            case field_11034: {
                return class_2248.method_9541((double)0.0, (double)1.0, (double)1.0, (double)1.0, (double)16.0, (double)16.0);
            }
            case field_11039: {
                return class_2248.method_9541((double)15.0, (double)1.0, (double)1.0, (double)16.0, (double)16.0, (double)16.0);
            }
            case field_11043: {
                return class_2248.method_9541((double)1.0, (double)1.0, (double)15.0, (double)16.0, (double)16.0, (double)16.0);
            }
            case field_11035: {
                return class_2248.method_9541((double)1.0, (double)1.0, (double)0.0, (double)16.0, (double)16.0, (double)1.0);
            }
        }
        return class_2248.method_9541((double)0.0, (double)0.0, (double)0.0, (double)8.0, (double)8.0, (double)8.0);
    }

    public class_1269 method_9534(class_2680 state, class_1937 world, class_2338 pos, class_1657 player, class_1268 hand, class_3965 hit) {
        if (player.method_6047().method_7938()) {
            ShipIdBlockEntity be = (ShipIdBlockEntity)world.method_8321(pos);
            be.setShipName(player.method_6047().method_7964().getString());
        }
        return super.method_9534(state, world, pos, player, hand, hit);
    }

    @Nullable
    public class_2586 method_10123(class_2338 pos, class_2680 state) {
        return new ShipIdBlockEntity(pos, state);
    }

    @Nullable
    public class_2680 method_9605(class_1750 ctx) {
        return (class_2680)super.method_9605(ctx).method_11657((class_2769)class_2741.field_12525, (Comparable)ctx.method_8042().method_10153());
    }

    protected void method_9515(class_2689.class_2690<class_2248, class_2680> builder) {
        builder.method_11667(new class_2769[]{class_2741.field_12525});
    }
}

