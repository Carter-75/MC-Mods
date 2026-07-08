/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 */
package org.valkyrienskies.core.impl.shadow;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*
 * Uses 'sealed' constructs - enablewith --sealed true
 */
public interface CE {

    public static final class a
    implements CE {
        final String a;

        public a(String string) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"");
            this.a = string;
        }

        public final String a() {
            return this.a;
        }
    }

    public static final class b
    implements CE {
        final String a;
        final String b;

        public b(String string, String string2) {
            Intrinsics.checkNotNullParameter((Object)string, (String)"");
            Intrinsics.checkNotNullParameter((Object)string2, (String)"");
            this.a = string;
            this.b = string2;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2={"Lorg/valkyrienskies/core/impl/shadow/CE$c;", "Lorg/valkyrienskies/core/impl/shadow/CE;", "<init>", "()V"})
    public static final class c
    implements CE {
        public static final c INSTANCE = new c();

        private c() {
        }
    }

    public static final class d
    implements CE {
        final Object a;

        public d(Object object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            this.a = object;
        }

        public final Object a() {
            return this.a;
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2={"Lorg/valkyrienskies/core/impl/shadow/CE$e;", "Lorg/valkyrienskies/core/impl/shadow/CE;", "<init>", "()V"})
    public static final class e
    implements CE {
        public static final e INSTANCE = new e();

        private e() {
        }
    }

    public static final class f
    implements CE {
        final Object a;

        public f(Object object) {
            Intrinsics.checkNotNullParameter((Object)object, (String)"");
            this.a = object;
        }

        public final Object a() {
            return this.a;
        }
    }
}

