/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.impl.registry.sync.RegistrySyncManager
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.Registries
 */
package backported.updates.copper.fabric.platform;

import backported.updates.copper.Constants;
import backported.updates.copper.registry.RegistryHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import net.fabricmc.fabric.impl.registry.sync.RegistrySyncManager;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;

public class FabricRegistryHelper
extends RegistryHelper {
    private final List<RestorableEntry<?>> minecraftEntries = new ArrayList<>();

    @Override
    public <T> Supplier<T> register(RegistryKey<? extends Registry<? super T>> registryKey, String name, Supplier<T> supplier) {
        return this.registerWithNamespace(registryKey, "copperagebackport", name, supplier);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public <T> Supplier<T> registerWithNamespace(RegistryKey<? extends Registry<? super T>> registryKey, String namespace, String name, Supplier<T> supplier) {
        T registered;
        Registry<T> registry = (Registry<T>)Registries.REGISTRIES.get(registryKey.getValue());
        if (registry == null) {
            throw new IllegalArgumentException("Unknown registry: " + String.valueOf(registryKey.getValue()));
        }
        boolean restoreBootstrapFlag = false;
        boolean originalPostBootstrap = false;
        if ("minecraft".equals(namespace) && (originalPostBootstrap = RegistrySyncManager.postBootstrap)) {
            RegistrySyncManager.postBootstrap = false;
            restoreBootstrapFlag = true;
        }
        Identifier id = Identifier.of((String)namespace, (String)name);
        try {
            registered = Registry.register(registry, id, supplier.get());
            if ("minecraft".equals(namespace)) {
                this.cacheMinecraftEntry(registryKey, id, registered);
            }
        }
        finally {
            if (restoreBootstrapFlag) {
                RegistrySyncManager.postBootstrap = originalPostBootstrap;
            }
        }
        Constants.LOG.debug("Registered {} under namespace {}", name, namespace);
        return () -> registered;
    }

    @Override
    public void fireRegistrationCallbacks() {
        super.fireRegistrationCallbacks();
    }

    private <T> void cacheMinecraftEntry(RegistryKey<? extends Registry<? super T>> registryKey, Identifier id, T value) {
        this.minecraftEntries.add(new RestorableEntry<T>(registryKey, id, value));
    }

    @Override
    public void restoreVanillaNamespaceEntries() {
        Constants.LOG.debug("Requested minecraft namespace restore for {} cached entries", this.minecraftEntries.size());
        if (this.minecraftEntries.isEmpty()) {
            return;
        }
        int restored = 0;
        for (RestorableEntry<?> entry : this.minecraftEntries) {
            restored += this.restoreEntry(entry) ? 1 : 0;
        }
        if (restored > 0) {
            Constants.LOG.info("Restored {} minecraft namespace entries", restored);
        } else {
            Constants.LOG.debug("Minecraft namespace already intact; no entries restored");
        }
    }

    private <T> boolean restoreEntry(RestorableEntry<T> entry) {
        Registry<T> registry = (Registry<T>)Registries.REGISTRIES.get(entry.registryKey.getValue());
        if (registry == null) {
            return false;
        }
        T existing = registry.get(entry.id);
        if (existing != null && Objects.equals(existing, entry.value)) {
            return false;
        }
        Registry.register(registry, entry.id, entry.value);
        return true;
    }

    private record RestorableEntry<T>(RegistryKey<? extends Registry<? super T>> registryKey, Identifier id, T value) {
    }
}

