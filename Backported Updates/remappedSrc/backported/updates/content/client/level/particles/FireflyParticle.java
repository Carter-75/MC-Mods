/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_2338
 *  net.minecraft.class_2400
 *  net.minecraft.class_3532
 *  net.minecraft.class_3999
 *  net.minecraft.class_4002
 *  net.minecraft.class_4003
 *  net.minecraft.class_638
 *  net.minecraft.class_703
 *  net.minecraft.class_707
 */
package backported.updates.content.client.level.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_2338;
import net.minecraft.class_2400;
import net.minecraft.class_3532;
import net.minecraft.class_3999;
import net.minecraft.class_4002;
import net.minecraft.class_4003;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;

@Environment(value=EnvType.CLIENT)
public class FireflyParticle
extends class_4003 {
    private static final float PARTICLE_FADE_OUT_LIGHT_TIME = 0.3f;
    private static final float PARTICLE_FADE_IN_LIGHT_TIME = 0.1f;
    private static final float PARTICLE_FADE_OUT_ALPHA_TIME = 0.5f;
    private static final float PARTICLE_FADE_IN_ALPHA_TIME = 0.3f;
    private static final int PARTICLE_MIN_LIFETIME = 200;
    private static final int PARTICLE_MAX_LIFETIME = 300;

    protected FireflyParticle(class_638 level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.field_28787 = true;
        this.field_28786 = 0.96f;
        this.field_17867 *= 0.75f;
        this.field_3869 *= (double)0.8f;
        this.field_3852 *= (double)0.8f;
        this.field_3850 *= (double)0.8f;
    }

    public class_3999 method_18122() {
        return class_3999.field_17829;
    }

    protected int method_3068(float partialTick) {
        return (int)(255.0f * this.getFadeAmount(this.getLifetimeProgress((float)this.field_3866 + partialTick), 0.1f, 0.3f));
    }

    public void method_3070() {
        super.method_3070();
        if (!this.field_3851.method_8320(class_2338.method_49637((double)this.field_3874, (double)this.field_3854, (double)this.field_3871)).method_26215()) {
            this.method_3085();
        } else {
            this.method_3083(this.getFadeAmount(this.getLifetimeProgress(this.field_3866), 0.3f, 0.5f));
            if (Math.random() > 0.95 || this.field_3866 == 1) {
                this.method_34753(-0.05 + (double)0.1f * Math.random(), -0.05 + (double)0.1f * Math.random(), -0.05 + (double)0.1f * Math.random());
            }
        }
    }

    private float getLifetimeProgress(float age) {
        return class_3532.method_15363((float)(age / (float)this.field_3847), (float)0.0f, (float)1.0f);
    }

    private float getFadeAmount(float lifetime, float fadeIn, float fadeOut) {
        if (lifetime >= 1.0f - fadeIn) {
            return (1.0f - lifetime) / fadeIn;
        }
        return lifetime <= fadeOut ? lifetime / fadeOut : 1.0f;
    }

    @Environment(value=EnvType.CLIENT)
    public record Provider(class_4002 sprite) implements class_707<class_2400>
    {
        public class_703 createParticle(class_2400 type, class_638 level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FireflyParticle particle = new FireflyParticle(level, x, y, z, 0.5 - level.field_9229.method_43058(), level.field_9229.method_43056() ? ySpeed : -ySpeed, 0.5 - level.field_9229.method_43058());
            particle.method_3077(level.field_9229.method_39332(200, 300));
            particle.method_3087(1.5f);
            particle.method_18140(this.sprite);
            particle.method_3083(0.0f);
            return particle;
        }
    }
}

