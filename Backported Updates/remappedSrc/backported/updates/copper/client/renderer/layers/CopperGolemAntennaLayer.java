/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_2680
 *  net.minecraft.class_310
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_4608
 *  net.minecraft.class_776
 *  net.minecraft.class_7833
 */
package backported.updates.copper.client.renderer.layers;

import backported.updates.copper.client.model.CopperGolemModel;
import backported.updates.copper.entity.CopperGolemEntity;
import net.minecraft.class_1747;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2680;
import net.minecraft.class_310;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_776;
import net.minecraft.class_7833;

public class CopperGolemAntennaLayer
extends class_3887<CopperGolemEntity, CopperGolemModel> {
    private final class_776 blockRenderer = class_310.method_1551().method_1541();

    public CopperGolemAntennaLayer(class_3883<CopperGolemEntity, CopperGolemModel> renderer) {
        super(renderer);
    }

    public void render(class_4587 poseStack, class_4597 buffer, int packedLight, CopperGolemEntity entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        class_1799 antennaItem = entity.method_6118(CopperGolemEntity.EQUIPMENT_SLOT_ANTENNA);
        if (antennaItem.method_7960()) {
            return;
        }
        class_1792 class_17922 = antennaItem.method_7909();
        if (!(class_17922 instanceof class_1747)) {
            return;
        }
        class_1747 blockItem = (class_1747)class_17922;
        class_2680 blockState = blockItem.method_7711().method_9564();
        poseStack.method_22903();
        ((CopperGolemModel)this.method_17165()).applyBlockOnAntennaTransform(poseStack);
        poseStack.method_22907(class_7833.field_40718.rotationDegrees(180.0f));
        poseStack.method_22905(0.5f, 0.5f, 0.5f);
        poseStack.method_22904(-0.5, -0.5, -0.5);
        this.blockRenderer.method_3353(blockState, poseStack, buffer, packedLight, class_4608.field_21444);
        poseStack.method_22909();
    }
}

