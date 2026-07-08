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
 *  net.minecraft.class_1935
 *  net.minecraft.class_763
 *  net.minecraft.class_7923
 *  net.minecraft.class_811
 */
package backported.updates.content.client.level.item;

import backported.updates.content.common.registries.ModItems;
import backported.updates.content.core.VanillaBackport;
import backported.updates.foundation.client.v2.render.ItemRendererRegistry;
import backported.updates.foundation.core.util.event.ResultHolder;
import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_763;
import net.minecraft.class_7923;
import net.minecraft.class_811;

public class BundleRenderer
implements ItemRendererRegistry.Renderer {
    public static final Set<class_1935> BUNDLES = Set.of(class_1802.field_27023, (class_1935)ModItems.WHITE_BUNDLE.get(), (class_1935)ModItems.ORANGE_BUNDLE.get(), (class_1935)ModItems.MAGENTA_BUNDLE.get(), (class_1935)ModItems.LIGHT_BLUE_BUNDLE.get(), (class_1935)ModItems.YELLOW_BUNDLE.get(), (class_1935)ModItems.LIME_BUNDLE.get(), (class_1935)ModItems.PINK_BUNDLE.get(), (class_1935)ModItems.GRAY_BUNDLE.get(), (class_1935)ModItems.LIGHT_GRAY_BUNDLE.get(), (class_1935)ModItems.CYAN_BUNDLE.get(), (class_1935)ModItems.BLUE_BUNDLE.get(), (class_1935)ModItems.BROWN_BUNDLE.get(), (class_1935)ModItems.GREEN_BUNDLE.get(), (class_1935)ModItems.RED_BUNDLE.get(), (class_1935)ModItems.BLACK_BUNDLE.get(), (class_1935)ModItems.PURPLE_BUNDLE.get());
    private static final Map<class_1935, class_1091> BUNDLE_MODELS = BundleRenderer.buildModels();

    private static Map<class_1935, class_1091> buildModels() {
        HashMap<class_1935, class_1091> models = new HashMap<class_1935, class_1091>();
        for (class_1935 item : BUNDLES) {
            models.put(item, BundleRenderer.create(item.method_8389()));
        }
        return models;
    }

    private static class_1091 create(class_1792 item) {
        return new class_1091(VanillaBackport.resource(class_7923.field_41178.method_10221((Object)item).method_12832()), "inventory");
    }

    @Override
    public boolean shouldUse() {
        return VanillaBackport.COMMON_CONFIG.hasUpdatedBundles.get();
    }

    @Override
    public ResultHolder<class_1087> renderFirstPerson(class_1799 stack, class_811 context, class_763 shaper) {
        return ResultHolder.submit(shaper.method_3303().method_4742(BUNDLE_MODELS.get(stack.method_7909())));
    }

    @Override
    public ResultHolder<class_1087> renderThirdPerson(class_1799 stack, class_763 shaper) {
        return ResultHolder.submit(shaper.method_3303().method_4742(BUNDLE_MODELS.get(stack.method_7909())));
    }

    @Override
    public Set<class_1091> registerModels() {
        ImmutableSet models = ImmutableSet.of();
        models = ImmutableSet.builder().addAll((Iterable)models).addAll(BUNDLE_MODELS.values()).build();
        return models;
    }
}

