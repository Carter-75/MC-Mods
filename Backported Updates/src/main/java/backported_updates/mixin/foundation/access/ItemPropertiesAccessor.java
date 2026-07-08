/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.item.ModelPredicateProvider
 *  net.minecraft.util.Identifier
 *  net.minecraft.client.item.ModelPredicateProviderRegistry
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.access;

import java.util.Map;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.util.Identifier;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ModelPredicateProviderRegistry.class})
public interface ItemPropertiesAccessor {
    @Accessor
    public static Map<Identifier, ModelPredicateProvider> getGLOBAL() {
        throw new UnsupportedOperationException();
    }
}

