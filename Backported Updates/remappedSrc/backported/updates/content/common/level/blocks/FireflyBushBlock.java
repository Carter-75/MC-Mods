/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.MapCodec
 *  net.minecraft.class_1937
 *  net.minecraft.class_2261
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2680
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.block.SpreadableBonemealableBlock;
import backported.updates.content.core.util.LevelUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.class_1937;
import net.minecraft.class_2261;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2680;
import net.minecraft.class_2902;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class FireflyBushBlock
extends class_2261
implements SpreadableBonemealableBlock {
    public static final MapCodec<FireflyBushBlock> CODEC = FireflyBushBlock.method_54094(FireflyBushBlock::new);
    private static final double FIREFLY_CHANCE_PER_TICK = 0.7;
    private static final double FIREFLY_HORIZONTAL_RANGE = 10.0;
    private static final double FIREFLY_VERTICAL_RANGE = 5.0;
    private static final int FIREFLY_SPAWN_MAX_BRIGHTNESS_LEVEL = 13;
    private static final int FIREFLY_AMBIENT_SOUND_CHANCE_ONE_IN = 30;

    public FireflyBushBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    protected MapCodec<? extends class_2261> method_53969() {
        return CODEC;
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        if (random.method_43048(30) == 0 && LevelUtils.isMoonVisible(level) && level.method_8624(class_2902.class_2903.field_13203, pos.method_10263(), pos.method_10260()) <= pos.method_10264()) {
            level.method_45446(pos, ModSoundEvents.FIREFLY_BUSH_IDLE.get(), class_3419.field_15256, 1.0f, 1.0f, false);
        }
        if ((LevelUtils.isMoonVisible(level) || level.method_22339(pos) <= 13) && random.method_43058() <= 0.7) {
            double x = (double)pos.method_10263() + random.method_43058() * 10.0 - 5.0;
            double y = (double)pos.method_10264() + random.method_43058() * 5.0;
            double z = (double)pos.method_10260() + random.method_43058() * 10.0 - 5.0;
            level.method_8406((class_2394)ModParticles.FIREFLY.get(), x, y, z, 0.0, 0.0, 0.0);
        }
    }

    public boolean method_9651(class_4538 level, class_2338 pos, class_2680 state) {
        return SpreadableBonemealableBlock.hasSpreadableNeighbourPos(level, pos, state);
    }

    public boolean method_9650(class_1937 level, class_5819 random, class_2338 pos, class_2680 state) {
        return true;
    }

    public void method_9652(class_3218 level, class_5819 random, class_2338 pos, class_2680 state) {
        SpreadableBonemealableBlock.findSpreadableNeighbourPos((class_1937)level, pos, state).ifPresent(newPos -> level.method_8501(newPos, this.method_9564()));
    }
}

