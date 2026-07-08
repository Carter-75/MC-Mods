/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.mob.PathAwareEntity
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.entity.ai.goal.LookAtEntityGoal
 *  net.minecraft.entity.ai.goal.WanderAroundGoal
 *  net.minecraft.entity.ai.goal.ActiveTargetGoal
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.nbt.NbtElement
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.data.DataTracker
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.entity.ai.pathing.PathNodeType
 */
package backported.updates.garden.entity;

import backported.updates.garden.Init;
import backported.updates.garden.entity.CreakingHeartBlockEntity;
import backported.updates.garden.entity.ai.goal.CreakingMeleeAttackGoal;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.ai.pathing.PathNodeType;

public class CreakingEntity
extends HostileEntity {
    private static final TrackedData<Boolean> IS_HEART_SPAWN = DataTracker.registerData(CreakingEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.BOOLEAN);
    public boolean isHeartSpawn = false;
    public boolean deathLock = false;
    public BlockPos boundHeart;

    public CreakingEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.WATER, -1.0f);
    }

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 0.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0);
    }

    public boolean isHeartNear() {
        if (this.boundHeart != null && this.getWorld().getBlockState(this.boundHeart).getBlock() == Init.CREAKING_HEART) {
            Vec3d heartPos;
            Vec3d entityPos = this.getPos();
            double distance = entityPos.distanceTo(heartPos = new Vec3d((double)this.boundHeart.getX(), (double)this.boundHeart.getY(), (double)this.boundHeart.getZ()));
            if (distance <= 34.0) {
                BlockEntity blockEntity = this.getWorld().getBlockEntity(this.boundHeart);
                if (blockEntity instanceof CreakingHeartBlockEntity) {
                    ((CreakingHeartBlockEntity)blockEntity).creakingEntity = this;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            return;
        }
        BlockEntity blockEntity = this.getWorld().getBlockEntity(this.getBlockPos());
        if (blockEntity instanceof CreakingHeartBlockEntity) {
            CreakingHeartBlockEntity creakingHeartBlockEntity = (CreakingHeartBlockEntity)blockEntity;
            creakingHeartBlockEntity.creakingEntity = this;
        }
        boolean isHeartNear = this.isHeartNear();
        if (this.isHeartSpawn && this.getWorld().isDay() && !this.getWorld().isThundering() || this.isHeartSpawn && !isHeartNear) {
            this.deathLock = true;
            this.kill();
        }
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(IS_HEART_SPAWN, false);
    }

    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("is_heart_spawn", this.isHeartSpawn);
        if (this.boundHeart != null) {
            NbtCompound heartNbt = new NbtCompound();
            heartNbt.putInt("x", this.boundHeart.getX());
            heartNbt.putInt("y", this.boundHeart.getY());
            heartNbt.putInt("z", this.boundHeart.getZ());
            nbt.put("bound_heart", (NbtElement)heartNbt);
        }
    }

    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.isHeartSpawn = nbt.getBoolean("is_heart_spawn");
        if (nbt.contains("bound_heart", 10)) {
            NbtCompound heartNbt = nbt.getCompound("bound_heart");
            this.boundHeart = new BlockPos(heartNbt.getInt("x"), heartNbt.getInt("y"), heartNbt.getInt("z"));
        }
    }

    protected void initGoals() {
        this.goalSelector.add(1, (Goal)new CreakingMeleeAttackGoal((PathAwareEntity)this, 1.0, true));
        this.goalSelector.add(2, (Goal)new WanderAroundGoal((PathAwareEntity)this, 0.7));
        this.goalSelector.add(3, (Goal)new LookAtEntityGoal((MobEntity)this, PlayerEntity.class, 32.0f));
        this.targetSelector.add(0, (Goal)new ActiveTargetGoal((MobEntity)this, PlayerEntity.class, false));
    }

    public void onDeath(DamageSource damageSource) {
        BlockEntity blockEntity;
        super.onDeath(damageSource);
        if (this.boundHeart != null && (blockEntity = this.getWorld().getBlockEntity(this.boundHeart)) instanceof CreakingHeartBlockEntity) {
            ((CreakingHeartBlockEntity)blockEntity).creakingEntity = null;
        }
    }

    public boolean damage(DamageSource source, float amount) {
        if (this.isHeartSpawn && this.isHeartNear() && (this.getWorld().isNight() || this.getWorld().isThundering())) {
            BlockState blockState = this.getWorld().getBlockState(this.boundHeart);
            BlockEntity blockEntity = this.getWorld().getBlockEntity(this.boundHeart);
            Block block = blockState.getBlock();
            if (blockEntity instanceof CreakingHeartBlockEntity) {
                ((CreakingHeartBlockEntity)blockEntity).trySpawnResin();
            }
            return false;
        }
        return super.damage(source, amount);
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }
}

