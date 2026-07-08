/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2960
 *  net.minecraft.class_2975
 *  net.minecraft.class_5321
 *  net.minecraft.class_7924
 *  net.minecraft.class_8813
 */
package backported.updates.garden.feature.pale_oak_tree;

import java.util.Optional;
import net.minecraft.class_2960;
import net.minecraft.class_2975;
import net.minecraft.class_5321;
import net.minecraft.class_7924;
import net.minecraft.class_8813;

public class PaleOakSapling {
    public static final class_8813 PALE;
    public static final class_5321<class_2975<?, ?>> PALE_REGISTRY;

    static {
        PALE_REGISTRY = class_5321.method_29179((class_5321)class_7924.field_41239, (class_2960)class_2960.method_60655((String)"iwie", (String)"pale_tree"));
        PALE = new class_8813("pale_tree", Optional.of(PALE_REGISTRY), Optional.empty(), Optional.empty());
    }
}

