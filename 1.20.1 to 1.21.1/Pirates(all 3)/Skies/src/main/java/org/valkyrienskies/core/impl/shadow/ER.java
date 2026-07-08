/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMap
 *  it.unimi.dsi.fastutil.longs.Long2ObjectMaps
 *  it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap
 *  kotlin.Pair
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

public final class ER {
    public static final <V> Long2ObjectMap<V> a(Pair<Long, ? extends V> ... pairArray) {
        Long2ObjectOpenHashMap long2ObjectOpenHashMap;
        Intrinsics.checkNotNullParameter(pairArray, (String)"");
        Long2ObjectOpenHashMap long2ObjectOpenHashMap2 = long2ObjectOpenHashMap = new Long2ObjectOpenHashMap();
        MapsKt.putAll((Map)((Map)long2ObjectOpenHashMap), pairArray);
        return (Long2ObjectMap)long2ObjectOpenHashMap;
    }

    public static final <V> Long2ObjectMap<? extends V> a() {
        Long2ObjectMap long2ObjectMap = Long2ObjectMaps.emptyMap();
        Intrinsics.checkNotNullExpressionValue((Object)long2ObjectMap, (String)"");
        return long2ObjectMap;
    }
}

