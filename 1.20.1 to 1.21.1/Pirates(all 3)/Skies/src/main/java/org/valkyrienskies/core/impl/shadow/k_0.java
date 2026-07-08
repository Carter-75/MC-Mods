/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.time.DateTimeException;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Arrays;
import org.valkyrienskies.core.impl.shadow.a_0;
import org.valkyrienskies.core.impl.shadow.b_0;
import org.valkyrienskies.core.impl.shadow.d_0;
import org.valkyrienskies.core.impl.shadow.h_0;
import org.valkyrienskies.core.impl.shadow.i_0;
import org.valkyrienskies.core.impl.shadow.j_0;
import org.valkyrienskies.core.impl.shadow.m_0;
import org.valkyrienskies.core.impl.shadow.q_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.k
 */
public final class k_0
extends i_0
implements q_0 {
    private static char a = '-';
    private static char b = ':';
    private static char c = 'T';
    private static final k_0 d = new k_0();
    private static final char e = '+';
    private static final char f = '-';
    private static final char g = 't';
    private static final char h = ' ';
    private static final char i = '.';
    private static final char j = 'Z';
    private static final char k = 'z';
    private static final int[] l = new int[]{100000000, 10000000, 1000000, 100000, 10000, 1000, 100, 10, 1};
    private final j_0 m = new j_0();

    private k_0() {
    }

    public static k_0 a() {
        return d;
    }

    public static String a(char[] cArray, int n2, h_0 object) {
        int n3 = 0;
        if (object != null) {
            int n4;
            h_0 h_02 = object;
            n3 = n2;
            object = cArray;
            if (h_02.equals(h_0.a)) {
                object[n3] = 90;
                n4 = 1;
            } else {
                object[n3] = h_02.c() < 0 ? 45 : 43;
                h_0 h_03 = h_02;
                m_0.a(Math.abs(h_03.b), (char[])object, n3 + 1, 2);
                object[n3 + 3] = 58;
                h_03 = h_02;
                m_0.a(Math.abs(h_03.c), (char[])object, n3 + 4, 2);
                n4 = 6;
            }
            n3 = n4;
        }
        return new String(cArray, 0, n2 + n3);
    }

    private static int b(char[] cArray, int n2, h_0 h_02) {
        if (h_02.equals(h_0.a)) {
            cArray[n2] = 90;
            return 1;
        }
        cArray[n2] = h_02.c() < 0 ? 45 : 43;
        h_0 h_03 = h_02;
        m_0.a(Math.abs(h_03.b), cArray, n2 + 1, 2);
        cArray[n2 + 3] = 58;
        h_03 = h_02;
        m_0.a(Math.abs(h_03.c), cArray, n2 + 4, 2);
        return 6;
    }

    private static int a(char[] cArray) {
        return m_0.a(cArray, 11, 13);
    }

    private static int b(char[] cArray) {
        return m_0.a(cArray, 14, 16);
    }

    private static int c(char[] cArray) {
        return m_0.a(cArray, 8, 10);
    }

    private a_0 a(char[] object, int n2, int n3, int n4, int n5, int n6) {
        switch (object[16]) {
            case ':': {
                Object object2 = object;
                object = this;
                int n7 = ((char[])object2).length - 19;
                if (n7 == 0) {
                    int n8 = k_0.f(object2);
                    return super.a(n2, n3, n4, n5, n6, n8, 0, null, 0);
                }
                h_0 h_02 = null;
                int n9 = 0;
                int n10 = 0;
                int n11 = object2[19];
                if (n7 == 1 && (n11 == 90 || n11 == 122)) {
                    h_02 = h_0.a;
                    k_0.b(object2, 19);
                } else if (n7 > 0 && n11 == 46) {
                    n7 = m_0.a(object2, 20);
                    if (n7 != -1) {
                        int n12;
                        int n13;
                        n11 = n13 = n7 - 20;
                        n10 = n7;
                        Object object3 = object2;
                        n9 = m_0.b(object2, 20, n10);
                        switch (n11) {
                            case 1: {
                                n12 = n9 * 100000000;
                                break;
                            }
                            case 2: {
                                n12 = n9 * 10000000;
                                break;
                            }
                            case 3: {
                                n12 = n9 * 1000000;
                                break;
                            }
                            case 4: {
                                n12 = n9 * 100000;
                                break;
                            }
                            case 5: {
                                n12 = n9 * 10000;
                                break;
                            }
                            case 6: {
                                n12 = n9 * 1000;
                                break;
                            }
                            case 7: {
                                n12 = n9 * 100;
                                break;
                            }
                            case 8: {
                                n12 = n9 * 10;
                                break;
                            }
                            default: {
                                n12 = n9;
                            }
                        }
                        n9 = n12;
                        n10 = n13;
                        h_02 = super.a((char[])object2, n7);
                    } else {
                        k_0.a(object2, "No timezone information");
                    }
                } else if (n7 > 0 && (n11 == 43 || n11 == 45)) {
                    h_02 = super.a((char[])object2, 19);
                } else {
                    k_0.a(object2, "Unexpected character at position 19");
                }
                return super.a(n2, n3, n4, n5, n6, k_0.f(object2), n9, h_02, n10);
            }
            case '+': 
            case '-': 
            case 'Z': 
            case 'z': {
                object = this.a((char[])object, 16);
                return a_0.a(n2, n3, n4, n5, n6, (h_0)object);
            }
        }
        this.a((char[])object, 16, ':', '+', '-', 'Z');
        throw new DateTimeException(new String((char[])object));
    }

    private void a(char[] cArray, int n2, char c2) {
        if (n2 >= cArray.length) {
            k_0.a(cArray, "Unexpected end of input");
        }
        if (cArray[n2] != c2) {
            throw new DateTimeException("Expected character " + c2 + " at position " + (n2 + 1) + " '" + new String(cArray) + "'");
        }
    }

    private void a(char[] cArray, int n2, char ... cArray2) {
        if (n2 >= cArray.length) {
            k_0.a(cArray, "Unexpected end of input");
        }
        boolean bl = false;
        char[] cArray3 = cArray2;
        int n3 = cArray2.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            char c2 = cArray3[i2];
            if (cArray[n2] != c2) continue;
            bl = true;
            break;
        }
        if (!bl) {
            throw new DateTimeException("Expected character " + Arrays.toString(cArray2) + " at position " + (n2 + 1) + " '" + new String(cArray) + "'");
        }
    }

    private h_0 a(char[] cArray, int n2) {
        int n3 = cArray.length;
        n3 -= n2;
        int n4 = cArray[n2];
        if (n4 == 90 || n4 == 122) {
            k_0.b(cArray, n2);
            return h_0.a;
        }
        if (n3 != 6) {
            throw new DateTimeException("Invalid timezone offset: " + new String(cArray, n2, n3));
        }
        n3 = cArray[n2];
        n4 = m_0.a(cArray, n2 + 1, n2 + 3);
        int n5 = m_0.a(cArray, n2 + 4, n2 + 4 + 2);
        if (n3 == 45) {
            n4 = -n4;
            n5 = -n5;
        } else if (n3 != 43) {
            throw new DateTimeException("Invalid character starting at position " + n2 + 1);
        }
        if (n3 == 45 && n4 == 0 && n5 == 0) {
            throw new DateTimeException("Unknown 'Local Offset Convention' date-time not allowed");
        }
        return h_0.a(n4, n5);
    }

    private static void b(char[] cArray, int n2) {
        if (cArray.length > n2 + 1) {
            throw new DateTimeException("Trailing junk data after position " + (n2 + 1) + ": " + new String(cArray));
        }
    }

    @Override
    public final String a(OffsetDateTime offsetDateTime, int n2) {
        return this.a(offsetDateTime, ZoneOffset.UTC, b_0.SECOND, n2);
    }

    @Override
    public final String a(OffsetDateTime offsetDateTime, b_0 b_02) {
        return this.a(offsetDateTime, ZoneOffset.UTC, b_02, 0);
    }

    @Override
    public final String a(OffsetDateTime offsetDateTime, ZoneOffset zoneOffset, int n2) {
        return this.a(offsetDateTime, zoneOffset, b_0.NANO, n2);
    }

    public String a(OffsetDateTime object, ZoneOffset object2, b_0 b_02, int n2) {
        k_0.a(n2);
        OffsetDateTime offsetDateTime = object;
        if (!((OffsetDateTime)object).getOffset().equals(object2)) {
            offsetDateTime = ((OffsetDateTime)object).atZoneSameInstant((ZoneId)object2).toOffsetDateTime();
        }
        object = h_0.a((ZoneOffset)object2);
        object2 = new char[31];
        if (k_0.a(b_02, (char[])object2, offsetDateTime.getYear(), 0, 4, b_0.YEAR)) {
            Object object3 = object2;
            object2 = b_0.YEAR;
            return k_0.a((char[])object3, ((b_0)((Object)object2)).requiredLength, null);
        }
        object2[4] = 45;
        if (k_0.a(b_02, (char[])object2, offsetDateTime.getMonthValue(), 5, 2, b_0.MONTH)) {
            Object object4 = object2;
            object2 = b_0.MONTH;
            return k_0.a((char[])object4, ((b_0)((Object)object2)).requiredLength, null);
        }
        object2[7] = 45;
        if (k_0.a(b_02, (char[])object2, offsetDateTime.getDayOfMonth(), 8, 2, b_0.DAY)) {
            Object object5 = object2;
            object2 = b_0.DAY;
            return k_0.a((char[])object5, ((b_0)((Object)object2)).requiredLength, null);
        }
        object2[10] = 84;
        m_0.a(offsetDateTime.getHour(), (char[])object2, 11, 2);
        object2[13] = 58;
        if (k_0.a(b_02, (char[])object2, offsetDateTime.getMinute(), 14, 2, b_0.MINUTE)) {
            Object object6 = object2;
            object2 = b_0.MINUTE;
            return k_0.a((char[])object6, ((b_0)((Object)object2)).requiredLength, (h_0)object);
        }
        object2[16] = 58;
        m_0.a(offsetDateTime.getSecond(), (char[])object2, 17, 2);
        boolean bl = n2 > 0;
        if (bl) {
            object2[19] = 46;
            k_0.a((char[])object2, n2, offsetDateTime.getNano());
            return k_0.a((char[])object2, n2 + 20, (h_0)object);
        }
        return k_0.a((char[])object2, 19, (h_0)object);
    }

    private static boolean a(b_0 b_02, char[] cArray, int n2, int n3, int n4, b_0 b_03) {
        m_0.a(n2, cArray, n3, n4);
        return b_02 == b_03;
    }

    private static void a(char[] cArray, int n2, int n3) {
        double d2 = l[n2 - 1];
        m_0.a((int)((double)n3 / d2), cArray, 20, n2);
    }

    @Override
    public final OffsetDateTime a(String string) {
        return k_0.a(this.b(string)).e();
    }

    public static a_0 a(a_0 a_02) {
        if (!a_02.a(b_0.SECOND)) {
            throw new DateTimeException("No " + b_0.SECOND.name() + " field found");
        }
        return a_02;
    }

    @Override
    public final String a(OffsetDateTime offsetDateTime) {
        return this.a(offsetDateTime, 3);
    }

    @Override
    public final String b(OffsetDateTime offsetDateTime) {
        return this.a(offsetDateTime, 6);
    }

    @Override
    public final String c(OffsetDateTime offsetDateTime) {
        return this.a(offsetDateTime, 9);
    }

    @Override
    public final String d(OffsetDateTime offsetDateTime) {
        return this.a(offsetDateTime, 0);
    }

    @Override
    public final a_0 b(String object) {
        if (object == null) {
            throw new NullPointerException("text cannot be null");
        }
        int n2 = ((String)object).length();
        char[] cArray = ((String)object).toCharArray();
        object = cArray;
        Object object2 = cArray;
        int n3 = m_0.a(cArray, 0, 4);
        if (4 == n2) {
            return a_0.a(n3);
        }
        this.a((char[])object, 4, '-');
        Object object3 = object;
        object2 = object3;
        int n4 = m_0.a((char[])object3, 5, 7);
        if (7 == n2) {
            return a_0.a(n3, n4);
        }
        this.a((char[])object, 7, '-');
        int n5 = k_0.c((char[])object);
        if (10 == n2) {
            return a_0.a(n3, n4, n5);
        }
        this.a((char[])object, 10, 'T', 't', ' ');
        int n6 = k_0.a((char[])object);
        this.a((char[])object, 13, ':');
        int n7 = k_0.b((char[])object);
        if (16 == n2) {
            return a_0.a(n3, n4, n5, n6, n7, null);
        }
        return this.a((char[])object, n3, n4, n5, n6, n7);
    }

    private static int d(char[] cArray) {
        return m_0.a(cArray, 5, 7);
    }

    private static int e(char[] cArray) {
        return m_0.a(cArray, 0, 4);
    }

    private a_0 a(int n2, int n3, int n4, int n5, int n6, char[] cArray) {
        int n7 = cArray.length - 19;
        if (n7 == 0) {
            int n8 = k_0.f(cArray);
            return this.a(n2, n3, n4, n5, n6, n8, 0, null, 0);
        }
        h_0 h_02 = null;
        int n9 = 0;
        int n10 = 0;
        char c2 = cArray[19];
        if (n7 == 1 && (c2 == 'Z' || c2 == 'z')) {
            h_02 = h_0.a;
            k_0.b(cArray, 19);
        } else if (n7 > 0 && c2 == '.') {
            n7 = m_0.a(cArray, 20);
            if (n7 != -1) {
                int n11 = n7 - 20;
                n9 = k_0.b(cArray, n7, n11);
                n10 = n11;
                h_02 = this.a(cArray, n7);
            } else {
                k_0.a(cArray, "No timezone information");
            }
        } else if (n7 > 0 && (c2 == '+' || c2 == '-')) {
            h_02 = this.a(cArray, 19);
        } else {
            k_0.a(cArray, "Unexpected character at position 19");
        }
        return this.a(n2, n3, n4, n5, n6, k_0.f(cArray), n9, h_02, n10);
    }

    private a_0 a(int n2, int n3, int n4, int n5, int n6, int n7, int n8, h_0 h_02, int n9) {
        YearMonth yearMonth;
        boolean bl;
        if (n7 == 60 && ((bl = this.m.a(yearMonth = YearMonth.of(n2, n3))) || yearMonth.isAfter(this.m.a()))) {
            int n10 = n5 - h_02.c() / 3600;
            int n11 = n6 - h_02.c() % 3600 / 60;
            if ((n3 == Month.DECEMBER.getValue() && n4 == 31 || n3 == Month.JUNE.getValue() && n4 == 30) && n10 == 23 && n11 == 59) {
                OffsetDateTime offsetDateTime = OffsetDateTime.of(n2, n3, n4, n5, n6, 59, n8, h_02.d()).plusSeconds(1L);
                throw new d_0(offsetDateTime, n7, bl);
            }
        }
        if (n9 > 0) {
            return a_0.a(n2, n3, n4, n5, n6, n7, n8, h_02, n9);
        }
        return a_0.a(n2, n3, n4, n5, n6, n7, h_02);
    }

    private static void a(char[] cArray, String string) {
        throw new DateTimeException(string + ": " + new String(cArray));
    }

    private static int f(char[] cArray) {
        return m_0.a(cArray, 17, 19);
    }

    private static int b(char[] cArray, int n2, int n3) {
        int n4 = m_0.b(cArray, 20, n2);
        switch (n3) {
            case 1: {
                return n4 * 100000000;
            }
            case 2: {
                return n4 * 10000000;
            }
            case 3: {
                return n4 * 1000000;
            }
            case 4: {
                return n4 * 100000;
            }
            case 5: {
                return n4 * 10000;
            }
            case 6: {
                return n4 * 1000;
            }
            case 7: {
                return n4 * 100;
            }
            case 8: {
                return n4 * 10;
            }
        }
        return n4;
    }
}

