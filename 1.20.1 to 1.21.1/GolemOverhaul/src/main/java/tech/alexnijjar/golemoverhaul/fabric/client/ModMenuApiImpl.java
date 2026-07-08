/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.teamresourceful.resourcefulconfig.client.ConfigScreen
 *  com.teamresourceful.resourcefulconfig.common.config.ResourcefulConfig
 *  com.terraformersmc.modmenu.api.ConfigScreenFactory
 *  com.terraformersmc.modmenu.api.ModMenuApi
 */
package tech.alexnijjar.golemoverhaul.fabric.client;

import com.teamresourceful.resourcefulconfig.client.ConfigScreen;
import com.teamresourceful.resourcefulconfig.common.config.ResourcefulConfig;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;
import tech.alexnijjar.golemoverhaul.common.config.GolemOverhaulConfig;

public class ModMenuApiImpl
implements ModMenuApi {
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ResourcefulConfig config = GolemOverhaul.CONFIGURATOR.getConfig(GolemOverhaulConfig.class);
            if (config == null) {
                return null;
            }
            return new ConfigScreen(parent, null, config);
        };
    }
}

