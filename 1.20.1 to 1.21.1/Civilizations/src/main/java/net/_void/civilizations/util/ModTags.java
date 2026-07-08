/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package net._void.civilizations.util;

import net.minecraft.class_1792;
import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public class ModTags {

    public static class Items {
        private static class_6862<class_1792> createTag(String name) {
            return class_6862.method_40092((class_5321)class_7924.field_41197, (class_2960)new class_2960("civilizations", name));
        }
    }

    public static class Blocks {
        public static final class_6862<class_2248> EGYPT_KEY_OPENABLE = Blocks.createTag("egypt_key_openable");

        private static class_6862<class_2248> createTag(String name) {
            return class_6862.method_40092((class_5321)class_7924.field_41254, (class_2960)new class_2960("civilizations", name));
        }
    }
}

