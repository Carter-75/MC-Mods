/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.World
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.world.event.GameEvent$Emitter
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.Leashable
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.api.leash;

import backported.updates.content.common.api.leash.LeashExtension;
import backported.updates.foundation.common.integration.MobInteraction;
import java.util.List;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.event.GameEvent;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.Leashable;
import org.jetbrains.annotations.Nullable;

public class LeashIntegration
implements MobInteraction {
    @Override
    public ActionResult onInteract(PlayerEntity player, Entity entity, Hand hand) {
        List<Leashable> nearbyMobs;
        LivingEntity living;
        Leashable leashable;
        ItemStack stack = player.getStackInHand(hand);
        if (!entity.getWorld().isClient() && player.shouldCancelInteraction() && entity instanceof Leashable && (leashable = (Leashable)entity).canBeLeashed() && entity.isAlive() && (!(entity instanceof LivingEntity) || !(living = (LivingEntity)entity).isBaby()) && !(nearbyMobs = LeashExtension.vb$leashableInArea(entity, l -> l.getLeashHolder() == player)).isEmpty()) {
            boolean attachedAny = false;
            for (Leashable target : nearbyMobs) {
                if (!((LeashExtension)target).vb$canHaveALeashAttachedTo(entity)) continue;
                target.attachLeash(entity, true);
                attachedAny = true;
            }
            if (attachedAny) {
                entity.getWorld().emitGameEvent((RegistryEntry)GameEvent.ENTITY_ACTION, entity.getBlockPos(), GameEvent.Emitter.of((Entity)player));
                entity.playSoundIfNotSilent(SoundEvents.ENTITY_LEASH_KNOT_PLACE);
                return ActionResult.SUCCESS;
            }
        }
        if (stack.isOf(Items.SHEARS) && this.shearOffAllLeashConnections(entity, player)) {
            stack.damage(1, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
            return ActionResult.SUCCESS;
        }
        if (entity.isAlive() && entity instanceof Leashable) {
            leashable = (Leashable)entity;
            if (leashable.getLeashHolder() == player) {
                if (!entity.getWorld().isClient()) {
                    leashable.detachLeash(true, !player.isCreative());
                    entity.getWorld().emitGameEvent((RegistryEntry)GameEvent.ENTITY_INTERACT, entity.getPos(), GameEvent.Emitter.of((Entity)player));
                    entity.playSoundIfNotSilent(SoundEvents.ENTITY_LEASH_KNOT_BREAK);
                }
                return ActionResult.SUCCESS;
            }
            if (stack.isOf(Items.LEAD) && !(leashable.getLeashHolder() instanceof PlayerEntity)) {
                if (!entity.getWorld().isClient() && ((LeashExtension)leashable).vb$canHaveALeashAttachedTo((Entity)player)) {
                    if (leashable.isLeashed()) {
                        leashable.detachLeash(true, true);
                    }
                    leashable.attachLeash((Entity)player, true);
                    entity.playSoundIfNotSilent(SoundEvents.ENTITY_LEASH_KNOT_PLACE);
                    if (!player.isCreative()) {
                        stack.decrement(1);
                    }
                }
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    private boolean shearOffAllLeashConnections(Entity entity, PlayerEntity player) {
        World class_19372;
        boolean sheared = LeashIntegration.dropAllLeashConnections(entity, player);
        if (sheared && (class_19372 = entity.getWorld()) instanceof ServerWorld) {
            ServerWorld server = (ServerWorld)class_19372;
            server.playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_SHEEP_SHEAR, player != null ? player.getSoundCategory() : entity.getSoundCategory());
        }
        return sheared;
    }

    public static boolean dropAllLeashConnections(Entity entity, @Nullable PlayerEntity player) {
        Leashable leashable;
        boolean dropConnections;
        List<Leashable> leashed = LeashExtension.vb$leashableLeashedTo(entity);
        boolean bl = dropConnections = !leashed.isEmpty();
        if (entity instanceof Leashable && (leashable = (Leashable)entity).isLeashed()) {
            leashable.detachLeash(true, true);
            dropConnections = true;
        }
        for (Leashable leashable2 : leashed) {
            leashable2.detachLeash(true, true);
        }
        if (dropConnections) {
            entity.emitGameEvent((RegistryEntry)GameEvent.SHEAR, (Entity)player);
            return true;
        }
        return false;
    }
}

