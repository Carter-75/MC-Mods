/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.SourceDebugExtension
 *  net.minecraft.class_2248
 *  net.minecraft.class_5953
 *  net.minecraft.class_5955
 *  org.jetbrains.annotations.NotNull
 */
package dev.mim1q.derelict.item;

import com.google.common.collect.BiMap;
import dev.mim1q.derelict.init.ModBlocksAndItems;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import net.minecraft.class_2248;
import net.minecraft.class_5953;
import net.minecraft.class_5955;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={2, 0, 0}, k=2, xi=48, d1={"\u0000\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2={"", "Lnet/minecraft/class_2248;", "getFullAgingMap", "()Ljava/util/Map;", "derelict"})
@SourceDebugExtension(value={"SMAP\nStaffItem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StaffItem.kt\ndev/mim1q/derelict/item/StaffItemKt\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,111:1\n216#2,2:112\n216#2,2:114\n*S KotlinDebug\n*F\n+ 1 StaffItem.kt\ndev/mim1q/derelict/item/StaffItemKt\n*L\n101#1:112,2\n104#1:114,2\n*E\n"})
public final class StaffItemKt {
    @NotNull
    public static final Map<class_2248, class_2248> getFullAgingMap() {
        class_2248 to;
        class_2248 from;
        Map.Entry entry;
        Map.Entry element$iv;
        Map map = new LinkedHashMap();
        map.putAll(ModBlocksAndItems.INSTANCE.getBLOCK_AGING_MAP());
        Object t = class_5955.field_29564.get();
        Intrinsics.checkNotNullExpressionValue(t, (String)"get(...)");
        Map $this$forEach$iv = (Map)t;
        boolean $i$f$forEach = false;
        Iterator iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = element$iv = iterator.next();
            boolean bl = false;
            from = (class_2248)entry.getKey();
            to = (class_2248)entry.getValue();
            map.put(from, to);
        }
        Object t2 = class_5953.field_29560.get();
        Intrinsics.checkNotNullExpressionValue(t2, (String)"get(...)");
        $this$forEach$iv = (Map)t2;
        $i$f$forEach = false;
        iterator = $this$forEach$iv.entrySet().iterator();
        while (iterator.hasNext()) {
            entry = element$iv = iterator.next();
            boolean bl = false;
            from = (class_2248)entry.getKey();
            to = (class_2248)entry.getValue();
            class_2248 aged = class_5955.method_34737((class_2248)to).orElse(null);
            class_2248 agedWaxed = (class_2248)((BiMap)class_5953.field_29560.get()).get((Object)aged);
            if (agedWaxed == null) continue;
            map.put(from, agedWaxed);
        }
        return map;
    }
}

