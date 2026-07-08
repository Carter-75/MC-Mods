/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2246
 *  net.minecraft.class_2350
 *  net.minecraft.class_2680
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_310
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5614$class_5615
 *  net.minecraft.class_776
 *  net.minecraft.class_827
 *  org.joml.Quaternionf
 */
package ace.actually.pirates.blocks.entity;

import ace.actually.pirates.blocks.entity.CannonPrimingBlockEntity;
import java.util.Objects;
import net.minecraft.class_2246;
import net.minecraft.class_2350;
import net.minecraft.class_2680;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_310;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5614;
import net.minecraft.class_776;
import net.minecraft.class_827;
import org.joml.Quaternionf;

public class CannonPrimingBlockEntityRenderer
implements class_827<CannonPrimingBlockEntity> {
    public CannonPrimingBlockEntityRenderer(class_5614.class_5615 context) {
    }

    public void render(CannonPrimingBlockEntity entity, float tickDelta, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
        if (entity.method_11015()) {
            return;
        }
        class_2680 state = Objects.requireNonNull(entity.method_10997()).method_8320(entity.method_11016());
        if (((Boolean)state.method_11654((class_2769)class_2741.field_12553)).booleanValue()) {
            return;
        }
        class_776 blockRenderManager = class_310.method_1551().method_1541();
        matrices.method_22903();
        matrices.method_22904(0.5, 1.2501, 0.5);
        double rotationValue = (double)((class_2350)state.method_11654((class_2769)class_2741.field_12525)).method_10144() * Math.PI / 180.0 + entity.randomRotation + 0.39269908169872414;
        matrices.method_22907(new Quaternionf(Math.cos(rotationValue / 2.0), 0.0, Math.sin(rotationValue / 2.0), 0.0));
        matrices.method_22907(new Quaternionf(Math.cos(0.7853981633974483), Math.sin(0.7853981633974483), 0.0, 0.0));
        matrices.method_22904(-0.3125, -0.25, -0.5);
        blockRenderManager.method_3353(class_2246.field_10336.method_9564(), matrices, vertexConsumers, 255, overlay);
        matrices.method_22909();
    }
}

