/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1299
 *  net.minecraft.class_1676
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 */
package org.valkyrienskies.mod.mixin.mod_compat.create_big_cannons;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import net.minecraft.class_1299;
import net.minecraft.class_1676;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Pseudo
@Mixin(targets={"rbasamoyai.createbigcannons.munitions.AbstractCannonProjectile"})
public abstract class MixinAbstractCannonProjectile
extends class_1676 {
    protected MixinAbstractCannonProjectile(class_1299<? extends class_1676> p_37248_, class_1937 p_37249_) {
        super(p_37248_, p_37249_);
    }

    @WrapOperation(method={"shouldFall"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;noCollision(Lnet/minecraft/world/phys/AABB;)Z")})
    private boolean mixinNoCollision(class_1937 level, class_238 aabb, Operation<Boolean> original) {
        Stream<Ship> ships = StreamSupport.stream(VSGameUtilsKt.getShipsIntersecting(level, aabb).spliterator(), false);
        return (Boolean)original.call(new Object[]{level, aabb}) != false && ships.allMatch(s -> level.method_18026(VectorConversionsMCKt.toMinecraft(VectorConversionsMCKt.toJOML(aabb).transform(s.getWorldToShip()))));
    }
}

