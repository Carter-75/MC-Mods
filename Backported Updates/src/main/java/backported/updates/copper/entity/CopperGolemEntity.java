/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Dynamic
 *  net.minecraft.world.LocalDifficulty
 *  net.minecraft.util.Hand
 *  net.minecraft.util.ActionResult
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityType
 *  net.minecraft.entity.EquipmentSlot
 *  net.minecraft.entity.mob.MobEntity
 *  net.minecraft.entity.LivingEntity
 *  net.minecraft.entity.EntityData
 *  net.minecraft.entity.ai.pathing.EntityNavigation
 *  net.minecraft.entity.passive.GolemEntity
 *  net.minecraft.entity.LightningEntity
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.Items
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.ChestBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.enums.ChestType
 *  net.minecraft.Property
 *  net.minecraft.entity.data.TrackedData
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.entity.data.TrackedDataHandlerRegistry
 *  net.minecraft.entity.data.DataTracker
 *  net.minecraft.entity.data.DataTracker$Builder
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.registry.tag.ItemTags
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.entity.ai.brain.Brain
 *  net.minecraft.entity.ai.brain.Brain$Profile
 *  net.minecraft.entity.ai.brain.task.LookTargetUtil
 *  net.minecraft.entity.attribute.DefaultAttributeContainer$Builder
 *  net.minecraft.entity.attribute.EntityAttributes
 *  net.minecraft.entity.Shearable
 *  net.minecraft.world.ServerWorldAccess
 *  net.minecraft.block.entity.ViewerCountManager
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.entity.ai.pathing.PathNodeType
 *  net.minecraft.entity.AnimationState
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.entity;

import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.ModSounds;
import backported.updates.copper.block.CopperGolemStatueBlock;
import backported.updates.copper.block.entity.CopperGolemStatueBlockEntity;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.entity.ContainerUser;
import backported.updates.copper.entity.CopperGolemOxidationLevels;
import backported.updates.copper.entity.CopperGolemState;
import backported.updates.copper.entity.ai.CopperGolemAi;
import backported.updates.copper.entity.ai.navigation.CopperGolemNavigation;
import backported.updates.copper.registry.ModBlocks;
import com.mojang.serialization.Dynamic;
import java.util.UUID;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.ChestType;
import net.minecraft.state.property.Property;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.Shearable;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.world.event.GameEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Oxidizable;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.AnimationState;
import org.jetbrains.annotations.Nullable;

public class CopperGolemEntity
extends GolemEntity
implements Shearable,
ContainerUser {
    private static final long IGNORE_WEATHERING_TICK = -2L;
    private static final long UNSET_WEATHERING_TICK = -1L;
    private static final int SPIN_ANIMATION_MIN_COOLDOWN = 200;
    private static final int SPIN_ANIMATION_MAX_COOLDOWN = 240;
    private static final float TURN_TO_STATUE_CHANCE = 0.0058f;
    private static final double CONTAINER_INTERACTION_RANGE = 3.0;
    public static final EquipmentSlot EQUIPMENT_SLOT_ANTENNA = EquipmentSlot.HEAD;
    private static final TrackedData<Integer> DATA_WEATHER_STATE = DataTracker.registerData(CopperGolemEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.INTEGER);
    private static final TrackedData<Integer> COPPER_GOLEM_STATE = DataTracker.registerData(CopperGolemEntity.class, (TrackedDataHandler)TrackedDataHandlerRegistry.INTEGER);
    private long nextWeatheringTick = -1L;
    @Nullable
    private BlockPos openedChestPos;
    @Nullable
    private UUID lastLightningBoltUUID;
    private int idleAnimationStartTick = 0;
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState interactionGetItemAnimationState = new AnimationState();
    public final AnimationState interactionGetNoItemAnimationState = new AnimationState();
    public final AnimationState interactionDropItemAnimationState = new AnimationState();
    public final AnimationState interactionDropNoItemAnimationState = new AnimationState();
    public final AnimationState pressingButtonAnimationState = new AnimationState();

    private static Oxidizable.OxidationLevel getNextWeatherState(Oxidizable.OxidationLevel current) {
        return switch (current) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Oxidizable.OxidationLevel.EXPOSED;
            case Oxidizable.OxidationLevel.EXPOSED -> Oxidizable.OxidationLevel.WEATHERED;
            case Oxidizable.OxidationLevel.WEATHERED -> Oxidizable.OxidationLevel.OXIDIZED;
            case Oxidizable.OxidationLevel.OXIDIZED -> Oxidizable.OxidationLevel.OXIDIZED;
        };
    }

    private static Oxidizable.OxidationLevel getPreviousWeatherState(Oxidizable.OxidationLevel current) {
        return switch (current) {
            default -> throw new MatchException(null, null);
            case Oxidizable.OxidationLevel.UNAFFECTED -> Oxidizable.OxidationLevel.UNAFFECTED;
            case Oxidizable.OxidationLevel.EXPOSED -> Oxidizable.OxidationLevel.UNAFFECTED;
            case Oxidizable.OxidationLevel.WEATHERED -> Oxidizable.OxidationLevel.EXPOSED;
            case Oxidizable.OxidationLevel.OXIDIZED -> Oxidizable.OxidationLevel.WEATHERED;
        };
    }

    public CopperGolemEntity(EntityType<? extends GolemEntity> entityType, World level) {
        super(entityType, level);
        this.getNavigation().setRangeMultiplier(3.0f);
        this.setPersistent();
        this.setState(CopperGolemState.IDLE);
        this.setCanPickUpLoot(true);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 16.0f);
        this.setPathfindingPenalty(PathNodeType.DANGER_OTHER, 16.0f);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, -1.0f);
        this.getBrain().remember(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), this.getRandom().nextBetweenExclusive(60, 100));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 12.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double)0.2f).add(EntityAttributes.GENERIC_STEP_HEIGHT, 1.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0);
    }

    protected Brain.Profile<CopperGolemEntity> createBrainProfile() {
        return CopperGolemAi.brainProvider();
    }

    protected Brain<?> deserializeBrain(Dynamic<?> dynamic) {
        return CopperGolemAi.makeBrain((Brain<CopperGolemEntity>)this.createBrainProfile().deserialize(dynamic));
    }

    @SuppressWarnings("unchecked")
    public Brain<CopperGolemEntity> getBrain() {
        return (Brain<CopperGolemEntity>) super.getBrain();
    }

    protected EntityNavigation createNavigation(World level) {
        CopperGolemNavigation navigation = new CopperGolemNavigation((MobEntity)this, level);
        navigation.setCanPathThroughDoors(true);
        navigation.setCanEnterOpenDoors(true);
        navigation.setRequiredPathLength(48.0f);
        return navigation;
    }

    public boolean canGather(ItemStack stack) {
        return false;
    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(DATA_WEATHER_STATE, Oxidizable.OxidationLevel.UNAFFECTED.ordinal());
        builder.add(COPPER_GOLEM_STATE, CopperGolemState.IDLE.ordinal());
    }

    public CopperGolemState getState() {
        int stateId = (Integer)this.dataTracker.get(COPPER_GOLEM_STATE);
        CopperGolemState[] states = CopperGolemState.values();
        return stateId >= 0 && stateId < states.length ? states[stateId] : CopperGolemState.IDLE;
    }

    public void setState(CopperGolemState state) {
        this.dataTracker.set(COPPER_GOLEM_STATE, state.ordinal());
    }

    public Oxidizable.OxidationLevel getWeatherState() {
        int weatherId = (Integer)this.dataTracker.get(DATA_WEATHER_STATE);
        Oxidizable.OxidationLevel[] states = Oxidizable.OxidationLevel.values();
        return weatherId >= 0 && weatherId < states.length ? states[weatherId] : Oxidizable.OxidationLevel.UNAFFECTED;
    }

    public void setWeatherState(Oxidizable.OxidationLevel weatherState) {
        this.dataTracker.set(DATA_WEATHER_STATE, weatherState.ordinal());
    }

    public void setOpenedChestPos(BlockPos openedChestPos) {
        this.openedChestPos = openedChestPos;
    }

    public void clearOpenedChestPos() {
        this.openedChestPos = null;
    }

    @Override
    public boolean hasContainerOpen(ViewerCountManager openCounter, BlockPos pos) {
        if (this.openedChestPos == null) {
            return false;
        }
        if (this.openedChestPos.equals(pos)) {
            return true;
        }
        BlockState blockstate = this.getWorld().getBlockState(this.openedChestPos);
        if (blockstate.getBlock() instanceof ChestBlock && blockstate.get(ChestBlock.CHEST_TYPE) != ChestType.SINGLE) {
            Direction connectedDirection = ChestBlock.getFacing(blockstate);
            return this.openedChestPos.offset(connectedDirection).equals(pos);
        }
        return false;
    }

    @Override
    public double getContainerInteractionRange() {
        return 3.0;
    }

    protected void mobTick() {
        this.getWorld().getProfiler().push("copperGolemBrain");
        this.getBrain().tick((ServerWorld)this.getWorld(), this);
        this.getWorld().getProfiler().pop();
        this.getWorld().getProfiler().push("copperGolemActivityUpdate");
        CopperGolemAi.updateActivity(this);
        this.getWorld().getProfiler().pop();
        super.mobTick();
    }

    public void writeCustomDataToNbt(NbtCompound compound) {
        super.writeCustomDataToNbt(compound);
        compound.putLong("next_weather_age", this.nextWeatheringTick);
        compound.putInt("weather_state", this.getWeatherState().ordinal());
    }

    public void readCustomDataFromNbt(NbtCompound compound) {
        super.readCustomDataFromNbt(compound);
        this.nextWeatheringTick = compound.getLong("next_weather_age");
        if (compound.contains("weather_state")) {
            int weatherId = compound.getInt("weather_state");
            Oxidizable.OxidationLevel[] states = Oxidizable.OxidationLevel.values();
            if (weatherId >= 0 && weatherId < states.length) {
                this.setWeatherState(states[weatherId]);
            }
        }
    }

    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            if (!this.isAiDisabled()) {
                this.setupAnimationStates();
            }
        } else {
            this.updateWeathering((ServerWorld)this.getWorld(), this.getWorld().getRandom(), this.getWorld().getTime());
        }
    }

    private void updateWeathering(ServerWorld level, Random random, long dayTime) {
        if (this.nextWeatheringTick != -2L) {
            if (this.nextWeatheringTick == -1L) {
                this.nextWeatheringTick = dayTime + (long)random.nextBetween(CommonConfig.weatheringTickFrom(), CommonConfig.weatheringTickTo());
            } else {
                boolean isOxidized;
                Oxidizable.OxidationLevel weatherState = this.getWeatherState();
                boolean bl = isOxidized = weatherState == Oxidizable.OxidationLevel.OXIDIZED;
                if (dayTime >= this.nextWeatheringTick && !isOxidized) {
                    Oxidizable.OxidationLevel nextState = CopperGolemEntity.getNextWeatherState(weatherState);
                    boolean willBeOxidized = nextState == Oxidizable.OxidationLevel.OXIDIZED;
                    this.setWeatherState(nextState);
                    long l = this.nextWeatheringTick = willBeOxidized ? 0L : this.nextWeatheringTick + (long)random.nextBetween(CommonConfig.weatheringTickFrom(), CommonConfig.weatheringTickTo());
                }
                if (isOxidized && this.canTurnToStatue((World)level)) {
                    this.turnToStatue(level);
                }
            }
        }
    }

    private boolean canTurnToStatue(World level) {
        return level.getBlockState(this.getBlockPos()).isOf(Blocks.AIR) && level.random.nextFloat() <= 0.0058f;
    }

    private void turnToStatue(ServerWorld level) {
        BlockPos blockPos = this.getBlockPos();
        CopperGolemStatueBlock.Pose randomPose = CopperGolemStatueBlock.Pose.values()[this.random.nextBetweenExclusive(0, CopperGolemStatueBlock.Pose.values().length)];
        level.setBlockState(blockPos, (ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get().getDefaultState().with(CopperGolemStatueBlock.POSE, (randomPose))).with(CopperGolemStatueBlock.FACING, Direction.fromRotation((double)this.getYaw())), 3);
        BlockEntity class_25862 = level.getBlockEntity(blockPos);
        if (class_25862 instanceof CopperGolemStatueBlockEntity) {
            CopperGolemStatueBlockEntity statueEntity = (CopperGolemStatueBlockEntity)class_25862;
            statueEntity.createStatue(this);
            this.dropAllEquipment();
            this.discard();
            this.playSoundIfNotSilent(ModSounds.COPPER_GOLEM_BECOME_STATUE.get());
            if (this.isLeashed()) {
                if (level.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                    this.detachLeash(true, true);
                } else {
                    this.detachLeash(true, false);
                }
            }
        }
    }

    private void setupAnimationStates() {
        switch (this.getState()) {
            case IDLE: {
                this.interactionGetNoItemAnimationState.stop();
                this.interactionGetItemAnimationState.stop();
                this.interactionDropItemAnimationState.stop();
                this.interactionDropNoItemAnimationState.stop();
                this.pressingButtonAnimationState.stop();
                if (this.idleAnimationStartTick == this.age) {
                    this.idleAnimationState.start(this.age);
                } else if (this.idleAnimationStartTick == 0) {
                    this.idleAnimationStartTick = this.age + this.random.nextBetweenExclusive(200, 240);
                }
                if (this.age != this.idleAnimationStartTick + 10) break;
                this.playHeadSpinSound();
                this.idleAnimationStartTick = 0;
                break;
            }
            case GETTING_ITEM: {
                this.idleAnimationState.stop();
                this.idleAnimationStartTick = 0;
                this.interactionGetNoItemAnimationState.stop();
                this.interactionDropItemAnimationState.stop();
                this.interactionDropNoItemAnimationState.stop();
                this.pressingButtonAnimationState.stop();
                this.interactionGetItemAnimationState.startIfNotRunning(this.age);
                break;
            }
            case GETTING_NO_ITEM: {
                this.idleAnimationState.stop();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.stop();
                this.interactionDropNoItemAnimationState.stop();
                this.interactionDropItemAnimationState.stop();
                this.pressingButtonAnimationState.stop();
                this.interactionGetNoItemAnimationState.startIfNotRunning(this.age);
                break;
            }
            case DROPPING_ITEM: {
                this.idleAnimationState.stop();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.stop();
                this.interactionGetNoItemAnimationState.stop();
                this.interactionDropNoItemAnimationState.stop();
                this.pressingButtonAnimationState.stop();
                this.interactionDropItemAnimationState.startIfNotRunning(this.age);
                break;
            }
            case DROPPING_NO_ITEM: {
                this.idleAnimationState.stop();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.stop();
                this.interactionGetNoItemAnimationState.stop();
                this.interactionDropItemAnimationState.stop();
                this.pressingButtonAnimationState.stop();
                this.interactionDropNoItemAnimationState.startIfNotRunning(this.age);
                break;
            }
            case PRESSING_BUTTON: {
                this.idleAnimationState.stop();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.stop();
                this.interactionGetNoItemAnimationState.stop();
                this.interactionDropItemAnimationState.stop();
                this.interactionDropNoItemAnimationState.stop();
                this.pressingButtonAnimationState.startIfNotRunning(this.age);
            }
        }
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getStackInHand(hand);
        World level = this.getWorld();
        if (itemstack.isEmpty() && !this.getMainHandStack().isEmpty()) {
            if (!level.isClient()) {
                ItemStack heldItem = this.getMainHandStack();
                LookTargetUtil.give((LivingEntity)this, (ItemStack)heldItem, (Vec3d)player.getPos());
                this.setStackInHand(Hand.MAIN_HAND, ItemStack.EMPTY);
            }
            return ActionResult.SUCCESS;
        }
        if (itemstack.isOf(Items.SHEARS) && this.isShearable()) {
            if (level instanceof ServerWorld) {
                ServerWorld serverLevel = (ServerWorld)level;
                this.sheared(SoundCategory.PLAYERS);
                this.emitGameEvent((RegistryEntry)GameEvent.SHEAR, (Entity)player);
                itemstack.damage(1, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
            }
            return ActionResult.success((boolean)level.isClient());
        }
        if (itemstack.isOf(Items.HONEYCOMB) && this.nextWeatheringTick != -2L) {
            if (!level.isClient()) {
                level.syncWorldEvent(null, 3003, this.getBlockPos(), 0);
                this.nextWeatheringTick = -2L;
                itemstack.decrementUnlessCreative(1, (LivingEntity)player);
            }
            return ActionResult.success((boolean)level.isClient());
        }
        if (itemstack.isIn(ItemTags.AXES)) {
            if (!level.isClient()) {
                Oxidizable.OxidationLevel weatherState = this.getWeatherState();
                if (this.nextWeatheringTick == -2L) {
                    level.playSoundFromEntity(null, (Entity)this, SoundEvents.ITEM_AXE_SCRAPE, this.getSoundCategory(), 1.0f, 1.0f);
                    level.syncWorldEvent(null, 3004, this.getBlockPos(), 0);
                    this.nextWeatheringTick = -1L;
                    itemstack.damage(1, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
                    return ActionResult.SUCCESS;
                }
                if (weatherState != Oxidizable.OxidationLevel.UNAFFECTED) {
                    level.playSoundFromEntity(null, (Entity)this, SoundEvents.ITEM_AXE_SCRAPE, this.getSoundCategory(), 1.0f, 1.0f);
                    level.syncWorldEvent(null, 3005, this.getBlockPos(), 0);
                    this.nextWeatheringTick = -1L;
                    this.setWeatherState(CopperGolemEntity.getPreviousWeatherState(weatherState));
                    itemstack.damage(1, (LivingEntity)player, LivingEntity.getSlotForHand((Hand)hand));
                    return ActionResult.SUCCESS;
                }
            }
            return ActionResult.success((boolean)level.isClient());
        }
        return super.interactMob(player, hand);
    }

    private void playHeadSpinSound() {
        if (!this.isSilent()) {
            this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), this.getSpinHeadSound(), this.getSoundCategory(), 1.0f, 1.0f, false);
        }
    }

    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).hurtSound();
    }

    protected SoundEvent getDeathSound() {
        return CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).deathSound();
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).stepSound(), 1.0f, 1.0f);
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float calculateNextStepSoundDistance() {
        return this.distanceTraveled + 0.6f;
    }

    private SoundEvent getSpinHeadSound() {
        return CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).spinHeadSound();
    }

    public Vec3d getLeashOffset() {
        return new Vec3d(0.0, 0.75 * (double)this.getStandingEyeHeight(), 0.0);
    }

    public void sheared(SoundCategory source) {
        this.getWorld().playSoundFromEntity(null, (Entity)this, ModSounds.COPPER_GOLEM_SHEAR.get(), source, 1.0f, 1.0f);
        ItemStack antennaItem = this.getEquippedStack(EQUIPMENT_SLOT_ANTENNA);
        if (!antennaItem.isEmpty()) {
            this.equipStack(EQUIPMENT_SLOT_ANTENNA, ItemStack.EMPTY);
            this.dropStack(antennaItem, 1.5f);
        }
    }

    public boolean isShearable() {
        return this.isAlive() && this.getEquippedStack(EQUIPMENT_SLOT_ANTENNA).isOf(Items.POPPY);
    }

    public void spawn(Oxidizable.OxidationLevel weatherState) {
        this.setWeatherState(weatherState);
        this.playSpawnSound();
    }

    public void playSpawnSound() {
        this.playSoundIfNotSilent(ModSounds.COPPER_GOLEM_SPAWN.get());
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess level, LocalDifficulty difficulty, SpawnReason spawnType, @Nullable EntityData spawnData) {
        this.playSpawnSound();
        return super.initialize(level, difficulty, spawnType, spawnData);
    }

    public void onStruckByLightning(ServerWorld level, LightningEntity lightning) {
        super.onStruckByLightning(level, lightning);
        UUID uuid = lightning.getUuid();
        if (!uuid.equals(this.lastLightningBoltUUID)) {
            this.lastLightningBoltUUID = uuid;
            Oxidizable.OxidationLevel weatherState = this.getWeatherState();
            if (weatherState != Oxidizable.OxidationLevel.UNAFFECTED) {
                this.nextWeatheringTick = -1L;
                this.setWeatherState(CopperGolemEntity.getPreviousWeatherState(weatherState));
            }
        }
    }

    protected void applyDamage(DamageSource source, float amount) {
        super.applyDamage(source, amount);
        this.setState(CopperGolemState.IDLE);
    }

    protected void dropInventory() {
        super.dropInventory();
        this.dropAllEquipment();
    }
}

