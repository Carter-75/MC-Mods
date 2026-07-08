/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2362
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_3419
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.EyeblossomBlock;
import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2362;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_3419;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class EyeblossomFlowerPotBlock
extends class_2362 {
    public EyeblossomFlowerPotBlock(class_2248 content, class_4970.class_2251 properties) {
        super(content, properties);
    }

    public void method_9514(class_2680 state, class_3218 level, class_2338 pos, class_5819 random) {
        boolean isNaturalNight;
        boolean hasOpenEyeblossom;
        if (this.method_9542(state) && level.method_8597().comp_645() && (hasOpenEyeblossom = this.method_16231() == ModBlocks.OPEN_EYEBLOSSOM.get()) != (isNaturalNight = CreakingHeartBlock.isNaturalNight((class_1937)level))) {
            level.method_8652(pos, this.opposite(state), 3);
            EyeblossomBlock.Type type = EyeblossomBlock.Type.fromBoolean(hasOpenEyeblossom).transform();
            type.spawnTransformParticle(level, pos, random);
            level.method_8396(null, pos, type.longSwitchSound(), class_3419.field_15245, 1.0f, 1.0f);
        }
        super.method_9514(state, level, pos, random);
    }

    public boolean method_9542(class_2680 state) {
        return state.method_27852(ModBlocks.POTTED_OPEN_EYEBLOSSOM.get()) || state.method_27852(ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get());
    }

    private class_2680 opposite(class_2680 state) {
        if (state.method_27852(ModBlocks.POTTED_OPEN_EYEBLOSSOM.get())) {
            return ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get().method_9564();
        }
        return state.method_27852(ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get()) ? ModBlocks.POTTED_OPEN_EYEBLOSSOM.get().method_9564() : state;
    }
}

