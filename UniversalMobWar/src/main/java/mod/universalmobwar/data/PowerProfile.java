package mod.universalmobwar.data;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

/**
 * PowerProfile: Stores all scaling/progression data for a mob (global system).
 * This is separate from MobWarData for modularity and future expansion.
 */
public class PowerProfile {
    // Base stats (copied from entity on spawn)
    public double baseHealth;
    public double baseDamage;
    public double baseSpeed;
    public double baseArmor;
    public double baseKnockbackResist;

    // Scaling points
    public double dayScalingPoints;
    public double killScalingPoints;
    public double totalPoints;

    // Upgrades
    public List<String> chosenUpgrades = new ArrayList<>();
    public String priorityPath = "universal";
    public int tierLevel = 0;

    // Archetype (for modded mob support)
    public String archetype = "unknown";
    public java.util.Set<String> categories = new java.util.HashSet<>();
    public java.util.Map<String, Integer> specialSkills = new java.util.HashMap<>();
    public boolean isMaxed = false;

    // For deterministic behavior
    public long lastUpdateTick = 0;

    public PowerProfile() {}

    /**
     * Serializes this PowerProfile to NBT for persistent storage.
     */
    public CompoundTag writeNbt() {
        CompoundTag nbt = new CompoundTag();
        nbt.putDouble("baseHealth", baseHealth);
        nbt.putDouble("baseDamage", baseDamage);
        nbt.putDouble("baseSpeed", baseSpeed);
        nbt.putDouble("baseArmor", baseArmor);
        nbt.putDouble("baseKnockbackResist", baseKnockbackResist);
        nbt.putDouble("dayScalingPoints", dayScalingPoints);
        nbt.putDouble("killScalingPoints", killScalingPoints);
        nbt.putDouble("totalPoints", totalPoints);
        nbt.putInt("tierLevel", tierLevel);
        nbt.putString("priorityPath", priorityPath);
        nbt.putString("archetype", archetype);
        nbt.putLong("lastUpdateTick", lastUpdateTick);
        nbt.putBoolean("isMaxed", isMaxed);
        ListTag upgrades = new ListTag();
        for (String id : chosenUpgrades) {
            upgrades.add(net.minecraft.nbt.StringTag.valueOf(id));
        }
        nbt.put("chosenUpgrades", upgrades);
        
        ListTag cats = new ListTag();
        for (String c : categories) {
            cats.add(net.minecraft.nbt.StringTag.valueOf(c));
        }
        nbt.put("categories", cats);
        
        CompoundTag skills = new CompoundTag();
        for (java.util.Map.Entry<String, Integer> entry : specialSkills.entrySet()) {
            skills.putInt(entry.getKey(), entry.getValue());
        }
        nbt.put("specialSkills", skills);
        
        return nbt;
    }

    /**
     * Loads a PowerProfile from NBT.
     */
    public static PowerProfile fromNbt(CompoundTag nbt) {
        PowerProfile profile = new PowerProfile();
        profile.baseHealth = nbt.getDoubleOr("baseHealth", 0.0);
        profile.baseDamage = nbt.getDoubleOr("baseDamage", 0.0);
        profile.baseSpeed = nbt.getDoubleOr("baseSpeed", 0.0);
        profile.baseArmor = nbt.getDoubleOr("baseArmor", 0.0);
        profile.baseKnockbackResist = nbt.getDoubleOr("baseKnockbackResist", 0.0);
        profile.dayScalingPoints = nbt.getDoubleOr("dayScalingPoints", 0.0);
        profile.killScalingPoints = nbt.getDoubleOr("killScalingPoints", 0.0);
        profile.totalPoints = nbt.getDoubleOr("totalPoints", 0.0);
        profile.tierLevel = nbt.getIntOr("tierLevel", 0);
        profile.priorityPath = nbt.getStringOr("priorityPath", "universal");
        profile.archetype = nbt.getStringOr("archetype", "unknown");
        profile.lastUpdateTick = nbt.getLongOr("lastUpdateTick", 0L);
        profile.isMaxed = nbt.getBooleanOr("isMaxed", false);
        profile.chosenUpgrades.clear();
        {
            ListTag upgrades = nbt.getListOrEmpty("chosenUpgrades");
            for (int i = 0; i < upgrades.size(); i++) {
                profile.chosenUpgrades.add(upgrades.getStringOr(i, ""));
            }
        }
        profile.categories.clear();
        {
            ListTag cats = nbt.getListOrEmpty("categories");
            for (int i = 0; i < cats.size(); i++) {
                profile.categories.add(cats.getStringOr(i, ""));
            }
        }
        profile.specialSkills.clear();
        {
            CompoundTag skills = nbt.getCompoundOrEmpty("specialSkills");
            for (String key : skills.keySet()) {
                profile.specialSkills.put(key, skills.getIntOr(key, 0));
            }
        }
        return profile;
    }
}
