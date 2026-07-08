/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.api.behaviour.movement.MovementBehaviour
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.contraptions.Contraption
 *  com.simibubi.create.content.contraptions.OrientedContraptionEntity
 *  com.simibubi.create.content.contraptions.StructureTransform
 *  com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour
 *  com.simibubi.create.content.contraptions.behaviour.MovementContext
 *  com.simibubi.create.content.kinetics.base.BlockBreakingMovementBehaviour
 *  net.createmod.catnip.math.VecHelper
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1688
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2374
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2688
 *  net.minecraft.class_2940
 *  net.minecraft.class_3218
 *  net.minecraft.class_3499$class_3501
 *  net.minecraft.class_3532
 *  org.apache.commons.lang3.tuple.MutablePair
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.entity;

import com.simibubi.create.api.behaviour.movement.MovementBehaviour;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.content.contraptions.OrientedContraptionEntity;
import com.simibubi.create.content.contraptions.StructureTransform;
import com.simibubi.create.content.contraptions.actors.harvester.HarvesterMovementBehaviour;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.kinetics.base.BlockBreakingMovementBehaviour;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1688;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2688;
import net.minecraft.class_2940;
import net.minecraft.class_3218;
import net.minecraft.class_3499;
import net.minecraft.class_3532;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix3d;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.ContraptionWingProvider;
import org.valkyrienskies.core.api.ships.LoadedServerShip;
import org.valkyrienskies.core.api.ships.LoadedShip;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.CompatUtil;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.ShipMountedToData;
import org.valkyrienskies.mod.common.entity.ShipMountedToDataProvider;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.compat.CreateConversionsKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.MixinAbstractContraptionEntityDuck;

@Mixin(value={AbstractContraptionEntity.class})
public abstract class MixinAbstractContraptionEntity
extends class_1297
implements MixinAbstractContraptionEntityDuck,
ContraptionWingProvider,
IEntityDraggingInformationProvider,
ShipMountedToDataProvider {
    @Unique
    private static final Logger LOGGER = LogManager.getLogger("Clockwork.MixinAbstractContraptionEntity");
    @Unique
    private int wingGroupId = -1;
    @Shadow(remap=false)
    protected Contraption contraption;
    @Unique
    private boolean vs$forceStall = false;
    @Shadow
    private boolean skipActorStop;
    @Shadow
    @Final
    private static class_2940<Boolean> STALLED;

    public MixinAbstractContraptionEntity(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Shadow
    protected abstract StructureTransform makeStructureTransform();

    @Override
    public StructureTransform getStructureTransform() {
        return this.makeStructureTransform();
    }

    @Shadow
    public abstract class_243 getPassengerPosition(class_1297 var1, float var2);

    @Shadow
    public abstract class_243 applyRotation(class_243 var1, float var2);

    @Shadow
    public abstract class_243 getAnchorVec();

    @Shadow
    public abstract class_243 getPrevAnchorVec();

    @Override
    @Nullable
    public ShipMountedToData provideShipMountedToData(@NotNull class_1297 passenger, @Nullable Float partialTicks) {
        LoadedShip shipObjectEntityMountedTo = VSGameUtilsKt.getLoadedShipManagingPos(passenger.method_37908(), (Vector3dc)VectorConversionsMCKt.toJOML(this.method_19538()));
        if (shipObjectEntityMountedTo == null) {
            return null;
        }
        class_243 transformedPos = this.getPassengerPosition(passenger, partialTicks == null ? 1.0f : partialTicks.floatValue());
        if (transformedPos == null) {
            transformedPos = this.method_30950(partialTicks == null ? 0.0f : partialTicks.floatValue());
        }
        return new ShipMountedToData(shipObjectEntityMountedTo, VectorConversionsMCKt.toJOML(transformedPos));
    }

    @Redirect(method={"moveCollidedEntitiesOnDisassembly"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setPos(DDD)V"))
    private void redirectSetPos(class_1297 instance, double x, double y, double z) {
        class_243 result2 = CompatUtil.INSTANCE.toSameSpaceAs(instance.method_5770(), x, y, z, instance.method_19538());
        if (instance.method_19538().method_1022(result2) < 20.0) {
            instance.method_5814(result2.field_1352, result2.field_1351, result2.field_1350);
        } else {
            LOGGER.warn("Warning distance too high ignoring setPos request");
        }
    }

    @Redirect(method={"moveCollidedEntitiesOnDisassembly"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;teleportTo(DDD)V"))
    private void redirectTeleportTo(class_1297 instance, double x, double y, double z) {
        class_243 result2 = CompatUtil.INSTANCE.toSameSpaceAs(instance.method_5770(), x, y, z, instance.method_19538());
        if (instance.method_19538().method_1022(result2) < 20.0) {
            if (VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), result2.field_1352, result2.field_1351, result2.field_1350) && instance instanceof class_1688) {
                result2.method_1031(0.0, 0.5, 0.0);
            }
            instance.method_5859(result2.field_1352, result2.field_1351, result2.field_1350);
        } else {
            LOGGER.warn("Warning distance too high ignoring teleportTo request");
        }
    }

    @Inject(method={"toGlobalVector(Lnet/minecraft/world/phys/Vec3;FZ)Lnet/minecraft/world/phys/Vec3;"}, at={@At(value="HEAD")}, cancellable=true)
    private void redirectToGlobalVector(class_243 localVec, float partialTicks, boolean prevAnchor, CallbackInfoReturnable<class_243> cir) {
        if (partialTicks != 1.0f && !prevAnchor) {
            class_243 anchor = this.getAnchorVec();
            class_243 oldAnchor = this.getPrevAnchorVec();
            class_243 lerpedAnchor = new class_243(class_3532.method_16436((double)partialTicks, (double)oldAnchor.field_1352, (double)anchor.field_1352), class_3532.method_16436((double)partialTicks, (double)oldAnchor.field_1351, (double)anchor.field_1351), class_3532.method_16436((double)partialTicks, (double)oldAnchor.field_1350, (double)anchor.field_1350));
            class_243 rotationOffset = VecHelper.getCenterOf((class_2382)class_2338.field_10980);
            localVec = localVec.method_1020(rotationOffset);
            localVec = this.applyRotation(localVec, partialTicks);
            localVec = localVec.method_1019(rotationOffset).method_1019(lerpedAnchor);
            cir.setReturnValue((Object)localVec);
        }
    }

    @Shadow
    public abstract class_243 toGlobalVector(class_243 var1, float var2);

    @Shadow
    public abstract class_243 getPrevPositionVec();

    @Unique
    private boolean vs$shouldMod(MovementBehaviour moveBehaviour) {
        return moveBehaviour instanceof BlockBreakingMovementBehaviour || moveBehaviour instanceof HarvesterMovementBehaviour;
    }

    @Unique
    private class_2338 vs$getTargetPos(MovementBehaviour instance, MovementContext context, class_2338 pos, class_243 actorPosition) {
        Ship ship;
        if (this.vs$shouldMod(instance) && context.world.method_8320(pos).method_26215() && VSGameUtilsKt.isBlockInShipyard(context.world, pos) && (ship = VSGameUtilsKt.getShipManagingPos(context.world, pos)) != null) {
            Vector3d actorPosInWorld = ship.getTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(actorPosition));
            return class_2338.method_49637((double)actorPosInWorld.x(), (double)actorPosInWorld.y(), (double)actorPosInWorld.z());
        }
        return pos;
    }

    @Shadow
    public abstract boolean isStalled();

    @Shadow
    protected abstract boolean shouldActorTrigger(MovementContext var1, class_3499.class_3501 var2, MovementBehaviour var3, class_243 var4, class_2338 var5);

    @Shadow
    protected abstract boolean isActorActive(MovementContext var1, MovementBehaviour var2);

    @Shadow
    protected abstract void onContraptionStalled();

    @Inject(method={"tickActors"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private void preTickActors(CallbackInfo ci) {
        ci.cancel();
        boolean stalledPreviously = this.contraption.stalled;
        if (!this.method_37908().field_9236) {
            this.contraption.stalled = this.vs$forceStall;
        }
        this.skipActorStop = true;
        for (MutablePair pair : this.contraption.getActors()) {
            MovementContext context = (MovementContext)pair.right;
            class_3499.class_3501 blockInfo = (class_3499.class_3501)pair.left;
            MovementBehaviour actor = (MovementBehaviour)MovementBehaviour.REGISTRY.get((class_2688)blockInfo.comp_1342());
            if (actor == null) continue;
            class_243 oldMotion = context.motion;
            class_243 actorPosition = this.toGlobalVector(VecHelper.getCenterOf((class_2382)blockInfo.comp_1341()).method_1019(actor.getActiveAreaOffset(context)), 1.0f);
            class_2338 gridPosition = this.vs$getTargetPos(actor, context, class_2338.method_49638((class_2374)actorPosition), actorPosition);
            boolean newPosVisited = !context.stall && this.shouldActorTrigger(context, blockInfo, actor, actorPosition, gridPosition);
            context.rotation = v -> this.applyRotation((class_243)v, 1.0f);
            context.position = actorPosition;
            if (!this.isActorActive(context, actor) && !actor.mustTickWhileDisabled()) continue;
            if (newPosVisited && !context.stall) {
                actor.visitNewPosition(context, gridPosition);
                if (!this.method_5805()) break;
                context.firstMovement = false;
            }
            if (!oldMotion.equals((Object)context.motion)) {
                actor.onSpeedChanged(context, oldMotion, context.motion);
                if (!this.method_5805()) break;
            }
            actor.tick(context);
            if (!this.method_5805()) break;
            this.contraption.stalled |= context.stall;
        }
        if (!this.method_5805()) {
            this.contraption.stop(this.method_37908());
            return;
        }
        this.skipActorStop = false;
        for (class_1297 entity : this.method_5685()) {
            if (!(entity instanceof OrientedContraptionEntity)) continue;
            OrientedContraptionEntity orientedCE = (OrientedContraptionEntity)entity;
            if (this.contraption.getBearingPosOf(entity.method_5667()) == null || orientedCE.getContraption() == null || !orientedCE.getContraption().stalled) continue;
            this.contraption.stalled = true;
            break;
        }
        if (!this.method_37908().field_9236) {
            if (!stalledPreviously && this.contraption.stalled) {
                this.onContraptionStalled();
            }
            this.field_6011.method_12778(STALLED, (Object)this.contraption.stalled);
            return;
        }
        this.contraption.stalled = this.isStalled();
    }

    @Override
    public void vs$setForceStall(boolean forceStall) {
        this.vs$forceStall = forceStall;
    }

    @Inject(method={"getContactPointMotion"}, at={@At(value="HEAD")})
    private void modGetContactPointMotion(class_243 globalContactPoint, CallbackInfoReturnable<class_243> cir) {
        Ship ship;
        if (VSGameUtilsKt.isBlockInShipyard(this.method_37908(), this.getAnchorVec().field_1352, this.getAnchorVec().field_1351, this.getAnchorVec().field_1350) != VSGameUtilsKt.isBlockInShipyard(this.method_37908(), this.getPrevAnchorVec().field_1352, this.getPrevAnchorVec().field_1351, this.getPrevAnchorVec().field_1350) && (ship = VSGameUtilsKt.getShipManagingPos(this.method_37908(), (class_2374)this.getAnchorVec())) != null) {
            class_243 result2 = VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(this.getPrevPositionVec())));
            this.field_6014 = result2.field_1352;
            this.field_6036 = result2.field_1351;
            this.field_5969 = result2.field_1350;
        }
    }

    @Override
    public int getWingGroupId() {
        return this.wingGroupId;
    }

    @Override
    public void setWingGroupId(int wingGroupId) {
        this.wingGroupId = wingGroupId;
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void postTick(CallbackInfo ci) {
        class_3218 serverLevel;
        LoadedServerShip ship;
        AbstractContraptionEntity thisAsAbstractContraptionEntity = (AbstractContraptionEntity)AbstractContraptionEntity.class.cast(this);
        class_1937 level = thisAsAbstractContraptionEntity.method_37908();
        if (this.wingGroupId != -1 && level instanceof class_3218 && (ship = VSGameUtilsKt.getLoadedShipManagingPos(serverLevel = (class_3218)level, (Vector3dc)VectorConversionsMCKt.toJOML(thisAsAbstractContraptionEntity.method_19538()))) != null) {
            try {
                ship.getWingManager().setWingGroupTransform(this.wingGroupId, this.computeContraptionWingTransform());
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override
    @NotNull
    public Matrix4dc computeContraptionWingTransform() {
        AbstractContraptionEntity thisAsAbstractContraptionEntity = (AbstractContraptionEntity)AbstractContraptionEntity.class.cast(this);
        Matrix3d rotationMatrix = CreateConversionsKt.toJOML(thisAsAbstractContraptionEntity.getRotationState().asMatrix());
        Vector3d pos = VectorConversionsMCKt.toJOML(thisAsAbstractContraptionEntity.getAnchorVec());
        return new Matrix4d(rotationMatrix).setTranslation(pos);
    }

    @Override
    public boolean vs$shouldDrag() {
        return false;
    }
}

