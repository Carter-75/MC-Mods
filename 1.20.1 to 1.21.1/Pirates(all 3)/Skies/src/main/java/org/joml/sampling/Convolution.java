/*
 * Decompiled with CFR 0.152.
 */
package org.joml.sampling;

import java.nio.FloatBuffer;
import org.joml.Math;

public class Convolution {
    public static void gaussianKernel(int rows, int cols, float sigma, FloatBuffer dest) {
        if ((rows & 1) == 0) {
            throw new IllegalArgumentException("rows must be an odd number");
        }
        if ((cols & 1) == 0) {
            throw new IllegalArgumentException("cols must be an odd number");
        }
        if (dest == null) {
            throw new IllegalArgumentException("dest must not be null");
        }
        if (dest.remaining() < rows * cols) {
            throw new IllegalArgumentException("dest must have at least " + rows * cols + " remaining values");
        }
        float sum = 0.0f;
        int pos = dest.position();
        int i2 = 0;
        for (int y = -(rows - 1) / 2; y <= (rows - 1) / 2; ++y) {
            int x = -(cols - 1) / 2;
            while (x <= (cols - 1) / 2) {
                float k2 = (float)Math.exp((double)(-(y * y + x * x)) / (2.0 * (double)sigma * (double)sigma));
                dest.put(pos + i2, k2);
                sum += k2;
                ++x;
                ++i2;
            }
        }
        for (i2 = 0; i2 < rows * cols; ++i2) {
            dest.put(pos + i2, dest.get(pos + i2) / sum);
        }
    }

    public static void gaussianKernel(int rows, int cols, float sigma, float[] dest) {
        if ((rows & 1) == 0) {
            throw new IllegalArgumentException("rows must be an odd number");
        }
        if ((cols & 1) == 0) {
            throw new IllegalArgumentException("cols must be an odd number");
        }
        if (dest == null) {
            throw new IllegalArgumentException("dest must not be null");
        }
        if (dest.length < rows * cols) {
            throw new IllegalArgumentException("dest must have a size of at least " + rows * cols);
        }
        float sum = 0.0f;
        int i2 = 0;
        for (int y = -(rows - 1) / 2; y <= (rows - 1) / 2; ++y) {
            int x = -(cols - 1) / 2;
            while (x <= (cols - 1) / 2) {
                float k2;
                dest[i2] = k2 = (float)Math.exp((double)(-(y * y + x * x)) / (2.0 * (double)sigma * (double)sigma));
                sum += k2;
                ++x;
                ++i2;
            }
        }
        for (i2 = 0; i2 < rows * cols; ++i2) {
            dest[i2] = dest[i2] / sum;
        }
    }
}

