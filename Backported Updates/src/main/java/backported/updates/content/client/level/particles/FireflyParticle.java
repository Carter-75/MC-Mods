/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.particle.SimpleParticleType
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.particle.ParticleTextureSheet
 *  net.minecraft.client.particle.SpriteProvider
 *  net.minecraft.client.particle.SpriteBillboardParticle
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleFactory
 */
package backported.updates.content.client.level.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;

@Environment(value=EnvType.CLIENT)
public class FireflyParticle
extends SpriteBillboardParticle {
    private static final float PARTICLE_FADE_OUT_LIGHT_TIME = 0.3f;
    private static final float PARTICLE_FADE_IN_LIGHT_TIME = 0.1f;
    private static final float PARTICLE_FADE_OUT_ALPHA_TIME = 0.5f;
    private static final float PARTICLE_FADE_IN_ALPHA_TIME = 0.3f;
    private static final int PARTICLE_MIN_LIFETIME = 200;
    private static final int PARTICLE_MAX_LIFETIME = 300;

    protected FireflyParticle(ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.ascending = true;
        this.velocityMultiplier = 0.96f;
        this.scale *= 0.75f;
        this.velocityY *= (double)0.8f;
        this.velocityX *= (double)0.8f;
        this.velocityZ *= (double)0.8f;
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    protected int getBrightness(float partialTick) {
        return (int)(255.0f * this.getFadeAmount(this.getLifetimeProgress((float)this.age + partialTick), 0.1f, 0.3f));
    }

    public void tick() {
        super.tick();
        if (!this.world.getBlockState(BlockPos.ofFloored((double)this.x, (double)this.y, (double)this.z)).isAir()) {
            this.markDead();
        } else {
            this.setAlpha(this.getFadeAmount(this.getLifetimeProgress(this.age), 0.3f, 0.5f));
            if (Math.random() > 0.95 || this.age == 1) {
                this.setVelocity(-0.05 + (double)0.1f * Math.random(), -0.05 + (double)0.1f * Math.random(), -0.05 + (double)0.1f * Math.random());
            }
        }
    }

    private float getLifetimeProgress(float age) {
        return MathHelper.clamp((float)(age / (float)this.maxAge), (float)0.0f, (float)1.0f);
    }

    private float getFadeAmount(float lifetime, float fadeIn, float fadeOut) {
        if (lifetime >= 1.0f - fadeIn) {
            return (1.0f - lifetime) / fadeIn;
        }
        return lifetime <= fadeOut ? lifetime / fadeOut : 1.0f;
    }

    @Environment(value=EnvType.CLIENT)
    public record Provider(SpriteProvider sprite) implements ParticleFactory<SimpleParticleType>
    {
        public Particle createParticle(SimpleParticleType type, ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FireflyParticle particle = new FireflyParticle(level, x, y, z, 0.5 - level.random.nextDouble(), level.random.nextBoolean() ? ySpeed : -ySpeed, 0.5 - level.random.nextDouble());
            particle.setMaxAge(level.random.nextBetween(200, 300));
            particle.scale(1.5f);
            particle.setSprite(this.sprite);
            particle.setAlpha(0.0f);
            return particle;
        }
    }
}

