/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  me.jellysquid.mods.sodium.client.render.chunk.RenderSection
 *  net.minecraft.class_310
 *  net.minecraft.class_638
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 */
package org.valkyrienskies.mod.mixin.mod_compat.sodium;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import me.jellysquid.mods.sodium.client.render.chunk.RenderSection;
import net.minecraft.class_310;
import net.minecraft.class_638;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.valkyrienskies.core.api.ships.ClientShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

@Mixin(value={RenderSection.class}, remap=false)
public abstract class MixinRenderSection {
    @Shadow
    public abstract int getCenterX();

    @Shadow
    public abstract int getCenterY();

    @Shadow
    public abstract int getCenterZ();

    @WrapMethod(method={"getSquaredDistance(FFF)F"})
    private float squareDistanceIfInShipyard(float x, float y, float z, Operation<Float> original) {
        class_638 world = class_310.method_1551().field_1687;
        ClientShip shipObject = VSGameUtilsKt.getLoadedShipManagingPos(world, (double)this.getCenterX(), (double)this.getCenterY(), (double)this.getCenterZ());
        if (shipObject != null) {
            Vector3d chunkPosInWorld = shipObject.getRenderTransform().getShipToWorld().transformPosition(new Vector3d(this.getCenterX(), this.getCenterY(), this.getCenterZ()));
            return (float)chunkPosInWorld.distanceSquared(x, y, z);
        }
        return ((Float)original.call(new Object[]{Float.valueOf(x), Float.valueOf(y), Float.valueOf(z)})).floatValue();
    }
}

