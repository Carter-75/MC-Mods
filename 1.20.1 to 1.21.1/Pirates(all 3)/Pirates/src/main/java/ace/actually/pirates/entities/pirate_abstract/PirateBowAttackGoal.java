/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1352
 *  net.minecraft.class_1352$class_4134
 *  net.minecraft.class_1588
 *  net.minecraft.class_1603
 *  net.minecraft.class_1675
 *  net.minecraft.class_1753
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 *  org.valkyrienskies.mod.common.VSGameUtilsKt
 */
package ace.actually.pirates.entities.pirate_abstract;

import java.util.EnumSet;
import java.util.Objects;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1588;
import net.minecraft.class_1603;
import net.minecraft.class_1675;
import net.minecraft.class_1753;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

public class PirateBowAttackGoal<T extends class_1588>
extends class_1352 {
    private final T actor;
    private final double speed;
    private int attackInterval;
    private final float squaredRange;
    private int cooldown = -1;
    private int targetSeeingTicker;
    private boolean movingToLeft;
    private boolean backward;
    private int combatTicks = -1;

    public PirateBowAttackGoal(T actor, double speed, int attackInterval, float range) {
        this.actor = actor;
        this.speed = speed;
        this.attackInterval = attackInterval;
        this.squaredRange = range * range;
        this.method_6265(EnumSet.of(class_1352.class_4134.field_18405, class_1352.class_4134.field_18406));
    }

    public void setAttackInterval(int attackInterval) {
        this.attackInterval = attackInterval;
    }

    public boolean method_6264() {
        return this.actor.method_5968() == null ? false : this.isHoldingBow();
    }

    protected boolean isHoldingBow() {
        return this.actor.method_24518(class_1802.field_8102);
    }

    public boolean method_6266() {
        return (this.method_6264() || !this.actor.method_5942().method_6357()) && this.isHoldingBow();
    }

    public void method_6269() {
        super.method_6269();
        this.actor.method_19540(true);
    }

    public void method_6270() {
        super.method_6270();
        this.actor.method_19540(false);
        this.targetSeeingTicker = 0;
        this.cooldown = -1;
        this.actor.method_6021();
    }

    public boolean method_38846() {
        return true;
    }

    public void method_6268() {
        class_1309 livingEntity = this.actor.method_5968();
        if (livingEntity != null) {
            boolean bl2;
            double d = this.actor.method_5649(livingEntity.method_23317(), livingEntity.method_23318(), livingEntity.method_23321());
            boolean bl = this.actor.method_5985().method_6369((class_1297)livingEntity);
            boolean bl3 = bl2 = this.targetSeeingTicker > 0;
            if (bl != bl2) {
                this.targetSeeingTicker = 0;
            }
            this.targetSeeingTicker = bl ? ++this.targetSeeingTicker : --this.targetSeeingTicker;
            if (!(d > (double)this.squaredRange) && this.targetSeeingTicker >= 20) {
                this.actor.method_5942().method_6340();
                ++this.combatTicks;
            } else if (VSGameUtilsKt.getShipManaging(this.actor) != null && VSGameUtilsKt.getShipManaging((class_1297)livingEntity) != null) {
                if (Objects.equals(VSGameUtilsKt.getShipManaging(this.actor), VSGameUtilsKt.getShipManaging((class_1297)livingEntity))) {
                    this.actor.method_5942().method_6335((class_1297)livingEntity, this.speed);
                    this.combatTicks = -1;
                }
            } else {
                class_1293 effectInstance = new class_1293(class_1294.field_5924);
                this.actor.method_6092(effectInstance);
            }
            if (this.combatTicks >= 20) {
                if ((double)this.actor.method_6051().method_43057() < 0.3) {
                    boolean bl4 = this.movingToLeft = !this.movingToLeft;
                }
                if ((double)this.actor.method_6051().method_43057() < 0.3) {
                    this.backward = !this.backward;
                }
                this.combatTicks = 0;
            }
            if (this.combatTicks > -1) {
                if (d > (double)(this.squaredRange * 0.75f)) {
                    this.backward = false;
                } else if (d < (double)(this.squaredRange * 0.25f)) {
                    this.backward = true;
                }
                this.actor.method_5962().method_6243(this.backward ? -0.5f : 0.5f, this.movingToLeft ? 0.5f : -0.5f);
                class_1297 var7 = this.actor.method_49694();
                if (var7 instanceof class_1308) {
                    class_1308 mobEntity = (class_1308)var7;
                    mobEntity.method_5951((class_1297)livingEntity, 30.0f, 30.0f);
                }
                this.actor.method_5951((class_1297)livingEntity, 30.0f, 30.0f);
            } else {
                this.actor.method_5988().method_6226((class_1297)livingEntity, 30.0f, 30.0f);
            }
            if (this.actor.method_6115()) {
                int i;
                if (!bl && this.targetSeeingTicker < -60) {
                    this.actor.method_6021();
                } else if (bl && (i = this.actor.method_6048()) >= 20) {
                    this.actor.method_6021();
                    ((class_1603)this.actor).method_7105(livingEntity, class_1753.method_7722((int)i));
                    this.cooldown = this.attackInterval;
                }
            } else if (--this.cooldown <= 0 && this.targetSeeingTicker >= -60) {
                this.actor.method_6019(class_1675.method_18812(this.actor, (class_1792)class_1802.field_8102));
            }
        }
    }
}

