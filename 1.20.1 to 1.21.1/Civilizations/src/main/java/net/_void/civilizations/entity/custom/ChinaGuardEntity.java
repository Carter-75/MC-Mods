/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1296
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1314
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1379
 *  net.minecraft.class_1399
 *  net.minecraft.class_1400
 *  net.minecraft.class_1429
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1935
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

import net._void.civilizations.entity.ai.ChinaGuardShootGoal;
import net._void.civilizations.item.ModItems;
import net.minecraft.class_1282;
import net.minecraft.class_1296;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1314;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1379;
import net.minecraft.class_1399;
import net.minecraft.class_1400;
import net.minecraft.class_1429;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1935;
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

public class ChinaGuardEntity
extends class_1429 {
    private static final class_2940<Boolean> SHOOTING = class_2945.method_12791(ChinaGuardEntity.class, (class_2941)class_2943.field_13323);
    public final class_7094 idleAnimationState = new class_7094();
    private int idleAnimationTimeout = 0;
    public final class_7094 shootingAnimationState = new class_7094();
    public int shootingAnimationTimeout = 0;

    public ChinaGuardEntity(class_1299<? extends class_1429> entityType, class_1937 world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.field_5974.method_43048(40) + 80;
            this.idleAnimationState.method_41322(this.field_6012);
        } else {
            --this.idleAnimationTimeout;
        }
        if (this.isShooting() && this.shootingAnimationTimeout <= 0) {
            this.shootingAnimationTimeout = 10;
            this.shootingAnimationState.method_41322(this.field_6012);
        } else {
            --this.shootingAnimationTimeout;
        }
        if (!this.isShooting()) {
            this.shootingAnimationState.method_41325();
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
        this.field_6201.method_6277(1, (class_1352)new ChinaGuardShootGoal((class_1314)this));
        this.field_6201.method_6277(2, (class_1352)new class_1379((class_1314)this, 1.0));
        this.field_6185.method_6277(1, (class_1352)new class_1399((class_1314)this, new Class[0]));
        this.field_6185.method_6277(2, (class_1352)new class_1400((class_1308)this, class_1657.class, false));
    }

    public static class_5132.class_5133 createGuardAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23724, 2.0).method_26868(class_5134.field_23721, 3.0).method_26868(class_5134.field_23719, 0.25).method_26868(class_5134.field_23717, 30.0);
    }

    public void setShooting(boolean shooting) {
        this.field_6011.method_12778(SHOOTING, (Object)shooting);
    }

    public boolean isShooting() {
        return (Boolean)this.field_6011.method_12789(SHOOTING);
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

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(SHOOTING, (Object)false);
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (source.method_49708(class_8111.field_42321)) {
            return false;
        }
        return super.method_5643(source, amount);
    }

    protected void method_6099(class_1282 source, int lootingMultiplier, boolean allowDrops) {
        super.method_6099(source, lootingMultiplier, allowDrops);
        class_1542 itemEntity = this.method_5706((class_1935)ModItems.CHINA_KEY_FRAGMENT);
        if (itemEntity != null) {
            itemEntity.method_6976();
        }
    }

    public boolean method_5931(class_1657 player) {
        return false;
    }
}

