/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

public class YAMLMapper
extends ObjectMapper {
    private static final long serialVersionUID = 1L;

    public YAMLMapper() {
        this(new YAMLFactory());
    }

    public YAMLMapper(YAMLFactory f2) {
        super(f2);
    }

    public YAMLMapper(YAMLMapper base) {
        super(base);
    }

    public static Builder builder() {
        return new Builder(new YAMLMapper());
    }

    public static Builder builder(YAMLFactory streamFactory) {
        return new Builder(new YAMLMapper(streamFactory));
    }

    @Override
    public YAMLMapper copy() {
        this._checkInvalidCopy(YAMLMapper.class);
        return new YAMLMapper(this);
    }

    public YAMLMapper configure(YAMLGenerator.Feature f2, boolean state) {
        return state ? this.enable(f2) : this.disable(f2);
    }

    public YAMLMapper configure(YAMLParser.Feature f2, boolean state) {
        return state ? this.enable(f2) : this.disable(f2);
    }

    public YAMLMapper enable(YAMLGenerator.Feature f2) {
        ((YAMLFactory)this._jsonFactory).enable(f2);
        return this;
    }

    public YAMLMapper enable(YAMLParser.Feature f2) {
        ((YAMLFactory)this._jsonFactory).enable(f2);
        return this;
    }

    public YAMLMapper disable(YAMLGenerator.Feature f2) {
        ((YAMLFactory)this._jsonFactory).disable(f2);
        return this;
    }

    public YAMLMapper disable(YAMLParser.Feature f2) {
        ((YAMLFactory)this._jsonFactory).disable(f2);
        return this;
    }

    @Override
    public final YAMLFactory getFactory() {
        return (YAMLFactory)this._jsonFactory;
    }

    public static class Builder
    extends MapperBuilder<YAMLMapper, Builder> {
        public Builder(YAMLMapper m2) {
            super(m2);
        }

        public Builder enable(YAMLParser.Feature ... features) {
            for (YAMLParser.Feature f2 : features) {
                ((YAMLMapper)this._mapper).enable(f2);
            }
            return this;
        }

        public Builder disable(YAMLParser.Feature ... features) {
            for (YAMLParser.Feature f2 : features) {
                ((YAMLMapper)this._mapper).disable(f2);
            }
            return this;
        }

        public Builder configure(YAMLParser.Feature f2, boolean state) {
            if (state) {
                ((YAMLMapper)this._mapper).enable(f2);
            } else {
                ((YAMLMapper)this._mapper).disable(f2);
            }
            return this;
        }

        public Builder enable(YAMLGenerator.Feature ... features) {
            for (YAMLGenerator.Feature f2 : features) {
                ((YAMLMapper)this._mapper).enable(f2);
            }
            return this;
        }

        public Builder disable(YAMLGenerator.Feature ... features) {
            for (YAMLGenerator.Feature f2 : features) {
                ((YAMLMapper)this._mapper).disable(f2);
            }
            return this;
        }

        public Builder configure(YAMLGenerator.Feature f2, boolean state) {
            if (state) {
                ((YAMLMapper)this._mapper).enable(f2);
            } else {
                ((YAMLMapper)this._mapper).disable(f2);
            }
            return this;
        }
    }
}

