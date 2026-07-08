/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.contraptions.Contraption
 *  dev.engine_room.flywheel.api.visualization.VisualizationManager
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.client;

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.Contraption;
import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.MixinAbstractContraptionEntityDuck;

@Mixin(value={AbstractContraptionEntity.class})
public abstract class MixinAbstractContraptionEntityClient
extends class_1297
implements MixinAbstractContraptionEntityDuck {
    @Shadow(remap=false)
    protected Contraption contraption;

    public MixinAbstractContraptionEntityClient(class_1299<?> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"tick"}, at={@At(value="HEAD")})
    private void updateAnchor(CallbackInfo ci) {
        if (VSGameUtilsKt.getShipManagingPos(this.method_37908(), this.contraption.anchor) != VSGameUtilsKt.getShipManaging(this)) {
            this.contraption.anchor = this.method_24515();
            if (VisualizationManager.supportsVisualization((class_1936)this.method_37908())) {
                VisualizationManager.get((class_1936)this.method_37908()).entities().queueRemove((Object)this);
                VisualizationManager.get((class_1936)this.method_37908()).entities().queueAdd((Object)this);
            }
        }
    }
}

