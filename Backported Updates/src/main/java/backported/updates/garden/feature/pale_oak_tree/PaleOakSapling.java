/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Identifier
 *  net.minecraft.world.gen.feature.ConfiguredFeature
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.block.SaplingGenerator
 */
package backported.updates.garden.feature.pale_oak_tree;

import java.util.Optional;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.block.SaplingGenerator;

public class PaleOakSapling {
    public static final SaplingGenerator PALE;
    public static final RegistryKey<ConfiguredFeature<?, ?>> PALE_REGISTRY;

    static {
        PALE_REGISTRY = RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of((String)"iwie", (String)"pale_tree"));
        PALE = new SaplingGenerator("pale_tree", Optional.of(PALE_REGISTRY), Optional.empty(), Optional.empty());
    }
}

