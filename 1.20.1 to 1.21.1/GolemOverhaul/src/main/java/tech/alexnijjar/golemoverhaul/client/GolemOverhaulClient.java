/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefullib.common.network.Packet
 *  dev.architectury.event.events.client.ClientTickEvent
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  dev.architectury.registry.client.keymappings.KeyMappingRegistry
 *  dev.architectury.registry.client.level.entity.EntityRendererRegistry
 *  net.minecraft.class_1299
 *  net.minecraft.class_1921
 *  net.minecraft.class_2248
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_746
 *  net.minecraft.class_7923
 *  software.bernie.geckolib.model.DefaultedEntityGeoModel
 *  software.bernie.geckolib.model.GeoModel
 *  software.bernie.geckolib.renderer.GeoEntityRenderer
 */
package tech.alexnijjar.golemoverhaul.client;

import com.teamresourceful.resourcefullib.common.network.Packet;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.client.keymappings.KeyMappingRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import java.util.function.Supplier;
import net.minecraft.class_1299;
import net.minecraft.class_1921;
import net.minecraft.class_2248;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_746;
import net.minecraft.class_7923;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import tech.alexnijjar.golemoverhaul.client.fabric.GolemOverhaulClientImpl;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.BarrelGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.CandleGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.CoalGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.HayGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.HoneyGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.KelpGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.NetheriteGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.SlimeGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.golems.TerracottaGolemRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.projectiles.CandleFlameProjectileRenderer;
import tech.alexnijjar.golemoverhaul.client.renderers.entities.projectiles.HoneyBlobProjectileRenderer;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantComponents;
import tech.alexnijjar.golemoverhaul.common.entities.golems.NetheriteGolem;
import tech.alexnijjar.golemoverhaul.common.network.NetworkHandler;
import tech.alexnijjar.golemoverhaul.common.network.packets.ServerboundGolemSummonPacket;
import tech.alexnijjar.golemoverhaul.common.registry.ModBlocks;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class GolemOverhaulClient {
    public static final class_304 KEY_NETHERITE_GOLEM_SUMMON = new class_304(ConstantComponents.NETHERITE_GOLEM_SUMMON_KEY.getString(), 82, ConstantComponents.GOLEM_OVERHAUL_CATEGORY.getString());

    public static void init() {
        GolemOverhaulClient.registerKeyMappings();
        GolemOverhaulClient.registerEntityRenderers();
        GolemOverhaulClient.registerBlockRenderTypes();
    }

    private static void registerKeyMappings() {
        KeyMappingRegistry.register((class_304)KEY_NETHERITE_GOLEM_SUMMON);
        ClientTickEvent.CLIENT_PRE.register(minecraft -> {
            if (KEY_NETHERITE_GOLEM_SUMMON.method_1436()) {
                class_746 player = class_310.method_1551().field_1724;
                if (player == null) {
                    return;
                }
                if (player.method_5854() instanceof NetheriteGolem) {
                    NetworkHandler.CHANNEL.sendToServer((Packet)new ServerboundGolemSummonPacket());
                }
            }
        });
    }

    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(ModEntityTypes.BARREL_GOLEM, BarrelGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.CANDLE_GOLEM, CandleGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.COAL_GOLEM, CoalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.HAY_GOLEM, HayGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.HONEY_GOLEM, HoneyGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.KELP_GOLEM, KelpGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.NETHERITE_GOLEM, NetheriteGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.SLIME_GOLEM, SlimeGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.TERRACOTTA_GOLEM, TerracottaGolemRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.CANDLE_FLAME, CandleFlameProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.MUD_BALL, context -> new GeoEntityRenderer(context, (GeoModel)new DefaultedEntityGeoModel(class_7923.field_41177.method_10221((Object)((class_1299)ModEntityTypes.MUD_BALL.get())))));
        EntityRendererRegistry.register(ModEntityTypes.HONEY_BLOB, HoneyBlobProjectileRenderer::new);
    }

    private static void registerBlockRenderTypes() {
        GolemOverhaulClient.registerBlockRenderType(ModBlocks.CANDLE_GOLEM_BLOCK, class_1921.method_23581());
        GolemOverhaulClient.registerBlockRenderType(ModBlocks.CLAY_GOLEM_STATUE, class_1921.method_23581());
    }

    /*
     * WARNING - void declaration
     */
    @ExpectPlatform
    @ExpectPlatform.Transformed
    private static void registerBlockRenderType(Supplier<class_2248> block, class_1921 type) {
        void var1_1;
        GolemOverhaulClientImpl.registerBlockRenderType(block, (class_1921)var1_1);
    }
}

