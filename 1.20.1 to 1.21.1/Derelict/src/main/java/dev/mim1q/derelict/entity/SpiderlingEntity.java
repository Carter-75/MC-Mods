/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.AnimatedProperty
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1268
 *  net.minecraft.class_1269
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1308
 *  net.minecraft.class_1309
 *  net.minecraft.class_1314
 *  net.minecraft.class_1352
 *  net.minecraft.class_1359
 *  net.minecraft.class_1361
 *  net.minecraft.class_1366
 *  net.minecraft.class_1376
 *  net.minecraft.class_1379
 *  net.minecraft.class_1394
 *  net.minecraft.class_1399
 *  net.minecraft.class_1400
 *  net.minecraft.class_1588
 *  net.minecraft.class_1628
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1937
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2382
 *  net.minecraft.class_2388
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_3218
 *  net.minecraft.class_3414
 *  net.minecraft.class_3417
 *  net.minecraft.class_5132$class_5133
 *  net.minecraft.class_5134
 *  net.minecraft.class_5455
 *  net.minecraft.class_5761
 *  net.minecraft.class_8109
 *  net.minecraft.class_8111
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package dev.mim1q.derelict.entity;

import dev.mim1q.derelict.entity.damage.DerelictDamageSource;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.util.entity.EntityUtilKt;
import dev.mim1q.derelict.util.entity.OptionalTrackedDataDelegate;
import dev.mim1q.derelict.util.entity.TrackedDataDelegate;
import dev.mim1q.gimm1q.interpolation.AnimatedProperty;
import java.util.Optional;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1308;
import net.minecraft.class_1309;
import net.minecraft.class_1314;
import net.minecraft.class_1352;
import net.minecraft.class_1359;
import net.minecraft.class_1361;
import net.minecraft.class_1366;
import net.minecraft.class_1376;
import net.minecraft.class_1379;
import net.minecraft.class_1394;
import net.minecraft.class_1399;
import net.minecraft.class_1400;
import net.minecraft.class_1588;
import net.minecraft.class_1628;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1937;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2382;
import net.minecraft.class_2388;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_3218;
import net.minecraft.class_3414;
import net.minecraft.class_3417;
import net.minecraft.class_5132;
import net.minecraft.class_5134;
import net.minecraft.class_5455;
import net.minecraft.class_5761;
import net.minecraft.class_8109;
import net.minecraft.class_8111;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0003BCDB\u001f\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0014\u00a2\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\r\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016\u00a2\u0006\u0004\b*\u0010 J\u000f\u0010+\u001a\u00020\u001aH\u0016\u00a2\u0006\u0004\b+\u0010\u001cJ\u000f\u0010-\u001a\u00020,H\u0016\u00a2\u0006\u0004\b-\u0010.R/\u00107\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010/8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0017\u00109\u001a\u0002088\u0006\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R+\u0010A\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u00138B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010#\"\u0004\b@\u0010&\u0082\u0001\u0002EF\u00a8\u0006G"}, d2={"Ldev/mim1q/derelict/entity/SpiderlingEntity;", "Lnet/minecraft/class_1628;", "Lnet/minecraft/class_5761;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initDataTracker", "()V", "initGoals", "tick", "", "fallDistance", "damageMultiplier", "Lnet/minecraft/class_1282;", "damageSource", "", "handleFallDamage", "(FFLnet/minecraft/class_1282;)Z", "source", "amount", "damage", "(Lnet/minecraft/class_1282;F)Z", "Lnet/minecraft/class_1799;", "getPickBlockStack", "()Lnet/minecraft/class_1799;", "Lnet/minecraft/class_2487;", "nbt", "writeCustomDataToNbt", "(Lnet/minecraft/class_2487;)V", "readCustomDataFromNbt", "isFromBucket", "()Z", "fromBucket", "setFromBucket", "(Z)V", "stack", "copyDataToStack", "(Lnet/minecraft/class_1799;)V", "copyDataFromNbt", "getBucketItem", "Lnet/minecraft/class_3414;", "getBucketFillSound", "()Lnet/minecraft/class_3414;", "Lnet/minecraft/class_2338;", "<set-?>", "anchorPosition$delegate", "Ldev/mim1q/derelict/util/entity/OptionalTrackedDataDelegate;", "getAnchorPosition", "()Lnet/minecraft/class_2338;", "setAnchorPosition", "(Lnet/minecraft/class_2338;)V", "anchorPosition", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "anchored", "Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "getAnchored", "()Ldev/mim1q/gimm1q/interpolation/AnimatedProperty;", "spawnedFromBucket$delegate", "Ldev/mim1q/derelict/util/entity/TrackedDataDelegate;", "getSpawnedFromBucket", "setSpawnedFromBucket", "spawnedFromBucket", "Companion", "Enemy", "Ally", "Ldev/mim1q/derelict/entity/SpiderlingEntity$Ally;", "Ldev/mim1q/derelict/entity/SpiderlingEntity$Enemy;", "derelict"})
public abstract class SpiderlingEntity
extends class_1628
implements class_5761 {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final OptionalTrackedDataDelegate anchorPosition$delegate;
    @NotNull
    private final AnimatedProperty anchored;
    @NotNull
    private final TrackedDataDelegate spawnedFromBucket$delegate;
    @NotNull
    private static final class_2940<Optional<class_2338>> ANCHOR_POSITION;
    @NotNull
    private static final class_2940<Boolean> SPAWNED_FROM_BUCKET;

    private SpiderlingEntity(class_1299<SpiderlingEntity> entityType, class_1937 world) {
        super(entityType, world);
        this.field_5985 = true;
        this.anchorPosition$delegate = EntityUtilKt.nullableTracked(ANCHOR_POSITION);
        this.anchored = new AnimatedProperty(0.0f);
        this.spawnedFromBucket$delegate = EntityUtilKt.tracked(SPAWNED_FROM_BUCKET);
    }

    @Nullable
    public final class_2338 getAnchorPosition() {
        return (class_2338)this.anchorPosition$delegate.getValue((class_1297)this, $$delegatedProperties[0]);
    }

    public final void setAnchorPosition(@Nullable class_2338 class_23382) {
        this.anchorPosition$delegate.setValue((class_1297)this, $$delegatedProperties[0], class_23382);
    }

    @NotNull
    public final AnimatedProperty getAnchored() {
        return this.anchored;
    }

    private final boolean getSpawnedFromBucket() {
        return (Boolean)this.spawnedFromBucket$delegate.getValue((class_1297)this, $$delegatedProperties[1]);
    }

    private final void setSpawnedFromBucket(boolean bl) {
        this.spawnedFromBucket$delegate.setValue((class_1297)this, $$delegatedProperties[1], bl);
    }

    protected void method_5693() {
        super.method_5693();
        this.field_6011.method_12784(ANCHOR_POSITION, Optional.empty());
        this.field_6011.method_12784(SPAWNED_FROM_BUCKET, (Object)false);
    }

    protected void method_5959() {
        this.field_6201.method_6277(4, (class_1352)new class_1379((class_1314)this, 1.0));
        this.field_6201.method_6277(5, (class_1352)new class_1394((class_1314)this, 1.0));
        this.field_6201.method_6277(1, (class_1352)new class_1366((class_1314)this, 1.0, true));
        this.field_6201.method_6277(0, (class_1352)new class_1359((class_1308)this, 0.3f));
        this.field_6201.method_6277(1, (class_1352)new class_1361((class_1308)this, class_1657.class, 8.0f));
        this.field_6185.method_6277(0, (class_1352)new class_1400((class_1308)this, class_1657.class, true));
    }

    public void method_5773() {
        super.method_5773();
        if (this.method_37908().field_9236) {
            this.anchored.transitionTo(this.getAnchorPosition() != null ? 1.0f : 0.0f, 10.0f);
        } else if (this.getAnchorPosition() != null) {
            if (!this.method_37908().method_8320(this.method_24515().method_10074()).method_26215()) {
                this.method_18800(0.0, 0.01, 0.0);
            }
            if (this.field_6012 % 5 == 0 && this.method_37908().method_8320(this.getAnchorPosition()).method_26215()) {
                this.setAnchorPosition(null);
            }
        }
        if (this.getAnchorPosition() != null) {
            class_2338 class_23382 = this.getAnchorPosition();
            Intrinsics.checkNotNull((Object)class_23382);
            class_243 direction = class_243.method_24953((class_2382)((class_2382)class_23382)).method_1020(this.method_19538()).method_1029();
            if (direction.method_37267() > 0.05) {
                this.method_5762(direction.field_1352 * 0.1, 0.0, direction.field_1350 * 0.1);
            }
            this.method_5875(true);
            if (this.method_18798().field_1351 > 0.0) {
                this.method_18800(this.method_18798().field_1352, this.method_18798().field_1351 * 0.99, this.method_18798().field_1350);
            }
        } else {
            this.method_5875(false);
        }
    }

    public boolean method_5747(float fallDistance, float damageMultiplier, @NotNull class_1282 damageSource) {
        Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
        return false;
    }

    /*
     * Unable to fully structure code
     */
    public boolean method_5643(@NotNull class_1282 source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.getAnchorPosition() == null) ** GOTO lbl-1000
        v0 = source.method_5529();
        if (!(v0 != null ? v0.method_31747() : false)) lbl-1000:
        // 2 sources

        {
            v1 = amount;
        } else {
            v1 = 0.0f;
        }
        result = super.method_5643(source, v1);
        if (!this.getSpawnedFromBucket() && !this.method_37908().field_9236) {
            this.setAnchorPosition(null);
        }
        this.method_18799(this.method_18798().method_18805(1.0, 0.0, 1.0));
        return result;
    }

    @NotNull
    public class_1799 method_31480() {
        class_1799 class_17992 = ModBlocksAndItems.INSTANCE.getSPIDERLING_IN_A_BUCKET().method_7854();
        Intrinsics.checkNotNullExpressionValue((Object)class_17992, (String)"getDefaultStack(...)");
        return class_17992;
    }

    public void method_5652(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        super.method_5652(nbt);
        class_2338 anchorPosition = this.getAnchorPosition();
        if (anchorPosition != null) {
            nbt.method_10544("AnchorPosition", anchorPosition.method_10063());
        }
        nbt.method_10556("SpawnedFromBucket", this.getSpawnedFromBucket());
    }

    public void method_5749(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        super.method_5749(nbt);
        if (nbt.method_10545("AnchorPosition")) {
            this.setAnchorPosition(class_2338.method_10092((long)nbt.method_10537("AnchorPosition")));
        }
        this.setSpawnedFromBucket(nbt.method_10577("SpawnedFromBucket"));
    }

    public boolean method_6453() {
        return this.getSpawnedFromBucket();
    }

    public void method_6454(boolean fromBucket) {
        this.setSpawnedFromBucket(fromBucket);
    }

    public void method_6455(@NotNull class_1799 stack) {
        Intrinsics.checkNotNullParameter((Object)stack, (String)"stack");
        class_5761.method_35167((class_1308)((class_1308)this), (class_1799)stack);
    }

    public void method_35170(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        class_5761.method_35168((class_1308)((class_1308)this), (class_2487)nbt);
    }

    @NotNull
    public class_1799 method_6452() {
        class_1799 class_17992 = ModBlocksAndItems.INSTANCE.getSPIDERLING_IN_A_BUCKET().method_7854();
        Intrinsics.checkNotNullExpressionValue((Object)class_17992, (String)"getDefaultStack(...)");
        return class_17992;
    }

    @NotNull
    public class_3414 method_35171() {
        class_3414 class_34142 = class_3417.field_14760;
        Intrinsics.checkNotNullExpressionValue((Object)class_34142, (String)"ENTITY_SPIDER_STEP");
        return class_34142;
    }

    public /* synthetic */ SpiderlingEntity(class_1299 entityType, class_1937 world, DefaultConstructorMarker $constructor_marker) {
        this((class_1299<SpiderlingEntity>)entityType, world);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SpiderlingEntity.class, "anchorPosition", "getAnchorPosition()Lnet/minecraft/util/math/BlockPos;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(SpiderlingEntity.class, "spawnedFromBucket", "getSpawnedFromBucket()Z", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        class_2940 class_29402 = class_2945.method_12791(SpiderlingEntity.class, (class_2941)class_2943.field_13315);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        ANCHOR_POSITION = class_29402;
        class_2940 class_29403 = class_2945.method_12791(SpiderlingEntity.class, (class_2941)class_2943.field_13323);
        Intrinsics.checkNotNullExpressionValue((Object)class_29403, (String)"registerData(...)");
        SPAWNED_FROM_BUCKET = class_29403;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0011H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0013R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006&"}, d2={"Ldev/mim1q/derelict/entity/SpiderlingEntity$Ally;", "Ldev/mim1q/derelict/entity/SpiderlingEntity;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "tick", "()V", "Lnet/minecraft/class_1282;", "damageSource", "", "isInvulnerableTo", "(Lnet/minecraft/class_1282;)Z", "initGoals", "Lnet/minecraft/class_8109;", "getDamageSources", "()Lnet/minecraft/class_8109;", "Lnet/minecraft/class_2487;", "nbt", "writeCustomDataToNbt", "(Lnet/minecraft/class_2487;)V", "readCustomDataFromNbt", "createSources", "Ljava/util/UUID;", "owner", "Ljava/util/UUID;", "getOwner", "()Ljava/util/UUID;", "setOwner", "(Ljava/util/UUID;)V", "", "maxAge", "I", "sources", "Lnet/minecraft/class_8109;", "derelict"})
    public static final class Ally
    extends SpiderlingEntity {
        @Nullable
        private UUID owner;
        private final int maxAge;
        @Nullable
        private final class_8109 sources;

        public Ally(@NotNull class_1299<SpiderlingEntity> entityType, @NotNull class_1937 world) {
            Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            super(entityType, world, null);
            this.maxAge = 200 + world.field_9229.method_43048(100);
            this.sources = this.createSources();
        }

        @Nullable
        public final UUID getOwner() {
            return this.owner;
        }

        public final void setOwner(@Nullable UUID uUID) {
            this.owner = uUID;
        }

        @Override
        public void method_5773() {
            block1: {
                super.method_5773();
                if (this.method_37908().field_9236 || this.field_6012 <= this.maxAge) break block1;
                this.method_31472();
                class_1937 class_19372 = this.method_37908();
                class_3218 class_32182 = class_19372 instanceof class_3218 ? (class_3218)class_19372 : null;
                if (class_32182 != null) {
                    class_32182.method_14199((class_2394)new class_2388(class_2398.field_11217, class_2246.field_10343.method_9564()), this.method_19538().field_1352, this.method_19538().field_1351 + 0.5, this.method_19538().field_1350, 20, 0.2, 0.2, 0.2, 0.01);
                }
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean method_5679(@NotNull class_1282 damageSource) {
            Intrinsics.checkNotNullParameter((Object)damageSource, (String)"damageSource");
            if (this.owner != null) {
                class_1297 class_12972 = damageSource.method_5529();
                if (Intrinsics.areEqual((Object)(class_12972 != null ? class_12972.method_5667() : null), (Object)this.owner)) return true;
            }
            if (damageSource.method_49708(class_8111.field_42340)) return true;
            if (!super.method_5679(damageSource)) return false;
            return true;
        }

        @Override
        protected void method_5959() {
            this.field_6201.method_6277(3, (class_1352)new class_1376((class_1308)this));
            this.field_6201.method_6277(1, (class_1352)new class_1366((class_1314)this, 1.0, true));
            this.field_6201.method_6277(0, (class_1352)new class_1359((class_1308)this, 0.3f));
            this.field_6185.method_6277(0, (class_1352)new class_1399((class_1314)this, new Class[0]));
            this.field_6185.method_6277(0, (class_1352)new class_1400((class_1308)this, class_1588.class, true, Ally::initGoals$lambda$0));
        }

        @NotNull
        public class_8109 method_48923() {
            class_8109 class_81092 = this.sources;
            if (class_81092 == null) {
                class_8109 class_81093 = super.method_48923();
                class_81092 = class_81093;
                Intrinsics.checkNotNullExpressionValue((Object)class_81093, (String)"getDamageSources(...)");
            }
            return class_81092;
        }

        @Override
        public void method_5652(@NotNull class_2487 nbt) {
            Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
            super.method_5652(nbt);
            if (this.owner != null) {
                UUID uUID = this.owner;
                Intrinsics.checkNotNull((Object)uUID);
                nbt.method_25927("owner", uUID);
            }
        }

        @Override
        public void method_5749(@NotNull class_2487 nbt) {
            Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
            super.method_5749(nbt);
            if (nbt.method_25928("owner")) {
                this.owner = nbt.method_25926("owner");
            }
        }

        private final class_8109 createSources() {
            class_8109 class_81092;
            class_1937 class_19372 = this.method_37908();
            if (class_19372 != null && (class_19372 = class_19372.method_30349()) != null) {
                class_1937 it = class_19372;
                boolean bl = false;
                class_81092 = new class_8109((class_5455)it, this){
                    final /* synthetic */ Ally this$0;
                    {
                        this.this$0 = $receiver;
                        super($it);
                    }

                    public class_1282 method_48812(class_1309 attacker) {
                        Intrinsics.checkNotNullParameter((Object)attacker, (String)"attacker");
                        DerelictDamageSource derelictDamageSource = DerelictDamageSource.Companion.getSPIDERLING_ALLY();
                        class_1937 class_19372 = this.this$0.method_37908();
                        Intrinsics.checkNotNullExpressionValue((Object)class_19372, (String)"getWorld(...)");
                        return derelictDamageSource.get(class_19372, (class_1297)attacker);
                    }
                };
            } else {
                class_81092 = null;
            }
            return class_81092;
        }

        private static final boolean initGoals$lambda$0(class_1309 it) {
            return !(it instanceof Ally);
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\u0006R#\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0012"}, d2={"Ldev/mim1q/derelict/entity/SpiderlingEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_5132$class_5133;", "createSpiderlingAttributes", "()Lnet/minecraft/class_5132$class_5133;", "createSpiderlingAllyAttributes", "Lnet/minecraft/class_2940;", "Ljava/util/Optional;", "Lnet/minecraft/class_2338;", "ANCHOR_POSITION", "Lnet/minecraft/class_2940;", "getANCHOR_POSITION", "()Lnet/minecraft/class_2940;", "", "SPAWNED_FROM_BUCKET", "getSPAWNED_FROM_BUCKET", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_2940<Optional<class_2338>> getANCHOR_POSITION() {
            return ANCHOR_POSITION;
        }

        @NotNull
        public final class_2940<Boolean> getSPAWNED_FROM_BUCKET() {
            return SPAWNED_FROM_BUCKET;
        }

        @NotNull
        public final class_5132.class_5133 createSpiderlingAttributes() {
            class_5132.class_5133 class_51332 = class_1628.method_26918().method_26868(class_5134.field_23716, 2.0).method_26868(class_5134.field_23721, 2.0).method_26868(class_5134.field_23719, 0.33);
            Intrinsics.checkNotNullExpressionValue((Object)class_51332, (String)"add(...)");
            return class_51332;
        }

        @NotNull
        public final class_5132.class_5133 createSpiderlingAllyAttributes() {
            class_5132.class_5133 class_51332 = class_1628.method_26918().method_26868(class_5134.field_23716, 2.0).method_26868(class_5134.field_23721, 4.0).method_26868(class_5134.field_23719, 0.36);
            Intrinsics.checkNotNullExpressionValue((Object)class_51332, (String)"add(...)");
            return class_51332;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2={"Ldev/mim1q/derelict/entity/SpiderlingEntity$Enemy;", "Ldev/mim1q/derelict/entity/SpiderlingEntity;", "Lnet/minecraft/class_1299;", "entityType", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "Lnet/minecraft/class_1657;", "player", "Lnet/minecraft/class_1268;", "hand", "Lnet/minecraft/class_1269;", "interactMob", "(Lnet/minecraft/class_1657;Lnet/minecraft/class_1268;)Lnet/minecraft/class_1269;", "derelict"})
    public static final class Enemy
    extends SpiderlingEntity {
        public Enemy(@NotNull class_1299<SpiderlingEntity> entityType, @NotNull class_1937 world) {
            Intrinsics.checkNotNullParameter(entityType, (String)"entityType");
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            super(entityType, world, null);
        }

        @NotNull
        protected class_1269 method_5992(@NotNull class_1657 player, @NotNull class_1268 hand) {
            Intrinsics.checkNotNullParameter((Object)player, (String)"player");
            Intrinsics.checkNotNullParameter((Object)hand, (String)"hand");
            class_1269 class_12692 = class_5761.method_35169((class_1657)player, (class_1268)hand, (class_1309)((class_1309)this)).orElse(super.method_5992(player, hand));
            Intrinsics.checkNotNullExpressionValue((Object)class_12692, (String)"orElse(...)");
            return class_12692;
        }
    }
}

