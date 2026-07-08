/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.class_1308
 *  net.minecraft.class_2960
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_5601
 *  net.minecraft.class_5603
 *  net.minecraft.class_5605
 *  net.minecraft.class_5606
 *  net.minecraft.class_5607
 *  net.minecraft.class_5609
 *  net.minecraft.class_5610
 *  net.minecraft.class_583
 *  net.minecraft.class_630
 */
package org.valkyrienskies.mod.client;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_1308;
import net.minecraft.class_2960;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_5601;
import net.minecraft.class_5603;
import net.minecraft.class_5605;
import net.minecraft.class_5606;
import net.minecraft.class_5607;
import net.minecraft.class_5609;
import net.minecraft.class_5610;
import net.minecraft.class_583;
import net.minecraft.class_630;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001!B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 JO\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J?\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/mod/client/VSPhysicsEntityModel;", "Lnet/minecraft/class_1308;", "T", "Lnet/minecraft/class_583;", "Lnet/minecraft/class_4587;", "poseStack", "Lnet/minecraft/class_4588;", "vertexConsumer", "", "packedLight", "packedOverlay", "", "red", "green", "blue", "alpha", "", "renderToBuffer", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IIFFFF)V", "entity", "f", "g", "h", "i", "j", "setupAnim", "(Lnet/minecraft/class_1308;FFFFF)V", "Lnet/minecraft/class_630;", "bb_main", "Lnet/minecraft/class_630;", "root", "<init>", "(Lnet/minecraft/class_630;)V", "Companion", "valkyrienskies-120"})
public final class VSPhysicsEntityModel<T extends class_1308>
extends class_583<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_630 bb_main;
    @NotNull
    private static final class_5601 LAYER_LOCATION = new class_5601(new class_2960("valkyrienskies", "test_sphere"), "main");

    public VSPhysicsEntityModel(@NotNull class_630 root) {
        Intrinsics.checkNotNullParameter((Object)root, (String)"root");
        class_630 class_6302 = root.method_32086("bb_main");
        Intrinsics.checkNotNullExpressionValue((Object)class_6302, (String)"getChild(...)");
        this.bb_main = class_6302;
    }

    public void method_2828(@NotNull class_4587 poseStack, @NotNull class_4588 vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Intrinsics.checkNotNullParameter((Object)poseStack, (String)"poseStack");
        Intrinsics.checkNotNullParameter((Object)vertexConsumer, (String)"vertexConsumer");
        this.bb_main.method_22699(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setupAnim(@NotNull T entity, float f2, float g2, float h2, float i2, float j2) {
        Intrinsics.checkNotNullParameter(entity, (String)"entity");
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2={"Lorg/valkyrienskies/mod/client/VSPhysicsEntityModel$Companion;", "", "Lnet/minecraft/class_5607;", "createBodyLayer", "()Lnet/minecraft/class_5607;", "Lnet/minecraft/class_5601;", "LAYER_LOCATION", "Lnet/minecraft/class_5601;", "getLAYER_LOCATION", "()Lnet/minecraft/class_5601;", "<init>", "()V", "valkyrienskies-120"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_5601 getLAYER_LOCATION() {
            return LAYER_LOCATION;
        }

        @NotNull
        public final class_5607 createBodyLayer() {
            class_5609 meshdefinition = new class_5609();
            class_5610 partdefinition = meshdefinition.method_32111();
            class_5610 bb_main = partdefinition.method_32117("bb_main", class_5606.method_32108().method_32101(0, 3).method_32098(-4.0f, -4.0f, -4.0f, 8.0f, 2.0f, 8.0f, new class_5605(0.0f)).method_32101(1, 1).method_32098(-4.0f, -12.0f, 4.0f, 8.0f, 8.0f, 2.0f, new class_5605(0.0f)).method_32101(2, 0).method_32098(-2.0f, -10.0f, 6.0f, 4.0f, 4.0f, 2.0f, new class_5605(0.0f)).method_32101(0, 3).method_32098(-4.0f, -14.0f, -4.0f, 8.0f, 2.0f, 8.0f, new class_5605(0.0f)).method_32101(2, 0).method_32098(-2.0f, -10.0f, -8.0f, 4.0f, 4.0f, 2.0f, new class_5605(0.0f)).method_32101(0, 0).method_32098(-2.0f, -16.0f, -2.0f, 4.0f, 2.0f, 4.0f, new class_5605(0.0f)).method_32101(0, 0).method_32098(-2.0f, -2.0f, -2.0f, 4.0f, 2.0f, 4.0f, new class_5605(0.0f)), class_5603.method_32090((float)0.0f, (float)24.0f, (float)0.0f));
            class_5610 cube_r1 = bb_main.method_32117("cube_r1", class_5606.method_32108().method_32101(2, 0).method_32098(-2.0f, -3.0f, 0.0f, 4.0f, 4.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32091((float)8.0f, (float)-7.0f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)0.0f));
            class_5610 cube_r2 = bb_main.method_32117("cube_r2", class_5606.method_32108().method_32101(2, 0).method_32098(-2.0f, -3.0f, 0.0f, 4.0f, 4.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32091((float)-6.0f, (float)-7.0f, (float)0.0f, (float)0.0f, (float)-1.5708f, (float)0.0f));
            class_5610 cube_r3 = bb_main.method_32117("cube_r3", class_5606.method_32108().method_32101(0, 0).method_32098(-4.0f, -8.0f, 4.0f, 8.0f, 8.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32091((float)-10.0f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
            class_5610 cube_r4 = bb_main.method_32117("cube_r4", class_5606.method_32108().method_32101(0, 3).method_32098(-4.0f, -8.0f, 4.0f, 8.0f, 8.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.0f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)3.1416f, (float)0.0f));
            class_5610 cube_r5 = bb_main.method_32117("cube_r5", class_5606.method_32108().method_32101(0, 1).method_32098(-4.0f, -8.0f, 4.0f, 8.0f, 8.0f, 2.0f, new class_5605(0.0f)), class_5603.method_32091((float)0.0f, (float)-4.0f, (float)0.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
            class_5607 class_56072 = class_5607.method_32110((class_5609)meshdefinition, (int)16, (int)16);
            Intrinsics.checkNotNullExpressionValue((Object)class_56072, (String)"create(...)");
            return class_56072;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}

