/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1299
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package tech.alexnijjar.golemoverhaul.common.tags;

import net.minecraft.class_1299;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;

public class ModEntityTypeTags {
    public static final class_6862<class_1299<?>> HONEY_IMMUNE = ModEntityTypeTags.tag("honey_immune");

    private static class_6862<class_1299<?>> tag(String name) {
        return class_6862.method_40092((class_5321)class_7924.field_41266, (class_2960)GolemOverhaul.asResource(name));
    }
}

