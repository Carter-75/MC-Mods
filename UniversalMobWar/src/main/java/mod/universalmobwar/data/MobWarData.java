package mod.universalmobwar.data;

import net.minecraft.world.entity.Mob;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.UUIDUtil;

import java.util.*;

/**
 * Tracks mob evolution data, alliance relationships, and combat statistics.
 * This data is stored per-mob using entity NBT data.
 */
public class MobWarData {
    
    // Evolution system
    private int killCount = 0;
    private int level = 0;
    private static final int MAX_LEVEL = 100;
    private static final int KILLS_PER_LEVEL = 3;
    
    // Alliance system - stores UUIDs of allies
    private final Set<UUID> allies = new HashSet<>();
    private UUID currentTarget = null;
    private long lastTargetChangeTime = 0;
    
    // Combat stats
    private double damageDealt = 0;
    private double damageTaken = 0;

    // Skill Tree Data
    private double skillPoints = 0;
    private double spentPoints = 0;
    private CompoundTag skillData = new CompoundTag();

    public MobWarData() {}

    // Skill Tree Methods
    public double getSkillPoints() { return skillPoints; }
    public void setSkillPoints(double points) { this.skillPoints = points; }
    public double getSpentPoints() { return spentPoints; }
    public void setSpentPoints(double points) { this.spentPoints = points; }
    public CompoundTag getSkillData() { return skillData; }
    public void setSkillData(CompoundTag data) { this.skillData = data; }
    
    public PowerProfile getPowerProfile() {
        if (skillData == null || skillData.isEmpty()) return null;
        return PowerProfile.fromNbt(skillData);
    }
    
    // Evolution methods
    public void addKill() {
        killCount++;
        updateLevel();
    }
    
    private void updateLevel() {
        int newLevel = Math.min(killCount / KILLS_PER_LEVEL, MAX_LEVEL);
        if (newLevel > level) {
            level = newLevel;
        }
    }
    
    public int getLevel() {
        return level;
    }
    
    public int getKillCount() {
        return killCount;
    }
    
    public static int getMaxLevel() {
        return MAX_LEVEL;
    }
    
    // Stat bonuses based on level
    public double getHealthBonus() {
        return level * 0.5; // +0.5 hearts per level
    }
    
    public double getDamageBonus() {
        return level * 0.1; // +10% damage per level
    }
    
    public double getSpeedBonus() {
        return level * 0.005; // +0.5% speed per level
    }
    
    public double getArmorBonus() {
        return level * 0.1; // +0.1 armor per level
    }
    
    public double getKnockbackResistanceBonus() {
        return Math.min(level * 0.01, 1.0); // +1% per level, max 100%
    }
    
    // Alliance methods
    public void addAlly(UUID uuid) {
        allies.add(uuid);
    }
    
    public void removeAlly(UUID uuid) {
        allies.remove(uuid);
    }
    
    public boolean isAlly(UUID uuid) {
        return allies.contains(uuid);
    }
    
    public Set<UUID> getAllies() {
        return new HashSet<>(allies);
    }
    
    public void clearAllies() {
        allies.clear();
    }
    
    // Target tracking
    public void setCurrentTarget(UUID target) {
        if (currentTarget == null || !currentTarget.equals(target)) {
            currentTarget = target;
            lastTargetChangeTime = System.currentTimeMillis();
        }
    }
    
    public UUID getCurrentTarget() {
        return currentTarget;
    }
    
    public long getTimeSinceTargetChange() {
        return System.currentTimeMillis() - lastTargetChangeTime;
    }
    
    public void clearTarget() {
        currentTarget = null;
    }
    
    // Combat stats
    public void addDamageDealt(double damage) {
        damageDealt += damage;
    }
    
    public void addDamageTaken(double damage) {
        damageTaken += damage;
    }
    
    public double getDamageDealt() {
        return damageDealt;
    }
    
    public double getDamageTaken() {
        return damageTaken;
    }
    
    // NBT serialization
    public CompoundTag writeNbt() {
        CompoundTag nbt = new CompoundTag();
        
        nbt.putInt("killCount", killCount);
        nbt.putInt("level", level);
        nbt.putDouble("damageDealt", damageDealt);
        nbt.putDouble("damageTaken", damageTaken);
        
        // Skill Tree Persistence
        nbt.putDouble("skillPoints", skillPoints);
        nbt.putDouble("spentPoints", spentPoints);
        nbt.put("skillData", skillData);
        
        if (currentTarget != null) {
            nbt.putIntArray("currentTarget", UUIDUtil.uuidToIntArray(currentTarget));
            nbt.putLong("lastTargetChangeTime", lastTargetChangeTime);
        }
        
        // Store allies as long array (2 longs per UUID)
        if (!allies.isEmpty()) {
            long[] allyArray = new long[allies.size() * 2];
            int i = 0;
            for (UUID uuid : allies) {
                allyArray[i++] = uuid.getMostSignificantBits();
                allyArray[i++] = uuid.getLeastSignificantBits();
            }
            nbt.putLongArray("allies", allyArray);
        }
        
        return nbt;
    }
    
    public void readNbt(CompoundTag nbt) {
        killCount = nbt.getIntOr("killCount", 0);
        level = nbt.getIntOr("level", 0);
        damageDealt = nbt.getDoubleOr("damageDealt", 0.0);
        damageTaken = nbt.getDoubleOr("damageTaken", 0.0);
        
        // Skill Tree Persistence
        if (nbt.contains("skillPoints")) skillPoints = nbt.getDoubleOr("skillPoints", 0.0);
        if (nbt.contains("spentPoints")) spentPoints = nbt.getDoubleOr("spentPoints", 0.0);
        if (nbt.contains("skillData")) skillData = nbt.getCompoundOrEmpty("skillData");
        
        if (nbt.contains("currentTarget")) {
            int[] arr = nbt.getIntArray("currentTarget").orElse(null);
            if (arr != null && arr.length == 4) {
                currentTarget = UUIDUtil.uuidFromIntArray(arr);
                lastTargetChangeTime = nbt.getLongOr("lastTargetChangeTime", 0L);
            }
        }
        
        if (nbt.contains("allies")) {
            long[] allyArray = nbt.getLongArray("allies").orElse(new long[0]);
            allies.clear();
            for (int i = 0; i + 1 < allyArray.length; i += 2) {
                UUID uuid = new UUID(allyArray[i], allyArray[i + 1]);
                allies.add(uuid);
            }
        }
    }
    
    // Static helper to get or create data for a mob
    private static final String NBT_KEY = "UniversalMobWarData";
    
    public static MobWarData get(Mob mob) {
        if (mob instanceof IMobWarDataHolder holder) {
            return holder.getMobWarData();
        }
        
        // Fallback (Should not happen with Mixin): entities no longer expose a
        // CompoundTag-based writeNbt in 26.2, so return fresh data.
        return new MobWarData();
    }
    
    public static void save(Mob mob, MobWarData data) {
        if (mob instanceof IMobWarDataHolder holder) {
            holder.setMobWarData(data);
            return;
        }
        
        // Fallback: no CompoundTag entity persistence path in 26.2; the mixin
        // holder is the authoritative store. Nothing to do here.
    }
}
