/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_2311
 *  net.minecraft.class_2338
 *  net.minecraft.class_2680
 *  net.minecraft.class_5819
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.blocks;

import backported.updates.content.client.level.sound.AmbientDesertBlockSoundsPlayer;
import backported_updates.mixin.common.blocks.BlockMixin;
import net.minecraft.class_1937;
import net.minecraft.class_2311;
import net.minecraft.class_2338;
import net.minecraft.class_2680;
import net.minecraft.class_5819;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_2311.class})
public class DeadBushBlockMixin
extends BlockMixin {
    @Override
    public void vb$onAnimateTick(class_2680 state, class_1937 level, class_2338 pos, class_5819 random, CallbackInfo ci) {
        AmbientDesertBlockSoundsPlayer.playAmbientDeadBushSounds(level, pos, random);
    }
}

