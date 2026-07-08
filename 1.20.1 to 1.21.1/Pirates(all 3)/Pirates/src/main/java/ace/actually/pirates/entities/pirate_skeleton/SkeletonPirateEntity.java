/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1266
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1297$class_5529
 *  net.minecraft.class_1299
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1588
 *  net.minecraft.class_1603
 *  net.minecraft.class_1665
 *  net.minecraft.class_1675
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5575
 *  net.minecraft.class_5819
 */
package ace.actually.pirates.entities.pirate_skeleton;

import ace.actually.pirates.Pirates;
import ace.actually.pirates.entities.pirate_abstract.AbstractPirateEntity;
import ace.actually.pirates.entities.pirate_abstract.PirateBowAttackGoal;
import java.util.ArrayList;
import java.util.function.Predicate;
import net.minecraft.class_1266;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1588;
import net.minecraft.class_1603;
import net.minecraft.class_1665;
import net.minecraft.class_1675;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5575;
import net.minecraft.class_5819;

public class SkeletonPirateEntity
extends AbstractPirateEntity
implements class_1603 {
    protected class_2338 blockToDisable;

    public SkeletonPirateEntity(class_1937 world) {
        this(world, new class_2338(0, 0, 0));
    }

    public SkeletonPirateEntity(class_1937 world, class_2338 blockToDisable) {
        super((class_1299<? extends class_1588>)((class_1299)Pirates.SKELETON_PIRATE_ENTITY_TYPE.get()), world, blockToDisable);
        if (world.method_8320(blockToDisable).method_27852((class_2248)Pirates.MOTION_INVOKING_BLOCK.get()) && !world.method_8608()) {
            class_3218 serverWorld = (class_3218)world;
            serverWorld.method_27910(0, 36000, true, true);
            System.out.println("Skeleton ship!! Setting thunder");
        }
    }

    @Override
    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(3, new PirateBowAttackGoal<SkeletonPirateEntity>(this, 1.0, 20, 20.0f));
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
        persistentProjectileEntity.method_7451((byte)2);
        this.method_5770().method_8649((class_1297)persistentProjectileEntity);
    }

    protected class_1665 createArrowProjectile(class_1799 arrow, float damageModifier) {
        return class_1675.method_18813((class_1309)this, (class_1799)arrow, (float)damageModifier);
    }

    public static class_5132.class_5133 attributes() {
        return class_1588.method_26918().method_26868(class_5134.field_23719, 0.3).method_26868(class_5134.field_23716, 24.0).method_26868(class_5134.field_23717, 100.0);
    }

    @Override
    public void method_5650(class_1297.class_5529 reason) {
        class_3218 serverWorld;
        class_1937 world = this.method_5770();
        if (!world.method_8608() && !SkeletonPirateEntity.anySkeletonPiratesLeft(serverWorld = (class_3218)world)) {
            serverWorld.method_27910(6000, 0, false, false);
            System.out.println("clearing the skies");
        }
        super.method_5650(reason);
    }

    public static boolean anySkeletonPiratesLeft(class_3218 world) {
        ArrayList pirates = new ArrayList();
        class_5575 filter = class_5575.method_31795(SkeletonPirateEntity.class);
        Predicate<SkeletonPirateEntity> predicate = entity -> true;
        world.method_47539(filter, predicate, pirates, 2);
        return pirates.size() > 1;
    }

    protected class_3414 method_5994() {
        return class_3417.field_15214;
    }

    protected class_3414 method_6011(class_1282 source) {
        return class_3417.field_15027;
    }

    protected class_3414 method_6002() {
        return class_3417.field_15122;
    }
}

