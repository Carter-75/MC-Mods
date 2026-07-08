/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper
 *  net.minecraft.village.VillagerProfession
 *  net.minecraft.village.TradeOffers$Factory
 */
package backported.updates.foundation.common.integration.fabric;

import backported.updates.foundation.common.integration.TradeIntegration;
import backported.updates.foundation.common.integration.VillagerLevel;
import java.util.Collections;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.village.VillagerProfession;
import net.minecraft.village.TradeOffers;

public class TradeIntegrationImpl {
    public static void registerVillagerTrades(Consumer<TradeIntegration.Event> listener) {
        listener.accept(new TradeIntegration.Event(){

            @Override
            public void registerTrade(VillagerProfession profession, VillagerLevel level, TradeOffers.Factory ... trades) {
                TradeOfferHelper.registerVillagerOffers((VillagerProfession)profession, (int)level.getValue(), listings -> Collections.addAll(listings, trades));
            }

            @Override
            public void registerWandererTrade(boolean rare, TradeOffers.Factory ... trades) {
                TradeOfferHelper.registerWanderingTraderOffers((int)(rare ? 2 : 1), listings -> Collections.addAll(listings, trades));
            }
        });
    }
}

