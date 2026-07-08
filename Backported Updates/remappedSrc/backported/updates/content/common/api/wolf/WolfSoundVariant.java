/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.datafixers.kinds.App
 *  com.mojang.datafixers.kinds.Applicative
 *  com.mojang.serialization.Codec
 *  com.mojang.serialization.codecs.RecordCodecBuilder
 *  net.minecraft.class_3414
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 *  net.minecraft.class_9129
 *  net.minecraft.class_9135
 *  net.minecraft.class_9139
 */
package backported.updates.content.common.api.wolf;

import backported.updates.content.core.registries.ModRegistries;
import com.mojang.datafixers.kinds.App;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.class_3414;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import net.minecraft.class_9129;
import net.minecraft.class_9135;
import net.minecraft.class_9139;

public record WolfSoundVariant(class_6880<class_3414> ambientSound, class_6880<class_3414> deathSound, class_6880<class_3414> growlSound, class_6880<class_3414> hurtSound, class_6880<class_3414> pantSound, class_6880<class_3414> whineSound) {
    public static final class_9139<class_9129, WolfSoundVariant> STREAM_CODEC = class_9135.method_56365(ModRegistries.WOLF_SOUND_VARIANT_KEY);
    public static final Codec<WolfSoundVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group((App)class_7923.field_41172.method_40294().fieldOf("ambient_sound").forGetter(WolfSoundVariant::ambientSound), (App)class_7923.field_41172.method_40294().fieldOf("death_sound").forGetter(WolfSoundVariant::deathSound), (App)class_7923.field_41172.method_40294().fieldOf("growl_sound").forGetter(WolfSoundVariant::growlSound), (App)class_7923.field_41172.method_40294().fieldOf("hurt_sound").forGetter(WolfSoundVariant::hurtSound), (App)class_7923.field_41172.method_40294().fieldOf("pant_sound").forGetter(WolfSoundVariant::pantSound), (App)class_7923.field_41172.method_40294().fieldOf("whine_sound").forGetter(WolfSoundVariant::whineSound)).apply((Applicative)instance, WolfSoundVariant::new));

    public WolfSoundVariant(class_3414 ambientSound, class_3414 deathSound, class_3414 growlSound, class_3414 hurtSound, class_3414 pantSound, class_3414 whineSound) {
        this((class_6880<class_3414>)class_6880.method_40223((Object)ambientSound), (class_6880<class_3414>)class_6880.method_40223((Object)deathSound), (class_6880<class_3414>)class_6880.method_40223((Object)growlSound), (class_6880<class_3414>)class_6880.method_40223((Object)hurtSound), (class_6880<class_3414>)class_6880.method_40223((Object)pantSound), (class_6880<class_3414>)class_6880.method_40223((Object)whineSound));
    }
}

