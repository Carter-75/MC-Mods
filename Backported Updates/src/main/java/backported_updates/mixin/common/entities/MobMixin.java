/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.world.LocalDifficulty
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.EntityData
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.World
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.world.ServerWorldAccess
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package backported_updates.mixin.common.entities;

import net.minecraft.world.LocalDifficulty;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={MobEntity.class})
public abstract class MobMixin
extends LivingEntity {
    @Shadow
    public abstract ActionResult interact(PlayerEntity var1, Hand var2);

    @Shadow
    protected abstract void initDataTracker(DataTracker.Builder var1);

    protected MobMixin(EntityType<? extends LivingEntity> entityType, World level) {
        super(entityType, level);
    }

    @Inject(method={"initDataTracker"}, at={@At(value="TAIL")})
    protected void vb$defineSynchedData(DataTracker.Builder builder, CallbackInfo ci) {
    }

    @Inject(method={"writeCustomDataToNbt"}, at={@At(value="RETURN")})
    protected void vb$addAdditionalSaveData(NbtCompound tag, CallbackInfo ci) {
    }

    @Inject(method={"readCustomDataFromNbt"}, at={@At(value="RETURN")})
    protected void vb$readAdditionalSaveData(NbtCompound tag, CallbackInfo ci) {
    }

    @Inject(method={"initialize"}, at={@At(value="RETURN")})
    protected void vb$finalizeSpawn(ServerWorldAccess level, LocalDifficulty difficulty, SpawnReason reason, EntityData spawnData, CallbackInfoReturnable<EntityData> cir) {
    }

    @Inject(method={"tick"}, at={@At(value="RETURN")})
    protected void vb$tick(CallbackInfo ci) {
    }
}

