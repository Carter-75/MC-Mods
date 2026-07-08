/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  net.minecraft.class_1937
 *  net.minecraft.class_239
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_3417
 *  net.minecraft.class_3857
 *  net.minecraft.class_3966
 */
package tech.alexnijjar.golemoverhaul.common.entities.projectiles;

import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1937;
import net.minecraft.class_239;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_3417;
import net.minecraft.class_3857;
import net.minecraft.class_3966;
import tech.alexnijjar.golemoverhaul.common.entities.golems.CandleGolem;
import tech.alexnijjar.golemoverhaul.common.entities.golems.TerracottaGolem;
import tech.alexnijjar.golemoverhaul.common.registry.ModEntityTypes;

public class CandleFlameProjectile
extends class_3857 {
    public CandleFlameProjectile(class_1299<? extends class_3857> type, class_1937 level) {
        super(type, level);
    }

    public CandleFlameProjectile(class_1937 level, class_1309 owner) {
        super((class_1299)ModEntityTypes.CANDLE_FLAME.get(), level);
        this.method_7432((class_1297)owner);
    }

    protected void method_7454(class_3966 result) {
        super.method_7454(result);
        class_1297 entity = result.method_17782();
        if (entity instanceof CandleGolem) {
            return;
        }
        if (result.method_17782() instanceof TerracottaGolem) {
            return;
        }
        entity.method_5643(this.method_48923().method_48811((class_1297)this, this.method_24921()), 3.0f);
        entity.method_5639(5);
    }

    protected void method_7488(class_239 result) {
        super.method_7488(result);
        if (!this.method_37908().method_8608()) {
            this.method_5783(class_3417.field_14895, 1.0f, 1.0f);
            this.method_31472();
        }
    }

    protected class_1792 method_16942() {
        return class_1802.field_8814;
    }

    public boolean method_5740() {
        return true;
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_37908().method_8608() && this.field_6012 % 5 == 0) {
            this.spawnParticles();
        }
        if (!this.method_37908().method_8608() && this.field_6012 > 100) {
            this.method_31472();
        }
    }

    private void spawnParticles() {
        for (int i = 0; i < 3; ++i) {
            double x = this.method_23317() + this.field_5974.method_43058() * 0.5;
            double y = this.method_23318() + this.field_5974.method_43058() * 0.5;
            double z = this.method_23321() + this.field_5974.method_43058() * 0.5;
            this.method_37908().method_8406((class_2394)class_2398.field_11240, x, y, z, 0.0, 0.0, 0.0);
        }
    }
}

