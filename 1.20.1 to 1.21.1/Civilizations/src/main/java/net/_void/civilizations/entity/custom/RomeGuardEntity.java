/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1282
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1296
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1314
 *  net.minecraft.class_1315
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1376
 *  net.minecraft.class_1379
 *  net.minecraft.class_1400
 *  net.minecraft.class_1429
 *  net.minecraft.class_156
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2487
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3730
 *  net.minecraft.class_4050
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5425
 *  net.minecraft.class_5819
 *  net.minecraft.class_7094
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.entity.custom;

import net._void.civilizations.entity.ModEntities;
import net._void.civilizations.entity.ai.RomeGuardAttackGoal;
import net._void.civilizations.entity.custom.RomeBossEntity;
import net._void.civilizations.entity.custom.RomeGuardVariant;
import net.minecraft.class_1266;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1314;
import net.minecraft.class_1315;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1376;
import net.minecraft.class_1379;
import net.minecraft.class_1400;
import net.minecraft.class_1429;
import net.minecraft.class_156;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3730;
import net.minecraft.class_4050;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5425;
import net.minecraft.class_5819;
import net.minecraft.class_7094;
import org.jetbrains.annotations.Nullable;

public class RomeGuardEntity
extends class_1429 {
    private static final class_2940<Boolean> ATTACKING = class_2945.method_12791(RomeGuardEntity.class, (class_2941)class_2943.field_13323);
    public final class_7094 idleAnimationState = new class_7094();
    private int idleAnimationTimeout = 0;
    public final class_7094 attackAnimationState = new class_7094();
    public int attackAnimationTimeout = 0;
    private static final class_2940<Integer> DATA_ID_TYPE_VARIANT = class_2945.method_12791(RomeGuardEntity.class, (class_2941)class_2943.field_13327);

    public RomeGuardEntity(class_1299<? extends class_1429> entityType, class_1937 world) {
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
            this.attackAnimationTimeout = 10;
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
        this.field_6201.method_6277(1, (class_1352)new RomeGuardAttackGoal((class_1314)this, 1.0, true));
        this.field_6201.method_6277(2, (class_1352)new class_1379((class_1314)this, 1.0));
        this.field_6201.method_6277(3, (class_1352)new class_1361((class_1308)this, class_1657.class, 5.0f));
        this.field_6201.method_6277(4, (class_1352)new class_1376((class_1308)this));
        this.field_6185.method_6277(2, (class_1352)new class_1400((class_1308)this, RomeBossEntity.class, false));
    }

    public static class_5132.class_5133 createCivilianAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23724, 1.0).method_26868(class_5134.field_23721, 2.0).method_26868(class_5134.field_23719, 0.25).method_26868(class_5134.field_23717, 40.0);
    }

    public void method_19540(boolean attacking) {
        this.field_6011.method_12778(ATTACKING, (Object)attacking);
    }

    public boolean method_6510() {
        return (Boolean)this.field_6011.method_12789(ATTACKING);
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
        RomeGuardEntity baby = (RomeGuardEntity)ModEntities.ROME_GUARD.method_5883((class_1937)world);
        RomeGuardVariant variant = (RomeGuardVariant)((Object)class_156.method_27173((Object[])RomeGuardVariant.values(), (class_5819)this.field_5974));
        baby.setVariant(variant);
        return baby;
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ATTACKING, (Object)false);
        this.field_6011.method_12784(DATA_ID_TYPE_VARIANT, (Object)1);
    }

    public void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        nbt.method_10569("Variant", this.getTypeVariant());
    }

    public void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        this.field_6011.method_12778(DATA_ID_TYPE_VARIANT, (Object)nbt.method_10550("Variant"));
    }

    public class_1315 method_5943(class_5425 world, class_1266 difficulty, class_3730 spawnReason, @Nullable class_1315 entityData, @Nullable class_2487 entityNbt) {
        RomeGuardVariant variant = (RomeGuardVariant)((Object)class_156.method_27173((Object[])RomeGuardVariant.values(), (class_5819)this.field_5974));
        this.setVariant(variant);
        return super.method_5943(world, difficulty, spawnReason, entityData, entityNbt);
    }

    public RomeGuardVariant getVariant() {
        return RomeGuardVariant.byId(this.getTypeVariant() & 0xFF);
    }

    private int getTypeVariant() {
        return (Integer)this.field_6011.method_12789(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(RomeGuardVariant variant) {
        this.field_6011.method_12778(DATA_ID_TYPE_VARIANT, (Object)(variant.getId() & 0xFF));
    }

    public void method_6078(class_1282 damageSource) {
        super.method_6078(damageSource);
        class_1297 class_12972 = damageSource.method_5529();
        if (class_12972 instanceof RomeBossEntity) {
            RomeBossEntity boss = (RomeBossEntity)class_12972;
            boss.method_6092(new class_1293(class_1294.field_5910, 100, 2));
            boss.method_6092(new class_1293(class_1294.field_5924, 100, 4));
            ++boss.guardsKilled;
        }
    }

    public boolean method_5931(class_1657 player) {
        return false;
    }
}

