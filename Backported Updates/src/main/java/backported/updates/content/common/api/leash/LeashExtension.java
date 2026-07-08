/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableMap$Builder
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.passive.AbstractDonkeyEntity
 *  net.minecraft.entity.passive.AbstractHorseEntity
 *  net.minecraft.util.Util
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.world.World
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.entity.passive.CamelEntity
 *  net.minecraft.entity.passive.SnifferEntity
 *  net.minecraft.entity.Leashable
 *  net.minecraft.entity.Leashable$LeashData
 */
package backported.updates.content.common.api.leash;

import backported.updates.content.common.api.leash.LeashDataExtension;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AbstractDonkeyEntity;
import net.minecraft.entity.passive.AbstractHorseEntity;
import net.minecraft.util.Util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.passive.CamelEntity;
import net.minecraft.entity.passive.SnifferEntity;
import net.minecraft.entity.Leashable;

public interface LeashExtension {
    public static final Map<Predicate<Entity>, Function<Entity, Vec3d[]>> QUAD_LEASH_OFFSETS = Util.make(() -> {
        ImmutableMap.Builder<Predicate<Entity>, Function<Entity, Vec3d[]>> offsets = new ImmutableMap.Builder<>();
        offsets.put(entity -> entity instanceof BoatEntity, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.0, 0.64, 0.382, 0.88));
        offsets.put(entity -> entity instanceof CamelEntity, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.02, 0.48, 0.25, 0.82));
        offsets.put(entity -> entity instanceof AbstractHorseEntity, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.04, 0.52, 0.23, 0.87));
        offsets.put(entity -> entity instanceof AbstractDonkeyEntity, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.04, 0.41, 0.18, 0.73));
        offsets.put(entity -> entity instanceof SnifferEntity, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, -0.01, 0.63, 0.38, 1.15));
        return offsets.build();
    });
    public static final Vec3d AXIS_SPECIFIC_ELASTICITY = new Vec3d(0.8, 0.2, 0.8);
    public static final List<Vec3d> ENTITY_ATTACHMENT_POINT = ImmutableList.of(new Vec3d(0.0, 0.5, 0.5));
    public static final List<Vec3d> LEASHER_ATTACHMENT_POINT = ImmutableList.of(new Vec3d(0.0, 0.5, 0.0));
    public static final List<Vec3d> SHARED_QUAD_ATTACHMENT_POINTS = ImmutableList.of(new Vec3d(-0.5, 0.5, 0.5), new Vec3d(-0.5, 0.5, -0.5), new Vec3d(0.5, 0.5, -0.5), new Vec3d(0.5, 0.5, 0.5));

    default public boolean vb$canHaveALeashAttachedTo(Entity target) {
        if (this == target) {
            return false;
        }
        return this.vb$leashDistanceTo(target) <= this.vb$leashSnapDistance() && ((Leashable)this).canBeLeashed();
    }

    default public double vb$leashDistanceTo(Entity entity) {
        return entity.getBoundingBox().getCenter().distanceTo(((Entity)this).getBoundingBox().getCenter());
    }

    default public void vb$onElasticLeashPull() {
        ((Entity)this).limitFallDistance();
    }

    default public double vb$leashSnapDistance() {
        return 12.0;
    }

    default public double vb$leashElasticDistance() {
        return 6.0;
    }

    public static <E extends Entity> float vb$angularFriction(E entity) {
        if (entity.isOnGround()) {
            return entity.getWorld().getBlockState(entity.getVelocityAffectingPos()).getBlock().getSlipperiness() * 0.91f;
        }
        return entity.isInFluid() ? 0.8f : 0.91f;
    }

    default public void vb$whenLeashedTo(Entity entity) {
        if (entity instanceof LeashExtension) {
            LeashExtension extension = (LeashExtension)entity;
            extension.vb$notifyLeashHolder((Leashable)this);
        }
    }

    default public void vb$notifyLeashHolder(Leashable leashable) {
    }

    default public void vb$resetAngularMomentum() {
        Leashable.LeashData data = ((Leashable)this).getLeashData();
        if ((Object)data instanceof LeashDataExtension extension) {
            extension.setAngularMomentum(0.0);
        }
    }

    default public boolean vb$checkElasticInteractions(Entity entity, Leashable.LeashData data) {
        LeashExtension holder;
        if (((Entity)this).getControllingPassenger() instanceof PlayerEntity) {
            return false;
        }
        boolean supportQuadLeash = entity instanceof LeashExtension && (holder = (LeashExtension)entity).vb$supportQuadLeashAsHolder() && this.vb$supportQuadLeash();
        List<Wrench> wrenches = LeashExtension.vb$computeElasticInteraction((Entity & LeashExtension)this, entity, supportQuadLeash ? SHARED_QUAD_ATTACHMENT_POINTS : ENTITY_ATTACHMENT_POINT, supportQuadLeash ? SHARED_QUAD_ATTACHMENT_POINTS : LEASHER_ATTACHMENT_POINT);
        if (wrenches.isEmpty()) {
            return false;
        }
        Wrench wrench = Wrench.accumulate(wrenches).scale(supportQuadLeash ? 0.25 : 1.0);
        LeashDataExtension extension = (LeashDataExtension)(Object)data;
        extension.setAngularMomentum(extension.angularMomentum() + 10.0 * wrench.torque());
        Vec3d offset = LeashExtension.vb$getHolderMovement(entity).subtract(LeashExtension.vb$getKnownMovement((Entity)this));
        ((Entity)this).addVelocityInternal(wrench.force().multiply(AXIS_SPECIFIC_ELASTICITY).add(offset.multiply(0.11)));
        return true;
    }

    public static Vec3d vb$getHolderMovement(Entity entity) {
        MobEntity mob;
        return entity instanceof MobEntity && (mob = (MobEntity)entity).isAiDisabled() ? Vec3d.ZERO : LeashExtension.vb$getKnownMovement(entity);
    }

    public static Vec3d vb$getKnownMovement(Entity entity) {
        LivingEntity passenger = entity.getControllingPassenger();
        if (passenger instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)passenger;
            if (entity.isAlive()) {
                return player.getVelocity();
            }
        }
        return entity.getVelocity();
    }

    public static <E extends Entity & LeashExtension> List<Wrench> vb$computeElasticInteraction(E entity, Entity holder, List<Vec3d> attachmentPoints, List<Vec3d> holderAttachmentPoints) {
        double elasticDistance = ((LeashExtension)entity).vb$leashElasticDistance();
        Vec3d entityMovement = LeashExtension.vb$getHolderMovement(entity);
        float entityYaw = entity.getYaw() * ((float)Math.PI / 180);
        Vec3d entityDimensions = new Vec3d((double)entity.getWidth(), (double)entity.getHeight(), (double)entity.getWidth());
        float holderYaw = holder.getYaw() * ((float)Math.PI / 180);
        Vec3d holderDimensions = new Vec3d((double)holder.getWidth(), (double)holder.getHeight(), (double)holder.getWidth());
        ArrayList<Wrench> wrenches = new ArrayList<Wrench>();
        for (int i = 0; i < attachmentPoints.size(); ++i) {
            Vec3d entityOffset = attachmentPoints.get(i).multiply(entityDimensions).rotateY(-entityYaw);
            Vec3d entityPosition = entity.getPos().add(entityOffset);
            Vec3d holderOffset = holderAttachmentPoints.get(i).multiply(holderDimensions).rotateY(-holderYaw);
            Vec3d holderPosition = holder.getPos().add(holderOffset);
            LeashExtension.vb$computeDampenedSpringInteraction(holderPosition, entityPosition, elasticDistance, entityMovement, entityOffset).ifPresent(wrenches::add);
        }
        return wrenches;
    }

    private static Optional<Wrench> vb$computeDampenedSpringInteraction(Vec3d holderPos, Vec3d entityPos, double threshold, Vec3d movement, Vec3d offset) {
        boolean movingWithForce;
        double distance = entityPos.distanceTo(holderPos);
        if (distance < threshold) {
            return Optional.empty();
        }
        Vec3d force = holderPos.subtract(entityPos).normalize().multiply(distance - threshold);
        double torque = Wrench.torqueFromForce(offset, force);
        boolean bl = movingWithForce = movement.dotProduct(force) >= 0.0;
        if (movingWithForce) {
            force = force.multiply((double)0.3f);
        }
        return Optional.of(new Wrench(force, torque));
    }

    default public boolean vb$supportQuadLeash() {
        Entity entity = (Entity)this;
        for (Predicate<Entity> filter : QUAD_LEASH_OFFSETS.keySet()) {
            if (!filter.test(entity)) continue;
            return true;
        }
        return false;
    }

    default public boolean vb$supportQuadLeashAsHolder() {
        return false;
    }

    default public Vec3d[] vb$getQuadLeashOffsets() {
        Entity entity = (Entity)this;
        for (Predicate<Entity> filter : QUAD_LEASH_OFFSETS.keySet()) {
            if (!filter.test(entity)) continue;
            return QUAD_LEASH_OFFSETS.get(filter).apply(entity);
        }
        return LeashExtension.vb$createQuadLeashOffsets((Entity)this, 0.0, 0.5, 0.5, 0.5);
    }

    default public Vec3d[] vb$getQuadLeashHolderOffsets() {
        return LeashExtension.vb$createQuadLeashOffsets((Entity)this, 0.0, 0.5, 0.5, 0.0);
    }

    public static Vec3d[] vb$createQuadLeashOffsets(Entity entity, double forwardOffset, double sideOffset, double widthOffset, double heightOffset) {
        float entityWidth = entity.getWidth();
        double forward = forwardOffset * (double)entityWidth;
        double side = sideOffset * (double)entityWidth;
        double width = widthOffset * (double)entityWidth;
        double height = heightOffset * (double)entity.getHeight();
        return new Vec3d[]{new Vec3d(-width, height, side + forward), new Vec3d(-width, height, -side + forward), new Vec3d(width, height, -side + forward), new Vec3d(width, height, side + forward)};
    }

    public static List<Leashable> vb$leashableLeashedTo(Entity entity) {
        return LeashExtension.vb$leashableInArea(entity, leashable -> leashable.getLeashHolder() == entity);
    }

    public static List<Leashable> vb$leashableInArea(Entity entity, Predicate<Leashable> filter) {
        return LeashExtension.vb$leashableInArea(entity.getWorld(), entity.getBoundingBox().getCenter(), filter);
    }

    public static List<Leashable> vb$leashableInArea(World level, Vec3d pos, Predicate<Leashable> filter) {
        Box area = Box.of((Vec3d)pos, (double)32.0, (double)32.0, (double)32.0);
        return level.getEntitiesByClass(Entity.class, area, entity -> {
            Leashable leashable;
            return entity instanceof Leashable && filter.test(leashable = (Leashable)entity);
        }).stream().map(Leashable.class::cast).toList();
    }

    public static float vb$getPreciseBodyRotation(Entity entity, float partialTicks) {
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity)entity;
            return MathHelper.lerp((float)partialTicks, (float)living.prevBodyYaw, (float)living.bodyYaw);
        }
        return MathHelper.lerp((float)partialTicks, (float)entity.prevYaw, (float)entity.getYaw());
    }

    public record Wrench(Vec3d force, double torque) {
        static final Wrench ZERO = new Wrench(Vec3d.ZERO, 0.0);

        static double torqueFromForce(Vec3d position, Vec3d force) {
            return position.z * force.x - position.x * force.z;
        }

        public static Wrench accumulate(List<Wrench> wrenches) {
            if (wrenches.isEmpty()) {
                return ZERO;
            }
            double x = 0.0;
            double y = 0.0;
            double z = 0.0;
            double torque = 0.0;
            for (Wrench wrench : wrenches) {
                Vec3d force = wrench.force;
                x += force.x;
                y += force.y;
                z += force.z;
                torque += wrench.torque;
            }
            return new Wrench(new Vec3d(x, y, z), torque);
        }

        public Wrench scale(double factor) {
            return new Wrench(this.force.multiply(factor), this.torque * factor);
        }
    }
}

