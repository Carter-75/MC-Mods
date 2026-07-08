/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.resource.ResourcePackManager
 *  net.minecraft.resource.ResourcePackProvider
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Mutable
 *  org.spongepowered.asm.mixin.gen.Accessor
 */
package backported_updates.mixin.foundation.access;

import java.util.Set;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value={ResourcePackManager.class})
public interface PackRepositoryAccessor {
    @Accessor(value="providers")
    public Set<ResourcePackProvider> getProviders();

    @Mutable
    @Accessor(value="providers")
    public void setProviders(Set<ResourcePackProvider> var1);
}

