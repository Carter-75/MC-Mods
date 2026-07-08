/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bawnorton.mixinsquared.TargetHandler
 *  com.llamalad7.mixinextras.injector.wrapoperation.Operation
 *  com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation
 *  net.minecraft.class_2370
 *  net.minecraft.class_5321
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 */
package backported_updates.mixin.foundation.fabric;

import backported.updates.foundation.core.fabric.CoreRegistryImpl;
import com.bawnorton.mixinsquared.TargetHandler;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import java.util.Set;
import net.minecraft.class_2370;
import net.minecraft.class_5321;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value={class_2370.class}, priority=1500)
public abstract class MappedRegistryMixin<T> {
    @TargetHandler(mixin="net.fabricmc.fabric.mixin.registry.sync.SimpleRegistryMixin", name="onChange")
    @WrapOperation(method={"@MixinSquared:Handler"}, at={@At(value="INVOKE", target="Ljava/util/Set;contains(Ljava/lang/Object;)Z", remap=false)})
    private boolean shouldSkipVanillaRegistry(Set<String> vanillaNamespaces, Object namespace, Operation<Boolean> original, class_5321<T> registryKey) {
        boolean isVanillaNamespace = (Boolean)original.call(new Object[]{vanillaNamespaces, namespace});
        if (isVanillaNamespace && CoreRegistryImpl.REGISTERED_KEYS.contains(registryKey)) {
            return false;
        }
        return isVanillaNamespace;
    }
}

