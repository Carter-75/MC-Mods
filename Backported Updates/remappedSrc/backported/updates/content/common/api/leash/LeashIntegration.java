/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_5712
 *  net.minecraft.class_5712$class_7397
 *  net.minecraft.class_6880
 *  net.minecraft.class_9817
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.api.leash;

import backported.updates.content.common.api.leash.LeashExtension;
import backported.updates.foundation.common.integration.MobInteraction;
import java.util.List;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_5712;
import net.minecraft.class_6880;
import net.minecraft.class_9817;
import org.jetbrains.annotations.Nullable;

public class LeashIntegration
implements MobInteraction {
    @Override
    public class_1269 onInteract(class_1657 player, class_1297 entity, class_1268 hand) {
        List<class_9817> nearbyMobs;
        class_1309 living;
        class_9817 leashable;
        class_1799 stack = player.method_5998(hand);
        if (!entity.method_37908().method_8608() && player.method_21823() && entity instanceof class_9817 && (leashable = (class_9817)entity).method_5931() && entity.method_5805() && (!(entity instanceof class_1309) || !(living = (class_1309)entity).method_6109()) && !(nearbyMobs = LeashExtension.vb$leashableInArea(entity, l -> l.method_60952() == player)).isEmpty()) {
            boolean attachedAny = false;
            for (class_9817 target : nearbyMobs) {
                if (!((LeashExtension)target).vb$canHaveALeashAttachedTo(entity)) continue;
                target.method_60964(entity, true);
                attachedAny = true;
            }
            if (attachedAny) {
                entity.method_37908().method_43276((class_6880)class_5712.field_45148, entity.method_24515(), class_5712.class_7397.method_43285((class_1297)player));
                entity.method_43077(class_3417.field_15062);
                return class_1269.field_5812;
            }
        }
        if (stack.method_31574(class_1802.field_8868) && this.shearOffAllLeashConnections(entity, player)) {
            stack.method_7970(1, (class_1309)player, class_1309.method_56079((class_1268)hand));
            return class_1269.field_5812;
        }
        if (entity.method_5805() && entity instanceof class_9817) {
            leashable = (class_9817)entity;
            if (leashable.method_60952() == player) {
                if (!entity.method_37908().method_8608()) {
                    leashable.method_5932(true, !player.method_7337());
                    entity.method_37908().method_32888((class_6880)class_5712.field_28725, entity.method_19538(), class_5712.class_7397.method_43285((class_1297)player));
                    entity.method_43077(class_3417.field_15184);
                }
                return class_1269.field_5812;
            }
            if (stack.method_31574(class_1802.field_8719) && !(leashable.method_60952() instanceof class_1657)) {
                if (!entity.method_37908().method_8608() && ((LeashExtension)leashable).vb$canHaveALeashAttachedTo((class_1297)player)) {
                    if (leashable.method_60953()) {
                        leashable.method_5932(true, true);
                    }
                    leashable.method_60964((class_1297)player, true);
                    entity.method_43077(class_3417.field_15062);
                    if (!player.method_7337()) {
                        stack.method_7934(1);
                    }
                }
                return class_1269.field_5812;
            }
        }
        return class_1269.field_5811;
    }

    private boolean shearOffAllLeashConnections(class_1297 entity, class_1657 player) {
        class_1937 class_19372;
        boolean sheared = LeashIntegration.dropAllLeashConnections(entity, player);
        if (sheared && (class_19372 = entity.method_37908()) instanceof class_3218) {
            class_3218 server = (class_3218)class_19372;
            server.method_45447(null, entity.method_24515(), class_3417.field_14975, player != null ? player.method_5634() : entity.method_5634());
        }
        return sheared;
    }

    public static boolean dropAllLeashConnections(class_1297 entity, @Nullable class_1657 player) {
        class_9817 leashable;
        boolean dropConnections;
        List<class_9817> leashed = LeashExtension.vb$leashableLeashedTo(entity);
        boolean bl = dropConnections = !leashed.isEmpty();
        if (entity instanceof class_9817 && (leashable = (class_9817)entity).method_60953()) {
            leashable.method_5932(true, true);
            dropConnections = true;
        }
        for (class_9817 leashable2 : leashed) {
            leashable2.method_5932(true, true);
        }
        if (dropConnections) {
            entity.method_32875((class_6880)class_5712.field_28730, (class_1297)player);
            return true;
        }
        return false;
    }
}

