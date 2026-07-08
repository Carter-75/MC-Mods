/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.structure;

import g_mungus.vlib.data.StructureSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2={"Lg_mungus/vlib/structure/StructureManager;", "", "", "namespace", "Lg_mungus/vlib/data/StructureSettings;", "structureSettings", "", "addModifiedStructures", "(Ljava/lang/String;Lg_mungus/vlib/data/StructureSettings;)V", "resetModifiedStructures", "()V", "", "getModifiedStructures", "()Ljava/util/Map;", "modifiedStructures", "Ljava/util/Map;", "<init>", "vlib"})
public final class StructureManager {
    @NotNull
    public static final StructureManager INSTANCE = new StructureManager();
    @NotNull
    private static volatile Map<String, StructureSettings> modifiedStructures = MapsKt.emptyMap();

    private StructureManager() {
    }

    public final void addModifiedStructures(@NotNull String namespace, @NotNull StructureSettings structureSettings) {
        Intrinsics.checkNotNullParameter((Object)namespace, (String)"namespace");
        Intrinsics.checkNotNullParameter((Object)structureSettings, (String)"structureSettings");
        Map modifiedStructures = MapsKt.toMutableMap(StructureManager.modifiedStructures);
        modifiedStructures.put(namespace, structureSettings);
        StructureManager.modifiedStructures = modifiedStructures;
    }

    public final void resetModifiedStructures() {
        modifiedStructures = MapsKt.emptyMap();
    }

    @NotNull
    public final Map<String, StructureSettings> getModifiedStructures() {
        return MapsKt.toMap(modifiedStructures);
    }
}

