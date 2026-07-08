/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper
 *  net.minecraft.class_3852
 *  net.minecraft.class_3853$class_1652
 */
package backported.updates.foundation.common.integration.fabric;

import backported.updates.foundation.common.integration.TradeIntegration;
import backported.updates.foundation.common.integration.VillagerLevel;
import java.util.Collections;
import java.util.function.Consumer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.class_3852;
import net.minecraft.class_3853;

public class TradeIntegrationImpl {
    public static void registerVillagerTrades(Consumer<TradeIntegration.Event> listener) {
        listener.accept(new TradeIntegration.Event(){

            @Override
            public void registerTrade(class_3852 profession, VillagerLevel level, class_3853.class_1652 ... trades) {
                TradeOfferHelper.registerVillagerOffers((class_3852)profession, (int)level.getValue(), listings -> Collections.addAll(listings, trades));
            }

            @Override
            public void registerWandererTrade(boolean rare, class_3853.class_1652 ... trades) {
                TradeOfferHelper.registerWanderingTraderOffers((int)(rare ? 2 : 1), listings -> Collections.addAll(listings, trades));
            }
        });
    }
}

