/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.valkyrienskies.core.impl.shadow.sd
 */
package org.valkyrienskies.core.impl.shadow;

import org.valkyrienskies.core.impl.shadow.sd;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.sd
 */
@Deprecated
public final class sd_0<T extends Comparable<T>> {
    a a = null;

    private void a(T t) {
        if (t != null) {
            if (this.a == null) {
                this.a = new a(this, t, null);
                return;
            }
            this.a.a(t);
        }
    }

    private boolean b(T object) {
        if (object != null) {
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            block42: {
                Object object6;
                object5 = object;
                object4 = this;
                object3 = null;
                object4 = ((sd_0)object4).a;
                while (object4 != null) {
                    object2 = object4;
                    if (((a)object2).a.compareTo(object5) < 0) {
                        object2 = object4;
                        if (((a)object2).c == null) {
                            object6 = object3;
                            break block42;
                        }
                        object2 = object4;
                        object4 = ((a)object2).c;
                        continue;
                    }
                    object3 = object4;
                    object2 = object4;
                    if (((a)object2).b == null) {
                        object6 = object3;
                        break block42;
                    }
                    object2 = object4;
                    object4 = ((a)object2).b;
                }
                object6 = object4 = null;
            }
            while (object4 != null) {
                a a2;
                block43: {
                    object2 = object4;
                    if (((a)object2).a == object) {
                        if (((a)object4).d == null && ((a)object4).b == null && ((a)object4).c == null) {
                            ((a)object4).a = null;
                            object4 = null;
                            object = ((a)object4).f;
                            ((a)object4).f.a = null;
                        } else {
                            a a3;
                            int n2;
                            if (((a)object4).b == null && ((a)object4).c == null) {
                                object5 = object4;
                                ((a)object4).a = null;
                                Object object7 = object5;
                                n2 = object7 == ((a)object7).d.b ? 1 : 0;
                                a3 = null;
                            } else {
                                object5 = ((a)object4).b != null ? ((a)object4).b.c() : ((a)object4).c.b();
                                ((a)object4).a = ((a)object5).a;
                                Object object8 = object5;
                                n2 = object8 == ((a)object8).d.b ? 1 : 0;
                                a3 = ((a)object5).b != null ? ((a)object5).b : ((a)object5).c;
                            }
                            object3 = a3;
                            object5 = ((a)object5).d;
                            if (n2 != 0) {
                                ((a)object5).b = object3;
                            } else {
                                ((a)object5).c = object3;
                            }
                            if (object3 != null) {
                                ((a)object3).d = object5;
                            }
                            while (true) {
                                if (n2 != 0) {
                                    boolean bl;
                                    object = object5;
                                    switch (1.a[((a)object).e - 1]) {
                                        case 1: {
                                            ((a)object).e = b.BALANCED$7e36164e;
                                            bl = true;
                                            break;
                                        }
                                        case 2: {
                                            if (((a)object).c.e == b.RIGHT_HIGH$7e36164e) {
                                                ((a)object).g();
                                                ((a)object).e = b.BALANCED$7e36164e;
                                                ((a)object).b.e = b.BALANCED$7e36164e;
                                                bl = true;
                                                break;
                                            }
                                            if (((a)object).c.e == b.BALANCED$7e36164e) {
                                                ((a)object).g();
                                                ((a)object).e = b.LEFT_HIGH$7e36164e;
                                                ((a)object).b.e = b.RIGHT_HIGH$7e36164e;
                                                bl = false;
                                                break;
                                            }
                                            n2 = ((a)object).c.b.e;
                                            ((a)object).c.f();
                                            ((a)object).g();
                                            switch (1.a[n2 - 1]) {
                                                case 1: {
                                                    ((a)object).b.e = b.BALANCED$7e36164e;
                                                    ((a)object).c.e = b.RIGHT_HIGH$7e36164e;
                                                    break;
                                                }
                                                case 2: {
                                                    ((a)object).b.e = b.LEFT_HIGH$7e36164e;
                                                    ((a)object).c.e = b.BALANCED$7e36164e;
                                                    break;
                                                }
                                                default: {
                                                    ((a)object).b.e = b.BALANCED$7e36164e;
                                                    ((a)object).c.e = b.BALANCED$7e36164e;
                                                }
                                            }
                                            ((a)object).e = b.BALANCED$7e36164e;
                                            bl = true;
                                            break;
                                        }
                                        default: {
                                            ((a)object).e = b.RIGHT_HIGH$7e36164e;
                                            bl = false;
                                        }
                                    }
                                    if (!bl) break;
                                } else {
                                    boolean bl;
                                    object = object5;
                                    switch (1.a[((a)object).e - 1]) {
                                        case 2: {
                                            ((a)object).e = b.BALANCED$7e36164e;
                                            bl = true;
                                            break;
                                        }
                                        case 1: {
                                            if (((a)object).b.e == b.LEFT_HIGH$7e36164e) {
                                                ((a)object).f();
                                                ((a)object).e = b.BALANCED$7e36164e;
                                                ((a)object).c.e = b.BALANCED$7e36164e;
                                                bl = true;
                                                break;
                                            }
                                            if (((a)object).b.e == b.BALANCED$7e36164e) {
                                                ((a)object).f();
                                                ((a)object).e = b.RIGHT_HIGH$7e36164e;
                                                ((a)object).c.e = b.LEFT_HIGH$7e36164e;
                                                bl = false;
                                                break;
                                            }
                                            n2 = ((a)object).b.c.e;
                                            ((a)object).b.g();
                                            ((a)object).f();
                                            switch (1.a[n2 - 1]) {
                                                case 1: {
                                                    ((a)object).b.e = b.BALANCED$7e36164e;
                                                    ((a)object).c.e = b.RIGHT_HIGH$7e36164e;
                                                    break;
                                                }
                                                case 2: {
                                                    ((a)object).b.e = b.LEFT_HIGH$7e36164e;
                                                    ((a)object).c.e = b.BALANCED$7e36164e;
                                                    break;
                                                }
                                                default: {
                                                    ((a)object).b.e = b.BALANCED$7e36164e;
                                                    ((a)object).c.e = b.BALANCED$7e36164e;
                                                }
                                            }
                                            ((a)object).e = b.BALANCED$7e36164e;
                                            bl = true;
                                            break;
                                        }
                                        default: {
                                            ((a)object).e = b.LEFT_HIGH$7e36164e;
                                            bl = false;
                                        }
                                    }
                                    if (!bl) break;
                                }
                                if (((a)object5).d == null) break;
                                Object object9 = object5;
                                n2 = object9 == ((a)object9).d.b ? 1 : 0;
                                object5 = ((a)object5).d;
                            }
                        }
                        return true;
                    }
                    object2 = object4;
                    if (((a)object2).a.compareTo(object) > 0) {
                        return false;
                    }
                    if (((a)object4).c != null && (object5 = ((a)object4).c.b()) != null) {
                        a2 = (a)object5;
                    } else {
                        object5 = object4;
                        while (((a)object5).d != null) {
                            Object object10 = object5;
                            if (object10 != ((a)object10).d.c) {
                                a2 = ((a)object5).d;
                                break block43;
                            }
                            object5 = ((a)object5).d;
                        }
                        a2 = null;
                    }
                }
                object4 = a2;
            }
        }
        return false;
    }

    private boolean a() {
        return this.a == null;
    }

    private int b() {
        if (this.a == null) {
            return 0;
        }
        return this.a.a();
    }

    private a c() {
        if (this.a == null) {
            return null;
        }
        return this.a.b();
    }

    private a d() {
        if (this.a == null) {
            return null;
        }
        return this.a.c();
    }

    private a c(T t) {
        a a2 = null;
        a a3 = this.a;
        while (a3 != null) {
            a a4 = a3;
            if (a4.a.compareTo(t) < 0) {
                a4 = a3;
                if (a4.c == null) {
                    return a2;
                }
                a4 = a3;
                a3 = a4.c;
                continue;
            }
            a2 = a3;
            a4 = a3;
            if (a4.b == null) {
                return a2;
            }
            a4 = a3;
            a3 = a4.b;
        }
        return null;
    }

    private a d(T t) {
        a a2 = null;
        a a3 = this.a;
        while (a3 != null) {
            a a4 = a3;
            if (a4.a.compareTo(t) > 0) {
                a4 = a3;
                if (a4.b == null) {
                    return a2;
                }
                a4 = a3;
                a3 = a4.b;
                continue;
            }
            a2 = a3;
            a4 = a3;
            if (a4.c == null) {
                return a2;
            }
            a4 = a3;
            a3 = a4.c;
        }
        return null;
    }

    static /* synthetic */ a a(sd_0 sd_02, a a2) {
        sd_02.a = null;
        return null;
    }

    static final class 1 {
        static final /* synthetic */ int[] a;

        static {
            a = new int[b.values$2eacb26c().length];
            try {
                1.a[b.LEFT_HIGH$7e36164e - 1] = 1;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                1.a[b.RIGHT_HIGH$7e36164e - 1] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static final class a {
        T a;
        a b;
        a c;
        a d;
        int e;
        final /* synthetic */ sd_0 f;

        a(T t, a a2) {
            this.f = var1_1;
            this.a = t;
            this.b = null;
            this.c = null;
            this.d = a2;
            this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
        }

        private T h() {
            return this.a;
        }

        final int a() {
            return 1 + (this.b == null ? 0 : this.b.a()) + (this.c == null ? 0 : this.c.a());
        }

        final a b() {
            a a2 = this;
            while (a2.b != null) {
                a2 = a2.b;
            }
            return a2;
        }

        final a c() {
            a a2 = this;
            while (a2.c != null) {
                a2 = a2.c;
            }
            return a2;
        }

        private a i() {
            a a2;
            if (this.b != null && (a2 = this.b.c()) != null) {
                return a2;
            }
            a2 = this;
            while (a2.d != null) {
                a a3 = a2;
                if (a3 != a3.d.b) {
                    return a2.d;
                }
                a2 = a2.d;
            }
            return null;
        }

        public final a d() {
            a a2;
            if (this.c != null && (a2 = this.c.b()) != null) {
                return a2;
            }
            a2 = this;
            while (a2.d != null) {
                a a3 = a2;
                if (a3 != a3.d.c) {
                    return a2.d;
                }
                a2 = a2.d;
            }
            return null;
        }

        final boolean a(T t) {
            if (t.compareTo(this.a) < 0) {
                if (this.b == null) {
                    this.b = new a(this.f, t, this);
                    return this.j();
                }
                if (this.b.a(t)) {
                    return this.j();
                }
                return false;
            }
            if (this.c == null) {
                this.c = new a(this.f, t, this);
                return this.k();
            }
            if (this.c.a(t)) {
                return this.k();
            }
            return false;
        }

        public final void e() {
            a a2;
            boolean bl;
            a a3;
            if (this.d == null && this.b == null && this.c == null) {
                this.a = null;
                sd_0 sd_02 = null;
                sd_02 = this.f;
                ((sd)this.f).a = null;
                return;
            }
            if (this.b == null && this.c == null) {
                a3 = this;
                this.a = null;
                a a4 = a3;
                bl = a4 == a4.d.b;
                a2 = null;
            } else {
                a3 = this.b != null ? this.b.c() : this.c.b();
                this.a = a3.a;
                a a5 = a3;
                bl = a5 == a5.d.b;
                a2 = a3.b != null ? a3.b : a3.c;
            }
            a a6 = a2;
            a3 = a3.d;
            if (bl) {
                a3.b = a6;
            } else {
                a3.c = a6;
            }
            if (a6 != null) {
                a6.d = a3;
            }
            while (bl ? a3.l() : a3.m()) {
                if (a3.d == null) {
                    return;
                }
                a a7 = a3;
                bl = a7 == a7.d.b;
                a3 = a3.d;
            }
        }

        private boolean j() {
            switch (1.a[this.e - 1]) {
                case 1: {
                    if (this.b.e == org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e) {
                        this.f();
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    } else {
                        int n2 = this.b.c.e;
                        this.b.g();
                        this.f();
                        switch (1.a[n2 - 1]) {
                            case 1: {
                                this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                                this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
                                break;
                            }
                            case 2: {
                                this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
                                this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                                break;
                            }
                            default: {
                                this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                                this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            }
                        }
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    }
                    return false;
                }
                case 2: {
                    this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    return false;
                }
            }
            this.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
            return true;
        }

        private boolean k() {
            switch (1.a[this.e - 1]) {
                case 1: {
                    this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    return false;
                }
                case 2: {
                    if (this.c.e == org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e) {
                        this.g();
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    } else {
                        int n2 = this.c.b.e;
                        this.c.f();
                        this.g();
                        switch (1.a[n2 - 1]) {
                            case 1: {
                                this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                                this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
                                break;
                            }
                            case 2: {
                                this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
                                this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                                break;
                            }
                            default: {
                                this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                                this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            }
                        }
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    }
                    return false;
                }
            }
            this.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
            return true;
        }

        private boolean l() {
            switch (1.a[this.e - 1]) {
                case 1: {
                    this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    return true;
                }
                case 2: {
                    if (this.c.e == org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e) {
                        this.g();
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        return true;
                    }
                    if (this.c.e == org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e) {
                        this.g();
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
                        this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
                        return false;
                    }
                    int n2 = this.c.b.e;
                    this.c.f();
                    this.g();
                    switch (1.a[n2 - 1]) {
                        case 1: {
                            this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
                            break;
                        }
                        case 2: {
                            this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
                            this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            break;
                        }
                        default: {
                            this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        }
                    }
                    this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    return true;
                }
            }
            this.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
            return false;
        }

        private boolean m() {
            switch (1.a[this.e - 1]) {
                case 2: {
                    this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    return true;
                }
                case 1: {
                    if (this.b.e == org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e) {
                        this.f();
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        return true;
                    }
                    if (this.b.e == org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e) {
                        this.f();
                        this.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
                        this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
                        return false;
                    }
                    int n2 = this.b.c.e;
                    this.b.g();
                    this.f();
                    switch (1.a[n2 - 1]) {
                        case 1: {
                            this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.RIGHT_HIGH$7e36164e;
                            break;
                        }
                        case 2: {
                            this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
                            this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            break;
                        }
                        default: {
                            this.b.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                            this.c.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                        }
                    }
                    this.e = org.valkyrienskies.core.impl.shadow.sd$b.BALANCED$7e36164e;
                    return true;
                }
            }
            this.e = org.valkyrienskies.core.impl.shadow.sd$b.LEFT_HIGH$7e36164e;
            return false;
        }

        void f() {
            Object object = this.a;
            this.a = this.b.a;
            this.b.a = object;
            object = this.b;
            this.b = ((a)object).b;
            ((a)object).b = ((a)object).c;
            ((a)object).c = this.c;
            this.c = object;
            if (this.b != null) {
                this.b.d = this;
            }
            if (this.c.c != null) {
                this.c.c.d = this.c;
            }
        }

        void g() {
            Object object = this.a;
            this.a = this.c.a;
            this.c.a = object;
            object = this.c;
            this.c = ((a)object).c;
            ((a)object).c = ((a)object).b;
            ((a)object).b = this.b;
            this.b = object;
            if (this.c != null) {
                this.c.d = this;
            }
            if (this.b.b != null) {
                this.b.b.d = this.b;
            }
        }

        static /* synthetic */ Comparable a(a a2) {
            return a2.a;
        }

        static /* synthetic */ a b(a a2) {
            return a2.c;
        }

        static /* synthetic */ a c(a a2) {
            return a2.b;
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class b
    extends Enum<b> {
        public static final int LEFT_HIGH$7e36164e = 1;
        public static final int RIGHT_HIGH$7e36164e = 2;
        public static final int BALANCED$7e36164e = 3;
        private static final /* synthetic */ int[] $VALUES$313b9e6d;

        public static int[] values$2eacb26c() {
            return (int[])$VALUES$313b9e6d.clone();
        }

        private b() {
        }

        static {
            $VALUES$313b9e6d = new int[]{LEFT_HIGH$7e36164e, RIGHT_HIGH$7e36164e, BALANCED$7e36164e};
        }
    }
}

