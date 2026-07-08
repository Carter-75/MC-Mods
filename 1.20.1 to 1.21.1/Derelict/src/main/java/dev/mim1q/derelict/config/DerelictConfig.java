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
import dev.mim1q.derelict.config.DerelictConfigModel;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import java.util.function.Consumer;

public class DerelictConfig
extends ConfigWrapper<DerelictConfigModel> {
    public final Keys keys = new Keys();
    private final Option<DerelictConfigModel.FlickeringLightsSetting> flickeringLights;
    private final Option<Float> spiderlingSpawnChance;
    private final Option<String> arachneEggAdvancement;
    private final Option<Integer> arachneEggRespawnTime;

    private DerelictConfig() {
        super(DerelictConfigModel.class);
        this.flickeringLights = this.optionForKey(this.keys.flickeringLights);
        this.spiderlingSpawnChance = this.optionForKey(this.keys.spiderlingSpawnChance);
        this.arachneEggAdvancement = this.optionForKey(this.keys.arachneEggAdvancement);
        this.arachneEggRespawnTime = this.optionForKey(this.keys.arachneEggRespawnTime);
    }

    private DerelictConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(DerelictConfigModel.class, janksonBuilder);
        this.flickeringLights = this.optionForKey(this.keys.flickeringLights);
        this.spiderlingSpawnChance = this.optionForKey(this.keys.spiderlingSpawnChance);
        this.arachneEggAdvancement = this.optionForKey(this.keys.arachneEggAdvancement);
        this.arachneEggRespawnTime = this.optionForKey(this.keys.arachneEggRespawnTime);
    }

    public static DerelictConfig createAndLoad() {
        DerelictConfig wrapper = new DerelictConfig();
        wrapper.load();
        return wrapper;
    }

    public static DerelictConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        DerelictConfig wrapper = new DerelictConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public DerelictConfigModel.FlickeringLightsSetting flickeringLights() {
        return (DerelictConfigModel.FlickeringLightsSetting)((Object)this.flickeringLights.value());
    }

    public void flickeringLights(DerelictConfigModel.FlickeringLightsSetting value) {
        this.flickeringLights.set((Object)value);
    }

    public float spiderlingSpawnChance() {
        return ((Float)this.spiderlingSpawnChance.value()).floatValue();
    }

    public void spiderlingSpawnChance(float value) {
        this.spiderlingSpawnChance.set((Object)Float.valueOf(value));
    }

    public String arachneEggAdvancement() {
        return (String)this.arachneEggAdvancement.value();
    }

    public void arachneEggAdvancement(String value) {
        this.arachneEggAdvancement.set((Object)value);
    }

    public int arachneEggRespawnTime() {
        return (Integer)this.arachneEggRespawnTime.value();
    }

    public void arachneEggRespawnTime(int value) {
        this.arachneEggRespawnTime.set((Object)value);
    }

    public static class Keys {
        public final Option.Key flickeringLights = new Option.Key("flickeringLights");
        public final Option.Key spiderlingSpawnChance = new Option.Key("spiderlingSpawnChance");
        public final Option.Key arachneEggAdvancement = new Option.Key("arachneEggAdvancement");
        public final Option.Key arachneEggRespawnTime = new Option.Key("arachneEggRespawnTime");
    }
}

