/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmName
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  org.valkyrienskies.core.impl.shadow.Db
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.valkyrienskies.core.impl.shadow.Db;
import org.valkyrienskies.core.impl.shadow.dc_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.Db
 */
@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u00d6\u0003\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u00d6\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0017\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\b\u0010\u0018R\u0014\u0010\u0014\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028WX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Db;", "Lorg/valkyrienskies/core/impl/shadow/Dc;", "", "e", "()D", "f", "p0", "p1", "a", "(DD)Lorg/valkyrienskies/core/impl/shadow/Db;", "", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "c", "D", "d", "b", "(D)V", "<init>", "(DD)V"})
public final class db_0
implements dc_0 {
    public static final a a = new a(null);
    double b;
    double c;

    public db_0(double d2, double d3) {
        this.b = d2;
        this.c = d3;
    }

    @JvmName(name="c")
    private double c() {
        return this.b;
    }

    @JvmName(name="a")
    public final void a(double d2) {
        this.b = d2;
    }

    @JvmName(name="d")
    private double d() {
        return this.c;
    }

    @JvmName(name="b")
    public final void b(double d2) {
        this.c = d2;
    }

    @Override
    @JvmName(name="a")
    public final double a() {
        return this.b;
    }

    @Override
    @JvmName(name="b")
    public final double b() {
        return this.c;
    }

    private double e() {
        return this.b;
    }

    private double f() {
        return this.c;
    }

    private static db_0 a(double d2, double d3) {
        return new db_0(d2, d3);
    }

    private static /* synthetic */ db_0 a$default(db_0 db_02, double d2, double d3, int n2) {
        if ((n2 & 1) != 0) {
            d2 = db_02.b;
        }
        if ((n2 & 2) != 0) {
            d3 = db_02.c;
        }
        double d4 = d3;
        double d5 = d2;
        return new db_0(d5, d4);
    }

    public final String toString() {
        return "CollisionRange(_min=" + this.b + ", _max=" + this.c + ")";
    }

    public final int hashCode() {
        int n2 = Double.hashCode(this.b);
        n2 = n2 * 31 + Double.hashCode(this.c);
        return n2;
    }

    public final boolean equals(Object other) {
        db_0 db_02;
        if (this == other) {
            return true;
        }
        if (!(other instanceof db_0)) {
            return false;
        }
        db_02 = db_02;
        if (Double.compare(this.b, db_02.b) != 0) {
            return false;
        }
        return Double.compare(this.c, db_02.c) == 0;
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\r\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0003\u0010\b"}, d2={"Lorg/valkyrienskies/core/impl/shadow/Db$a;", "", "Lorg/valkyrienskies/core/impl/shadow/Db;", "a", "()Lorg/valkyrienskies/core/impl/shadow/Db;", "", "p0", "p1", "(DD)Lorg/valkyrienskies/core/impl/shadow/Db;", "<init>", "()V"})
    public static final class a {
        private a() {
        }

        private static db_0 a(double d2, double d3) {
            return new Db(0.0, 0.0);
        }

        public final db_0 a() {
            double d2 = 0.0;
            double d3 = 0.0;
            return new Db(0.0, 0.0);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

