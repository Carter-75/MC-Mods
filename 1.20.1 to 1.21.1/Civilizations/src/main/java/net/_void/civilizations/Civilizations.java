/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ModInitializer
 *  net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry
 *  net.minecraft.class_5132$class_5133
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 */
package net._void.civilizations;

import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.block.entity.ModBlockEntities;
import net._void.civilizations.effect.ModEffects;
import net._void.civilizations.entity.ModEntities;
import net._void.civilizations.entity.custom.BossAnubisEntity;
import net._void.civilizations.entity.custom.BossArtemisEntity;
import net._void.civilizations.entity.custom.BossLokiCloneEntity;
import net._void.civilizations.entity.custom.BossLokiEntity;
import net._void.civilizations.entity.custom.BossMercuryEntity;
import net._void.civilizations.entity.custom.BossWukongEntity;
import net._void.civilizations.entity.custom.ChinaBossEntity;
import net._void.civilizations.entity.custom.ChinaCivilianEntity;
import net._void.civilizations.entity.custom.ChinaGuardEntity;
import net._void.civilizations.entity.custom.EgyptBossEntity;
import net._void.civilizations.entity.custom.EgyptCivilianEntity;
import net._void.civilizations.entity.custom.EgyptNpcEntity;
import net._void.civilizations.entity.custom.GreeceBossEntity;
import net._void.civilizations.entity.custom.GreeceCivilianEntity;
import net._void.civilizations.entity.custom.NordicBossEntity;
import net._void.civilizations.entity.custom.NordicCivilianEntity;
import net._void.civilizations.entity.custom.RomeBossEntity;
import net._void.civilizations.entity.custom.RomeCivilianEntity;
import net._void.civilizations.entity.custom.RomeGuardEntity;
import net._void.civilizations.item.ModItemGroups;
import net._void.civilizations.item.ModItems;
import net._void.civilizations.networking.ModMessages;
import net._void.civilizations.screen.ModScreenHandlers;
import net._void.civilizations.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.class_5132;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Civilizations
implements ModInitializer {
    public static final String MOD_ID = "civilizations";
    public static final Logger LOGGER = LoggerFactory.getLogger((String)"civilizations");

    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModEffects.registerEffects();
        ModSounds.registerSounds();
        ModMessages.registerC2SPackets();
        FabricDefaultAttributeRegistry.register(ModEntities.EGYPT_CIVILIAN, (class_5132.class_5133)EgyptCivilianEntity.createCivilianAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.EGYPT_NPC, (class_5132.class_5133)EgyptNpcEntity.createNpcAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.EGYPT_BOSS, (class_5132.class_5133)EgyptBossEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CHINA_CIVILIAN, (class_5132.class_5133)ChinaCivilianEntity.createCivilianAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CHINA_GUARD, (class_5132.class_5133)ChinaGuardEntity.createGuardAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.CHINA_BOSS, (class_5132.class_5133)ChinaBossEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.NORDIC_CIVILIAN, (class_5132.class_5133)NordicCivilianEntity.createCivilianAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.NORDIC_BOSS, (class_5132.class_5133)NordicBossEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GREECE_CIVILIAN, (class_5132.class_5133)GreeceCivilianEntity.createCivilianAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.GREECE_BOSS, (class_5132.class_5133)GreeceBossEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ROME_CIVILIAN, (class_5132.class_5133)RomeCivilianEntity.createCivilianAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ROME_BOSS, (class_5132.class_5133)RomeBossEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.ROME_GUARD, (class_5132.class_5133)RomeGuardEntity.createCivilianAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOSS_ARTEMIS, (class_5132.class_5133)BossArtemisEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOSS_ANUBIS, (class_5132.class_5133)BossAnubisEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOSS_MERCURY, (class_5132.class_5133)BossMercuryEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOSS_LOKI, (class_5132.class_5133)BossLokiEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOSS_LOKI_CLONE, (class_5132.class_5133)BossLokiCloneEntity.createBossAttributes());
        FabricDefaultAttributeRegistry.register(ModEntities.BOSS_WUKONG, (class_5132.class_5133)BossWukongEntity.createBossAttributes());
    }
}

