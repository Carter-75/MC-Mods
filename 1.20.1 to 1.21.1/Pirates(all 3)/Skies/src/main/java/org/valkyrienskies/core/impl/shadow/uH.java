/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.List;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.kO;
import org.valkyrienskies.core.impl.shadow.uG;
import org.valkyrienskies.core.impl.shadow.uK;
import org.valkyrienskies.core.impl.shadow.uN;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class uH<T extends kO<T>> {
    final uN<T> a;
    List<uK<T>> b;
    public uG<T> c;

    private uH(uN<T> uN2) {
        this.a = uN2;
        this.b = new ArrayList<uK<T>>();
        this.c = new uG(null, uN2.a());
    }

    public final uG<T> a() {
        return this.c;
    }

    private int a(uK<T> uK2) {
        this.b.add(uK2);
        this.c = new uG<T>(this.c, uK2.a());
        return this.b.size();
    }

    public final void a(T t, T[] TArray, T object) {
        int n2 = 0;
        this.c.a(0, (kO[])TArray);
        while (true) {
            object = this.c;
            if (++n2 >= ((uG)object).a.length - 1) break;
            this.c.a(n2, (kO[])TArray);
            this.b.get(n2 - 1);
        }
    }

    public final T[] a(T object, T[] TArray) {
        object = (kO[])ch_0.a(object.c(), this.c.b());
        int n2 = 0;
        this.c.a(0, (kO[])TArray);
        kO[] kOArray = this.a.c();
        this.c.a(0, kOArray, (kO[])object);
        while (true) {
            kOArray = this.c;
            if (++n2 >= kOArray.a.length - 1) break;
            this.c.a(n2, (kO[])TArray);
            kOArray = this.b.get(n2 - 1).c();
            this.c.a(n2, kOArray, (kO[])object);
        }
        return object;
    }
}

