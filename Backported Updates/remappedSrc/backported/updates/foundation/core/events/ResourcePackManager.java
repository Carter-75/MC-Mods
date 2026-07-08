/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_2960
 *  net.minecraft.class_3264
 *  net.minecraft.class_3285
 *  net.minecraft.class_3288
 */
package backported.updates.foundation.core.events;

import backported.updates.foundation.core.events.fabric.ResourcePackManagerImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.class_2960;
import net.minecraft.class_3264;
import net.minecraft.class_3285;
import net.minecraft.class_3288;

public class ResourcePackManager {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerPack(Consumer<Event> listener) {
        ResourcePackManagerImpl.registerPack(listener);
    }

    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void registerBuiltResourcePack(class_2960 packId, String modId, String packName) {
        ResourcePackManagerImpl.registerBuiltResourcePack(packId, modId, packName);
    }

    public static interface Event {
        public void register(class_3264 var1, class_3285 var2);

        default public void register(class_3264 packType, Supplier<class_3288> supplier) {
            if (supplier == null) {
                return;
            }
            this.register(packType, loader -> {
                class_3288 pack = (class_3288)supplier.get();
                if (pack != null) {
                    loader.accept(pack);
                }
            });
        }
    }
}

