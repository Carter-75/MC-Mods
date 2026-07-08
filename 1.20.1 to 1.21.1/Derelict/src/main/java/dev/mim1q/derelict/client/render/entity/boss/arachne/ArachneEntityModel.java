/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.mim1q.gimm1q.interpolation.Easing
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.IntIterator
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.ranges.IntRange
 *  kotlin.ranges.RangesKt
 *  net.minecraft.class_1921
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.boss.arachne;

import dev.mim1q.derelict.entity.boss.ArachneEntity;
import dev.mim1q.derelict.entity.spider.legs.SpiderLegParts;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import dev.mim1q.derelict.util.extensions.ModelExtensionsKt;
import dev.mim1q.gimm1q.interpolation.Easing;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import net.minecraft.class_1921;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_583;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001c\u0010$\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010#R\u001c\u0010%\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010#R\"\u0010'\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00030\u00030&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010)\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u001c\u0010*\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010#R\u001c\u0010+\u001a\n !*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00062"}, d2={"Ldev/mim1q/derelict/client/render/entity/boss/arachne/ArachneEntityModel;", "Lnet/minecraft/class_583;", "Ldev/mim1q/derelict/entity/boss/ArachneEntity;", "Lnet/minecraft/class_630;", "root", "<init>", "(Lnet/minecraft/class_630;)V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4588;", "vertices", "", "light", "overlay", "", "red", "green", "blue", "alpha", "", "render", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IIFFFF)V", "entity", "limbAngle", "limbDistance", "animationProgress", "headYaw", "headPitch", "setAngles", "(Ldev/mim1q/derelict/entity/boss/ArachneEntity;FFFFF)V", "tickDelta", "animateModel", "(Ldev/mim1q/derelict/entity/boss/ArachneEntity;FFF)V", "kotlin.jvm.PlatformType", "body", "Lnet/minecraft/class_630;", "sternum", "abdomen", "", "eggs", "Ljava/util/List;", "head", "leftFang", "rightFang", "", "Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "legs", "[Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "getLegs", "()[Ldev/mim1q/derelict/entity/spider/legs/SpiderLegParts;", "derelict"})
@SourceDebugExtension(value={"SMAP\nArachneEntityModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ArachneEntityModel.kt\ndev/mim1q/derelict/client/render/entity/boss/arachne/ArachneEntityModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,120:1\n1557#2:121\n1628#2,3:122\n1872#2,3:128\n13411#3,3:125\n13411#3,3:131\n*S KotlinDebug\n*F\n+ 1 ArachneEntityModel.kt\ndev/mim1q/derelict/client/render/entity/boss/arachne/ArachneEntityModel\n*L\n21#1:121\n21#1:122,3\n106#1:128,3\n90#1:125,3\n112#1:131,3\n*E\n"})
public final class ArachneEntityModel
extends class_583<ArachneEntity> {
    private final class_630 body;
    private final class_630 sternum;
    private final class_630 abdomen;
    @NotNull
    private final List<class_630> eggs;
    private final class_630 head;
    private final class_630 leftFang;
    private final class_630 rightFang;
    @NotNull
    private final SpiderLegParts[] legs;

    /*
     * WARNING - void declaration
     */
    public ArachneEntityModel(@NotNull class_630 root) {
        void $this$mapTo$iv$iv;
        void $this$map$iv;
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        super(class_1921::method_23576);
        this.body = root.method_32086("body");
        this.sternum = this.body.method_32086("sternum");
        this.abdomen = this.sternum.method_32086("abdomen");
        Iterable iterable = (Iterable)new IntRange(0, 16);
        ArachneEntityModel arachneEntityModel = this;
        boolean $i$f$map = false;
        void var4_5 = $this$map$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)$this$map$iv, (int)10));
        boolean $i$f$mapTo = false;
        Iterator iterator = $this$mapTo$iv$iv.iterator();
        while (iterator.hasNext()) {
            void it;
            int item$iv$iv;
            int n = item$iv$iv = ((IntIterator)iterator).nextInt();
            Collection collection = destination$iv$iv;
            boolean bl = false;
            collection.add(this.abdomen.method_32086("eggs").method_32086("egg" + (int)it));
        }
        arachneEntityModel.eggs = (List)destination$iv$iv;
        this.head = this.body.method_32086("head");
        this.leftFang = this.head.method_32086("left_fang");
        this.rightFang = this.head.method_32086("right_fang");
        class_630 class_6302 = this.body;
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"body");
        this.legs = SpiderLegParts.Companion.createArray(class_6302);
    }

    @NotNull
    public final SpiderLegParts[] getLegs() {
        return this.legs;
    }

    public void method_2828(@NotNull class_4587 matrices, @NotNull class_4588 vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        Intrinsics.checkNotNullParameter((Object)matrices, (String)"matrices");
        Intrinsics.checkNotNullParameter((Object)vertices, (String)"vertices");
        this.body.method_22699(matrices, vertices, light, overlay, red, green, blue, alpha);
    }

    /*
     * WARNING - void declaration
     */
    public void setAngles(@NotNull ArachneEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        this.head.method_33425(MathExtensionsKt.radians(headPitch), MathExtensionsKt.radians(headYaw), 0.0f);
        float screaming = entity.getLegsRaisedAnimation().update(animationProgress);
        float shaking = entity.getShakingAnimation().update(animationProgress);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[0].getUpper(), 0.0f, -70.0f, 0.0f, screaming);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[0].getLower(), 0.0f, 50.0f, 0.0f, screaming);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[0].getJoint(), 0.0f, 0.0f, 60.0f, screaming);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[4].getUpper(), 0.0f, 70.0f, 0.0f, screaming);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[4].getLower(), 0.0f, -50.0f, 0.0f, screaming);
        ModelExtensionsKt.setPartialAnglesDegrees(this.legs[4].getJoint(), 0.0f, 0.0f, -60.0f, screaming);
        class_630 class_6302 = this.body;
        class_6302.field_3675 += (float)Math.sin(animationProgress * 3.0f) * MathExtensionsKt.radians(1.0f) * shaking;
        class_6302 = this.abdomen;
        class_6302.field_3675 += (float)Math.sin(animationProgress * 3.0f - 1.0f) * MathExtensionsKt.radians(5.0f) * shaking;
        class_6302 = this.head;
        class_6302.field_3675 += (float)Math.sin(animationProgress * 5.0f - 1.0f) * MathExtensionsKt.radians(2.0f) * shaking;
        float leftLegStomp = entity.getLeftLegStomp().update(animationProgress);
        float rightLegStomp = entity.getRightLegStomp().update(animationProgress);
        class_630 class_6303 = this.legs[0].getUpper();
        class_6303.field_3674 += MathExtensionsKt.radians(60.0f) * leftLegStomp;
        class_6303 = this.legs[0].getJoint();
        class_6303.field_3675 += MathExtensionsKt.radians(20.0f) * leftLegStomp;
        class_6303 = this.legs[4].getUpper();
        class_6303.field_3674 -= MathExtensionsKt.radians(60.0f) * rightLegStomp;
        class_6303 = this.legs[4].getJoint();
        class_6303.field_3675 -= MathExtensionsKt.radians(20.0f) * rightLegStomp;
        float fangAnimation = entity.getFangsAnimation().update(animationProgress);
        class_630 class_6304 = this.leftFang;
        class_6304.field_3674 += fangAnimation * MathExtensionsKt.radians(20.0f);
        class_6304 = this.leftFang;
        class_6304.field_3654 -= fangAnimation * MathExtensionsKt.radians(60.0f);
        class_6304 = this.rightFang;
        class_6304.field_3674 -= fangAnimation * MathExtensionsKt.radians(20.0f);
        class_6304 = this.rightFang;
        class_6304.field_3654 -= fangAnimation * MathExtensionsKt.radians(60.0f);
        class_6304 = this.head;
        class_6304.field_3654 -= fangAnimation * MathExtensionsKt.radians(15.0f);
        if (entity.method_29504()) {
            float death = entity.getDeathAnimation().update(animationProgress);
            float jumpParam = RangesKt.coerceAtMost((float)(entity.getDeathAnimation().getProgress() * (float)3), (float)1.0f);
            float jump = (float)-4 * jumpParam * (jumpParam - 1.0f);
            class_630 class_6305 = this.body;
            class_6305.field_3656 -= (float)16 * jump;
            class_6305 = this.body;
            class_6305.field_3655 -= (float)16 * jumpParam;
            class_6305 = this.body;
            class_6305.field_3654 -= MathExtensionsKt.radians(180.0f) * jumpParam;
            SpiderLegParts[] $this$forEachIndexed$iv = this.legs;
            boolean $i$f$forEachIndexed = false;
            int index$iv = 0;
            for (SpiderLegParts item$iv : $this$forEachIndexed$iv) {
                void leg;
                int n = index$iv++;
                SpiderLegParts spiderLegParts = item$iv;
                int i = n;
                boolean bl = false;
                int mul = i < 4 ? 1 : -1;
                ModelExtensionsKt.setPartialRoll(leg.getLower(), (float)mul * MathExtensionsKt.radians(130.0f), death);
                ModelExtensionsKt.setPartialRoll(leg.getUpper(), (float)mul * MathExtensionsKt.radians(40.0f), death);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void animateModel(@NotNull ArachneEntity entity, float limbAngle, float limbDistance, float tickDelta) {
        boolean bl;
        int index;
        Intrinsics.checkNotNullParameter((Object)((Object)entity), (String)"entity");
        float animationProgress = (float)entity.field_6012 + tickDelta;
        this.body.method_41923();
        this.abdomen.method_41923();
        this.leftFang.method_41923();
        this.rightFang.method_41923();
        SpiderLegParts[] $this$forEachIndexed$iv = (SpiderLegParts[])this.eggs;
        boolean $i$f$forEachIndexed = false;
        int index$iv = 0;
        for (Object t : $this$forEachIndexed$iv) {
            float scale;
            int n;
            if ((n = index$iv++) < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            class_630 class_6302 = (class_630)t;
            index = n;
            bl = false;
            float speed = 7.0f + (float)Math.sin((float)index * 100.0f) * 3.0f;
            ((class_630)egg).field_37938 = scale = 1.0f + (float)Math.sin((animationProgress + (float)index * speed) * 0.25f) * 0.1f;
            ((class_630)egg).field_37939 = scale;
            ((class_630)egg).field_37940 = scale;
        }
        $this$forEachIndexed$iv = this.legs;
        $i$f$forEachIndexed = false;
        index$iv = 0;
        for (SpiderLegParts item$iv : $this$forEachIndexed$iv) {
            void it;
            int n = index$iv++;
            SpiderLegParts egg = item$iv;
            index = n;
            bl = false;
            it.applyIk(entity.getLegController().getIk(index), Easing.lerp((float)entity.field_6220, (float)entity.field_6283, (float)tickDelta), tickDelta);
        }
    }
}

