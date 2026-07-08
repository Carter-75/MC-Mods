/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.eC$a
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.eC;
import org.valkyrienskies.core.impl.shadow.ec_2;
import org.valkyrienskies.core.impl.shadow.eg_2;
import org.valkyrienskies.core.impl.shadow.ek_2;
import org.valkyrienskies.core.impl.shadow.eo_2;
import org.valkyrienskies.core.impl.shadow.ev_2;
import org.valkyrienskies.core.impl.shadow.ew_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.eC
 */
public final class ec_1<T>
implements ek_2<Set<T>> {
    private static final ek_2<Set<Object>> a = eo_2.a(Collections.emptySet());
    private final List<ew_2<T>> b;
    private final List<ew_2<Collection<T>>> c;

    private static <T> ek_2<Set<T>> a() {
        return a;
    }

    private static <T> ec_2.a_0<T> a(int individualProviderSize, int collectionProviderSize) {
        return new eC.a(individualProviderSize, collectionProviderSize, 0);
    }

    private ec_1(List<ew_2<T>> individualProviders, List<ew_2<Collection<T>>> collectionProviders) {
        this.b = individualProviders;
        this.c = collectionProviders;
    }

    private Set<T> b() {
        int n2 = this.b.size();
        ArrayList<Collection> arrayList = new ArrayList<Collection>(this.c.size());
        int n3 = this.c.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            Collection collection = (Collection)this.c.get(i2).get();
            n2 += collection.size();
            arrayList.add(collection);
        }
        HashSet<Object> hashSet = new HashSet<Object>(eg_2.d(n2));
        int n4 = this.b.size();
        for (n3 = 0; n3 < n4; ++n3) {
            hashSet.add(ev_2.a(this.b.get(n3).get()));
        }
        n4 = arrayList.size();
        for (n3 = 0; n3 < n4; ++n3) {
            for (Object e2 : (Collection)arrayList.get(n3)) {
                hashSet.add(ev_2.a(e2));
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override
    public final /* synthetic */ Object get() {
        ec_1 ec_12 = this;
        int n2 = ec_12.b.size();
        ArrayList<Collection> arrayList = new ArrayList<Collection>(ec_12.c.size());
        int n3 = ec_12.c.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            Collection collection = (Collection)ec_12.c.get(i2).get();
            n2 += collection.size();
            arrayList.add(collection);
        }
        HashSet<Object> hashSet = new HashSet<Object>(eg_2.d(n2));
        int n4 = ec_12.b.size();
        for (n3 = 0; n3 < n4; ++n3) {
            hashSet.add(ev_2.a(ec_12.b.get(n3).get()));
        }
        n4 = arrayList.size();
        for (n3 = 0; n3 < n4; ++n3) {
            for (Object e2 : (Collection)arrayList.get(n3)) {
                hashSet.add(ev_2.a(e2));
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* synthetic */ ec_1(List list, List list2, byte by) {
        this(list, list2);
    }
}

