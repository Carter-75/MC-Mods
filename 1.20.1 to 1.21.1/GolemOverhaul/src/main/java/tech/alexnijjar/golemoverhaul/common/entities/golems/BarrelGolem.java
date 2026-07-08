/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1303
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1315
 *  net.minecraft.class_1352
 *  net.minecraft.class_1374
 *  net.minecraft.class_1427
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1665
 *  net.minecraft.class_173
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_181
 *  net.minecraft.class_1928
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3489
 *  net.minecraft.class_3730
 *  net.minecraft.class_4215
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_52
 *  net.minecraft.class_5425
 *  net.minecraft.class_5534
 *  net.minecraft.class_5819
 *  net.minecraft.class_8103
 *  net.minecraft.class_8567$class_8568
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.core.animation.AnimationController
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.core.object.PlayState
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import java.util.List;
import net.minecraft.class_1266;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1303;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1315;
import net.minecraft.class_1352;
import net.minecraft.class_1374;
import net.minecraft.class_1427;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_173;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_181;
import net.minecraft.class_1928;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3489;
import net.minecraft.class_3730;
import net.minecraft.class_4215;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_52;
import net.minecraft.class_5425;
import net.minecraft.class_5534;
import net.minecraft.class_5819;
import net.minecraft.class_8103;
import net.minecraft.class_8567;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantAnimations;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModSoundEvents;

public class BarrelGolem
extends BaseGolem {
    private static final class_2940<Boolean> ID_OPEN = class_2945.method_12791(BarrelGolem.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Integer> ID_DAY_START_TICKS = class_2945.method_12791(BarrelGolem.class, (class_2941)class_2943.field_13327);
    private static final class_2382 ITEM_PICKUP_REACH = new class_2382(2, 0, 2);
    public static final class_2960 BARTERING_LOOT = new class_2960("golemoverhaul", "gameplay/barrel_golem_bartering");
    public static final byte CHANGE_STATE_EVENT_ID = 8;
    public static final byte BARTER_EVENT_ID = 9;
    public static final int WAKE_UP_TICKS = 62;
    public static final int BARTERING_TICKS = 78;
    private int changeStateTicks;
    private int barteringTicks;
    private int openUpTicks;
    @Nullable
    private class_1657 barteringTarget;

    public BarrelGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 10;
        this.method_5952(true);
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 40.0).method_26868(class_5134.field_23719, 0.31).method_26868(class_5134.field_23724, 6.0).method_26868(class_5134.field_23721, 1.0);
    }

    public static boolean checkMobSpawnRules(class_1299<? extends class_1308> type, class_1936 level, class_3730 spawnType, class_2338 pos, class_5819 random) {
        if (!GolemOverhaulConfig.spawnBarrelGolems || !GolemOverhaulConfig.allowSpawning) {
            return false;
        }
        return class_1308.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        super.registerControllers(controllers);
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "open_controller", state -> {
            if (this.isBartering()) {
                state.resetCurrentAnimation();
                return PlayState.STOP;
            }
            if (this.isWakingUp()) {
                return state.setAndContinue(ConstantAnimations.WAKE_UP);
            }
            if (this.openUpTicks > 0) {
                return state.setAndContinue(ConstantAnimations.OPEN);
            }
            if (this.method_37908().method_23886() || !this.isOpen()) {
                return state.setAndContinue(ConstantAnimations.HIDE);
            }
            state.resetCurrentAnimation();
            return PlayState.STOP;
        })});
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "barter_controller", 5, state -> {
            if (this.isBartering()) {
                return state.setAndContinue(ConstantAnimations.BARTER);
            }
            state.resetCurrentAnimation();
            return PlayState.STOP;
        }).setSoundKeyframeHandler(event -> this.method_37908().method_45446(this.method_24515(), (class_3414)ModSoundEvents.BARREL_GOLEM_BARTER.get(), this.method_5634(), 1.0f, 1.0f, false))});
    }

    @Override
    public PlayState getMoveAnimation(AnimationState<BaseGolem> state, boolean moving) {
        if (!this.isOpen()) {
            return PlayState.STOP;
        }
        if (this.isBartering()) {
            state.resetCurrentAnimation();
            return PlayState.STOP;
        }
        return state.setAndContinue(moving ? ConstantAnimations.WALK : (this.isOpen() ? ConstantAnimations.IDLE : ConstantAnimations.IDLE_HIDDEN));
    }

    @Override
    public PlayState getAttackAnimation(AnimationState<? extends BaseGolem> state) {
        return PlayState.STOP;
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_OPEN, (Object)true);
        this.field_6011.method_12784(ID_DAY_START_TICKS, (Object)62);
    }

    public boolean method_30948() {
        return this.method_5805() && !this.isOpen();
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10556("Open", this.isOpen());
        compound.method_10569("ChangeStateTicks", this.changeStateTicks);
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setOpen(compound.method_10577("Open"), false);
        this.changeStateTicks = compound.method_10550("ChangeStateTicks");
    }

    @Override
    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(1, (class_1352)new BarrelGolemPanicGoal(1.0));
        this.field_6201.method_6277(2, (class_1352)new BarrelGolemFindNearestEmeraldGoal());
    }

    @Override
    public boolean canTarget() {
        return false;
    }

    public boolean isOpen() {
        return (Boolean)this.field_6011.method_12789(ID_OPEN);
    }

    public boolean isBartering() {
        return this.barteringTicks > 0;
    }

    public int getBarteringTicks() {
        return this.barteringTicks;
    }

    public int getDayStartTicks() {
        return (Integer)this.field_6011.method_12789(ID_DAY_START_TICKS);
    }

    public void setDayStartTicks(int ticks) {
        this.field_6011.method_12778(ID_DAY_START_TICKS, (Object)ticks);
    }

    public void setOpen(boolean open, boolean playSound) {
        if (!open && this.method_5809()) {
            return;
        }
        if (!this.method_37908().method_8608() && playSound && this.isOpen() != open) {
            if (open) {
                this.method_43077(class_3417.field_17604);
            } else {
                this.method_43077(class_3417.field_17603);
            }
        }
        this.field_6011.method_12778(ID_OPEN, (Object)open);
        this.openUpTicks = open ? 10 : 0;
        this.method_5996(class_5134.field_23718).method_6192(open ? 0.0 : 1.0);
    }

    @Override
    protected class_3414 method_6011(class_1282 damageSource) {
        return class_3417.field_15135;
    }

    @Override
    protected class_3414 method_6002() {
        return class_3417.field_14742;
    }

    @Override
    public void method_5711(byte id) {
        super.method_5711(id);
        if (id == 8) {
            this.changeStateTicks = this.getRandomChangeInterval();
        } else if (id == 9) {
            this.barteringTicks = 78;
        }
    }

    @Override
    public boolean canRepair(class_1799 stack) {
        return stack.method_31573(class_3489.field_15537);
    }

    @Override
    public float getRepairItemHealAmount() {
        return 5.0f;
    }

    @Override
    public class_3414 getRepairSound() {
        return class_3417.field_14675;
    }

    @Override
    @Nullable
    public class_1315 method_5943(class_5425 level, class_1266 difficulty, class_3730 reason, @Nullable class_1315 spawnData, @Nullable class_2487 dataTag) {
        this.setOpen(this.method_37908().method_8594() < 4, false);
        this.changeStateTicks = this.getRandomChangeInterval();
        return super.method_5943(level, difficulty, reason, spawnData, dataTag);
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (!this.isOpen()) {
            class_1665 arrow;
            class_1297 class_12972 = source.method_5526();
            if (class_12972 instanceof class_1665 && !(arrow = (class_1665)class_12972).method_5809()) {
                return false;
            }
            if (!source.method_48789(class_8103.field_42246)) {
                amount /= 10.0f;
            } else {
                amount *= 2.0f;
                if (!this.isOpen()) {
                    this.setOpen(true, true);
                }
            }
        }
        return super.method_5643(source, amount);
    }

    protected boolean method_6062() {
        return super.method_6062() || this.isBartering() || !this.isOpen();
    }

    @Override
    public void method_6007() {
        super.method_6007();
        if (!this.method_37908().method_8608()) {
            if (this.method_37908().method_8594() < 4) {
                this.setDayStartTicks(this.getDayStartTicks() + 1);
            } else {
                this.setDayStartTicks(0);
            }
        }
        this.changeStateTicks = Math.max(0, this.changeStateTicks - 1);
        this.barteringTicks = Math.max(0, this.barteringTicks - 1);
        this.openUpTicks = Math.max(0, this.openUpTicks - 1);
        if (!this.method_37908().method_8608()) {
            if (this.changeStateTicks == 0 && this.method_37908().method_8530() && !this.isWakingUp()) {
                this.setOpen(!this.isOpen(), true);
                this.changeStateTicks = this.getRandomChangeInterval();
                this.method_37908().method_8421((class_1297)this, (byte)8);
            }
            if (!this.isOpen() || this.isBartering()) {
                this.field_6189.method_6340();
            }
            if (!this.method_37908().method_8530() && this.isOpen()) {
                this.setOpen(false, true);
            } else if (this.finishedWakeUp() && !this.isOpen()) {
                this.setOpen(true, false);
            }
            if (this.barteringTicks == 24) {
                this.throwItems(this.getBarterResponseItems());
                class_1303 orb = new class_1303(this.method_37908(), this.method_23317(), this.method_23318(), this.method_23321(), this.method_6051().method_43048(2) + 2);
                this.method_37908().method_8649((class_1297)orb);
                if (this.barteringTarget != null) {
                    class_243 targetPos = this.barteringTarget.method_19538().method_1020(this.method_19538());
                    targetPos = targetPos.method_1029().method_18805(0.3, 0.3, 0.3);
                    orb.method_18799(targetPos);
                }
                this.barteringTarget = null;
                this.method_6122(class_1268.field_5808, class_1799.field_8037);
                this.method_36457(0.0f);
            }
        }
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_37908().method_8608()) {
            if (!this.isOpen() || this.isBartering()) {
                this.field_6283 = this.field_6241;
            }
        } else {
            class_1799 stack = this.method_6047();
            if (stack.method_31574(class_1802.field_8687) && !this.isBartering() && this.isOpen()) {
                this.barter();
            }
        }
    }

    protected void method_5949(class_1542 itemEntity) {
        class_1297 class_12972;
        class_1799 stack = itemEntity.method_6983();
        class_1799 equippedStack = this.method_24523(stack.method_7972());
        if (!equippedStack.method_7960()) {
            this.method_29499(itemEntity);
            this.method_6103((class_1297)itemEntity, 1);
            stack.method_7934(1);
            if (stack.method_7960()) {
                itemEntity.method_31472();
            } else {
                itemEntity.method_6976();
            }
        }
        if ((class_12972 = itemEntity.method_24921()) instanceof class_1657) {
            class_1657 player;
            this.barteringTarget = player = (class_1657)class_12972;
        }
    }

    private boolean canBarterWith(class_1799 stack) {
        return stack.method_31574(class_1802.field_8687) && this.method_6047().method_7960() && this.isOpen() && !this.isBartering();
    }

    public boolean method_20820(class_1799 stack) {
        return this.method_37908().method_8450().method_8355(class_1928.field_19388) && this.canBarterWith(stack);
    }

    @NotNull
    protected class_2382 method_42646() {
        return ITEM_PICKUP_REACH;
    }

    public boolean isWakingUp() {
        int ticks = this.getDayStartTicks();
        return ticks > 0 && ticks < 62;
    }

    private boolean finishedWakeUp() {
        return this.getDayStartTicks() == 62;
    }

    private int getRandomChangeInterval() {
        return 800 + this.method_6051().method_43048(800);
    }

    public void barter() {
        if (this.isBartering()) {
            return;
        }
        this.method_37908().method_8421((class_1297)this, (byte)9);
        this.changeStateTicks = this.getRandomChangeInterval();
        this.barteringTicks = 78;
    }

    @Override
    protected class_1269 method_5992(class_1657 player, class_1268 hand) {
        class_1799 stack = player.method_5998(hand);
        if (!this.method_37908().method_8608() && this.canBarterWith(stack)) {
            this.barteringTarget = player;
            this.method_6122(class_1268.field_5808, stack.method_7972());
            stack.method_7934(1);
            return class_1269.field_5812;
        }
        return super.method_5992(player, hand);
    }

    private List<class_1799> getBarterResponseItems() {
        class_1937 class_19372 = this.method_37908();
        if (class_19372 instanceof class_3218) {
            class_3218 level = (class_3218)class_19372;
            class_52 lootTable = level.method_8503().method_3857().getLootTable(BARTERING_LOOT);
            return lootTable.method_51878(new class_8567.class_8568(level).method_51874(class_181.field_1226, (Object)this).method_51875(class_173.field_22403));
        }
        return List.of();
    }

    private void throwItems(List<class_1799> stacks) {
        if (this.barteringTarget != null) {
            this.throwItemsTowardPlayer(this.barteringTarget, stacks);
        } else {
            this.throwItemsTowardRandomPos(stacks);
        }
    }

    private void throwItemsTowardRandomPos(List<class_1799> stacks) {
        this.throwItemsTowardPos(stacks, this.getRandomNearbyPos());
    }

    private void throwItemsTowardPlayer(class_1657 player, List<class_1799> stacks) {
        this.throwItemsTowardPos(stacks, player.method_19538());
    }

    private void throwItemsTowardPos(List<class_1799> stacks, class_243 pos) {
        for (class_1799 stack : stacks) {
            class_4215.method_19949((class_1309)this, (class_1799)stack, (class_243)pos.method_1031(0.0, 1.0, 0.0));
        }
    }

    private class_243 getRandomNearbyPos() {
        class_243 vec3 = class_5534.method_31527((class_1314)this, (int)4, (int)2);
        return vec3 == null ? this.method_19538() : vec3;
    }

    private class BarrelGolemPanicGoal
    extends class_1374 {
        public BarrelGolemPanicGoal(double speedModifier) {
            super((class_1314)BarrelGolem.this, speedModifier);
        }

        public boolean method_6264() {
            return BarrelGolem.this.isOpen() && super.method_6264();
        }

        public void method_6270() {
            super.method_6270();
            BarrelGolem.this.setOpen(false, true);
        }
    }

    private class BarrelGolemFindNearestEmeraldGoal
    extends class_1352 {
        private class_1542 nearest;

        private BarrelGolemFindNearestEmeraldGoal() {
        }

        public boolean method_6264() {
            class_1542 nearest;
            if (BarrelGolem.this.isOpen() && !BarrelGolem.this.isBartering() && (nearest = (class_1542)BarrelGolem.this.method_37908().method_8390(class_1542.class, BarrelGolem.this.method_5829().method_1014(16.0), stack -> BarrelGolem.this.method_20820(stack.method_6983())).stream().findFirst().orElse(null)) != null) {
                this.nearest = nearest;
                return true;
            }
            return false;
        }

        public boolean method_6266() {
            return BarrelGolem.this.isOpen() && !BarrelGolem.this.isBartering() && this.nearest != null && !this.nearest.method_31481();
        }

        public void method_6268() {
            BarrelGolem.this.field_6189.method_6335((class_1297)this.nearest, 0.7);
            BarrelGolem.this.field_6206.method_6226((class_1297)this.nearest, 30.0f, 30.0f);
        }
    }
}

