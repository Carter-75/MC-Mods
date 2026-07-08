/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_4738
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_2487
 *  net.minecraft.class_2709
 *  net.minecraft.class_3218
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.feature.shipyard_entities;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.Set;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2487;
import net.minecraft.class_2709;
import net.minecraft.class_3218;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.common.entity.handling.WorldEntityHandler;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={class_1297.class})
public abstract class MixinEntity {
    @Unique
    private boolean isModifyingSetPos = false;
    @Unique
    private boolean isModifyingTeleport = false;
    @Shadow
    public class_1937 field_6002;

    @Shadow
    public abstract class_1937 method_37908();

    @Shadow
    public abstract void method_23327(double var1, double var3, double var5);

    @Shadow
    public abstract void method_24201(class_1297 var1);

    @Shadow
    public abstract void method_5859(double var1, double var3, double var5);

    @Shadow
    public abstract boolean method_48105(class_3218 var1, double var2, double var4, double var6, Set<class_2709> var8, float var9, float var10);

    @Shadow
    public abstract class_1299<?> method_5864();

    @WrapOperation(method={"positionRider(Lnet/minecraft/world/entity/Entity;)V"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;positionRider(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/entity/Entity$MoveFunction;)V")})
    private void positionRider(class_1297 instance, class_1297 passengerI, class_1297.class_4738 callback, Operation<Void> positionRider) {
        positionRider.call(new Object[]{instance, passengerI, (passenger, x, y, z) -> VSEntityManager.INSTANCE.getHandler(passenger).positionSetFromVehicle(passenger, (class_1297)class_1297.class.cast(this), x, y, z)});
    }

    @Inject(method={"setPosRaw"}, at={@At(value="HEAD")}, cancellable=true)
    private void handlePosSet(double x, double y, double z, CallbackInfo ci) {
        class_1937 level = this.method_37908();
        if (!class_1657.class.isInstance(this) || level == null || this.isModifyingSetPos || !VSGameUtilsKt.isBlockInShipyard(level, x, y, z)) {
            return;
        }
        Ship ship = VSGameUtilsKt.getShipManagingPos(level, x, y, z);
        if (ship != null) {
            this.isModifyingSetPos = true;
            WorldEntityHandler.INSTANCE.moveEntityFromShipyardToWorld((class_1297)class_1297.class.cast(this), ship, x, y, z);
            this.isModifyingSetPos = false;
            ci.cancel();
        }
    }

    @Inject(at={@At(value="HEAD")}, method={"teleportTo(DDD)V"}, cancellable=true)
    private void beforeTeleportTo(double d2, double e2, double f2, CallbackInfo ci) {
        if (this.isModifyingTeleport) {
            return;
        }
        ci.cancel();
        this.isModifyingTeleport = true;
        Vector3d pos = VSEntityManager.INSTANCE.getHandler((class_1297)class_1297.class.cast(this)).getTeleportPos((class_1297)class_1297.class.cast(this), new Vector3d(d2, e2, f2));
        this.method_5859(pos.x, pos.y, pos.z);
        this.isModifyingTeleport = false;
    }

    @Inject(at={@At(value="HEAD")}, method={"teleportTo(Lnet/minecraft/server/level/ServerLevel;DDDLjava/util/Set;FF)Z"}, cancellable=true)
    private void beforeTeleportTo(class_3218 serverLevel, double d2, double e2, double f2, Set<class_2709> set, float g2, float h2, CallbackInfoReturnable<Boolean> ci) {
        if (this.isModifyingTeleport) {
            return;
        }
        ci.cancel();
        this.isModifyingTeleport = true;
        Vector3d pos = VSEntityManager.INSTANCE.getHandler((class_1297)class_1297.class.cast(this)).getTeleportPos((class_1297)class_1297.class.cast(this), new Vector3d(d2, e2, f2));
        this.method_48105(serverLevel, pos.x, pos.y, pos.z, set, g2, h2);
        this.isModifyingTeleport = false;
    }

    @ModifyExpressionValue(method={"saveWithoutId"}, at={@At(value="FIELD", target="Lnet/minecraft/world/entity/Entity;vehicle:Lnet/minecraft/world/entity/Entity;")})
    private class_1297 preventSavingVehiclePosAsOurPos(class_1297 originalVehicle) {
        int vehicleChunkZ;
        if (originalVehicle == null) {
            return null;
        }
        int vehicleChunkX = (int)originalVehicle.method_19538().method_10216() >> 4;
        boolean isVehicleInShipyard = VSGameUtilsKt.isChunkInShipyard(this.field_6002, vehicleChunkX, vehicleChunkZ = (int)originalVehicle.method_19538().method_10215() >> 4);
        if (isVehicleInShipyard) {
            return null;
        }
        return originalVehicle;
    }

    @Inject(method={"setRemoved"}, at={@At(value="HEAD")})
    private void preSetRemoved(class_1297.class_5529 removalReason, CallbackInfo ci) {
        class_1297 thisAsEntity = (class_1297)class_1297.class.cast(this);
        LoadedShip ship = VSGameUtilsKt.getLoadedShipManagingPos(thisAsEntity.method_37908(), (Vector3dc)VectorConversionsMCKt.toJOML(thisAsEntity.method_19538()));
        if (ship != null) {
            VSEntityManager.INSTANCE.getHandler(thisAsEntity).entityRemovedFromShipyard(thisAsEntity, ship);
        }
    }

    @Inject(method={"move"}, at={@At(value="HEAD")})
    void leaveShipyard(CallbackInfo ci) {
        class_1297 e2 = (class_1297)class_1297.class.cast(this);
        Ship ship = VSGameUtilsKt.getShipManaging(e2);
        if (ship != null) {
            AABBic shipAABBi = ship.getShipAABB();
            if (shipAABBi == null || !shipAABBi.isValid()) {
                WorldEntityHandler.INSTANCE.moveEntityFromShipyardToWorld((class_1297)class_1297.class.cast(this), ship);
                return;
            }
            class_238 eBB = e2.method_5829();
            class_238 shipAABB = new class_238((double)shipAABBi.minX(), (double)shipAABBi.minY(), (double)shipAABBi.minZ(), (double)shipAABBi.maxX(), (double)shipAABBi.maxY(), (double)shipAABBi.maxZ()).method_1009(-0.25, 1.5, -0.25);
            if (!shipAABB.method_994(eBB) && (double)e2.field_28627 > 0.05) {
                WorldEntityHandler.INSTANCE.moveEntityFromShipyardToWorld((class_1297)class_1297.class.cast(this), ship);
            }
        }
    }

    @Shadow
    protected abstract void method_5865(class_1297 var1, class_1297.class_4738 var2);

    @WrapMethod(method={"load"})
    private void loadShipyard(class_2487 compoundTag, Operation<Void> original) {
        this.isModifyingSetPos = true;
        original.call(new Object[]{compoundTag});
        this.isModifyingSetPos = false;
    }
}

