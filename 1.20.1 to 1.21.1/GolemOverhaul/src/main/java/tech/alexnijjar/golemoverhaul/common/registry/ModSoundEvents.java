/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.registry.RegistryEntry
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries
 *  com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_7923
 */
package tech.alexnijjar.golemoverhaul.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_7923;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;

public class ModSoundEvents {
    public static final ResourcefulRegistry<class_3414> SOUND_EVENTS = ResourcefulRegistries.create((class_2378)class_7923.field_41172, (String)"golemoverhaul");
    public static final RegistryEntry<class_3414> COAL_GOLEM_AMBIENT = SOUND_EVENTS.register("coal_golem_ambient", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("coal_golem_ambient")));
    public static final RegistryEntry<class_3414> COAL_GOLEM_HURT = SOUND_EVENTS.register("coal_golem_hurt", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("coal_golem_hurt")));
    public static final RegistryEntry<class_3414> COAL_GOLEM_DEATH = SOUND_EVENTS.register("coal_golem_death", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("coal_golem_death")));
    public static final RegistryEntry<class_3414> COAL_GOLEM_EXPLODE = SOUND_EVENTS.register("coal_golem_explode", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("coal_golem_explode")));
    public static final RegistryEntry<class_3414> BARREL_GOLEM_BARTER = SOUND_EVENTS.register("barrel_golem_barter", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("barrel_golem_barter")));
    public static final RegistryEntry<class_3414> NETHERITE_GOLEM_HIT = SOUND_EVENTS.register("netherite_golem_hit", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("netherite_golem_hit")));
    public static final RegistryEntry<class_3414> NETHERITE_GOLEM_HURT = SOUND_EVENTS.register("netherite_golem_hurt", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("netherite_golem_hurt")));
    public static final RegistryEntry<class_3414> NETHERITE_GOLEM_DEATH = SOUND_EVENTS.register("netherite_golem_death", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("netherite_golem_death")));
    public static final RegistryEntry<class_3414> NETHERITE_GOLEM_STEP = SOUND_EVENTS.register("netherite_golem_step", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("netherite_golem_step")));
    public static final RegistryEntry<class_3414> NETHERITE_GOLEM_SUMMON = SOUND_EVENTS.register("netherite_golem_summon", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("netherite_golem_summon")));
    public static final RegistryEntry<class_3414> HAY_GOLEM_HURT = SOUND_EVENTS.register("hay_golem_hurt", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("hay_golem_hurt")));
    public static final RegistryEntry<class_3414> HAY_GOLEM_DEATH = SOUND_EVENTS.register("hay_golem_death", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("hay_golem_death")));
    public static final RegistryEntry<class_3414> KELP_GOLEM_DEATH = SOUND_EVENTS.register("kelp_golem_death", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("kelp_golem_death")));
    public static final RegistryEntry<class_3414> KELP_GOLEM_STEP = SOUND_EVENTS.register("kelp_golem_step", () -> class_3414.method_47908((class_2960)GolemOverhaul.asResource("kelp_golem_step")));
}

