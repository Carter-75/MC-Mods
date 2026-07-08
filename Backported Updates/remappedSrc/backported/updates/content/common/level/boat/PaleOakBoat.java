/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1690
 *  net.minecraft.class_1792
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2604
 *  net.minecraft.class_2680
 *  net.minecraft.class_3231
 */
package backported.updates.content.common.level.boat;

import backported.updates.content.common.level.boat.PaleOakBoatBehavior;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.common.registries.ModItems;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1690;
import net.minecraft.class_1792;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2604;
import net.minecraft.class_2680;
import net.minecraft.class_3231;

public class PaleOakBoat
extends class_1690
implements PaleOakBoatBehavior {
    public PaleOakBoat(class_1299<? extends class_1690> entityType, class_1937 level) {
        super(entityType, level);
    }

    public PaleOakBoat(class_1937 level, double x, double y, double z) {
        this(ModEntities.PALE_OAK_BOAT.get(), level);
        this.method_5814(x, y, z);
        this.field_6014 = x;
        this.field_6036 = y;
        this.field_5969 = z;
    }

    public class_1792 method_7557() {
        return ModItems.PALE_OAK_BOAT.get();
    }

    protected void method_5623(double y, boolean onGround, class_2680 state, class_2338 pos) {
        this.fall(this, y, onGround);
    }

    public class_2596<class_2602> method_18002(class_3231 entity) {
        return new class_2604((class_1297)this, entity);
    }
}

