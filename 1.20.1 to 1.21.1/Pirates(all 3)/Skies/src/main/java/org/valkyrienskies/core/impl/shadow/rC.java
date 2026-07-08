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
import org.valkyrienskies.core.impl.shadow.rB;
import org.valkyrienskies.core.impl.shadow.rv_0;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class rC
extends qP<rv_0> {
    public rC() {
        super("{", "}", "; ", BS.a(Locale.getDefault()));
    }

    public rC(NumberFormat numberFormat) {
        super("{", "}", "; ", numberFormat);
    }

    private rC(String string, String string2, String string3) {
        super(string, string2, string3, BS.a(Locale.getDefault()));
    }

    private rC(String string, String string2, String string3, NumberFormat numberFormat) {
        super(string, string2, string3, numberFormat);
    }

    public static rC a() {
        return rC.a(Locale.getDefault());
    }

    private static rC a(Locale locale) {
        return new rC(BS.a(locale));
    }

    @Override
    public final StringBuffer a(qO<rv_0> rB2, StringBuffer serializable, FieldPosition fieldPosition) {
        rB2 = rB2;
        StringBuffer stringBuffer = serializable;
        double[] dArray = new double[2];
        serializable = rB2;
        dArray[0] = ((rB)serializable).c;
        serializable = rB2;
        dArray[1] = ((rB)serializable).d;
        return this.a(stringBuffer, fieldPosition, dArray);
    }

    private rB b(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        rB rB2 = this.b(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), rB.class);
        }
        return rB2;
    }

    private rB b(String object, ParsePosition parsePosition) {
        double[] dArray = this.a(2, (String)object, parsePosition);
        object = dArray;
        if (dArray == null) {
            return null;
        }
        return new rB((double)object[0], (double)object[1]);
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
        object = ((rC)object).b(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), rB.class);
        }
        return object;
    }
}

