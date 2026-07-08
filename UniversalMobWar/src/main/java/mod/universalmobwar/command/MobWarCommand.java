package mod.universalmobwar.command;
import net.minecraft.core.BlockPos;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.entity.MobWarlordEntity;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Mob;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.phys.Vec3;

import java.util.List;

/**
 * Provides /mobwar commands for managing the mod.
 */
public class MobWarCommand {
    
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registryAccess, Commands.CommandSelection environment) {
        dispatcher.register(Commands.literal("mobwar")
            .then(Commands.literal("help")
                .executes(MobWarCommand::executeHelp))
            .then(Commands.literal("stats")
                .executes(MobWarCommand::executeStats))
            .then(Commands.literal("reset")
                .requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
                .executes(MobWarCommand::executeReset))
            .then(Commands.literal("reload")
                .requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
                .executes(MobWarCommand::executeReload))
            .then(Commands.literal("summon")
                .requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
                .then(Commands.literal("warlord")
                    .executes(MobWarCommand::executeSummonWarlord)))
            .then(Commands.literal("raid")
                .requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
                .then(Commands.literal("forceboss")
                    .executes(MobWarCommand::executeForceRaidBoss)))
            .executes(MobWarCommand::executeHelp)

        );

        // Alias command requested: /universalmobwar reload
        dispatcher.register(Commands.literal("universalmobwar")
            .then(Commands.literal("help")
                .executes(MobWarCommand::executeHelp))
            .then(Commands.literal("reload")
                .requires(Commands.hasPermission(Commands.LEVEL_GAMEMASTERS))
                .executes(MobWarCommand::executeReload))
            .executes(MobWarCommand::executeHelp)
        );
    }
    
    private static int executeHelp(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        
        source.sendSuccess(() -> Component.literal(""), false);
        source.sendSuccess(() -> 
            Component.literal("═══════════════════════════════════════════════════")
                .styled(style -> style.withColor(ChatFormatting.GOLD).withBold(true)), false);
        source.sendSuccess(() -> 
            Component.literal("    UNIVERSAL MOB WAR - Commands")
                .styled(style -> style.withColor(ChatFormatting.RED).withBold(true)), false);
        source.sendSuccess(() -> 
            Component.literal("═══════════════════════════════════════════════════")
                .styled(style -> style.withColor(ChatFormatting.GOLD).withBold(true)), false);
        
        source.sendSuccess(() -> 
            Component.literal("Commands:").styled(style -> style.withColor(ChatFormatting.AQUA).withBold(true)), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /kit [player]")
                .styled(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(" - Max gear kit (self or OP target)")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /mobwar help")
                .styled(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(" - Show this help message")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /mobwar stats")
                .styled(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(" - Show nearby mob statistics")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /mobwar reset")
                .styled(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(" - Clear all mob targets (OP)")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /mobwar reload")
                .styled(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(" - Reload config file (OP)")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("Boss:").styled(style -> style.withColor(ChatFormatting.DARK_PURPLE).withBold(true)), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /mobwar summon warlord")
                .styled(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(" - Summon Mob Warlord boss (OP)")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /mobwar raid forceboss")
                .styled(style -> style.withColor(ChatFormatting.GREEN))
                .append(Component.literal(" - Guarantee boss in next raid (OP)")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /summon universalmobwar:mob_warlord")
                .styled(style -> style.withColor(ChatFormatting.LIGHT_PURPLE))
                .append(Component.literal(" - Summon the Mob Warlord boss")
                    .styled(style -> style.withColor(ChatFormatting.GRAY))), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • Or use Mob Warlord Spawn Egg")
                .styled(style -> style.withColor(ChatFormatting.LIGHT_PURPLE)), false);
        
        source.sendSuccess(() -> Component.literal(""), false);
        source.sendSuccess(() -> 
            Component.literal("Game Rules:").styled(style -> style.withColor(ChatFormatting.AQUA).withBold(true)), false);
        
        source.sendSuccess(() -> 
            Component.literal("  • /gamerule universalMobWarEnabled <true|false>")
                .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
        source.sendSuccess(() -> 
            Component.literal("  • /gamerule universalMobWarIgnoreSame <true|false>")
                .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
        source.sendSuccess(() -> 
            Component.literal("  • /gamerule universalMobWarTargetPlayers <true|false>")
                .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
        source.sendSuccess(() -> 
            Component.literal("  • /gamerule universalMobWarNeutralAggressive <true|false>")
                .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
        source.sendSuccess(() -> 
            Component.literal("  • /gamerule universalMobWarAlliances <true|false>")
                .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
        source.sendSuccess(() -> 
            Component.literal("  • /gamerule universalMobWarEvolution <true|false>")
                .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
        source.sendSuccess(() -> 
            Component.literal("  • /gamerule universalMobWarRangeMultiplier <1-10000>")
                .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
        source.sendSuccess(() -> 
            Component.literal("    (1=0.01x, 100=1.0x, 10000=100.0x range)")
                .styled(style -> style.withColor(ChatFormatting.DARK_GRAY)), false);
        
        source.sendSuccess(() -> 
            Component.literal("═══════════════════════════════════════════════════")
                .styled(style -> style.withColor(ChatFormatting.GOLD).withBold(true)), false);
        
        return 1;
    }
    
    private static int executeStats(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        CommandSourceStack source = context.getSource();
        ServerLevel world = source.getLevel();
        // Removed unused variable: BlockPos pos = BlockPos.ofFloored(source.getPosition());
        
        // Find mobs within 50 blocks
        List<Mob> nearbyMobs = world.getEntitiesOfClass(
            Mob.class,
            source.getPlayer().getBoundingBox().inflate(50),
            mob -> mob.isAlive()
        );
        
        if (nearbyMobs.isEmpty()) {
            source.sendSuccess(() -> 
                Component.literal("No mobs found within 50 blocks.")
                    .styled(style -> style.withColor(ChatFormatting.YELLOW)), false);
            return 0;
        }
        
        source.sendSuccess(() -> 
            Component.literal("═══ Nearby Mob Statistics ═══")
                .styled(style -> style.withColor(ChatFormatting.GOLD).withBold(true)), false);
        
        int highestLevel = 0;
        Mob topMob = null;
        
        for (Mob mob : nearbyMobs) {
            MobWarData data = MobWarData.get(mob);
            if (data.getLevel() > highestLevel) {
                highestLevel = data.getLevel();
                topMob = mob;
            }
        }
        
        source.sendSuccess(() -> 
            Component.literal("Total Mobs: ")
                .styled(style -> style.withColor(ChatFormatting.AQUA))
                .append(Component.literal(String.valueOf(nearbyMobs.size()))
                    .styled(style -> style.withColor(ChatFormatting.WHITE))), false);
        
        if (topMob != null) {
            Mob finalTopMob = topMob;
            int finalHighestLevel = highestLevel;
            MobWarData topData = MobWarData.get(topMob);
            
            source.sendSuccess(() -> 
                Component.literal("Strongest Mob: ")
                    .styled(style -> style.withColor(ChatFormatting.AQUA))
                    .append(Component.literal(finalTopMob.getType().getName().getString())
                        .styled(style -> style.withColor(ChatFormatting.RED).withBold(true)))
                    .append(Component.literal(" (Level " + finalHighestLevel + ", " + topData.getKillCount() + " kills)")
                        .styled(style -> style.withColor(ChatFormatting.YELLOW))), false);
        }
        
        // Count mobs with levels
        long veteranMobs = nearbyMobs.stream()
            .filter(mob -> MobWarData.get(mob).getLevel() >= 10)
            .count();
        
        if (veteranMobs > 0) {
            long finalVeteranMobs = veteranMobs;
            source.sendSuccess(() -> 
                Component.literal("Veteran Mobs (Lv10+): ")
                    .styled(style -> style.withColor(ChatFormatting.AQUA))
                    .append(Component.literal(String.valueOf(finalVeteranMobs))
                        .styled(style -> style.withColor(ChatFormatting.RED))), false);
        }
        
        source.sendSuccess(() -> 
            Component.literal("═══════════════════════════")
                .styled(style -> style.withColor(ChatFormatting.GOLD).withBold(true)), false);
        
        return 1;
    }
    
    private static int executeReset(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        ServerLevel world = source.getLevel();
        
        // Get all mob entities in the world
        int count = 0;
        for (net.minecraft.world.entity.Entity entity : world.getAllEntities()) {
            if (entity instanceof Mob mob) {
                mob.setTarget(null);
                count++;
            }
        }
        
        int finalCount = count;
        source.sendSuccess(() -> 
            Component.literal("Reset targets for " + finalCount + " mobs.")
                .styled(style -> style.withColor(ChatFormatting.GREEN)), true);
        
        return count;
    }
    
    private static int executeReload(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        ModConfig config = ModConfig.reload();

        source.sendSuccess(() -> Component.literal("Universal Mob War config reloaded from disk.")
            .styled(style -> style.withColor(ChatFormatting.GREEN).withBold(true)), true);

        // Print all config fields (excluding lists for brevity)
        if (config != null) {
            source.sendSuccess(() -> Component.literal("--- Universal Mob War Config ---")
                .styled(style -> style.withColor(ChatFormatting.AQUA)), false);

            source.sendSuccess(() -> Component.literal("modEnabled: ").append(Component.literal(String.valueOf(config.modEnabled)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("targetingEnabled: ").append(Component.literal(String.valueOf(config.targetingEnabled)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("targetPlayers: ").append(Component.literal(String.valueOf(config.targetPlayers)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("ignoreSameSpecies: ").append(Component.literal(String.valueOf(config.ignoreSameSpecies)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("neutralMobsAlwaysAggressive: ").append(Component.literal(String.valueOf(config.neutralMobsAlwaysAggressive)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("disableNaturalMobSpawns: ").append(Component.literal(String.valueOf(config.disableNaturalMobSpawns)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("limitNaturalMobSpawns: ").append(Component.literal(String.valueOf(config.limitNaturalMobSpawns)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("naturalSpawnCapPerSimulationDistance: ").append(Component.literal(String.valueOf(config.naturalSpawnCapPerSimulationDistance)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("rangeMultiplierPercent: ").append(Component.literal(String.valueOf(config.rangeMultiplierPercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("allianceEnabled: ").append(Component.literal(String.valueOf(config.allianceEnabled)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("weakAllianceDurationMs: ").append(Component.literal(String.valueOf(config.weakAllianceDurationMs)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("strongAllianceDurationMs: ").append(Component.literal(String.valueOf(config.strongAllianceDurationMs)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("allianceBreakChancePercent: ").append(Component.literal(String.valueOf(config.allianceBreakChancePercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("strongAllianceBreakChancePercent: ").append(Component.literal(String.valueOf(config.strongAllianceBreakChancePercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("scalingEnabled: ").append(Component.literal(String.valueOf(config.scalingEnabled)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("dayScalingMultiplierPercent: ").append(Component.literal(String.valueOf(config.dayScalingMultiplierPercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("killScalingMultiplierPercent: ").append(Component.literal(String.valueOf(config.killScalingMultiplierPercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("buyChancePercent: ").append(Component.literal(String.valueOf(config.buyChancePercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("saveChancePercent: ").append(Component.literal(String.valueOf(config.saveChancePercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("maxUpgradeIterations: ").append(Component.literal(String.valueOf(config.maxUpgradeIterations)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("allowBossScaling: ").append(Component.literal(String.valueOf(config.allowBossScaling)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("scaleMobXpDropsWithSpentPoints: ").append(Component.literal(String.valueOf(config.scaleMobXpDropsWithSpentPoints)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("spentPointsPerXpBonusStep: ").append(Component.literal(String.valueOf(config.spentPointsPerXpBonusStep)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("xpBonusPercentPerStep: ").append(Component.literal(String.valueOf(config.xpBonusPercentPerStep)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("manualWorldDayOverride: ").append(Component.literal(String.valueOf(config.manualWorldDayOverride)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("upgradeIntervalTicks: ").append(Component.literal(String.valueOf(config.upgradeIntervalTicks)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("forceSpendAllOnSpawn: ").append(Component.literal(String.valueOf(config.forceSpendAllOnSpawn)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("maxSpawnUpgradeIterations: ").append(Component.literal(String.valueOf(config.maxSpawnUpgradeIterations)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("forceSyncSpawnUpgrade: ").append(Component.literal(String.valueOf(config.forceSyncSpawnUpgrade)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("logSpawnPointSummary: ").append(Component.literal(String.valueOf(config.logSpawnPointSummary)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("allowModdedEnchantments: ").append(Component.literal(String.valueOf(config.allowModdedEnchantments)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("warlordEnabled: ").append(Component.literal(String.valueOf(config.warlordEnabled)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("alwaysSpawnWarlordOnFinalWave: ").append(Component.literal(String.valueOf(config.alwaysSpawnWarlordOnFinalWave)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("warlordSpawnChance: ").append(Component.literal(String.valueOf(config.warlordSpawnChance)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("warlordMinRaidLevel: ").append(Component.literal(String.valueOf(config.warlordMinRaidLevel)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("warlordMinionCount: ").append(Component.literal(String.valueOf(config.warlordMinionCount)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("warlordHealthMultiplierPercent: ").append(Component.literal(String.valueOf(config.warlordHealthMultiplierPercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("warlordDamageMultiplierPercent: ").append(Component.literal(String.valueOf(config.warlordDamageMultiplierPercent)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("performanceMode: ").append(Component.literal(String.valueOf(config.performanceMode)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("enableBatching: ").append(Component.literal(String.valueOf(config.enableBatching)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("enableAsyncTasks: ").append(Component.literal(String.valueOf(config.enableAsyncTasks)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("maxConcurrentUpgradeJobs: ").append(Component.literal(String.valueOf(config.maxConcurrentUpgradeJobs)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("upgradeProcessingTimeMs: ").append(Component.literal(String.valueOf(config.upgradeProcessingTimeMs)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("targetingCacheMs: ").append(Component.literal(String.valueOf(config.targetingCacheMs)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("targetingMaxQueriesPerTick: ").append(Component.literal(String.valueOf(config.targetingMaxQueriesPerTick)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("mobDataSaveDebounceMs: ").append(Component.literal(String.valueOf(config.mobDataSaveDebounceMs)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("cleanupNonPlayerGroundProjectiles: ").append(Component.literal(String.valueOf(config.cleanupNonPlayerGroundProjectiles)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("cleanupNonPlayerGroundProjectilesIntervalSeconds: ").append(Component.literal(String.valueOf(config.cleanupNonPlayerGroundProjectilesIntervalSeconds)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("cleanupNonPlayerGroundProjectilesMinAgeTicks: ").append(Component.literal(String.valueOf(config.cleanupNonPlayerGroundProjectilesMinAgeTicks)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("cleanupNonPlayerGroundProjectilesMaxPerWorldPerRun: ").append(Component.literal(String.valueOf(config.cleanupNonPlayerGroundProjectilesMaxPerWorldPerRun)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("showTargetLines: ").append(Component.literal(String.valueOf(config.showTargetLines)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("showLevelParticles: ").append(Component.literal(String.valueOf(config.showLevelParticles)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("disableParticles: ").append(Component.literal(String.valueOf(config.disableParticles)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("minFpsForVisuals: ").append(Component.literal(String.valueOf(config.minFpsForVisuals)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("maxParticlesPerConnection: ").append(Component.literal(String.valueOf(config.maxParticlesPerConnection)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("maxDrawnMinionConnections: ").append(Component.literal(String.valueOf(config.maxDrawnMinionConnections)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("debugUpgradeLog: ").append(Component.literal(String.valueOf(config.debugUpgradeLog)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
            source.sendSuccess(() -> Component.literal("debugLogging: ").append(Component.literal(String.valueOf(config.debugLogging)).styled(s -> s.withColor(ChatFormatting.YELLOW))), false);
        }

        return 1;
    }
    
    private static int executeSummonWarlord(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        ServerLevel world = source.getLevel();
        Vec3 pos = source.getPosition();
        
        try {
            // Create the Mob Warlord
            MobWarlordEntity warlord = new MobWarlordEntity(UniversalMobWarMod.MOB_WARLORD, world);
            warlord.snapTo(pos.x, pos.y, pos.z, 0.0f, 0.0f);
            warlord.finalizeSpawn(world, world.getCurrentDifficultyAt(BlockPos.containing(pos)), EntitySpawnReason.COMMAND, null);
            
            world.addFreshEntity(warlord);
            
            source.sendSuccess(() -> 
                Component.literal("Summoned the Mob Warlord boss at ")
                    .styled(style -> style.withColor(ChatFormatting.DARK_PURPLE))
                    .append(Component.literal(String.format("%.1f, %.1f, %.1f", pos.x, pos.y, pos.z))
                        .styled(style -> style.withColor(ChatFormatting.GOLD)))
                    .append(Component.literal("!")
                        .styled(style -> style.withColor(ChatFormatting.DARK_PURPLE))), 
                true
            );
            
            return 1;
        } catch (Exception e) {
            source.sendFailure(Component.literal("Failed to summon Mob Warlord: " + e.getMessage()));
            return 0;
        }
    }
    
    private static int executeForceRaidBoss(CommandContext<CommandSourceStack> context) {
        CommandSourceStack source = context.getSource();
        
        // This is a simple flag setter - actual logic is in RaidBossSpawnCommand
        mod.universalmobwar.command.RaidBossSpawnCommand.shouldForceSpawn();
        
        source.sendSuccess(() -> 
            Component.literal("[SUCCESS] Next raid will GUARANTEE a Mob Warlord spawn on the final wave!")
                .styled(style -> style.withColor(ChatFormatting.GREEN).withBold(true)), 
            true
        );
        
        source.sendSuccess(() -> 
            Component.literal("  Start a raid to summon the boss!")
                .styled(style -> style.withColor(ChatFormatting.GRAY)), 
            false
        );
        
        return 1;
    }
}

