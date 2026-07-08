/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1271
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1799
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2487
 *  net.minecraft.class_2495
 *  net.minecraft.class_2520
 *  net.minecraft.class_2561
 *  net.minecraft.class_3218
 */
package ace.actually.pirates.items;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.entity.MotionInvokingBlockEntity;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1271;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2495;
import net.minecraft.class_2520;
import net.minecraft.class_2561;
import net.minecraft.class_3218;

public class ShipPather
extends class_1792 {
    public ShipPather(class_1792.class_1793 settings) {
        super(settings);
    }

    public class_1269 method_7884(class_1838 context) {
        class_1937 class_19372 = context.method_8045();
        if (class_19372 instanceof class_3218) {
            class_3218 world = (class_3218)class_19372;
            if (context.method_20287() == class_1268.field_5808) {
                if (world.method_8320(context.method_8037()).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get())) {
                    compound = new class_2487();
                    class_2338 v = context.method_8037();
                    compound.method_10539("mib", new int[]{v.method_10263(), v.method_10264(), v.method_10260()});
                    context.method_8036().method_5998(class_1268.field_5808).method_7980(compound);
                } else if (context.method_8041().method_7985() && context.method_8041().method_7969().method_10545("mib")) {
                    compound = context.method_8041().method_7969();
                    int[] v = compound.method_10561("mib");
                    MotionInvokingBlockEntity be = (MotionInvokingBlockEntity)world.method_8321(new class_2338(v[0], v[1], v[2]));
                    class_2338 pos = context.method_8037();
                    be.addPathNode(new class_2338(pos.method_10263(), be.method_11016().method_10264(), pos.method_10260()));
                    context.method_8036().method_43496((class_2561)class_2561.method_43471((String)"text.pirates.pather.add"));
                } else {
                    context.method_8036().method_43496((class_2561)class_2561.method_43471((String)"text.pirates.need_mib"));
                }
            }
        }
        return super.method_7884(context);
    }

    public class_1271<class_1799> method_7836(class_1937 world, class_1657 user, class_1268 hand) {
        if (class_1268.field_5808 == hand && !world.field_9236 && user.method_6047().method_7985() && user.method_6047().method_7969().method_10545("mib")) {
            class_2487 compound = user.method_6047().method_7969();
            int[] v = compound.method_10561("mib");
            MotionInvokingBlockEntity be = (MotionInvokingBlockEntity)world.method_8321(new class_2338(v[0], v[1], v[2]));
            int[] t = be.getTarget();
            user.method_43496((class_2561)class_2561.method_43471((String)"text.pirates.target").method_10852(class_2561.method_30163((String)(" " + t[0] + " " + t[1] + " " + t[2]))));
            user.method_43496((class_2561)class_2561.method_43471((String)"text.pirates.paths"));
            for (class_2520 element : be.getPath()) {
                if (element.method_10711() != 11) continue;
                int[] ints = ((class_2495)element).method_10588();
                user.method_43496(class_2561.method_30163((String)(ints[0] + " " + ints[1] + " " + ints[2])));
            }
        }
        return super.method_7836(world, user, hand);
    }
}

