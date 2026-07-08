/*
 * Decompiled with CFR 0.152.
 */
package org.joml.sampling;

import org.joml.Random;
import org.joml.sampling.Callback2d;

public class StratifiedSampling {
    private final Random rnd;

    public StratifiedSampling(long seed) {
        this.rnd = new Random(seed);
    }

    public void generateRandom(int n2, Callback2d callback) {
        for (int y = 0; y < n2; ++y) {
            for (int x = 0; x < n2; ++x) {
                float sampleX = (this.rnd.nextFloat() / (float)n2 + (float)x / (float)n2) * 2.0f - 1.0f;
                float sampleY = (this.rnd.nextFloat() / (float)n2 + (float)y / (float)n2) * 2.0f - 1.0f;
                callback.onNewSample(sampleX, sampleY);
            }
        }
    }

    public void generateCentered(int n2, float centering, Callback2d callback) {
        float start = centering * 0.5f;
        float end = 1.0f - centering;
        for (int y = 0; y < n2; ++y) {
            for (int x = 0; x < n2; ++x) {
                float sampleX = ((start + this.rnd.nextFloat() * end) / (float)n2 + (float)x / (float)n2) * 2.0f - 1.0f;
                float sampleY = ((start + this.rnd.nextFloat() * end) / (float)n2 + (float)y / (float)n2) * 2.0f - 1.0f;
                callback.onNewSample(sampleX, sampleY);
            }
        }
    }
}

