/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  net.minecraft.class_1299
 *  net.minecraft.class_1311
 *  net.minecraft.class_1959
 *  net.minecraft.class_5321
 *  net.minecraft.class_5483
 *  net.minecraft.class_6796
 *  net.minecraft.class_6862
 *  net.minecraft.class_8197$class_5305
 */
package backported.updates.foundation.common.worldgen.modifier;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import net.minecraft.class_1299;
import net.minecraft.class_1311;
import net.minecraft.class_1959;
import net.minecraft.class_5321;
import net.minecraft.class_5483;
import net.minecraft.class_6796;
import net.minecraft.class_6862;
import net.minecraft.class_8197;

public interface BiomeContext {
    public static final Predicate<BiomeContext> OVERWORLD_BIOME = context -> class_8197.class_5305.field_34499.method_49514().anyMatch(context::is);

    public class_5321<class_1959> resource();

    public class_1959 biome();

    public boolean is(class_6862<class_1959> var1);

    public boolean is(class_5321<class_1959> var1);

    public boolean is(Predicate<BiomeContext> var1);

    public boolean hasFeature(class_5321<class_6796> var1);

    default public boolean hasEntity(Supplier<class_1299<?>> entities) {
        return this.hasEntity((Set<Supplier<class_1299<?>>>)ImmutableSet.of(entities));
    }

    default public boolean hasEntity(Set<Supplier<class_1299<?>>> entitySet) {
        Set entities = entitySet.stream().map(Supplier::get).collect(Collectors.toSet());
        class_5483 settings = this.biome().method_30966();
        return Arrays.stream(class_1311.values()).flatMap(category -> settings.method_31004(category).method_34994().stream()).anyMatch(spawner -> entities.contains(spawner.field_9389));
    }
}

