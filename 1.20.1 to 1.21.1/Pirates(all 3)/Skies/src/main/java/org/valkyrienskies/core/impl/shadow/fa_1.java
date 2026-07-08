/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.valkyrienskies.core.impl.shadow.fu_2;
import org.valkyrienskies.core.impl.shadow.fy_2;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.fA
 */
public interface fa_1<K, V> {
    public int a();

    public boolean b();

    public boolean c(Object var1);

    public boolean d(Object var1);

    public boolean a(Object var1, Object var2);

    public Collection<V> e(K var1);

    public boolean b(K var1, V var2);

    public boolean a(K var1, Iterable<? extends V> var2);

    public boolean a(Map<? extends K, ? extends V> var1);

    public boolean a(fa_1<? extends K, ? extends V> var1);

    public Collection<V> f(Object var1);

    public boolean c(Object var1, Object var2);

    public void c();

    public Collection<Map.Entry<K, V>> d();

    public fy_2<K> e();

    public Set<K> f();

    public Collection<V> g();

    public Map<K, Collection<V>> h();

    public fu_2<K, V> i();
}

