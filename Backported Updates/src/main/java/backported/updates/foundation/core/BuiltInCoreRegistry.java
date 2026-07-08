/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.registry.Registry
 *  net.minecraft.util.Identifier
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.util.math.random.Random
 *  net.minecraft.registry.tag.TagKey
 *  net.minecraft.registry.entry.RegistryEntry
 */
package backported.updates.foundation.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.registry.entry.RegistryEntry;

public class BuiltInCoreRegistry<T> {
    private final Map<Identifier, T> hardcodedEntries = new HashMap<Identifier, T>();
    private final Map<Identifier, T> dataDrivenEntries = new HashMap<Identifier, T>();
    private final String modId;
    private final Registry<T> registry;
    protected boolean isPresent = false;

    public BuiltInCoreRegistry(Registry<T> registry, String modId) {
        this.modId = modId;
        this.registry = registry;
        this.registry.getIds().forEach(id -> this.hardcodedEntries.putIfAbsent(id, (T)this.registry.get(id)));
    }

    public T register(Identifier name, T entry) {
        return this.hardcodedEntries.put(name, entry);
    }

    public T register(String name, T entry) {
        Identifier location = Identifier.of((String)this.modId, (String)name);
        return this.hardcodedEntries.put(location, entry);
    }

    public T registerDataDriven(Identifier name, T entry) {
        return this.dataDrivenEntries.put(name, entry);
    }

    public <E extends T> RegistryKey<T> resource(String name, E entry) {
        this.register(name, entry);
        return RegistryKey.of(this.registry.getKey(), Identifier.of((String)this.modId, (String)name));
    }

    public T getOrDefault(Identifier name, T fallback) {
        if (this.registry.containsId(name)) {
            return (T)this.registry.get(name);
        }
        if (this.dataDrivenEntries.containsKey(name)) {
            return this.dataDrivenEntries.get(name);
        }
        if (this.hardcodedEntries.containsKey(name)) {
            return this.hardcodedEntries.get(name);
        }
        return fallback;
    }

    public T get(Identifier name) {
        if (this.dataDrivenEntries.containsKey(name)) {
            return this.dataDrivenEntries.get(name);
        }
        return this.hardcodedEntries.get(name);
    }

    public T get(RegistryKey<T> name) {
        return this.getOrDefault(name.getValue(), null);
    }

    public T getOrThrow(RegistryKey<T> key) {
        T value = this.get(key);
        if (value == null) {
            RegistryKey resource = this.registry.getKey();
            throw new IllegalStateException("Missing key in " + String.valueOf(resource) + ":" + String.valueOf(key));
        }
        return value;
    }

    public Identifier getKey(T value) {
        Optional<Identifier> dataDrivenKey = this.dataDrivenEntries.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).findFirst().map(Map.Entry::getKey);
        return dataDrivenKey.orElseGet(() -> this.hardcodedEntries.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).findFirst().orElseThrow(() -> new IllegalArgumentException("Value not found in registry: " + String.valueOf(value))).getKey());
    }

    public Optional<List<T>> fromTag(TagKey<T> tag) {
        @SuppressWarnings("unchecked") List<T> values = (List<T>)(List<?>)this.getAllEntries().values().stream().filter(value -> RegistryEntry.of(value).isIn(tag)).toList();
        return values.isEmpty() ? Optional.empty() : Optional.of(values);
    }

    public Optional<T> getRandomFromTag(TagKey<T> tag, Random random) {
        return this.fromTag(tag).map(values -> this.getRandomElement((Collection<T>)values, random));
    }

    public T getRandomElement(Collection<T> collection, Random random) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random element from empty collection");
        }
        if (collection instanceof List) {
            List<T> list = (List<T>)collection;
            return (T)list.get(random.nextInt(list.size()));
        }
        int index = random.nextInt(collection.size());
        Iterator<T> iterator = collection.iterator();
        for (int i = 0; i < index; ++i) {
            iterator.next();
        }
        return iterator.next();
    }

    public T getRandomElement(Random random) {
        Map<Identifier, T> allEntries = this.getAllEntries();
        if (allEntries.isEmpty()) {
            throw new IllegalStateException("Registry is empty");
        }
        return this.getRandomElement(allEntries.values(), random);
    }

    private Map<Identifier, T> getAllEntries() {
        HashMap combined = new HashMap();
        this.registry.getEntrySet().forEach(entry -> combined.put((entry.getKey()).getValue(), entry.getValue()));
        combined.putAll(this.hardcodedEntries);
        combined.putAll(this.dataDrivenEntries);
        return combined;
    }

    public Collection<T> values() {
        return Collections.unmodifiableCollection(this.getAllEntries().values());
    }

    public Map<Identifier, T> entries() {
        return Collections.unmodifiableMap(this.getAllEntries());
    }

    public void clearDataDrivenEntries() {
        this.dataDrivenEntries.clear();
    }

    public void register() {
        if (this.isPresent) {
            throw new IllegalStateException("Duplication of BuiltIn-Registry: " + String.valueOf(this.registry));
        }
        this.isPresent = true;
    }
}

