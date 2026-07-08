/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.llamalad7.mixinextras.sugar.Share
 *  com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef
 *  com.simibubi.create.content.kinetics.deployer.DeployerFakePlayer
 *  com.simibubi.create.content.kinetics.deployer.DeployerHandler
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2586
 *  net.minecraft.class_3218
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Pseudo
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import com.simibubi.create.content.kinetics.deployer.DeployerFakePlayer;
import com.simibubi.create.content.kinetics.deployer.DeployerHandler;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2586;
import net.minecraft.class_3218;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.world.RaycastUtilsKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.IDeployerBehavior;

@Pseudo
@Mixin(value={DeployerHandler.class})
public abstract class MixinDeployerHandler {
    @ModifyExpressionValue(method={"activateInner"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;add(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;", ordinal=0)})
    private static class_243 setRayOrigin(class_243 original, @Local(argsOnly=true, ordinal=0) DeployerFakePlayer player, @Local(argsOnly=true, ordinal=0) class_243 vec3, @Share(value="mode") LocalBooleanRef place_in_world) {
        class_2586 blockEntity = player.method_37908().method_8321(class_2338.method_49638((class_2374)vec3));
        if (blockEntity instanceof IDeployerBehavior) {
            IDeployerBehavior behavior = (IDeployerBehavior)blockEntity;
            place_in_world.set(behavior.valkyrienskies$get_working_mode().get() == IDeployerBehavior.WorkingMode.IN_WORLD);
        }
        if (place_in_world.get()) {
            return VSGameUtilsKt.toWorldCoordinates(player.method_37908(), original);
        }
        return original;
    }

    @ModifyExpressionValue(method={"activateInner"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;add(Lnet/minecraft/world/phys/Vec3;)Lnet/minecraft/world/phys/Vec3;", ordinal=1)})
    private static class_243 setRayTarget(class_243 original, @Local(argsOnly=true, ordinal=0) DeployerFakePlayer player, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return VSGameUtilsKt.toWorldCoordinates(player.method_37908(), original);
        }
        return original;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;getEntitiesOfClass(Ljava/lang/Class;Lnet/minecraft/world/phys/AABB;)Ljava/util/List;"), index=1)
    private static class_238 aabbToWorld(class_238 par2, @Local(ordinal=0) class_3218 world, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return VSGameUtilsKt.transformAabbToWorld((class_1937)world, par2);
        }
        return par2;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;scale(D)Lnet/minecraft/world/phys/Vec3;", ordinal=1))
    private static double scale(double factor, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return factor + 0.03125;
        }
        return factor;
    }

    @WrapOperation(method={"activateInner"}, at={@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;clip(Lnet/minecraft/world/level/ClipContext;)Lnet/minecraft/world/phys/BlockHitResult;")})
    private static class_3965 clip(class_3218 instance, class_3959 clipContext, Operation<class_3965> original, @Local(argsOnly=true, ordinal=0) class_243 vec, @Local(argsOnly=true, ordinal=1) class_243 extensionVector, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            class_3965 result2 = RaycastUtilsKt.clipIncludeShips((class_1937)instance, clipContext, true);
            if (result2.method_17783() == class_239.class_240.field_1333) {
                return RaycastUtilsKt.clipIncludeShips((class_1937)instance, new class_3959(clipContext.method_17750(), VSGameUtilsKt.toWorldCoordinates((class_1937)instance, vec.method_1019(extensionVector.method_1021(2.484375))), class_3959.class_3960.field_17559, class_3959.class_242.field_1348, null), true);
            }
            return RaycastUtilsKt.clipIncludeShips((class_1937)instance, clipContext, true);
        }
        return (class_3965)original.call(new Object[]{instance, clipContext});
    }

    @ModifyExpressionValue(method={"activateInner"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/phys/BlockHitResult;getBlockPos()Lnet/minecraft/core/BlockPos;")})
    private static class_2338 redirectToTrue(class_2338 original, @Local(argsOnly=true, ordinal=0) class_2338 clickedPos, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return clickedPos;
        }
        return original;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;", ordinal=0), index=0)
    private static class_2338 replace1(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;mayInteract(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;)Z", ordinal=0), index=1)
    private static class_2338 replace2(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/block/state/BlockState;getShape(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/shapes/VoxelShape;", ordinal=0), index=1)
    private static class_2338 replace3(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/foundation/utility/BlockHelper;extinguishFire(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z", ordinal=0), index=2)
    private static class_2338 replace4(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/block/state/BlockState;attack(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;)V", ordinal=0), index=1)
    private static class_2338 replace5(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/block/state/BlockState;getDestroyProgress(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)F", ordinal=0), index=2)
    private static class_2338 replace6(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;playSound(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FF)V", ordinal=0), index=1)
    private static class_2338 replace7(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/deployer/DeployerHandler;tryHarvestBlock(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/server/level/ServerPlayerGameMode;Lnet/minecraft/core/BlockPos;)Z", ordinal=0), index=2)
    private static class_2338 replace8(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;destroyBlockProgress(ILnet/minecraft/core/BlockPos;I)V", ordinal=0), index=1)
    private static class_2338 replace9(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/server/level/ServerLevel;destroyBlockProgress(ILnet/minecraft/core/BlockPos;I)V", ordinal=1), index=1)
    private static class_2338 replace10(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lorg/apache/commons/lang3/tuple/Pair;of(Ljava/lang/Object;Ljava/lang/Object;)Lorg/apache/commons/lang3/tuple/Pair;"), index=0, remap=false)
    private static Object replace11(Object par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/block/state/BlockState;getShape(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/phys/shapes/VoxelShape;", ordinal=1), index=1)
    private static class_2338 replace12(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/deployer/DeployerHandler;safeOnUse(Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/phys/BlockHitResult;)Lnet/minecraft/world/InteractionResult;"), index=2)
    private static class_2338 replace13(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }

    @ModifyArg(method={"activateInner"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/block/BaseFireBlock;canBePlacedAt(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/core/Direction;)Z"), index=1)
    private static class_2338 replace14(class_2338 par1, @Local(ordinal=0) class_3965 result2, @Share(value="mode") LocalBooleanRef original_behaviour) {
        if (original_behaviour.get()) {
            return result2.method_17777();
        }
        return par1;
    }
}

