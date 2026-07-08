package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.command.RaidBossSpawnCommand;
import mod.universalmobwar.config.ModConfig;
import mod.universalmobwar.entity.MobWarlordEntity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.raids.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * WARLORD SYSTEM - Raid Integration
 * 
 * Injects the Mob Warlord boss into the final raid wave.
 * 
 * This system works independently and can be enabled/disabled via:
 * - Config: warlordEnabled
 * 
 * Does NOT depend on: Targeting, Alliance, or Scaling systems
 */
@Mixin(Raid.class)
public abstract class RaidSpawningMixin {
    
    @Shadow
    private int groupsSpawned;
    
    @Shadow
    private ServerLevel level;
    
    @Shadow
    private BlockPos center;
    
    /**
     * Injects boss spawning logic into the raid wave spawning.
     * Only spawns on final wave (wave 6+) with configurable chance.
     * Can be forced with /mobwar raid forceboss command.
     */
    @Inject(method = "spawnGroup", at = @At("TAIL"))
    private void universalmobwar$spawnWarlordBoss(BlockPos pos, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("RaidSpawningMixin#spawnWarlordBoss", () -> {
            // Check if warlord system is enabled
            ModConfig config = ModConfig.getInstance();
            if (!config.isWarlordActive()) return;
            
            // Only spawn on final waves (configurable minimum raid level)
            if (this.groupsSpawned < config.warlordMinRaidLevel) return;
            
            // Check if force spawn is active (from command)
            boolean forceSpawn = RaidBossSpawnCommand.shouldForceSpawn();
            
            // Check if always spawn on final wave is enabled
            if (config.alwaysSpawnWarlordOnFinalWave) {
                forceSpawn = true;
            }
            
            // Configurable spawn chance (default 25%) OR forced by command
            double spawnChance = config.warlordSpawnChance / 100.0;
            if (!forceSpawn && Math.random() > spawnChance) return;
            
            // Find suitable spawn position near raid center
            BlockPos spawnPos = findSuitableSpawnPos(this.center);
            if (spawnPos == null) return;
            
            // Create and spawn the Mob Warlord
            MobWarlordEntity warlord = new MobWarlordEntity(UniversalMobWarMod.MOB_WARLORD, this.level);
            warlord.moveTo(
                spawnPos.getX() + 0.5, 
                spawnPos.getY(), 
                spawnPos.getZ() + 0.5, 
                0.0f, 
                0.0f
            );
            warlord.finalizeSpawn(this.level, this.level.getCurrentDifficultyAt(spawnPos), EntitySpawnReason.EVENT, null);
            
            // Mark as raid boss - this changes targeting behavior
            warlord.setRaidBoss(true);
            warlord.setPersistenceRequired();
            
            boolean spawned = this.level.addFreshEntity(warlord);
            
            if (spawned) {
                // Broadcast to all players
                this.level.players().forEach(player -> {
                    player.sendSystemMessage(
                        net.minecraft.network.chat.Component.literal("")
                            .append(net.minecraft.network.chat.Component.literal("═══════════════════════════════════").withStyle(style -> style.withColor(net.minecraft.ChatFormatting.DARK_RED).withBold(true)))
                            .append(net.minecraft.network.chat.Component.literal("\n"))
                            .append(net.minecraft.network.chat.Component.literal("    💀 THE MOB WARLORD HAS JOINED THE RAID! 💀").withStyle(style -> style.withColor(net.minecraft.ChatFormatting.RED).withBold(true)))
                            .append(net.minecraft.network.chat.Component.literal("\n"))
                            .append(net.minecraft.network.chat.Component.literal("═══════════════════════════════════").withStyle(style -> style.withColor(net.minecraft.ChatFormatting.DARK_RED).withBold(true)))
                    );
                    
                    // Play dramatic sound (server-side)
                    player.playNotifySound(
                        net.minecraft.sounds.SoundEvents.WITHER_SPAWN,
                        net.minecraft.sounds.SoundSource.HOSTILE,
                        1.0f,
                        0.5f
                    );
                });
                
                UniversalMobWarMod.LOGGER.info("Mob Warlord spawned in raid at {}", spawnPos);
            }
        });
    }
    
    /**
     * Finds a suitable spawn position near the raid center.
     */
    private BlockPos findSuitableSpawnPos(BlockPos center) {
        // Try to find a valid spawn position within 32 blocks of center
        for (int attempt = 0; attempt < 10; attempt++) {
            int offsetX = (int)((Math.random() - 0.5) * 64); // ±32 blocks
            int offsetZ = (int)((Math.random() - 0.5) * 64);
            
            BlockPos testPos = center.offset(offsetX, 0, offsetZ);
            
            // Find ground level
            BlockPos groundPos = this.level.getHeightmapPos(net.minecraft.world.level.levelgen.Heightmap.Types.WORLD_SURFACE, testPos);
            
            // Check if position is valid (solid ground, enough space above)
            if (this.level.getBlockState(groundPos.below()).isSolidRender()) {
                if (this.level.isEmptyBlock(groundPos) && this.level.isEmptyBlock(groundPos.above()) && this.level.isEmptyBlock(groundPos.above(2))) {
                    return groundPos;
                }
            }
        }
        
        // Fallback to center if no valid position found
        return this.level.getHeightmapPos(net.minecraft.world.level.levelgen.Heightmap.Types.WORLD_SURFACE, center);
    }
}
