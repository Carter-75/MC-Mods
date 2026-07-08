/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.MapCodec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.world.Difficulty
 *  net.minecraft.entity.effect.StatusEffect
 *  net.minecraft.entity.effect.StatusEffectInstance
 *  net.minecraft.entity.effect.StatusEffects
 *  net.minecraft.entity.Entity
 *  net.minecraft.world.World
 *  net.minecraft.block.Block
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.block.FlowerBlock
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.particle.ParticleEffect
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.block.BlockState
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.entity.passive.BeeEntity
 *  net.minecraft.block.AbstractBlock$Settings
 *  net.minecraft.world.event.GameEvent
 *  net.minecraft.world.event.GameEvent$Emitter
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.content.common.level.blocks;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.registries.ModBlocks;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.Difficulty;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.FlowerBlock;
import net.minecraft.util.math.Vec3i;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.block.AbstractBlock;
import net.minecraft.world.event.GameEvent;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.entry.RegistryEntry;

public class EyeblossomBlock
extends FlowerBlock {
    public static final MapCodec<EyeblossomBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.BOOL.fieldOf("open").forGetter(block -> block.type.open), EyeblossomBlock.createSettingsCodec()).apply(instance, EyeblossomBlock::new));
    private final Type type;

    public MapCodec<? extends EyeblossomBlock> getCodec() {
        return CODEC;
    }

    public EyeblossomBlock(Type type, AbstractBlock.Settings properties) {
        super(type.effect, (float)type.effectDuration, properties);
        this.type = type;
    }

    public EyeblossomBlock(boolean open, AbstractBlock.Settings properties) {
        super(Type.fromBoolean((boolean)open).effect, (float)Type.fromBoolean((boolean)open).effectDuration, properties);
        this.type = Type.fromBoolean(open);
    }

    public void randomDisplayTick(BlockState state, World level, BlockPos pos, Random random) {
        BlockState floorState;
        if (this.type.emitSounds() && random.nextInt(700) == 0 && (floorState = level.getBlockState(pos.down())).isOf(ModBlocks.PALE_MOSS_BLOCK.get())) {
            level.playSound((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), ModSoundEvents.EYEBLOSSOM_IDLE.get(), SoundCategory.BLOCKS, 1.0f, 1.0f, false);
        }
    }

    public void randomTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (this.tryChangingState(state, level, pos, random)) {
            level.playSound(null, pos, this.type.transform().longSwitchSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        super.randomTick(state, level, pos, random);
    }

    public void scheduledTick(BlockState state, ServerWorld level, BlockPos pos, Random random) {
        if (this.tryChangingState(state, level, pos, random)) {
            level.playSound(null, pos, this.type.transform().shortSwitchSound, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        super.scheduledTick(state, level, pos, random);
    }

    private boolean tryChangingState(BlockState state, ServerWorld level, BlockPos origin, Random random) {
        if (!level.getDimension().natural()) {
            return false;
        }
        if (CreakingHeartBlock.isNaturalNight((World)level) == this.type.open) {
            return false;
        }
        Type type = this.type.transform();
        level.setBlockState(origin, type.state(), 3);
        level.emitGameEvent((RegistryEntry)GameEvent.BLOCK_CHANGE, origin, GameEvent.Emitter.of(state));
        type.spawnTransformParticle(level, origin, random);
        BlockPos.iterate((BlockPos)origin.add(-3, -2, -3), (BlockPos)origin.add(3, 2, 3)).forEach(pos -> {
            BlockState closeState = level.getBlockState(pos);
            if (closeState == state) {
                double distance = Math.sqrt(origin.getSquaredDistance((Vec3i)pos));
                int ticks = random.nextBetween((int)(distance * 5.0), (int)(distance * 10.0));
                level.scheduleBlockTick(pos, state.getBlock(), ticks);
            }
        });
        return true;
    }

    public void onEntityCollision(BlockState state, World level, BlockPos pos, Entity entity) {
        BeeEntity bee;
        if (!level.isClient() && level.getDifficulty() != Difficulty.PEACEFUL && entity instanceof BeeEntity && !(bee = (BeeEntity)entity).hasStatusEffect(StatusEffects.POISON)) {
            bee.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 25));
        }
    }

    public static enum Type {
        OPEN(true, (RegistryEntry<StatusEffect>)StatusEffects.BLINDNESS, 11, ModSoundEvents.EYEBLOSSOM_OPEN_LONG.get(), ModSoundEvents.EYEBLOSSOM_OPEN.get(), 16545810),
        CLOSED(false, (RegistryEntry<StatusEffect>)StatusEffects.NAUSEA, 7, ModSoundEvents.EYEBLOSSOM_CLOSE_LONG.get(), ModSoundEvents.EYEBLOSSOM_CLOSE.get(), 0x5F5F5F);

        final boolean open;
        final RegistryEntry<StatusEffect> effect;
        final int effectDuration;
        final SoundEvent longSwitchSound;
        final SoundEvent shortSwitchSound;
        final int particleColor;

        private Type(boolean open, RegistryEntry<StatusEffect> effect, int effectDuration, SoundEvent longSwitchSound, SoundEvent shortSwitchSound, int particleColor) {
            this.open = open;
            this.effect = effect;
            this.effectDuration = effectDuration;
            this.longSwitchSound = longSwitchSound;
            this.shortSwitchSound = shortSwitchSound;
            this.particleColor = particleColor;
        }

        public Block block() {
            return this.open ? ModBlocks.OPEN_EYEBLOSSOM.get() : ModBlocks.CLOSED_EYEBLOSSOM.get();
        }

        public BlockState state() {
            return this.block().getDefaultState();
        }

        public Type transform() {
            return Type.fromBoolean(!this.open);
        }

        public boolean emitSounds() {
            return this.open;
        }

        public static Type fromBoolean(boolean open) {
            return open ? OPEN : CLOSED;
        }

        public void spawnTransformParticle(ServerWorld level, BlockPos pos, Random random) {
            Vec3d center = pos.toCenterPos();
            double scale = 0.5 + random.nextDouble();
            Vec3d offset = new Vec3d(random.nextDouble() - 0.5, random.nextDouble() + 1.0, random.nextDouble() - 0.5);
            Vec3d target = center.add(offset.multiply(scale));
            TrailParticleOption particle = new TrailParticleOption(target, this.particleColor, (int)(20.0 * scale));
            level.spawnParticles((ParticleEffect)particle, center.x, center.y, center.z, 1, 0.0, 0.0, 0.0, 0.0);
        }

        public SoundEvent longSwitchSound() {
            return this.longSwitchSound;
        }
    }
}

