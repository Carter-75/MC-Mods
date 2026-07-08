/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_630
 */
package backported.updates.foundation.client.animator;

import java.util.Optional;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_630;

@Environment(value=EnvType.CLIENT)
public interface AnimatedModel {
    public class_630 root();

    default public Optional<class_630> getAnyDescendantWithName(String name) {
        return this.root().method_32088().filter(part -> part.method_41919(name)).findFirst().map(part -> part.method_32086(name));
    }
}

