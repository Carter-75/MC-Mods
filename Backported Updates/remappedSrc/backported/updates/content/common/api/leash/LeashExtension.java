/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableMap$Builder
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1492
 *  net.minecraft.class_1496
 *  net.minecraft.class_156
 *  net.minecraft.class_1657
 *  net.minecraft.class_1690
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_7689
 *  net.minecraft.class_8153
 *  net.minecraft.class_9817
 *  net.minecraft.class_9817$class_9818
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
import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1492;
import net.minecraft.class_1496;
import net.minecraft.class_156;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_7689;
import net.minecraft.class_8153;
import net.minecraft.class_9817;

public interface LeashExtension {
    public static final Map<Predicate<class_1297>, Function<class_1297, class_243[]>> QUAD_LEASH_OFFSETS = (Map)class_156.method_656(() -> {
        ImmutableMap.Builder offsets = new ImmutableMap.Builder();
        offsets.put(entity -> entity instanceof class_1690, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.0, 0.64, 0.382, 0.88));
        offsets.put(entity -> entity instanceof class_7689, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.02, 0.48, 0.25, 0.82));
        offsets.put(entity -> entity instanceof class_1496, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.04, 0.52, 0.23, 0.87));
        offsets.put(entity -> entity instanceof class_1492, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, 0.04, 0.41, 0.18, 0.73));
        offsets.put(entity -> entity instanceof class_8153, entity -> LeashExtension.vb$createQuadLeashOffsets(entity, -0.01, 0.63, 0.38, 1.15));
        return offsets.build();
    });
    public static final class_243 AXIS_SPECIFIC_ELASTICITY = new class_243(0.8, 0.2, 0.8);
    public static final List<class_243> ENTITY_ATTACHMENT_POINT = ImmutableList.of((Object)new class_243(0.0, 0.5, 0.5));
    public static final List<class_243> LEASHER_ATTACHMENT_POINT = ImmutableList.of((Object)new class_243(0.0, 0.5, 0.0));
    public static final List<class_243> SHARED_QUAD_ATTACHMENT_POINTS = ImmutableList.of((Object)new class_243(-0.5, 0.5, 0.5), (Object)new class_243(-0.5, 0.5, -0.5), (Object)new class_243(0.5, 0.5, -0.5), (Object)new class_243(0.5, 0.5, 0.5));

    default public boolean vb$canHaveALeashAttachedTo(class_1297 target) {
        if (this == target) {
            return false;
        }
        return this.vb$leashDistanceTo(target) <= this.vb$leashSnapDistance() && ((class_9817)this).method_5931();
    }

    default public double vb$leashDistanceTo(class_1297 entity) {
        return entity.method_5829().method_1005().method_1022(((class_1297)this).method_5829().method_1005());
    }

    default public void vb$onElasticLeashPull() {
        ((class_1297)this).method_45318();
    }

    default public double vb$leashSnapDistance() {
        return 12.0;
    }

    default public double vb$leashElasticDistance() {
        return 6.0;
    }

    public static <E extends class_1297> float vb$angularFriction(E entity) {
        if (entity.method_24828()) {
            return entity.method_37908().method_8320(entity.method_23314()).method_26204().method_9499() * 0.91f;
        }
        return entity.method_52535() ? 0.8f : 0.91f;
    }

    default public void vb$whenLeashedTo(class_1297 entity) {
        if (entity instanceof LeashExtension) {
            LeashExtension extension = (LeashExtension)entity;
            extension.vb$notifyLeashHolder((class_9817)this);
        }
    }

    default public void vb$notifyLeashHolder(class_9817 leashable) {
    }

    default public void vb$resetAngularMomentum() {
        class_9817.class_9818 class_98182;
        class_9817.class_9818 data = ((class_9817)this).method_60955();
        if (data != null && (class_98182 = data) instanceof LeashDataExtension) {
            LeashDataExtension extension = (LeashDataExtension)class_98182;
            extension.setAngularMomentum(0.0);
        }
    }

    default public boolean vb$checkElasticInteractions(class_1297 entity, class_9817.class_9818 data) {
        LeashExtension holder;
        if (((class_1297)this).method_5642() instanceof class_1657) {
            return false;
        }
        boolean supportQuadLeash = entity instanceof LeashExtension && (holder = (LeashExtension)entity).vb$supportQuadLeashAsHolder() && this.vb$supportQuadLeash();
        List<Wrench> wrenches = LeashExtension.vb$computeElasticInteraction((class_1297)((LeashExtension)((class_9817)this)), entity, supportQuadLeash ? SHARED_QUAD_ATTACHMENT_POINTS : ENTITY_ATTACHMENT_POINT, supportQuadLeash ? SHARED_QUAD_ATTACHMENT_POINTS : LEASHER_ATTACHMENT_POINT);
        if (wrenches.isEmpty()) {
            return false;
        }
        Wrench wrench = Wrench.accumulate(wrenches).scale(supportQuadLeash ? 0.25 : 1.0);
        LeashDataExtension extension = (LeashDataExtension)data;
        extension.setAngularMomentum(extension.angularMomentum() + 10.0 * wrench.torque());
        class_243 offset = LeashExtension.vb$getHolderMovement(entity).method_1020(LeashExtension.vb$getKnownMovement((class_1297)this));
        ((class_1297)this).method_45319(wrench.force().method_18806(AXIS_SPECIFIC_ELASTICITY).method_1019(offset.method_1021(0.11)));
        return true;
    }

    public static class_243 vb$getHolderMovement(class_1297 entity) {
        class_1308 mob;
        return entity instanceof class_1308 && (mob = (class_1308)entity).method_5987() ? class_243.field_1353 : LeashExtension.vb$getKnownMovement(entity);
    }

    public static class_243 vb$getKnownMovement(class_1297 entity) {
        class_1309 passenger = entity.method_5642();
        if (passenger instanceof class_1657) {
            class_1657 player = (class_1657)passenger;
            if (entity.method_5805()) {
                return player.method_18798();
            }
        }
        return entity.method_18798();
    }

    public static <E extends class_1297 & LeashExtension> List<Wrench> vb$computeElasticInteraction(E entity, class_1297 holder, List<class_243> attachmentPoints, List<class_243> holderAttachmentPoints) {
        double elasticDistance = ((LeashExtension)entity).vb$leashElasticDistance();
        class_243 entityMovement = LeashExtension.vb$getHolderMovement(entity);
        float entityYaw = entity.method_36454() * ((float)Math.PI / 180);
        class_243 entityDimensions = new class_243((double)entity.method_17681(), (double)entity.method_17682(), (double)entity.method_17681());
        float holderYaw = holder.method_36454() * ((float)Math.PI / 180);
        class_243 holderDimensions = new class_243((double)holder.method_17681(), (double)holder.method_17682(), (double)holder.method_17681());
        ArrayList<Wrench> wrenches = new ArrayList<Wrench>();
        for (int i = 0; i < attachmentPoints.size(); ++i) {
            class_243 entityOffset = attachmentPoints.get(i).method_18806(entityDimensions).method_1024(-entityYaw);
            class_243 entityPosition = entity.method_19538().method_1019(entityOffset);
            class_243 holderOffset = holderAttachmentPoints.get(i).method_18806(holderDimensions).method_1024(-holderYaw);
            class_243 holderPosition = holder.method_19538().method_1019(holderOffset);
            LeashExtension.vb$computeDampenedSpringInteraction(holderPosition, entityPosition, elasticDistance, entityMovement, entityOffset).ifPresent(wrenches::add);
        }
        return wrenches;
    }

    private static Optional<Wrench> vb$computeDampenedSpringInteraction(class_243 holderPos, class_243 entityPos, double threshold, class_243 movement, class_243 offset) {
        boolean movingWithForce;
        double distance = entityPos.method_1022(holderPos);
        if (distance < threshold) {
            return Optional.empty();
        }
        class_243 force = holderPos.method_1020(entityPos).method_1029().method_1021(distance - threshold);
        double torque = Wrench.torqueFromForce(offset, force);
        boolean bl = movingWithForce = movement.method_1026(force) >= 0.0;
        if (movingWithForce) {
            force = force.method_1021((double)0.3f);
        }
        return Optional.of(new Wrench(force, torque));
    }

    default public boolean vb$supportQuadLeash() {
        class_1297 entity = (class_1297)this;
        for (Predicate<class_1297> filter : QUAD_LEASH_OFFSETS.keySet()) {
            if (!filter.test(entity)) continue;
            return true;
        }
        return false;
    }

    default public boolean vb$supportQuadLeashAsHolder() {
        return false;
    }

    default public class_243[] vb$getQuadLeashOffsets() {
        class_1297 entity = (class_1297)this;
        for (Predicate<class_1297> filter : QUAD_LEASH_OFFSETS.keySet()) {
            if (!filter.test(entity)) continue;
            return QUAD_LEASH_OFFSETS.get(filter).apply(entity);
        }
        return LeashExtension.vb$createQuadLeashOffsets((class_1297)this, 0.0, 0.5, 0.5, 0.5);
    }

    default public class_243[] vb$getQuadLeashHolderOffsets() {
        return LeashExtension.vb$createQuadLeashOffsets((class_1297)this, 0.0, 0.5, 0.5, 0.0);
    }

    public static class_243[] vb$createQuadLeashOffsets(class_1297 entity, double forwardOffset, double sideOffset, double widthOffset, double heightOffset) {
        float entityWidth = entity.method_17681();
        double forward = forwardOffset * (double)entityWidth;
        double side = sideOffset * (double)entityWidth;
        double width = widthOffset * (double)entityWidth;
        double height = heightOffset * (double)entity.method_17682();
        return new class_243[]{new class_243(-width, height, side + forward), new class_243(-width, height, -side + forward), new class_243(width, height, -side + forward), new class_243(width, height, side + forward)};
    }

    public static List<class_9817> vb$leashableLeashedTo(class_1297 entity) {
        return LeashExtension.vb$leashableInArea(entity, leashable -> leashable.method_60952() == entity);
    }

    public static List<class_9817> vb$leashableInArea(class_1297 entity, Predicate<class_9817> filter) {
        return LeashExtension.vb$leashableInArea(entity.method_37908(), entity.method_5829().method_1005(), filter);
    }

    public static List<class_9817> vb$leashableInArea(class_1937 level, class_243 pos, Predicate<class_9817> filter) {
        class_238 area = class_238.method_30048((class_243)pos, (double)32.0, (double)32.0, (double)32.0);
        return level.method_8390(class_1297.class, area, entity -> {
            class_9817 leashable;
            return entity instanceof class_9817 && filter.test(leashable = (class_9817)entity);
        }).stream().map(class_9817.class::cast).toList();
    }

    public static float vb$getPreciseBodyRotation(class_1297 entity, float partialTicks) {
        if (entity instanceof class_1309) {
            class_1309 living = (class_1309)entity;
            return class_3532.method_16439((float)partialTicks, (float)living.field_6220, (float)living.field_6283);
        }
        return class_3532.method_16439((float)partialTicks, (float)entity.field_5982, (float)entity.method_36454());
    }

    public record Wrench(class_243 force, double torque) {
        static final Wrench ZERO = new Wrench(class_243.field_1353, 0.0);

        static double torqueFromForce(class_243 position, class_243 force) {
            return position.field_1350 * force.field_1352 - position.field_1352 * force.field_1350;
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
                class_243 force = wrench.force;
                x += force.field_1352;
                y += force.field_1351;
                z += force.field_1350;
                torque += wrench.torque;
            }
            return new Wrench(new class_243(x, y, z), torque);
        }

        public Wrench scale(double factor) {
            return new Wrench(this.force.method_1021(factor), this.torque * factor);
        }
    }
}

