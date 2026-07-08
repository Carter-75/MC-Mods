/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.PropertyReference1
 *  kotlin.jvm.internal.PropertyReference1Impl
 *  kotlin.jvm.internal.Reflection
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlin.reflect.KProperty
 *  net.minecraft.class_1299
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_3695
 *  net.minecraft.class_4309
 *  net.minecraft.class_7923
 */
package org.valkyrienskies.mod.common.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KProperty;
import net.minecraft.class_1299;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_3695;
import net.minecraft.class_4309;
import net.minecraft.class_7923;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.mod.common.entity.handling.VSEntityHandler;
import org.valkyrienskies.mod.common.entity.handling.VSEntityManager;
import org.valkyrienskies.mod.util.ClassLogger;
import org.valkyrienskies.mod.util.LoggingKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u000b\u001a\u00020\n2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2={"Lorg/valkyrienskies/mod/common/config/VSEntityHandlerDataLoader;", "Lnet/minecraft/class_4309;", "", "Lnet/minecraft/class_2960;", "Lcom/google/gson/JsonElement;", "list", "Lnet/minecraft/class_3300;", "resourceManager", "Lnet/minecraft/class_3695;", "profiler", "", "apply", "(Ljava/util/Map;Lnet/minecraft/class_3300;Lnet/minecraft/class_3695;)V", "Lorg/apache/logging/log4j/Logger;", "logger$delegate", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "logger", "<init>", "()V", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nVSEntityHandlerDataLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VSEntityHandlerDataLoader.kt\norg/valkyrienskies/mod/common/config/VSEntityHandlerDataLoader\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,36:1\n216#2,2:37\n*S KotlinDebug\n*F\n+ 1 VSEntityHandlerDataLoader.kt\norg/valkyrienskies/mod/common/config/VSEntityHandlerDataLoader\n*L\n21#1:37,2\n*E\n"})
public final class VSEntityHandlerDataLoader
extends class_4309 {
    @NotNull
    public static final VSEntityHandlerDataLoader INSTANCE;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    @NotNull
    private static final Logger logger$delegate;

    private VSEntityHandlerDataLoader() {
        super(new Gson(), "vs_entities");
    }

    protected void apply(@NotNull Map<class_2960, JsonElement> list, @NotNull class_3300 resourceManager, @NotNull class_3695 profiler) {
        Intrinsics.checkNotNullParameter(list, (String)"list");
        Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
        Intrinsics.checkNotNullParameter((Object)profiler, (String)"profiler");
        Map<class_2960, JsonElement> $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<class_2960, JsonElement>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<class_2960, JsonElement> element$iv;
            Map.Entry<class_2960, JsonElement> entry = element$iv = iterator2.next();
            boolean bl = false;
            class_2960 l2 = entry.getKey();
            JsonElement v = entry.getValue();
            try {
                VSEntityHandler handler;
                class_1299 type;
                if ((class_1299)class_7923.field_41177.method_17966(l2).orElse(null) == null) continue;
                if (VSEntityManager.INSTANCE.getHandler(new class_2960(v.getAsJsonObject().get("handler").getAsString())) == null) {
                    throw new Exception("Handler not found");
                }
                VSEntityManager.INSTANCE.pair(type, handler);
            }
            catch (Exception e2) {
                INSTANCE.getLogger().error("Error loading entity handler data for entity type " + l2, (Throwable)e2);
            }
        }
    }

    private final Logger getLogger() {
        return ClassLogger.getValue-impl(logger$delegate, (Object)this, $$delegatedProperties[0]);
    }

    static {
        KProperty[] kPropertyArray = new KProperty[]{Reflection.property1((PropertyReference1)((PropertyReference1)new PropertyReference1Impl(VSEntityHandlerDataLoader.class, "logger", "getLogger()Lorg/apache/logging/log4j/Logger;", 0)))};
        $$delegatedProperties = kPropertyArray;
        INSTANCE = new VSEntityHandlerDataLoader();
        logger$delegate = LoggingKt.logger().provideDelegate-j8jxBIw((Object)INSTANCE, $$delegatedProperties[0]);
    }
}

