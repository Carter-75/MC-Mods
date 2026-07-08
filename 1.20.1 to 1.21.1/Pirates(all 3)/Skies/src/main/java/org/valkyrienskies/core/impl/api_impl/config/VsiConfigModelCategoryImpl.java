/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.api_impl.config;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.valkyrienskies.core.internal.config.VsiConfigModelCategory;
import org.valkyrienskies.core.internal.config.VsiConfigModelEntry;
import org.valkyrienskies.core.internal.config.VsiConfigNode;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b#\u0010$J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00062\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000eH\u00c6\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bH\u00d6\u0001\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0006H\u00d6\u0001\u00a2\u0006\u0004\b\u001e\u0010\rR&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b \u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\r\u00a8\u0006%"}, d2={"Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelCategoryImpl;", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;", "cat", "", "addCategory", "(Lorg/valkyrienskies/core/internal/config/VsiConfigModelCategory;)V", "", "name", "Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;", "entry", "addEntry", "(Ljava/lang/String;Lorg/valkyrienskies/core/internal/config/VsiConfigModelEntry;)V", "component1", "()Ljava/lang/String;", "", "Lorg/valkyrienskies/core/internal/config/VsiConfigNode;", "component2", "()Ljava/util/Map;", "title", "children", "copy", "(Ljava/lang/String;Ljava/util/Map;)Lorg/valkyrienskies/core/impl/api_impl/config/VsiConfigModelCategoryImpl;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/util/Map;", "getChildren", "Ljava/lang/String;", "getTitle", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "internal"})
public final class VsiConfigModelCategoryImpl
implements VsiConfigModelCategory {
    @NotNull
    private final String title;
    @NotNull
    private final Map<String, VsiConfigNode> children;

    public VsiConfigModelCategoryImpl(@NotNull String title, @NotNull Map<String, VsiConfigNode> children2) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(children2, (String)"children");
        this.title = title;
        this.children = children2;
    }

    public /* synthetic */ VsiConfigModelCategoryImpl(String string, Map map2, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            map2 = new LinkedHashMap();
        }
        this(string, map2);
    }

    @Override
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @Override
    @NotNull
    public Map<String, VsiConfigNode> getChildren() {
        return this.children;
    }

    @Override
    public void addEntry(@NotNull String name, @NotNull VsiConfigModelEntry<?> entry) {
        Intrinsics.checkNotNullParameter((Object)name, (String)"name");
        Intrinsics.checkNotNullParameter(entry, (String)"entry");
        this.getChildren().put(name, entry);
    }

    @Override
    public void addCategory(@NotNull VsiConfigModelCategory cat) {
        Intrinsics.checkNotNullParameter((Object)cat, (String)"cat");
        this.getChildren().put(cat.getTitle(), cat);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final Map<String, VsiConfigNode> component2() {
        return this.children;
    }

    @NotNull
    public final VsiConfigModelCategoryImpl copy(@NotNull String title, @NotNull Map<String, VsiConfigNode> children2) {
        Intrinsics.checkNotNullParameter((Object)title, (String)"title");
        Intrinsics.checkNotNullParameter(children2, (String)"children");
        return new VsiConfigModelCategoryImpl(title, children2);
    }

    public static /* synthetic */ VsiConfigModelCategoryImpl copy$default(VsiConfigModelCategoryImpl vsiConfigModelCategoryImpl, String string, Map map2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            string = vsiConfigModelCategoryImpl.title;
        }
        if ((n2 & 2) != 0) {
            map2 = vsiConfigModelCategoryImpl.children;
        }
        return vsiConfigModelCategoryImpl.copy(string, map2);
    }

    @NotNull
    public String toString() {
        return "VsiConfigModelCategoryImpl(title=" + this.title + ", children=" + this.children + ")";
    }

    public int hashCode() {
        int result2 = this.title.hashCode();
        result2 = result2 * 31 + ((Object)this.children).hashCode();
        return result2;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VsiConfigModelCategoryImpl)) {
            return false;
        }
        VsiConfigModelCategoryImpl vsiConfigModelCategoryImpl = (VsiConfigModelCategoryImpl)other;
        if (!Intrinsics.areEqual((Object)this.title, (Object)vsiConfigModelCategoryImpl.title)) {
            return false;
        }
        return Intrinsics.areEqual(this.children, vsiConfigModelCategoryImpl.children);
    }
}

