/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2256
 *  net.minecraft.class_2311
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_3218
 *  net.minecraft.class_4538
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import backported.updates.content.common.registries.ModBlocks;
import net.minecraft.class_1937;
import net.minecraft.class_2256;
import net.minecraft.class_2311;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_3218;
import net.minecraft.class_4538;
import net.minecraft.class_4970;
import net.minecraft.class_5819;

public class ShortDryGrassBlock
extends class_2311
implements class_2256 {
    public ShortDryGrassBlock(class_4970.class_2251 properties) {
        super(properties);
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        AmbientDesertBlockSoundsPlayer.playAmbientDryGrassSounds(level, pos, random);
    }

    public boolean method_9651(class_4538 level, class_2338 pos, class_2680 state) {
        return true;
    }

    public boolean method_9650(class_1937 level, class_5819 random, class_2338 pos, class_2680 state) {
        return true;
    }

    public void method_9652(class_3218 level, class_5819 random, class_2338 pos, class_2680 state) {
        level.method_8501(pos, ModBlocks.TALL_DRY_GRASS.get().method_9564());
    }
}

