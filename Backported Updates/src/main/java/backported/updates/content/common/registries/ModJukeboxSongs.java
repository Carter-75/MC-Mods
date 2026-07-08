/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.Util
 *  net.minecraft.text.Text
 *  net.minecraft.util.Identifier
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.registry.RegistryKey
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registerable
 *  net.minecraft.registry.RegistryKeys
 *  net.minecraft.block.jukebox.JukeboxSong
 */
package backported.updates.content.common.registries;

import backported.updates.content.client.registries.ModSoundEvents;
import net.minecraft.util.Util;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.sound.SoundEvent;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.block.jukebox.JukeboxSong;

public class ModJukeboxSongs {
    public static final RegistryKey<JukeboxSong> TEARS = ModJukeboxSongs.create("tears");
    public static final RegistryKey<JukeboxSong> LAVA_CHICKEN = ModJukeboxSongs.create("lava_chicken");

    public static void bootstrap(Registerable<JukeboxSong> context) {
        ModJukeboxSongs.register(context, TEARS, ModSoundEvents.MUSIC_DISC_TEARS.get(), 175, 10);
        ModJukeboxSongs.register(context, LAVA_CHICKEN, ModSoundEvents.MUSIC_DISC_LAVA_CHICKEN.get(), 134, 9);
    }

    private static void register(Registerable<JukeboxSong> context, RegistryKey<JukeboxSong> key, SoundEvent soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.register(key, new JukeboxSong(RegistryEntry.of(soundEvent), (Text)Text.translatable((String)Util.createTranslationKey((String)"jukebox_song", key.getValue())), (float)lengthInSeconds, comparatorOutput));
    }

    private static RegistryKey<JukeboxSong> create(String name) {
        return RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.ofVanilla((String)name));
    }
}

