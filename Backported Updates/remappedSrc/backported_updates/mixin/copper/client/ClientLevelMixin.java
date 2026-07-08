/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1113
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_3419
 *  net.minecraft.class_5294
 *  net.minecraft.class_5294$class_5401
 *  net.minecraft.class_638
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
import net.minecraft.class_1113;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_3419;
import net.minecraft.class_5294;
import net.minecraft.class_638;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_638.class})
public abstract class ClientLevelMixin
extends class_1937
implements EndFlashAccessor {
    @Shadow
    @Final
    private class_310 field_3729;
    @Unique
    private EndFlashState copperagebackport$endFlashState;

    @Shadow
    public abstract class_5294 method_28103();

    protected ClientLevelMixin() {
        super(null, null, null, null, null, false, false, 0L, 0);
    }

    @Inject(method={"<init>"}, at={@At(value="RETURN")})
    private void copperagebackport$onInit(CallbackInfo ci) {
        if (this.method_28103().method_29992() == class_5294.class_5401.field_25641) {
            this.copperagebackport$endFlashState = new EndFlashState();
        }
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void copperagebackport$onTick(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
        if (this.copperagebackport$endFlashState != null) {
            this.copperagebackport$endFlashState.tick(this.method_8510());
            if (this.copperagebackport$endFlashState.flashStartedThisTick()) {
                this.field_3729.method_1483().method_4872((class_1113)new DirectionalSoundInstance(ModSounds.WEATHER_END_FLASH.get(), class_3419.field_15252, this.field_9229, this.field_3729.field_1773.method_19418(), this.copperagebackport$endFlashState.getXAngle(), this.copperagebackport$endFlashState.getYAngle()), 30);
            }
        }
    }

    @Override
    @Unique
    public EndFlashState copperagebackport$getEndFlashState() {
        return this.copperagebackport$endFlashState;
    }
}

