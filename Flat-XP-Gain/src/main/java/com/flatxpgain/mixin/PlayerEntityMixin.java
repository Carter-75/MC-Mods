package com.flatxpgain.mixin;

import com.flatxpgain.FlatXpGain;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerEntityMixin {

    @Shadow public int experienceLevel;

    @Inject(method = "getXpNeededForNextLevel", at = @At("HEAD"), cancellable = true)
    private void customNextLevelExperience(CallbackInfoReturnable<Integer> cir) {
        if (!FlatXpGain.getActiveConfig().modEnabled) {
            return;
        }
        
        if (FlatXpGain.getActiveConfig().flatXpEnabled) {
            cir.setReturnValue(FlatXpGain.getActiveConfig().level1XpCost);
            return;
        }
        
        if (FlatXpGain.getActiveConfig().linearXpEnabled) {
            // Level 1 (expLevel 0) = level1XpCost
            // Level N (expLevel N-1) = level1XpCost + (N-1) * nextXpAddition
            int cost = FlatXpGain.getActiveConfig().level1XpCost + 
                       (this.experienceLevel * FlatXpGain.getActiveConfig().nextXpAddition);
            cir.setReturnValue(cost);
        }
    }
}
