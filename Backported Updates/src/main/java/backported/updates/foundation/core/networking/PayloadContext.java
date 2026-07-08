/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.PlayerEntity
 */
package backported.updates.foundation.core.networking;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.minecraft.entity.player.PlayerEntity;

public interface PayloadContext {
    public PlayerEntity player();

    public CompletableFuture<Void> enqueueWork(Runnable var1);

    public <T> CompletableFuture<T> enqueueWork(Supplier<T> var1);
}

