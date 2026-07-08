/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_7923
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import net.minecraft.class_7923;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;

public class BaseGolemRenderer<T extends BaseGolem>
extends GeoEntityRenderer<T> {
    public BaseGolemRenderer(class_5617.class_5618 renderManager, GeoModel<T> model) {
        super(renderManager, model);
    }

    public static <T extends class_1297> class_2960 texture(RegistryEntry<class_1299<T>> golem) {
        String name = BaseGolemRenderer.name(golem).method_12832();
        return GolemOverhaul.asResource("%s/%s".formatted(name.replace("_golem", ""), name));
    }

    public static <T extends class_1297> class_2960 name(RegistryEntry<class_1299<T>> golem) {
        return class_7923.field_41177.method_10221((Object)((class_1299)golem.get()));
    }
}

