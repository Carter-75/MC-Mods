/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1101
 *  net.minecraft.class_1102
 *  net.minecraft.class_1937
 *  net.minecraft.class_310
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  net.minecraft.class_5819
 *  org.jspecify.annotations.NonNull
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package org.valkyrienskies.mod.mixin.feature.sound.client;

import net.minecraft.class_1101;
import net.minecraft.class_1102;
import net.minecraft.class_1937;
import net.minecraft.class_310;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_5819;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.client.audio.VelocityTickableSoundInstance;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={class_1101.class})
public abstract class MixinAbstractTickableSoundInstance
extends class_1102
implements VelocityTickableSoundInstance {
    @Unique
    private ClientShip ship;
    @Unique
    private Vector3d worldPosition = null;

    public double method_4784() {
        this.updatePosition();
        return this.worldPosition == null ? this.field_5439 : this.worldPosition.x();
    }

    public double method_4779() {
        this.updatePosition();
        return this.worldPosition == null ? this.field_5450 : this.worldPosition.y();
    }

    public double method_4778() {
        this.updatePosition();
        return this.worldPosition == null ? this.field_5449 : this.worldPosition.z();
    }

    @Override
    public @NonNull Vector3dc getVelocity() {
        return this.ship != null ? this.ship.getVelocity() : new Vector3d();
    }

    @Unique
    private void updatePosition() {
        if (this.worldPosition == null) {
            this.worldPosition = new Vector3d(this.field_5439, this.field_5450, this.field_5449);
        }
        this.ship = (ClientShip)VSGameUtilsKt.getShipManagingPos((class_1937)class_310.method_1551().field_1687, this.field_5439, this.field_5450, this.field_5449);
        if (this.ship != null) {
            this.ship.getRenderTransform().getShipToWorld().transformPosition(this.field_5439, this.field_5450, this.field_5449, this.worldPosition);
        }
    }

    protected MixinAbstractTickableSoundInstance(class_3414 soundEvent, class_3419 soundSource, class_5819 randomSource, Ship ship) {
        super(soundEvent, soundSource, randomSource);
    }
}

