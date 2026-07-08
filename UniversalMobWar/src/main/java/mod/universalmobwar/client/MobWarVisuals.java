package mod.universalmobwar.client;

import mod.universalmobwar.data.MobWarData;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

/**
 * Client-side helper for generating formatted mob text when debugging overlays need it.
 */
public class MobWarVisuals {
        // FPS safeguard: disables some visuals if FPS is low
        private static boolean isFpsAcceptable() {
            // Placeholder: Replace with actual FPS check if available
            // For now, always return true (no FPS API in vanilla)
            return true;
        }

    /**
     * Gets display text for a mob showing their level and stats.
     */
    public static Component getMobDisplayName(Mob mob) {
        if (!isFpsAcceptable()) {
            return mob.getDisplayName();
        }
        MobWarData data = MobWarData.get(mob);
        int level = data.getLevel();
        if (level == 0) {
            return mob.getDisplayName();
        }
        // Format: [Lv.5] Zombie ⚔
        MutableComponent levelText = Component.literal("[Lv." + level + "] ")
            .withStyle(style -> style.withColor(getLevelColor(level)).withBold(true));
        levelText.append(mob.getDisplayName());
        // Add weapon indicator if mob has weapon
        if (!mob.getMainHandItem().isEmpty()) {
            levelText.append(Component.literal(" ⚔").withStyle(style -> style.withColor(ChatFormatting.GOLD)));
        }
        return levelText;
    }

    /**
     * Gets color based on mob level.
     */
    private static ChatFormatting getLevelColor(int level) {
        if (level >= 50) return ChatFormatting.DARK_RED;
        if (level >= 30) return ChatFormatting.RED;
        if (level >= 20) return ChatFormatting.GOLD;
        if (level >= 10) return ChatFormatting.YELLOW;
        return ChatFormatting.GREEN;
    }

    /**
     * Gets status text for a mob (current target info).
     */
    public static Component getMobStatusText(Mob mob) {
        if (!isFpsAcceptable()) {
            return Component.literal("").withStyle(style -> style.withColor(ChatFormatting.GRAY));
        }
        LivingEntity target = mob.getTarget();
        if (target == null) {
            return Component.literal("Idle").withStyle(style -> style.withColor(ChatFormatting.GRAY));
        }
        return Component.literal("→ ")
            .withStyle(style -> style.withColor(ChatFormatting.RED))
            .append(Component.literal(target.getDisplayName().getString())
                .withStyle(style -> style.withColor(ChatFormatting.WHITE)));
    }

    /**
     * Gets detailed stats text for tooltips.
     */
    public static Component getMobStatsText(Mob mob) {
        if (!isFpsAcceptable()) {
            return Component.literal("");
        }
        MobWarData data = MobWarData.get(mob);
        return Component.literal("Level: " + data.getLevel())
            .withStyle(style -> style.withColor(ChatFormatting.YELLOW))
            .append(Component.literal(" | Kills: " + data.getKillCount())
                .withStyle(style -> style.withColor(ChatFormatting.RED)))
            .append(Component.literal(" | Allies: " + data.getAllies().size())
                .withStyle(style -> style.withColor(ChatFormatting.AQUA)));
    }
}
