/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.render.model.BakedQuad
 */
package backported.updates.content.client.util;

import net.minecraft.client.render.model.BakedQuad;

public class EmissiveQuad
extends BakedQuad {
    private static final int FULL_BRIGHTNESS = 0xF000F0;

    public EmissiveQuad(BakedQuad original) {
        super(EmissiveQuad.makeEmissive((int[])original.getVertexData().clone()), original.getColorIndex(), original.getFace(), original.getSprite(), original.hasShade());
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

