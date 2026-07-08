/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
 *  net.minecraft.class_5819
 */
package backported.updates.copper.client.endflash;

import net.minecraft.class_3532;
import net.minecraft.class_5819;

public class EndFlashState {
    public static final int SOUND_DELAY_IN_TICKS = 30;
    private static final int FLASH_INTERVAL_IN_TICKS = 600;
    private static final int MAX_FLASH_OFFSET_IN_TICKS = 200;
    private static final int MIN_FLASH_DURATION_IN_TICKS = 100;
    private static final int MAX_FLASH_DURATION_IN_TICKS = 380;
    private long flashSeed;
    private int offset;
    private int duration;
    private float intensity;
    private float oldIntensity;
    private float xAngle;
    private float yAngle;

    public void tick(long gametime) {
        this.calculateFlashParameters(gametime);
        this.oldIntensity = this.intensity;
        this.intensity = this.calculateIntensity(gametime);
    }

    private void calculateFlashParameters(long gametime) {
        long i = gametime / 600L;
        if (i != this.flashSeed) {
            class_5819 randomsource = class_5819.method_43049((long)i);
            randomsource.method_43057();
            this.offset = class_3532.method_32751((class_5819)randomsource, (int)0, (int)200);
            this.duration = class_3532.method_32751((class_5819)randomsource, (int)100, (int)Math.min(380, 600 - this.offset));
            this.xAngle = class_3532.method_32750((class_5819)randomsource, (float)-60.0f, (float)10.0f);
            this.yAngle = class_3532.method_32750((class_5819)randomsource, (float)-180.0f, (float)180.0f);
            this.flashSeed = i;
        }
    }

    private float calculateIntensity(long gametime) {
        long i = gametime % 600L;
        return i >= (long)this.offset && i <= (long)(this.offset + this.duration) ? class_3532.method_15374((float)((float)(i - (long)this.offset) * (float)Math.PI / (float)this.duration)) : 0.0f;
    }

    public float getXAngle() {
        return this.xAngle;
    }

    public float getYAngle() {
        return this.yAngle;
    }

    public float getIntensity(float partialTick) {
        return class_3532.method_16439((float)partialTick, (float)this.oldIntensity, (float)this.intensity);
    }

    public boolean flashStartedThisTick() {
        return this.intensity > 0.0f && this.oldIntensity <= 0.0f;
    }
}

