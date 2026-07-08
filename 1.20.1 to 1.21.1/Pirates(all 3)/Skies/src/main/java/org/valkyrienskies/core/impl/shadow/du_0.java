/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Du
 */
public final class du_0 {
    private final int[] c;
    private final int d;
    int a;
    int b;
    private int e;

    public du_0(int n2) {
        this.c = new int[n2 * 3];
        this.d = n2;
        this.a = -1;
        this.b = -1;
        this.e = 0;
        this.a();
    }

    public final void a(int n2) {
        int n3 = this.c(n2);
        if (this.e == 0) {
            du_0 du_02 = this;
            du_02.a = du_02.b = n2;
            this.b(n2, -1);
            this.c(n2, -1);
        } else if (n3 == 0) {
            if (n2 < this.a) {
                du_0 du_03 = this;
                du_03.b(du_03.a, n2);
                this.c(n2, this.a);
                this.a = n2;
            } else if (n2 > this.b) {
                du_0 du_04 = this;
                du_04.c(du_04.b, n2);
                this.b(n2, this.b);
                this.b = n2;
            } else {
                int n4;
                int n5 = -1;
                for (n4 = n2 - 1; n4 >= 0; --n4) {
                    if (this.c(n4) == 0) continue;
                    n5 = n4;
                    break;
                }
                n4 = this.e(n5);
                this.c(n2, n4);
                this.b(n2, n5);
                this.c(n5, n2);
                this.b(n4, n2);
            }
        }
        this.a(n2, n3 + 1);
        ++this.e;
    }

    public final void b(int n2) {
        if (this.e <= 0) {
            throw new IllegalArgumentException("Cannot decrement when list is empty");
        }
        int n3 = this.c(n2);
        if (n3 <= 0) {
            throw new IllegalArgumentException("Cannot store negative values");
        }
        if (n3 == 1) {
            if (this.e == 1) {
                this.c(n2, -1);
                this.b(n2, -1);
                this.a = -1;
                this.b = -1;
            } else if (n2 == this.a) {
                du_0 du_02 = this;
                n3 = du_02.e(du_02.a);
                du_0 du_03 = this;
                du_03.c(du_03.a, -1);
                this.b(n3, -1);
                this.a = n3;
            } else if (n2 == this.b) {
                du_0 du_04 = this;
                n3 = du_04.d(du_04.b);
                du_0 du_05 = this;
                du_05.b(du_05.b, -1);
                this.c(n3, -1);
                this.b = n3;
            } else {
                n3 = this.d(n2);
                int n4 = this.e(n2);
                this.c(n3, n4);
                this.b(n4, n3);
            }
            this.a(n2, 0);
        } else {
            this.a(n2, n3 - 1);
        }
        --this.e;
    }

    private void a(int n2, int n3) {
        this.f(n2 * 3);
        this.c[n2 * 3] = n3;
    }

    private void b(int n2, int n3) {
        this.f(n2 * 3 + 1);
        this.c[n2 * 3 + 1] = n3;
    }

    private void c(int n2, int n3) {
        this.f(n2 * 3 + 2);
        this.c[n2 * 3 + 2] = n3;
    }

    private int c(int n2) {
        this.f(n2 * 3);
        return this.c[n2 * 3];
    }

    private int d(int n2) {
        this.f(n2 * 3 + 1);
        return this.c[n2 * 3 + 1];
    }

    private int e(int n2) {
        this.f(n2 * 3 + 2);
        return this.c[n2 * 3 + 2];
    }

    private void f(int n2) {
        if (n2 < 0 || n2 > this.d * 3) {
            throw new IllegalArgumentException("Cannot store key of value " + n2);
        }
    }

    public final void a() {
        this.e = 0;
        for (int i2 = 0; i2 < this.d; ++i2) {
            this.a(i2, 0);
            this.b(i2, -1);
            this.c(i2, -1);
        }
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }
}

