/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.client.particle.ParticleTextureSheet
 *  net.minecraft.client.particle.SpriteProvider
 *  net.minecraft.client.particle.SpriteBillboardParticle
 *  net.minecraft.util.math.ColorHelper$Argb
 *  net.minecraft.client.world.ClientWorld
 *  net.minecraft.client.particle.Particle
 *  net.minecraft.client.particle.ParticleFactory
 */
package backported.updates.content.client.level.particles;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.content.core.util.ColorUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.particle.SpriteBillboardParticle;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;

@Environment(value=EnvType.CLIENT)
public class TrailParticle
extends SpriteBillboardParticle {
    private final Vec3d target;

    protected TrailParticle(ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, Vec3d target, int color) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        color = ColorUtils.scaleRGB(color, 0.875f + this.random.nextFloat() * 0.25f, 0.875f + this.random.nextFloat() * 0.25f, 0.875f + this.random.nextFloat() * 0.25f);
        this.red = (float)ColorHelper.Argb.getRed((int)color) / 255.0f;
        this.green = (float)ColorHelper.Argb.getGreen((int)color) / 255.0f;
        this.blue = (float)ColorHelper.Argb.getBlue((int)color) / 255.0f;
        this.scale = 0.26f;
        this.target = target;
    }

    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.age++ >= this.maxAge) {
            this.markDead();
        } else {
            int ageInTicks = this.maxAge - this.age;
            double deltaTime = 1.0 / (double)ageInTicks;
            this.x = MathHelper.lerp((double)deltaTime, (double)this.x, (double)this.target.getX());
            this.y = MathHelper.lerp((double)deltaTime, (double)this.y, (double)this.target.getY());
            this.z = MathHelper.lerp((double)deltaTime, (double)this.z, (double)this.target.getZ());
        }
    }

    protected int getBrightness(float partialTick) {
        return 0xF000F0;
    }

    @Environment(value=EnvType.CLIENT)
    public record Provider(SpriteProvider sprites) implements ParticleFactory<TrailParticleOption>
    {
        public Particle createParticle(TrailParticleOption option, ClientWorld level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TrailParticle particle = new TrailParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, option.target(), option.color());
            particle.setSprite(this.sprites);
            particle.setMaxAge(option.duration());
            return particle;
        }
    }
}

