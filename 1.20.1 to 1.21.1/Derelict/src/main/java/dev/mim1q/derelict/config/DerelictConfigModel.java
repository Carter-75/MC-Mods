/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  blue.endless.jankson.Comment
 *  io.wispforest.owo.config.annotation.Config
 */
package dev.mim1q.derelict.config;

import blue.endless.jankson.Comment;
import io.wispforest.owo.config.annotation.Config;

@Config(name="derelict", wrapperName="DerelictConfig")
public class DerelictConfigModel {
    @Comment(value="Which type of flickering lights to use:\n  FAST: Best performance, doesn't have an effect on the emitted light level\n  FANCY: Affects emitted light, worse performance. Best option to use with custom texture packs\n  FABULOUS: Affects emitted light, looks the best, slightly worse performance than fancy. Best option for vanilla textures\n\nNote: - When switching from FAST to FANCY/FABULOUS, all existing flickering light blocks will have to be replaced in order for the change to take place.\n      - Consider using FAST if you're hosting a server with a lot of players, or if any of the players might be sensitive to flickering lights.")
    public FlickeringLightsSetting flickeringLights = FlickeringLightsSetting.FABULOUS;
    @Comment(value="The chance for a Spiderling to spawn when an entity dies.\nEntities that this applies to are defined in the `derelict:entity_types/spawns_spiderlings_on_death` tag.\nValue is a percentage, 0.0 - 100.0")
    public float spiderlingSpawnChance = 10.0f;
    @Comment(value="The ID of the advancement that is necessary to break Arachne's Egg to summon the boss. Not having this\nadvancement will display a message with the advancement's DESCRIPTION in-game.\n\nIf left empty, no advancement is required.")
    public String arachneEggAdvancement = "";
    @Comment(value="The time it takes for an Arachne's Egg to respawn, in seconds.\nSet to -1 to disable respawning (only recommended if you have a proper reason to only allow one fight per \nnest).")
    public int arachneEggRespawnTime = 3600;

    public static enum FlickeringLightsSetting {
        FAST,
        FANCY,
        FABULOUS;

    }
}

