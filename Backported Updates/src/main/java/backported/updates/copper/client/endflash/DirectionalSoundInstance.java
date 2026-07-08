/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.sound.MovingSoundInstance
 *  net.minecraft.client.sound.SoundInstance$AttenuationType
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.sound.SoundCategory
 *  net.minecraft.client.render.Camera
 *  net.minecraft.util.math.random.Random
 */
package backported.updates.copper.client.endflash;

import net.minecraft.client.sound.MovingSoundInstance;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.util.math.Vec3d;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundCategory;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.random.Random;

public class DirectionalSoundInstance
extends MovingSoundInstance {
    private final Camera camera;
    private final float xAngle;
    private final float yAngle;

    public DirectionalSoundInstance(SoundEvent soundEvent, SoundCategory source, Random random, Camera camera, float xAngle, float yAngle) {
        super(soundEvent, source, random);
        this.camera = camera;
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.setPosition();
    }

    private void setPosition() {
        Vec3d vec3 = Vec3d.fromPolar((float)this.xAngle, (float)this.yAngle).multiply(10.0);
        this.x = this.camera.getPos().x + vec3.x;
        this.y = this.camera.getPos().y + vec3.y;
        this.z = this.camera.getPos().z + vec3.z;
        this.attenuationType = SoundInstance.AttenuationType.NONE;
    }

    public void tick() {
        this.setPosition();
    }
}

