/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.Registries
 *  net.minecraft.component.ComponentType
 *  net.minecraft.component.ComponentType$Builder
 */
package backported.updates.content.common.registries;

import backported.updates.content.common.level.entities.animal.ChickenVariant;
import backported.updates.content.core.registries.ModRegistries;
import backported.updates.foundation.core.CoreRegistry;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.component.ComponentType;

public class ModDataComponents {
    public static final CoreRegistry<ComponentType<?>> COMPONENTS = CoreRegistry.create(Registries.DATA_COMPONENT_TYPE, "minecraft");
    public static final Supplier<ComponentType<RegistryKey<ChickenVariant>>> CHICKEN_VARIANT = ModDataComponents.register("chicken/variant", builder -> builder.codec(RegistryKey.createCodec(ModRegistries.CHICKEN_VARIANT_KEY)).packetCodec(RegistryKey.createPacketCodec(ModRegistries.CHICKEN_VARIANT_KEY)));

    public static <T> Supplier<ComponentType<T>> register(String key, UnaryOperator<ComponentType.Builder<T>> operator) {
        return COMPONENTS.register(key, () -> ((ComponentType.Builder)operator.apply(ComponentType.builder())).build());
    }
}

