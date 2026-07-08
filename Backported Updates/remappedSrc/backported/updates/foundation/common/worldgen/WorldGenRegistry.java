/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2378
 *  net.minecraft.class_2960
 *  net.minecraft.class_2975
 *  net.minecraft.class_3031
 *  net.minecraft.class_3037
 *  net.minecraft.class_3111
 *  net.minecraft.class_5216$class_5487
 *  net.minecraft.class_5321
 *  net.minecraft.class_6796
 *  net.minecraft.class_6797
 *  net.minecraft.class_6880
 *  net.minecraft.class_7891
 */
package backported.updates.foundation.common.worldgen;

import java.util.List;
import net.minecraft.class_2378;
import net.minecraft.class_2960;
import net.minecraft.class_2975;
import net.minecraft.class_3031;
import net.minecraft.class_3037;
import net.minecraft.class_3111;
import net.minecraft.class_5216;
import net.minecraft.class_5321;
import net.minecraft.class_6796;
import net.minecraft.class_6797;
import net.minecraft.class_6880;
import net.minecraft.class_7891;

public class WorldGenRegistry<T> {
    protected final String modId;
    protected final class_5321<? extends class_2378<T>> registry;

    private WorldGenRegistry(class_5321<? extends class_2378<T>> registry, String modId) {
        this.registry = registry;
        this.modId = modId;
    }

    public static <T> WorldGenRegistry<T> of(class_5321<? extends class_2378<T>> registry, String modId) {
        return new WorldGenRegistry<T>(registry, modId);
    }

    public class_5321<T> create(String name) {
        return class_5321.method_29179(this.registry, (class_2960)class_2960.method_60655((String)this.modId, (String)name));
    }

    public void register(class_7891<T> context, class_5321<T> key, T entry) {
        context.method_46838(key, entry);
    }

    public <FC extends class_3037, F extends class_3031<FC>> void register(class_7891<class_2975<?, ?>> context, class_5321<class_2975<?, ?>> key, F feature, FC configuration) {
        context.method_46838(key, (Object)new class_2975(feature, configuration));
    }

    public void register(class_7891<class_2975<?, ?>> context, class_5321<class_2975<?, ?>> key, class_3031<class_3111> feature) {
        this.register(context, key, feature, class_3037.field_13603);
    }

    public void register(class_7891<class_6796> context, class_5321<class_6796> key, class_6880<class_2975<?, ?>> feature, List<class_6797> placements) {
        context.method_46838(key, (Object)new class_6796(feature, List.copyOf(placements)));
    }

    public void register(class_7891<class_6796> context, class_5321<class_6796> key, class_6880<class_2975<?, ?>> feature, class_6797 ... placements) {
        this.register(context, key, feature, List.of(placements));
    }

    public void register(class_7891<class_5216.class_5487> context, class_5321<class_5216.class_5487> key, int firstOctave, double firstAmplitude, double ... amplitudes) {
        context.method_46838(key, (Object)new class_5216.class_5487(firstOctave, firstAmplitude, amplitudes));
    }

    public void register() {
    }
}

