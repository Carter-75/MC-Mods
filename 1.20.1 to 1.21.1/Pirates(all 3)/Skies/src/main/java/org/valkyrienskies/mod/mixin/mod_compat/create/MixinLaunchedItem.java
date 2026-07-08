/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.schematics.cannon.LaunchedItem
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.simibubi.create.content.schematics.cannon.LaunchedItem;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={LaunchedItem.class})
public class MixinLaunchedItem {
    @Shadow
    public class_2338 target;
    @Unique
    public class_2338 valkyrienskies$startPos;

    @Inject(method={"<init>(Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/item/ItemStack;)V"}, at={@At(value="RETURN")})
    private void constructorOne(class_2338 start, class_2338 target, class_1799 stack, CallbackInfo ci) {
        this.valkyrienskies$startPos = start;
    }

    @Inject(method={"Lcom/simibubi/create/content/schematics/cannon/LaunchedItem;update(Lnet/minecraft/world/level/Level;)Z"}, at={@At(value="HEAD")})
    private void injectUpdate(class_1937 world, CallbackInfoReturnable<Boolean> cir) {
        class_2338 estimatePos;
        if (this.valkyrienskies$startPos == null) {
            return;
        }
        LaunchedItem launchedItem = (LaunchedItem)LaunchedItem.class.cast(this);
        LoadedShip targetShip = VSGameUtilsKt.getLoadedShipManagingPos(world, (class_2382)launchedItem.target);
        LoadedShip thisShip = VSGameUtilsKt.getLoadedShipManagingPos(world, (class_2382)this.valkyrienskies$startPos);
        Vector3d newPos = VectorConversionsMCKt.toJOML(launchedItem.target.method_46558());
        if (targetShip == thisShip) {
            return;
        }
        if (targetShip != null) {
            newPos = targetShip.getTransform().getShipToWorld().transformPosition(newPos);
        }
        if (thisShip != null) {
            newPos = thisShip.getTransform().getWorldToShip().transformPosition(newPos);
        }
        if (MixinLaunchedItem.ticksForDistance(this.valkyrienskies$startPos, estimatePos = class_2338.method_49638((class_2374)VectorConversionsMCKt.toMinecraft(newPos))) < launchedItem.totalTicks) {
            launchedItem.ticksRemaining = launchedItem.totalTicks = MixinLaunchedItem.ticksForDistance(this.valkyrienskies$startPos, estimatePos);
        }
    }

    @Shadow
    private static int ticksForDistance(class_2338 start, class_2338 target) {
        return 0;
    }
}

