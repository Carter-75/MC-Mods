/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceType
 *  net.minecraft.resource.ResourcePackProvider
 *  net.minecraft.resource.ResourcePackProfile
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.events.fabric.ResourcePackManagerImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceType;
import net.minecraft.resource.ResourcePackProvider;
import net.minecraft.resource.ResourcePackProfile;

public class ResourcePackManager {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerPack(Consumer<Event> listener) {
        ResourcePackManagerImpl.registerPack(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerBuiltResourcePack(Identifier packId, String modId, String packName) {
        ResourcePackManagerImpl.registerBuiltResourcePack(packId, modId, packName);
    }

    public static interface Event {
        public void register(ResourceType var1, ResourcePackProvider var2);

        default public void register(ResourceType packType, Supplier<ResourcePackProfile> supplier) {
            if (supplier == null) {
                return;
            }
            this.register(packType, loader -> {
                ResourcePackProfile pack = (ResourcePackProfile)supplier.get();
                if (pack != null) {
                    loader.accept(pack);
                }
            });
        }
    }
}

