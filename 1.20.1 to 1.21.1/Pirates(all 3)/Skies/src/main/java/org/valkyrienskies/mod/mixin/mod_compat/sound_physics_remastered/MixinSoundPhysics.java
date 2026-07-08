/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.sound_physics_remastered;

import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Pseudo
@Mixin(targets={"com.sonicether.soundphysics.SoundPhysics"}, remap=false)
public abstract class MixinSoundPhysics {
    @Shadow
    public static void onPlaySound(double posX, double posY, double posZ, int sourceID) {
        throw new AssertionError();
    }

    @Inject(at={@At(value="HEAD")}, method={"onPlaySound"}, cancellable=true)
    private static void beforeOnPlaySound(double posX, double posY, double posZ, int sourceID, CallbackInfo ci) {
        class_638 level = class_310.method_1551().field_1687;
        if (level == null) {
            return;
        }
        Ship ship = VSGameUtilsKt.getShipManagingPos((class_1937)level, posX, posY, posZ);
        if (ship instanceof ClientShip) {
            ClientShip ship2 = (ClientShip)ship;
            Vector3d inWorldPos = ship2.getShipToWorld().transformPosition(new Vector3d(posX, posY, posZ));
            MixinSoundPhysics.onPlaySound(inWorldPos.x, inWorldPos.y, inWorldPos.z, sourceID);
            ci.cancel();
        }
    }
}

