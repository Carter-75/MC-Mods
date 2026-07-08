/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  net.minecraft.block.Block
 *  net.minecraft.block.ButtonBlock
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Direction
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.block.BlockState
 *  net.minecraft.block.enums.BlockFace
 *  net.minecraft.state.property.Properties
 *  net.minecraft.Property
 *  net.minecraft.server.world.ServerWorld
 *  net.minecraft.sound.SoundEvents
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.entity.ai.brain.task.MultiTickTask
 *  net.minecraft.entity.ai.brain.BlockPosLookTarget
 *  net.minecraft.entity.ai.brain.MemoryModuleType
 *  net.minecraft.entity.ai.brain.MemoryModuleState
 *  net.minecraft.entity.ai.brain.WalkTarget
 *  net.minecraft.block.Oxidizable$OxidationLevel
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.copper.entity.ai.behavior;

import backported.updates.copper.ModMemoryTypes;
import backported.updates.copper.block.CopperButtonBlock;
import backported.updates.copper.config.CommonConfig;
import backported.updates.copper.entity.CopperGolemEntity;
import backported.updates.copper.entity.CopperGolemState;
import backported.updates.copper.registry.ModBlocks;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.ButtonBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.ai.brain.task.MultiTickTask;
import net.minecraft.entity.ai.brain.BlockPosLookTarget;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.ai.brain.MemoryModuleState;
import net.minecraft.entity.ai.brain.WalkTarget;
import net.minecraft.block.Oxidizable;
import org.jetbrains.annotations.Nullable;

public class PressRandomCopperButton
extends MultiTickTask<CopperGolemEntity> {
    private final float speedModifier;
    private final int horizontalSearchDistance;
    private final int verticalSearchDistance;
    private final int pressInterval;
    private final Random random = new Random();
    @Nullable
    private BlockPos targetButton;
    private int ticksSinceReached = 0;

    public PressRandomCopperButton(float speedModifier, int horizontalSearchDistance, int verticalSearchDistance, int pressInterval) {
        super(ImmutableMap.of(MemoryModuleType.WALK_TARGET, MemoryModuleState.VALUE_ABSENT, ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), MemoryModuleState.REGISTERED, ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), MemoryModuleState.VALUE_PRESENT), pressInterval);
        this.speedModifier = speedModifier;
        this.horizontalSearchDistance = horizontalSearchDistance;
        this.verticalSearchDistance = verticalSearchDistance;
        this.pressInterval = pressInterval;
    }

    protected boolean checkExtraStartConditions(ServerWorld level, CopperGolemEntity golem) {
        if (this.targetButton != null) {
            return false;
        }
        if (golem.getState() != CopperGolemState.IDLE) {
            return false;
        }
        Optional lastEmptyTime = golem.getBrain().getOptionalRegisteredMemory(ModMemoryTypes.LAST_CONTAINER_EMPTY.get());
        if (lastEmptyTime.isEmpty()) {
            return false;
        }
        int chancePercent = CommonConfig.buttonPressChancePercent();
        float chanceFloat = (float)chancePercent / 100.0f;
        if (this.random.nextFloat() >= chanceFloat) {
            golem.getBrain().forget(ModMemoryTypes.LAST_CONTAINER_EMPTY.get());
            return false;
        }
        golem.getBrain().forget(ModMemoryTypes.LAST_CONTAINER_EMPTY.get());
        BlockPos buttonPos = this.findRandomCopperButton(level, golem);
        if (buttonPos != null) {
            this.targetButton = buttonPos;
            return true;
        }
        return false;
    }

    protected void start(ServerWorld level, CopperGolemEntity golem, long gameTime) {
        if (this.targetButton != null) {
            golem.getBrain().remember(MemoryModuleType.WALK_TARGET, new WalkTarget(this.targetButton, this.speedModifier, 0));
            golem.getBrain().remember(MemoryModuleType.LOOK_TARGET, new BlockPosLookTarget(this.targetButton));
        }
    }

    protected boolean canStillUse(ServerWorld level, CopperGolemEntity golem, long gameTime) {
        if (this.targetButton == null) {
            return false;
        }
        double distanceSqr = golem.getBlockPos().getSquaredDistance((Vec3i)this.targetButton);
        if (distanceSqr <= 0.5) {
            if (this.ticksSinceReached == 0) {
                this.stopInPlace(golem);
            }
            ++this.ticksSinceReached;
            if (this.ticksSinceReached <= 10) {
                this.stopInPlace(golem);
                this.rotateTowardsButton(golem, this.targetButton);
            }
            if (this.ticksSinceReached == 11) {
                golem.setState(CopperGolemState.PRESSING_BUTTON);
            }
            if (this.ticksSinceReached == 19) {
                this.pressButton(level, golem, this.targetButton);
            }
            return this.ticksSinceReached < 35;
        }
        BlockState state = level.getBlockState(this.targetButton);
        if (!this.isCopperButton(state.getBlock())) {
            return false;
        }
        return this.ticksSinceReached < 200;
    }

    protected void finishRunning(ServerWorld level, CopperGolemEntity golem, long gameTime) {
        golem.getBrain().forget(MemoryModuleType.WALK_TARGET);
        golem.getBrain().forget(MemoryModuleType.LOOK_TARGET);
        golem.setState(CopperGolemState.IDLE);
        this.targetButton = null;
        this.ticksSinceReached = 0;
    }

    private void pressButton(ServerWorld level, CopperGolemEntity golem, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        Block block = state.getBlock();
        if (block instanceof ButtonBlock) {
            CopperButtonBlock copperButton;
            ButtonBlock buttonBlock = (ButtonBlock)block;
            if (((Boolean)state.get(Properties.POWERED)).booleanValue()) {
                return;
            }
            if (block instanceof CopperButtonBlock && (copperButton = (CopperButtonBlock)block).getAge() == Oxidizable.OxidationLevel.OXIDIZED) {
                level.playSound(null, pos, SoundEvents.BLOCK_COPPER_HIT, SoundCategory.BLOCKS, 1.0f, 1.0f);
                return;
            }
            BlockState poweredState = state.with(Properties.POWERED, Boolean.valueOf(true));
            level.setBlockState(pos, poweredState, 3);
            level.playSound(null, pos, SoundEvents.BLOCK_COPPER_HIT, SoundCategory.BLOCKS, 0.3f, 0.6f);
            level.scheduleBlockTick(pos, (Block)buttonBlock, 15);
            level.updateNeighborsAlways(pos, (Block)buttonBlock);
            BlockFace face = (BlockFace)state.get(Properties.BLOCK_FACE);
            Direction facing = (Direction)state.get(Properties.HORIZONTAL_FACING);
            Direction attachedDirection = face == BlockFace.FLOOR ? Direction.DOWN : (face == BlockFace.CEILING ? Direction.UP : facing.getOpposite());
            BlockPos attachedPos = pos.offset(attachedDirection);
            level.updateNeighborsAlways(attachedPos, (Block)buttonBlock);
        }
    }

    @Nullable
    private BlockPos findRandomCopperButton(ServerWorld level, CopperGolemEntity golem) {
        BlockPos golemPos = golem.getBlockPos();
        ArrayList<BlockPos> allAvailableButtons = new ArrayList<BlockPos>();
        for (int x = -this.horizontalSearchDistance; x <= this.horizontalSearchDistance; ++x) {
            for (int y = -this.verticalSearchDistance; y <= this.verticalSearchDistance; ++y) {
                for (int z = -this.horizontalSearchDistance; z <= this.horizontalSearchDistance; ++z) {
                    BlockPos checkPos = golemPos.add(x, y, z);
                    BlockState state = level.getBlockState(checkPos);
                    if (!this.isCopperButton(state.getBlock()) || ((Boolean)state.get(Properties.POWERED)).booleanValue()) continue;
                    allAvailableButtons.add(checkPos);
                }
            }
        }
        if (!allAvailableButtons.isEmpty()) {
            return (BlockPos)allAvailableButtons.get(golem.getRandom().nextInt(allAvailableButtons.size()));
        }
        return null;
    }

    private boolean isCopperButton(Block block) {
        return block == ModBlocks.COPPER_BUTTON.get() || block == ModBlocks.EXPOSED_COPPER_BUTTON.get() || block == ModBlocks.WEATHERED_COPPER_BUTTON.get() || block == ModBlocks.OXIDIZED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_EXPOSED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_WEATHERED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_OXIDIZED_COPPER_BUTTON.get();
    }

    private void stopInPlace(CopperGolemEntity golem) {
        golem.getNavigation().stop();
        golem.getBrain().forget(MemoryModuleType.WALK_TARGET);
        golem.setSidewaysSpeed(0.0f);
        golem.setUpwardSpeed(0.0f);
        golem.setForwardSpeed(0.0f);
        golem.setMovementSpeed(0.0f);
        golem.setVelocity(0.0, golem.getVelocity().y, 0.0);
        golem.limbAnimator.setSpeed(0.0f);
    }

    private void rotateTowardsButton(CopperGolemEntity golem, BlockPos buttonPos) {
        double dx = (double)buttonPos.getX() + 0.5 - golem.getX();
        double dz = (double)buttonPos.getZ() + 0.5 - golem.getZ();
        float desiredYaw = (float)(Math.atan2(dz, dx) * 57.29577951308232) - 90.0f;
        desiredYaw = MathHelper.wrapDegrees((float)desiredYaw);
        float currentYaw = MathHelper.wrapDegrees((float)golem.getYaw());
        float yawDiff = MathHelper.wrapDegrees((float)(desiredYaw - currentYaw));
        float rotationStep = MathHelper.clamp((float)yawDiff, (float)-30.0f, (float)30.0f);
        float newYaw = currentYaw + rotationStep;
        golem.setYaw(newYaw);
        golem.prevYaw = newYaw;
        golem.setHeadYaw(newYaw);
        golem.prevHeadYaw = newYaw;
        golem.bodyYaw = newYaw;
        golem.prevBodyYaw = newYaw;
    }
}

