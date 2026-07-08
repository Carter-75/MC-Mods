/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Joiner
 *  com.google.common.base.Preconditions
 *  com.google.common.collect.Lists
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.annotations.NotNull
 *  org.jetbrains.annotations.Nullable
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.core.util.config.ConfigBuilder;
import backported.updates.foundation.core.util.config.IConfigSpec;
import backported.updates.foundation.core.util.config.SimpleConfigBuilder;
import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.ConfigSpec;
import backported.updates.foundation.nightconfig.core.EnumGetMethod;
import backported.updates.foundation.nightconfig.core.UnmodifiableConfig;
import backported.updates.foundation.nightconfig.core.file.FileConfig;
import backported.updates.foundation.nightconfig.core.utils.UnmodifiableConfigWrapper;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SimpleConfigSpec
extends UnmodifiableConfigWrapper<UnmodifiableConfig>
implements IConfigSpec<SimpleConfigSpec> {
    private final Map<List<String>, String> levelComments;
    private final Map<List<String>, String> levelTranslationKeys;
    private final UnmodifiableConfig values;
    private Config childConfig;
    private boolean isCorrecting = false;
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Joiner LINE_JOINER = Joiner.on((String)"\n");
    static final Joiner DOT_JOINER = Joiner.on((String)".");

    SimpleConfigSpec(UnmodifiableConfig storage, UnmodifiableConfig values, Map<List<String>, String> levelComments, Map<List<String>, String> levelTranslationKeys) {
        super(storage);
        this.values = values;
        this.levelComments = levelComments;
        this.levelTranslationKeys = levelTranslationKeys;
    }

    public String getLevelComment(List<String> path) {
        return this.levelComments.get(path);
    }

    public String getLevelTranslationKey(List<String> path) {
        return this.levelTranslationKeys.get(path);
    }

    @Override
    public void setConfig(CommentedConfig config) {
        this.childConfig = config;
        if (config != null && !this.isCorrect(config)) {
            String configName = config instanceof FileConfig ? ((FileConfig)((Object)config)).getNioPath().toString() : config.toString();
            LOGGER.warn("Configuration file {} is not correct. Correcting", (Object)configName);
            this.correct(config, (action, path, incorrectValue, correctedValue) -> LOGGER.warn("Incorrect key {} was corrected from {} to its default, {}. {}", (Object)DOT_JOINER.join((Iterable)path), incorrectValue, correctedValue, (Object)(incorrectValue == correctedValue ? "This seems to be an error." : "")), (action, path, incorrectValue, correctedValue) -> LOGGER.debug("The comment on key {} does not match the spec. This may create a backup.", (Object)DOT_JOINER.join((Iterable)path)));
            if (config instanceof FileConfig) {
                ((FileConfig)((Object)config)).save();
            }
        }
        this.afterReload();
    }

    @Override
    public boolean isCorrecting() {
        return this.isCorrecting;
    }

    public boolean isLoaded() {
        return this.childConfig != null;
    }

    public UnmodifiableConfig getSpec() {
        return this.config;
    }

    public UnmodifiableConfig getValues() {
        return this.values;
    }

    @Override
    public void afterReload() {
        this.resetCaches(this.getValues().valueMap().values());
    }

    private void resetCaches(Iterable<Object> values) {
        values.forEach(value -> {
            if (value instanceof FabricConfigValue) {
                FabricConfigValue configValue = (FabricConfigValue)value;
                configValue.clearCache();
            } else if (value instanceof Config) {
                Config config = (Config)value;
                this.resetCaches(config.valueMap().values());
            }
        });
    }

    public void save() {
        Preconditions.checkNotNull((Object)this.childConfig, (Object)"Cannot save config value without assigned Config object present");
        if (this.childConfig instanceof FileConfig) {
            ((FileConfig)this.childConfig).save();
        }
    }

    @Override
    public synchronized boolean isCorrect(CommentedConfig config) {
        LinkedList<String> parent = new LinkedList<String>();
        return this.correct(this.config, config, parent, Collections.unmodifiableList(parent), (action, path, incorrectValue, correctedValue) -> {}, null, true) == 0;
    }

    @Override
    public int correct(CommentedConfig config) {
        return this.correct(config, (action, path, incorrectValue, correctedValue) -> {}, null);
    }

    public synchronized int correct(CommentedConfig config, ConfigSpec.CorrectionListener listener) {
        return this.correct(config, listener, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized int correct(CommentedConfig config, ConfigSpec.CorrectionListener listener, ConfigSpec.CorrectionListener commentListener) {
        LinkedList<String> parent = new LinkedList<String>();
        int ret = -1;
        try {
            this.isCorrecting = true;
            ret = this.correct(this.config, config, parent, Collections.unmodifiableList(parent), listener, commentListener, false);
        }
        finally {
            this.isCorrecting = false;
        }
        return ret;
    }

    private int correct(UnmodifiableConfig spec, CommentedConfig config, LinkedList<String> parentPath, List<String> parentPathUnmodifiable, ConfigSpec.CorrectionListener listener, ConfigSpec.CorrectionListener commentListener, boolean dryRun) {
        int count = 0;
        Map<String, Object> specMap = spec.valueMap();
        Map<String, Object> configMap = config.valueMap();
        for (Map.Entry<String, Object> specEntry : specMap.entrySet()) {
            String key = specEntry.getKey();
            Object specValue = specEntry.getValue();
            Object configValue = configMap.get(key);
            ConfigSpec.CorrectionAction action = configValue == null ? ConfigSpec.CorrectionAction.ADD : ConfigSpec.CorrectionAction.REPLACE;
            parentPath.addLast(key);
            if (specValue instanceof Config) {
                if (configValue instanceof CommentedConfig) {
                    if ((count += this.correct((Config)specValue, (CommentedConfig)configValue, parentPath, parentPathUnmodifiable, listener, commentListener, dryRun)) > 0 && dryRun) {
                        return count;
                    }
                } else {
                    if (dryRun) {
                        return 1;
                    }
                    CommentedConfig newValue = config.createSubConfig();
                    configMap.put(key, newValue);
                    listener.onCorrect(action, parentPathUnmodifiable, configValue, newValue);
                    ++count;
                    count += this.correct((Config)specValue, newValue, parentPath, parentPathUnmodifiable, listener, commentListener, dryRun);
                }
                String newComment = this.levelComments.get(parentPath);
                oldComment = config.getComment(key);
                if (!this.stringsMatchIgnoringNewlines(oldComment, newComment)) {
                    if (commentListener != null) {
                        commentListener.onCorrect(action, parentPathUnmodifiable, oldComment, newComment);
                    }
                    if (dryRun) {
                        return 1;
                    }
                    config.setComment(key, newComment);
                }
            } else {
                ValueSpec valueSpec = (ValueSpec)specValue;
                if (!valueSpec.test(configValue)) {
                    if (dryRun) {
                        return 1;
                    }
                    Object newValue = valueSpec.correct(configValue);
                    configMap.put(key, newValue);
                    listener.onCorrect(action, parentPathUnmodifiable, configValue, newValue);
                    ++count;
                }
                if (!this.stringsMatchIgnoringNewlines(oldComment = config.getComment(key), valueSpec.getComment())) {
                    if (commentListener != null) {
                        commentListener.onCorrect(action, parentPathUnmodifiable, oldComment, valueSpec.getComment());
                    }
                    if (dryRun) {
                        return 1;
                    }
                    config.setComment(key, valueSpec.getComment());
                }
            }
            parentPath.removeLast();
        }
        Iterator<Map.Entry<String, Object>> ittr = configMap.entrySet().iterator();
        while (ittr.hasNext()) {
            Map.Entry<String, Object> entry = ittr.next();
            if (specMap.containsKey(entry.getKey())) continue;
            if (dryRun) {
                return 1;
            }
            ittr.remove();
            parentPath.addLast(entry.getKey());
            listener.onCorrect(ConfigSpec.CorrectionAction.REMOVE, parentPathUnmodifiable, entry.getValue(), null);
            parentPath.removeLast();
            ++count;
        }
        return count;
    }

    private boolean stringsMatchIgnoringNewlines(@Nullable Object obj1, @Nullable Object obj2) {
        if (obj1 instanceof String) {
            String string1 = (String)obj1;
            if (obj2 instanceof String) {
                String string2 = (String)obj2;
                if (!string1.isEmpty() && !string2.isEmpty()) {
                    return string1.replaceAll("\r\n", "\n").equals(string2.replaceAll("\r\n", "\n"));
                }
            }
        }
        return Objects.equals(obj1, obj2);
    }

    public static class ValueSpec {
        private final String comment;
        private final String langKey;
        private final Range<?> range;
        private final boolean worldRestart;
        private final Class<?> clazz;
        private final Supplier<?> supplier;
        private final Predicate<Object> validator;
        private Object _default = null;

        ValueSpec(Supplier<?> supplier, Predicate<Object> validator, BuilderContext context) {
            Objects.requireNonNull(supplier, "Default supplier can not be null");
            Objects.requireNonNull(validator, "Validator can not be null");
            this.comment = context.hasComment() ? context.buildComment() : null;
            this.langKey = context.getTranslationKey();
            this.range = context.getRange();
            this.worldRestart = context.needsWorldRestart();
            this.clazz = context.getClazz();
            this.supplier = supplier;
            this.validator = validator;
        }

        public String getComment() {
            return this.comment;
        }

        public String getTranslationKey() {
            return this.langKey;
        }

        public <V extends Comparable<? super V>> Range<V> getRange() {
            return this.range;
        }

        public boolean needsWorldRestart() {
            return this.worldRestart;
        }

        public Class<?> getClazz() {
            return this.clazz;
        }

        public boolean test(Object value) {
            return this.validator.test(value);
        }

        public Object correct(Object value) {
            return this.range == null ? this.getDefault() : this.range.correct(value, this.getDefault());
        }

        public Object getDefault() {
            if (this._default == null) {
                this._default = this.supplier.get();
            }
            return this._default;
        }
    }

    public static class FabricConfigValue<T>
    implements ConfigBuilder.ConfigValue<T> {
        private static final boolean USE_CACHES = true;
        private final SimpleConfigBuilder parent;
        private final List<String> path;
        private final Supplier<T> defaultSupplier;
        private T cachedValue = null;
        SimpleConfigSpec spec;

        FabricConfigValue(SimpleConfigBuilder parent, List<String> path, Supplier<T> defaultSupplier) {
            this.parent = parent;
            this.path = path;
            this.defaultSupplier = defaultSupplier;
            this.parent.values.add(this);
        }

        @Override
        public List<String> getPath() {
            return Lists.newArrayList(this.path);
        }

        @Override
        public T get() {
            Preconditions.checkNotNull((Object)this.spec, (Object)"Cannot get config value before spec is built");
            if (this.spec.childConfig == null) {
                return this.defaultSupplier.get();
            }
            if (this.cachedValue == null) {
                this.cachedValue = this.getRaw(this.spec.childConfig, this.path, this.defaultSupplier);
            }
            return this.cachedValue;
        }

        protected T getRaw(Config config, List<String> path, Supplier<T> defaultSupplier) {
            return config.getOrElse(path, defaultSupplier);
        }

        @Override
        public ConfigBuilder next() {
            return this.parent;
        }

        @Override
        public void save() {
            Preconditions.checkNotNull((Object)this.spec, (Object)"Cannot save config value before spec is built");
            Preconditions.checkNotNull((Object)this.spec.childConfig, (Object)"Cannot save config value without assigned Config object present");
            this.spec.save();
        }

        @Override
        public void set(T value) {
            Preconditions.checkNotNull((Object)this.spec, (Object)"Cannot set config value before spec is built");
            Preconditions.checkNotNull((Object)this.spec.childConfig, (Object)"Cannot set config value without assigned Config object present");
            this.spec.childConfig.set(this.path, value);
            this.cachedValue = value;
        }

        @Override
        public void clearCache() {
            this.cachedValue = null;
        }
    }

    public static class EnumValue<T extends Enum<T>>
    extends FabricConfigValue<T> {
        private final EnumGetMethod converter;
        private final Class<T> clazz;

        EnumValue(SimpleConfigBuilder parent, List<String> path, Supplier<T> defaultSupplier, EnumGetMethod converter, Class<T> clazz) {
            super(parent, path, defaultSupplier);
            this.converter = converter;
            this.clazz = clazz;
        }

        @Override
        protected T getRaw(Config config, List<String> path, Supplier<T> defaultSupplier) {
            return config.getEnumOrElse(path, this.clazz, this.converter, defaultSupplier);
        }
    }

    public static class DoubleValue
    extends FabricConfigValue<Double> {
        DoubleValue(SimpleConfigBuilder parent, List<String> path, Supplier<Double> defaultSupplier) {
            super(parent, path, defaultSupplier);
        }

        @Override
        protected Double getRaw(Config config, List<String> path, Supplier<Double> defaultSupplier) {
            Number n = (Number)config.get(path);
            return n == null ? defaultSupplier.get().doubleValue() : n.doubleValue();
        }
    }

    public static class LongValue
    extends FabricConfigValue<Long> {
        LongValue(SimpleConfigBuilder parent, List<String> path, Supplier<Long> defaultSupplier) {
            super(parent, path, defaultSupplier);
        }

        @Override
        protected Long getRaw(Config config, List<String> path, Supplier<Long> defaultSupplier) {
            return config.getLongOrElse(path, defaultSupplier::get);
        }
    }

    public static class IntValue
    extends FabricConfigValue<Integer> {
        IntValue(SimpleConfigBuilder parent, List<String> path, Supplier<Integer> defaultSupplier) {
            super(parent, path, defaultSupplier);
        }

        @Override
        protected Integer getRaw(Config config, List<String> path, Supplier<Integer> defaultSupplier) {
            return config.getIntOrElse(path, defaultSupplier::get);
        }
    }

    public static class BooleanValue
    extends FabricConfigValue<Boolean> {
        BooleanValue(SimpleConfigBuilder parent, List<String> path, Supplier<Boolean> defaultSupplier) {
            super(parent, path, defaultSupplier);
        }
    }

    public static class Range<V extends Comparable<? super V>>
    implements Predicate<Object> {
        private final Class<? extends V> clazz;
        private final V min;
        private final V max;

        Range(Class<V> clazz, V min, V max) {
            this.clazz = clazz;
            this.min = min;
            this.max = max;
        }

        public Class<? extends V> getClazz() {
            return this.clazz;
        }

        public V getMin() {
            return this.min;
        }

        public V getMax() {
            return this.max;
        }

        private boolean isNumber(Object other) {
            return Number.class.isAssignableFrom(this.clazz) && other instanceof Number;
        }

        @Override
        public boolean test(Object t) {
            boolean result;
            if (this.isNumber(t)) {
                boolean result2;
                Number n = (Number)t;
                boolean bl = result2 = ((Number)this.min).doubleValue() <= n.doubleValue() && n.doubleValue() <= ((Number)this.max).doubleValue();
                if (!result2) {
                    LOGGER.debug("Range value {} is not within its bounds {}-{}", (Object)n.doubleValue(), (Object)((Number)this.min).doubleValue(), (Object)((Number)this.max).doubleValue());
                }
                return result2;
            }
            if (!this.clazz.isInstance(t)) {
                return false;
            }
            Comparable c = (Comparable)this.clazz.cast(t);
            boolean bl = result = c.compareTo(this.min) >= 0 && c.compareTo(this.max) <= 0;
            if (!result) {
                LOGGER.debug("Range value {} is not within its bounds {}-{}", (Object)c, this.min, this.max);
            }
            return result;
        }

        public Object correct(Object value, Object def) {
            if (this.isNumber(value)) {
                Number n = (Number)value;
                return n.doubleValue() < ((Number)this.min).doubleValue() ? this.min : (n.doubleValue() > ((Number)this.max).doubleValue() ? this.max : value);
            }
            if (!this.clazz.isInstance(value)) {
                return def;
            }
            Comparable c = (Comparable)this.clazz.cast(value);
            return c.compareTo(this.min) < 0 ? this.min : (c.compareTo(this.max) > 0 ? this.max : value);
        }

        public String toString() {
            if (this.clazz == Integer.class) {
                if (this.max.equals(Integer.MAX_VALUE)) {
                    return "> " + String.valueOf(this.min);
                }
                if (this.min.equals(Integer.MIN_VALUE)) {
                    return "< " + String.valueOf(this.max);
                }
            }
            return String.valueOf(this.min) + " ~ " + String.valueOf(this.max);
        }
    }

    static class BuilderContext {
        @NotNull
        private String[] comment = new String[0];
        private String langKey;
        private Range<?> range;
        private boolean worldRestart = false;
        private Class<?> clazz;

        BuilderContext() {
        }

        public void setComment(String ... value) {
            this.validate(value == null, "Passed in null value for comment");
            this.comment = value;
        }

        public boolean hasComment() {
            return this.comment.length > 0;
        }

        public String[] getComment() {
            return this.comment;
        }

        public String buildComment() {
            return LINE_JOINER.join((Object[])this.comment);
        }

        public void setTranslationKey(String value) {
            this.langKey = value;
        }

        public String getTranslationKey() {
            return this.langKey;
        }

        public <V extends Comparable<? super V>> void setRange(Range<V> value) {
            this.range = value;
            this.setClazz(value.getClazz());
        }

        public <V extends Comparable<? super V>> Range<V> getRange() {
            return this.range;
        }

        public void worldRestart() {
            this.worldRestart = true;
        }

        public boolean needsWorldRestart() {
            return this.worldRestart;
        }

        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }

        public Class<?> getClazz() {
            return this.clazz;
        }

        public void ensureEmpty() {
            this.validate(this.hasComment(), "Non-empty comment when empty expected");
            this.validate(this.langKey, "Non-null translation key when null expected");
            this.validate(this.range, "Non-null range when null expected");
            this.validate(this.worldRestart, "Dangeling world restart value set to true");
        }

        private void validate(Object value, String message) {
            if (value != null) {
                throw new IllegalStateException(message);
            }
        }

        private void validate(boolean value, String message) {
            if (value) {
                throw new IllegalStateException(message);
            }
        }
    }
}

