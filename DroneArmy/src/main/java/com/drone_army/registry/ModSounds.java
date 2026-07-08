package com.drone_army.registry;

import com.drone_army.DroneArmyMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent ROBOT_AMBIENT = registerSoundEvent("robot_ambient");
    public static final SoundEvent ROBOT_HURT = registerSoundEvent("robot_hurt");
    public static final SoundEvent ROBOT_DEATH = registerSoundEvent("robot_death");

    // Future specific sounds
    public static final SoundEvent COMBAT_DRONE_BLADE = registerSoundEvent("combat_drone_blade");
    public static final SoundEvent ARTILLERY_FIRE = registerSoundEvent("artillery_fire");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(DroneArmyMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        DroneArmyMod.LOGGER.info("Registering Sounds for " + DroneArmyMod.MOD_ID);
    }
}
