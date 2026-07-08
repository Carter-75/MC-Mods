/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  dev.architectury.injectables.annotations.ExpectPlatform
 *  dev.architectury.injectables.annotations.ExpectPlatform$Transformed
 *  net.minecraft.entity.data.TrackedDataHandler
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.foundation.core.helper;

import backported.updates.foundation.core.helper.fabric.DataSerializerRegistryImpl;
import dev.architectury.injectables.annotations.ExpectPlatform;
import java.util.function.Supplier;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public abstract class DataSerializerRegistry {
    @ExpectPlatform
    @ExpectPlatform.Transformed
    public static DataSerializerRegistry create(String modId) {
        return DataSerializerRegistryImpl.create(modId);
    }

    public <T> Supplier<TrackedDataHandler<T>> register(String name, PacketCodec<? super RegistryByteBuf, T> codec) {
        return this.register(name, () -> TrackedDataHandler.create((PacketCodec)codec));
    }

    public abstract <T> Supplier<TrackedDataHandler<T>> register(String var1, Supplier<TrackedDataHandler<T>> var2);

    public abstract void register();
}

