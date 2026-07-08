/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_9817$class_9818
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.LeashDataExtension;
import net.minecraft.class_9817;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value={class_9817.class_9818.class})
public class LeashDataMixin
implements LeashDataExtension {
    @Unique
    private double angularMomentum;

    @Override
    public double angularMomentum() {
        return this.angularMomentum;
    }

    @Override
    public void setAngularMomentum(double angularMomentum) {
        this.angularMomentum = angularMomentum;
    }
}

