/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.class_8710
 *  net.minecraft.class_8710$class_9154
 *  net.minecraft.class_9129
 *  net.minecraft.class_9139
 */
package backported.updates.foundation.core.networking;

import backported.updates.foundation.core.networking.PayloadContext;
import backported.updates.foundation.core.networking.fabric.NetworkingImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.class_8710;
import net.minecraft.class_9129;
import net.minecraft.class_9139;

public class Networking {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static void register(Consumer<Registrar> listener) {
        NetworkingImpl.register(listener);
    }

    public static interface Registrar {
        public <T extends class_8710> void registerToServer(class_8710.class_9154<T> var1, class_9139<? super class_9129, T> var2, BiConsumer<T, PayloadContext> var3);

        public <T extends class_8710> void registerToClient(class_8710.class_9154<T> var1, class_9139<? super class_9129, T> var2, BiConsumer<T, PayloadContext> var3);

        default public <T extends class_8710> void registerBidirectional(class_8710.class_9154<T> type, class_9139<? super class_9129, T> codec, BiConsumer<T, PayloadContext> handler) {
            this.registerToServer(type, codec, handler);
            this.registerToClient(type, codec, handler);
        }
    }
}

