/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefulconfig.common.config.Configurator
 *  dev.architectury.platform.Platform
 *  dev.architectury.utils.Env
 *  net.minecraft.class_2960
 */
package tech.alexnijjar.golemoverhaul;

import com.teamresourceful.resourcefulconfig.common.config.Configurator;
import dev.architectury.platform.Platform;
import dev.architectury.utils.Env;
import net.minecraft.class_2960;
import tech.alexnijjar.golemoverhaul.client.GolemOverhaulClient;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;
import tech.alexnijjar.golemoverhaul.common.events.ModEvents;
import tech.alexnijjar.golemoverhaul.common.network.NetworkHandler;
import tech.alexnijjar.golemoverhaul.common.registry.ModBlocks;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModItems;
import tech.alexnijjar.golemoverhaul.common.registry.ModParticleTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModRecipeSerializers;
import tech.alexnijjar.golemoverhaul.common.registry.ModRecipeTypes;
import tech.alexnijjar.golemoverhaul.common.registry.ModSoundEvents;

public final class GolemOverhaul {
    public static final String MOD_ID = "golemoverhaul";
    public static final Configurator CONFIGURATOR = new Configurator();

    public static void init() {
        CONFIGURATOR.registerConfig(GolemOverhaulConfig.class);
        NetworkHandler.init();
        ModEntityTypes.init();
        ModBlocks.BLOCKS.init();
        ModItems.ITEMS.init();
        ModParticleTypes.PARTICLE_TYPES.init();
        ModSoundEvents.SOUND_EVENTS.init();
        ModRecipeTypes.RECIPE_TYPES.init();
        ModRecipeSerializers.RECIPE_SERIALIZERS.init();
        ModEvents.init();
        if (Platform.getEnvironment() == Env.CLIENT) {
            GolemOverhaulClient.init();
        }
    }

    public static class_2960 asResource(String path) {
        return new class_2960(MOD_ID, path);
    }
}

