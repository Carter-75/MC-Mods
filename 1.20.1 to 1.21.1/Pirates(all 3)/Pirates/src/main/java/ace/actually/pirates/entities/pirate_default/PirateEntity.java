/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1304
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1352
 *  net.minecraft.class_1400
 *  net.minecraft.class_1439
 *  net.minecraft.class_1588
 *  net.minecraft.class_1603
 *  net.minecraft.class_1657
 *  net.minecraft.class_1665
 *  net.minecraft.class_1675
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_3417
 *  net.minecraft.class_3988
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5819
 */
package ace.actually.pirates.entities.pirate_default;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.entities.friendly_pirate.FriendlyPirateEntity;
import ace.actually.pirates.entities.pirate_abstract.AbstractPirateEntity;
import ace.actually.pirates.entities.pirate_abstract.PirateBowAttackGoal;
import net.minecraft.class_1266;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1400;
import net.minecraft.class_1439;
import net.minecraft.class_1588;
import net.minecraft.class_1603;
import net.minecraft.class_1657;
import net.minecraft.class_1665;
import net.minecraft.class_1675;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_3417;
import net.minecraft.class_3988;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5819;

public class PirateEntity
extends AbstractPirateEntity
implements class_1603 {
    protected class_2338 blockToDisable;

    public PirateEntity(class_1937 world) {
        this(world, class_2338.field_10980);
    }

    public PirateEntity(class_1937 world, class_2338 blockToDisable) {
        super((class_1299<? extends class_1588>)((class_1299)Pirates.PIRATE_ENTITY_TYPE.get()), world, blockToDisable);
    }

    public PirateEntity(class_1299<? extends class_1588> entityEntityType, class_1937 level) {
        super(entityEntityType, level, class_2338.field_10980);
    }

    @Override
    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(3, new PirateBowAttackGoal<PirateEntity>(this, 1.0, 20, 20.0f));
        this.field_6185.method_6277(1, (class_1352)new class_1400((class_1308)this, class_1657.class, true));
        this.field_6185.method_6277(3, (class_1352)new class_1400((class_1308)this, class_3988.class, false));
        this.field_6185.method_6277(3, (class_1352)new class_1400((class_1308)this, class_1439.class, true));
        this.field_6185.method_6277(3, (class_1352)new class_1400((class_1308)this, FriendlyPirateEntity.class, true));
    }

    protected void method_5964(class_5819 random, class_1266 localDifficulty) {
        super.method_5964(random, localDifficulty);
        this.method_5673(class_1304.field_6173, new class_1799((class_1935)class_1802.field_8102));
    }

    public void method_7105(class_1309 target, float pullProgress) {
        class_1799 itemStack = this.method_5998(class_1675.method_18812((class_1309)this, (class_1792)class_1802.field_8102));
        class_1665 persistentProjectileEntity = this.createArrowProjectile(itemStack, pullProgress);
        double d = target.method_23317() - this.method_23317();
        double e = target.method_23323(0.3333333333333333) - persistentProjectileEntity.method_23318();
        double f = target.method_23321() - this.method_23321();
        double g = Math.sqrt(d * d + f * f);
        persistentProjectileEntity.method_7485(d, e + g * (double)0.2f, f, 1.6f, (float)(14 - this.method_5770().method_8407().method_5461() * 4));
        this.method_5783(class_3417.field_14633, 1.0f, 1.0f / (this.method_6051().method_43057() * 0.4f + 0.8f));
        this.method_5770().method_8649((class_1297)persistentProjectileEntity);
    }

    protected class_1665 createArrowProjectile(class_1799 arrow, float damageModifier) {
        return class_1675.method_18813((class_1309)this, (class_1799)arrow, (float)damageModifier);
    }

    public static class_5132.class_5133 attributes() {
        return PirateEntity.method_26918().method_26868(class_5134.field_23719, 0.3).method_26868(class_5134.field_23717, 100.0);
    }
}

