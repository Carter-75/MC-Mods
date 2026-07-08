/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.CollectionToArray
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.joml.primitives.AABBdc;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.core.impl.shadow.ds_0;
import org.valkyrienskies.core.internal.ships.VsiMutableQueryableShipData;
import org.valkyrienskies.core.util.AABBdUtilKt;

/*
 * Duplicate member names - consider using --renamedupmembers true
 * Renamed from org.valkyrienskies.core.impl.shadow.Em
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\u00a2\u0006\u0004\b0\u00101J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\bH\u0096\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u000e\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u0013J\u001d\u0010\u0016\u001a\u0004\u0018\u00018\u00002\n\u0010\u0004\u001a\u00060\u0014j\u0002`\u0015H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u0004\u001a\u00020\u0018H\u0017\u00a2\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00192\u0006\u0010\u0004\u001a\u00020\u00182\n\u0010\r\u001a\u00060\u0010j\u0002`\u0011H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\fH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0002\u00a2\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\"\u0010\u0007J\u001b\u0010\"\u001a\u00028\u00002\n\u0010\u0004\u001a\u00060\u0014j\u0002`\u0015H\u0016\u00a2\u0006\u0004\b\"\u0010\u0017R8\u0010%\u001a&\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00028\u00000#j\u0012\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00028\u0000`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R*\u0010.\u001a\u0012\u0012\b\u0012\u00060\u0014j\u0002`\u0015\u0012\u0004\u0012\u00028\u00000*8WX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b%\u0010-\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020\f8WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u001e"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Em;", "Lorg/valkyrienskies/core/api/ships/Ship;", "ShipType", "Lorg/valkyrienskies/core/internal/ships/VsiMutableQueryableShipData;", "p0", "", "add", "(Lorg/valkyrienskies/core/api/ships/Ship;)V", "", "", "equals", "(Ljava/lang/Object;)Z", "", "p1", "getByChunkPos", "(II)Lorg/valkyrienskies/core/api/ships/Ship;", "", "Lorg/valkyrienskies/core/api/world/properties/DimensionId;", "p2", "(IILjava/lang/String;)Lorg/valkyrienskies/core/api/ships/Ship;", "", "Lorg/valkyrienskies/core/api/ships/properties/ShipId;", "getById", "(J)Lorg/valkyrienskies/core/api/ships/Ship;", "Lorg/joml/primitives/AABBdc;", "", "getIntersecting", "(Lorg/joml/primitives/AABBdc;)Ljava/lang/Iterable;", "(Lorg/joml/primitives/AABBdc;Ljava/lang/String;)Ljava/lang/Iterable;", "hashCode", "()I", "", "iterator", "()Ljava/util/Iterator;", "remove", "Ljava/util/HashMap;", "Lkotlin/collections/d;", "a", "Ljava/util/HashMap;", "Lorg/valkyrienskies/core/impl/shadow/Ds;", "b", "Lorg/valkyrienskies/core/impl/shadow/Ds;", "", "getIdToShipData", "()Ljava/util/Map;", "()V", "c", "d", "<init>", "(Ljava/lang/Iterable;)V"})
public class em_0<ShipType extends Ship>
implements VsiMutableQueryableShipData<ShipType> {
    private final HashMap<Long, ShipType> a;
    private final ds_0<ShipType> b;

    public em_0(Iterable<? extends ShipType> object) {
        Intrinsics.checkNotNullParameter(object, (String)"");
        this.a = new HashMap();
        this.b = new ds_0();
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = object.next();
            object2 = (Ship)object2;
            this.add((ShipType)object2);
        }
    }

    public /* synthetic */ em_0(Iterable iterable, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 1) != 0) {
            iterable = CollectionsKt.emptyList();
        }
        this(iterable);
    }

    @Override
    @JvmName(name="getIdToShipData")
    public Map<Long, ShipType> getIdToShipData() {
        return this.a;
    }

    @Deprecated(message="Use the specific functions instead, such as #getById or #iterator")
    private static /* synthetic */ void a() {
    }

    @Override
    public Iterator<ShipType> iterator() {
        Iterator<ShipType> iterator2 = this.a.values().iterator();
        return new Iterator<ShipType>(iterator2, this){
            private ShipType a;
            private /* synthetic */ Iterator<ShipType> b;
            private /* synthetic */ em_0<ShipType> c;
            {
                this.b = iterator2;
                this.c = em_02;
            }

            private ShipType a() {
                return this.a;
            }

            private void a(ShipType ShipType) {
                this.a = ShipType;
            }

            @Override
            public final boolean hasNext() {
                return this.b.hasNext();
            }

            private ShipType b() {
                Object ShipType = this.b.next();
                Intrinsics.checkNotNullExpressionValue(ShipType, (String)"");
                Ship ship = (Ship)ShipType;
                this.a = ship;
                return ship;
            }

            @Override
            public final void remove() {
                Object ShipType = this.a;
                if (ShipType == null) {
                    throw new IllegalStateException("remove() failed because last was null!");
                }
                Object ShipType2 = ShipType;
                this.b.remove();
                this.c.b.a(ShipType2.getChunkClaim());
                this.a = null;
            }

            @Override
            public final /* synthetic */ Object next() {
                a a2 = this;
                Object ShipType = a2.b.next();
                Intrinsics.checkNotNullExpressionValue(ShipType, (String)"");
                Ship ship = (Ship)ShipType;
                a2.a = ship;
                return ship;
            }
        };
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void add(ShipType ship) {
        void var1_1;
        Intrinsics.checkNotNullParameter(ship, (String)"");
        if (this.getById(ship.getId()) != null) {
            throw new IllegalArgumentException("Adding ship id:" + ship.getId() + " failed because of duplicated ID.");
        }
        ((Map)this.a).put(ship.getId(), ship);
        this.b.a(ship.getChunkClaim(), var1_1);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void remove(ShipType ship) {
        void var1_1;
        Intrinsics.checkNotNullParameter(ship, (String)"");
        this.remove(var1_1.getId());
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ShipType getById(long shipId) {
        void var1_1;
        return (ShipType)((Ship)this.a.get((long)var1_1));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ShipType getByChunkPos(int chunkX, int chunkZ) {
        void var2_2;
        void var1_1;
        return (ShipType)((Ship)this.b.a((int)var1_1, (int)var2_2));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ShipType getByChunkPos(int chunkX, int chunkZ, String dimensionId) {
        void var3_4;
        void var2_3;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Ship ship = (Ship)this.b.a((int)var1_1, (int)var2_3);
        if (ship != null && Intrinsics.areEqual((Object)ship.getChunkClaimDimension(), (Object)var3_4)) {
            return (ShipType)ship;
        }
        return null;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public ShipType remove(long id) {
        ShipType ShipType = this.getById(id);
        if (ShipType == null) {
            void var1_1;
            throw new IllegalArgumentException("Removing ship id:" + (long)var1_1 + " failed because it couldn't be found.");
        }
        ShipType ShipType2 = ShipType;
        this.a.remove(ShipType2.getId());
        this.b.a(ShipType2.getChunkClaim());
        return ShipType2;
    }

    @JvmName(name="b")
    private int b() {
        return this.a.size();
    }

    @Override
    @Deprecated(message="This gets all ships in the AABB, irrespective of dimension. This is pretty much never what you want.", replaceWith=@ReplaceWith(expression="getIntersecting(aabb, dimensionId)", imports={}))
    public Iterable<ShipType> getIntersecting(AABBdc aabb) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"");
        Object object = this;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            Ship ship = (Ship)e2;
            if (!AABBdUtilKt.intersectsAABB(ship.getWorldAABB(), aabb)) continue;
            collection.add(e2);
        }
        return (List)collection;
    }

    @Override
    public Iterable<ShipType> getIntersecting(AABBdc aabb, String dimensionId) {
        Intrinsics.checkNotNullParameter((Object)aabb, (String)"");
        Intrinsics.checkNotNullParameter((Object)dimensionId, (String)"");
        Object object = this;
        Collection collection = new ArrayList();
        object = object.iterator();
        while (object.hasNext()) {
            Object e2 = object.next();
            Ship ship = (Ship)e2;
            if (!(AABBdUtilKt.intersectsAABB(ship.getWorldAABB(), aabb) && Intrinsics.areEqual((Object)ship.getChunkClaimDimension(), (Object)dimensionId))) continue;
            collection.add(e2);
        }
        return (List)collection;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public boolean equals(Object other) {
        void var1_1;
        if (this == other) {
            return true;
        }
        Object object = other;
        if (!Intrinsics.areEqual(this.getClass(), object != null ? object.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull((Object)other);
        em_0 cfr_ignored_0 = (em_0)other;
        return Intrinsics.areEqual(this.a, ((em_0)var1_1).a);
    }

    @Override
    public int hashCode() {
        return this.a.hashCode();
    }

    private static boolean c() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection<? extends ShipType> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean remove(Object element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection<? extends Object> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeIf(Predicate<? super ShipType> p0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection<? extends Object> elements) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public em_0() {
        this(null, 1, null);
    }

    @Override
    public /* synthetic */ boolean add(Object element) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public <T> T[] toArray(T[] array) {
        void var1_1;
        Intrinsics.checkNotNullParameter(array, (String)"");
        return CollectionToArray.toArray((Collection)this, (Object[])var1_1);
    }

    @Override
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }
}

