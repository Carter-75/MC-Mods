/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1271
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1781
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.LeashIntegration;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.class_1268;
import net.minecraft.class_1271;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1781;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_1781.class})
public class FireworkRocketItemMixin {
    @Inject(method={"use"}, at={@At(value="INVOKE", target="Lnet/minecraft/world/entity/projectile/FireworkRocketEntity;<init>(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)V")})
    private void vb$onUse(class_1937 level, class_1657 player, class_1268 usedHand, CallbackInfoReturnable<class_1271<class_1799>> cir) {
        if (VanillaBackport.COMMON_CONFIG.leashDropConnections.get().booleanValue() && LeashIntegration.dropAllLeashConnections((class_1297)player, null)) {
            level.method_43129(null, (class_1297)player, class_3417.field_15184, class_3419.field_15254, 1.0f, 1.0f);
        }
    }
}

