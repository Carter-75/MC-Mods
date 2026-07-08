/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.conversion;

import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.ConfigFormat;
import backported.updates.foundation.nightconfig.core.conversion.ConvertedFormat;
import backported.updates.foundation.nightconfig.core.utils.ConfigWrapper;
import backported.updates.foundation.nightconfig.core.utils.TransformingMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

abstract class AbstractConvertedConfig<C extends Config>
extends ConfigWrapper<C>
implements Config {
    final Function<Object, Object> readConversion;
    final Function<Object, Object> writeConversion;
    final Predicate<Class<?>> supportPredicate;
    final ConfigFormat<?> format;

    AbstractConvertedConfig(C config, Function<Object, Object> readConversion, Function<Object, Object> writeConversion, Predicate<Class<?>> supportPredicate) {
        super(config);
        this.readConversion = readConversion;
        this.writeConversion = writeConversion;
        this.supportPredicate = supportPredicate;
        this.format = new ConvertedFormat(config.configFormat(), supportPredicate);
    }

    @Override
    public <T> T set(List<String> path, Object value) {
        return (T)this.readConversion.apply(((Config)this.config).set(path, this.writeConversion.apply(value)));
    }

    @Override
    public Map<String, Object> valueMap() {
        return new TransformingMap<String, Object, Object>(((Config)this.config).valueMap(), this.readConversion, this.writeConversion, this.writeConversion);
    }

    @Override
    public <T> T getRaw(List<String> path) {
        return (T)this.readConversion.apply(((Config)this.config).getRaw(path));
    }

    @Override
    public ConfigFormat<?> configFormat() {
        return this.format;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ':' + this.valueMap() + " (original: " + this.config + ')';
    }
}

