package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.WitchAbilityHelper;
import mod.universalmobwar.system.WitchAbilityHelper.ThrowStats;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.projectile.throwableitem.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * Adds scaling-system special abilities to Witch potion attacks.
 */
@Mixin(Witch.class)
public abstract class WitchAbilityMixin extends Mob {

    protected WitchAbilityMixin(EntityType<? extends Mob> entityType, Level world) {
        super(entityType, world);
    }

    @Redirect(method = "performRangedAttack(Lnet/minecraft/world/entity/LivingEntity;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;addFreshEntity(Lnet/minecraft/world/entity/Entity;)Z"))
    private boolean universalmobwar$augmentPotionThrows(Level world, Entity entity, LivingEntity target, float pullProgress) {
        try {
            if (!(world instanceof ServerLevel serverWorld) || !(entity instanceof ThrownPotion potion)) {
                return world.addFreshEntity(entity);
            }

            Mob witch = (Mob) (Object) this;
            if (!(witch instanceof IMobWarDataHolder holder)) {
                return world.addFreshEntity(entity);
            }

            MobWarData data = holder.getMobWarData();
            if (data == null) {
                return world.addFreshEntity(entity);
            }

            ItemStack resolvedStack = WitchAbilityHelper.resolvePotionStack(witch, data, potion.getItem().copy(), witch.getRandom());
            potion.setItem(resolvedStack);

            ThrowStats stats = WitchAbilityHelper.resolveThrowStats(witch, data);
            WitchAbilityHelper.configureTrajectory(potion, witch, target, stats, 0.0f);

            boolean spawned = serverWorld.addFreshEntity(potion);
            return spawned;
        } catch (Throwable t) {
            UniversalMobWarMod.LOGGER.error("[WitchAbilityMixin] Potion throw augmentation failed", t);
            return world.addFreshEntity(entity);
        }
    }
}
