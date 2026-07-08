/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.copper;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import java.util.function.Supplier;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.registry.RegistryKeys;

public class ModSounds {
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_UNAFFECTED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_UNAFFECTED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_UNAFFECTED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_UNAFFECTED;
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_EXPOSED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_EXPOSED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_EXPOSED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_EXPOSED;
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_WEATHERED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_WEATHERED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_WEATHERED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_WEATHERED;
    public static Supplier<SoundEvent> COPPER_GOLEM_DEATH_OXIDIZED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HURT_OXIDIZED;
    public static Supplier<SoundEvent> COPPER_GOLEM_STEP_OXIDIZED;
    public static Supplier<SoundEvent> COPPER_GOLEM_HEAD_SPIN_OXIDIZED;
    public static Supplier<SoundEvent> COPPER_GOLEM_SPAWN;
    public static Supplier<SoundEvent> COPPER_GOLEM_BECOME_STATUE;
    public static Supplier<SoundEvent> COPPER_GOLEM_SHEAR;
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_DROP;
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_NO_DROP;
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_GET;
    public static Supplier<SoundEvent> COPPER_GOLEM_ITEM_NO_GET;
    public static Supplier<SoundEvent> COPPER_CHEST_CLOSE;
    public static Supplier<SoundEvent> COPPER_CHEST_OPEN;
    public static Supplier<SoundEvent> COPPER_STATUE_BREAK;
    public static Supplier<SoundEvent> COPPER_STATUE_PLACE;
    public static Supplier<SoundEvent> COPPER_STATUE_HIT;
    public static Supplier<SoundEvent> COPPER_STATUE_BECOME;
    public static Supplier<SoundEvent> SHELF_ACTIVATE;
    public static Supplier<SoundEvent> SHELF_DEACTIVATE;
    public static Supplier<SoundEvent> SHELF_PLACE_ITEM;
    public static Supplier<SoundEvent> SHELF_TAKE_ITEM;
    public static Supplier<SoundEvent> SHELF_SINGLE_SWAP;
    public static Supplier<SoundEvent> SHELF_MULTI_SWAP;
    public static Supplier<SoundEvent> ARMOR_EQUIP_COPPER;
    public static Supplier<SoundEvent> WEATHER_END_FLASH;

    public static void register() {
        Constants.LOG.info("Registering sounds for {}", "Copper-Age-Backport");
        RegistryHelper helper = RegistryHelper.getInstance();
        COPPER_GOLEM_DEATH_UNAFFECTED = ModSounds.registerSound(helper, "entity.copper_golem.death.unaffected");
        COPPER_GOLEM_HURT_UNAFFECTED = ModSounds.registerSound(helper, "entity.copper_golem.hurt.unaffected");
        COPPER_GOLEM_STEP_UNAFFECTED = ModSounds.registerSound(helper, "entity.copper_golem.step.unaffected");
        COPPER_GOLEM_HEAD_SPIN_UNAFFECTED = ModSounds.registerSound(helper, "entity.copper_golem.head_spin.unaffected");
        COPPER_GOLEM_DEATH_EXPOSED = ModSounds.registerSound(helper, "entity.copper_golem.death.exposed");
        COPPER_GOLEM_HURT_EXPOSED = ModSounds.registerSound(helper, "entity.copper_golem.hurt.exposed");
        COPPER_GOLEM_STEP_EXPOSED = ModSounds.registerSound(helper, "entity.copper_golem.step.exposed");
        COPPER_GOLEM_HEAD_SPIN_EXPOSED = ModSounds.registerSound(helper, "entity.copper_golem.head_spin.exposed");
        COPPER_GOLEM_DEATH_WEATHERED = ModSounds.registerSound(helper, "entity.copper_golem.death.weathered");
        COPPER_GOLEM_HURT_WEATHERED = ModSounds.registerSound(helper, "entity.copper_golem.hurt.weathered");
        COPPER_GOLEM_STEP_WEATHERED = ModSounds.registerSound(helper, "entity.copper_golem.step.weathered");
        COPPER_GOLEM_HEAD_SPIN_WEATHERED = ModSounds.registerSound(helper, "entity.copper_golem.head_spin.weathered");
        COPPER_GOLEM_DEATH_OXIDIZED = ModSounds.registerSound(helper, "entity.copper_golem.death.oxidized");
        COPPER_GOLEM_HURT_OXIDIZED = ModSounds.registerSound(helper, "entity.copper_golem.hurt.oxidized");
        COPPER_GOLEM_STEP_OXIDIZED = ModSounds.registerSound(helper, "entity.copper_golem.step.oxidized");
        COPPER_GOLEM_HEAD_SPIN_OXIDIZED = ModSounds.registerSound(helper, "entity.copper_golem.head_spin.oxidized");
        COPPER_GOLEM_SPAWN = ModSounds.registerSound(helper, "entity.copper_golem.spawn");
        COPPER_GOLEM_BECOME_STATUE = ModSounds.registerSound(helper, "entity.copper_golem.become_statue");
        COPPER_GOLEM_SHEAR = ModSounds.registerSound(helper, "entity.copper_golem.shear");
        COPPER_GOLEM_ITEM_DROP = ModSounds.registerSound(helper, "entity.copper_golem.item_drop");
        COPPER_GOLEM_ITEM_NO_DROP = ModSounds.registerSound(helper, "entity.copper_golem.item_no_drop");
        COPPER_GOLEM_ITEM_GET = ModSounds.registerSound(helper, "entity.copper_golem.no_item_get");
        COPPER_GOLEM_ITEM_NO_GET = ModSounds.registerSound(helper, "entity.copper_golem.no_item_no_get");
        COPPER_CHEST_CLOSE = ModSounds.registerSound(helper, "block.copper_chest.close");
        COPPER_CHEST_OPEN = ModSounds.registerSound(helper, "block.copper_chest.open");
        COPPER_STATUE_BREAK = ModSounds.registerSound(helper, "block.copper_statue.break");
        COPPER_STATUE_PLACE = ModSounds.registerSound(helper, "block.copper_statue.place");
        COPPER_STATUE_HIT = ModSounds.registerSound(helper, "block.copper_statue.hit");
        COPPER_STATUE_BECOME = ModSounds.registerSound(helper, "block.copper_statue.become_statue");
        SHELF_ACTIVATE = ModSounds.registerSound(helper, "block.shelf.activate");
        SHELF_DEACTIVATE = ModSounds.registerSound(helper, "block.shelf.deactivate");
        SHELF_PLACE_ITEM = ModSounds.registerSound(helper, "block.shelf.place_item");
        SHELF_TAKE_ITEM = ModSounds.registerSound(helper, "block.shelf.take_item");
        SHELF_SINGLE_SWAP = ModSounds.registerSound(helper, "block.shelf.single_swap");
        SHELF_MULTI_SWAP = ModSounds.registerSound(helper, "block.shelf.multi_swap");
        ARMOR_EQUIP_COPPER = ModSounds.registerSound(helper, "item.armor.equip_copper");
        WEATHER_END_FLASH = ModSounds.registerSound(helper, "weather.end_flash");
    }

    private static Supplier<SoundEvent> registerSound(RegistryHelper helper, String name) {
        Identifier id = Identifier.ofVanilla((String)name);
        return helper.registerAuto(RegistryKeys.SOUND_EVENT, name, () -> SoundEvent.of(id));
    }
}

