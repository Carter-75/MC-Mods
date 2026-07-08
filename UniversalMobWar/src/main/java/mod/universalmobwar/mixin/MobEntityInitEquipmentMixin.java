package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.config.ModConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.EnumSet;

/**
 * Prevent vanilla from assigning random equipment so mobs only earn gear via the scaling system.
 */
@Mixin(Mob.class)
public abstract class MobEntityInitEquipmentMixin {

    private static final EnumSet<EquipmentSlot> CLEARED_SLOTS = EnumSet.of(
        EquipmentSlot.MAINHAND,
        EquipmentSlot.OFFHAND,
        EquipmentSlot.HEAD,
        EquipmentSlot.CHEST,
        EquipmentSlot.LEGS,
        EquipmentSlot.FEET
    );

    @Inject(method = "populateDefaultEquipmentSlots", at = @At("HEAD"), cancellable = true)
    private void universalmobwar$disableVanillaEquipment(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        UniversalMobWarMod.runSafely("MobEntityInitEquipmentMixin#disableVanillaEquipment", () -> {
            if (!ModConfig.getInstance().modEnabled) {
                return;
            }

            Mob self = (Mob)(Object)this;
            for (EquipmentSlot slot : EquipmentSlot.values()) {
                if (!CLEARED_SLOTS.contains(slot)) {
                    continue;
                }
                self.setItemSlot(slot, ItemStack.EMPTY);
                self.setDropChance(slot, 0.0f);
            }

            ci.cancel();
        });
    }
}
