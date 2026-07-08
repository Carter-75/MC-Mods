package com.drone_army.client.renderer;

import com.drone_army.DroneArmyMod;
import com.drone_army.entity.RobotEntity;
import net.minecraft.client.render.entity.BipedEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;

public class RobotEntityRenderer extends BipedEntityRenderer<RobotEntity, BipedEntityModel<RobotEntity>> {
    private final Identifier texture;

    public RobotEntityRenderer(EntityRendererFactory.Context context, String textureName) {
        super(context, new BipedEntityModel<>(context.getPart(EntityModelLayers.PLAYER)), 0.5f);
        this.texture = Identifier.of(DroneArmyMod.MOD_ID, "textures/entity/" + textureName + ".png");
    }

    @Override
    public Identifier getTexture(RobotEntity entity) {
        return texture;
    }
}
