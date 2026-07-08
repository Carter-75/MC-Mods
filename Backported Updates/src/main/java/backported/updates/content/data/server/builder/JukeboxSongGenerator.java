/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
 *  net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider$Entries
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.RegistryWrapper$Impl
 *  net.minecraft.registry.RegistryWrapper$WrapperLookup
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.block.jukebox.JukeboxSong
 */
package backported.updates.content.data.server.builder;

import backported.updates.content.common.registries.ModJukeboxSongs;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.block.jukebox.JukeboxSong;

public class JukeboxSongGenerator
extends FabricDynamicRegistryProvider {
    public JukeboxSongGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    protected void configure(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries) {
        this.add(provider, entries, ModJukeboxSongs.TEARS);
        this.add(provider, entries, ModJukeboxSongs.LAVA_CHICKEN);
    }

    private void add(RegistryWrapper.WrapperLookup provider, FabricDynamicRegistryProvider.Entries entries, RegistryKey<JukeboxSong> key) {
        RegistryWrapper.Impl registry = provider.getWrapperOrThrow(RegistryKeys.JUKEBOX_SONG);
        entries.add(key, ((JukeboxSong)registry.getOrThrow(key).value()));
    }

    public String getName() {
        return "jukebox_songs";
    }
}

