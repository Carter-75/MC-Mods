/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package tech.alexnijjar.golemoverhaul.common.tags;

import net.minecraft.class_1792;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;
import tech.alexnijjar.golemoverhaul.GolemOverhaul;

public class ModItemTags {
    public static final class_6862<class_1792> WAX = ModItemTags.tag("wax");
    public static final class_6862<class_1792> CACTUS = ModItemTags.tag("cactus");

    private static class_6862<class_1792> tag(String name) {
        return class_6862.method_40092((class_5321)class_7924.field_41197, (class_2960)GolemOverhaul.asResource(name));
    }
}

