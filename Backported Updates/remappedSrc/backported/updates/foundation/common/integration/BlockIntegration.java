/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_1743
 *  net.minecraft.class_1821
 *  net.minecraft.class_1935
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2315
 *  net.minecraft.class_2357
 *  net.minecraft.class_2358
 *  net.minecraft.class_2680
 */
package backported.updates.foundation.common.integration;

import backported.updates.foundation.common.integration.BlockInteraction;
import backported.updates.foundation.common.integration.fabric.BlockIntegrationImpl;
import com.google.common.collect.Maps;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.Map;
import java.util.function.Consumer;
import net.minecraft.class_1743;
import net.minecraft.class_1821;
import net.minecraft.class_1935;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2315;
import net.minecraft.class_2357;
import net.minecraft.class_2358;
import net.minecraft.class_2680;

public class BlockIntegration {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerIntegrations(Consumer<Event> listener) {
        BlockIntegrationImpl.registerIntegrations(listener);
    }

    public static interface Event {
        public void registerBlockInteraction(BlockInteraction var1);

        public void registerFuelItem(class_1935 var1, int var2);

        public void registerCompostableItem(class_1935 var1, float var2);

        public void registerWaxableBlock(class_2248 var1, class_2248 var2);

        public void registerOxidableBlock(class_2248 var1, class_2248 var2);

        default public void registerDispenserBehavior(class_1935 item, class_2357 behavior) {
            class_2315.method_10009((class_1935)item, (class_2357)behavior);
        }

        default public void registerStrippableBlock(class_2248 target, class_2248 result) {
            class_1743.field_7898 = Maps.newHashMap((Map)class_1743.field_7898);
            class_1743.field_7898.putIfAbsent(target, result);
        }

        default public void registerFlattenableBlock(class_2248 target, class_2680 result) {
            class_1821.field_8912.putIfAbsent(target, result);
        }

        default public void registerFlattenableBlock(class_2248 target, class_2248 result) {
            this.registerFlattenableBlock(target, result.method_9564());
        }

        default public void registerFlammableBlock(class_2248 target, int encouragement, int flammability) {
            ((class_2358)class_2246.field_10036).method_10189(target, encouragement, flammability);
        }
    }
}

