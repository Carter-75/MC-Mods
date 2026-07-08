/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1799
 *  org.jetbrains.annotations.NotNull
 */
package tech.alexnijjar.golemoverhaul.common.entities;

import java.util.Collections;
import java.util.List;
import net.minecraft.class_1799;
import org.jetbrains.annotations.NotNull;

public interface IShearable {
    default public boolean isShearable() {
        return true;
    }

    @NotNull
    default public List<class_1799> onSheared() {
        return Collections.emptyList();
    }
}

