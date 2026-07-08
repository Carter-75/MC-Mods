/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_777
 */
package backported.updates.content.client.util;

import net.minecraft.class_777;

public class EmissiveQuad
extends class_777 {
    private static final int FULL_BRIGHTNESS = 0xF000F0;

    public EmissiveQuad(class_777 original) {
        super(EmissiveQuad.makeEmissive((int[])original.method_3357().clone()), original.method_3359(), original.method_3358(), original.method_35788(), original.method_24874());
    }

    private static int[] makeEmissive(int[] vertexData) {
        int vertexSize = 8;
        int lightsOffset = 6;
        for (int i = 0; i < vertexData.length; i += vertexSize) {
            vertexData[i + lightsOffset] = 0xF000F0;
        }
        return vertexData;
    }
}

