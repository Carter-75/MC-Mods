/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3917
 *  net.minecraft.class_7923
 */
package net._void.civilizations.screen;

import net._void.civilizations.Civilizations;
import net._void.civilizations.screen.TombstoneScreenHandler;
import net._void.civilizations.screen.TradingStationScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3917;
import net.minecraft.class_7923;

public class ModScreenHandlers {
    public static final class_3917<TradingStationScreenHandler> TRADING_STATION_SCREEN_HANDLER = (class_3917)class_2378.method_10230((class_2378)class_7923.field_41187, (class_2960)new class_2960("civilizations", "trading_station"), (Object)new ExtendedScreenHandlerType(TradingStationScreenHandler::new));
    public static final class_3917<TombstoneScreenHandler> TOMBSTONE_SCREEN_HANDLER = (class_3917)class_2378.method_10230((class_2378)class_7923.field_41187, (class_2960)new class_2960("civilizations", "tombstone"), (Object)new ExtendedScreenHandlerType(TombstoneScreenHandler::new));

    public static void registerScreenHandlers() {
        Civilizations.LOGGER.info("Registering Screen Handlers for civilizations");
    }
}

