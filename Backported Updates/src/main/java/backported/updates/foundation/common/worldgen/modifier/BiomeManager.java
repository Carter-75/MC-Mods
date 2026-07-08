/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 */
package backported.updates.foundation.common.worldgen.modifier;

import backported.updates.foundation.common.worldgen.modifier.BiomeContext;
import backported.updates.foundation.common.worldgen.modifier.BiomeWriter;
import backported.updates.foundation.common.worldgen.modifier.fabric.BiomeManagerImpl;
import com.google.common.collect.Lists;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.List;
import java.util.function.BiConsumer;

public class BiomeManager {
    private static final List<BiConsumer<BiomeWriter, BiomeContext>> MODIFICATIONS = Lists.newArrayList();
    public static final BiomeManager INSTANCE = new BiomeManager();

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void bootstrap() {
        BiomeManagerImpl.bootstrap();
    }

    public void register(BiomeWriter writer) {
        MODIFICATIONS.forEach(writer::add);
    }

    public static void add(BiConsumer<BiomeWriter, BiomeContext> modifier) {
        MODIFICATIONS.add(modifier);
    }
}

