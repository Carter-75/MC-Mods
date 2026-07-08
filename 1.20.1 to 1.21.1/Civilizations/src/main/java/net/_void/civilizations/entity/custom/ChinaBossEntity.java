/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.networking.v1.PacketByteBufs
 *  net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
 *  net.minecraft.class_1259$class_1260
 *  net.minecraft.class_1259$class_1261
 *  net.minecraft.class_1282
 *  net.minecraft.class_1296
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1314
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1379
 *  net.minecraft.class_1399
 *  net.minecraft.class_1400
 *  net.minecraft.class_1429
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1690
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
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
 *  net.minecraft.class_7
 *  net.minecraft.class_7094
 *  net.minecraft.class_8111
 *  org.jetbrains.annotations.Nullable
 */
package net._void.civilizations.entity.custom;

import net._void.civilizations.entity.ai.ChinaBossAttackGoal;
import net._void.civilizations.entity.custom.ChinaGuardEntity;
import net._void.civilizations.item.ModItems;
import net._void.civilizations.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.class_1259;
import net.minecraft.class_1282;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1314;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1379;
import net.minecraft.class_1399;
import net.minecraft.class_1400;
import net.minecraft.class_1429;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1690;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
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
import net.minecraft.class_7;
import net.minecraft.class_7094;
import net.minecraft.class_8111;
import org.jetbrains.annotations.Nullable;

public class ChinaBossEntity
extends class_1429 {
    private static final class_2940<Boolean> ATTACKING = class_2945.method_12791(ChinaBossEntity.class, (class_2941)class_2943.field_13323);
    public final class_7094 idleAnimationState = new class_7094();
    private int idleAnimationTimeout = 0;
    public final class_7094 attackAnimationState = new class_7094();
    public int attackAnimationTimeout = 0;
    int guardsSpawned = 0;
    int spawnTimer = -1;
    double spawnX = 0.0;
    double spawnY = 0.0;
    double spawnZ = 0.0;
    private final class_3213 bossBar = new class_3213((class_2561)class_2561.method_43471((String)"entity.civilizations.china_boss"), class_1259.class_1260.field_5784, class_1259.class_1261.field_5790);

    public ChinaBossEntity(class_1299<? extends class_1429> entityType, class_1937 world) {
        super(entityType, world);
        this.method_5941(class_7.field_3, 0.0f);
        this.method_5941(class_7.field_9, 0.0f);
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
                buffer.method_10814("ChinaBossPlay");
                ServerPlayNetworking.send((class_3222)((class_3222)player), (class_2960)ModMessages.BOSS_MUSIC_PLAY, (class_2540)buffer);
                continue;
            }
            if (this.method_37908().method_8608()) continue;
            buffer = PacketByteBufs.create();
            buffer.method_10814("ChinaBossStop");
            ServerPlayNetworking.send((class_3222)((class_3222)player), (class_2960)ModMessages.BOSS_MUSIC_PLAY, (class_2540)buffer);
        }
    }

    protected void method_5959() {
        this.field_6201.method_6277(0, (class_1352)new class_1347((class_1308)this));
        this.field_6201.method_6277(1, (class_1352)new ChinaBossAttackGoal((class_1314)this, 1.0, true));
        this.field_6201.method_6277(2, (class_1352)new class_1379((class_1314)this, 1.0));
        this.field_6185.method_6277(1, (class_1352)new class_1399((class_1314)this, new Class[0]));
        this.field_6185.method_6277(2, (class_1352)new class_1400((class_1308)this, class_1657.class, false));
    }

    public static class_5132.class_5133 createBossAttributes() {
        return class_1308.method_26828().method_26868(class_5134.field_23716, 800.0).method_26868(class_5134.field_23724, 5.0).method_26868(class_5134.field_23721, 9.0).method_26868(class_5134.field_23719, (double)0.3f).method_26868(class_5134.field_23717, 75.0).method_26868(class_5134.field_23718, 0.5);
    }

    public void method_19540(boolean shooting) {
        this.field_6011.method_12778(ATTACKING, (Object)shooting);
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
        double j;
        double i;
        super.method_5958();
        this.bossBar.method_5408(this.method_6032() / this.method_6063());
        if (this.method_5809()) {
            this.method_33572(false);
        }
        if (((int)this.method_6063() - (int)this.method_6032()) / 160 > this.guardsSpawned) {
            this.spawnTimer = 0;
            this.spawnX = this.method_23317();
            this.spawnY = this.method_23318();
            this.spawnZ = this.method_23321();
            for (i = this.spawnX - 2.0; i <= this.spawnX + 2.0; i += 4.0) {
                for (j = this.spawnZ - 2.0; j <= this.spawnZ + 2.0; j += 4.0) {
                    ((class_3218)this.method_37908()).method_14199((class_2394)class_2398.field_11240, i, this.spawnY, j, 20, 0.1, 0.1, 0.1, 1.0);
                }
            }
            ++this.guardsSpawned;
        }
        if (this.spawnTimer >= 0 && this.spawnTimer < 20) {
            ++this.spawnTimer;
        }
        if (this.spawnTimer >= 20) {
            for (i = this.spawnX - 2.0; i <= this.spawnX + 2.0; i += 4.0) {
                for (j = this.spawnZ - 2.0; j <= this.spawnZ + 2.0; j += 4.0) {
                    ((class_3218)this.method_37908()).method_14199((class_2394)class_2398.field_11240, i, this.spawnY, j, 20, 0.1, 0.1, 0.1, 1.0);
                    ChinaGuardEntity customEntity = (ChinaGuardEntity)((class_1299)class_1299.method_5898((String)"civilizations:china_guard").get()).method_5883(this.method_37908());
                    if (this.method_37908().method_8320(new class_2338((int)i, (int)this.spawnY, (int)j)).method_26204().equals(class_2246.field_10124) && this.method_37908().method_8320(new class_2338((int)i, (int)this.spawnY + 1, (int)j)).method_26204().equals(class_2246.field_10124)) {
                        customEntity.method_30634(i, this.spawnY, j);
                    } else {
                        customEntity.method_30634(this.method_23317(), this.method_23318(), this.method_23321());
                    }
                    this.method_37908().method_8649((class_1297)customEntity);
                }
            }
            this.spawnTimer = -1;
        }
        if ((class_12972 = this.method_5854()) instanceof class_1690) {
            class_1690 boatEntity = (class_1690)class_12972;
            boatEntity.method_5768();
        }
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ATTACKING, (Object)false);
    }

    public boolean method_5643(class_1282 source, float amount) {
        if (source.method_49708(class_8111.field_42321) || source.method_49708(class_8111.field_42335) || source.method_49708(class_8111.field_42337) || source.method_49708(class_8111.field_42338) || source.method_49708(class_8111.field_42345) || source.method_49708(class_8111.field_42342) || source.method_49708(class_8111.field_42340)) {
            return false;
        }
        return super.method_5643(source, amount);
    }

    public void method_6078(class_1282 damageSource) {
        for (class_1657 player : this.method_37908().method_18456()) {
            if (!(player.method_5858((class_1297)this) <= 2500.0) || this.method_37908().method_8608()) continue;
            class_2540 buffer = PacketByteBufs.create();
            buffer.method_10814("ChinaBossStop");
            ServerPlayNetworking.send((class_3222)((class_3222)player), (class_2960)ModMessages.BOSS_MUSIC_PLAY, (class_2540)buffer);
        }
        super.method_6078(damageSource);
    }

    protected void method_6099(class_1282 source, int lootingMultiplier, boolean allowDrops) {
        class_1542 itemEntity3;
        class_1542 itemEntity2;
        super.method_6099(source, lootingMultiplier, allowDrops);
        class_1542 itemEntity = this.method_5706((class_1935)ModItems.CHINA_SWORD);
        if (itemEntity != null) {
            itemEntity.method_6976();
            itemEntity.method_5684(true);
        }
        if ((itemEntity2 = this.method_5706((class_1935)class_1802.field_8288)) != null) {
            itemEntity2.method_6976();
            itemEntity2.method_5684(true);
        }
        if ((itemEntity3 = this.method_5706((class_1935)ModItems.CHINA_CORE)) != null) {
            itemEntity3.method_6976();
            itemEntity3.method_5684(true);
        }
    }

    public boolean method_5810() {
        return false;
    }

    public boolean method_5931(class_1657 player) {
        return false;
    }
}

