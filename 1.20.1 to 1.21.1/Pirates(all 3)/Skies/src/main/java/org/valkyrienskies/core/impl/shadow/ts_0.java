/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.oZ;
import org.valkyrienskies.core.impl.shadow.sv_0;
import org.valkyrienskies.core.impl.shadow.sy_0;
import org.valkyrienskies.core.impl.shadow.td_0;
import org.valkyrienskies.core.impl.shadow.tq_0;

/*
 * Renamed from org.valkyrienskies.core.impl.shadow.ts
 */
public final class ts_0 {
    private static final String h = "{";
    private static final String i = "}";
    private static final String j = "{";
    private static final String k = "}";
    private static final String l = ",";
    private static final String m = ",";
    final String a;
    final String b;
    final String c;
    final String d;
    final String e;
    final String f;
    final NumberFormat g;

    public ts_0() {
        this("{", "}", "{", "}", ",", ",", BS.a(Locale.getDefault()));
    }

    private ts_0(NumberFormat numberFormat) {
        this("{", "}", "{", "}", ",", ",", numberFormat);
    }

    public ts_0(String string, String string2, String string3, String string4, String string5, String string6) {
        this(string, string2, string3, string4, string5, string6, BS.a(Locale.getDefault()));
    }

    private ts_0(String string, String string2, String string3, String string4, String string5, String string6, NumberFormat numberFormat) {
        this.a = string;
        this.b = string2;
        this.c = string3;
        this.d = string4;
        this.e = string5;
        this.f = string6;
        this.g = numberFormat;
        this.g.setGroupingUsed(false);
    }

    private static Locale[] c() {
        return NumberFormat.getAvailableLocales();
    }

    private String d() {
        return this.a;
    }

    private String e() {
        return this.b;
    }

    private String f() {
        return this.c;
    }

    private String g() {
        return this.d;
    }

    private String h() {
        return this.e;
    }

    private String i() {
        return this.f;
    }

    public final NumberFormat a() {
        return this.g;
    }

    public static ts_0 b() {
        return ts_0.a(Locale.getDefault());
    }

    public static ts_0 a(Locale locale) {
        return new ts_0(BS.a(locale));
    }

    public final String a(sv_0 sv_02) {
        return this.a(sv_02, new StringBuffer(), new FieldPosition(0)).toString();
    }

    private StringBuffer a(tq_0 tq_02, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.a);
        int n2 = tq_02.f();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuffer.append(this.c);
            for (int i3 = 0; i3 < tq_02.g(); ++i3) {
                if (i3 > 0) {
                    stringBuffer.append(this.f);
                }
                BS.a(tq_02.b(i2, i3), this.g, stringBuffer, fieldPosition);
            }
            stringBuffer.append(this.d);
            if (i2 >= n2 - 1) continue;
            stringBuffer.append(this.e);
        }
        stringBuffer.append(this.b);
        return stringBuffer;
    }

    /*
     * Unable to fully structure code
     */
    private tq_0 a(String var1_1) {
        block16: {
            block17: {
                var5_3 = var2_2 = new ParsePosition(0);
                var4_5 = var1_1;
                var3_6 = this;
                var6_7 = var5_3.getIndex();
                var7_8 = var3_6.a.trim();
                var8_9 = var3_6.b.trim();
                var9_10 = var3_6.c.trim();
                var10_11 = var3_6.d.trim();
                var11_12 = var3_6.f.trim();
                var12_13 = var3_6.e.trim();
                BS.a((String)var4_5, var5_3);
                if (BS.a((String)var4_5, (String)var7_8, var5_3)) break block17;
                v0 = null;
                break block16;
            }
            var7_8 = new ArrayList<E>();
            var13_14 = new ArrayList<Number>();
            var14_15 = true;
            while (var14_15) {
                block18: {
                    if (var13_14.isEmpty()) break block18;
                    BS.a((String)var4_5, var5_3);
                    if (!BS.a((String)var4_5, var11_12, var5_3)) {
                        if (var10_11.length() != 0 && !BS.a((String)var4_5, var10_11, var5_3)) {
                            v0 = null;
                            break block16;
                        }
                        BS.a((String)var4_5, var5_3);
                        if (BS.a((String)var4_5, var12_13, var5_3)) {
                            var7_8.add(var13_14);
                            var13_14 = new ArrayList<E>();
                            continue;
                        }
                        var14_15 = false;
                    }
                    ** GOTO lbl-1000
                }
                BS.a((String)var4_5, var5_3);
                if (var9_10.length() != 0 && !BS.a((String)var4_5, var9_10, var5_3)) {
                    v0 = null;
                } else lbl-1000:
                // 2 sources

                {
                    if (!var14_15) continue;
                    BS.a((String)var4_5, var5_3);
                    var15_17 = BS.a((String)var4_5, var3_6.g, var5_3);
                    if (var15_17 != null) {
                        var13_14.add(var15_17);
                        continue;
                    }
                    if (var13_14.isEmpty()) {
                        var14_15 = false;
                        continue;
                    }
                    var5_3.setIndex(var6_7);
                    v0 = null;
                }
                break block16;
            }
            if (!var13_14.isEmpty()) {
                var7_8.add(var13_14);
            }
            BS.a((String)var4_5, var5_3);
            if (!BS.a((String)var4_5, var8_9, var5_3)) {
                v0 = null;
            } else if (var7_8.isEmpty()) {
                var5_3.setIndex(var6_7);
                v0 = null;
            } else {
                var14_16 = new double[var7_8.size()][];
                var15_18 = 0;
                var3_6 = var7_8.iterator();
                while (var3_6.hasNext()) {
                    var4_5 = (List)var3_6.next();
                    var14_16[var15_18] = new double[var4_5.size()];
                    for (var5_4 = 0; var5_4 < var4_5.size(); ++var5_4) {
                        var14_16[var15_18][var5_4] = ((Number)var4_5.get(var5_4)).doubleValue();
                    }
                    ++var15_18;
                }
                v0 = var3_6 = td_0.a(var14_16);
            }
        }
        if (var2_2.getIndex() == 0) {
            throw new oZ(var1_1, var2_2.getErrorIndex(), sy_0.class);
        }
        return var3_6;
    }

    private tq_0 a(String object, ParsePosition object2) {
        int n2 = ((ParsePosition)object2).getIndex();
        Object object3 = this.a.trim();
        String string = this.b.trim();
        String string2 = this.c.trim();
        String string3 = this.d.trim();
        String string4 = this.f.trim();
        String string5 = this.e.trim();
        BS.a((String)object, (ParsePosition)object2);
        if (!BS.a((String)object, (String)object3, (ParsePosition)object2)) {
            return null;
        }
        object3 = new ArrayList();
        ArrayList<Number> arrayList = new ArrayList<Number>();
        boolean bl = true;
        while (bl) {
            if (!arrayList.isEmpty()) {
                BS.a((String)object, (ParsePosition)object2);
                if (!BS.a((String)object, string4, (ParsePosition)object2)) {
                    if (string3.length() != 0 && !BS.a((String)object, string3, (ParsePosition)object2)) {
                        return null;
                    }
                    BS.a((String)object, (ParsePosition)object2);
                    if (BS.a((String)object, string5, (ParsePosition)object2)) {
                        object3.add(arrayList);
                        arrayList = new ArrayList();
                        continue;
                    }
                    bl = false;
                }
            } else {
                BS.a((String)object, (ParsePosition)object2);
                if (string2.length() != 0 && !BS.a((String)object, string2, (ParsePosition)object2)) {
                    return null;
                }
            }
            if (!bl) continue;
            BS.a((String)object, (ParsePosition)object2);
            Number number = BS.a((String)object, this.g, (ParsePosition)object2);
            if (number != null) {
                arrayList.add(number);
                continue;
            }
            if (arrayList.isEmpty()) {
                bl = false;
                continue;
            }
            ((ParsePosition)object2).setIndex(n2);
            return null;
        }
        if (!arrayList.isEmpty()) {
            object3.add(arrayList);
        }
        BS.a((String)object, (ParsePosition)object2);
        if (!BS.a((String)object, string, (ParsePosition)object2)) {
            return null;
        }
        if (object3.isEmpty()) {
            ((ParsePosition)object2).setIndex(n2);
            return null;
        }
        double[][] dArrayArray = new double[object3.size()][];
        int n3 = 0;
        object = object3.iterator();
        while (object.hasNext()) {
            object2 = (List)object.next();
            dArrayArray[n3] = new double[object2.size()];
            for (n2 = 0; n2 < object2.size(); ++n2) {
                dArrayArray[n3][n2] = ((Number)object2.get(n2)).doubleValue();
            }
            ++n3;
        }
        return td_0.a(dArrayArray);
    }
}

