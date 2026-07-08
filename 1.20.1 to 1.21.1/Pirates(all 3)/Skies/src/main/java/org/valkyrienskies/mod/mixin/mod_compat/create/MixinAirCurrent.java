/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  com.llamalad7.mixinextras.sugar.Local
 *  com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour
 *  com.simibubi.create.content.kinetics.fan.AirCurrent
 *  com.simibubi.create.content.kinetics.fan.IAirCurrentSource
 *  com.simibubi.create.content.kinetics.fan.processing.FanProcessingType
 *  com.simibubi.create.foundation.blockEntity.behaviour.BehaviourType
 *  com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_259
 *  net.minecraft.class_2680
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3965
 *  org.apache.commons.lang3.tuple.Pair
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.belt.behaviour.TransportedItemStackHandlerBehaviour;
import com.simibubi.create.content.kinetics.fan.AirCurrent;
import com.simibubi.create.content.kinetics.fan.IAirCurrentSource;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.blockEntity.behaviour.BehaviourType;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_259;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.apache.commons.lang3.tuple.Pair;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.entity.handling.DefaultShipyardEntityHandler;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;
import org.valkyrienskies.mod.compat.create.AdvancedAirCurrentSegment;
import org.valkyrienskies.mod.compat.create.AirFlowClipContext;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.IExtendedAirCurrentSource;
import org.valkyrienskies.mod.util.AdvancedBlockWalker;

@Mixin(value={AirCurrent.class})
public abstract class MixinAirCurrent {
    @Unique
    private static final boolean[] FALSE_THEN_TRUE = new boolean[]{false, true};
    @Unique
    private static final double NON_BLOCK_EXTEND = 0.03125;
    @Unique
    private static final double EPS1 = 1.0E-6;
    @Unique
    private static final double EPS2 = 2.0E-6;
    @Unique
    private static final double EPS3 = 4.0E-6;
    @Shadow
    @Final
    public IAirCurrentSource source;
    @Shadow
    public class_2350 direction;
    @Shadow
    public boolean pushing;
    @Shadow
    public float maxDistance;
    @Shadow
    protected List<Pair<TransportedItemStackHandlerBehaviour, FanProcessingType>> affectedItemHandlers;
    @Unique
    private double shipScale = 1.0;
    @Unique
    private FanProcessingType initialProcessingType = null;
    @Unique
    private List<AdvancedAirCurrentSegment> segments = new ArrayList<AdvancedAirCurrentSegment>();

    @Shadow
    private static boolean shouldAlwaysPass(class_2680 state) {
        return false;
    }

    @Shadow
    protected abstract int getLimit();

    @Unique
    private Ship getShip() {
        IAirCurrentSource iAirCurrentSource = this.source;
        if (iAirCurrentSource instanceof IExtendedAirCurrentSource) {
            IExtendedAirCurrentSource se = (IExtendedAirCurrentSource)iAirCurrentSource;
            return se.getShip();
        }
        if (this.source.getAirCurrentWorld() != null) {
            return VSGameUtilsKt.getShipManagingPos(this.source.getAirCurrentWorld(), this.source.getAirCurrentPos());
        }
        return null;
    }

    @Inject(method={"getFlowLimit"}, at={@At(value="RETURN")}, cancellable=true, remap=false)
    private static void clipFlowLimit(class_1937 level, class_2338 start, float originalMax, class_2350 facing, CallbackInfoReturnable<Float> cir) {
        float flowLimit = ((Float)cir.getReturnValue()).floatValue();
        Ship ship = VSGameUtilsKt.getShipManagingPos(level, start);
        if (ship != null) {
            class_2338 pos;
            Vector3d startVec = new Vector3d(start.method_10263(), start.method_10264(), start.method_10260());
            Vector3d direction = VectorConversionsMCKt.toJOMLD(facing.method_10163());
            startVec.add(0.5, 0.5, 0.5).add(direction.mul(0.5, new Vector3d()));
            ship.getTransform().getShipToWorld().transformPosition(startVec);
            ship.getTransform().getShipToWorld().transformDirection(direction);
            Vector3dc scaling = ship.getTransform().getShipToWorldScaling();
            double shipScale = facing.method_10166().method_10172(scaling.x(), scaling.y(), scaling.z());
            direction.mul(flowLimit);
            class_243 startPos = VectorConversionsMCKt.toMinecraft(startVec);
            class_243 endPos = VectorConversionsMCKt.toMinecraft(startVec.add(direction.x, direction.y, direction.z));
            class_3965 result2 = level.method_17742((class_3959)new AirFlowClipContext(level, start, startPos, endPos, MixinAirCurrent::shouldAlwaysPass));
            double limit = result2.method_17784().method_1022(startPos) / shipScale + 2.0E-6;
            if (result2.method_17783() == class_239.class_240.field_1332 && level.method_8320(pos = result2.method_17777()).method_26220((class_1922)level, pos) != class_259.method_1077()) {
                limit += 0.03125;
            }
            cir.setReturnValue((Object)Float.valueOf((float)limit));
            return;
        }
        class_2338 end = start.method_10079(facing, (int)Math.ceil(flowLimit));
        if (VSGameUtilsKt.getShipsIntersecting(level, new class_238((double)start.method_10263(), (double)start.method_10264(), (double)start.method_10260(), (double)(end.method_10263() + 1), (double)(end.method_10264() + 1), (double)(end.method_10260() + 1))).iterator().hasNext()) {
            class_2338 pos;
            class_243 startPos = class_243.method_24953((class_2382)start).method_1031((double)facing.method_10148() * 0.5, (double)facing.method_10164() * 0.5, (double)facing.method_10165() * 0.5);
            class_243 endPos = class_243.method_24953((class_2382)end).method_1031((double)facing.method_10148() * 0.5, (double)facing.method_10164() * 0.5, (double)facing.method_10165() * 0.5);
            class_3965 result3 = level.method_17742((class_3959)new AirFlowClipContext(level, start, startPos, endPos, MixinAirCurrent::shouldAlwaysPass));
            double limit = result3.method_17784().method_1022(startPos) + 2.0E-6;
            if (result3.method_17783() == class_239.class_240.field_1332 && level.method_8320(pos = result3.method_17777()).method_26220((class_1922)level, pos) != class_259.method_1077()) {
                limit += 0.03125;
            }
            cir.setReturnValue((Object)Float.valueOf(Math.min((float)limit, flowLimit)));
        }
    }

    @Inject(method={"rebuild"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/fan/IAirCurrentSource;getAirCurrentWorld()Lnet/minecraft/world/level/Level;", remap=true)}, remap=false)
    private void calcScaling(CallbackInfo ci) {
        Ship ship = this.getShip();
        if (ship != null) {
            Vector3dc scaling = ship.getTransform().getShipToWorldScaling();
            this.shipScale = this.direction.method_10166().method_10172(scaling.x(), scaling.y(), scaling.z());
        }
    }

    @Inject(method={"rebuild"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/fan/AirCurrent;getLimit()I")}, remap=false)
    private void stealInitialType(CallbackInfo ci, @Local(name={"type"}) FanProcessingType type) {
        this.initialProcessingType = type;
    }

    @Inject(method={"rebuild"}, at={@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/fan/AirCurrent;findAffectedHandlers()V")}, remap=false)
    private void calcSegments(CallbackInfo ci) {
        this.segments.clear();
        class_1937 level = this.source.getAirCurrentWorld();
        class_2338 start = this.source.getAirCurrentPos();
        class_243 startCenter = start.method_46558();
        AdvancedAirCurrentSegment currentSegment = null;
        FanProcessingType type = this.initialProcessingType;
        int limit = this.getLimit();
        class_243 delta = new class_243((double)this.direction.method_10148() * 0.5, (double)this.direction.method_10164() * 0.5, (double)this.direction.method_10165() * 0.5);
        class_243 startPos = startCenter.method_1019(delta);
        class_243 endPos = startCenter.method_43206(this.direction, (double)this.maxDistance).method_1019(delta);
        AdvancedBlockWalker walker = new AdvancedBlockWalker(level, startPos, endPos, !this.pushing, true);
        while (walker.hasNext()) {
            AdvancedBlockWalker.BlockPosWithDistance data = walker.next();
            FanProcessingType newType = FanProcessingType.getAt((class_1937)level, (class_2338)data.pos());
            double dist = data.distance();
            if (dist < 2.147483647E9 && Math.abs(dist - (double)((int)dist)) < 1.0E-6) {
                dist = (int)dist;
            }
            if (newType != null) {
                type = newType;
            }
            if (currentSegment == null) {
                currentSegment = new AdvancedAirCurrentSegment();
                currentSegment.startOffset = dist;
                currentSegment.type = type;
                continue;
            }
            if (currentSegment.type == type) continue;
            currentSegment.endOffset = dist;
            this.segments.add(currentSegment);
            currentSegment = new AdvancedAirCurrentSegment();
            currentSegment.startOffset = dist;
            currentSegment.type = type;
        }
        if (currentSegment != null) {
            currentSegment.endOffset = this.pushing ? (double)limit : 0.0;
            this.segments.add(currentSegment);
        }
    }

    @WrapOperation(method={"tickAffectedEntities"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;position()Lnet/minecraft/world/phys/Vec3;")})
    private class_243 transformEntityPos(class_1297 instance, Operation<class_243> original) {
        class_243 result2 = (class_243)original.call(new Object[]{instance});
        Ship ship = this.getShip();
        if (ship == null || VSEntityManager.INSTANCE.getHandler(instance) instanceof DefaultShipyardEntityHandler) {
            return result2;
        }
        Vector3d sourcePos = VectorConversionsMCKt.toJOML(this.source.getAirCurrentPos().method_46558());
        Vector3d naiveEntityPos = ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(result2));
        Vector3d distanceFromSource = VectorConversionsMCKt.toJOML(this.source.getAirCurrentPos().method_46558()).sub(naiveEntityPos);
        Vector3d adjustedEntityPos = sourcePos.sub(distanceFromSource.div(this.shipScale, new Vector3d()), new Vector3d());
        return VectorConversionsMCKt.toMinecraft(adjustedEntityPos);
    }

    @ModifyArg(method={"tickAffectedEntities"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/kinetics/fan/processing/FanProcessingType;spawnProcessingParticles(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/phys/Vec3;)V"), index=1)
    private class_243 useRealEntityPosition(class_243 pos, @Local class_1297 entity) {
        return entity.method_19538();
    }

    @Redirect(method={"tickAffectedEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/AABB;intersects(Lnet/minecraft/world/phys/AABB;)Z"))
    private boolean redirectIntersects(class_238 entityAABB, class_238 boundsAABB) {
        Ship ship = this.getShip();
        if (ship == null) {
            return entityAABB.method_994(boundsAABB);
        }
        AABBd entityInShipAABB = VectorConversionsMCKt.toJOML(entityAABB).transform(ship.getWorldToShip());
        AABBd boundsInWorldAABB = VectorConversionsMCKt.toJOML(boundsAABB).transform(ship.getShipToWorld());
        return boundsAABB.method_1003(entityInShipAABB.minX, entityInShipAABB.minY, entityInShipAABB.minZ, entityInShipAABB.maxX, entityInShipAABB.maxY, entityInShipAABB.maxZ) && entityAABB.method_1003(boundsInWorldAABB.minX, boundsInWorldAABB.minY, boundsInWorldAABB.minZ, boundsInWorldAABB.maxX, boundsInWorldAABB.maxY, boundsInWorldAABB.maxZ);
    }

    @WrapOperation(method={"tickAffectedEntities"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V")})
    private void redirectSetDeltaMovement(class_1297 instance, class_243 motion, Operation<Void> original, @Local(ordinal=2) float acceleration, @Local(ordinal=3) float maxAcceleration, @Local(ordinal=0) class_2382 flow) {
        Ship ship = this.getShip();
        if (ship != null && !(VSEntityManager.INSTANCE.getHandler(instance) instanceof DefaultShipyardEntityHandler)) {
            Vector3d tempVec = new Vector3d();
            ship.getTransform().getShipToWorld().transformDirection((double)flow.method_10263(), (double)flow.method_10264(), (double)flow.method_10260(), tempVec);
            class_243 transformedFlow = VectorConversionsMCKt.toMinecraft(tempVec);
            class_243 previousMotion = instance.method_18798();
            double xIn = class_3532.method_15350((double)(transformedFlow.field_1352 * (double)acceleration - previousMotion.field_1352), (double)(-maxAcceleration), (double)maxAcceleration);
            double yIn = class_3532.method_15350((double)(transformedFlow.field_1351 * (double)acceleration - previousMotion.field_1351), (double)(-maxAcceleration), (double)maxAcceleration);
            double zIn = class_3532.method_15350((double)(transformedFlow.field_1350 * (double)acceleration - previousMotion.field_1350), (double)(-maxAcceleration), (double)maxAcceleration);
            motion = previousMotion.method_1019(new class_243(xIn, yIn, zIn).method_1021(0.125));
        }
        original.call(new Object[]{instance, motion});
    }

    @Inject(method={"findAffectedHandlers"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private void findAffectedHandlers(CallbackInfo ci) {
        ci.cancel();
        this.affectedItemHandlers.clear();
        class_1937 level = this.source.getAirCurrentWorld();
        class_2338 start = this.source.getAirCurrentPos();
        class_243 startCenter = start.method_46558();
        ArrayList<AdvancedBlockWalker.BlockPosWithDistance> datas = new ArrayList<AdvancedBlockWalker.BlockPosWithDistance>();
        class_243 delta = new class_243((double)this.direction.method_10148() * 0.5, (double)this.direction.method_10164() * 0.5, (double)this.direction.method_10165() * 0.5);
        class_243 startPos = startCenter.method_1019(delta);
        class_243 endPos = startCenter.method_43206(this.direction, (double)this.maxDistance).method_1019(delta);
        AdvancedBlockWalker walker = new AdvancedBlockWalker(level, startPos, endPos, !this.pushing, false);
        while (walker.hasNext()) {
            datas.add(walker.next());
        }
        HashSet<class_2338> processed = new HashSet<class_2338>();
        for (boolean checkBelow : FALSE_THEN_TRUE) {
            for (AdvancedBlockWalker.BlockPosWithDistance data : datas) {
                class_2338 pos = checkBelow ? data.pos().method_10074() : data.pos();
                TransportedItemStackHandlerBehaviour behaviour = (TransportedItemStackHandlerBehaviour)BlockEntityBehaviour.get((class_1922)level, (class_2338)pos, (BehaviourType)TransportedItemStackHandlerBehaviour.TYPE);
                if (behaviour == null) continue;
                double dist = data.distance() + 4.0E-6;
                if (dist < 2.147483647E9 && Math.abs(dist - (double)((int)dist)) < 1.0E-6) {
                    dist = (int)dist;
                }
                if (dist > (double)this.maxDistance || !processed.add(pos)) continue;
                FanProcessingType type = FanProcessingType.getAt((class_1937)level, (class_2338)pos);
                if (type == null) {
                    type = this.getTypeAt0(dist);
                }
                this.affectedItemHandlers.add((Pair<TransportedItemStackHandlerBehaviour, FanProcessingType>)Pair.of((Object)behaviour, (Object)type));
            }
        }
    }

    @Inject(method={"getTypeAt"}, at={@At(value="HEAD")}, cancellable=true, remap=false)
    private void getTypeAt(float offset, CallbackInfoReturnable<FanProcessingType> cir) {
        cir.setReturnValue((Object)this.getTypeAt0(offset));
    }

    @Unique
    private FanProcessingType getTypeAt0(double offset) {
        if (offset < 2.147483647E9 && Math.abs(offset - (double)((int)offset)) < 1.0E-6) {
            offset = (int)offset;
        }
        if (offset < 0.0 || offset > (double)this.maxDistance) {
            return null;
        }
        if (this.pushing) {
            for (AdvancedAirCurrentSegment segment : this.segments) {
                if (!(offset <= segment.endOffset)) continue;
                return segment.type;
            }
        } else {
            for (AdvancedAirCurrentSegment segment : this.segments) {
                if (!(offset >= segment.endOffset)) continue;
                return segment.type;
            }
        }
        return null;
    }
}

