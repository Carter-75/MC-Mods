/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.minecraft.resource.ResourcePackManager
 *  net.minecraft.resource.ResourcePackProvider
 *  net.minecraft.client.gui.screen.world.CreateWorldScreen
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.core.events.fabric.ResourcePackManagerImpl;
import backported_updates.mixin.foundation.access.PackRepositoryAccessor;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import java.util.HashSet;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={CreateWorldScreen.class})
public class CreateWorldScreenMixin {
    @ModifyExpressionValue(method={"create"}, at={@At(value="NEW", target="net/minecraft/resource/ResourcePackManager")})
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

