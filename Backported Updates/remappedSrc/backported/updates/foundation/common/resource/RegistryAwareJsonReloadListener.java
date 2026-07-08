/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_3695
 *  net.minecraft.class_4309
 *  net.minecraft.class_5455
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.common.resource;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_3695;
import net.minecraft.class_4309;
import net.minecraft.class_5455;
import org.jetbrains.annotations.Nullable;

public abstract class RegistryAwareJsonReloadListener
extends class_4309 {
    private static final List<RegistryAwareJsonReloadListener> INSTANCES = Collections.synchronizedList(new ArrayList());
    @Nullable
    private Map<class_2960, JsonElement> resources;
    @Nullable
    private class_3300 manager;
    @Nullable
    private class_3695 profiler;

    public RegistryAwareJsonReloadListener(Gson gson, String directory) {
        super(gson, directory);
        INSTANCES.add(this);
    }

    protected void apply(Map<class_2960, JsonElement> resources, class_3300 manager, class_3695 profiler) {
        this.resources = resources;
        this.manager = manager;
        this.profiler = profiler;
    }

    public abstract void parse(Map<class_2960, JsonElement> var1, class_5455 var2, class_3300 var3, class_3695 var4);

    public static void runReloads(class_5455 access) {
        for (RegistryAwareJsonReloadListener listener : INSTANCES) {
            if (listener.resources == null || listener.manager == null || listener.profiler == null) continue;
            listener.parse(listener.resources, access, listener.manager, listener.profiler);
            listener.resources = null;
            listener.manager = null;
            listener.profiler = null;
        }
    }
}

