package com.packsmod.integration;

import com.packsmod.PacksModClient;
import com.packsmod.config.PacksModConfig;
import com.packsmod.packs.PackCategory;
import com.packsmod.packs.PackDefinition;
import com.packsmod.packs.PackRegistry;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class PacksModModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            PacksModConfig config = PacksModConfig.load();
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.of("PacksMod Configuration"));

            builder.setSavingRunnable(() -> {
                PacksModConfig.save(config);
                PacksModClient.syncConfig(MinecraftClient.getInstance());
            });

            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // General Category (Selectors)
            ConfigCategory general = builder.getOrCreateCategory(Text.of("General"));

            general.addEntry(entryBuilder
                    .startEnumSelector(Text.of("Font Selection"), PacksModConfig.FontSelection.class,
                            config.fontSelection)
                    .setDefaultValue(PacksModConfig.FontSelection.OFF)
                    .setSaveConsumer(newValue -> config.fontSelection = newValue)
                    .build());

            general.addEntry(entryBuilder
                    .startEnumSelector(Text.of("Armor Selection"), PacksModConfig.ArmorSelection.class,
                            config.armorSelection)
                    .setDefaultValue(PacksModConfig.ArmorSelection.OFF)
                    .setSaveConsumer(newValue -> config.armorSelection = newValue)
                    .build());

            // Resource Packs Category
            ConfigCategory packs = builder.getOrCreateCategory(Text.of("Resource Packs"));

            for (String key : PackRegistry.orderedKeys()) {
                PackDefinition pack = PackRegistry.find(key).orElse(null);
                // Filter for generic RESOURCE packs (exclude Armor/Font/Shaders)
                if (pack != null && pack.category() == PackCategory.RESOURCE) {
                    boolean current = config.packToggles.getOrDefault(key, true);
                    packs.addEntry(entryBuilder.startBooleanToggle(Text.of(pack.displayName()), current)
                            .setDefaultValue(true)
                            .setSaveConsumer(newValue -> config.packToggles.put(key, newValue))
                            .build());
                }
            }

            // Shader Packs Category
            ConfigCategory shaders = builder.getOrCreateCategory(Text.of("Shader Packs"));
            for (String key : PackRegistry.orderedKeys()) {
                PackDefinition pack = PackRegistry.find(key).orElse(null);
                if (pack != null && pack.isShaderPack()) {
                    boolean current = config.packToggles.getOrDefault(key, false);
                    shaders.addEntry(entryBuilder.startBooleanToggle(Text.of(pack.displayName()), current)
                            .setDefaultValue(false)
                            .setSaveConsumer(newValue -> config.packToggles.put(key, newValue))
                            .build());
                }
            }

            return builder.build();
        };
    }
}
