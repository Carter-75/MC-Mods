/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  net.minecraft.class_3695
 *  net.minecraft.class_4309
 */
package org.valkyrienskies.mod.common.config;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import net.minecraft.class_3695;
import net.minecraft.class_4309;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.valkyrienskies.mod.util.LoggingKt;
import org.valkyrienskies.mod.util.McMathUtilKt;

@Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001!B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J7\u0010\u000b\u001a\u00020\n2\u0016\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\fJ+\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0015\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R.\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2={"Lorg/valkyrienskies/mod/common/config/DimensionParametersResolver;", "Lnet/minecraft/class_4309;", "", "Lnet/minecraft/class_2960;", "Lcom/google/gson/JsonElement;", "objects", "Lnet/minecraft/class_3300;", "resourceManager", "Lnet/minecraft/class_3695;", "profiler", "", "apply", "(Ljava/util/Map;Lnet/minecraft/class_3300;Lnet/minecraft/class_3695;)V", "element", "", "", "Lorg/valkyrienskies/mod/common/config/DimensionParametersResolver$Parameters;", "map", "parse", "(Lcom/google/gson/JsonElement;Ljava/util/Map;)V", "Lorg/apache/logging/log4j/Logger;", "logger", "Lorg/apache/logging/log4j/Logger;", "getLogger", "()Lorg/apache/logging/log4j/Logger;", "dimensionMap", "Ljava/util/Map;", "getDimensionMap", "()Ljava/util/Map;", "setDimensionMap", "(Ljava/util/Map;)V", "<init>", "()V", "Parameters", "valkyrienskies-120"})
@SourceDebugExtension(value={"SMAP\nDimensionParametersResolver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DimensionParametersResolver.kt\norg/valkyrienskies/mod/common/config/DimensionParametersResolver\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,75:1\n216#2:76\n217#2:79\n1863#3,2:77\n381#4,7:80\n*S KotlinDebug\n*F\n+ 1 DimensionParametersResolver.kt\norg/valkyrienskies/mod/common/config/DimensionParametersResolver\n*L\n27#1:76\n27#1:79\n31#1:77,2\n58#1:80,7\n*E\n"})
public final class DimensionParametersResolver
extends class_4309 {
    @NotNull
    public static final DimensionParametersResolver INSTANCE = new DimensionParametersResolver();
    @NotNull
    private static final Logger logger = LoggingKt.logger("Bloon Factory");
    @NotNull
    private static Map<String, Parameters> dimensionMap = new HashMap();

    private DimensionParametersResolver() {
        super(new Gson(), "vs_dimension_parameters");
    }

    @NotNull
    public final Logger getLogger() {
        return logger;
    }

    @NotNull
    public final Map<String, Parameters> getDimensionMap() {
        return dimensionMap;
    }

    public final void setDimensionMap(@NotNull Map<String, Parameters> map2) {
        Intrinsics.checkNotNullParameter(map2, (String)"<set-?>");
        dimensionMap = map2;
    }

    protected void apply(@NotNull Map<class_2960, ? extends JsonElement> objects, @NotNull class_3300 resourceManager, @NotNull class_3695 profiler) {
        Intrinsics.checkNotNullParameter(objects, (String)"objects");
        Intrinsics.checkNotNullParameter((Object)resourceManager, (String)"resourceManager");
        Intrinsics.checkNotNullParameter((Object)profiler, (String)"profiler");
        HashMap temp = new HashMap();
        Map<class_2960, ? extends JsonElement> $this$forEach$iv = objects;
        boolean $i$f$forEach = false;
        Iterator<Map.Entry<class_2960, ? extends JsonElement>> iterator2 = $this$forEach$iv.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<class_2960, ? extends JsonElement> element$iv;
            Map.Entry<class_2960, ? extends JsonElement> entry = element$iv = iterator2.next();
            boolean bl = false;
            class_2960 key = entry.getKey();
            JsonElement value = entry.getValue();
            if (key == null || value == null) continue;
            try {
                if (value.isJsonArray()) {
                    JsonArray jsonArray = value.getAsJsonArray();
                    Intrinsics.checkNotNullExpressionValue((Object)jsonArray, (String)"getAsJsonArray(...)");
                    Iterable $this$forEach$iv2 = (Iterable)jsonArray;
                    boolean $i$f$forEach2 = false;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        JsonElement it = (JsonElement)element$iv2;
                        boolean bl2 = false;
                        Intrinsics.checkNotNull((Object)it);
                        INSTANCE.parse(it, temp);
                    }
                    continue;
                }
                if (value.isJsonObject()) {
                    INSTANCE.parse(value, temp);
                    continue;
                }
                throw new IllegalArgumentException();
            }
            catch (Exception e2) {
                logger.error(ExceptionsKt.stackTraceToString((Throwable)e2));
            }
        }
        dimensionMap = temp;
    }

    private final void parse(JsonElement element, Map<String, Parameters> map2) {
        Parameters parameters;
        Parameters parameters2;
        JsonElement jsonElement = element.getAsJsonObject().get("maxYPos");
        if (jsonElement == null) {
            throw new NoSuchElementException("Parameter \"maxYPos\" wasn't filled");
        }
        double maxYPos = jsonElement.getAsDouble();
        JsonElement jsonElement2 = element.getAsJsonObject().get("seaLevel");
        if (jsonElement2 == null) {
            throw new NoSuchElementException("Parameter \"seaLevel\" wasn't filled");
        }
        double seaLevel = jsonElement2.getAsDouble();
        JsonElement jsonElement3 = element.getAsJsonObject().get("gravity");
        if (jsonElement3 == null || (jsonElement3 = jsonElement3.getAsJsonArray()) == null) {
            throw new NoSuchElementException("Parameter \"gravity\" wasn't filled");
        }
        JsonElement gravity = jsonElement3;
        Object object = element.getAsJsonObject().get("dimensionId");
        if (object == null || (object = object.getAsString()) == null) {
            throw new NoSuchElementException("Parameter \"dimensionId\" wasn't filled");
        }
        Object dimensionId = object;
        JsonElement jsonElement4 = element.getAsJsonObject().get("priority");
        int priority = jsonElement4 != null ? jsonElement4.getAsInt() : 0;
        Map<String, Parameters> $this$getOrPut$iv = map2;
        boolean $i$f$getOrPut = false;
        Parameters value$iv = $this$getOrPut$iv.get(dimensionId);
        if (value$iv == null) {
            boolean bl = false;
            Parameters answer$iv = new Parameters(maxYPos, seaLevel, DimensionParametersResolver.parse$toVector3d((JsonArray)gravity), priority);
            $this$getOrPut$iv.put((String)dimensionId, answer$iv);
            parameters2 = answer$iv;
        } else {
            parameters2 = value$iv;
        }
        Parameters it = parameters = parameters2;
        boolean bl = false;
        if (it.getPriority() < priority) {
            map2.put((String)dimensionId, new Parameters(maxYPos, seaLevel, DimensionParametersResolver.parse$toVector3d((JsonArray)gravity), priority));
        }
    }

    private static final Vector3dc parse$toVector3d(JsonArray $this$parse_u24toVector3d) {
        return new Vector3d($this$parse_u24toVector3d.get(0).getAsDouble(), $this$parse_u24toVector3d.get(1).getAsDouble(), $this$parse_u24toVector3d.get(2).getAsDouble());
    }

    @Metadata(mv={2, 0, 0}, k=1, xi=48, d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tH\u00c6\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tH\u00c6\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tH\u00d6\u0001\u00a2\u0006\u0004\b\u0016\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0017H\u00d6\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004R\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\b\"\u0004\b\u001f\u0010 R\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\u000b\u00a8\u0006%"}, d2={"Lorg/valkyrienskies/mod/common/config/DimensionParametersResolver$Parameters;", "", "", "component1", "()D", "component2", "Lorg/joml/Vector3dc;", "component3", "()Lorg/joml/Vector3dc;", "", "component4", "()I", "maxY", "seaLevel", "gravity", "priority", "copy", "(DDLorg/joml/Vector3dc;I)Lorg/valkyrienskies/mod/common/config/DimensionParametersResolver$Parameters;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "D", "getMaxY", "getSeaLevel", "Lorg/joml/Vector3dc;", "getGravity", "setGravity", "(Lorg/joml/Vector3dc;)V", "I", "getPriority", "<init>", "(DDLorg/joml/Vector3dc;I)V", "valkyrienskies-120"})
    public static final class Parameters {
        private final double maxY;
        private final double seaLevel;
        @NotNull
        private Vector3dc gravity;
        private final int priority;

        public Parameters(double maxY, double seaLevel, @NotNull Vector3dc gravity, int priority) {
            Intrinsics.checkNotNullParameter((Object)gravity, (String)"gravity");
            this.maxY = maxY;
            this.seaLevel = seaLevel;
            this.gravity = gravity;
            this.priority = priority;
        }

        public /* synthetic */ Parameters(double d2, double d3, Vector3dc vector3dc, int n2, int n3, DefaultConstructorMarker defaultConstructorMarker) {
            if ((n3 & 4) != 0) {
                vector3dc = McMathUtilKt.getDEFAULT_WORLD_GRAVITY();
            }
            if ((n3 & 8) != 0) {
                n2 = -1;
            }
            this(d2, d3, vector3dc, n2);
        }

        public final double getMaxY() {
            return this.maxY;
        }

        public final double getSeaLevel() {
            return this.seaLevel;
        }

        @NotNull
        public final Vector3dc getGravity() {
            return this.gravity;
        }

        public final void setGravity(@NotNull Vector3dc vector3dc) {
            Intrinsics.checkNotNullParameter((Object)vector3dc, (String)"<set-?>");
            this.gravity = vector3dc;
        }

        public final int getPriority() {
            return this.priority;
        }

        public final double component1() {
            return this.maxY;
        }

        public final double component2() {
            return this.seaLevel;
        }

        @NotNull
        public final Vector3dc component3() {
            return this.gravity;
        }

        public final int component4() {
            return this.priority;
        }

        @NotNull
        public final Parameters copy(double maxY, double seaLevel, @NotNull Vector3dc gravity, int priority) {
            Intrinsics.checkNotNullParameter((Object)gravity, (String)"gravity");
            return new Parameters(maxY, seaLevel, gravity, priority);
        }

        public static /* synthetic */ Parameters copy$default(Parameters parameters, double d2, double d3, Vector3dc vector3dc, int n2, int n3, Object object) {
            if ((n3 & 1) != 0) {
                d2 = parameters.maxY;
            }
            if ((n3 & 2) != 0) {
                d3 = parameters.seaLevel;
            }
            if ((n3 & 4) != 0) {
                vector3dc = parameters.gravity;
            }
            if ((n3 & 8) != 0) {
                n2 = parameters.priority;
            }
            return parameters.copy(d2, d3, vector3dc, n2);
        }

        @NotNull
        public String toString() {
            return "Parameters(maxY=" + this.maxY + ", seaLevel=" + this.seaLevel + ", gravity=" + this.gravity + ", priority=" + this.priority + ")";
        }

        public int hashCode() {
            int result2 = Double.hashCode(this.maxY);
            result2 = result2 * 31 + Double.hashCode(this.seaLevel);
            result2 = result2 * 31 + this.gravity.hashCode();
            result2 = result2 * 31 + Integer.hashCode(this.priority);
            return result2;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parameters)) {
                return false;
            }
            Parameters parameters = (Parameters)other;
            if (Double.compare(this.maxY, parameters.maxY) != 0) {
                return false;
            }
            if (Double.compare(this.seaLevel, parameters.seaLevel) != 0) {
                return false;
            }
            if (!Intrinsics.areEqual((Object)this.gravity, (Object)parameters.gravity)) {
                return false;
            }
            return this.priority == parameters.priority;
        }
    }
}

