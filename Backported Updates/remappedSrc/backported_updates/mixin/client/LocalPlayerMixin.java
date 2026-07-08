/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1113
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  net.minecraft.class_742
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.client;

import backported.updates.content.client.level.sound.RidingHappyGhastSoundInstance;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import com.mojang.authlib.GameProfile;
import net.minecraft.class_1113;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_310;
import net.minecraft.class_638;
import net.minecraft.class_742;
import net.minecraft.class_746;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_746.class})
public abstract class LocalPlayerMixin
extends class_742 {
    @Shadow
    @Final
    protected class_310 field_3937;

    public LocalPlayerMixin(class_638 clientLevel, GameProfile gameProfile) {
        super(clientLevel, gameProfile);
    }

    @Inject(method={"startRiding"}, at={@At(value="HEAD")}, cancellable=true)
    private void onStartRiding(class_1297 vehicle, boolean force, CallbackInfoReturnable<Boolean> cir) {
        if (super.method_5873(vehicle, force) && vehicle instanceof HappyGhast) {
            HappyGhast ghast = (HappyGhast)vehicle;
            this.field_3937.method_1483().method_4873((class_1113)new RidingHappyGhastSoundInstance((class_1657)((class_746)this), ghast));
            cir.setReturnValue((Object)true);
        }
    }
}

