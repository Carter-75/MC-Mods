/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.Nullable
 */
package tech.alexnijjar.golemoverhaul.common.entities;

import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public interface AdditionalBeeData {
    @Nullable
    public UUID golemoverhaul$getOwner();

    public void golemoverhaul$setOwner(UUID var1);

    public boolean golemoverhaul$hasGolemHive();
}

