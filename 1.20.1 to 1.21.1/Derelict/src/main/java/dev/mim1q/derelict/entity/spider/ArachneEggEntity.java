/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  dev.mim1q.gimm1q.screenshake.ScreenShakeUtils
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.MutablePropertyReference1
 *  kotlin.jvm.internal.MutablePropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  kotlin.text.StringsKt
 *  net.minecraft.class_1282
 *  net.minecraft.class_1297
 *  net.minecraft.class_1299
 *  net.minecraft.class_1309
 *  net.minecraft.class_161
 *  net.minecraft.class_1937
 *  net.minecraft.class_238
 *  net.minecraft.class_2388
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2561
 *  net.minecraft.class_2940
 *  net.minecraft.class_2941
 *  net.minecraft.class_2943
 *  net.minecraft.class_2945
 *  net.minecraft.class_2960
 *  net.minecraft.class_3218
 *  net.minecraft.class_3222
 *  net.minecraft.class_3417
 *  net.minecraft.class_3419
 *  net.minecraft.class_4051
 *  net.minecraft.server.MinecraftServer
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.entity.spider;

import dev.mim1q.derelict.Derelict;
import dev.mim1q.derelict.entity.boss.ArachneEntity;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import dev.mim1q.derelict.init.ModEntities;
import dev.mim1q.derelict.util.entity.EntityUtilKt;
import dev.mim1q.derelict.util.entity.TrackedDataDelegate;
import dev.mim1q.gimm1q.interpolation.Easing;
import dev.mim1q.gimm1q.screenshake.ScreenShakeUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_1282;
import net.minecraft.class_1297;
import net.minecraft.class_1299;
import net.minecraft.class_1309;
import net.minecraft.class_161;
import net.minecraft.class_1937;
import net.minecraft.class_238;
import net.minecraft.class_2388;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2561;
import net.minecraft.class_2940;
import net.minecraft.class_2941;
import net.minecraft.class_2943;
import net.minecraft.class_2945;
import net.minecraft.class_2960;
import net.minecraft.class_3218;
import net.minecraft.class_3222;
import net.minecraft.class_3417;
import net.minecraft.class_3419;
import net.minecraft.class_4051;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 82\u00020\u0001:\u00018B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u001c\u0010\nJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014\u00a2\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001dH\u0014\u00a2\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b$\u0010#J\u0017\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u0001H\u0016\u00a2\u0006\u0004\b&\u0010'R+\u00100\u001a\u00020(2\u0006\u0010)\u001a\u00020(8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00102R\u0016\u00104\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u00069"}, d2={"Ldev/mim1q/derelict/entity/spider/ArachneEggEntity;", "Lnet/minecraft/class_1297;", "Lnet/minecraft/class_1299;", "type", "Lnet/minecraft/class_1937;", "world", "<init>", "(Lnet/minecraft/class_1299;Lnet/minecraft/class_1937;)V", "", "initDataTracker", "()V", "tick", "", "delta", "getAnimationTime", "(F)F", "Lnet/minecraft/class_1282;", "source", "amount", "", "damage", "(Lnet/minecraft/class_1282;F)Z", "Lnet/minecraft/class_3222;", "player", "", "id", "canBreakEggIfAdvancementMet", "(Lnet/minecraft/class_3222;Ljava/lang/String;)Z", "breakEggStage", "Lnet/minecraft/class_2487;", "nbt", "readCustomDataFromNbt", "(Lnet/minecraft/class_2487;)V", "writeCustomDataToNbt", "canHit", "()Z", "isCollidable", "other", "collidesWith", "(Lnet/minecraft/class_1297;)Z", "", "<set-?>", "stage$delegate", "Ldev/mim1q/derelict/util/entity/TrackedDataDelegate;", "getStage", "()I", "setStage", "(I)V", "stage", "lastAnimationTime", "I", "animationTime", "stageCooldown", "", "lastTimeWithSpiderInArena", "J", "Companion", "derelict"})
@SourceDebugExtension(value={"SMAP\nArachneEggEntity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArachneEggEntity.kt\ndev/mim1q/derelict/entity/spider/ArachneEggEntity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,202:1\n1863#2,2:203\n*S KotlinDebug\n*F\n+ 1 ArachneEggEntity.kt\ndev/mim1q/derelict/entity/spider/ArachneEggEntity\n*L\n179#1:203,2\n*E\n"})
public final class ArachneEggEntity
extends class_1297 {
    @NotNull
    public static final Companion Companion;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private final TrackedDataDelegate stage$delegate;
    private int lastAnimationTime;
    private int animationTime;
    private int stageCooldown;
    private long lastTimeWithSpiderInArena;
    @NotNull
    private static final class_2940<Integer> STAGE;

    public ArachneEggEntity(@NotNull class_1299<?> type, @NotNull class_1937 world) {
        Intrinsics.checkNotNullParameter(type, (String)"type");
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        super(type, world);
        this.stage$delegate = EntityUtilKt.tracked(STAGE);
        this.stageCooldown = 20;
    }

    public final int getStage() {
        return ((Number)this.stage$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    private final void setStage(int n) {
        this.stage$delegate.setValue(this, $$delegatedProperties[0], n);
    }

    protected void method_5693() {
        this.field_6011.method_12784(STAGE, (Object)0);
    }

    public void method_5773() {
        super.method_5773();
        this.lastAnimationTime = this.animationTime;
        this.animationTime += this.getStage() + 1;
        if (this.getStage() == 3) {
            this.field_23807 = false;
            this.animationTime = this.lastAnimationTime;
            if (!this.method_37908().method_8608() && this.field_6012 % 20 == 0 && Derelict.INSTANCE.getCONFIG().arachneEggRespawnTime() > 0) {
                if (this.method_37908().method_21726(ArachneEntity.class, class_4051.field_18092, null, this.method_23317(), this.method_23318(), this.method_23321(), class_238.method_30048((class_243)this.method_19538(), (double)20.0, (double)6.0, (double)20.0)) != null) {
                    this.lastTimeWithSpiderInArena = this.method_37908().method_8510();
                }
                if (this.method_37908().method_8510() - this.lastTimeWithSpiderInArena > (long)(20 * Derelict.INSTANCE.getCONFIG().arachneEggRespawnTime())) {
                    this.breakEggStage();
                }
            }
        } else {
            this.field_23807 = true;
        }
        if (this.stageCooldown > 0) {
            int n = this.stageCooldown;
            this.stageCooldown = n + -1;
        }
        if (!this.method_37908().field_9236 && this.field_6012 % 5 == 0 && this.getStage() < 3) {
            class_1937 class_19372 = this.method_37908();
            Intrinsics.checkNotNull((Object)class_19372, (String)"null cannot be cast to non-null type net.minecraft.server.world.ServerWorld");
            ((class_3218)class_19372).method_14199((class_2394)new class_2388(class_2398.field_11217, ModBlocksAndItems.INSTANCE.getSPIDER_EGG_BLOCK().method_9564()), this.method_23317(), this.method_23318() + 1.2, this.method_23321(), 1 + 2 * this.getStage(), 0.8, 1.2, 0.8, 0.05);
        }
    }

    public final float getAnimationTime(float delta) {
        return Easing.lerp((float)this.lastAnimationTime, (float)this.animationTime, (float)delta);
    }

    public boolean method_5643(@NotNull class_1282 source, float amount) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (this.method_37908().field_9236) {
            return super.method_5643(source, amount);
        }
        class_1297 player = source.method_5529();
        if (this.stageCooldown <= 0 && player instanceof class_3222) {
            if (this.getStage() < 3) {
                class_3222 class_32222 = (class_3222)player;
                String string = Derelict.INSTANCE.getCONFIG().arachneEggAdvancement();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"arachneEggAdvancement(...)");
                if (this.canBreakEggIfAdvancementMet(class_32222, string)) {
                    this.breakEggStage();
                    return true;
                }
            }
            return false;
        }
        return super.method_5643(source, amount);
    }

    private final boolean canBreakEggIfAdvancementMet(class_3222 player, String id) {
        if (StringsKt.isBlank((CharSequence)id)) {
            return true;
        }
        class_2960 class_29602 = class_2960.method_12829((String)id);
        if (class_29602 == null) {
            return true;
        }
        class_2960 identifier = class_29602;
        MinecraftServer minecraftServer = this.method_37908().method_8503();
        if (minecraftServer == null || (minecraftServer = minecraftServer.method_3851()) == null || (minecraftServer = minecraftServer.method_12896(identifier)) == null) {
            return true;
        }
        MinecraftServer advancement = minecraftServer;
        if (player.method_14236().method_12882((class_161)advancement).method_740()) {
            return true;
        }
        Object[] objectArray = new Object[1];
        Object object = advancement.method_686();
        if (object == null || (object = object.method_817()) == null) {
            object = "";
        }
        objectArray[0] = object;
        player.method_7353((class_2561)class_2561.method_43469((String)"text.derelict.spider_egg_required_advancement", (Object[])objectArray), true);
        return false;
    }

    private final void breakEggStage() {
        if (this.getStage() < 4) {
            this.setStage((this.getStage() + 1) % 4);
            this.stageCooldown = 20;
            this.method_37908().method_8396(null, this.method_24515(), class_3417.field_14657, class_3419.field_15251, 0.5f, 0.5f);
            class_1937 class_19372 = this.method_37908();
            Intrinsics.checkNotNull((Object)class_19372, (String)"null cannot be cast to non-null type net.minecraft.server.world.ServerWorld");
            ScreenShakeUtils.shakeAround((class_3218)((class_3218)class_19372), (class_243)this.method_19538(), (float)(1.0f + 0.5f * (float)this.getStage()), (int)(this.getStage() == 3 ? 70 : 40), (double)8.0, (double)20.0);
            class_1937 class_19373 = this.method_37908();
            Intrinsics.checkNotNull((Object)class_19373, (String)"null cannot be cast to non-null type net.minecraft.server.world.ServerWorld");
            ((class_3218)class_19373).method_14199((class_2394)new class_2388(class_2398.field_11217, ModBlocksAndItems.INSTANCE.getSPIDER_EGG_BLOCK().method_9564()), this.method_23317(), this.method_23318() + 1.2, this.method_23321(), 80, 0.6, 1.0, 0.6, 0.05);
            if (this.getStage() == 3) {
                class_1937 class_19374 = this.method_37908();
                Intrinsics.checkNotNull((Object)class_19374, (String)"null cannot be cast to non-null type net.minecraft.server.world.ServerWorld");
                ((class_3218)class_19374).method_14199((class_2394)class_2398.field_11221, this.method_23317(), this.method_23318() + 1.2, this.method_23321(), 3, 2.8, 2.8, 2.8, 0.05);
                this.method_5783(class_3417.field_14803, 1.0f, 1.0f);
                this.method_5783(class_3417.field_14579, 2.0f, 0.2f);
                class_1299<ArachneEntity> class_12992 = ModEntities.INSTANCE.getARACHNE();
                class_1937 class_19375 = this.method_37908();
                Intrinsics.checkNotNullExpressionValue((Object)class_19375, (String)"getWorld(...)");
                ArachneEntity boss = new ArachneEntity(class_12992, class_19375);
                boss.setSpawnPos(this.method_24515().method_10077(4));
                boss.method_33574(this.method_19538());
                this.method_37908().method_8649((class_1297)boss);
            }
            List list = this.method_37908().method_8390(class_1309.class, this.method_5829().method_1014(5.0), arg_0 -> ArachneEggEntity.breakEggStage$lambda$1(ArachneEggEntity::breakEggStage$lambda$0, arg_0));
            Intrinsics.checkNotNullExpressionValue((Object)list, (String)"getEntitiesByClass(...)");
            Iterable $this$forEach$iv = list;
            boolean $i$f$forEach = false;
            for (Object element$iv : $this$forEach$iv) {
                class_1309 it = (class_1309)element$iv;
                boolean bl = false;
                it.method_5643(this.method_48923().method_48830(), 1.0f);
                it.method_6005((double)this.getStage(), this.method_23317() - it.method_23317(), this.method_23321() - it.method_23321());
            }
        }
    }

    protected void method_5749(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        this.setStage(nbt.method_10550("stage"));
    }

    protected void method_5652(@NotNull class_2487 nbt) {
        Intrinsics.checkNotNullParameter((Object)nbt, (String)"nbt");
        nbt.method_10569("stage", this.getStage());
    }

    public boolean method_5863() {
        return this.getStage() != 3;
    }

    public boolean method_30948() {
        return this.method_5863();
    }

    public boolean method_30949(@NotNull class_1297 other) {
        Intrinsics.checkNotNullParameter((Object)other, (String)"other");
        return this.method_5863();
    }

    private static final boolean breakEggStage$lambda$0(class_1309 it) {
        return !(it instanceof ArachneEntity);
    }

    private static final boolean breakEggStage$lambda$1(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)((MutablePropertyReference1)new MutablePropertyReference1Impl(ArachneEggEntity.class, "stage", "getStage()I", 0)))};
        $$delegatedProperties = kPropertyArray;
        Companion = new Companion(null);
        class_2940 class_29402 = class_2945.method_12791(ArachneEggEntity.class, (class_2941)class_2943.field_13327);
        Intrinsics.checkNotNullExpressionValue((Object)class_29402, (String)"registerData(...)");
        STAGE = class_29402;
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Ldev/mim1q/derelict/entity/spider/ArachneEggEntity$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_2940;", "", "STAGE", "Lnet/minecraft/class_2940;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

