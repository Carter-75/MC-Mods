/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.schematics.SchematicPrinter
 *  com.simibubi.create.content.schematics.cannon.SchematicannonBlockEntity
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_2586
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.blockentity;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.schematics.SchematicPrinter;
import com.simibubi.create.content.schematics.cannon.SchematicannonBlockEntity;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_2586;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.CompatUtil;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={SchematicannonBlockEntity.class})
public class MixinSchematicannonBlockEntity {
    @Redirect(method={"initializePrinter"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/schematics/SchematicPrinter;getAnchor()Lnet/minecraft/core/BlockPos;"))
    private class_2338 redirectGetBlockPos(SchematicPrinter instance) {
        class_2586 thisBE = (class_2586)class_2586.class.cast(this);
        class_2338 original = instance.getAnchor();
        LoadedShip thisShip = VSGameUtilsKt.getShipObjectManagingPos(thisBE.method_10997(), (class_2382)thisBE.method_11016());
        return class_2338.method_49638((class_2374)CompatUtil.INSTANCE.toSameSpaceAs(thisBE.method_10997(), original.method_46558(), (Ship)thisShip));
    }

    @WrapOperation(method={"launchBlock", "launchEntity", "launchBelt"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/schematics/cannon/SchematicannonBlockEntity;getBlockPos()Lnet/minecraft/core/BlockPos;")})
    private class_2338 useTargetSpacePos(SchematicannonBlockEntity instance, Operation<class_2338> original, @Local(argsOnly=true) class_2338 target) {
        return class_2338.method_49638((class_2374)CompatUtil.INSTANCE.toSameSpaceAs(instance.method_10997(), ((class_2338)original.call(new Object[]{instance})).method_46558(), target));
    }
}

