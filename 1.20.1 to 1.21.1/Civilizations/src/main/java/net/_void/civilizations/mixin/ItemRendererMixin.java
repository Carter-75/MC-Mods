/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1087
 *  net.minecraft.class_1091
 *  net.minecraft.class_1799
 *  net.minecraft.class_4587
 *  net.minecraft.class_4597
 *  net.minecraft.class_811
 *  net.minecraft.class_918
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 */
package net._void.civilizations.mixin;

import net._void.civilizations.item.ModItems;
import net._void.civilizations.mixin.ItemRendererAccessor;
import net.minecraft.class_1087;
import net.minecraft.class_1091;
import net.minecraft.class_1799;
import net.minecraft.class_4587;
import net.minecraft.class_4597;
import net.minecraft.class_811;
import net.minecraft.class_918;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value={class_918.class})
public abstract class ItemRendererMixin {
    @ModifyVariable(method={"renderItem"}, at=@At(value="HEAD"), argsOnly=true)
    public class_1087 useRubyStaffModel(class_1087 value, class_1799 stack, class_811 renderMode, boolean leftHanded, class_4587 matrices, class_4597 vertexConsumers, int light, int overlay) {
        if (stack.method_31574(ModItems.EGYPT_CROOK) && renderMode != class_811.field_4317) {
            return ((ItemRendererAccessor)((Object)this)).mccourse$getModels().method_3303().method_4742(new class_1091("civilizations", "egypt_crook_3d", "inventory"));
        }
        if (stack.method_31574(ModItems.WUKONG_SWORD) && renderMode != class_811.field_4317) {
            return ((ItemRendererAccessor)((Object)this)).mccourse$getModels().method_3303().method_4742(new class_1091("civilizations", "wukong_sword_3d", "inventory"));
        }
        return value;
    }
}

