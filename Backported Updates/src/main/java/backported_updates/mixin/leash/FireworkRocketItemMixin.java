/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Hand
 *  net.minecraft.util.TypedActionResult
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.FireworkRocketItem
 *  net.minecraft.item.ItemStack
 *  net.minecraft.world.World
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.leash;

import backported.updates.content.common.api.leash.LeashIntegration;
import backported.updates.content.core.VanillaBackport;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FireworkRocketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={FireworkRocketItem.class})
public class FireworkRocketItemMixin {
    @Inject(method={"use"}, at={@At(value="INVOKE", target="Lnet/minecraft/entity/projectile/FireworkRocketEntity;<init>(Lnet/minecraft/world/World;Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/LivingEntity;)V")})
    private void vb$onUse(World level, PlayerEntity player, Hand usedHand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (VanillaBackport.COMMON_CONFIG.leashDropConnections.get().booleanValue() && LeashIntegration.dropAllLeashConnections((Entity)player, null)) {
            level.playSoundFromEntity(null, (Entity)player, SoundEvents.ENTITY_LEASH_KNOT_BREAK, SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
    }
}

