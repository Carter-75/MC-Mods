/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_5819
 *  net.minecraft.class_6862
 *  net.minecraft.class_6880
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
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_5819;
import net.minecraft.class_6862;
import net.minecraft.class_6880;

public class BuiltInCoreRegistry<T> {
    private final Map<class_2960, T> hardcodedEntries = new HashMap<class_2960, T>();
    private final Map<class_2960, T> dataDrivenEntries = new HashMap<class_2960, T>();
    private final String modId;
    private final class_2378<T> registry;
    protected boolean isPresent = false;

    public BuiltInCoreRegistry(class_2378<T> registry, String modId) {
        this.modId = modId;
        this.registry = registry;
        this.registry.method_10235().forEach(id -> this.hardcodedEntries.putIfAbsent((class_2960)id, (T)this.registry.method_10223(id)));
    }

    public T register(class_2960 name, T entry) {
        return this.hardcodedEntries.put(name, entry);
    }

    public T register(String name, T entry) {
        class_2960 location = class_2960.method_60655((String)this.modId, (String)name);
        return this.hardcodedEntries.put(location, entry);
    }

    public T registerDataDriven(class_2960 name, T entry) {
        return this.dataDrivenEntries.put(name, entry);
    }

    public <E extends T> class_5321<T> resource(String name, E entry) {
        this.register(name, entry);
        return class_5321.method_29179((class_5321)this.registry.method_30517(), (class_2960)class_2960.method_60655((String)this.modId, (String)name));
    }

    public T getOrDefault(class_2960 name, T fallback) {
        if (this.registry.method_10250(name)) {
            return (T)this.registry.method_10223(name);
        }
        if (this.dataDrivenEntries.containsKey(name)) {
            return this.dataDrivenEntries.get(name);
        }
        if (this.hardcodedEntries.containsKey(name)) {
            return this.hardcodedEntries.get(name);
        }
        return fallback;
    }

    public T get(class_2960 name) {
        if (this.dataDrivenEntries.containsKey(name)) {
            return this.dataDrivenEntries.get(name);
        }
        return this.hardcodedEntries.get(name);
    }

    public T get(class_5321<T> name) {
        return this.getOrDefault(name.method_29177(), null);
    }

    public T getOrThrow(class_5321<T> key) {
        T value = this.get(key);
        if (value == null) {
            class_5321 resource = this.registry.method_30517();
            throw new IllegalStateException("Missing key in " + String.valueOf(resource) + ":" + String.valueOf(key));
        }
        return value;
    }

    public class_2960 getKey(T value) {
        Optional<class_2960> dataDrivenKey = this.dataDrivenEntries.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).findFirst().map(Map.Entry::getKey);
        return dataDrivenKey.orElseGet(() -> (class_2960)this.hardcodedEntries.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), value)).findFirst().orElseThrow(() -> new IllegalArgumentException("Value not found in registry: " + String.valueOf(value))).getKey());
    }

    public Optional<List<T>> fromTag(class_6862<T> tag) {
        List<Object> values = this.getAllEntries().values().stream().filter(value -> class_6880.method_40223((Object)value).method_40220(tag)).toList();
        return values.isEmpty() ? Optional.empty() : Optional.of(values);
    }

    public Optional<T> getRandomFromTag(class_6862<T> tag, class_5819 random) {
        return this.fromTag(tag).map(values -> this.getRandomElement((Collection<T>)values, random));
    }

    public T getRandomElement(Collection<T> collection, class_5819 random) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random element from empty collection");
        }
        if (collection instanceof List) {
            List list = (List)collection;
            return (T)list.get(random.method_43048(list.size()));
        }
        int index = random.method_43048(collection.size());
        Iterator<T> iterator = collection.iterator();
        for (int i = 0; i < index; ++i) {
            iterator.next();
        }
        return iterator.next();
    }

    public T getRandomElement(class_5819 random) {
        Map<class_2960, T> allEntries = this.getAllEntries();
        if (allEntries.isEmpty()) {
            throw new IllegalStateException("Registry is empty");
        }
        return this.getRandomElement(allEntries.values(), random);
    }

    private Map<class_2960, T> getAllEntries() {
        HashMap combined = new HashMap();
        this.registry.method_29722().forEach(entry -> combined.put(((class_5321)entry.getKey()).method_29177(), entry.getValue()));
        combined.putAll(this.hardcodedEntries);
        combined.putAll(this.dataDrivenEntries);
        return combined;
    }

    public Collection<T> values() {
        return Collections.unmodifiableCollection(this.getAllEntries().values());
    }

    public Map<class_2960, T> entries() {
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

