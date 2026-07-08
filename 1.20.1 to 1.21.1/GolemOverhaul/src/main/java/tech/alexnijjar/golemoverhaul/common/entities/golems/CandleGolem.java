/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1352
 *  net.minecraft.class_1381
 *  net.minecraft.class_1409
 *  net.minecraft.class_1427
 *  net.minecraft.class_1439$class_4621
 *  net.minecraft.class_1603
 *  net.minecraft.class_1657
 *  net.minecraft.class_1778
 *  net.minecraft.class_1786
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2487
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_8103
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.core.object.PlayState
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import net.minecraft.class_11;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1381;
import net.minecraft.class_1409;
import net.minecraft.class_1427;
import net.minecraft.class_1439;
import net.minecraft.class_1603;
import net.minecraft.class_1657;
import net.minecraft.class_1778;
import net.minecraft.class_1786;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_8103;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantAnimations;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.CandleFlameProjectile;
import tech.alexnijjar.golemoverhaul.common.tags.ModItemTags;

public class CandleGolem
extends BaseGolem
implements class_1603 {
    private static final float HEALTH_LOSS_PER_SHOT = 0.02f;
    private static final class_2940<Boolean> ID_LIT = class_2945.method_12791(CandleGolem.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> ID_SITTING = class_2945.method_12791(CandleGolem.class, (class_2941)class_2943.field_13323);
    private final class_1381 rangedAttackGoal = new CandleGolemRangedAttackGoal(this, 1.0, 20, 15.0f);

    public CandleGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 4;
        this.field_6189 = new CandleGolemGroundPathNavigation();
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 15.0).method_26868(class_5134.field_23719, 0.3).method_26868(class_5134.field_23721, 3.0);
    }

    @Override
    public PlayState getMoveAnimation(AnimationState<BaseGolem> state, boolean moving) {
        return state.setAndContinue(moving ? ConstantAnimations.WALK : (this.isSitting() ? ConstantAnimations.SITTING_IDLE : ConstantAnimations.IDLE));
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_LIT, (Object)false);
        this.field_6011.method_12784(ID_SITTING, (Object)false);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10556("Lit", this.isLit());
        compound.method_10556("Sitting", this.isSitting());
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setLit(compound.method_10577("Lit"));
        this.setSitting(compound.method_10577("Sitting"));
    }

    @Override
    public boolean canMeleeAttack() {
        return !this.canBeLit();
    }

    @Override
    public boolean canTarget() {
        return this.isLit() || !this.canBeLit();
    }

    public boolean isLit() {
        return this.canBeLit() && (Boolean)this.field_6011.method_12789(ID_LIT) != false;
    }

    public void setLit(boolean lit) {
        this.field_6011.method_12778(ID_LIT, (Object)lit);
        this.field_6201.method_6280((class_1352)this.rangedAttackGoal);
        if (lit) {
            this.field_6201.method_6277(2, (class_1352)this.rangedAttackGoal);
        }
        this.updateAttackGoals();
    }

    public boolean isSitting() {
        return (Boolean)this.field_6011.method_12789(ID_SITTING);
    }

    public void setSitting(boolean sitting) {
        this.field_6011.method_12778(ID_SITTING, (Object)sitting);
        this.method_5996(class_5134.field_23718).method_6192(sitting ? 1.0 : 0.0);
    }

    public boolean canBeLit() {
        return this.getCrackiness() != class_1439.class_4621.field_21084;
    }

    @Override
    public boolean hasAttackAnimation() {
        return false;
    }

    public void method_5730() {
        super.method_5730();
        this.setLit(true);
    }

    protected void method_6074(class_1282 damageSource, float damageAmount) {
        if (damageSource.method_48789(class_8103.field_42246)) {
            this.setLit(true);
        }
        if (this.isSitting()) {
            damageAmount *= 0.1f;
        }
        super.method_6074(damageSource, damageAmount);
        this.updateAttackGoals();
    }

    public void method_46395() {
        super.method_46395();
        if (this.isLit()) {
            this.setLit(false);
            this.method_5783(class_3417.field_15102, 1.0f, 2.0f);
        }
    }

    @Override
    public int getAttackTicks() {
        return 10;
    }

    @Override
    public boolean canRepair(class_1799 stack) {
        return stack.method_31573(ModItemTags.WAX);
    }

    @Override
    public float getRepairItemHealAmount() {
        return 5.0f;
    }

    @Override
    public class_3414 getRepairSound() {
        return class_3417.field_29543;
    }

    public void method_7105(class_1309 target, float velocity) {
        CandleFlameProjectile projectile = new CandleFlameProjectile(this.method_37908(), (class_1309)this);
        projectile.method_5814(this.method_23317(), this.method_23318() + 0.5, this.method_23321());
        double x = target.method_23317() - this.method_23317();
        double y = target.method_23318() - projectile.method_23318();
        double z = target.method_23321() - this.method_23321();
        double distance = Math.sqrt(x * x + z * z) * 0.2;
        projectile.method_7485(x, y + distance, z, 0.4f, 5.0f);
        this.method_37908().method_8649((class_1297)projectile);
        this.method_37908().method_43128(null, this.method_23317(), this.method_23318(), this.method_23321(), class_3417.field_14970, this.method_5634(), 0.3f, this.field_5974.method_43057() * 0.4f + 0.8f);
        this.method_6033(this.method_6032() - 0.02f);
    }

    public void method_5773() {
        if (this.isSitting()) {
            this.method_18800(0.0, this.method_18798().method_10214(), 0.0);
            this.field_6189.method_6340();
        }
        super.method_5773();
        if (this.method_37908().method_8608()) {
            if (this.isLit() && this.field_6012 % 10 == 0) {
                this.method_37908().method_8406((class_2394)class_2398.field_11240, this.method_23317(), this.method_23318() + 0.4, this.method_23321(), 0.0, 0.02, 0.0);
            }
        } else if (this.method_5721()) {
            this.setLit(false);
        }
    }

    @Override
    @NotNull
    protected class_1269 method_5992(class_1657 player, @NotNull class_1268 hand) {
        if (super.method_5992(player, hand).method_23665()) {
            return class_1269.field_5812;
        }
        if (this.method_37908().method_8608()) {
            return class_1269.field_5812;
        }
        class_1799 stack = player.method_5998(hand);
        if (!player.method_5715() && stack.method_7960()) {
            this.setSitting(!this.isSitting());
            return class_1269.field_5812;
        }
        if (this.isLit()) {
            if (stack.method_7960()) {
                this.method_46395();
                return class_1269.field_5812;
            }
        } else if (this.canBeLit()) {
            if (stack.method_7909() instanceof class_1786) {
                stack.method_7956(1, (class_1309)player, p -> p.method_20236(hand));
                this.method_43077(class_3417.field_15145);
                this.setLit(true);
                return class_1269.field_5812;
            }
            if (stack.method_7909() instanceof class_1778) {
                stack.method_7934(1);
                this.method_43077(class_3417.field_15013);
                this.setLit(true);
                return class_1269.field_5812;
            }
        }
        return class_1269.field_5811;
    }

    @Override
    protected class_238 getAttackBoundingBox() {
        return super.getAttackBoundingBox().method_1009(0.25, 0.0, 0.25);
    }

    private class CandleGolemRangedAttackGoal
    extends class_1381 {
        public CandleGolemRangedAttackGoal(class_1603 rangedAttackMob, double speedModifier, int attackInterval, float attackRadius) {
            super(rangedAttackMob, speedModifier, attackInterval, attackRadius);
        }

        public boolean method_6264() {
            return CandleGolem.this.canBeLit() && super.method_6264();
        }
    }

    private class CandleGolemGroundPathNavigation
    extends class_1409 {
        public CandleGolemGroundPathNavigation() {
            super((class_1308)CandleGolem.this, CandleGolem.this.method_37908());
        }

        protected boolean method_6358() {
            return !CandleGolem.this.isSitting() && super.method_6358();
        }

        public boolean method_6334(@Nullable class_11 path, double speed) {
            return !CandleGolem.this.isSitting() && super.method_6334(path, speed);
        }
    }
}

