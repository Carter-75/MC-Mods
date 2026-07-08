/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.spi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.spi.ThreadContextMap;
import org.apache.logging.log4j.util.BiConsumer;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ReadOnlyStringMap;
import org.apache.logging.log4j.util.TriConsumer;

public class DefaultThreadContextMap
implements ThreadContextMap,
ReadOnlyStringMap {
    private static final long serialVersionUID = 8218007901108944053L;
    public static final String INHERITABLE_MAP = "isThreadContextMapInheritable";
    private final boolean useMap;
    private final ThreadLocal<Map<String, String>> localMap;
    private static boolean inheritableMap;

    static ThreadLocal<Map<String, String>> createThreadLocalMap(final boolean isMapEnabled) {
        if (inheritableMap) {
            return new InheritableThreadLocal<Map<String, String>>(){

                @Override
                protected Map<String, String> childValue(Map<String, String> parentValue) {
                    return parentValue != null && isMapEnabled ? Collections.unmodifiableMap(new HashMap<String, String>(parentValue)) : null;
                }
            };
        }
        return new ThreadLocal<Map<String, String>>();
    }

    static void init() {
        inheritableMap = PropertiesUtil.getProperties().getBooleanProperty(INHERITABLE_MAP);
    }

    public DefaultThreadContextMap() {
        this(true);
    }

    public DefaultThreadContextMap(boolean useMap) {
        this.useMap = useMap;
        this.localMap = DefaultThreadContextMap.createThreadLocalMap(useMap);
    }

    @Override
    public void put(String key, String value) {
        if (!this.useMap) {
            return;
        }
        Map<String, String> map2 = this.localMap.get();
        map2 = map2 == null ? new HashMap<String, String>(1) : new HashMap<String, String>(map2);
        map2.put(key, value);
        this.localMap.set(Collections.unmodifiableMap(map2));
    }

    public void putAll(Map<String, String> m2) {
        if (!this.useMap) {
            return;
        }
        Map<String, String> map2 = this.localMap.get();
        map2 = map2 == null ? new HashMap<String, String>(m2.size()) : new HashMap<String, String>(map2);
        for (Map.Entry<String, String> e2 : m2.entrySet()) {
            map2.put(e2.getKey(), e2.getValue());
        }
        this.localMap.set(Collections.unmodifiableMap(map2));
    }

    @Override
    public String get(String key) {
        Map<String, String> map2 = this.localMap.get();
        return map2 == null ? null : map2.get(key);
    }

    @Override
    public void remove(String key) {
        Map<String, String> map2 = this.localMap.get();
        if (map2 != null) {
            HashMap<String, String> copy = new HashMap<String, String>(map2);
            copy.remove(key);
            this.localMap.set(Collections.unmodifiableMap(copy));
        }
    }

    public void removeAll(Iterable<String> keys2) {
        Map<String, String> map2 = this.localMap.get();
        if (map2 != null) {
            HashMap<String, String> copy = new HashMap<String, String>(map2);
            for (String key : keys2) {
                copy.remove(key);
            }
            this.localMap.set(Collections.unmodifiableMap(copy));
        }
    }

    @Override
    public void clear() {
        this.localMap.remove();
    }

    @Override
    public Map<String, String> toMap() {
        return this.getCopy();
    }

    @Override
    public boolean containsKey(String key) {
        Map<String, String> map2 = this.localMap.get();
        return map2 != null && map2.containsKey(key);
    }

    @Override
    public <V> void forEach(BiConsumer<String, ? super V> action) {
        Map<String, String> map2 = this.localMap.get();
        if (map2 == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String value = entry.getValue();
            action.accept(entry.getKey(), value);
        }
    }

    @Override
    public <V, S> void forEach(TriConsumer<String, ? super V, S> action, S state) {
        Map<String, String> map2 = this.localMap.get();
        if (map2 == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String value = entry.getValue();
            action.accept(entry.getKey(), value, state);
        }
    }

    @Override
    public <V> V getValue(String key) {
        Map<String, String> map2 = this.localMap.get();
        return (V)(map2 == null ? null : map2.get(key));
    }

    @Override
    public Map<String, String> getCopy() {
        Map<String, String> map2 = this.localMap.get();
        return map2 == null ? new HashMap<String, String>() : new HashMap<String, String>(map2);
    }

    @Override
    public Map<String, String> getImmutableMapOrNull() {
        return this.localMap.get();
    }

    @Override
    public boolean isEmpty() {
        Map<String, String> map2 = this.localMap.get();
        return map2 == null || map2.isEmpty();
    }

    @Override
    public int size() {
        Map<String, String> map2 = this.localMap.get();
        return map2 == null ? 0 : map2.size();
    }

    public String toString() {
        Map<String, String> map2 = this.localMap.get();
        return map2 == null ? "{}" : map2.toString();
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        Map<String, String> map2 = this.localMap.get();
        result2 = 31 * result2 + (map2 == null ? 0 : map2.hashCode());
        result2 = 31 * result2 + Boolean.valueOf(this.useMap).hashCode();
        return result2;
    }

    public boolean equals(Object obj) {
        ThreadContextMap other;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof DefaultThreadContextMap) {
            other = (DefaultThreadContextMap)obj;
            if (this.useMap != ((DefaultThreadContextMap)other).useMap) {
                return false;
            }
        }
        if (!(obj instanceof ThreadContextMap)) {
            return false;
        }
        other = (ThreadContextMap)obj;
        Map<String, String> map2 = this.localMap.get();
        Map<String, String> otherMap = other.getImmutableMapOrNull();
        return Objects.equals(map2, otherMap);
    }

    static {
        DefaultThreadContextMap.init();
    }
}

