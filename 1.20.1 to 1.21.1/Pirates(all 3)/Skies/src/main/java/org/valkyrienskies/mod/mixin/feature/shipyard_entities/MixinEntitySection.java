/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_238
 *  net.minecraft.class_5568
 *  net.minecraft.class_5572
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package org.valkyrienskies.mod.mixin.feature.shipyard_entities;

import net.minecraft.class_238;
import net.minecraft.class_5568;
import net.minecraft.class_5572;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.hooks.VSGameEvents;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixinducks.world.OfShip;

@Mixin(value={class_5572.class})
public class MixinEntitySection
implements OfShip {
    @Unique
    private Ship ofShip;

    @Override
    public Ship getShip() {
        return this.ofShip;
    }

    @Override
    public void setShip(Ship ship) {
        this.ofShip = ship;
        if (ship != null) {
            VSGameEvents.INSTANCE.getEntitySectionSetShip().emit(new VSGameEvents.EntitySectionSetShip((class_5572<class_5568>)((class_5572)class_5572.class.cast(this)), ship));
        }
    }

    @ModifyVariable(method={"getEntities(Lnet/minecraft/world/phys/AABB;Lnet/minecraft/util/AbortableIterationConsumer;)Lnet/minecraft/util/AbortableIterationConsumer$Continuation;"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    class_238 modifyAABB1(class_238 aabb) {
        if (this.ofShip != null) {
            return VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.toJOML(aabb).transform(this.ofShip.getWorldToShip()));
        }
        return aabb;
    }

    @ModifyVariable(method={"getEntities(Lnet/minecraft/world/level/entity/EntityTypeTest;Lnet/minecraft/world/phys/AABB;Lnet/minecraft/util/AbortableIterationConsumer;)Lnet/minecraft/util/AbortableIterationConsumer$Continuation;"}, at=@At(value="HEAD"), ordinal=0, argsOnly=true)
    class_238 modifyAABB2(class_238 aabb) {
        if (this.ofShip != null) {
            return VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.toJOML(aabb).transform(this.ofShip.getWorldToShip()));
        }
        return aabb;
    }
}

