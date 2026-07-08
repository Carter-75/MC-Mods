package mod.universalmobwar.mixin;

import mod.universalmobwar.UniversalMobWarMod;
import mod.universalmobwar.data.IMobWarDataHolder;
import mod.universalmobwar.data.MobWarData;
import mod.universalmobwar.system.ScalingSystem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.Mob;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Hooks Creeper-specific scaling abilities for explosion power and lingering clouds.
 */
@Mixin(Creeper.class)
public abstract class CreeperAbilityMixin extends Monster {

    protected CreeperAbilityMixin(EntityType<? extends Monster> entityType, Level world) {
        super(entityType, world);
    }

    @Inject(method = "explode", at = @At("HEAD"))
    private void universalmobwar$boostExplosionRadius(CallbackInfo ci) {
        UniversalMobWarMod.runSafely("CreeperAbilityMixin#boostExplosionRadius", () -> {
            if (!(this.level() instanceof ServerLevel)) {
                return;
            }

            MobWarData data = universalmobwar$getData();
            if (data == null) {
                return;
            }

            CompoundTag skillData = data.getSkillData();
            if (skillData.getInt("ability_creeper_power") <= 0) {
                return;
            }

            float configuredRadius = ScalingSystem.getCreeperExplosionRadius((Mob) (Object) this, data);
            CreeperEntityAccessor accessor = (CreeperEntityAccessor) this;
            int upgradedRadius = Math.max(accessor.universalmobwar$getExplosionRadius(), Math.round(configuredRadius));
            accessor.universalmobwar$setExplosionRadius(upgradedRadius);
        });
    }

    @Inject(method = "explode", at = @At("TAIL"))
    private void universalmobwar$spawnPotionCloud(CallbackInfo ci) {
        UniversalMobWarMod.runSafely("CreeperAbilityMixin#spawnPotionCloud", () -> {
            if (!(this.level() instanceof ServerLevel serverWorld)) {
                return;
            }

            MobWarData data = universalmobwar$getData();
            if (data == null) {
                return;
            }

            if (data.getSkillData().getInt("ability_creeper_potion_cloud") <= 0) {
                return;
            }

            BlockPos pos = this.blockPosition();
            ScalingSystem.spawnCreeperPotionCloud((Mob) (Object) this, data, serverWorld, pos);
        });
    }

    @Unique
    private MobWarData universalmobwar$getData() {
        if (this instanceof IMobWarDataHolder holder) {
            return holder.getMobWarData();
        }
        return MobWarData.get((Mob) (Object) this);
    }
}
