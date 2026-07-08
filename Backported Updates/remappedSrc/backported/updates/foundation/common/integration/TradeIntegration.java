/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_3852
 *  net.minecraft.class_3853$class_1652
 */
package backported.updates.foundation.common.integration;

import backported.updates.foundation.common.integration.VillagerLevel;
import backported.updates.foundation.common.integration.fabric.TradeIntegrationImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import net.minecraft.class_3852;
import net.minecraft.class_3853;

public class TradeIntegration {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerVillagerTrades(Consumer<Event> listener) {
        TradeIntegrationImpl.registerVillagerTrades(listener);
    }

    public static interface Event {
        public void registerTrade(class_3852 var1, VillagerLevel var2, class_3853.class_1652 ... var3);

        public void registerWandererTrade(boolean var1, class_3853.class_1652 ... var2);
    }
}

