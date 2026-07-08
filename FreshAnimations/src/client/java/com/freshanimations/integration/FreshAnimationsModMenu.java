package com.freshanimations.integration;

import com.freshanimations.FreshAnimationsClient;
import com.freshanimations.config.FreshAnimationsConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.Map;

public class FreshAnimationsModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                    .setParentScreen(parent)
                    .setTitle(Text.of("Fresh Animations Config"));

            ConfigCategory general = builder.getOrCreateCategory(Text.of("Packs"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // We iterate safely over a copy or directly if acceptable
            for (String packId : FreshAnimationsConfig.PACK_TOGGLES.keySet()) {
                boolean currentValue = FreshAnimationsConfig.PACK_TOGGLES.get(packId);

                general.addEntry(entryBuilder.startBooleanToggle(Text.of(packId), currentValue)
                        .setDefaultValue(false)
                        .setSaveConsumer(newValue -> FreshAnimationsConfig.PACK_TOGGLES.put(packId, newValue))
                        .build());
            }

            builder.setSavingRunnable(() -> {
                FreshAnimationsConfig.save();
                if (MinecraftClient.getInstance() != null) {
                    FreshAnimationsClient.syncConfig(MinecraftClient.getInstance());
                    MinecraftClient.getInstance().reloadResources();
                }
            });

            return builder.build();
        };
    }
}
