/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.impl.registry.sync.RegistrySyncManager
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_7923
 */
package backported.updates.copper.fabric.platform;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import net.fabricmc.fabric.impl.registry.sync.RegistrySyncManager;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_7923;

public class FabricRegistryHelper
extends RegistryHelper {
    private final List<RestorableEntry<?>> minecraftEntries = new ArrayList();

    @Override
    public <T> Supplier<T> register(class_5321<? extends class_2378<? super T>> registryKey, String name, Supplier<T> supplier) {
        return this.registerWithNamespace(registryKey, "copperagebackport", name, supplier);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public <T> Supplier<T> registerWithNamespace(class_5321<? extends class_2378<? super T>> registryKey, String namespace, String name, Supplier<T> supplier) {
        Object registered;
        class_2378 registry = (class_2378)class_7923.field_41167.method_10223(registryKey.method_29177());
        if (registry == null) {
            throw new IllegalArgumentException("Unknown registry: " + String.valueOf(registryKey.method_29177()));
        }
        boolean restoreBootstrapFlag = false;
        boolean originalPostBootstrap = false;
        if ("minecraft".equals(namespace) && (originalPostBootstrap = RegistrySyncManager.postBootstrap)) {
            RegistrySyncManager.postBootstrap = false;
            restoreBootstrapFlag = true;
        }
        class_2960 id = class_2960.method_60655((String)namespace, (String)name);
        try {
            registered = class_2378.method_10230((class_2378)registry, (class_2960)id, supplier.get());
            if ("minecraft".equals(namespace)) {
                this.cacheMinecraftEntry(registryKey, id, registered);
            }
        }
        finally {
            if (restoreBootstrapFlag) {
                RegistrySyncManager.postBootstrap = originalPostBootstrap;
            }
        }
        Constants.LOG.debug("Registered {} under namespace {}", (Object)name, (Object)namespace);
        return () -> registered;
    }

    @Override
    public void fireRegistrationCallbacks() {
        super.fireRegistrationCallbacks();
    }

    private <T> void cacheMinecraftEntry(class_5321<? extends class_2378<? super T>> registryKey, class_2960 id, T value) {
        this.minecraftEntries.add(new RestorableEntry<T>(registryKey, id, value));
    }

    @Override
    public void restoreVanillaNamespaceEntries() {
        Constants.LOG.debug("Requested minecraft namespace restore for {} cached entries", (Object)this.minecraftEntries.size());
        if (this.minecraftEntries.isEmpty()) {
            return;
        }
        int restored = 0;
        for (RestorableEntry<?> entry : this.minecraftEntries) {
            restored += this.restoreEntry(entry) ? 1 : 0;
        }
        if (restored > 0) {
            Constants.LOG.info("Restored {} minecraft namespace entries", (Object)restored);
        } else {
            Constants.LOG.debug("Minecraft namespace already intact; no entries restored");
        }
    }

    private <T> boolean restoreEntry(RestorableEntry<T> entry) {
        class_2378 registry = (class_2378)class_7923.field_41167.method_10223(entry.registryKey.method_29177());
        if (registry == null) {
            return false;
        }
        Object existing = registry.method_10223(entry.id);
        if (existing != null && Objects.equals(existing, entry.value)) {
            return false;
        }
        class_2378.method_10230((class_2378)registry, (class_2960)entry.id, entry.value);
        return true;
    }

    private record RestorableEntry<T>(class_5321<? extends class_2378<? super T>> registryKey, class_2960 id, T value) {
    }
}

