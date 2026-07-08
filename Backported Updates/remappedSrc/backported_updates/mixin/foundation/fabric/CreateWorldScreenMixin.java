/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.llamalad7.mixinextras.injector.ModifyExpressionValue
 *  net.minecraft.class_3283
 *  net.minecraft.class_3285
 *  net.minecraft.class_525
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.core.events.fabric.ResourcePackManagerImpl;
import backported_updates.mixin.foundation.access.PackRepositoryAccessor;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import java.util.HashSet;
import net.minecraft.class_3283;
import net.minecraft.class_3285;
import net.minecraft.class_525;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={class_525.class})
public class CreateWorldScreenMixin {
    @ModifyExpressionValue(method={"openFresh"}, at={@At(value="NEW", target="([Lnet/minecraft/server/packs/repository/RepositorySource;)Lnet/minecraft/server/packs/repository/PackRepository;")})
    private static class_3283 platform$addBuiltinDataPacks(class_3283 original) {
        if (original instanceof PackRepositoryAccessor) {
            PackRepositoryAccessor repository = (PackRepositoryAccessor)original;
            HashSet<class_3285> sources = new HashSet<class_3285>(repository.getSources());
            sources.addAll(ResourcePackManagerImpl.PACKS);
            repository.setSources(sources);
        }
        return original;
    }
}

