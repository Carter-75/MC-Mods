/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Dynamic
 *  net.minecraft.class_1266
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1304
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1315
 *  net.minecraft.class_1408
 *  net.minecraft.class_1427
 *  net.minecraft.class_1538
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1928
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2281
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2745
 *  net.minecraft.class_2769
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2945$class_9222
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_3489
 *  net.minecraft.class_3730
 *  net.minecraft.class_4095
 *  net.minecraft.class_4095$class_5303
 *  net.minecraft.class_4215
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5147
 *  net.minecraft.class_5425
 *  net.minecraft.class_5561
 *  net.minecraft.class_5712
 *  net.minecraft.class_5819
 *  net.minecraft.class_5955$class_5811
 *  net.minecraft.class_6880
 *  net.minecraft.class_7
 *  net.minecraft.class_7094
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
import net.minecraft.class_1266;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1315;
import net.minecraft.class_1408;
import net.minecraft.class_1427;
import net.minecraft.class_1538;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1928;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2281;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_3489;
import net.minecraft.class_3730;
import net.minecraft.class_4095;
import net.minecraft.class_4215;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5147;
import net.minecraft.class_5425;
import net.minecraft.class_5561;
import net.minecraft.class_5712;
import net.minecraft.class_5819;
import net.minecraft.class_5955;
import net.minecraft.class_6880;
import net.minecraft.class_7;
import net.minecraft.class_7094;
import org.jetbrains.annotations.Nullable;

public class CopperGolemEntity
extends class_1427
implements class_5147,
ContainerUser {
    private static final long IGNORE_WEATHERING_TICK = -2L;
    private static final long UNSET_WEATHERING_TICK = -1L;
    private static final int SPIN_ANIMATION_MIN_COOLDOWN = 200;
    private static final int SPIN_ANIMATION_MAX_COOLDOWN = 240;
    private static final float TURN_TO_STATUE_CHANCE = 0.0058f;
    private static final double CONTAINER_INTERACTION_RANGE = 3.0;
    public static final class_1304 EQUIPMENT_SLOT_ANTENNA = class_1304.field_6169;
    private static final class_2940<Integer> DATA_WEATHER_STATE = class_2945.method_12791(CopperGolemEntity.class, (class_2941)class_2943.field_13327);
    private static final class_2940<Integer> COPPER_GOLEM_STATE = class_2945.method_12791(CopperGolemEntity.class, (class_2941)class_2943.field_13327);
    private long nextWeatheringTick = -1L;
    @Nullable
    private class_2338 openedChestPos;
    @Nullable
    private UUID lastLightningBoltUUID;
    private int idleAnimationStartTick = 0;
    public final class_7094 idleAnimationState = new class_7094();
    public final class_7094 interactionGetItemAnimationState = new class_7094();
    public final class_7094 interactionGetNoItemAnimationState = new class_7094();
    public final class_7094 interactionDropItemAnimationState = new class_7094();
    public final class_7094 interactionDropNoItemAnimationState = new class_7094();
    public final class_7094 pressingButtonAnimationState = new class_7094();

    private static class_5955.class_5811 getNextWeatherState(class_5955.class_5811 current) {
        return switch (current) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> class_5955.class_5811.field_28705;
            case class_5955.class_5811.field_28705 -> class_5955.class_5811.field_28706;
            case class_5955.class_5811.field_28706 -> class_5955.class_5811.field_28707;
            case class_5955.class_5811.field_28707 -> class_5955.class_5811.field_28707;
        };
    }

    private static class_5955.class_5811 getPreviousWeatherState(class_5955.class_5811 current) {
        return switch (current) {
            default -> throw new MatchException(null, null);
            case class_5955.class_5811.field_28704 -> class_5955.class_5811.field_28704;
            case class_5955.class_5811.field_28705 -> class_5955.class_5811.field_28704;
            case class_5955.class_5811.field_28706 -> class_5955.class_5811.field_28705;
            case class_5955.class_5811.field_28707 -> class_5955.class_5811.field_28706;
        };
    }

    public CopperGolemEntity(class_1299<? extends class_1427> entityType, class_1937 level) {
        super(entityType, level);
        this.method_5942().method_23964(3.0f);
        this.method_5971();
        this.setState(CopperGolemState.IDLE);
        this.method_5952(true);
        this.method_5941(class_7.field_9, 16.0f);
        this.method_5941(class_7.field_5, 16.0f);
        this.method_5941(class_7.field_3, -1.0f);
        this.method_18868().method_18878(ModMemoryTypes.TRANSPORT_ITEMS_COOLDOWN_TICKS.get(), (Object)this.method_59922().method_43051(60, 100));
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 12.0).method_26868(class_5134.field_23719, (double)0.2f).method_26868(class_5134.field_47761, 1.0).method_26868(class_5134.field_23721, 1.0);
    }

    protected class_4095.class_5303<CopperGolemEntity> method_28306() {
        return CopperGolemAi.brainProvider();
    }

    protected class_4095<?> method_18867(Dynamic<?> dynamic) {
        return CopperGolemAi.makeBrain((class_4095<CopperGolemEntity>)this.method_28306().method_28335(dynamic));
    }

    public class_4095<CopperGolemEntity> method_18868() {
        return super.method_18868();
    }

    protected class_1408 method_5965(class_1937 level) {
        CopperGolemNavigation navigation = new CopperGolemNavigation((class_1308)this, level);
        navigation.method_6363(true);
        navigation.method_35139(true);
        navigation.setRequiredPathLength(48.0f);
        return navigation;
    }

    public boolean method_20820(class_1799 stack) {
        return false;
    }

    protected void method_5693(class_2945.class_9222 builder) {
        super.method_5693(builder);
        builder.method_56912(DATA_WEATHER_STATE, (Object)class_5955.class_5811.field_28704.ordinal());
        builder.method_56912(COPPER_GOLEM_STATE, (Object)CopperGolemState.IDLE.ordinal());
    }

    public CopperGolemState getState() {
        int stateId = (Integer)this.field_6011.method_12789(COPPER_GOLEM_STATE);
        CopperGolemState[] states = CopperGolemState.values();
        return stateId >= 0 && stateId < states.length ? states[stateId] : CopperGolemState.IDLE;
    }

    public void setState(CopperGolemState state) {
        this.field_6011.method_12778(COPPER_GOLEM_STATE, (Object)state.ordinal());
    }

    public class_5955.class_5811 getWeatherState() {
        int weatherId = (Integer)this.field_6011.method_12789(DATA_WEATHER_STATE);
        class_5955.class_5811[] states = class_5955.class_5811.values();
        return weatherId >= 0 && weatherId < states.length ? states[weatherId] : class_5955.class_5811.field_28704;
    }

    public void setWeatherState(class_5955.class_5811 weatherState) {
        this.field_6011.method_12778(DATA_WEATHER_STATE, (Object)weatherState.ordinal());
    }

    public void setOpenedChestPos(class_2338 openedChestPos) {
        this.openedChestPos = openedChestPos;
    }

    public void clearOpenedChestPos() {
        this.openedChestPos = null;
    }

    @Override
    public boolean hasContainerOpen(class_5561 openCounter, class_2338 pos) {
        if (this.openedChestPos == null) {
            return false;
        }
        if (this.openedChestPos.equals((Object)pos)) {
            return true;
        }
        class_2680 blockstate = this.method_37908().method_8320(this.openedChestPos);
        if (blockstate.method_26204() instanceof class_2281 && blockstate.method_11654((class_2769)class_2281.field_10770) != class_2745.field_12569) {
            class_2350 connectedDirection = class_2281.method_9758((class_2680)blockstate);
            return this.openedChestPos.method_10093(connectedDirection).equals((Object)pos);
        }
        return false;
    }

    @Override
    public double getContainerInteractionRange() {
        return 3.0;
    }

    protected void method_5958() {
        this.method_37908().method_16107().method_15396("copperGolemBrain");
        this.method_18868().method_19542((class_3218)this.method_37908(), (class_1309)this);
        this.method_37908().method_16107().method_15407();
        this.method_37908().method_16107().method_15396("copperGolemActivityUpdate");
        CopperGolemAi.updateActivity(this);
        this.method_37908().method_16107().method_15407();
        super.method_5958();
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10544("next_weather_age", this.nextWeatheringTick);
        compound.method_10569("weather_state", this.getWeatherState().ordinal());
    }

    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.nextWeatheringTick = compound.method_10537("next_weather_age");
        if (compound.method_10545("weather_state")) {
            int weatherId = compound.method_10550("weather_state");
            class_5955.class_5811[] states = class_5955.class_5811.values();
            if (weatherId >= 0 && weatherId < states.length) {
                this.setWeatherState(states[weatherId]);
            }
        }
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_37908().method_8608()) {
            if (!this.method_5987()) {
                this.setupAnimationStates();
            }
        } else {
            this.updateWeathering((class_3218)this.method_37908(), this.method_37908().method_8409(), this.method_37908().method_8510());
        }
    }

    private void updateWeathering(class_3218 level, class_5819 random, long dayTime) {
        if (this.nextWeatheringTick != -2L) {
            if (this.nextWeatheringTick == -1L) {
                this.nextWeatheringTick = dayTime + (long)random.method_39332(CommonConfig.weatheringTickFrom(), CommonConfig.weatheringTickTo());
            } else {
                boolean isOxidized;
                class_5955.class_5811 weatherState = this.getWeatherState();
                boolean bl = isOxidized = weatherState == class_5955.class_5811.field_28707;
                if (dayTime >= this.nextWeatheringTick && !isOxidized) {
                    class_5955.class_5811 nextState = CopperGolemEntity.getNextWeatherState(weatherState);
                    boolean willBeOxidized = nextState == class_5955.class_5811.field_28707;
                    this.setWeatherState(nextState);
                    long l = this.nextWeatheringTick = willBeOxidized ? 0L : this.nextWeatheringTick + (long)random.method_39332(CommonConfig.weatheringTickFrom(), CommonConfig.weatheringTickTo());
                }
                if (isOxidized && this.canTurnToStatue((class_1937)level)) {
                    this.turnToStatue(level);
                }
            }
        }
    }

    private boolean canTurnToStatue(class_1937 level) {
        return level.method_8320(this.method_24515()).method_27852(class_2246.field_10124) && level.field_9229.method_43057() <= 0.0058f;
    }

    private void turnToStatue(class_3218 level) {
        class_2338 blockPos = this.method_24515();
        CopperGolemStatueBlock.Pose randomPose = CopperGolemStatueBlock.Pose.values()[this.field_5974.method_43051(0, CopperGolemStatueBlock.Pose.values().length)];
        level.method_8652(blockPos, (class_2680)((class_2680)ModBlocks.OXIDIZED_COPPER_GOLEM_STATUE.get().method_9564().method_11657(CopperGolemStatueBlock.POSE, (Comparable)((Object)randomPose))).method_11657((class_2769)CopperGolemStatueBlock.FACING, (Comparable)class_2350.method_10150((double)this.method_36454())), 3);
        class_2586 class_25862 = level.method_8321(blockPos);
        if (class_25862 instanceof CopperGolemStatueBlockEntity) {
            CopperGolemStatueBlockEntity statueEntity = (CopperGolemStatueBlockEntity)class_25862;
            statueEntity.createStatue(this);
            this.method_60973();
            this.method_31472();
            this.method_43077(ModSounds.COPPER_GOLEM_BECOME_STATUE.get());
            if (this.method_60953()) {
                if (level.method_8450().method_8355(class_1928.field_19393)) {
                    this.method_5932(true, true);
                } else {
                    this.method_5932(true, false);
                }
            }
        }
    }

    private void setupAnimationStates() {
        switch (this.getState()) {
            case IDLE: {
                this.interactionGetNoItemAnimationState.method_41325();
                this.interactionGetItemAnimationState.method_41325();
                this.interactionDropItemAnimationState.method_41325();
                this.interactionDropNoItemAnimationState.method_41325();
                this.pressingButtonAnimationState.method_41325();
                if (this.idleAnimationStartTick == this.field_6012) {
                    this.idleAnimationState.method_41322(this.field_6012);
                } else if (this.idleAnimationStartTick == 0) {
                    this.idleAnimationStartTick = this.field_6012 + this.field_5974.method_43051(200, 240);
                }
                if (this.field_6012 != this.idleAnimationStartTick + 10) break;
                this.playHeadSpinSound();
                this.idleAnimationStartTick = 0;
                break;
            }
            case GETTING_ITEM: {
                this.idleAnimationState.method_41325();
                this.idleAnimationStartTick = 0;
                this.interactionGetNoItemAnimationState.method_41325();
                this.interactionDropItemAnimationState.method_41325();
                this.interactionDropNoItemAnimationState.method_41325();
                this.pressingButtonAnimationState.method_41325();
                this.interactionGetItemAnimationState.method_41324(this.field_6012);
                break;
            }
            case GETTING_NO_ITEM: {
                this.idleAnimationState.method_41325();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.method_41325();
                this.interactionDropNoItemAnimationState.method_41325();
                this.interactionDropItemAnimationState.method_41325();
                this.pressingButtonAnimationState.method_41325();
                this.interactionGetNoItemAnimationState.method_41324(this.field_6012);
                break;
            }
            case DROPPING_ITEM: {
                this.idleAnimationState.method_41325();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.method_41325();
                this.interactionGetNoItemAnimationState.method_41325();
                this.interactionDropNoItemAnimationState.method_41325();
                this.pressingButtonAnimationState.method_41325();
                this.interactionDropItemAnimationState.method_41324(this.field_6012);
                break;
            }
            case DROPPING_NO_ITEM: {
                this.idleAnimationState.method_41325();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.method_41325();
                this.interactionGetNoItemAnimationState.method_41325();
                this.interactionDropItemAnimationState.method_41325();
                this.pressingButtonAnimationState.method_41325();
                this.interactionDropNoItemAnimationState.method_41324(this.field_6012);
                break;
            }
            case PRESSING_BUTTON: {
                this.idleAnimationState.method_41325();
                this.idleAnimationStartTick = 0;
                this.interactionGetItemAnimationState.method_41325();
                this.interactionGetNoItemAnimationState.method_41325();
                this.interactionDropItemAnimationState.method_41325();
                this.interactionDropNoItemAnimationState.method_41325();
                this.pressingButtonAnimationState.method_41324(this.field_6012);
            }
        }
    }

    public class_1269 method_5992(class_1657 player, class_1268 hand) {
        class_1799 itemstack = player.method_5998(hand);
        class_1937 level = this.method_37908();
        if (itemstack.method_7960() && !this.method_6047().method_7960()) {
            if (!level.method_8608()) {
                class_1799 heldItem = this.method_6047();
                class_4215.method_19949((class_1309)this, (class_1799)heldItem, (class_243)player.method_19538());
                this.method_6122(class_1268.field_5808, class_1799.field_8037);
            }
            return class_1269.field_5812;
        }
        if (itemstack.method_31574(class_1802.field_8868) && this.method_27072()) {
            if (level instanceof class_3218) {
                class_3218 serverLevel = (class_3218)level;
                this.method_6636(class_3419.field_15248);
                this.method_32875((class_6880)class_5712.field_28730, (class_1297)player);
                itemstack.method_7970(1, (class_1309)player, class_1309.method_56079((class_1268)hand));
            }
            return class_1269.method_29236((boolean)level.method_8608());
        }
        if (itemstack.method_31574(class_1802.field_20414) && this.nextWeatheringTick != -2L) {
            if (!level.method_8608()) {
                level.method_8444(null, 3003, this.method_24515(), 0);
                this.nextWeatheringTick = -2L;
                itemstack.method_57008(1, (class_1309)player);
            }
            return class_1269.method_29236((boolean)level.method_8608());
        }
        if (itemstack.method_31573(class_3489.field_42612)) {
            if (!level.method_8608()) {
                class_5955.class_5811 weatherState = this.getWeatherState();
                if (this.nextWeatheringTick == -2L) {
                    level.method_43129(null, (class_1297)this, class_3417.field_29541, this.method_5634(), 1.0f, 1.0f);
                    level.method_8444(null, 3004, this.method_24515(), 0);
                    this.nextWeatheringTick = -1L;
                    itemstack.method_7970(1, (class_1309)player, class_1309.method_56079((class_1268)hand));
                    return class_1269.field_5812;
                }
                if (weatherState != class_5955.class_5811.field_28704) {
                    level.method_43129(null, (class_1297)this, class_3417.field_29541, this.method_5634(), 1.0f, 1.0f);
                    level.method_8444(null, 3005, this.method_24515(), 0);
                    this.nextWeatheringTick = -1L;
                    this.setWeatherState(CopperGolemEntity.getPreviousWeatherState(weatherState));
                    itemstack.method_7970(1, (class_1309)player, class_1309.method_56079((class_1268)hand));
                    return class_1269.field_5812;
                }
            }
            return class_1269.method_29236((boolean)level.method_8608());
        }
        return super.method_5992(player, hand);
    }

    private void playHeadSpinSound() {
        if (!this.method_5701()) {
            this.method_37908().method_8486(this.method_23317(), this.method_23318(), this.method_23321(), this.getSpinHeadSound(), this.method_5634(), 1.0f, 1.0f, false);
        }
    }

    protected class_3414 method_6011(class_1282 damageSource) {
        return CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).hurtSound();
    }

    protected class_3414 method_6002() {
        return CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).deathSound();
    }

    protected void method_5712(class_2338 pos, class_2680 state) {
        this.method_5783(CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).stepSound(), 1.0f, 1.0f);
    }

    protected float method_6107() {
        return 1.0f;
    }

    protected float method_5867() {
        return this.field_5994 + 0.6f;
    }

    private class_3414 getSpinHeadSound() {
        return CopperGolemOxidationLevels.getOxidationLevel(this.getWeatherState()).spinHeadSound();
    }

    public class_243 method_29919() {
        return new class_243(0.0, 0.75 * (double)this.method_5751(), 0.0);
    }

    public void method_6636(class_3419 source) {
        this.method_37908().method_43129(null, (class_1297)this, ModSounds.COPPER_GOLEM_SHEAR.get(), source, 1.0f, 1.0f);
        class_1799 antennaItem = this.method_6118(EQUIPMENT_SLOT_ANTENNA);
        if (!antennaItem.method_7960()) {
            this.method_5673(EQUIPMENT_SLOT_ANTENNA, class_1799.field_8037);
            this.method_5699(antennaItem, 1.5f);
        }
    }

    public boolean method_27072() {
        return this.method_5805() && this.method_6118(EQUIPMENT_SLOT_ANTENNA).method_31574(class_1802.field_8880);
    }

    public void spawn(class_5955.class_5811 weatherState) {
        this.setWeatherState(weatherState);
        this.playSpawnSound();
    }

    public void playSpawnSound() {
        this.method_43077(ModSounds.COPPER_GOLEM_SPAWN.get());
    }

    @Nullable
    public class_1315 method_5943(class_5425 level, class_1266 difficulty, class_3730 spawnType, @Nullable class_1315 spawnData) {
        this.playSpawnSound();
        return super.method_5943(level, difficulty, spawnType, spawnData);
    }

    public void method_5800(class_3218 level, class_1538 lightning) {
        super.method_5800(level, lightning);
        UUID uuid = lightning.method_5667();
        if (!uuid.equals(this.lastLightningBoltUUID)) {
            this.lastLightningBoltUUID = uuid;
            class_5955.class_5811 weatherState = this.getWeatherState();
            if (weatherState != class_5955.class_5811.field_28704) {
                this.nextWeatheringTick = -1L;
                this.setWeatherState(CopperGolemEntity.getPreviousWeatherState(weatherState));
            }
        }
    }

    protected void method_6074(class_1282 source, float amount) {
        super.method_6074(source, amount);
        this.setState(CopperGolemState.IDLE);
    }

    protected void method_16078() {
        super.method_16078();
        this.method_60973();
    }
}

