/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2315
 *  net.minecraft.class_2338
 *  net.minecraft.class_2342
 *  net.minecraft.class_2347
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3486
 */
package backported.updates.content.common.level.dispenser;

import backported.updates.content.common.level.boat.PaleOakBoat;
import backported.updates.content.common.level.boat.PaleOakBoatBehavior;
import backported.updates.content.common.level.boat.PaleOakChestBoat;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2315;
import net.minecraft.class_2338;
import net.minecraft.class_2342;
import net.minecraft.class_2347;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3486;

public class PaleOakBoatDispenseBehavior
extends class_2347 {
    private final class_2347 defaultDispenseItemBehavior = new class_2347();
    private final boolean isChestBoat;

    public PaleOakBoatDispenseBehavior() {
        this(false);
    }

    public PaleOakBoatDispenseBehavior(boolean isChestBoat) {
        this.isChestBoat = isChestBoat;
    }

    public class_1799 method_10135(class_2342 source, class_1799 stack) {
        class_2350 direction = (class_2350)source.comp_1969().method_11654((class_2769)class_2315.field_10918);
        class_3218 level = source.comp_1967();
        class_243 center = source.method_53906();
        double width = 0.5625 + (double)class_1299.field_6121.method_17685() / 2.0;
        double x = center.method_10216() + (double)direction.method_10148() * width;
        double y = center.method_10214() + (double)((float)direction.method_10164() * 1.125f);
        double z = center.method_10215() + (double)direction.method_10165() * width;
        class_2338 blockpos = source.comp_1968().method_10093(direction);
        double offset = 0.0;
        if (level.method_8316(blockpos).method_15767(class_3486.field_15517)) {
            offset = 1.0;
        } else if (!level.method_8320(blockpos).method_26215() || !level.method_8316(blockpos.method_10074()).method_15767(class_3486.field_15517)) {
            return this.defaultDispenseItemBehavior.dispense(source, stack);
        }
        PaleOakBoatBehavior boat = this.isChestBoat ? new PaleOakChestBoat((class_1937)level, x, y, z) : new PaleOakBoat((class_1937)level, x, y, z);
        boat.method_36456(direction.method_10144());
        boat.method_5814(x, y + offset, z);
        level.method_8649((class_1297)boat);
        stack.method_7934(1);
        return stack;
    }

    protected void method_10136(class_2342 source) {
        source.comp_1967().method_20290(1000, source.comp_1968(), 0);
    }
}

