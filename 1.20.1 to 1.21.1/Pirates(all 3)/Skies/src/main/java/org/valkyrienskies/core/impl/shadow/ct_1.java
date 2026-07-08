/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.valkyrienskies.core.impl.shadow.bs_1;
import org.valkyrienskies.core.impl.shadow.bv_1;
import org.valkyrienskies.core.impl.shadow.dk_1;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.cT
 */
public class ct_1 {
    private boolean b;
    private boolean c;
    private bs_1 d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h = false;
    private Map<String, String> i = new HashMap<String, String>();
    private boolean j = true;
    private boolean k = true;
    public static final String a = "com.networknt.AllKeywordWalkListener";
    private final Map<String, List<dk_1>> l = new HashMap<String, List<dk_1>>();
    private final List<dk_1> m = new ArrayList<dk_1>();
    private final List<dk_1> n = new ArrayList<dk_1>();
    private bv_1 o;
    private boolean p = true;

    public boolean a() {
        return this.b;
    }

    public void a(boolean bl) {
        this.b = bl;
    }

    public void b(boolean bl) {
        this.c = bl;
    }

    public boolean b() {
        return this.c;
    }

    public void a(bs_1 bs_12) {
        this.d = bs_12;
    }

    public bs_1 c() {
        return this.d;
    }

    public Map<String, String> d() {
        return new HashMap<String, String>(this.i);
    }

    public void a(Map<String, String> map2) {
        this.i = map2;
    }

    public boolean e() {
        return this.j;
    }

    public void c(boolean bl) {
        this.j = bl;
    }

    public boolean f() {
        return this.e;
    }

    public void d(boolean bl) {
        this.e = bl;
    }

    public boolean g() {
        return this.f;
    }

    public void e(boolean bl) {
        this.f = bl;
    }

    public void a(dk_1 dk_12) {
        if (this.l.get(a) == null) {
            ArrayList arrayList = new ArrayList();
            this.l.put(a, arrayList);
        }
        this.l.get(a).add(dk_12);
    }

    public void a(String string, dk_1 dk_12) {
        if (this.l.get(string) == null) {
            ArrayList arrayList = new ArrayList();
            this.l.put(string, arrayList);
        }
        this.l.get(string).add(dk_12);
    }

    public void a(List<dk_1> list) {
        if (this.l.get(a) == null) {
            ArrayList arrayList = new ArrayList();
            this.l.put(a, arrayList);
        }
        this.l.get(a).addAll(list);
    }

    public void a(String string, List<dk_1> list) {
        if (this.l.get(string) == null) {
            ArrayList arrayList = new ArrayList();
            this.l.put(string, arrayList);
        }
        this.l.get(string).addAll(list);
    }

    public void b(List<dk_1> list) {
        this.m.addAll(list);
    }

    public void b(dk_1 dk_12) {
        this.m.add(dk_12);
    }

    public void c(dk_1 dk_12) {
        this.n.add(dk_12);
    }

    public void c(List<dk_1> list) {
        this.n.addAll(list);
    }

    public List<dk_1> h() {
        return this.m;
    }

    public Map<String, List<dk_1>> i() {
        return this.l;
    }

    public List<dk_1> j() {
        return this.n;
    }

    public bv_1 k() {
        return this.o;
    }

    public void a(bv_1 bv_12) {
        this.o = bv_12;
    }

    public boolean l() {
        return this.g;
    }

    public void f(boolean bl) {
        this.g = bl;
    }

    public boolean m() {
        return this.h;
    }

    public void g(boolean bl) {
        this.h = bl;
    }

    public void h(boolean bl) {
        this.p = bl;
    }

    public boolean n() {
        return this.p;
    }

    public boolean o() {
        return this.k;
    }

    public void i(boolean bl) {
        this.k = bl;
    }
}

