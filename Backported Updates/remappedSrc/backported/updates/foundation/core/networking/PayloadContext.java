/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 */
package backported.updates.foundation.core.networking;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import net.minecraft.class_1657;

public interface PayloadContext {
    public class_1657 player();

    public CompletableFuture<Void> enqueueWork(Runnable var1);

    public <T> CompletableFuture<T> enqueueWork(Supplier<T> var1);
}

