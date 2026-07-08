/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Dynamic
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.passive.PassiveEntity
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.MovementType
 *  net.minecraft.entity.ai.control.BodyControl
 *  net.minecraft.entity.ai.control.FlightMoveControl
 *  net.minecraft.entity.ai.control.LookControl
 *  net.minecraft.entity.ai.control.MoveControl
 *  net.minecraft.entity.ai.control.MoveControl$State
 *  net.minecraft.entity.ai.goal.SwimGoal
 *  net.minecraft.entity.ai.goal.Goal
 *  net.minecraft.entity.ai.goal.Goal$Control
 *  net.minecraft.entity.ai.pathing.BirdNavigation
 *  net.minecraft.entity.ai.pathing.EntityNavigation
 *  net.minecraft.entity.passive.AnimalEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.recipe.Ingredient
 *  net.minecraft.world.BlockView
 *  net.minecraft.world.World
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.biome.Biome$Precipitation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.math.Vec2f
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.block.BlockState
 *  net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket
 *  net.minecraft.world.Heightmap$Type
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.data.DataTracker
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.FluidTags
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.fluid.FluidState
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.entity.ai.brain.Brain
 *  net.minecraft.entity.ai.brain.Brain$Profile
 *  net.minecraft.world.WorldView
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.entity.Mount
 *  net.minecraft.entity.Leashable
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.entities.happyghast;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.leash.LeashExtension;
import backported.updates.content.common.level.entities.happyghast.HappyGhastAi;
import backported.updates.content.common.level.entities.happyghast.HappyGhastTemptGoal;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.core.util.BlockPosUtils;
import backported.updates.content.core.util.CollisionUtils;
import backported_updates.mixin.access.LivingEntityAccessor;
import com.mojang.serialization.Dynamic;
import java.util.EnumSet;
import java.util.function.BooleanSupplier;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.ai.control.BodyControl;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.control.LookControl;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.pathing.BirdNavigation;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.Packet;
import net.minecraft.block.BlockState;
import net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.math.MathHelper;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.world.WorldView;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.math.random.Random;
import net.minecraft.entity.Mount;
import net.minecraft.entity.Leashable;
import org.jetbrains.annotations.Nullable;

public class HappyGhast
extends AnimalEntity
implements Mount,
LeashExtension {
    public static final Ingredient IS_FOOD = Ingredient.fromTag(ModItemTags.HAPPY_GHAST_FOOD);
    private int leashHolderTime = 0;
    private int serverStillTimeout;
    private static final TrackedData<Boolean> IS_LEASH_HOLDER = DataTracker.registerData(HappyGhast.class, (TrackedDataHandler)TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> STAYS_STILL = DataTracker.registerData(HappyGhast.class, (TrackedDataHandler)TrackedDataHandlerRegistry.BOOLEAN);
    private boolean requiresPrecisePosition;

    public HappyGhast(EntityType<? extends AnimalEntity> entityType, World level) {
        super(entityType, level);
        this.moveControl = new GhastMoveControl(this, true, this::isOnStillTimeout);
        this.lookControl = new HappyGhastLookControl();
    }

    private void setServerStillTimeout(int timeout) {
        World class_19372;
        if (this.serverStillTimeout <= 0 && timeout > 0 && (class_19372 = this.getWorld()) instanceof ServerWorld) {
            ServerWorld level = (ServerWorld)class_19372;
            this.updateTrackedPosition(this.getX(), this.getY(), this.getZ());
            level.getChunkManager().chunkLoadingManager.sendToOtherNearbyPlayers((Entity)this, (Packet)new EntityPositionS2CPacket((Entity)this));
        }
        this.serverStillTimeout = timeout;
        this.syncStayStillFlag();
    }

    private EntityNavigation createBabyNavigation(World level) {
        return new BabyFlyingPathNavigation((MobEntity)this, level);
    }

    protected void initGoals() {
        this.goalSelector.add(3, (Goal)new GhastFloatGoal(this));
        this.goalSelector.add(4, (Goal)new HappyGhastTemptGoal(this, 1.0, stack -> !this.isHarnessed() && !this.isBaby() ? stack.isIn(ModItemTags.HAPPY_GHAST_TEMPT_ITEMS) : IS_FOOD.test(stack), false, 7.0));
        this.goalSelector.add(5, (Goal)new RandomFloatAroundGoal(this, 16));
    }

    private void adultGhastSetup() {
        this.moveControl = new GhastMoveControl(this, true, this::isOnStillTimeout);
        this.lookControl = new HappyGhastLookControl();
        this.navigation = this.createNavigation(this.getWorld());
        World class_19372 = this.getWorld();
        if (class_19372 instanceof ServerWorld) {
            ServerWorld server = (ServerWorld)class_19372;
            this.clearGoals(goal -> true);
            this.initGoals();
            this.getBrain().stopAllTasks(server, this);
            this.brain.forgetAll();
        }
    }

    private void babyGhastSetup() {
        this.moveControl = new FlightMoveControl((MobEntity)this, 180, true);
        this.lookControl = new LookControl((MobEntity)this);
        this.navigation = this.createBabyNavigation(this.getWorld());
        this.setServerStillTimeout(0);
        this.clearGoals(goal -> true);
    }

    protected void onGrowUp() {
        if (this.isBaby()) {
            this.babyGhastSetup();
        } else {
            this.adultGhastSetup();
        }
        super.onGrowUp();
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return AnimalEntity.createLivingAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0).add(EntityAttributes.GENERIC_FLYING_SPEED, 0.05).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.05).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0);
    }

    protected float clampScale(float scale) {
        return Math.min(scale, 1.0f);
    }

    public boolean getRequiresPrecisePosition() {
        return this.requiresPrecisePosition;
    }

    public void setRequiresPrecisePosition(boolean requiresPrecisePosition) {
        this.requiresPrecisePosition = requiresPrecisePosition;
    }

    public void stopMovement() {
        this.getNavigation().stop();
        this.setSidewaysSpeed(0.0f);
        this.setUpwardSpeed(0.0f);
        this.setMovementSpeed(0.0f);
        this.setVelocity(0.0, 0.0, 0.0);
        this.vb$resetAngularMomentum();
    }

    protected void fall(double y, boolean onGround, BlockState state, BlockPos pos) {
    }

    public void travel(Vec3d travelVector) {
        if (this.isOnStillTimeout()) {
            this.setVelocity(Vec3d.ZERO);
            return;
        }
        float speed = (float)this.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED) * 5.0f / 3.0f;
        if (this.isLogicalSideForUpdatingMovement()) {
            if (this.isTouchingWater()) {
                this.updateVelocity(speed, travelVector);
                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply((double)0.8f));
            } else if (this.isInLava()) {
                this.updateVelocity(speed, travelVector);
                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply(0.5));
            } else {
                this.updateVelocity(speed, travelVector);
                this.move(MovementType.SELF, this.getVelocity());
                this.setVelocity(this.getVelocity().multiply((double)0.91f));
            }
        }
        this.updateLimbs(false);
    }

    public boolean isClimbing() {
        return false;
    }

    public float getPathfindingFavor(BlockPos pos, WorldView level) {
        if (!level.isAir(pos)) {
            return 0.0f;
        }
        return level.isAir(pos.down()) && !level.isAir(pos.down(2)) ? 10.0f : 5.0f;
    }

    protected boolean shouldFollowLeash() {
        return false;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    public float getSoundPitch() {
        return 1.0f;
    }

    public int getMinAmbientSoundDelay() {
        int interval = super.getMinAmbientSoundDelay();
        return this.hasPassengers() ? interval * 6 : interval;
    }

    @Nullable
    protected SoundEvent getAmbientSound() {
        return this.isBaby() ? ModSoundEvents.GHASTLING_AMBIENT.get() : ModSoundEvents.HAPPY_GHAST_AMBIENT.get();
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource source) {
        return this.isBaby() ? ModSoundEvents.GHASTLING_HURT.get() : ModSoundEvents.HAPPY_GHAST_HURT.get();
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return this.isBaby() ? ModSoundEvents.GHASTLING_DEATH.get() : ModSoundEvents.HAPPY_GHAST_DEATH.get();
    }

    public int getLimitPerChunk() {
        return 1;
    }

    @Nullable
    public PassiveEntity createChild(ServerWorld level, PassiveEntity mate) {
        return (PassiveEntity)ModEntities.HAPPY_GHAST.get().create((World)level);
    }

    public boolean canEat() {
        return false;
    }

    public float getScaleFactor() {
        return this.isBaby() ? 0.2375f : 1.0f;
    }

    public boolean isBreedingItem(ItemStack stack) {
        return IS_FOOD.test(stack);
    }

    public void equipHarness() {
        this.getWorld().playSoundFromEntity(null, (Entity)this, ModSoundEvents.HARNESS_EQUIP.get(), SoundCategory.NEUTRAL, 0.5f, 1.0f);
    }

    public boolean canBeHarnessed() {
        return this.isAlive() && !this.isBaby();
    }

    public boolean isHarnessed() {
        return this.getEquippedStack(EquipmentSlot.CHEST).isIn(ModItemTags.HARNESSES);
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ActionResult result;
        if (this.isBaby()) {
            return super.interactMob(player, hand);
        }
        ItemStack stack = player.getStackInHand(hand);
        if (!stack.isEmpty() && (result = stack.useOnEntity(player, (LivingEntity)this, hand)).isAccepted()) {
            return result;
        }
        if (!stack.isOf(Items.SHEARS) || this.hasPassengers() || !this.isHarnessed() && !player.isCreative()) {
            if (this.isHarnessed()) {
                if (!this.getWorld().isClient()) {
                    player.startRiding((Entity)this);
                }
                return ActionResult.success((boolean)this.getWorld().isClient());
            }
            return super.interactMob(player, hand);
        }
        stack.damage(1, (LivingEntity)player, HappyGhast.getSlotForHand((Hand)hand));
        this.playSoundIfNotSilent(ModSoundEvents.HARNESS_UNEQUIP.get());
        ItemStack harness = this.getEquippedStack(EquipmentSlot.CHEST);
        this.equipStack(EquipmentSlot.CHEST, ItemStack.EMPTY);
        this.dropStack(harness, this.getHeight() + 0.5f);
        return ActionResult.SUCCESS;
    }

    public Box getVisibilityBoundingBox() {
        Box box = super.getVisibilityBoundingBox();
        float height = this.getHeight();
        return box.withMinY(box.minY - (double)(height / 2.0f));
    }

    protected void addPassenger(Entity passenger) {
        if (!this.hasPassengers()) {
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSoundEvents.HARNESS_GOGGLES_DOWN.get(), this.getSoundCategory(), 1.0f, 1.0f);
        }
        super.addPassenger(passenger);
        if (!this.getWorld().isClient) {
            if (!this.scanPlayerAboveGhast()) {
                this.setServerStillTimeout(0);
            } else if (this.serverStillTimeout > 10) {
                this.setServerStillTimeout(10);
            }
        }
    }

    protected void removePassenger(Entity passenger) {
        super.removePassenger(passenger);
        if (!this.getWorld().isClient) {
            this.setServerStillTimeout(10);
        }
        if (!this.hasPassengers()) {
            this.clearPositionTarget();
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSoundEvents.HARNESS_GOGGLES_UP.get(), this.getSoundCategory(), 1.0f, 1.0f);
        }
    }

    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().size() < 4;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        LivingEntity class_13092;
        Entity class_12972;
        if (this.isHarnessed() && !this.isOnStillTimeout() && (class_12972 = this.getFirstPassenger()) instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity)class_12972;
            class_13092 = player;
        } else {
            class_13092 = super.getControllingPassenger();
        }
        return class_13092;
    }

    protected Vec3d getControlledMovementInput(PlayerEntity player, Vec3d travelVector) {
        float forward = player.sidewaysSpeed;
        float strafe = 0.0f;
        float upward = 0.0f;
        if (player.forwardSpeed != 0.0f) {
            float xOffset = MathHelper.cos((float)(player.getPitch() * ((float)Math.PI / 180)));
            float zOffset = -MathHelper.sin((float)(player.getPitch() * ((float)Math.PI / 180)));
            if (player.forwardSpeed < 0.0f) {
                xOffset *= -0.5f;
                zOffset *= -0.5f;
            }
            upward = zOffset;
            strafe = xOffset;
        }
        if (((LivingEntityAccessor)player).isJumping()) {
            upward += 0.5f;
        }
        return new Vec3d((double)forward, (double)upward, (double)strafe).multiply((double)3.9f * this.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED) * VanillaBackport.COMMON_CONFIG.happyGhastSpeedModifier.get());
    }

    protected Vec2f getRiddenRotation(LivingEntity controller) {
        return new Vec2f(controller.getPitch() * 0.5f, controller.getYaw());
    }

    protected void tickControlled(PlayerEntity controller, Vec3d riddenInput) {
        super.tickControlled(controller, riddenInput);
        Vec2f rotation = this.getRiddenRotation((LivingEntity)controller);
        float yRot = this.getYaw();
        float diff = MathHelper.wrapDegrees((float)(rotation.y - yRot));
        this.setRotation(yRot += diff * 0.08f, rotation.x);
        this.bodyYaw = this.headYaw = yRot;
        this.prevYaw = this.headYaw;
    }

    protected Brain.Profile<HappyGhast> createBrainProfile() {
        return HappyGhastAi.brainProvider();
    }

    protected Brain<?> deserializeBrain(Dynamic<?> dynamic) {
        return HappyGhastAi.makeBrain((Brain<HappyGhast>)this.createBrainProfile().deserialize(dynamic));
    }

    @SuppressWarnings("unchecked")
    public Brain<HappyGhast> getBrain() {
        return (Brain<HappyGhast>) super.getBrain();
    }

    protected void mobTick() {
        if (this.isBaby()) {
            Profiler profiler = this.getWorld().getProfiler();
            profiler.push("happyGhastBrain");
            this.getBrain().tick((ServerWorld)this.getWorld(), this);
            profiler.swap("HappyGhastActivityUpdate");
            HappyGhastAi.updateActivity(this);
            profiler.pop();
        }
        this.checkRestriction();
        super.mobTick();
    }

    public void tick() {
        super.tick();
        if (!this.getWorld().isClient()) {
            if (this.leashHolderTime > 0) {
                --this.leashHolderTime;
            }
            this.setLeashHolder(this.leashHolderTime > 0);
            if (this.serverStillTimeout > 0) {
                if (this.age > 60) {
                    --this.serverStillTimeout;
                }
                this.setServerStillTimeout(this.serverStillTimeout);
            }
            if (this.scanPlayerAboveGhast()) {
                this.setServerStillTimeout(10);
            }
        }
    }

    public void tickMovement() {
        if (!this.getWorld().isClient) {
            this.setRequiresPrecisePosition(this.isOnStillTimeout());
        }
        super.tickMovement();
        this.continuousHeal();
    }

    private int getHappyGhastRestrictionRadius() {
        return !this.isBaby() && !this.isHarnessed() ? 64 : 32;
    }

    private void checkRestriction() {
        if (!this.isLeashed() && !this.hasPassengers()) {
            int radius = this.getHappyGhastRestrictionRadius();
            if (!this.hasPositionTarget() || !this.getPositionTarget().isWithinDistance((Vec3i)this.getBlockPos(), (double)(radius + 16)) || (float)radius != this.getPositionTargetRange()) {
                this.setPositionTarget(this.getBlockPos(), radius);
            }
        }
    }

    private void continuousHeal() {
        World class_19372 = this.getWorld();
        if (class_19372 instanceof ServerWorld) {
            boolean isFastHealing;
            ServerWorld server = (ServerWorld)class_19372;
            if (this.isAlive() && this.deathTime == 0 && this.getMaxHealth() != this.getHealth() && this.age % ((isFastHealing = server.getDimension().natural() && (this.isInClouds() || this.precipitationAt(this.getBlockPos()) != Biome.Precipitation.NONE)) ? 20 : 600) == 0) {
                this.heal(1.0f);
            }
        }
    }

    private Biome.Precipitation precipitationAt(BlockPos pos) {
        if (!this.getWorld().isRaining()) {
            return Biome.Precipitation.NONE;
        }
        if (!this.getWorld().isSkyVisible(pos)) {
            return Biome.Precipitation.NONE;
        }
        if (this.getWorld().getTopPosition(Heightmap.Type.MOTION_BLOCKING, pos).getY() > pos.getY()) {
            return Biome.Precipitation.NONE;
        }
        Biome biome = (Biome)this.getWorld().getBiome(pos).value();
        return biome.getPrecipitation(pos);
    }

    private boolean isInClouds() {
        if (this.getWorld().getDimension().natural()) {
            int cloudHeight = 192;
            if (this.getY() + (double)this.getHeight() < (double)cloudHeight) {
                return false;
            }
            int cloudRange = cloudHeight + 4;
            return this.getY() <= (double)cloudRange;
        }
        return false;
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(IS_LEASH_HOLDER, false);
        builder.add(STAYS_STILL, false);
    }

    private void setLeashHolder(boolean holder) {
        this.dataTracker.set(IS_LEASH_HOLDER, holder);
    }

    public boolean isLeashHolder() {
        return (Boolean)this.dataTracker.get(IS_LEASH_HOLDER);
    }

    private void syncStayStillFlag() {
        this.dataTracker.set(STAYS_STILL, (this.serverStillTimeout > 0));
    }

    public boolean staysStill() {
        return (Boolean)this.dataTracker.get(STAYS_STILL);
    }

    @Override
    public boolean vb$supportQuadLeashAsHolder() {
        return true;
    }

    @Override
    public Vec3d[] vb$getQuadLeashHolderOffsets() {
        return LeashExtension.vb$createQuadLeashOffsets((Entity)this, -0.03125, 0.4375, 0.46875, 0.03125);
    }

    protected Vec3d getLeashOffset() {
        return Vec3d.ZERO;
    }

    @Override
    public double vb$leashElasticDistance() {
        return 10.0;
    }

    @Override
    public double vb$leashSnapDistance() {
        return 16.0;
    }

    @Override
    public void vb$onElasticLeashPull() {
        LeashExtension.super.vb$onElasticLeashPull();
        this.getMoveControl().state = MoveControl.State.WAIT;
    }

    @Override
    public void vb$notifyLeashHolder(Leashable leashable) {
        if (((LeashExtension)leashable).vb$supportQuadLeash()) {
            this.leashHolderTime = 5;
        }
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putInt("still_timeout", this.serverStillTimeout);
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.setServerStillTimeout(compound.getInt("still_timeout"));
    }

    public boolean isOnStillTimeout() {
        return this.staysStill() || this.serverStillTimeout > 0;
    }

    private boolean scanPlayerAboveGhast() {
        Box bb = this.getBoundingBox();
        Box ghastDetectionBox = new Box(bb.minX - 1.0, bb.maxY - (double)1.0E-5f, bb.minZ - 1.0, bb.maxX + 1.0, bb.maxY + bb.getLengthY() / 2.0, bb.maxZ + 1.0);
        for (PlayerEntity player : this.getWorld().getPlayers()) {
            Entity rootVehicle;
            if (player.isSpectator() || (rootVehicle = player.getRootVehicle()) instanceof HappyGhast || !ghastDetectionBox.contains(rootVehicle.getPos())) continue;
            return true;
        }
        return false;
    }

    protected BodyControl createBodyControl() {
        return new GhastBodyRotationControl(this);
    }

    public boolean isCollidable() {
        if (!this.isBaby() && this.isAlive()) {
            return this.hasPassengers() || this.isOnStillTimeout();
        }
        return false;
    }

    static class GhastMoveControl
    extends MoveControl {
        private final HappyGhast ghast;
        private int floatDuration;
        private final boolean careful;
        private final BooleanSupplier shouldBeStopped;

        public GhastMoveControl(HappyGhast ghast, boolean careful, BooleanSupplier shouldBeStopped) {
            super((MobEntity)ghast);
            this.ghast = ghast;
            this.careful = careful;
            this.shouldBeStopped = shouldBeStopped;
        }

        public void tick() {
            if (this.shouldBeStopped.getAsBoolean()) {
                this.state = MoveControl.State.WAIT;
                this.ghast.stopMovement();
            }
            if (this.state == MoveControl.State.MOVE_TO && this.floatDuration-- <= 0) {
                this.floatDuration += this.ghast.getRandom().nextInt(5) + 2;
                Vec3d target = new Vec3d(this.targetX - this.ghast.getX(), this.targetY - this.ghast.getY(), this.targetZ - this.ghast.getZ());
                if (this.canReach(target)) {
                    this.ghast.setVelocity(this.ghast.getVelocity().add(target.normalize().multiply(this.ghast.getAttributeValue(EntityAttributes.GENERIC_FLYING_SPEED) * 5.0 / 3.0)));
                } else {
                    this.state = MoveControl.State.WAIT;
                }
            }
        }

        private boolean canReach(Vec3d target) {
            Box entityBox = this.ghast.getBoundingBox();
            Box targetBox = entityBox.offset(target);
            if (this.careful) {
                for (BlockPos position : BlockPosUtils.betweenClosed(targetBox.expand(1.0))) {
                    if (this.blockTraversalPossible((BlockView)this.ghast.getWorld(), null, null, position, false, false)) continue;
                    return false;
                }
            }
            boolean inWater = this.ghast.isTouchingWater();
            boolean inLava = this.ghast.isInLava();
            Vec3d currentPos = this.ghast.getPos();
            Vec3d targetPos = currentPos.add(target);
            return BlockPosUtils.forEachBlockIntersectedBetween(currentPos, targetPos, targetBox, (pos, step) -> CollisionUtils.intersects(entityBox, pos) || this.blockTraversalPossible((BlockView)this.ghast.getWorld(), currentPos, targetPos, pos, inWater, inLava));
        }

        private boolean blockTraversalPossible(BlockView level, @Nullable Vec3d origin, @Nullable Vec3d target, BlockPos pos, boolean inWater, boolean inLava) {
            boolean hasValidPath;
            BlockState state = level.getBlockState(pos);
            if (state.isAir()) {
                return true;
            }
            boolean bl = hasValidPath = origin != null && target != null;
            boolean noCollisionDetected = hasValidPath ? !CollisionUtils.collidedWithShapeMovingFrom((LivingEntity)this.ghast, origin, target, state.getCollisionShape(level, pos).offset((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()).getBoundingBoxes()) : state.getCollisionShape(level, pos).isEmpty();
            if (!this.careful) {
                return noCollisionDetected;
            }
            if (state.isIn(ModBlockTags.HAPPY_GHAST_AVOIDS)) {
                return false;
            }
            FluidState fluidState = level.getFluidState(pos);
            if (!(fluidState.isEmpty() || hasValidPath && !CollisionUtils.collidedWithFluid((LivingEntity)this.ghast, fluidState, pos, origin, target))) {
                if (fluidState.isIn(FluidTags.WATER)) {
                    return inWater;
                }
                if (fluidState.isIn(FluidTags.LAVA)) {
                    return inLava;
                }
            }
            return noCollisionDetected;
        }
    }

    class HappyGhastLookControl
    extends LookControl {
        HappyGhastLookControl() {
            super((MobEntity)HappyGhast.this);
        }

        public void tick() {
            if (HappyGhast.this.isOnStillTimeout()) {
                float closeAngle = HappyGhastLookControl.wrapDegrees90(HappyGhast.this.getYaw());
                HappyGhast.this.setYaw(HappyGhast.this.getYaw() - closeAngle);
                HappyGhast.this.setHeadYaw(HappyGhast.this.getYaw());
            } else if (this.lookAtTimer > 0) {
                --this.lookAtTimer;
                double x = this.x - HappyGhast.this.getX();
                double z = this.z - HappyGhast.this.getZ();
                HappyGhast.this.setYaw(-((float)MathHelper.atan2((double)x, (double)z)) * 57.295776f);
                HappyGhast.this.headYaw = HappyGhast.this.bodyYaw = HappyGhast.this.getYaw();
            } else {
                if (HappyGhast.this.hasPassengers() && HappyGhast.this.getControllingPassenger() instanceof PlayerEntity) {
                    return;
                }
                Vec3d movement = this.entity.getVelocity();
                this.entity.setYaw(-((float)MathHelper.atan2((double)movement.x, (double)movement.z)) * 57.295776f);
                this.entity.bodyYaw = this.entity.getYaw();
            }
        }

        public static float wrapDegrees90(float degrees) {
            float result = degrees % 90.0f;
            if (result >= 45.0f) {
                result -= 90.0f;
            }
            if (result < -45.0f) {
                result += 90.0f;
            }
            return result;
        }
    }

    static class BabyFlyingPathNavigation
    extends BirdNavigation {
        public BabyFlyingPathNavigation(MobEntity mob, World level) {
            super(mob, level);
            this.setCanPathThroughDoors(false);
            this.setCanSwim(true);
        }

        protected boolean canPathDirectlyThrough(Vec3d posVec31, Vec3d posVec32) {
            return BabyFlyingPathNavigation.doesNotCollide((MobEntity)this.entity, (Vec3d)posVec31, (Vec3d)posVec32, (boolean)false);
        }
    }

    static class GhastFloatGoal
    extends SwimGoal {
        private final HappyGhast ghast;

        public GhastFloatGoal(HappyGhast ghast) {
            super((MobEntity)ghast);
            this.ghast = ghast;
        }

        public boolean canStart() {
            return !this.ghast.isOnStillTimeout() && super.canStart();
        }
    }

    static class RandomFloatAroundGoal
    extends Goal {
        private final HappyGhast ghast;
        private final int distanceToBlocks;

        public RandomFloatAroundGoal(HappyGhast ghast, int distanceToBlocks) {
            this.ghast = ghast;
            this.distanceToBlocks = distanceToBlocks;
            this.setControls(EnumSet.of(Goal.Control.MOVE));
        }

        public boolean canStart() {
            double z;
            double y;
            MoveControl control = this.ghast.getMoveControl();
            if (!control.isMoving()) {
                return true;
            }
            double x = control.getTargetX() - this.ghast.getX();
            double distance = x * x + (y = control.getTargetY() - this.ghast.getY()) * y + (z = control.getTargetZ() - this.ghast.getZ()) * z;
            return distance < 1.0 || distance > 3600.0;
        }

        public boolean shouldContinue() {
            return false;
        }

        public void start() {
            Vec3d target = RandomFloatAroundGoal.getSuitableFlyToPosition((MobEntity)this.ghast, this.distanceToBlocks);
            this.ghast.getMoveControl().moveTo(target.getX(), target.getY(), target.getZ(), 1.0);
        }

        public static Vec3d getSuitableFlyToPosition(MobEntity mob, int distanceToBlocks) {
            BlockPos pos;
            int floor;
            World level = mob.getWorld();
            Random random = mob.getRandom();
            Vec3d origin = mob.getPos();
            Vec3d target = null;
            for (int attempt = 0; attempt < 64; ++attempt) {
                target = RandomFloatAroundGoal.chooseRandomPositionWithRestriction(mob, origin, random);
                if (target == null || !RandomFloatAroundGoal.isGoodTarget(level, target, distanceToBlocks)) continue;
                return target;
            }
            if (target == null) {
                target = RandomFloatAroundGoal.chooseRandomPosition(origin, random);
            }
            if ((floor = level.getTopY(Heightmap.Type.MOTION_BLOCKING, (pos = BlockPos.ofFloored(target)).getX(), pos.getZ())) < pos.getY() && floor > level.getBottomY()) {
                target = new Vec3d(target.getX(), mob.getY() - Math.abs(mob.getY() - target.getY()), target.getZ());
            }
            return target;
        }

        private static boolean isGoodTarget(World level, Vec3d target, int distanceToBlocks) {
            if (distanceToBlocks <= 0) {
                return true;
            }
            BlockPos pos = BlockPos.ofFloored((Position)target);
            if (level.getBlockState(pos).isAir()) {
                for (Direction direction : Direction.values()) {
                    for (int distance = 1; distance < distanceToBlocks; ++distance) {
                        BlockPos neighbor = pos.offset(direction, distance);
                        if (level.getBlockState(neighbor).isAir()) continue;
                        return true;
                    }
                }
            }
            return false;
        }

        private static Vec3d chooseRandomPosition(Vec3d origin, Random random) {
            double x = origin.getX() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double y = origin.getY() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            double z = origin.getZ() + (double)((random.nextFloat() * 2.0f - 1.0f) * 16.0f);
            return new Vec3d(x, y, z);
        }

        @Nullable
        private static Vec3d chooseRandomPositionWithRestriction(MobEntity mob, Vec3d origin, Random random) {
            Vec3d target = RandomFloatAroundGoal.chooseRandomPosition(origin, random);
            return mob.hasPositionTarget() && !mob.isInWalkTargetRange(BlockPos.ofFloored((Position)target)) ? null : target;
        }
    }

    static class GhastBodyRotationControl
    extends BodyControl {
        private final HappyGhast ghast;

        public GhastBodyRotationControl(HappyGhast ghast) {
            super((MobEntity)ghast);
            this.ghast = ghast;
        }

        public void tick() {
            if (this.ghast.hasPassengers()) {
                this.ghast.bodyYaw = this.ghast.headYaw = this.ghast.getYaw();
            }
            super.tick();
        }
    }
}

