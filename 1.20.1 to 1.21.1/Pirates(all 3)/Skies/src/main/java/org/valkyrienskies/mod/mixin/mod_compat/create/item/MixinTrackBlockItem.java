/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.simibubi.create.content.trains.track.TrackBlockItem
 *  net.minecraft.class_1838
 *  net.minecraft.class_2680
 *  org.spongepowered.asm.mixin.Mixin
 */
package org.valkyrienskies.mod.mixin.mod_compat.create.item;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.simibubi.create.content.trains.track.TrackBlockItem;
import net.minecraft.class_1838;
import net.minecraft.class_2680;
import org.spongepowered.asm.mixin.Mixin;
import org.valkyrienskies.mod.common.PlayerUtil;

@Mixin(value={TrackBlockItem.class})
public class MixinTrackBlockItem {
    @WrapMethod(method={"getPlacementState"})
    private class_2680 wrapPlacementState(class_1838 context, Operation<class_2680> original) {
        if (context != null && context.method_8036() != null) {
            PlayerUtil.transformPlayerTemporarily(context.method_8036(), context.method_8045(), context.method_8037());
            class_2680 state = (class_2680)original.call(new Object[]{context});
            PlayerUtil.untransformPlayer(context.method_8036());
            return state;
        }
        return (class_2680)original.call(new Object[]{context});
    }
}

