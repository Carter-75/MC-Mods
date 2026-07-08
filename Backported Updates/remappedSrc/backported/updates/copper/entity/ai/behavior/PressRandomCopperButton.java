/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableMap
 *  net.minecraft.class_2248
 *  net.minecraft.class_2269
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_2680
 *  net.minecraft.class_2738
 *  net.minecraft.class_2741
 *  net.minecraft.class_2769
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3532
 *  net.minecraft.class_4097
 *  net.minecraft.class_4099
 *  net.minecraft.class_4140
 *  net.minecraft.class_4141
 *  net.minecraft.class_4142
 *  net.minecraft.class_5955$class_5811
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
import net.minecraft.class_2248;
import net.minecraft.class_2269;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_2680;
import net.minecraft.class_2738;
import net.minecraft.class_2741;
import net.minecraft.class_2769;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3532;
import net.minecraft.class_4097;
import net.minecraft.class_4099;
import net.minecraft.class_4140;
import net.minecraft.class_4141;
import net.minecraft.class_4142;
import net.minecraft.class_5955;
import org.jetbrains.annotations.Nullable;

public class PressRandomCopperButton
extends class_4097<CopperGolemEntity> {
    private final float speedModifier;
    private final int horizontalSearchDistance;
    private final int verticalSearchDistance;
    private final int pressInterval;
    private final Random random = new Random();
    @Nullable
    private class_2338 targetButton;
    private int ticksSinceReached = 0;

    public PressRandomCopperButton(float speedModifier, int horizontalSearchDistance, int verticalSearchDistance, int pressInterval) {
        super((Map)ImmutableMap.of((Object)class_4140.field_18445, (Object)class_4141.field_18457, ModMemoryTypes.VISITED_BLOCK_POSITIONS.get(), (Object)class_4141.field_18458, ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), (Object)class_4141.field_18456), pressInterval);
        this.speedModifier = speedModifier;
        this.horizontalSearchDistance = horizontalSearchDistance;
        this.verticalSearchDistance = verticalSearchDistance;
        this.pressInterval = pressInterval;
    }

    protected boolean checkExtraStartConditions(class_3218 level, CopperGolemEntity golem) {
        if (this.targetButton != null) {
            return false;
        }
        if (golem.getState() != CopperGolemState.IDLE) {
            return false;
        }
        Optional lastEmptyTime = golem.method_18868().method_18904(ModMemoryTypes.LAST_CONTAINER_EMPTY.get());
        if (lastEmptyTime.isEmpty()) {
            return false;
        }
        int chancePercent = CommonConfig.buttonPressChancePercent();
        float chanceFloat = (float)chancePercent / 100.0f;
        if (this.random.nextFloat() >= chanceFloat) {
            golem.method_18868().method_18875(ModMemoryTypes.LAST_CONTAINER_EMPTY.get());
            return false;
        }
        golem.method_18868().method_18875(ModMemoryTypes.LAST_CONTAINER_EMPTY.get());
        class_2338 buttonPos = this.findRandomCopperButton(level, golem);
        if (buttonPos != null) {
            this.targetButton = buttonPos;
            return true;
        }
        return false;
    }

    protected void start(class_3218 level, CopperGolemEntity golem, long gameTime) {
        if (this.targetButton != null) {
            golem.method_18868().method_18878(class_4140.field_18445, (Object)new class_4142(this.targetButton, this.speedModifier, 0));
            golem.method_18868().method_18878(class_4140.field_18446, (Object)new class_4099(this.targetButton));
        }
    }

    protected boolean canStillUse(class_3218 level, CopperGolemEntity golem, long gameTime) {
        if (this.targetButton == null) {
            return false;
        }
        double distanceSqr = golem.method_24515().method_10262((class_2382)this.targetButton);
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
        class_2680 state = level.method_8320(this.targetButton);
        if (!this.isCopperButton(state.method_26204())) {
            return false;
        }
        return this.ticksSinceReached < 200;
    }

    protected void stop(class_3218 level, CopperGolemEntity golem, long gameTime) {
        golem.method_18868().method_18875(class_4140.field_18445);
        golem.method_18868().method_18875(class_4140.field_18446);
        golem.setState(CopperGolemState.IDLE);
        this.targetButton = null;
        this.ticksSinceReached = 0;
    }

    private void pressButton(class_3218 level, CopperGolemEntity golem, class_2338 pos) {
        class_2680 state = level.method_8320(pos);
        class_2248 block = state.method_26204();
        if (block instanceof class_2269) {
            CopperButtonBlock copperButton;
            class_2269 buttonBlock = (class_2269)block;
            if (((Boolean)state.method_11654((class_2769)class_2741.field_12484)).booleanValue()) {
                return;
            }
            if (block instanceof CopperButtonBlock && (copperButton = (CopperButtonBlock)block).getAge() == class_5955.class_5811.field_28707) {
                level.method_8396(null, pos, class_3417.field_26963, class_3419.field_15245, 1.0f, 1.0f);
                return;
            }
            class_2680 poweredState = (class_2680)state.method_11657((class_2769)class_2741.field_12484, (Comparable)Boolean.valueOf(true));
            level.method_8652(pos, poweredState, 3);
            level.method_8396(null, pos, class_3417.field_26963, class_3419.field_15245, 0.3f, 0.6f);
            level.method_39279(pos, (class_2248)buttonBlock, 15);
            level.method_8452(pos, (class_2248)buttonBlock);
            class_2738 face = (class_2738)state.method_11654((class_2769)class_2741.field_12555);
            class_2350 facing = (class_2350)state.method_11654((class_2769)class_2741.field_12481);
            class_2350 attachedDirection = face == class_2738.field_12475 ? class_2350.field_11033 : (face == class_2738.field_12473 ? class_2350.field_11036 : facing.method_10153());
            class_2338 attachedPos = pos.method_10093(attachedDirection);
            level.method_8452(attachedPos, (class_2248)buttonBlock);
        }
    }

    @Nullable
    private class_2338 findRandomCopperButton(class_3218 level, CopperGolemEntity golem) {
        class_2338 golemPos = golem.method_24515();
        ArrayList<class_2338> allAvailableButtons = new ArrayList<class_2338>();
        for (int x = -this.horizontalSearchDistance; x <= this.horizontalSearchDistance; ++x) {
            for (int y = -this.verticalSearchDistance; y <= this.verticalSearchDistance; ++y) {
                for (int z = -this.horizontalSearchDistance; z <= this.horizontalSearchDistance; ++z) {
                    class_2338 checkPos = golemPos.method_10069(x, y, z);
                    class_2680 state = level.method_8320(checkPos);
                    if (!this.isCopperButton(state.method_26204()) || ((Boolean)state.method_11654((class_2769)class_2741.field_12484)).booleanValue()) continue;
                    allAvailableButtons.add(checkPos);
                }
            }
        }
        if (!allAvailableButtons.isEmpty()) {
            return (class_2338)allAvailableButtons.get(golem.method_59922().method_43048(allAvailableButtons.size()));
        }
        return null;
    }

    private boolean isCopperButton(class_2248 block) {
        return block == ModBlocks.COPPER_BUTTON.get() || block == ModBlocks.EXPOSED_COPPER_BUTTON.get() || block == ModBlocks.WEATHERED_COPPER_BUTTON.get() || block == ModBlocks.OXIDIZED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_EXPOSED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_WEATHERED_COPPER_BUTTON.get() || block == ModBlocks.WAXED_OXIDIZED_COPPER_BUTTON.get();
    }

    private void stopInPlace(CopperGolemEntity golem) {
        golem.method_5942().method_6340();
        golem.method_18868().method_18875(class_4140.field_18445);
        golem.method_5938(0.0f);
        golem.method_5976(0.0f);
        golem.method_5930(0.0f);
        golem.method_6125(0.0f);
        golem.method_18800(0.0, golem.method_18798().field_1351, 0.0);
        golem.field_42108.method_48567(0.0f);
    }

    private void rotateTowardsButton(CopperGolemEntity golem, class_2338 buttonPos) {
        double dx = (double)buttonPos.method_10263() + 0.5 - golem.method_23317();
        double dz = (double)buttonPos.method_10260() + 0.5 - golem.method_23321();
        float desiredYaw = (float)(Math.atan2(dz, dx) * 57.29577951308232) - 90.0f;
        desiredYaw = class_3532.method_15393((float)desiredYaw);
        float currentYaw = class_3532.method_15393((float)golem.method_36454());
        float yawDiff = class_3532.method_15393((float)(desiredYaw - currentYaw));
        float rotationStep = class_3532.method_15363((float)yawDiff, (float)-30.0f, (float)30.0f);
        float newYaw = currentYaw + rotationStep;
        golem.method_36456(newYaw);
        golem.field_5982 = newYaw;
        golem.method_5847(newYaw);
        golem.field_6259 = newYaw;
        golem.field_6283 = newYaw;
        golem.field_6220 = newYaw;
    }
}

