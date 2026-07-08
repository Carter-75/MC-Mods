/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.village.VillagerProfession
 *  net.minecraft.village.TradeOffers$Factory
 */
package backported.updates.foundation.common.integration;

import backported.updates.foundation.common.integration.VillagerLevel;
import backported.updates.foundation.common.integration.fabric.TradeIntegrationImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.TradeOffers;

public class TradeIntegration {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerVillagerTrades(Consumer<Event> listener) {
        TradeIntegrationImpl.registerVillagerTrades(listener);
    }

    public static interface Event {
        public void registerTrade(VillagerProfession var1, VillagerLevel var2, TradeOffers.Factory ... var3);

        public void registerWandererTrade(boolean var1, TradeOffers.Factory ... var2);
    }
}

