/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.sound.BlockSoundGroup
 *  net.minecraft.sound.SoundEvents
 */
package backported.updates.content.client.registries;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.foundation.core.helper.SoundRegistry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class ModSoundTypes {
    public static final SoundRegistry SOUNDS = SoundRegistry.create("backported_updates");
    public static final BlockSoundGroup CREAKING_HEART = SOUNDS.soundType(ModSoundEvents.CREAKING_HEART_BREAK, ModSoundEvents.CREAKING_HEART_STEP, ModSoundEvents.CREAKING_HEART_PLACE, ModSoundEvents.CREAKING_HEART_HIT, ModSoundEvents.CREAKING_HEART_FALL);
    public static final BlockSoundGroup RESIN = SOUNDS.soundType(ModSoundEvents.RESIN_BREAK, ModSoundEvents.RESIN_STEP, ModSoundEvents.RESIN_PLACE, () -> SoundEvents.INTENTIONALLY_EMPTY, ModSoundEvents.RESIN_FALL);
    public static final BlockSoundGroup RESIN_BRICKS = SOUNDS.soundType(ModSoundEvents.RESIN_BRICKS_BREAK, ModSoundEvents.RESIN_BRICKS_STEP, ModSoundEvents.RESIN_BRICKS_PLACE, ModSoundEvents.RESIN_BRICKS_HIT, ModSoundEvents.RESIN_BRICKS_FALL);
    public static final BlockSoundGroup DRIED_GHAST = SOUNDS.soundType(ModSoundEvents.DRIED_GHAST_BREAK, ModSoundEvents.DRIED_GHAST_STEP, () -> SoundEvents.INTENTIONALLY_EMPTY, () -> SoundEvents.INTENTIONALLY_EMPTY, ModSoundEvents.DRIED_GHAST_FALL);
    public static final BlockSoundGroup LEAF_LITTER = SOUNDS.soundType(ModSoundEvents.LEAF_LITTER_BREAK, ModSoundEvents.LEAF_LITTER_STEP, ModSoundEvents.LEAF_LITTER_PLACE, ModSoundEvents.LEAF_LITTER_HIT, ModSoundEvents.LEAF_LITTER_FALL);
    public static final BlockSoundGroup CACTUS_FLOWER = SOUNDS.soundType(ModSoundEvents.CACTUS_FLOWER_BREAK, () -> SoundEvents.INTENTIONALLY_EMPTY, ModSoundEvents.CACTUS_FLOWER_PLACE, () -> SoundEvents.INTENTIONALLY_EMPTY, () -> SoundEvents.INTENTIONALLY_EMPTY);
    public static final BlockSoundGroup COPPER_GOLEM_STATUE = SOUNDS.soundType(ModSoundEvents.COPPER_GOLEM_STATUE_BREAK.orElse(() -> SoundEvents.INTENTIONALLY_EMPTY), ModSoundEvents.COPPER_GOLEM_STATUE_STEP.orElse(() -> SoundEvents.INTENTIONALLY_EMPTY), ModSoundEvents.COPPER_GOLEM_STATUE_PLACE.orElse(() -> SoundEvents.INTENTIONALLY_EMPTY), ModSoundEvents.COPPER_GOLEM_STATUE_HIT.orElse(() -> SoundEvents.INTENTIONALLY_EMPTY), ModSoundEvents.COPPER_GOLEM_STATUE_FALL.orElse(() -> SoundEvents.INTENTIONALLY_EMPTY));
}

