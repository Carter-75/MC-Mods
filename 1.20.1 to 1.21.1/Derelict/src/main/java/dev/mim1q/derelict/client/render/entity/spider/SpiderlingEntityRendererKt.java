/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.client.render.entity.spider;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0001\u0010\u0002\u00a8\u0006\u0003"}, d2={"Lnet/minecraft/class_5607;", "getSpiderlingTexturedModelData", "()Lnet/minecraft/class_5607;", "derelict"})
public final class SpiderlingEntityRendererKt {
    @NotNull
    public static final class_5607 getSpiderlingTexturedModelData() {
        class_5609 modelData = new class_5609();
        class_5610 modelPartData = modelData.method_32111();
        class_5610 main = modelPartData.method_32117("", class_5606.method_32108().method_32101(0, 0).method_32098(-2.5f, -2.0f, 1.0f, 5.0f, 4.0f, 5.0f, new class_5605(0.0f)).method_32101(0, 18).method_32098(-1.5f, 0.0f, -2.0f, 3.0f, 2.0f, 3.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)19.0f, (float)0.0f));
        class_5610 leftLegs = main.method_32117("leftLegs", class_5606.method_32108(), class_5603.method_32090((float)0.5f, (float)2.25f, (float)-0.5f));
        leftLegs.method_32117("leftLeg0", class_5606.method_32108().method_32101(0, 24).method_32098(-1.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)1.0f, (float)-0.75f, (float)-2.0f));
        leftLegs.method_32117("leftLeg1", class_5606.method_32108().method_32101(0, 28).method_32098(-1.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)1.0f, (float)-0.75f, (float)-0.75f));
        leftLegs.method_32117("leftLeg2", class_5606.method_32108().method_32101(0, 24).method_32098(-1.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)1.0f, (float)-0.75f, (float)0.5f));
        leftLegs.method_32117("leftLeg3", class_5606.method_32108().method_32101(0, 28).method_32098(-1.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)), class_5603.method_32090((float)1.0f, (float)-0.75f, (float)1.75f));
        class_5610 rightLegs = main.method_32117("rightLegs", class_5606.method_32108(), class_5603.method_32090((float)-0.5f, (float)2.25f, (float)-0.5f));
        rightLegs.method_32117("rightLeg0", class_5606.method_32108().method_32101(0, 30).method_32096().method_32098(-6.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32106(false), class_5603.method_32090((float)-1.0f, (float)-0.75f, (float)-2.0f));
        rightLegs.method_32117("rightLeg1", class_5606.method_32108().method_32101(0, 26).method_32096().method_32098(-6.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32106(false), class_5603.method_32090((float)-1.0f, (float)-0.75f, (float)-0.75f));
        rightLegs.method_32117("rightLeg2", class_5606.method_32108().method_32101(0, 30).method_32096().method_32098(-6.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32106(false), class_5603.method_32090((float)-1.0f, (float)-0.75f, (float)0.5f));
        rightLegs.method_32117("rightLeg3", class_5606.method_32108().method_32101(0, 26).method_32096().method_32098(-6.5f, -0.5f, -0.5f, 8.0f, 1.0f, 1.0f, new class_5605(0.0f)).method_32106(false), class_5603.method_32090((float)-1.0f, (float)-0.75f, (float)1.75f));
        class_5610 neck = main.method_32117("neck", class_5606.method_32108(), class_5603.method_32090((float)0.0f, (float)0.5f, (float)-2.0f));
        neck.method_32117("head", class_5606.method_32108().method_32101(0, 9).method_32098(-2.0f, -1.5f, -4.0f, 4.0f, 3.0f, 4.0f, new class_5605(0.0f)).method_32101(9, 20).method_32098(-1.5f, 1.5f, -4.0f, 3.0f, 1.0f, 0.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)0.0f, (float)0.0f));
        class_5607 class_56072 = class_5607.method_32110((class_5609)modelData, (int)32, (int)32);
        Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"of(...)");
        return class_56072;
    }
}

