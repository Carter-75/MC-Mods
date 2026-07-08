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
import org.valkyrienskies.core.impl.shadow.qU;
import org.valkyrienskies.core.impl.shadow.qZ;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 * Renamed from org.valkyrienskies.core.impl.shadow.ra
 */
public final class ra_0
extends qP<qU> {
    public ra_0() {
        super("{", "}", "; ", BS.a(Locale.getDefault()));
    }

    public ra_0(NumberFormat numberFormat) {
        super("{", "}", "; ", numberFormat);
    }

    private ra_0(String string, String string2) {
        super(string, string2, "; ", BS.a(Locale.getDefault()));
    }

    private ra_0(String string, String string2, NumberFormat numberFormat) {
        super(string, string2, "; ", numberFormat);
    }

    public static ra_0 a() {
        return ra_0.a(Locale.getDefault());
    }

    private static ra_0 a(Locale locale) {
        return new ra_0(BS.a(locale));
    }

    @Override
    public final StringBuffer a(qO<qU> qZ2, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        qZ2 = qZ2;
        return this.a(stringBuffer, fieldPosition, qZ2.d);
    }

    private qZ b(String string) {
        ParsePosition parsePosition = new ParsePosition(0);
        qZ qZ2 = this.b(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), qZ.class);
        }
        return qZ2;
    }

    private qZ b(String object, ParsePosition parsePosition) {
        double[] dArray = this.a(1, (String)object, parsePosition);
        object = dArray;
        if (dArray == null) {
            return null;
        }
        return new qZ((double)object[0]);
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
        object = ((ra_0)object).b(string, parsePosition);
        if (parsePosition.getIndex() == 0) {
            throw new oZ(string, parsePosition.getErrorIndex(), qZ.class);
        }
        return object;
    }
}

