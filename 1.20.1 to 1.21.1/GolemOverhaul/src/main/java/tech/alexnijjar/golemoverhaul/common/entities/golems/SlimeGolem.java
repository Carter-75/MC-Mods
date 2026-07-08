/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1315
 *  net.minecraft.class_1427
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1923
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_2919
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3730
 *  net.minecraft.class_4048
 *  net.minecraft.class_4050
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5281
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  net.minecraft.class_6908
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 *  software.bernie.geckolib.core.animation.AnimationController
 *  software.bernie.geckolib.core.animation.AnimationState
 *  software.bernie.geckolib.core.animation.RawAnimation
 *  software.bernie.geckolib.core.object.PlayState
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import java.util.Locale;
import net.minecraft.class_1266;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1315;
import net.minecraft.class_1427;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1923;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2919;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3730;
import net.minecraft.class_4048;
import net.minecraft.class_4050;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5281;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import net.minecraft.class_6908;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;
import tech.alexnijjar.golemoverhaul.common.constants.ConstantAnimations;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class SlimeGolem
extends BaseGolem {
    private static final class_2940<Byte> ID_SIZE = class_2945.method_12791(SlimeGolem.class, (class_2941)class_2943.field_13319);
    public static final class_4048 SMALL_DIMENSIONS = class_4048.method_18384((float)0.5f, (float)0.5f);
    @NotNull
    private RawAnimation attackArm = this.getRandomArmAnimation();

    public SlimeGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, (double)Size.LARGE.health).method_26868(class_5134.field_23719, Size.LARGE.speed).method_26868(class_5134.field_23722, Size.LARGE.knockback).method_26868(class_5134.field_23721, (double)Size.LARGE.attackDamage);
    }

    @Override
    public AnimationController<?> getMovementController() {
        return super.getMovementController().setSoundKeyframeHandler(event -> this.method_37908().method_45446(this.method_24515(), this.getStepSound(), this.method_5634(), 0.3f, 1.0f, false));
    }

    public static boolean checkSlimeSpawnRules(class_1299<? extends class_1308> type, class_1936 level, class_3730 spawnType, class_2338 pos, class_5819 random) {
        boolean isSlimeChunk;
        if (!GolemOverhaulConfig.spawnSlimeGolems || !GolemOverhaulConfig.allowSpawning) {
            return false;
        }
        if (spawnType == class_3730.field_16469) {
            return class_1308.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
        }
        if (level.method_23753(pos).method_40220(class_6908.field_37391) && pos.method_10264() > 50 && pos.method_10264() < 70 && random.method_43057() < 0.5f && random.method_43057() < level.method_30272() && level.method_22339(pos) <= random.method_43048(8)) {
            return SlimeGolem.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
        }
        if (!(level instanceof class_5281)) {
            return false;
        }
        class_1923 chunkpos = new class_1923(pos);
        boolean bl = isSlimeChunk = class_2919.method_12662((int)chunkpos.field_9181, (int)chunkpos.field_9180, (long)((class_5281)level).method_8412(), (long)987234911L).method_43048(10) == 0;
        if (random.method_43048(10) == 0 && isSlimeChunk && pos.method_10264() < 40) {
            return class_1308.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
        }
        return false;
    }

    @Override
    public PlayState getAttackAnimation(AnimationState<? extends BaseGolem> state) {
        return state.setAndContinue(this.attackArm);
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_SIZE, (Object)0);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10582("Size", this.getSize().name().toLowerCase(Locale.ROOT));
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        String sizeStr = compound.method_10558("Size").toUpperCase(Locale.ROOT);
        if (sizeStr.isEmpty()) {
            this.setSize(Size.LARGE, false);
        } else {
            this.setSize(Size.valueOf(sizeStr), false);
        }
    }

    public Size getSize() {
        return Size.values()[(Byte)this.field_6011.method_12789(ID_SIZE)];
    }

    public void setSize(Size size, boolean resetHealth) {
        this.field_6011.method_12778(ID_SIZE, (Object)((byte)size.ordinal()));
        this.method_23311();
        this.method_18382();
        this.method_5996(class_5134.field_23716).method_6192((double)size.health);
        this.method_5996(class_5134.field_23719).method_6192(size.speed);
        this.method_5996(class_5134.field_23722).method_6192(size.knockback);
        this.method_5996(class_5134.field_23721).method_6192((double)size.attackDamage);
        if (resetHealth) {
            this.method_6033(this.method_6063());
        }
        this.field_6194 = size.xpReward;
    }

    @Override
    protected class_3414 method_6011(class_1282 damageSource) {
        return this.getSize().isLarge() ? class_3417.field_15014 : class_3417.field_14620;
    }

    @Override
    protected class_3414 method_6002() {
        return this.getSize().isLarge() ? class_3417.field_14763 : class_3417.field_14849;
    }

    private class_3414 getStepSound() {
        return this.getSize().isLarge() ? class_3417.field_15014 : class_3417.field_14620;
    }

    @Override
    public boolean method_6121(@NotNull class_1297 target) {
        if (super.method_6121(target)) {
            this.method_5783(this.getSize().isLarge() ? class_3417.field_15095 : class_3417.field_15148, 1.0f, 1.0f);
            return true;
        }
        return false;
    }

    @Override
    public int getAttackTicks() {
        return 22;
    }

    @Override
    public class_1792 getRepairItem() {
        return class_1802.field_8777;
    }

    @Override
    public float getRepairItemHealAmount() {
        return 10.0f;
    }

    @Override
    public class_3414 getRepairSound() {
        return class_3417.field_15194;
    }

    public void method_5650(class_1297.class_5529 reason) {
        if (!this.method_37908().field_9236 && this.getSize().isLarge() && this.method_29504()) {
            class_2561 name = this.method_5797();
            boolean noAi = this.method_5987();
            float width = this.method_18377((class_4050)this.method_18376()).field_18067;
            float halfWidth = width / 2.0f;
            int amount = 2 + this.field_5974.method_43048(3);
            for (int i = 0; i < amount; ++i) {
                float x = ((float)(i % 2) - 0.5f) * halfWidth;
                float z = ((float)(i / 2) - 0.5f) * halfWidth;
                SlimeGolem slime = (SlimeGolem)((class_1299)ModEntityTypes.SLIME_GOLEM.get()).method_5883(this.method_37908());
                if (slime == null) continue;
                if (this.method_5947()) {
                    slime.method_5971();
                }
                slime.method_5665(name);
                slime.method_5977(noAi);
                slime.method_5684(this.method_5655());
                slime.setSize(Size.SMALL, true);
                slime.method_5808(this.method_23317() + (double)x, this.method_23318() + 0.5, this.method_23321() + (double)z, this.field_5974.method_43057() * 360.0f, 0.0f);
                this.method_37908().method_8649((class_1297)slime);
            }
        }
        super.method_5650(reason);
    }

    @Override
    @Nullable
    public class_1315 method_5943(class_5425 level, class_1266 difficulty, class_3730 reason, @Nullable class_1315 spawnData, @Nullable class_2487 dataTag) {
        this.setSize(level.method_8409().method_43056() ? Size.LARGE : Size.SMALL, true);
        return super.method_5943(level, difficulty, reason, spawnData, dataTag);
    }

    public class_4048 method_18377(class_4050 pose) {
        if (pose == class_4050.field_18078) {
            return field_18072;
        }
        if (this.getSize().isLarge()) {
            return super.method_18377(pose);
        }
        return SMALL_DIMENSIONS.method_18383(this.method_17825());
    }

    @Override
    public void method_5711(byte id) {
        super.method_5711(id);
        if (id == 4) {
            this.attackArm = this.getRandomArmAnimation();
        }
    }

    private RawAnimation getRandomArmAnimation() {
        return this.method_6051().method_43056() ? ConstantAnimations.ATTACK_RIGHT : ConstantAnimations.ATTACK_LEFT;
    }

    @Override
    protected class_238 getAttackBoundingBox() {
        return super.getAttackBoundingBox().method_1009(0.5, 0.0, 0.5);
    }

    public static enum Size {
        LARGE(50, 6, 0.24, 2.0, 0),
        SMALL(20, 3, 0.19, 1.0, 6);

        private final int health;
        private final int attackDamage;
        private final double speed;
        private final double knockback;
        private final int xpReward;

        private Size(int health, int attackDamage, double speed, double knockback, int xpReward) {
            this.health = health;
            this.attackDamage = attackDamage;
            this.speed = speed;
            this.knockback = knockback;
            this.xpReward = xpReward;
        }

        public boolean isLarge() {
            return this == LARGE;
        }
    }
}

