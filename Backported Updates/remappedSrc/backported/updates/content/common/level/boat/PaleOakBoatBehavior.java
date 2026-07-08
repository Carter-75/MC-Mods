/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1690
 *  net.minecraft.class_1690$class_1691
 *  net.minecraft.class_1802
 *  net.minecraft.class_1928
 *  net.minecraft.class_1935
 *  net.minecraft.class_3486
 */
package backported.updates.content.common.level.boat;

import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.class_1690;
import net.minecraft.class_1802;
import net.minecraft.class_1928;
import net.minecraft.class_1935;
import net.minecraft.class_3486;

public interface PaleOakBoatBehavior {
    default public void fall(class_1690 boat, double y, boolean onGround) {
        boat.field_7696 = boat.method_18798().field_1351;
        if (!boat.method_5765()) {
            if (onGround) {
                if (boat.field_6017 > 3.0f) {
                    if (boat.field_7702 != class_1690.class_1691.field_7719) {
                        boat.method_38785();
                        return;
                    }
                    boat.method_5747(boat.field_6017, 1.0f, boat.method_48923().method_48827());
                    if (!boat.method_37908().method_8608() && !boat.method_31481()) {
                        boat.method_5768();
                        if (boat.method_37908().method_8450().method_8355(class_1928.field_19393)) {
                            int i;
                            for (i = 0; i < 3; ++i) {
                                boat.method_5706((class_1935)ModBlocks.PALE_OAK_PLANKS.get());
                            }
                            for (i = 0; i < 3; ++i) {
                                boat.method_5706((class_1935)class_1802.field_8600);
                            }
                        }
                    }
                }
                boat.method_38785();
            } else if (!boat.method_37908().method_8316(boat.method_24515().method_10074()).method_15767(class_3486.field_15517) && y < 0.0) {
                boat.field_6017 -= (float)y;
            }
        }
    }
}

