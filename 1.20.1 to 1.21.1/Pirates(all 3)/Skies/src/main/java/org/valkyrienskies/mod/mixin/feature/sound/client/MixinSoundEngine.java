/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1113
 *  net.minecraft.class_1140
 *  net.minecraft.class_1297
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4227
 *  net.minecraft.class_4235$class_4236
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.feature.sound.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.Map;
import net.minecraft.class_1113;
import net.minecraft.class_1140;
import net.minecraft.class_1297;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4227;
import net.minecraft.class_4235;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.client.audio.VelocityTickableSoundInstance;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.EntityDraggingInformation;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixinducks.com.mojang.blaze3d.audio.HasOpenALVelocity;

@Mixin(value={class_1140.class})
public abstract class MixinSoundEngine {
    @Shadow
    protected abstract float method_4853(class_1113 var1);

    @Shadow
    protected abstract float method_4849(class_1113 var1);

    @WrapOperation(at={@At(value="INVOKE", target="Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;", ordinal=0)}, method={"tickNonPaused"})
    private Object redirectGet(Map<?, ?> instance, Object obj, Operation<Object> get) {
        if (!(obj instanceof VelocityTickableSoundInstance)) {
            return get.call(new Object[]{instance, obj});
        }
        VelocityTickableSoundInstance soundInstance = (VelocityTickableSoundInstance)obj;
        class_4235.class_4236 handle = (class_4235.class_4236)instance.get(soundInstance);
        if (handle == null) {
            return get.call(new Object[]{instance, obj});
        }
        float volume = this.method_4853((class_1113)soundInstance);
        float pitch = this.method_4849((class_1113)soundInstance);
        class_243 vec3 = new class_243(soundInstance.method_4784(), soundInstance.method_4779(), soundInstance.method_4778());
        Vector3dc soundVelocity = soundInstance.getVelocity();
        class_746 player = class_310.method_1551().field_1724;
        Vector3dc velocity = soundInstance.getVelocity();
        handle.method_19735(channel -> {
            channel.method_19647(volume);
            channel.method_19639(pitch);
            channel.method_19641(vec3);
        });
        return null;
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lcom/mojang/blaze3d/audio/Listener;setListenerPosition(Lnet/minecraft/world/phys/Vec3;)V")}, method={"*"})
    private void injectListenerVelocity(class_4227 listener, class_243 position, Operation<Void> setListenerPosition) {
        ClientShip draggingShip;
        EntityDraggingInformation dragInfo;
        ClientShip mounted;
        class_746 player = class_310.method_1551().field_1724;
        class_638 level = class_310.method_1551().field_1687;
        ((HasOpenALVelocity)listener).setVelocity(new Vector3d());
        if (level != null && player != null && (mounted = (ClientShip)VSGameUtilsKt.getShipMountedTo((class_1297)player)) == null && (dragInfo = ((IEntityDraggingInformationProvider)player).getDraggingInformation()).isEntityBeingDraggedByAShip() && dragInfo.getLastShipStoodOn() != null && (draggingShip = (ClientShip)VSGameUtilsKt.getShipObjectWorld(level).getLoadedShips().getById(dragInfo.getLastShipStoodOn())) != null) {
            Vector3d playerPosInShip = VectorConversionsMCKt.toJOML(player.method_19538()).sub(draggingShip.getRenderTransform().getPositionInWorld());
            Vector3d vector3d = draggingShip.getAngularVelocity().cross(playerPosInShip, new Vector3d()).add(draggingShip.getVelocity());
        }
        setListenerPosition.call(new Object[]{listener, position});
    }
}

