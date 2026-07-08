/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  blue.endless.jankson.Jankson$Builder
 *  io.wispforest.owo.config.ConfigWrapper
 *  io.wispforest.owo.config.Option
 *  io.wispforest.owo.config.Option$Key
 */
package dev.mim1q.derelict.config;

import blue.endless.jankson.Jankson;
import dev.mim1q.derelict.config.DerelictClientConfigModel;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import java.util.function.Consumer;

public class DerelictClientConfig
extends ConfigWrapper<DerelictClientConfigModel> {
    public final Keys keys = new Keys();
    private final Option<Float> waxedIndicatorOpacity;
    private final Option<Float> waxedIndicatorScale;
    private final Option<Boolean> waxableHighlights;
    private final Option<Boolean> ageableHighlights;
    private final Option<Integer> waxableAndAgeableHightlightRange;
    private final Option<Boolean> waxableCrosshairTip;
    private final Option<Boolean> ageableCrosshairTip;

    private DerelictClientConfig() {
        super(DerelictClientConfigModel.class);
        this.waxedIndicatorOpacity = this.optionForKey(this.keys.waxedIndicatorOpacity);
        this.waxedIndicatorScale = this.optionForKey(this.keys.waxedIndicatorScale);
        this.waxableHighlights = this.optionForKey(this.keys.waxableHighlights);
        this.ageableHighlights = this.optionForKey(this.keys.ageableHighlights);
        this.waxableAndAgeableHightlightRange = this.optionForKey(this.keys.waxableAndAgeableHightlightRange);
        this.waxableCrosshairTip = this.optionForKey(this.keys.waxableCrosshairTip);
        this.ageableCrosshairTip = this.optionForKey(this.keys.ageableCrosshairTip);
    }

    private DerelictClientConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(DerelictClientConfigModel.class, janksonBuilder);
        this.waxedIndicatorOpacity = this.optionForKey(this.keys.waxedIndicatorOpacity);
        this.waxedIndicatorScale = this.optionForKey(this.keys.waxedIndicatorScale);
        this.waxableHighlights = this.optionForKey(this.keys.waxableHighlights);
        this.ageableHighlights = this.optionForKey(this.keys.ageableHighlights);
        this.waxableAndAgeableHightlightRange = this.optionForKey(this.keys.waxableAndAgeableHightlightRange);
        this.waxableCrosshairTip = this.optionForKey(this.keys.waxableCrosshairTip);
        this.ageableCrosshairTip = this.optionForKey(this.keys.ageableCrosshairTip);
    }

    public static DerelictClientConfig createAndLoad() {
        DerelictClientConfig wrapper = new DerelictClientConfig();
        wrapper.load();
        return wrapper;
    }

    public static DerelictClientConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        DerelictClientConfig wrapper = new DerelictClientConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public float waxedIndicatorOpacity() {
        return ((Float)this.waxedIndicatorOpacity.value()).floatValue();
    }

    public void waxedIndicatorOpacity(float value) {
        this.waxedIndicatorOpacity.set((Object)Float.valueOf(value));
    }

    public float waxedIndicatorScale() {
        return ((Float)this.waxedIndicatorScale.value()).floatValue();
    }

    public void waxedIndicatorScale(float value) {
        this.waxedIndicatorScale.set((Object)Float.valueOf(value));
    }

    public boolean waxableHighlights() {
        return (Boolean)this.waxableHighlights.value();
    }

    public void waxableHighlights(boolean value) {
        this.waxableHighlights.set((Object)value);
    }

    public boolean ageableHighlights() {
        return (Boolean)this.ageableHighlights.value();
    }

    public void ageableHighlights(boolean value) {
        this.ageableHighlights.set((Object)value);
    }

    public int waxableAndAgeableHightlightRange() {
        return (Integer)this.waxableAndAgeableHightlightRange.value();
    }

    public void waxableAndAgeableHightlightRange(int value) {
        this.waxableAndAgeableHightlightRange.set((Object)value);
    }

    public boolean waxableCrosshairTip() {
        return (Boolean)this.waxableCrosshairTip.value();
    }

    public void waxableCrosshairTip(boolean value) {
        this.waxableCrosshairTip.set((Object)value);
    }

    public boolean ageableCrosshairTip() {
        return (Boolean)this.ageableCrosshairTip.value();
    }

    public void ageableCrosshairTip(boolean value) {
        this.ageableCrosshairTip.set((Object)value);
    }

    public static class Keys {
        public final Option.Key waxedIndicatorOpacity = new Option.Key("waxedIndicatorOpacity");
        public final Option.Key waxedIndicatorScale = new Option.Key("waxedIndicatorScale");
        public final Option.Key waxableHighlights = new Option.Key("waxableHighlights");
        public final Option.Key ageableHighlights = new Option.Key("ageableHighlights");
        public final Option.Key waxableAndAgeableHightlightRange = new Option.Key("waxableAndAgeableHightlightRange");
        public final Option.Key waxableCrosshairTip = new Option.Key("waxableCrosshairTip");
        public final Option.Key ageableCrosshairTip = new Option.Key("ageableCrosshairTip");
    }
}

