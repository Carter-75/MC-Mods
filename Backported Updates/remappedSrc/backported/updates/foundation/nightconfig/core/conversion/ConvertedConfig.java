/*
 * Decompiled with CFR 0.152.
 */
package backported.updates.foundation.nightconfig.core.conversion;

import backported.updates.foundation.nightconfig.core.Config;
import backported.updates.foundation.nightconfig.core.conversion.AbstractConvertedConfig;
import backported.updates.foundation.nightconfig.core.conversion.ConversionTable;
import backported.updates.foundation.nightconfig.core.utils.TransformingSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public final class ConvertedConfig
extends AbstractConvertedConfig<Config> {
    public ConvertedConfig(Config config, ConversionTable readTable, ConversionTable writeTable, Predicate<Class<?>> supportPredicate) {
        this(config, readTable::convert, writeTable::convert, supportPredicate);
    }

    public ConvertedConfig(Config config, Function<Object, Object> readConversion, Function<Object, Object> writeConversion, Predicate<Class<?>> supportPredicate) {
        super(config, readConversion, writeConversion, supportPredicate);
    }

    @Override
    public Set<? extends Config.Entry> entrySet() {
        Function<Config.Entry, Config.Entry> readTransfo = entry -> new Config.Entry((Config.Entry)entry){
            final /* synthetic */ Config.Entry val$entry;
            {
                this.val$entry = entry;
            }

            public Object setValue(Object value) {
                return ConvertedConfig.this.readConversion.apply(this.val$entry.setValue(ConvertedConfig.this.writeConversion.apply(value)));
            }

            @Override
            public String getKey() {
                return this.val$entry.getKey();
            }

            @Override
            public <T> T getRawValue() {
                return (T)ConvertedConfig.this.readConversion.apply(this.val$entry.getRawValue());
            }
        };
        return new TransformingSet<Config.Entry, Config.Entry>(((Config)this.config).entrySet(), readTransfo, o -> null, e -> e);
    }
}

