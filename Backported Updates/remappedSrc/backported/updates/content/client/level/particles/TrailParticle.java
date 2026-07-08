/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3999
 *  net.minecraft.class_4002
 *  net.minecraft.class_4003
 *  net.minecraft.class_5253$class_5254
 *  net.minecraft.class_638
 *  net.minecraft.class_703
 *  net.minecraft.class_707
 */
package backported.updates.content.client.level.particles;

import backported.updates.content.client.level.particles.particleoptions.TrailParticleOption;
import backported.updates.content.core.util.ColorUtils;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3999;
import net.minecraft.class_4002;
import net.minecraft.class_4003;
import net.minecraft.class_5253;
import net.minecraft.class_638;
import net.minecraft.class_703;
import net.minecraft.class_707;

@Environment(value=EnvType.CLIENT)
public class TrailParticle
extends class_4003 {
    private final class_243 target;

    protected TrailParticle(class_638 level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, class_243 target, int color) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        color = ColorUtils.scaleRGB(color, 0.875f + this.field_3840.method_43057() * 0.25f, 0.875f + this.field_3840.method_43057() * 0.25f, 0.875f + this.field_3840.method_43057() * 0.25f);
        this.field_3861 = (float)class_5253.class_5254.method_27765((int)color) / 255.0f;
        this.field_3842 = (float)class_5253.class_5254.method_27766((int)color) / 255.0f;
        this.field_3859 = (float)class_5253.class_5254.method_27767((int)color) / 255.0f;
        this.field_17867 = 0.26f;
        this.target = target;
    }

    public class_3999 method_18122() {
        return class_3999.field_17828;
    }

    public void method_3070() {
        this.field_3858 = this.field_3874;
        this.field_3838 = this.field_3854;
        this.field_3856 = this.field_3871;
        if (this.field_3866++ >= this.field_3847) {
            this.method_3085();
        } else {
            int ageInTicks = this.field_3847 - this.field_3866;
            double deltaTime = 1.0 / (double)ageInTicks;
            this.field_3874 = class_3532.method_16436((double)deltaTime, (double)this.field_3874, (double)this.target.method_10216());
            this.field_3854 = class_3532.method_16436((double)deltaTime, (double)this.field_3854, (double)this.target.method_10214());
            this.field_3871 = class_3532.method_16436((double)deltaTime, (double)this.field_3871, (double)this.target.method_10215());
        }
    }

    protected int method_3068(float partialTick) {
        return 0xF000F0;
    }

    @Environment(value=EnvType.CLIENT)
    public record Provider(class_4002 sprites) implements class_707<TrailParticleOption>
    {
        public class_703 createParticle(TrailParticleOption option, class_638 level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            TrailParticle particle = new TrailParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, option.target(), option.color());
            particle.method_18140(this.sprites);
            particle.method_3077(option.duration());
            return particle;
        }
    }
}

