/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2498
 *  net.minecraft.class_3417
 */
package backported.updates.content.client.registries;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.foundation.core.helper.SoundRegistry;
import net.minecraft.class_2498;
import net.minecraft.class_3417;

public class ModSoundTypes {
    public static final SoundRegistry SOUNDS = SoundRegistry.create("minecraft");
    public static final class_2498 CREAKING_HEART = SOUNDS.soundType(ModSoundEvents.CREAKING_HEART_BREAK, ModSoundEvents.CREAKING_HEART_STEP, ModSoundEvents.CREAKING_HEART_PLACE, ModSoundEvents.CREAKING_HEART_HIT, ModSoundEvents.CREAKING_HEART_FALL);
    public static final class_2498 RESIN = SOUNDS.soundType(ModSoundEvents.RESIN_BREAK, ModSoundEvents.RESIN_STEP, ModSoundEvents.RESIN_PLACE, () -> class_3417.field_42593, ModSoundEvents.RESIN_FALL);
    public static final class_2498 RESIN_BRICKS = SOUNDS.soundType(ModSoundEvents.RESIN_BRICKS_BREAK, ModSoundEvents.RESIN_BRICKS_STEP, ModSoundEvents.RESIN_BRICKS_PLACE, ModSoundEvents.RESIN_BRICKS_HIT, ModSoundEvents.RESIN_BRICKS_FALL);
    public static final class_2498 DRIED_GHAST = SOUNDS.soundType(ModSoundEvents.DRIED_GHAST_BREAK, ModSoundEvents.DRIED_GHAST_STEP, () -> class_3417.field_42593, () -> class_3417.field_42593, ModSoundEvents.DRIED_GHAST_FALL);
    public static final class_2498 LEAF_LITTER = SOUNDS.soundType(ModSoundEvents.LEAF_LITTER_BREAK, ModSoundEvents.LEAF_LITTER_STEP, ModSoundEvents.LEAF_LITTER_PLACE, ModSoundEvents.LEAF_LITTER_HIT, ModSoundEvents.LEAF_LITTER_FALL);
    public static final class_2498 CACTUS_FLOWER = SOUNDS.soundType(ModSoundEvents.CACTUS_FLOWER_BREAK, () -> class_3417.field_42593, ModSoundEvents.CACTUS_FLOWER_PLACE, () -> class_3417.field_42593, () -> class_3417.field_42593);
    public static final class_2498 COPPER_GOLEM_STATUE = SOUNDS.soundType(ModSoundEvents.COPPER_GOLEM_STATUE_BREAK.orElse(() -> class_3417.field_42593), ModSoundEvents.COPPER_GOLEM_STATUE_STEP.orElse(() -> class_3417.field_42593), ModSoundEvents.COPPER_GOLEM_STATUE_PLACE.orElse(() -> class_3417.field_42593), ModSoundEvents.COPPER_GOLEM_STATUE_HIT.orElse(() -> class_3417.field_42593), ModSoundEvents.COPPER_GOLEM_STATUE_FALL.orElse(() -> class_3417.field_42593));
}

