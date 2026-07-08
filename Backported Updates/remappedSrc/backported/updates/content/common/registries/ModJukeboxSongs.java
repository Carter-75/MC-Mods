/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_2561
 *  net.minecraft.class_2960
 *  net.minecraft.class_3414
 *  net.minecraft.class_5321
 *  net.minecraft.class_6880
 *  net.minecraft.class_7891
 *  net.minecraft.class_7924
 *  net.minecraft.class_9793
 */
package backported.updates.content.common.registries;

import backported.updates.content.client.registries.ModSoundEvents;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_3414;
import net.minecraft.class_5321;
import net.minecraft.class_6880;
import net.minecraft.class_7891;
import net.minecraft.class_7924;
import net.minecraft.class_9793;

public class ModJukeboxSongs {
    public static final class_5321<class_9793> TEARS = ModJukeboxSongs.create("tears");
    public static final class_5321<class_9793> LAVA_CHICKEN = ModJukeboxSongs.create("lava_chicken");

    public static void bootstrap(class_7891<class_9793> context) {
        ModJukeboxSongs.register(context, TEARS, ModSoundEvents.MUSIC_DISC_TEARS.get(), 175, 10);
        ModJukeboxSongs.register(context, LAVA_CHICKEN, ModSoundEvents.MUSIC_DISC_LAVA_CHICKEN.get(), 134, 9);
    }

    private static void register(class_7891<class_9793> context, class_5321<class_9793> key, class_3414 soundEvent, int lengthInSeconds, int comparatorOutput) {
        context.method_46838(key, (Object)new class_9793(class_6880.method_40223((Object)soundEvent), (class_2561)class_2561.method_43471((String)class_156.method_646((String)"jukebox_song", (class_2960)key.method_29177())), (float)lengthInSeconds, comparatorOutput));
    }

    private static class_5321<class_9793> create(String name) {
        return class_5321.method_29179((class_5321)class_7924.field_52176, (class_2960)class_2960.method_60656((String)name));
    }
}

