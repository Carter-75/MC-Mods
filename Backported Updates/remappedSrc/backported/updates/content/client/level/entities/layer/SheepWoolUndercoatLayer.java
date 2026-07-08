/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1472
 *  net.minecraft.class_1767
 *  net.minecraft.class_2960
 *  net.minecraft.class_3883
 *  net.minecraft.class_3887
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_5253$class_5254
 *  net.minecraft.class_5599
 *  net.minecraft.class_5602
 *  net.minecraft.class_583
 *  net.minecraft.class_598
 *  net.minecraft.class_601
 */
package backported.updates.content.client.level.entities.layer;

import backported.updates.content.client.util.LazyModel;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1472;
import net.minecraft.class_1767;
import net.minecraft.class_2960;
import net.minecraft.class_3883;
import net.minecraft.class_3887;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_5253;
import net.minecraft.class_5599;
import net.minecraft.class_5602;
import net.minecraft.class_583;
import net.minecraft.class_598;
import net.minecraft.class_601;

public class SheepWoolUndercoatLayer
extends class_3887<class_1472, class_601<class_1472>> {
    private static final class_2960 SHEEP_WOOL_UNDERCOAT_TEXTURE = class_2960.method_60656((String)"textures/entity/sheep/sheep_wool_undercoat.png");
    private final LazyModel<class_1472, class_583<class_1472>> model;

    public SheepWoolUndercoatLayer(class_3883<class_1472, class_601<class_1472>> renderer, class_5599 models) {
        super(renderer);
        this.model = LazyModel.of(models, class_5602.field_27593, class_598::new);
    }

    public void render(class_4587 poseStack, class_4597 buffer, int packedLight, class_1472 sheep, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (sheep.method_5864() == class_1299.field_6115 && !sheep.method_5767()) {
            int color;
            if (sheep.method_16914() && "jeb_".equals(sheep.method_5477().getString())) {
                int offset = sheep.field_6012 / 25 + sheep.method_5628();
                int size = class_1767.values().length;
                int fromIndex = offset % size;
                int toIndex = (offset + 1) % size;
                float delta = ((float)(sheep.field_6012 % 25) + partialTick) / 25.0f;
                int fromColor = class_1472.method_6634((class_1767)class_1767.method_7791((int)fromIndex));
                int toColor = class_1472.method_6634((class_1767)class_1767.method_7791((int)toIndex));
                color = class_5253.class_5254.method_48780((float)delta, (int)fromColor, (int)toColor);
            } else {
                color = class_1472.method_6634((class_1767)sheep.method_6633());
            }
            SheepWoolUndercoatLayer.method_23196((class_583)this.method_17165(), this.model.get(), (class_2960)SHEEP_WOOL_UNDERCOAT_TEXTURE, (class_4587)poseStack, (class_4597)buffer, (int)packedLight, (class_1309)sheep, (float)limbSwing, (float)limbSwingAmount, (float)ageInTicks, (float)netHeadYaw, (float)headPitch, (float)partialTick, (int)color);
        }
    }
}

