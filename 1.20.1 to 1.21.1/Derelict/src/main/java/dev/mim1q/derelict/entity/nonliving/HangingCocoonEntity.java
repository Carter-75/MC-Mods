/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.AnimatedProperty
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1540
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_181
 *  net.minecraft.class_1829
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2388
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2680
 *  net.minecraft.class_2769
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3417
 *  net.minecraft.class_3865
 *  net.minecraft.class_52
 *  net.minecraft.class_8567
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Math
 */
package dev.mim1q.derelict.entity.nonliving;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.util.MathUtilsKt;
import dev.mim1q.gimm1q.interpolation.AnimatedProperty;
import dev.mim1q.gimm1q.interpolation.Easing;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1540;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_181;
import net.minecraft.class_1829;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2388;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2680;
import net.minecraft.class_2769;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3417;
import net.minecraft.class_3865;
import net.minecraft.class_52;
import net.minecraft.class_8567;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 .2\u00020\u0001:\u0001.B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u0019\u0010\nJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0014\u00a2\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b*\u0010+R\u0017\u0010,\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b,\u0010#\u001a\u0004\b-\u0010%\u00a8\u0006/"}, d2={"Ldev/mim1q/derelict/entity/nonliving/HangingCocoonEntity;", "Lnet/minecraft/class_1297;", "Lnet/minecraft/class_1299;", "type", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "tick", "()V", "Lnet/minecraft/class_1282;", "source", "", "amount", "", "damage", "(Lnet/minecraft/class_1282;F)Z", "broken", "Lnet/minecraft/class_1657;", "player", "dropLoot", "(ZLnet/minecraft/class_1282;Lnet/minecraft/class_1657;)V", "shouldBreak", "(Lnet/minecraft/class_1657;)Z", "initDataTracker", "Lnet/minecraft/class_2487;", "nbt", "readCustomDataFromNbt", "(Lnet/minecraft/class_2487;)V", "writeCustomDataToNbt", "canHit", "()Z", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "punchYaw", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "getPunchYaw", "()Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "prevPunchAngle", "F", "value", "punchTime", "getPunchTime", "()F", "punchDistance", "getPunchDistance", "Companion", "derelict"})
public final class HangingCocoonEntity
extends class_1297 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final AnimatedProperty punchYaw;
    private float prevPunchAngle;
    private float punchTime;
    @NotNull
    private final AnimatedProperty punchDistance;
    @NotNull
    private static final class_2940<Boolean> BROKEN;
    @NotNull
    private static final class_2940<Float> PUNCH_ANGLE;

    public HangingCocoonEntity(@NotNull class_1299<?> type, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(type, world);
        this.field_23807 = true;
        this.punchYaw = new AnimatedProperty(0.0f, HangingCocoonEntity::punchYaw$lambda$0);
        this.punchDistance = new AnimatedProperty(0.0f);
    }

    @NotNull
    public final AnimatedProperty getPunchYaw() {
        return this.punchYaw;
    }

    public final float getPunchTime() {
        return this.punchTime;
    }

    @NotNull
    public final AnimatedProperty getPunchDistance() {
        return this.punchDistance;
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_37908().field_9236) {
            float f = this.punchTime;
            this.punchTime = f + 1.0f;
            Float punchAngle = (Float)this.field_6011.method_12789(PUNCH_ANGLE);
            Intrinsics.checkNotNull((Object)punchAngle);
            this.punchYaw.transitionTo(punchAngle.floatValue(), 30.0f, Easing::easeInOutQuad);
            if (!Intrinsics.areEqual((float)this.prevPunchAngle, (Float)punchAngle)) {
                this.punchDistance.transitionTo(1.0f, 5.0f, Easing::easeOutCubic);
                if ((float)Math.cos(this.punchTime * 0.2f) < 0.0f) {
                    this.punchTime += 1.0f;
                }
            } else if (this.punchDistance.getValue() == 1.0f) {
                this.punchDistance.transitionTo(0.0f, 80.0f, Easing::easeOutCubic);
            }
            this.prevPunchAngle = punchAngle.floatValue();
        }
    }

    public boolean method_5643(@NotNull class_1282 source, float amount) {
        class_243 srcPos;
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.method_37908().field_9236) {
            return false;
        }
        class_1297 class_12972 = source.method_5529();
        class_1657 player = class_12972 instanceof class_1657 ? (class_1657)class_12972 : null;
        class_1937 class_19372 = this.method_37908();
        class_3218 world = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
        class_2680 cobwebState = class_2246.field_10343.method_9564();
        if (player != null && world != null) {
            if (this.shouldBreak(player)) {
                if (((Boolean)this.field_6011.method_12789(BROKEN)).booleanValue()) {
                    this.dropLoot(true, source, player);
                    this.method_31472();
                } else {
                    this.dropLoot(false, source, player);
                    this.field_6011.method_12778(BROKEN, (Object)true);
                }
                this.method_5783(class_3417.field_14983, 1.0f, 0.8f);
                v0 = world.method_14199((class_2394)new class_2388(class_2398.field_11217, cobwebState), this.method_23317(), this.method_23318() + 1.0, this.method_23321(), 20, 0.2, 0.5, 0.2, 1.0);
            } else {
                this.method_5783(class_3417.field_14628, 1.0f, 0.8f);
                v0 = world.method_14199((class_2394)new class_2388(class_2398.field_11217, cobwebState), this.method_23317(), this.method_23318() + 1.0, this.method_23321(), 2, 0.2, 0.5, 0.2, 1.0);
            }
        }
        if ((srcPos = source.method_5510()) != null) {
            this.field_6011.method_12778(PUNCH_ANGLE, (Object)Float.valueOf((float)org.joml.Math.atan2((double)(srcPos.field_1350 - this.method_23321()), (double)(srcPos.field_1352 - this.method_23317())) - 1.5707964f));
        }
        return true;
    }

    private final void dropLoot(boolean broken, class_1282 source, class_1657 player) {
        block0: {
            class_2960 lootTableId = Derelict.INSTANCE.id("misc/hanging_cocoon_" + (broken ? "break" : "damage"));
            class_1937 class_19372 = this.method_37908();
            class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
            if (class_32182 == null) break block0;
            class_3218 serverWorld = class_32182;
            boolean bl = false;
            class_52 lootTable = serverWorld.method_8503().method_3857().getLootTable(lootTableId);
            Pair[] pairArray = new Pair[]{TuplesKt.to((Object)class_181.field_1226, (Object)((Object)this)), TuplesKt.to((Object)class_181.field_1230, (Object)player), TuplesKt.to((Object)class_181.field_1231, (Object)source)};
            lootTable.method_51882(new class_8567(serverWorld, MapsKt.mapOf((Pair[])pairArray), MapsKt.emptyMap(), player.method_7292()), arg_0 -> HangingCocoonEntity.dropLoot$lambda$2$lambda$1(this, arg_0));
        }
    }

    private final boolean shouldBreak(class_1657 player) {
        if (player.method_6047().method_7909() instanceof class_1829 || player.method_6079().method_7909() instanceof class_1829) {
            return true;
        }
        return this.field_5974.method_43057() < 0.2f;
    }

    protected void method_5693() {
        this.field_6011.method_12784(BROKEN, (Object)false);
        this.field_6011.method_12784(PUNCH_ANGLE, (Object)Float.valueOf(0.0f));
    }

    protected void method_5749(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        this.field_6011.method_12778(BROKEN, (Object)nbt.method_10577("Broken"));
    }

    protected void method_5652(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        Object object = this.field_6011.method_12789(BROKEN);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"get(...)");
        nbt.method_10556("Broken", ((Boolean)object).booleanValue());
    }

    public boolean method_5863() {
        return true;
    }

    private static final float punchYaw$lambda$0(float start, float end, float delta) {
        return MathUtilsKt.lerpAngleRadians(start, end, Easing.easeOutQuad((float)0.0f, (float)1.0f, (float)delta));
    }

    private static final void dropLoot$lambda$2$lambda$1(HangingCocoonEntity this$0, class_1799 it) {
        Intrinsics.checkNotNullParameter((Object)((Object)this$0), (String)"this$0");
        if (it.method_31574(class_1802.field_8398)) {
            v0 = class_1540.method_40005((class_1937)this$0.method_37908(), (class_2338)this$0.method_24515(), (class_2680)((class_2680)class_2246.field_10181.method_9564().method_11657((class_2769)class_3865.field_11105, (Comparable)Boolean.valueOf(true))));
        } else {
            class_1542 item = new class_1542(this$0.method_37908(), this$0.method_23317(), this$0.method_23318(), this$0.method_23321(), it);
            item.method_18799(new class_243(item.method_18798().field_1352 * 0.5, -0.1, item.method_18798().field_1350 * 0.5));
            item.method_33574(item.method_19538().method_1031(0.75 * (this$0.field_5974.method_43058() - 0.5), this$0.field_5974.method_43058(), 0.75 * (this$0.field_5974.method_43058() - 0.5)));
            v0 = this$0.method_37908().method_8649((class_1297)item);
        }
    }

    static {
        class_2940 class_29402 = class_2945.method_12791(HangingCocoonEntity.class, (class_2941)class_2943.field_13323);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        BROKEN = class_29402;
        class_2940 class_29403 = class_2945.method_12791(HangingCocoonEntity.class, (class_2941)class_2943.field_13320);
        Intrinsics.checkNotNullExpressionValue((Object)class_29403, (String)"registerData(...)");
        PUNCH_ANGLE = class_29403;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\r"}, d2={"Ldev/mim1q/derelict/entity/nonliving/HangingCocoonEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2940;", "", "BROKEN", "Lnet/minecraft/class_2940;", "getBROKEN", "()Lnet/minecraft/class_2940;", "", "PUNCH_ANGLE", "getPUNCH_ANGLE", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2940<Boolean> getBROKEN() {
            return BROKEN;
        }

        @NotNull
        public final class_2940<Float> getPUNCH_ANGLE() {
            return PUNCH_ANGLE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

