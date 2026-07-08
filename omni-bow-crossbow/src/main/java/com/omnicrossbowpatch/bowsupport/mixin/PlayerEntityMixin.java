package com.omnicrossbowpatch.bowsupport.mixin;

import java.util.function.Predicate;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
	private static final Identifier OMNI_ENCHANTMENT_ID = Identifier.of("omnicrossbow", "omni");

	@Redirect(
		method = "getProjectileType",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/item/RangedWeaponItem;getHeldProjectiles()Ljava/util/function/Predicate;"
		)
	)
	private Predicate<ItemStack> omni$allowAnyAmmo(RangedWeaponItem item, ItemStack weaponStack) {
		Predicate<ItemStack> original = item.getHeldProjectiles();
		if (!hasOmniEnchantment(weaponStack)) {
			return original;
		}
		return stack -> !stack.isEmpty() && stack != weaponStack;
	}

	private boolean hasOmniEnchantment(ItemStack stack) {
		if (!(stack.getItem() instanceof RangedWeaponItem)) {
			return false;
		}
		PlayerEntity player = (PlayerEntity) (Object) this;
		RegistryEntry<Enchantment> omni;
		try {
			omni = player.getWorld()
					.getRegistryManager()
					.getWrapperOrThrow(RegistryKeys.ENCHANTMENT)
					.getOrThrow(RegistryKey.of(RegistryKeys.ENCHANTMENT, OMNI_ENCHANTMENT_ID));
		} catch (Exception ignored) {
			return false;
		}
		return stack.getEnchantments().getLevel(omni) > 0;
	}
}
