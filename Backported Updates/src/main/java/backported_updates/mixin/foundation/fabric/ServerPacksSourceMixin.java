/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyReturnValue
 *  net.minecraft.resource.ResourcePackManager
 *  net.minecraft.resource.ResourcePackProvider
 *  net.minecraft.resource.VanillaDataPackProvider
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.core.events.fabric.ResourcePackManagerImpl;
import backported_updates.mixin.foundation.access.PackRepositoryAccessor;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import java.util.HashSet;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.resource.VanillaDataPackProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={VanillaDataPackProvider.class})
public class ServerPacksSourceMixin {
    @ModifyReturnValue(method={"createManager"}, at={@At(value="RETURN")})
    private static ResourcePackManager platform$addBuiltinDataPacks(ResourcePackManager original) {
        if (original instanceof PackRepositoryAccessor) {
            PackRepositoryAccessor repository = (PackRepositoryAccessor)original;
            HashSet<ResourcePackProvider> sources = new HashSet<ResourcePackProvider>(repository.getProviders());
            sources.addAll(ResourcePackManagerImpl.PACKS);
            repository.setProviders(sources);
        }
        return original;
    }
}

