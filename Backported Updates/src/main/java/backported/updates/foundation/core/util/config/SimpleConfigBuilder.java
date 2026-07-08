/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  com.google.common.collect.ObjectArrays
 *  org.apache.commons.lang3.tuple.Pair
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.Platform;
import backported.updates.foundation.core.Environment;
import backported.updates.foundation.core.util.config.ConfigBuilder;
import backported.updates.foundation.core.util.config.SimpleConfigSpec;
import com.electronwill.nightconfig.core.Config;
import com.electronwill.nightconfig.core.EnumGetMethod;
import com.electronwill.nightconfig.core.InMemoryFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.lang3.tuple.Pair;

public class SimpleConfigBuilder
implements ConfigBuilder {
    private final Config storage = Config.of(LinkedHashMap::new, InMemoryFormat.withUniversalSupport());
    private final Map<List<String>, String> levelComments = new HashMap<List<String>, String>();
    private final Map<List<String>, String> levelTranslationKeys = new HashMap<List<String>, String>();
    private final List<String> currentPath = new ArrayList<String>();
    List<SimpleConfigSpec.FabricConfigValue<?>> values = new ArrayList();
    private SimpleConfigSpec.BuilderContext context = new SimpleConfigSpec.BuilderContext();

    private <T> ConfigBuilder.ConfigValue<T> define(List<String> path, SimpleConfigSpec.ValueSpec value, Supplier<T> defaultSupplier) {
        if (!this.currentPath.isEmpty()) {
            ArrayList<String> tmp = new ArrayList<String>(this.currentPath.size() + path.size());
            tmp.addAll(this.currentPath);
            tmp.addAll(path);
            path = tmp;
        }
        this.storage.set(path, value);
        this.context = new SimpleConfigSpec.BuilderContext();
        return new SimpleConfigSpec.FabricConfigValue<T>(this, path, defaultSupplier);
    }

    @Override
    public <T> ConfigBuilder.ConfigValue<T> define(List<String> path, Supplier<T> defaultSupplier, Predicate<Object> validator, Class<?> clazz) {
        this.context.setClazz(clazz);
        return this.define(path, new SimpleConfigSpec.ValueSpec(defaultSupplier, validator, this.context), defaultSupplier);
    }

    @Override
    public <V extends Comparable<? super V>> ConfigBuilder.ConfigValue<V> defineInRange(List<String> path, Supplier<V> defaultSupplier, V min, V max, Class<V> clazz) {
        SimpleConfigSpec.Range<V> range = new SimpleConfigSpec.Range<V>(clazz, min, max);
        this.context.setRange(range);
        this.context.setComment((String[])ObjectArrays.concat((Object[])this.context.getComment(), ("Range: " + String.valueOf(range))));
        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Range min most be less then max.");
        }
        return this.define(path, defaultSupplier, (Predicate<Object>)range);
    }

    @Override
    public <T> ConfigBuilder.ConfigValue<List<? extends T>> defineList(final List<String> path, Supplier<List<? extends T>> defaultSupplier, final Predicate<Object> elementValidator) {
        this.context.setClazz(List.class);
        return this.define(path, new SimpleConfigSpec.ValueSpec(defaultSupplier, x -> x instanceof List && ((List<?>)x).stream().allMatch(elementValidator), this.context){

            @Override
            public Object correct(Object value) {
                if (!(value instanceof List) || ((List<?>)value).isEmpty()) {
                    Platform.LOGGER.debug("List on key {} is deemed to need correction. It is null, not a list, or an empty list. Modders, consider defineListAllowEmpty?", path.get(path.size() - 1));
                    return this.getDefault();
                }
                ArrayList list = Lists.newArrayList((Iterable)(value));
                list.removeIf(elementValidator.negate());
                if (list.isEmpty()) {
                    Platform.LOGGER.debug("List on key {} is deemed to need correction. It failed validation.", path.get(path.size() - 1));
                    return this.getDefault();
                }
                return list;
            }
        }, defaultSupplier);
    }

    @Override
    public <T> ConfigBuilder.ConfigValue<List<? extends T>> defineListAllowEmpty(final List<String> path, Supplier<List<? extends T>> defaultSupplier, final Predicate<Object> elementValidator) {
        this.context.setClazz(List.class);
        return this.define(path, new SimpleConfigSpec.ValueSpec(defaultSupplier, x -> x instanceof List && ((List<?>)x).stream().allMatch(elementValidator), this.context){

            @Override
            public Object correct(Object value) {
                if (!(value instanceof List)) {
                    Platform.LOGGER.debug("List on key {} is deemed to need correction, as it is null or not a list.", path.get(path.size() - 1));
                    return this.getDefault();
                }
                ArrayList list = Lists.newArrayList((Iterable)(value));
                list.removeIf(elementValidator.negate());
                if (list.isEmpty()) {
                    Platform.LOGGER.debug("List on key {} is deemed to need correction. It failed validation.", path.get(path.size() - 1));
                    return this.getDefault();
                }
                return list;
            }
        }, defaultSupplier);
    }

    @Override
    public <V extends Enum<V>> ConfigBuilder.ConfigValue<V> defineEnum(List<String> path, Supplier<V> defaultSupplier, EnumGetMethod converter, Predicate<Object> validator, Class<V> clazz) {
        this.context.setClazz(clazz);
        Enum[] allowedValues = (Enum[])clazz.getEnumConstants();
        this.context.setComment((String[])ObjectArrays.concat((Object[])this.context.getComment(), ("Allowed Values: " + Arrays.stream(allowedValues).filter(validator).map(Enum::name).collect(Collectors.joining(", ")))));
        return new SimpleConfigSpec.EnumValue<V>(this, this.define(path, new SimpleConfigSpec.ValueSpec(defaultSupplier, validator, this.context), defaultSupplier).getPath(), defaultSupplier, converter, clazz);
    }

    @Override
    public ConfigBuilder.ConfigValue<Boolean> define(List<String> path, Supplier<Boolean> defaultSupplier) {
        return new SimpleConfigSpec.BooleanValue(this, this.define(path, defaultSupplier, o -> {
            if (o instanceof String) {
                return ((String)o).equalsIgnoreCase("true") || ((String)o).equalsIgnoreCase("false");
            }
            return o instanceof Boolean;
        }, Boolean.class).getPath(), defaultSupplier);
    }

    @Override
    public ConfigBuilder.ConfigValue<Double> defineInRange(List<String> path, Supplier<Double> defaultSupplier, double min, double max) {
        return new SimpleConfigSpec.DoubleValue(this, this.defineInRange(path, defaultSupplier, Double.valueOf(min), Double.valueOf(max), Double.class).getPath(), defaultSupplier);
    }

    @Override
    public ConfigBuilder.ConfigValue<Integer> defineInRange(List<String> path, Supplier<Integer> defaultSupplier, int min, int max) {
        return new SimpleConfigSpec.IntValue(this, this.defineInRange(path, defaultSupplier, Integer.valueOf(min), Integer.valueOf(max), Integer.class).getPath(), defaultSupplier);
    }

    @Override
    public ConfigBuilder.ConfigValue<Long> defineInRange(List<String> path, Supplier<Long> defaultSupplier, long min, long max) {
        return new SimpleConfigSpec.LongValue(this, this.defineInRange(path, defaultSupplier, Long.valueOf(min), Long.valueOf(max), Long.class).getPath(), defaultSupplier);
    }

    @Override
    public ConfigBuilder comment(String comment) {
        if (comment == null || comment.isEmpty()) {
            comment = "No comment";
            if (!Environment.isProduction()) {
                Platform.LOGGER.error("Null comment for config option {}, this is invalid and may be disallowed in the future.", SimpleConfigSpec.DOT_JOINER.join(this.currentPath));
            }
        }
        this.context.setComment(comment);
        return this;
    }

    @Override
    public ConfigBuilder comment(String ... comment) {
        if (comment == null || comment.length < 1 || comment.length == 1 && comment[0].isEmpty()) {
            comment = new String[]{"No comment"};
            if (!Environment.isProduction()) {
                Platform.LOGGER.error("Null comment for config option {}, this is invalid and may be disallowed in the future.", SimpleConfigSpec.DOT_JOINER.join(this.currentPath));
            }
        }
        this.context.setComment(comment);
        return this;
    }

    @Override
    public ConfigBuilder translation(String translationKey) {
        this.context.setTranslationKey(translationKey);
        return this;
    }

    @Override
    public ConfigBuilder worldRestart() {
        this.context.worldRestart();
        return this;
    }

    @Override
    public ConfigBuilder push(List<String> path) {
        this.currentPath.addAll(path);
        if (this.context.hasComment()) {
            this.levelComments.put(new ArrayList<String>(this.currentPath), this.context.buildComment());
            this.context.setComment(new String[0]);
        }
        if (this.context.getTranslationKey() != null) {
            this.levelTranslationKeys.put(new ArrayList<String>(this.currentPath), this.context.getTranslationKey());
            this.context.setTranslationKey(null);
        }
        this.context.ensureEmpty();
        return this;
    }

    @Override
    public ConfigBuilder pop(int count) {
        if (count > this.currentPath.size()) {
            throw new IllegalArgumentException("Attempted to pop " + count + " elements when we only had: " + String.valueOf(this.currentPath));
        }
        for (int x = 0; x < count; ++x) {
            this.currentPath.remove(this.currentPath.size() - 1);
        }
        return this;
    }

    public <T> Pair<T, SimpleConfigSpec> configure(Function<ConfigBuilder, T> consumer) {
        T o = consumer.apply(this);
        return Pair.of(o, this.build());
    }

    public SimpleConfigSpec build() {
        this.context.ensureEmpty();
        Config valueCfg = Config.of(Config.getDefaultMapCreator(true, true), InMemoryFormat.withSupport(ConfigBuilder.ConfigValue.class::isAssignableFrom));
        this.values.forEach(v -> valueCfg.set(v.getPath(), v));
        SimpleConfigSpec ret = new SimpleConfigSpec(this.storage, valueCfg, this.levelComments, this.levelTranslationKeys);
        this.values.forEach(v -> {
            v.spec = ret;
        });
        return ret;
    }
}

