/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1315
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1366
 *  net.minecraft.class_1376
 *  net.minecraft.class_1379
 *  net.minecraft.class_1399
 *  net.minecraft.class_1400
 *  net.minecraft.class_1427
 *  net.minecraft.class_1439
 *  net.minecraft.class_1439$class_4621
 *  net.minecraft.class_1473
 *  net.minecraft.class_1548
 *  net.minecraft.class_1569
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_2487
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3730
 *  net.minecraft.class_5425
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.animatable.GeoEntity
 *  software.bernie.geckolib.core.animatable.GeoAnimatable
 *  software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache
 *  software.bernie.geckolib.core.animation.AnimatableManager$ControllerRegistrar
 *  software.bernie.geckolib.core.animation.AnimationController
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.core.object.PlayState
 *  software.bernie.geckolib.util.GeckoLibUtil
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems.base;

import net.minecraft.class_1266;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1315;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1366;
import net.minecraft.class_1376;
import net.minecraft.class_1379;
import net.minecraft.class_1399;
import net.minecraft.class_1400;
import net.minecraft.class_1427;
import net.minecraft.class_1439;
import net.minecraft.class_1473;
import net.minecraft.class_1548;
import net.minecraft.class_1569;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2487;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3730;
import net.minecraft.class_5425;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantAnimations;

public abstract class BaseGolem
extends class_1427
implements GeoEntity {
    public static final byte ATTACK_EVENT_ID = 4;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache((GeoAnimatable)this);
    private final class_1366 meleeAttackGoal = new class_1366((class_1314)this, 1.0, true);
    private final class_1399 hurtByTargetGoal = new class_1399((class_1314)this, new Class[]{BaseGolem.class});
    private final class_1400<class_1308> attackTargetGoal = new class_1400((class_1308)this, class_1308.class, 5, true, false, this::shouldAttack);
    protected int attackAnimationTicks;
    protected int attackDelayTicks = -1;
    private static final double DEFAULT_ATTACK_REACH = Math.sqrt(2.04f) - (double)0.6f;

    protected BaseGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.updateAttackGoals();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController[]{this.getMovementController()});
        controllers.add(new AnimationController[]{new AnimationController((GeoAnimatable)this, "attack_controller", 0, state -> {
            if (!this.hasAttackAnimation()) {
                return PlayState.STOP;
            }
            if (this.attackAnimationTicks == 0) {
                state.resetCurrentAnimation();
                return PlayState.STOP;
            }
            return this.getAttackAnimation((AnimationState<? extends BaseGolem>)state);
        })});
    }

    public AnimationController<?> getMovementController() {
        return new AnimationController((GeoAnimatable)this, this::handleMovementController);
    }

    public PlayState handleMovementController(AnimationState<BaseGolem> state) {
        boolean moving = (double)state.getLimbSwingAmount() > 0.05 || (double)state.getLimbSwingAmount() < -0.05;
        return this.getMoveAnimation(state, moving);
    }

    public PlayState getMoveAnimation(AnimationState<BaseGolem> state, boolean moving) {
        return state.setAndContinue(moving ? ConstantAnimations.WALK : ConstantAnimations.IDLE);
    }

    public PlayState getAttackAnimation(AnimationState<? extends BaseGolem> state) {
        return state.setAndContinue(ConstantAnimations.ATTACK);
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    protected void method_5959() {
        if (this.canFloatInWater()) {
            this.field_6201.method_6277(0, (class_1352)new class_1347((class_1308)this));
        }
        this.field_6201.method_6277(4, (class_1352)new class_1379((class_1314)this, 1.0));
        this.field_6201.method_6277(7, (class_1352)new class_1361((class_1308)this, class_1657.class, 6.0f));
        this.field_6201.method_6277(8, (class_1352)new class_1376((class_1308)this));
    }

    public boolean method_18395(class_1309 target) {
        return super.method_18395(target) && !(target instanceof BaseGolem) && !(target instanceof class_1439) && !(target instanceof class_1473);
    }

    public final void updateAttackGoals() {
        this.field_6201.method_6280((class_1352)this.meleeAttackGoal);
        this.field_6185.method_6280((class_1352)this.hurtByTargetGoal);
        this.field_6185.method_6280(this.attackTargetGoal);
        if (this.canMeleeAttack()) {
            this.field_6201.method_6277(2, (class_1352)this.meleeAttackGoal);
        }
        if (this.canTarget()) {
            this.field_6185.method_6277(1, (class_1352)this.hurtByTargetGoal);
            this.field_6185.method_6277(3, this.attackTargetGoal);
        }
    }

    public boolean canMeleeAttack() {
        return this.canTarget();
    }

    public boolean canTarget() {
        return true;
    }

    public boolean shouldAttack(class_1309 entity) {
        return entity instanceof class_1569 && !(entity instanceof class_1548);
    }

    public class_1439.class_4621 getCrackiness() {
        float fraction = this.method_6032() / this.method_6063();
        if ((double)fraction > 0.66) {
            return class_1439.class_4621.field_21081;
        }
        if ((double)fraction > 0.33) {
            return class_1439.class_4621.field_21083;
        }
        return class_1439.class_4621.field_21084;
    }

    public boolean method_6121(@NotNull class_1297 target) {
        if (this.isAttacking()) {
            return false;
        }
        this.startAttacking();
        this.sendAttackEvent();
        return this.hasDelayedAttack() || super.method_6121(target);
    }

    public void startAttacking() {
        if (this.isAttacking()) {
            return;
        }
        this.attackAnimationTicks = this.getAttackTicks();
        if (this.hasDelayedAttack()) {
            this.attackDelayTicks = this.getAttackDelayTicks();
        }
    }

    public boolean isAttacking() {
        return this.attackAnimationTicks > 0 || this.attackDelayTicks > 0;
    }

    public void sendAttackEvent() {
        this.method_37908().method_8421((class_1297)this, (byte)4);
    }

    public void method_5711(byte id) {
        super.method_5711(id);
        if (id == 4) {
            this.startAttacking();
        }
    }

    private void tickAttackDelay() {
        class_1309 target = this.method_5968();
        if (this.attackDelayTicks == 0) {
            if (target != null && this.method_42150(target)) {
                this.actuallyAttackAfterDelay(target);
            }
            this.performAdditionalAttacks(target);
            this.attackDelayTicks = -1;
        }
    }

    public void actuallyAttackAfterDelay(class_1309 target) {
        super.method_6121((class_1297)target);
    }

    public void performAdditionalAttacks(class_1309 target) {
    }

    public boolean canFloatInWater() {
        return true;
    }

    public boolean hasAttackAnimation() {
        return true;
    }

    public int getAttackTicks() {
        return 0;
    }

    public int getAttackDelayTicks() {
        return 0;
    }

    public final boolean hasDelayedAttack() {
        return this.getAttackDelayTicks() > 0;
    }

    public class_1792 getRepairItem() {
        return class_1802.field_8162;
    }

    public abstract float getRepairItemHealAmount();

    public boolean canRepair(class_1799 stack) {
        return stack.method_31574(this.getRepairItem());
    }

    public class_3414 getRepairSound() {
        return class_3417.field_21077;
    }

    public final void removeAndAddDeathParticles() {
        this.method_37908().method_8421((class_1297)this, (byte)60);
        this.method_5650(class_1297.class_5529.field_26998);
    }

    public void method_6007() {
        super.method_6007();
        this.attackAnimationTicks = Math.max(0, this.attackAnimationTicks - 1);
        this.attackDelayTicks = Math.max(-1, this.attackDelayTicks - 1);
        if (this.hasDelayedAttack()) {
            this.tickAttackDelay();
        }
    }

    protected class_1269 method_5992(class_1657 player, class_1268 hand) {
        class_1799 stack = player.method_5998(hand);
        if (!this.canRepair(stack)) {
            return class_1269.field_5811;
        }
        float health = this.method_6032();
        this.method_6025(this.getRepairItemHealAmount());
        if (this.method_6032() == health) {
            return class_1269.field_5811;
        }
        float pitch = 1.0f + (this.field_5974.method_43057() - this.field_5974.method_43057()) * 0.2f;
        this.method_5783(this.getRepairSound(), 1.0f, pitch);
        if (!player.method_31549().field_7477) {
            stack.method_7934(1);
        }
        return class_1269.method_29236((boolean)this.method_37908().method_8608());
    }

    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.updateAttackGoals();
    }

    @Nullable
    public class_1315 method_5943(class_5425 level, class_1266 difficulty, class_3730 reason, @Nullable class_1315 spawnData, @Nullable class_2487 dataTag) {
        this.updateAttackGoals();
        return super.method_5943(level, difficulty, reason, spawnData, dataTag);
    }

    protected class_3414 method_6011(class_1282 damageSource) {
        return class_3417.field_14940;
    }

    protected class_3414 method_6002() {
        return class_3417.field_14732;
    }

    protected class_238 getAttackBoundingBox() {
        class_238 aabb;
        class_1297 vehicle = this.method_5854();
        if (vehicle != null) {
            class_238 vehicleAabb = vehicle.method_5829();
            class_238 selfAabb = this.method_5829();
            aabb = new class_238(Math.min(selfAabb.field_1323, vehicleAabb.field_1323), selfAabb.field_1322, Math.min(selfAabb.field_1321, vehicleAabb.field_1321), Math.max(selfAabb.field_1320, vehicleAabb.field_1320), selfAabb.field_1325, Math.max(selfAabb.field_1324, vehicleAabb.field_1324));
        } else {
            aabb = this.method_5829();
        }
        return aabb.method_1009(DEFAULT_ATTACK_REACH, 0.0, DEFAULT_ATTACK_REACH);
    }

    public boolean method_42150(class_1309 entity) {
        return this.getAttackBoundingBox().method_994(entity.method_5829());
    }
}

