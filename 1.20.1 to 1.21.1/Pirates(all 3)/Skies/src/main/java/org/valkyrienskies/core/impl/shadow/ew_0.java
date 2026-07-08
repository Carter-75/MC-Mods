/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.ints.IntArrayList
 *  it.unimi.dsi.fastutil.ints.IntList
 *  it.unimi.dsi.fastutil.objects.ObjectCollection
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function6
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.joml.Matrix4dc;
import org.valkyrienskies.core.api.ships.PositionedWing;
import org.valkyrienskies.core.api.ships.Wing;
import org.valkyrienskies.core.api.ships.WingGroupChanges;
import org.valkyrienskies.core.api.ships.WingManager;
import org.valkyrienskies.core.api.ships.WingManagerChanges;
import org.valkyrienskies.core.impl.shadow.ev_0;
import org.valkyrienskies.core.util.datastructures.BlockPos2ObjectOpenHashMap;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Ew
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u0003\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\t2\n\u0010\u0003\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u00a1\u0001\u0010\u0005\u001a\u00020\u00042\u008b\u0001\u0010\u0003\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u0010H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u001bJ\u0013\u0010\u001c\u001a\u00060\nj\u0002`\u000bH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ5\u0010!\u001a\u0004\u0018\u00010\u00182\n\u0010\u0003\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0016\u00a2\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b#\u0010$J=\u0010&\u001a\u00020\t2\n\u0010\u0003\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0016\u00a2\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\u001e\u001a\u00020\u0011H\u0016\u00a2\u0006\u0004\b(\u0010)R\u0016\u0010\u0005\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010.R\u0014\u0010*\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00101\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Ew;", "Lorg/valkyrienskies/core/api/ships/WingManager;", "Lorg/valkyrienskies/core/api/ships/WingManagerChanges;", "p0", "", "a", "(Lorg/valkyrienskies/core/api/ships/WingManagerChanges;)V", "clearWingChanges", "()V", "", "", "Lorg/valkyrienskies/core/api/ships/WingGroupId;", "createWingGroup", "(Z)I", "deleteWingGroup", "(I)Z", "Lkotlin/Function6;", "Lorg/joml/Matrix4dc;", "Lkotlin/ParameterName;", "name", "wingTransform", "posX", "posY", "posZ", "Lorg/valkyrienskies/core/api/ships/Wing;", "wing", "isContraption", "(Lkotlin/jvm/functions/Function6;)V", "getFirstWingGroupId", "()I", "p1", "p2", "p3", "getWing", "(IIII)Lorg/valkyrienskies/core/api/ships/Wing;", "getWingChanges", "()Lorg/valkyrienskies/core/api/ships/WingManagerChanges;", "p4", "setWing", "(IIIILorg/valkyrienskies/core/api/ships/Wing;)Z", "setWingGroupTransform", "(ILorg/joml/Matrix4dc;)V", "c", "I", "Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "Lorg/valkyrienskies/core/impl/shadow/Ev;", "Lit/unimi/dsi/fastutil/ints/Int2ObjectMap;", "b", "Lit/unimi/dsi/fastutil/ints/IntList;", "Lit/unimi/dsi/fastutil/ints/IntList;", "<init>"})
public final class ew_0
implements WingManager {
    private final Int2ObjectMap<ev_0> a = (Int2ObjectMap)new Int2ObjectOpenHashMap();
    private final IntList b = (IntList)new IntArrayList();
    private int c;

    /*
     * WARNING - void declaration
     */
    @Override
    public final int createWingGroup(boolean isContraption) {
        void var1_1;
        int n2 = this.c;
        this.c = n2 + 1;
        Integer n3 = n2;
        ((Map)this.a).put(n3, new ev_0());
        Object object = this.a.get(n2);
        Intrinsics.checkNotNull((Object)object);
        void var3_5 = var1_1;
        ev_0 ev_02 = (ev_0)object;
        ((ev_0)object).e = var3_5;
        return n2;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean deleteWingGroup(int wingGroupId) {
        boolean bl = this.a.remove(wingGroupId) != null;
        if (bl) {
            void var1_1;
            this.b.add((int)var1_1);
        }
        return bl;
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final boolean setWing(int wingGroupId, int posX, int posY, int posZ, Wing wing) {
        void var3_4;
        void var2_3;
        int n2;
        Object object = this.a.get(n2);
        Intrinsics.checkNotNull((Object)object);
        n2 = 16;
        n2 = 0;
        Wing wing2 = wing;
        int n3 = posZ;
        ev_0 ev_02 = (ev_0)object;
        return ev_02.a((int)var2_3, (int)var3_4, n3, wing2, true);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final Wing getWing(int wingGroupId, int posX, int posY, int posZ) {
        void var3_4;
        void var2_3;
        void var1_1;
        Object object = this.a.get((int)var1_1);
        Intrinsics.checkNotNull((Object)object);
        int n2 = posZ;
        ev_0 ev_02 = (ev_0)object;
        return ev_02.a.get((int)var2_3, (int)var3_4, n2);
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public final void setWingGroupTransform(int wingGroupId, Matrix4dc transform2) {
        void var2_3;
        void var1_1;
        Intrinsics.checkNotNullParameter((Object)transform2, (String)"");
        Object object = this.a.get((int)var1_1);
        Intrinsics.checkNotNull((Object)object);
        ev_0 ev_02 = (ev_0)object;
        Intrinsics.checkNotNullParameter((Object)var2_3, (String)"");
        ev_02.c = var2_3;
        ev_02.d = true;
    }

    @Override
    public final WingManagerChanges getWingChanges() {
        List list = null;
        for (Object object : this.a.int2ObjectEntrySet()) {
            int n2 = object.getIntKey();
            ev_0 ev_02 = (ev_0)object.getValue();
            object = ev_02;
            object = ev_02;
            if ((ev_02.b == null && !object.d ? null : (object = new WingGroupChanges(object.b, object.d ? object.c : null))) == null) continue;
            if (list == null) {
                list = new ArrayList();
            }
            list.add(new Pair((Object)n2, object));
        }
        if (list == null && this.b.isEmpty()) {
            return null;
        }
        return new WingManagerChanges(list, (List)new IntArrayList(this.b));
    }

    @Override
    public final void clearWingChanges() {
        for (ev_0 ev_02 : (ObjectCollection)this.a.values()) {
            ev_0 ev_03 = ev_02;
            ev_03 = ev_02;
            ev_02.b = null;
            ev_03.d = false;
        }
        this.b.clear();
    }

    @Override
    public final int getFirstWingGroupId() {
        if (this.c == 0) {
            throw new IllegalStateException("This wing manager has no wing groups!");
        }
        return 0;
    }

    public final void a(WingManagerChanges object) {
        Iterator iterator2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"");
        List<Integer> list = ((WingManagerChanges)object).getDeletedWingGroups();
        if (list != null) {
            iterator2 = list;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                Object e2 = iterator2.next();
                int n2 = ((Number)e2).intValue();
                this.a.remove(n2);
            }
        }
        List<Pair<Integer, WingGroupChanges>> list2 = ((WingManagerChanges)object).getWingGroupChanges();
        if (list2 != null) {
            iterator2 = list2;
            iterator2 = iterator2.iterator();
            while (iterator2.hasNext()) {
                Object v;
                Object object2 = iterator2.next();
                object = (Map)this.a;
                Object object3 = (object2 = (Pair)object2).getFirst();
                Object object4 = object.get(object3);
                if (object4 == null) {
                    object4 = new ev_0();
                    object.put(object3, object4);
                    v = object4;
                } else {
                    v = object4;
                }
                object2 = (WingGroupChanges)object2.getSecond();
                object = (ev_0)v;
                Intrinsics.checkNotNullParameter(object2, (String)"");
                if (((WingGroupChanges)object2).getChangedTransform() != null) {
                    Intrinsics.checkNotNull((Object)((WingGroupChanges)object2).getChangedTransform());
                    ((ev_0)object).c = ((ev_0)object).c;
                }
                List<PositionedWing> list3 = ((WingGroupChanges)object2).getChangedWings();
                if (list3 == null) continue;
                object2 = list3;
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object3 = object2.next();
                    object3 = (PositionedWing)object3;
                    ((ev_0)object).a(((PositionedWing)object3).getPosX(), ((PositionedWing)object3).getPosY(), ((PositionedWing)object3).getPosZ(), ((PositionedWing)object3).getWing(), false);
                }
            }
            return;
        }
    }

    private void a(Function6<? super Matrix4dc, ? super Integer, ? super Integer, ? super Integer, ? super Wing, ? super Boolean, Unit> function6) {
        Intrinsics.checkNotNullParameter(function6, (String)"");
        Object object = this;
        for (ev_0 ev_02 : (ObjectCollection)((ew_0)object).a.values()) {
            int n2;
            int n3;
            int n4;
            Wing wing;
            BlockPos2ObjectOpenHashMap<Wing> blockPos2ObjectOpenHashMap = ev_02;
            object = ev_02;
            blockPos2ObjectOpenHashMap = ev_02.a;
            if (blockPos2ObjectOpenHashMap.getContainsNullKey()) {
                wing = (Wing)blockPos2ObjectOpenHashMap.getValues()[blockPos2ObjectOpenHashMap.getN()];
                n4 = blockPos2ObjectOpenHashMap.getKeys()[blockPos2ObjectOpenHashMap.getN() * 3 + 2];
                n3 = blockPos2ObjectOpenHashMap.getKeys()[blockPos2ObjectOpenHashMap.getN() * 3 + 1];
                n2 = blockPos2ObjectOpenHashMap.getKeys()[blockPos2ObjectOpenHashMap.getN() * 3];
                ev_0 ev_03 = ev_02;
                object = ev_03;
                object = ev_02;
                function6.invoke((Object)ev_03.c, (Object)n2, (Object)n3, (Object)n4, (Object)wing, (Object)((ev_0)object).e);
            }
            for (int i2 = blockPos2ObjectOpenHashMap.getN(); i2 >= 0; --i2) {
                if (blockPos2ObjectOpenHashMap.getKeys()[i2 * 3] == 0 && blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 1] == 0 && blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 2] == 0) continue;
                wing = (Wing)blockPos2ObjectOpenHashMap.getValues()[i2];
                n4 = blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 2];
                n3 = blockPos2ObjectOpenHashMap.getKeys()[i2 * 3 + 1];
                n2 = blockPos2ObjectOpenHashMap.getKeys()[i2 * 3];
                ev_0 ev_04 = ev_02;
                object = ev_04;
                object = ev_02;
                function6.invoke((Object)ev_04.c, (Object)n2, (Object)n3, (Object)n4, (Object)wing, (Object)((ev_0)object).e);
            }
        }
    }

    public static final /* synthetic */ Int2ObjectMap a(ew_0 ew_02) {
        return ew_02.a;
    }
}

