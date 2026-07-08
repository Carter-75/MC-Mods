/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.World
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.client.network.AbstractClientPlayerEntity
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  org.spongepowered.asm.mixin.injection.callback.LocalCapture
 */
package backported_updates.mixin.foundation.client;

import backported.updates.foundation.client.event.FovRendering;
import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(value={AbstractClientPlayerEntity.class})
public abstract class AbstractClientPlayerMixin
extends PlayerEntity {
    public AbstractClientPlayerMixin(World level, BlockPos pos, float yRot, GameProfile gameProfile) {
        super(level, pos, yRot, gameProfile);
    }

    @Inject(method={"getFovMultiplier"}, at={@At(value="RETURN", ordinal=1)}, cancellable=true, locals=LocalCapture.CAPTURE_FAILHARD)
    public void updateFov(CallbackInfoReturnable<Float> cir, float currentFov) {
        float fov = FovRendering.EVENT.invoker().setFov(this, currentFov);
        if (fov != currentFov) {
            cir.setReturnValue(Float.valueOf(fov));
        }
    }
}

