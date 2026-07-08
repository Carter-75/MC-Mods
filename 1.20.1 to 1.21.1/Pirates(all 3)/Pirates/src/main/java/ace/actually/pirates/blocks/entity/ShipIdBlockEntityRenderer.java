/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2350
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_310
 *  net.minecraft.class_327$class_6415
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5614$class_5615
 *  net.minecraft.class_7833
 *  net.minecraft.class_827
 */
package ace.actually.pirates.blocks.entity;

import ace.actually.pirates.blocks.entity.ShipIdBlockEntity;
import net.minecraft.class_2350;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5614;
import net.minecraft.class_7833;
import net.minecraft.class_827;

public class ShipIdBlockEntityRenderer
implements class_827<ShipIdBlockEntity> {
    public ShipIdBlockEntityRenderer(class_5614.class_5615 context) {
    }

    public void render(ShipIdBlockEntity entity, float tickDelta, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
        matrices.method_22903();
        matrices.method_46416(0.0f, 2.0f, 0.0f);
        switch ((class_2350)entity.method_11010().method_11654((class_2769)class_2741.field_12525)) {
            case field_11043: {
                matrices.method_22907(class_7833.field_40716.rotationDegrees(180.0f));
                matrices.method_22904(-1.0, 0.0, -0.9);
                break;
            }
            case field_11034: {
                matrices.method_22907(class_7833.field_40716.rotationDegrees(90.0f));
                matrices.method_22904(-1.0, 0.0, 0.1);
                break;
            }
            case field_11039: {
                matrices.method_22907(class_7833.field_40716.rotationDegrees(270.0f));
                matrices.method_22904(0.0, 0.0, -0.9);
                break;
            }
            case field_11035: {
                matrices.method_22904(0.0, 0.0, 0.1);
            }
        }
        matrices.method_22905(-0.1f, 0.1f, 0.1f);
        matrices.method_22907(class_7833.field_40717.rotationDegrees(180.0f));
        class_310.method_1551().field_1772.method_27521(entity.getShipName().replace("\\", "\u00a7"), 0.0f, 1.0f, 0, false, matrices.method_23760().method_23761(), vertexConsumers, class_327.class_6415.field_33993, 1, light);
        matrices.method_22909();
    }
}

