/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  net.minecraft.entity.vehicle.BoatEntity
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.render.entity.model.CompositeEntityModel
 */
package backported.updates.foundation.client.api.model;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.CompositeEntityModel;

public interface CustomBoatModel {
    public Pair<Identifier, CompositeEntityModel<BoatEntity>> getModelWithLocation(BoatEntity var1);
}

