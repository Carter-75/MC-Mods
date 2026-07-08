/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.contraptions.ControlledContraptionEntity
 *  com.simibubi.create.content.contraptions.bearing.BearingContraption
 *  com.simibubi.create.content.contraptions.behaviour.MovementContext
 *  net.minecraft.class_1299
 *  net.minecraft.class_1937
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.fabric.mixin.compat.create;

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.ControlledContraptionEntity;
import com.simibubi.create.content.contraptions.bearing.BearingContraption;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import org.joml.Math;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={ControlledContraptionEntity.class})
public abstract class MixinControlledContraptionEntity
extends AbstractContraptionEntity {
    @Shadow
    protected float angleDelta;

    public MixinControlledContraptionEntity(class_1299<?> entityTypeIn, class_1937 worldIn) {
        super(entityTypeIn, worldIn);
    }

    @Redirect(method={"shouldActorTrigger"}, at=@At(value="FIELD", opcode=181, target="Lcom/simibubi/create/content/contraptions/behaviour/MovementContext;motion:Lnet/minecraft/world/phys/Vec3;"))
    private void redirectPutMotion(MovementContext instance, class_243 value) {
        BearingContraption bc = (BearingContraption)this.contraption;
        class_2350 facing = bc.getFacing();
        class_2382 dir = facing.method_10163();
        double scalar = Math.abs((double)this.angleDelta / 360.0) * (double)Math.signum(dir.method_10263() + dir.method_10264() + dir.method_10260());
        instance.motion = new class_243((double)Math.abs(dir.method_10263()), (double)Math.abs(dir.method_10264()), (double)Math.abs(dir.method_10260())).method_1021(scalar);
    }
}

