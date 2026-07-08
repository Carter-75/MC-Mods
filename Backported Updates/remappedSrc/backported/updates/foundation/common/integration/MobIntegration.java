/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1317$class_4306
 *  net.minecraft.class_1352
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_9168
 */
package backported.updates.foundation.common.integration;

import backported.updates.foundation.common.events.EntityEvents;
import backported.updates.foundation.common.integration.MobInteraction;
import backported.updates.foundation.common.integration.fabric.MobIntegrationImpl;
import backported.updates.foundation.core.util.event.CancellableResult;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1317;
import net.minecraft.class_1352;
import net.minecraft.class_2902;
import net.minecraft.class_5132;
import net.minecraft.class_9168;

public class MobIntegration {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerIntegrations(Consumer<Event> listener) {
        MobIntegrationImpl.registerIntegrations(listener);
    }

    public static interface Event {
        public void registerMobInteraction(MobInteraction var1);

        public void registerAttributes(Supplier<? extends class_1299<? extends class_1309>> var1, Supplier<class_5132.class_5133> var2);

        public <T extends class_1308> void registerPlacement(Supplier<class_1299<T>> var1, class_9168 var2, class_2902.class_2903 var3, class_1317.class_4306<T> var4);

        default public void registerGoal(Predicate<class_1308> predicate, int priority, Function<class_1308, class_1352> factory) {
            EntityEvents.ON_SPAWN.register((entity, level) -> {
                class_1308 mob;
                if (entity instanceof class_1308 && predicate.test(mob = (class_1308)entity)) {
                    mob.field_6201.method_6277(priority, (class_1352)factory.apply(mob));
                }
                return CancellableResult.PASS;
            });
        }

        default public void registerGoal(class_1299<?> entity, int priority, Function<class_1308, class_1352> factory) {
            this.registerGoal((class_1308 mob) -> mob.method_5864() == entity, priority, factory);
        }

        default public void registerTarget(Predicate<class_1308> predicate, int priority, Function<class_1308, class_1352> factory) {
            EntityEvents.ON_SPAWN.register((entity, level) -> {
                class_1308 mob;
                if (entity instanceof class_1308 && predicate.test(mob = (class_1308)entity)) {
                    mob.field_6185.method_6277(priority, (class_1352)factory.apply(mob));
                }
                return CancellableResult.PASS;
            });
        }

        default public void registerTarget(class_1299<? extends class_1297> entity, int priority, Function<class_1308, class_1352> factory) {
            this.registerTarget((class_1308 mob) -> mob.method_5864() == entity, priority, factory);
        }
    }
}

