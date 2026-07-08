/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.sound.SoundEvent
 *  net.minecraft.registry.entry.RegistryEntry
 *  net.minecraft.registry.Registries
 *  net.minecraft.network.RegistryByteBuf
 *  net.minecraft.network.codec.PacketCodecs
 *  net.minecraft.network.codec.PacketCodec
 */
package backported.updates.content.common.api.wolf;

import backported.updates.content.core.registries.ModRegistries;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.sound.SoundEvent;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.Registries;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.codec.PacketCodec;

public record WolfSoundVariant(RegistryEntry<SoundEvent> ambientSound, RegistryEntry<SoundEvent> deathSound, RegistryEntry<SoundEvent> growlSound, RegistryEntry<SoundEvent> hurtSound, RegistryEntry<SoundEvent> pantSound, RegistryEntry<SoundEvent> whineSound) {
    public static final PacketCodec<RegistryByteBuf, WolfSoundVariant> STREAM_CODEC = PacketCodecs.registryValue(ModRegistries.WOLF_SOUND_VARIANT_KEY);
    public static final Codec<WolfSoundVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group(Registries.SOUND_EVENT.getEntryCodec().fieldOf("ambient_sound").forGetter(WolfSoundVariant::ambientSound), Registries.SOUND_EVENT.getEntryCodec().fieldOf("death_sound").forGetter(WolfSoundVariant::deathSound), Registries.SOUND_EVENT.getEntryCodec().fieldOf("growl_sound").forGetter(WolfSoundVariant::growlSound), Registries.SOUND_EVENT.getEntryCodec().fieldOf("hurt_sound").forGetter(WolfSoundVariant::hurtSound), Registries.SOUND_EVENT.getEntryCodec().fieldOf("pant_sound").forGetter(WolfSoundVariant::pantSound), Registries.SOUND_EVENT.getEntryCodec().fieldOf("whine_sound").forGetter(WolfSoundVariant::whineSound)).apply(instance, WolfSoundVariant::new));

    public WolfSoundVariant(SoundEvent ambientSound, SoundEvent deathSound, SoundEvent growlSound, SoundEvent hurtSound, SoundEvent pantSound, SoundEvent whineSound) {
        this((RegistryEntry<SoundEvent>)RegistryEntry.of(ambientSound), (RegistryEntry<SoundEvent>)RegistryEntry.of(deathSound), (RegistryEntry<SoundEvent>)RegistryEntry.of(growlSound), (RegistryEntry<SoundEvent>)RegistryEntry.of(hurtSound), (RegistryEntry<SoundEvent>)RegistryEntry.of(pantSound), (RegistryEntry<SoundEvent>)RegistryEntry.of(whineSound));
    }
}

