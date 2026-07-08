/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5617$class_5618
 */
package tech.alexnijjar.golemoverhaul.client.renderers.entities.golems;

import net.minecraft.class_2960;
import net.minecraft.class_5617;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemModel;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.base.BaseGolemRenderer;
import tech.alexnijjar.golemoverhaul.common.entities.golems.TerracottaGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class TerracottaGolemRenderer
extends BaseGolemRenderer<TerracottaGolem> {
    public static final class_2960 MODEL = GolemOverhaul.asResource("geo/entity/terracotta/terracotta_golem.geo.json");
    public static final class_2960 CACTUS_MODEL = GolemOverhaul.asResource("geo/entity/terracotta/cactus_terracotta_golem.geo.json");
    public static final class_2960 DEAD_BUSH_MODEL = GolemOverhaul.asResource("geo/entity/terracotta/dead_bush_terracotta_golem.geo.json");

    public TerracottaGolemRenderer(class_5617.class_5618 renderManager) {
        super(renderManager, new BaseGolemModel<TerracottaGolem>(ModEntityTypes.TERRACOTTA_GOLEM, true, 10){

            public class_2960 getModelResource(TerracottaGolem golem) {
                return switch (golem.getTerracottaType()) {
                    default -> throw new IncompatibleClassChangeError();
                    case TerracottaGolem.Type.NORMAL -> MODEL;
                    case TerracottaGolem.Type.CACTUS -> CACTUS_MODEL;
                    case TerracottaGolem.Type.DEAD_BUSH -> DEAD_BUSH_MODEL;
                };
            }
        });
    }
}

