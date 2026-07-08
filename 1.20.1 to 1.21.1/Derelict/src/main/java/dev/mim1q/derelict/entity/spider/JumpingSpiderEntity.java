/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.AnimatedProperty
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1330
 *  net.minecraft.class_1352
 *  net.minecraft.class_1352$class_4134
 *  net.minecraft.class_1359
 *  net.minecraft.class_1628
 *  net.minecraft.class_1937
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3417
 *  net.minecraft.class_3532
 *  net.minecraft.class_4538
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.entity.spider;

import dev.mim1q.derelict.entity.spider.control.ArachneBodyControl;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.gimm1q.interpolation.AnimatedProperty;
import dev.mim1q.gimm1q.interpolation.Easing;
import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1330;
import net.minecraft.class_1352;
import net.minecraft.class_1359;
import net.minecraft.class_1628;
import net.minecraft.class_1937;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3417;
import net.minecraft.class_3532;
import net.minecraft.class_4538;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001f\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0012\u0010\nJ\u0019\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0017\u0010&\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006,"}, d2={"Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity;", "Lnet/minecraft/class_1628;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initDataTracker", "()V", "initGoals", "Lnet/minecraft/class_2338;", "pos", "Lnet/minecraft/class_2680;", "state", "playStepSound", "(Lnet/minecraft/class_2338;Lnet/minecraft/class_2680;)V", "tick", "Lnet/minecraft/class_1309;", "target", "setTarget", "(Lnet/minecraft/class_1309;)V", "Lnet/minecraft/class_1330;", "createBodyControl", "()Lnet/minecraft/class_1330;", "Lnet/minecraft/class_4538;", "", "canSpawn", "(Lnet/minecraft/class_4538;)Z", "", "jumpAttackCooldown", "I", "getJumpAttackCooldown", "()I", "setJumpAttackCooldown", "(I)V", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "jumpChargeAnimation", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "getJumpChargeAnimation", "()Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "Companion", "JumpingSpiderJumpAttack", "derelict"})
public final class JumpingSpiderEntity
extends class_1628 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int jumpAttackCooldown;
    @NotNull
    private final AnimatedProperty jumpChargeAnimation;
    @NotNull
    private static final class_2940<Boolean> JUMP_CHARGING;
    @NotNull
    private static final class_2940<Integer> TARGET_ID;

    public JumpingSpiderEntity(@NotNull class_1299<? extends JumpingSpiderEntity> entityType, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(entityType, world);
        this.jumpAttackCooldown = 40;
        this.jumpChargeAnimation = new AnimatedProperty(0.0f, Easing::easeOutCubic);
    }

    public final int getJumpAttackCooldown() {
        return this.jumpAttackCooldown;
    }

    public final void setJumpAttackCooldown(int n) {
        this.jumpAttackCooldown = n;
    }

    @NotNull
    public final AnimatedProperty getJumpChargeAnimation() {
        return this.jumpChargeAnimation;
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(JUMP_CHARGING, (Object)false);
        this.field_6011.method_12784(TARGET_ID, (Object)-1);
    }

    protected void method_5959() {
        super.method_5959();
        this.method_47825(JumpingSpiderEntity::initGoals$lambda$0);
        this.field_6201.method_6277(0, (class_1352)new JumpingSpiderJumpAttack());
    }

    protected void method_5712(@NotNull class_2338 pos, @NotNull class_2680 state) {
        Intrinsics.checkNotNullParameter((Object)pos, (String)"pos");
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        if (!((Boolean)this.field_6011.method_12789(JUMP_CHARGING)).booleanValue()) {
            super.method_5712(pos, state);
        }
    }

    public void method_5773() {
        super.method_5773();
        if (!this.method_37908().field_9236) {
            this.jumpAttackCooldown = Math.max(0, this.jumpAttackCooldown - 1);
        } else {
            boolean bl = (Boolean)this.field_6011.method_12789(JUMP_CHARGING) != false ? this.jumpChargeAnimation.transitionTo(1.0f, 20.0f) : this.jumpChargeAnimation.transitionTo(0.0f, 20.0f);
        }
        Boolean isChargingJump = (Boolean)this.field_6011.method_12789(JUMP_CHARGING);
        class_1937 class_19372 = this.method_37908();
        Object object = this.field_6011.method_12789(TARGET_ID);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        class_1297 trackedTarget = class_19372.method_8469(((Number)object).intValue());
        if (isChargingJump.booleanValue() && trackedTarget != null) {
            this.method_23327(class_3532.method_16436((double)0.01, (double)this.field_6014, (double)this.method_23317()), this.method_23318(), class_3532.method_16436((double)0.01, (double)this.field_5969, (double)this.method_23321()));
            this.field_6283 = class_3532.method_17821((float)0.2f, (float)this.field_6220, (float)((float)MathExtensionsKt.degrees(Math.atan2(trackedTarget.method_23321() - this.method_23321(), trackedTarget.method_23317() - this.method_23317())) - 90.0f));
        }
    }

    public void method_5980(@Nullable class_1309 target) {
        super.method_5980(target);
        class_1309 class_13092 = target;
        this.field_6011.method_12778(TARGET_ID, (Object)(class_13092 != null ? class_13092.method_5628() : -1));
    }

    @NotNull
    protected class_1330 method_5963() {
        return new ArachneBodyControl((class_1308)this, 0.7f);
    }

    public boolean method_5957(@NotNull class_4538 world) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        return super.method_5957(world) && world.method_22339(this.method_24515()) == 0;
    }

    private static final boolean initGoals$lambda$0(class_1352 it) {
        return it instanceof class_1359;
    }

    static {
        class_2940 class_29402 = class_2945.method_12791(JumpingSpiderEntity.class, (class_2941)class_2943.field_13323);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        JUMP_CHARGING = class_29402;
        class_2940 class_29403 = class_2945.method_12791(JumpingSpiderEntity.class, (class_2941)class_2943.field_13327);
        Intrinsics.checkNotNullExpressionValue((Object)class_29403, (String)"registerData(...)");
        TARGET_ID = class_29403;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2940;", "", "JUMP_CHARGING", "Lnet/minecraft/class_2940;", "getJUMP_CHARGING", "()Lnet/minecraft/class_2940;", "", "TARGET_ID", "getTARGET_ID", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2940<Boolean> getJUMP_CHARGING() {
            return JUMP_CHARGING;
        }

        @NotNull
        public final class_2940<Integer> getTARGET_ID() {
            return TARGET_ID;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\f\u0010\nR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2={"Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity$JumpingSpiderJumpAttack;", "Lnet/minecraft/class_1352;", "<init>", "(Ldev/mim1q/derelict/entity/spider/JumpingSpiderEntity;)V", "", "canStart", "()Z", "shouldContinue", "", "tick", "()V", "stop", "start", "", "ticks", "I", "derelict"})
    @SourceDebugExtension(value={"SMAP\nJumpingSpiderEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JumpingSpiderEntity.kt\ndev/mim1q/derelict/entity/spider/JumpingSpiderEntity$JumpingSpiderJumpAttack\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,136:1\n1#2:137\n*E\n"})
    public final class JumpingSpiderJumpAttack
    extends class_1352 {
        private int ticks;

        public JumpingSpiderJumpAttack() {
            this.method_6265(EnumSet.of((Enum)class_1352.class_4134.field_18405, (Enum)class_1352.class_4134.field_18406, (Enum)class_1352.class_4134.field_18407));
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean method_6264() {
            if (JumpingSpiderEntity.this.method_5968() == null) return false;
            class_1309 class_13092 = JumpingSpiderEntity.this.method_5968();
            Intrinsics.checkNotNull((Object)class_13092);
            if (!(class_13092.method_23318() <= JumpingSpiderEntity.this.method_23318())) return false;
            if (JumpingSpiderEntity.this.getJumpAttackCooldown() > 0) return false;
            if (!(JumpingSpiderEntity.this.field_5974.method_43057() < 0.2f)) return false;
            return true;
        }

        public boolean method_6266() {
            return JumpingSpiderEntity.this.method_5968() != null && this.ticks < 15;
        }

        public void method_6268() {
            ++this.ticks;
        }

        /*
         * WARNING - void declaration
         */
        public void method_6270() {
            class_1309 currentTarget = JumpingSpiderEntity.this.method_5968();
            if (currentTarget != null) {
                void it;
                JumpingSpiderEntity.this.method_5783(class_3417.field_14869, 1.0f, 1.4f);
                class_243 class_2432 = currentTarget.method_33571().method_1020(JumpingSpiderEntity.this.method_33571());
                JumpingSpiderEntity jumpingSpiderEntity = JumpingSpiderEntity.this;
                boolean bl = false;
                jumpingSpiderEntity.method_18799(new class_243(it.field_1352, class_3532.method_15350((double)it.field_1351, (double)0.0, (double)0.2), it.field_1350).method_1029().method_1021(2.0).method_1031(0.0, 0.2, 0.0));
                JumpingSpiderEntity.this.field_6037 = true;
                JumpingSpiderEntity.this.field_6007 = true;
            }
            JumpingSpiderEntity.this.field_6011.method_12778(Companion.getJUMP_CHARGING(), (Object)false);
            JumpingSpiderEntity.this.setJumpAttackCooldown(40 + JumpingSpiderEntity.this.field_5974.method_43048(100));
        }

        public void method_6269() {
            JumpingSpiderEntity.this.method_5783(class_3417.field_14657, 1.0f, 1.5f);
            this.ticks = 0;
            JumpingSpiderEntity.this.field_6011.method_12778(Companion.getJUMP_CHARGING(), (Object)true);
        }
    }
}

