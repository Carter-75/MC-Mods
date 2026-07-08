/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_247
 *  net.minecraft.class_259
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3726
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 */
package org.valkyrienskies.mod.compat.tis3d;

import net.minecraft.class_1297;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_247;
import net.minecraft.class_259;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3726;
import net.minecraft.class_3959;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Tis3dClipContext
extends class_3959 {
    private final class_3726 collisionContext;

    public Tis3dClipContext(class_243 arg, class_243 arg2, class_3959.class_3960 arg3, class_3959.class_242 arg4, @Nullable class_1297 arg5) {
        super(arg, arg2, arg3, arg4, arg5);
        this.collisionContext = arg5 == null ? class_3726.method_16194() : class_3726.method_16195((class_1297)arg5);
    }

    @NotNull
    public class_265 method_17748(@NotNull class_2680 bs, @NotNull class_1922 bg2, @NotNull class_2338 bp) {
        class_265 collider = class_3959.class_3960.field_17558.get(bs, bg2, bp, this.collisionContext);
        class_265 visual = class_3959.class_3960.field_23142.get(bs, bg2, bp, this.collisionContext);
        return class_259.method_1072((class_265)collider, (class_265)visual, (class_247)class_247.field_16896);
    }
}

