/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.client.model.ModelPart
 */
package backported.updates.foundation.client.animator;

import java.util.Optional;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;

@Environment(value=EnvType.CLIENT)
public interface AnimatedModel {
    public ModelPart root();

    default public Optional<ModelPart> getAnyDescendantWithName(String name) {
        return this.root().traverse().filter(part -> part.hasChild(name)).findFirst().map(part -> part.getChild(name));
    }
}

