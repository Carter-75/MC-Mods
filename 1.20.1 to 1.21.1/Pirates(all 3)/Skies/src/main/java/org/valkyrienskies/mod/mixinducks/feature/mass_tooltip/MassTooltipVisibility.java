/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1836
 */
package org.valkyrienskies.mod.mixinducks.feature.mass_tooltip;

import net.minecraft.class_1836;

public enum MassTooltipVisibility {
    ALWAYS,
    ADVANCED,
    DISABLED;


    public boolean isVisible(class_1836 flag) {
        return this.equals((Object)ALWAYS) || this.equals((Object)ADVANCED) && flag.method_8035();
    }
}

