/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  kotlinx.serialization.DeserializationStrategy
 *  kotlinx.serialization.SerializationStrategy
 *  kotlinx.serialization.json.Json
 *  kotlinx.serialization.json.JsonElement
 *  net.minecraft.class_2338
 *  net.minecraft.class_243
 *  net.minecraft.class_2487
 *  net.minecraft.class_2520
 *  net.minecraft.class_3499
 *  net.minecraft.class_3499$class_3502
 *  org.jetbrains.annotations.NotNull
 */
package g_mungus.vlib.v2.internal.template;

import g_mungus.vlib.mixin.v2.templatePlacement.StructureTemplateAccessor;
import g_mungus.vlib.v2.internal.serialization.JsonToNBTKt;
import g_mungus.vlib.v2.internal.template.VLibStructureData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import net.minecraft.class_2338;
import net.minecraft.class_243;
import net.minecraft.class_2487;
import net.minecraft.class_2520;
import net.minecraft.class_3499;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Lnet/minecraft/class_3499;", "Lg_mungus/vlib/v2/internal/template/VLibStructureData;", "data", "", "saveAdditional", "(Lnet/minecraft/class_3499;Lg_mungus/vlib/v2/internal/template/VLibStructureData;)V", "readAdditional", "(Lnet/minecraft/class_3499;)Lg_mungus/vlib/v2/internal/template/VLibStructureData;", "vlib"})
@SourceDebugExtension(value={"SMAP\nStructureTemplateInternalExt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StructureTemplateInternalExt.kt\ng_mungus/vlib/v2/internal/template/StructureTemplateInternalExtKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Json.kt\nkotlinx/serialization/json/JsonKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n1#2:34\n211#3:35\n222#3:37\n1863#4:36\n1864#4:38\n*S KotlinDebug\n*F\n+ 1 StructureTemplateInternalExt.kt\ng_mungus/vlib/v2/internal/template/StructureTemplateInternalExtKt\n*L\n21#1:35\n29#1:37\n27#1:36\n27#1:38\n*E\n"})
public final class StructureTemplateInternalExtKt {
    /*
     * WARNING - void declaration
     */
    public static final void saveAdditional(@NotNull class_3499 $this$saveAdditional, @NotNull VLibStructureData data) {
        void $this$saveAdditional_u24lambda_u243_u24lambda_u242;
        class_2487 class_24872;
        List<class_3499.class_3502> list;
        Intrinsics.checkNotNullParameter((Object)$this$saveAdditional, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)data, (String)"data");
        List<class_3499.class_3502> $this$saveAdditional_u24lambda_u243 = list = ((StructureTemplateAccessor)$this$saveAdditional).getEntityInfoList();
        boolean bl = false;
        $this$saveAdditional_u24lambda_u243.removeIf(arg_0 -> StructureTemplateInternalExtKt.saveAdditional$lambda$3$lambda$1(StructureTemplateInternalExtKt::saveAdditional$lambda$3$lambda$0, arg_0));
        class_2487 class_24873 = class_24872 = new class_2487();
        class_2338 class_23382 = new class_2338(0, 0, 0);
        class_243 class_2432 = new class_243(0.0, 0.0, 0.0);
        List<class_3499.class_3502> list2 = $this$saveAdditional_u24lambda_u243;
        boolean bl2 = false;
        Json $this$encodeToJsonElement$iv = (Json)Json.Default;
        boolean $i$f$encodeToJsonElement = false;
        $this$encodeToJsonElement$iv.getSerializersModule();
        $this$saveAdditional_u24lambda_u243_u24lambda_u242.method_10566("vlib", JsonToNBTKt.toTag($this$encodeToJsonElement$iv.encodeToJsonElement((SerializationStrategy)VLibStructureData.Companion.serializer(), (Object)data)));
        Unit unit = Unit.INSTANCE;
        class_2487 class_24874 = class_24872;
        class_2338 class_23383 = class_23382;
        class_243 class_2433 = class_2432;
        list2.add(new class_3499.class_3502(class_2433, class_23383, class_24874));
    }

    /*
     * WARNING - void declaration
     */
    @NotNull
    public static final VLibStructureData readAdditional(@NotNull class_3499 $this$readAdditional) {
        Intrinsics.checkNotNullParameter((Object)$this$readAdditional, (String)"<this>");
        List<class_3499.class_3502> list = ((StructureTemplateAccessor)$this$readAdditional).getEntityInfoList();
        Intrinsics.checkNotNullExpressionValue(list, (String)"getEntityInfoList(...)");
        Iterable $this$forEach$iv = list;
        boolean $i$f$forEach = false;
        for (Object element$iv : $this$forEach$iv) {
            void $this$decodeFromJsonElement$iv;
            class_3499.class_3502 entityInfo = (class_3499.class_3502)element$iv;
            boolean bl = false;
            if (!entityInfo.field_15598.method_10545("vlib")) continue;
            Json json = (Json)Json.Default;
            class_2487 class_24872 = entityInfo.field_15598.method_10562("vlib");
            Intrinsics.checkNotNullExpressionValue((Object)class_24872, (String)"getCompound(...)");
            JsonElement json$iv = JsonToNBTKt.toJson((class_2520)class_24872);
            boolean $i$f$decodeFromJsonElement = false;
            $this$decodeFromJsonElement$iv.getSerializersModule();
            return (VLibStructureData)$this$decodeFromJsonElement$iv.decodeFromJsonElement((DeserializationStrategy)VLibStructureData.Companion.serializer(), json$iv);
        }
        return VLibStructureData.Companion.getDEFAULT();
    }

    private static final boolean saveAdditional$lambda$3$lambda$0(class_3499.class_3502 it) {
        return it.field_15598.method_10545("vlib");
    }

    private static final boolean saveAdditional$lambda$3$lambda$1(Function1 $tmp0, Object p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, (String)"$tmp0");
        return (Boolean)$tmp0.invoke(p0);
    }
}

