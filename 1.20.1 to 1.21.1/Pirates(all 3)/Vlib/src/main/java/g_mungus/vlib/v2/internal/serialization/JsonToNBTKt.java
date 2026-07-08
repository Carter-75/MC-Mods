/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.json.JsonArray
 *  kotlinx.serialization.json.JsonArrayBuilder
 *  kotlinx.serialization.json.JsonElement
 *  kotlinx.serialization.json.JsonElementKt
 *  kotlinx.serialization.json.JsonObject
 *  kotlinx.serialization.json.JsonObjectBuilder
 *  kotlinx.serialization.json.JsonPrimitive
 *  net.minecraft.class_2481
 *  net.minecraft.class_2487
 *  net.minecraft.class_2489
 *  net.minecraft.class_2497
 *  net.minecraft.class_2499
 *  net.minecraft.class_2503
 *  net.minecraft.class_2514
 *  net.minecraft.class_2519
 *  net.minecraft.class_2520
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.v2.internal.serialization;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArrayBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.JsonPrimitive;
import net.minecraft.class_2481;
import net.minecraft.class_2487;
import net.minecraft.class_2489;
import net.minecraft.class_2497;
import net.minecraft.class_2499;
import net.minecraft.class_2503;
import net.minecraft.class_2514;
import net.minecraft.class_2519;
import net.minecraft.class_2520;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2={"Lkotlinx/serialization/json/JsonElement;", "Lnet/minecraft/class_2520;", "toTag", "(Lkotlinx/serialization/json/JsonElement;)Lnet/minecraft/class_2520;", "toJson", "(Lnet/minecraft/class_2520;)Lkotlinx/serialization/json/JsonElement;", "vlib"})
@SourceDebugExtension(value={"SMAP\nJsonToNBT.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JsonToNBT.kt\ng_mungus/vlib/v2/internal/serialization/JsonToNBTKt\n+ 2 JsonElementBuilders.kt\nkotlinx/serialization/json/JsonElementBuildersKt\n*L\n1#1,47:1\n28#2,4:48\n51#2,4:52\n*S KotlinDebug\n*F\n+ 1 JsonToNBT.kt\ng_mungus/vlib/v2/internal/serialization/JsonToNBTKt\n*L\n37#1:48,4\n40#1:52,4\n*E\n"})
public final class JsonToNBTKt {
    @NotNull
    public static final class_2520 toTag(@NotNull JsonElement $this$toTag) {
        class_2520 class_25202;
        Intrinsics.checkNotNullParameter((Object)$this$toTag, (String)"<this>");
        JsonElement jsonElement = $this$toTag;
        if (jsonElement instanceof JsonObject) {
            class_2487 class_24872;
            class_2487 $this$toTag_u24lambda_u240 = class_24872 = new class_2487();
            boolean bl = false;
            for (Map.Entry entry : ((Map)$this$toTag).entrySet()) {
                String key = (String)entry.getKey();
                JsonElement value = (JsonElement)entry.getValue();
                $this$toTag_u24lambda_u240.method_10566(key, JsonToNBTKt.toTag(value));
            }
            class_25202 = (class_2520)class_24872;
        } else if (jsonElement instanceof JsonArray) {
            class_2499 class_24992;
            class_2499 $this$toTag_u24lambda_u241 = class_24992 = new class_2499();
            boolean bl = false;
            for (JsonElement e : (JsonArray)$this$toTag) {
                $this$toTag_u24lambda_u241.add((Object)JsonToNBTKt.toTag(e));
            }
            class_25202 = (class_2520)class_24992;
        } else if (jsonElement instanceof JsonPrimitive) {
            class_2520 class_25203 = JsonElementKt.getBooleanOrNull((JsonPrimitive)((JsonPrimitive)$this$toTag)) != null ? (class_2520)class_2481.method_23234((boolean)JsonElementKt.getBoolean((JsonPrimitive)((JsonPrimitive)$this$toTag))) : (JsonElementKt.getIntOrNull((JsonPrimitive)((JsonPrimitive)$this$toTag)) != null ? (class_2520)class_2497.method_23247((int)JsonElementKt.getInt((JsonPrimitive)((JsonPrimitive)$this$toTag))) : (JsonElementKt.getLongOrNull((JsonPrimitive)((JsonPrimitive)$this$toTag)) != null ? (class_2520)class_2503.method_23251((long)JsonElementKt.getLong((JsonPrimitive)((JsonPrimitive)$this$toTag))) : (JsonElementKt.getDoubleOrNull((JsonPrimitive)((JsonPrimitive)$this$toTag)) != null ? (class_2520)class_2489.method_23241((double)JsonElementKt.getDouble((JsonPrimitive)((JsonPrimitive)$this$toTag))) : (class_2520)class_2519.method_23256((String)((JsonPrimitive)$this$toTag).getContent()))));
            Intrinsics.checkNotNull((Object)class_25203);
            class_25202 = class_25203;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return class_25202;
    }

    @NotNull
    public static final JsonElement toJson(@NotNull class_2520 $this$toJson) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter((Object)$this$toJson, (String)"<this>");
        class_2520 class_25202 = $this$toJson;
        if (class_25202 instanceof class_2487) {
            JsonObjectBuilder builder$iv;
            boolean $i$f$buildJsonObject = false;
            JsonObjectBuilder $this$toJson_u24lambda_u242 = builder$iv = new JsonObjectBuilder();
            boolean bl = false;
            for (String key : ((class_2487)$this$toJson).method_10541()) {
                Intrinsics.checkNotNull((Object)key);
                class_2520 class_25203 = ((class_2487)$this$toJson).method_10580(key);
                Intrinsics.checkNotNull((Object)class_25203);
                $this$toJson_u24lambda_u242.put(key, JsonToNBTKt.toJson(class_25203));
            }
            jsonElement = (JsonElement)builder$iv.build();
        } else if (class_25202 instanceof class_2499) {
            JsonArrayBuilder builder$iv;
            boolean $i$f$buildJsonArray = false;
            JsonArrayBuilder $this$toJson_u24lambda_u243 = builder$iv = new JsonArrayBuilder();
            boolean bl = false;
            Iterator iterator = ((class_2499)$this$toJson).iterator();
            Intrinsics.checkNotNullExpressionValue((Object)iterator, (String)"iterator(...)");
            Iterator iterator2 = iterator;
            while (iterator2.hasNext()) {
                class_2520 tag = (class_2520)iterator2.next();
                Intrinsics.checkNotNull((Object)tag);
                $this$toJson_u24lambda_u243.add(JsonToNBTKt.toJson(tag));
            }
            jsonElement = (JsonElement)builder$iv.build();
        } else {
            jsonElement = class_25202 instanceof class_2481 ? (JsonElement)JsonElementKt.JsonPrimitive((Boolean)(((class_2481)$this$toJson).method_10698() != 0 ? 1 : 0)) : (class_25202 instanceof class_2514 ? (JsonElement)JsonElementKt.JsonPrimitive((Number)((class_2514)$this$toJson).method_10702()) : (class_25202 instanceof class_2519 ? (JsonElement)JsonElementKt.JsonPrimitive((String)((class_2519)$this$toJson).method_10714()) : (JsonElement)JsonElementKt.JsonPrimitive((String)$this$toJson.toString())));
        }
        return jsonElement;
    }
}

