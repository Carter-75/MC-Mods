/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_2338
 *  net.minecraft.class_5561
 */
package backported.updates.copper.entity;

import net.minecraft.class_1309;
import net.minecraft.class_2338;
import net.minecraft.class_5561;

public interface ContainerUser {
    public boolean hasContainerOpen(class_5561 var1, class_2338 var2);

    public double getContainerInteractionRange();

    default public class_1309 getLivingEntity() {
        if (this instanceof class_1309) {
            return (class_1309)this;
        }
        throw new IllegalStateException("A container user must be a LivingEntity");
    }
}

