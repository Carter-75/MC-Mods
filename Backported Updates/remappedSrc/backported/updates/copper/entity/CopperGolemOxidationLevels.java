/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_5955$class_5811
 */
package backported.updates.copper.entity;

import backported.updates.copper.ModSounds;
import backported.updates.copper.entity.CopperGolemOxidationLevel;
import java.util.Map;
import net.minecraft.class_2960;
import net.minecraft.class_5955;

public class CopperGolemOxidationLevels {
    private static final CopperGolemOxidationLevel UNAFFECTED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_UNAFFECTED.get(), ModSounds.COPPER_GOLEM_HURT_UNAFFECTED.get(), ModSounds.COPPER_GOLEM_DEATH_UNAFFECTED.get(), ModSounds.COPPER_GOLEM_STEP_UNAFFECTED.get(), class_2960.method_60656((String)"textures/entity/copper_golem/copper_golem.png"), class_2960.method_60656((String)"textures/entity/copper_golem/copper_golem_eyes.png"));
    private static final CopperGolemOxidationLevel EXPOSED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_EXPOSED.get(), ModSounds.COPPER_GOLEM_HURT_EXPOSED.get(), ModSounds.COPPER_GOLEM_DEATH_EXPOSED.get(), ModSounds.COPPER_GOLEM_STEP_EXPOSED.get(), class_2960.method_60656((String)"textures/entity/copper_golem/exposed_copper_golem.png"), class_2960.method_60656((String)"textures/entity/copper_golem/exposed_copper_golem_eyes.png"));
    private static final CopperGolemOxidationLevel WEATHERED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_WEATHERED.get(), ModSounds.COPPER_GOLEM_HURT_WEATHERED.get(), ModSounds.COPPER_GOLEM_DEATH_WEATHERED.get(), ModSounds.COPPER_GOLEM_STEP_WEATHERED.get(), class_2960.method_60656((String)"textures/entity/copper_golem/weathered_copper_golem.png"), class_2960.method_60656((String)"textures/entity/copper_golem/weathered_copper_golem_eyes.png"));
    private static final CopperGolemOxidationLevel OXIDIZED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_OXIDIZED.get(), ModSounds.COPPER_GOLEM_HURT_OXIDIZED.get(), ModSounds.COPPER_GOLEM_DEATH_OXIDIZED.get(), ModSounds.COPPER_GOLEM_STEP_OXIDIZED.get(), class_2960.method_60656((String)"textures/entity/copper_golem/oxidized_copper_golem.png"), class_2960.method_60656((String)"textures/entity/copper_golem/oxidized_copper_golem_eyes.png"));
    private static final Map<class_5955.class_5811, CopperGolemOxidationLevel> WEATHERED_STATES = Map.of(class_5955.class_5811.field_28704, UNAFFECTED, class_5955.class_5811.field_28705, EXPOSED, class_5955.class_5811.field_28706, WEATHERED, class_5955.class_5811.field_28707, OXIDIZED);

    public static CopperGolemOxidationLevel getOxidationLevel(class_5955.class_5811 weatherState) {
        return WEATHERED_STATES.get(weatherState);
    }
}

