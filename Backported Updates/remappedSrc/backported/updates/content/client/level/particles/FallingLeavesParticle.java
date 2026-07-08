/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2400
 *  net.minecraft.class_3999
 *  net.minecraft.class_4002
 *  net.minecraft.class_4003
 *  net.minecraft.class_638
 *  net.minecraft.class_703
 *  net.minecraft.class_707
 *  net.minecraft.class_9381
 */
package backported.updates.content.client.level.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2400;
import net.minecraft.class_3999;
import net.minecraft.class_4002;
import net.minecraft.class_4003;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;
import net.minecraft.class_9381;

@Environment(value=EnvType.CLIENT)
public class FallingLeavesParticle
extends class_4003 {
    private static final float ACCELERATION_SCALE = 0.0025f;
    private static final int INITIAL_LIFETIME = 300;
    private static final int CURVE_ENDPOINT_TIME = 300;
    private float rotSpeed;
    private final float spinAcceleration;
    private final float windBig;
    private final boolean swirl;
    private final boolean flowAway;
    private final double xaFlowScale;
    private final double zaFlowScale;
    private final double swirlPeriod;

    protected FallingLeavesParticle(class_638 level, double x, double y, double z, class_4002 sprites, float fallAcceleration, float windBig, boolean swirl, boolean flowAway, float scale, float startVelocity) {
        super(level, x, y, z);
        float size;
        this.rotSpeed = (float)Math.toRadians(this.field_3840.method_43056() ? -30.0 : 30.0);
        this.spinAcceleration = (float)Math.toRadians(this.field_3840.method_43056() ? -5.0 : 5.0);
        this.method_18141(sprites.method_18138(this.field_3840.method_43048(12), 12));
        this.windBig = windBig;
        this.swirl = swirl;
        this.flowAway = flowAway;
        this.field_3847 = 300;
        this.field_3844 = fallAcceleration * 1.2f * 0.0025f;
        this.field_17867 = size = scale * (this.field_3840.method_43056() ? 0.05f : 0.075f);
        this.method_3080(size, size);
        this.field_28786 = 1.0f;
        this.field_3869 = -startVelocity;
        float particleRandom = this.field_3840.method_43057();
        this.xaFlowScale = Math.cos(Math.toRadians(particleRandom * 60.0f)) * (double)this.windBig;
        this.zaFlowScale = Math.sin(Math.toRadians(particleRandom * 60.0f)) * (double)this.windBig;
        this.swirlPeriod = Math.toRadians(1000.0f + particleRandom * 3000.0f);
    }

    public class_3999 method_18122() {
        return class_3999.field_17828;
    }

    public void method_3070() {
        this.field_3858 = this.field_3874;
        this.field_3838 = this.field_3854;
        this.field_3856 = this.field_3871;
        if (this.field_3847-- <= 0) {
            this.method_3085();
        }
        if (!this.field_3843) {
            float aliveTicks = 300 - this.field_3847;
            float relativeAge = Math.min(aliveTicks / 300.0f, 1.0f);
            double xa = 0.0;
            double za = 0.0;
            if (this.flowAway) {
                xa += this.xaFlowScale * Math.pow(relativeAge, 1.25);
                za += this.zaFlowScale * Math.pow(relativeAge, 1.25);
            }
            if (this.swirl) {
                xa += (double)relativeAge * Math.cos((double)relativeAge * this.swirlPeriod) * (double)this.windBig;
                za += (double)relativeAge * Math.sin((double)relativeAge * this.swirlPeriod) * (double)this.windBig;
            }
            this.field_3852 += xa * (double)0.0025f;
            this.field_3850 += za * (double)0.0025f;
            this.field_3869 -= (double)this.field_3844;
            this.rotSpeed += this.spinAcceleration / 20.0f;
            this.field_3857 = this.field_3839;
            this.field_3839 += this.rotSpeed / 20.0f;
            this.method_3069(this.field_3852, this.field_3869, this.field_3850);
            if (this.field_3845 || this.field_3847 < 299 && (this.field_3852 == 0.0 || this.field_3850 == 0.0)) {
                this.method_3085();
            }
            if (!this.field_3843) {
                this.field_3852 *= (double)this.field_28786;
                this.field_3869 *= (double)this.field_28786;
                this.field_3850 *= (double)this.field_28786;
            }
        }
    }

    @Environment(value=EnvType.CLIENT)
    public record TintedLeavesProvider(class_4002 sprites) implements class_707<class_9381>
    {
        public class_703 createParticle(class_9381 type, class_638 level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FallingLeavesParticle particle = new FallingLeavesParticle(level, x, y, z, this.sprites, 0.07f, 10.0f, true, false, 2.0f, 0.021f);
            particle.method_3084(type.method_58259(), type.method_58263(), type.method_58264());
            return particle;
        }
    }

    @Environment(value=EnvType.CLIENT)
    public record PaleOakProvider(class_4002 sprites) implements class_707<class_2400>
    {
        public class_703 createParticle(class_2400 type, class_638 level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new FallingLeavesParticle(level, x, y, z, this.sprites, 0.07f, 10.0f, true, false, 2.0f, 0.021f);
        }
    }
}

