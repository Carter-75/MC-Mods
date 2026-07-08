/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_1937$class_7867
 *  net.minecraft.class_2248
 *  net.minecraft.class_239
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2596
 *  net.minecraft.class_2602
 *  net.minecraft.class_2604
 *  net.minecraft.class_3218
 *  net.minecraft.class_3856
 *  net.minecraft.class_3857
 *  net.minecraft.class_3965
 *  net.minecraft.class_3966
 */
package ace.actually.pirates.entities.shot;

import ace.actually.pirates.Pirates;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_239;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2596;
import net.minecraft.class_2602;
import net.minecraft.class_2604;
import net.minecraft.class_3218;
import net.minecraft.class_3856;
import net.minecraft.class_3857;
import net.minecraft.class_3965;
import net.minecraft.class_3966;

public class ShotEntity
extends class_3857
implements class_3856 {
    private class_1309 in;
    private float damage = 6.0f;
    private String extra = "";
    private int tickAge = 0;

    public ShotEntity(class_1299<? extends class_3857> entityType, class_1937 world, class_1309 caster, class_1792 toShow, float damageTo, String special) {
        super(entityType, world);
        this.in = caster;
        this.method_16940(new class_1799((class_1935)toShow));
        this.damage = damageTo;
        this.extra = special;
    }

    public ShotEntity(class_1937 world) {
        super((class_1299)Pirates.SHOT_ENTITY_TYPE.get(), world);
    }

    public ShotEntity(class_1299<? extends class_3857> shotEntityEntityType, class_1937 level) {
        super(shotEntityEntityType, level);
    }

    public void method_5773() {
        if (this.tickAge > 500) {
            if (!this.method_37908().method_8608()) {
                this.explode();
            }
        } else {
            ++this.tickAge;
        }
        if (!this.method_37908().method_8608() && this.method_18798().method_1033() > 0.85) {
            ((class_3218)this.method_37908()).method_14199((class_2394)class_2398.field_11204, this.method_23317(), this.method_23318(), this.method_23321(), 1, 0.0, 0.0, 0.0, 0.0);
        }
        super.method_5773();
    }

    protected void method_7488(class_239 hitResult) {
        super.method_7488(hitResult);
        if (!this.method_37908().field_9236) {
            this.explode();
        }
    }

    protected void method_7454(class_3966 entityHitResult) {
        super.method_7454(entityHitResult);
        class_1297 entity = entityHitResult.method_17782();
        entity.method_5643(this.method_48923().method_48807(null), this.damage);
        if (!this.method_37908().field_9236) {
            this.explode();
        }
    }

    protected void method_24920(class_3965 blockHitResult) {
        super.method_24920(blockHitResult);
        if (this.extra.contains("heavy")) {
            this.method_37908().method_8501(blockHitResult.method_17777(), ((class_2248)Pirates.HEAVY_BLOCK.get()).method_9564());
        }
    }

    private void explode() {
        this.method_37908().method_8537((class_1297)this, this.method_23317(), this.method_23318(), this.method_23321(), Pirates.baseShotPower, this.extra.contains("fire"), class_1937.class_7867.field_40891);
        this.method_31472();
    }

    protected class_1792 method_16942() {
        return (class_1792)Pirates.CANNONBALL_ENT.get();
    }

    public class_1799 method_7495() {
        return super.method_7495();
    }

    public class_2596<class_2602> method_18002() {
        class_1309 entity = this.in;
        return new class_2604((class_1297)this, entity == null ? 0 : entity.method_5628());
    }
}

