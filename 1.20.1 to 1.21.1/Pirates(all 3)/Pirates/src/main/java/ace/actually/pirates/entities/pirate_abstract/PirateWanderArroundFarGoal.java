/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1314
 *  net.minecraft.class_1379
 *  net.minecraft.class_243
 *  net.minecraft.class_5534
 *  org.jetbrains.annotations.Nullable
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package ace.actually.pirates.entities.pirate_abstract;

import net.minecraft.class_1297;
import net.minecraft.class_1314;
import net.minecraft.class_1379;
import net.minecraft.class_243;
import net.minecraft.class_5534;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class PirateWanderArroundFarGoal
extends class_1379 {
    public static final float CHANCE = 0.001f;
    protected final float probability;

    public PirateWanderArroundFarGoal(class_1314 pathAwareEntity, double d) {
        this(pathAwareEntity, d, 0.001f);
    }

    public PirateWanderArroundFarGoal(class_1314 mob, double speed, float probability) {
        super(mob, speed);
        this.probability = probability;
    }

    @Nullable
    protected class_243 method_6302() {
        if (VSGameUtilsKt.getShipManaging((class_1297)this.field_6566) != null) {
            return null;
        }
        if (this.field_6566.method_5816()) {
            class_243 vec3d = class_5534.method_31527((class_1314)this.field_6566, (int)15, (int)7);
            return vec3d == null ? super.method_6302() : vec3d;
        }
        return this.field_6566.method_6051().method_43057() >= this.probability ? class_5534.method_31527((class_1314)this.field_6566, (int)10, (int)7) : super.method_6302();
    }
}

