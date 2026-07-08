/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.serialization.Dynamic
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_13
 *  net.minecraft.class_1304
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1330
 *  net.minecraft.class_1333
 *  net.minecraft.class_1334
 *  net.minecraft.class_1335
 *  net.minecraft.class_14
 *  net.minecraft.class_1408
 *  net.minecraft.class_1409
 *  net.minecraft.class_1493
 *  net.minecraft.class_1588
 *  net.minecraft.class_1657
 *  net.minecraft.class_1676
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_2382
 *  net.minecraft.class_2388
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2512
 *  net.minecraft.class_2586
 *  net.minecraft.class_2680
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2945$class_9222
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3695
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_4095
 *  net.minecraft.class_4095$class_5303
 *  net.minecraft.class_4140
 *  net.minecraft.class_4538
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_7
 *  net.minecraft.class_7094
 *  net.minecraft.class_8103
 *  net.minecraft.class_9316
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.content.common.level.entities.creaking;

import backported.updates.content.client.registries.ModParticles;
import backported.updates.content.client.registries.ModSoundEvents;
import backported.updates.content.common.level.blockentities.CreakingHeartBlockEntity;
import backported.updates.content.common.level.blocks.CreakingHeartBlock;
import backported.updates.content.common.level.blocks.blockstates.CreakingHeartState;
import backported.updates.content.common.level.entities.creaking.CreakingAi;
import backported.updates.content.common.registries.ModBlocks;
import com.mojang.serialization.Dynamic;
import java.util.List;
import java.util.Optional;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_13;
import net.minecraft.class_1304;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1330;
import net.minecraft.class_1333;
import net.minecraft.class_1334;
import net.minecraft.class_1335;
import net.minecraft.class_14;
import net.minecraft.class_1408;
import net.minecraft.class_1409;
import net.minecraft.class_1493;
import net.minecraft.class_1588;
import net.minecraft.class_1657;
import net.minecraft.class_1676;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2382;
import net.minecraft.class_2388;
import net.minecraft.class_239;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2512;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3695;
import net.minecraft.class_3959;
import net.minecraft.class_4095;
import net.minecraft.class_4140;
import net.minecraft.class_4538;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_7;
import net.minecraft.class_7094;
import net.minecraft.class_8103;
import net.minecraft.class_9316;
import org.jetbrains.annotations.Nullable;

public class Creaking
extends class_1588 {
    private static final class_2940<Boolean> CAN_MOVE = class_2945.method_12791(Creaking.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> IS_ACTIVE = class_2945.method_12791(Creaking.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Boolean> IS_TEARING_DOWN = class_2945.method_12791(Creaking.class, (class_2941)class_2943.field_13323);
    private static final class_2940<Optional<class_2338>> HOME_POS = class_2945.method_12791(Creaking.class, (class_2941)class_2943.field_13315);
    public static final byte CREAKING_ATTACK = 4;
    public static final byte CREAKING_HURT = 66;
    private int attackAnimationRemainingTicks;
    public final class_7094 attackAnimationState = new class_7094();
    public final class_7094 invulnerabilityAnimationState = new class_7094();
    public final class_7094 deathAnimationState = new class_7094();
    private int invulnerabilityAnimationRemainingTicks;
    private boolean eyesGlowing;
    private int nextFlickerTime;
    private int playerStuckCounter;
    private int creakingDeathTime;

    public Creaking(class_1299<? extends class_1588> entityType, class_1937 level) {
        super(entityType, level);
        this.field_6206 = new CreakingLookControl((class_1308)this);
        this.field_6207 = new CreakingMoveControl((class_1308)this);
        this.field_6204 = new CreakingJumpControl((class_1308)this);
        class_1409 navigation = (class_1409)this.method_5942();
        navigation.method_6354(true);
        this.field_6194 = 0;
    }

    public void setTransient(class_2338 pos) {
        this.setHomePos(pos);
        this.method_5941(class_7.field_17, 8.0f);
        this.method_5941(class_7.field_33534, 8.0f);
        this.method_5941(class_7.field_14, 8.0f);
        this.method_5941(class_7.field_3, 0.0f);
        this.method_5941(class_7.field_9, 0.0f);
    }

    public boolean isHeartBound() {
        return this.getHomePos() != null;
    }

    protected class_1330 method_5963() {
        return new CreakingBodyRotationControl((class_1308)this);
    }

    protected class_4095.class_5303<Creaking> method_28306() {
        return CreakingAi.brainProvider();
    }

    protected class_4095<?> method_18867(Dynamic<?> dynamic) {
        return CreakingAi.makeBrain((class_4095<Creaking>)this.method_28306().method_28335(dynamic));
    }

    protected void method_5693(class_2945.class_9222 builder) {
        super.method_5693(builder);
        builder.method_56912(CAN_MOVE, (Object)true);
        builder.method_56912(IS_ACTIVE, (Object)false);
        builder.method_56912(IS_TEARING_DOWN, (Object)false);
        builder.method_56912(HOME_POS, Optional.empty());
    }

    public static class_5132.class_5133 createAttributes() {
        return class_1588.method_26918().method_26868(class_5134.field_23716, 1.0).method_26868(class_5134.field_23719, 0.4).method_26868(class_5134.field_23721, 3.0).method_26868(class_5134.field_23717, 32.0).method_26868(class_5134.field_47761, 1.0625);
    }

    public boolean canMove() {
        return (Boolean)this.field_6011.method_12789(CAN_MOVE);
    }

    public boolean method_6121(class_1297 target) {
        if (!(target instanceof class_1309)) {
            return false;
        }
        this.attackAnimationRemainingTicks = 15;
        this.method_37908().method_8421((class_1297)this, (byte)4);
        return super.method_6121(target);
    }

    public boolean method_5643(class_1282 source, float amount) {
        class_2338 home = this.getHomePos();
        if (home == null || source.method_48789(class_8103.field_42242)) {
            return super.method_5643(source, amount);
        }
        if (!this.method_5679(source) && this.invulnerabilityAnimationRemainingTicks <= 0 && !this.method_29504()) {
            class_1657 player = this.blameSourceForDamage(source);
            class_1297 entity = source.method_5526();
            if (entity instanceof class_1309 || entity instanceof class_1676 || player != null) {
                CreakingHeartBlockEntity heart;
                this.invulnerabilityAnimationRemainingTicks = 8;
                this.method_37908().method_8421((class_1297)this, (byte)66);
                class_2586 class_25862 = this.method_37908().method_8321(home);
                if (class_25862 instanceof CreakingHeartBlockEntity && (heart = (CreakingHeartBlockEntity)class_25862).isProtector(this)) {
                    if (player != null) {
                        heart.creakingHurt();
                    }
                    this.method_6013(source);
                }
                return true;
            }
        }
        return false;
    }

    @Nullable
    public class_1657 blameSourceForDamage(class_1282 source) {
        class_1297 entity = source.method_5529();
        if (entity instanceof class_1309) {
            class_1309 living = (class_1309)entity;
            if (!source.method_48789(class_8103.field_42254)) {
                class_1493 wolf;
                this.method_6015(living);
                if (entity instanceof class_1657) {
                    class_1657 player = (class_1657)entity;
                    this.field_6238 = 100;
                    this.field_6258 = player;
                } else if (entity instanceof class_1493 && (wolf = (class_1493)entity).method_6181()) {
                    class_1657 player;
                    this.field_6238 = 100;
                    class_1309 class_13092 = wolf.method_35057();
                    this.field_6258 = class_13092 instanceof class_1657 ? (player = (class_1657)class_13092) : null;
                }
            }
        }
        return this.field_6258;
    }

    public boolean method_5810() {
        return super.method_5810() && this.canMove();
    }

    public void method_5762(double x, double y, double z) {
        if (this.canMove()) {
            super.method_5762(x, y, z);
        }
    }

    public class_4095<Creaking> method_18868() {
        return super.method_18868();
    }

    protected void method_5958() {
        class_3695 profiler = this.method_37908().method_16107();
        profiler.method_15396("creakingBrain");
        this.method_18868().method_19542((class_3218)this.method_37908(), (class_1309)this);
        profiler.method_15407();
        CreakingAi.updateActivity(this);
    }

    public void method_6007() {
        if (this.invulnerabilityAnimationRemainingTicks > 0) {
            --this.invulnerabilityAnimationRemainingTicks;
        }
        if (this.attackAnimationRemainingTicks > 0) {
            --this.attackAnimationRemainingTicks;
        }
        if (!this.method_37908().method_8608()) {
            boolean canMove = (Boolean)this.field_6011.method_12789(CAN_MOVE);
            boolean checkCanMove = this.checkCanMove();
            if (checkCanMove != canMove) {
                if (checkCanMove) {
                    this.method_43077(ModSoundEvents.CREAKING_UNFREEZE.get());
                } else {
                    this.method_5942().method_6340();
                    this.method_5938(0.0f);
                    this.method_5976(0.0f);
                    this.method_6125(0.0f);
                    this.method_43077(ModSoundEvents.CREAKING_FREEZE.get());
                }
            }
            this.field_6011.method_12778(CAN_MOVE, (Object)checkCanMove);
        }
        super.method_6007();
    }

    public void method_5773() {
        class_2338 pos;
        if (!this.method_37908().method_8608() && (pos = this.getHomePos()) != null) {
            CreakingHeartBlockEntity heart;
            boolean isProtector;
            class_2586 class_25862 = this.method_37908().method_8321(pos);
            boolean bl = isProtector = class_25862 instanceof CreakingHeartBlockEntity && (heart = (CreakingHeartBlockEntity)class_25862).isProtector(this);
            if (!isProtector) {
                this.method_6033(0.0f);
            }
        }
        super.method_5773();
        if (this.method_37908().method_8608()) {
            if (this.isTearingDown() && this.field_6213 != 0) {
                this.field_6213 = 0;
            }
            this.setupAnimationStates();
            this.checkEyeBlink();
        }
    }

    protected void method_6108() {
        if (this.isHeartBound() && this.isTearingDown()) {
            ++this.creakingDeathTime;
            if (!this.method_37908().method_8608() && this.creakingDeathTime > 45 && !this.method_31481()) {
                this.tearDown();
            }
        } else {
            super.method_6108();
        }
    }

    protected void method_48565(float partialTick) {
        float speed = Math.min(partialTick * 25.0f, 3.0f);
        this.field_42108.method_48568(speed, 0.4f);
    }

    private void setupAnimationStates() {
        this.attackAnimationState.method_45317(this.attackAnimationRemainingTicks > 0, this.field_6012);
        this.invulnerabilityAnimationState.method_45317(this.invulnerabilityAnimationRemainingTicks > 0, this.field_6012);
        this.deathAnimationState.method_45317(this.isTearingDown(), this.field_6012);
    }

    public void tearDown() {
        class_1937 class_19372 = this.method_37908();
        if (class_19372 instanceof class_3218) {
            class_3218 server = (class_3218)class_19372;
            class_238 aabb = this.method_5829();
            class_243 center = aabb.method_1005();
            double x = aabb.method_17939() * 0.3;
            double y = aabb.method_17940() * 0.3;
            double z = aabb.method_17941() * 0.3;
            ModParticles.sendParticles(server, new class_2388(class_2398.field_11217, ModBlocks.PALE_OAK_WOOD.get().method_9564()), center.field_1352, center.field_1351, center.field_1350, 100, x, y, z, 0.0);
            ModParticles.sendParticles(server, new class_2388(class_2398.field_11217, (class_2680)ModBlocks.CREAKING_HEART.get().method_9564().method_11657(CreakingHeartBlock.STATE, (Comparable)((Object)CreakingHeartState.AWAKE))), center.field_1352, center.field_1351, center.field_1350, 10, x, y, z, 0.0);
        }
        this.method_43077(this.method_6002());
        this.method_31472();
    }

    public void creakingDeathEffects(class_1282 source) {
        this.blameSourceForDamage(source);
        this.method_6078(source);
        this.method_43077(ModSoundEvents.CREAKING_TWITCH.get());
    }

    public void method_5711(byte id) {
        if (id == 66) {
            this.invulnerabilityAnimationRemainingTicks = 8;
            this.method_6013(this.method_48923().method_48830());
        } else if (id == 4) {
            this.attackAnimationRemainingTicks = 15;
            this.method_59928();
        } else {
            super.method_5711(id);
        }
    }

    public boolean method_5753() {
        return this.isHeartBound() || super.method_5753();
    }

    protected boolean method_5818(class_1297 passenger) {
        return !this.isHeartBound() && super.method_5818(passenger);
    }

    protected boolean method_48921() {
        return !this.isHeartBound() && super.method_48921();
    }

    protected void method_5627(class_1297 passenger) {
        if (!this.isHeartBound()) {
            super.method_5627(passenger);
        }
    }

    public boolean method_5822(boolean allowPassengers) {
        return !this.isHeartBound() && super.method_5822(allowPassengers);
    }

    protected class_1408 method_5965(class_1937 level) {
        return new CreakingPathNavigation(this, level);
    }

    public boolean playerIsStuckInYou() {
        List players = this.field_18321.method_18904(class_4140.field_18443).orElse(List.of());
        if (!players.isEmpty()) {
            class_238 aabb = this.method_5829();
            for (class_1657 player : players) {
                if (!aabb.method_1006(player.method_33571())) continue;
                ++this.playerStuckCounter;
                return this.playerStuckCounter > 4;
            }
        }
        this.playerStuckCounter = 0;
        return false;
    }

    public void method_5749(class_2487 tag) {
        super.method_5749(tag);
        if (tag.method_10545("home_pos")) {
            this.setTransient((class_2338)class_2512.method_10691((class_2487)tag, (String)"home_pos").get());
        }
    }

    public void method_5652(class_2487 tag) {
        super.method_5652(tag);
        if (this.getHomePos() != null) {
            tag.method_10566("home_pos", class_2512.method_10692((class_2338)this.getHomePos()));
        }
    }

    public void setHomePos(class_2338 pos) {
        this.field_6011.method_12778(HOME_POS, Optional.of(pos));
    }

    public class_2338 getHomePos() {
        return ((Optional)this.field_6011.method_12789(HOME_POS)).orElse(null);
    }

    public void setTearingDown() {
        this.field_6011.method_12778(IS_TEARING_DOWN, (Object)true);
    }

    public boolean isTearingDown() {
        return (Boolean)this.field_6011.method_12789(IS_TEARING_DOWN);
    }

    public boolean hasGlowingEyes() {
        return this.eyesGlowing;
    }

    public boolean shouldEyesGlow() {
        return this.isTearingDown() ? this.hasGlowingEyes() : this.isActive();
    }

    public void checkEyeBlink() {
        if (this.creakingDeathTime > this.nextFlickerTime) {
            this.nextFlickerTime = this.creakingDeathTime + this.method_59922().method_39332(this.eyesGlowing ? 2 : this.creakingDeathTime / 4, this.eyesGlowing ? 8 : this.creakingDeathTime / 2);
            this.eyesGlowing = !this.eyesGlowing;
        }
    }

    public void method_59928() {
        this.method_37908().method_8486(this.method_23317(), this.method_23318(), this.method_23321(), ModSoundEvents.CREAKING_ATTACK.get(), this.method_5634(), 1.0f, 1.0f, false);
    }

    @Nullable
    protected class_3414 method_5994() {
        return this.isActive() ? null : ModSoundEvents.CREAKING_AMBIENT.get();
    }

    protected class_3414 method_6011(class_1282 source) {
        return this.isHeartBound() ? ModSoundEvents.CREAKING_SWAY.get() : super.method_6011(source);
    }

    protected class_3414 method_6002() {
        return ModSoundEvents.CREAKING_DEATH.get();
    }

    protected void method_5712(class_2338 pos, class_2680 state) {
        this.method_5783(ModSoundEvents.CREAKING_STEP.get(), 0.15f, 1.0f);
    }

    @Nullable
    public class_1309 method_5968() {
        return this.method_18868().method_18904(class_4140.field_22355).orElse(null);
    }

    public void method_6005(double strength, double x, double z) {
        if (this.canMove()) {
            super.method_6005(strength, x, z);
        }
    }

    public boolean checkCanMove() {
        List players = this.field_18321.method_18904(class_4140.field_18443).orElse(List.of());
        boolean isActive = this.isActive();
        if (players.isEmpty()) {
            if (isActive) {
                this.deactivate();
            }
        } else {
            boolean canMove = false;
            for (class_1657 player : players) {
                if (!this.method_18395((class_1309)player) || this.method_5722((class_1297)player)) continue;
                canMove = true;
                if (isActive && player.method_6118(class_1304.field_6169).method_31574(class_2246.field_10147.method_8389()) || !this.isLookingAtMe((class_1309)player, 0.5, false, true, this.method_23320(), this.method_23318() + 0.5 * (double)this.method_55693(), (this.method_23320() + this.method_23318()) / 2.0)) continue;
                if (isActive) {
                    return false;
                }
                if (!(player.method_5858((class_1297)this) < 144.0)) continue;
                this.activate(player);
                return false;
            }
            if (!canMove && isActive) {
                this.deactivate();
            }
        }
        return true;
    }

    public boolean isLookingAtMe(class_1309 entity, double tolerance, boolean scaleWithDistance, boolean checkVisibility, double ... heightTargets) {
        class_243 viewVector = entity.method_5828(1.0f).method_1029();
        for (double heightTarget : heightTargets) {
            double lookThreshold;
            class_243 directionToMe = new class_243(this.method_23317() - entity.method_23317(), heightTarget - entity.method_23320(), this.method_23321() - entity.method_23321());
            double distance = directionToMe.method_1033();
            double dotProduct = viewVector.method_1026(directionToMe = directionToMe.method_1029());
            if (!(dotProduct > (lookThreshold = 1.0 - tolerance / (scaleWithDistance ? distance : 1.0))) || !this.hasLineOfSight(entity, (class_1297)this, checkVisibility ? class_3959.class_3960.field_23142 : class_3959.class_3960.field_17558, class_3959.class_242.field_1348, heightTarget)) continue;
            return true;
        }
        return false;
    }

    public boolean hasLineOfSight(class_1309 stalker, class_1297 me, class_3959.class_3960 block, class_3959.class_242 fluid, double targetHeight) {
        if (me.method_37908() != stalker.method_37908()) {
            return false;
        }
        class_243 stalkerPosition = new class_243(stalker.method_23317(), stalker.method_23320(), stalker.method_23321());
        class_243 myPosition = new class_243(me.method_23317(), targetHeight, me.method_23321());
        return myPosition.method_1022(stalkerPosition) <= 128.0 && stalker.method_37908().method_17742(new class_3959(stalkerPosition, myPosition, block, fluid, (class_1297)stalker)).method_17783() == class_239.class_240.field_1333;
    }

    public void activate(class_1657 player) {
        this.method_18868().method_18878(class_4140.field_22355, (Object)player);
        this.method_43077(ModSoundEvents.CREAKING_ACTIVATE.get());
        this.setIsActive(true);
    }

    public void deactivate() {
        this.method_18868().method_18875(class_4140.field_22355);
        this.method_43077(ModSoundEvents.CREAKING_DEACTIVATE.get());
        this.setIsActive(false);
    }

    public void setIsActive(boolean active) {
        this.field_6011.method_12778(IS_ACTIVE, (Object)active);
    }

    public boolean isActive() {
        return (Boolean)this.field_6011.method_12789(IS_ACTIVE);
    }

    public float method_6144(class_2338 pos, class_4538 level) {
        return 0.0f;
    }

    class CreakingLookControl
    extends class_1333 {
        public CreakingLookControl(class_1308 mob) {
            super(mob);
        }

        public void method_6231() {
            if (Creaking.this.canMove()) {
                super.method_6231();
            }
        }
    }

    class CreakingMoveControl
    extends class_1335 {
        public CreakingMoveControl(class_1308 mob) {
            super(mob);
        }

        public void method_6240() {
            if (Creaking.this.canMove()) {
                super.method_6240();
            }
        }
    }

    class CreakingJumpControl
    extends class_1334 {
        public CreakingJumpControl(class_1308 mob) {
            super(mob);
        }

        public void method_6234() {
            if (Creaking.this.canMove()) {
                super.method_6234();
            } else {
                Creaking.this.method_6100(false);
            }
        }
    }

    class CreakingBodyRotationControl
    extends class_1330 {
        public CreakingBodyRotationControl(class_1308 mob) {
            super(mob);
        }

        public void method_6224() {
            if (Creaking.this.canMove()) {
                super.method_6224();
            }
        }
    }

    class CreakingPathNavigation
    extends class_1409 {
        CreakingPathNavigation(Creaking creaking2, class_1937 level) {
            super((class_1308)creaking2, level);
        }

        public void method_6360() {
            if (Creaking.this.canMove()) {
                super.method_6360();
            }
        }

        protected class_13 method_6336(int i) {
            this.field_6678 = new HomeNodeEvaluator();
            this.field_6678.method_15(true);
            return new class_13(this.field_6678, i);
        }
    }

    class HomeNodeEvaluator
    extends class_14 {
        HomeNodeEvaluator() {
        }

        public class_7 method_17(class_9316 context, int x, int y, int z) {
            class_2338 pos = Creaking.this.getHomePos();
            if (pos == null) {
                return super.method_17(context, x, y, z);
            }
            double distance = pos.method_10262(new class_2382(x, y, z));
            return distance > 1024.0 && distance >= pos.method_10262((class_2382)context.method_57624()) ? class_7.field_22 : super.method_17(context, x, y, z);
        }
    }
}

