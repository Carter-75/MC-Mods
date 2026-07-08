package mod.realtimeclock;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.ZonedDateTime;

public class RealTimeClockMod implements ModInitializer {

    public static final String MOD_ID = "realtimeclock";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static final long TICKS_PER_DAY = 24000L;
    private static final long MIDNIGHT_OFFSET = 18000L;

    public static final GameRules.Key<GameRules.BooleanRule> REALTIME_CLOCK_RULE = GameRuleRegistry.register(
        "realtimeClockSync",
        GameRules.Category.UPDATES,
        GameRuleFactory.createBooleanRule(false, RealTimeClockMod::handleRuleChange)
    );

    @Override
    public void onInitialize() {
        ServerTickEvents.END_WORLD_TICK.register(world -> {
            if (world.getGameRules().getBoolean(REALTIME_CLOCK_RULE)) {
                alignWorld(world);
            }
        });

        ServerLifecycleEvents.SERVER_STARTED.register(server -> server.execute(() -> applyRuleToAllWorlds(server)));

        LOGGER.info("Realtime Clock gamerule loaded");
    }

    private static void handleRuleChange(MinecraftServer server, GameRules.BooleanRule rule) {
        if (server == null || !rule.get()) {
            return;
        }
        server.execute(() -> applyRuleToAllWorlds(server));
    }

    private static void applyRuleToAllWorlds(MinecraftServer server) {
        for (ServerWorld world : server.getWorlds()) {
            if (world.getGameRules().getBoolean(REALTIME_CLOCK_RULE)) {
                alignWorld(world);
            }
        }
    }

    private static void alignWorld(ServerWorld world) {
        long desiredTime = calculateAbsoluteTime();
        if (world.getTimeOfDay() != desiredTime) {
            world.setTimeOfDay(desiredTime);
        }
    }

    private static long calculateAbsoluteTime() {
        ZonedDateTime now = ZonedDateTime.now();
        long nanosInDay = Duration.ofDays(1).toNanos();
        long nanosIntoDay = now.toLocalTime().toNanoOfDay();
        double dayFraction = nanosIntoDay / (double) nanosInDay;
        long ticksForCurrentTime = (long) Math.floor(dayFraction * TICKS_PER_DAY);
        long adjustedTicks = (ticksForCurrentTime + MIDNIGHT_OFFSET) % TICKS_PER_DAY;
        long epochDays = now.toLocalDate().toEpochDay();
        return epochDays * TICKS_PER_DAY + adjustedTicks;
    }
}
