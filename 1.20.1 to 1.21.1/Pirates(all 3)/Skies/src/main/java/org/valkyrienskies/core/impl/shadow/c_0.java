/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.Optional;
import org.valkyrienskies.core.impl.shadow.a_0;
import org.valkyrienskies.core.impl.shadow.b_0;
import org.valkyrienskies.core.impl.shadow.e_0;
import org.valkyrienskies.core.impl.shadow.f_0;
import org.valkyrienskies.core.impl.shadow.g_0;
import org.valkyrienskies.core.impl.shadow.k_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.c
 */
public final class c_0 {
    private static final k_0 a = k_0.a();

    private c_0() {
    }

    public static OffsetDateTime a(String object) {
        String string = object;
        object = a;
        return k_0.a(((k_0)object).b(string)).e();
    }

    private static a_0 b(String string) {
        return a.b(string);
    }

    private static boolean c(String string) {
        try {
            c_0.a(string);
            return true;
        }
        catch (DateTimeException dateTimeException) {
            return false;
        }
    }

    private static String a(OffsetDateTime offsetDateTime, int n2) {
        return a.a(offsetDateTime, n2);
    }

    private static String a(OffsetDateTime object, b_0 object2) {
        b_0 b_02 = object2;
        object2 = object;
        object = a;
        return ((k_0)object).a((OffsetDateTime)object2, ZoneOffset.UTC, b_02, 0);
    }

    private static String a(OffsetDateTime offsetDateTime) {
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        return a.a(offsetDateTime2, offsetDateTime2.getOffset(), 0);
    }

    private static String b(OffsetDateTime offsetDateTime, int n2) {
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        return a.a(offsetDateTime2, offsetDateTime2.getOffset(), n2);
    }

    private static String b(OffsetDateTime object) {
        OffsetDateTime offsetDateTime = object;
        object = a;
        return ((k_0)object).a(offsetDateTime, 0);
    }

    private static String c(OffsetDateTime object) {
        OffsetDateTime offsetDateTime = object;
        object = a;
        return ((k_0)object).a(offsetDateTime, 3);
    }

    private static String d(OffsetDateTime object) {
        OffsetDateTime offsetDateTime = object;
        object = a;
        return ((k_0)object).a(offsetDateTime, 6);
    }

    private static String e(OffsetDateTime object) {
        OffsetDateTime offsetDateTime = object;
        object = a;
        return ((k_0)object).a(offsetDateTime, 9);
    }

    private static void a(String object, e_0 e_02) {
        if (((a_0)(object = a.b((String)object))).a(b_0.MINUTE)) {
            Object object2 = object;
            if (Optional.ofNullable(((a_0)object2).b).isPresent()) {
                e_02.a(((a_0)object).e());
                return;
            }
            e_02.a(((a_0)object).d());
            return;
        }
        if (((a_0)object).a(b_0.DAY)) {
            e_02.a(((a_0)object).f());
            return;
        }
        if (((a_0)object).a(b_0.MONTH)) {
            e_02.a(((a_0)object).c());
            return;
        }
        Object object3 = object;
        e_02.a(Year.of(((a_0)object3).a));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    private static Object a(String object, 1 var1_1) {
        if (((a_0)(object = a.b((String)object))).a(b_0.MINUTE)) {
            Object object2 = object;
            if (Optional.ofNullable(((a_0)object2).b).isPresent()) {
                return var1_1.a(((a_0)object).e());
            }
            return var1_1.a(((a_0)object).d());
        }
        if (((a_0)object).a(b_0.DAY)) {
            return var1_1.a(((a_0)object).f());
        }
        if (((a_0)object).a(b_0.MONTH)) {
            return var1_1.a(((a_0)object).c());
        }
        Object object3 = object;
        return var1_1.a(Year.of(((a_0)object3).a));
    }

    private static boolean a(String object, g_0 ... object2) {
        try {
            Object t;
            object2 = new f_0<Boolean>((g_0[])object2){
                private /* synthetic */ g_0[] a;
                {
                    this.a = g_0Array;
                }

                private Boolean a() {
                    return c_0.a(g_0.LOCAL_DATE, this.a);
                }

                private Boolean b() {
                    return c_0.a(g_0.OFFSET_DATE_TIME, this.a);
                }

                private Boolean c() {
                    return c_0.a(g_0.LOCAL_DATE_TIME, this.a);
                }

                private Boolean d() {
                    return c_0.a(g_0.YEAR_MONTH, this.a);
                }

                private Boolean e() {
                    return c_0.a(g_0.YEAR, this.a);
                }

                @Override
                public final /* synthetic */ Object a(OffsetDateTime object) {
                    object = this;
                    return c_0.a(g_0.OFFSET_DATE_TIME, object.a);
                }

                @Override
                public final /* synthetic */ Object a(Year object) {
                    object = this;
                    return c_0.a(g_0.YEAR, object.a);
                }

                @Override
                public final /* synthetic */ Object a(YearMonth object) {
                    object = this;
                    return c_0.a(g_0.YEAR_MONTH, object.a);
                }

                @Override
                public final /* synthetic */ Object a(LocalDate object) {
                    object = this;
                    return c_0.a(g_0.LOCAL_DATE, object.a);
                }

                @Override
                public final /* synthetic */ Object a(LocalDateTime object) {
                    object = this;
                    return c_0.a(g_0.LOCAL_DATE_TIME, object.a);
                }
            };
            object = a.b((String)object);
            if (((a_0)object).a(b_0.MINUTE)) {
                Object object3 = object;
                t = Optional.ofNullable(((a_0)object3).b).isPresent() ? object2.a(((a_0)object).e()) : object2.a(((a_0)object).d());
            } else if (((a_0)object).a(b_0.DAY)) {
                t = object2.a(((a_0)object).f());
            } else if (((a_0)object).a(b_0.MONTH)) {
                t = object2.a(((a_0)object).c());
            } else {
                Object object4 = object;
                t = object2.a(Year.of(((a_0)object4).a));
            }
            return (Boolean)t;
        }
        catch (DateTimeException dateTimeException) {
            return false;
        }
    }

    private static boolean b(g_0 g_02, g_0 ... g_0Array) {
        for (g_0 g_03 : g_0Array) {
            if (!g_03.equals((Object)g_02)) continue;
            return true;
        }
        return false;
    }

    static /* synthetic */ boolean a(g_0 g_02, g_0[] g_0Array) {
        for (g_0 g_03 : g_0Array) {
            if (!g_03.equals((Object)g_02)) continue;
            return true;
        }
        return false;
    }
}

