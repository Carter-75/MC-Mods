/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  net.minecraft.util.Identifier
 *  net.minecraft.resource.ResourceManager
 *  net.minecraft.util.profiler.Profiler
 *  net.minecraft.resource.JsonDataLoader
 *  net.minecraft.registry.DynamicRegistryManager
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.common.resource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.util.Identifier;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.registry.DynamicRegistryManager;
import org.jetbrains.annotations.Nullable;

public abstract class RegistryAwareJsonReloadListener
extends JsonDataLoader {
    private static final List<RegistryAwareJsonReloadListener> INSTANCES = Collections.synchronizedList(new ArrayList());
    @Nullable
    private Map<Identifier, JsonElement> resources;
    @Nullable
    private ResourceManager manager;
    @Nullable
    private Profiler profiler;

    public RegistryAwareJsonReloadListener(Gson gson, String directory) {
        super(gson, directory);
        INSTANCES.add(this);
    }

    protected void apply(Map<Identifier, JsonElement> resources, ResourceManager manager, Profiler profiler) {
        this.resources = resources;
        this.manager = manager;
        this.profiler = profiler;
    }

    public abstract void parse(Map<Identifier, JsonElement> var1, DynamicRegistryManager var2, ResourceManager var3, Profiler var4);

    public static void runReloads(DynamicRegistryManager access) {
        for (RegistryAwareJsonReloadListener listener : INSTANCES) {
            if (listener.resources == null || listener.manager == null || listener.profiler == null) continue;
            listener.parse(listener.resources, access, listener.manager, listener.profiler);
            listener.resources = null;
            listener.manager = null;
            listener.profiler = null;
        }
    }
}

