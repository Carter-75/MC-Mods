/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  net.minecraft.class_2960
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.dimension;

import g_mungus.vlib.data.DimensionSettings;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_2960;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0011R\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2={"Lg_mungus/vlib/dimension/DimensionSettingsManager;", "", "Lnet/minecraft/class_2960;", "dimensionID", "Lg_mungus/vlib/data/DimensionSettings;", "settings", "", "addSettings", "(Lnet/minecraft/class_2960;Lg_mungus/vlib/data/DimensionSettings;)V", "", "", "getModifiedDimensions", "()Ljava/util/Map;", "dimensionKey", "getSettingsForLevel", "(Ljava/lang/String;)Lg_mungus/vlib/data/DimensionSettings;", "dimension", "(Lnet/minecraft/class_2960;)Lg_mungus/vlib/data/DimensionSettings;", "", "modifiedDimensions", "Ljava/util/Map;", "DEFAULT", "Lg_mungus/vlib/data/DimensionSettings;", "<init>", "()V", "vlib"})
public final class DimensionSettingsManager {
    @NotNull
    public static final DimensionSettingsManager INSTANCE = new DimensionSettingsManager();
    @NotNull
    private static Map<String, DimensionSettings> modifiedDimensions = new LinkedHashMap();
    @NotNull
    private static final DimensionSettings DEFAULT = new DimensionSettings(1.0, 1.0, false, 4, null);

    private DimensionSettingsManager() {
    }

    public final void addSettings(@NotNull class_2960 dimensionID, @NotNull DimensionSettings settings) {
        Intrinsics.checkNotNullParameter((Object)dimensionID, (String)"dimensionID");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
        modifiedDimensions.put(dimensionID.toString(), settings);
    }

    @NotNull
    public final Map<String, DimensionSettings> getModifiedDimensions() {
        return MapsKt.toMap(modifiedDimensions);
    }

    @NotNull
    public final DimensionSettings getSettingsForLevel(@NotNull String dimensionKey) {
        Intrinsics.checkNotNullParameter((Object)dimensionKey, (String)"dimensionKey");
        String key = StringsKt.drop((String)dimensionKey, (int)20);
        DimensionSettings dimensionSettings = modifiedDimensions.get(key);
        if (dimensionSettings == null) {
            dimensionSettings = DEFAULT;
        }
        return dimensionSettings;
    }

    @NotNull
    public final DimensionSettings getSettingsForLevel(@NotNull class_2960 dimension) {
        Intrinsics.checkNotNullParameter((Object)dimension, (String)"dimension");
        String string = dimension.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString(...)");
        String key = string;
        DimensionSettings dimensionSettings = modifiedDimensions.get(key);
        if (dimensionSettings == null) {
            dimensionSettings = DEFAULT;
        }
        return dimensionSettings;
    }
}

