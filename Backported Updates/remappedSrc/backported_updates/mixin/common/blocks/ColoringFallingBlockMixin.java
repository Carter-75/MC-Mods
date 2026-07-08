/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_4970$class_2251
 *  net.minecraft.class_5819
 *  net.minecraft.class_8812
 *  org.spongepowered.asm.mixin.Mixin
 */
package backported_updates.mixin.common.blocks;

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_4970;
import net.minecraft.class_5819;
import net.minecraft.class_8812;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value={class_8812.class})
public class ColoringFallingBlockMixin
extends class_2248 {
    public ColoringFallingBlockMixin(class_4970.class_2251 properties) {
        super(properties);
    }

    public void method_9496(class_2680 state, class_1937 level, class_2338 pos, class_5819 random) {
        AmbientDesertBlockSoundsPlayer.playAmbientSandSounds(level, pos, random);
        super.method_9496(state, level, pos, random);
    }
}

