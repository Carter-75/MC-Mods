/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Map;
import org.valkyrienskies.core.impl.shadow.ey_1;
import org.valkyrienskies.core.impl.shadow.fb_1;
import org.valkyrienskies.core.impl.shadow.fe_1;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.gk_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.gm
 */
public abstract class gm_2<K, V>
extends gk_2<K, V>
implements fb_1<K, V> {
    protected gm_2(fb_1<K, V> fb_12) {
        super(fb_12);
    }

    protected fb_1<K, V> j() {
        return (fb_1)super.h();
    }

    @Override
    public fe_1<K, V> e() {
        return this.j().e();
    }

    @Override
    public K firstKey() {
        return this.j().firstKey();
    }

    @Override
    public K lastKey() {
        return this.j().lastKey();
    }

    @Override
    public final K c(K k2) {
        return this.j().c(k2);
    }

    @Override
    public final K d(K k2) {
        return this.j().d(k2);
    }

    @Override
    public fb_1<V, K> d() {
        return this.j().d();
    }

    @Override
    public /* synthetic */ ey_1 a() {
        return this.d();
    }

    @Override
    public /* synthetic */ fu_2 c() {
        return this.e();
    }

    @Override
    protected /* synthetic */ ey_1 h() {
        return this.j();
    }

    @Override
    public /* synthetic */ Map i() {
        return this.j();
    }
}

