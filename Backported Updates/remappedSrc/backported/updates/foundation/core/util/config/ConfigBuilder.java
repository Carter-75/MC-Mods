/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Splitter
 *  com.google.common.collect.Lists
 *  org.jetbrains.annotations.ApiStatus$Internal
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.nightconfig.core.EnumGetMethod;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.jetbrains.annotations.ApiStatus;

public interface ConfigBuilder {
    public static final Splitter DOT_SPLITTER = Splitter.on((String)".");

    @ApiStatus.Internal
    public static List<String> split(String path) {
        return Lists.newArrayList((Iterable)DOT_SPLITTER.split((CharSequence)path));
    }

    default public <T> ConfigValue<T> define(String path, T defaultValue) {
        return this.define(ConfigBuilder.split(path), defaultValue);
    }

    default public <T> ConfigValue<T> define(List<String> path, T defaultValue) {
        return this.define(path, defaultValue, (Object o) -> o != null && defaultValue.getClass().isAssignableFrom(o.getClass()));
    }

    default public <T> ConfigValue<T> define(String path, T defaultValue, Predicate<Object> validator) {
        return this.define(ConfigBuilder.split(path), defaultValue, validator);
    }

    default public <T> ConfigValue<T> define(List<String> path, T defaultValue, Predicate<Object> validator) {
        Objects.requireNonNull(defaultValue, "Default value can not be null");
        return this.define(path, () -> defaultValue, validator);
    }

    default public <T> ConfigValue<T> define(String path, Supplier<T> defaultSupplier, Predicate<Object> validator) {
        return this.define(ConfigBuilder.split(path), defaultSupplier, validator);
    }

    default public <T> ConfigValue<T> define(List<String> path, Supplier<T> defaultSupplier, Predicate<Object> validator) {
        return this.define(path, defaultSupplier, validator, Object.class);
    }

    public <T> ConfigValue<T> define(List<String> var1, Supplier<T> var2, Predicate<Object> var3, Class<?> var4);

    default public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(String path, V defaultValue, V min, V max, Class<V> clazz) {
        return this.defineInRange(ConfigBuilder.split(path), defaultValue, min, max, clazz);
    }

    default public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(List<String> path, V defaultValue, V min, V max, Class<V> clazz) {
        return this.defineInRange(path, () -> defaultValue, min, max, clazz);
    }

    default public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(String path, Supplier<V> defaultSupplier, V min, V max, Class<V> clazz) {
        return this.defineInRange(ConfigBuilder.split(path), defaultSupplier, min, max, clazz);
    }

    public <V extends Comparable<? super V>> ConfigValue<V> defineInRange(List<String> var1, Supplier<V> var2, V var3, V var4, Class<V> var5);

    default public <T> ConfigValue<T> defineInList(String path, T defaultValue, Collection<? extends T> acceptableValues) {
        return this.defineInList(ConfigBuilder.split(path), defaultValue, acceptableValues);
    }

    default public <T> ConfigValue<T> defineInList(String path, Supplier<T> defaultSupplier, Collection<? extends T> acceptableValues) {
        return this.defineInList(ConfigBuilder.split(path), defaultSupplier, acceptableValues);
    }

    default public <T> ConfigValue<T> defineInList(List<String> path, T defaultValue, Collection<? extends T> acceptableValues) {
        return this.defineInList(path, () -> defaultValue, acceptableValues);
    }

    default public <T> ConfigValue<T> defineInList(List<String> path, Supplier<T> defaultSupplier, Collection<? extends T> acceptableValues) {
        return this.define(path, defaultSupplier, acceptableValues::contains);
    }

    default public <T> ConfigValue<List<? extends T>> defineList(String path, List<? extends T> defaultValue, Predicate<Object> elementValidator) {
        return this.defineList(ConfigBuilder.split(path), defaultValue, elementValidator);
    }

    default public <T> ConfigValue<List<? extends T>> defineList(String path, Supplier<List<? extends T>> defaultSupplier, Predicate<Object> elementValidator) {
        return this.defineList(ConfigBuilder.split(path), defaultSupplier, elementValidator);
    }

    default public <T> ConfigValue<List<? extends T>> defineList(List<String> path, List<? extends T> defaultValue, Predicate<Object> elementValidator) {
        return this.defineList(path, () -> defaultValue, elementValidator);
    }

    public <T> ConfigValue<List<? extends T>> defineList(List<String> var1, Supplier<List<? extends T>> var2, Predicate<Object> var3);

    public <T> ConfigValue<List<? extends T>> defineListAllowEmpty(List<String> var1, Supplier<List<? extends T>> var2, Predicate<Object> var3);

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue, EnumGetMethod converter) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue, converter);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue) {
        return this.defineEnum(path, defaultValue, (Enum[])defaultValue.getDeclaringClass().getEnumConstants());
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue, EnumGetMethod converter) {
        return this.defineEnum(path, defaultValue, converter, (Enum[])defaultValue.getDeclaringClass().getEnumConstants());
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue, V ... acceptableValues) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue, (Enum[])acceptableValues);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue, EnumGetMethod converter, V ... acceptableValues) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue, converter, (Enum[])acceptableValues);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue, V ... acceptableValues) {
        return this.defineEnum(path, defaultValue, (Collection<V>)Arrays.asList(acceptableValues));
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue, EnumGetMethod converter, V ... acceptableValues) {
        return this.defineEnum(path, defaultValue, converter, (Collection<V>)Arrays.asList(acceptableValues));
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue, Collection<V> acceptableValues) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue, acceptableValues);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue, EnumGetMethod converter, Collection<V> acceptableValues) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue, converter, acceptableValues);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue, Collection<V> acceptableValues) {
        return this.defineEnum(path, defaultValue, EnumGetMethod.NAME_IGNORECASE, acceptableValues);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue, EnumGetMethod converter, Collection<V> acceptableValues) {
        return this.defineEnum(path, defaultValue, converter, (Object obj) -> {
            if (obj == null) {
                return false;
            }
            if (obj instanceof Enum) {
                return acceptableValues.contains(obj);
            }
            try {
                return acceptableValues.contains(converter.get(obj, defaultValue.getDeclaringClass()));
            }
            catch (ClassCastException | IllegalArgumentException e) {
                return false;
            }
        });
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue, Predicate<Object> validator) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue, validator);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, V defaultValue, EnumGetMethod converter, Predicate<Object> validator) {
        return this.defineEnum(ConfigBuilder.split(path), defaultValue, converter, validator);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue, Predicate<Object> validator) {
        return this.defineEnum(path, () -> defaultValue, validator, defaultValue.getDeclaringClass());
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, V defaultValue, EnumGetMethod converter, Predicate<Object> validator) {
        return this.defineEnum(path, () -> defaultValue, converter, validator, defaultValue.getDeclaringClass());
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, Supplier<V> defaultSupplier, Predicate<Object> validator, Class<V> clazz) {
        return this.defineEnum(ConfigBuilder.split(path), defaultSupplier, validator, clazz);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(String path, Supplier<V> defaultSupplier, EnumGetMethod converter, Predicate<Object> validator, Class<V> clazz) {
        return this.defineEnum(ConfigBuilder.split(path), defaultSupplier, converter, validator, clazz);
    }

    default public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> path, Supplier<V> defaultSupplier, Predicate<Object> validator, Class<V> clazz) {
        return this.defineEnum(path, defaultSupplier, EnumGetMethod.NAME_IGNORECASE, validator, clazz);
    }

    public <V extends Enum<V>> ConfigValue<V> defineEnum(List<String> var1, Supplier<V> var2, EnumGetMethod var3, Predicate<Object> var4, Class<V> var5);

    default public ConfigValue<Boolean> define(String path, boolean defaultValue) {
        return this.define(ConfigBuilder.split(path), defaultValue);
    }

    default public ConfigValue<Boolean> define(List<String> path, boolean defaultValue) {
        return this.define(path, () -> defaultValue);
    }

    default public ConfigValue<Boolean> define(String path, Supplier<Boolean> defaultSupplier) {
        return this.define(ConfigBuilder.split(path), defaultSupplier);
    }

    public ConfigValue<Boolean> define(List<String> var1, Supplier<Boolean> var2);

    default public ConfigValue<Double> defineInRange(String path, double defaultValue, double min, double max) {
        return this.defineInRange(ConfigBuilder.split(path), defaultValue, min, max);
    }

    default public ConfigValue<Double> defineInRange(List<String> path, double defaultValue, double min, double max) {
        return this.defineInRange(path, () -> defaultValue, min, max);
    }

    default public ConfigValue<Double> defineInRange(String path, Supplier<Double> defaultSupplier, double min, double max) {
        return this.defineInRange(ConfigBuilder.split(path), defaultSupplier, min, max);
    }

    public ConfigValue<Double> defineInRange(List<String> var1, Supplier<Double> var2, double var3, double var5);

    default public ConfigValue<Integer> defineInRange(String path, int defaultValue, int min, int max) {
        return this.defineInRange(ConfigBuilder.split(path), defaultValue, min, max);
    }

    default public ConfigValue<Integer> defineInRange(List<String> path, int defaultValue, int min, int max) {
        return this.defineInRange(path, () -> defaultValue, min, max);
    }

    default public ConfigValue<Integer> defineInRange(String path, Supplier<Integer> defaultSupplier, int min, int max) {
        return this.defineInRange(ConfigBuilder.split(path), defaultSupplier, min, max);
    }

    public ConfigValue<Integer> defineInRange(List<String> var1, Supplier<Integer> var2, int var3, int var4);

    default public ConfigValue<Long> defineInRange(String path, long defaultValue, long min, long max) {
        return this.defineInRange(ConfigBuilder.split(path), defaultValue, min, max);
    }

    default public ConfigValue<Long> defineInRange(List<String> path, long defaultValue, long min, long max) {
        return this.defineInRange(path, () -> defaultValue, min, max);
    }

    default public ConfigValue<Long> defineInRange(String path, Supplier<Long> defaultSupplier, long min, long max) {
        return this.defineInRange(ConfigBuilder.split(path), defaultSupplier, min, max);
    }

    public ConfigValue<Long> defineInRange(List<String> var1, Supplier<Long> var2, long var3, long var5);

    public ConfigBuilder comment(String var1);

    public ConfigBuilder comment(String ... var1);

    public ConfigBuilder translation(String var1);

    public ConfigBuilder worldRestart();

    default public ConfigBuilder push(String path) {
        return this.push(ConfigBuilder.split(path));
    }

    public ConfigBuilder push(List<String> var1);

    default public ConfigBuilder pop() {
        return this.pop(1);
    }

    public ConfigBuilder pop(int var1);

    public static interface ConfigValue<T> {
        public List<String> getPath();

        public T get();

        public ConfigBuilder next();

        public void save();

        public void set(T var1);

        public void clearCache();
    }
}

