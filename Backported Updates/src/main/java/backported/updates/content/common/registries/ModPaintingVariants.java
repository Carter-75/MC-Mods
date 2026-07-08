/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.decoration.painting.PaintingVariant
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 */
package backported.updates.content.common.registries;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;

public class ModPaintingVariants {
    public static final RegistryKey<PaintingVariant> DENNIS = ModPaintingVariants.registryKey("dennis");

    public static void bootstrap(Registerable<PaintingVariant> context) {
        ModPaintingVariants.register(context, DENNIS, 3, 3);
    }

    private static void register(Registerable<PaintingVariant> context, RegistryKey<PaintingVariant> key, int width, int height) {
        context.register(key, new PaintingVariant(width, height, key.getValue()));
    }

    private static RegistryKey<PaintingVariant> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PAINTING_VARIANT, Identifier.ofVanilla((String)name));
    }
}

