/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.text.StringsKt
 *  net.minecraft.class_2960
 *  net.minecraft.class_3298
 *  net.minecraft.class_3300
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.data;

import g_mungus.vlib.VLib;
import g_mungus.vlib.data.DimensionSettings;
import g_mungus.vlib.data.StructureSettings;
import g_mungus.vlib.dimension.DimensionSettingsManager;
import g_mungus.vlib.structure.StructureManager;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import net.minecraft.class_2960;
import net.minecraft.class_3298;
import net.minecraft.class_3300;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2={"Lnet/minecraft/class_3300;", "resourceManager", "", "onResourceReload", "(Lnet/minecraft/class_3300;)V", "vlib"})
@SourceDebugExtension(value={"SMAP\nReloadListener.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReloadListener.kt\ng_mungus/vlib/data/ReloadListenerKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,60:1\n216#2,2:61\n216#2,2:63\n*S KotlinDebug\n*F\n+ 1 ReloadListener.kt\ng_mungus/vlib/data/ReloadListenerKt\n*L\n18#1:61,2\n36#1:63,2\n*E\n"})
public final class ReloadListenerKt {
    public static final void onResourceReload(@NotNull class_3300 resourceManager) {
        Object namespace;
        class_3298 resource;
        class_2960 resourceLocation;
        Map.Entry entry;
        Map.Entry element$iv;
        Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
        VLib.INSTANCE.getLOGGER().info("VLib scanning for data");
        StructureManager.INSTANCE.resetModifiedStructures();
        Predicate<class_2960> predicate = ReloadListenerKt::onResourceReload$lambda$0;
        Map map = resourceManager.method_14488("structure-settings", predicate);
        Intrinsics.checkNotNullExpressionValue((Object)map, (String)"listResources(...)");
        Map $this$forEach$iv = map;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            StructureSettings structureSettings;
            entry = element$iv = iterator.next();
            boolean bl = false;
            resourceLocation = (class_2960)entry.getKey();
            resource = (class_3298)entry.getValue();
            try {
                InputStream inputStream = resource.method_14482();
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"open(...)");
                structureSettings = StructureSettings.Companion.readJson(inputStream);
            }
            catch (Exception e) {
                VLib.INSTANCE.getLOGGER().error("Error occurred while loading resource json: " + resourceLocation, (Throwable)e);
                structureSettings = null;
            }
            StructureSettings structures = structureSettings;
            if (structures != null) {
                String string = resourceLocation.method_12832();
                Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
                String[] e = new String[]{"/"};
                namespace = StringsKt.replace$default((String)((String)CollectionsKt.last((List)StringsKt.split$default((CharSequence)string, (String[])e, (boolean)false, (int)0, (int)6, null))), (String)".json", (String)"", (boolean)false, (int)4, null);
                StructureManager.INSTANCE.addModifiedStructures((String)namespace, structures);
                continue;
            }
            VLib.INSTANCE.getLOGGER().warn("Skipping resource at " + resourceLocation + " because it could not be parsed.");
        }
        Map map2 = resourceManager.method_14488("dimension-settings", predicate);
        Intrinsics.checkNotNullExpressionValue((Object)map2, (String)"listResources(...)");
        $this$forEach$iv = map2;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = element$iv = iterator.next();
            boolean bl = false;
            resourceLocation = (class_2960)entry.getKey();
            resource = (class_3298)entry.getValue();
            try {
                InputStream inputStream = resource.method_14482();
                Intrinsics.checkNotNullExpressionValue((Object)inputStream, (String)"open(...)");
                namespace = DimensionSettings.Companion.readJson(inputStream);
            }
            catch (Exception e) {
                VLib.INSTANCE.getLOGGER().error("Error occurred while loading resource json: " + resourceLocation, (Throwable)e);
                namespace = null;
            }
            DimensionSettings settings = namespace;
            String string = resourceLocation.method_12832();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"getPath(...)");
            class_2960 location = class_2960.method_12829((String)StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.drop((String)string, (int)19), (String)".json", (String)"", (boolean)false, (int)4, null), (String)"/", (String)":", (boolean)false, (int)4, null));
            if (settings != null && location != null) {
                DimensionSettingsManager.INSTANCE.addSettings(location, settings);
                continue;
            }
            VLib.INSTANCE.getLOGGER().warn("Skipping resource at " + resourceLocation + " because it could not be parsed.");
        }
        VLib.INSTANCE.getLOGGER().info("Finished reload. Modified structure data:\n" + StructureManager.INSTANCE.getModifiedStructures() + "\nModified dimensions:\n" + DimensionSettingsManager.INSTANCE.getModifiedDimensions());
    }

    private static final boolean onResourceReload$lambda$0(class_2960 it) {
        Intrinsics.checkNotNullParameter((Object)it, (String)"it");
        return true;
    }
}

