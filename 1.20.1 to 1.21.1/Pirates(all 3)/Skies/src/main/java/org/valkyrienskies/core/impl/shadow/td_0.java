/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BY;
import org.valkyrienskies.core.impl.shadow.ch_0;
import org.valkyrienskies.core.impl.shadow.ci_0;
import org.valkyrienskies.core.impl.shadow.cq_0;
import org.valkyrienskies.core.impl.shadow.kM;
import org.valkyrienskies.core.impl.shadow.kN;
import org.valkyrienskies.core.impl.shadow.oS;
import org.valkyrienskies.core.impl.shadow.oU;
import org.valkyrienskies.core.impl.shadow.pf_0;
import org.valkyrienskies.core.impl.shadow.pl_0;
import org.valkyrienskies.core.impl.shadow.pn_0;
import org.valkyrienskies.core.impl.shadow.po_0;
import org.valkyrienskies.core.impl.shadow.pr_0;
import org.valkyrienskies.core.impl.shadow.pw_0;
import org.valkyrienskies.core.impl.shadow.px_0;
import org.valkyrienskies.core.impl.shadow.qd_0;
import org.valkyrienskies.core.impl.shadow.qg_0;
import org.valkyrienskies.core.impl.shadow.sA;
import org.valkyrienskies.core.impl.shadow.sC;
import org.valkyrienskies.core.impl.shadow.sD;
import org.valkyrienskies.core.impl.shadow.sI;
import org.valkyrienskies.core.impl.shadow.sM;
import org.valkyrienskies.core.impl.shadow.sQ;
import org.valkyrienskies.core.impl.shadow.sT;
import org.valkyrienskies.core.impl.shadow.su_0;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sw_0;
import org.valkyrienskies.core.impl.shadow.sx_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.sz_0;
import org.valkyrienskies.core.impl.shadow.tA;
import org.valkyrienskies.core.impl.shadow.tC;
import org.valkyrienskies.core.impl.shadow.tc_0;
import org.valkyrienskies.core.impl.shadow.th_0;
import org.valkyrienskies.core.impl.shadow.tj_0;
import org.valkyrienskies.core.impl.shadow.tn_0;
import org.valkyrienskies.core.impl.shadow.tq_0;
import org.valkyrienskies.core.impl.shadow.ts_0;
import org.valkyrienskies.core.impl.shadow.tu_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.td
 */
public final class td_0 {
    private static ts_0 a;
    private static ts_0 b;

    private td_0() {
    }

    public static sv_0 a(int n2, int n3) {
        if (n2 * n3 <= 4096) {
            return new sy_0(n2, n3);
        }
        return new sD(n2, n3);
    }

    private static <T extends kN<T>> sQ<T> a(kM<T> kM2, int n2, int n3) {
        if (n2 * n3 <= 4096) {
            return new sx_0<T>(kM2, n2, n3);
        }
        return new sC<T>(kM2, n2, n3);
    }

    public static sv_0 a(double[][] dArray) {
        if (dArray == null || dArray[0] == null) {
            throw new pl_0();
        }
        if (dArray.length * dArray[0].length <= 4096) {
            return new sy_0(dArray);
        }
        return new sD(dArray);
    }

    private static <T extends kN<T>> sQ<T> a(T[][] TArray) {
        if (TArray == null || TArray[0] == null) {
            throw new pl_0();
        }
        if (TArray.length * TArray[0].length <= 4096) {
            return new sx_0(TArray);
        }
        return new sC(TArray);
    }

    public static tq_0 a(int n2) {
        int n3 = n2;
        sv_0 sv_02 = td_0.a(n3, n3);
        int n4 = 0;
        while (n4 < n2) {
            int n5 = n4++;
            sv_02.c(n5, n5, 1.0);
        }
        return sv_02;
    }

    public static <T extends kN<T>> sQ<T> a(kM<T> kM2, int n2) {
        kN kN2 = (kN)kM2.a();
        kN kN3 = (kN)kM2.b();
        int n3 = n2;
        kN[][] kNArray = (kN[][])ch_0.a(kM2, n3, n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            Object[] objectArray = kNArray[i2];
            Arrays.fill(objectArray, kN2);
            objectArray[i2] = kN3;
        }
        return new sx_0(kM2, kNArray, false);
    }

    public static tq_0 a(double[] dArray) {
        sv_0 sv_02 = td_0.a(dArray.length, dArray.length);
        for (int i2 = 0; i2 < dArray.length; ++i2) {
            int n2 = i2;
            sv_02.c(n2, n2, dArray[i2]);
        }
        return sv_02;
    }

    private static <T extends kN<T>> sQ<T> a(T[] TArray) {
        su_0 su_02 = td_0.a(TArray[0].c(), (int)TArray.length, (int)TArray.length);
        for (int i2 = 0; i2 < TArray.length; ++i2) {
            int n2 = i2;
            su_02.a(n2, n2, TArray[i2]);
        }
        return su_02;
    }

    public static sA b(double[] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        return new sA(dArray, true);
    }

    private static <T extends kN<T>> sT<T> b(T[] TArray) {
        if (TArray == null) {
            throw new pl_0();
        }
        if (TArray.length == 0) {
            throw new pr_0(px_0.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
        }
        return new sz_0(TArray[0].c(), TArray, true);
    }

    private static tq_0 d(double[] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        int n2 = dArray.length;
        sv_0 sv_02 = td_0.a(1, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            sv_02.c(0, i2, dArray[i2]);
        }
        return sv_02;
    }

    private static <T extends kN<T>> sQ<T> c(T[] TArray) {
        if (TArray == null) {
            throw new pl_0();
        }
        int n2 = TArray.length;
        if (n2 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_COLUMN);
        }
        su_0 su_02 = td_0.a(TArray[0].c(), (int)1, (int)n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            su_02.a(0, i2, TArray[i2]);
        }
        return su_02;
    }

    public static tq_0 c(double[] dArray) {
        if (dArray == null) {
            throw new pl_0();
        }
        int n2 = dArray.length;
        sv_0 sv_02 = td_0.a(n2, 1);
        for (int i2 = 0; i2 < n2; ++i2) {
            sv_02.c(i2, 0, dArray[i2]);
        }
        return sv_02;
    }

    private static <T extends kN<T>> sQ<T> d(T[] TArray) {
        if (TArray == null) {
            throw new pl_0();
        }
        int n2 = TArray.length;
        if (n2 == 0) {
            throw new pf_0(px_0.AT_LEAST_ONE_ROW);
        }
        su_0 su_02 = td_0.a(TArray[0].c(), (int)n2, (int)1);
        for (int i2 = 0; i2 < n2; ++i2) {
            su_02.a(i2, 0, TArray[i2]);
        }
        return su_02;
    }

    private static boolean a(tq_0 tq_02, double d2, boolean bl) {
        int n2 = tq_02.f();
        if (n2 != tq_02.g()) {
            if (bl) {
                throw new th_0(n2, tq_02.g());
            }
            return false;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = i2 + 1; i3 < n2; ++i3) {
                double d3;
                double d4 = tq_02.b(i2, i3);
                if (!(BY.w(d4 - (d3 = tq_02.b(i3, i2))) > BY.e(BY.w(d4), BY.w(d3)) * d2)) continue;
                if (bl) {
                    throw new tj_0(i2, i3, d2);
                }
                return false;
            }
        }
        return true;
    }

    private static void b(tq_0 tq_02, double d2) {
        td_0.a(tq_02, d2, true);
    }

    public static boolean a(tq_0 tq_02, double d2) {
        return td_0.a(tq_02, d2, false);
    }

    public static void a(sv_0 sv_02, int n2, int n3) {
        td_0.a((sw_0)sv_02, n2);
        td_0.b((sw_0)sv_02, n3);
    }

    public static void a(sw_0 sw_02, int n2) {
        if (n2 < 0 || n2 >= sw_02.f()) {
            throw new po_0(px_0.ROW_INDEX, (Number)n2, 0, sw_02.f() - 1);
        }
    }

    public static void b(sw_0 sw_02, int n2) {
        if (n2 < 0 || n2 >= sw_02.g()) {
            throw new po_0(px_0.COLUMN_INDEX, (Number)n2, 0, sw_02.g() - 1);
        }
    }

    public static void a(sv_0 sv_02, int n2, int n3, int n4, int n5) {
        td_0.a((sw_0)sv_02, n2);
        td_0.a((sw_0)sv_02, n3);
        if (n3 < n2) {
            throw new pn_0((pw_0)px_0.INITIAL_ROW_AFTER_FINAL_ROW, (Number)n3, n2, false);
        }
        td_0.b((sw_0)sv_02, n4);
        td_0.b((sw_0)sv_02, n5);
        if (n5 < n4) {
            throw new pn_0((pw_0)px_0.INITIAL_COLUMN_AFTER_FINAL_COLUMN, (Number)n5, n4, false);
        }
    }

    public static void a(sv_0 sv_02, int[] nArray, int[] nArray2) {
        if (nArray == null) {
            throw new pl_0();
        }
        if (nArray2 == null) {
            throw new pl_0();
        }
        if (nArray.length == 0) {
            throw new pf_0(px_0.EMPTY_SELECTED_ROW_INDEX_ARRAY);
        }
        if (nArray2.length == 0) {
            throw new pf_0(px_0.EMPTY_SELECTED_COLUMN_INDEX_ARRAY);
        }
        for (int n2 : nArray) {
            td_0.a((sw_0)sv_02, n2);
        }
        nArray = nArray2;
        int n3 = nArray2.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n2;
            n2 = nArray[i2];
            td_0.b((sw_0)sv_02, n2);
        }
    }

    public static void a(tq_0 tq_02, tq_0 tq_03) {
        if (tq_02.f() != tq_03.f() || tq_02.g() != tq_03.g()) {
            throw new tc_0(tq_02.f(), tq_02.g(), tq_03.f(), tq_03.g());
        }
    }

    public static void a(sv_0 sv_02, tq_0 tq_02) {
        if (sv_02.f() != tq_02.f() || sv_02.g() != tq_02.g()) {
            throw new tc_0(sv_02.f(), sv_02.g(), tq_02.f(), tq_02.g());
        }
    }

    public static void b(sv_0 sv_02, tq_0 tq_02) {
        if (sv_02.g() != tq_02.f()) {
            throw new oS(sv_02.g(), tq_02.f());
        }
    }

    private static sy_0 b(sQ<qg_0> object) {
        b b2 = new b();
        object.c(b2);
        object = b2;
        return new sy_0(((b)object).a, false);
    }

    public static sy_0 a(sQ<qd_0> object) {
        a a2 = new a();
        object.c(a2);
        object = a2;
        return new sy_0(((a)object).a, false);
    }

    public static void a(tu_0 tu_02, ObjectOutputStream objectOutputStream) {
        int n2 = tu_02.f();
        objectOutputStream.writeInt(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            objectOutputStream.writeDouble(tu_02.a(i2));
        }
    }

    public static void a(Object object, String object2, ObjectInputStream objectInputStream) {
        try {
            int n2 = objectInputStream.readInt();
            double[] dArray = new double[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                dArray[i2] = objectInputStream.readDouble();
            }
            sA sA2 = new sA(dArray, false);
            object2 = object.getClass().getDeclaredField((String)object2);
            ((Field)object2).setAccessible(true);
            ((Field)object2).set(object, sA2);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            IOException iOException = new IOException();
            iOException.initCause(noSuchFieldException);
            throw iOException;
        }
        catch (IllegalAccessException illegalAccessException) {
            IOException iOException = new IOException();
            iOException.initCause(illegalAccessException);
            throw iOException;
        }
    }

    public static void a(tq_0 tq_02, ObjectOutputStream objectOutputStream) {
        int n2 = tq_02.f();
        int n3 = tq_02.g();
        objectOutputStream.writeInt(n2);
        objectOutputStream.writeInt(n3);
        for (int i2 = 0; i2 < n2; ++i2) {
            for (int i3 = 0; i3 < n3; ++i3) {
                objectOutputStream.writeDouble(tq_02.b(i2, i3));
            }
        }
    }

    public static void b(Object object, String string, ObjectInputStream objectInputStream) {
        try {
            Object object2;
            int n2 = objectInputStream.readInt();
            int n3 = objectInputStream.readInt();
            double[][] dArray = new double[n2][n3];
            for (int i2 = 0; i2 < n2; ++i2) {
                object2 = dArray[i2];
                for (int i3 = 0; i3 < n3; ++i3) {
                    object2[i3] = objectInputStream.readDouble();
                }
            }
            sy_0 sy_02 = new sy_0(dArray, false);
            Field field = object.getClass().getDeclaredField(string);
            object2 = field;
            field.setAccessible(true);
            ((Field)object2).set(object, sy_02);
            return;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            IOException iOException = new IOException();
            iOException.initCause(noSuchFieldException);
            throw iOException;
        }
        catch (IllegalAccessException illegalAccessException) {
            IOException iOException = new IOException();
            iOException.initCause(illegalAccessException);
            throw iOException;
        }
    }

    private static void a(tq_0 tq_02, tu_0 tu_02) {
        if (tq_02 == null || tu_02 == null || tq_02.f() != tu_02.f()) {
            throw new oS(tq_02 == null ? 0 : tq_02.f(), tu_02 == null ? 0 : tu_02.f());
        }
        if (tq_02.g() != tq_02.f()) {
            throw new th_0(tq_02.f(), tq_02.g());
        }
        int n2 = tq_02.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            double d2;
            int n3 = i2;
            double d3 = tq_02.b(n3, n3);
            if (BY.w(d2) < cq_0.b) {
                throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
            }
            double d4 = tu_02.a(i2) / d3;
            tu_02.a(i2, d4);
            for (int i3 = i2 + 1; i3 < n2; ++i3) {
                tu_02.a(i3, tu_02.a(i3) - d4 * tq_02.b(i3, i2));
            }
        }
    }

    private static void b(tq_0 tq_02, tu_0 tu_02) {
        if (tq_02 == null || tu_02 == null || tq_02.f() != tu_02.f()) {
            throw new oS(tq_02 == null ? 0 : tq_02.f(), tu_02 == null ? 0 : tu_02.f());
        }
        if (tq_02.g() != tq_02.f()) {
            throw new th_0(tq_02.f(), tq_02.g());
        }
        int n2 = tq_02.f();
        --n2;
        while (n2 >= 0) {
            double d2;
            int n3 = n2;
            double d3 = tq_02.b(n3, n3);
            if (BY.w(d2) < cq_0.b) {
                throw new oU(px_0.ZERO_DENOMINATOR, new Object[0]);
            }
            double d4 = tu_02.a(n2) / d3;
            tu_02.a(n2, d4);
            for (int i2 = n2 - 1; i2 >= 0; --i2) {
                tu_02.a(i2, tu_02.a(i2) - d4 * tq_02.b(i2, n2));
            }
            --n2;
        }
    }

    private static sy_0 a(tq_0 object, int n2) {
        int n3 = object.f();
        if (object.g() != n3) {
            throw new th_0(object.f(), object.g());
        }
        int n4 = n2 + 1;
        Object object2 = object.a(0, n2, 0, n2);
        tq_0 tq_02 = object.a(0, n2, n4, n3 - 1);
        tq_0 tq_03 = object.a(n4, n3 - 1, 0, n2);
        object = object.a(n4, n3 - 1, n4, n3 - 1);
        Object object3 = new tC((tq_0)object2);
        if (!(object3 = ((tC)object3).a()).a()) {
            throw new tA();
        }
        object3 = object3.b();
        Object object4 = new tC((tq_0)object);
        if (!(object4 = ((tC)object4).a()).a()) {
            throw new tA();
        }
        object4 = object4.b();
        object2 = object2.b(tq_02.c((tq_0)object4).c(tq_03));
        object2 = new tC((tq_0)object2);
        if (!(object2 = ((tC)object2).a()).a()) {
            throw new tA();
        }
        object2 = object2.b();
        object = object.b(tq_03.c((tq_0)object3).c(tq_02));
        object = new tC((tq_0)object);
        if (!(object = ((tC)object).a()).a()) {
            throw new tA();
        }
        object = object.b();
        tq_02 = object3.c(tq_02).c((tq_0)object).b(-1.0);
        tq_03 = object4.c(tq_03).c((tq_0)object2).b(-1.0);
        int n5 = n3;
        sy_0 sy_02 = new sy_0(n5, n5);
        sy_02.a(object2.a(), 0, 0);
        sy_02.a(tq_02.a(), 0, n4);
        sy_02.a(tq_03.a(), n4, 0);
        int n6 = n4;
        sy_02.a(object.a(), n6, n6);
        return sy_02;
    }

    private static tq_0 a(tq_0 object) {
        double d2 = 0.0;
        ci_0.a(object);
        if (!object.e()) {
            throw new th_0(object.f(), object.g());
        }
        if (object instanceof sM) {
            return ((sM)object).c(0.0);
        }
        object = new tn_0((tq_0)object, 0.0);
        return ((tn_0)object).c().b();
    }

    private static tq_0 c(tq_0 object, double d2) {
        ci_0.a(object);
        if (!object.e()) {
            throw new th_0(object.f(), object.g());
        }
        if (object instanceof sM) {
            return ((sM)object).c(0.0);
        }
        object = new tn_0((tq_0)object, 0.0);
        return ((tn_0)object).c().b();
    }

    static {
        ts_0.a(Locale.getDefault());
        new ts_0("[", "]", "", "", "; ", ", ");
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class a
    extends sI<qd_0> {
        double[][] a;

        a() {
            super(qd_0.c);
        }

        @Override
        public final void a(int n2, int n3, int n4, int n5) {
            this.a = new double[n2][n3];
        }

        @Override
        private void a(int n2, int n3, qd_0 qd_02) {
            this.a[n2][n3] = qd_02.doubleValue();
        }

        final sy_0 b() {
            return new sy_0(this.a, false);
        }

        @Override
        public final /* synthetic */ void a(int n2, int n3, kN kN2) {
            qd_0 qd_02 = (qd_0)kN2;
            int n4 = n3;
            n3 = n2;
            a a2 = this;
            a2.a[n3][n4] = qd_02.doubleValue();
        }
    }

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    static final class b
    extends sI<qg_0> {
        double[][] a;

        b() {
            super(qg_0.b);
        }

        @Override
        public final void a(int n2, int n3, int n4, int n5) {
            this.a = new double[n2][n3];
        }

        @Override
        private void a(int n2, int n3, qg_0 qg_02) {
            this.a[n2][n3] = qg_02.doubleValue();
        }

        final sy_0 b() {
            return new sy_0(this.a, false);
        }

        @Override
        public final /* synthetic */ void a(int n2, int n3, kN kN2) {
            qg_0 qg_02 = (qg_0)kN2;
            int n4 = n3;
            n3 = n2;
            b b2 = this;
            b2.a[n3][n4] = qg_02.doubleValue();
        }
    }
}

