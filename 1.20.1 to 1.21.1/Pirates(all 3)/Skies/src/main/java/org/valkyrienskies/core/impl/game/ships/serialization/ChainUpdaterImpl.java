/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.MapsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.game.ships.serialization;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.valkyrienskies.core.impl.game.ships.serialization.ChainUpdater;
import org.valkyrienskies.core.impl.game.ships.serialization.DtoUpdater;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B5\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u001e\u0010\n\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R,\u0010\n\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0007\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2={"Lorg/valkyrienskies/core/impl/game/ships/serialization/ChainUpdaterImpl;", "T", "Lorg/valkyrienskies/core/impl/game/ships/serialization/ChainUpdater;", "", "value", "updateToLatest", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "Ljava/lang/Class;", "Lorg/valkyrienskies/core/impl/game/ships/serialization/DtoUpdater;", "mappings", "Ljava/util/Map;", "updateTo", "Ljava/lang/Class;", "getUpdateTo", "()Ljava/lang/Class;", "Lkotlin/Pair;", "<init>", "(Ljava/lang/Class;[Lkotlin/Pair;)V"})
public final class ChainUpdaterImpl<T>
implements ChainUpdater<T> {
    private final Class<T> updateTo;
    private final Map<Class<?>, DtoUpdater<?, ?>> mappings;

    /*
     * WARNING - void declaration
     */
    public ChainUpdaterImpl(Class<T> updateTo, Pair<? extends Class<?>, ? extends DtoUpdater<?, ?>> ... mappings) {
        void var2_2;
        void var1_1;
        Intrinsics.checkNotNullParameter(updateTo, (String)"");
        Intrinsics.checkNotNullParameter(mappings, (String)"");
        this.updateTo = var1_1;
        this.mappings = MapsKt.toMap((Pair[])var2_2);
    }

    @JvmName(name="getUpdateTo")
    public final Class<T> getUpdateTo() {
        return this.updateTo;
    }

    @Override
    public final T updateToLatest(Object value) {
        Object obj;
        Intrinsics.checkNotNullParameter((Object)value, (String)"");
        while (!this.updateTo.isInstance(obj)) {
            Object object = obj.getClass();
            DtoUpdater<?, ?> dtoUpdater = this.mappings.get(object);
            if (dtoUpdater == null) {
                throw new IllegalArgumentException("Could not find updater for type " + (Class)object);
            }
            object = dtoUpdater;
            obj = dtoUpdater.update(obj);
        }
        return (T)obj;
    }
}

