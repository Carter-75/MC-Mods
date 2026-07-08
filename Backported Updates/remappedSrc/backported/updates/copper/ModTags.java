/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2248
 *  net.minecraft.class_2960
 *  net.minecraft.class_5321
 *  net.minecraft.class_6862
 *  net.minecraft.class_7924
 */
package backported.updates.copper;

import net.minecraft.class_2248;
import net.minecraft.class_2960;
import net.minecraft.class_5321;
import net.minecraft.class_6862;
import net.minecraft.class_7924;

public class ModTags {

    public static class Blocks {
        public static final class_6862<class_2248> COPPER = Blocks.tag("copper");
        public static final class_6862<class_2248> COPPER_CHESTS = Blocks.tag("copper_chests");
        public static final class_6862<class_2248> WOODEN_SHELVES = Blocks.tag("wooden_shelves");

        private static class_6862<class_2248> tag(String name) {
            return class_6862.method_40092((class_5321)class_7924.field_41254, (class_2960)class_2960.method_60655((String)"copperagebackport", (String)name));
        }
    }
}

