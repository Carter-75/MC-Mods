/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1296
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1429
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_4050
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_7094
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.entity.custom;

import net._void.civilizations.entity.ModEntities;
import net.minecraft.class_1282;
import net.minecraft.class_1296;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1429;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_4050;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7094;
import org.jetbrains.annotations.Nullable;

public class EgyptNpcEntity
extends class_1429 {
    public final class_7094 idleAnimationState = new class_7094();
    private int idleAnimationTimeout = 0;

    public EgyptNpcEntity(class_1299<? extends class_1429> entityType, class_1937 world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.field_5974.method_43048(40) + 80;
            this.idleAnimationState.method_41322(this.field_6012);
        } else {
            --this.idleAnimationTimeout;
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
        this.field_6201.method_6277(0, (class_1352)new class_1361((class_1308)this, class_1657.class, 5.0f));
    }

    public static class_5132.class_5133 createNpcAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 100.0).method_26868(class_5134.field_23724, 5.0).method_26868(class_5134.field_23717, 20.0).method_26868(class_5134.field_23718, 0.5);
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
        return (class_1296)ModEntities.EGYPT_NPC.method_5883((class_1937)world);
    }

    public boolean method_5931(class_1657 player) {
        return false;
    }
}

