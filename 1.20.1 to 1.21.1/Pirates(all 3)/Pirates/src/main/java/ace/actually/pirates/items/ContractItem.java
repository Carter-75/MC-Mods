/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1792
 *  net.minecraft.class_1792$class_1793
 *  net.minecraft.class_1838
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 */
package ace.actually.pirates.items;

import ace.actually.pirates.entities.friendly_pirate.FriendlyPirateEntity;
import ace.actually.pirates.util.DisarmUtils;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1792;
import net.minecraft.class_1838;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;

public class ContractItem
extends class_1792 {
    class_2248 jobsite;
    String jobname;

    public ContractItem(class_2248 jobsite, String jobname) {
        super(new class_1792.class_1793());
        this.jobname = jobname;
        this.jobsite = jobsite;
    }

    public class_1269 method_7884(class_1838 context) {
        class_1937 class_19372 = context.method_8045();
        if (class_19372 instanceof class_3218) {
            class_3218 world = (class_3218)class_19372;
            if (context.method_8045().method_8320(context.method_8037()).method_27852(this.jobsite)) {
                class_2338 pos = context.method_8037();
                FriendlyPirateEntity fpe = new FriendlyPirateEntity((class_1937)world, pos);
                fpe.setPirateJob(this.jobname);
                class_2680 state = world.method_8320(pos);
                DisarmUtils.rearm((class_1937)world, pos);
                class_2338 spos = state.method_28498((class_2769)class_2741.field_12525) ? pos.method_10093(((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10153()) : pos.method_10084();
                world.method_8649((class_1297)fpe);
                fpe.method_20620(spos.method_10263(), spos.method_10264(), spos.method_10260());
                fpe.genCustomName((class_1937)world);
                context.method_8041().method_7934(1);
            }
        }
        return super.method_7884(context);
    }
}

