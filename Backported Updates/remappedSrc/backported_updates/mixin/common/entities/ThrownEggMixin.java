/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.sugar.Local
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1428
 *  net.minecraft.class_1681
 *  net.minecraft.class_1937
 *  net.minecraft.class_239
 *  net.minecraft.class_3857
 *  net.minecraft.class_5321
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package backported_updates.mixin.common.entities;

import backported.updates.content.common.api.variant.VariantDataHolder;
import backported.updates.content.common.api.variant.VariantUtils;
import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.common.registries.ModDataComponents;
import backported.updates.content.core.registries.ModBuiltinRegistries;
import com.llamalad7.mixinextras.sugar.Local;
import java.util.Optional;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1428;
import net.minecraft.class_1681;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_3857;
import net.minecraft.class_5321;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_1681.class})
public abstract class ThrownEggMixin
extends class_3857 {
    public ThrownEggMixin(class_1299<? extends class_3857> entityType, class_1937 level) {
        super(entityType, level);
    }

    @Inject(method={"onHit"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/animal/Chicken;moveTo(DDDFF)V", shift=At.Shift.AFTER)})
    private void setChickenVariant(class_239 result, CallbackInfo ci, @Local class_1428 chicken) {
        Optional.ofNullable((class_5321)this.method_7495().method_57824(ModDataComponents.CHICKEN_VARIANT.get())).map(key -> VariantUtils.getDefault(ModBuiltinRegistries.CHICKEN_VARIANTS, key)).ifPresent(variant -> VariantDataHolder.getHolder((class_1309)chicken).setVariantData((ChickenVariant)variant));
    }
}

