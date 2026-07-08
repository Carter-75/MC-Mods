/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.SoundInstance
 *  net.minecraft.world.World
 *  net.minecraft.client.MinecraftClient
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.client.render.DimensionEffects
 *  net.minecraft.client.render.DimensionEffects$SkyType
 *  net.minecraft.client.world.ClientWorld
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.copper.client;

import backported.updates.copper.ModSounds;
import backported.updates.copper.client.endflash.DirectionalSoundInstance;
import backported.updates.copper.client.endflash.EndFlashAccessor;
import backported.updates.copper.client.endflash.EndFlashState;
import java.util.function.BooleanSupplier;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.client.render.DimensionEffects;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={ClientWorld.class})
public abstract class ClientLevelMixin
extends World
implements EndFlashAccessor {
    @Shadow
    @Final
    private MinecraftClient client;
    @Unique
    private EndFlashState copperagebackport$endFlashState;

    @Shadow
    public abstract DimensionEffects getDimensionEffects();

    protected ClientLevelMixin() {
        super(null, null, null, null, null, false, false, 0L, 0);
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void copperagebackport$onInit(CallbackInfo ci) {
        if (this.getDimensionEffects().getSkyType() == DimensionEffects.SkyType.END) {
            this.copperagebackport$endFlashState = new EndFlashState();
        }
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void copperagebackport$onTick(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
        if (this.copperagebackport$endFlashState != null) {
            this.copperagebackport$endFlashState.tick(this.getTime());
            if (this.copperagebackport$endFlashState.flashStartedThisTick()) {
                this.client.getSoundManager().play((SoundInstance)new DirectionalSoundInstance(ModSounds.WEATHER_END_FLASH.get(), SoundCategory.WEATHER, this.random, this.client.gameRenderer.getCamera(), this.copperagebackport$endFlashState.getXAngle(), this.copperagebackport$endFlashState.getYAngle()), 30);
            }
        }
    }

    @Override
    @Unique
    public EndFlashState copperagebackport$getEndFlashState() {
        return this.copperagebackport$endFlashState;
    }
}

