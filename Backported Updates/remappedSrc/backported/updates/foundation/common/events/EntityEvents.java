/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 */
package backported.updates.foundation.common.events;

import backported.updates.foundation.core.util.event.CancellableResult;
import backported.updates.foundation.core.util.event.Event;
import java.util.Arrays;
import java.util.function.Consumer;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1799;
import net.minecraft.class_1937;

public interface EntityEvents {
    public static final Event<LivingSpawn> ON_SPAWN = Event.cancellable(LivingSpawn.class);
    public static final Event<LivingAttack> ON_ATTACK = Event.cancellable(LivingAttack.class);
    public static final Event<LivingRemove> ON_REMOVE = Event.cancellable(LivingRemove.class);
    public static final Event<LivingDeath> ON_DEATH = Event.create(LivingDeath.class, events -> (entity, source) -> Arrays.stream(events).allMatch(event -> event.onDeath(entity, source)));
    public static final Event<EntityPickUp> ON_PICK = Event.create(EntityPickUp.class);

    public static interface LivingDeath {
        public boolean onDeath(class_1297 var1, class_1282 var2);
    }

    public static interface LivingSpawn {
        public CancellableResult onSpawn(class_1297 var1, class_1937 var2);
    }

    public static interface LivingAttack {
        public CancellableResult onAttack(class_1297 var1, class_1282 var2);
    }

    public static interface LivingRemove {
        public CancellableResult onRemove(class_1297 var1, class_1282 var2);
    }

    public static interface EntityPickUp {
        public void onPickUp(class_1297 var1, Consumer<class_1799> var2);
    }
}

