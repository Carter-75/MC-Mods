/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1379
 *  net.minecraft.class_1400
 *  net.minecraft.class_1588
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2520
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2945$class_9222
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_7
 */
package backported.updates.garden.entity;

import backported.updates.garden.Init;
import backported.updates.garden.entity.CreakingHeartBlockEntity;
import backported.updates.garden.entity.ai.goal.CreakingMeleeAttackGoal;
import net.minecraft.class_1282;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1379;
import net.minecraft.class_1400;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2520;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7;

public class CreakingEntity
extends class_1588 {
    private static final class_2940<Boolean> IS_HEART_SPAWN = class_2945.method_12791(CreakingEntity.class, (class_2941)class_2943.field_13323);
    public boolean isHeartSpawn = false;
    public boolean deathLock = false;
    public class_2338 boundHeart;

    public CreakingEntity(class_1299<? extends class_1588> entityType, class_1937 world) {
        super(entityType, world);
        this.method_5941(class_7.field_18, -1.0f);
    }

    public static class_5132.class_5133 createMobAttributes() {
        return class_1588.method_26828().method_26868(class_5134.field_23716, 1.0).method_26868(class_5134.field_23722, 0.0).method_26868(class_5134.field_23719, 0.25).method_26868(class_5134.field_23721, 6.0);
    }

    public boolean isHeartNear() {
        if (this.boundHeart != null && this.method_37908().method_8320(this.boundHeart).method_26204() == Init.CREAKING_HEART) {
            class_243 heartPos;
            class_243 entityPos = this.method_19538();
            double distance = entityPos.method_1022(heartPos = new class_243((double)this.boundHeart.method_10263(), (double)this.boundHeart.method_10264(), (double)this.boundHeart.method_10260()));
            if (distance <= 34.0) {
                class_2586 blockEntity = this.method_37908().method_8321(this.boundHeart);
                if (blockEntity instanceof CreakingHeartBlockEntity) {
                    ((CreakingHeartBlockEntity)blockEntity).creakingEntity = this;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_37908().method_8608()) {
            return;
        }
        class_2586 blockEntity = this.method_37908().method_8321(this.method_24515());
        if (blockEntity instanceof CreakingHeartBlockEntity) {
            CreakingHeartBlockEntity creakingHeartBlockEntity = (CreakingHeartBlockEntity)blockEntity;
            creakingHeartBlockEntity.creakingEntity = this;
        }
        boolean isHeartNear = this.isHeartNear();
        if (this.isHeartSpawn && this.method_37908().method_8530() && !this.method_37908().method_8546() || this.isHeartSpawn && !isHeartNear) {
            this.deathLock = true;
            this.method_5768();
        }
    }

    protected void method_5693(class_2945.class_9222 builder) {
        super.method_5693(builder);
        builder.method_56912(IS_HEART_SPAWN, (Object)false);
    }

    public void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        nbt.method_10556("is_heart_spawn", this.isHeartSpawn);
        if (this.boundHeart != null) {
            class_2487 heartNbt = new class_2487();
            heartNbt.method_10569("x", this.boundHeart.method_10263());
            heartNbt.method_10569("y", this.boundHeart.method_10264());
            heartNbt.method_10569("z", this.boundHeart.method_10260());
            nbt.method_10566("bound_heart", (class_2520)heartNbt);
        }
    }

    public void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        this.isHeartSpawn = nbt.method_10577("is_heart_spawn");
        if (nbt.method_10573("bound_heart", 10)) {
            class_2487 heartNbt = nbt.method_10562("bound_heart");
            this.boundHeart = new class_2338(heartNbt.method_10550("x"), heartNbt.method_10550("y"), heartNbt.method_10550("z"));
        }
    }

    protected void method_5959() {
        this.field_6201.method_6277(1, (class_1352)new CreakingMeleeAttackGoal((class_1314)this, 1.0, true));
        this.field_6201.method_6277(2, (class_1352)new class_1379((class_1314)this, 0.7));
        this.field_6201.method_6277(3, (class_1352)new class_1361((class_1308)this, class_1657.class, 32.0f));
        this.field_6185.method_6277(0, (class_1352)new class_1400((class_1308)this, class_1657.class, false));
    }

    public void method_6078(class_1282 damageSource) {
        class_2586 blockEntity;
        super.method_6078(damageSource);
        if (this.boundHeart != null && (blockEntity = this.method_37908().method_8321(this.boundHeart)) instanceof CreakingHeartBlockEntity) {
            ((CreakingHeartBlockEntity)blockEntity).creakingEntity = null;
        }
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (this.isHeartSpawn && this.isHeartNear() && (this.method_37908().method_23886() || this.method_37908().method_8546())) {
            class_2680 blockState = this.method_37908().method_8320(this.boundHeart);
            class_2586 blockEntity = this.method_37908().method_8321(this.boundHeart);
            class_2248 block = blockState.method_26204();
            if (blockEntity instanceof CreakingHeartBlockEntity) {
                ((CreakingHeartBlockEntity)blockEntity).trySpawnResin();
            }
            return false;
        }
        return super.method_5643(source, amount);
    }

    protected class_3414 method_5994() {
        return class_3417.field_15200;
    }

    protected class_3414 method_6011(class_1282 source) {
        return class_3417.field_15069;
    }

    protected class_3414 method_6002() {
        return class_3417.field_14877;
    }
}

