/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PacketByteBufs
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.minecraft.class_1259$class_1260
 *  net.minecraft.class_1259$class_1261
 *  net.minecraft.class_1282
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1296
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1314
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1400
 *  net.minecraft.class_1429
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1690
 *  net.minecraft.class_1799
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2487
 *  net.minecraft.class_2540
 *  net.minecraft.class_2561
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2960
 *  net.minecraft.class_3213
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3414
 *  net.minecraft.class_4050
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_7094
 *  net.minecraft.class_8111
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.entity.custom;

import net._void.civilizations.entity.ai.BossLokiAttackGoal;
import net._void.civilizations.item.ModItems;
import net._void.civilizations.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1259;
import net.minecraft.class_1282;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1314;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1400;
import net.minecraft.class_1429;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_1799;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2487;
import net.minecraft.class_2540;
import net.minecraft.class_2561;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_2960;
import net.minecraft.class_3213;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3414;
import net.minecraft.class_4050;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7094;
import net.minecraft.class_8111;
import org.jetbrains.annotations.Nullable;

public class BossLokiEntity
extends class_1429 {
    private static final class_2940<Boolean> ATTACK = class_2945.method_12791(BossLokiEntity.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> POTION = class_2945.method_12791(BossLokiEntity.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> CLONE = class_2945.method_12791(BossLokiEntity.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> SUMMON = class_2945.method_12791(BossLokiEntity.class, (class_2941)class_2943.field_13323);
    public final class_7094 idleAnimationState = new class_7094();
    private int idleAnimationTimeout = 0;
    public final class_7094 attackAnimationState = new class_7094();
    public int attackAnimationTimeout = 0;
    public final class_7094 potionAnimationState = new class_7094();
    public int potionAnimationTimeout = 0;
    public final class_7094 cloneAnimationState = new class_7094();
    public int cloneAnimationTimeout = 0;
    public final class_7094 summonAnimationState = new class_7094();
    public int summonAnimationTimeout = 0;
    private static class_2940<Integer> X = class_2945.method_12791(BossLokiEntity.class, (class_2941)class_2943.field_13327);
    private static class_2940<Integer> Y = class_2945.method_12791(BossLokiEntity.class, (class_2941)class_2943.field_13327);
    private static class_2940<Integer> Z = class_2945.method_12791(BossLokiEntity.class, (class_2941)class_2943.field_13327);
    private final class_3213 bossBar = new class_3213((class_2561)class_2561.method_43471((String)"entity.civilizations.boss_loki"), class_1259.class_1260.field_5784, class_1259.class_1261.field_5790);

    public void setCoords(int x, int y, int z) {
        this.field_6011.method_12778(X, (Object)x);
        this.field_6011.method_12778(Y, (Object)y);
        this.field_6011.method_12778(Z, (Object)z);
    }

    public int getCoordsX() {
        return (Integer)this.field_6011.method_12789(X);
    }

    public int getCoordsY() {
        return (Integer)this.field_6011.method_12789(Y);
    }

    public int getCoordsZ() {
        return (Integer)this.field_6011.method_12789(Z);
    }

    public BossLokiEntity(class_1299<? extends class_1429> entityType, class_1937 world) {
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
            this.attackAnimationTimeout = 20;
            this.attackAnimationState.method_41322(this.field_6012);
        } else {
            --this.attackAnimationTimeout;
        }
        if (!this.method_6510()) {
            this.attackAnimationState.method_41325();
        }
        if (this.isPotioning() && this.potionAnimationTimeout <= 0) {
            this.potionAnimationTimeout = 20;
            this.potionAnimationState.method_41322(this.field_6012);
        } else {
            --this.potionAnimationTimeout;
        }
        if (!this.isPotioning()) {
            this.potionAnimationState.method_41325();
        }
        if (this.isCloning() && this.cloneAnimationTimeout <= 0) {
            this.cloneAnimationTimeout = 20;
            this.cloneAnimationState.method_41322(this.field_6012);
        } else {
            --this.cloneAnimationTimeout;
        }
        if (!this.isCloning()) {
            this.cloneAnimationState.method_41325();
        }
        if (this.isSummoning() && this.summonAnimationTimeout <= 0) {
            this.summonAnimationTimeout = 20;
            this.summonAnimationState.method_41322(this.field_6012);
        } else {
            --this.summonAnimationTimeout;
        }
        if (!this.isSummoning()) {
            this.summonAnimationState.method_41325();
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
        for (class_1657 player : this.method_37908().method_18456()) {
            class_2540 buffer;
            if (player.method_5858((class_1297)this) <= 2500.0) {
                if (this.method_37908().method_8608() || !this.method_5805()) continue;
                buffer = PacketByteBufs.create();
                buffer.method_10814("NordicGodPlay");
                ServerPlayNetworking.send((class_3222)((class_3222)player), (class_2960)ModMessages.BOSS_MUSIC_PLAY, (class_2540)buffer);
                continue;
            }
            if (this.method_37908().method_8608()) continue;
            buffer = PacketByteBufs.create();
            buffer.method_10814("NordicGodStop");
            ServerPlayNetworking.send((class_3222)((class_3222)player), (class_2960)ModMessages.BOSS_MUSIC_PLAY, (class_2540)buffer);
        }
    }

    protected void method_5959() {
        this.field_6201.method_6277(0, (class_1352)new class_1347((class_1308)this));
        this.field_6201.method_6277(1, (class_1352)new BossLokiAttackGoal((class_1314)this));
        this.field_6185.method_6277(1, (class_1352)new class_1400((class_1308)this, class_1657.class, false));
    }

    public static class_5132.class_5133 createBossAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 1200.0).method_26868(class_5134.field_23724, 5.0).method_26868(class_5134.field_23721, 16.0).method_26868(class_5134.field_23719, (double)0.2f).method_26868(class_5134.field_23717, 75.0).method_26868(class_5134.field_23718, 2.0);
    }

    public void method_19540(boolean attacking) {
        this.field_6011.method_12778(ATTACK, (Object)attacking);
    }

    public boolean method_6510() {
        return (Boolean)this.field_6011.method_12789(ATTACK);
    }

    public void setPotioning(boolean potion) {
        this.field_6011.method_12778(POTION, (Object)potion);
    }

    public boolean isPotioning() {
        return (Boolean)this.field_6011.method_12789(POTION);
    }

    public void setCloning(boolean clone) {
        this.field_6011.method_12778(CLONE, (Object)clone);
    }

    public boolean isCloning() {
        return (Boolean)this.field_6011.method_12789(CLONE);
    }

    public void setSummoning(boolean summon) {
        this.field_6011.method_12778(SUMMON, (Object)summon);
    }

    public boolean isSummoning() {
        return (Boolean)this.field_6011.method_12789(SUMMON);
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

    public void method_5837(class_3222 player) {
        super.method_5837(player);
        this.bossBar.method_14088(player);
    }

    public void method_5742(class_3222 player) {
        super.method_5742(player);
        this.bossBar.method_14089(player);
    }

    protected void method_5958() {
        class_1297 class_12972;
        super.method_5958();
        this.bossBar.method_5408(this.method_6032() / this.method_6063());
        if (this.method_5809()) {
            this.method_33572(false);
        }
        if ((class_12972 = this.method_5854()) instanceof class_1690) {
            class_1690 boatEntity = (class_1690)class_12972;
            boatEntity.method_5768();
        }
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ATTACK, (Object)false);
        this.field_6011.method_12784(POTION, (Object)false);
        this.field_6011.method_12784(CLONE, (Object)false);
        this.field_6011.method_12784(SUMMON, (Object)false);
        this.field_6011.method_12784(X, (Object)0);
        this.field_6011.method_12784(Y, (Object)0);
        this.field_6011.method_12784(Z, (Object)0);
    }

    public void method_5652(class_2487 nbt) {
        super.method_5652(nbt);
        nbt.method_10569("X", this.getCoordsX());
        nbt.method_10569("Y", this.getCoordsY());
        nbt.method_10569("Z", this.getCoordsZ());
    }

    public void method_5749(class_2487 nbt) {
        super.method_5749(nbt);
        this.field_6011.method_12778(X, (Object)nbt.method_10550("X"));
        this.field_6011.method_12778(Y, (Object)nbt.method_10550("Y"));
        this.field_6011.method_12778(Z, (Object)nbt.method_10550("Z"));
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (source.method_49708(class_8111.field_42335) || source.method_49708(class_8111.field_42337) || source.method_49708(class_8111.field_42338) || source.method_49708(class_8111.field_42345) || source.method_49708(class_8111.field_42342) || source.method_49708(class_8111.field_42340) || source.method_49708(class_8111.field_42331) || source.method_49708(class_8111.field_42332)) {
            return false;
        }
        return super.method_5643(source, amount);
    }

    public void method_6078(class_1282 damageSource) {
        for (double i = -50.0; i <= 100.0; i += 1.0) {
            for (double j = -50.0; j <= 100.0; j += 1.0) {
                if (!(Math.pow(i, 2.0) + Math.pow(j, 2.0) <= Math.pow(35.0, 2.0))) continue;
                this.method_37908().method_8501(new class_2338((Integer)this.field_6011.method_12789(X) + (int)i, 198, (Integer)this.field_6011.method_12789(Z) + (int)j), class_2246.field_10124.method_9564());
                this.method_37908().method_8501(new class_2338((Integer)this.field_6011.method_12789(X) + (int)i, 199, (Integer)this.field_6011.method_12789(Z) + (int)j), class_2246.field_10124.method_9564());
                this.method_37908().method_8501(new class_2338((Integer)this.field_6011.method_12789(X) + (int)i, 200, (Integer)this.field_6011.method_12789(Z) + (int)j), class_2246.field_10124.method_9564());
                this.method_37908().method_8501(new class_2338((Integer)this.field_6011.method_12789(X) + (int)i, 201, (Integer)this.field_6011.method_12789(Z) + (int)j), class_2246.field_10124.method_9564());
            }
        }
        class_1297 class_12972 = damageSource.method_5529();
        if (class_12972 instanceof class_1657) {
            class_1657 player = (class_1657)class_12972;
            player.method_6092(new class_1293(class_1294.field_5906, 500, 0, false, false));
        }
        class_1542 itemEntity = new class_1542(this.method_37908(), (double)((Integer)this.field_6011.method_12789(X)).intValue() + 0.5, (double)((Integer)this.field_6011.method_12789(Y)).intValue(), (double)((Integer)this.field_6011.method_12789(Z)).intValue() + 0.5, new class_1799((class_1935)ModItems.LOKI_NECKLACE));
        itemEntity.method_30634((double)((Integer)this.field_6011.method_12789(X)).intValue() + 0.5, (double)((Integer)this.field_6011.method_12789(Y)).intValue(), (double)((Integer)this.field_6011.method_12789(Z)).intValue() + 0.5);
        this.method_37908().method_8649((class_1297)itemEntity);
        for (class_1657 player : this.method_37908().method_18456()) {
            if (!(player.method_5858((class_1297)this) <= 2500.0) || this.method_37908().method_8608()) continue;
            class_2540 buffer = PacketByteBufs.create();
            buffer.method_10814("NordicGodStop");
            ServerPlayNetworking.send((class_3222)((class_3222)player), (class_2960)ModMessages.BOSS_MUSIC_PLAY, (class_2540)buffer);
        }
        super.method_6078(damageSource);
    }

    public boolean method_5810() {
        return false;
    }

    public boolean method_5931(class_1657 player) {
        return false;
    }
}

