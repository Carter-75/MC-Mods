/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.AbstractContraptionEntity
 *  com.simibubi.create.content.contraptions.ControlledContraptionEntity
 *  com.simibubi.create.content.contraptions.IControlContraption
 *  net.minecraft.class_1299
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.entity;

import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import com.simibubi.create.content.contraptions.ControlledContraptionEntity;
import com.simibubi.create.content.contraptions.IControlContraption;
import net.minecraft.class_1299;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.valkyrienskies.mod.mixinducks.mod_compat.create.IMixinControlledContraptionEntity;

@Mixin(value={ControlledContraptionEntity.class})
public abstract class MixinControlledContraptionEntity
extends AbstractContraptionEntity
implements IMixinControlledContraptionEntity {
    @Shadow
    protected abstract IControlContraption getController();

    public MixinControlledContraptionEntity(class_1299<?> entityTypeIn, class_1937 worldIn) {
        super(entityTypeIn, worldIn);
    }

    private class_243 flatten(class_243 vec3) {
        if (vec3.field_1352 == 0.0) {
            vec3 = new class_243(0.0, vec3.field_1351, vec3.field_1350);
        }
        if (vec3.field_1351 == 0.0) {
            vec3 = new class_243(vec3.field_1352, 0.0, vec3.field_1350);
        }
        if (vec3.field_1350 == 0.0) {
            vec3 = new class_243(vec3.field_1352, vec3.field_1351, 0.0);
        }
        return vec3;
    }

    @Redirect(method={"shouldActorTrigger"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/phys/Vec3;equals(Ljava/lang/Object;)Z"))
    private boolean redirectEquals(class_243 instance, Object vec3) {
        class_243 other = (class_243)vec3;
        other = this.flatten(other);
        instance = this.flatten(instance);
        return instance.equals((Object)other);
    }

    @Override
    public IControlContraption grabController() {
        return this.getController();
    }
}

