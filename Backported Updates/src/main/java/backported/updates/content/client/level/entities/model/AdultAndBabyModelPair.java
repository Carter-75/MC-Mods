/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.render.entity.model.EntityModel
 */
package backported.updates.content.client.level.entities.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModel;

@Environment(value=EnvType.CLIENT)
public record AdultAndBabyModelPair<T extends EntityModel<?>>(T adultModel, T babyModel) {
    public T getModel(boolean isBaby) {
        return isBaby ? this.babyModel : this.adultModel;
    }
}

