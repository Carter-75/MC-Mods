/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.simibubi.create.content.contraptions.Contraption
 *  net.minecraft.class_1297
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package org.valkyrienskies.mod.mixin.mod_compat.create;

import com.simibubi.create.content.contraptions.Contraption;
import net.minecraft.class_1297;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={Contraption.class})
public class MixinContraption {
    @Redirect(method={"onEntityCreated"}, at=@At(value="INVOKE", target="Lnet/minecraft/world/level/Level;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z"))
    private boolean wrapOp(class_1937 level, class_1297 entity) {
        class_2338 anchor = class_2338.method_49637((double)((int)Math.floor(entity.method_23317())), (double)((int)Math.floor(entity.method_23318())), (double)((int)Math.floor(entity.method_23321())));
        boolean added = level.method_8649(entity);
        if (added) {
            entity.method_24203((double)anchor.method_10263() + 0.5, (double)anchor.method_10264(), (double)anchor.method_10260() + 0.5);
        }
        return added;
    }
}

