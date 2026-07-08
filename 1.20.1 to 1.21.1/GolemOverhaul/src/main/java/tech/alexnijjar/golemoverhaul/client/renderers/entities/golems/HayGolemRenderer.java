/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1439$class_4621
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_1439;
import net.minecraft.class_2960;
import net.minecraft.class_5617;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.HayGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class HayGolemRenderer
extends BaseGolemRenderer<HayGolem> {
    public static final class_2960 GREEN_TEXTURE_1 = GolemOverhaul.asResource("textures/entity/hay/green_hay_golem_1.png");
    public static final class_2960 GREEN_TEXTURE_2 = GolemOverhaul.asResource("textures/entity/hay/green_hay_golem_2.png");
    public static final class_2960 GREEN_TEXTURE_3 = GolemOverhaul.asResource("textures/entity/hay/green_hay_golem_3.png");
    public static final class_2960 RED_TEXTURE_1 = GolemOverhaul.asResource("textures/entity/hay/red_hay_golem_1.png");
    public static final class_2960 RED_TEXTURE_2 = GolemOverhaul.asResource("textures/entity/hay/red_hay_golem_2.png");
    public static final class_2960 RED_TEXTURE_3 = GolemOverhaul.asResource("textures/entity/hay/red_hay_golem_3.png");
    public static final class_2960 GREEN_MODEL = GolemOverhaul.asResource("geo/entity/hay/green_hay_golem.geo.json");
    public static final class_2960 SHEARED_GREEN_MODEL = GolemOverhaul.asResource("geo/entity/hay/green_hay_golem_sheared.geo.json");
    public static final class_2960 RED_MODEL = GolemOverhaul.asResource("geo/entity/hay/red_hay_golem.geo.json");
    public static final class_2960 SHEARED_RED_MODEL = GolemOverhaul.asResource("geo/entity/hay/red_hay_golem_sheared.geo.json");

    public HayGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<HayGolem>(ModEntityTypes.HAY_GOLEM, true, 90){

            public class_2960 getModelResource(HayGolem golem) {
                boolean sheared = golem.isSheared();
                return golem.getColor() == HayGolem.Color.GREEN ? (sheared ? SHEARED_GREEN_MODEL : GREEN_MODEL) : (sheared ? SHEARED_RED_MODEL : RED_MODEL);
            }
        });
    }

    public class_2960 getTextureLocation(HayGolem golem) {
        HayGolem.Color color = golem.getColor();
        return switch (golem.getCrackiness()) {
            default -> throw new IncompatibleClassChangeError();
            case class_1439.class_4621.field_21081, class_1439.class_4621.field_21082 -> {
                if (color == HayGolem.Color.GREEN) {
                    yield GREEN_TEXTURE_1;
                }
                yield RED_TEXTURE_1;
            }
            case class_1439.class_4621.field_21083 -> {
                if (color == HayGolem.Color.GREEN) {
                    yield GREEN_TEXTURE_2;
                }
                yield RED_TEXTURE_2;
            }
            case class_1439.class_4621.field_21084 -> color == HayGolem.Color.GREEN ? GREEN_TEXTURE_3 : RED_TEXTURE_3;
        };
    }
}

