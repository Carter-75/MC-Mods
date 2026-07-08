/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.longs.LongOpenHashSet
 *  it.unimi.dsi.fastutil.longs.LongSet
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.shadow.GC;
import org.valkyrienskies.core.impl.shadow.GD;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Gy
 */
public final class gy_0
extends SimpleModule {
    public gy_0() {
        SimpleModule simpleModule = this;
        Intrinsics.checkNotNullExpressionValue((Object)simpleModule.addAbstractTypeMapping(LongSet.class, LongOpenHashSet.class), (String)"");
        simpleModule = this;
        Function1 function1 = 1.a;
        Function1 function12 = 2.a;
        simpleModule.addSerializer(LongOpenHashSet.class, new GD(function1, LongOpenHashSet.class));
        simpleModule.addDeserializer(LongOpenHashSet.class, (JsonDeserializer)new GC<LongOpenHashSet, long[]>(function12, LongOpenHashSet.class, long[].class));
    }
}

