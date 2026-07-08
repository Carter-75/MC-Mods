/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.model.CompositeEntityModel
 *  net.minecraft.client.render.entity.model.BoatEntityModel
 *  net.minecraft.client.render.entity.EntityRendererFactory$Context
 *  net.minecraft.client.render.entity.model.ChestBoatEntityModel
 *  net.minecraft.client.render.entity.BoatEntityRenderer
 */
package backported.updates.content.client.level.entities.renderer;

import backported.updates.content.client.registries.ModModelLayers;
import backported.updates.foundation.client.api.model.CustomBoatModel;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.ChestBoatEntityModel;
import net.minecraft.client.render.entity.BoatEntityRenderer;

@Environment(value=EnvType.CLIENT)
public class PaleOakBoatRenderer
extends BoatEntityRenderer
implements CustomBoatModel {
    private static final Identifier PALE_OAK_BOAT = Identifier.ofVanilla((String)"textures/entity/boat/pale_oak.png");
    private static final Identifier PALE_OAK_CHEST_BOAT = Identifier.ofVanilla((String)"textures/entity/chest_boat/pale_oak.png");
    private final Pair<Identifier, CompositeEntityModel<BoatEntity>> boatResource;

    public PaleOakBoatRenderer(EntityRendererFactory.Context context, boolean chestBoat) {
        super(context, chestBoat);
        this.boatResource = Pair.of((chestBoat ? PALE_OAK_CHEST_BOAT : PALE_OAK_BOAT), (chestBoat ? new ChestBoatEntityModel(context.getPart(ModModelLayers.PALE_OAK_CHEST_BOAT)) : new BoatEntityModel(context.getPart(ModModelLayers.PALE_OAK_BOAT))));
    }

    @Override
    public Pair<Identifier, CompositeEntityModel<BoatEntity>> getModelWithLocation(BoatEntity boat) {
        return this.boatResource;
    }
}

