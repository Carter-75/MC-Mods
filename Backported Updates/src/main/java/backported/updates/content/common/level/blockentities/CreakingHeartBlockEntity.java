/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Either
 *  net.minecraft.world.Difficulty
 *  net.minecraft.entity.damage.DamageSource
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.Util
 *  net.minecraft.entity.player.PlayerEntity
 *  net.minecraft.world.GameRules
 *  net.minecraft.world.World
 *  net.minecraft.block.Blocks
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Position
 *  net.minecraft.util.math.Box
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.nbt.NbtCompound
 *  net.minecraft.block.entity.BlockEntity
 *  net.minecraft.network.packet.Packet
 *  net.minecraft.network.listener.ClientPlayPacketListener
 *  net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket
 *  net.minecraft.block.BlockState
 *  net.minecraft.state.property.Properties
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.entity.SpawnReason
 *  net.minecraft.world.WorldView
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.world.event.GameEvent$Emitter
 *  net.minecraft.block.MultifaceGrowthBlock
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  org.apache.commons.lang3.mutable.Mutable
 *  org.apache.commons.lang3.mutable.MutableObject
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.blockentities;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.level.entities.creaking.Creaking;
import backported.updates.content.common.registries.ModBlockEntities;
import backported.updates.content.common.registries.ModBlocks;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.util.SpawnExtras;
import com.mojang.datafixers.util.Either;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.util.Util;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.block.Blocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.Vec3d;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.SpawnReason;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import net.minecraft.block.MultifaceGrowthBlock;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.RegistryWrapper;
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;

public class CreakingHeartBlockEntity
extends BlockEntity {
    private static final Optional<Creaking> NO_CREAKING = Optional.empty();
    @Nullable
    private Either<Creaking, UUID> creakingInfo;
    private long ticksExisted;
    private int ticker;
    private int emitter;
    @Nullable
    private Vec3d emitterTarget;
    private int outputSignal;

    public CreakingHeartBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CREAKING_HEART.get(), pos, state);
    }

    public static void serverTick(World level, BlockPos pos, BlockState state, CreakingHeartBlockEntity heart) {
        ++heart.ticksExisted;
        if (level instanceof ServerWorld) {
            ServerWorld server = (ServerWorld)level;
            int signal = heart.computeAnalogOutputSignal();
            if (heart.outputSignal != signal) {
                heart.outputSignal = signal;
                level.updateComparators(pos, ModBlocks.CREAKING_HEART.get());
            }
            if (heart.emitter > 0) {
                if (heart.emitter > 50) {
                    heart.emitParticles(server, 1, true);
                    heart.emitParticles(server, 1, false);
                }
                if (heart.emitter % 10 == 0 && heart.emitterTarget != null) {
                    heart.getCreakingProtector().ifPresent(creaking -> {
                        heart.emitterTarget = creaking.getBoundingBox().getCenter();
                    });
                    Vec3d center = Vec3d.ofCenter((Vec3i)pos);
                    float emission = 0.2f + 0.8f * (float)(100 - heart.emitter) / 100.0f;
                    Vec3d position = center.subtract(heart.emitterTarget).multiply((double)emission).add(heart.emitterTarget);
                    BlockPos target = BlockPos.ofFloored((Position)position);
                    float volume = (float)heart.emitter / 2.0f / 100.0f + 0.5f;
                    level.playSound(null, target, ModSoundEvents.CREAKING_HEART_HURT.get(), SoundCategory.BLOCKS, volume, 1.0f);
                }
                --heart.emitter;
            }
            if (heart.ticker-- < 0) {
                heart.ticker = heart.world == null ? 20 : heart.world.random.nextInt(5) + 20;
                BlockState updatedState = CreakingHeartBlockEntity.updateCreakingState(level, state, pos, heart);
                Creaking creaking = null;
                if (updatedState != state) {
                    level.setBlockState(pos, updatedState, 3);
                    if (updatedState.get(CreakingHeartBlock.STATE) == CreakingHeartState.UPROOTED) {
                        return;
                    }
                }
                if (heart.creakingInfo == null) {
                    PlayerEntity player;
                    if (updatedState.get(CreakingHeartBlock.STATE) == CreakingHeartState.AWAKE && level.getDifficulty() != Difficulty.PEACEFUL && level.getGameRules().getBoolean(GameRules.DO_MOB_SPAWNING) && (player = level.getClosestPlayer((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 32.0, false)) != null && (creaking = CreakingHeartBlockEntity.spawnProtector(server, heart)) != null) {
                        heart.setCreakingInfo(creaking);
                        creaking.playSoundIfNotSilent(ModSoundEvents.CREAKING_SPAWN.get());
                        level.playSound(null, heart.getPos(), ModSoundEvents.CREAKING_HEART_SPAWN.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
                    }
                } else {
                    Optional<Creaking> protector = heart.getCreakingProtector();
                    if (protector.isPresent()) {
                        creaking = protector.get();
                        if (!CreakingHeartBlock.isNaturalNight(level) && !creaking.isPersistent() || heart.distanceToCreaking() > 34.0 || creaking.playerIsStuckInYou()) {
                            heart.removeProtector(null);
                        }
                    }
                }
            }
        }
    }

    private static BlockState updateCreakingState(World level, BlockState state, BlockPos pos, CreakingHeartBlockEntity heart) {
        if (!CreakingHeartBlock.hasRequiredLogs(state, (WorldView)level, pos) && heart.creakingInfo == null) {
            return state.with(CreakingHeartBlock.STATE, (CreakingHeartState.UPROOTED));
        }
        boolean isNaturalNight = CreakingHeartBlock.isNaturalNight(level);
        return state.with(CreakingHeartBlock.STATE, ((isNaturalNight ? CreakingHeartState.AWAKE : CreakingHeartState.DORMANT)));
    }

    private double distanceToCreaking() {
        return this.getCreakingProtector().map(creaking -> Math.sqrt(creaking.squaredDistanceTo(Vec3d.ofBottomCenter((Vec3i)this.getPos())))).orElse(0.0);
    }

    private void clearCreakingInfo() {
        this.creakingInfo = null;
        this.markDirty();
    }

    public void setCreakingInfo(Creaking creaking) {
        this.creakingInfo = Either.left((creaking));
        this.markDirty();
    }

    public void setCreakingInfo(UUID uuid) {
        this.creakingInfo = Either.right(uuid);
        this.ticksExisted = 0L;
        this.markDirty();
    }

    private Optional<Creaking> getCreakingProtector() {
        World class_19372;
        if (this.creakingInfo == null) {
            return NO_CREAKING;
        }
        if (this.creakingInfo.left().isPresent()) {
            Creaking creaking = (Creaking)(this.creakingInfo.left().get());
            if (!creaking.isRemoved()) {
                return Optional.of(creaking);
            }
            this.setCreakingInfo(creaking.getUuid());
        }
        if ((class_19372 = this.world) instanceof ServerWorld) {
            ServerWorld server = (ServerWorld)class_19372;
            if (this.creakingInfo.right().isPresent()) {
                UUID uuid = (UUID)this.creakingInfo.right().get();
                Entity class_12972 = server.getEntity(uuid);
                if (class_12972 instanceof Creaking) {
                    Creaking creaking = (Creaking)class_12972;
                    this.setCreakingInfo(creaking);
                    return Optional.of(creaking);
                }
                if (this.ticksExisted >= 30L) {
                    this.clearCreakingInfo();
                }
                return NO_CREAKING;
            }
        }
        return NO_CREAKING;
    }

    @Nullable
    private static Creaking spawnProtector(ServerWorld level, CreakingHeartBlockEntity heart) {
        if (!VanillaBackport.COMMON_CONFIG.hasCreaking.get().booleanValue()) {
            return null;
        }
        BlockPos pos = heart.getPos();
        Optional<Creaking> protector = SpawnExtras.trySpawnMob(ModEntities.CREAKING.get(), SpawnReason.SPAWNER, level, pos, 5, 16, 8, SpawnExtras.ON_TOP_OF_COLLIDER_NO_LEAVES, true);
        if (protector.isEmpty()) {
            return null;
        }
        Creaking creaking = protector.get();
        level.emitGameEvent((Entity)creaking, (RegistryEntry)GameEvent.ENTITY_PLACE, creaking.getPos());
        level.sendEntityStatus((Entity)creaking, (byte)60);
        creaking.setTransient(pos);
        return creaking;
    }

    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create((BlockEntity)this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup provider) {
        return this.createComponentlessNbt(provider);
    }

    public void creakingHurt() {
        World class_19372;
        Creaking creaking = this.getCreakingProtector().orElse(null);
        if (creaking != null && (class_19372 = this.world) instanceof ServerWorld) {
            ServerWorld server = (ServerWorld)class_19372;
            if (this.emitter <= 0) {
                this.emitParticles(server, 20, false);
                if (this.getCachedState().get(CreakingHeartBlock.STATE) == CreakingHeartState.AWAKE && VanillaBackport.COMMON_CONFIG.hasResin.get().booleanValue()) {
                    int i = this.world.getRandom().nextBetween(2, 3);
                    for (int j = 0; j < i; ++j) {
                        this.spreadResin().ifPresent(pos -> {
                            this.world.playSound(null, pos, ModSoundEvents.RESIN_PLACE.get(), SoundCategory.BLOCKS, 1.0f, 1.0f);
                            this.world.emitGameEvent((RegistryEntry)GameEvent.BLOCK_PLACE, pos, GameEvent.Emitter.of(this.getCachedState()));
                        });
                    }
                }
                this.emitter = 100;
                this.emitterTarget = creaking.getBoundingBox().getCenter();
            }
        }
    }

    private Optional<BlockPos> spreadResin() {
        if (this.world == null) {
            return Optional.empty();
        }
        MutableObject mutable = new MutableObject(null);
        BlockPos.iterateRecursively((BlockPos)this.pos, (int)2, (int)64, (pos, consumer) -> {
            for (Object directionObj : Util.copyShuffled(Direction.values(), this.world.getRandom())) {
                Direction direction = (Direction)directionObj;
                BlockPos neighbor = pos.offset(direction);
                if (!this.world.getBlockState(neighbor).isIn(ModBlockTags.CREAKING_HEART_HOLDERS)) continue;
                consumer.accept(neighbor);
            }
        }, arg_0 -> this.lambda$spreadResin$4((Mutable)mutable, arg_0));
        return Optional.ofNullable((BlockPos)mutable.getValue());
    }

    private void emitParticles(ServerWorld level, int count, boolean reverseDirection) {
        Creaking creaking = this.getCreakingProtector().orElse(null);
        if (creaking != null) {
            int color = reverseDirection ? VanillaBackport.COMMON_CONFIG.creakingParticleReverseColor.get() : VanillaBackport.COMMON_CONFIG.creakingParticleColor.get();
            Random random = level.getRandom();
            for (double i = 0.0; i < (double)count; i += 1.0) {
                Box creakingBounds = creaking.getBoundingBox();
                Vec3d currentPos = new Vec3d(creakingBounds.minX, creakingBounds.minY, creakingBounds.minZ).add(random.nextDouble() * creakingBounds.getLengthX(), random.nextDouble() * creakingBounds.getLengthY(), random.nextDouble() * creakingBounds.getLengthZ());
                Vec3d heartPos = Vec3d.of((Vec3i)this.getPos()).add(random.nextDouble(), random.nextDouble(), random.nextDouble());
                if (reverseDirection) {
                    Vec3d target = currentPos;
                    currentPos = heartPos;
                    heartPos = target;
                }
                TrailParticleOption particle = new TrailParticleOption(heartPos, color, random.nextInt(40) + 10);
                ModParticles.sendParticles(level, particle, true, true, currentPos.x, currentPos.y, currentPos.z, 1, 0.0, 0.0, 0.0, 0.0);
            }
        }
    }

    public void removeProtector(@Nullable DamageSource source) {
        Creaking creaking = this.getCreakingProtector().orElse(null);
        if (creaking != null) {
            if (source == null) {
                creaking.tearDown();
            } else {
                creaking.creakingDeathEffects(source);
                creaking.setTearingDown();
                creaking.setHealth(0.0f);
            }
            this.clearCreakingInfo();
        }
    }

    public boolean isProtector(Creaking creaking) {
        return this.getCreakingProtector().map(target -> target == creaking).orElse(false);
    }

    public int getAnalogOutputSignal() {
        return this.outputSignal;
    }

    public int computeAnalogOutputSignal() {
        if (this.creakingInfo != null && this.getCreakingProtector().isPresent()) {
            double distance = this.distanceToCreaking();
            double signalFromDistance = MathHelper.clamp((double)distance, (double)0.0, (double)32.0) / 32.0;
            return 15 - (int)Math.floor(signalFromDistance * 15.0);
        }
        return 0;
    }

    public void readNbt(NbtCompound tag, RegistryWrapper.WrapperLookup provider) {
        super.readNbt(tag, provider);
        if (tag.containsUuid("creaking")) {
            this.setCreakingInfo(tag.getUuid("creaking"));
        } else {
            this.clearCreakingInfo();
        }
    }

    protected void writeNbt(NbtCompound tag, RegistryWrapper.WrapperLookup provider) {
        super.writeNbt(tag, provider);
        if (this.creakingInfo != null) {
            tag.putUuid("creaking", (UUID)this.creakingInfo.map(Entity::getUuid, uuid -> uuid));
        }
    }

    private /* synthetic */ boolean lambda$spreadResin$4(Mutable mutable, BlockPos pos) {
        if (this.world.getBlockState(pos).isIn(ModBlockTags.CREAKING_HEART_HOLDERS)) {
            for (Object directionObj : Util.copyShuffled(Direction.values(), this.world.getRandom())) {
                Direction direction = (Direction)directionObj;
                BlockPos neighbor = pos.offset(direction);
                BlockState neighborState = this.world.getBlockState(neighbor);
                Direction opposite = direction.getOpposite();
                Block resinClump = ModBlocks.RESIN_CLUMP.get();
                if (neighborState.isAir()) {
                    neighborState = resinClump.getDefaultState();
                } else if (neighborState.isOf(Blocks.WATER) && neighborState.getFluidState().isStill()) {
                    neighborState = resinClump.getDefaultState().with(Properties.WATERLOGGED, Boolean.valueOf(true));
                }
                if (!neighborState.isOf(resinClump) || MultifaceGrowthBlock.hasDirection(neighborState, (Direction)opposite)) continue;
                this.world.setBlockState(neighbor, neighborState.with(MultifaceGrowthBlock.getProperty((Direction)opposite), Boolean.valueOf(true)), 3);
                mutable.setValue(neighbor);
                return false;
            }
        }
        return true;
    }
}

