/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1959
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package tech.alexnijjar.golemoverhaul.common.tags;

import net.minecraft.class_1959;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;

public class ModBiomeTags {
    public static final class_6862<class_1959> COAL_GOLEM_SPAWNS = ModBiomeTags.tag("coal_golem_spawns");
    public static final class_6862<class_1959> HONEY_GOLEM_SPAWNS = ModBiomeTags.tag("honey_golem_spawns");
    public static final class_6862<class_1959> SLIME_GOLEM_SPAWNS = ModBiomeTags.tag("slime_golem_spawns");
    public static final class_6862<class_1959> SLIME_GOLEM_SWAMP_SPAWNS = ModBiomeTags.tag("slime_golem_swamp_spawns");
    public static final class_6862<class_1959> TERRACOTTA_GOLEM_SPAWNS = ModBiomeTags.tag("terracotta_golem_spawns");

    private static class_6862<class_1959> tag(String name) {
        return class_6862.method_40092((class_5321)class_7924.field_41236, (class_2960)GolemOverhaul.asResource(name));
    }
}

