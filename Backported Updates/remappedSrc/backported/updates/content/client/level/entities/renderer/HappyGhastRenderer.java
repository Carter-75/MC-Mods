/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_1304
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_5617$class_5618
 *  net.minecraft.class_583
 *  net.minecraft.class_927
 */
package backported.updates.content.client.level.entities.renderer;

import backported.updates.content.client.level.entities.layer.GhastHarnessLayer;
import backported.updates.content.client.level.entities.layer.RopesLayer;
import backported.updates.content.client.level.entities.layer.SimpleEquipmentLayer;
import backported.updates.content.client.level.entities.model.HappyGhastHarnessModel;
import backported.updates.content.client.level.entities.model.HappyGhastModel;
import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.content.common.level.entities.happyghast.HappyGhast;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_1304;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_5617;
import net.minecraft.class_583;
import net.minecraft.class_927;

@Environment(value=EnvType.CLIENT)
public class HappyGhastRenderer
extends class_927<HappyGhast, HappyGhastModel<HappyGhast>> {
    private static final class_2960 GHAST_LOCATION = class_2960.method_60656((String)"textures/entity/ghast/happy_ghast.png");
    private static final class_2960 GHAST_BABY_LOCATION = class_2960.method_60656((String)"textures/entity/ghast/happy_ghast_baby.png");
    private static final class_2960 GHAST_ROPES = class_2960.method_60656((String)"textures/entity/ghast/happy_ghast_ropes.png");

    public HappyGhastRenderer(class_5617.class_5618 context) {
        super(context, new HappyGhastModel(context.method_32167(ModModelLayers.HAPPY_GHAST)), 1.5f);
        this.method_4046(new SimpleEquipmentLayer(this, GhastHarnessLayer.TEXTURE_BY_ITEM, class_1304.field_6174, HappyGhast::isHarnessed, (class_583<HappyGhast>)new HappyGhastHarnessModel(context.method_32167(ModModelLayers.HAPPY_GHAST_HARNESS)), (class_583<HappyGhast>)null));
        this.method_4046(new RopesLayer(this, context.method_32170(), GHAST_ROPES));
    }

    public class_2960 getTextureLocation(HappyGhast entity) {
        return entity.method_6109() ? GHAST_BABY_LOCATION : GHAST_LOCATION;
    }

    protected void scale(HappyGhast entity, class_4587 matrices, float partialTicks) {
        float scale = entity.method_6109() ? 0.95f : 4.0f;
        matrices.method_22905(scale, scale, scale);
    }
}

