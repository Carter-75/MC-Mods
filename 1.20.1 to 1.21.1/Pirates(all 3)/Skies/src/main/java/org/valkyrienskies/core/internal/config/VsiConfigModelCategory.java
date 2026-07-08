/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package org.valkyrienskies.core.internal.config;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.internal.config.VsiConfigModelEntry;
import org.valkyrienskies.core.internal.config.VsiConfigNode;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH&\u00a2\u0006\u0004\b\n\u0010\u000bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0013\u00c0\u0006\u0001"}, d2={"Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;", "Lorg/valkyrienskies/core/internal/config/VsiConfigNode;", "cat", "", "addCategory", "(Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;)V", "", "name", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;", "entry", "addEntry", "(Ljava/lang/String;Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;)V", "", "getChildren", "()Ljava/util/Map;", "children", "getTitle", "()Ljava/lang/String;", "title", "internal"})
public interface VsiConfigModelCategory
extends VsiConfigNode {
    @NotNull
    public String getTitle();

    @NotNull
    public Map<String, VsiConfigNode> getChildren();

    public void addEntry(@NotNull String var1, @NotNull VsiConfigModelEntry<?> var2);

    public void addCategory(@NotNull VsiConfigModelCategory var1);
}

