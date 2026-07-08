/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.util.Pair
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package backported.updates.foundation.core.util.config;

import backported.updates.foundation.core.events.ConfigEvents;
import backported.updates.foundation.core.networking.packet.ClientboundConfigSyncPayload;
import backported.updates.foundation.core.util.config.ModConfig;
import backported.updates.foundation.nightconfig.core.CommentedConfig;
import backported.updates.foundation.nightconfig.core.file.CommentedFileConfig;
import backported.updates.foundation.nightconfig.toml.TomlFormat;
import com.mojang.datafixers.util.Pair;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.EnumMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigTracker {
    public static final ConfigTracker INSTANCE = new ConfigTracker();
    public static final Logger LOGGER = LogManager.getLogger();
    private final ConcurrentHashMap<String, ModConfig> fileMap = new ConcurrentHashMap();
    private final EnumMap<ModConfig.Type, Set<ModConfig>> configSets = new EnumMap(ModConfig.Type.class);
    private final ConcurrentHashMap<String, Map<ModConfig.Type, ModConfig>> configsByMod = new ConcurrentHashMap();

    private ConfigTracker() {
        for (ModConfig.Type type : ModConfig.Type.values()) {
            this.configSets.put(type, Collections.synchronizedSet(new LinkedHashSet()));
        }
    }

    void trackConfig(ModConfig config) {
        if (this.fileMap.containsKey(config.getFileName())) {
            LOGGER.error("Detected config file conflict {} between {} and {}", (Object)config.getFileName(), (Object)this.fileMap.get(config.getFileName()).getModId(), (Object)config.getModId());
            throw new RuntimeException("Config conflict detected!");
        }
        this.fileMap.put(config.getFileName(), config);
        this.configSets.get((Object)config.getType()).add(config);
        this.configsByMod.computeIfAbsent(config.getModId(), k -> new EnumMap(ModConfig.Type.class)).put(config.getType(), config);
        LOGGER.debug("Config file {} for {} tracking", (Object)config.getFileName(), (Object)config.getModId());
    }

    public void loadConfigs(ModConfig.Type type, Path configBasePath) {
        LOGGER.debug("Loading configs type {}", (Object)type);
        this.configSets.get((Object)type).forEach(config -> this.openConfig((ModConfig)config, configBasePath));
    }

    public void unloadConfigs(ModConfig.Type type, Path configBasePath) {
        LOGGER.debug("Unloading configs type {}", (Object)type);
        this.configSets.get((Object)type).forEach(config -> this.closeConfig((ModConfig)config, configBasePath));
    }

    public List<Pair<String, ClientboundConfigSyncPayload>> syncConfigs(boolean isLocal) {
        return isLocal ? Collections.emptyList() : this.configSets.get((Object)ModConfig.Type.SERVER).stream().filter(mc -> mc.getFullPath() != null).map(mc -> {
            try {
                return Pair.of((Object)("Config " + mc.getFileName()), (Object)new ClientboundConfigSyncPayload(mc.getFileName(), Files.readAllBytes(mc.getFullPath())));
            }
            catch (Exception exception) {
                LOGGER.error("Failed to sync {} config for {}", (Object)mc.getType(), (Object)mc.getModId(), (Object)exception);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private void openConfig(ModConfig config, Path configBasePath) {
        LOGGER.trace("Loading config file type {} at {} for {}", (Object)config.getType(), (Object)config.getFileName(), (Object)config.getModId());
        CommentedFileConfig configData = config.getHandler().reader(configBasePath).apply(config);
        config.setConfigData(configData);
        ConfigEvents.LOADING.invoker().onModConfig(config);
        config.save();
    }

    private void closeConfig(ModConfig config, Path configBasePath) {
        if (config.getConfigData() != null) {
            config.save();
            config.getHandler().unload(configBasePath, config);
            config.setConfigData(null);
        }
    }

    public void receiveSyncedConfig(ClientboundConfigSyncPayload payload) {
        if (this.fileMap.containsKey(payload.name())) {
            ModConfig config = this.fileMap.get(payload.name());
            config.setConfigData((CommentedConfig)TomlFormat.instance().createParser().parse(new ByteArrayInputStream(payload.data())));
            ConfigEvents.RELOADING.invoker().onModConfig(config);
        }
    }

    public void loadDefaultServerConfigs() {
        this.configSets.get((Object)ModConfig.Type.SERVER).forEach(config -> {
            CommentedConfig commentedConfig = CommentedConfig.inMemory();
            config.getSpec().correct(commentedConfig);
            config.setConfigData(commentedConfig);
            ConfigEvents.LOADING.invoker().onModConfig((ModConfig)config);
        });
    }

    public String getConfigFileName(String modId, ModConfig.Type type) {
        return Optional.ofNullable(this.configsByMod.getOrDefault(modId, Collections.emptyMap()).getOrDefault((Object)type, null)).flatMap(config -> Optional.ofNullable(config.getFullPath())).map(Object::toString).orElse(null);
    }

    public Optional<ModConfig> getConfig(String modId, ModConfig.Type type) {
        return Optional.ofNullable(this.configsByMod.getOrDefault(modId, Collections.emptyMap()).getOrDefault((Object)type, null));
    }
}

