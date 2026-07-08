/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3999
 *  net.minecraft.class_4002
 *  net.minecraft.class_4003
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_638
 *  net.minecraft.class_703
 *  net.minecraft.class_707
 *  net.minecraft.class_7833
 *  org.jetbrains.annotations.NotNull
 *  org.joml.Matrix4f
 *  org.joml.Vector3f
 */
package dev.mim1q.derelict.particle.spider;

import dev.mim1q.derelict.particle.spider.SpiderParticleEffect;
import dev.mim1q.derelict.util.extensions.MathExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3999;
import net.minecraft.class_4002;
import net.minecraft.class_4003;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;
import net.minecraft.class_7833;
import org.jetbrains.annotations.NotNull;
import org.joml.Matrix4f;
import org.joml.Vector3f;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\u0018\u0000 72\u00020\u0001:\u000278B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J?\u0010!\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b!\u0010\"J'\u0010#\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0017H\u0016\u00a2\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b'\u0010(J'\u0010)\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b+\u0010&JE\u0010/\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010,\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u00152\b\b\u0002\u0010.\u001a\u00020\u0015H\u0002\u00a2\u0006\u0004\b/\u00100R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0016\u00102\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u0010\t\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b6\u00105\u00a8\u00069"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticle;", "Lnet/minecraft/class_4003;", "Lnet/minecraft/class_638;", "world", "", "x", "y", "z", "vx", "vz", "Lnet/minecraft/class_2350;", "direction", "<init>", "(Lnet/minecraft/class_638;DDDDDLnet/minecraft/class_2350;)V", "Lnet/minecraft/class_3999;", "getType", "()Lnet/minecraft/class_3999;", "Lnet/minecraft/class_4588;", "vertexConsumer", "Lnet/minecraft/class_4184;", "camera", "", "tickDelta", "", "buildGeometry", "(Lnet/minecraft/class_4588;Lnet/minecraft/class_4184;F)V", "Lnet/minecraft/class_4587;", "matrices", "", "light", "xOffset", "zOffset", "angle", "drawLeg", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_4588;IDDF)V", "rotateMatrices", "(Lnet/minecraft/class_4587;Lnet/minecraft/class_2350;F)V", "tick", "()V", "getSize", "(F)F", "setVelocity", "(DDD)V", "setAngle", "width", "height", "u", "drawBillboard", "(Lnet/minecraft/class_4588;Lnet/minecraft/class_4587;IFFF)V", "Lnet/minecraft/class_2350;", "rotation", "F", "getVx", "()D", "getVz", "Companion", "Factory", "derelict"})
@SourceDebugExtension(value={"SMAP\nSpiderParticle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpiderParticle.kt\ndev/mim1q/derelict/particle/spider/SpiderParticle\n+ 2 RenderUtil.kt\ndev/mim1q/derelict/util/render/RenderUtilKt\n*L\n1#1,259:1\n12#2,2:260\n12#2,4:262\n14#2,2:266\n12#2,4:268\n*S KotlinDebug\n*F\n+ 1 SpiderParticle.kt\ndev/mim1q/derelict/particle/spider/SpiderParticle\n*L\n47#1:260,2\n59#1:262,4\n47#1:266,2\n101#1:268,4\n*E\n"})
public final class SpiderParticle
extends class_4003 {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final class_2350 direction;
    private float rotation;
    @NotNull
    private static final class_4587 matrices = new class_4587();

    public SpiderParticle(@NotNull class_638 world, double x, double y, double z, double vx, double vz, @NotNull class_2350 direction) {
        Intrinsics.checkNotNullParameter((Object)world, (String)"world");
        Intrinsics.checkNotNullParameter((Object)direction, (String)"direction");
        super(world, x, y, z, 0.0, 0.0, 0.0);
        this.direction = direction;
        this.field_3847 = 40 + this.field_3840.method_43048(40);
        this.field_3841 = 0.0f;
        this.field_17867 = this.field_3840.method_43057() * 0.05f + 0.1f;
        this.field_28786 = class_3532.method_15355((float)((float)(vx * vx + vz * vz)));
        this.rotation = (float)class_3532.method_15349((double)vz, (double)vx);
    }

    private final double getVx() {
        return (double)class_3532.method_15374((float)(1.5707964f - this.rotation)) * (double)this.field_28786;
    }

    private final double getVz() {
        return (double)class_3532.method_15362((float)(1.5707964f - this.rotation)) * (double)this.field_28786;
    }

    @NotNull
    public class_3999 method_18122() {
        class_3999 class_39992 = class_3999.field_17829;
        Intrinsics.checkNotNullExpressionValue((Object)class_39992, (String)"PARTICLE_SHEET_TRANSLUCENT");
        return class_39992;
    }

    public void method_3074(@NotNull class_4588 vertexConsumer, @NotNull class_4184 camera, float tickDelta) {
        Intrinsics.checkNotNullParameter((Object)vertexConsumer, (String)"vertexConsumer");
        Intrinsics.checkNotNullParameter((Object)camera, (String)"camera");
        class_4587 $this$entry$iv = matrices;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$buildGeometry_u24lambda_u242 = $this$entry$iv;
        boolean bl = false;
        double x = class_3532.method_16436((double)tickDelta, (double)this.field_3858, (double)this.field_3874);
        double y = class_3532.method_16436((double)tickDelta, (double)this.field_3838, (double)this.field_3854);
        double z = class_3532.method_16436((double)tickDelta, (double)this.field_3856, (double)this.field_3871);
        int light = this.method_3068(0.0f);
        $this$buildGeometry_u24lambda_u242.method_22904(x - camera.method_19326().field_1352, y - camera.method_19326().field_1351, z - camera.method_19326().field_1350);
        float scale = this.method_18132(tickDelta) / 8.0f;
        $this$buildGeometry_u24lambda_u242.method_22905(scale, scale, scale);
        this.rotateMatrices(matrices, this.direction, class_3532.method_16439((float)tickDelta, (float)this.field_3857, (float)this.field_3839));
        $this$buildGeometry_u24lambda_u242.method_22904(0.0, 0.0, -0.01);
        class_4587 $this$entry$iv2 = matrices;
        boolean $i$f$entry2 = false;
        $this$entry$iv2.method_22903();
        class_4587 $this$buildGeometry_u24lambda_u242_u24lambda_u241 = $this$entry$iv2;
        boolean bl2 = false;
        $this$buildGeometry_u24lambda_u242_u24lambda_u241.method_22904(-1.5, 0.0, -0.2);
        int n = 3;
        int n2 = 0;
        while (n2 < n) {
            int it = n2++;
            boolean bl3 = false;
            SpiderParticle.drawBillboard$default(this, vertexConsumer, matrices, light, 3.0f, 8.0f, 0.0f, 32, null);
            $this$buildGeometry_u24lambda_u242_u24lambda_u241.method_22904(0.0, 0.0, -0.3);
        }
        $this$entry$iv2.method_22909();
        float time = ((float)this.field_3866 + tickDelta) * 0.67f;
        float angle1 = class_3532.method_15379((float)class_3532.method_15374((float)time));
        float angle2 = class_3532.method_15379((float)class_3532.method_15374((float)(time + MathExtensionsKt.radians(90.0f))));
        float angle3 = class_3532.method_15379((float)class_3532.method_15374((float)(time + MathExtensionsKt.radians(45.0f))));
        float angle4 = class_3532.method_15379((float)class_3532.method_15374((float)(time + MathExtensionsKt.radians(135.0f))));
        this.drawLeg(matrices, vertexConsumer, light, -1.0, 5.0, 60.0f - angle1 * 50.0f);
        this.drawLeg(matrices, vertexConsumer, light, -0.5, 4.5, 100.0f - angle2 * 50.0f);
        this.drawLeg(matrices, vertexConsumer, light, -0.5, 3.5, 140.0f - angle3 * 40.0f);
        this.drawLeg(matrices, vertexConsumer, light, -1.25, 2.5, 180.0f - angle4 * 50.0f);
        this.drawLeg(matrices, vertexConsumer, light, 1.0, 5.0, -60.0f + angle4 * 50.0f);
        this.drawLeg(matrices, vertexConsumer, light, 0.5, 4.5, -100.0f + angle1 * 50.0f);
        this.drawLeg(matrices, vertexConsumer, light, 0.5, 3.5, -140.0f + angle2 * 40.0f);
        this.drawLeg(matrices, vertexConsumer, light, 1.25, 2.5, -180.0f + angle3 * 50.0f);
        $this$entry$iv.method_22909();
    }

    private final void drawLeg(class_4587 matrices, class_4588 vertexConsumer, int light, double xOffset, double zOffset, float angle) {
        class_4587 $this$entry$iv = matrices;
        boolean $i$f$entry = false;
        $this$entry$iv.method_22903();
        class_4587 $this$drawLeg_u24lambda_u243 = $this$entry$iv;
        boolean bl = false;
        $this$drawLeg_u24lambda_u243.method_22904(xOffset, zOffset, 0.005);
        $this$drawLeg_u24lambda_u243.method_22907(class_7833.field_40718.rotationDegrees(angle));
        $this$drawLeg_u24lambda_u243.method_22904(-0.5, 0.0, 0.0);
        this.drawBillboard(vertexConsumer, matrices, light, 1.0f, 6.0f, 0.25f);
        $this$entry$iv.method_22909();
    }

    private final void rotateMatrices(class_4587 matrices, class_2350 direction, float angle) {
        switch (WhenMappings.$EnumSwitchMapping$0[direction.ordinal()]) {
            case 1: {
                matrices.method_22907(class_7833.field_40713.rotationDegrees(90.0f));
                matrices.method_22907(class_7833.field_40718.rotation(angle + 1.5707964f));
                break;
            }
            case 2: {
                matrices.method_22907(class_7833.field_40714.rotationDegrees(90.0f));
                matrices.method_22907(class_7833.field_40718.rotation(angle - 1.5707964f));
                break;
            }
            default: {
                matrices.method_22907(class_7833.field_40715.rotationDegrees(direction.method_10144()));
                matrices.method_22907(class_7833.field_40718.rotation(angle));
            }
        }
    }

    public void method_3070() {
        int remaining;
        block6: {
            block5: {
                boolean zVel;
                this.rotation += (this.field_3840.method_43057() - 0.5f) * (this.field_3840.method_43057() < 0.1f ? 1.0f : 0.2f);
                this.setAngle();
                this.method_34753(this.getVx(), 0.0, this.getVz());
                this.method_3080(0.01f, 0.01f);
                class_243 offset = new class_243(this.field_3852, this.field_3869, this.field_3850).method_1021(1.5).method_1019(class_243.method_24954((class_2382)this.direction.method_10163()).method_1021(0.5));
                boolean xVel = Math.abs(this.field_3874 - this.field_3858) < (double)1.0E-5f;
                boolean yVel = Math.abs(this.field_3854 - this.field_3838) < (double)1.0E-5f;
                boolean bl = zVel = Math.abs(this.field_3871 - this.field_3856) < (double)1.0E-5f;
                if (this.field_3866 > 2 && xVel ^ yVel ^ zVel ^ true) break block5;
                Iterable iterable = this.field_3851.method_20812(null, this.method_3064().method_989(offset.field_1352, offset.field_1351, offset.field_1350));
                Intrinsics.checkNotNullExpressionValue((Object)iterable, (String)"getBlockCollisions(...)");
                if (!CollectionsKt.none((Iterable)iterable)) break block6;
            }
            this.method_3085();
            return;
        }
        super.method_3070();
        if (this.field_3866 <= 4) {
            this.field_3841 = (float)this.field_3866 / 4.0f;
        }
        if ((remaining = this.field_3847 - this.field_3866) <= 5) {
            this.field_3841 = (float)remaining / 5.0f;
        }
    }

    public float method_18132(float tickDelta) {
        float multiplier = this.field_3866 <= 4 ? ((float)this.field_3866 + tickDelta) / 4.0f : ((float)(this.field_3847 - this.field_3866) - tickDelta <= 5.0f ? ((float)(this.field_3847 - this.field_3866) - tickDelta) / 5.0f : 1.0f);
        return this.field_17867 * multiplier;
    }

    public void method_34753(double x, double y, double z) {
        switch (WhenMappings.$EnumSwitchMapping$0[this.direction.ordinal()]) {
            case 1: 
            case 2: {
                super.method_34753(x, 0.0, z);
                break;
            }
            case 3: 
            case 4: {
                super.method_34753(x, z, 0.0);
                break;
            }
            case 5: 
            case 6: {
                super.method_34753(0.0, x, z);
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final void setAngle() {
        this.field_3857 = this.field_3839;
        this.field_3839 = switch (WhenMappings.$EnumSwitchMapping$0[this.direction.ordinal()]) {
            case 2 -> this.rotation;
            case 1 -> (float)Math.PI - this.rotation;
            case 3 -> 1.5707964f - this.rotation;
            case 4 -> this.rotation - 1.5707964f;
            case 5 -> this.rotation;
            case 6 -> -this.rotation;
            default -> throw new NoWhenBranchMatchedException();
        };
    }

    private final void drawBillboard(class_4588 vertexConsumer, class_4587 matrices, int light, float width, float height, float u) {
        Vector3f[] vector3fArray = new Vector3f[]{new Vector3f(0.0f, 0.0f, 0.0f), new Vector3f(0.0f, height, 0.0f), new Vector3f(width, height, 0.0f), new Vector3f(width, 0.0f, 0.0f)};
        Vector3f[] vertices = vector3fArray;
        float uOffset = (this.method_18134() - this.method_18133()) * u;
        float maxU = class_3532.method_16439((float)(width / 16.0f), (float)this.method_18133(), (float)this.method_18134()) + uOffset;
        float maxV = class_3532.method_16439((float)(height / 16.0f), (float)this.method_18135(), (float)this.method_18136());
        float minU = this.method_18133() + uOffset;
        float minV = this.method_18135();
        Matrix4f posMatrix = matrices.method_23760().method_23761();
        vertexConsumer.method_22918(posMatrix, vertices[0].x, vertices[0].y, vertices[0].z).method_22913(maxU, maxV).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(light).method_1344();
        vertexConsumer.method_22918(posMatrix, vertices[1].x, vertices[1].y, vertices[1].z).method_22913(maxU, minV).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(light).method_1344();
        vertexConsumer.method_22918(posMatrix, vertices[2].x, vertices[2].y, vertices[2].z).method_22913(minU, minV).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(light).method_1344();
        vertexConsumer.method_22918(posMatrix, vertices[3].x, vertices[3].y, vertices[3].z).method_22913(minU, maxV).method_22915(this.field_3861, this.field_3842, this.field_3859, this.field_3841).method_22916(light).method_1344();
    }

    static /* synthetic */ void drawBillboard$default(SpiderParticle spiderParticle, class_4588 class_45882, class_4587 class_45872, int n, float f, float f2, float f3, int n2, Object object) {
        if ((n2 & 8) != 0) {
            f = 1.0f;
        }
        if ((n2 & 0x10) != 0) {
            f2 = 1.0f;
        }
        if ((n2 & 0x20) != 0) {
            f3 = 0.0f;
        }
        spiderParticle.drawBillboard(class_45882, class_45872, n, f, f2, f3);
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticle$Companion;", "", "<init>", "()V", "Lnet/minecraft/class_4587;", "matrices", "Lnet/minecraft/class_4587;", "getMatrices", "()Lnet/minecraft/class_4587;", "derelict"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final class_4587 getMatrices() {
            return matrices;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006JO\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0014\u00a8\u0006\u0015"}, d2={"Ldev/mim1q/derelict/particle/spider/SpiderParticle$Factory;", "Lnet/minecraft/class_707;", "Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;", "Lnet/minecraft/class_4002;", "spriteProvider", "<init>", "(Lnet/minecraft/class_4002;)V", "parameters", "Lnet/minecraft/class_638;", "world", "", "x", "y", "z", "velocityX", "velocityY", "velocityZ", "Lnet/minecraft/class_703;", "createParticle", "(Ldev/mim1q/derelict/particle/spider/SpiderParticleEffect;Lnet/minecraft/class_638;DDDDDD)Lnet/minecraft/class_703;", "Lnet/minecraft/class_4002;", "derelict"})
    public static final class Factory
    implements class_707<SpiderParticleEffect> {
        @NotNull
        private final class_4002 spriteProvider;

        public Factory(@NotNull class_4002 spriteProvider) {
            Intrinsics.checkNotNullParameter((Object)spriteProvider, (String)"spriteProvider");
            this.spriteProvider = spriteProvider;
        }

        @NotNull
        public class_703 createParticle(@NotNull SpiderParticleEffect parameters, @NotNull class_638 world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            Intrinsics.checkNotNullParameter((Object)parameters, (String)"parameters");
            Intrinsics.checkNotNullParameter((Object)world, (String)"world");
            SpiderParticle particle = new SpiderParticle(world, x, y, z, velocityX, velocityZ, parameters.getDirection());
            particle.method_18140(this.spriteProvider);
            return (class_703)particle;
        }
    }

    @Metadata(mv={2, 0, 0}, k=3, xi=48)
    public final class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] nArray = new int[class_2350.values().length];
            try {
                nArray[class_2350.field_11036.ordinal()] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11033.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11043.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11035.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11034.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            try {
                nArray[class_2350.field_11039.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                // empty catch block
            }
            $EnumSwitchMapping$0 = nArray;
        }
    }
}

