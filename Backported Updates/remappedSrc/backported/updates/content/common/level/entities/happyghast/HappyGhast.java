/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Dynamic
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1296
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1304
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1313
 *  net.minecraft.class_1330
 *  net.minecraft.class_1331
 *  net.minecraft.class_1333
 *  net.minecraft.class_1335
 *  net.minecraft.class_1335$class_1336
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1352$class_4134
 *  net.minecraft.class_1407
 *  net.minecraft.class_1408
 *  net.minecraft.class_1429
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1856
 *  net.minecraft.class_1922
 *  net.minecraft.class_1937
 *  net.minecraft.class_1959
 *  net.minecraft.class_1959$class_1963
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_241
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2777
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2945$class_9222
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3419
 *  net.minecraft.class_3486
 *  net.minecraft.class_3532
 *  net.minecraft.class_3610
 *  net.minecraft.class_3695
 *  net.minecraft.class_4095
 *  net.minecraft.class_4095$class_5303
 *  net.minecraft.class_4538
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5819
 *  net.minecraft.class_6026
 *  net.minecraft.class_9817
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.entities.happyghast;

import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.api.leash.LeashExtension;
import backported.updates.content.common.level.entities.happyghast.HappyGhastAi;
import backported.updates.content.common.level.entities.happyghast.HappyGhastTemptGoal;
import backported.updates.content.common.registries.ModEntities;
import backported.updates.content.core.VanillaBackport;
import backported.updates.content.core.data.tags.ModBlockTags;
import backported.updates.content.core.data.tags.ModItemTags;
import backported.updates.content.core.util.BlockPosUtils;
import backported.updates.content.core.util.CollisionUtils;
import backported_updates.mixin.access.LivingEntityAccessor;
import com.mojang.serialization.Dynamic;
import java.util.EnumSet;
import java.util.function.BooleanSupplier;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1296;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1304;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1313;
import net.minecraft.class_1330;
import net.minecraft.class_1331;
import net.minecraft.class_1333;
import net.minecraft.class_1335;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1407;
import net.minecraft.class_1408;
import net.minecraft.class_1429;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1856;
import net.minecraft.class_1922;
import net.minecraft.class_1937;
import net.minecraft.class_1959;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_241;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2777;
import net.minecraft.class_2902;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3419;
import net.minecraft.class_3486;
import net.minecraft.class_3532;
import net.minecraft.class_3610;
import net.minecraft.class_3695;
import net.minecraft.class_4095;
import net.minecraft.class_4538;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5819;
import net.minecraft.class_6026;
import net.minecraft.class_9817;
import org.jetbrains.annotations.Nullable;

public class HappyGhast
extends class_1429
implements class_6026,
LeashExtension {
    public static final class_1856 IS_FOOD = class_1856.method_8106(ModItemTags.HAPPY_GHAST_FOOD);
    private int leashHolderTime = 0;
    private int serverStillTimeout;
    private static final class_2940<Boolean> IS_LEASH_HOLDER = class_2945.method_12791(HappyGhast.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> STAYS_STILL = class_2945.method_12791(HappyGhast.class, (class_2941)class_2943.field_13323);
    private boolean requiresPrecisePosition;

    public HappyGhast(class_1299<? extends class_1429> entityType, class_1937 level) {
        super(entityType, level);
        this.field_6207 = new GhastMoveControl(this, true, this::isOnStillTimeout);
        this.field_6206 = new HappyGhastLookControl();
    }

    private void setServerStillTimeout(int timeout) {
        class_1937 class_19372;
        if (this.serverStillTimeout <= 0 && timeout > 0 && (class_19372 = this.method_37908()) instanceof class_3218) {
            class_3218 level = (class_3218)class_19372;
            this.method_43391(this.method_23317(), this.method_23318(), this.method_23321());
            level.method_14178().field_17254.method_18702((class_1297)this, (class_2596)new class_2777((class_1297)this));
        }
        this.serverStillTimeout = timeout;
        this.syncStayStillFlag();
    }

    private class_1408 createBabyNavigation(class_1937 level) {
        return new BabyFlyingPathNavigation((class_1308)this, level);
    }

    protected void method_5959() {
        this.field_6201.method_6277(3, (class_1352)new GhastFloatGoal(this));
        this.field_6201.method_6277(4, (class_1352)new HappyGhastTemptGoal(this, 1.0, stack -> !this.isHarnessed() && !this.method_6109() ? stack.method_31573(ModItemTags.HAPPY_GHAST_TEMPT_ITEMS) : IS_FOOD.method_8093(stack), false, 7.0));
        this.field_6201.method_6277(5, (class_1352)new RandomFloatAroundGoal(this, 16));
    }

    private void adultGhastSetup() {
        this.field_6207 = new GhastMoveControl(this, true, this::isOnStillTimeout);
        this.field_6206 = new HappyGhastLookControl();
        this.field_6189 = this.method_5965(this.method_37908());
        class_1937 class_19372 = this.method_37908();
        if (class_19372 instanceof class_3218) {
            class_3218 server = (class_3218)class_19372;
            this.method_47825(goal -> true);
            this.method_5959();
            this.method_18868().method_18900(server, (class_1309)this);
            this.field_18321.method_49709();
        }
    }

    private void babyGhastSetup() {
        this.field_6207 = new class_1331((class_1308)this, 180, true);
        this.field_6206 = new class_1333((class_1308)this);
        this.field_6189 = this.createBabyNavigation(this.method_37908());
        this.setServerStillTimeout(0);
        this.method_47825(goal -> true);
    }

    protected void method_5619() {
        if (this.method_6109()) {
            this.babyGhastSetup();
        } else {
            this.adultGhastSetup();
        }
        super.method_5619();
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1429.method_26827().method_26868(class_5134.field_23716, 20.0).method_26868(class_5134.field_23720, 0.05).method_26868(class_5134.field_23719, 0.05).method_26868(class_5134.field_23717, 16.0);
    }

    protected float method_56077(float scale) {
        return Math.min(scale, 1.0f);
    }

    public boolean getRequiresPrecisePosition() {
        return this.requiresPrecisePosition;
    }

    public void setRequiresPrecisePosition(boolean requiresPrecisePosition) {
        this.requiresPrecisePosition = requiresPrecisePosition;
    }

    public void method_55695() {
        this.method_5942().method_6340();
        this.method_5938(0.0f);
        this.method_5976(0.0f);
        this.method_6125(0.0f);
        this.method_18800(0.0, 0.0, 0.0);
        this.vb$resetAngularMomentum();
    }

    protected void method_5623(double y, boolean onGround, class_2680 state, class_2338 pos) {
    }

    public void method_6091(class_243 travelVector) {
        if (this.isOnStillTimeout()) {
            this.method_18799(class_243.field_1353);
            return;
        }
        float speed = (float)this.method_45325(class_5134.field_23720) * 5.0f / 3.0f;
        if (this.method_5787()) {
            if (this.method_5799()) {
                this.method_5724(speed, travelVector);
                this.method_5784(class_1313.field_6308, this.method_18798());
                this.method_18799(this.method_18798().method_1021((double)0.8f));
            } else if (this.method_5771()) {
                this.method_5724(speed, travelVector);
                this.method_5784(class_1313.field_6308, this.method_18798());
                this.method_18799(this.method_18798().method_1021(0.5));
            } else {
                this.method_5724(speed, travelVector);
                this.method_5784(class_1313.field_6308, this.method_18798());
                this.method_18799(this.method_18798().method_1021((double)0.91f));
            }
        }
        this.method_29242(false);
    }

    public boolean method_6101() {
        return false;
    }

    public float method_6144(class_2338 pos, class_4538 level) {
        if (!level.method_22347(pos)) {
            return 0.0f;
        }
        return level.method_22347(pos.method_10074()) && !level.method_22347(pos.method_10087(2)) ? 10.0f : 5.0f;
    }

    public boolean method_6094() {
        return this.method_6109() || super.method_6094();
    }

    protected boolean method_43689() {
        return false;
    }

    protected void method_5712(class_2338 pos, class_2680 state) {
    }

    public float method_6017() {
        return 1.0f;
    }

    public int method_5970() {
        int interval = super.method_5970();
        return this.method_5782() ? interval * 6 : interval;
    }

    @Nullable
    protected class_3414 method_5994() {
        return this.method_6109() ? ModSoundEvents.GHASTLING_AMBIENT.get() : ModSoundEvents.HAPPY_GHAST_AMBIENT.get();
    }

    @Nullable
    protected class_3414 method_6011(class_1282 source) {
        return this.method_6109() ? ModSoundEvents.GHASTLING_HURT.get() : ModSoundEvents.HAPPY_GHAST_HURT.get();
    }

    @Nullable
    protected class_3414 method_6002() {
        return this.method_6109() ? ModSoundEvents.GHASTLING_DEATH.get() : ModSoundEvents.HAPPY_GHAST_DEATH.get();
    }

    public int method_5945() {
        return 1;
    }

    @Nullable
    public class_1296 method_5613(class_3218 level, class_1296 mate) {
        return (class_1296)ModEntities.HAPPY_GHAST.get().method_5883((class_1937)level);
    }

    public boolean method_6482() {
        return false;
    }

    public float method_17825() {
        return this.method_6109() ? 0.2375f : 1.0f;
    }

    public boolean method_6481(class_1799 stack) {
        return IS_FOOD.method_8093(stack);
    }

    public void equipHarness() {
        this.method_37908().method_43129(null, (class_1297)this, ModSoundEvents.HARNESS_EQUIP.get(), class_3419.field_15254, 0.5f, 1.0f);
    }

    public boolean canBeHarnessed() {
        return this.method_5805() && !this.method_6109();
    }

    public boolean isHarnessed() {
        return this.method_6118(class_1304.field_6174).method_31573(ModItemTags.HARNESSES);
    }

    public class_1269 method_5992(class_1657 player, class_1268 hand) {
        class_1269 result;
        if (this.method_6109()) {
            return super.method_5992(player, hand);
        }
        class_1799 stack = player.method_5998(hand);
        if (!stack.method_7960() && (result = stack.method_7920(player, (class_1309)this, hand)).method_23665()) {
            return result;
        }
        if (!stack.method_31574(class_1802.field_8868) || this.method_5782() || !this.isHarnessed() && !player.method_7337()) {
            if (this.isHarnessed()) {
                if (!this.method_37908().method_8608()) {
                    player.method_5804((class_1297)this);
                }
                return class_1269.method_29236((boolean)this.method_37908().method_8608());
            }
            return super.method_5992(player, hand);
        }
        stack.method_7970(1, (class_1309)player, HappyGhast.method_56079((class_1268)hand));
        this.method_43077(ModSoundEvents.HARNESS_UNEQUIP.get());
        class_1799 harness = this.method_6118(class_1304.field_6174);
        this.method_5673(class_1304.field_6174, class_1799.field_8037);
        this.method_5699(harness, this.method_17682() + 0.5f);
        return class_1269.field_5812;
    }

    public class_238 method_5830() {
        class_238 box = super.method_5830();
        float height = this.method_17682();
        return box.method_35575(box.field_1322 - (double)(height / 2.0f));
    }

    protected void method_5627(class_1297 passenger) {
        if (!this.method_5782()) {
            this.method_37908().method_43128(null, this.method_23317(), this.method_23318(), this.method_23321(), ModSoundEvents.HARNESS_GOGGLES_DOWN.get(), this.method_5634(), 1.0f, 1.0f);
        }
        super.method_5627(passenger);
        if (!this.method_37908().field_9236) {
            if (!this.scanPlayerAboveGhast()) {
                this.setServerStillTimeout(0);
            } else if (this.serverStillTimeout > 10) {
                this.setServerStillTimeout(10);
            }
        }
    }

    protected void method_5793(class_1297 passenger) {
        super.method_5793(passenger);
        if (!this.method_37908().field_9236) {
            this.setServerStillTimeout(10);
        }
        if (!this.method_5782()) {
            this.method_35055();
            this.method_37908().method_43128(null, this.method_23317(), this.method_23318(), this.method_23321(), ModSoundEvents.HARNESS_GOGGLES_UP.get(), this.method_5634(), 1.0f, 1.0f);
        }
    }

    protected boolean method_5818(class_1297 passenger) {
        return this.method_5685().size() < 4;
    }

    @Nullable
    public class_1309 method_5642() {
        class_1309 class_13092;
        class_1297 class_12972;
        if (this.isHarnessed() && !this.isOnStillTimeout() && (class_12972 = this.method_31483()) instanceof class_1657) {
            class_1657 player = (class_1657)class_12972;
            class_13092 = player;
        } else {
            class_13092 = super.method_5642();
        }
        return class_13092;
    }

    protected class_243 method_49482(class_1657 player, class_243 travelVector) {
        float forward = player.field_6212;
        float strafe = 0.0f;
        float upward = 0.0f;
        if (player.field_6250 != 0.0f) {
            float xOffset = class_3532.method_15362((float)(player.method_36455() * ((float)Math.PI / 180)));
            float zOffset = -class_3532.method_15374((float)(player.method_36455() * ((float)Math.PI / 180)));
            if (player.field_6250 < 0.0f) {
                xOffset *= -0.5f;
                zOffset *= -0.5f;
            }
            upward = zOffset;
            strafe = xOffset;
        }
        if (((LivingEntityAccessor)player).isJumping()) {
            upward += 0.5f;
        }
        return new class_243((double)forward, (double)upward, (double)strafe).method_1021((double)3.9f * this.method_45325(class_5134.field_23720) * VanillaBackport.COMMON_CONFIG.happyGhastSpeedModifier.get());
    }

    protected class_241 getRiddenRotation(class_1309 controller) {
        return new class_241(controller.method_36455() * 0.5f, controller.method_36454());
    }

    protected void method_49481(class_1657 controller, class_243 riddenInput) {
        super.method_49481(controller, riddenInput);
        class_241 rotation = this.getRiddenRotation((class_1309)controller);
        float yRot = this.method_36454();
        float diff = class_3532.method_15393((float)(rotation.field_1342 - yRot));
        this.method_5710(yRot += diff * 0.08f, rotation.field_1343);
        this.field_6283 = this.field_6241 = yRot;
        this.field_5982 = this.field_6241;
    }

    protected class_4095.class_5303<HappyGhast> method_28306() {
        return HappyGhastAi.brainProvider();
    }

    protected class_4095<?> method_18867(Dynamic<?> dynamic) {
        return HappyGhastAi.makeBrain((class_4095<HappyGhast>)this.method_28306().method_28335(dynamic));
    }

    public class_4095<HappyGhast> method_18868() {
        return super.method_18868();
    }

    protected void method_5958() {
        if (this.method_6109()) {
            class_3695 profiler = this.method_37908().method_16107();
            profiler.method_15396("happyGhastBrain");
            this.method_18868().method_19542((class_3218)this.method_37908(), (class_1309)this);
            profiler.method_15405("HappyGhastActivityUpdate");
            HappyGhastAi.updateActivity(this);
            profiler.method_15407();
        }
        this.checkRestriction();
        super.method_5958();
    }

    public void method_5773() {
        super.method_5773();
        if (!this.method_37908().method_8608()) {
            if (this.leashHolderTime > 0) {
                --this.leashHolderTime;
            }
            this.setLeashHolder(this.leashHolderTime > 0);
            if (this.serverStillTimeout > 0) {
                if (this.field_6012 > 60) {
                    --this.serverStillTimeout;
                }
                this.setServerStillTimeout(this.serverStillTimeout);
            }
            if (this.scanPlayerAboveGhast()) {
                this.setServerStillTimeout(10);
            }
        }
    }

    public void method_6007() {
        if (!this.method_37908().field_9236) {
            this.setRequiresPrecisePosition(this.isOnStillTimeout());
        }
        super.method_6007();
        this.continuousHeal();
    }

    private int getHappyGhastRestrictionRadius() {
        return !this.method_6109() && !this.isHarnessed() ? 64 : 32;
    }

    private void checkRestriction() {
        if (!this.method_60953() && !this.method_5782()) {
            int radius = this.getHappyGhastRestrictionRadius();
            if (!this.method_18410() || !this.method_18412().method_19771((class_2382)this.method_24515(), (double)(radius + 16)) || (float)radius != this.method_18413()) {
                this.method_18408(this.method_24515(), radius);
            }
        }
    }

    private void continuousHeal() {
        class_1937 class_19372 = this.method_37908();
        if (class_19372 instanceof class_3218) {
            boolean isFastHealing;
            class_3218 server = (class_3218)class_19372;
            if (this.method_5805() && this.field_6213 == 0 && this.method_6063() != this.method_6032() && this.field_6012 % ((isFastHealing = server.method_8597().comp_645() && (this.isInClouds() || this.precipitationAt(this.method_24515()) != class_1959.class_1963.field_9384)) ? 20 : 600) == 0) {
                this.method_6025(1.0f);
            }
        }
    }

    private class_1959.class_1963 precipitationAt(class_2338 pos) {
        if (!this.method_37908().method_8419()) {
            return class_1959.class_1963.field_9384;
        }
        if (!this.method_37908().method_8311(pos)) {
            return class_1959.class_1963.field_9384;
        }
        if (this.method_37908().method_8598(class_2902.class_2903.field_13197, pos).method_10264() > pos.method_10264()) {
            return class_1959.class_1963.field_9384;
        }
        class_1959 biome = (class_1959)this.method_37908().method_23753(pos).comp_349();
        return biome.method_48162(pos);
    }

    private boolean isInClouds() {
        if (this.method_37908().method_8597().comp_645()) {
            int cloudHeight = 192;
            if (this.method_23318() + (double)this.method_17682() < (double)cloudHeight) {
                return false;
            }
            int cloudRange = cloudHeight + 4;
            return this.method_23318() <= (double)cloudRange;
        }
        return false;
    }

    protected void method_5693(class_2945.class_9222 builder) {
        super.method_5693(builder);
        builder.method_56912(IS_LEASH_HOLDER, (Object)false);
        builder.method_56912(STAYS_STILL, (Object)false);
    }

    private void setLeashHolder(boolean holder) {
        this.field_6011.method_12778(IS_LEASH_HOLDER, (Object)holder);
    }

    public boolean isLeashHolder() {
        return (Boolean)this.field_6011.method_12789(IS_LEASH_HOLDER);
    }

    private void syncStayStillFlag() {
        this.field_6011.method_12778(STAYS_STILL, (Object)(this.serverStillTimeout > 0 ? 1 : 0));
    }

    public boolean staysStill() {
        return (Boolean)this.field_6011.method_12789(STAYS_STILL);
    }

    @Override
    public boolean vb$supportQuadLeashAsHolder() {
        return true;
    }

    @Override
    public class_243[] vb$getQuadLeashHolderOffsets() {
        return LeashExtension.vb$createQuadLeashOffsets((class_1297)this, -0.03125, 0.4375, 0.46875, 0.03125);
    }

    protected class_243 method_29919() {
        return class_243.field_1353;
    }

    @Override
    public double vb$leashElasticDistance() {
        return 10.0;
    }

    @Override
    public double vb$leashSnapDistance() {
        return 16.0;
    }

    @Override
    public void vb$onElasticLeashPull() {
        LeashExtension.super.vb$onElasticLeashPull();
        this.method_5962().field_6374 = class_1335.class_1336.field_6377;
    }

    @Override
    public void vb$notifyLeashHolder(class_9817 leashable) {
        if (((LeashExtension)leashable).vb$supportQuadLeash()) {
            this.leashHolderTime = 5;
        }
    }

    public void method_5652(class_2487 compound) {
        super.method_5652(compound);
        compound.method_10569("still_timeout", this.serverStillTimeout);
    }

    public void method_5749(class_2487 compound) {
        super.method_5749(compound);
        this.setServerStillTimeout(compound.method_10550("still_timeout"));
    }

    public boolean isOnStillTimeout() {
        return this.staysStill() || this.serverStillTimeout > 0;
    }

    private boolean scanPlayerAboveGhast() {
        class_238 bb = this.method_5829();
        class_238 ghastDetectionBox = new class_238(bb.field_1323 - 1.0, bb.field_1325 - (double)1.0E-5f, bb.field_1321 - 1.0, bb.field_1320 + 1.0, bb.field_1325 + bb.method_17940() / 2.0, bb.field_1324 + 1.0);
        for (class_1657 player : this.method_37908().method_18456()) {
            class_1297 rootVehicle;
            if (player.method_7325() || (rootVehicle = player.method_5668()) instanceof HappyGhast || !ghastDetectionBox.method_1006(rootVehicle.method_19538())) continue;
            return true;
        }
        return false;
    }

    protected class_1330 method_5963() {
        return new GhastBodyRotationControl(this);
    }

    public boolean method_30948() {
        if (!this.method_6109() && this.method_5805()) {
            return this.method_5782() || this.isOnStillTimeout();
        }
        return false;
    }

    static class GhastMoveControl
    extends class_1335 {
        private final HappyGhast ghast;
        private int floatDuration;
        private final boolean careful;
        private final BooleanSupplier shouldBeStopped;

        public GhastMoveControl(HappyGhast ghast, boolean careful, BooleanSupplier shouldBeStopped) {
            super((class_1308)ghast);
            this.ghast = ghast;
            this.careful = careful;
            this.shouldBeStopped = shouldBeStopped;
        }

        public void method_6240() {
            if (this.shouldBeStopped.getAsBoolean()) {
                this.field_6374 = class_1335.class_1336.field_6377;
                this.ghast.method_55695();
            }
            if (this.field_6374 == class_1335.class_1336.field_6378 && this.floatDuration-- <= 0) {
                this.floatDuration += this.ghast.method_59922().method_43048(5) + 2;
                class_243 target = new class_243(this.field_6370 - this.ghast.method_23317(), this.field_6369 - this.ghast.method_23318(), this.field_6367 - this.ghast.method_23321());
                if (this.canReach(target)) {
                    this.ghast.method_18799(this.ghast.method_18798().method_1019(target.method_1029().method_1021(this.ghast.method_45325(class_5134.field_23720) * 5.0 / 3.0)));
                } else {
                    this.field_6374 = class_1335.class_1336.field_6377;
                }
            }
        }

        private boolean canReach(class_243 target) {
            class_238 entityBox = this.ghast.method_5829();
            class_238 targetBox = entityBox.method_997(target);
            if (this.careful) {
                for (class_2338 position : BlockPosUtils.betweenClosed(targetBox.method_1014(1.0))) {
                    if (this.blockTraversalPossible((class_1922)this.ghast.method_37908(), null, null, position, false, false)) continue;
                    return false;
                }
            }
            boolean inWater = this.ghast.method_5799();
            boolean inLava = this.ghast.method_5771();
            class_243 currentPos = this.ghast.method_19538();
            class_243 targetPos = currentPos.method_1019(target);
            return BlockPosUtils.forEachBlockIntersectedBetween(currentPos, targetPos, targetBox, (pos, step) -> CollisionUtils.intersects(entityBox, pos) || this.blockTraversalPossible((class_1922)this.ghast.method_37908(), currentPos, targetPos, pos, inWater, inLava));
        }

        private boolean blockTraversalPossible(class_1922 level, @Nullable class_243 origin, @Nullable class_243 target, class_2338 pos, boolean inWater, boolean inLava) {
            boolean noCollisionDetected;
            boolean hasValidPath;
            class_2680 state = level.method_8320(pos);
            if (state.method_26215()) {
                return true;
            }
            boolean bl = hasValidPath = origin != null && target != null;
            boolean bl2 = hasValidPath ? !CollisionUtils.collidedWithShapeMovingFrom((class_1309)this.ghast, origin, target, state.method_26220(level, pos).method_1096((double)pos.method_10263(), (double)pos.method_10264(), (double)pos.method_10260()).method_1090()) : (noCollisionDetected = state.method_26220(level, pos).method_1110());
            if (!this.careful) {
                return noCollisionDetected;
            }
            if (state.method_26164(ModBlockTags.HAPPY_GHAST_AVOIDS)) {
                return false;
            }
            class_3610 fluidState = level.method_8316(pos);
            if (!(fluidState.method_15769() || hasValidPath && !CollisionUtils.collidedWithFluid((class_1309)this.ghast, fluidState, pos, origin, target))) {
                if (fluidState.method_15767(class_3486.field_15517)) {
                    return inWater;
                }
                if (fluidState.method_15767(class_3486.field_15518)) {
                    return inLava;
                }
            }
            return noCollisionDetected;
        }
    }

    class HappyGhastLookControl
    extends class_1333 {
        HappyGhastLookControl() {
            super((class_1308)HappyGhast.this);
        }

        public void method_6231() {
            if (HappyGhast.this.isOnStillTimeout()) {
                float closeAngle = HappyGhastLookControl.wrapDegrees90(HappyGhast.this.method_36454());
                HappyGhast.this.method_36456(HappyGhast.this.method_36454() - closeAngle);
                HappyGhast.this.method_5847(HappyGhast.this.method_36454());
            } else if (this.field_35103 > 0) {
                --this.field_35103;
                double x = this.field_6364 - HappyGhast.this.method_23317();
                double z = this.field_6362 - HappyGhast.this.method_23321();
                HappyGhast.this.method_36456(-((float)class_3532.method_15349((double)x, (double)z)) * 57.295776f);
                HappyGhast.this.field_6241 = HappyGhast.this.field_6283 = HappyGhast.this.method_36454();
            } else {
                if (HappyGhast.this.method_5782() && HappyGhast.this.method_5642() instanceof class_1657) {
                    return;
                }
                class_243 movement = this.field_6361.method_18798();
                this.field_6361.method_36456(-((float)class_3532.method_15349((double)movement.field_1352, (double)movement.field_1350)) * 57.295776f);
                this.field_6361.field_6283 = this.field_6361.method_36454();
            }
        }

        public static float wrapDegrees90(float degrees) {
            float result = degrees % 90.0f;
            if (result >= 45.0f) {
                result -= 90.0f;
            }
            if (result < -45.0f) {
                result += 90.0f;
            }
            return result;
        }
    }

    static class BabyFlyingPathNavigation
    extends class_1407 {
        public BabyFlyingPathNavigation(class_1308 mob, class_1937 level) {
            super(mob, level);
            this.method_6332(false);
            this.method_6354(true);
        }

        protected boolean method_6341(class_243 posVec31, class_243 posVec32) {
            return BabyFlyingPathNavigation.method_43394((class_1308)this.field_6684, (class_243)posVec31, (class_243)posVec32, (boolean)false);
        }
    }

    static class GhastFloatGoal
    extends class_1347 {
        private final HappyGhast ghast;

        public GhastFloatGoal(HappyGhast ghast) {
            super((class_1308)ghast);
            this.ghast = ghast;
        }

        public boolean method_6264() {
            return !this.ghast.isOnStillTimeout() && super.method_6264();
        }
    }

    static class RandomFloatAroundGoal
    extends class_1352 {
        private final HappyGhast ghast;
        private final int distanceToBlocks;

        public RandomFloatAroundGoal(HappyGhast ghast, int distanceToBlocks) {
            this.ghast = ghast;
            this.distanceToBlocks = distanceToBlocks;
            this.method_6265(EnumSet.of(class_1352.class_4134.field_18405));
        }

        public boolean method_6264() {
            double z;
            double y;
            class_1335 control = this.ghast.method_5962();
            if (!control.method_6241()) {
                return true;
            }
            double x = control.method_6236() - this.ghast.method_23317();
            double distance = x * x + (y = control.method_6235() - this.ghast.method_23318()) * y + (z = control.method_6237() - this.ghast.method_23321()) * z;
            return distance < 1.0 || distance > 3600.0;
        }

        public boolean method_6266() {
            return false;
        }

        public void method_6269() {
            class_243 target = RandomFloatAroundGoal.getSuitableFlyToPosition((class_1308)this.ghast, this.distanceToBlocks);
            this.ghast.method_5962().method_6239(target.method_10216(), target.method_10214(), target.method_10215(), 1.0);
        }

        public static class_243 getSuitableFlyToPosition(class_1308 mob, int distanceToBlocks) {
            class_2338 pos;
            int floor;
            class_1937 level = mob.method_37908();
            class_5819 random = mob.method_59922();
            class_243 origin = mob.method_19538();
            class_243 target = null;
            for (int attempt = 0; attempt < 64; ++attempt) {
                target = RandomFloatAroundGoal.chooseRandomPositionWithRestriction(mob, origin, random);
                if (target == null || !RandomFloatAroundGoal.isGoodTarget(level, target, distanceToBlocks)) continue;
                return target;
            }
            if (target == null) {
                target = RandomFloatAroundGoal.chooseRandomPosition(origin, random);
            }
            if ((floor = level.method_8624(class_2902.class_2903.field_13197, (pos = class_2338.method_49638(target)).method_10263(), pos.method_10260())) < pos.method_10264() && floor > level.method_31607()) {
                target = new class_243(target.method_10216(), mob.method_23318() - Math.abs(mob.method_23318() - target.method_10214()), target.method_10215());
            }
            return target;
        }

        private static boolean isGoodTarget(class_1937 level, class_243 target, int distanceToBlocks) {
            if (distanceToBlocks <= 0) {
                return true;
            }
            class_2338 pos = class_2338.method_49638((class_2374)target);
            if (level.method_8320(pos).method_26215()) {
                for (class_2350 direction : class_2350.values()) {
                    for (int distance = 1; distance < distanceToBlocks; ++distance) {
                        class_2338 neighbor = pos.method_10079(direction, distance);
                        if (level.method_8320(neighbor).method_26215()) continue;
                        return true;
                    }
                }
            }
            return false;
        }

        private static class_243 chooseRandomPosition(class_243 origin, class_5819 random) {
            double x = origin.method_10216() + (double)((random.method_43057() * 2.0f - 1.0f) * 16.0f);
            double y = origin.method_10214() + (double)((random.method_43057() * 2.0f - 1.0f) * 16.0f);
            double z = origin.method_10215() + (double)((random.method_43057() * 2.0f - 1.0f) * 16.0f);
            return new class_243(x, y, z);
        }

        @Nullable
        private static class_243 chooseRandomPositionWithRestriction(class_1308 mob, class_243 origin, class_5819 random) {
            class_243 target = RandomFloatAroundGoal.chooseRandomPosition(origin, random);
            return mob.method_18410() && !mob.method_18407(class_2338.method_49638((class_2374)target)) ? null : target;
        }
    }

    static class GhastBodyRotationControl
    extends class_1330 {
        private final HappyGhast ghast;

        public GhastBodyRotationControl(HappyGhast ghast) {
            super((class_1308)ghast);
            this.ghast = ghast;
        }

        public void method_6224() {
            if (this.ghast.method_5782()) {
                this.ghast.field_6283 = this.ghast.field_6241 = this.ghast.method_36454();
            }
            super.method_6224();
        }
    }
}

