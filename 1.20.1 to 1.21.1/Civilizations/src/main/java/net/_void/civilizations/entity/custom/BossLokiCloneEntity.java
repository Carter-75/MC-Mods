/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1296
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1314
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1399
 *  net.minecraft.class_1429
 *  net.minecraft.class_1657
 *  net.minecraft.class_1690
 *  net.minecraft.class_1937
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_4050
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_7094
 *  net.minecraft.class_8111
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.entity.custom;

import net._void.civilizations.entity.ai.BossLokiCloneAttackGoal;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1314;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1399;
import net.minecraft.class_1429;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_1937;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_4050;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7094;
import net.minecraft.class_8111;
import org.jetbrains.annotations.Nullable;

public class BossLokiCloneEntity
extends class_1429 {
    private static final class_2940<Boolean> ATTACK = class_2945.method_12791(BossLokiCloneEntity.class, (class_2941)class_2943.field_13323);
    public final class_7094 idleAnimationState = new class_7094();
    private int idleAnimationTimeout = 0;
    public final class_7094 attackAnimationState = new class_7094();
    public int attackAnimationTimeout = 0;

    public BossLokiCloneEntity(class_1299<? extends class_1429> entityType, class_1937 world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.field_5974.method_43048(40) + 80;
            this.idleAnimationState.method_41322(this.field_6012);
        } else {
            --this.idleAnimationTimeout;
        }
        if (this.method_6510() && this.attackAnimationTimeout <= 0) {
            this.attackAnimationTimeout = 20;
            this.attackAnimationState.method_41322(this.field_6012);
        } else {
            --this.attackAnimationTimeout;
        }
        if (!this.method_6510()) {
            this.attackAnimationState.method_41325();
        }
    }

    protected void method_48565(float posDelta) {
        float f = this.method_18376() == class_4050.field_18076 ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.field_42108.method_48568(f, 0.2f);
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_37908().method_8608()) {
            this.setupAnimationStates();
        }
    }

    protected void method_5959() {
        this.field_6201.method_6277(0, (class_1352)new class_1347((class_1308)this));
        this.field_6201.method_6277(1, (class_1352)new BossLokiCloneAttackGoal((class_1314)this, 1.0, true));
        this.field_6185.method_6277(1, (class_1352)new class_1399((class_1314)this, new Class[0]));
    }

    public static class_5132.class_5133 createBossAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23724, 5.0).method_26868(class_5134.field_23721, 10.0).method_26868(class_5134.field_23719, 0.0).method_26868(class_5134.field_23717, 75.0).method_26868(class_5134.field_23718, 2.0);
    }

    public void method_19540(boolean attacking) {
        this.field_6011.method_12778(ATTACK, (Object)attacking);
    }

    public boolean method_6510() {
        return (Boolean)this.field_6011.method_12789(ATTACK);
    }

    @Nullable
    protected class_3414 method_5994() {
        return super.method_5994();
    }

    @Nullable
    protected class_3414 method_6011(class_1282 source) {
        return super.method_6011(source);
    }

    @Nullable
    protected class_3414 method_6002() {
        return super.method_6002();
    }

    @Nullable
    public class_1296 method_5613(class_3218 world, class_1296 entity) {
        return null;
    }

    protected void method_5958() {
        class_1657 player;
        class_1297 class_12972;
        super.method_5958();
        if (this.method_5809()) {
            this.method_33572(false);
        }
        if ((class_12972 = this.method_5854()) instanceof class_1690) {
            class_1690 boatEntity = (class_1690)class_12972;
            boatEntity.method_5768();
        }
        if ((player = this.method_37908().method_18459(this.method_23317(), this.method_23318(), this.method_23321(), 75.0, true)) != null) {
            this.method_5988().method_20248(player.method_23317(), player.method_23320(), player.method_23321());
        }
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ATTACK, (Object)false);
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (source.method_49708(class_8111.field_42335) || source.method_49708(class_8111.field_42337) || source.method_49708(class_8111.field_42338) || source.method_49708(class_8111.field_42342) || source.method_49708(class_8111.field_42340)) {
            return false;
        }
        class_1297 class_12972 = source.method_5529();
        if (class_12972 instanceof class_1657) {
            class_1657 player = (class_1657)class_12972;
            if (amount >= 3.0f) {
                int i = (int)(Math.random() * 6.0 + 1.0);
                switch (i) {
                    case 1: {
                        player.method_6092(new class_1293(class_1294.field_5899, 80));
                        break;
                    }
                    case 2: {
                        player.method_6092(new class_1293(class_1294.field_5920, 80));
                        break;
                    }
                    case 3: {
                        player.method_6092(new class_1293(class_1294.field_5909, 80));
                        break;
                    }
                    case 4: {
                        player.method_6092(new class_1293(class_1294.field_5901, 80));
                        break;
                    }
                    case 5: {
                        player.method_6092(new class_1293(class_1294.field_5911, 80));
                        break;
                    }
                    case 6: {
                        player.method_6092(new class_1293(class_1294.field_5903, 80));
                    }
                }
            }
        }
        return super.method_5643(source, amount);
    }

    public boolean method_5810() {
        return false;
    }

    public boolean method_5931(class_1657 player) {
        return false;
    }
}

