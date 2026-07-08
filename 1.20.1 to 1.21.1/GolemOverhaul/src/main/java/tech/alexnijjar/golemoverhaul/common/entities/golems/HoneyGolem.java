/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1352
 *  net.minecraft.class_1381
 *  net.minecraft.class_1427
 *  net.minecraft.class_1603
 *  net.minecraft.class_1657
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1936
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_2487
 *  net.minecraft.class_2499
 *  net.minecraft.class_2520
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_3730
 *  net.minecraft.class_4466
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5819
 *  org.jetbrains.annotations.NotNull
 */
package tech.alexnijjar.golemoverhaul.common.entities.golems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1352;
import net.minecraft.class_1381;
import net.minecraft.class_1427;
import net.minecraft.class_1603;
import net.minecraft.class_1657;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1936;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2487;
import net.minecraft.class_2499;
import net.minecraft.class_2520;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_3730;
import net.minecraft.class_4466;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5819;
import org.jetbrains.annotations.NotNull;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;
import tech.alexnijjar.golemoverhaul.common.entities.AdditionalBeeData;
import tech.alexnijjar.golemoverhaul.common.entities.IShearable;
import tech.alexnijjar.golemoverhaul.common.entities.golems.base.BaseGolem;
import tech.alexnijjar.golemoverhaul.common.entities.projectiles.HoneyBlobProjectile;
import tech.alexnijjar.golemoverhaul.common.registry.ModItems;
import tech.alexnijjar.golemoverhaul.mixins.common.BeeAccessor;

public class HoneyGolem
extends BaseGolem
implements class_1603,
IShearable {
    public static final byte NECTAR_PARTICLES_EVENT_ID = 8;
    public static final int RANGED_ATTACK_DELAY_TICKS = 6;
    public static final class_2940<Byte> ID_HONEY_LEVEL = class_2945.method_12791(HoneyGolem.class, (class_2941)class_2943.field_13319);
    private final List<BeeData> bees = new ArrayList<BeeData>();
    private int attackAnimationDelay = -1;
    private boolean hasPopulatedInitialBees;

    public HoneyGolem(class_1299<? extends class_1427> type, class_1937 level) {
        super(type, level);
        this.field_6194 = 8;
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 30.0).method_26868(class_5134.field_23719, 0.2).method_26868(class_5134.field_23721, 6.0);
    }

    public static boolean checkMobSpawnRules(class_1299<? extends class_1308> type, class_1936 level, class_3730 spawnType, class_2338 pos, class_5819 random) {
        if (!GolemOverhaulConfig.spawnHoneyGolems || !GolemOverhaulConfig.allowSpawning) {
            return false;
        }
        return class_1308.method_20636(type, (class_1936)level, (class_3730)spawnType, (class_2338)pos, (class_5819)random);
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ID_HONEY_LEVEL, (Object)0);
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10567("HoneyLevel", this.getHoneyLevel());
        class_2499 beeTag = new class_2499();
        for (BeeData bee : this.bees) {
            class_2487 tag = new class_2487();
            tag.method_10566("EntityData", (class_2520)bee.tag);
            tag.method_10569("TicksInHive", bee.ticks);
            tag.method_10569("MinOccupationTicks", bee.minOccupationTicks);
            beeTag.add((Object)tag);
        }
        compound.method_10566("Bees", (class_2520)beeTag);
        compound.method_10556("HasPopulatedInitialBees", this.hasPopulatedInitialBees);
    }

    @Override
    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setHoneyLevel(compound.method_10571("HoneyLevel"));
        class_2499 beeTag = compound.method_10554("Bees", 10);
        for (int i = 0; i < beeTag.size(); ++i) {
            class_2487 tag = beeTag.method_10602(i);
            this.bees.add(new BeeData(tag.method_10562("EntityData"), tag.method_10550("TicksInHive"), tag.method_10550("MinOccupationTicks")));
        }
        this.hasPopulatedInitialBees = compound.method_10577("HasPopulatedInitialBees");
    }

    @Override
    public boolean canMeleeAttack() {
        return false;
    }

    @Override
    protected void method_5959() {
        super.method_5959();
        this.field_6201.method_6277(2, (class_1352)new class_1381((class_1603)this, 1.0, 20, 15.0f));
    }

    public byte getHoneyLevel() {
        return (Byte)this.field_6011.method_12789(ID_HONEY_LEVEL);
    }

    public void setHoneyLevel(byte honeyLevel) {
        this.field_6011.method_12778(ID_HONEY_LEVEL, (Object)honeyLevel);
    }

    public boolean isFullOfHoney() {
        return this.getHoneyLevel() >= 4;
    }

    @Override
    protected class_3414 method_6011(class_1282 damageSource) {
        return class_3417.field_21072;
    }

    @Override
    protected class_3414 method_6002() {
        return class_3417.field_21070;
    }

    @Override
    public int getAttackTicks() {
        return 15;
    }

    @Override
    public class_1792 getRepairItem() {
        return class_1802.field_20417;
    }

    @Override
    public float getRepairItemHealAmount() {
        return 20.0f;
    }

    @Override
    public class_3414 getRepairSound() {
        return class_3417.field_21070;
    }

    public void method_7105(class_1309 target, float velocity) {
        if (this.attackAnimationDelay == -1) {
            this.sendAttackEvent();
            this.attackAnimationDelay = 6;
        }
    }

    public void actuallyShoot(class_1309 target) {
        if (target == null) {
            return;
        }
        HoneyBlobProjectile projectile = new HoneyBlobProjectile(this.method_37908(), (class_1309)this);
        projectile.method_5814(this.method_23317(), this.method_23318(), this.method_23321());
        double x = target.method_23317() - this.method_23317();
        double y = target.method_23318() - projectile.method_23318();
        double z = target.method_23321() - this.method_23321();
        double distance = Math.sqrt(x * x + z * z) * 0.2;
        projectile.method_7485(x, y + distance + 0.8, z, 1.2f, 3.0f);
        this.method_37908().method_8649((class_1297)projectile);
        this.method_5783(class_3417.field_14863, 1.0f, 0.4f / (this.method_6051().method_43057() * 0.4f + 0.8f));
    }

    public void method_5773() {
        super.method_5773();
        if (!this.method_37908().method_8608() && !this.hasPopulatedInitialBees) {
            this.hasPopulatedInitialBees = true;
            this.populateInitialBees();
        }
    }

    private void populateInitialBees() {
        int count = 2 + this.method_37908().method_8409().method_43048(4);
        for (int i = 0; i < count; ++i) {
            class_4466 bee = Objects.requireNonNull((class_4466)class_1299.field_20346.method_5883(this.method_37908()));
            ((AdditionalBeeData)bee).golemoverhaul$setOwner(this.method_5667());
            this.bees.add(new BeeData(bee.method_5647(new class_2487()), 0, 2400));
        }
        this.setHoneyLevel((byte)count);
    }

    protected void method_5958() {
        if (!this.bees.isEmpty() && this.method_37908().method_8409().method_43058() < 0.005) {
            this.method_43077(class_3417.field_20612);
        }
        if (!this.method_37908().method_23886() && !this.method_37908().method_8419()) {
            for (int i = 0; i < this.bees.size(); ++i) {
                BeeData bee = this.bees.get(i);
                ++bee.ticks;
                if (bee.ticks < bee.minOccupationTicks) continue;
                this.releaseBee(i);
                --i;
            }
        }
        if (!this.bees.isEmpty() && this.field_6012 % 200 == 0) {
            this.method_6025(1.0f);
        }
        this.attackAnimationDelay = Math.max(-1, this.attackAnimationDelay - 1);
        if (this.attackAnimationDelay == 0) {
            this.actuallyShoot(this.method_5968());
            this.attackAnimationDelay = -1;
        }
    }

    public void method_6078(class_1282 damageSource) {
        super.method_6078(damageSource);
        if (this.method_37908().method_8608()) {
            return;
        }
        if (!this.bees.isEmpty()) {
            this.releaseAllBees();
        }
    }

    @Override
    @NotNull
    public List<class_1799> onSheared() {
        if (!this.isFullOfHoney()) {
            return List.of();
        }
        this.method_43077(class_3417.field_20611);
        if (!this.method_37908().method_8608()) {
            this.setHoneyLevel((byte)0);
        }
        return List.of(new class_1799((class_1935)ModItems.HONEY_BLOB.get(), 5 + this.method_37908().field_9229.method_43048(8)), new class_1799((class_1935)class_1802.field_20414, 3));
    }

    @Override
    public boolean isShearable() {
        return this.isFullOfHoney();
    }

    @Override
    public void method_5711(byte id) {
        super.method_5711(id);
        if (id == 8) {
            for (int i = 0; i < 8; ++i) {
                this.method_37908().method_8406((class_2394)class_2398.field_20537, this.method_23317() + this.method_6051().method_43059() * 0.25, this.method_23318() + 0.5, this.method_23321() + this.method_6051().method_43059() * 0.25, 0.0, 0.0, 0.0);
            }
        }
    }

    public void healFromNectar() {
        this.method_6025(5.0f);
        this.method_37908().method_8421((class_1297)this, (byte)8);
    }

    public boolean method_5643(class_1282 source, float amount) {
        class_1309 entity;
        class_1297 class_12972;
        if (!this.bees.isEmpty() && (class_12972 = source.method_5529()) instanceof class_1309 && this.method_18395(entity = (class_1309)class_12972)) {
            class_1657 player;
            if (entity instanceof class_1657 && (player = (class_1657)entity).method_7337()) {
                return super.method_5643(source, amount);
            }
            this.releaseAllBees().forEach(bee -> bee.method_5980(entity));
        }
        return super.method_5643(source, amount);
    }

    public boolean canPutBee() {
        return this.bees.size() < 5;
    }

    public void putBee(class_4466 bee) {
        if (!this.canPutBee()) {
            return;
        }
        ((AdditionalBeeData)bee).golemoverhaul$setOwner(this.method_5667());
        this.bees.add(new BeeData(bee.method_5647(new class_2487()), 0, 2400));
        if (bee.method_21784() && !this.isFullOfHoney()) {
            this.setHoneyLevel((byte)(this.getHoneyLevel() + 1));
            if (this.method_6032() < this.method_6063()) {
                this.method_6025(10.0f);
                this.method_37908().method_8421((class_1297)this, (byte)8);
            }
        }
        bee.method_21788();
        bee.method_31472();
        this.method_43077(class_3417.field_20609);
    }

    private class_4466 releaseBee(int index) {
        BeeData data = this.bees.get(index);
        class_4466 bee = Objects.requireNonNull((class_4466)class_1299.field_20346.method_5883(this.method_37908()));
        bee.method_5651(data.tag);
        bee.method_5814(this.method_23317(), this.method_23318(), this.method_23321());
        bee.method_21788();
        bee.method_6033(bee.method_6063());
        this.method_37908().method_8649((class_1297)bee);
        bee.method_21807(400);
        this.method_43077(class_3417.field_20610);
        this.bees.remove(index);
        return bee;
    }

    public List<class_4466> releaseAllBees() {
        ArrayList<class_4466> removedBees = new ArrayList<class_4466>();
        int size = this.bees.size();
        for (int i = 0; i < size; ++i) {
            class_4466 bee = this.releaseBee(0);
            ((BeeAccessor)bee).setRemainingCooldownBeforeLocatingNewFlower(400);
            removedBees.add(bee);
        }
        return removedBees;
    }

    private static final class BeeData {
        private final class_2487 tag;
        private int ticks;
        private final int minOccupationTicks;

        private BeeData(class_2487 tag, int ticks, int minOccupationTicks) {
            this.tag = tag;
            this.ticks = ticks;
            this.minOccupationTicks = minOccupationTicks;
        }
    }
}

