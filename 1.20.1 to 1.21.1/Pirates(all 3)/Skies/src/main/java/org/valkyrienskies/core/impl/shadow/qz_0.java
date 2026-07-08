/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.pj_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pm_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qF;
import org.valkyrienskies.core.impl.shadow.qp_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.qz
 */
public abstract class qz_0
implements qF {
    List<qp_0> a;
    private int b;

    public qz_0(int n2) {
        this(Collections.emptyList(), n2);
    }

    public qz_0(List<qp_0> list, int n2) {
        if (list == null) {
            throw new pl_0();
        }
        if (n2 <= 0) {
            throw new pj_0(px_0.POPULATION_LIMIT_NOT_POSITIVE, n2);
        }
        if (list.size() > n2) {
            throw new pm_0(px_0.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, (Number)list.size(), n2, false);
        }
        this.b = n2;
        this.a = new ArrayList<qp_0>(n2);
        this.a.addAll(list);
    }

    @Deprecated
    private void a(List<qp_0> list) {
        if (list == null) {
            throw new pl_0();
        }
        if (list.size() > this.b) {
            throw new pm_0(px_0.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, (Number)list.size(), this.b, false);
        }
        this.a.clear();
        this.a.addAll(list);
    }

    private void a(Collection<qp_0> collection) {
        if (this.a.size() + collection.size() > this.b) {
            throw new pm_0(px_0.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, (Number)this.a.size(), this.b, false);
        }
        this.a.addAll(collection);
    }

    public final List<qp_0> b() {
        return Collections.unmodifiableList(this.a);
    }

    protected final List<qp_0> c() {
        return this.a;
    }

    @Override
    public final void a(qp_0 qp_02) {
        if (this.a.size() >= this.b) {
            throw new pm_0(px_0.LIST_OF_CHROMOSOMES_BIGGER_THAN_POPULATION_SIZE, (Number)this.a.size(), this.b, false);
        }
        this.a.add(qp_02);
    }

    @Override
    public final qp_0 d() {
        qp_0 qp_02 = this.a.get(0);
        for (qp_0 qp_03 : this.a) {
            if (qp_03.b(qp_02) <= 0) continue;
            qp_02 = qp_03;
        }
        return qp_02;
    }

    @Override
    public final int e() {
        return this.b;
    }

    private void a(int n2) {
        if (n2 <= 0) {
            throw new pj_0(px_0.POPULATION_LIMIT_NOT_POSITIVE, n2);
        }
        if (n2 < this.a.size()) {
            throw new pn_0(n2, (Number)this.a.size(), true);
        }
        this.b = n2;
    }

    @Override
    public final int f() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }

    @Override
    public Iterator<qp_0> iterator() {
        qz_0 qz_02 = this;
        return Collections.unmodifiableList(qz_02.a).iterator();
    }
}

