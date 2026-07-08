/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.particle.SimpleParticleType
 *  net.minecraft.client.particle.ParticleTextureSheet
 *  net.minecraft.client.particle.SpriteProvider
 *  net.minecraft.client.particle.SpriteBillboardParticle
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleFactory
 *  net.minecraft.particle.EntityEffectParticleEffect
 */
package backported.updates.content.client.level.particles;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.particle.EntityEffectParticleEffect;

@Environment(value=EnvType.CLIENT)
public class FallingLeavesParticle
extends SpriteBillboardParticle {
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

    protected FallingLeavesParticle(ClientWorld level, double x, double y, double z, SpriteProvider sprites, float fallAcceleration, float windBig, boolean swirl, boolean flowAway, float scale, float startVelocity) {
        super(level, x, y, z);
        float size;
        this.rotSpeed = (float)Math.toRadians(this.random.nextBoolean() ? -30.0 : 30.0);
        this.spinAcceleration = (float)Math.toRadians(this.random.nextBoolean() ? -5.0 : 5.0);
        this.setSprite(sprites.getSprite(this.random.nextInt(12), 12));
        this.windBig = windBig;
        this.swirl = swirl;
        this.flowAway = flowAway;
        this.maxAge = 300;
        this.gravityStrength = fallAcceleration * 1.2f * 0.0025f;
        this.scale = size = scale * (this.random.nextBoolean() ? 0.05f : 0.075f);
        this.setBoundingBoxSpacing(size, size);
        this.velocityMultiplier = 1.0f;
        this.velocityY = -startVelocity;
        float particleRandom = this.random.nextFloat();
        this.xaFlowScale = Math.cos(Math.toRadians(particleRandom * 60.0f)) * (double)this.windBig;
        this.zaFlowScale = Math.sin(Math.toRadians(particleRandom * 60.0f)) * (double)this.windBig;
        this.swirlPeriod = Math.toRadians(1000.0f + particleRandom * 3000.0f);
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        }
        if (!this.dead) {
            float aliveTicks = 300 - this.maxAge;
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
            this.velocityX += xa * (double)0.0025f;
            this.velocityZ += za * (double)0.0025f;
            this.velocityY -= (double)this.gravityStrength;
            this.rotSpeed += this.spinAcceleration / 20.0f;
            this.prevAngle = this.angle;
            this.angle += this.rotSpeed / 20.0f;
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            if (this.onGround || this.maxAge < 299 && (this.velocityX == 0.0 || this.velocityZ == 0.0)) {
                this.markDead();
            }
            if (!this.dead) {
                this.velocityX *= (double)this.velocityMultiplier;
                this.velocityY *= (double)this.velocityMultiplier;
                this.velocityZ *= (double)this.velocityMultiplier;
            }
        }
    }

    @Environment(value=EnvType.CLIENT)
    public record TintedLeavesProvider(SpriteProvider sprites) implements ParticleFactory<EntityEffectParticleEffect>
    {
        public Particle createParticle(EntityEffectParticleEffect type, ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            FallingLeavesParticle particle = new FallingLeavesParticle(level, x, y, z, this.sprites, 0.07f, 10.0f, true, false, 2.0f, 0.021f);
            particle.setColor(type.getRed(), type.getGreen(), type.getBlue());
            return particle;
        }
    }

    @Environment(value=EnvType.CLIENT)
    public record PaleOakProvider(SpriteProvider sprites) implements ParticleFactory<SimpleParticleType>
    {
        public Particle createParticle(SimpleParticleType type, ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new FallingLeavesParticle(level, x, y, z, this.sprites, 0.07f, 10.0f, true, false, 2.0f, 0.021f);
        }
    }
}

