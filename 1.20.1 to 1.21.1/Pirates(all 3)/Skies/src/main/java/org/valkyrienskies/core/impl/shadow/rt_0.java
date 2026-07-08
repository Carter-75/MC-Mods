/*
 * Decompiled with CFR 0.152.
 */
package org.valkyrienskies.core.impl.shadow;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;
import org.valkyrienskies.core.impl.shadow.BS;
import org.valkyrienskies.core.impl.shadow.oZ;
import org.valkyrienskies.core.impl.shadow.qO;
import org.valkyrienskies.core.impl.shadow.qP;
import org.valkyrienskies.core.impl.shadow.rc_0;
import org.valkyrienskies.core.impl.shadow.rs_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.rt
 */
public final class rt_0
extends qP<rc_0> {
    public rt_0() {
        super("{", "}", "; ", BS.a(Locale.getDefault()));
    }

    public rt_0(NumberFormat numberFormat) {
        super("{", "}", "; ", numberFormat);
    }

    private rt_0(String string, String string2, String string3) {
        super(string, string2, string3, BS.a(Locale.getDefault()));
    }

    private rt_0(String string, String string2, String string3, NumberFormat numberFormat) {
        super(string, string2, string3, numberFormat);
    }

    public static rt_0 a() {
        return rt_0.a(Locale.getDefault());
    }

    public static rt_0 a(Locale locale) {
        return new rt_0(BS.a(locale));
    }

    @Override
    public final StringBuffer a(qO<rc_0> rs_02, StringBuffer serializable, FieldPosition fieldPosition) {
        rs_02 = rs_02;
        StringBuffer stringBuffer = serializable;
        double[] dArray = new double[3];
        serializable = rs_02;
        dArray[0] = ((rs_0)serializable).i;
        serializable = rs_02;
        dArray[1] = ((rs_0)serializable).j;
        serializable = rs_02;
        dArray[2] = ((rs_0)serializable).k;
        return this.a(stringBuffer, fieldPosition, dArray);
    }

    private rs_0 b(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        rs_0 rs_02 = this.b(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), rs_0.class);
        }
        return rs_02;
    }

    private rs_0 b(String object, ParsePosition parsePosition) {
        double[] dArray = this.a(3, (String)object, parsePosition);
        object = dArray;
        if (dArray == null) {
            return null;
        }
        return new rs_0((double)object[0], (double)object[1], (double)object[2]);
    }

    @Override
    public final /* synthetic */ qO a(String string, ParsePosition parsePosition) {
        return this.b(string, parsePosition);
    }

    @Override
    public final /* synthetic */ qO a(String object) {
        String string = object;
        object = this;
        ParsePosition parsePosition = new ParsePosition(0);
        object = ((rt_0)object).b(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), rs_0.class);
        }
        return object;
    }
}

