/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_1657
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2708
 *  net.minecraft.class_2709
 *  net.minecraft.class_2828
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3225
 *  net.minecraft.class_3244
 *  net.minecraft.server.MinecraftServer
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.server.network;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.Collections;
import java.util.Set;
import net.minecraft.class_1657;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2708;
import net.minecraft.class_2709;
import net.minecraft.class_2828;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3225;
import net.minecraft.class_3244;
import net.minecraft.server.MinecraftServer;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.core.internal.world.VsiServerShipWorld;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.config.VSGameConfig;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.mixinducks.world.entity.PlayerDuck;

@Mixin(value={class_3244.class})
public abstract class MixinServerGamePacketListenerImpl {
    @Shadow
    public class_3222 field_14140;
    @Shadow
    private int field_14123;
    @Shadow
    private int field_14118;
    @Shadow
    private class_243 field_14119;
    @Shadow
    private int field_14139;
    @Shadow
    @Final
    private MinecraftServer field_14148;

    @Shadow
    public abstract void method_14364(class_2596<?> var1);

    @ModifyExpressionValue(at={@At(value="FIELD", target="Lnet/minecraft/server/network/ServerGamePacketListenerImpl;aboveGroundTickCount:I", ordinal=0)}, method={"tick"})
    private int noFlyKick(int original) {
        if (VSGameConfig.SERVER.getEnableMovementChecks()) {
            return original;
        }
        return 0;
    }

    @WrapOperation(at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;subtract(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;")}, method={"handleUseItemOn"})
    private class_243 skipDistanceCheck2(class_243 instance, class_243 vec3, Operation<class_243> subtract) {
        return VSGameUtilsKt.toWorldCoordinates(this.field_14140.method_37908(), (class_243)subtract.call(new Object[]{instance, vec3}));
    }

    @WrapOperation(method={"handleMovePlayer"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/network/ServerGamePacketListenerImpl;isSingleplayerOwner()Z")}, require=0)
    private boolean shouldSkipMoveCheck1(class_3244 instance, Operation<Boolean> isSinglePlayerOwner) {
        return !VSGameConfig.SERVER.getEnableMovementChecks();
    }

    @WrapOperation(method={"handleMoveVehicle"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/network/ServerGamePacketListenerImpl;isSingleplayerOwner()Z")}, require=0)
    private boolean shouldSkipMoveCheck2(class_3244 instance, Operation<Boolean> isSinglePlayerOwner) {
        return !VSGameConfig.SERVER.getEnableMovementChecks();
    }

    @WrapOperation(method={"handleMovePlayer"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerPlayerGameMode;isCreative()Z")}, require=0)
    private boolean shouldSkipMoveCheck(class_3225 instance, Operation<Boolean> isSinglePlayerOwner) {
        return !VSGameConfig.SERVER.getEnableMovementChecks();
    }

    @Inject(method={"teleport(DDDFFLjava/util/Set;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void transformTeleport(double x, double y, double z, float yaw, float pitch, Set<class_2709> relativeSet, CallbackInfo ci) {
        if (!VSGameConfig.SERVER.getTransformTeleports()) {
            return;
        }
        class_2338 blockPos = class_2338.method_49637((double)x, (double)y, (double)z);
        ServerShip ship = VSGameUtilsKt.getShipManagingPos((class_3218)this.field_14140.method_37908(), blockPos);
        if (ship != null) {
            Vector3d pos = new Vector3d(x, y, z);
            ship.getShipToWorld().transformPosition(pos);
            this.field_14119 = VectorConversionsMCKt.toMinecraft(pos);
            if (++this.field_14123 == Integer.MAX_VALUE) {
                this.field_14123 = 0;
            }
            this.field_14139 = this.field_14118;
            this.field_14140.method_5641(pos.x, pos.y, pos.z, yaw, pitch);
            this.method_14364((class_2596<?>)new class_2708(pos.x, pos.y, pos.z, yaw, pitch, Collections.emptySet(), this.field_14123));
            ci.cancel();
        }
    }

    @Inject(method={"onDisconnect"}, at={@At(value="HEAD")})
    void onDisconnect(class_2561 reason, CallbackInfo ci) {
        VsiServerShipWorld world = VSGameUtilsKt.getShipObjectWorld(this.field_14148);
        if (world != null) {
            world.onDisconnect(VSGameUtilsKt.getPlayerWrapper((class_1657)this.field_14140));
        }
    }

    @Inject(method={"handleMovePlayer"}, at={@At(value="TAIL")})
    void afterHandleMovePlayer(class_2828 serverboundMovePlayerPacket, CallbackInfo ci) {
        class_3222 class_32222 = this.field_14140;
        if (class_32222 instanceof PlayerDuck) {
            PlayerDuck duck = (PlayerDuck)class_32222;
            duck.vs_setHandledMovePacket(true);
            if (duck.vs_getQueuedPositionUpdate() != null) {
                this.field_14140.method_33574(duck.vs_getQueuedPositionUpdate());
                duck.vs_setQueuedPositionUpdate(null);
            }
        }
    }
}

