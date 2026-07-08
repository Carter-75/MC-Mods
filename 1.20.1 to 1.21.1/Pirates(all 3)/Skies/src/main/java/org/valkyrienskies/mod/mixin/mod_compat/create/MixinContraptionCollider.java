/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity$ContraptionRotationState
 *  com.simibubi.create.content.contraptions.ContraptionCollider
 *  com.simibubi.create.foundation.collision.Matrix3d
 *  javax.annotation.Nullable
 *  net.createmod.catnip.math.VecHelper
 *  net.minecraft.class_1297
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.ContraptionCollider;
import com.simibubi.create.foundation.collision.Matrix3d;
import javax.annotation.Nullable;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.class_1297;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joml.Vector3d;
import org.joml.primitives.AABBd;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.IEntityDraggingInformationProvider;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Mixin(value={ContraptionCollider.class})
public abstract class MixinContraptionCollider {
    @Unique
    private static final Logger LOGGER = LogManager.getLogger("Clockwork.MixinContraptionCollider");
    @Unique
    private static AbstractContraptionEntity contraptionEnt;
    @Unique
    private static AbstractContraptionEntity hDFTContraptionEntity;
    @Unique
    private static AbstractContraptionEntity bounceEntityContraptionEntity;

    @Shadow
    static class_243 collide(class_243 p_20273_, class_1297 e2) {
        return p_20273_;
    }

    @Unique
    private static class_238 entityGetBoundingBox(AbstractContraptionEntity abstractContraptionEntity, class_1297 instance) {
        Ship ship;
        class_238 tempAabb = instance.method_5829();
        if (!VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), instance.method_24515()) && VSGameUtilsKt.isBlockInShipyard(contraptionEnt.method_5770(), class_2338.method_49638((class_2374)contraptionEnt.getAnchorVec())) && (ship = VSGameUtilsKt.getShipManagingPos(instance.method_5770(), (class_2374)contraptionEnt.getAnchorVec())) != null) {
            AABBd temp = new AABBd();
            temp.set(VectorConversionsMCKt.toJOML(tempAabb)).transform(ship.getWorldToShip());
            tempAabb = VectorConversionsMCKt.toMinecraft(temp);
        }
        return tempAabb;
    }

    @Unique
    private static class_243 entityPosition(AbstractContraptionEntity abstractContraptionEntity, class_1297 instance, boolean old) {
        Ship ship;
        class_243 tempVec;
        class_243 class_2432 = tempVec = old ? new class_243(instance.field_6014, instance.field_6036, instance.field_5969) : instance.method_19538();
        if (!VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), instance.method_24515()) && VSGameUtilsKt.isBlockInShipyard(abstractContraptionEntity.method_5770(), class_2338.method_49638((class_2374)abstractContraptionEntity.getAnchorVec())) && (ship = VSGameUtilsKt.getShipManagingPos(abstractContraptionEntity.method_5770(), abstractContraptionEntity.getContraption().anchor)) != null) {
            Vector3d translatedPos = ship.getTransform().getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(tempVec));
            tempVec = VectorConversionsMCKt.toMinecraft(translatedPos);
        }
        return tempVec;
    }

    @Unique
    private static class_243 getSetEntityDeltaMovement(AbstractContraptionEntity abstractContraptionEntity, class_1297 instance, @Nullable class_243 motion) {
        Ship ship;
        class_243 tempVec = instance.method_18798();
        if (!VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), instance.method_24515()) && VSGameUtilsKt.isBlockInShipyard(abstractContraptionEntity.method_5770(), new class_2338((class_2382)abstractContraptionEntity.getContraption().anchor)) && (ship = VSGameUtilsKt.getShipManagingPos(instance.method_5770(), abstractContraptionEntity.getContraption().anchor)) != null) {
            if (motion != null) {
                motion = !VSGameUtilsKt.isBlockInShipyard(abstractContraptionEntity.method_5770(), class_2338.method_49638((class_2374)abstractContraptionEntity.getAnchorVec())) ? VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformDirection(VectorConversionsMCKt.toJOML(motion))) : VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformDirection(VectorConversionsMCKt.toJOML(motion)));
                ((IEntityDraggingInformationProvider)instance).getDraggingInformation().setLastShipStoodOn(ship.getId());
                instance.method_18799(motion);
                motion = null;
            }
            tempVec = VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformDirection(VectorConversionsMCKt.toJOML(tempVec)));
        }
        if (motion != null) {
            instance.method_18799(motion);
        }
        return tempVec;
    }

    @Inject(method={"collideEntities"}, at={@At(value="HEAD")}, remap=false)
    private static void injectHead(AbstractContraptionEntity contraptionEntity, CallbackInfo ci) {
        contraptionEnt = contraptionEntity;
    }

    private static void warn1(Vector3d vec3) {
        LOGGER.warn("Warning setPosDistance too high ignoring setPos request [" + vec3.x + "," + vec3.y + "," + vec3.z + "]");
    }

    private static void warn2(double x, double y, double z) {
        LOGGER.warn("Warning DEFAULT setPosDistance too high ignoring setPos request [" + x + "," + y + "," + z + "]");
    }

    private static void setOfPos(AbstractContraptionEntity abstractContraptionEntity, class_1297 instance, double x, double y, double z) {
        if (VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), class_2338.method_49637((double)x, (double)y, (double)z)) && !VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), instance.method_24515())) {
            Ship ship = VSGameUtilsKt.getShipManagingPos(instance.method_5770(), abstractContraptionEntity.getContraption().anchor);
            if (ship != null) {
                Vector3d newPos = new Vector3d(x, y, z);
                ship.getShipToWorld().transformPosition(newPos, newPos);
                if (instance.method_19538().method_1022(VectorConversionsMCKt.toMinecraft(newPos)) < 20.0) {
                    instance.method_5814(newPos.x, newPos.y, newPos.z);
                } else {
                    MixinContraptionCollider.warn1(newPos);
                }
            }
        } else {
            class_243 class_2432 = new class_243(x, y, z);
            if (instance.method_19538().method_1022(class_2432) < 20.0) {
                instance.method_5814(x, y, z);
            } else {
                MixinContraptionCollider.warn2(x, y, z);
            }
        }
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setPos(DDD)V"))
    private static void redirectSetPos(class_1297 instance, double x, double y, double z) {
        MixinContraptionCollider.setOfPos(contraptionEnt, instance, x, y, z);
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/AbstractContraptionEntity;getBoundingBox()Lnet/minecraft/world/phys/AABB;"))
    private static class_238 redirectContraptionGetBoundingBox(AbstractContraptionEntity instance) {
        return VSGameUtilsKt.transformAabbToWorld(instance.method_5770(), instance.method_5829());
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getBoundingBox()Lnet/minecraft/world/phys/AABB;"))
    private static class_238 redirectEntityGetBoundingBox(class_1297 instance) {
        return MixinContraptionCollider.entityGetBoundingBox(contraptionEnt, instance);
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;position()Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectEntityPosition(class_1297 instance) {
        return MixinContraptionCollider.entityPosition(contraptionEnt, instance, false);
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getDeltaMovement()Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectEntityGetDeltaMovement(class_1297 instance) {
        return MixinContraptionCollider.getSetEntityDeltaMovement(contraptionEnt, instance, null);
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
    private static void redirectEntitySetDeltaMovement(class_1297 instance, class_243 motion) {
        MixinContraptionCollider.getSetEntityDeltaMovement(contraptionEnt, instance, motion);
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getX()D"))
    private static double redirectEntityGetX(class_1297 instance) {
        return MixinContraptionCollider.entityPosition((AbstractContraptionEntity)MixinContraptionCollider.contraptionEnt, (class_1297)instance, (boolean)false).field_1352;
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getY()D"))
    private static double redirectEntityGetY(class_1297 instance) {
        return MixinContraptionCollider.entityPosition((AbstractContraptionEntity)MixinContraptionCollider.contraptionEnt, (class_1297)instance, (boolean)false).field_1351;
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getZ()D"))
    private static double redirectEntityGetZ(class_1297 instance) {
        return MixinContraptionCollider.entityPosition((AbstractContraptionEntity)MixinContraptionCollider.contraptionEnt, (class_1297)instance, (boolean)false).field_1350;
    }

    @Redirect(method={"collideEntities"}, at=@At(value="FIELD", target="Lnet/minecraft/world/entity/Entity;xo:D", opcode=180))
    private static double redirectEntityGetXo(class_1297 instance) {
        return MixinContraptionCollider.entityPosition((AbstractContraptionEntity)MixinContraptionCollider.contraptionEnt, (class_1297)instance, (boolean)true).field_1352;
    }

    @Redirect(method={"collideEntities"}, at=@At(value="FIELD", target="Lnet/minecraft/world/entity/Entity;zo:D", opcode=180))
    private static double redirectEntityGetZo(class_1297 instance) {
        return MixinContraptionCollider.entityPosition((AbstractContraptionEntity)MixinContraptionCollider.contraptionEnt, (class_1297)instance, (boolean)true).field_1350;
    }

    private static class_243 aaaaaaaaaaaaaa(AbstractContraptionEntity abstractContraptionEntity, class_1297 entity, class_243 anchorVec, Matrix3d rotationMatrix, float yawOffset) {
        Ship ship;
        if (VSGameUtilsKt.isBlockInShipyard(abstractContraptionEntity.method_5770(), abstractContraptionEntity.getContraption().anchor) && !VSGameUtilsKt.isBlockInShipyard(abstractContraptionEntity.method_5770(), entity.method_24515()) && (ship = VSGameUtilsKt.getShipManagingPos(abstractContraptionEntity.method_5770(), abstractContraptionEntity.getContraption().anchor)) != null) {
            class_243 entityPosition = MixinContraptionCollider.entityPosition(abstractContraptionEntity, entity, false);
            class_243 centerY = new class_243(0.0, MixinContraptionCollider.entityGetBoundingBox(contraptionEnt, entity).method_17940() / 2.0, 0.0);
            class_243 position = entityPosition;
            position = position.method_1019(centerY);
            position = position.method_1020(VecHelper.CENTER_OF_ORIGIN);
            position = position.method_1020(anchorVec);
            position = VecHelper.rotate((class_243)position, (double)(-yawOffset), (class_2350.class_2351)class_2350.class_2351.field_11052);
            position = rotationMatrix.transform(position);
            position = position.method_1019(VecHelper.CENTER_OF_ORIGIN);
            position = position.method_1020(centerY);
            position = position.method_1020(entityPosition);
            return position;
        }
        return ContraptionCollider.getWorldToLocalTranslation((class_1297)entity, (class_243)anchorVec, (Matrix3d)rotationMatrix, (float)yawOffset);
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/AbstractContraptionEntity;getPrevPositionVec()Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectGetPrevPositionVec(AbstractContraptionEntity instance) {
        Ship ship;
        class_243 prevPos = instance.getPrevPositionVec();
        if (VSGameUtilsKt.isBlockInShipyard(instance.method_37908(), class_2338.method_49638((class_2374)instance.getAnchorVec())) && !VSGameUtilsKt.isBlockInShipyard(instance.method_37908(), class_2338.method_49638((class_2374)instance.getPrevAnchorVec())) && (ship = VSGameUtilsKt.getShipManagingPos(instance.method_37908(), (class_2374)instance.getAnchorVec())) != null) {
            class_243 result2 = VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(instance.getPrevPositionVec())));
            instance.field_6014 = result2.field_1352;
            instance.field_6036 = result2.field_1351;
            instance.field_5969 = result2.field_1350;
            prevPos = result2;
        }
        if (VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), class_2338.method_49638((class_2374)prevPos)) || VSGameUtilsKt.isBlockInShipyard(instance.method_5770(), class_2338.method_49638((class_2374)instance.method_19538()))) {
            // empty if block
        }
        return prevPos;
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/ContraptionCollider;getWorldToLocalTranslation(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/world/phys/Vec3;Lcom/simibubi/create/foundation/collision/Matrix3d;F)Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectGetWorldToLocalTranslation(class_1297 entity, class_243 anchorVec, Matrix3d rotationMatrix, float yawOffset) {
        return MixinContraptionCollider.aaaaaaaaaaaaaa(contraptionEnt, entity, anchorVec, rotationMatrix, yawOffset);
    }

    @Unique
    private static class_243 adjustCollide(class_243 contactPoint, class_1297 entity) {
        Ship ship;
        class_243 result2 = MixinContraptionCollider.collide(contactPoint, entity);
        if (VSGameUtilsKt.isBlockInShipyard(entity.method_5770(), contactPoint.field_1352, contactPoint.field_1351, contactPoint.field_1350) && !VSGameUtilsKt.isBlockInShipyard(entity.method_5770(), entity.method_24515())) {
            Ship ship2 = VSGameUtilsKt.getShipManagingPos(entity.method_5770(), (class_2374)contactPoint);
            if (ship2 != null) {
                class_243 temp = VectorConversionsMCKt.toMinecraft(ship2.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(contactPoint)));
                result2 = MixinContraptionCollider.collide(temp, entity);
                result2 = VectorConversionsMCKt.toMinecraft(ship2.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(result2)));
            }
        } else if (!VSGameUtilsKt.isBlockInShipyard(entity.method_5770(), contactPoint.field_1352, contactPoint.field_1351, contactPoint.field_1350) && VSGameUtilsKt.isBlockInShipyard(entity.method_5770(), entity.method_24515()) && (ship = VSGameUtilsKt.getShipManagingPos(entity.method_5770(), entity.method_24515())) != null) {
            class_243 temp = VectorConversionsMCKt.toMinecraft(ship.getWorldToShip().transformPosition(VectorConversionsMCKt.toJOML(contactPoint)));
            result2 = MixinContraptionCollider.collide(temp, entity);
            result2 = VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(result2)));
        }
        return result2;
    }

    @Redirect(method={"collideEntities"}, at=@At(value="INVOKE", target="Lcom/simibubi/create/content/contraptions/ContraptionCollider;collide(Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectEntityGetBoundingBoxCollide(class_243 contactPoint, class_1297 entity) {
        return MixinContraptionCollider.adjustCollide(contactPoint, entity);
    }

    private static class_238 redirectEntityGetBoundingBox2(class_1297 instance) {
        return MixinContraptionCollider.entityGetBoundingBox(contraptionEnt, instance);
    }

    private static class_243 redirectEntityPosition2(class_1297 instance) {
        return MixinContraptionCollider.entityPosition(contraptionEnt, instance, false);
    }

    @Inject(method={"worldToLocalPos(Lnet/minecraft/world/phys/Vec3;Lcom/simibubi/create/content/contraptions/AbstractContraptionEntity;)Lnet/minecraft/world/phys/Vec3;"}, at={@At(value="HEAD")}, cancellable=true)
    private static void modPosition(class_243 entity, AbstractContraptionEntity contraptionEntity, CallbackInfoReturnable<class_243> cir) {
        Ship ship;
        if (VSGameUtilsKt.isBlockInShipyard(contraptionEntity.method_5770(), new class_2338((class_2382)contraptionEntity.getContraption().anchor)) && !VSGameUtilsKt.isBlockInShipyard(contraptionEntity.method_5770(), class_2338.method_49638((class_2374)entity)) && (ship = VSGameUtilsKt.getShipManagingPos(contraptionEntity.method_5770(), contraptionEntity.getContraption().anchor)) != null) {
            cir.setReturnValue((Object)ContraptionCollider.worldToLocalPos((class_243)entity, (class_243)VectorConversionsMCKt.toMinecraft(ship.getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(contraptionEntity.getAnchorVec()))), (AbstractContraptionEntity.ContraptionRotationState)contraptionEntity.getRotationState()));
        }
    }

    @ModifyVariable(method={"handleDamageFromTrain"}, at=@At(value="HEAD"), argsOnly=true)
    private static AbstractContraptionEntity injectHandleDamageFromTrain(AbstractContraptionEntity abstractContraptionEntity) {
        hDFTContraptionEntity = abstractContraptionEntity;
        return hDFTContraptionEntity;
    }

    @Redirect(method={"handleDamageFromTrain"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getDeltaMovement()Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectEntityGetDeltaMovementFromTrain(class_1297 instance) {
        return MixinContraptionCollider.getSetEntityDeltaMovement(hDFTContraptionEntity, instance, null);
    }

    @ModifyVariable(method={"bounceEntity"}, at=@At(value="HEAD"), argsOnly=true)
    private static AbstractContraptionEntity injectBounceEntity(AbstractContraptionEntity abstractContraptionEntity) {
        bounceEntityContraptionEntity = abstractContraptionEntity;
        return bounceEntityContraptionEntity;
    }

    @Redirect(method={"bounceEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;position()Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectEntityPositionBounceEntity(class_1297 instance) {
        return MixinContraptionCollider.entityPosition(bounceEntityContraptionEntity, instance, false);
    }

    @Redirect(method={"bounceEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;getDeltaMovement()Lnet/minecraft/world/phys/Vec3;"))
    private static class_243 redirectEntityGetDeltaMovementBounceEntity(class_1297 instance) {
        return MixinContraptionCollider.getSetEntityDeltaMovement(bounceEntityContraptionEntity, instance, null);
    }

    @Redirect(method={"bounceEntity"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/Entity;setDeltaMovement(Lnet/minecraft/world/phys/Vec3;)V"))
    private static void redirectEntitySetDeltaMovementBounceEntity(class_1297 instance, class_243 motion) {
        MixinContraptionCollider.getSetEntityDeltaMovement(bounceEntityContraptionEntity, instance, motion);
    }
}

