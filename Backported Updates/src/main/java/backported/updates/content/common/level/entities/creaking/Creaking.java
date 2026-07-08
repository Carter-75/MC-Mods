/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Dynamic
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.ai.pathing.PathNodeNavigator
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.ai.control.BodyControl
 *  net.minecraft.entity.ai.control.LookControl
 *  net.minecraft.entity.ai.control.JumpControl
 *  net.minecraft.entity.ai.control.MoveControl
 *  net.minecraft.entity.ai.pathing.LandPathNodeMaker
 *  net.minecraft.entity.ai.pathing.EntityNavigation
 *  net.minecraft.entity.ai.pathing.MobNavigation
 *  net.minecraft.entity.passive.WolfEntity
 *  net.minecraft.entity.mob.HostileEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.entity.projectile.ProjectileEntity
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.particle.BlockStateParticleEffect
 *  net.minecraft.util.hit.HitResult$Type
 *  net.minecraft.particle.ParticleTypes
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.nbt.NbtHelper
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.data.DataTracker
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.world.RaycastContext
 *  net.minecraft.world.RaycastContext$FluidHandling
 *  net.minecraft.world.RaycastContext$ShapeType
 *  net.minecraft.entity.ai.brain.Brain
 *  net.minecraft.entity.ai.brain.Brain$Profile
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.world.WorldView
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.entity.ai.pathing.PathNodeType
 *  net.minecraft.entity.AnimationState
 *  net.minecraft.registry.tag.DamageTypeTags
 *  net.minecraft.entity.ai.pathing.PathContext
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.entities.creaking;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blockentities.CreakingHeartBlockEntity;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.level.entities.creaking.CreakingAi;
import backported.updates.content.common.registries.ModBlocks;
import com.mojang.serialization.Dynamic;
import java.util.List;
import java.util.Optional;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.pathing.PathNodeNavigator;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.pathing.LandPathNodeMaker;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3i;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.util.hit.HitResult;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtHelper;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.RaycastContext;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.world.WorldView;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.AnimationState;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.entity.ai.pathing.PathContext;
import org.jetbrains.annotations.Nullable;

public class Creaking
extends HostileEntity {
    private static final TrackedData<Boolean> CAN_MOVE = DataTracker.registerData(Creaking.class, (TrackedDataHandler)TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_ACTIVE = DataTracker.registerData(Creaking.class, (TrackedDataHandler)TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_TEARING_DOWN = DataTracker.registerData(Creaking.class, (TrackedDataHandler)TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Optional<BlockPos>> HOME_POS = DataTracker.registerData(Creaking.class, (TrackedDataHandler)TrackedDataHandlerRegistry.OPTIONAL_BLOCK_POS);
    public static final byte CREAKING_ATTACK = 4;
    public static final byte CREAKING_HURT = 66;
    private int attackAnimationRemainingTicks;
    public final AnimationState attackAnimationState = new AnimationState();
    public final AnimationState invulnerabilityAnimationState = new AnimationState();
    public final AnimationState deathAnimationState = new AnimationState();
    private int invulnerabilityAnimationRemainingTicks;
    private boolean eyesGlowing;
    private int nextFlickerTime;
    private int playerStuckCounter;
    private int creakingDeathTime;

    public Creaking(EntityType<? extends HostileEntity> entityType, World level) {
        super(entityType, level);
        this.lookControl = new CreakingLookControl((MobEntity)this);
        this.moveControl = new CreakingMoveControl((MobEntity)this);
        this.jumpControl = new CreakingJumpControl((MobEntity)this);
        MobNavigation navigation = (MobNavigation)this.getNavigation();
        navigation.setCanSwim(true);
        this.experiencePoints = 0;
    }

    public void setTransient(BlockPos pos) {
        this.setHomePos(pos);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_OTHER, 8.0f);
        this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, 8.0f);
        this.setPathfindingPenalty(PathNodeType.LAVA, 8.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, 0.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 0.0f);
    }

    public boolean isHeartBound() {
        return this.getHomePos() != null;
    }

    protected BodyControl createBodyControl() {
        return new CreakingBodyRotationControl((MobEntity)this);
    }

    protected Brain.Profile<Creaking> createBrainProfile() {
        return CreakingAi.brainProvider();
    }

    protected Brain<?> deserializeBrain(Dynamic<?> dynamic) {
        return CreakingAi.makeBrain((Brain<Creaking>)this.createBrainProfile().deserialize(dynamic));
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(CAN_MOVE, true);
        builder.add(IS_ACTIVE, false);
        builder.add(IS_TEARING_DOWN, false);
        builder.add(HOME_POS, Optional.empty());
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3.0).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 32.0).add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0625);
    }

    public boolean canMove() {
        return (Boolean)this.dataTracker.get(CAN_MOVE);
    }

    public boolean tryAttack(Entity target) {
        if (!(target instanceof LivingEntity)) {
            return false;
        }
        this.attackAnimationRemainingTicks = 15;
        this.getWorld().sendEntityStatus((Entity)this, (byte)4);
        return super.tryAttack(target);
    }

    public boolean damage(DamageSource source, float amount) {
        BlockPos home = this.getHomePos();
        if (home == null || source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            return super.damage(source, amount);
        }
        if (!this.isInvulnerableTo(source) && this.invulnerabilityAnimationRemainingTicks <= 0 && !this.isDead()) {
            PlayerEntity player = this.blameSourceForDamage(source);
            Entity entity = source.getSource();
            if (entity instanceof LivingEntity || entity instanceof ProjectileEntity || player != null) {
                CreakingHeartBlockEntity heart;
                this.invulnerabilityAnimationRemainingTicks = 8;
                this.getWorld().sendEntityStatus((Entity)this, (byte)66);
                BlockEntity class_25862 = this.getWorld().getBlockEntity(home);
                if (class_25862 instanceof CreakingHeartBlockEntity && (heart = (CreakingHeartBlockEntity)class_25862).isProtector(this)) {
                    if (player != null) {
                        heart.creakingHurt();
                    }
                    this.playHurtSound(source);
                }
                return true;
            }
        }
        return false;
    }

    @Nullable
    public PlayerEntity blameSourceForDamage(DamageSource source) {
        Entity entity = source.getAttacker();
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity)entity;
            if (!source.isIn(DamageTypeTags.NO_ANGER)) {
                WolfEntity wolf;
                this.setAttacker(living);
                if (entity instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity)entity;
                    this.playerHitTimer = 100;
                    this.attackingPlayer = player;
                } else if (entity instanceof WolfEntity && (wolf = (WolfEntity)entity).isTamed()) {
                    PlayerEntity player;
                    this.playerHitTimer = 100;
                    LivingEntity class_13092 = wolf.getOwner();
                    this.attackingPlayer = class_13092 instanceof PlayerEntity ? (player = (PlayerEntity)class_13092) : null;
                }
            }
        }
        return this.attackingPlayer;
    }

    public boolean isPushable() {
        return super.isPushable() && this.canMove();
    }

    public void addVelocity(double x, double y, double z) {
        if (this.canMove()) {
            super.addVelocity(x, y, z);
        }
    }

    @SuppressWarnings("unchecked")
    public Brain<Creaking> getBrain() {
        return (Brain<Creaking>) super.getBrain();
    }

    protected void mobTick() {
        Profiler profiler = this.getWorld().getProfiler();
        profiler.push("creakingBrain");
        this.getBrain().tick((ServerWorld)this.getWorld(), this);
        profiler.pop();
        CreakingAi.updateActivity(this);
    }

    public void tickMovement() {
        if (this.invulnerabilityAnimationRemainingTicks > 0) {
            --this.invulnerabilityAnimationRemainingTicks;
        }
        if (this.attackAnimationRemainingTicks > 0) {
            --this.attackAnimationRemainingTicks;
        }
        if (!this.getWorld().isClient()) {
            boolean canMove = (Boolean)this.dataTracker.get(CAN_MOVE);
            boolean checkCanMove = this.checkCanMove();
            if (checkCanMove != canMove) {
                if (checkCanMove) {
                    this.playSoundIfNotSilent(ModSoundEvents.CREAKING_UNFREEZE.get());
                } else {
                    this.getNavigation().stop();
                    this.setSidewaysSpeed(0.0f);
                    this.setUpwardSpeed(0.0f);
                    this.setMovementSpeed(0.0f);
                    this.playSoundIfNotSilent(ModSoundEvents.CREAKING_FREEZE.get());
                }
            }
            this.dataTracker.set(CAN_MOVE, checkCanMove);
        }
        super.tickMovement();
    }

    public void tick() {
        BlockPos pos;
        if (!this.getWorld().isClient() && (pos = this.getHomePos()) != null) {
            CreakingHeartBlockEntity heart;
            boolean isProtector;
            BlockEntity class_25862 = this.getWorld().getBlockEntity(pos);
            boolean bl = isProtector = class_25862 instanceof CreakingHeartBlockEntity && (heart = (CreakingHeartBlockEntity)class_25862).isProtector(this);
            if (!isProtector) {
                this.setHealth(0.0f);
            }
        }
        super.tick();
        if (this.getWorld().isClient()) {
            if (this.isTearingDown() && this.deathTime != 0) {
                this.deathTime = 0;
            }
            this.setupAnimationStates();
            this.checkEyeBlink();
        }
    }

    protected void updatePostDeath() {
        if (this.isHeartBound() && this.isTearingDown()) {
            ++this.creakingDeathTime;
            if (!this.getWorld().isClient() && this.creakingDeathTime > 45 && !this.isRemoved()) {
                this.tearDown();
            }
        } else {
            super.updatePostDeath();
        }
    }

    protected void updateLimbs(float partialTick) {
        float speed = Math.min(partialTick * 25.0f, 3.0f);
        this.limbAnimator.updateLimbs(speed, 0.4f);
    }

    private void setupAnimationStates() {
        this.attackAnimationState.setRunning(this.attackAnimationRemainingTicks > 0, this.age);
        this.invulnerabilityAnimationState.setRunning(this.invulnerabilityAnimationRemainingTicks > 0, this.age);
        this.deathAnimationState.setRunning(this.isTearingDown(), this.age);
    }

    public void tearDown() {
        World class_19372 = this.getWorld();
        if (class_19372 instanceof ServerWorld) {
            ServerWorld server = (ServerWorld)class_19372;
            Box aabb = this.getBoundingBox();
            Vec3d center = aabb.getCenter();
            double x = aabb.getLengthX() * 0.3;
            double y = aabb.getLengthY() * 0.3;
            double z = aabb.getLengthZ() * 0.3;
            ModParticles.sendParticles(server, new BlockStateParticleEffect(ParticleTypes.BLOCK, ModBlocks.PALE_OAK_WOOD.get().getDefaultState()), center.x, center.y, center.z, 100, x, y, z, 0.0);
            ModParticles.sendParticles(server, new BlockStateParticleEffect(ParticleTypes.BLOCK, ModBlocks.CREAKING_HEART.get().getDefaultState().with(CreakingHeartBlock.STATE, (CreakingHeartState.AWAKE))), center.x, center.y, center.z, 10, x, y, z, 0.0);
        }
        this.playSoundIfNotSilent(this.getDeathSound());
        this.discard();
    }

    public void creakingDeathEffects(DamageSource source) {
        this.blameSourceForDamage(source);
        this.onDeath(source);
        this.playSoundIfNotSilent(ModSoundEvents.CREAKING_TWITCH.get());
    }

    public void handleStatus(byte id) {
        if (id == 66) {
            this.invulnerabilityAnimationRemainingTicks = 8;
            this.playHurtSound(this.getDamageSources().generic());
        } else if (id == 4) {
            this.attackAnimationRemainingTicks = 15;
            this.playAttackSound();
        } else {
            super.handleStatus(id);
        }
    }

    public boolean isFireImmune() {
        return this.isHeartBound() || super.isFireImmune();
    }

    protected boolean canAddPassenger(Entity passenger) {
        return !this.isHeartBound() && super.canAddPassenger(passenger);
    }

    protected boolean couldAcceptPassenger() {
        return !this.isHeartBound() && super.couldAcceptPassenger();
    }

    protected void addPassenger(Entity passenger) {
        if (!this.isHeartBound()) {
            super.addPassenger(passenger);
        }
    }

    public boolean canUsePortals(boolean allowPassengers) {
        return !this.isHeartBound() && super.canUsePortals(allowPassengers);
    }

    protected EntityNavigation createNavigation(World level) {
        return new CreakingPathNavigation(this, level);
    }

    public boolean playerIsStuckInYou() {
        List<PlayerEntity> players = this.brain.getOptionalRegisteredMemory(MemoryModuleType.NEAREST_PLAYERS).orElse(List.of());
        if (!players.isEmpty()) {
            Box aabb = this.getBoundingBox();
            for (PlayerEntity player : players) {
                if (!aabb.contains(player.getEyePos())) continue;
                ++this.playerStuckCounter;
                return this.playerStuckCounter > 4;
            }
        }
        this.playerStuckCounter = 0;
        return false;
    }

    public void readCustomDataFromNbt(NbtCompound tag) {
        super.readCustomDataFromNbt(tag);
        if (tag.contains("home_pos")) {
            this.setTransient((BlockPos)NbtHelper.toBlockPos((NbtCompound)tag, (String)"home_pos").get());
        }
    }

    public void writeCustomDataToNbt(NbtCompound tag) {
        super.writeCustomDataToNbt(tag);
        if (this.getHomePos() != null) {
            tag.put("home_pos", NbtHelper.fromBlockPos((BlockPos)this.getHomePos()));
        }
    }

    public void setHomePos(BlockPos pos) {
        this.dataTracker.set(HOME_POS, Optional.of(pos));
    }

    public BlockPos getHomePos() {
        return this.dataTracker.get(HOME_POS).orElse(null);
    }

    public void setTearingDown() {
        this.dataTracker.set(IS_TEARING_DOWN, true);
    }

    public boolean isTearingDown() {
        return (Boolean)this.dataTracker.get(IS_TEARING_DOWN);
    }

    public boolean hasGlowingEyes() {
        return this.eyesGlowing;
    }

    public boolean shouldEyesGlow() {
        return this.isTearingDown() ? this.hasGlowingEyes() : this.isActive();
    }

    public void checkEyeBlink() {
        if (this.creakingDeathTime > this.nextFlickerTime) {
            this.nextFlickerTime = this.creakingDeathTime + this.getRandom().nextBetween(this.eyesGlowing ? 2 : this.creakingDeathTime / 4, this.eyesGlowing ? 8 : this.creakingDeathTime / 2);
            this.eyesGlowing = !this.eyesGlowing;
        }
    }

    public void playAttackSound() {
        this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), ModSoundEvents.CREAKING_ATTACK.get(), this.getSoundCategory(), 1.0f, 1.0f, false);
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return this.isActive() ? null : ModSoundEvents.CREAKING_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return this.isHeartBound() ? ModSoundEvents.CREAKING_SWAY.get() : super.getHurtSound(source);
    }

    protected SoundEvent getDeathSound() {
        return ModSoundEvents.CREAKING_DEATH.get();
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(ModSoundEvents.CREAKING_STEP.get(), 0.15f, 1.0f);
    }

    @Nullable
    public LivingEntity getTarget() {
        return this.getBrain().getOptionalRegisteredMemory(MemoryModuleType.ATTACK_TARGET).orElse(null);
    }

    public void takeKnockback(double strength, double x, double z) {
        if (this.canMove()) {
            super.takeKnockback(strength, x, z);
        }
    }

    public boolean checkCanMove() {
        List<PlayerEntity> players = this.brain.getOptionalRegisteredMemory(MemoryModuleType.NEAREST_PLAYERS).orElse(List.of());
        boolean isActive = this.isActive();
        if (players.isEmpty()) {
            if (isActive) {
                this.deactivate();
            }
        } else {
            boolean canMove = false;
            for (PlayerEntity player : players) {
                if (!this.canTarget((LivingEntity)player) || this.isTeammate((Entity)player)) continue;
                canMove = true;
                if (isActive && player.getEquippedStack(EquipmentSlot.HEAD).isOf(Blocks.CARVED_PUMPKIN.asItem()) || !this.isLookingAtMe((LivingEntity)player, 0.5, false, true, this.getEyeY(), this.getY() + 0.5 * (double)this.getScale(), (this.getEyeY() + this.getY()) / 2.0)) continue;
                if (isActive) {
                    return false;
                }
                if (!(player.squaredDistanceTo((Entity)this) < 144.0)) continue;
                this.activate(player);
                return false;
            }
            if (!canMove && isActive) {
                this.deactivate();
            }
        }
        return true;
    }

    public boolean isLookingAtMe(LivingEntity entity, double tolerance, boolean scaleWithDistance, boolean checkVisibility, double ... heightTargets) {
        Vec3d viewVector = entity.getRotationVec(1.0f).normalize();
        for (double heightTarget : heightTargets) {
            double lookThreshold;
            Vec3d directionToMe = new Vec3d(this.getX() - entity.getX(), heightTarget - entity.getEyeY(), this.getZ() - entity.getZ());
            double distance = directionToMe.length();
            double dotProduct = viewVector.dotProduct(directionToMe = directionToMe.normalize());
            if (!(dotProduct > (lookThreshold = 1.0 - tolerance / (scaleWithDistance ? distance : 1.0))) || !this.hasLineOfSight(entity, (Entity)this, checkVisibility ? RaycastContext.ShapeType.VISUAL : RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, heightTarget)) continue;
            return true;
        }
        return false;
    }

    public boolean hasLineOfSight(LivingEntity stalker, Entity me, RaycastContext.ShapeType block, RaycastContext.FluidHandling fluid, double targetHeight) {
        if (me.getWorld() != stalker.getWorld()) {
            return false;
        }
        Vec3d stalkerPosition = new Vec3d(stalker.getX(), stalker.getEyeY(), stalker.getZ());
        Vec3d myPosition = new Vec3d(me.getX(), targetHeight, me.getZ());
        return myPosition.distanceTo(stalkerPosition) <= 128.0 && stalker.getWorld().raycast(new RaycastContext(stalkerPosition, myPosition, block, fluid, (Entity)stalker)).getType() == HitResult.Type.MISS;
    }

    public void activate(PlayerEntity player) {
        this.getBrain().remember(MemoryModuleType.ATTACK_TARGET, player);
        this.playSoundIfNotSilent(ModSoundEvents.CREAKING_ACTIVATE.get());
        this.setIsActive(true);
    }

    public void deactivate() {
        this.getBrain().forget(MemoryModuleType.ATTACK_TARGET);
        this.playSoundIfNotSilent(ModSoundEvents.CREAKING_DEACTIVATE.get());
        this.setIsActive(false);
    }

    public void setIsActive(boolean active) {
        this.dataTracker.set(IS_ACTIVE, active);
    }

    public boolean isActive() {
        return (Boolean)this.dataTracker.get(IS_ACTIVE);
    }

    public float getPathfindingFavor(BlockPos pos, WorldView level) {
        return 0.0f;
    }

    class CreakingLookControl
    extends LookControl {
        public CreakingLookControl(MobEntity mob) {
            super(mob);
        }

        public void tick() {
            if (Creaking.this.canMove()) {
                super.tick();
            }
        }
    }

    class CreakingMoveControl
    extends MoveControl {
        public CreakingMoveControl(MobEntity mob) {
            super(mob);
        }

        public void tick() {
            if (Creaking.this.canMove()) {
                super.tick();
            }
        }
    }

    class CreakingJumpControl
    extends JumpControl {
        public CreakingJumpControl(MobEntity mob) {
            super(mob);
        }

        public void tick() {
            if (Creaking.this.canMove()) {
                super.tick();
            } else {
                Creaking.this.setJumping(false);
            }
        }
    }

    class CreakingBodyRotationControl
    extends BodyControl {
        public CreakingBodyRotationControl(MobEntity mob) {
            super(mob);
        }

        public void tick() {
            if (Creaking.this.canMove()) {
                super.tick();
            }
        }
    }

    class CreakingPathNavigation
    extends MobNavigation {
        CreakingPathNavigation(Creaking creaking2, World level) {
            super((MobEntity)creaking2, level);
        }

        public void tick() {
            if (Creaking.this.canMove()) {
                super.tick();
            }
        }

        protected PathNodeNavigator createPathNodeNavigator(int i) {
            this.nodeMaker = new HomeNodeEvaluator();
            this.nodeMaker.setCanEnterOpenDoors(true);
            return new PathNodeNavigator(this.nodeMaker, i);
        }
    }

    class HomeNodeEvaluator
    extends LandPathNodeMaker {
        HomeNodeEvaluator() {
        }

        public PathNodeType getDefaultNodeType(PathContext context, int x, int y, int z) {
            BlockPos pos = Creaking.this.getHomePos();
            if (pos == null) {
                return super.getDefaultNodeType(context, x, y, z);
            }
            double distance = pos.getSquaredDistance(new Vec3i(x, y, z));
            return distance > 1024.0 && distance >= pos.getSquaredDistance((Vec3i)context.getEntityPos()) ? PathNodeType.BLOCKED : super.getDefaultNodeType(context, x, y, z);
        }
    }
}

