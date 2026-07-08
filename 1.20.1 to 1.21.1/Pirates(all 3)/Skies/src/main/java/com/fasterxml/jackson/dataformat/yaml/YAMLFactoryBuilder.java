/*
 * Decompiled with CFR 0.152.
 */
package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.TSFBuilder;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.util.StringQuotingChecker;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;

public class YAMLFactoryBuilder
extends TSFBuilder<YAMLFactory, YAMLFactoryBuilder> {
    protected int _formatGeneratorFeatures;
    protected StringQuotingChecker _quotingChecker;
    protected DumperOptions.Version _version;
    protected LoaderOptions _loaderOptions;
    protected DumperOptions _dumperOptions;

    protected YAMLFactoryBuilder() {
        this._formatGeneratorFeatures = YAMLFactory.DEFAULT_YAML_GENERATOR_FEATURE_FLAGS;
    }

    public YAMLFactoryBuilder(YAMLFactory base) {
        super(base);
        this._formatGeneratorFeatures = base._yamlGeneratorFeatures;
        this._version = base._version;
        this._quotingChecker = base._quotingChecker;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature f2) {
        this._formatGeneratorFeatures |= f2.getMask();
        return this;
    }

    public YAMLFactoryBuilder enable(YAMLGenerator.Feature first2, YAMLGenerator.Feature ... other) {
        this._formatGeneratorFeatures |= first2.getMask();
        for (YAMLGenerator.Feature f2 : other) {
            this._formatGeneratorFeatures |= f2.getMask();
        }
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature f2) {
        this._formatGeneratorFeatures &= ~f2.getMask();
        return this;
    }

    public YAMLFactoryBuilder disable(YAMLGenerator.Feature first2, YAMLGenerator.Feature ... other) {
        this._formatGeneratorFeatures &= ~first2.getMask();
        for (YAMLGenerator.Feature f2 : other) {
            this._formatGeneratorFeatures &= ~f2.getMask();
        }
        return this;
    }

    public YAMLFactoryBuilder configure(YAMLGenerator.Feature f2, boolean state) {
        return state ? this.enable(f2) : this.disable(f2);
    }

    public YAMLFactoryBuilder stringQuotingChecker(StringQuotingChecker sqc) {
        this._quotingChecker = sqc;
        return this;
    }

    public YAMLFactoryBuilder yamlVersionToWrite(DumperOptions.Version v) {
        this._version = v;
        return this;
    }

    public YAMLFactoryBuilder loaderOptions(LoaderOptions loaderOptions) {
        this._loaderOptions = loaderOptions;
        return this;
    }

    public YAMLFactoryBuilder dumperOptions(DumperOptions dumperOptions) {
        this._dumperOptions = dumperOptions;
        return this;
    }

    public int formatGeneratorFeaturesMask() {
        return this._formatGeneratorFeatures;
    }

    public DumperOptions.Version yamlVersionToWrite() {
        return this._version;
    }

    public StringQuotingChecker stringQuotingChecker() {
        if (this._quotingChecker != null) {
            return this._quotingChecker;
        }
        return StringQuotingChecker.Default.instance();
    }

    public LoaderOptions loaderOptions() {
        return this._loaderOptions;
    }

    public DumperOptions dumperOptions() {
        return this._dumperOptions;
    }

    @Override
    public YAMLFactory build() {
        return new YAMLFactory(this);
    }
}

