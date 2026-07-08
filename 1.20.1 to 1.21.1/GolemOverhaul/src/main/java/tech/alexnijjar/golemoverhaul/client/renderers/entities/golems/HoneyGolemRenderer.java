/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1439$class_4621
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1439;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HoneyGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class HoneyGolemRenderer
extends BaseGolemRenderer<HoneyGolem> {
    public static final class_2960 FULL_TEXTURE_1 = GolemOverhaul.asResource("textures/entity/honey/honey_golem_full_1.png");
    public static final class_2960 FULL_TEXTURE_2 = GolemOverhaul.asResource("textures/entity/honey/honey_golem_full_2.png");
    public static final class_2960 FULL_TEXTURE_3 = GolemOverhaul.asResource("textures/entity/honey/honey_golem_full_3.png");

    public HoneyGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<HoneyGolem>(ModEntityTypes.HONEY_GOLEM, true, 20));
    }

    public class_2960 getTextureLocation(HoneyGolem golem) {
        if (!golem.isFullOfHoney()) {
            return this.getGeoModel().getTextureResource((GeoAnimatable)golem);
        }
        return switch (golem.getCrackiness()) {
            default -> throw new IncompatibleClassChangeError();
            case class_1439.class_4621.field_21081, class_1439.class_4621.field_21082 -> FULL_TEXTURE_1;
            case class_1439.class_4621.field_21083 -> FULL_TEXTURE_2;
            case class_1439.class_4621.field_21084 -> FULL_TEXTURE_3;
        };
    }
}

