/*
 * Decompiled with CFR 0.152.
 */
package org.apache.logging.log4j.spi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.apache.logging.log4j.spi.ReadOnlyThreadContextMap;
import org.apache.logging.log4j.spi.ThreadContextMap;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ReadOnlyStringMap;
import org.apache.logging.log4j.util.SortedArrayStringMap;
import org.apache.logging.log4j.util.StringMap;

class GarbageFreeSortedArrayThreadContextMap
implements ReadOnlyThreadContextMap,
ObjectThreadContextMap {
    public static final String INHERITABLE_MAP = "isThreadContextMapInheritable";
    protected static final int DEFAULT_INITIAL_CAPACITY = 16;
    protected static final String PROPERTY_NAME_INITIAL_CAPACITY = "log4j2.ThreadContext.initial.capacity";
    protected final ThreadLocal<StringMap> localMap = this.createThreadLocalMap();
    private static volatile int initialCapacity;
    private static volatile boolean inheritableMap;

    static void init() {
        PropertiesUtil properties = PropertiesUtil.getProperties();
        initialCapacity = properties.getIntegerProperty(PROPERTY_NAME_INITIAL_CAPACITY, 16);
        inheritableMap = properties.getBooleanProperty(INHERITABLE_MAP);
    }

    private ThreadLocal<StringMap> createThreadLocalMap() {
        if (inheritableMap) {
            return new InheritableThreadLocal<StringMap>(){

                @Override
                protected StringMap childValue(StringMap parentValue) {
                    return parentValue != null ? GarbageFreeSortedArrayThreadContextMap.this.createStringMap(parentValue) : null;
                }
            };
        }
        return new ThreadLocal<StringMap>();
    }

    protected StringMap createStringMap() {
        return new SortedArrayStringMap(initialCapacity);
    }

    protected StringMap createStringMap(ReadOnlyStringMap original) {
        return new SortedArrayStringMap(original);
    }

    private StringMap getThreadLocalMap() {
        StringMap map2 = this.localMap.get();
        if (map2 == null) {
            map2 = this.createStringMap();
            this.localMap.set(map2);
        }
        return map2;
    }

    @Override
    public void put(String key, String value) {
        this.getThreadLocalMap().putValue(key, value);
    }

    public void putValue(String key, Object value) {
        this.getThreadLocalMap().putValue(key, value);
    }

    @Override
    public void putAll(Map<String, String> values2) {
        if (values2 == null || values2.isEmpty()) {
            return;
        }
        StringMap map2 = this.getThreadLocalMap();
        for (Map.Entry<String, String> entry : values2.entrySet()) {
            map2.putValue(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public <V> void putAllValues(Map<String, V> values2) {
        if (values2 == null || values2.isEmpty()) {
            return;
        }
        StringMap map2 = this.getThreadLocalMap();
        for (Map.Entry<String, V> entry : values2.entrySet()) {
            map2.putValue(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public String get(String key) {
        return (String)this.getValue(key);
    }

    @Override
    public <V> V getValue(String key) {
        StringMap map2 = this.localMap.get();
        return map2 == null ? null : (V)map2.getValue(key);
    }

    @Override
    public void remove(String key) {
        StringMap map2 = this.localMap.get();
        if (map2 != null) {
            map2.remove(key);
        }
    }

    @Override
    public void removeAll(Iterable<String> keys2) {
        StringMap map2 = this.localMap.get();
        if (map2 != null) {
            for (String key : keys2) {
                map2.remove(key);
            }
        }
    }

    @Override
    public void clear() {
        StringMap map2 = this.localMap.get();
        if (map2 != null) {
            map2.clear();
        }
    }

    @Override
    public boolean containsKey(String key) {
        StringMap map2 = this.localMap.get();
        return map2 != null && map2.containsKey(key);
    }

    @Override
    public Map<String, String> getCopy() {
        StringMap map2 = this.localMap.get();
        return map2 == null ? new HashMap() : map2.toMap();
    }

    @Override
    public StringMap getReadOnlyContextData() {
        StringMap map2 = this.localMap.get();
        if (map2 == null) {
            map2 = this.createStringMap();
            this.localMap.set(map2);
        }
        return map2;
    }

    @Override
    public Map<String, String> getImmutableMapOrNull() {
        StringMap map2 = this.localMap.get();
        return map2 == null ? null : Collections.unmodifiableMap(map2.toMap());
    }

    @Override
    public boolean isEmpty() {
        StringMap map2 = this.localMap.get();
        return map2 == null || map2.isEmpty();
    }

    public String toString() {
        StringMap map2 = this.localMap.get();
        return map2 == null ? "{}" : map2.toString();
    }

    public int hashCode() {
        int prime = 31;
        int result2 = 1;
        StringMap map2 = this.localMap.get();
        result2 = 31 * result2 + (map2 == null ? 0 : map2.hashCode());
        return result2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ThreadContextMap)) {
            return false;
        }
        ThreadContextMap other = (ThreadContextMap)obj;
        Map<String, String> map2 = this.getImmutableMapOrNull();
        Map<String, String> otherMap = other.getImmutableMapOrNull();
        return Objects.equals(map2, otherMap);
    }

    static {
        GarbageFreeSortedArrayThreadContextMap.init();
    }
}

