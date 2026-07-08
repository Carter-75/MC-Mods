/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.ClientModInitializer
 *  net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
 *  net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
 *  net.minecraft.class_1921
 *  net.minecraft.class_3929
 *  net.minecraft.class_5601
 */
package net._void.civilizations;

import net._void.civilizations.block.ModBlocks;
import net._void.civilizations.entity.ModEntities;
import net._void.civilizations.entity.client.BossAnubisModel;
import net._void.civilizations.entity.client.BossAnubisRenderer;
import net._void.civilizations.entity.client.BossArtemisModel;
import net._void.civilizations.entity.client.BossArtemisRenderer;
import net._void.civilizations.entity.client.BossLokiCloneModel;
import net._void.civilizations.entity.client.BossLokiCloneRenderer;
import net._void.civilizations.entity.client.BossLokiModel;
import net._void.civilizations.entity.client.BossLokiRenderer;
import net._void.civilizations.entity.client.BossMercuryModel;
import net._void.civilizations.entity.client.BossMercuryRenderer;
import net._void.civilizations.entity.client.BossWukongModel;
import net._void.civilizations.entity.client.BossWukongRenderer;
import net._void.civilizations.entity.client.ChinaBossModel;
import net._void.civilizations.entity.client.ChinaBossRenderer;
import net._void.civilizations.entity.client.ChinaCivilianModel;
import net._void.civilizations.entity.client.ChinaCivilianRenderer;
import net._void.civilizations.entity.client.ChinaGuardModel;
import net._void.civilizations.entity.client.ChinaGuardRenderer;
import net._void.civilizations.entity.client.EgyptBossModel;
import net._void.civilizations.entity.client.EgyptBossRenderer;
import net._void.civilizations.entity.client.EgyptCivilianModel;
import net._void.civilizations.entity.client.EgyptCivilianRenderer;
import net._void.civilizations.entity.client.EgyptNpcModel;
import net._void.civilizations.entity.client.EgyptNpcRenderer;
import net._void.civilizations.entity.client.GreeceBossModel;
import net._void.civilizations.entity.client.GreeceBossRenderer;
import net._void.civilizations.entity.client.GreeceCivilianModel;
import net._void.civilizations.entity.client.GreeceCivilianRenderer;
import net._void.civilizations.entity.client.ModModelLayers;
import net._void.civilizations.entity.client.NordicBossModel;
import net._void.civilizations.entity.client.NordicBossRenderer;
import net._void.civilizations.entity.client.NordicCivilianModel;
import net._void.civilizations.entity.client.NordicCivilianRenderer;
import net._void.civilizations.entity.client.RomeBossModel;
import net._void.civilizations.entity.client.RomeBossRenderer;
import net._void.civilizations.entity.client.RomeCivilianModel;
import net._void.civilizations.entity.client.RomeCivilianRenderer;
import net._void.civilizations.entity.client.RomeGuardModel;
import net._void.civilizations.entity.client.RomeGuardRenderer;
import net._void.civilizations.networking.ModMessages;
import net._void.civilizations.screen.ModScreenHandlers;
import net._void.civilizations.screen.TombstoneScreen;
import net._void.civilizations.screen.TradingStationScreen;
import net._void.civilizations.util.ModModelPredicates;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.class_1921;
import net.minecraft.class_3929;
import net.minecraft.class_5601;

public class CivilizationsClient
implements ClientModInitializer {
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EGYPT_DOOR, class_1921.method_23581());
        EntityRendererRegistry.register(ModEntities.EGYPT_CIVILIAN, EgyptCivilianRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.EGYPT_CIVILIAN, EgyptCivilianModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.EGYPT_NPC, EgyptNpcRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.EGYPT_NPC, EgyptNpcModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.EGYPT_BOSS, EgyptBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.EGYPT_BOSS, EgyptBossModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHINA_CIVILIAN, ChinaCivilianRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.CHINA_CIVILIAN, ChinaCivilianModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHINA_GUARD, ChinaGuardRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.CHINA_GUARD, ChinaGuardModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHINA_BOSS, ChinaBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.CHINA_BOSS, ChinaBossModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.NORDIC_CIVILIAN, NordicCivilianRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.NORDIC_CIVILIAN, NordicCivilianModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.NORDIC_BOSS, NordicBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.NORDIC_BOSS, NordicBossModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GREECE_CIVILIAN, GreeceCivilianRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.GREECE_CIVILIAN, GreeceCivilianModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GREECE_BOSS, GreeceBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.GREECE_BOSS, GreeceBossModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ROME_CIVILIAN, RomeCivilianRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.ROME_CIVILIAN, RomeCivilianModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ROME_BOSS, RomeBossRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.ROME_BOSS, RomeBossModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.ROME_GUARD, RomeGuardRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.ROME_GUARD, RomeGuardModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOSS_ARTEMIS, BossArtemisRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.BOSS_ARTEMIS, BossArtemisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOSS_ANUBIS, BossAnubisRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.BOSS_ANUBIS, BossAnubisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOSS_MERCURY, BossMercuryRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.BOSS_MERCURY, BossMercuryModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOSS_LOKI, BossLokiRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.BOSS_LOKI, BossLokiModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOSS_LOKI_CLONE, BossLokiCloneRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.BOSS_LOKI_CLONE, BossLokiCloneModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BOSS_WUKONG, BossWukongRenderer::new);
        EntityModelLayerRegistry.registerModelLayer((class_5601)ModModelLayers.BOSS_WUKONG, BossWukongModel::getTexturedModelData);
        class_3929.method_17542(ModScreenHandlers.TRADING_STATION_SCREEN_HANDLER, TradingStationScreen::new);
        class_3929.method_17542(ModScreenHandlers.TOMBSTONE_SCREEN_HANDLER, TombstoneScreen::new);
        ModModelPredicates.registerModModels();
        ModMessages.registerS2CPackets();
    }
}

