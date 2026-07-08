/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.class_1087
 *  net.minecraft.class_1091
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1921
 *  net.minecraft.class_1935
 *  net.minecraft.class_325
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4696
 *  net.minecraft.class_5253$class_5254
 *  net.minecraft.class_763
 *  net.minecraft.class_777
 *  net.minecraft.class_7923
 *  net.minecraft.class_811
 *  net.minecraft.class_918
 */
package backported.updates.content.client.level.item;

import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.client.v2.render.DynamicItemRenderer;
import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1921;
import net.minecraft.class_1935;
import net.minecraft.class_325;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4696;
import net.minecraft.class_5253;
import net.minecraft.class_763;
import net.minecraft.class_777;
import net.minecraft.class_7923;
import net.minecraft.class_811;
import net.minecraft.class_918;

public class SpawnEggRenderer
implements DynamicItemRenderer.Renderer {
    public static final Set<class_1935> SPAWN_EGGS = Set.of(class_1802.field_38419, class_1802.field_47832, class_1802.field_28355, class_1802.field_8727, class_1802.field_20413, class_1802.field_8154, class_1802.field_49153, class_1802.field_47313, class_1802.field_40239, class_1802.field_16314, class_1802.field_8068, class_1802.field_8835, class_1802.field_8661, class_1802.field_8433, (class_1935)ModItems.CREAKING_SPAWN_EGG.get(), class_1802.field_8503, class_1802.field_8751, class_1802.field_8306, class_1802.field_8083, class_1802.field_8769, class_1802.field_8374, class_1802.field_8510, class_1802.field_8795, class_1802.field_18005, class_1802.field_37535, class_1802.field_8265, class_1802.field_28407, class_1802.field_30905, class_1802.field_8409, (class_1935)ModItems.HAPPY_GHAST_SPAWN_EGG.get(), class_1802.field_22014, class_1802.field_8117, class_1802.field_8760, class_1802.field_40864, class_1802.field_8633, class_1802.field_8852, class_1802.field_8299, class_1802.field_8331, class_1802.field_8132, class_1802.field_8193, class_1802.field_8274, class_1802.field_8670, class_1802.field_8493, class_1802.field_22401, class_1802.field_25777, class_1802.field_8325, class_1802.field_8346, class_1802.field_8100, class_1802.field_8227, class_1802.field_8297, class_1802.field_8447, class_1802.field_8607, class_1802.field_8480, class_1802.field_8564, class_1802.field_8300, class_1802.field_8232, class_1802.field_8881, class_1802.field_42710, class_1802.field_40866, class_1802.field_8185, class_1802.field_8307, class_1802.field_8514, class_1802.field_23255, class_1802.field_37536, class_1802.field_17731, class_1802.field_8612, class_1802.field_8435, class_1802.field_8235, class_1802.field_8086, class_1802.field_8149, class_1802.field_17732, class_1802.field_38219, class_1802.field_8254, class_1802.field_8832, class_1802.field_8485, class_1802.field_23744, class_1802.field_8441, class_1802.field_8728, class_1802.field_8136, class_1802.field_8093);
    private static final Map<class_1935, class_1091> EGG_MODELS = SpawnEggRenderer.buildModels();

    private static Map<class_1935, class_1091> buildModels() {
        HashMap<class_1935, class_1091> models = new HashMap<class_1935, class_1091>();
        for (class_1935 item : SPAWN_EGGS) {
            models.put(item, SpawnEggRenderer.create(item.method_8389()));
        }
        return models;
    }

    private static class_1091 create(class_1792 item) {
        return new class_1091(VanillaBackport.resource(class_7923.field_41178.method_10221((Object)item).method_12832()), "inventory");
    }

    @Override
    public boolean shouldUse() {
        return VanillaBackport.CLIENT_CONFIG.useLegacySpawnEggs.get() == false;
    }

    @Override
    public void renderFirstPerson(class_1799 stack, class_811 context, boolean leftHand, class_4587 pose, class_4597 buffer, int light, int overlay, class_1087 model, class_763 shaper, class_325 colors) {
        model = shaper.method_3303().method_4742(EGG_MODELS.get(stack.method_7909()));
        model.method_4709().method_3503(context).method_23075(leftHand, pose);
        pose.method_46416(-0.5f, -0.5f, -0.5f);
        class_1921 renderType = class_4696.method_23678((class_1799)stack, (boolean)true);
        class_4588 vertices = class_918.method_29711((class_4597)buffer, (class_1921)renderType, (boolean)true, (boolean)stack.method_7958());
        this.renderModelLists(model, stack, light, overlay, pose, vertices, colors);
    }

    @Override
    public ResultHolder<class_1087> renderThirdPerson(class_1799 stack, class_763 shaper) {
        return ResultHolder.submit(shaper.method_3303().method_4742(EGG_MODELS.get(stack.method_7909())));
    }

    @Override
    public Set<class_1091> registerModels() {
        ImmutableSet models = ImmutableSet.of();
        models = ImmutableSet.builder().addAll((Iterable)models).addAll(EGG_MODELS.values()).build();
        return models;
    }

    @Override
    public void renderQuadList(class_4587 pose, class_4588 buffer, List<class_777> quads, class_1799 stack, int light, int overlay, class_325 colors) {
        class_4587.class_4665 last = pose.method_23760();
        for (class_777 quad : quads) {
            int tint = -1;
            float alpha = (float)class_5253.class_5254.method_27762((int)tint) / 255.0f;
            float red = (float)class_5253.class_5254.method_27765((int)tint) / 255.0f;
            float green = (float)class_5253.class_5254.method_27766((int)tint) / 255.0f;
            float blue = (float)class_5253.class_5254.method_27767((int)tint) / 255.0f;
            buffer.method_22919(last, quad, red, green, blue, alpha, light, overlay);
        }
    }
}

