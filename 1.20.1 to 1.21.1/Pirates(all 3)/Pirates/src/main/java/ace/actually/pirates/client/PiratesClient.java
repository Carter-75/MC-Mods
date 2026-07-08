/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.registry.client.level.entity.EntityRendererRegistry
 *  dev.architectury.registry.client.rendering.BlockEntityRendererRegistry
 *  net.minecraft.class_2591
 *  net.minecraft.class_2960
 *  net.minecraft.class_5601
 */
package ace.actually.pirates.client;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.blocks.entity.CannonPrimingBlockEntityRenderer;
import ace.actually.pirates.blocks.entity.ShipIdBlockEntityRenderer;
import ace.actually.pirates.entities.friendly_pirate.FriendlyPirateRenderer;
import ace.actually.pirates.entities.pirate_default.PirateEntityRenderer;
import ace.actually.pirates.entities.shot.ShotEntityRenderer;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.minecraft.class_2591;
import net.minecraft.class_2960;
import net.minecraft.class_5601;

public class PiratesClient {
    public static final class_5601 SKELETON_PIRATE = new class_5601(new class_2960("pirates", "skeleton_pirate"), "main");

    public static void initClientFromMain() {
        EntityRendererRegistry.register(Pirates.PIRATE_ENTITY_TYPE, PirateEntityRenderer::new);
        EntityRendererRegistry.register(Pirates.FRIENDLY_PIRATE_TYPE, FriendlyPirateRenderer::new);
        EntityRendererRegistry.register(Pirates.SHOT_ENTITY_TYPE, context -> new ShotEntityRenderer(context, 1.0f, false));
    }

    public static void initClient() {
        BlockEntityRendererRegistry.register((class_2591)((class_2591)Pirates.CANNON_PRIMING_BLOCK_ENTITY.get()), CannonPrimingBlockEntityRenderer::new);
        BlockEntityRendererRegistry.register((class_2591)((class_2591)Pirates.SHIP_ID_BLOCK_ENTITY.get()), ShipIdBlockEntityRenderer::new);
    }
}

