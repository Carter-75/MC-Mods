/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.content.common.worldgen;

import backported.updates.content.common.worldgen.generation.SpringToLifeFeatureManager;
import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import backported.updates.foundation.common.worldgen.modifier.BiomeWriter;

public class WorldGeneration {
    public static void bootstrap(BiomeWriter writer, BiomeContext context) {
        new SpringToLifeFeatureManager(context, writer).bootstrap();
    }
}

