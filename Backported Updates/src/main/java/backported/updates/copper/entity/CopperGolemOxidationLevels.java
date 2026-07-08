/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.block.Oxidizable$OxidationLevel
 */
package backported.updates.copper.entity;

import backported.updates.copper.ModSounds;
import backported.updates.copper.entity.CopperGolemOxidationLevel;
import java.util.Map;
import net.minecraft.util.Identifier;
import net.minecraft.block.Oxidizable;

public class CopperGolemOxidationLevels {
    private static final CopperGolemOxidationLevel UNAFFECTED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_UNAFFECTED.get(), ModSounds.COPPER_GOLEM_HURT_UNAFFECTED.get(), ModSounds.COPPER_GOLEM_DEATH_UNAFFECTED.get(), ModSounds.COPPER_GOLEM_STEP_UNAFFECTED.get(), Identifier.ofVanilla((String)"textures/entity/copper_golem/copper_golem.png"), Identifier.ofVanilla((String)"textures/entity/copper_golem/copper_golem_eyes.png"));
    private static final CopperGolemOxidationLevel EXPOSED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_EXPOSED.get(), ModSounds.COPPER_GOLEM_HURT_EXPOSED.get(), ModSounds.COPPER_GOLEM_DEATH_EXPOSED.get(), ModSounds.COPPER_GOLEM_STEP_EXPOSED.get(), Identifier.ofVanilla((String)"textures/entity/copper_golem/exposed_copper_golem.png"), Identifier.ofVanilla((String)"textures/entity/copper_golem/exposed_copper_golem_eyes.png"));
    private static final CopperGolemOxidationLevel WEATHERED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_WEATHERED.get(), ModSounds.COPPER_GOLEM_HURT_WEATHERED.get(), ModSounds.COPPER_GOLEM_DEATH_WEATHERED.get(), ModSounds.COPPER_GOLEM_STEP_WEATHERED.get(), Identifier.ofVanilla((String)"textures/entity/copper_golem/weathered_copper_golem.png"), Identifier.ofVanilla((String)"textures/entity/copper_golem/weathered_copper_golem_eyes.png"));
    private static final CopperGolemOxidationLevel OXIDIZED = new CopperGolemOxidationLevel(ModSounds.COPPER_GOLEM_HEAD_SPIN_OXIDIZED.get(), ModSounds.COPPER_GOLEM_HURT_OXIDIZED.get(), ModSounds.COPPER_GOLEM_DEATH_OXIDIZED.get(), ModSounds.COPPER_GOLEM_STEP_OXIDIZED.get(), Identifier.ofVanilla((String)"textures/entity/copper_golem/oxidized_copper_golem.png"), Identifier.ofVanilla((String)"textures/entity/copper_golem/oxidized_copper_golem_eyes.png"));
    private static final Map<Oxidizable.OxidationLevel, CopperGolemOxidationLevel> WEATHERED_STATES = Map.of(Oxidizable.OxidationLevel.UNAFFECTED, UNAFFECTED, Oxidizable.OxidationLevel.EXPOSED, EXPOSED, Oxidizable.OxidationLevel.WEATHERED, WEATHERED, Oxidizable.OxidationLevel.OXIDIZED, OXIDIZED);

    public static CopperGolemOxidationLevel getOxidationLevel(Oxidizable.OxidationLevel weatherState) {
        return WEATHERED_STATES.get(weatherState);
    }
}

