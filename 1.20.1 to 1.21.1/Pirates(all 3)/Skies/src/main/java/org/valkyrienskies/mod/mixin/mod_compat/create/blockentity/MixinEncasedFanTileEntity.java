/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.kinetics.base.KineticBlockEntity
 *  com.simibubi.create.content.kinetics.fan.EncasedFanBlockEntity
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.fan.EncasedFanBlockEntity;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2591;
import net.minecraft.class_2680;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.IExtendedAirCurrentSource;

@Mixin(value={EncasedFanBlockEntity.class})
public abstract class MixinEncasedFanTileEntity
extends KineticBlockEntity
implements IExtendedAirCurrentSource {
    @Unique
    private Ship ship = null;

    public MixinEncasedFanTileEntity(class_2591<?> typeIn, class_2338 pos, class_2680 state) {
        super(typeIn, pos, state);
    }

    public void method_31662(@NotNull class_1937 level) {
        super.method_31662(level);
        this.ship = VSGameUtilsKt.getShipManagingPos(level, this.method_11016());
    }

    @Override
    public Ship getShip() {
        return this.ship;
    }
}

