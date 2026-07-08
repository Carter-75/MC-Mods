/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.Entity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 */
package backported.updates.foundation.common.events;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import java.util.Arrays;
import java.util.function.Consumer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface EntityEvents {
    public static final Event<LivingSpawn> ON_SPAWN = Event.cancellable(LivingSpawn.class);
    public static final Event<LivingAttack> ON_ATTACK = Event.cancellable(LivingAttack.class);
    public static final Event<LivingRemove> ON_REMOVE = Event.cancellable(LivingRemove.class);
    public static final Event<LivingDeath> ON_DEATH = Event.create(LivingDeath.class, events -> (entity, source) -> Arrays.stream(events).allMatch(event -> event.onDeath(entity, source)));
    public static final Event<EntityPickUp> ON_PICK = Event.create(EntityPickUp.class);

    public static interface LivingDeath {
        public boolean onDeath(Entity var1, DamageSource var2);
    }

    public static interface LivingSpawn {
        public CancellableResult onSpawn(Entity var1, World var2);
    }

    public static interface LivingAttack {
        public CancellableResult onAttack(Entity var1, DamageSource var2);
    }

    public static interface LivingRemove {
        public CancellableResult onRemove(Entity var1, DamageSource var2);
    }

    public static interface EntityPickUp {
        public void onPickUp(Entity var1, Consumer<ItemStack> var2);
    }
}

