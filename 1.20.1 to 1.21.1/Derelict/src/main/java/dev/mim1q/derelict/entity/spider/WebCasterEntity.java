/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.AnimatedProperty
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1347
 *  net.minecraft.class_1352
 *  net.minecraft.class_1361
 *  net.minecraft.class_1366
 *  net.minecraft.class_1376
 *  net.minecraft.class_1394
 *  net.minecraft.class_1400
 *  net.minecraft.class_1452
 *  net.minecraft.class_1588
 *  net.minecraft.class_1628
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_2680
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3417
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.spider;

import dev.mim1q.derelict.entity.spider.control.ArachneBodyControl;
import dev.mim1q.derelict.entity.spider.legs.SpiderLegController;
import dev.mim1q.derelict.init.ModStatusEffects;
import dev.mim1q.derelict.tag.ModBlockTags;
import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.gimm1q.interpolation.AnimatedProperty;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1347;
import net.minecraft.class_1352;
import net.minecraft.class_1361;
import net.minecraft.class_1366;
import net.minecraft.class_1376;
import net.minecraft.class_1394;
import net.minecraft.class_1400;
import net.minecraft.class_1452;
import net.minecraft.class_1588;
import net.minecraft.class_1628;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3417;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00016B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0014\u00a2\u0006\u0004\b\u001f\u0010 J\u001f\u0010%\u001a\u00020\b2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#H\u0016\u00a2\u0006\u0004\b%\u0010&R\u0017\u0010(\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010.R\u0016\u00100\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0017\u00102\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u00a8\u00067"}, d2={"Ldev/mim1q/derelict/entity/spider/WebCasterEntity;", "Lnet/minecraft/class_1588;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initDataTracker", "()V", "initGoals", "tick", "handleAnimations", "tickWebLogic", "Lnet/minecraft/class_1297;", "target", "", "tryAttack", "(Lnet/minecraft/class_1297;)Z", "", "getSoundPitch", "()F", "Lnet/minecraft/class_1309;", "", "squaredAttackRange", "(Lnet/minecraft/class_1309;)D", "bodyYaw", "setBodyYaw", "(F)V", "Ldev/mim1q/derelict/entity/spider/control/ArachneBodyControl;", "createBodyControl", "()Ldev/mim1q/derelict/entity/spider/control/ArachneBodyControl;", "Lnet/minecraft/class_2680;", "state", "Lnet/minecraft/class_243;", "multiplier", "slowMovement", "(Lnet/minecraft/class_2680;Lnet/minecraft/class_243;)V", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "legController", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "getLegController", "()Ldev/mim1q/derelict/entity/spider/legs/SpiderLegController;", "", "targetTimer", "I", "webCooldown", "webHeldTimer", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "webHeldAnimation", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "getWebHeldAnimation", "()Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "Companion", "derelict"})
public final class WebCasterEntity
extends class_1588 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final SpiderLegController legController;
    private int targetTimer;
    private int webCooldown;
    private int webHeldTimer;
    @NotNull
    private final AnimatedProperty webHeldAnimation;
    @NotNull
    private static final class_2940<Boolean> WEB_HELD;

    public WebCasterEntity(@NotNull class_1299<WebCasterEntity> entityType, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(entityType, world);
        Pair[] pairArray = new Pair[]{TuplesKt.to(WebCasterEntity::legController$lambda$2, WebCasterEntity::legController$lambda$3), TuplesKt.to(WebCasterEntity::legController$lambda$4, WebCasterEntity::legController$lambda$5), TuplesKt.to(WebCasterEntity::legController$lambda$6, () -> WebCasterEntity.legController$lambda$7(this)), TuplesKt.to(WebCasterEntity::legController$lambda$8, WebCasterEntity::legController$lambda$9), TuplesKt.to(WebCasterEntity::legController$lambda$10, WebCasterEntity::legController$lambda$11), TuplesKt.to(WebCasterEntity::legController$lambda$12, WebCasterEntity::legController$lambda$13), TuplesKt.to(WebCasterEntity::legController$lambda$14, () -> WebCasterEntity.legController$lambda$15(this)), TuplesKt.to(WebCasterEntity::legController$lambda$16, WebCasterEntity::legController$lambda$17)};
        this.legController = new SpiderLegController((class_1309)this, (Function0<Float>)((Function0)WebCasterEntity::legController$lambda$0), (Function0<Float>)((Function0)WebCasterEntity::legController$lambda$1), pairArray);
        this.targetTimer = 100;
        this.webCooldown = 100;
        this.webHeldTimer = 40;
        this.webHeldAnimation = new AnimatedProperty(0.0f);
    }

    @NotNull
    public final SpiderLegController getLegController() {
        return this.legController;
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(WEB_HELD, (Object)false);
    }

    protected void method_5959() {
        this.field_6201.method_6277(0, (class_1352)new class_1347((class_1308)this));
        this.field_6201.method_6277(1, (class_1352)new class_1366((class_1314)this, 1.2, true));
        this.field_6201.method_6277(2, (class_1352)new class_1361((class_1308)this, class_1657.class, 16.0f));
        this.field_6201.method_6277(5, (class_1352)new class_1394((class_1314)this, 0.8));
        this.field_6201.method_6277(6, (class_1352)new class_1376((class_1308)this));
        this.field_6185.method_6277(2, (class_1352)new class_1400((class_1308)this, class_1657.class, true));
        this.field_6185.method_6277(2, (class_1352)new class_1400((class_1308)this, class_1452.class, true));
    }

    @NotNull
    public final AnimatedProperty getWebHeldAnimation() {
        return this.webHeldAnimation;
    }

    public void method_5773() {
        if (this.method_37908().field_9236) {
            this.legController.tick();
        }
        super.method_5773();
        if (this.method_37908().field_9236) {
            this.handleAnimations();
        } else {
            this.tickWebLogic();
        }
    }

    private final void handleAnimations() {
        if (((Boolean)this.field_6011.method_12789(WEB_HELD)).booleanValue()) {
            this.webHeldAnimation.transitionTo(1.0f, 15.0f, Easing::easeOutBack);
        } else {
            this.webHeldAnimation.transitionTo(0.0f, 5.0f, Easing::easeOutCubic);
        }
    }

    private final void tickWebLogic() {
        int n = this.webCooldown;
        this.webCooldown = n + -1;
        if (((Boolean)this.field_6011.method_12789(WEB_HELD)).booleanValue()) {
            n = this.webHeldTimer;
            this.webHeldTimer = n + -1;
            if (this.method_5968() == null) {
                this.targetTimer = 60 + this.field_5974.method_43048(60);
                this.field_6011.method_12778(WEB_HELD, (Object)false);
                return;
            }
        }
        if (this.webCooldown <= 0 && this.method_5968() != null) {
            n = this.targetTimer;
            this.targetTimer = n + -1;
            if (this.targetTimer >= 0) {
                return;
            }
            if (!((Boolean)this.field_6011.method_12789(WEB_HELD)).booleanValue()) {
                this.field_6011.method_12778(WEB_HELD, (Object)true);
                this.method_5783(class_3417.field_15226, 1.0f, this.method_6017());
                this.method_5783(class_3417.field_15170, 1.0f, this.method_6017());
            }
        }
    }

    public boolean method_6121(@NotNull class_1297 target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        Boolean webHeld = (Boolean)this.field_6011.method_12789(WEB_HELD);
        if (webHeld.booleanValue() && this.webHeldTimer > 0) {
            return false;
        }
        if (webHeld.booleanValue() && target instanceof class_1309) {
            ((class_1309)target).method_6092(new class_1293((class_1291)ModStatusEffects.INSTANCE.getCOBWEBBED(), 60, 2, true, false, true));
            this.webCooldown = 200 + this.field_5974.method_43048(200);
            this.webHeldTimer = 40;
            this.field_6011.method_12778(WEB_HELD, (Object)false);
            this.method_5783(class_3417.field_15226, 1.0f, this.method_6017());
            return false;
        }
        return super.method_6121(target);
    }

    public float method_6017() {
        return 0.6f + this.field_5974.method_43057() * 0.25f;
    }

    public double method_33191(@NotNull class_1309 target) {
        Intrinsics.checkNotNullParameter((Object)target, (String)"target");
        return Math.pow((double)this.method_17681() + 1.0, 2) + (double)target.method_17681();
    }

    public void method_5636(float bodyYaw) {
        super.method_5636(MathUtilsKt.wrapDegrees(this.field_6283, bodyYaw, 10.0f));
    }

    @NotNull
    protected ArachneBodyControl createBodyControl() {
        return new ArachneBodyControl((class_1308)this, 0.0f, 2, null);
    }

    public void method_5844(@NotNull class_2680 state, @NotNull class_243 multiplier) {
        Intrinsics.checkNotNullParameter((Object)state, (String)"state");
        Intrinsics.checkNotNullParameter((Object)multiplier, (String)"multiplier");
        if (!state.method_26164(ModBlockTags.INSTANCE.getCOBWEBS())) {
            super.method_5844(state, multiplier);
        }
    }

    private static final float legController$lambda$0() {
        return 1.5f;
    }

    private static final float legController$lambda$1() {
        return 1.75f;
    }

    private static final class_243 legController$lambda$2() {
        return new class_243(0.3125, 0.6, 0.4375);
    }

    private static final class_243 legController$lambda$3() {
        return new class_243(1.5, 0.0, 2.0);
    }

    private static final class_243 legController$lambda$4() {
        return new class_243(0.3125, 0.6, 0.3125);
    }

    private static final class_243 legController$lambda$5() {
        return new class_243(2.0, 0.0, 1.5);
    }

    private static final class_243 legController$lambda$6() {
        return new class_243(0.3125, 0.6, 0.1875);
    }

    private static final class_243 legController$lambda$7(WebCasterEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return (Boolean)this$0.field_6011.method_12789(WEB_HELD) != false ? new class_243(2.0, 0.0, 1.5) : new class_243(2.0, 0.0, -1.0);
    }

    private static final class_243 legController$lambda$8() {
        return new class_243(0.3125, 0.6, 0.0625);
    }

    private static final class_243 legController$lambda$9() {
        return new class_243(1.5, 0.0, -1.5);
    }

    private static final class_243 legController$lambda$10() {
        return new class_243(-0.3125, 0.6, 0.4375);
    }

    private static final class_243 legController$lambda$11() {
        return new class_243(-1.5, 0.0, 2.0);
    }

    private static final class_243 legController$lambda$12() {
        return new class_243(-0.3125, 0.6, 0.3125);
    }

    private static final class_243 legController$lambda$13() {
        return new class_243(-2.0, 0.0, 1.5);
    }

    private static final class_243 legController$lambda$14() {
        return new class_243(-0.3125, 0.6, 0.1875);
    }

    private static final class_243 legController$lambda$15(WebCasterEntity this$0) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        return (Boolean)this$0.field_6011.method_12789(WEB_HELD) != false ? new class_243(-2.0, 0.0, 1.5) : new class_243(-2.0, 0.0, -1.0);
    }

    private static final class_243 legController$lambda$16() {
        return new class_243(-0.3125, 0.6, 0.0625);
    }

    private static final class_243 legController$lambda$17() {
        return new class_243(-1.5, 0.0, -1.5);
    }

    static {
        class_2940 class_29402 = class_2945.method_12791(WebCasterEntity.class, (class_2941)class_2943.field_13323);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        WEB_HELD = class_29402;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/entity/spider/WebCasterEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5132$class_5133;", "createWebCasterAttributes", "()Lnet/minecraft/class_5132$class_5133;", "Lnet/minecraft/class_2940;", "", "WEB_HELD", "Lnet/minecraft/class_2940;", "getWEB_HELD", "()Lnet/minecraft/class_2940;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2940<Boolean> getWEB_HELD() {
            return WEB_HELD;
        }

        @NotNull
        public final class_5132.class_5133 createWebCasterAttributes() {
            class_5132.class_5133 class_51332 = class_1628.method_26923().method_26868(class_5134.field_23716, 40.0).method_26868(class_5134.field_23725, 1.0).method_26868(class_5134.field_23721, 3.0);
            Intrinsics.checkNotNullExpressionValue((Object)class_51332, (String)"add(...)");
            return class_51332;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

